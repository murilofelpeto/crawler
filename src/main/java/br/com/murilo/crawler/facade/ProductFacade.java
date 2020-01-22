package br.com.murilo.crawler.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.murilo.crawler.dto.request.ProductRequest;
import br.com.murilo.crawler.dto.response.ProductResponse;
import br.com.murilo.crawler.model.Product;
import br.com.murilo.crawler.service.ProductService;

@Component
public class ProductFacade {
	
	@Autowired
	private ProductService productService;
	
	public void updateByCategory(String categoria) {
		this.productService.updateCategoryDatabase(categoria);
	}
	
	public ProductResponse findByCodigo(Integer codigo) {
		return new ProductResponse(this.productService.findByCodigo(codigo));
	}
	
	public ProductResponse findById(String id) {
		return new ProductResponse(this.productService.findById(id));
	}
	
	public ProductResponse update(ProductRequest product, String id) {
		return new ProductResponse(this.productService.update(new Product(product), id));
	}
}
