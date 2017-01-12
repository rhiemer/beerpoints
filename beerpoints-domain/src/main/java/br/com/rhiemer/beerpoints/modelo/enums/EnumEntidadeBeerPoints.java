package br.com.rhiemer.beerpoints.modelo.enums;

import java.util.HashMap;
import java.util.Map;

import br.com.rhiemer.beerpoints.modelo.Bar;
import br.com.rhiemer.beerpoints.modelo.BarCerveja;
import br.com.rhiemer.beerpoints.modelo.Cerveja;
import br.com.rhiemer.beerpoints.modelo.IEntityBeerPoints;
import br.com.rhiemer.beerpoints.modelo.Estilo;
import br.com.rhiemer.beerpoints.modelo.Fabricante;
import br.com.rhiemer.beerpoints.modelo.Pais;
import br.com.rhiemer.beerpoints.modelo.constantes.ConstantesBeerPointsDomain;

/**
 * Entidades do beerpoints
 * 
 * @author rodrigo.hiemer
 *
 */
public enum EnumEntidadeBeerPoints {

	CERVEJA(ConstantesBeerPointsDomain.CERVEJA, Cerveja.class), BAR(
			ConstantesBeerPointsDomain.BAR, Bar.class), BAR_CERVEJA(
			ConstantesBeerPointsDomain.BAR_CERVEJA, BarCerveja.class), ESTILO(
			ConstantesBeerPointsDomain.ESTILO, Estilo.class), FABRICANTE(
			ConstantesBeerPointsDomain.FABRICANTE, Fabricante.class), PAIS(
			ConstantesBeerPointsDomain.PAIS, Pais.class);

	private static final Map<String, EnumEntidadeBeerPoints> LOOKUP_NOME = new HashMap<>();
	private static final Map<Class<?>, EnumEntidadeBeerPoints> LOOKUP_CLASSE = new HashMap<>();

	static {
		for (EnumEntidadeBeerPoints item : EnumEntidadeBeerPoints.values()) {
			LOOKUP_NOME.put(item.nome, item);
		}

		for (EnumEntidadeBeerPoints item : EnumEntidadeBeerPoints.values()) {
			LOOKUP_CLASSE.put(item.classe, item);
		}
	}

	private String nome;
	private Class<?> classe;

	private EnumEntidadeBeerPoints(String nome,
			Class<? extends IEntityBeerPoints> classe) {
		this.nome = nome;
		this.classe = classe;
	}

	public String getNome() {
		return nome;
	}

	public Class<?> getClasse() {
		return classe;
	}

	public static EnumEntidadeBeerPoints getByNome(String nome) {
		return LOOKUP_NOME.get(nome);
	}

	public static EnumEntidadeBeerPoints getByClasse(Class<?> classe) {
		return LOOKUP_CLASSE.get(classe);
	}

}
