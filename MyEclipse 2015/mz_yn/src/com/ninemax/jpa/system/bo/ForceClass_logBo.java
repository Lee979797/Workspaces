package com.ninemax.jpa.system.bo;

import com.ninemax.jpa.system.dao.ForceClass_logDAO;
import com.ninemax.jpa.system.model.ForceClass_log;
import com.ninemax.jpa.util.clsPageComponent;

import java.text.ParseException;
import java.util.List;

public class ForceClass_logBo {
	private ForceClass_logDAO forceClass_logDAO = new ForceClass_logDAO();
	
	public List<ForceClass_log> findAll() {
		return forceClass_logDAO.findAll();
	}
	public List<ForceClass_log> findPageList(String searchField, String searchValue,String startDate, String endDate,String orderbyColum,String orderbyMethod,int pageSize,int pageNo,clsPageComponent pageComponent) throws ParseException  {
		return forceClass_logDAO.findPageList(searchField, searchValue,startDate,endDate,orderbyColum,orderbyMethod,pageSize, pageNo, pageComponent);
	}
	public boolean save(ForceClass_log ForceClass_log){
		return forceClass_logDAO.save(ForceClass_log);
	}
	public boolean update(ForceClass_log ForceClass_log){
		return forceClass_logDAO.update(ForceClass_log);
	}
	public boolean delete(ForceClass_log ForceClass_log){
		return forceClass_logDAO.delete(ForceClass_log);
	}
	public ForceClass_log findById(String id){
		return forceClass_logDAO.findById(id);
	}

}
