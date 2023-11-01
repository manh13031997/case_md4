package com.example.case_md4.controller;
import com.example.case_md4.service.userDetail.IUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
