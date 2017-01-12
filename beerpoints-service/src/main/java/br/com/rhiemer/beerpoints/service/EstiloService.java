package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.modelo.Estilo;

@Stateless
@LocalBean
public class EstiloService extends
		PersitenceServiceBeerPoints<Estilo, Integer> {

}
