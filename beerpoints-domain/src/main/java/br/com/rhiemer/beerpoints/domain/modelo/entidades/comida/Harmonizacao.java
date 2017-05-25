package br.com.rhiemer.beerpoints.domain.modelo.entidades.comida;

import javax.persistence.AssociationOverride;
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

import br.com.rhiemer.api.jpa.annotations.UniqueKey;
import br.com.rhiemer.api.util.annotations.rest.RESTful;
import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Cerveja;

@Entity
@Table(name = "TB_HARMONIZACAO", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "bar_comida_id", "cerveja_id" }, name = "UK_HARMONIZACAO"),
		@UniqueConstraint(columnNames = { "controle_id" }, name = "UK_HARMONIZACAO_CONTROLE_ID") })
@RESTful(ConstantesBeerPointsDomain.HARMONIZACAO)
@Audited
@AuditTable("TB_AUDITORIA_HARMONIZACAO")
@SQLDelete(sql = "UPDATE TB_HARMONIZACAO SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
@UniqueKey(nome = "barComida_cerveja", columnNames = { "barComida", "cerveja" }, validar = true)
@AssociationOverride(name = "controle_id", foreignKey = @ForeignKey(name = "FK_HARMONIZACAO_CONTROLE_ENTIDADE"))
public class Harmonizacao extends EntityBeerPointsCoreModelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7013818192972350150L;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bar_comida_id", nullable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_HARMONIZACAO_BAR_COMIDA"))
	private BarComida barComida;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cerveja_id", nullable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_HARMONIZACAO_CERVEJA"))
	private Cerveja cerveja;

	public BarComida getBarComida() {
		return barComida;
	}

	public void setBarComida(BarComida barComida) {
		this.barComida = barComida;
	}

	public Cerveja getCerveja() {
		return cerveja;
	}

	public void setCerveja(Cerveja cerveja) {
		this.cerveja = cerveja;
	}

}
