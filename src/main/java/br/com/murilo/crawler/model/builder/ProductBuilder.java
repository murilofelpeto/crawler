package br.com.murilo.crawler.model.builder;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;

import br.com.murilo.crawler.model.Product;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductBuilder {

	private Integer codigo;
	private String nome;
	private String descricao;
	private BigDecimal valor;
	private String link;
	private String categoria;
	private String imagem;

	public ProductBuilder qualCodigo(Element codigo) {
		if (codigo != null) {
			String strCode = codigo.text();
			strCode = strCode.replaceAll("\\D+", "");
			this.codigo = Integer.parseInt(strCode);
		}
		return this;
	}

	public ProductBuilder qualNome(Element nome) {
		this.nome = nome.text();
		return this;
	}

	public ProductBuilder qualDescricao(Element descricao) {
		this.descricao = descricao.text();
		return this;
	}

	public ProductBuilder qualPreco(Element preco) {
		if(preco != null) {
			String strPreco = preco.text();
			strPreco = strPreco.replace(".", "");
			strPreco = strPreco.replace(",", ".");
			strPreco = strPreco.replaceAll("[^0-9?!\\.]", "");
			
			if(StringUtils.isNotBlank(strPreco)) {
				this.valor = new BigDecimal(strPreco);							
			}
		}
		return this;
	}

	public ProductBuilder qualLink(String link) {
		this.link = link;
		return this;
	}
	
	public ProductBuilder qualCategoria(Element categoria) {
		if(categoria != null) {
			this.categoria = categoria.text();
		}
		return this;
	}

	public Product build() {
		return new Product(codigo, nome, descricao, valor, link, categoria, imagem);
	}

	public ProductBuilder qualImagem(Element imagem) {
		this.imagem = imagem.attr("src");
		return this;
	}

}
