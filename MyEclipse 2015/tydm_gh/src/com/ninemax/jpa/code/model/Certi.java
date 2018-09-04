package com.ninemax.jpa.code.model;

/**
 * User: yzhhui
 * Date: 12-8-8
 * Time: ÏÂÎç5:05
 */
public class Certi {
    private String djhZb;
    private String djhFb;
    private String djhFbPre;
    private String fbSn;
    private String type;
    private String jgdm;
    private String jgmc;
    private String jglx;
    private String jgdz;
    private String QRCode;
    private String yxq;
    private String bzjgdm;
    private String djh;
    private Integer zbNumber;
    private Integer fbNumber;
    private Integer[] fbs;
    private String frdbMc;
    private String frdbValue;
    private String tsxx1;
    private String tsxx2;
    private String tsxx3;

    public String getDjhZb() {
        return djhZb;
    }

    public void setDjhZb(String djhZb) {
        this.djhZb = djhZb;
    }

    public String getDjhFb() {
        return djhFb;
    }

    public void setDjhFb(String djhFb) {
        this.djhFb = djhFb;
    }

    public String getDjhFbPre() {
        return djhFbPre;
    }

    public void setDjhFbPre(String djhFbPre) {
        this.djhFbPre = djhFbPre;
    }

    public String getFbSn() {
        if (fbSn == null || "".equals(fbSn))
            return "1";
        return fbSn;
    }

    public void setFbSn(String fbSn) {
        this.fbSn = fbSn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
    }

    public String getJgdz() {
        return jgdz;
    }

    public void setJgdz(String jgdz) {
        this.jgdz = jgdz;
    }

    public String getYxq() {
        return yxq;
    }

    public void setYxq(String yxq) {
        this.yxq = yxq;
    }

    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    public String getDjh() {
        return djh;
    }

    public void setDjh(String djh) {
        this.djh = djh;
    }

    public String getTsxx1() {
        return tsxx1;
    }

    public void setTsxx1(String tsxx1) {
        this.tsxx1 = tsxx1;
    }

    public String getTsxx2() {
        return tsxx2;
    }

    public void setTsxx2(String tsxx2) {
        this.tsxx2 = tsxx2;
    }

    public String getTsxx3() {
        return tsxx3;
    }

    public void setTsxx3(String tsxx3) {
        this.tsxx3 = tsxx3;
    }

    public Integer getZbNumber() {
        return zbNumber;
    }

    public void setZbNumber(Integer zbNumber) {
        this.zbNumber = zbNumber;
    }

    public Integer getFbNumber() {
        return fbNumber;
    }

    public void setFbNumber(Integer fbNumber) {
        this.fbNumber = fbNumber;
    }

    public String getFrdbMc() {
        return frdbMc;
    }

    public void setFrdbMc(String frdbMc) {
        this.frdbMc = frdbMc;
    }

    public String getFrdbValue() {
        return frdbValue;
    }

    public void setFrdbValue(String frdbValue) {
        this.frdbValue = frdbValue;
    }

    public String getQRCode() {
        return QRCode;
    }

    public void setQRCode(String QRCode) {
        this.QRCode = QRCode;
    }

    public Integer[] getFbs() {
        return fbs;
    }

    public void setFbs(Integer[] fbs) {
        this.fbs = fbs;
    }
}
