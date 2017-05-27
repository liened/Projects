package com.exm.myboot.dao;

import com.exm.myboot.entity.StuInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StuInfoDao extends JpaRepository<StuInfo,String>{

    StuInfo findByStuName(String stuName);

}
