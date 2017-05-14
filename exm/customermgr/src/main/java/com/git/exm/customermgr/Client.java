package com.git.exm.customermgr;

import com.git.exm.customermgr.dao.CustomerDAO;
import com.git.exm.customermgr.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class Client {

    @Autowired
    CustomerDAO dao;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Client t = (Client) ctx.getBean("client");
        Customer c1 = new Customer();
        c1.setCustId(1);

        Customer c2 = t.dao.getById(c1);
        System.out.println(c2.getCustNum());

    }

}
