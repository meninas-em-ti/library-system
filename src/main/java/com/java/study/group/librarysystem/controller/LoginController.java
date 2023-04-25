package com.java.study.group.librarysystem.controller;

import com.java.study.group.librarysystem.dto.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String performLogin(final LoginDto loginDto, final Model model){

       if(loginDto.getUsername().equals("Admin") && loginDto.getPassword().equals("Admin@123")) {
            return "welcome";
       }
        model.addAttribute("error", "Incorrect Username & Password");
        return "login";

    }
}
