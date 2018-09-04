package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.util.Date;

/**
 * TCfjlb entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_cfjlb")
public class TCfjlb implements java.io.Serializable {

    // Fields

    private Integer id;
    private String jgdm;
    private String jgmc;
    private String jglx;
    private String fddbr;
    private String jgdz;
    private Date zfrq;
    private String bzjgdm;
    private Integer fkje;
    private Date cfrq;
    private Boolean cfbz;
    private Date lrrq;
    private String cfr;
    private String lrr;
    private String zjhm;
    private String zjlx;
    private Date njqx;
    private Date zcrq;
    private String cflx;
    private String memo;


    // Property accessors
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "jgdm", nullable = false, length = 9)
    public String getJgdm() {
        return this.jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    @Column(name = "jgmc", length = 120)
    public String getJgmc() {
        return this.jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    @Column(name = "jglx", length = 1)
    public String getJglx() {
        return this.jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
    }

    @Column(name = "fddbr", length = 30)
    public String getFddbr() {
        return this.fddbr;
    }

    public void setFddbr(String fddbr) {
        this.fddbr = fddbr;
    }

    @Column(name = "jgdz", length = 120)
    public String getJgdz() {
        return this.jgdz;
    }

    public void setJgdz(String jgdz) {
        this.jgdz = jgdz;
    }

    @Column(name = "zfrq", length = 23, columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getZfrq() {
        return this.zfrq;
    }

    public void setZfrq(Date zfrq) {
        this.zfrq = zfrq;
    }

    @Column(name = "bzjgdm", length = 6)
    public String getBzjgdm() {
        return this.bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    @Column(name = "fkje")
    public Integer getFkje() {
        return this.fkje;
    }

    public void setFkje(Integer fkje) {
        this.fkje = fkje;
    }

    @Column(name = "cfrq", length = 23, columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCfrq() {
        return this.cfrq;
    }

    public void setCfrq(Date cfrq) {
        this.cfrq = cfrq;
    }

    @Column(name = "cfbz")
    public Boolean getCfbz() {
        return this.cfbz;
    }

    public void setCfbz(Boolean cfbz) {
        this.cfbz = cfbz;
    }

    @Column(name = "lrrq", length = 23, columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLrrq() {
        return this.lrrq;
    }

    public void setLrrq(Date lrrq) {
        this.lrrq = lrrq;
    }

    @Column(name = "cfr", length = 10)
    public String getCfr() {
        return this.cfr;
    }

    public void setCfr(String cfr) {
        this.cfr = cfr;
    }

    @Column(name = "lrr", length = 10)
    public String getLrr() {
        return this.lrr;
    }

    public void setLrr(String lrr) {
        this.lrr = lrr;
    }

    @Column(name = "zjhm", length = 25)
    public String getZjhm() {
        return this.zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    @Column(name = "zjlx", length = 1)
    public String getZjlx() {
        return this.zjlx;
    }

    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }

    @Column(name = "njqx", length = 23, columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getNjqx() {
        return this.njqx;
    }

    public void setNjqx(Date njqx) {
        this.njqx = njqx;
    }

    @Column(name = "zcrq", length = 23, columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getZcrq() {
        return this.zcrq;
    }

    public void setZcrq(Date zcrq) {
        this.zcrq = zcrq;
    }

    @Column(name = "cflx", length = 2)
    public String getCflx() {
        return this.cflx;
    }

    public void setCflx(String cflx) {
        this.cflx = cflx;
    }

    @Column(name = "memo", length = 100)
    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }


}