package dev.config.bach.controller;

import dev.config.bach.task.CensusTask;
import dev.config.bach.task.PollutionTask;
import dev.config.bach.task.RegionTask;
import dev.config.bach.task.WeatherTask;
import dev.entity.City;
import dev.entity.Pollution;
import dev.entity.Weather;
import dev.repository.CityRepository;
import dev.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class TaskController {

    private CensusTask censusTask;
    private WeatherTask weatherTask;
    private PollutionTask pollutionTask;
    private RestTemplate restTemplate;
    private RegionTask regionTask;
    private CityRepository cityRepository;

//    public TaskController(CensusTask censusTask, WeatherTask weatherTask, PollutionTask pollutionTask, RestTemplate restTemplate,CityService cityService,CityRepository cityRepository) {
//        this.censusTask = censusTask;
//        this.weatherTask = weatherTask;
//        this.pollutionTask = pollutionTask;
//        this.restTemplate = restTemplate;
//        this.cityRepository=cityRepository;
//    }

    public Pollution pollutionTaskController(City city) {
        return this.pollutionTask.run(restTemplate, city);
    }

    public Weather weatherTaskControler(City city) {
        return this.weatherTask.run(restTemplate, city);
    }

    public void cityTaskController() {

    }
    public void regionTaskController(){
        regionTask.run(restTemplate);
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Autowired
    public void setCensusTask(CensusTask censusTask) {
        this.censusTask = censusTask;
    }
    @Autowired
    public void setWeatherTask(WeatherTask weatherTask) {
        this.weatherTask = weatherTask;
    }
    @Autowired
    public void setPollutionTask(PollutionTask pollutionTask) {
        this.pollutionTask = pollutionTask;
    }
    @Autowired
    public void setRegionTask(RegionTask regionTask) {
        this.regionTask = regionTask;
    }
    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Autowired
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
}
