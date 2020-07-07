package io.alexc.studentsweb.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class StudentDTO {

    private String registryNumber;
    private String userId;
    private String name;
    private String surname;
    private Date enrollDate;
    private Integer semester;
    private String email;
    private String phone;
    private String address;
    private String departmentName;

}
