package com.ml.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Polygon;

import com.kenai.jffi.Array;
import com.ml.exception.GeometryCalculationException;
import com.ml.model.Position;
import com.ml.model.SolarSystem;
/*Utilizo el framework JTS para topologia el cual  dara soporte para simplificar
 * algunos calculos sobre geometria. 
 */

public class WeatherProcessor {

	public void processWetherForTeenYears(SolarSystem solarSystem) {
		
	}
	
	//crea la figura que forman los tres planetas uniendo sus posiciones (sin el sol) si el area es cero entonces estan alineados
	private boolean isPlannetsAlignedWithoutSun(SolarSystem solarSystem) throws GeometryCalculationException {
		  Polygon planetsPolygon = createPolygonBetweenPlanets(solarSystem);
		  if(planetsPolygon==null) {
			  throw new GeometryCalculationException("Error de trazado en planetas contiguos");
		  }
//		  double perimeter = planets.getLength();		  
		 return  (planetsPolygon.getArea()==0)?true:false;
	}
	
	
	public Polygon createPolygonBetweenPlanets(SolarSystem solarSystem) {
		GeometryFactory gf = new GeometryFactory();	  
	      // Combierto la posicion de cada planeta  
		  ArrayList<Coordinate> coordsList = (ArrayList<Coordinate>) solarSystem.getPlanets().stream().map(x->{return positionToCoordinate(x.getPosition());}).collect(Collectors.toList());
		  //Agrego una cuarta posicion que se corresponde a la del primer planeta de la lista. Esto es requisito en JTS para cerrar el poligono.
		  coordsList.add(positionToCoordinate( solarSystem.getPlanets().get(0).getPosition()));
		  LinearRing lRing = gf.createLinearRing( (Coordinate[]) coordsList.toArray() );
		  LinearRing holes[] = null; // no aplica para este caso
		  Polygon planets = gf.createPolygon(lRing, holes );
		return planets;
	}
	
	private Coordinate positionToCoordinate(Position pos) {
		return new Coordinate(pos.getCoordinateX(), pos.getCoordinateY());
	}
}
