package io.alexc.studentsweb.repository;

import io.alexc.studentsweb.entity.ApplicationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationTypeRepository extends JpaRepository<ApplicationType, Integer> {
}
