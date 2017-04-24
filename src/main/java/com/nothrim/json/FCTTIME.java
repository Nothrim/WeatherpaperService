package com.nothrim.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Author: Notrim
 * Created by: ModelGenerator on 24.04.2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FCTTIME {
    private String hour;
    @JsonProperty("hour_padded")
    private String hourPadded;
    private String min;
    @JsonProperty("min_unpadded")
    private String minUnpadded;
    private String sec;
    private String year;
    private String mon;

    @Override
    public String toString() {
        return "FCTTIME{" +
                "hour='" + hour + '\'' +
                ", hourPadded='" + hourPadded + '\'' +
                ", min='" + min + '\'' +
                ", minUnpadded='" + minUnpadded + '\'' +
                ", sec='" + sec + '\'' +
                ", year='" + year + '\'' +
                ", mon='" + mon + '\'' +
                ", monPadded='" + monPadded + '\'' +
                ", monAbbrev='" + monAbbrev + '\'' +
                ", mday='" + mday + '\'' +
                ", mdayPadded='" + mdayPadded + '\'' +
                ", yday='" + yday + '\'' +
                ", isdst='" + isdst + '\'' +
                ", epoch='" + epoch + '\'' +
                ", pretty='" + pretty + '\'' +
                ", civil='" + civil + '\'' +
                ", monthName='" + monthName + '\'' +
                ", monthNameAbbrev='" + monthNameAbbrev + '\'' +
                ", weekdayName='" + weekdayName + '\'' +
                ", weekdayNameNight='" + weekdayNameNight + '\'' +
                ", weekdayNameAbbrev='" + weekdayNameAbbrev + '\'' +
                ", weekdayNameUnlang='" + weekdayNameUnlang + '\'' +
                ", weekdayNameNightUnlang='" + weekdayNameNightUnlang + '\'' +
                ", ampm='" + ampm + '\'' +
                ", tz='" + tz + '\'' +
                ", age='" + age + '\'' +
                ", UTCDATE='" + UTCDATE + '\'' +
                '}';
    }

    @JsonProperty("mon_padded")
    private String monPadded;
    @JsonProperty("mon_abbrev")
    private String monAbbrev;
    private String mday;
    @JsonProperty("mday_padded")
    private String mdayPadded;
    private String yday;
    private String isdst;
    private String epoch;
    private String pretty;
    private String civil;
    @JsonProperty("month_name")
    private String monthName;
    @JsonProperty("month_name_abbrev")
    private String monthNameAbbrev;
    @JsonProperty("weekday_name")
    private String weekdayName;
    @JsonProperty("weekday_name_night")
    private String weekdayNameNight;
    @JsonProperty("weekday_name_abbrev")
    private String weekdayNameAbbrev;
    @JsonProperty("weekday_name_unlang")
    private String weekdayNameUnlang;
    @JsonProperty("weekday_name_night_unlang")
    private String weekdayNameNightUnlang;
    private String ampm;
    private String tz;
    private String age;
    @JsonProperty("UTCDATE")
    private String UTCDATE;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getHourPadded() {
        return hourPadded;
    }

    public void setHourPadded(String hourPadded) {
        this.hourPadded = hourPadded;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMinUnpadded() {
        return minUnpadded;
    }

    public void setMinUnpadded(String minUnpadded) {
        this.minUnpadded = minUnpadded;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getMonPadded() {
        return monPadded;
    }

    public void setMonPadded(String monPadded) {
        this.monPadded = monPadded;
    }

    public String getMonAbbrev() {
        return monAbbrev;
    }

    public void setMonAbbrev(String monAbbrev) {
        this.monAbbrev = monAbbrev;
    }

    public String getMday() {
        return mday;
    }

    public void setMday(String mday) {
        this.mday = mday;
    }

    public String getMdayPadded() {
        return mdayPadded;
    }

    public void setMdayPadded(String mdayPadded) {
        this.mdayPadded = mdayPadded;
    }

    public String getYday() {
        return yday;
    }

    public void setYday(String yday) {
        this.yday = yday;
    }

    public String getIsdst() {
        return isdst;
    }

    public void setIsdst(String isdst) {
        this.isdst = isdst;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public String getPretty() {
        return pretty;
    }

    public void setPretty(String pretty) {
        this.pretty = pretty;
    }

    public String getCivil() {
        return civil;
    }

    public void setCivil(String civil) {
        this.civil = civil;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public String getMonthNameAbbrev() {
        return monthNameAbbrev;
    }

    public void setMonthNameAbbrev(String monthNameAbbrev) {
        this.monthNameAbbrev = monthNameAbbrev;
    }

    public String getWeekdayName() {
        return weekdayName;
    }

    public void setWeekdayName(String weekdayName) {
        this.weekdayName = weekdayName;
    }

    public String getWeekdayNameNight() {
        return weekdayNameNight;
    }

    public void setWeekdayNameNight(String weekdayNameNight) {
        this.weekdayNameNight = weekdayNameNight;
    }

    public String getWeekdayNameAbbrev() {
        return weekdayNameAbbrev;
    }

    public void setWeekdayNameAbbrev(String weekdayNameAbbrev) {
        this.weekdayNameAbbrev = weekdayNameAbbrev;
    }

    public String getWeekdayNameUnlang() {
        return weekdayNameUnlang;
    }

    public void setWeekdayNameUnlang(String weekdayNameUnlang) {
        this.weekdayNameUnlang = weekdayNameUnlang;
    }

    public String getWeekdayNameNightUnlang() {
        return weekdayNameNightUnlang;
    }

    public void setWeekdayNameNightUnlang(String weekdayNameNightUnlang) {
        this.weekdayNameNightUnlang = weekdayNameNightUnlang;
    }

    public String getAmpm() {
        return ampm;
    }

    public void setAmpm(String ampm) {
        this.ampm = ampm;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUTCDATE() {
        return UTCDATE;
    }

    public void setUTCDATE(String UTCDATE) {
        this.UTCDATE = UTCDATE;
    }
}