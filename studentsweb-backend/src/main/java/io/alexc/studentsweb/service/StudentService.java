package io.alexc.studentsweb.service;

import io.alexc.studentsweb.dto.StudentCourseRegistrationDTO;
import io.alexc.studentsweb.dto.StudentDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface StudentService {

    StudentDTO findByUserId(String userId);

    StudentDTO getCurrentUser();

    List<StudentCourseRegistrationDTO> getCurrentStudentCourseRegistrations();

}
