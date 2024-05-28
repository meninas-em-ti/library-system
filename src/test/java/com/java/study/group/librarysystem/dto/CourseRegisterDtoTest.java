package com.java.study.group.librarysystem.dto;

import com.java.study.group.librarysystem.model.Course;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

class CourseRegisterDtoTest {

  private CourseRegisterDto courseRegisterDto;

  @Test
  void toCourse() {
    final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a", Locale.US);

    final Course expectedCourse = new Course();
    expectedCourse.setName("Story time for kids");
    expectedCourse.setLimitOfCostumers(10);
    expectedCourse.setStartDateAndTime(LocalDateTime.parse("11/09/2022 12:43 AM", dateTimeFormatter));
    expectedCourse.setAgeGroup("kids");
    expectedCourse.setPriceOfClass(new BigDecimal(25.5));
    expectedCourse.setInstructorName("Ivone");

    courseRegisterDto = new CourseRegisterDto();
    courseRegisterDto.setName("Story time for kids");
    courseRegisterDto.setLimitOfCostumers(10);
    courseRegisterDto.setStartDateAndTime("11/09/2022 12:43 AM");
    courseRegisterDto.setAgeGroup("kids");
    courseRegisterDto.setPriceOfClass(new BigDecimal(25.5));
    courseRegisterDto.setInstructorName("Ivone");

    assertThat(courseRegisterDto.toCourse()).isEqualTo(expectedCourse);
  }
}