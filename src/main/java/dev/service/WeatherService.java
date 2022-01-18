package dev.service;

import dev.entity.Pollution;
import dev.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@PropertySource("classpath:application-api.properties")
public class WeatherService {

    @Value("${key.api-open-weather}")
    private String apiKey;

    private final WeatherRepository repository;

    public WeatherService(WeatherRepository repository) {
        this.repository = repository;
    }

    public Pollution getCurrentWeather(Long lat, Long lon){
        String cityName =null; // service City => ask city via lat lon return cityName
        return null;
    }

    /**
     * search for weather using the name of the city
     * @param cityName
     * @return
     */
    public Pollution getCurrentWeatherByCity(String cityName){
        return null;
    }

    /**
     * search for the city then the weather between two dates
     * @param lat
     * @param lon
     * @param startDate
     * @param endDate
     * @return
     */
    public List<Pollution> getForecastWeather(Long lat, Long lon, LocalDate startDate, LocalDate endDate){
        String cityName =null; // service City => ask city via lat lon return cityName
        return null;
    }

    /**
     * search for weather using the name of the city then the between two dates
     * @param cityName
     * @param startDate
     * @param endDate
     * @return
     */
    public List<Pollution> getForecastWeatherByCity(String cityName, LocalDate startDate,LocalDate endDate){
        return null;
    }
}
