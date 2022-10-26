package com.halfacode.userservice.controller;

import com.halfacode.userservice.dto.ResponseTemplateVO;
import com.halfacode.userservice.entity.User;
import com.halfacode.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userid){
        return userService.getUserWithDepartment(userid);
    }


}
