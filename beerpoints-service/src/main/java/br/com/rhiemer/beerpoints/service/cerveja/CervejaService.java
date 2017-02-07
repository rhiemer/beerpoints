package br.com.rhiemer.beerpoints.service.cerveja;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Cerveja;
import br.com.rhiemer.beerpoints.service.entity.PersitenceServiceBeerPointsEntidadeComNome;

@Stateless
@LocalBean
public class CervejaService extends PersitenceServiceBeerPointsEntidadeComNome<Cerveja,Integer> {

}
