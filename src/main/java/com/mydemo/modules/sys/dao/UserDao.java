package com.mydemo.modules.sys.dao;


import com.mydemo.common.persistence.CrudDao;
import com.mydemo.common.persistence.annotation.MyBatisDao;
import com.mydemo.modules.sys.entity.User;

@MyBatisDao
public interface UserDao extends CrudDao<User>{

    User getByLoginName(String loginName);
}
