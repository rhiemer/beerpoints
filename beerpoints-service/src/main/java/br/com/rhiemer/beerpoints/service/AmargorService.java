package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Amargor;

@Stateless
@LocalBean
public class AmargorService extends PersitenceServiceBeerPointsEntidadeComNome<Amargor, Integer> {

}
