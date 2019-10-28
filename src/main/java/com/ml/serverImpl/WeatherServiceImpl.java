package com.ml.serverImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ml.model.Weather;
import com.ml.repository.WeatherDao;
import com.ml.service.WeatherService;

public class WeatherServiceImpl implements WeatherService{

	@Autowired
	WeatherDao weatherDao;
	
	@Override
	public Weather findWetherByDay(int day) {

		return weatherDao.findByDayNumber(day);
	}

}
