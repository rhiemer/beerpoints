package br.com.rhiemer.beerpoints.service.bar;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.bar.Bar;
import br.com.rhiemer.beerpoints.service.entity.PersitenceServiceBeerPointsEntidadeComNome;

@Stateless
@LocalBean
public class BarService extends PersitenceServiceBeerPointsEntidadeComNome<Bar,Integer> {

}
