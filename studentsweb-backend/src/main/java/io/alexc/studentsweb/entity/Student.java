package io.alexc.studentsweb.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity @Data
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "registry_number")
    private String registryNumber;

    @Column(name = "id_user")
    private String userId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "enroll_date")
    private Date enrollDate;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "id_department", nullable = false)
    private Department enrolledDepartment;

    @ManyToMany
    @JoinTable(
            name = "course_has_student",
            joinColumns = @JoinColumn(name = "student_registry_number"),
            inverseJoinColumns = @JoinColumn(name = "id_course"))
    private Set<Course> enrolledCourses;

    @OneToMany(mappedBy="student")
    private Set<StudentApplication> studentApplications;

}
