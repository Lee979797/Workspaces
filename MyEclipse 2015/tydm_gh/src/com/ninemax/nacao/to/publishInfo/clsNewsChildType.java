package com.ninemax.nacao.to.publishInfo;

public class clsNewsChildType {

	private String id = "";
	private String child_type = "";
	private String parent_type = "";
	private String website_id ="";
	private String sort_id ="";
	public String getSort_id() {
		return sort_id;
	}
	public void setSort_id(String sortId) {
		sort_id = sortId;
	}
	public String getWebsite_id() {
		return website_id;
	}
	public void setWebsite_id(String website_id) {
		this.website_id = website_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getChild_type() {
		return child_type;
	}
	public void setChild_type(String child_type) {
		this.child_type = child_type;
	}
	public String getParent_type() {
		return parent_type;
	}
	public void setParent_type(String parent_type) {
		this.parent_type = parent_type;
	}
	
}
