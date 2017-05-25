package br.com.rhiemer.beerpoints.domain.modelo.entidades.cervejaria;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Embedded;
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
import br.com.rhiemer.beerpoints.domain.embeddable.EnderecoLocalizacao;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo;
import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPointsComEnderecoLocalizacao;

@Entity
@Table(name = "TB_CERVEJARIA_LOCALIZACAO", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "controle_id" }, name = "UK_CERVEJARIA_LOCALIZACAO_CONTROLE_ID") })
@RESTful(ConstantesBeerPointsDomain.CERVEJARIA_LOCALIZACAO)
@Audited
@AuditTable("TB_AUDITORIA_CERVEJARIA_LOCALIZACAO")
@SQLDelete(sql = "UPDATE TB_CERVEJARIA_LOCALIZACAO SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
@AssociationOverrides({
	@AssociationOverride(name = "controle_id", foreignKey = @ForeignKey(name = "FK_CERVEJARIA_LOCALIZACAO_CONTROLE_ENTIDADE")),
	@AssociationOverride(name = "localizacao_id", foreignKey = @ForeignKey(name = "FK_CERVEJARIA_LOCALIZACAO_LOCALIZACAO")),
	@AssociationOverride(name = "municipio_id", foreignKey = @ForeignKey(name = "FK_CERVEJARIA_LOCALIZACAO_MUNICIPIO")) })
public class CervejariaLocalizacao extends EntityBeerPointsCoreModelo
		implements IEntityBeerPointsComEnderecoLocalizacao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cervejaria_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CERVEJARIA_LOCALIZACAO_CERVEJARIA"))
	private Cervejaria cervejaria;

	@Embedded
	@Audited
	private EnderecoLocalizacao enderecoLocalizacao;

	public Cervejaria getCervejaria() {
		return cervejaria;
	}

	public void setCervejaria(Cervejaria cervejaria) {
		this.cervejaria = cervejaria;
	}

	public EnderecoLocalizacao getEnderecoLocalizacao() {
		return enderecoLocalizacao;
	}

	public void setEnderecoLocalizacao(EnderecoLocalizacao enderecoLocalizacao) {
		this.enderecoLocalizacao = enderecoLocalizacao;
	}

}
