package com.ninemax.jpa.code.model;

/**
 * User: yzhhui
 * Date: 12-6-21
 * Time: 下午2:28
 */
public enum PrinterType {
    P300系列(1),
    P400系列(2),
    NBS一体机(3);
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
