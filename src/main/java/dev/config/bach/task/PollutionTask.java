package dev.config.bach.task;

import dev.entity.City;
import dev.entity.Pollution;
import dev.dto.PollutionDto;
import dev.repository.PollutionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:application-api.properties")
public class PollutionTask {

    @Value("${key.api-open-weather}")
    private String keyApiWeather;
    @Value("${request.pollution-open-weather}")
    private String urlPollution;

    private final PollutionRepository pollutionRepository;

    public PollutionTask(PollutionRepository pollutionRepository) {
        this.pollutionRepository = pollutionRepository;
    }

    @Transactional
    public Pollution run(RestTemplate buildTemplate, City city) throws HttpClientErrorException {
        /* request api open-weather */
        String url = String.format(urlPollution, city.getLatitude(), city.getLongitude(), keyApiWeather);
        PollutionDto pollutionDto = buildTemplate.getForObject(url, PollutionDto.class);
//        /* format response */
        assert pollutionDto != null;
        return pollutionRepository.save(new Pollution(pollutionDto));

    }
}
