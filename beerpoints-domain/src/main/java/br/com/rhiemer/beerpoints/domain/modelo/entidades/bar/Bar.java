package br.com.rhiemer.beerpoints.domain.modelo.entidades.bar;

import java.util.List;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.embeddable.EnderecoLocalizacao;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo;
import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPointsComEnderecoLocalizacao;

@Entity
@Table(name = "TB_BAR", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "controle_id" }, name = "UK_BAR_CONTROLE_ID") })
@RESTful(ConstantesBeerPointsDomain.BAR)
@Audited
@AuditTable("TB_AUDITORIA_BAR")
@SQLDelete(sql = "UPDATE TB_BAR SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")

@AssociationOverrides({
		@AssociationOverride(name = "controle_id", foreignKey = @ForeignKey(name = "FK_BAR_CONTROLE_ENTIDADE")),
		@AssociationOverride(name = "localizacao_id", foreignKey = @ForeignKey(name = "FK_BAR_LOCALIZACAO")),
		@AssociationOverride(name = "municipio_id", foreignKey = @ForeignKey(name = "FK_BAR_MUNICIPIO")) })
public class Bar extends EntityBeerPointsCoreModelo implements IEntityBeerPointsComEnderecoLocalizacao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;

	@Embedded
	@Audited
	private EnderecoLocalizacao enderecoLocalizacao;

	@OneToMany(mappedBy = "bar", fetch = FetchType.LAZY)
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
