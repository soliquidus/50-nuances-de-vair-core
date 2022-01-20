package dev.config.bach.task;

import dev.dto.PollutionDto;
import dev.dto.api.CityJson;
import dev.dto.api.FeaturesJson;
import dev.dto.api.GeometryJson;
import dev.entity.City;
import dev.entity.Pollution;
import dev.repository.CityRepository;
import dev.service.CityService;
import dev.service.PollutionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Service
@PropertySource("classpath:application-api.properties")
public class CityLocalizedTask {

    @Value("${request.localized.city-geo-gouv}")
    private String urlLocalizedCity;

    @Transactional
    public City run(RestTemplate buildTemplate, City city)throws HttpClientErrorException {
        /* request api open-weather */
        String url = String.format(urlLocalizedCity, city.getName(),city.getZipCode());
        CityJson cityJson = buildTemplate.getForObject(url,CityJson.class);
        /* format response */
        assert cityJson != null;
        return  assertNotNull(city, cityJson);
    }

    public static City assertNotNull(City city, CityJson cityJson) {
        FeaturesJson features = cityJson.getFeatures()[0];
        GeometryJson geometry = features.getGeometry();
        Double longitude = geometry.getCoordinates()[0];
        Double latitude = geometry.getCoordinates()[1];
        city.setLatitude(latitude);
        city.setLongitude(longitude);
        return city;
    }
}
