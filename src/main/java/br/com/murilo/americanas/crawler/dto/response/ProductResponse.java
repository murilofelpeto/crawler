package br.com.murilo.americanas.crawler.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.murilo.americanas.crawler.model.Product;
import lombok.Getter;

@Getter
public class ProductResponse implements Serializable {

	private static final long serialVersionUID = 7425812975344209008L;
	
	private String id;
	private Integer codigo;
	private String nome;
	private String descricao;
	private BigDecimal valor;
	private String link;
	private String categoria;
	private String imagem;
	
	public ProductResponse(Product product) {
		this.id = product.getId();
		this.codigo = product.getCodigo();
		this.nome = product.getNome();
		this.descricao = product.getDescricao();
		this.valor = product.getValor();
		this.link = product.getLink();
		this.categoria = product.getCategoria();
		this.imagem = product.getImagem();
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
		ProductResponse other = (ProductResponse) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}	
}
