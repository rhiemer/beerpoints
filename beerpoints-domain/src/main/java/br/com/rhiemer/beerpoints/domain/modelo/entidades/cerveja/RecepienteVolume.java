package br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreComIdIncrementalDeleteLogico;

@Entity
@Table(name = "TB_RECEPIENTE_VOLUME")
@RESTful(ConstantesBeerPointsDomain.RECEPIENTE_VOLUME)
@Audited
@AuditTable("TB_AUDITORIA_RECEPIENTE_VOLUME")
@SQLDelete(sql = "UPDATE TB_RECEPIENTE_VOLUME SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
public class RecepienteVolume extends EntityBeerPointsCoreComIdIncrementalDeleteLogico {

	private static final long serialVersionUID = 1612827864014461181L;
	/**
	 * 
	 */

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recepiente_id", nullable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_RECEP_VOL_RECEPIENTE"))
	private Recepiente recepiente;

	@NotNull
	@Column(precision = 10, scale = 5)
	@DecimalMax("9999999999")
	@DecimalMin("0.00001")
	private BigDecimal quantidade;

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public Recepiente getRecepiente() {
		return recepiente;
	}

	public void setRecepiente(Recepiente recepiente) {
		this.recepiente = recepiente;
	}

}
