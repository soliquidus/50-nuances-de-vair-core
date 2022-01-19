package dev.config;

import dev.entity.Pollution;
import dev.dto.PollutionDto;
import dev.repository.PollutionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
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

    @Bean
    @Scope("prototype")
    public Pollution runPollutionTask(RestTemplate buildTemplate) {
        Double lat = 46.977;
        Double lon = 1.314;
        /* request api open-weather */
        PollutionDto pollutionDto = buildTemplate.getForObject(
                String.format(urlPollution, lat, lon, keyApiWeather),
                PollutionDto.class);
        /* format response */
        Pollution pollution = new Pollution(pollutionDto);
        return pollutionRepository.save(pollution);
    }
}
