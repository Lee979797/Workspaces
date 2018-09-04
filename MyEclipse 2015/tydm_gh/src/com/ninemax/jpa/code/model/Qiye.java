package com.ninemax.jpa.code.model;

import com.ninemax.jpa.util.StringUtils;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User: liuzy
 * Date: 13-9-2
 * Time: ÏÂÎç3:56
 */
@Entity
@Table(name = "qiye")
public class Qiye implements java.io.Serializable {

    // Fields

    private String cwybs;
    private String vqymc;
    private String czch;
    private String vzs;
    private String cqylx;
    private String vchrJyfw;
    private Date dclrq;
    private Date dhzrq;
    private Date djyqxq;
    private Date djyqxz;
    private String cdqzt;
    private Double numZczb;
    private String cdjjg;
    private String cyzbm;
    private String vlxdh;
    private String chydm;
    private String vchrXm;
    private String chrZjhm;
    private Date ddxrq;
    private String vdxyy;
    private Date dzxrq;
    private String czxyy;
    private String zhnjnd;

    // Constructors

    /**
     * default constructor
     */
    public Qiye() {
    }

    /**
     * minimal constructor
     */
    public Qiye(String cwybs) {
        this.cwybs = cwybs;
    }


    // Property accessors
    @Id
    @Column(name = "cwybs", unique = true, nullable = false, length = 16)
    public String getCwybs() {
        return this.cwybs;
    }

    public void setCwybs(String cwybs) {
        this.cwybs = cwybs;
    }

    @Column(name = "vqymc", length = 100)
    public String getVqymc() {
        return this.vqymc;
    }

    public void setVqymc(String vqymc) {
        if (vqymc != null)
            this.vqymc = StringUtils.toSBC(vqymc.trim());
    }

    @Column(name = "czch", length = 38)
    public String getCzch() {
        return this.czch;
    }

    public void setCzch(String czch) {
        this.czch = czch;
    }

    @Column(name = "vzs", length = 100)
    public String getVzs() {
        return this.vzs;
    }

    public void setVzs(String vzs) {
        if (vzs != null)
            this.vzs = StringUtils.toSBC(vzs.trim());
    }

    @Column(name = "cqylx", length = 50)
    public String getCqylx() {
        return this.cqylx;
    }

    public void setCqylx(String cqylx) {
        this.cqylx = cqylx;
    }

    @Column(name = "vchr_jyfw", length = 2000)
    public String getVchrJyfw() {
        return this.vchrJyfw;
    }

    public void setVchrJyfw(String vchrJyfw) {
        this.vchrJyfw = vchrJyfw;
    }

    @Column(name = "dclrq", columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDclrq() {
        return this.dclrq;
    }

    public void setDclrq(Date dclrq) {
        this.dclrq = dclrq;
    }

    @Column(name = "dhzrq", columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDhzrq() {
        return this.dhzrq;
    }

    public void setDhzrq(Date dhzrq) {
        this.dhzrq = dhzrq;
    }

    @Column(name = "djyqxq", columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDjyqxq() {
        return this.djyqxq;
    }

    public void setDjyqxq(Date djyqxq) {
        this.djyqxq = djyqxq;
    }

    @Column(name = "djyqxz", columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDjyqxz() {
        return this.djyqxz;
    }

    public void setDjyqxz(Date djyqxz) {
        this.djyqxz = djyqxz;
    }

    @Column(name = "cdqzt", length = 10)
    public String getCdqzt() {
        return this.cdqzt;
    }

    public void setCdqzt(String cdqzt) {
        this.cdqzt = cdqzt;
    }

    @Column(name = "num_zczb", precision = 15, scale = 4)
    public Double getNumZczb() {
        return this.numZczb;
    }

    public void setNumZczb(Double numZczb) {
        this.numZczb = numZczb;
    }

    @Column(name = "cdjjg", length = 50)
    public String getCdjjg() {
        return this.cdjjg;
    }

    public void setCdjjg(String cdjjg) {
        this.cdjjg = cdjjg;
    }

    @Column(name = "cyzbm", length = 6)
    public String getCyzbm() {
        return this.cyzbm;
    }

    public void setCyzbm(String cyzbm) {
        this.cyzbm = cyzbm;
    }

    @Column(name = "vlxdh", length = 30)
    public String getVlxdh() {
        return this.vlxdh;
    }

    public void setVlxdh(String vlxdh) {
        this.vlxdh = vlxdh;
    }

    @Column(name = "chydm", length = 5)
    public String getChydm() {
        return this.chydm;
    }

    public void setChydm(String chydm) {
        this.chydm = chydm;
    }

    @Column(name = "vchr_xm", length = 50)
    public String getVchrXm() {
        return this.vchrXm;
    }

    public void setVchrXm(String vchrXm) {
        if (vchrXm != null)
            this.vchrXm = StringUtils.toSBC(vchrXm.trim());
    }

    @Column(name = "chr_zjhm", length = 20)
    public String getChrZjhm() {
        return this.chrZjhm;
    }

    public void setChrZjhm(String chrZjhm) {
        this.chrZjhm = chrZjhm;
    }

    @Column(name = "ddxrq", columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDdxrq() {
        return this.ddxrq;
    }

    public void setDdxrq(Date ddxrq) {
        this.ddxrq = ddxrq;
    }

    @Column(name = "vdxyy", length = 200)
    public String getVdxyy() {
        return this.vdxyy;
    }

    public void setVdxyy(String vdxyy) {
        this.vdxyy = vdxyy;
    }

    @Column(name = "dzxrq", columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDzxrq() {
        return this.dzxrq;
    }

    public void setDzxrq(Date dzxrq) {
        this.dzxrq = dzxrq;
    }

    @Column(name = "czxyy", length = 2)
    public String getCzxyy() {
        return this.czxyy;
    }

    public void setCzxyy(String czxyy) {
        this.czxyy = czxyy;
    }

    @Column(name = "zhnjnd", length = 4)
    public String getZhnjnd() {
        return this.zhnjnd;
    }

    public void setZhnjnd(String zhnjnd) {
        this.zhnjnd = zhnjnd;
    }

}