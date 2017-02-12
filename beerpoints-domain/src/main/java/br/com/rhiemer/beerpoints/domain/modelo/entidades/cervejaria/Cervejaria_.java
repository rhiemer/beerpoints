package br.com.rhiemer.beerpoints.domain.modelo.entidades.cervejaria;

import br.com.rhiemer.beerpoints.domain.enums.EnumTipoCervejaria;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cervejaria.class)
public abstract class Cervejaria_ extends br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo_ {

	public static volatile SingularAttribute<Cervejaria, EnumTipoCervejaria> tipoCervejaria;
	public static volatile ListAttribute<Cervejaria, CervejariaLocalizacao> localizacoes;

}

