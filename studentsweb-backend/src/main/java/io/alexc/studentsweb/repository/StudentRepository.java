package io.alexc.studentsweb.repository;

import io.alexc.studentsweb.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {

    Optional<Student> getByUserId(String userId);

}
