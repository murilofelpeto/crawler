package br.com.murilo.crawler.types;

public class Teste {

	public static void main(String[] args) {
		
		Category.getBycategoryname().forEach((k, v) -> System.out.println(k + ": " + v));
		System.out.println();
		System.out.println(Category.getBycategoryname().get("controle-remoto").getAmericanasCategory());
	}

}
