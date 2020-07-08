package io.alexc.studentsweb.repository;

import io.alexc.studentsweb.entity.StudentCourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentCourseRegistrationRepository extends JpaRepository<StudentCourseRegistration, Integer> {

    @Query("select scr from StudentCourseRegistration scr JOIN scr.student s JOIN scr.course c where s.userId = :studentRegistrationNumber and c.semester = :semester")
    List<StudentCourseRegistration> getByStudentIdAndSemester(@Param("studentRegistrationNumber") String studentRegistrationNumber,
                                                              @Param("semester") Integer semester);

}
