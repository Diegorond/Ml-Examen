package com.ml.controller;

import org.locationtech.jts.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ml.exception.SolarSystemException;
import com.ml.request.dto.WeatherOverviewDTO;
import com.ml.request.dto.WeatherResponseDTO;
import com.ml.service.WeatherService;

@RestController
public class SolarSystemController {

	@Autowired
	WeatherService weatherService;

	@GetMapping("/clima")
	ResponseEntity findWeatherByDay(@RequestParam(value = "dia") String day) {
		//
		WeatherResponseDTO weatherDto;
		try {
			if (!validateDay(day)) {
				return ResponseEntity.badRequest().body("El dia debe estar comprendido entre 1 y 3650");
			}
			weatherDto = weatherService.findWetherByDay(Integer.parseInt(day));
			return ResponseEntity.ok().body(weatherDto);
		} catch (NumberFormatException e) {
			return ResponseEntity.badRequest().body("El dia solo puede ser un valor numerico");
		} catch (SolarSystemException e) {
			return ResponseEntity.badRequest().body(e.toString());
		}
	}

	private boolean validateDay(String day) throws NumberFormatException {

		int dayConverted = Integer.parseInt(day);
		if (dayConverted >= 1 && dayConverted <= 3560) {
			return true;
		} else {
			return false;
		}
	}
	
	@GetMapping("/clima/resumen")
	ResponseEntity getWeatherOverview() {
		
		WeatherOverviewDTO weatherOverviewDTO = weatherService.makeWeatherOverview();
		return ResponseEntity.ok().body(weatherOverviewDTO);
	} 
	
}
