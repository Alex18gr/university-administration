package io.alexc.studentsweb.service;

import io.alexc.studentsweb.dto.AnnouncementDTO;

import java.util.List;

public interface AnnouncementService {

    List<AnnouncementDTO> getAnnouncementsByCurrentStudentDepartment();

}
