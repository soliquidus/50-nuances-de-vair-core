package dev.service;

import dev.dto.CityDto;
import dev.dto.api.CityJson;
import dev.entity.City;
import dev.entity.Department;
import dev.repository.CityRepository;
import dev.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Service
@PropertySource("classpath:application-api.properties")
public class CityService {
    @Value("${request.localized.city-geo-gouv}")
    private String urlCity;
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

            String url = String.format(urlCity,city.getName(),city.getZipCode());

            RestTemplate test = new RestTemplate();

            CityJson cityJson = test.getForObject(url, CityJson.class);
            assert cityJson != null;
            city.addLocalisationAndCensus(cityJson);
            this.cityRepository.save(city);
        }
    }

    public City getCity(Long id) {
        return this.cityRepository.getById(id);
    }

    public List<City> getCities(){
        return this.cityRepository.findAll();
    }
}
