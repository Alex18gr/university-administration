package io.alexc.studentsweb.controller;

import io.alexc.studentsweb.dto.StudentApplicationDTO;
import io.alexc.studentsweb.entity.StudentApplication;
import io.alexc.studentsweb.service.StudentApplicationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "api/students/me/student-applications")
public class StudentApplicationController {

    private final StudentApplicationService studentApplicationService;

    public StudentApplicationController(StudentApplicationService studentApplicationService) {
        this.studentApplicationService = studentApplicationService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    List<StudentApplicationDTO> getAllCurrentStudentApplications() {
        return studentApplicationService.getCurrentStudentApplications();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    StudentApplicationDTO createNewApplication(@RequestBody CreateApplicationData applicationData) {

        return studentApplicationService.createCurrentStudentApplication(applicationData.getNotes(), applicationData.getApplicationTypeId());

    }

    @Getter @Setter @RequiredArgsConstructor
    public static class CreateApplicationData {
        private String notes;
        private Integer applicationTypeId;
    }
}
