package com.ml.utils;

import java.util.Arrays;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Polygon;

import com.ml.model.SolarSystem;
/*Utilizo el framework JTS para topologia el cual  dara soporte para simplificar
 * algunos calculos sobre geometria. 
 */

public class WeatherProcessor {

	public void processWetherForTeenYears(SolarSystem solarSystem) {
		
	}
	
	private boolean isPlannetsAligned(SolarSystem solarSystem) {
		  GeometryFactory gf = new GeometryFactory();

//	        // Combierto la posicion de cada planeta  
//		  Coordinate[] coords = solarSystem.getPlanets().stream(lines.split("\\s+"))
//				.map(String::toUpperCase)
//				.toArray(String[]::new);
		  Coordinate[] coords  =
		     new Coordinate[] {new Coordinate(0, 1), new Coordinate(0, -2),
		                       new Coordinate(0, 2),new Coordinate(0, 1)};

		  
		  LinearRing lRing = gf.createLinearRing( coords );
		  LinearRing holes[] = null; // no aplica para este caso
		  Polygon planets = gf.createPolygon(lRing, holes );
		  double perimeter = planets.getLength();
		return false;
	}
}
