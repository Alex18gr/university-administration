package io.alexc.studentsweb.service;

import io.alexc.studentsweb.dto.DepartmentDTO;
import io.alexc.studentsweb.entity.Department;
import io.alexc.studentsweb.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentServiceImpl(ModelMapper modelMapper, DepartmentRepository departmentRepository) {
        this.modelMapper = modelMapper;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll().stream().map(this::convertDepartmentToDTO).collect(Collectors.toList());
    }

    private DepartmentDTO convertDepartmentToDTO(Department department) {
        return modelMapper.map(department, DepartmentDTO.class);
    }
}
