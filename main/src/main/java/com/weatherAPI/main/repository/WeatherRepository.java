package com.weatherAPI.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weatherAPI.main.entity.WeatherLog;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherLog, Long> {

}
