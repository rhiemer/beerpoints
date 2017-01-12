package br.com.rhiemer.beerpoints.rest.resource;

import java.util.List;

import br.com.rhiemer.api.rest.full.RESTFullResource;
import br.com.rhiemer.beerpoints.modelo.GenericEntityBeerPoints;
import br.com.rhiemer.beerpoints.service.PersitenceServiceBeerPoints;



public class RESTFullBeerPointsResource extends RESTFullResource implements RestFullBeerPoints {

	protected PersitenceServiceBeerPoints getPersitenceServiceBeerPoints(Class<?> classe) {
		return (PersitenceServiceBeerPoints) buscarPersitenceService(classe, PersitenceServiceBeerPoints.class);

	}

	@Override
	public List<? extends GenericEntityBeerPoints> procurarPeloNome(String entity, String nome) {

		List<? extends GenericEntityBeerPoints> result = getPersitenceServiceBeerPoints(
				restfullEntities.getNotFound(entity)).pesquisarPeloNome(nome);

		return result;
	}

	@Override
	public List<? extends GenericEntityBeerPoints> procurarPeloNomePaginado(String entity, String nome,
			Integer firstResult, Integer maxResult) {

		List<? extends GenericEntityBeerPoints> result = getPersitenceServiceBeerPoints(
				restfullEntities.getNotFound(entity)).pesquisarPeloNomePaginada(nome, firstResult, maxResult);

		return result;
	}
	
	

	
}
