package br.com.rhiemer.beerpoints.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

@Embeddable
public class Localizacao {
	
	@Column(precision = 20, scale = 8)
	@DecimalMax("999")
	@DecimalMin("0.00000001")
	private BigDecimal latitude;
	
	@Column(precision = 20, scale = 8)
	@DecimalMax("1000")
	@DecimalMin("0.00000001")
	private BigDecimal longitude;

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

}
