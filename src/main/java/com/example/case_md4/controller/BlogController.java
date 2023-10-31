package com.example.case_md4.controller;

import com.example.case_md4.model.Blog;
import com.example.case_md4.model.User;
import com.example.case_md4.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;
    @GetMapping
    public ModelAndView showUser(){
        ModelAndView modelAndView = new ModelAndView("blog/blogList");
        modelAndView.addObject("blog1", blogService.findAll());
        return modelAndView;
    }
    @GetMapping("/blogCreate")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/blog/blogCreate");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/blogCreate")
    public ModelAndView save(Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView= new ModelAndView("redirect:/blog");
        return modelAndView;
    }
}

