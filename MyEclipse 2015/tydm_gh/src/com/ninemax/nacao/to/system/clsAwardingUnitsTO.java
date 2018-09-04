package com.ninemax.nacao.to.system;

import java.io.Serializable;

/**
 * ÊÚÅÆµ¥Î»
 * @author 
 *
 */
public class clsAwardingUnitsTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7587726418298325089L;
	private String id;
	private String units_name;
	private String orderBy;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUnits_name() {
		return units_name;
	}
	public void setUnits_name(String units_name) {
		this.units_name = units_name;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
}
