package com.java.study.group.librarysystem.controller;

import com.java.study.group.librarysystem.dto.CourseDto;
import com.java.study.group.librarysystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("course")
public class CourseController {

    //TODO: in the course.html file: add H1 and margin and fix button in the welcome.html file.

    //TODO: in the course.html: validate the form inputs

    private final CourseService courseService;

    @GetMapping("/form/register")
    public String getRegisterForm() {
        return "course";
    }

    @PostMapping("/register")
    public String registerCourse(@ModelAttribute final CourseDto courseDto, final Model model) {
        try {
            courseService.register(courseDto);
            return "redirect:/courses";
        } catch (Exception exception) {
            model.addAttribute("error", exception.getMessage() + " Error to register course");
        }

        return "course";
    }
}
