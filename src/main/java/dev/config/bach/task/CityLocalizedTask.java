package dev.config.bach.task;

import dev.dto.PollutionDto;
import dev.dto.api.CityJson;
import dev.dto.api.FeaturesJson;
import dev.dto.api.GeometryJson;
import dev.entity.City;
import dev.entity.Pollution;
import dev.service.CityService;
import dev.service.PollutionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@PropertySource("classpath:application-api.properties")
public class CityLocalizedTask {

    @Value("${key.api-open-weather}")
    private String keyApiWeather;
    @Value("${request.localized.city-geo-gouv}")
    private String urlLocalizedCity;

    private final CityService cityService;

    public CityLocalizedTask(CityService cityService) {
        this.cityService = cityService;
    }

    public City run(RestTemplate buildTemplate, City city) {
        /* request api open-weather */
        CityJson cityJson = buildTemplate.getForObject(
                String.format(urlLocalizedCity, city.getName(), city.getZipCode(), keyApiWeather),
                CityJson.class);
//        /* format response */
        assertNull(city, cityJson);
        return city;

    }

    public static void assertNull(City city, CityJson cityJson) {
        assert cityJson != null;
        FeaturesJson features = cityJson.getFeatures()[0];
        GeometryJson geometry = features.getGeometry();
        Double longitude = geometry.getCoordinates()[0];
        Double latitude = geometry.getCoordinates()[1];
        city.setLatitude(latitude);
        city.setLongitude(longitude);
    }
}
