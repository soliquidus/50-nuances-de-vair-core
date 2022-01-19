package dev.config.bach;


import dev.config.bach.controller.TaskController;
import dev.entity.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import java.util.List;


@Configuration
@EnableScheduling
public class ApiScheduledCall {

    private final Logger LOGGER = LoggerFactory.getLogger(ApiScheduledCall.class);
    private final TaskController taskController;


    public ApiScheduledCall(TaskController taskController) {
        this.taskController = taskController;
    }

    @PostConstruct
    public void cityInitializeWithRelation() {
       taskController.regionTaskController();
    }

    //    @Scheduled(cron = "0 0 6 * * ?")
    @Scheduled(fixedDelay = 10000)
    public void scheduleFixedDelayTask() {
        // boucle sur les départements
//        appel de la liste de la ville du département


//            Pollution pollution = taskController.pollutionTaskController(city);
//            Weather weather = taskController.

//        boucle sur les villes
        // requêtes pollution
//        Pollution pollution = context.getBean("runPollutionTask", Pollution.class);
        // requêtes weather
//        Weather weather = context.getBean("runWeatherTask",Weather.class);
//        enregistrement de la ville avec pollution / weather / census

        LOGGER.info("MESSAGE scheduleFixedDelayTask ");

    }

}
