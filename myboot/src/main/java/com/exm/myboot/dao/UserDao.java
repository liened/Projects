package com.exm.myboot.dao;

import com.exm.myboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {

    User getByUserNameAndEmail(String userName,String email);
}
