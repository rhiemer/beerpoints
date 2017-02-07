package br.com.rhiemer.beerpoints.domain.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPointsComControle;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.controle.ControleEntidade;

@MappedSuperclass
public abstract class EntityBeerPointsCoreComControle extends EntityBeerPointsCoreComIdIncrementalDeleteLogico
		implements IEntityBeerPointsComControle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7073080721361887314L;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "controleId", referencedColumnName = "id",unique = true, nullable = false, updatable = false)
	@JsonIgnore
	private ControleEntidade controleEntidade;

	@Column(name="controleId",nullable = false, unique = true, updatable = false,insertable=false)
	private Integer controleId;
	
	

	public Integer getControleId() {
		return controleId;
	}

	public void setControleId(Integer controleId) {
		this.controleId = controleId;
	}
	
	@Override
	public ControleEntidade getControleEntidade() {
		return controleEntidade;
	}

	@Override
	public void setControleEntidade(ControleEntidade controleEntidade) {
		this.controleEntidade = controleEntidade;
	}

}
