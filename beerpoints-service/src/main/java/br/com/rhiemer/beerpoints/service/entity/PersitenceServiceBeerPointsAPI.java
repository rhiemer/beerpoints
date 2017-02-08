package br.com.rhiemer.beerpoints.service.entity;

import static br.com.rhiemer.api.jpa.constantes.ConstantesAPIJPA.SERVICE_APLICACAO;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;

import br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo;

@Stateless
@LocalBean
@Named(SERVICE_APLICACAO)
public class PersitenceServiceBeerPointsAPI extends PersitenceServiceBeerPointsEntidadeComNome<EntityBeerPointsCoreModelo,Serializable> {

}
