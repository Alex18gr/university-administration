package io.alexc.studentsweb.controller;

import io.alexc.studentsweb.dto.EmployeeDTO;
import io.alexc.studentsweb.service.EmployeeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public List<EmployeeDTO> searchEmployees(@RequestBody SearchCriteria searchCriteria) {

        return employeeService.searchEmployeeByText(searchCriteria.getText(), searchCriteria.getDepartmentId(), searchCriteria.getServiceId());

    }

    @Data
    private static class SearchCriteria {
        private String text;
        private Integer departmentId;
        private Integer serviceId;
    }

}
