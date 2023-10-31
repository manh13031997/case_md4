package com.example.case_md4.controller;

import com.example.case_md4.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping
    public ModelAndView showUser(){
        ModelAndView modelAndView = new ModelAndView("views/categoryList");
        modelAndView.addObject("manh", categoryService.findAll());
        return modelAndView;
    }
}
