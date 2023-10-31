package com.example.case_md4.controller;

import com.example.case_md4.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;
    @GetMapping
    public ModelAndView showUser(){
        ModelAndView modelAndView = new ModelAndView("views/blogList");
        modelAndView.addObject("manh", blogService.findAll());
        return modelAndView;
    }
}

