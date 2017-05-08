package com.nothrim.json.weather;

/**
 * Author: Notrim
 * Created by: ModelGenerator on 08.05.2017
 */
public class Response {
    private String version;
    private String termsofService;
    private Features features;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTermsofService() {
        return termsofService;
    }

    public void setTermsofService(String termsofService) {
        this.termsofService = termsofService;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "Response{" +
                "version='" + version + '\'' +
                ", termsofService='" + termsofService + '\'' +
                ", features=" + features +
                '}';
    }
}