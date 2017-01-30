package br.com.rhiemer.beerpoints.modelo.entidades.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import br.com.rhiemer.beerpoints.modelo.entidades.interfaces.IEntityBeerPointsComControle;
import br.com.rhiemer.beerpoints.modelo.entidades.interfaces.IEntityBeerPointsCoreModelo;

@MappedSuperclass
public abstract class EntityBeerPointsCoreModelo extends EntityBeerPointsComNomeTexto
		implements IEntityBeerPointsCoreModelo,IEntityBeerPointsComControle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6329286668684785571L;
	
	@NotNull
	@Column(nullable = false)
	private Integer controleId;

	public Integer getControleId() {
		return controleId;
	}

	public void setControleId(Integer controleId) {
		this.controleId = controleId;
	}

}
