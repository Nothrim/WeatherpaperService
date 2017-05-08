package com.nothrim.json.weather;

/**
 * Author: Notrim
 * Created by: ModelGenerator on 08.05.2017
 */
public class Features {
    private int conditions;

    public int getConditions() {
        return conditions;
    }

    public void setConditions(int conditions) {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        return "Features{" +
                "conditions=" + conditions +
                '}';
    }
}