package com.java.study.group.librarysystem.controller;

import com.java.study.group.librarysystem.dto.CourseDto;
import com.java.study.group.librarysystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("course")
public class CourseController {

    @Autowired
    CourseRepository repository;

    @GetMapping("")
    public String getCourse(Model model) {
        System.out.println();
        return "course";
    }

    @PostMapping("/register")
    public String addCourse(@ModelAttribute CourseDto courseDto, Model model){
        System.out.println(courseDto.getName());
        System.out.println(courseDto.getLimitOfCostumers());
        System.out.println(courseDto.getPriceOfClass());
        System.out.println(courseDto.getAgeGroup());
        System.out.println(courseDto.getInstructorName());

        repository.save(courseDto.toCourse());

        return "redirect:/courses";
    }
}
