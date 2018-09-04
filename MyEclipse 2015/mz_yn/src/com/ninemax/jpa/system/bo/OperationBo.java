package com.ninemax.jpa.system.bo;

import com.ninemax.jdbc.dao.clsPageComponent;
import com.ninemax.jpa.system.dao.OperationDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OperationBo {
	
	public OperationBo(){}
	
	private OperationDAO operationDAO = new OperationDAO();	
	private java.text.SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private	String date = sd.format(new Date());
	
	
	@SuppressWarnings("unchecked")
	public List findPageList(String startDate, String endDate,String orderbyColum,String orderbyMethod,int pageNo, int pageSize,clsPageComponent pageComponent) throws ParseException{
	
		
		return operationDAO.findPageList(startDate, endDate, orderbyColum, orderbyMethod, pageNo, pageSize, pageComponent);
	}
	
}
