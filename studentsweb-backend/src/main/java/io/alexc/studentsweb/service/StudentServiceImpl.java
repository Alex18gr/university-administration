package io.alexc.studentsweb.service;

import io.alexc.studentsweb.dto.StudentApplicationDTO;
import io.alexc.studentsweb.dto.StudentApplicationSemesterAvgMarksDTO;
import io.alexc.studentsweb.dto.StudentCourseRegistrationDTO;
import io.alexc.studentsweb.dto.StudentDTO;
import io.alexc.studentsweb.entity.Student;
import io.alexc.studentsweb.entity.StudentCourseRegistration;
import io.alexc.studentsweb.repository.StudentCourseRegistrationRepository;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final StudentCourseRegistrationRepository studentCourseRegistrationRepository;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper, StudentCourseRegistrationRepository studentCourseRegistrationRepository) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
        this.studentCourseRegistrationRepository = studentCourseRegistrationRepository;
    }

    @Override
    public StudentDTO findByUserId(String userId) {
        return null;
        // return this.studentRepository.getByUserId(userId).get();
    }

    @Override
    public StudentDTO getCurrentUser() {
        return convertStudentToDto(studentRepository.getByUserId(getCurrentStudentId())
                .orElseThrow(RuntimeException::new));
    }

    @Override
    public List<StudentCourseRegistrationDTO> getCurrentStudentCourseRegistrations() {
        return studentRepository.getByUserId(getCurrentStudentId())
                .orElseThrow(RuntimeException::new).getCourseRegistrations().stream()
                .map(this::convertCourseRegistrationToDTO).collect(Collectors.toList());
    }

    @Override
    public List<StudentCourseRegistrationDTO> getCurrentStudentCourseRegistrationsBySemester(Integer semester) {
        return studentCourseRegistrationRepository.getByStudentIdAndSemester(getCurrentStudentId(), semester)
                .stream().map(this::convertCourseRegistrationToDTO).collect(Collectors.toList());
    }

    @Override
    public String getCurrentStudentId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        KeycloakPrincipal principal = (KeycloakPrincipal) authentication.getPrincipal();
        return principal.getName();
    }

    @Override
    public List<StudentApplicationSemesterAvgMarksDTO> getCurrentStudentMarksAverageBySemester() {
        return studentCourseRegistrationRepository.getAverageStudentMarks(getCurrentStudentId());
    }

    private StudentDTO convertStudentToDto(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }

    private StudentCourseRegistrationDTO convertCourseRegistrationToDTO(StudentCourseRegistration courseRegistration) {
           // return modelMapper.map(courseRegistration, StudentCourseRegistrationDTO.class);
        StudentCourseRegistrationDTO courseRegistrationDTO = new StudentCourseRegistrationDTO();
        courseRegistrationDTO.setName(courseRegistration.getCourse().getName());
        courseRegistrationDTO.setRegistryNumber(courseRegistration.getCourse().getRegistryNumber());
        courseRegistrationDTO.setMark(courseRegistration.getMark());
        List<StudentCourseRegistrationDTO.StudentCourseRegistrationProfessorDTO> professorDTOS = courseRegistration
                .getCourse().getProfessors().stream()
                .map(m -> new StudentCourseRegistrationDTO.StudentCourseRegistrationProfessorDTO(m.getName(), m.getSurname(), m.getEmail(), m.getTitle(), m.getSiteUrl())).collect(Collectors.toList());
        courseRegistrationDTO.setProfessors(professorDTOS);
        return courseRegistrationDTO;
    }
}
