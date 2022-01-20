package dev.config.bach.task;

import dev.dto.CityDto;
import dev.service.CityService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@PropertySource("classpath:application-api.properties")
public class CityTask {

    @Value("${request.cities-geo-gouv}")
    private String urlCities;
    @Value(("${state.department-geo.gouv}"))
    private List<String> specialDeptpartmentCode;

    private final CityService cityService;

    public CityTask(CityService cityService) {
        this.cityService = cityService;
    }
    /* /!\ Task programming after DepartmentTask */
    public void run(RestTemplate restTemplate) {
        /* codeDept is a list of departments */
        List<String> codeDept = createListDepartment();
        codeDept.addAll(specialDeptpartmentCode);

        codeDept.forEach(code -> {
            /* timer to regulate the flow */
            new Timer().schedule(
                    new CityWebClient(restTemplate, cityService, code)
                    , 10000, 10000);
        });

    }
    /* create the list of departments */
    private List<String> createListDepartment() {
        AtomicInteger index = new AtomicInteger(1);
        return Stream.of(new Integer[95])
                .map(c -> index.getAndIncrement())
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
    /* task managed by the timer */
    class CityWebClient extends TimerTask {
        private final RestTemplate restTemplate;
        private final CityService cityService;
        private final String codeDept;

        public CityWebClient(RestTemplate restTemplate, CityService cityService, String codeDept) {
            this.restTemplate = restTemplate;
            this.cityService = cityService;
            this.codeDept = codeDept;
        }

        @Override
        public void run() {
            String url = String.format(urlCities, codeDept);
            CityDto[] cityDto = restTemplate.getForObject(url, CityDto[].class);
            assert cityDto != null;
            this.cityService.createCities(List.of(cityDto));
        }
    }
}
