package br.com.rhiemer.beerpoints.service.app;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.auxiliares.Tag;
import br.com.rhiemer.beerpoints.service.entity.PersitenceServiceBeerPointsEntidadeComNome;

@Stateless
@LocalBean
public class TagService extends PersitenceServiceBeerPointsEntidadeComNome<Tag, Integer> {

}
