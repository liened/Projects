package com.exm.myboot.controller;

import com.exm.myboot.entity.User;
import com.exm.myboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("get")
    public User get(HttpServletRequest request){
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        System.out.println("----------------------------------------------");
        System.out.println("userName:"+userName+" - "+"email:"+email);
        System.out.println("----------------------------------------------");
        User user = userService.getByUserNameAndEmail(userName,email);
        if(user == null){
            return null;
        }
        System.out.println(user.getNickName()+" - "+user.getEmail());
        return user;
    }

}
