package com.ml.model;

import java.util.List;

public class SolarSystem {

	private List<Planet> planets;
	private double perimeterMaxRegisteredBetweenPlanets;
	
	public List<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}
	
	public void moveOneDay() {
		for(Planet planet:planets) {
			planet.moveOneDay();
		}
	}

	public double getPerimeterMaxRegisteredBetweenPlanets() {
		return perimeterMaxRegisteredBetweenPlanets;
	}

	public void setPerimeterMaxRegisteredBetweenPlanets(double perimeterMaxRegisteredBetweenPlanets) {
		/*voy guardando el maximo perimetro registrado con el paso de los dias para mas adelante
		saber cuando va a ser el pico de lluvia*/
		if(perimeterMaxRegisteredBetweenPlanets>this.perimeterMaxRegisteredBetweenPlanets)
			this.perimeterMaxRegisteredBetweenPlanets = perimeterMaxRegisteredBetweenPlanets;
	}


}
