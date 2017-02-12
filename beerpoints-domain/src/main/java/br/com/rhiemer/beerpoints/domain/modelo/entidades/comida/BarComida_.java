package br.com.rhiemer.beerpoints.domain.modelo.entidades.comida;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.bar.Bar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BarComida.class)
public abstract class BarComida_ extends br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo_ {

	public static volatile SingularAttribute<BarComida, Bar> bar;
	public static volatile SingularAttribute<BarComida, Comida> comida;

}

