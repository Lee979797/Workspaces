package com.ninemax.jpa.code.model;

/**
 * User: yzhhui
 * Date: 12-6-21
 * Time: ����2:28
 */
public enum PrinterType {
    P300ϵ��(1),
    P400ϵ��(2),
    NBSһ���(3);
    private Short value;

    PrinterType(Integer name) {
        value = name.shortValue();
    }

    public String getStatus() {
        return toString();
    }

    public Short getValue() {
        return value;
    }
}
