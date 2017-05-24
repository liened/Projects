package com.exm.myboot.dao;

import com.exm.myboot.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {

    User findByUserName(String userName);

    User findByUserNameOrEmail(String username,String email);

}
