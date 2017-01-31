package br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.bar.BarCerveja;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cervejaria.Cervejaria;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.localizacao.RegiaoPais;

@Entity
@Table(name = "TB_CERVEJA")
@RESTful(ConstantesBeerPointsDomain.CERVEJA)
@NamedQuery(name = "Cerveja.procurarPeloIdLazy", query = "select a from Cerveja a " + "left join fetch a.estilo "
		+ "left join fetch a.cervejaria " + "left join fetch a.pais " + "where a.id =:id")
@Audited
@AuditTable("TB_AUDITORIA_CERVEJA")
@SQLDelete(sql = "UPDATE TB_CERVEJA SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
public class Cerveja extends EntityBeerPointsCoreModelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;

	@Column(precision = 5, scale = 2)
	private BigDecimal teorAlcolico;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estilo_id", nullable = false)
	private Estilo estilo;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "familia_id", nullable = false)
	private Familia familia;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cervejaria_id", nullable = false)
	private Cervejaria cervejaria;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "amargor_id", nullable = false)
	private Amargor amargor;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pais_id", nullable = false)
	private Pais pais;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "regiao_pais_id", nullable = false)
	private RegiaoPais regiaoPais;

	@JsonIgnore
	@XmlTransient
	@OneToMany(mappedBy = "cerveja", fetch = FetchType.LAZY)	
	private List<BarCerveja> bares;

	@JsonIgnore
	@XmlTransient
	public List<BarCerveja> getBares() {
		return bares;
	}

	@JsonIgnore
	@XmlTransient
	public void setBares(List<BarCerveja> bares) {
		this.bares = bares;
	}

	public BigDecimal getTeorAlcolico() {
		return teorAlcolico;
	}

	public void setTeorAlcolico(BigDecimal teorAlcolico) {
		this.teorAlcolico = teorAlcolico;
	}


	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public RegiaoPais getRegiaoPais() {
		return regiaoPais;
	}

	public void setRegiaoPais(RegiaoPais regiaoPais) {
		this.regiaoPais = regiaoPais;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public Cervejaria getCervejaria() {
		return cervejaria;
	}

	public void setCervejaria(Cervejaria cervejaria) {
		this.cervejaria = cervejaria;
	}

	public Amargor getAmargor() {
		return amargor;
	}

	public void setAmargor(Amargor amargor) {
		this.amargor = amargor;
	}

}
