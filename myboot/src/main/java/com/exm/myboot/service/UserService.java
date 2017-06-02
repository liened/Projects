package com.exm.myboot.service;

import com.exm.myboot.dao.UserDao;
import com.exm.myboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    /**
     * Save方法
     * @param user
     */
    @Transactional
    public void saveUser(User user){
        userDao.save(user);
    }

    /**
     * 查询所有
     * @return
     */
    @Transactional(readOnly = true)
    public List<User> findAll(){
        return userDao.findAllByOrderByUserNoAsc();
    }

    /**
     * Or 条件查询
     * @param userNo
     * @param userName
     * @return
     */
    @Transactional(readOnly = true)
    public User findByUserNoOrUserName(String userNo,String userName){
        return userDao.findByUserNoOrUserName(userNo,userName);
    }

    /**
     * 查询所有的分页
     * @param pageable
     * @return
     */
    public Page<User> findPage(Pageable pageable){
        return userDao.findAll(pageable);
    }

    /**
     * Like 查询
     *  注意：传的参数要自己处理%
     * @param userNo
     * @return
     */
    public List<User> findByUserNoLike(String userNo){
        StringBuilder sb = new StringBuilder(2);
        sb.append("%");
        sb.append(userNo);
        sb.append("%");
        return userDao.findByUserNoLike(sb.toString());
    }

    /**
     * Like 分页
     *  注意：把分页的参数Pageable放在最后
     * @param userNo
     * @param pageable
     * @return
     */
    public Page<User> findByUserNoLike(String userNo,Pageable pageable){
        StringBuilder sb = new StringBuilder(2);
        if(userNo != null && !"".equals(userNo)){
            sb.append("%");
            sb.append(userNo);
            sb.append("%");
        }
        return userDao.findByUserNoLike(sb.toString(),pageable);
    }

    /**
     *  自定义更新的方法
     * @param userName
     * @param userNo
     * @return
     */
    public int updateByUserNo(String userName,String userNo){
        return userDao.updateByUserNo(userName,userNo);
    }

    /**
     * Order by
     * @return
     */
    public User findFirstByOrderByUserNoAsc(){
        return userDao.findFirstByOrderByUserNoAsc();
    }

    /**
     * Order by 区间查询
     * @return
     */
    public List<User> findLast3ByUserNo(){
        return userDao.findLast3ByUserNo();
    }
}
