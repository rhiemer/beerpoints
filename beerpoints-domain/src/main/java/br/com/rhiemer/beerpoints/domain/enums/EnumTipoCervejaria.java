package br.com.rhiemer.beerpoints.domain.enums;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import br.com.rhiemer.api.jpa.enums.EnumeracaoComNome;

public enum EnumTipoCervejaria implements EnumeracaoComNome {

	PEQUENA("Pequena"), GRANDE("Grande");

	private static Map<String, EnumTipoCervejaria> mapNome;

	static {
		mapNome=new HashMap<>();
		for (EnumTipoCervejaria value : EnumTipoCervejaria.values()) {
			mapNome.put(value.getNome(), value);
		}
	}

	private String nome;

	private EnumTipoCervejaria(String nome) {
		this.nome = nome;
	}

	@JsonValue
	public String getNome() {
		return nome;
	}
	
	@JsonCreator
	public static EnumTipoCervejaria getByNome(String nome)
	{
		return mapNome.get(nome);
	}

}
