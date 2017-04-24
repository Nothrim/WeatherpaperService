package com.nothrim.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Author: Notrim
 * Created by: ModelGenerator on 24.04.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Heatindex {
    private String english;
    private String metric;

    public String getEnglish() {
        return english;
    }

    @Override
    public String toString() {
        return "Heatindex{" +
                "english='" + english + '\'' +
                ", metric='" + metric + '\'' +
                '}';
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }
}