package com.ninemax.common.vo;

import java.io.Serializable;

public class CheckBoxType implements Serializable {
    private static final long serialVersionUID = -2689669421566312656L;
    private Integer id;
    private String expenseType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }
}
