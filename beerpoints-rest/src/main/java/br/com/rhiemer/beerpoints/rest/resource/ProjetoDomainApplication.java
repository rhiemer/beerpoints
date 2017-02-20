package br.com.rhiemer.beerpoints.rest.resource;

import static br.com.rhiemer.api.rest.constantes.ConstantesAPIRest.PATH_VERSION_INI;
import static br.com.rhiemer.api.rest.constantes.ConstantesAPIRest.VERSION_INI;
import static br.com.rhiemer.api.rest.constantes.ConstantesAPIRest.VERSION_INI_BARRA;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath(PATH_VERSION_INI)
public class ProjetoDomainApplication extends Application {

	
	public static final String DOMAIN_REST_PADRAO = VERSION_INI;
	public static final String DOMAIN_REST_PADRAO_PATH = PATH_VERSION_INI;
	public static final String DOMAIN_REST_PADRAO_BARRA = VERSION_INI_BARRA;

}
