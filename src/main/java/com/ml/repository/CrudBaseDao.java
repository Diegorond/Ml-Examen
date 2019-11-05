package com.ml.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import com.ml.exception.SolarSystemException;
import com.ml.model.DayWhetherType;
import com.ml.model.Weather;
	
@NoRepositoryBean
	public interface CrudBaseDao<T, ID>  extends Repository<T, ID>  {
	    void save(T entity);
	    int countByDayWhetherType(T dayWeatherType);
	    T  findByDayNumber(int day) throws SolarSystemException;
	    void deleteAll();
	}


