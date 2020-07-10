package io.alexc.studentsweb.repository;

import io.alexc.studentsweb.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
