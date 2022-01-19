package dev.controller;

import dev.dto.RegionDto;
import dev.service.RegionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("regions")
public class RegionController {

    private RegionService regionService;
    @Value("${get.regions}")
    private String url;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("api-test")
    public List<Object> apiTest() {
        RestTemplate restTemplate = new RestTemplate();
        Object[] regions = restTemplate.getForObject(url, Object[].class);
        assert regions != null;
        return List.of(regions);
    }

    @PostMapping("/save")
    public void addRegions() {
        RestTemplate restTemplate = new RestTemplate();

        RegionDto[] regionsDto = restTemplate.getForObject(url, RegionDto[].class);
        assert regionsDto != null;
        this.regionService.createRegions(List.of(regionsDto));
    }
}
