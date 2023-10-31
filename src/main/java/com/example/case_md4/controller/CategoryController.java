package com.example.case_md4.controller;

import com.example.case_md4.model.Category;
import com.example.case_md4.model.User;
import com.example.case_md4.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        ModelAndView modelAndView = new ModelAndView("category/categoryList");
        modelAndView.addObject("category1", categoryService.findAll());
        return modelAndView;
    }
    @GetMapping("/categoryCreate")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/category/categoryCreate");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("categoryCreate")
    public ModelAndView save(Category category){
        categoryService.save(category);
        ModelAndView modelAndView= new ModelAndView("redirect:/category");
        return modelAndView;
    }
}
