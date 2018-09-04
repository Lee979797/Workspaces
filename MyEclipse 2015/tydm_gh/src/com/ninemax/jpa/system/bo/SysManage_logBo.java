package com.ninemax.jpa.system.bo;

import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.dao.SysManage_logDAO;
import com.ninemax.jpa.system.model.SysManage_log;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;

import java.text.ParseException;
import java.util.List;

public class SysManage_logBo {
	private SysManage_logDAO sysManage_logDAO = new SysManage_logDAO();
	
	public List<SysManage_log> findAll() {
		return sysManage_logDAO.findAll();
	}
	public List<SysManage_log> findPageList(String searchField, String searchValue,String startDate, String endDate,String orderbyColum,String orderbyMethod,int pageSize,int pageNo,clsPageComponent pageComponent) throws ParseException  {
		String newValue = "";
        if(!clsStringTool.isEmpty(searchValue)){
            User user = new UserBo().FindByChineseName(searchValue.trim());
            if(user!=null){
                newValue = String.valueOf(user.getUserId());
            }else{
            	newValue="dhsjfh2134287mvcxz../ckv";
            }
        }
        return sysManage_logDAO.findPageList(searchField, newValue,startDate,endDate,orderbyColum,orderbyMethod,pageSize, pageNo, pageComponent);
	}
	public boolean save(SysManage_log sysManage_log){
		return sysManage_logDAO.save(sysManage_log);
	}
	public boolean update(SysManage_log sysManage_log){
		return sysManage_logDAO.update(sysManage_log);
	}
	public boolean delete(SysManage_log sysManage_log){
		return sysManage_logDAO.delete(sysManage_log);
	}
	public SysManage_log findById(String id){
		return sysManage_logDAO.findById(id);
	}

}
