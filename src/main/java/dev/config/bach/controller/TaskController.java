package dev.config.bach.controller;


import dev.config.bach.task.CityTask;
import dev.config.bach.task.DepartmentTask;
import dev.config.bach.task.RegionTask;
import dev.config.bach.task.WeatherTask;
import dev.entity.City;
import dev.entity.Weather;
import dev.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class TaskController {

    //    private CensusTask censusTask;
//    private PollutionTask pollutionTask;
    private WeatherTask weatherTask;
    private RestTemplate restTemplate;
    private RegionTask regionTask;
    private DepartmentTask departmentTask;
    private CityTask cityTask;
    private CityRepository cityRepository;


    public Weather weatherTaskControler(City city) {
        return this.weatherTask.run(restTemplate, city);
    }

    public void regionTaskController() {
        regionTask.run(restTemplate);
    }

    public void departmentTaskController() {
        departmentTask.run(restTemplate);
    }

    public void cityTaskController() {
        cityTask.run(restTemplate);
    }
    public void citySaveByTaskController(City city){
        cityRepository.save(city);
    }
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    //    @Autowired
//    public void setCensusTask(CensusTask censusTask) {
//        this.censusTask = censusTask;
//    }
//    @Autowired
//    public void setPollutionTask(PollutionTask pollutionTask) {
//        this.pollutionTask = pollutionTask;
//    }
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
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Autowired
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
}
