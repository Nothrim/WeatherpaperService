package com.nothrim.json.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Author: Notrim
 * Created by: ModelGenerator on 08.05.2017
 */
public class CurrentObservation {
    private Image image;
    @JsonProperty("display_location")
    private DisplayLocation displayLocation;
    @JsonProperty("observation_location")
    private ObservationLocation observationLocation;
    private Estimated estimated;
    @JsonProperty("station_id")
    private String stationId;
    @JsonProperty("observation_time")
    private String observationTime;
    @JsonProperty("observation_time_rfc822")
    private String observationTimeRfc;
    @JsonProperty("observation_epoch")
    private String observationEpoch;
    @JsonProperty("local_time_rfc822")
    private String localTimeRfc;
    @JsonProperty("local_epoch")
    private String localEpoch;
    @JsonProperty("local_tz_short")
    private String localTzShort;
    @JsonProperty("local_tz_long")
    private String localTzLong;
    @JsonProperty("local_tz_offset")
    private String localTzOffset;
    private String weather;
    @JsonProperty("temperature_string")
    private String temperatureString;
    @JsonProperty("temp_f")
    private double tempF;
    @JsonProperty("temp_c")
    private double tempC;
    @JsonProperty("relative_humidity")
    private String relativeHumidity;
    @JsonProperty("wind_string")
    private String windString;
    @JsonProperty("wind_dir")
    private String windDir;
    @JsonProperty("wind degrees")
    private int windDegrees;
    @JsonProperty("wind_mph")
    private double windMph;
    @JsonProperty("wind_gust_mph")
    private String windGustMph;
    @JsonProperty("wind_kph")
    private double windKph;
    @JsonProperty("wind_gust_kph")
    private String windGustKph;
    @JsonProperty("pressure_mb")
    private String pressureMb;
    @JsonProperty("pressure_in")
    private String pressureIn;
    @JsonProperty("pressure_trend")
    private String pressureTrend;
    @JsonProperty("dewpoint_string")
    private String dewpointString;
    @JsonProperty("dewpoiont_f")
    private int dewpointF;
    @JsonProperty("dewpoint_c")
    private int dewpointC;
    @JsonProperty("heat_index_string")
    private String heatIndexString;
    @JsonProperty("heat_index_f")
    private String heatIndexF;
    @JsonProperty("heat_index_c")
    private String heatIndexC;
    @JsonProperty("windchill_string")
    private String windchillString;
    @JsonProperty("windchill_f")
    private String windchillF;
    @JsonProperty("windchill_c")
    private String windchillC;
    @JsonProperty("feelslike_string")
    private String feelslikeString;
    @JsonProperty("feelslike_f")
    private String feelslikeF;
    @JsonProperty("feelslike_c")
    private String feelslikeC;
    @JsonProperty("visibility_mi")
    private String visibilityMi;
    @JsonProperty("visibility_km")
    private String visibilityKm;
    private String solarradiation;
    private String UV;
    @JsonProperty("precip_hr_string")
    private String precipHrString;
    @JsonProperty("precip_hr_in")
    private String precipHrIn;
    @JsonProperty("precip_hr_metric")
    private String precipHrMetric;
    @JsonProperty("precip_today_string")
    private String precipTodayString;
    @JsonProperty("precip_today_in")
    private String precipTodayIn;
    @JsonProperty("precip_today_metric")
    private String precipTodayMetric;
    private String icon;
    @JsonProperty("icon_url")
    private String iconUrl;
    @JsonProperty("forecast_url")
    private String forecastUrl;
    @JsonProperty("history_url")
    private String historyUrl;
    @JsonProperty("ob_url")
    private String obUrl;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public DisplayLocation getDisplayLocation() {
        return displayLocation;
    }

    public void setDisplayLocation(DisplayLocation displayLocation) {
        this.displayLocation = displayLocation;
    }

    public ObservationLocation getObservationLocation() {
        return observationLocation;
    }

    public void setObservationLocation(ObservationLocation observationLocation) {
        this.observationLocation = observationLocation;
    }


    public Estimated getEstimated() {
        return estimated;
    }

    public void setEstimated(Estimated estimated) {
        this.estimated = estimated;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getObservationTime() {
        return observationTime;
    }

    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    public String getObservationTimeRfc() {
        return observationTimeRfc;
    }

    public void setObservationTimeRfc(String observationTimeRfc) {
        this.observationTimeRfc = observationTimeRfc;
    }

    public String getObservationEpoch() {
        return observationEpoch;
    }

    public void setObservationEpoch(String observationEpoch) {
        this.observationEpoch = observationEpoch;
    }

    public String getLocalTimeRfc() {
        return localTimeRfc;
    }

    public void setLocalTimeRfc(String localTimeRfc) {
        this.localTimeRfc = localTimeRfc;
    }

    public String getLocalEpoch() {
        return localEpoch;
    }

    public void setLocalEpoch(String localEpoch) {
        this.localEpoch = localEpoch;
    }

    public String getLocalTzShort() {
        return localTzShort;
    }

    public void setLocalTzShort(String localTzShort) {
        this.localTzShort = localTzShort;
    }

    public String getLocalTzLong() {
        return localTzLong;
    }

    public void setLocalTzLong(String localTzLong) {
        this.localTzLong = localTzLong;
    }

    public String getLocalTzOffset() {
        return localTzOffset;
    }

    public void setLocalTzOffset(String localTzOffset) {
        this.localTzOffset = localTzOffset;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemperatureString() {
        return temperatureString;
    }

    public void setTemperatureString(String temperatureString) {
        this.temperatureString = temperatureString;
    }

    public double getTempF() {
        return tempF;
    }

    public void setTempF(double tempF) {
        this.tempF = tempF;
    }

    public double getTempC() {
        return tempC;
    }

    public void setTempC(double tempC) {
        this.tempC = tempC;
    }

    public String getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(String relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public String getWindString() {
        return windString;
    }

    public void setWindString(String windString) {
        this.windString = windString;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public int getWindDegrees() {
        return windDegrees;
    }

    public void setWindDegrees(int windDegrees) {
        this.windDegrees = windDegrees;
    }

    public double getWindMph() {
        return windMph;
    }

    public void setWindMph(double windMph) {
        this.windMph = windMph;
    }

    public String getWindGustMph() {
        return windGustMph;
    }

    public void setWindGustMph(String windGustMph) {
        this.windGustMph = windGustMph;
    }

    public double getWindKph() {
        return windKph;
    }

    public void setWindKph(double windKph) {
        this.windKph = windKph;
    }

    public String getWindGustKph() {
        return windGustKph;
    }

    public void setWindGustKph(String windGustKph) {
        this.windGustKph = windGustKph;
    }

    public String getPressureMb() {
        return pressureMb;
    }

    public void setPressureMb(String pressureMb) {
        this.pressureMb = pressureMb;
    }

    public String getPressureIn() {
        return pressureIn;
    }

    public void setPressureIn(String pressureIn) {
        this.pressureIn = pressureIn;
    }

    public String getPressureTrend() {
        return pressureTrend;
    }

    public void setPressureTrend(String pressureTrend) {
        this.pressureTrend = pressureTrend;
    }

    public String getDewpointString() {
        return dewpointString;
    }

    public void setDewpointString(String dewpointString) {
        this.dewpointString = dewpointString;
    }

    public int getDewpointF() {
        return dewpointF;
    }

    public void setDewpointF(int dewpointF) {
        this.dewpointF = dewpointF;
    }

    public int getDewpointC() {
        return dewpointC;
    }

    public void setDewpointC(int dewpointC) {
        this.dewpointC = dewpointC;
    }

    public String getHeatIndexString() {
        return heatIndexString;
    }

    public void setHeatIndexString(String heatIndexString) {
        this.heatIndexString = heatIndexString;
    }

    public String getHeatIndexF() {
        return heatIndexF;
    }

    public void setHeatIndexF(String heatIndexF) {
        this.heatIndexF = heatIndexF;
    }

    public String getHeatIndexC() {
        return heatIndexC;
    }

    public void setHeatIndexC(String heatIndexC) {
        this.heatIndexC = heatIndexC;
    }

    public String getWindchillString() {
        return windchillString;
    }

    public void setWindchillString(String windchillString) {
        this.windchillString = windchillString;
    }

    public String getWindchillF() {
        return windchillF;
    }

    public void setWindchillF(String windchillF) {
        this.windchillF = windchillF;
    }

    public String getWindchillC() {
        return windchillC;
    }

    public void setWindchillC(String windchillC) {
        this.windchillC = windchillC;
    }

    public String getFeelslikeString() {
        return feelslikeString;
    }

    public void setFeelslikeString(String feelslikeString) {
        this.feelslikeString = feelslikeString;
    }

    public String getFeelslikeF() {
        return feelslikeF;
    }

    public void setFeelslikeF(String feelslikeF) {
        this.feelslikeF = feelslikeF;
    }

    public String getFeelslikeC() {
        return feelslikeC;
    }

    public void setFeelslikeC(String feelslikeC) {
        this.feelslikeC = feelslikeC;
    }

    public String getVisibilityMi() {
        return visibilityMi;
    }

    public void setVisibilityMi(String visibilityMi) {
        this.visibilityMi = visibilityMi;
    }

    public String getVisibilityKm() {
        return visibilityKm;
    }

    public void setVisibilityKm(String visibilityKm) {
        this.visibilityKm = visibilityKm;
    }

    public String getSolarradiation() {
        return solarradiation;
    }

    public void setSolarradiation(String solarradiation) {
        this.solarradiation = solarradiation;
    }

    public String getUV() {
        return UV;
    }

    public void setUV(String UV) {
        this.UV = UV;
    }

    public String getPrecipHrString() {
        return precipHrString;
    }

    public void setPrecipHrString(String precipHrString) {
        this.precipHrString = precipHrString;
    }

    public String getPrecipHrIn() {
        return precipHrIn;
    }

    public void setPrecipHrIn(String precipHrIn) {
        this.precipHrIn = precipHrIn;
    }

    public String getPrecipHrMetric() {
        return precipHrMetric;
    }

    public void setPrecipHrMetric(String precipHrMetric) {
        this.precipHrMetric = precipHrMetric;
    }

    public String getPrecipTodayString() {
        return precipTodayString;
    }

    public void setPrecipTodayString(String precipTodayString) {
        this.precipTodayString = precipTodayString;
    }

    public String getPrecipTodayIn() {
        return precipTodayIn;
    }

    public void setPrecipTodayIn(String precipTodayIn) {
        this.precipTodayIn = precipTodayIn;
    }

    public String getPrecipTodayMetric() {
        return precipTodayMetric;
    }

    public void setPrecipTodayMetric(String precipTodayMetric) {
        this.precipTodayMetric = precipTodayMetric;
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

    public String getForecastUrl() {
        return forecastUrl;
    }

    public void setForecastUrl(String forecastUrl) {
        this.forecastUrl = forecastUrl;
    }

    public String getHistoryUrl() {
        return historyUrl;
    }

    public void setHistoryUrl(String historyUrl) {
        this.historyUrl = historyUrl;
    }

    public String getObUrl() {
        return obUrl;
    }

    public void setObUrl(String obUrl) {
        this.obUrl = obUrl;
    }

    @Override
    public String toString() {
        return "CurrentObservation{" +
                "image=" + image +
                ", displayLocation=" + displayLocation +
                ", observationLocation=" + observationLocation +
                ", estimated='" + estimated + '\'' +
                ", stationId='" + stationId + '\'' +
                ", observationTime='" + observationTime + '\'' +
                ", observationTimeRfc='" + observationTimeRfc + '\'' +
                ", observationEpoch='" + observationEpoch + '\'' +
                ", localTimeRfc='" + localTimeRfc + '\'' +
                ", localEpoch='" + localEpoch + '\'' +
                ", localTzShort='" + localTzShort + '\'' +
                ", localTzLong='" + localTzLong + '\'' +
                ", localTzOffset='" + localTzOffset + '\'' +
                ", weather='" + weather + '\'' +
                ", temperatureString='" + temperatureString + '\'' +
                ", tempF=" + tempF +
                ", tempC=" + tempC +
                ", relativeHumidity='" + relativeHumidity + '\'' +
                ", windString='" + windString + '\'' +
                ", windDir='" + windDir + '\'' +
                ", windDegrees=" + windDegrees +
                ", windMph=" + windMph +
                ", windGustMph='" + windGustMph + '\'' +
                ", windKph=" + windKph +
                ", windGustKph='" + windGustKph + '\'' +
                ", pressureMb='" + pressureMb + '\'' +
                ", pressureIn='" + pressureIn + '\'' +
                ", pressureTrend='" + pressureTrend + '\'' +
                ", dewpointString='" + dewpointString + '\'' +
                ", dewpointF=" + dewpointF +
                ", dewpointC=" + dewpointC +
                ", heatIndexString='" + heatIndexString + '\'' +
                ", heatIndexF='" + heatIndexF + '\'' +
                ", heatIndexC='" + heatIndexC + '\'' +
                ", windchillString='" + windchillString + '\'' +
                ", windchillF='" + windchillF + '\'' +
                ", windchillC='" + windchillC + '\'' +
                ", feelslikeString='" + feelslikeString + '\'' +
                ", feelslikeF='" + feelslikeF + '\'' +
                ", feelslikeC='" + feelslikeC + '\'' +
                ", visibilityMi='" + visibilityMi + '\'' +
                ", visibilityKm='" + visibilityKm + '\'' +
                ", solarradiation='" + solarradiation + '\'' +
                ", UV='" + UV + '\'' +
                ", precipHrString='" + precipHrString + '\'' +
                ", precipHrIn='" + precipHrIn + '\'' +
                ", precipHrMetric='" + precipHrMetric + '\'' +
                ", precipTodayString='" + precipTodayString + '\'' +
                ", precipTodayIn='" + precipTodayIn + '\'' +
                ", precipTodayMetric='" + precipTodayMetric + '\'' +
                ", icon='" + icon + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", forecastUrl='" + forecastUrl + '\'' +
                ", historyUrl='" + historyUrl + '\'' +
                ", obUrl='" + obUrl + '\'' +
                '}';
    }
}