package io.alexc.studentsweb.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity @Data
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_department")
    private Integer departmentId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "prefix")
    private String prefix;

    @OneToMany(mappedBy = "enrolledDepartment")
    private Set<Student> enrolledStudents;

    @OneToMany(mappedBy="department")
    private Set<Announcement> announcements;

}
