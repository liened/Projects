package com.exm.demo.controller;


import com.exm.demo.entity.Loan;
import com.exm.demo.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    LoanService loanService;

    @RequestMapping("findLoans")
    public List<Loan> findLoans(Loan loan){
        System.out.println("============ findLoans ==========");
        return loanService.findLoans(loan);
    }

}
