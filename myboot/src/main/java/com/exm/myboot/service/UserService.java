package com.exm.myboot.service;

import com.exm.myboot.entity.User;
import com.exm.myboot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Transactional
    public void save(User user){
        userDao.save(user);
    }

    public List<User> findAll(){
        return userDao.findAll();
    }

    public User findByUserName(String userName){
        return userDao.findByUserName(userName);
    }

    public User findByUserNameOrEmail(String userName,String email){
        return userDao.findByUserNameOrEmail(userName,email);
    }
}
