package com.ninemax.jpa.code.model;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-21
 * Time: ����2:28
 * To change this template use File | Settings | File Templates.
 */
public enum Jfly {
    QEBK("ȫ���"),
    CEBK("����"),
    CZBK("��������"),
    ZsZz("������֧"),
    QT("����"),
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
