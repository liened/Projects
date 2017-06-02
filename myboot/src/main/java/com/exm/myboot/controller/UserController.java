package com.exm.myboot.controller;

import com.exm.myboot.entity.User;
import com.exm.myboot.service.UserService;
import oracle.jrockit.jfr.events.RequestableEventEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("findAll")
    public List<User> findAll(){
        List<User> lst = userService.findAll();
        return lst;
    }

    @RequestMapping("save")
    public void save(User user){
        userService.saveUser(user);
    }

    @RequestMapping("findOne")
    public User findOne(HttpServletRequest request){
        String userNo = request.getParameter("userNo");
        String userName = request.getParameter("userName");
        User user = userService.findByUserNoOrUserName(userNo,userName);
        return user;
    }

    /**
     * 分页查询 传入Pageable即可，多个参数时，将Pageable放在最后面
     * @param request
     * @return
     */
    @RequestMapping("findPage")
    public Page<User> findPage(HttpServletRequest request){
        String pageStr = request.getParameter("page");
        int page = Integer.parseInt(pageStr),size = 2;
        Sort sort = new Sort(Sort.Direction.ASC,"userNo");
        Pageable pageable = new PageRequest(page, size, sort);
        return userService.findPage(pageable);
    }

    @RequestMapping("findLike")
    public Page<User> findByUserNoPage(HttpServletRequest request){
        String pageStr = request.getParameter("page");
        String userNo = request.getParameter("userNo");
        int page = Integer.parseInt(pageStr),size = 2;
        Sort sort = new Sort(Sort.Direction.ASC,"userNo");
        Pageable pageable = new PageRequest(page, size, sort);
        return userService.findByUserNoLike(userNo,pageable);
    }

    @RequestMapping("like")
    public List<User> like(HttpServletRequest request){
        String no = request.getParameter("no");
        return userService.findByUserNoLike(no);
    }

    @RequestMapping("update")
    public int test(HttpServletRequest request){
        String userNo = request.getParameter("no");
        String userName = request.getParameter("name");
        int t = userService.updateByUserNo(userName,userNo);
        return t;
    }

    @RequestMapping("findFirst")
    public User findFirst(){
        return userService.findFirstByOrderByUserNoAsc();
    }

    @RequestMapping("findLast")
    public List<User> findLast(){
        return userService.findLast3ByUserNo();
    }
}
