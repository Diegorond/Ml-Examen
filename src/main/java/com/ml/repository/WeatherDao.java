package com.ml.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.ml.model.Weather;
	
	@NoRepositoryBean
	public interface WeatherDao extends Repository<Weather, Integer> {
	    void save(Weather entity);
	    Weather  findByDayNumber(int day);
	    void deleteAll();
	}


