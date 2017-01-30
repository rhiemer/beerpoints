package br.com.rhiemer.beerpoints.modelo.entidades;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.modelo.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.modelo.entidades.embeddable.EnderecoLocalizacao;
import br.com.rhiemer.beerpoints.modelo.entidades.entity.EntityBeerPointsCoreModelo;
import br.com.rhiemer.beerpoints.modelo.entidades.interfaces.IEntityBeerPointsComEnderecoLocalizacao;

@Entity
@Table(name="TB_BAR")
@RESTful(ConstantesBeerPointsDomain.BAR)
@Audited
@AuditTable("TB_AUDITORIA_BAR")
@SQLDelete(sql = "UPDATE TB_BAR SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
public class Bar extends EntityBeerPointsCoreModelo implements IEntityBeerPointsComEnderecoLocalizacao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;
	
	@Embedded
	@Audited
	private EnderecoLocalizacao enderecoLocalizacao;
	

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
	

	public EnderecoLocalizacao getEnderecoLocalizacao() {
		return enderecoLocalizacao;
	}

	public void setEnderecoLocalizacao(EnderecoLocalizacao enderecoLocalizacao) {
		this.enderecoLocalizacao = enderecoLocalizacao;
	}


	

}
