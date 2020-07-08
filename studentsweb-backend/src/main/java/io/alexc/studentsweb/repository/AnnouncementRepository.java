package io.alexc.studentsweb.repository;

import io.alexc.studentsweb.entity.Announcement;
import io.alexc.studentsweb.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {

    List<Announcement> getByDepartment(Department department);

}
