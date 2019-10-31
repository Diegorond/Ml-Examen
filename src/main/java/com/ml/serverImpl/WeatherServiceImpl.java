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
	
	private WeatherResponseDTO buildWeatherToDTO(Weather weather) {

		WeatherResponseDTO responseDTO = new WeatherResponseDTO();
		responseDTO.setDia(new Integer(weather.getDayNumber()).toString());
		switch(weather.getDayWhetherType()) {
		  case RAIN:
		    responseDTO.setClima("Se espera un dia lluvia");
		    break;
		  case DROUGHT:
		    responseDTO.setClima("Habra sequia para esta jornada");
		    break;
		  case OPTIMAL:
		    responseDTO.setClima("Se espera un hermoso dia");
			    break;
		  case UNDEFINED:
			    responseDTO.setClima("Sin pronostico planetas en posicion invalida");
			    break;
		  default:
		    // code block
		}
		
		return null;
	}

}
