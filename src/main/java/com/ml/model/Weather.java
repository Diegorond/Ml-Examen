package com.ml.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Weather {
	
	private Integer id;
	private DayWhetherType dayWhetherType;
	/*Este atributo solo se utilizara para los dias de lluvia y que son maximos lo hice de esa forma
	para no crear especificaciones de clima adicionales y reducir complejidad*/
	private Integer perimeterBetweenPlanets;
	private int dayNumber;
	
	public Weather() {
		this.dayWhetherType = DayWhetherType.UNDEFINED;
		this.setDayNumber(0);
	}
	
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Transient
	public String getDescription() {
		return "construir descripcion clima";
	}

	@Column(name = "DAY_WEATHER_TYPE" )
	public DayWhetherType getDayWhetherType() {
		return dayWhetherType;
	}
	public void setDayWhetherType(DayWhetherType dayWhetherType) {
		this.dayWhetherType = dayWhetherType;
	}

	@Column(name = "PERIMETER_BETWEEN_PLANETS" )
	public Integer getPerimeterBetweenPlanets() {
		return perimeterBetweenPlanets;
	}

	public void setPerimeterBetweenPlanets(Integer perimeterBetweenPlanets) {
		this.perimeterBetweenPlanets = perimeterBetweenPlanets;
	}

	public int getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}

}
