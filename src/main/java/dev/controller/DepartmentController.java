package dev.controller;

import dev.dto.DepartmentDto;
import dev.service.DepartmentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("departments")
public class DepartmentController {

    private DepartmentService departmentService;
    @Value("${get.departments}")
    private String url;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/save")
    public void addDepartments() {
        RestTemplate restTemplate = new RestTemplate();
        DepartmentDto[] departmentsDto = restTemplate.getForObject(url, DepartmentDto[].class);
        assert departmentsDto != null;
        this.departmentService.createDepartments(List.of(departmentsDto));
    }
}
