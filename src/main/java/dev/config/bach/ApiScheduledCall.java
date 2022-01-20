package dev.config.bach;


import dev.config.bach.controller.TaskController;
import dev.entity.City;
import dev.entity.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.HttpClientErrorException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableScheduling
public class ApiScheduledCall {

    private final Logger LOGGER = LoggerFactory.getLogger(ApiScheduledCall.class);
    private final TaskController taskController;

    public ApiScheduledCall(TaskController taskController) {
        this.taskController = taskController;
    }

    /**
    * launch initializer of the table
    * cn_region
    * cn_department
    * cn_city
    * the order of initialization is very important for relations
    */
    @PostConstruct
    public void cityInitializeWithRelation() {
//        taskController.regionTaskController();
//        taskController.departmentTaskController();
//        taskController.cityTaskController();
        scheduleFixedDelayTask();
    }

    /*
     * daily programming for pollution and weather data
     */
//        @Scheduled(cron = "0 0 4 * * ?")
//        @Scheduled(cron = "0 0 8 * * ?")
//        @Scheduled(cron = "0 0 12 * * ?")
//        @Scheduled(cron = "0 0 16 * * ?")
//        @Scheduled(cron = "0 0 20 * * ?")
//        @Scheduled(cron = "0 0 0 * * ?")

    public void scheduleFixedDelayTask() {
        List<City> citiesError = new ArrayList<>();
        taskController.getAllCities().forEach(city->{
            try{
                Weather weather = taskController.weatherTaskControler(city);
                city.setWeather(weather);
                taskController.citySaveByTaskController(city);
            }catch (HttpClientErrorException e){
                citiesError.add(city);
            }
        });
        citiesError.forEach(c->LOGGER.info("error database for the city : {}",c));
            LOGGER.info("test");
    }
}
