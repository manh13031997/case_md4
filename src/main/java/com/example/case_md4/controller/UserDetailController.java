package com.example.case_md4.controller;

import com.example.case_md4.model.UserDetail;
import com.example.case_md4.service.userDetail.IUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/userDetail")
public class UserDetailController {
    @Autowired
    IUserDetailService userDetailService;
    @GetMapping
    public ModelAndView showUser(){
        ModelAndView modelAndView = new ModelAndView("userDetail/userDetailList");
        modelAndView.addObject("userDetail1", userDetailService.findAll());
        return modelAndView;
    }
    @GetMapping("/userDetailCreate")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/userDetail/userDetailCreate");
        modelAndView.addObject("userDetail", new UserDetail());
        return modelAndView;
    }

    @PostMapping("userDetailCreate")
    public ModelAndView save(UserDetail userDetail){
        userDetailService.save(userDetail);
        ModelAndView modelAndView= new ModelAndView("redirect:/userDetail");
        return modelAndView;
    }
    @GetMapping("/userDetailEdit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/userDetail/userDetailEdit");
        modelAndView.addObject("userDetail1", userDetailService.findById(id).get());
        return modelAndView;
    }
    @PostMapping("/userDetailEdit")
    public ModelAndView update(UserDetail userDetail){
        userDetailService.save(userDetail);
        ModelAndView modelAndView= new ModelAndView("redirect:/userDetail");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView remove(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("redirect:/userDetail");
        userDetailService.remove(id);
        return modelAndView;
    }
}