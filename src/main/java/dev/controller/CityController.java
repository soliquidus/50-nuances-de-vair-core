package dev.controller;

import dev.dto.CityDto;
import dev.dto.api.CityJson;
import dev.dto.api.FeaturesJson;
import dev.dto.api.GeometryJson;
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

    @Value("${get.cities}")
    private String url;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/test")
    public GeometryJson test() {
        String url = "https://api-adresse.data.gouv.fr/search/?q=nantes&postcode=44000&limit=1";
        RestTemplate test = new RestTemplate();

        CityJson json = test.getForObject(url, CityJson.class);
        FeaturesJson features = json.getFeatures()[0];
        GeometryJson geometry = features.getGeometry();

        return geometry;
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

