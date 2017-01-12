package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.modelo.Fabricante;

@Stateless
@LocalBean
public class FabricanteService extends
		PersitenceServiceBeerPoints<Fabricante, Integer> {

}
