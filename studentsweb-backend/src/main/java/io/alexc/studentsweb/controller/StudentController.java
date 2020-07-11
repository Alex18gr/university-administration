package io.alexc.studentsweb.controller;

import io.alexc.studentsweb.dto.AnnouncementDTO;
import io.alexc.studentsweb.dto.StudentApplicationSemesterAvgMarksDTO;
import io.alexc.studentsweb.dto.StudentCourseRegistrationDTO;
import io.alexc.studentsweb.dto.StudentDTO;
import io.alexc.studentsweb.service.AnnouncementService;
import io.alexc.studentsweb.service.StudentService;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "api/students/me")
public class StudentController {

    private final StudentService studentService;
    private final AnnouncementService announcementService;

    public StudentController(StudentService studentService, AnnouncementService announcementService) {
        this.studentService = studentService;
        this.announcementService = announcementService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public StudentDTO getCurrentStudentData(HttpServletRequest request) {
//        KeycloakAuthenticationToken principal = (KeycloakAuthenticationToken) request.getUserPrincipal();
//        principal.getAccount().getKeycloakSecurityContext().getIdToken().getId();

        return studentService.getCurrentUser();

    }

    @RequestMapping(value = "course-registrations", method = RequestMethod.GET)
    public List<StudentCourseRegistrationDTO> getCurrentStudentCourses(@RequestParam(required = false) Integer semester) {
        if (semester == null || semester < 1 || semester > 8) {
            return this.studentService.getCurrentStudentCourseRegistrations();
        } else {
            return this.studentService.getCurrentStudentCourseRegistrationsBySemester(semester);
        }
    }

    @RequestMapping(value = "course-registrations/semester-average", method = RequestMethod.GET)
    public List<StudentApplicationSemesterAvgMarksDTO> getCurrentStudentMarksAverageBySemester() {
        return studentService.getCurrentStudentMarksAverageBySemester();
    }

    @RequestMapping(value = "announcements", method = RequestMethod.GET)
    public List<AnnouncementDTO> getCurrentUserAnnouncements() {
        return announcementService.getAnnouncementsByCurrentStudentDepartment();
    }
}
