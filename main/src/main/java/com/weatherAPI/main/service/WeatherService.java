package com.weatherAPI.main.service;

import java.util.List;

import com.weatherAPI.main.entity.WeatherLog;

public interface WeatherService {

	WeatherLog getWeatherByCity(String city);

	List<WeatherLog> getAllWeather();

}
