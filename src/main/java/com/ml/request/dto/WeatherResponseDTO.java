package com.ml.request.dto;

public class WeatherResponseDTO {

	private String dayNumber;
	private String description;
	
	public String getDayNumber() {
		return dayNumber;
	}
	public void setDayNumber(String dayNumber) {
		this.dayNumber = dayNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
