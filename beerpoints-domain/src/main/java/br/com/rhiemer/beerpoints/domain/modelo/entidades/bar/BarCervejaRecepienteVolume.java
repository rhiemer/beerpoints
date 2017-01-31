package br.com.rhiemer.beerpoints.domain.modelo.entidades.bar;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import br.com.rhiemer.api.jpa.annotations.UniqueKey;
import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreInformacao;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.RecepienteVolume;

@Entity
@Table(name = "TB_BAR_CERVEJA_RECEP_VOL",uniqueConstraints={@UniqueConstraint(columnNames = {"bar_cerveja_id" , "recepiente_volume_id"})})
@Audited
@AuditTable("TB_AUDITORIA_BAR_CERVEJA_RECEP_VOL")
@RESTful(ConstantesBeerPointsDomain.BAR_CERVEJA_RECEPIENTE_VOLUME)
@SQLDelete(sql = "UPDATE TB_BAR_CERVEJA_RECEP_VOL SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
@UniqueKey(columnNames={"barCerveja","recepienteVolume"},validar=true)
public class BarCervejaRecepienteVolume extends EntityBeerPointsCoreInformacao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;


	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bar_cerveja_id", nullable = false,updatable=false)
	private BarCerveja barCerveja;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recepiente_volume_id", nullable = false,updatable=false)
	private RecepienteVolume recepienteVolume;

	@NotNull
	@Column(precision = 10, scale = 5)
	@DecimalMax("9999999999")
	@DecimalMin("0.00001")
	private BigDecimal preco;

	public BarCerveja getBarCerveja() {
		return barCerveja;
	}

	public void setBarCerveja(BarCerveja barCerveja) {
		this.barCerveja = barCerveja;
	}

	public RecepienteVolume getRecepienteVolume() {
		return recepienteVolume;
	}

	public void setRecepienteVolume(RecepienteVolume recepienteVolume) {
		this.recepienteVolume = recepienteVolume;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	
	

}
