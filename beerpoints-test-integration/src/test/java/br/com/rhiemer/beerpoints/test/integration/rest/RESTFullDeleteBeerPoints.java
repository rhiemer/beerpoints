package br.com.rhiemer.beerpoints.test.integration.rest;

import static br.com.rhiemer.api.rest.constantes.ConstantesAPIRest.PATH_DELETE;

import javax.ws.rs.Path;

import br.com.rhiemer.api.rest.full.RestFullDelete;

@Path(PATH_DELETE)
public interface RESTFullDeleteBeerPoints extends RestFullDelete {

}
