package com.ivanchin.seetheweather.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ivanchin.seetheweather.model.WeatherData;

@Service
public class WeatherService {
    @Value("${openweathermap.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getWeatherData(String city) {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather";
        String url = apiUrl + "?q=" + city + "&appid=" + apiKey;

        WeatherData weatherData = restTemplate.getForObject(url, WeatherData.class);

        if (weatherData != null && weatherData.getMain() != null) {
            double temperatureInCelsius = weatherData.getMain().getTemp() - 273.15;
            weatherData.getMain().setTempCelsius(temperatureInCelsius);
        }

        return weatherData != null ? weatherData.toString() : null;
    }
}
