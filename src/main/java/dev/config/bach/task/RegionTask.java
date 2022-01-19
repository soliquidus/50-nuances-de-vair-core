package dev.config.bach.task;

import dev.dto.RegionDto;
import dev.entity.Region;
import dev.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@PropertySource("classpath:application-api.properties")
public class RegionTask {
    @Value("${request.region-geo-gouv}")
    private String urlRegion;

    private final RegionRepository regionRepository;


    public RegionTask(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    /* /!\ fisrt request before DepartmentTask and CityTask*/
    public void run(RestTemplate restTemplate ){
        RegionDto[] regionsDto = restTemplate.getForObject(urlRegion, RegionDto[].class);
        assert regionsDto != null;
        regionRepository.saveAll(Stream.of(regionsDto).map(Region::new).collect(Collectors.toList()));
    }
}
