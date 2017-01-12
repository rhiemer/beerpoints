package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.modelo.Cerveja;

@Stateless
@LocalBean
public class CervejaService extends PersitenceServiceBeerPoints<Cerveja,Integer> {

}
