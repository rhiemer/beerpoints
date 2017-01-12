package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.modelo.Pais;

@Stateless
@LocalBean
public class PaisService extends
		PersitenceServiceBeerPoints<Pais, Integer> {

}
