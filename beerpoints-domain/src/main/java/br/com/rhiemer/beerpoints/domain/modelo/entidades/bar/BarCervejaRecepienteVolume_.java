package br.com.rhiemer.beerpoints.domain.modelo.entidades.bar;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.RecepienteVolume;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BarCervejaRecepienteVolume.class)
public abstract class BarCervejaRecepienteVolume_ extends br.com.rhiemer.beerpoints.domain.entity.EntityBeerPointsCoreInformacao_ {

	public static volatile SingularAttribute<BarCervejaRecepienteVolume, BigDecimal> preco;
	public static volatile SingularAttribute<BarCervejaRecepienteVolume, RecepienteVolume> recepienteVolume;
	public static volatile SingularAttribute<BarCervejaRecepienteVolume, BarCerveja> barCerveja;

}

