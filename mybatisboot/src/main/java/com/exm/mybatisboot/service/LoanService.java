package com.exm.mybatisboot.service;

//import com.exm.mybatisboot.common.persistence.Page;
import com.exm.mybatisboot.dao.LoanDao;
import com.exm.mybatisboot.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
        List<Loan> list = loanDao.findLoans(loan);
        System.out.println("list:"+list);
        return list;
    }

//    public Page findPage(Page<Loan> page, Loan loan){
//        loan.setPage(page);
//        List<Loan> list = loanDao.findLoans(loan);
//        System.out.println(list);
//        page.setList(list);
//        return page;
//    }


    public int insert(Loan loan){
       return loanDao.insert(loan);
    }

    public int update(Loan loan){
        return loanDao.update(loan);
    }

    public int delete(String[] ids){
        return loanDao.delete(ids);
    }

    public Loan getByLoanNum(String loanNum){
        return loanDao.getByLoanNum(loanNum);
    }


}
