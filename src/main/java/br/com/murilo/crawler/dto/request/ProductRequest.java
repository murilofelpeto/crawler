package br.com.murilo.crawler.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.murilo.crawler.types.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest implements Serializable {

	private static final long serialVersionUID = -3115372111443730582L;

	private String id;
	private Integer codigo;
	private String nome;
	private String descricao;
	private BigDecimal valor;
	private String link;
	private Category categoria;
	private String imagem;

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
		ProductRequest other = (ProductRequest) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
