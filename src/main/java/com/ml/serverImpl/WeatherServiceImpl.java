package com.ml.serverImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ml.model.SolarSystem;
import com.ml.model.Weather;
import com.ml.repository.WeatherDao;
import com.ml.service.WeatherService;
import com.ml.utils.WeatherProcessor;

public class WeatherServiceImpl implements WeatherService{

	@Autowired
	SolarSystem solarSytem;
	
	@Autowired
	private WeatherDao weatherDao;
	
	@Autowired
	private WeatherProcessor weatherProcessor;
	
	//Devuelve el clima para un dia dado (dia 1 a 3650)
	@Override
	public Weather findWetherByDay(int day) {
		return weatherDao.findByDayNumber(day);
	}

	@Override
	public boolean predictWeatherForTeenYears() {
		return weatherProcessor.processWetherForTeenYears(solarSytem);
	}	

}
