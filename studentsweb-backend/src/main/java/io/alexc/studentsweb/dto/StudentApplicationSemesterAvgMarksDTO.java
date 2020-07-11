package io.alexc.studentsweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor @AllArgsConstructor
public class StudentApplicationSemesterAvgMarksDTO {

    Integer semester;
    Double marksAverage;

}
