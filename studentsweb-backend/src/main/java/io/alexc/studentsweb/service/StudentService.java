package io.alexc.studentsweb.service;

import io.alexc.studentsweb.dto.StudentDTO;

public interface StudentService {

    StudentDTO findByUserId(String userId);

    StudentDTO getCurrentUser();

}
