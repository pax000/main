package com.weatherAPI.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weatherAPI.main.entity.WeatherLog;
import com.weatherAPI.main.service.WeatherService;

@Controller
@RequestMapping("/weatherLog")
public class WeatherController {
	
	@Autowired
	private WeatherService service;

	@GetMapping("/getCurrentWeather")
	@ResponseBody
	public WeatherLog getCurrentWeather(@RequestParam String city) {
		return service.getWeatherByCity(city);
	}
	
	@GetMapping("/getAllWeather")
	@ResponseBody
	public List<WeatherLog> getAllWeather() {
		return service.getAllWeather();
	}
	
}
