package com.lhq.prj.bms.service;

public interface AllocateCodeService {
	public String applyCode(String center_id, String dmlx, String jgmc,String zch, String flag);
	
	public String successConfirm(String center_id, String jgmc, String zch, String jgdm);
}
