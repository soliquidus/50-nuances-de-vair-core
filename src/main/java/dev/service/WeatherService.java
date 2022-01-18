package dev.service;

import dev.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application-api.properties")
public class WeatherService {

    @Value("${key.api-open-weather}")
    private String apiKey;

    private final WeatherRepository repository;

    public WeatherService(WeatherRepository repository) {
        this.repository = repository;
    }

}
