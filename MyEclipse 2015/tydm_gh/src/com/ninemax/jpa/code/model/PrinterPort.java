package com.ninemax.jpa.code.model;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-21
 * Time: обнГ2:28
 * To change this template use File | Settings | File Templates.
 */
public enum PrinterPort {
    LPT1("LPT1"),
    LPT2("LPT2"),
    COM1("COM1"),
    COM2("COM2"),
    COM3("COM3"),
    COM4("COM4");
    private String status;

    PrinterPort(String name) {
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
