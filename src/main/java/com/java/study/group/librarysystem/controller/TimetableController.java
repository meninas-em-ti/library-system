package com.java.study.group.librarysystem.controller;

import com.java.study.group.librarysystem.dto.CourseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("courses")
public class TimetableController {


  @GetMapping("/timetable")
  public String listAllCourses(Model model){
    CourseDto courseDto = new CourseDto("Computers",30,
            LocalDateTime.parse("2022-09-26T00:12:43.482047"),"Adult",10L,
            12,45);
    List<CourseDto> courseDtoList =  Arrays.asList(courseDto,courseDto,courseDto);
    model.addAttribute("coursesDto", courseDtoList);

    return "timetable";
  }

  @PostMapping("/timetables")
  public String loginSubmit(Model model){
    return "login";

  }
}
