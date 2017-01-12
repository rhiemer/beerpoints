package br.com.rhiemer.beerpoints.modelo;

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
import br.com.rhiemer.beerpoints.modelo.constantes.ConstantesBeerPointsDomain;

@Entity
@Table(name = "TB_CERVEJA")
@RESTful(ConstantesBeerPointsDomain.CERVEJA)
@NamedQuery(name = "Cerveja.procurarPeloIdLazy", query = "select a from Cerveja a " + "left join fetch a.estilo "
		+ "left join fetch a.fabricante " + "left join fetch a.pais " + "where a.id =:id")
@Audited
@AuditTable("TB_AUDITORIA_CERVEJA")
@SQLDelete(sql = "UPDATE TB_CERVEJA SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
public class Cerveja extends GenericEntityBeerPoints {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;

	@Column(precision = 5, scale = 2)
	private BigDecimal teorAlcolico;

	@Column(precision = 10, scale = 5,insertable=false)
	private BigDecimal precoMedio;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estilo_id", nullable = false)
	private Estilo estilo;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fabricante_id", nullable = false)
	private Fabricante fabricante;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pais_id", nullable = false)
	private Pais pais;

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

	public BigDecimal getPrecoMedio() {
		return precoMedio;
	}

	public void setPrecoMedio(BigDecimal precoMedio) {
		this.precoMedio = precoMedio;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
