package com.exm.mybatisboot.dao;

import com.exm.mybatisboot.entity.Loan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface LoanDao {

    List<Loan> findLoans(Loan loan);

    int insert(Loan loan);

    int update(Loan loan);

    int delete(String[] ids);

    Loan getByLoanNum(String loanNum);
}
