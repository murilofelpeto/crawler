package br.com.murilo.crawler.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.murilo.crawler.dto.request.ProductRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Document
public class Product implements Serializable {

	private static final long serialVersionUID = 9126621660694799390L;
	
	@Id
	private String id;
	private Integer codigo;
	private String nome;
	private String descricao;
	private BigDecimal valor;
	private String link;
	private String categoria;
	private String imagem;
	
	public Product(ProductRequest request) {
		this.id = request.getId();
		this.codigo = request.getCodigo();
		this.nome = request.getNome();
		this.descricao = request.getDescricao();
		this.valor = request.getValor();
		this.link = request.getLink();
		this.categoria = request.getCategoria();
		this.imagem = request.getImagem();
	}

	public Product(Integer codigo, String nome, String descricao, BigDecimal valor, String link, String categoria, String imagem) {
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.link = link;
		this.categoria = categoria;
		this.imagem = imagem;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}	
}
