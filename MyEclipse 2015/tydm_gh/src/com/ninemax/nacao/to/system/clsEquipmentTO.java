package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsEquipmentTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -929874670667311891L;
	private String id ;
	private String equipment_name;
	private String equipment_islast;
	private String equipment_depth;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
	     this.id=id;
	}
	public String getEquipmentName(){
		return equipment_name;
	}
	public void setEquipmentName(String equipmentname){
		this.equipment_name=equipmentname;
	}
	public String getEquipmentIsLast(){
		return equipment_islast;
	}
	public void setEquipmentIsLast(String equipmentislast ){
		this.equipment_islast=equipmentislast;
	}
	public String getEquipmentDepth(){
		return equipment_depth;
	}
	public void setEquipmentDepth(String equipmentdepth) {
		this.equipment_depth=equipmentdepth;
	}

}
