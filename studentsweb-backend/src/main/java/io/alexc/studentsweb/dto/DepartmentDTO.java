package io.alexc.studentsweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@RequiredArgsConstructor @AllArgsConstructor
public class DepartmentDTO {

    private Integer departmentId;
    private String name;
    private String description;
    private String prefix;

}
