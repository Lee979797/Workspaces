package com.ninemax.nacao.to.portalet;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 保存用户布局的所有信息，与dwr交互 
 */

public class clsUserPortalTO implements Serializable{
	
	private String user_id;
	private clsCustomMadeTO customMadeTO;
	private clsLayoutTO layoutTO;
	private clsThemeTO themeTO;
	private ArrayList myUnitTOs = new ArrayList();
	
	public clsCustomMadeTO getCustomMadeTO() {
		return customMadeTO;
	}
	public void setCustomMadeTO(clsCustomMadeTO customMadeTO) {
		this.customMadeTO = customMadeTO;
	}
	public clsLayoutTO getLayoutTO() {
		return layoutTO;
	}
	public void setLayoutTO(clsLayoutTO layoutTO) {
		this.layoutTO = layoutTO;
	}
	public ArrayList getMyUnitTOs() {
		return myUnitTOs;
	}
	public void setMyUnitTOs(ArrayList myUnitTOs) {
		this.myUnitTOs = myUnitTOs;
	}
	public clsThemeTO getThemeTO() {
		return themeTO;
	}
	public void setThemeTO(clsThemeTO themeTO) {
		this.themeTO = themeTO;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	

}
