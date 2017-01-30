package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.modelo.entidades.Pais;

@Stateless
@LocalBean
public class PaisService extends
		PersitenceServiceBeerPointsEntidadeComNome<Pais, Integer> {

}
