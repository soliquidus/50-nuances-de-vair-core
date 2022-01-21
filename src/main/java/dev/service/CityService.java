package dev.service;

import dev.dto.CityDto;
import dev.dto.api.CityJson;
import dev.dto.api.CityJson.FeaturesJson;
import dev.dto.api.CityJson.GeometryJson;
import dev.entity.City;
import dev.entity.Department;
import dev.repository.CityRepository;
import dev.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final DepartmentRepository departmentRepository;

    public CityService(CityRepository cityRepository, DepartmentRepository departmentRepository) {
        this.cityRepository = cityRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createCities(List<CityDto> cities) {
        for (CityDto cityDto : cities) {
            Department department = this.departmentRepository.findByDepartmentCode(cityDto.getCodeDepartement());
            String[] zipCodes = cityDto.getCodesPostaux();
            String zipCode = zipCodes[0];
            String name = cityDto.getNom();

            City city = new City(name, zipCode, department);
            this.cityRepository.save(city);
        }
    }

    @Transactional
    public void getGeoData() {
        List<City> cities = this.cityRepository.findAll();
        for (City city : cities) {

            String url = "https://api-adresse.data.gouv.fr/search/?q=" + city.getName() + "&postcode=" + city.getZipCode() + "&limit=1";

            RestTemplate test = new RestTemplate();

            CityJson json = test.getForObject(url, CityJson.class);
            assert json != null;
            FeaturesJson features = json.getFeaturesJsons()[0];
            GeometryJson geometry = features.getGeometryJson();
            Double longitude = geometry.getGeoLocalisation()[0];
            Double latitude = geometry.getGeoLocalisation()[1];

            city.setLatitude(latitude);
            city.setLongitude(longitude);

            this.cityRepository.save(city);
        }
    }
}
