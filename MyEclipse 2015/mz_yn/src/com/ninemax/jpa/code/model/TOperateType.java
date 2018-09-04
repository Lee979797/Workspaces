package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User: yzhhui
 * Date: 12-7-5
 * Time: ÏÂÎç4:06
 */
@javax.persistence.Table(name = "t_operate_type")
@Entity
public class TOperateType {
    private String czlxdm;

    @javax.persistence.Column(name = "czlxdm")
    @Id
    public String getCzlxdm() {
        return czlxdm;
    }

    public void setCzlxdm(String czlxdm) {
        this.czlxdm = czlxdm;
    }

    private String czlxmc;

    @javax.persistence.Column(name = "czlxmc")
    @Basic
    public String getCzlxmc() {
        return czlxmc;
    }

    public void setCzlxmc(String czlxmc) {
        this.czlxmc = czlxmc;
    }

    private Boolean isMain;

    @javax.persistence.Column(name = "isMain")
    @Basic
    public Boolean getMain() {
        return isMain;
    }

    public void setMain(Boolean main) {
        isMain = main;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TOperateType that = (TOperateType) o;

        return !(czlxdm != null ? !czlxdm.equals(that.czlxdm) : that.czlxdm != null) && !(czlxmc != null ? !czlxmc.equals(that.czlxmc) : that.czlxmc != null) && !(isMain != null ? !isMain.equals(that.isMain) : that.isMain != null);

    }

    @Override
    public int hashCode() {
        int result = czlxdm != null ? czlxdm.hashCode() : 0;
        result = 31 * result + (czlxmc != null ? czlxmc.hashCode() : 0);
        result = 31 * result + (isMain != null ? isMain.hashCode() : 0);
        return result;
    }
}
