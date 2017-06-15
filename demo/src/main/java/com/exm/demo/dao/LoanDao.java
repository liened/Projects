package com.exm.demo.dao;


import com.exm.demo.common.dao.BaseDao;
import com.exm.demo.entity.Loan;

public interface LoanDao extends BaseDao<Loan>{

    int deleteByIds(String[] ids);

    Loan getByLoanNum(Loan loan);
}
