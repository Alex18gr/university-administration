package io.alexc.studentsweb.service;

import io.alexc.studentsweb.dto.EmployeeDTO;
import io.alexc.studentsweb.entity.Employee;
import io.alexc.studentsweb.repository.EmployeeRepository;
import io.alexc.studentsweb.specification.EmployeeSpecifications;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmployeeDTO> searchEmployeeByText(String text, Integer departmentId, Integer serviceId) {

        Specification<Employee> employeeSearchSpecifications = EmployeeSpecifications.textInNameOrSurname(text);

        if (departmentId != null) {
            employeeSearchSpecifications = employeeSearchSpecifications.and(EmployeeSpecifications.employeeInDepartment(departmentId));
        }
        if (serviceId != null) {
            employeeSearchSpecifications = employeeSearchSpecifications.and(EmployeeSpecifications.employeeInService(serviceId));
        }

        List<Employee> employeeSearchResults = employeeRepository.findAll(employeeSearchSpecifications);

        return employeeSearchResults.stream().map(this::convertEmployeeToDto).collect(Collectors.toList());
    }

    private EmployeeDTO convertEmployeeToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }
}
