package dev.config.bach.task;

import dev.dto.WeatherDto;
import dev.entity.City;
import dev.entity.Weather;
import dev.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Service
@PropertySource("classpath:application-api.properties")
public class WeatherTask {
    @Value("${key.api-open-weather}")
    private String keyApiWeather;
    @Value("${request.weather-open-weather}")
    private String urlWeather;
    @Value("${state.api-open-weather}")
    private String state;

    private final WeatherRepository weatherRepository;

    public WeatherTask(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Transactional
    public Weather run(RestTemplate restTemplate, City city)throws HttpClientErrorException {
        /* request api open-weather */
        String url = String.format(urlWeather, city.getName(), state, city.getZipCode(), keyApiWeather);
        WeatherDto weatherDto = restTemplate.getForObject(url, WeatherDto.class);
        /* format response */
        assert weatherDto != null;
        Weather weather = new Weather(weatherDto);
        return weatherRepository.save(weather);
    }

}
