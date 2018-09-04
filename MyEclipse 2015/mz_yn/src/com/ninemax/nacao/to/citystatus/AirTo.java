package com.ninemax.nacao.to.citystatus;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2010-11-6
 * Time: 17:37:24
 * To change this template use File | Settings | File Templates.
 */
public class AirTo implements java.io.Serializable {

    
private String dq;
    private String kqwrzs;//空气污染指数

    public String getDq() {
        return dq;
    }

    public void setDq(String dq) {
        this.dq = dq;
    }

    public String getKqwrzs() {
        return kqwrzs;
    }

    public void setKqwrzs(String kqwrzs) {
        this.kqwrzs = kqwrzs;
    }

    public String getWrlx() {
        return wrlx;
    }

    public void setWrlx(String wrlx) {
        this.wrlx = wrlx;
    }

    public String getWrjb() {
        return wrjb;
    }

    public void setWrjb(String wrjb) {
        this.wrjb = wrjb;
    }

    public String getKqzl() {
        return kqzl;
    }

    public void setKqzl(String kqzl) {
        this.kqzl = kqzl;
    }

    public String getXzqhdm() {
        return xzqhdm;
    }

    public void setXzqhdm(String xzqhdm) {
        this.xzqhdm = xzqhdm;
    }

    public String getNian() {
        return nian;
    }

    public void setNian(String nian) {
        this.nian = nian;
    }

    public String getYue() {
        return yue;
    }

    public void setYue(String yue) {
        this.yue = yue;
    }

    public String getRi() {
        return ri;
    }

    public void setRi(String ri) {
        this.ri = ri;
    }

    private String wrlx;//污染类型
    private String wrjb;//污染级别
    private String kqzl;//空气质量
    private String xzqhdm;//行政区划代码
    private String nian;//年
    private String yue;//月
    private String ri;//鈤

}
