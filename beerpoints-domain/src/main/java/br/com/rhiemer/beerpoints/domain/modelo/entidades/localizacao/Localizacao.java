package br.com.rhiemer.beerpoints.domain.modelo.entidades.localizacao;

import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.embeddable.CoordenadasRegiao;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo;

@Entity
@Table(name = "TB_LOCALIZACAO")
@RESTful(ConstantesBeerPointsDomain.LOCALIZACAO)
@Audited
@AuditTable("TB_AUDITORIA_LOCALIZACAO")
@SQLDelete(sql = "UPDATE TB_LOCALIZACAO SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
public class Localizacao extends EntityBeerPointsCoreModelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;

	@Embedded
	@Audited
	private CoordenadasRegiao coordenadasRegiao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_id", nullable = false)
	private TipoLocalizacao tipo;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "RE_LOCALIZACAO", joinColumns = @JoinColumn(name = "id_localizacao_pai", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_localizacao_filha", referencedColumnName = "id"))
	@JsonIgnore
	private Set<Localizacao> localizacaoFilhas;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "localizacaoFilhas")
	@JsonIgnore
	private Set<Localizacao> localizacaoPais;

	public Set<Localizacao> getLocalizacaoPais() {
		return localizacaoPais;
	}

	public Set<Localizacao> getLocalizacaoFilhas() {
		return localizacaoFilhas;
	}

	public void setLocalizacaoFilhas(Set<Localizacao> localizacaoFilhas) {
		this.localizacaoFilhas = localizacaoFilhas;
	}

	public void setLocalizacaoPais(Set<Localizacao> localizacaoPais) {
		this.localizacaoPais = localizacaoPais;
	}

	public CoordenadasRegiao getCoordenadasRegiao() {
		return coordenadasRegiao;
	}

	public void setCoordenadasRegiao(CoordenadasRegiao coordenadasRegiao) {
		this.coordenadasRegiao = coordenadasRegiao;
	}

	public TipoLocalizacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoLocalizacao tipo) {
		this.tipo = tipo;
	}

}
