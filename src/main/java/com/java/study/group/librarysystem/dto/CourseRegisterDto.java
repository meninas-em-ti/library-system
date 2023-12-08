package com.java.study.group.librarysystem.dto;

import com.java.study.group.librarysystem.model.Course;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
@NoArgsConstructor
public class CourseRegisterDto {
    private String name;
    private int limitOfCostumers;
    private String startDateAndTime;
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
        course.setStartDateAndTime(setStartDateAndTimeFromString(this.startDateAndTime));

        return course;
    }

    private LocalDateTime setStartDateAndTimeFromString(final String startDateAndTime){
        String pattern = "MM/dd/yyyy h:mm a";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern, Locale.US);
        LocalDateTime localDateTime = LocalDateTime.parse(startDateAndTime, dateTimeFormatter);

        return localDateTime;
    }
}
