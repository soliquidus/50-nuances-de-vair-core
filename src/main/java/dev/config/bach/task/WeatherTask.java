package dev.config.bach.task;

import dev.dto.WeatherDto;
import dev.entity.City;
import dev.entity.Weather;
import dev.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:application-api.properties")
public class WeatherTask {
   @Value("${key.api-open-weather}")
    private String keyApiWeather;
    @Value("${request.weather-open-weather}")
    private String urlWeather;
    @Value("${state}")
    private String state;

    private final WeatherRepository weatherRepository;

    public WeatherTask(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public Weather run(RestTemplate restTemplate,City city){
        /* request api open-weather */
        WeatherDto weatherDto = restTemplate.getForObject(
                String.format(urlWeather,
                        city.getName(),state,city.getZipCode(),keyApiWeather)
        ,WeatherDto.class);
        /* format response */
        assert weatherDto != null;
        Weather weather = new Weather(weatherDto);
        return weatherRepository.save(weather);
    }

}
