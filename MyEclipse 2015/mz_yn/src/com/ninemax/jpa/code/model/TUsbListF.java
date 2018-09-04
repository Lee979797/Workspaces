package com.ninemax.jpa.code.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhhui
 * Date: 13-9-2
 * Time: ÏÂÎç3:54
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "t_usb_list_f")
@Entity
public class TUsbListF {
    private long id;

    @javax.persistence.Column(name = "id")
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String jgdm;

    @javax.persistence.Column(name = "jgdm")
    @Basic
    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    private String start;

    @javax.persistence.Column(name = "start")
    @Basic
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    private String end;

    @javax.persistence.Column(name = "[end]")
    @Basic
    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    private String num;

    @javax.persistence.Column(name = "num")
    @Basic
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    private String name;

    @javax.persistence.Column(name = "name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String time;

    @javax.persistence.Column(name = "time")
    @Basic
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String bz;

    @javax.persistence.Column(name = "bz")
    @Basic
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TUsbListF listF = (TUsbListF) o;

        if (id != listF.id) return false;
        if (bz != null ? !bz.equals(listF.bz) : listF.bz != null) return false;
        if (end != null ? !end.equals(listF.end) : listF.end != null) return false;
        if (jgdm != null ? !jgdm.equals(listF.jgdm) : listF.jgdm != null) return false;
        if (name != null ? !name.equals(listF.name) : listF.name != null) return false;
        if (num != null ? !num.equals(listF.num) : listF.num != null) return false;
        if (start != null ? !start.equals(listF.start) : listF.start != null) return false;
        if (time != null ? !time.equals(listF.time) : listF.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (jgdm != null ? jgdm.hashCode() : 0);
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (bz != null ? bz.hashCode() : 0);
        return result;
    }
}
