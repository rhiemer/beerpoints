package br.com.rhiemer.beerpoints.modelo.enums;

import java.util.HashMap;
import java.util.Map;

import br.com.rhiemer.beerpoints.modelo.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.modelo.entidades.Amargor;
import br.com.rhiemer.beerpoints.modelo.entidades.Bar;
import br.com.rhiemer.beerpoints.modelo.entidades.BarCerveja;
import br.com.rhiemer.beerpoints.modelo.entidades.BarCervejaRecepienteVolume;
import br.com.rhiemer.beerpoints.modelo.entidades.BarComida;
import br.com.rhiemer.beerpoints.modelo.entidades.Cerveja;
import br.com.rhiemer.beerpoints.modelo.entidades.Cervejaria;
import br.com.rhiemer.beerpoints.modelo.entidades.CervejariaLocalizacao;
import br.com.rhiemer.beerpoints.modelo.entidades.Comida;
import br.com.rhiemer.beerpoints.modelo.entidades.Entidade;
import br.com.rhiemer.beerpoints.modelo.entidades.Estilo;
import br.com.rhiemer.beerpoints.modelo.entidades.Familia;
import br.com.rhiemer.beerpoints.modelo.entidades.Harmonizacao;
import br.com.rhiemer.beerpoints.modelo.entidades.Localizacao;
import br.com.rhiemer.beerpoints.modelo.entidades.Municipio;
import br.com.rhiemer.beerpoints.modelo.entidades.Pais;
import br.com.rhiemer.beerpoints.modelo.entidades.PaisLocalizacao;
import br.com.rhiemer.beerpoints.modelo.entidades.Recepiente;
import br.com.rhiemer.beerpoints.modelo.entidades.RecepienteVolume;
import br.com.rhiemer.beerpoints.modelo.entidades.Tag;
import br.com.rhiemer.beerpoints.modelo.entidades.TipoLocalizacao;
import br.com.rhiemer.beerpoints.modelo.entidades.UF;
import br.com.rhiemer.beerpoints.modelo.entidades.interfaces.IEntityBeerPoints;

/**
 * Entidades do beerpoints
 * 
 * @author rodrigo.hiemer
 *
 */
public enum EnumEntidadeBeerPoints {

	CERVEJA(ConstantesBeerPointsDomain.CERVEJA, Cerveja.class), BAR(ConstantesBeerPointsDomain.BAR,
			Bar.class), BAR_CERVEJA(ConstantesBeerPointsDomain.BAR_CERVEJA, BarCerveja.class), ESTILO(
					ConstantesBeerPointsDomain.ESTILO,
					Estilo.class), CERVEJARIA(ConstantesBeerPointsDomain.CERVEJARIA, Cervejaria.class), PAIS(
							ConstantesBeerPointsDomain.PAIS,
							Pais.class), AMARGOR(ConstantesBeerPointsDomain.AMARGOR, Amargor.class), ENTIDADE(
									ConstantesBeerPointsDomain.ENTIDADE, Entidade.class), BAR_CERVEJA_RECEPIENTE_VOLUME(
											ConstantesBeerPointsDomain.BAR_CERVEJA_RECEPIENTE_VOLUME,
											BarCervejaRecepienteVolume.class), FAMILIA(
													ConstantesBeerPointsDomain.FAMILIA,
													Familia.class), RECEPIENTE(ConstantesBeerPointsDomain.RECEPIENTE,
															Recepiente.class), RECEPIENTE_VOLUME(
																	ConstantesBeerPointsDomain.RECEPIENTE_VOLUME,
																	RecepienteVolume.class), TAG(
																			ConstantesBeerPointsDomain.TAG,
																			Tag.class), COMIDA(
																					ConstantesBeerPointsDomain.COMIDA,
																					Comida.class), HARMONIZACAO(
																							ConstantesBeerPointsDomain.HARMONIZACAO,
																							Harmonizacao.class), BAR_COMIDA(
																									ConstantesBeerPointsDomain.BAR_COMIDA,
																									BarComida.class), LOCALIZACAO(
																											ConstantesBeerPointsDomain.LOCALIZACAO,
																											Localizacao.class), PAIS_LOCALIZACAO(
																													ConstantesBeerPointsDomain.PAIS_LOCALIZACAO,
																													PaisLocalizacao.class), UF(
																															ConstantesBeerPointsDomain.UF,
																															UF.class), MUNICIPIO(
																																	ConstantesBeerPointsDomain.MUNICIPIO,
																																	Municipio.class), TIPO_LOCALIZACAO(
																																			ConstantesBeerPointsDomain.TIPO_LOCALIZACAO,
																																			TipoLocalizacao.class), CERVEJARIA_LOCALIZACAO(
																																					ConstantesBeerPointsDomain.CERVEJARIA_LOCALIZACAO,
																																					CervejariaLocalizacao.class);

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

	private EnumEntidadeBeerPoints(String nome, Class<? extends IEntityBeerPoints> classe) {
		this.nome = nome;
		this.classe = classe;
	}

	public String getNome() {
		return nome;
	}

	public Class<?> getClasse() {
		return classe;
	}

	public Entidade criarEntidade() {
		Entidade entidade = new Entidade();
		entidade.setId(this.nome);
		return entidade;
	}

	public static EnumEntidadeBeerPoints getByNome(String nome) {
		return LOOKUP_NOME.get(nome);
	}

	public static EnumEntidadeBeerPoints getByClasse(Class<?> classe) {
		return LOOKUP_CLASSE.get(classe);
	}

	public static Entidade criarEntidade(Class<?> classe) {
		return getByClasse(classe).criarEntidade();
	}

}
