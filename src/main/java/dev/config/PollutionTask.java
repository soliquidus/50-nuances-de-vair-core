package dev.config;

import dev.dto.PollutionDto;
import dev.entity.Pollution;
import dev.json.PollutionJson;
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

    public PollutionTask(RestTemplateBuilder restTemplateBuilder,PollutionRepository pollutionRepository) {
        this.pollutionRepository = pollutionRepository;
    }

    @Bean
    @Scope("prototype")
    public Pollution runPollutionTask(RestTemplate buildTemplate) {
        Double lat = 46.977;
        Double lon = 1.314;
        /* request api open-weather */
        PollutionJson pollutionJson = buildTemplate.getForObject(
                String.format(urlPollution, lat, lon, keyApiWeather),
                PollutionJson.class);
        /* format response */
        PollutionDto pollutionDto = new PollutionDto(pollutionJson);
        return pollutionRepository.save(pollutionDto.convert());
    }
}
