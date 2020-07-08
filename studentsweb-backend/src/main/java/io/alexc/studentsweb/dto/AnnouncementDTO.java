package io.alexc.studentsweb.dto;


import io.alexc.studentsweb.entity.Department;
import io.alexc.studentsweb.entity.Employee;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class AnnouncementDTO {

    private Integer announcementId;
    private String departmentName;
    private String title;
    private String content;
    private Date insDate;
    private EmployeeDTO creator;

}
