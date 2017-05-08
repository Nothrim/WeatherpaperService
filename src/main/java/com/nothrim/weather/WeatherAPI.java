package com.nothrim.weather;


import com.nothrim.json.weather.Weather;

/**
 * Created by Notrim on 08.05.2017.
 */
public interface WeatherAPI {
    public Weather getWeatherForPosition(float longitude, float latitude);

    public Weather getWeatherForCity(String cityName);
}
