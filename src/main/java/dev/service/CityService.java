package dev.service;

import dev.dto.CityDto;
import dev.entity.City;
import dev.entity.Department;
import dev.repository.CityRepository;
import dev.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

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
        for (CityDto cityDto: cities) {
            Department department = this.departmentRepository.findByDepartmentCode(cityDto.getCodeDepartement());
            String []zipCodes = cityDto.getCodesPostaux();
            City city = new City(cityDto.getNom(),zipCodes[0] , department);
            this.cityRepository.save(city);
        }
    }
}
