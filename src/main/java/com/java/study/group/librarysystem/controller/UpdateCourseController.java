package com.java.study.group.librarysystem.controller;

import com.java.study.group.librarysystem.dto.UpdateCourseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("update-course")
public class UpdateCourseController {

        @GetMapping("/courses")
        public String getCourse(Model model) {
                model.addAttribute("LoginDto", "loginDto");
                return "update-course";

        }


        @PostMapping("/courses") //course/create-course
        public String performCreateCourse(final UpdateCourseDto updateCourseDto, final Model model) {

                return "update-course"; //update-course.html

        }
}
