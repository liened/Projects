package com.exm.myboot.dao;

import com.exm.myboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {

    User findByUserName(String userName);

    User findByUserNameOrEmail(String userName,String email);

    User findByUserNameAndEmail(String userName,String email);
}
