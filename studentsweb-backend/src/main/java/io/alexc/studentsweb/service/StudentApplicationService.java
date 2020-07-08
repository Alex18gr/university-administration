package io.alexc.studentsweb.service;

import io.alexc.studentsweb.dto.StudentApplicationDTO;
import io.alexc.studentsweb.dto.UniversityServiceDTO;

import java.util.List;

public interface StudentApplicationService {

    List<UniversityServiceDTO> getUniversityServiceApplicationTypes();

    List<StudentApplicationDTO> getCurrentStudentApplications();

    StudentApplicationDTO createCurrentStudentApplication(String notes, Integer applicationTypeId);

}
