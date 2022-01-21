package dev.config.bach.task;

import dev.dto.RegionDto;
import dev.service.RegionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


import javax.transaction.Transactional;
import java.util.List;

@Service
@PropertySource("classpath:application-api.properties")
public class RegionTask implements Itask{
    @Value("${request.region-geo-gouv}")
    private String urlRegion;

    private final RegionService regionService;


    public RegionTask(RegionService regionService) {
        this.regionService = regionService;
    }

    /* /!\ fisrt request before DepartmentTask and CityTask*/
    @Override
    @Transactional
    public void run(RestTemplate restTemplate )throws HttpClientErrorException {
        RegionDto[] regionsDto = restTemplate.getForObject(urlRegion, RegionDto[].class);
        assert regionsDto != null;
        regionService.createRegions(List.of(regionsDto));
    }
}
