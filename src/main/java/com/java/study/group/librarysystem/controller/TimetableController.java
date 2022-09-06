package com.java.study.group.librarysystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("courses")
public class TimetableController {

  @GetMapping("/timetable")
  public String displayCoursesTimetable() {
    return "timetable";
  }
}
