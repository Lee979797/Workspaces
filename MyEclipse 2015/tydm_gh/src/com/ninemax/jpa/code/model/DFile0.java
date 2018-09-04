package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.util.Date;

/**
 * User: yzhhui
 * Date: 12-10-9
 * Time: ÏÂÎç1:54
 */
@javax.persistence.Table(name = "D_FILE0")
@Entity
public class DFile0 {
    private String creator;

    @javax.persistence.Column(name = "CREATOR")
    @Basic

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    private Date createtime;

    @javax.persistence.Column(name = "CREATETIME")
    @Basic
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    private String editor;

    @javax.persistence.Column(name = "EDITOR")
    @Basic
    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    private Date edittime;

    @javax.persistence.Column(name = "EDITTIME")
    @Basic
    public Date getEdittime() {
        return edittime;
    }

    public void setEdittime(Date edittime) {
        this.edittime = edittime;
    }

    private String deltor;

    @javax.persistence.Column(name = "DELTOR")
    @Basic
    public String getDeltor() {
        return deltor;
    }

    public void setDeltor(String deltor) {
        this.deltor = deltor;
    }

    private Date deltime;

    @javax.persistence.Column(name = "DELTIME")
    @Basic
    public Date getDeltime() {
        return deltime;
    }

    public void setDeltime(Date deltime) {
        this.deltime = deltime;
    }

    private Integer status;

    @javax.persistence.Column(name = "STATUS")
    @Basic
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    private Integer attr;

    @javax.persistence.Column(name = "ATTR")
    @Basic
    public Integer getAttr() {
        return attr;
    }

    public void setAttr(Integer attr) {
        this.attr = attr;
    }

    private Integer attrex;

    @javax.persistence.Column(name = "ATTREX")
    @Basic
    public Integer getAttrex() {
        return attrex;
    }

    public void setAttrex(Integer attrex) {
        this.attrex = attrex;
    }

    private Integer pageflag;

    @javax.persistence.Column(name = "PAGEFLAG")
    @Basic
    public Integer getPageflag() {
        return pageflag;
    }

    public void setPageflag(Integer pageflag) {
        this.pageflag = pageflag;
    }

    private Integer pagesame;

    @javax.persistence.Column(name = "PAGESAME")
    @Basic
    public Integer getPagesame() {
        return pagesame;
    }

    public void setPagesame(Integer pagesame) {
        this.pagesame = pagesame;
    }

    private Integer scamodal;

    @javax.persistence.Column(name = "SCAMODAL")
    @Basic
    public Integer getScamodal() {
        return scamodal;
    }

    public void setScamodal(Integer scamodal) {
        this.scamodal = scamodal;
    }

    private Integer errorflag;

    @javax.persistence.Column(name = "ERRORFLAG")
    @Basic
    public Integer getErrorflag() {
        return errorflag;
    }

    public void setErrorflag(Integer errorflag) {
        this.errorflag = errorflag;
    }

    private Integer arcid;

    @javax.persistence.Column(name = "ARCID")
    @Basic
    public Integer getArcid() {
        return arcid;
    }

    public void setArcid(Integer arcid) {
        this.arcid = arcid;
    }

    private Integer attached;

    @javax.persistence.Column(name = "ATTACHED")
    @Basic
    public Integer getAttached() {
        return attached;
    }

    public void setAttached(Integer attached) {
        this.attached = attached;
    }

    private String bmid;

    @javax.persistence.Column(name = "BMID")
    @Basic
    public String getBmid() {
        return bmid;
    }

    public void setBmid(String bmid) {
        this.bmid = bmid;
    }

    private Integer pid;

    @javax.persistence.Column(name = "PID")
    @Basic
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    private Integer did;

    @javax.persistence.Column(name = "DID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    private String qzh;

    @javax.persistence.Column(name = "QZH")
    @Basic
    public String getQzh() {
        return qzh;
    }

    public void setQzh(String qzh) {
        this.qzh = qzh;
    }

    private String docid;

    @javax.persistence.Column(name = "DOCID")
    @Basic
    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    private String jgdm;

    @javax.persistence.Column(name = "JGDM")
    @Basic
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String jgmc;

    @javax.persistence.Column(name = "JGMC")
    @Basic
    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    private Date newdate;

    @javax.persistence.Column(name = "NEWDATE")
    @Basic
    public Date getNewdate() {
        return newdate;
    }

    public void setNewdate(Date newdate) {
        this.newdate = newdate;
    }

    private Date modifydate;

    @javax.persistence.Column(name = "MODIFYDATE")
    @Basic
    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    private String xzqh;

    @javax.persistence.Column(name = "XZQH")
    @Basic
    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    private String arctype;

    @javax.persistence.Column(name = "ARCTYPE")
    @Basic
    public String getArctype() {
        return arctype;
    }

    public void setArctype(String arctype) {
        this.arctype = arctype;
    }

    private String gk;

    @javax.persistence.Column(name = "GK")
    @Basic
    public String getGk() {
        return gk;
    }

    public void setGk(String gk) {
        this.gk = gk;
    }

    private String bz;

    @javax.persistence.Column(name = "BZ")
    @Basic
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    private String jglx;

    @javax.persistence.Column(name = "JGLX")
    @Basic
    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
    }

    private String fddbr;

    @javax.persistence.Column(name = "FDDBR")
    @Basic
    public String getFddbr() {
        return fddbr;
    }

    public void setFddbr(String fddbr) {
        this.fddbr = fddbr;
    }

    private String jjhy;

    @javax.persistence.Column(name = "JJHY")
    @Basic
    public String getJjhy() {
        return jjhy;
    }

    public void setJjhy(String jjhy) {
        this.jjhy = jjhy;
    }

    private String jjlx;

    @javax.persistence.Column(name = "JJLX")
    @Basic
    public String getJjlx() {
        return jjlx;
    }

    public void setJjlx(String jjlx) {
        this.jjlx = jjlx;
    }

    private Date zcrq;

    @javax.persistence.Column(name = "ZCRQ")
    @Basic
    public Date getZcrq() {
        return zcrq;
    }

    public void setZcrq(Date zcrq) {
        this.zcrq = zcrq;
    }

    private String zgdm;

    @javax.persistence.Column(name = "ZGDM")
    @Basic
    public String getZgdm() {
        return zgdm;
    }

    public void setZgdm(String zgdm) {
        this.zgdm = zgdm;
    }

    private String pzjgdm;

    @javax.persistence.Column(name = "PZJGDM")
    @Basic
    public String getPzjgdm() {
        return pzjgdm;
    }

    public void setPzjgdm(String pzjgdm) {
        this.pzjgdm = pzjgdm;
    }

    private String jgdz;

    @javax.persistence.Column(name = "JGDZ")
    @Basic
    public String getJgdz() {
        return jgdz;
    }

    public void setJgdz(String jgdz) {
        this.jgdz = jgdz;
    }

    private String yzbm;

    @javax.persistence.Column(name = "YZBM")
    @Basic
    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    private String dhhm;

    @javax.persistence.Column(name = "DHHM")
    @Basic
    public String getDhhm() {
        return dhhm;
    }

    public void setDhhm(String dhhm) {
        this.dhhm = dhhm;
    }

    private Date bzrq;

    @javax.persistence.Column(name = "BZRQ")
    @Basic
    public Date getBzrq() {
        return bzrq;
    }

    public void setBzrq(Date bzrq) {
        this.bzrq = bzrq;
    }

    private String bzjgdm;

    @javax.persistence.Column(name = "BZJGDM")
    @Basic
    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    private Integer zgrs;

    @javax.persistence.Column(name = "ZGRS")
    @Basic
    public Integer getZgrs() {
        return zgrs;
    }

    public void setZgrs(Integer zgrs) {
        this.zgrs = zgrs;
    }

    private Date njrq;

    @javax.persistence.Column(name = "NJRQ")
    @Basic
    public Date getNjrq() {
        return njrq;
    }

    public void setNjrq(Date njrq) {
        this.njrq = njrq;
    }

    private String zch;

    @javax.persistence.Column(name = "ZCH")
    @Basic
    public String getZch() {
        return zch;
    }

    public void setZch(String zch) {
        this.zch = zch;
    }

    private String qzbz;

    @javax.persistence.Column(name = "QZBZ")
    @Basic
    public String getQzbz() {
        return qzbz;
    }

    public void setQzbz(String qzbz) {
        this.qzbz = qzbz;
    }

    private String zgmc;

    @javax.persistence.Column(name = "ZGMC")
    @Basic
    public String getZgmc() {
        return zgmc;
    }

    public void setZgmc(String zgmc) {
        this.zgmc = zgmc;
    }

    private String pzjgmc;

    @javax.persistence.Column(name = "PZJGMC")
    @Basic
    public String getPzjgmc() {
        return pzjgmc;
    }

    public void setPzjgmc(String pzjgmc) {
        this.pzjgmc = pzjgmc;
    }

    private String pzwh;

    @javax.persistence.Column(name = "PZWH")
    @Basic
    public String getPzwh() {
        return pzwh;
    }

    public void setPzwh(String pzwh) {
        this.pzwh = pzwh;
    }

    private Date pwrq;

    @javax.persistence.Column(name = "PWRQ")
    @Basic
    public Date getPwrq() {
        return pwrq;
    }

    public void setPwrq(Date pwrq) {
        this.pwrq = pwrq;
    }

    private String docmemo;

    @javax.persistence.Column(name = "DOCMEMO")
    @Basic
    public String getDocmemo() {
        return docmemo;
    }

    public void setDocmemo(String docmemo) {
        this.docmemo = docmemo;
    }

    private Integer isMini;

    @javax.persistence.Column(name = "isMini")
    @Basic
    public Integer getIsMini() {
        return isMini;
    }

    public void setIsMini(Integer isMini) {
        this.isMini = isMini;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DFile0 dFile0 = (DFile0) o;

        if (arcid != null ? !arcid.equals(dFile0.arcid) : dFile0.arcid != null) return false;
        if (arctype != null ? !arctype.equals(dFile0.arctype) : dFile0.arctype != null) return false;
        if (attached != null ? !attached.equals(dFile0.attached) : dFile0.attached != null) return false;
        if (attr != null ? !attr.equals(dFile0.attr) : dFile0.attr != null) return false;
        if (attrex != null ? !attrex.equals(dFile0.attrex) : dFile0.attrex != null) return false;
        if (bmid != null ? !bmid.equals(dFile0.bmid) : dFile0.bmid != null) return false;
        if (bz != null ? !bz.equals(dFile0.bz) : dFile0.bz != null) return false;
        if (bzjgdm != null ? !bzjgdm.equals(dFile0.bzjgdm) : dFile0.bzjgdm != null) return false;
        if (bzrq != null ? !bzrq.equals(dFile0.bzrq) : dFile0.bzrq != null) return false;
        if (createtime != null ? !createtime.equals(dFile0.createtime) : dFile0.createtime != null) return false;
        if (creator != null ? !creator.equals(dFile0.creator) : dFile0.creator != null) return false;
        if (deltime != null ? !deltime.equals(dFile0.deltime) : dFile0.deltime != null) return false;
        if (deltor != null ? !deltor.equals(dFile0.deltor) : dFile0.deltor != null) return false;
        if (dhhm != null ? !dhhm.equals(dFile0.dhhm) : dFile0.dhhm != null) return false;
        if (did != null ? !did.equals(dFile0.did) : dFile0.did != null) return false;
        if (docid != null ? !docid.equals(dFile0.docid) : dFile0.docid != null) return false;
        if (docmemo != null ? !docmemo.equals(dFile0.docmemo) : dFile0.docmemo != null) return false;
        if (editor != null ? !editor.equals(dFile0.editor) : dFile0.editor != null) return false;
        if (edittime != null ? !edittime.equals(dFile0.edittime) : dFile0.edittime != null) return false;
        if (errorflag != null ? !errorflag.equals(dFile0.errorflag) : dFile0.errorflag != null) return false;
        if (fddbr != null ? !fddbr.equals(dFile0.fddbr) : dFile0.fddbr != null) return false;
        if (gk != null ? !gk.equals(dFile0.gk) : dFile0.gk != null) return false;
        if (jgdm != null ? !jgdm.equals(dFile0.jgdm) : dFile0.jgdm != null) return false;
        if (jgdz != null ? !jgdz.equals(dFile0.jgdz) : dFile0.jgdz != null) return false;
        if (jglx != null ? !jglx.equals(dFile0.jglx) : dFile0.jglx != null) return false;
        if (jgmc != null ? !jgmc.equals(dFile0.jgmc) : dFile0.jgmc != null) return false;
        if (jjhy != null ? !jjhy.equals(dFile0.jjhy) : dFile0.jjhy != null) return false;
        if (jjlx != null ? !jjlx.equals(dFile0.jjlx) : dFile0.jjlx != null) return false;
        if (modifydate != null ? !modifydate.equals(dFile0.modifydate) : dFile0.modifydate != null) return false;
        if (newdate != null ? !newdate.equals(dFile0.newdate) : dFile0.newdate != null) return false;
        if (njrq != null ? !njrq.equals(dFile0.njrq) : dFile0.njrq != null) return false;
        if (pageflag != null ? !pageflag.equals(dFile0.pageflag) : dFile0.pageflag != null) return false;
        if (pagesame != null ? !pagesame.equals(dFile0.pagesame) : dFile0.pagesame != null) return false;
        if (pid != null ? !pid.equals(dFile0.pid) : dFile0.pid != null) return false;
        if (pwrq != null ? !pwrq.equals(dFile0.pwrq) : dFile0.pwrq != null) return false;
        if (pzjgdm != null ? !pzjgdm.equals(dFile0.pzjgdm) : dFile0.pzjgdm != null) return false;
        if (pzjgmc != null ? !pzjgmc.equals(dFile0.pzjgmc) : dFile0.pzjgmc != null) return false;
        if (pzwh != null ? !pzwh.equals(dFile0.pzwh) : dFile0.pzwh != null) return false;
        if (qzbz != null ? !qzbz.equals(dFile0.qzbz) : dFile0.qzbz != null) return false;
        if (qzh != null ? !qzh.equals(dFile0.qzh) : dFile0.qzh != null) return false;
        if (scamodal != null ? !scamodal.equals(dFile0.scamodal) : dFile0.scamodal != null) return false;
        if (status != null ? !status.equals(dFile0.status) : dFile0.status != null) return false;
        if (xzqh != null ? !xzqh.equals(dFile0.xzqh) : dFile0.xzqh != null) return false;
        if (yzbm != null ? !yzbm.equals(dFile0.yzbm) : dFile0.yzbm != null) return false;
        if (zch != null ? !zch.equals(dFile0.zch) : dFile0.zch != null) return false;
        if (zcrq != null ? !zcrq.equals(dFile0.zcrq) : dFile0.zcrq != null) return false;
        if (zgdm != null ? !zgdm.equals(dFile0.zgdm) : dFile0.zgdm != null) return false;
        if (zgmc != null ? !zgmc.equals(dFile0.zgmc) : dFile0.zgmc != null) return false;
        if (zgrs != null ? !zgrs.equals(dFile0.zgrs) : dFile0.zgrs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = creator != null ? creator.hashCode() : 0;
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (editor != null ? editor.hashCode() : 0);
        result = 31 * result + (edittime != null ? edittime.hashCode() : 0);
        result = 31 * result + (deltor != null ? deltor.hashCode() : 0);
        result = 31 * result + (deltime != null ? deltime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (attr != null ? attr.hashCode() : 0);
        result = 31 * result + (attrex != null ? attrex.hashCode() : 0);
        result = 31 * result + (pageflag != null ? pageflag.hashCode() : 0);
        result = 31 * result + (pagesame != null ? pagesame.hashCode() : 0);
        result = 31 * result + (scamodal != null ? scamodal.hashCode() : 0);
        result = 31 * result + (errorflag != null ? errorflag.hashCode() : 0);
        result = 31 * result + (arcid != null ? arcid.hashCode() : 0);
        result = 31 * result + (attached != null ? attached.hashCode() : 0);
        result = 31 * result + (bmid != null ? bmid.hashCode() : 0);
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (did != null ? did.hashCode() : 0);
        result = 31 * result + (qzh != null ? qzh.hashCode() : 0);
        result = 31 * result + (docid != null ? docid.hashCode() : 0);
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (jgmc != null ? jgmc.hashCode() : 0);
        result = 31 * result + (newdate != null ? newdate.hashCode() : 0);
        result = 31 * result + (modifydate != null ? modifydate.hashCode() : 0);
        result = 31 * result + (xzqh != null ? xzqh.hashCode() : 0);
        result = 31 * result + (arctype != null ? arctype.hashCode() : 0);
        result = 31 * result + (gk != null ? gk.hashCode() : 0);
        result = 31 * result + (bz != null ? bz.hashCode() : 0);
        result = 31 * result + (jglx != null ? jglx.hashCode() : 0);
        result = 31 * result + (fddbr != null ? fddbr.hashCode() : 0);
        result = 31 * result + (jjhy != null ? jjhy.hashCode() : 0);
        result = 31 * result + (jjlx != null ? jjlx.hashCode() : 0);
        result = 31 * result + (zcrq != null ? zcrq.hashCode() : 0);
        result = 31 * result + (zgdm != null ? zgdm.hashCode() : 0);
        result = 31 * result + (pzjgdm != null ? pzjgdm.hashCode() : 0);
        result = 31 * result + (jgdz != null ? jgdz.hashCode() : 0);
        result = 31 * result + (yzbm != null ? yzbm.hashCode() : 0);
        result = 31 * result + (dhhm != null ? dhhm.hashCode() : 0);
        result = 31 * result + (bzrq != null ? bzrq.hashCode() : 0);
        result = 31 * result + (bzjgdm != null ? bzjgdm.hashCode() : 0);
        result = 31 * result + (zgrs != null ? zgrs.hashCode() : 0);
        result = 31 * result + (njrq != null ? njrq.hashCode() : 0);
        result = 31 * result + (zch != null ? zch.hashCode() : 0);
        result = 31 * result + (qzbz != null ? qzbz.hashCode() : 0);
        result = 31 * result + (zgmc != null ? zgmc.hashCode() : 0);
        result = 31 * result + (pzjgmc != null ? pzjgmc.hashCode() : 0);
        result = 31 * result + (pzwh != null ? pzwh.hashCode() : 0);
        result = 31 * result + (pwrq != null ? pwrq.hashCode() : 0);
        result = 31 * result + (docmemo != null ? docmemo.hashCode() : 0);
        return result;
    }
}
