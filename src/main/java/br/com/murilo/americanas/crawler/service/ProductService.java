package br.com.murilo.americanas.crawler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.americanas.crawler.exception.ResourceNotFoundException;
import br.com.murilo.americanas.crawler.jsoup.MainCrawler;
import br.com.murilo.americanas.crawler.model.Product;
import br.com.murilo.americanas.crawler.repository.ProductRepository;

@Service
public class ProductService {

	private static final String message = "Produto não encontrado";
	private static final String url = "https://www.americanas.com.br/categoria/brinquedos/";
	
	@Autowired
	private ProductRepository repository;
	
	public void updateCategoryDatabase(String categoria) {
		MainCrawler crawler = new MainCrawler();
		crawler.getPageLinks(url.concat(categoria));
		crawler.getToyLink();
		crawler.buildToy();
		crawler.getProducts().forEach(p -> {
			if(!productExist(p.getCodigo()) && p.getValor() != null) {
				this.repository.insert(p);
			}
		});
	}
	
	public Product update(Product product, String id) {
		if(productExist(id)) {
			product.setId(id);
			this.repository.save(product);
		}
		throw new ResourceNotFoundException(message);
	}
	
	public Product findById(String id) {
		return this.repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(message));
	}
	
	public Product findByCodigo(Integer codigo) {
		return this.repository.findByCodigo(codigo)
				.orElseThrow(() -> new ResourceNotFoundException(message));
	}
	
	private boolean productExist(Integer codigo) {
		if(codigo == null) {
			return false;
		}
		return this.repository.findByCodigo(codigo).isPresent();
	}
	
	private boolean productExist(String id) {
		return this.repository.findById(id).isPresent();
	}
}
