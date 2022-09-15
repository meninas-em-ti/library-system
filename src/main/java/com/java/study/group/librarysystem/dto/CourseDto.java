package com.java.study.group.librarysystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    private String name;
    private int limitOfCostumers;
    private LocalDateTime timetable;
    private String ageGroup;
    private Long priceOfClass;
    private int numberOfClasses;
    private int durationOfClasses;
}
