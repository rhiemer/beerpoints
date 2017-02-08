package br.com.rhiemer.beerpoints.service.bar;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.bar.BarCervejaRecepienteVolume;
import br.com.rhiemer.beerpoints.service.entity.PersitenceServiceBeerPointsEntidade;

@Stateless
@LocalBean
public class BarCervejaRecepienteVolumeService
		extends PersitenceServiceBeerPointsEntidade<BarCervejaRecepienteVolume, Integer> {

}
