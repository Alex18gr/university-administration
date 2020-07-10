package io.alexc.studentsweb.controller;

import io.alexc.studentsweb.dto.UniversityServiceDTO;
import io.alexc.studentsweb.entity.UniversityService;
import io.alexc.studentsweb.service.StudentApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/university-services")
public class UniversityServiceController {

    private final StudentApplicationService studentApplicationService;

    public UniversityServiceController(StudentApplicationService studentApplicationService) {
        this.studentApplicationService = studentApplicationService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    List<UniversityServiceDTO> getAllUniversityServices() {
        return studentApplicationService.getAllUniversityServices();
    }

    @RequestMapping(value = "/application-types", method = RequestMethod.GET)
    List<UniversityServiceDTO> getUniversityServices() {
        return studentApplicationService.getUniversityServiceApplicationTypes();
    }

}
