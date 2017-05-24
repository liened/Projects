package com.exm.myboot.controller;

import com.exm.myboot.bean.User;
import com.exm.myboot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.junit.Assert;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping("save")
    public void save(){
        User u1 = new User("aa1","111","aa1@test.com","a1","20170524");
        User u2 = new User("aa2","222","aa2@test.com","a2","20170524");
        User u3 = new User("aa3","223","aa3@test.com","a3","20170524");
        userDao.save(u1);
        userDao.save(u2);
        userDao.save(u3);

        Assert.assertEquals(9,userDao.findAll().size());
        Assert.assertEquals("bb",userDao.findByUserNameOrEmail("bb","sdf"));
        userDao.delete(userDao.findByUserName("aa3"));
    }

}
