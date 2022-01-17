package dev.service;

import dev.entity.Pollution;
import dev.repository.PollutionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@PropertySource("classpath:application-api.properties")
public class PollutionService {

    @Value("${key.api-openweather}")
    private String apiKey;

    private final PollutionRepository repository;

    public PollutionService(PollutionRepository repository) {
        this.repository = repository;
    }

    /**
     * search for the city then Air pollution
     * @param lat
     * @param lon
     * @return
     */
    public Pollution getCurrentAirPollution(Long lat, Long lon){
        String cityName =null; // service City => ask city via lat lon return cityName
       return null;
    }

    /**
     * search for air pollution using the name of the city
     * @param cityName
     * @return
     */
    public Pollution getCurrentAirPollutionByCity(String cityName){
        return null;
    }

    /**
     * search for the city then the air pollution between two dates
     * @param lat
     * @param lon
     * @param startDate
     * @param endDate
     * @return
     */
    public List<Pollution> getForecastAirPollution(Long lat, Long lon, LocalDate startDate,LocalDate endDate){
        String cityName =null; // service City => ask city via lat lon return cityName
        return null;
    }

    /**
     * search for air pollution using the name of the city then the between two dates
     * @param cityName
     * @param startDate
     * @param endDate
     * @return
     */
    public List<Pollution> getForecastAirPollutionByCity(String cityName, LocalDate startDate,LocalDate endDate){
       return null;
    }

}
