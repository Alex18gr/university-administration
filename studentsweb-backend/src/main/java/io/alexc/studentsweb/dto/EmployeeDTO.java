package io.alexc.studentsweb.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
@RequiredArgsConstructor
public class EmployeeDTO {

    private String employeeId;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String siteUrl;
    private String title;

}
