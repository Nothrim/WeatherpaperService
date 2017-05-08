package com.nothrim.json.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Author: Notrim
 * Created by: ModelGenerator on 08.05.2017
 */
public class Weather {
    private Response response;
    @JsonProperty("current_observation")
    private CurrentObservation currentObservation;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public CurrentObservation getCurrentObservation() {
        return currentObservation;
    }

    public void setCurrentObservation(CurrentObservation currentObservation) {
        this.currentObservation = currentObservation;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "response=" + response +
                ", currentObservation=" + currentObservation +
                '}';
    }
}