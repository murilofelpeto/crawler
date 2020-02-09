package br.com.murilo.crawler.types;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum Category {

	AUTORAMAS("autoramas", "autoramas-e-pistas"),
	BARBIE("barbie", "barbie"),
	BICICLETA("bicicleta", "bicicleta-infantil"),
	BONECAS("bonecas", "bonecas"),
	BONECOS("bonecos", "bonecos"),
	BLOCOS_MONTAR("blocos-de-montar", "blocos-de-montar"),
	CASINHA("casinha", "brincando-de-casinha"),
	BRINQUEDOS_ELETRONICOS("briquedos-eletronicos", "brinquedos-eletronicos"),
	CONTROLE_REMOTO("controle-remoto", "brinquedos-de-controle-remoto"),
	ESPORTIVOS("brinquedos-esportivos", "brinquedos-esportivos"),
	FANTASIA("fantasias", "fantasias"),
	GUARDA_BRINQUEDOS("guarda-brinquedos", "guarda-brinquedos"),
	HOT_WHEELS("hot-wheels", "hot-wheels"),
	HOVERBOARD("hoverboard", "hoverboard"),
	INSTRUMENTOS_MUSICAIS("instrumentos-musicais", "instrumentos-musicais"),
	JOGOS("jogos", "jogos"),
	LANCADOR("lancadores", "lancador"),
	LEGO("lego", "lego"),
	MAQUIAGEM_BELEZA("maquiagem", "maquiagem-e-beleza"),
	MASSINHA("massinha", "massinha"),
	MINI_VEICULOS("mini-veiculos", "mini-veiculos"),
	MODELISMO("modelismo", "modelismo"),
	MOVEIS("moveis-para-crianca", "moveis-para-criancas"),
	PATINETE("patinete", "patinete-infantil"),
	PATINS("patins", "patins-infanti"),
	PELUCIAS("pelucias", "pelucias"),
	PLAYGROUND("playground", "playground"),
	PLAYMOBIL("playmobil", "playmobil"),
	PRAIA_PISCINA("praia-e-piscina", "praia-e-piscina"),
	QUEBRA_CABECA("quebra-cabeca", "quebra-cabeca"),
	SLIME("slime", "slime"),
	SKATE("skate", "skate-infantil"),
	VEICULOS("veiculos", "veiculos-de-brinquedo");
	
	private String categoryName;
	private String americanasCategory;
	
	private static final Map<String, Category> byCategoryName = new HashMap<>();

	static {
		for (Category p : values()) {
			byCategoryName.put(p.categoryName, p);
		}
	}
	
	Category(String categoryName, String americanasCategory){
		this.categoryName = categoryName;
		this.americanasCategory = americanasCategory;
	}

	public static Map<String, Category> getBycategoryname() {
		return byCategoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setAmericanasCategory(String americanasCategory) {
		this.americanasCategory = americanasCategory;
	}
}
