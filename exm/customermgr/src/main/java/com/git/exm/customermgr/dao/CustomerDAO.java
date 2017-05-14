package com.git.exm.customermgr.dao;

import com.git.exm.customermgr.vo.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO {

    public int create(Customer customer);

    public int update(Customer customer);

    public int delete(Customer customer);

    public Customer getById(Customer customer);

    public List<Customer> getByCondition(Customer customer);

}
