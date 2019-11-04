package com.ml.serverImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ml.exception.SolarSystemException;
import com.ml.model.SolarSystem;
import com.ml.model.Weather;
import com.ml.repository.WeatherDAO;
import com.ml.request.dto.WeatherOverviewDTO;
import com.ml.request.dto.WeatherResponseDTO;
import com.ml.service.WeatherService;
import com.ml.utils.WeatherProcessor;

@Component
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	SolarSystem solarSytem;

	@Autowired
	private WeatherDAO weatherDao;

	@Autowired
	private WeatherProcessor weatherProcessor;

	// Devuelve el clima para un dia dado (dia 1 a 3650)
	@Override
	public WeatherResponseDTO findWetherByDay(int day) throws SolarSystemException {
		Weather weather = weatherDao.findByDayNumber(day);
		return buildWeatherToDTO(weather);
	}

	@Override
	public void predictWeatherForTeenYears() throws SolarSystemException {
		try {
			weatherProcessor.processWetherForTeenYears(solarSytem);
		} catch (SolarSystemException e) {
			throw e;
		}
	}

	private WeatherResponseDTO buildWeatherToDTO(Weather weather) {

		WeatherResponseDTO responseDTO = new WeatherResponseDTO();
		responseDTO.setDia(new Integer(weather.getDayNumber()).toString());
		switch (weather.getDayWhetherType()) {
		case RAIN:
			responseDTO.setClima("Se espera un dia lluvia");
			return responseDTO;

		case DROUGHT:
			responseDTO.setClima("Habra sequia para esta jornada");
			return responseDTO;
		case OPTIMAL:
			responseDTO.setClima("Se espera un hermoso dia");
			return responseDTO;
		case UNDEFINED:
			responseDTO.setClima("Sin pronostico planetas en posicion invalida");
			return responseDTO;
		default:
			return null;
		}
	}

	@Override
	public WeatherOverviewDTO makeWeatherOverview() {
		// TODO Auto-generated method stub
		return null;
	}



}
