package br.com.rhiemer.beerpoints.service.bar;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.bar.BarCerveja;
import br.com.rhiemer.beerpoints.service.entity.PersitenceServiceBeerPointsEntidade;

@Stateless
@LocalBean
public class BarCervejaService extends PersitenceServiceBeerPointsEntidade<BarCerveja, Integer> {

	
}
