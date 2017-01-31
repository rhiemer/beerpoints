package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.bar.BarCerveja;

@Stateless
@LocalBean
public class BarCervejaService extends PersitenceServiceBeerPointsEntidade<BarCerveja, Integer> {

	
}
