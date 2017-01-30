package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.modelo.entidades.ControleEntidade;

@Stateless
@LocalBean
public class ControleEntidadeService extends
		PersitenceServiceBeerPointsEntidadeComNome<ControleEntidade,String> {

}
