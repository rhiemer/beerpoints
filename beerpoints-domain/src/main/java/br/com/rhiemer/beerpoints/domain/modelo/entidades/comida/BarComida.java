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
import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.bar.Bar;

@Entity

@Table(name = "TB_BAR_COMIDA", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "comida_id", "bar_id" }, name = "UK_BAR_COMIDA"),
		@UniqueConstraint(columnNames = { "controle_id" }, name = "UK_BAR_COMIDA_CONTROLE_ID") })
@RESTful(ConstantesBeerPointsDomain.BAR_COMIDA)
@Audited
@AuditTable("TB_AUDITORIA_BAR_COMIDA")
@SQLDelete(sql = "UPDATE TB_BAR_COMIDA SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
@UniqueKey(nome = "bar_comida", columnNames = { "bar", "comida" }, validar = true)
@AssociationOverride(name = "controle_id", foreignKey = @ForeignKey(name = "FK_BAR_COMIDA_CONTROLE_ENTIDADE"))
public class BarComida extends EntityBeerPointsCoreModelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7013818192972350150L;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bar_id", nullable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_BAR_COMIDA_BAR"))
	private Bar bar;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comida_id", nullable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_BAR_COMIDA_COMIDA"))
	private Comida comida;

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	public Comida getComida() {
		return comida;
	}

	public void setComida(Comida comida) {
		this.comida = comida;
	}

}
