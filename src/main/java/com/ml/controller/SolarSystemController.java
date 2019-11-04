package com.ml.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ml.exception.SolarSystemException;
import com.ml.request.dto.WeatherResponseDTO;
import com.ml.service.WeatherService;

@RestController
public class SolarSystemController {

	@Autowired
	WeatherService weatherService;
	
	@GetMapping("/clima/{dia}")
	ResponseEntity<WeatherResponseDTO> findWeatherByDay(@PathVariable int dia){
//		
		WeatherResponseDTO weatherDto;
		try {
			weatherDto = weatherService.findWetherByDay(dia);
			return new ResponseEntity<WeatherResponseDTO>(weatherDto,HttpStatus.OK);
		} catch (SolarSystemException e) {
			return null;
		}
	}

}
