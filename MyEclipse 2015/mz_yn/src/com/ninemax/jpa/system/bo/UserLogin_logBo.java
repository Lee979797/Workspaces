package com.ninemax.jpa.system.bo;

import com.ninemax.jdbc.business.system.clsUserBus;
import com.ninemax.jpa.code.dao.TZrxzqhDAO;
import com.ninemax.jpa.code.model.TZrxzqh;
import com.ninemax.jpa.system.dao.UserLogin_logDAO;
import com.ninemax.jpa.system.model.Bzjgdm;
import com.ninemax.jpa.system.model.UserLogin_log;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;

import java.text.ParseException;
import java.util.List;

public class UserLogin_logBo {
	private UserLogin_logDAO userLogin_logDAO = new UserLogin_logDAO();
	private TZrxzqhDAO tzDAO = new TZrxzqhDAO();
	
	public List<UserLogin_log> findAll() {
		return userLogin_logDAO.findAll();
	}
    // 省级用户查询
	public List<UserLogin_log> findPageList(String searchField, String searchValue,String userLoginValue,String startDate, String endDate,String orderbyColum,String orderbyMethod,int pageSize,int pageNo,clsPageComponent pageComponent) throws ParseException  {
        if(!clsStringTool.isEmpty(userLoginValue)){
            String userName = new clsUserBus().findUserByChineseName(userLoginValue);
            if(!clsStringTool.isEmpty(userName)){
                return userLogin_logDAO.findPageList(searchField, searchValue,userName,startDate,endDate,orderbyColum,orderbyMethod,pageSize, pageNo, pageComponent);
            }else{
                return userLogin_logDAO.findPageList(searchField, searchValue,userLoginValue,startDate,endDate,orderbyColum,orderbyMethod,pageSize, pageNo, pageComponent);
            }
        }else
            return userLogin_logDAO.findPageList(searchField, searchValue,userLoginValue,startDate,endDate,orderbyColum,orderbyMethod,pageSize, pageNo, pageComponent);
	}
    // 市级用户查询
	public List<UserLogin_log> findPageByCityList(String bzjgdm,String searchField, String searchValue,String userLoginValue,String startDate, String endDate,String orderbyColum,String orderbyMethod,int pageSize,int pageNo,clsPageComponent pageComponent) throws ParseException  {
		Bzjgdm tz = tzDAO.findById(bzjgdm);
/*		if(!tz.getBzjgflag()){
			bzjgdm = bzjgdm.substring(0,4);
		}*/
		bzjgdm = bzjgdm.substring(0,4);
        if(!clsStringTool.isEmpty(userLoginValue)){
            String userName = new clsUserBus().findUserByChineseName(userLoginValue);
            if(!clsStringTool.isEmpty(userName)){
                return userLogin_logDAO.findPageByCityList(bzjgdm,searchField, searchValue,userName,startDate,endDate,orderbyColum,orderbyMethod,pageSize, pageNo, pageComponent);
            }else{
                return userLogin_logDAO.findPageByCityList(bzjgdm,searchField, searchValue,userLoginValue,startDate,endDate,orderbyColum,orderbyMethod,pageSize, pageNo, pageComponent);
            }
        }else
            return userLogin_logDAO.findPageByCityList(bzjgdm,searchField, searchValue,userLoginValue,startDate,endDate,orderbyColum,orderbyMethod,pageSize, pageNo, pageComponent);
	}
	
	// 仅用户查询
	public List<UserLogin_log> findPageByUserList(String userId,String searchField, String searchValue,String userLoginValue,String startDate, String endDate,String orderbyColum,String orderbyMethod,int pageSize,int pageNo,clsPageComponent pageComponent) throws ParseException  {
        if(!clsStringTool.isEmpty(userLoginValue)){
            String userName = new clsUserBus().findUserByChineseName(userLoginValue);
            if(!clsStringTool.isEmpty(userName)){
                return userLogin_logDAO.findPageByUserList(userId,searchField, searchValue,userName,startDate,endDate,orderbyColum,orderbyMethod,pageSize, pageNo, pageComponent);
            }else{
                return userLogin_logDAO.findPageByUserList(userId,searchField, searchValue,userLoginValue,startDate,endDate,orderbyColum,orderbyMethod,pageSize, pageNo, pageComponent);
            }
        }else
            return userLogin_logDAO.findPageByUserList(userId,searchField, searchValue,userLoginValue,startDate,endDate,orderbyColum,orderbyMethod,pageSize, pageNo, pageComponent);
	}
	public boolean save(UserLogin_log userLogin_log){
		return userLogin_logDAO.save(userLogin_log);
	}
	public boolean update(UserLogin_log userLogin_log){
		return userLogin_logDAO.update(userLogin_log);
	}
	public boolean delete(UserLogin_log userLogin_log){
		return userLogin_logDAO.delete(userLogin_log);
	}
	public UserLogin_log findById(String id){
		return userLogin_logDAO.findById(id);
	}

}
