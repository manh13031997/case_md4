package com.example.case_md4.controller;

import com.example.case_md4.model.User;
import com.example.case_md4.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;
    //    @GetMapping
//    public ModelAndView showUser(){
//        ModelAndView modelAndView = new ModelAndView("user/userList");
//        modelAndView.addObject("user1", userService.findAll());
//        return modelAndView;
//    }
    @GetMapping
    public ResponseEntity<Iterable<User>> showAllUserValid() {
        List<User> userList = (List<User>) userService.findAll();
        if (userList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<User> findByID(@PathVariable Long id) {
        User user = userService.findById(id).get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @GetMapping("/userCreate")
//    public ModelAndView showCreateForm(){
//        ModelAndView modelAndView = new ModelAndView("/user/userCreate");
//        modelAndView.addObject("user", new User());
//        return modelAndView;
//    }
//
//    @PostMapping("userCreate")
//    public ModelAndView save(User user){
//        userService.save(user);
//        ModelAndView modelAndView= new ModelAndView("redirect:/user");
//        return modelAndView;
//    }
//
//    @GetMapping("/userEdit/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id){
//        ModelAndView modelAndView = new ModelAndView("/user/userEdit");
//        modelAndView.addObject("user1", userService.findById(id).get());
//        return modelAndView;
//    }
//    @PostMapping("/userEdit")
//    public ModelAndView update(User user){
//        userService.save(user);
//        ModelAndView modelAndView= new ModelAndView("redirect:/user");
//        return modelAndView;
//    }
//
//    @GetMapping("/delete/{id}")
//    public ModelAndView remove(@PathVariable Long id){
//        ModelAndView modelAndView= new ModelAndView("redirect:/user");
//        userService.remove(id);
//        return modelAndView;
//    }
}