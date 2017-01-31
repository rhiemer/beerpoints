package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.domain.modelo.entidades.bar.BarCervejaRecepienteVolume;

@Stateless
@LocalBean
public class BarCervejaRecepienteVolumeService
		extends PersitenceServiceBeerPointsEntidade<BarCervejaRecepienteVolume, Integer> {

}
