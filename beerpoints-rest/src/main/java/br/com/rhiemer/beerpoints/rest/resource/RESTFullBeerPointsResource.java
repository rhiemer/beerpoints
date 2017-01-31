package br.com.rhiemer.beerpoints.rest.resource;

import java.util.List;

import br.com.rhiemer.api.rest.full.RESTFullResource;
import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo;
import br.com.rhiemer.beerpoints.service.PersitenceServiceBeerPointsEntidadeComNome;



public class RESTFullBeerPointsResource extends RESTFullResource implements RestFullBeerPoints {

	protected PersitenceServiceBeerPointsEntidadeComNome getPersitenceServiceBeerPoints(Class<?> classe) {
		return (PersitenceServiceBeerPointsEntidadeComNome) buscarPersitenceService(classe, PersitenceServiceBeerPointsEntidadeComNome.class);

	}

	@Override
	public List<? extends EntityBeerPointsCoreModelo> procurarPeloNome(String entity, String nome) {

		List<? extends EntityBeerPointsCoreModelo> result = getPersitenceServiceBeerPoints(
				restfullEntities.getNotFound(entity)).pesquisarPeloNome(nome);

		return result;
	}

	@Override
	public List<? extends EntityBeerPointsCoreModelo> procurarPeloNomePaginado(String entity, String nome,
			Integer firstResult, Integer maxResult) {

		List<? extends EntityBeerPointsCoreModelo> result = getPersitenceServiceBeerPoints(
				restfullEntities.getNotFound(entity)).pesquisarPeloNomePaginada(nome, firstResult, maxResult);

		return result;
	}
	
	

	
}
