package br.com.rhiemer.beerpoints.domain.modelo.entidades.localizacao;

import javax.persistence.AssociationOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import br.com.rhiemer.api.util.annotations.rest.RESTful;
import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo;
import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPointsCadastroLocalizacao;
import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPointsIBGE;

@Entity
@Table(name = "TA_MUNICIPIO", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "controle_id" }, name = "UK_MUNICIPIO_CONTROLE_ID") })
@RESTful(ConstantesBeerPointsDomain.MUNICIPIO)
@Audited
@AuditTable("TB_AUDITORIA_MUNICIPIO")
@SQLDelete(sql = "UPDATE TA_MUNICIPIO SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
@AssociationOverride(name = "controle_id", foreignKey = @ForeignKey(name = "FK_MUNICIPIO_CONTROLE_ENTIDADE"))
public class Municipio extends EntityBeerPointsCoreModelo
		implements IEntityBeerPointsIBGE, IEntityBeerPointsCadastroLocalizacao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;

	@NotNull
	@Column(nullable = false)
	private Integer codigoIBGE;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "localizacao_id", nullable = false, foreignKey = @ForeignKey(name = "FK_MUNICIPIO_LOCALIZACAO"))
	private Localizacao localizacao;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uf_id", nullable = false, foreignKey = @ForeignKey(name = "FK_MUNICIPIO_UF"))
	private UF uf;

	public Integer getCodigoIBGE() {
		return codigoIBGE;
	}

	public void setCodigoIBGE(Integer codigoIBGE) {
		this.codigoIBGE = codigoIBGE;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

}
