package com.ml.utils;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Polygon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ml.exception.CalculateWeatherProcessGenericException;
import com.ml.exception.GeometryCalculationException;
import com.ml.exception.SolarSystemException;
import com.ml.model.DayWhetherType;
import com.ml.model.Position;
import com.ml.model.SolarSystem;
import com.ml.model.Weather;
/*Utilizo el framework JTS para topologia el cual  dara soporte para simplificar
 * algunos calculos sobre geometria. 
 */
import com.ml.repository.WeatherDao;

@Component
public class WeatherProcessor {

	private GeometryFactory geometryFactory = new GeometryFactory();
	
	@Autowired
	private WeatherDao weatherDao;
	
	public void processWetherForTeenYears(SolarSystem solarSystem) throws SolarSystemException{
		//Proceso el clima por los diez anios avanzando de a un dia y guardando el clima en la base para luego ser consultado
        int cantDaysTeenYears = 3650;
        try {
			for (int dayNumber = 1; dayNumber <= cantDaysTeenYears ; dayNumber++) {
				solarSystem.moveOneDay();
				calculateAndSaveWeather(solarSystem,dayNumber);
	        }
        }catch(GeometryCalculationException e){
        	throw e;
        }catch(Exception e){
        	throw new CalculateWeatherProcessGenericException("Error desconocido al procesar el clima, se resetean los planetas y se eliminan los datos guardados");
        }
	}
	
	private void calculateAndSaveWeather(SolarSystem solarSystem, int dayNumber) throws GeometryCalculationException{
		
		Weather weather = new Weather();
		//Comiendo evaluando el caso que se repetira mas cantidad de veces (planetas desalineados)
		 //Creo el triangulo (poligono) que forman los tres planetas desalineados.
		Polygon planetsPolygon = createPolygonBetweenPlanets(solarSystem, false);
		//Verifico  si el sol esta contenido dentro del triangulo que forman los planetas
		if(isSunInsidePolygonPlannets(solarSystem, planetsPolygon)) {
			weather.setDayNumber(dayNumber);
			weather.setDayWhetherType(DayWhetherType.RAIN);
		}
		
		
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
