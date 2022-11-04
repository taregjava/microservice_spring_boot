package com.halfacode.loginservice.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLoginResource {

    @GetMapping("/home")
    public String home(){
        return "public";
    }
    @GetMapping("/user")
    public String user(){
        return "User";
    }
    @GetMapping("/admin")
    public String admin(){
        return "Admin";
    }
}


