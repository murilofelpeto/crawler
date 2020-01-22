package br.com.murilo.crawler.jsoup;

import java.util.Set;

import br.com.murilo.crawler.model.Product;

public interface Crawler {

	public Set<Product> getProducts();
	public void getPageLinks(String url);
	public void getToyLink();
	public void buildToy();
}
