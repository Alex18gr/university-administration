package io.alexc.studentsweb.dto;

import io.alexc.studentsweb.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class EmployeeDetailsDTO {

    private String employeeId;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String siteUrl;
    private String title;
    private String office;
    private List<EmployeeCourseDTO> employeeCourses;
    private DepartmentDTO departmentDTO;

    @Getter
    @Setter
    @RequiredArgsConstructor @AllArgsConstructor
    public static class EmployeeCourseDTO {
        private Integer courseId;
        private String registryNumber;
        private String name;
        private String englishName;
        private String description;
        private String englishDescription;
        private Integer semester;
    }

}
