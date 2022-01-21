package dev.service;

import dev.dto.DepartmentDto;
import dev.entity.Department;
import dev.entity.Region;
import dev.repository.DepartmentRepository;
import dev.repository.RegionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final RegionRepository regionRepository;

    public DepartmentService(DepartmentRepository departmentRepository, RegionRepository regionRepository) {
        this.departmentRepository = departmentRepository;
        this.regionRepository = regionRepository;
    }

    @Transactional
    public void createDepartments(List<DepartmentDto> departments) {
        for (DepartmentDto departmentDto : departments) {
            Region region = this.regionRepository.findByRegionCode(departmentDto.getCodeRegion());
            Department department = new Department(departmentDto.getNom(), departmentDto.getCode(), region);
            this.departmentRepository.save(department);
        }
    }

    public List<Department> list() {
        return this.departmentRepository.findAll();
    }
}
