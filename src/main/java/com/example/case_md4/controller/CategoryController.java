package com.example.case_md4.controller;

import com.example.case_md4.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/manh")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping
    public ModelAndView showUser(){
        ModelAndView modelAndView = new ModelAndView("/views/list");
        modelAndView.addObject("manh", categoryService.findAll());
        return modelAndView;
    }
}
