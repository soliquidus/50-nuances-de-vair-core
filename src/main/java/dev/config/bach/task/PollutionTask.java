package dev.config.bach.task;

import dev.entity.City;
import dev.entity.Pollution;
import dev.dto.PollutionDto;
import dev.repository.PollutionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:application-api.properties")
public class PollutionTask {
    private Logger LOGGER = LoggerFactory.getLogger(PollutionTask.class);
    @Value("${key.api-open-weather}")
    private String keyApiWeather;
    @Value("${request.pollution-open-weather}")
    private String urlPollution;

    private final PollutionRepository pollutionRepository;

    public PollutionTask(PollutionRepository pollutionRepository) {
        this.pollutionRepository = pollutionRepository;
    }

    public Pollution run(RestTemplate buildTemplate, City city) {
        /* request api open-weather */
        PollutionDto pollutionDto = buildTemplate.getForObject(
                String.format(urlPollution, city.getLatitude(), city.getLongitude(), keyApiWeather),
                PollutionDto.class);
//        /* format response */
        assert pollutionDto != null;
        Pollution pollution = new Pollution(pollutionDto);
        return pollutionRepository.save(pollution);
    }
}
