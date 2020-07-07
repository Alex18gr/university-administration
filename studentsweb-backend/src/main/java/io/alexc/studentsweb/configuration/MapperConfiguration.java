package io.alexc.studentsweb.configuration;

import io.alexc.studentsweb.dto.StudentCourseRegistrationDTO;
import io.alexc.studentsweb.entity.Employee;
import io.alexc.studentsweb.entity.Student;
import io.alexc.studentsweb.entity.StudentCourseRegistration;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class MapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(StudentCourseRegistration.class, StudentCourseRegistrationDTO.class)
                .addMapping(src -> src.getCourse().getRegistryNumber(), StudentCourseRegistrationDTO::setRegistryNumber)
                .addMapping(src -> src.getCourse().getName(), StudentCourseRegistrationDTO::setName)
                .addMapping(StudentCourseRegistration::getMark, StudentCourseRegistrationDTO::setMark)
                .addMapping(src -> new HashSet<>(), StudentCourseRegistrationDTO::setProfessors);

        modelMapper.typeMap(Employee.class, StudentCourseRegistrationDTO.StudentCourseRegistrationProfessorDTO.class)
                .addMapping(Employee::getName, StudentCourseRegistrationDTO.StudentCourseRegistrationProfessorDTO::setName)
                .addMapping(Employee::getEmail, StudentCourseRegistrationDTO.StudentCourseRegistrationProfessorDTO::setEmail)
                .addMapping(Employee::getTitle, StudentCourseRegistrationDTO.StudentCourseRegistrationProfessorDTO::setTitle)
                .addMapping(Employee::getSiteUrl, StudentCourseRegistrationDTO.StudentCourseRegistrationProfessorDTO::setUrl);

        modelMapper.validate();

        return modelMapper;
    }

}
