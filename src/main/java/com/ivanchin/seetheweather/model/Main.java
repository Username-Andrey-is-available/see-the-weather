package com.ivanchin.seetheweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {

    private double temp;
    private double tempCelsius;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTempCelsius() {
        return tempCelsius;
    }

    public void setTempCelsius(double tempCelsius) {
        this.tempCelsius = Math.ceil(tempCelsius * Math.pow(10, 3)) / Math.pow(10, 3);
    }

    @Override
    public String toString() {
        return "Main{" +
                "temp=" + temp +
                ", tempCelsius=" + tempCelsius +
                '}';
    }
}
