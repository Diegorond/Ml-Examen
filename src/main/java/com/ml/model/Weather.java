package com.ml.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="WEATHER")
public class Weather {
	
	private Integer id;
	private DayWhetherType dayWhetherType;
	/*Este atributo solo se utilizara para los dias de lluvia y que son maximos lo hice de esa forma
	para no crear especificaciones de clima adicionales y reducir complejidad*/
	private double perimeterBetweenPlanets;
	private int dayNumber;
	
	public Weather() {
		this.dayWhetherType = DayWhetherType.UNDEFINED;
		this.setDayNumber(0);
	}
	
	@Id
	@Column(name = "ID", updatable = false, nullable = false)
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

	@Enumerated(EnumType.STRING)
	@Column(name = "DAY_WEATHER_TYPE" )
	public DayWhetherType getDayWhetherType() {
		return dayWhetherType;
	}
	public void setDayWhetherType(DayWhetherType dayWhetherType) {
		this.dayWhetherType = dayWhetherType;
	}

	@Column(name = "PERIMETER_BETWEEN_PLANETS" )
	public double getPerimeterBetweenPlanets() {
		return perimeterBetweenPlanets;
	}

	public void setPerimeterBetweenPlanets(double perimeterBetweenPlanets) {
		this.perimeterBetweenPlanets = perimeterBetweenPlanets;
	}

	public int getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}

}
