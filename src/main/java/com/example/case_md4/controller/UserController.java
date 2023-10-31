package com.example.case_md4.controller;

import com.example.case_md4.model.User;
import com.example.case_md4.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        modelAndView.addObject("user1", userService.findAll());
        return modelAndView;
    }
    @GetMapping("/userCreate")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/user/userCreate");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("userCreate")
    public ModelAndView save(User user){
        userService.save(user);
        ModelAndView modelAndView= new ModelAndView("redirect:/user");
        return modelAndView;
    }
}
