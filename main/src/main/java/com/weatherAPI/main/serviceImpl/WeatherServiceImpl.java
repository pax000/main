package com.weatherAPI.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weatherAPI.main.dto.CurrentWeather;
import com.weatherAPI.main.entity.WeatherLog;
import com.weatherAPI.main.mapper.WeatherMapper;
import com.weatherAPI.main.repository.WeatherRepository;
import com.weatherAPI.main.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	WeatherRepository logsRepo;
	
	WeatherMapper mapper = new WeatherMapper();
	
	private static String API_KEY = "955cd12329e7ea40e7d8b5ccc08573ea";

	private static final Logger LOGGER = Logger.getLogger(WeatherServiceImpl.class.getName());

	@Override
	public WeatherLog getWeatherByCity(String city) {
		LOGGER.info("Start - getWeatherById");
		final String uri = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid="
				+ API_KEY;
		WeatherLog mappedRes = new WeatherLog();
		
		RestTemplate restTemplate = new RestTemplate();
		CurrentWeather result = restTemplate.getForObject(uri, CurrentWeather.class);
		mappedRes = mapper.DtoToEntity(result);
		
		List<WeatherLog> weatherLogs = new ArrayList<>();
		weatherLogs = logsRepo.findAll();
		List<WeatherLog> weatherLogstoDelete = new ArrayList<>();
		if (weatherLogs.size() >= 5) {
			weatherLogstoDelete = weatherLogs.subList(0,weatherLogs.size()-4);
			logsRepo.deleteAll(weatherLogstoDelete);
		}
		logsRepo.save(mappedRes);
		LOGGER.info("END - getCurrentWeatherById");
		return mappedRes;
	}

	@Override
	public List<WeatherLog> getAllWeather() {
		return logsRepo.findAll();
	}

}
