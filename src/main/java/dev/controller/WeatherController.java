package dev.controller;

import dev.entity.Pollution;
import dev.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("weather")
public class WeatherController {

//    private final WeatherService service;
//
//    public WeatherController(WeatherService service) {
//        this.service = service;
//    }
//
//    /**
//     *  Current Weather data
//     */
//    @GetMapping("current")
//    public Pollution getCurrentWeather(@RequestParam Long lat, Long lon ){
//        return service.getCurrentWeather(lat, lon);
//    }
//
//    /**
//     *  Current Weather data  by city
//     */
//    @GetMapping("current")
//    public Pollution getCurrentWeatherByCity(@RequestParam String cityName ){
//        return service.getCurrentWeatherByCity(cityName);
//    }
//
//    /**
//     *  Forecast Weather data
//     */
//    @GetMapping("forecast")
//    public List<Pollution> getForecastWeather(@RequestParam Long lat, Long lon , LocalDate startDate, LocalDate endDate){
//        return service.getForecastWeather(lat, lon, startDate, endDate);
//    }
//    /**
//     *  Forecast Weather data by city
//     */
//    @GetMapping("forecast")
//    public List<Pollution> getForecastAirPollutionByCity(@RequestParam String cityName , LocalDate startDate,LocalDate endDate){
//        return service.getForecastWeatherByCity(cityName,startDate,endDate);
//    }
}
