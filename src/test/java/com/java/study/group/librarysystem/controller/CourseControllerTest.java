package com.java.study.group.librarysystem.controller;

import com.java.study.group.librarysystem.dto.CourseRegisterDto;
import com.java.study.group.librarysystem.service.CourseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CourseControllerTest {

  @Mock
  CourseService courseServiceMock;

  @Mock
  Model modelMock;

  @InjectMocks
  CourseController courseController;

  @AfterEach
  void afterEach() {
    verifyNoMoreInteractions(courseServiceMock, modelMock);
  }

  @Test
  void given_a_courseDto_registerCourse_returns_a_string(){
    final CourseRegisterDto courseRegisterDto = new CourseRegisterDto();
    courseRegisterDto.setName("Story time for kids");
    courseRegisterDto.setLimitOfCostumers(10);
    courseRegisterDto.setStartDateAndTime("11/09/2022 12:43 AM");
    courseRegisterDto.setAgeGroup("kids");
    courseRegisterDto.setPriceOfClass(new BigDecimal(25));
    courseRegisterDto.setInstructorName("Ivone");

    when(courseServiceMock.register(courseRegisterDto)).thenReturn(true);

    final String addCourseResponse = courseController.registerCourse(courseRegisterDto, modelMock);

    assertThat(addCourseResponse).isEqualTo("redirect:/courses");
    verify(courseServiceMock).register(courseRegisterDto);
  }

  @Test
  void given_nullCourseDto_registerCourse_returns_a_string(){
    when(courseServiceMock.register(null)).thenThrow(NullPointerException.class);

    assertThat(courseController.registerCourse(null, modelMock)).isEqualTo("course");
    verify(courseServiceMock).register(null);
    verify(modelMock).addAttribute(any(), any());
  }
}