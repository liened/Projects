package com.exm.myboot.controller;

import com.exm.myboot.utils.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    MyProperties myProperties;

    @RequestMapping("/hello")
    public String hello(){
        String username = myProperties.getName();
        return username;
    }
}
