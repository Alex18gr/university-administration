package io.alexc.studentsweb.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity @Getter
@Setter
@RequiredArgsConstructor
@Table(name = "university_service")
public class UniversityService {

    @Id
    @Column(name = "id_university_service")
    private Integer serviceId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy="issuingService")
    private Set<ApplicationType> applicationTypes;

}
