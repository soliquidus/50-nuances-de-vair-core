package dev.config.bach.task;

import dev.entity.City;
import dev.entity.Pollution;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class TaskController {

    private final CensusTask censusTask;
    private final WeatherTask weatherTask;
    private final PollutionTask pollutionTask;
    private final RestTemplate restTemplate;

    public TaskController(CensusTask censusTask, WeatherTask weatherTask, PollutionTask pollutionTask, RestTemplate restTemplate) {
        this.censusTask = censusTask;
        this.weatherTask = weatherTask;
        this.pollutionTask = pollutionTask;
        this.restTemplate = restTemplate;
    }

    public Pollution PollutionTaskController(City city) {
        return this.pollutionTask.run(restTemplate, city);
    }
}
