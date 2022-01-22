package dev.controller;

import dev.dto.DepartmentDto;
import dev.entity.Department;
import dev.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("departments")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/save")
    public void addDepartments() {
        String url = "https://geo.api.gouv.fr/departements";
        RestTemplate restTemplate = new RestTemplate();
        DepartmentDto[] departmentsDto = restTemplate.getForObject(url, DepartmentDto[].class);
        assert departmentsDto != null;
        this.departmentService.createDepartments(Arrays.asList(departmentsDto));
    }

    @GetMapping
    public List<Department> getDepartments() {
        return this.departmentService.list();
    }
}
