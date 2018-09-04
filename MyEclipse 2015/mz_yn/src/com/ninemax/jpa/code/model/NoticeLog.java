package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-8-15
 * Time: ÏÂÎç5:41
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "t_noticeLog")
@Entity
public class NoticeLog {
	
    @javax.persistence.Column(name = "nid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@javax.persistence.Column(name = "selDw")
	@Basic
    private String selDw;
    
	@javax.persistence.Column(name = "selPeople")
	@Basic
    private String selPeople;
    
	@javax.persistence.Column(name = "selTime")
	@Basic
    private String selTime;
    
	@javax.persistence.Column(name = "selSer")
	@Basic
    private String selSer;
    
	@javax.persistence.Column(name = "memo1")
	@Basic
    private String memo1;
    
	@javax.persistence.Column(name = "memo2")
	@Basic
    private String memo2;
    
	@javax.persistence.Column(name = "memo3")
	@Basic
    private String memo3;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSelDw() {
		return selDw;
	}

	public void setSelDw(String selDw) {
		this.selDw = selDw;
	}



	public String getSelTime() {
		return selTime;
	}

	public void setSelTime(String selTime) {
		this.selTime = selTime;
	}

	public String getSelSer() {
		return selSer;
	}

	public void setSelSer(String selSer) {
		this.selSer = selSer;
	}

	public String getMemo1() {
		return memo1;
	}

	public void setMemo1(String memo1) {
		this.memo1 = memo1;
	}

	public String getMemo2() {
		return memo2;
	}

	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}

	public String getMemo3() {
		return memo3;
	}

	public void setMemo3(String memo3) {
		this.memo3 = memo3;
	}

	public String getSelPeople() {
		return selPeople;
	}

	public void setSelPeople(String selPeople) {
		this.selPeople = selPeople;
	}
    
    
    
    
    
    
}
