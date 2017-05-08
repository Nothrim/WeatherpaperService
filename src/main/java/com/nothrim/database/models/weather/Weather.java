package com.nothrim.database.models.weather;

import com.nothrim.database.models.images.ApiCall;
import com.nothrim.database.models.security.User;
import com.nothrim.json.weather.CurrentObservation;
import com.nothrim.json.weather.DisplayLocation;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Notrim on 24.04.2017.
 */

@Entity
@Table(name = "weather")
public class Weather {
    private Long id;
    private String city;
    private String status;
    private Set<User> users;
    private ApiCall apiCall;
    private float latitude;
    private float longitude;
    private Date lastCall;
    private String relativeHumidity;
    private String temperature;
    private String windGustKph;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @OneToMany(mappedBy = "weather", cascade = CascadeType.ALL)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @ManyToOne
    @JoinColumn(name = "call")
    public ApiCall getApiCall() {
        return apiCall;
    }

    public void setApiCall(ApiCall apiCalls) {
        this.apiCall = apiCalls;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Date getLastCall() {
        return lastCall;
    }

    public void setLastCall(Date lastCall) {
        this.lastCall = lastCall;
    }

    public String getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(String relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public String getWindGustKph() {
        return windGustKph;
    }

    public void setWindGustKph(String windGustKph) {
        this.windGustKph = windGustKph;
    }

    @Transient
    public void mapJSON(CurrentObservation observation) {
        setTemperature(observation.getFeelslikeC());
        setWindGustKph(observation.getWindGustKph());
        setRelativeHumidity(observation.getRelativeHumidity());

        if (observation.getDisplayLocation() != null) {
            setCity(observation.getDisplayLocation().getCity());
            if (observation.getDisplayLocation().getLatitude() != null)
                setLatitude(Float.parseFloat(observation.getDisplayLocation().getLatitude()));
            if (observation.getDisplayLocation().getLongitude() != null)
                setLongitude(Float.parseFloat(observation.getDisplayLocation().getLongitude()));
        }
    }

    @Transient
    public CurrentObservation getJSON() {
        CurrentObservation observation = new CurrentObservation();
        observation.setFeelslikeC(getTemperature());
        observation.setWindGustKph(getWindGustKph());
        observation.setRelativeHumidity(getRelativeHumidity());
        DisplayLocation displayLocation = new DisplayLocation();
        displayLocation.setCity(getCity());
        displayLocation.setLatitude(Float.toString(getLatitude()));
        displayLocation.setLatitude(Float.toString(getLongitude()));
        observation.setDisplayLocation(displayLocation);
        return observation;
    }
}