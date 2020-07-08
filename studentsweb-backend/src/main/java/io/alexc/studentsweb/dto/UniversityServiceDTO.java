package io.alexc.studentsweb.dto;

import io.alexc.studentsweb.entity.ApplicationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class UniversityServiceDTO {

    private String name;
    private String description;
    private List<ServiceApplicationTypeDTO> applicationTypes;

    @Getter
    @Setter
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class ServiceApplicationTypeDTO {

        private Integer applicationTypeId;
        private String name;
        private String description;

    }

}
