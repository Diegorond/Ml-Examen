package com.ml.utils;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Polygon;
import org.springframework.stereotype.Component;

import com.ml.exception.GeometryCalculationException;
import com.ml.model.Position;
import com.ml.model.SolarSystem;
/*Utilizo el framework JTS para topologia el cual  dara soporte para simplificar
 * algunos calculos sobre geometria. 
 */

@Component
public class WeatherProcessor {

	private GeometryFactory geometryFactory = new GeometryFactory();
	
	
	public boolean processWetherForTeenYears(SolarSystem solarSystem) {
		
		return true;
	}
	
	//crea la figura que forman los tres planetas uniendo sus posiciones (sin el sol) si el area es cero entonces estan alineados
	private boolean isPlannetsAlignedWithoutSun(SolarSystem solarSystem, Polygon planetsPolygon) throws GeometryCalculationException {
		  
		 if(planetsPolygon==null) {
			  throw new GeometryCalculationException("Error de trazado en planetas contiguos");
		  }		  
		 return  (planetsPolygon.getArea()==0)?true:false;
	}
	
	private boolean isPlannetsAlegnedWithSun(SolarSystem solarSystem) throws GeometryCalculationException {
		//Creo un nuevo poligono esta vez con el sol incluido
		  Polygon planetsPolygon = createPolygonBetweenPlanets(solarSystem,true);
		  if(planetsPolygon==null) {
			  throw new GeometryCalculationException("Error de trazado en planetas contiguos");
		  }	  
		 return  (planetsPolygon.getArea()==0)?true:false;
	}
	
	private boolean isSunInsidePolygonPlannets(SolarSystem solarSystem, Polygon planetsPolygon) { 
		//Creo al sol
	    Coordinate coordinateSun = new Coordinate(0,0);
		Geometry sun = geometryFactory.createPoint(coordinateSun);
		return  (planetsPolygon.contains(sun))?true:false;
	}
	
	public Polygon createPolygonBetweenPlanets(SolarSystem solarSystem, boolean includeSun) {  
		  ArrayList<Coordinate> coordsList = convertCurrentPositionPlanetsToCoordinates(solarSystem);
		  //Segun lo indicado incluyo tambien la posicion del sol
		  if(includeSun) {
			  coordsList.add(new Coordinate(0,0));
		  }
		  //Agrego una cuarta posicion que se corresponde a la del primer planeta de la lista. Esto es requisito en JTS para cerrar el poligono.
		  coordsList.add(positionToCoordinate( solarSystem.getPlanets().get(0).getPosition()));
		  LinearRing lRing = geometryFactory.createLinearRing( (Coordinate[]) coordsList.toArray() );
		  LinearRing holes[] = null; // no aplica para este caso
		  Polygon planets = geometryFactory.createPolygon(lRing, holes );
		return planets;
	}

	private ArrayList<Coordinate> convertCurrentPositionPlanetsToCoordinates(SolarSystem solarSystem) {
	      // Combierto la posicion de cada planeta  
		ArrayList<Coordinate> coordsList = (ArrayList<Coordinate>) solarSystem.getPlanets().stream().map(x->{return positionToCoordinate(x.getPosition());}).collect(Collectors.toList());
		return coordsList;
	}
	
	private Coordinate positionToCoordinate(Position pos) {
		return new Coordinate(pos.getCoordinateX(), pos.getCoordinateY());
	}
}
