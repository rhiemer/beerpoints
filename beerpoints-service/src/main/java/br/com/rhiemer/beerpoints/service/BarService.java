package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.modelo.entidades.Bar;

@Stateless
@LocalBean
public class BarService extends PersitenceServiceBeerPointsEntidadeComNome<Bar,Integer> {

}
