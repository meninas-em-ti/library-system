package com.java.study.group.librarysystem.controller;

import com.java.study.group.librarysystem.dto.LoginDto;
import com.java.study.group.librarysystem.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {

    @GetMapping("/signin")
    public String getLogin(Model model){
        model.addAttribute("coursesDto", "coursesDto");
        return "login";

    }

    @PostMapping("/signin")
    public String postLogin(LoginDto loginDto){
       System.out.println(loginDto.getUsername() + loginDto.getPassword());
       return "timetable";
    }
}
