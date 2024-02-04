package com.ivanchin.seetheweather.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${openweathermap.api-key}")  // Correct key name from application.properties/yml
    private String apiKey;

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getWeatherData(String city) {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather";
        String url = apiUrl + "?q=" + city + "&appid=" + apiKey;
        return restTemplate.getForObject(url, String.class);
    }
}
