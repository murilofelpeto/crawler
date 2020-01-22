package br.com.murilo.crawler.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.murilo.crawler.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

	Optional<Product> findByCodigo(Integer codigo);
}
