package br.com.rhiemer.beerpoints.rest.resource;

import static br.com.rhiemer.api.util.constantes.ConstantesAPI.MEDIA_REST_JSON;
import static br.com.rhiemer.api.rest.constantes.ConstantesAPIRest.PATH_GENERIC;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.rhiemer.api.rest.full.RestFull;
import br.com.rhiemer.api.util.annotations.rest.RestClientMetodoClasse;

@Path(PATH_GENERIC)
public interface RestFullBeerPoints extends RestFull {

	@GET
	@Produces(MEDIA_REST_JSON)
	@Consumes(MEDIA_REST_JSON)
	@Path("/{entity}/pesquisarPeloNome/{nome}")
	Object procurarPeloNome(@PathParam("entity") @RestClientMetodoClasse String entity, @PathParam("nome") String nome);

	@GET
	@Produces(MEDIA_REST_JSON)
	@Consumes(MEDIA_REST_JSON)
	@Path("/{entity}/pesquisarPeloNome/{nome}/{firstResult}/{maxResult}")
	Object procurarPeloNomePaginado(@PathParam("entity") @RestClientMetodoClasse String entity, @PathParam("nome")String nome, @PathParam("firstResult")Integer firstResult,
			@PathParam("maxResult")Integer maxResult);
	
	

}