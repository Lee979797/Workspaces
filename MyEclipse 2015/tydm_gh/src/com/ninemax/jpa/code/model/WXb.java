package com.ninemax.jpa.code.model;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 13-5-24
 * Time: ÏÂÎç2:42
 */
@javax.persistence.Table(name = "w_xb")
@Entity
public class WXb {
    private int id;

    @javax.persistence.Column(name = "w_xb_id", nullable = false, insertable = true, updatable = true, length = 9, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String djh;

    @javax.persistence.Column(name = "w_xb_djh", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getDjh() {
        return djh;
    }

    public void setDjh(String djh) {
        this.djh = djh;
    }

    private String jgdm;

    @javax.persistence.Column(name = "w_xb_jgdm", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String jgmc;

    @javax.persistence.Column(name = "w_xb_jgmc", nullable = true, insertable = true, updatable = true, length = 100, precision = 0)
    @Basic
    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    private String fddbr;

    @javax.persistence.Column(name = "w_xb_fddbr", nullable = true, insertable = true, updatable = true, length = 100, precision = 0)
    @Basic
    public String getFddbr() {
        return fddbr;
    }

    public void setFddbr(String fddbr) {
        this.fddbr = fddbr;
    }

    private String jglx;

    @javax.persistence.Column(name = "w_xb_jglx", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
    }

    private String zjlx;

    @javax.persistence.Column(name = "w_xb_zjlx", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getZjlx() {
        return zjlx;
    }

    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }

    private String zjhm;

    @javax.persistence.Column(name = "w_xb_zjhm", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    private String jyfw;

    @javax.persistence.Column(name = "w_xb_jyfw", nullable = true, insertable = true, updatable = true, length = 1000, precision = 0)
    @Basic
    public String getJyfw() {
        return jyfw;
    }

    public void setJyfw(String jyfw) {
        this.jyfw = jyfw;
    }

    private String jjhy;

    @javax.persistence.Column(name = "w_xb_jjhy", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getJjhy() {
        return jjhy;
    }

    public void setJjhy(String jjhy) {
        this.jjhy = jjhy;
    }

    private String njjhy;

    @javax.persistence.Column(name = "w_xb_xjjhy", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getNjjhy() {
        return njjhy;
    }

    public void setNjjhy(String njjhy) {
        this.njjhy = njjhy;
    }

    private String jjlx;

    @javax.persistence.Column(name = "w_xb_jjlx", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getJjlx() {
        return jjlx;
    }

    public void setJjlx(String jjlx) {
        this.jjlx = jjlx;
    }

    private String njjlx;

    @javax.persistence.Column(name = "w_xb_xjjlx", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getNjjlx() {
        return njjlx;
    }

    public void setNjjlx(String njjlx) {
        this.njjlx = njjlx;
    }

    private Date zcrq;

    @javax.persistence.Column(name = "w_xb_clrq", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date getZcrq() {
        return zcrq;
    }

    public void setZcrq(Date zcrq) {
        this.zcrq = zcrq;
    }

    private Integer zgrs;

    @javax.persistence.Column(name = "w_xb_zgrs", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public Integer getZgrs() {
        return zgrs;
    }

    public void setZgrs(Integer zgrs) {
        this.zgrs = zgrs;
    }

    private String zgdm;

    @javax.persistence.Column(name = "w_xb_zgjg", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getZgdm() {
        return zgdm;
    }

    public void setZgdm(String zgdm) {
        this.zgdm = zgdm;
    }

    private Double zczj;

    @javax.persistence.Column(name = "w_xb_zczj", nullable = true, insertable = true, updatable = true, length = 18, precision = 4)
    @Basic
    public Double getZczj() {
        return zczj;
    }

    public void setZczj(Double zczj) {
        this.zczj = zczj;
    }

    private String hbzl;

    @javax.persistence.Column(name = "w_xb_hbzl", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getHbzl() {
        return hbzl;
    }

    public void setHbzl(String hbzl) {
        this.hbzl = hbzl;
    }

    private String wftzgb;

    @javax.persistence.Column(name = "w_xb_wfgb", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getWftzgb() {
        return wftzgb;
    }

    public void setWftzgb(String wftzgb) {
        this.wftzgb = wftzgb;
    }

    private String xzqh;

    @javax.persistence.Column(name = "w_xb_xzqh", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    private String jgdz;

    @javax.persistence.Column(name = "w_xb_dwdz", nullable = true, insertable = true, updatable = true, length = 200, precision = 0)
    @Basic
    public String getJgdz() {
        return jgdz;
    }

    public void setJgdz(String jgdz) {
        this.jgdz = jgdz;
    }

    private String yzbm;

    @javax.persistence.Column(name = "w_xb_yzbm", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    private String dhhm;

    @javax.persistence.Column(name = "w_xb_lxdh", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getDhhm() {
        return dhhm;
    }

    public void setDhhm(String dhhm) {
        this.dhhm = dhhm;
    }

    private String pzjgdm;

    @javax.persistence.Column(name = "w_xb_pzjg", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getPzjgdm() {
        return pzjgdm;
    }

    public void setPzjgdm(String pzjgdm) {
        this.pzjgdm = pzjgdm;
    }

    private String zch;

    @javax.persistence.Column(name = "w_xb_pzwh", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getZch() {
        return zch;
    }

    public void setZch(String zch) {
        this.zch = zch;
    }

    private String mobile;

    @javax.persistence.Column(name = "w_xb_frdh", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    private Integer fbsl;

    @javax.persistence.Column(name = "w_xb_fbsl1", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public Integer getFbsl() {
        return fbsl;
    }

    public void setFbsl(Integer fbsl) {
        this.fbsl = fbsl;
    }

    private Integer fksl;

    @javax.persistence.Column(name = "w_xb_fbsl2", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public Integer getFksl() {
        return fksl;
    }

    public void setFksl(Integer fksl) {
        this.fksl = fksl;
    }

    private String fbsl3;

    @javax.persistence.Column(name = "w_xb_fbsl3", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public String getFbsl3() {
        return fbsl3;
    }

    public void setFbsl3(String fbsl3) {
        this.fbsl3 = fbsl3;
    }

    private String email;

    @javax.persistence.Column(name = "w_xb_email", nullable = true, insertable = true, updatable = true, length = 100, precision = 0)
    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String url;

    @javax.persistence.Column(name = "w_xb_url", nullable = true, insertable = true, updatable = true, length = 100, precision = 0)
    @Basic
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String bz;

    @javax.persistence.Column(name = "w_xb_bz", nullable = true, insertable = true, updatable = true, length = 200, precision = 0)
    @Basic
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    private String zycp1;

    @javax.persistence.Column(name = "w_xb_cp1", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getZycp1() {
        return zycp1;
    }

    public void setZycp1(String zycp1) {
        this.zycp1 = zycp1;
    }

    private String zycp2;

    @javax.persistence.Column(name = "w_xb_cp2", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getZycp2() {
        return zycp2;
    }

    public void setZycp2(String zycp2) {
        this.zycp2 = zycp2;
    }

    private String zycp3;

    @javax.persistence.Column(name = "w_xb_cp3", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getZycp3() {
        return zycp3;
    }

    public void setZycp3(String zycp3) {
        this.zycp3 = zycp3;
    }

    private String tbrxm;

    @javax.persistence.Column(name = "w_xb_jbr", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getTbrxm() {
        return tbrxm;
    }

    public void setTbrxm(String tbrxm) {
        this.tbrxm = tbrxm;
    }

    private String tbrsfzh;

    @javax.persistence.Column(name = "w_xb_sfzhm", nullable = true, insertable = true, updatable = true, length = 18, precision = 0)
    @Basic
    public String getTbrsfzh() {
        return tbrsfzh;
    }

    public void setTbrsfzh(String tbrsfzh) {
        this.tbrsfzh = tbrsfzh;
    }

    private String gk;

    @javax.persistence.Column(name = "w_xb_sfsm", nullable = true, insertable = true, updatable = true, length = 2, precision = 0)
    @Basic
    public String getGk() {
        return gk;
    }

    public void setGk(String gk) {
        this.gk = gk;
    }

    private String tbrlxfs;

    @javax.persistence.Column(name = "w_xb_jbrdh", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getTbrlxfs() {
        return tbrlxfs;
    }

    public void setTbrlxfs(String tbrlxfs) {
        this.tbrlxfs = tbrlxfs;
    }

    private Date gsfzrq;

    @javax.persistence.Column(name = "w_xb_jyqx", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date getGsfzrq() {
        return gsfzrq;
    }

    public void setGsfzrq(Date gsfzrq) {
        this.gsfzrq = gsfzrq;
    }

    private String jydz;

    @javax.persistence.Column(name = "w_xb_jydz", nullable = true, insertable = true, updatable = true, length = 200, precision = 0)
    @Basic
    public String getJydz() {
        return jydz;
    }

    public void setJydz(String jydz) {
        this.jydz = jydz;
    }

    private String jyyb;

    @javax.persistence.Column(name = "w_xb_jyyzbm", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public String getJyyb() {
        return jyyb;
    }

    public void setJyyb(String jyyb) {
        this.jyyb = jyyb;
    }

    private String jydh;

    @javax.persistence.Column(name = "w_xb_jydh", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getJydh() {
        return jydh;
    }

    public void setJydh(String jydh) {
        this.jydh = jydh;
    }

    private String khyh;

    @javax.persistence.Column(name = "w_xb_khh", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getKhyh() {
        return khyh;
    }

    public void setKhyh(String khyh) {
        this.khyh = khyh;
    }

    private String khzh;

    @javax.persistence.Column(name = "w_xb_khzh", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getKhzh() {
        return khzh;
    }

    public void setKhzh(String khzh) {
        this.khzh = khzh;
    }

    private String jfly;

    @javax.persistence.Column(name = "w_xb_jyly", nullable = true, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public String getJfly() {
        return jfly;
    }

    public void setJfly(String jfly) {
        this.jfly = jfly;
    }

    private int lb;

    @javax.persistence.Column(name = "w_xb_lb", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getLb() {
        return lb;
    }

    public void setLb(int lb) {
        this.lb = lb;
    }

    private String zt;

    @javax.persistence.Column(name = "w_xb_zt", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    private String tjr;

    @javax.persistence.Column(name = "w_xb_tjr", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getTjr() {
        return tjr;
    }

    public void setTjr(String tjr) {
        this.tjr = tjr;
    }

    private Date tjsj;

    @javax.persistence.Column(name = "w_xb_tjsj", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date getTjsj() {
        return tjsj;
    }

    public void setTjsj(Date tjsj) {
        this.tjsj = tjsj;
    }

    private String blr;

    @javax.persistence.Column(name = "w_xb_blr", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getBlr() {
        return blr;
    }

    public void setBlr(String blr) {
        this.blr = blr;
    }

    private Date blsj;

    @javax.persistence.Column(name = "w_xb_blsj", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date getBlsj() {
        return blsj;
    }

    public void setBlsj(Date blsj) {
        this.blsj = blsj;
    }

    private int bj;

    @javax.persistence.Column(name = "w_xb_bj", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getBj() {
        return bj;
    }

    public void setBj(int bj) {
        this.bj = bj;
    }

    private Date createtime;

    @javax.persistence.Column(name = "w_xb_createtime", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    private Date xgsj;

    @javax.persistence.Column(name = "w_xb_xgsj", nullable = true, insertable = true, updatable = true, length = 23, precision = 3)
    @Basic
    public Date getXgsj() {
        return xgsj;
    }

    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }

    private String bzjgdm;

    @javax.persistence.Column(name = "w_xb_bzjgdm", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    @Basic
    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    private String zgjgmc;

    @javax.persistence.Column(name = "w_xb_zgjgmc", nullable = true, insertable = true, updatable = true, length = 500, precision = 0)
    @Basic
    public String getZgjgmc() {
        return zgjgmc;
    }

    public void setZgjgmc(String zgjgmc) {
        this.zgjgmc = zgjgmc;
    }
    
    private String nnjjhy;
    @javax.persistence.Column(name = "w_xb_jjhy2011")
    @Basic
    public String getNnjjhy() {
        return nnjjhy;
    }

    public void setNnjjhy(String nnjjhy) {
        this.nnjjhy = nnjjhy;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
