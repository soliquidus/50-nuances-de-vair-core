package dev.config.bach.task;

import dev.dto.CityDto;
import dev.service.CityService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@PropertySource("classpath:application-api.properties")
public class CityTask {

    @Value("${request.cities-geo-gouv}")
    private String urlCities;
    private final CityService cityService;

    public CityTask(CityService cityService) {
        this.cityService = cityService;
    }
    /* /!\ Task programming after departmentTask */
    public void run(RestTemplate restTemplate, Integer codeDept){
        String url = String.format(urlCities,codeDept);
        CityDto[] cityDto = restTemplate.getForObject(url, CityDto[].class);
        assert cityDto != null;
        this.cityService.createCities(List.of(cityDto));
    }
}
