package com.ml.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
public class SolarSystem {
	private static final Logger LOGGER = LoggerFactory.getLogger(SolarSystem.class);
	private List<Planet> planets;
	private double perimeterMaxRegisteredBetweenPlanets;
	
	public List<Planet> getPlanets() {
		return planets;
	}
	
	@PostConstruct
	private void init() {
		planets = new ArrayList<Planet>();
		Planet ferengi  = new Planet( "Ferengi", new Integer(500), 1,  false); 
		Planet betasoide = new Planet("Betasoide", new Integer(2000), 3, false);
		Planet vulcano = new Planet("Vulcano", new Integer(1000), 5, true);
		planets.add(ferengi);
		planets.add(betasoide);
		planets.add(vulcano);		
	}

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}
	
	public void moveOneDay() {
		for(Planet planet:planets) {	        
			planet.moveOneDay();
			LOGGER.info("Planeta "+ planet.getName() + " avanzo un dia " + planet.getPosition().toString());
		}
	}

	public double getPerimeterMaxRegisteredBetweenPlanets() {
		return perimeterMaxRegisteredBetweenPlanets;
	}

	public void setPerimeterMaxRegisteredBetweenPlanets(double perimeterMaxRegisteredBetweenPlanets) {
		/*voy guardando el maximo perimetro registrado con el paso de los dias para mas adelante
		saber cuando va a ser el pico de lluvia*/
		if(perimeterMaxRegisteredBetweenPlanets>this.perimeterMaxRegisteredBetweenPlanets)
			LOGGER.info("Nuevo perimetro maximo registrado: ",perimeterMaxRegisteredBetweenPlanets);
			this.perimeterMaxRegisteredBetweenPlanets = perimeterMaxRegisteredBetweenPlanets;
	}


}
