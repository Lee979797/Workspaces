package com.ninemax.nacao.to.system;

import java.io.Serializable;

/**
 * 友情链接分类
 * @author 
 *
 */
public class clsLinkSortTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 728184623258543027L;
	private String id;
	private String sort_name;
	private String orderBy;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSort_name() {
		return sort_name;
	}
	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
}
