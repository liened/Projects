package com.exm.mybatisboot.controller;

//import com.exm.mybatisboot.common.entity.Result;
//import com.exm.mybatisboot.common.persistence.Page;
//import com.exm.mybatisboot.common.web.BaseController;
import com.exm.mybatisboot.entity.Loan;
import com.exm.mybatisboot.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController{

    @Autowired
    LoanService loanService;


    @RequestMapping("getByLoanNum")
    public Loan getByLoanNum(@RequestParam String loanNum){
        return loanService.getByLoanNum(loanNum);
    }

    @RequestMapping("findLoans")
    public List<Loan> findLoans(HttpServletRequest request,HttpServletResponse response,Loan loan){
        System.out.println("========== findLoans ===========");
        return loanService.findLoans(loan);
    }

//    @RequestMapping("findPage")
//    public Result findPage(HttpServletRequest request, HttpServletResponse response,Loan loan){
//        System.out.println("=========== findPage =========");
//         Page<Loan> page = loanService.findPage(new Page(request, response), loan);
//        return this.successResult(page);
//    }
//
//    @RequestMapping("insert")
//    public Result insert(Loan loan){
//        Result result = new Result();
//        int t= loanService.insert(loan);
//        if(t == 1){
//            result.setStatus("200");
//        }else{
//            result.setStatus("300");
//        }
//        return result;
//    }
//
//    @RequestMapping("update")
//    public Result update(Loan loan){
//        Result result = new Result();
//        int t= loanService.update(loan);
//        if(t == 1){
//            result.setStatus("200");
//        }else{
//            result.setStatus("300");
//        }
//        return result;
//    }
//
//    @RequestMapping("delete")
//    public Result delete(@RequestParam String[] ids){
//        Result result = new Result();
//        loanService.delete(ids);
//        result.setStatus("200");
//        return result;
//    }
}
