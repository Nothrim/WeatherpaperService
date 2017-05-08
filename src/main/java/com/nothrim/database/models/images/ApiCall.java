package com.nothrim.database.models.images;

import com.nothrim.database.models.weather.Weather;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Created by Notrim on 25.04.2017.
 */
@Entity
@Table(name = "api_call")
public class ApiCall {
    private String call;
    private long count;
    private Date lastCall;
    private Set<Image> images;
    private Set<Weather> weather;


    @Column(nullable = false)
    @Id
    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }


    public Date getLastCall() {
        return lastCall;
    }

    public void setLastCall(Date lastCall) {
        this.lastCall = lastCall;
    }

    @OneToMany(mappedBy = "apiCall", cascade = CascadeType.ALL)
    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    @OneToMany(mappedBy = "apiCall", cascade = CascadeType.ALL)
    public Set<Weather> getWeather() {
        return weather;
    }

    public void setWeather(Set<Weather> weather) {
        this.weather = weather;
    }
}
