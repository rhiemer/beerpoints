package br.com.rhiemer.beerpoints.modelo.entidades.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import br.com.rhiemer.beerpoints.modelo.entidades.interfaces.IEntityBeerPointsComControle;

@MappedSuperclass
public abstract class EntityBeerPointsCoreComControle extends EntityBeerPointsCoreComIdIncrementalDeleteLogico
		implements IEntityBeerPointsComControle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7073080721361887314L;

	@NotNull
	@Column(nullable = false,unique=true)
	private Integer controleId;

	public Integer getControleId() {
		return controleId;
	}

	public void setControleId(Integer controleId) {
		this.controleId = controleId;
	}

}
