package dev.config.bach.task;

import dev.dto.DepartmentDto;
import dev.service.DepartmentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Arrays;
@Service
@PropertySource("classpath:application-api.properties")
public class DepartmentTask implements Itask{

    @Value("${request.department-geo-gouv}")
    private String urlDepartment;

    private final DepartmentService departmentService;

    public DepartmentTask(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    /* /!\ Task programming after RegionTask*/
    @Override
    @Transactional
    public void run(RestTemplate restTemplate)throws HttpClientErrorException {
        DepartmentDto[] departmentsDto = restTemplate.getForObject(urlDepartment, DepartmentDto[].class);
        assert departmentsDto != null;
        this.departmentService.createDepartments(Arrays.asList(departmentsDto));
    }
}
