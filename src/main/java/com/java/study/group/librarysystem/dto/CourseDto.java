package com.java.study.group.librarysystem.dto;

import com.java.study.group.librarysystem.model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    private String name;
    private int limitOfCostumers;
    private Instant startDateAndTime;
    private String ageGroup;
    private Long priceOfClass;
    private String instructorName;

    public Course toCourse(){
        Course course = new Course();
        course.setName(this.name);
        course.setLimitOfCostumers(this.limitOfCostumers);
        course.setAgeGroup(this.ageGroup);
        course.setInstructorName(this.instructorName);
        course.setPriceOfClass(this.priceOfClass);
        course.setStartDateAndTime(this.startDateAndTime);

        return course;
    }
}
