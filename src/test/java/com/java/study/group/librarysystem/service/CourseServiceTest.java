package com.java.study.group.librarysystem.service;

import com.java.study.group.librarysystem.dto.CourseRegisterDto;
import com.java.study.group.librarysystem.model.Course;
import com.java.study.group.librarysystem.repository.CourseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

  @Mock
  CourseRepository repository;

  @InjectMocks
  CourseService courseService;

  @AfterEach
  void afterEach() {
    verifyNoMoreInteractions(repository);
  }

  @Test
  void given_a_valid_courseDto_register_returns_true() {
    final CourseRegisterDto courseRegisterDto = new CourseRegisterDto();
    courseRegisterDto.setName("Story time for kids");
    courseRegisterDto.setLimitOfCostumers(10);
    courseRegisterDto.setStartDateAndTime("11/09/2022 12:43 AM");
    courseRegisterDto.setAgeGroup("kids");
    courseRegisterDto.setPriceOfClass(25l);
    courseRegisterDto.setInstructorName("Ivone");

    final Course course = courseRegisterDto.toCourse();
    when(repository.save(course)).thenReturn(course);

    assertThat(courseService.register(courseRegisterDto)).isTrue();
    verify(repository).save(course);
  }

  @Test
  void given_nullCourseDto_register_throws_exception() {
    Exception exception = assertThrows(NullPointerException.class, () -> {
      courseService.register(null);
    });

    final String expectedMessage = "Course details is null.";
    final String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void given_validCourseDto_register_returns_false_for_database_exception() {
    final CourseRegisterDto courseRegisterDto = new CourseRegisterDto();
    courseRegisterDto.setName("Story time for kids");
    courseRegisterDto.setLimitOfCostumers(10);
    courseRegisterDto.setStartDateAndTime("11/09/2022 12:43 AM");
    courseRegisterDto.setAgeGroup("kids");
    courseRegisterDto.setPriceOfClass(25l);
    courseRegisterDto.setInstructorName("Ivone");

    final Course course = courseRegisterDto.toCourse();
    when(repository.save(course)).thenThrow(new IllegalArgumentException());

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      courseService.register(courseRegisterDto);
    });

    final String expectedMessage = "Error while trying to save the course in the database";
    final String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }
}