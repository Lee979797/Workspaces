package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsFacilityTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 27609582046659065L;
	private String id ;
	private String facility_name;
	private String facility_islast;
	private String facility_depth;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
	     this.id=id;
	}
	public String getFacilityName(){
		return facility_name;
	}
	public void setFacilityName(String facilityname){
		this.facility_name=facilityname;
	}
	public String getfacilityIsLast(){
		return facility_islast;
	}
	public void setfacilityIsLast(String facilityislast ){
		this.facility_islast=facilityislast;
	}
	public String getfacilityDepth(){
		return facility_depth;
	}
	public void setFacilityDepth(String facilitydepth) {
		this.facility_depth=facilitydepth;
	}

}
