package com.ml.utils;

import org.locationtech.jts.geom.Polygon;

import com.ml.exception.SolarSystemException;
import com.ml.model.SolarSystem;

public interface WeatherProcessor {

	void processWetherForTeenYears(SolarSystem solarSystem) throws SolarSystemException;

	Polygon createPolygonBetweenPlanets(SolarSystem solarSystem, boolean includeSun);

}