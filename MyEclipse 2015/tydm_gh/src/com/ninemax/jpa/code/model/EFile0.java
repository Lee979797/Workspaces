package com.ninemax.jpa.code.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.Assigned;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

/**
 * User: yzhhui
 * Date: 12-10-9
 * Time: ÏÂÎç1:55
 */
@javax.persistence.Table(name = "E_FILE0")
@Entity
public class EFile0 {
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

    private Integer pid;

    @javax.persistence.Column(name = "PID")
    @Basic
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    private String efilename;

    @javax.persistence.Column(name = "EFILENAME")
    @Basic
    public String getEfilename() {
        return efilename;
    }

    public void setEfilename(String efilename) {
        this.efilename = efilename;
    }

    private String title;

    @javax.persistence.Column(name = "TITLE")
    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String ext;

    @javax.persistence.Column(name = "EXT")
    @Basic
    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    private String pzm;

    @javax.persistence.Column(name = "PZM")
    @Basic
    public String getPzm() {
        return pzm;
    }

    public void setPzm(String pzm) {
        this.pzm = pzm;
    }

    private String pathname;

    @javax.persistence.Column(name = "PATHNAME")
    @Basic
    public String getPathname() {
        return pathname;
    }

    public void setPathname(String pathname) {
        this.pathname = pathname;
    }

    private String efiledb;

    @javax.persistence.Column(name = "EFILEDB")
    @Basic
    public String getEfiledb() {
        return efiledb;
    }

    public void setEfiledb(String efiledb) {
        this.efiledb = efiledb;
    }

    private Integer efileid;

    @javax.persistence.Column(name = "EFILEID")
    @Basic
    public Integer getEfileid() {
        return efileid;
    }

    public void setEfileid(Integer efileid) {
        this.efileid = efileid;
    }

    private String xlh;

    @javax.persistence.Column(name = "XLH")
    @Basic
    public String getXlh() {
        return xlh;
    }

    public void setXlh(String xlh) {
        this.xlh = xlh;
    }

    private String bbh;

    @javax.persistence.Column(name = "BBH")
    @Basic
    public String getBbh() {
        return bbh;
    }

    public void setBbh(String bbh) {
        this.bbh = bbh;
    }

    private byte[] swt;

    @javax.persistence.Column(name = "SWT")
    @Basic
    public byte[] getSwt() {
        return swt;
    }

    public void setSwt(byte[] swt) {
        this.swt = swt;
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

    private Integer bz;

    @javax.persistence.Column(name = "BZ")
    @Basic
    public Integer getBz() {
        return bz;
    }

    public void setBz(Integer bz) {
        this.bz = bz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EFile0 eFile0 = (EFile0) o;

        if (attr != null ? !attr.equals(eFile0.attr) : eFile0.attr != null) return false;
        if (attrex != null ? !attrex.equals(eFile0.attrex) : eFile0.attrex != null) return false;
        if (bbh != null ? !bbh.equals(eFile0.bbh) : eFile0.bbh != null) return false;
        if (bz != null ? !bz.equals(eFile0.bz) : eFile0.bz != null) return false;
        if (createtime != null ? !createtime.equals(eFile0.createtime) : eFile0.createtime != null) return false;
        if (creator != null ? !creator.equals(eFile0.creator) : eFile0.creator != null) return false;
        if (deltime != null ? !deltime.equals(eFile0.deltime) : eFile0.deltime != null) return false;
        if (deltor != null ? !deltor.equals(eFile0.deltor) : eFile0.deltor != null) return false;
        if (did != null ? !did.equals(eFile0.did) : eFile0.did != null) return false;
        if (editor != null ? !editor.equals(eFile0.editor) : eFile0.editor != null) return false;
        if (edittime != null ? !edittime.equals(eFile0.edittime) : eFile0.edittime != null) return false;
        if (efiledb != null ? !efiledb.equals(eFile0.efiledb) : eFile0.efiledb != null) return false;
        if (efileid != null ? !efileid.equals(eFile0.efileid) : eFile0.efileid != null) return false;
        if (efilename != null ? !efilename.equals(eFile0.efilename) : eFile0.efilename != null) return false;
        if (ext != null ? !ext.equals(eFile0.ext) : eFile0.ext != null) return false;
        if (pathname != null ? !pathname.equals(eFile0.pathname) : eFile0.pathname != null) return false;
        if (pid != null ? !pid.equals(eFile0.pid) : eFile0.pid != null) return false;
        if (pzm != null ? !pzm.equals(eFile0.pzm) : eFile0.pzm != null) return false;
        if (status != null ? !status.equals(eFile0.status) : eFile0.status != null) return false;
        if (!Arrays.equals(swt, eFile0.swt)) return false;
        if (title != null ? !title.equals(eFile0.title) : eFile0.title != null) return false;
        if (xlh != null ? !xlh.equals(eFile0.xlh) : eFile0.xlh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = did != null ? did.hashCode() : 0;
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (efilename != null ? efilename.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (ext != null ? ext.hashCode() : 0);
        result = 31 * result + (pzm != null ? pzm.hashCode() : 0);
        result = 31 * result + (pathname != null ? pathname.hashCode() : 0);
        result = 31 * result + (efiledb != null ? efiledb.hashCode() : 0);
        result = 31 * result + (efileid != null ? efileid.hashCode() : 0);
        result = 31 * result + (xlh != null ? xlh.hashCode() : 0);
        result = 31 * result + (bbh != null ? bbh.hashCode() : 0);
        result = 31 * result + (swt != null ? Arrays.hashCode(swt) : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (attr != null ? attr.hashCode() : 0);
        result = 31 * result + (attrex != null ? attrex.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (editor != null ? editor.hashCode() : 0);
        result = 31 * result + (edittime != null ? edittime.hashCode() : 0);
        result = 31 * result + (deltor != null ? deltor.hashCode() : 0);
        result = 31 * result + (deltime != null ? deltime.hashCode() : 0);
        result = 31 * result + (bz != null ? bz.hashCode() : 0);
        return result;
    }
}
