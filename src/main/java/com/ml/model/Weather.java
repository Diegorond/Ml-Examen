package com.ml.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

public class Weather {
	
	public Integer id;

	public String description;
	public DayWhetherType dayWhetherType;
	public int dayNumber;
	
	public Weather() {
		this.description="";
		this.dayWhetherType = DayWhetherType.UNDEFINED;
		this.dayNumber = 0;
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
	
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name = "DAY_WEATHER_TYPE" )
	public DayWhetherType getDayWhetherType() {
		return dayWhetherType;
	}
	public void setDayWhetherType(DayWhetherType dayWhetherType) {
		this.dayWhetherType = dayWhetherType;
	}

}
