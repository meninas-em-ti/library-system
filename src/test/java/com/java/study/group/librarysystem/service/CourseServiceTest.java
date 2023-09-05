package com.java.study.group.librarysystem.service;

import com.java.study.group.librarysystem.dto.CourseDto;
import com.java.study.group.librarysystem.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

  @Mock
  CourseRepository repository;

  @InjectMocks
  CourseService courseService;

  @Test
  void given_a_valid_courseDto_register_returns_true() throws Exception {
    CourseDto courseDto = new CourseDto();
    courseDto.setName("Story time for kids");
    courseDto.setLimitOfCostumers(10);
    courseDto.setTimetable(LocalDateTime.parse("2022-09-26T00:12:43.482047"));
    courseDto.setAgeGroup("kids");
    courseDto.setPriceOfClass(25l);
    courseDto.setInstructorName("Ivone");

    when(repository.save(courseDto.toCourse())).thenReturn(courseDto.toCourse());

    final Boolean isCourseRegistered = courseService.register(courseDto);
    assertThat(isCourseRegistered).isTrue();
  }

  @Test
  void given_nullCourseDto_register_throws_exception() {
    Exception exception = assertThrows(NullPointerException.class, () -> {
      courseService.register(null);
    });

    String expectedMessage = "Course details is null.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void given_validCourseDto_register_returns_false_for_database_exception() throws Exception {
    CourseDto courseDto = new CourseDto();
    courseDto.setName("Story time for kids");
    courseDto.setLimitOfCostumers(10);
    courseDto.setTimetable(LocalDateTime.parse("2022-09-26T00:12:43.482047"));
    courseDto.setAgeGroup("kids");
    courseDto.setPriceOfClass(25l);
    courseDto.setInstructorName("Ivone");

    when(repository.save(courseDto.toCourse())).thenThrow(new IllegalArgumentException());

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      courseService.register(courseDto);
    });

    String expectedMessage = "Error while trying to save the course in the database";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }
}