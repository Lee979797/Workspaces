package com.ninemax.jdbc.dao.application;

import com.ninemax.jdbc.dao.DataAccess;
import com.ninemax.jdbc.to.system.clsProvinceTO;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

import java.util.ArrayList;
import java.util.List;

public class ZrxzqhDAO {

	private static Logger log = Logger.getLogger(ZrxzqhDAO.class);
	public List<clsProvinceTO> getChildElements(String likeId ,String id){
		List<clsProvinceTO> resultList = new ArrayList<clsProvinceTO>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT distinct(zrxzqh_id), zrxzqh_name FROM sc_zrxzqh WHERE zrxzqh_id like '"+clsStringTool.convertNull(likeId)+"' AND zrxzqh_id !='"+clsStringTool.convertNull(id)+"' ");
		DataAccess dateAccessObject = new DataAccess();
	
		try{
			CachedRowSet crs = dateAccessObject.query(sql.toString());
			while(crs.next()){
				clsProvinceTO pro = new clsProvinceTO();
				pro.setId(crs.getString("zrxzqh_id"));
				pro.setProvinceName(crs.getString("zrxzqh_name"));
				resultList.add(pro);
			}
			return resultList;
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	
	public List<clsProvinceTO> getFatherElements(){
		List<clsProvinceTO> resultList = new ArrayList<clsProvinceTO>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT distinct(zrxzqh_id), zrxzqh_name FROM sc_zrxzqh WHERE zrxzqh_id like '%0000' order by zrxzqh_id asc ");
		DataAccess dateAccessObject = new DataAccess();

		try{
			CachedRowSet crs = dateAccessObject.query(sql.toString());
			while(crs.next()){
				clsProvinceTO pro = new clsProvinceTO();
				pro.setId(crs.getString("zrxzqh_id"));
				pro.setProvinceName(crs.getString("zrxzqh_name"));
				resultList.add(pro);
			}
			return resultList;
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	
	public clsProvinceTO getProById(String id){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT zrxzqh_id, zrxzqh_name FROM sc_zrxzqh WHERE zrxzqh_id='"+id+"' ");
		DataAccess dateAccessObject = new DataAccess();
		clsProvinceTO pro = null;

		try{
			CachedRowSet crs = dateAccessObject.query(sql.toString());
			if(crs.next()){
				pro = new clsProvinceTO();
				pro.setId(crs.getString("zrxzqh_id"));
				pro.setProvinceName(crs.getString("zrxzqh_name"));
			}
			return pro;
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
	}
}
