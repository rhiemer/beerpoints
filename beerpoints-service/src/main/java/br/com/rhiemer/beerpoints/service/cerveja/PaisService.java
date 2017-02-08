package br.com.rhiemer.beerpoints.service.cerveja;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Pais;
import br.com.rhiemer.beerpoints.service.entity.PersitenceServiceBeerPointsEntidadeComNome;

@Stateless
@LocalBean
public class PaisService extends
		PersitenceServiceBeerPointsEntidadeComNome<Pais, Integer> {

}
