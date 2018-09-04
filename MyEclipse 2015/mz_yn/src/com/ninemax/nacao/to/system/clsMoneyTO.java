package com.ninemax.nacao.to.system;

import java.io.Serializable;

/**
 * ªı±“¿‡–Õ
 * @author Administrator
 *
 */

public class clsMoneyTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2054111547875187018L;
	private String money_id;
	private String money_name;
	public String getMoney_id() {
		return money_id;
	}
	public void setMoney_id(String money_id) {
		this.money_id = money_id;
	}
	public String getMoney_name() {
		return money_name;
	}
	public void setMoney_name(String money_name) {
		this.money_name = money_name;
	}
	
}
