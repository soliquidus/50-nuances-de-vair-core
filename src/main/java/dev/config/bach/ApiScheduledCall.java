package dev.config.bach;


import dev.config.bach.controller.TaskController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;


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
//        taskController.regionTaskController();
//        taskController.departmentTaskController();
//        taskController.cityTaskController();
    }

    //    @Scheduled(cron = "0 00 6 * * ?")
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedDelayTask() {
//        List<City> citiesError = new ArrayList<>();
//        taskController.getAllCities().forEach(city->{
//            try{
//                Weather weather = taskController.weatherTaskControler(city);
//                city.setWeather(weather);
//                taskController.citySaveByTaskController(city);
//            }catch (HttpClientErrorException e){
//                citiesError.add(city);
//            }
//        });
//        citiesError.forEach(c->LOGGER.info("error database for the city : {}",c));
    }

}
