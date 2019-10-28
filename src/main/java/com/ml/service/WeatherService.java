package com.ml.service;

import com.ml.model.Weather;

public interface WeatherService {

	Weather findWetherByDay(int day);
}
