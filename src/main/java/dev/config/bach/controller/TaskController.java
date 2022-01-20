package dev.config.bach.controller;


import dev.config.bach.task.*;
import dev.entity.City;
import dev.entity.Pollution;
import dev.entity.Weather;
import dev.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class TaskController {

    private PollutionTask pollutionTask;
    private WeatherTask weatherTask;
    private RestTemplate restTemplate;
    private RegionTask regionTask;
    private DepartmentTask departmentTask;
    private CityTask cityTask;
    private CityLocalizedTask cityLocalizedTask;
    private CityRepository cityRepository;

    public Pollution pollutionTaskController(City city) throws HttpClientErrorException {
        return this.pollutionTask.run(restTemplate, city);
    }

    public Weather weatherTaskControler(City city) throws HttpClientErrorException {
        return this.weatherTask.run(restTemplate, city);
    }

    public void regionTaskController() throws HttpClientErrorException {
        regionTask.run(restTemplate);
    }

    public void departmentTaskController() throws HttpClientErrorException {
        departmentTask.run(restTemplate);
    }

    public void cityTaskController() throws HttpClientErrorException {
        cityTask.run(restTemplate);
    }

    public City cityLocalizeTaskController(City city) throws HttpClientErrorException {
        return cityLocalizedTask.run(restTemplate, city);
    }

    public void citySaveByTaskController(City city) {
        cityRepository.save(city);
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }


    @Autowired
    public void setPollutionTask(PollutionTask pollutionTask) {
        this.pollutionTask = pollutionTask;
    }

    @Autowired
    public void setWeatherTask(WeatherTask weatherTask) {
        this.weatherTask = weatherTask;
    }

    @Autowired
    public void setRegionTask(RegionTask regionTask) {
        this.regionTask = regionTask;
    }

    @Autowired
    public void setDepartmentTask(DepartmentTask departmentTask) {
        this.departmentTask = departmentTask;
    }

    @Autowired
    public void setCityTask(CityTask cityTask) {
        this.cityTask = cityTask;
    }

    @Autowired
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Autowired
    public void setCityLocalizedTask(CityLocalizedTask cityLocalizedTask) {
        this.cityLocalizedTask = cityLocalizedTask;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}
