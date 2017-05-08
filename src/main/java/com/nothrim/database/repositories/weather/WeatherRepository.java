package com.nothrim.database.repositories.weather;

import com.nothrim.database.models.security.User;
import com.nothrim.database.models.weather.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * Created by Notrim on 24.04.2017.
 */
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    Weather findByCity(String city);

    Weather findByUsers(Set<User> users);

    Weather findByLatitudeAndLongitude(Float latitude, Float longitude);

}