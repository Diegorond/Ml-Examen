package com.ml.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ml.request.dto.WeatherResponseDTO;
import com.ml.service.WeatherService;
import com.ml.utils.WeatherProcessor;

@RestController
public class SolarSystemController {

	@Autowired
	WeatherService weatherService;
	
	@GetMapping(value = "/clima/{dia}")
	ResponseEntity<WeatherResponseDTO> findWeatherByDay(@PathVariable int dia){
		Weather wweatherService
		return new ResponseEntity<WeatherResponseDTO>(
	}

}
