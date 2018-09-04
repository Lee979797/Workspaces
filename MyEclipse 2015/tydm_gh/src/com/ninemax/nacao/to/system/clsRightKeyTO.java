package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsRightKeyTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7640876981018871550L;
	private String rightKey_id;
	private String rightKey_name;
	private String rightKey_depth;
	private String rightKey_kind;
	private String rightKey_func;
	private String rightKey_fullname;
	private String orderBy;//ÅÅÐò
	private String parentId;
	private String linkPage;
	private String pictrue;
	private String type;//1À¸Ä¿2È¨ÏÞ

	public String getRightKey_depth() {
		return rightKey_depth;
	}
	public void setRightKey_depth(String rightKey_depth) {
		this.rightKey_depth = rightKey_depth;
	}
	public String getRightKey_fullname() {
		return rightKey_fullname;
	}
	public void setRightKey_fullname(String rightKey_fullname) {
		this.rightKey_fullname = rightKey_fullname;
	}
	public String getRightKey_func() {
		return rightKey_func;
	}
	public void setRightKey_func(String rightKey_func) {
		this.rightKey_func = rightKey_func;
	}
	public String getRightKey_id() {
		return rightKey_id;
	}
	public void setRightKey_id(String rightKey_id) {
		this.rightKey_id = rightKey_id;
	}
	public String getRightKey_kind() {
		return rightKey_kind;
	}
	public void setRightKey_kind(String rightKey_kind) {
		this.rightKey_kind = rightKey_kind;
	}
	public String getRightKey_name() {
		return rightKey_name;
	}
	public void setRightKey_name(String rightKey_name) {
		this.rightKey_name = rightKey_name;
	}
	public String getLinkPage() {
		return linkPage;
	}
	public void setLinkPage(String linkPage) {
		this.linkPage = linkPage;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getPictrue() {
		return pictrue;
	}
	public void setPictrue(String pictrue) {
		this.pictrue = pictrue;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
