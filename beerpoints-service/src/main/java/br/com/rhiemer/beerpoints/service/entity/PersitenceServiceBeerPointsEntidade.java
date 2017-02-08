package br.com.rhiemer.beerpoints.service.entity;

import java.io.Serializable;

import br.com.rhiemer.api.jpa.service.PersistenceServiceAplicacao;
import br.com.rhiemer.beerpoints.domain.interfaces.IEntityBeerPoints;

public abstract class PersitenceServiceBeerPointsEntidade<T extends IEntityBeerPoints, K extends Serializable>
		extends PersistenceServiceAplicacao<T, K> {


}
