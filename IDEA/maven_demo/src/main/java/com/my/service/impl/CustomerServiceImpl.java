package com.my.service.impl;

import com.my.dao.CustomerDao;
import com.my.entity.Customer;
import com.my.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    //注入CustomerDao
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Customer findOne(String custId) {
        return customerDao.findOne(custId);
    }
}
