package com.ninemax.jpa.code.model;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-21
 * Time: 下午2:28
 * To change this template use File | Settings | File Templates.
 */
public enum Jfly {
    QEBK("全额拨款"),
    CEBK("差额拨款"),
    CZBK("财政拨款"),
    ZsZz("自收自支"),
    QT("其它"),
    NO("");
    private String status;

    Jfly(String name) {
        status = name;
    }

    @Override
    public String toString() {
        return status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
