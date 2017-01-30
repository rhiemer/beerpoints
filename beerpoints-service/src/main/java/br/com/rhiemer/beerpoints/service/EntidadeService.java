package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.api.jpa.service.PersistenceServiceAplicacao;
import br.com.rhiemer.beerpoints.modelo.entidades.Entidade;

@Stateless
@LocalBean
public class EntidadeService extends PersistenceServiceAplicacao<Entidade, String> {

}
