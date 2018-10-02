package com.weatherAPI.main.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WeatherLog")
public class WeatherLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", unique = true)
	private Long id;

	@Column(name = "responseId", columnDefinition = "BINARY(16)", unique = true)
	private String respId;

	@Column(name = "location", nullable = false)
	private String loc;

	@Column(name = "actualWeather",  nullable = false)
	private String actWeather;

	@Column(name = "temperature", nullable = false)
	private Float temp;

	@Column(name = "dTimeInserted",nullable = false)
	private Timestamp cre8DandT;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRespId() {
		return respId;
	}

	public void setRespId(String respId) {
		this.respId = respId;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getActWeather() {
		return actWeather;
	}

	public void setActWeather(String actWeather) {
		this.actWeather = actWeather;
	}

	public Float getTemp() {
		return temp;
	}

	public void setTemp(Float temp) {
		this.temp = temp;
	}

	public Timestamp getCre8DandT() {
		return cre8DandT;
	}

	public void setCre8DandT(Timestamp cre8DandT) {
		this.cre8DandT = cre8DandT;
	}
	
	
}
