package io.alexc.studentsweb.controller;

import io.alexc.studentsweb.dto.StudentDTO;
import io.alexc.studentsweb.service.StudentService;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "api/students")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "me", method = RequestMethod.GET)
    public StudentDTO getCurrentStudentData(HttpServletRequest request) {
//        KeycloakAuthenticationToken principal = (KeycloakAuthenticationToken) request.getUserPrincipal();
//        principal.getAccount().getKeycloakSecurityContext().getIdToken().getId();

        return studentService.getCurrentUser(request);

    }
}
