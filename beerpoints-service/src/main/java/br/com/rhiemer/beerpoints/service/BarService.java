package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.modelo.Bar;

@Stateless
@LocalBean
public class BarService extends PersitenceServiceBeerPoints<Bar,Integer> {

}
