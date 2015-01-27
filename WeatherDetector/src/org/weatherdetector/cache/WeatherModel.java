package org.weatherdetector.cache;

import java.util.Date;

public class WeatherModel {
	private String response;
	private Date responseTime;
	public WeatherModel(String response) {
		super();
		this.response = response;
		this.responseTime = new Date();
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Date getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}
	
	
}
