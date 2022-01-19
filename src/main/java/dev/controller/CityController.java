package dev.controller;

import dev.dto.CityDto;
import dev.service.CityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/save")
    public void addCities() {
        String url = "https://geo.api.gouv.fr/departements/11/communes";
        RestTemplate restTemplate = new RestTemplate();
        CityDto[] cityDto = restTemplate.getForObject(url, CityDto[].class);
        assert cityDto != null;
        this.cityService.createCities(List.of(cityDto));
    }
}
