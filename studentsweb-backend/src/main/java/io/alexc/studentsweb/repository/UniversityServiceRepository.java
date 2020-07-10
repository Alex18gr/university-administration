package io.alexc.studentsweb.repository;

import io.alexc.studentsweb.entity.UniversityService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UniversityServiceRepository extends JpaRepository<UniversityService, Integer> {


    @Query("select distinct serv from UniversityService serv where serv.applicationTypes.size > 0 ")
    List<UniversityService> getByApplicationTypesIsNotNull();

}
