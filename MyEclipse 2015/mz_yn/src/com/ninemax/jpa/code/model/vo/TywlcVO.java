package com.ninemax.jpa.code.model.vo;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-11-1
 * Time: ÉÏÎç11:30
 */
public class TywlcVO {

    public TywlcVO() {
    }

    public TywlcVO(String ywlsh, String jgdm, String jgmc, Date clsj) {
        this.ywlsh = ywlsh;
        this.jgdm = jgdm;
        this.jgmc = jgmc;
        this.clsj = clsj;
    }

    public TywlcVO(String ywlsh, Integer ywlclx, String type, String isend, String jgdm, String jgmc, String bzjgdm, Date clsj, Long id, String flag, String shflag) {
        this.ywlsh = ywlsh;
        this.ywlclx = ywlclx;
        this.type = type;
        this.isend = isend;
        this.jgdm = jgdm;
        this.jgmc = jgmc;
        this.bzjgdm = bzjgdm;
        this.clsj = clsj;
        this.id = id;
        this.flag = flag;
        this.shflag = shflag;
    }

    private String ywlsh;

    public String getYwlsh() {
        return ywlsh;
    }

    public void setYwlsh(String ywlsh) {
        this.ywlsh = ywlsh;
    }

    private Integer ywlclx;

    public Integer getYwlclx() {
        return ywlclx;
    }

    public void setYwlclx(Integer ywlclx) {
        this.ywlclx = ywlclx;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String isend;

    public String getIsend() {
        return isend;
    }

    public void setIsend(String isend) {
        this.isend = isend;
    }

    private String jgdm;

    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String jgmc;

    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    private String bzjgdm;

    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    private Date clsj;

    public Date getClsj() {
        return clsj;
    }

    public void setClsj(Date clsj) {
        this.clsj = clsj;
    }

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private String shflag;

    public String getShflag() {
       return shflag;
    }

    public void setShflag(String shflag) {
       this.shflag = shflag;
    }


}
