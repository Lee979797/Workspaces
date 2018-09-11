package com.my.service;

import com.my.entity.Customer;

public interface CustomerService {
    Customer findOne(String custId);
}
