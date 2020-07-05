package io.alexc.studentsweb.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity @Data
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_course")
    private Integer courseId;

    @ManyToOne
    @JoinColumn(name = "id_department", nullable = false)
    private Department department;

    @Column(name = "course_registry_number")
    private String registryNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "name_english")
    private String englishName;

    @Column(name = "description")
    private String description;

    @Column(name = "description_english")
    private String englishDescription;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "ects")
    private Integer ects;

    @ManyToMany(mappedBy = "enrolledCourses")
    private Set<Student> enrolledStudents;

    @ManyToMany(mappedBy = "courses")
    private Set<Employee> professors;

}
