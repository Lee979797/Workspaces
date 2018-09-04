package com.ninemax.jpa.system.bo;

import com.ninemax.jpa.system.dao.Portfolio_logDAO;
import com.ninemax.jpa.system.model.Portfolio_log;
import com.ninemax.jpa.util.clsPageComponent;

import java.text.ParseException;
import java.util.List;

public class Portfolio_logBo {
	private Portfolio_logDAO portfolio_logDAO = new Portfolio_logDAO();
	
	public List<Portfolio_log> findAll() {
		return portfolio_logDAO.findAll();
	}
	public List<Portfolio_log> findPageList(String searchField, String searchValue,String startDate, String endDate,String orderbyColum,String orderbyMethod,int pageSize,int pageNo,clsPageComponent pageComponent,String bzd) throws ParseException  {
		return portfolio_logDAO.findPageList(searchField, searchValue,startDate,endDate,orderbyColum,orderbyMethod,pageSize, pageNo, pageComponent,bzd);
	}
	public boolean save(Portfolio_log Portfolio_log){
		return portfolio_logDAO.save(Portfolio_log);
	}
	public boolean update(Portfolio_log Portfolio_log){
		return portfolio_logDAO.update(Portfolio_log);
	}
	public boolean delete(Portfolio_log Portfolio_log){
		return portfolio_logDAO.delete(Portfolio_log);
	}
	public Portfolio_log findById(String id){
		return portfolio_logDAO.findById(id);
	}

}
