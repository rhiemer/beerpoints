package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Recepiente;

@Stateless
@LocalBean
public class RecepienteService extends PersitenceServiceBeerPointsEntidadeComNome<Recepiente, Integer> {

}
