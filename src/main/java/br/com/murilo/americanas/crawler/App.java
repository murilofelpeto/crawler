package br.com.murilo.americanas.crawler;

import br.com.murilo.americanas.crawler.jsoup.MainCrawler;

public class App {
	public static void main(String[] args) {
		MainCrawler crawler = new MainCrawler();
		crawler.getPageLinks("https://www.americanas.com.br/categoria/brinquedos/bonecas");
		crawler.getToyLink();
		crawler.buildToy();
		crawler.printProduct();
	}
}
