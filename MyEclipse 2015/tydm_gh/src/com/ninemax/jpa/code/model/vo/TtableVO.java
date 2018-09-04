package com.ninemax.jpa.code.model.vo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Administrator
 *
 */
@Table(name = "ttable_ww")
@Entity
public class TtableVO implements java.io.Serializable{
    private int id;
    private String name;
    private String nameCn;
   
    @Column(name = "id")
    @Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    @Column(name = "name")
    @Basic
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    @Column(name = "name_cn")
    @Basic
	public String getNameCn() {
		return nameCn;
	}
	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}	
}
