package br.com.rhiemer.beerpoints.domain.modelo.entidades.bar;

import br.com.rhiemer.beerpoints.domain.embeddable.EnderecoLocalizacao;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Bar.class)
public abstract class Bar_ extends br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo_ {

	public static volatile SingularAttribute<Bar, EnderecoLocalizacao> enderecoLocalizacao;
	public static volatile ListAttribute<Bar, BarCerveja> cervejas;

}

