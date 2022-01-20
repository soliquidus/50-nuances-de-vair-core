package dev.service;

import dev.dto.CityDto;
import dev.dto.api.CityJson;
import dev.entity.Department;
import dev.repository.CityRepository;
import dev.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final DepartmentRepository departmentRepository;
    @Value("${key.api-open-weather}")
    private String apiKey;

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

            String url = "https://api-adresse.data.gouv.fr/search/?q=" + name + "&postcode=" + zipCode + "&limit=1";
            RestTemplate restTemplate = new RestTemplate();
            CityJson cityGeoCode = restTemplate.getForObject(url, CityJson.class);
            assert cityGeoCode != null;
//            Double longitude = cityGeoCode.getLon();
//            Double lattitude = cityGeoCode.getLat();

//            City city = new City(cityDto.getNom(), zipCode, department);
//            this.cityRepository.save(city);
        }
    }
}
