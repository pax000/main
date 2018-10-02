package com.weatherAPI.main.mapper;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

import com.weatherAPI.main.dto.CurrentWeather;
import com.weatherAPI.main.entity.WeatherLog;

public class WeatherMapper {

	public WeatherLog DtoToEntity(CurrentWeather result) {
		WeatherLog log = new WeatherLog();
		Calendar date = Calendar.getInstance();
		Timestamp time = new Timestamp(date.getTime().getTime());
		String respId = UUID.randomUUID().toString().replace("-", "");
		
		log.setRespId(respId);
		log.setActWeather(result.getWeather().get(0).getDescription());
		log.setLoc(result.getName());
		log.setTemp(result.getMain().getTemp());
		log.setCre8DandT(time);
		
		return log;
	}

}
