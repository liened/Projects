package com.exm.demo.service;

import com.exm.demo.common.persistence.Page;
import com.exm.demo.dao.LoanDao;
import com.exm.demo.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LoanService {

    @Autowired
    LoanDao loanDao;

    @Transactional(readOnly = true)
    public List<Loan> findLoans(Loan loan){
        return loanDao.findList(loan);
    }

    @Transactional(readOnly = true)
    public Page findPage(Page<Loan> page, Loan loan){
        loan.setPage(page);
        List<Loan> list = loanDao.findList(loan);
        System.out.println(list);
        page.setList(list);
        return page;
    }

    public int insert(Loan loan){
        return loanDao.insert(loan);
    }

    public int update(Loan loan){
        return loanDao.update(loan);
    }

    public int deleteByIds(String[] ids){
        return loanDao.deleteByIds(ids);
    }

}
