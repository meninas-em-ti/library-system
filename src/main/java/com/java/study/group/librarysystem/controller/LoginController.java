package com.java.study.group.librarysystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {

    @GetMapping("/signin")
    public String getLogin(Model model){
        model.addAttribute("coursesDto", "coursesDto");
        return "login";

    }
}
