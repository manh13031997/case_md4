package com.example.case_md4.controller;

import com.example.case_md4.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Id;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    IUserService userService;
    @GetMapping
    public ModelAndView showUser(){
        ModelAndView modelAndView = new ModelAndView("user/userList");
        modelAndView.addObject("manh", userService.findAll());
        return modelAndView;
    }
}
