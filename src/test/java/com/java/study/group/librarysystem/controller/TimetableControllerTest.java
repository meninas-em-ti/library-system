package com.java.study.group.librarysystem.controller;

import com.java.study.group.librarysystem.dto.CourseDto;
import com.java.study.group.librarysystem.model.Course;
import com.java.study.group.librarysystem.repository.CourseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TimetableControllerTest {
    @Mock
    private Model modelMock;

    @Mock
    private CourseRepository repository;

    @InjectMocks
    private TimetableController timetableController;

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(modelMock, repository);
    }

    @Test
    void listAllCourses_returns_timetable_page() {
        final Course course = new Course(1l, "Computers",30,
            LocalDateTime.parse("2022-09-26T00:12:43.482047"),"Adult",10L, "Bruna");

        final CourseDto expectedCourseDto = new CourseDto("Computers",30,
            LocalDateTime.parse("2022-09-26T00:12:43.482047"),"Adult",10L, "Bruna");

        when(repository.findAll()).thenReturn(List.of(course));

        assertThat(timetableController.listAllCourses(modelMock)).isEqualTo("timetable");
        verify(repository).findAll();
        verify(modelMock).addAttribute("coursesDto", Arrays.asList(expectedCourseDto));
    }
}