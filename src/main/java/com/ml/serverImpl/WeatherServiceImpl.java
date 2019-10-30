package com.ml.serverImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ml.exception.SolarSystemException;
import com.ml.model.DayWhetherType;
import com.ml.model.SolarSystem;
import com.ml.model.Weather;
import com.ml.repository.WeatherDao;
import com.ml.request.dto.WeatherResponseDTO;
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
	public WeatherResponseDTO findWetherByDay(int day) {
		Weather weather = weatherDao.findByDayNumber(day);
		return null;
	}

	@Override
	public void  predictWeatherForTeenYears() throws SolarSystemException {
		try {
			weatherProcessor.processWetherForTeenYears(solarSytem);
		} catch (SolarSystemException e) {
			throw e;
		}
	}	
	
	private WeatherResponseDTO convertWeatherToDTO(Weather weather) {

		WeatherResponseDTO responseDTO = new WeatherResponseDTO();
		switch(weather.getDayWhetherType()) {
		  case RAIN:
		    // code block
		    break;
		  case DROUGHT:
		    // code block
		    break;
		  case OPTIMAL:
			    // code block
			    break;
		  case UNDEFINED:
			    // code block
			    break;
		  default:
		    // code block
		}
		
		return null;
	}

}
