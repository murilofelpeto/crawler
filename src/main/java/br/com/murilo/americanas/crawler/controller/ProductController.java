package br.com.murilo.americanas.crawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.murilo.americanas.crawler.dto.request.ProductRequest;
import br.com.murilo.americanas.crawler.dto.response.ProductResponse;
import br.com.murilo.americanas.crawler.facade.ProductFacade;

@RestController("/api/v1/product")
public class ProductController {

	@Autowired
	private ProductFacade productFacade;
	
	@GetMapping("/{id}")
	public ProductResponse findByID(@PathVariable(name = "id") String id) {
		return this.productFacade.findById(id);
	}
	
	@GetMapping("/codigo/{codigo}")
	public ProductResponse findByCodigo(@PathVariable(name = "codigo") Integer codigo) {
		return this.productFacade.findByCodigo(codigo);
	}
	
	@PutMapping
	public void updateProductDatabase(@RequestParam(name = "categoria", required = true) String categoria) {
		this.productFacade.updateByCategory(categoria);
	}
	
	@PutMapping("/{id}")
	public ProductResponse updateProduct(@PathVariable(name = "id") String id, @RequestBody ProductRequest product) {
		return this.productFacade.update(product, id);
	}
}
