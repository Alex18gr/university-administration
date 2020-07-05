package io.alexc.studentsweb.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity @Data
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

    @ManyToOne
    @JoinColumn(name = "id_department", nullable = false)
    private Department department;

    @ManyToMany
    @JoinTable(
            name = "professor_has_course",
            joinColumns = @JoinColumn(name = "id_employee"),
            inverseJoinColumns = @JoinColumn(name = "id_course"))
    private Set<Course> courses;

}
