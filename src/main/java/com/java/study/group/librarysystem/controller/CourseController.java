package com.java.study.group.librarysystem.controller;

import com.java.study.group.librarysystem.dto.CourseDto;
import com.java.study.group.librarysystem.model.Course;
import com.java.study.group.librarysystem.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("course")
public class CourseController {

    private final CourseRepository repository;

    @GetMapping("/form/register")
    public String getRegisterForm() {
        return "course";
    }

    @PostMapping("/register")
    public String registerCourse(@ModelAttribute final CourseDto courseDto){
        System.out.println(courseDto.getName());
        System.out.println(courseDto.getLimitOfCostumers());
        System.out.println(courseDto.getPriceOfClass());
        System.out.println(courseDto.getAgeGroup());
        System.out.println(courseDto.getInstructorName());

        Course courseSaved = repository.save(courseDto.toCourse());

        return "redirect:/courses";
    }
}
