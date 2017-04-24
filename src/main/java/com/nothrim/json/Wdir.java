package com.nothrim.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Author: Notrim
 * Created by: ModelGenerator on 24.04.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wdir {
    private String dir;
    private String degrees;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getDegrees() {
        return degrees;
    }

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    @Override
    public String toString() {
        return "Wdir{" +
                "dir='" + dir + '\'' +
                ", degrees='" + degrees + '\'' +
                '}';
    }
}