package br.com.rhiemer.beerpoints.domain.enums;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPoints;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.auxiliares.Entidade;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.auxiliares.Tag;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.bar.Bar;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.bar.BarCerveja;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.bar.BarCervejaRecepienteVolume;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Amargor;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Cerveja;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Estilo;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Familia;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Pais;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Recepiente;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.RecepienteVolume;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cervejaria.Cervejaria;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cervejaria.CervejariaLocalizacao;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.comida.BarComida;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.comida.Comida;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.comida.Harmonizacao;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.localizacao.Localizacao;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.localizacao.Municipio;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.localizacao.PaisLocalizacao;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.localizacao.TipoLocalizacao;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.localizacao.UF;

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

	@JsonValue
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

	@JsonCreator
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
