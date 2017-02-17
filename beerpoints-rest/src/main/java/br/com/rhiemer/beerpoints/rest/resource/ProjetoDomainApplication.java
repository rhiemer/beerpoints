package br.com.rhiemer.beerpoints.rest.resource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/v1.0")
public class ProjetoDomainApplication extends Application {
	
	public static final String DOMAIN_REST_PADRAO="v1.0";
	public static final String DOMAIN_REST_PADRAO_BARRA="v1.0/";

}
