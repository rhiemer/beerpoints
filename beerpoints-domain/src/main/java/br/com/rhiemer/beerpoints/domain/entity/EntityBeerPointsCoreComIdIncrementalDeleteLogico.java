package br.com.rhiemer.beerpoints.domain.entity;

import br.com.rhiemer.api.jpa.entity.GenericEntityComIdIncrementalDeleteLogico;
import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPointsCore;

public abstract class EntityBeerPointsCoreComIdIncrementalDeleteLogico extends GenericEntityComIdIncrementalDeleteLogico
implements IEntityBeerPointsCore {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2531029845099837511L;

	public EntityBeerPointsCoreComIdIncrementalDeleteLogico() {
		super();
	}

	public EntityBeerPointsCoreComIdIncrementalDeleteLogico(int chave) {
		super(chave);
	}

	public EntityBeerPointsCoreComIdIncrementalDeleteLogico(Integer chave) {
		super(chave);
	}
	
	

}
