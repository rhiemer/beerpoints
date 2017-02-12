package br.com.rhiemer.beerpoints.domain.modelo.entidades.bar;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.Cerveja;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BarCerveja.class)
public abstract class BarCerveja_ extends br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreInformacao_ {

	public static volatile SingularAttribute<BarCerveja, Bar> bar;
	public static volatile SingularAttribute<BarCerveja, Cerveja> cerveja;

}

