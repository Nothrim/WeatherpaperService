package com.nothrim.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Author: Notrim
 * Created by: ModelGenerator on 24.04.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    private Response response;
    @JsonProperty("hourly_forecast")
    private List<HourlyForecastItem> hourlyForecast;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public List<HourlyForecastItem> getHourlyForecast() {
        return hourlyForecast;
    }

    public void setHourlyForecast(List<HourlyForecastItem> hourlyForecast) {
        this.hourlyForecast = hourlyForecast;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "response=" + response +
                ", hourlyForecast=" + hourlyForecast +
                '}';
    }
}