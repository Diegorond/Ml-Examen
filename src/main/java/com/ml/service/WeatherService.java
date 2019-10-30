package com.ml.service;

import com.ml.exception.SolarSystemException;
import com.ml.model.Weather;

public interface WeatherService {

	Weather findWetherByDay(int day);
	
	void predictWeatherForTeenYears() throws SolarSystemException;
}
