package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Pais;

@Stateless
@LocalBean
public class PaisService extends
		PersitenceServiceBeerPointsEntidadeComNome<Pais, Integer> {

}
