package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.modelo.entidades.Familia;

@Stateless
@LocalBean
public class FamiliaService extends
		PersitenceServiceBeerPointsEntidadeComNome<Familia, Integer> {

}
