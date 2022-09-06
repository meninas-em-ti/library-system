package com.java.study.group.librarysystem.controller;

import com.java.study.group.librarysystem.dto.CourseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("courses")
public class TimetableController {

  @GetMapping("/timetable")
  public String displayCoursesTimetable() {
    return "timetable";
  }

  @GetMapping("/timetable-data")
  public List<CourseDto> listAllCourses(){
    CourseDto courseDto = new CourseDto("Computers",30, LocalDateTime.now(),"Adult",10L,12,45);
    return Arrays.asList(courseDto,courseDto,courseDto);

  }
}
