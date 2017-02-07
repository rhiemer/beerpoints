package br.com.rhiemer.beerpoints.service.app;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.controle.ControleEntidade;
import br.com.rhiemer.beerpoints.service.entity.PersitenceServiceBeerPointsEntidadeComNome;

@Stateless
@LocalBean
public class ControleEntidadeService extends
		PersitenceServiceBeerPointsEntidadeComNome<ControleEntidade,String> {

}
