package br.com.rhiemer.beerpoints.service.cerveja;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.cerveja.RecepienteVolume;
import br.com.rhiemer.beerpoints.service.entity.PersitenceServiceBeerPointsEntidade;

@Stateless
@LocalBean
public class RecepienteVolumeService extends PersitenceServiceBeerPointsEntidade<RecepienteVolume, Integer> {

}
