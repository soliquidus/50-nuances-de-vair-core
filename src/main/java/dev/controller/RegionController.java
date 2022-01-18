package dev.controller;

import dev.dto.RegionDto;
import dev.service.RegionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("regions")
public class RegionController {

    private RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("api-test")
    public List<Object> apiTest() {
        String url = "https://geo.api.gouv.fr/regions";
        RestTemplate restTemplate = new RestTemplate();
        Object[] regions = restTemplate.getForObject(url, Object[].class);
        assert regions != null;
        return Arrays.asList(regions);
    }

    @PostMapping("/save")
    public void addRegions() {
        String url = "https://geo.api.gouv.fr/regions";
        RestTemplate restTemplate = new RestTemplate();

        RegionDto[] regionsDto = restTemplate.getForObject(url, RegionDto[].class);
        assert regionsDto != null;
        this.regionService.createRegions(Arrays.asList(regionsDto));
    }
}
