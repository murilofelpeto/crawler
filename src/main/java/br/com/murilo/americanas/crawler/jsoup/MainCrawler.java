package br.com.murilo.americanas.crawler.jsoup;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.murilo.americanas.crawler.model.Product;
import br.com.murilo.americanas.crawler.model.builder.ProductBuilder;

public class MainCrawler {

	private Set<String> pageLinks;
	private Set<String> productLinks;
	private Set<Product> products;

	public MainCrawler() {
		this.pageLinks = new HashSet<>();
		this.products = new HashSet<>();
		this.productLinks = new HashSet<>();
	}

	public Set<Product> getProducts(){
		return this.products;
	}
	
	public void getPageLinks(String url) {
		if (!pageLinks.contains(url)) {
			try {
				Document mainPage = Jsoup.connect(url).get();
				Elements pages = mainPage.select("a[href*=\"/pagina-\"]");
				
				for (Element page : pages) {
					this.pageLinks.add(url);
					if(this.pageLinks.size() <= 50) {
						getPageLinks(page.attr("abs:href"));
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void getToyLink() {
		this.pageLinks.forEach(p -> {
			try {
				Document page = Jsoup.connect(p).get();
				Elements products = page.select("a[href^=\"/produto/\"]");

				for (Element product : products) {
					this.productLinks.add(product.attr("abs:href"));
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	public void buildToy() {
		this.productLinks.forEach(prod -> {
			try {
				Document product = Jsoup.connect(prod).get();
				Element nome = product.selectFirst("h1#product-name-default");
				Element preco = product.selectFirst("span[class*=\"price\"]");
				Element descricao = product.selectFirst("div[class^=\"info-description\"]");
				Element codigo = product.selectFirst("span[class^=\"product-header\"]");
				Element categoria = product.selectFirst("h1[class=\"category-title\"]");
				Element imagem = product.selectFirst("div[class=\"image-gallery-image\"]").child(0);

				this.products.add(new ProductBuilder()
						.qualCodigo(codigo)
						.qualDescricao(descricao)
						.qualLink(prod)
						.qualNome(nome)
						.qualPreco(preco)
						.qualCategoria(categoria)
						.qualImagem(imagem)
						.build());

			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	public void printProduct() {
		this.products.forEach(System.out::println);
	}
	
	public void printLinks() {
		this.pageLinks.forEach(System.out::println);
	}
}
