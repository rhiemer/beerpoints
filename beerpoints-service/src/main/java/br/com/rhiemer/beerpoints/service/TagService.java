package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.modelo.entidades.Tag;

@Stateless
@LocalBean
public class TagService extends PersitenceServiceBeerPointsEntidadeComNome<Tag, Integer> {

}
