package com.my.dao;

import com.my.entity.Customer;

public interface CustomerDao {
    Customer findOne(String custId);
}
