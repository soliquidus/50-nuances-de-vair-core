package dev.config;

import dev.dto.WeatherDto;
import dev.entity.City;
import dev.entity.Weather;
import dev.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

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
    @Bean
    @Scope("prototype")
    public Weather runWeatherTask(RestTemplate restTemplate){
        City city = new City();
        city.setName("Montaigu");
        city.setZipCode(85600);
        /* request api open-weather */
        WeatherDto weatherDto = restTemplate.getForObject(
                String.format(urlWeather,city.getName(),state,city.getZipCode())
        ,WeatherDto.class);
        /* format response */
        Weather weather = new Weather(weatherDto);
        return weatherRepository.save(null);
    }
}
