package br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.bar.BarCerveja;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.cervejaria.Cervejaria;
import br.com.rhiemer.beerpoints.domain.modelo.entidades.localizacao.RegiaoPais;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cerveja.class)
public abstract class Cerveja_ extends br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreModelo_ {

	public static volatile SingularAttribute<Cerveja, BigDecimal> teorAlcolico;
	public static volatile SingularAttribute<Cerveja, Estilo> estilo;
	public static volatile ListAttribute<Cerveja, BarCerveja> bares;
	public static volatile SingularAttribute<Cerveja, Amargor> amargor;
	public static volatile SingularAttribute<Cerveja, Cervejaria> cervejaria;
	public static volatile SingularAttribute<Cerveja, RegiaoPais> regiaoPais;
	public static volatile SingularAttribute<Cerveja, Familia> familia;
	public static volatile SingularAttribute<Cerveja, Pais> pais;

}

