package com.nothrim.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Author: Notrim
 * Created by: ModelGenerator on 24.04.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Features {
    private int hourly;

    public int getHourly() {
        return hourly;
    }

    public void setHourly(int hourly) {
        this.hourly = hourly;
    }

    @Override
    public String toString() {
        return "Features{" +
                "hourly=" + hourly +
                '}';
    }
}