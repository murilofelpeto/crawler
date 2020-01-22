package br.com.murilo.crawler.service;

import java.util.HashSet;
import java.util.Set;

import br.com.murilo.crawler.jsoup.Crawler;
import br.com.murilo.crawler.jsoup.americanas.Americanas;
import br.com.murilo.crawler.model.Product;

public class CrawlerService {

	private static final String americanas = "https://www.americanas.com.br/categoria/brinquedos/";
	private static Set<Product> produtos = new HashSet<>();
	
	public static Set<Product> getProdutos(String categoria){
		parseAmericanas(categoria);
		return produtos;
	}
	
	private static void parseAmericanas(String categoria) {
		Crawler americanasCrawler = new Americanas();
		americanasCrawler.getPageLinks(americanas.concat(categoria));
		americanasCrawler.getToyLink();
		americanasCrawler.buildToy();
		produtos.addAll(americanasCrawler.getProducts());
	}
}
