package com.ninemax.jpa.code.model;

/**
 * * User: zhhuiyan
 * Date: 13-8-1
 * Time: ионГ9:25
 * Name:${Name}
 */
public class Kxx {
    public Kxx() {
    }

    public Kxx(TJgdm jgdm, TkKxxk kxxk) {
        this.jgdm = jgdm;
        this.kxxk = kxxk;
    }

    private TJgdm jgdm;
    private TkKxxk kxxk;

    public TkKxxk getKxxk() {
        return kxxk;
    }

    public void setKxxk(TkKxxk kxxk) {
        this.kxxk = kxxk;
    }

    public TJgdm getJgdm() {
        return jgdm;
    }

    public void setJgdm(TJgdm jgdm) {
        this.jgdm = jgdm;
    }
}
