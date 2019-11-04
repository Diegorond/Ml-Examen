package com.ml.request.dto;

public class WeatherOverviewDTO {
	
	private String lluvia;
	private String lluviaMaxima;
	private String sequia;
	private String optimo;
	private String indefinido;
	
	public String getLluvia() {
		return lluvia;
	}
	public void setLluvia(String lluvia) {
		this.lluvia = lluvia;
	}
	public String getLluviaMaxima() {
		return lluviaMaxima;
	}
	public void setLluviaMaxima(String lluviaMaxima) {
		this.lluviaMaxima = lluviaMaxima;
	}
	public String getSequia() {
		return sequia;
	}
	public void setSequia(String sequia) {
		this.sequia = sequia;
	}
	public String getOptimo() {
		return optimo;
	}
	public void setOptimo(String optimo) {
		this.optimo = optimo;
	}
	public String getIndefinido() {
		return indefinido;
	}
	public void setIndefinido(String indefinido) {
		this.indefinido = indefinido;
	}

}
