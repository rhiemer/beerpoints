package br.com.rhiemer.beerpoints.domain.entity;

import javax.persistence.MappedSuperclass;

import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPointsCoreInformacao;

@MappedSuperclass
public abstract class EntityBeerPointsCoreInformacao extends EntityBeerPointsCoreComControle
		implements IEntityBeerPointsCoreInformacao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6329286668684785571L;

}
