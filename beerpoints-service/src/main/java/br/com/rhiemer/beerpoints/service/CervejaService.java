package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.modelo.entidades.Cerveja;

@Stateless
@LocalBean
public class CervejaService extends PersitenceServiceBeerPointsEntidadeComNome<Cerveja,Integer> {

}
