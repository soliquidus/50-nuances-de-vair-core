package dev.config.bach;


import dev.config.bach.task.TaskController;
import dev.entity.City;
import dev.entity.Pollution;
import dev.entity.Weather;
import dev.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;


@Configuration
@EnableScheduling
public class ApiScheduledCall {

    private final Logger LOGGER = LoggerFactory.getLogger(ApiScheduledCall.class);
    private final TaskController taskController;


    public ApiScheduledCall(TaskController taskController) {
        this.taskController = taskController;
    }

    @PostConstruct
    public void get() {
        LOGGER.info("MESSAGE BOOT");
    }

    //    @Scheduled(cron = "0 0 6 * * ?")
    @Scheduled(fixedDelay = 10000)
    public void scheduleFixedDelayTask() {
        // boucle sur les départements
//        appel de la liste de la ville du département
//        boucle sur les villes
        // requêtes pollution
//        Pollution pollution = context.getBean("runPollutionTask", Pollution.class);
        // requêtes weather
//        Weather weather = context.getBean("runWeatherTask",Weather.class);
//        enregistrement de la ville avec pollution / weather / census
        City city = new City();
        city.setLatitude(new BigDecimal(49.535));
        city.setLongitude(new BigDecimal(3.8326));
       Pollution pollution= taskController.PollutionTaskController(city);
        LOGGER.info("MESSAGE scheduleFixedDelayTask {}",pollution);

//        String url = "https://geo.api.gouv.fr/departements/85/communes";
//        RestTemplate restTemplate = new RestTemplate();
//        CityDto[] cityDto = restTemplate.getForObject(url, CityDto[].class);
//        assert cityDto != null;
//        this.cityService.createCities(List.of(cityDto));
    }

}
