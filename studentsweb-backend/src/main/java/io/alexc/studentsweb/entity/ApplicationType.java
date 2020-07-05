package io.alexc.studentsweb.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity @Data
@Table(name = "university_application_type")
public class ApplicationType {

    @Id
    @Column(name = "id_university_application_type")
    private Integer applicationTypeId;

    @ManyToOne
    @JoinColumn(name="id_university_service", nullable=false)
    private UniversityService issuingService;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy="applicationType")
    private Set<StudentApplication> studentApplications;

}
