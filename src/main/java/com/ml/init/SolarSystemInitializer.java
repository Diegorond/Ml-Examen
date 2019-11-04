package com.ml.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ml.exception.SolarSystemException;
import com.ml.service.WeatherService;

@Component
public class SolarSystemInitializer {
	
	@Autowired
	WeatherService weatherService;
	

	@PostConstruct
	public void init() {
		
		try {
			weatherService.predictWeatherForTeenYears();
		} catch (SolarSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
