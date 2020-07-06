package io.alexc.studentsweb.service;

import io.alexc.studentsweb.dto.StudentDTO;

import javax.servlet.http.HttpServletRequest;

public interface StudentService {

    StudentDTO findByUserId(String userId);

    StudentDTO getCurrentUser(HttpServletRequest request);

}
