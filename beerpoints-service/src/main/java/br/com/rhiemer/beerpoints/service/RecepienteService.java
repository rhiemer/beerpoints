package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.modelo.entidades.Recepiente;

@Stateless
@LocalBean
public class RecepienteService extends PersitenceServiceBeerPointsEntidadeComNome<Recepiente, Integer> {

}
