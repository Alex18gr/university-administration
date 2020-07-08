package io.alexc.studentsweb.repository;

import io.alexc.studentsweb.entity.StudentApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentApplicationRepository extends JpaRepository<StudentApplication, Integer> {
}
