package com.ml.model;

import java.util.List;

public class SolarSystem {

	private List<Planet> planets;
	private double perimeterMaxBetweenPlanetsRegistered;
	

	public List<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}

	public double getPerimeterMaxBetweenPlanetsRegistered() {
		return perimeterMaxBetweenPlanetsRegistered;
	}

	public void setPerimeterMaxBetweenPlanetsRegistered(double perimeterMaxBetweenPlanetsRegistered) {
		this.perimeterMaxBetweenPlanetsRegistered = perimeterMaxBetweenPlanetsRegistered;
	}
}
