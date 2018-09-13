package com.lhq.prj.bms.action;

import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.po.Qx;
import com.lhq.prj.bms.service.IQxService;

public class QxAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IQxService qxService;
	private String[] bs;
	private String[] yw;
	private String[] ywsh;
	private String bsStr;
	private String ywStr;
	private boolean success;
	private List ywCodes;
	
	public void setQxService(IQxService qxService) {
		this.qxService = qxService;
	}
	
	public String saveBzjgYwSet(){
		
		bsStr = getRequest().getParameter("bsStr");
		bsStr = bsStr.replaceAll("\\[", "");
		bsStr = bsStr.replaceAll("\\]", "");
		bs = bsStr.split(",");
		
		ywStr = getRequest().getParameter("ywStr");
		ywStr = ywStr.replaceAll("\\[", "");
		ywStr = ywStr.replaceAll("\\]", "");
		yw = ywStr.split(",");
		
		for(int i=0;i<bs.length;i++){
			Qx qx = new Qx();
			qx.setBzjgCode(bs[i].replaceAll("\"", ""));
			
			qxService.deleteByBzjgCode(qx);
			
			for(int j=0;j<yw.length;j++){
				String str = yw[j];    //"1/0" --"ywlxCode/shbz/ywlx"
				ywsh = str.split("/");
				qx.setYwlxCode(ywsh[0].replaceAll("\"", ""));
				qx.setShbz(Integer.valueOf(ywsh[1]));
				qx.setYwlx(ywsh[2].replaceAll("\"", ""));
				
				success = qxService.saveQxSet(qx);
			}
		}
		
		return SUCCESS;
	}
	public String delBzjgYwSet(){
		bsStr = getRequest().getParameter("bsStr");
		bsStr = bsStr.replaceAll("\\[", "");
		bsStr = bsStr.replaceAll("\\]", "");
		bs = bsStr.split(",");
		
		for(int i=0;i<bs.length;i++){
			Qx qx = new Qx();
			qx.setBzjgCode(bs[i].replaceAll("\"", ""));
			qxService.deleteByBzjgCode(qx);
		}
		return SUCCESS;
	}
	
	public String findByBzjgCode(){
		
		String bzjgCode = getRequest().getParameter("bzjgCode");
		Qx qx = new Qx();
		qx.setBzjgCode(bzjgCode);
		ywCodes = qxService.findByBzjgCode(qx);
		System.out.println(ywCodes);
		return SUCCESS;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List getYwCodes() {
		return ywCodes;
	}

	public void setYwCodes(List ywCodes) {
		this.ywCodes = ywCodes;
	}

}
