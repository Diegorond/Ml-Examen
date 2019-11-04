package com.ml.init;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ml.model.Planet;
import com.ml.model.SolarSystem;

@Component
public class AppSolarSystemInitializator {
	
//	@PostConstruct
//	private void init() {
//		List<Planet> planets = new ArrayList<Planet>();
//		Planet ferengi = new Planet("Ferengi", new Integer(500), 1, false);
//		Planet betasoide = new Planet("Betasoide", new Integer(2000), 3, false);
//		Planet vulcano = new Planet("Vulcano", new Integer(1000), 5, true);
//		planets.add(ferengi);
//		planets.add(betasoide);
//		planets.add(vulcano);
//		SolarSystem solarSystem = new SolarSystem();
//		solarSystem.setPlanets(planets);
//		solarSystem.setPerimeterMaxRegisteredBetweenPlanets(0);
//		
//	}

}
