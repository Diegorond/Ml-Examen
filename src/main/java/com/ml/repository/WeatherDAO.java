package com.ml.repository;

import com.ml.exception.SolarSystemException;
import com.ml.model.Weather;

public interface WeatherDAO extends CrudBaseDao<Weather, Long>{

    void save(Weather entity);
    Weather findByDayNumber(int day) throws SolarSystemException;
    void deleteAll();
}
