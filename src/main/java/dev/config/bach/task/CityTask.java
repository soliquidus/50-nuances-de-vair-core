package dev.config.bach.task;

import dev.dto.CityDto;
import dev.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@PropertySource("classpath:application-api.properties")
public class CityTask {
private Logger LOGGER = LoggerFactory.getLogger(CityTask.class);
    @Value("${request.cities-geo-gouv}")
    private String urlCities;
    @Value("${state.department-geo.gouv}")
    private List<String> specialDeptpartmentCode;

    private final CityService cityService;

    public CityTask(CityService cityService) {
        this.cityService = cityService;
    }

    /* /!\ Task programming after DepartmentTask */
    @Transactional
    public void run(RestTemplate restTemplate) {
        List<String> codeDept = createListDepartment();
        codeDept.addAll(specialDeptpartmentCode);
        long start = System.currentTimeMillis();
        codeDept.forEach(code -> {
            String url = String.format(urlCities, code);
            try{
                CityDto[] cityDto = restTemplate.getForObject(url, CityDto[].class);
                assert cityDto != null;
                this.cityService.createCities(List.of(cityDto));
            }catch (HttpClientErrorException e){
                LOGGER.info(url);
            }
        });
        long end = System.currentTimeMillis();
        LOGGER.info(" Temps exécution : {}",(end-start)/1000);
    }

    private List<String> createListDepartment() {
        AtomicInteger index = new AtomicInteger(1);
        return Stream.of(new Integer[95])
                .map(c -> index.getAndIncrement())
                .filter(i->i!=20)
                .map(String::valueOf)
                .map(str->str.length()==1?"0"+str:str)
                .collect(Collectors.toList());
    }
}
