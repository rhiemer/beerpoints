package br.com.rhiemer.beerpoints.modelo.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import br.com.rhiemer.api.jpa.annotations.UniqueKey;
import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.modelo.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.modelo.entidades.entity.EntityBeerPointsCoreInformacao;

@Entity
@Table(name = "TB_BAR_CERVEJA", uniqueConstraints = { @UniqueConstraint(columnNames = { "cerveja_id", "bar_id" }) })
@Audited
@AuditTable("TB_AUDITORIA_BAR_CERVEJA")
@RESTful(ConstantesBeerPointsDomain.BAR_CERVEJA)
@SQLDelete(sql = "UPDATE TB_BAR_CERVEJA SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
@NamedQueries({
		@NamedQuery(name = "BarCerveja.procurarPeloIdLazy", query = "select a from BarCerveja a "
				+ "left join fetch a.cerveja " + "left join fetch a.bar " + " where a.id =:id") })
@UniqueKey(columnNames = { "cerveja", "bar" }, validar = true)
public class BarCerveja extends EntityBeerPointsCoreInformacao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cerveja_id", nullable = false, updatable = false)
	private Cerveja cerveja;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bar_id", nullable = false, updatable = false)
	private Bar bar;

	public Cerveja getCerveja() {
		return cerveja;
	}

	public void setCerveja(Cerveja cerveja) {
		this.cerveja = cerveja;
	}

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

}
