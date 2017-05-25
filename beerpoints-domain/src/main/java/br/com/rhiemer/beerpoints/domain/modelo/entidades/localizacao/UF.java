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
@Table(name = "TA_UF", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "controle_id" }, name = "UK_UF_CONTROLE_ID") })
@RESTful(ConstantesBeerPointsDomain.UF)
@Audited
@AuditTable("TB_AUDITORIA_UF")
@SQLDelete(sql = "UPDATE TA_UF SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
@AssociationOverride(name = "controle_id", foreignKey = @ForeignKey(name = "FK_UF_CONTROLE_ENTIDADE"))
public class UF extends EntityBeerPointsCoreModelo
		implements IEntityBeerPointsIBGE, IEntityBeerPointsCadastroLocalizacao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;

	@NotNull
	@Column(nullable = false)
	private Integer codigoIBGE;

	@NotNull
	@Column(nullable = false)
	private String sigla;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "localizacao_id", nullable = false, foreignKey = @ForeignKey(name = "FK_UF_LOCALIZACAO"))
	private Localizacao localizacao;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pais_localizacao_id", nullable = false, foreignKey = @ForeignKey(name = "FK_UF_PAIS_LOCALIZACAO"))
	private PaisLocalizacao pais;

	public Integer getCodigoIBGE() {
		return codigoIBGE;
	}

	public void setCodigoIBGE(Integer codigoIBGE) {
		this.codigoIBGE = codigoIBGE;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public PaisLocalizacao getPais() {
		return pais;
	}

	public void setPais(PaisLocalizacao pais) {
		this.pais = pais;
	}

}
