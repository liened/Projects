package com.exm.myboot.controller;

import com.exm.myboot.entity.User;
import com.exm.myboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("getUser")
    public User save(){
        User user = userService.findByUserNameOrEmail("aa1","");
        if(user == null){
            return null;
        }
        System.out.println(user.getNickName()+" - "+user.getEmail());
        return user;
    }

}
