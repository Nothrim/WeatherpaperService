package com.nothrim.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Author: Notrim
 * Created by: ModelGenerator on 24.04.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HourlyForecastItem {
    @JsonProperty("FCTTIME")
    private FCTTIME FCTTIME;
    private Temp temp;
    private Dewpoint dewpoint;
    private String condition;
    private String icon;
    @JsonProperty("icon_url")
    private String iconUrl;
    private String fctcode;
    private String sky;
    private Wspd wspd;
    private Wdir wdir;
    private String wx;
    private String uvi;
    private String humidity;
    private Windchill windchill;
    private Heatindex heatindex;
    private Feelslike feelslike;
    private Qpf qpf;
    private Snow snow;
    private String pop;
    private Mslp mslp;

    public com.nothrim.json.FCTTIME getFCTTIME() {
        return FCTTIME;
    }

    public void setFCTTIME(com.nothrim.json.FCTTIME FCTTIME) {
        this.FCTTIME = FCTTIME;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public Dewpoint getDewpoint() {
        return dewpoint;
    }

    public void setDewpoint(Dewpoint dewpoint) {
        this.dewpoint = dewpoint;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getFctcode() {
        return fctcode;
    }

    public void setFctcode(String fctcode) {
        this.fctcode = fctcode;
    }

    public String getSky() {
        return sky;
    }

    public void setSky(String sky) {
        this.sky = sky;
    }

    public Wspd getWspd() {
        return wspd;
    }

    public void setWspd(Wspd wspd) {
        this.wspd = wspd;
    }

    public Wdir getWdir() {
        return wdir;
    }

    public void setWdir(Wdir wdir) {
        this.wdir = wdir;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public String getUvi() {
        return uvi;
    }

    public void setUvi(String uvi) {
        this.uvi = uvi;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public Windchill getWindchill() {
        return windchill;
    }

    public void setWindchill(Windchill windchill) {
        this.windchill = windchill;
    }

    public Heatindex getHeatindex() {
        return heatindex;
    }

    public void setHeatindex(Heatindex heatindex) {
        this.heatindex = heatindex;
    }

    public Feelslike getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(Feelslike feelslike) {
        this.feelslike = feelslike;
    }

    public Qpf getQpf() {
        return qpf;
    }

    public void setQpf(Qpf qpf) {
        this.qpf = qpf;
    }

    public Snow getSnow() {
        return snow;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public Mslp getMslp() {
        return mslp;
    }

    @Override
    public String toString() {
        return "HourlyForecastItem{" +
                "FCTTIME=" + FCTTIME +
                ", temp=" + temp +
                ", dewpoint=" + dewpoint +
                ", condition='" + condition + '\'' +
                ", icon='" + icon + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", fctcode='" + fctcode + '\'' +
                ", sky='" + sky + '\'' +
                ", wspd=" + wspd +
                ", wdir=" + wdir +
                ", wx='" + wx + '\'' +
                ", uvi='" + uvi + '\'' +
                ", humidity='" + humidity + '\'' +
                ", windchill=" + windchill +
                ", heatindex=" + heatindex +
                ", feelslike=" + feelslike +
                ", qpf=" + qpf +
                ", snow=" + snow +
                ", pop='" + pop + '\'' +
                ", mslp=" + mslp +
                '}';
    }

    public void setMslp(Mslp mslp) {
        this.mslp = mslp;
    }
}