package io.alexc.studentsweb.service;

import io.alexc.studentsweb.dto.EmployeeDTO;
import io.alexc.studentsweb.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> searchEmployeeByText(String text);

}
