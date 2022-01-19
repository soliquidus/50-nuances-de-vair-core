package dev.config.bach.controller;

import dev.config.bach.task.CensusTask;
import dev.config.bach.task.PollutionTask;
import dev.config.bach.task.WeatherTask;
import dev.entity.City;
import dev.entity.Pollution;
import dev.entity.Weather;
import dev.repository.CityRepository;
import dev.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class TaskController {

    private final CensusTask censusTask;
    private final WeatherTask weatherTask;
    private final PollutionTask pollutionTask;
    private final RestTemplate restTemplate;
    private final CityService cityService;
    private final CityRepository cityRepository;

    public TaskController(CensusTask censusTask, WeatherTask weatherTask, PollutionTask pollutionTask, RestTemplate restTemplate,CityService cityService,CityRepository cityRepository) {
        this.censusTask = censusTask;
        this.weatherTask = weatherTask;
        this.pollutionTask = pollutionTask;
        this.restTemplate = restTemplate;
        this.cityService=cityService;
        this.cityRepository=cityRepository;
    }

    public Pollution pollutionTaskController(City city) {
        return this.pollutionTask.run(restTemplate, city);
    }
    public Weather weatherTaskControler(City city){
        return this.weatherTask.run(restTemplate,city);
    }
    public List<City> getAllCities(){
        return cityRepository.findAll();
    }
}
