package br.com.rhiemer.beerpoints.domain.converter;

import javax.persistence.AttributeConverter;

import br.com.rhiemer.beerpoints.domain.enums.EnumTipoCervejaria;

public class EnumTipoCervejariaConverter implements AttributeConverter<EnumTipoCervejaria, String> {

	@Override
	public String convertToDatabaseColumn(EnumTipoCervejaria attribute) {
		return attribute == null?null:attribute.getNome();
	}

	@Override
	public EnumTipoCervejaria convertToEntityAttribute(String dbData) {
		return EnumTipoCervejaria.getByNome(dbData);
	}
	
	

}
