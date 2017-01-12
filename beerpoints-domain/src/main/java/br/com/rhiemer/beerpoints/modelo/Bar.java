package br.com.rhiemer.beerpoints.modelo;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.modelo.constantes.ConstantesBeerPointsDomain;

@Entity
@Table(name="TB_BAR")
@RESTful(ConstantesBeerPointsDomain.BAR)
@Audited
@AuditTable("TB_AUDITORIA_BAR")
@SQLDelete(sql = "UPDATE TB_BAR SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
public class Bar extends GenericEntityBeerPoints {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;
	
	@Embedded
	private Localizacao localizacao;
	
	@OneToMany(mappedBy = "bar",fetch = FetchType.LAZY)
	@JsonIgnore
	@XmlTransient
	private List<BarCerveja> cervejas;

	@JsonIgnore
	@XmlTransient
	public List<BarCerveja> getCervejas() {
		return cervejas;
	}

	@JsonIgnore
	@XmlTransient
	public void setCervejas(List<BarCerveja> cervejas) {
		this.cervejas = cervejas;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

}
