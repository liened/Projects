package com.exm.myboot.service;

import com.exm.myboot.dao.StuInfoDao;
import com.exm.myboot.entity.StuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuInfoService {

    @Autowired
    StuInfoDao stuInfoDao;

    public StuInfo findByStuName(String stuName){
        return stuInfoDao.findByStuName(stuName);
    }
}
