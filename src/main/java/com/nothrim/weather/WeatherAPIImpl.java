package com.nothrim.weather;

import com.nothrim.json.weather.Weather;
import com.nothrim.rest.RequestBuilderImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Notrim on 08.05.2017.
 */
@Service
public class WeatherAPIImpl extends RequestBuilderImpl implements WeatherAPI {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(WeatherAPIImpl.class);

    private static final String API_URI = "http://api.wunderground.com/api/";
    private static final String KEY = "e5e6da42a0805669";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Weather getWeatherForPosition(float longitude, float latitude) {
        String call = API_URI +
                KEY +
                "/conditions/q/" +
                latitude +
                "," +
                longitude +
                ".json";
        log.info(call);
        return restTemplate.getForObject(call, Weather.class);
    }

    @Override
    public Weather getWeatherForCity(String cityName) {
        String call = API_URI +
                KEY +
                "/conditions/q/" +
                cityName +
                ".json";
        log.info(call);
        return restTemplate.getForObject(call, Weather.class);
    }
}
