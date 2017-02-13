package br.com.rhiemer.beerpoints.domain.modelo.entidades.auxiliares;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;

import br.com.rhiemer.api.jpa.entity.GenericEntityComIdStringDeleteLogico;
import br.com.rhiemer.api.rest.annotations.RESTful;
import br.com.rhiemer.beerpoints.domain.constantes.ConstantesBeerPointsDomain;
import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPointsAuxiliar;

@Entity
@Table(name = "TA_ENTIDADE")
@RESTful(ConstantesBeerPointsDomain.ENTIDADE)
@Audited
@AuditTable("TB_AUDITORIA_ENTIDADE")
@SQLDelete(sql = "UPDATE TA_ENTIDADE SET ativo = 'N', exclusao = sysdate() WHERE id = ? and VERSAO = ? ")
@Where(clause = "ativo = 'S' ")
public class Entidade extends GenericEntityComIdStringDeleteLogico implements IEntityBeerPointsAuxiliar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915147083075996444L;

	@NotNull
	@Column(length = 3, nullable = false)
	@Length(min = 1, max = 3)
	@Audited
	private Integer ordemPesquisa;

	public Integer getOrdemPesquisa() {
		return ordemPesquisa;
	}

	public void setOrdemPesquisa(Integer ordemPesquisa) {
		this.ordemPesquisa = ordemPesquisa;
	}

}
