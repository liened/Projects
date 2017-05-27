package com.exm.myboot.controller;

import com.exm.myboot.entity.StuInfo;
import com.exm.myboot.service.StuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/stuInfo")
public class StuInfoController {

    @Autowired
    StuInfoService stuInfoService;

    @RequestMapping("get")
    public StuInfo get(HttpServletRequest request){
        String stuName = request.getParameter("stuName");
        System.out.println(stuName);
        StuInfo stuInfo = stuInfoService.findByStuName(stuName);
        System.out.println(stuInfo.getStdId()+" - "+stuInfo.getStuName());
        return stuInfo;
    }
}
