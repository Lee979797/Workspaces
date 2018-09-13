package com.lhq.prj.bms.core;

import java.util.List;

public class Page {
	/** 总记录数 */
	private int totalProperty;

	/** 分页结果 */
	private List root;

	/** 开始页码 */
	private int start;

	/** 每页多少 */
	private int limit;

	/** 成功与否 */
	private boolean success;
	
	/** 查询条件 */
	private List conditions;
	
	/** 查询标志 */
	private String flag;
	private String flag2;
	
	private int orgid;
	
	private String PrimaryKey;
	
	private Object objCondition;
	
	/** 用户过滤yanqgi**/

	private int userid;
	
	private String username;

	//private String state;
	private List stateConditions;
	
	private String imageData;
	
	private String pageTypeStr;
	

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	private int categoryid;

	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public Object getObjCondition() {
		return objCondition;
	}
	public void setObjCondition(Object objCondition) {
		this.objCondition = objCondition;
	}

	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public List getRoot() {
		return root;
	}
	public void setRoot(List root) {
		this.root = root;
	}
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getTotalProperty() {
		return totalProperty;
	}
	public void setTotalProperty(int totalProperty) {
		this.totalProperty = totalProperty;
	}

	public List getConditions() {
		return conditions;
	}
	public void setConditions(List conditions) {
		this.conditions = conditions;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFlag() {
		return flag;
	}
	
	public void setFlag2(String flag2) {
		this.flag2 = flag2;
	}

	public String getFlag2() {
		return flag2;
	}
	
	public List getStateConditions() {
		return stateConditions;
	}
	public void setStateConditions(List stateConditions) {
		this.stateConditions = stateConditions;
	}

	public void setPrimaryKey(String PrimaryKey) {
		this.PrimaryKey = PrimaryKey;
	}

	public String getPrimaryKey() {
		return PrimaryKey;
	}

	public void setOrgid(int orgid) {
		this.orgid = orgid;
	}

	public int getOrgid() {
		return orgid;
	}

	public void setPageTypeStr(String pageTypeStr) {
		this.pageTypeStr = pageTypeStr;
	}

	public String getPageTypeStr() {
		return pageTypeStr;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	public String getImageData() {
		return imageData;
	}

	@Override
	public String toString() {
		return "Page [totalProperty=" + totalProperty + ", root=" + root
				+ ", start=" + start + ", limit=" + limit + ", success="
				+ success + ", conditions=" + conditions + ", flag=" + flag
				+ ", flag2=" + flag2 + ", orgid=" + orgid + ", PrimaryKey="
				+ PrimaryKey + ", objCondition=" + objCondition + ", userid="
				+ userid + ", username=" + username + ", stateConditions="
				+ stateConditions + ", imageData=" + imageData
				+ ", pageTypeStr=" + pageTypeStr + ", categoryid=" + categoryid
				+ "]";
	}


}
