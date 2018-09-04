package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yanzh
 * ²Ù×÷¼ÇÂ¼
 */
@Entity
@Table(name = "t_czjl")
public class TCzjl implements Serializable {

    private static final long serialVersionUID = 698447784324215650L;
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tyshxydm", length = 18)
    private String tyshxydm;
    
    @Transient
    private String jgdm;
    @Column(name="klsh")
    private Long klsh;
    @Column(name="memo")
    private String memo;
    @Column(name="name")
    private String name;
    @Column(name="type")
    private String type;
    @Column(name="bzjgdm")
    private String xzqh;

    @Column(name="date")
    private Date date;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getTyshxydm() {
		return tyshxydm;
	}

	public void setTyshxydm(String tyshxydm) {
		this.tyshxydm = tyshxydm;
	}

	
	public String getJgdm() {
		return tyshxydm;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getKlsh() {
        return klsh;
    }

    public void setKlsh(Long klsh) {
        this.klsh = klsh;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    
    
}
