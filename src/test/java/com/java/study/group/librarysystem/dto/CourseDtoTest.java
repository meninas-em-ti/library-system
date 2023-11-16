package com.java.study.group.librarysystem.dto;

import com.java.study.group.librarysystem.model.Course;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class CourseDtoTest {

  private CourseDto courseDto = new CourseDto();

  @Test
  void toCourse() {
    courseDto.setName("English Course");
    courseDto.setLimitOfCostumers(10);
    courseDto.setStartDateAndTime(LocalDateTime.parse("2022-09-26T00:12:43.482047"));
    courseDto.setAgeGroup("teens");
    courseDto.setPriceOfClass(10l);
    courseDto.setInstructorName("Elaine");

    final Course expectedCourse = new Course();
    expectedCourse.setName("English Course");
    expectedCourse.setLimitOfCostumers(10);
    expectedCourse.setStartDateAndTime(LocalDateTime.parse("2022-09-26T00:12:43.482047"));
    expectedCourse.setAgeGroup("teens");
    expectedCourse.setPriceOfClass(10l);
    expectedCourse.setInstructorName("Elaine");

    assertThat(courseDto.toCourse()).isEqualTo(expectedCourse);
  }
}