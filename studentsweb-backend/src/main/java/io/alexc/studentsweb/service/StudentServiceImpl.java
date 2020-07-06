package io.alexc.studentsweb.service;

import io.alexc.studentsweb.dto.StudentDTO;
import io.alexc.studentsweb.entity.Student;
import io.alexc.studentsweb.repository.StudentRepository;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDTO findByUserId(String userId) {
        return null;
        // return this.studentRepository.getByUserId(userId).get();
    }

    @Override
    public StudentDTO getCurrentUser(HttpServletRequest request) {
         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         // KeycloakAuthenticationToken principal = (KeycloakAuthenticationToken) request.getUserPrincipal();

        KeycloakPrincipal principal = (KeycloakPrincipal) authentication.getPrincipal();
////        principal.getAccount().getKeycloakSecurityContext().getIdToken().getId();
//        return convertStudentToDto(studentRepository.getByUserId(principal.getAccount().getKeycloakSecurityContext().getIdToken().getId())
//                .orElseThrow(RuntimeException::new));
        return convertStudentToDto(studentRepository.getByUserId(principal.getName())
                .orElseThrow(RuntimeException::new));
    }

    private StudentDTO convertStudentToDto(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }
}
