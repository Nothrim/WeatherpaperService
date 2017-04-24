package com.nothrim.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Author: Notrim
 * Created by: ModelGenerator on 24.04.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feelslike {
    private String english;
    private String metric;

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return "Feelslike{" +
                "english='" + english + '\'' +
                ", metric='" + metric + '\'' +
                '}';
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }
}