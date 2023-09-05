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

    //TODO: Check localDateTime in the TimetableController class

    //TODO: Check if it's possible to include start and end date of the course at registration time

    //TODO: Check if we need to use select instead of text for instructor name field and if we need to keep the validate icon(bootstrap need-validation)

    //TODO: Test course registration

    //TODO: refactor welcome page
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
