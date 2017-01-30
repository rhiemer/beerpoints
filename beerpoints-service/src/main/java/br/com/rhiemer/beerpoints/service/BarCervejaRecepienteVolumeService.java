package br.com.rhiemer.beerpoints.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.rhiemer.beerpoints.modelo.entidades.BarCervejaRecepienteVolume;

@Stateless
@LocalBean
public class BarCervejaRecepienteVolumeService
		extends PersitenceServiceBeerPointsEntidade<BarCervejaRecepienteVolume, Integer> {

}
