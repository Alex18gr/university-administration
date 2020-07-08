package io.alexc.studentsweb.dto;

import io.alexc.studentsweb.entity.ApplicationType;
import io.alexc.studentsweb.entity.Student;
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
public class StudentApplicationDTO {

    private Integer applicationId;
    private String notes;
    private String status;
    private Integer applicationTypeId;
    private String applicationTypeName;
    private Date applicationDate;

}
