package dev.config.bach.task;

import dev.dto.api.CityJson;
import dev.dto.api.CityJson.FeaturesJson;
import dev.dto.api.CityJson.GeometryJson;
import dev.entity.City;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Service
@PropertySource("classpath:application-api.properties")
public class CityLocalizedTask implements ItaskCity<City>{

    @Value("${request.localized.city-geo-gouv}")
    private String urlLocalizedCity;

    @Override
    @Transactional
    public City run(RestTemplate buildTemplate, City city)throws HttpClientErrorException {
        /* request api open-weather */
        String url = String.format(urlLocalizedCity, city.getName(),city.getZipCode());
        CityJson cityJson = buildTemplate.getForObject(url,CityJson.class);
        /* format response */
        assert cityJson != null;
        return  city.addLocalisationAndCensus(cityJson);
    }
}
