package com.exm.myboot.dao;

import com.exm.myboot.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long>{

    List<User> findAllByOrderByUserNoAsc();

    User findByUserNoOrUserName(String userNo,String userName);

    List<User> findByUserNoLike(String userNo);

    //分页查询
    Page<User> findAll(Pageable pageable);

    Page<User> findByUserNoLike(String userNo,Pageable pageable);

    /**
     * Order by
     * @return
     */
    User findFirstByOrderByUserNoAsc();

    List<User> findTop3ByOrderByUserNoDesc();

    /**
     * 更新
     * @param userName
     * @param userNo
     * @return
     */
    @Transactional
    @Modifying
    @Query("update User u set u.userName=?1 where u.userNo = ?2")
    int updateByUserNo(String userName,String userNo);
}
