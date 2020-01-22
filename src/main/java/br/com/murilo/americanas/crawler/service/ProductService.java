package br.com.murilo.americanas.crawler.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.americanas.crawler.exception.ResourceNotFoundException;
import br.com.murilo.americanas.crawler.model.Product;
import br.com.murilo.americanas.crawler.repository.ProductRepository;

@Service
public class ProductService {

	private static final String message = "Produto não encontrado";
	
	@Autowired
	private ProductRepository repository;
	
	public Product save(Product product) {
		return this.repository.insert(product);
	}
	
	public Product update(Product product) {
		return this.repository.save(product);
	}
	
	public Product findById(String id) {
		return this.repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(message));
	}
	
	public Optional<Product> findByCodigo(Integer codigo) {
		return this.repository.findByCodigo(codigo);
	}
}
