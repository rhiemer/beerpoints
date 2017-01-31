package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.cervejaria.Cervejaria;

@Stateless
@LocalBean
public class CervejariaService extends
		PersitenceServiceBeerPointsEntidadeComNome<Cervejaria, Integer> {

}
