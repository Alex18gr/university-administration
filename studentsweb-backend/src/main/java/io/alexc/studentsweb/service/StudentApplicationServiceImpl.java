package io.alexc.studentsweb.service;

import io.alexc.studentsweb.dto.StudentApplicationDTO;
import io.alexc.studentsweb.dto.UniversityServiceDTO;
import io.alexc.studentsweb.entity.ApplicationType;
import io.alexc.studentsweb.entity.Student;
import io.alexc.studentsweb.entity.StudentApplication;
import io.alexc.studentsweb.entity.UniversityService;
import io.alexc.studentsweb.repository.ApplicationTypeRepository;
import io.alexc.studentsweb.repository.StudentApplicationRepository;
import io.alexc.studentsweb.repository.StudentRepository;
import io.alexc.studentsweb.repository.UniversityServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentApplicationServiceImpl implements StudentApplicationService {

    private final UniversityServiceRepository universityServiceRepository;
    private final ModelMapper modelMapper;
    private final StudentRepository studentRepository;
    private final StudentService studentService;
    private final ApplicationTypeRepository applicationTypeRepository;
    private final StudentApplicationRepository studentApplicationRepository;

    public StudentApplicationServiceImpl(UniversityServiceRepository universityServiceRepository, ModelMapper modelMapper, StudentRepository studentRepository, StudentService studentService, ApplicationTypeRepository applicationTypeRepository, StudentApplicationRepository studentApplicationRepository) {
        this.universityServiceRepository = universityServiceRepository;
        this.modelMapper = modelMapper;
        this.studentRepository = studentRepository;
        this.studentService = studentService;
        this.applicationTypeRepository = applicationTypeRepository;
        this.studentApplicationRepository = studentApplicationRepository;
    }

    @Override
    public List<UniversityServiceDTO> getAllUniversityServices() {
        return universityServiceRepository.findAll().stream().map(this::convertUniversityServiceToDTO).collect(Collectors.toList());
    }

    @Override
    public List<UniversityServiceDTO> getUniversityServiceApplicationTypes() {
        return universityServiceRepository.getByApplicationTypesIsNotNull().stream().map(this::convertUniversityServiceToDTO).collect(Collectors.toList());
    }

    @Override
    public List<StudentApplicationDTO> getCurrentStudentApplications() {
        return studentRepository.getByUserId(studentService.getCurrentStudentId()).orElseThrow(RuntimeException::new)
                .getStudentApplications().stream().map(this::convertStudentApplicationToDto).collect(Collectors.toList());
    }

    @Override
    public StudentApplicationDTO createCurrentStudentApplication(String notes, Integer applicationTypeId) {
        ApplicationType applicationType = applicationTypeRepository.findById(applicationTypeId).orElseThrow(RuntimeException::new);
        String studentId = studentService.getCurrentStudentId();
        Student currentStudent = studentRepository.getByUserId(studentId).orElseThrow(RuntimeException::new);

        StudentApplication application = new StudentApplication();
        application.setApplicationType(applicationType);
        application.setStudent(currentStudent);
        application.setNotes(notes);
        application.setApplicationDate(new Date());
        application.setStatus("CREATED");

        StudentApplication savedApplication = studentApplicationRepository.save(application);

        return convertStudentApplicationToDto(savedApplication);

    }

    UniversityServiceDTO convertUniversityServiceToDTO(UniversityService universityService) {
        UniversityServiceDTO universityServiceDTO = new UniversityServiceDTO();
        universityServiceDTO.setServiceId(universityService.getServiceId());
        universityServiceDTO.setName(universityService.getName());
        universityServiceDTO.setDescription(universityService.getDescription());
        List<UniversityServiceDTO.ServiceApplicationTypeDTO> applicationTypeDTOs = universityService.getApplicationTypes()
                .stream().map(item -> new UniversityServiceDTO.ServiceApplicationTypeDTO(item.getApplicationTypeId(), item.getName(), item.getDescription()))
                .collect(Collectors.toList());
        universityServiceDTO.setApplicationTypes(applicationTypeDTOs);
        return universityServiceDTO;
    }

    private StudentApplicationDTO convertStudentApplicationToDto(StudentApplication application) {
        return modelMapper.map(application, StudentApplicationDTO.class);
    }
}
