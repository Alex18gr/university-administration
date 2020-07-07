package io.alexc.studentsweb.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class StudentCourseRegistrationDTO {

    private String registryNumber;
    private String name;
    private Integer mark;
    private List<StudentCourseRegistrationProfessorDTO> professors;

    @Getter @Setter @RequiredArgsConstructor @AllArgsConstructor
    public static class StudentCourseRegistrationProfessorDTO {
        private String name;
        private String email;
        private String title;
        private String url;
    }

}
