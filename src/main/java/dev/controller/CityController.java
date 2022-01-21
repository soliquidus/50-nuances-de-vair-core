package dev.controller;

import dev.dto.CityDto;
import dev.dto.api.CityJson;
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

    @Value("${get.cities.for.test}")
    private String url;

    @GetMapping("/test")
    public CityJson test(RestTemplate restTemplate) {
        String url = "https://api-adresse.data.gouv.fr/search/?q=Nantes&postcode=44000&limit=1";

        CityJson cityJson = restTemplate.getForObject(url, CityJson.class);
        return cityJson;
    }

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/save")
    public void addCities() {
        RestTemplate restTemplate = new RestTemplate();

        CityDto[] cityDtos = restTemplate.getForObject(url, CityDto[].class);

        assert cityDtos != null;
        this.cityService.createCities(List.of(cityDtos));
    }

    @Transactional
    @PostMapping("/geo")
    public void addGeoData() {
        this.cityService.getGeoData();
    }
}

