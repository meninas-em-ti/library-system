package com.java.study.group.librarysystem.controller;

import com.java.study.group.librarysystem.dto.CourseDto;
import com.java.study.group.librarysystem.service.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CourseControllerTest {

  @Mock
  CourseService courseServiceMock;

  @Mock
  Model modelMock;

  @InjectMocks
  CourseController courseController;

  @Test
  void given_a_courseDto_registerCourse_returns_a_string() throws Exception {
    CourseDto courseDto = new CourseDto();
    courseDto.setName("Story time for kids");
    courseDto.setLimitOfCostumers(10);
    courseDto.setTimetable(LocalDateTime.parse("2022-09-26T00:12:43.482047"));
    courseDto.setAgeGroup("kids");
    courseDto.setPriceOfClass(25l);
    courseDto.setInstructorName("Ivone");

    when(courseServiceMock.register(courseDto)).thenReturn(true);

    String addCourseResponse = courseController.registerCourse(courseDto, any());

    assertThat(addCourseResponse).isEqualTo("redirect:/courses");
  }

  @Test
  void given_nullCourseDto_registerCourse_throws_NullPointerException() throws Exception {
    when(courseServiceMock.register(null)).thenThrow(NullPointerException.class);

    assertThat(courseController.registerCourse(null, modelMock))
        .isEqualTo("course");
  }
}