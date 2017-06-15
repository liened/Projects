package com.exm.demo.controller;

import com.exm.demo.common.entity.Result;
import com.exm.demo.common.persistence.Page;
import com.exm.demo.common.web.BaseController;
import com.exm.demo.entity.Loan;
import com.exm.demo.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController extends BaseController{

    @Autowired
    LoanService loanService;

    @RequestMapping("findList")
    public List<Loan> findList(Loan loan){
        System.out.println("============ find List ==========");
        return loanService.findList(loan);
    }

    @RequestMapping("findPage")
    public Result findPage(HttpServletRequest request, HttpServletResponse response,Loan loan){
        Page<Loan> page = loanService.findPage(new Page<Loan>(request, response), loan);
        System.out.println("============ find Page ==========");
        return successResult(page);
    }

    @RequestMapping("delete")
    public Result delete(@RequestParam String[] ids){
        System.out.println("============= delete =============");
        loanService.deleteByIds(ids);
        return successResult(null);
    }

    @RequestMapping("saveOrUpdate")
    public Result saveOrUpdate(Loan loan){
        System.out.println("============= update =============");
        int t = loanService.saveOrUpdate(loan);
        if(t ==1){
            return successResult("更新成功");
        }else{
            return errorResult("更新失败");
        }
    }
}
