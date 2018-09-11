package com.my.action;


import com.my.entity.Customer;
import com.my.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {
    //注入CustomerService对象;
    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    //属性注入：
    private String custId;

    public void setCustId(String custId) {
        this.custId = custId;
    }

    //根据主键查询：
    public String findOne() throws Exception {
        Customer customer = customerService.findOne(custId);
        ActionContext.getContext().getValueStack().push(customer);
        return SUCCESS;
    }
}
