package dev.controller;

import dev.dto.CityDto;
import dev.dto.CityGeocode;
import dev.service.CityService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("cities")
public class CityController {

    private final CityService cityService;

    @Value("${key.api-open-weather}")
    private String apiKey;
    @Value("${get.cities}")
    private String url;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/test")
    public CityGeocode test() {
        String url = "http://api.openweathermap.org/geo/1.0/zip?zip=85530,FR&appid=" + apiKey;
        RestTemplate test = new RestTemplate();

        CityGeocode city = test.getForObject(url, CityGeocode.class);
        assert city != null;
        return city;
    }

    @Transactional
    @PostMapping("/save")
    public void addCities() {
        RestTemplate restTemplate = new RestTemplate();

        CityDto[] cityDtos = restTemplate.getForObject(url, CityDto[].class);

        assert cityDtos != null;
        this.cityService.createCities(List.of(cityDtos));
    }
}

