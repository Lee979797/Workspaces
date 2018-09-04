package com.ninemax.jpa.code.model;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-21
 * Time: обнГ2:28
 * To change this template use File | Settings | File Templates.
 */
public enum BaudRate {

    LOW(4800),
    MEDIUM(9600),
    HIGHT(115200);
    private Integer value;

    BaudRate(Integer name) {
        value = name;
    }

    public String getStatus() {
        return toString();
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
