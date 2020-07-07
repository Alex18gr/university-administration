package io.alexc.studentsweb.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity @Getter @Setter @RequiredArgsConstructor
@Table(name = "student_course_registration")
public class StudentCourseRegistration {

    @Id
    @Column(name = "id_registration")
    private Integer registrationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_course", nullable=false)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="student_registry_number", nullable=false)
    private Student student;

    @Column(name = "ins_date")
    private Date insDate;

    @Column(name = "mark")
    private Integer mark;

}
