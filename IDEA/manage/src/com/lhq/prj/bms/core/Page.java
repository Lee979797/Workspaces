package com.lhq.prj.bms.core;

import java.util.Date;
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
	
	/**状态条件*/
	//private String state;  
	private List stateConditions;
	
	/**状态条件*/
	//private String state;  
	private List stateConditions2; 
	
	private List pzjgdmConditions; 
	
	private List bzjgdmConditions;
	
	private Object objCondition;
	
	private List dflagConditions;
	
	/** 用户过滤yanqgi**/

	private int userid;
	
	private String username;
	
	private String handleUsername;
	
	private Date handleDate;
	
	private String auditUsername;
	
	private int orgid;
	
	private String jgmc;
	
	private String jgdm;
	
	private String newdate1;
	
	private String newdate2;
	
	private String modifydate1;
	
	private String modifydate2;
	
	private String arctype;
	
	private String strWhere;
	
	private String strPx;
	
	private String imageData;
	
	private String pageTypeStr;
	
	private List ywlxConditions;
	
	private List ywlxConditions2;
	
	private List dutyConditions;
	
	private List funcConditions;
	
	private String bzjgdm;
	
	private String dybz;
	
	private String qsbh;
	
	private String jzbh;
	
	private String zstype;
	
	private String qsdm;
	
	private String jzdm;
	
	private String flag;
	
	private int czshbz;
	
	private int categoryid;
	
	private String ywqx;
	
	private String qxCode;
	
	private String centerBzjgdm;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

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
	
	
	public List getStateConditions() {
		return stateConditions;
	}
	public void setStateConditions(List stateConditions) {
		this.stateConditions = stateConditions;
	}
	
	
	public List getStateConditions2() {
		return stateConditions2;
	}
	public void setStateConditions2(List stateConditions2) {
		this.stateConditions2 = stateConditions2;
	}

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public void setOrgid(int orgid) {
		this.orgid = orgid;
	}

	public int getOrgid() {
		return orgid;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	public String getJgmc() {
		return jgmc;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}

	public String getJgdm() {
		return jgdm;
	}

	public void setNewdate1(String newdate1) {
		this.newdate1 = newdate1;
	}

	public String getNewdate1() {
		return newdate1;
	}

	public void setNewdate2(String newdate2) {
		this.newdate2 = newdate2;
	}

	public String getNewdate2() {
		return newdate2;
	}

	public void setModifydate1(String modifydate1) {
		this.modifydate1 = modifydate1;
	}

	public String getModifydate1() {
		return modifydate1;
	}

	public void setModifydate2(String modifydate2) {
		this.modifydate2 = modifydate2;
	}

	public String getModifydate2() {
		return modifydate2;
	}

	public void setArctype(String arctype) {
		this.arctype = arctype;
	}

	public String getArctype() {
		return arctype;
	}

	public void setStrWhere(String strWhere) {
		this.strWhere = strWhere;
	}

	public String getStrWhere() {
		return strWhere;
	}

	public void setStrPx(String strPx) {
		this.strPx = strPx;
	}

	public String getStrPx() {
		return strPx;
	}

	public void setPzjgdmConditions(List pzjgdmConditions) {
		this.pzjgdmConditions = pzjgdmConditions;
	}

	public List getPzjgdmConditions() {
		return pzjgdmConditions;
	}

	public void setBzjgdm(String bzjgdm) {
		this.bzjgdm = bzjgdm;
	}

	public String getBzjgdm() {
		return bzjgdm;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	public String getImageData() {
		return imageData;
	}

	public void setPageTypeStr(String pageTypeStr) {
		this.pageTypeStr = pageTypeStr;
	}

	public String getPageTypeStr() {
		return pageTypeStr;
	}

	public void setYwlxConditions(List ywlxConditions) {
		this.ywlxConditions = ywlxConditions;
	}
	
	public List getYwlxConditions() {
		return ywlxConditions;
	}

	public void setYwlxConditions2(List ywlxConditions2) {
		this.ywlxConditions2 = ywlxConditions2;
	}
	
	public List getYwlxConditions2() {
		return ywlxConditions2;
	}
	
	public void setDutyConditions(List dutyConditions) {
		this.dutyConditions = dutyConditions;
	}

	public List getDutyConditions() {
		return dutyConditions;
	}

	
	public void setFuncConditions(List funcConditions) {
		this.funcConditions = funcConditions;
	}

	public List getFuncConditions() {
		return funcConditions;
	}

	public void setDflagConditions(List dflagConditions) {
		this.dflagConditions = dflagConditions;
	}

	public List getDflagConditions() {
		return dflagConditions;
	}

	public void setDybz(String dybz) {
		this.dybz = dybz;
	}

	public String getDybz() {
		return dybz;
	}

	public void setQsbh(String qsbh) {
		this.qsbh = qsbh;
	}

	public String getQsbh() {
		return qsbh;
	}

	public void setJzbh(String jzbh) {
		this.jzbh = jzbh;
	}

	public String getJzbh() {
		return jzbh;
	}

	public void setZstype(String zstype) {
		this.zstype = zstype;
	}

	public String getZstype() {
		return zstype;
	}

	public void setQsdm(String qsdm) {
		this.qsdm = qsdm;
	}

	public String getQsdm() {
		return qsdm;
	}

	public void setJzdm(String jzdm) {
		this.jzdm = jzdm;
	}

	public String getJzdm() {
		return jzdm;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFlag() {
		return flag;
	}

	public void setHandleUsername(String handleUsername) {
		this.handleUsername = handleUsername;
	}

	public String getHandleUsername() {
		return handleUsername;
	}

	@Override
	public String toString() {
		return "Page [totalProperty=" + totalProperty + ", root=" + root
				+ ", start=" + start + ", limit=" + limit + ", success="
				+ success + ", conditions=" + conditions + ", stateConditions="
				+ stateConditions + ", stateConditions2=" + stateConditions2
				+ ", pzjgdmConditions=" + pzjgdmConditions + ", objCondition="
				+ objCondition + ", dflagConditions=" + dflagConditions
				+ ", userid=" + userid + ", username=" + username
				+ ", handleUsername=" + handleUsername + ", orgid=" + orgid
				+ ", jgmc=" + jgmc + ", jgdm=" + jgdm + ", newdate1="
				+ newdate1 + ", newdate2=" + newdate2 + ", modifydate1="
				+ modifydate1 + ", modifydate2=" + modifydate2 + ", arctype="
				+ arctype + ", strWhere=" + strWhere + ", strPx=" + strPx
				+ ", imageData=" + imageData + ", pageTypeStr=" + pageTypeStr
				+ ", ywlxConditions=" + ywlxConditions + ", ywlxConditions2="
				+ ywlxConditions2 + ", dutyConditions=" + dutyConditions
				+ ", funcConditions=" + funcConditions + ", bzjgdm=" + bzjgdm
				+ ", dybz=" + dybz + ", qsbh=" + qsbh + ", jzbh=" + jzbh
				+ ", zstype=" + zstype + ", qsdm=" + qsdm + ", jzdm=" + jzdm
				+ ", flag=" + flag + ", categoryid=" + categoryid + "]";
	}

	public String getAuditUsername() {
		return auditUsername;
	}

	public void setAuditUsername(String auditUsername) {
		this.auditUsername = auditUsername;
	}

	public List getBzjgdmConditions() {
		return bzjgdmConditions;
	}

	public void setBzjgdmConditions(List bzjgdmConditions) {
		this.bzjgdmConditions = bzjgdmConditions;
	}

	public Date getHandleDate() {
		return handleDate;
	}

	public void setHandleDate(Date handleDate) {
		this.handleDate = handleDate;
	}

	public int getCzshbz() {
		return czshbz;
	}

	public void setCzshbz(int czshbz) {
		this.czshbz = czshbz;
	}

	public String getYwqx() {
		return ywqx;
	}

	public void setYwqx(String ywqx) {
		this.ywqx = ywqx;
	}

	public String getCenterBzjgdm() {
		return centerBzjgdm;
	}

	public void setCenterBzjgdm(String centerBzjgdm) {
		this.centerBzjgdm = centerBzjgdm;
	}

	public String getQxCode() {
		return qxCode;
	}

	public void setQxCode(String qxCode) {
		this.qxCode = qxCode;
	}
	
}
