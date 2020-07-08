package io.alexc.studentsweb.repository;

import io.alexc.studentsweb.entity.UniversityService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityServiceRepository extends JpaRepository<UniversityService, Integer> {
}
