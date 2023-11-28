package com.java.study.group.librarysystem.controller;

import com.java.study.group.librarysystem.dto.CourseDto;
import com.java.study.group.librarysystem.model.Course;
import com.java.study.group.librarysystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("courses")
public class TimetableController {

  @Autowired
  CourseRepository repository;


  @GetMapping("")
  public String listAllCourses(Model model){
    CourseDto courseDto = new CourseDto("Computers",30,
            Instant.parse("2020-01-23T00:00:00Z"),"Adult",10L,
            "Jack");
    List<CourseDto> courseDtoList =  new ArrayList<CourseDto>();
    List<Course> courseList = repository.findAll();
    for(Course course : courseList) {
      CourseDto courseDtoItem = new CourseDto(course.getName(),course.getLimitOfCostumers(),
          Instant.parse("2020-01-23T00:00:00Z"),course.getAgeGroup(),course.getPriceOfClass(),
              course.getInstructorName());
      courseDtoList.add(courseDtoItem);

    }
    courseDtoList = courseDtoList.isEmpty() ? Arrays.asList(courseDto,courseDto,courseDto) : courseDtoList;
    System.out.println(courseList);
    model.addAttribute("coursesDto", courseDtoList);

    return "timetable";
  }

}
