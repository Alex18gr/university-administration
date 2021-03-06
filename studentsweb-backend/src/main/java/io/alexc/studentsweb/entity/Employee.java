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
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id_employee")
    private String employeeId;

    @Column(name = "id_user")
    private String userId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "site_url")
    private String siteUrl;

    @Column(name = "address")
    private String address;

    @Column(name = "title")
    private String title;

    @Column(name = "office")
    private String office;

    @ManyToOne
    @JoinColumn(name = "id_department", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "id_university_service", nullable = false)
    private UniversityService universityService;

    @ManyToMany
    @JoinTable(
            name = "professor_has_course",
            joinColumns = @JoinColumn(name = "id_employee"),
            inverseJoinColumns = @JoinColumn(name = "id_course"))
    private Set<Course> courses;

}
