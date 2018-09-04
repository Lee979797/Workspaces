package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-11
 * Time: ÏÂÎç1:23
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(com.ninemax.jpa.code.model.TPrintsetPK.class)
@javax.persistence.Table(name = "t_printset")
@Entity
public class TPrintset {
    private String xzqh;

    @javax.persistence.Column(name = "xzqh")
    @Basic
    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    private String item;

    @javax.persistence.Column(name = "item")
    @Id
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    private String dyfx;

    @javax.persistence.Column(name = "dyfx")
    @Basic
    public String getDyfx() {
        return dyfx;
    }

    public void setDyfx(String dyfx) {
        this.dyfx = dyfx;
    }

    private String xpos;

    @javax.persistence.Column(name = "xpos")
    @Basic
    public String getXpos() {
        return xpos;
    }

    public void setXpos(String xpos) {
        this.xpos = xpos;
    }

    private String ypos;

    @javax.persistence.Column(name = "ypos")
    @Basic
    public String getYpos() {
        return ypos;
    }

    public void setYpos(String ypos) {
        this.ypos = ypos;
    }

    private String font;

    @javax.persistence.Column(name = "font")
    @Basic
    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    private String fontsize;

    @javax.persistence.Column(name = "fontsize")
    @Basic
    public String getFontsize() {
        return fontsize;
    }

    public void setFontsize(String fontsize) {
        this.fontsize = fontsize;
    }

    private Integer sn;

    @javax.persistence.Column(name = "sn")
    @Basic
    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    private String userid;

    @javax.persistence.Column(name = "userid")
    @Id
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TPrintset tPrintset = (TPrintset) o;

        if (dyfx != null ? !dyfx.equals(tPrintset.dyfx) : tPrintset.dyfx != null) return false;
        if (font != null ? !font.equals(tPrintset.font) : tPrintset.font != null) return false;
        if (fontsize != null ? !fontsize.equals(tPrintset.fontsize) : tPrintset.fontsize != null) return false;
        if (item != null ? !item.equals(tPrintset.item) : tPrintset.item != null) return false;
        if (sn != null ? !sn.equals(tPrintset.sn) : tPrintset.sn != null) return false;
        if (userid != null ? !userid.equals(tPrintset.userid) : tPrintset.userid != null) return false;
        if (xpos != null ? !xpos.equals(tPrintset.xpos) : tPrintset.xpos != null) return false;
        if (xzqh != null ? !xzqh.equals(tPrintset.xzqh) : tPrintset.xzqh != null) return false;
        if (ypos != null ? !ypos.equals(tPrintset.ypos) : tPrintset.ypos != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = xzqh != null ? xzqh.hashCode() : 0;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + (dyfx != null ? dyfx.hashCode() : 0);
        result = 31 * result + (xpos != null ? xpos.hashCode() : 0);
        result = 31 * result + (ypos != null ? ypos.hashCode() : 0);
        result = 31 * result + (font != null ? font.hashCode() : 0);
        result = 31 * result + (fontsize != null ? fontsize.hashCode() : 0);
        result = 31 * result + (sn != null ? sn.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        return result;
    }
}
