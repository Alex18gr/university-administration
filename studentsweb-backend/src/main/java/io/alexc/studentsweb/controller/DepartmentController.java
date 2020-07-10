package io.alexc.studentsweb.controller;

import io.alexc.studentsweb.dto.DepartmentDTO;
import io.alexc.studentsweb.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<DepartmentDTO> getAllUniversityDepartments() {
        return departmentService.getAllDepartments();
    }
}
