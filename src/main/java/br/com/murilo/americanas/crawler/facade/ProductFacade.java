package br.com.murilo.americanas.crawler.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.murilo.americanas.crawler.jsoup.MainCrawler;
import br.com.murilo.americanas.crawler.service.ProductService;

@Component
public class ProductFacade {

	@Autowired
	private ProductService productService;
	
	public void updateByCategory(String category) {
		String url = "https://www.americanas.com.br/categoria/brinquedos/" + category;
		MainCrawler crawler = new MainCrawler();
		crawler.getPageLinks(url);
		crawler.getToyLink();
		crawler.buildToy();
		crawler.getProducts().forEach(p -> {
			if(!productExist(p.getCodigo()) && p.getValor() != null) {
				productService.save(p);
			}
		});
	}

	private boolean productExist(Integer codigo) {
		if(codigo == null) {
			return false;
		}
		return this.productService.findByCodigo(codigo).isPresent();
	}
	
	
}
