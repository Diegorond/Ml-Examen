package com.ml.service;

import com.ml.exception.SolarSystemException;
import com.ml.model.Weather;
import com.ml.request.dto.WeatherOverviewDTO;
import com.ml.request.dto.WeatherResponseDTO;

public interface WeatherService {

	WeatherResponseDTO findWetherByDay(int day) throws SolarSystemException;
	
	void predictWeatherForTeenYears() throws SolarSystemException;
	
	WeatherOverviewDTO makeWeatherOverview();
}
