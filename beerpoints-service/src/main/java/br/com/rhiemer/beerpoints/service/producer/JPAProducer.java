package br.com.rhiemer.beerpoints.service.producer;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JPAProducer {
	
	@Produces	
	@PersistenceContext
    public EntityManager entityManager;
	
	

}
