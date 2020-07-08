package io.alexc.studentsweb.repository;

import io.alexc.studentsweb.entity.Department;
import io.alexc.studentsweb.entity.Employee;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {

    List<Employee> getByDepartment(Department department);

}
