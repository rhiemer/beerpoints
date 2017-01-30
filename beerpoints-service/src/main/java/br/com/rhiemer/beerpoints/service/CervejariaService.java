package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.modelo.entidades.Cervejaria;

@Stateless
@LocalBean
public class CervejariaService extends
		PersitenceServiceBeerPointsEntidadeComNome<Cervejaria, Integer> {

}
