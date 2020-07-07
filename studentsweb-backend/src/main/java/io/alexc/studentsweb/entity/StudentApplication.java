package io.alexc.studentsweb.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity @Getter
@Setter
@RequiredArgsConstructor
@Table(name = "student_application")
public class StudentApplication {

    @Id
    @Column(name = "id_student_application")
    private Integer applicationId;

    @Column(name = "notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name="id_university_application_type", nullable=false)
    private ApplicationType applicationType;

    @ManyToOne
    @JoinColumn(name="student_registry_number", nullable=false)
    private Student student;

    @Column(name = "application_date")
    private Date applicationDate;

}
