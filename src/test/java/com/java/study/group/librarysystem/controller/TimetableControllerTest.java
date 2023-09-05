package com.java.study.group.librarysystem.controller;

import com.java.study.group.librarysystem.dto.CourseDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class TimetableControllerTest {
    @Mock
    private Model modelMock;

    private TimetableController timetableController;

    @BeforeEach
    void setUp() {
        timetableController = new TimetableController();
    }

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(modelMock);
    }

    @Test
    void listAllCourses_returns_timetable_page() {
        final CourseDto expectedCourseDto = new CourseDto("Computers",30,
                LocalDateTime.parse("2022-09-26T00:12:43.482047"),"Adult",10L,
                12,45);

        assertThat(timetableController.listAllCourses(modelMock)).isEqualTo("timetable");
        verify(modelMock).addAttribute("coursesDto", Arrays.asList(expectedCourseDto,expectedCourseDto,expectedCourseDto));
    }
}