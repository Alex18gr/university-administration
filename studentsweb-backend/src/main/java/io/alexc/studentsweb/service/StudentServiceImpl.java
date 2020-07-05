package io.alexc.studentsweb.service;

import io.alexc.studentsweb.dto.StudentDTO;
import io.alexc.studentsweb.entity.Student;
import io.alexc.studentsweb.repository.StudentRepository;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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
    public StudentDTO getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        KeycloakPrincipal principal = (KeycloakPrincipal) authentication.getPrincipal();
        return convertStudentToDto(studentRepository.getByUserId(principal.getName()).orElseThrow(RuntimeException::new));
    }

    private StudentDTO convertStudentToDto(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }
}
