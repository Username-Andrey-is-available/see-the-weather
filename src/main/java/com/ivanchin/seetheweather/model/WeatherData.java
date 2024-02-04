package com.ivanchin.seetheweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {

    private final Main main;

    public WeatherData() {
        this.main = new Main();
    }

    public Main getMain() {
        return main;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "main=" + main +
                '}';
    }
}
