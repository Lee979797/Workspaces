package com.my.dao.impl;

import com.my.dao.CustomerDao;
import com.my.entity.Customer;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
    @Override
    public Customer findOne(String custId) {
        return (Customer) this.getHibernateTemplate().get(Customer.class, custId);
    }
}
