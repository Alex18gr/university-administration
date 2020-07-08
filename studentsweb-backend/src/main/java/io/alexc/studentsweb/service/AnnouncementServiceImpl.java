package io.alexc.studentsweb.service;

import io.alexc.studentsweb.dto.AnnouncementDTO;
import io.alexc.studentsweb.entity.Announcement;
import io.alexc.studentsweb.entity.Student;
import io.alexc.studentsweb.repository.AnnouncementRepository;
import io.alexc.studentsweb.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    private final StudentService studentService;
    private final StudentRepository studentRepository;
    private final AnnouncementRepository announcementRepository;
    private final ModelMapper modelMapper;

    public AnnouncementServiceImpl(StudentService studentService, StudentRepository studentRepository, AnnouncementRepository announcementRepository, ModelMapper modelMapper) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
        this.announcementRepository = announcementRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AnnouncementDTO> getAnnouncementsByCurrentStudentDepartment() {

        Student currentStudent = studentRepository.getByUserId(studentService.getCurrentStudentId()).orElseThrow(RuntimeException::new);
        List<Announcement> announcements = announcementRepository.getByDepartment(currentStudent.getEnrolledDepartment());

        List<AnnouncementDTO> announcementDTOS = announcements.stream().map(this::convertAnnouncementToDto).collect(Collectors.toList());

        return announcementDTOS;
    }

    AnnouncementDTO convertAnnouncementToDto(Announcement announcement) {
        return modelMapper.map(announcement, AnnouncementDTO.class);
    }

}
