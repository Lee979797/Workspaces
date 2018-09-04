package com.ninemax.jdbc.dao.application;

import com.ninemax.jdbc.dao.DataAccess;
import com.ninemax.jdbc.to.system.clsProvinceTO;
import com.ninemax.jpa.code.bus.TFzdmBus;
import com.ninemax.jpa.code.bus.TJglxBus;
import com.ninemax.jpa.code.bus.TQzjgdmBus;
import com.ninemax.jpa.code.bus.TjgdmBus;
import com.ninemax.jpa.code.model.ScXzqhdz;
import com.ninemax.jpa.code.model.TFzdm;
import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.code.model.TJgdmSave;
import com.ninemax.jpa.code.model.TJglx;
import com.ninemax.jpa.code.model.TQzjgdm;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.clsStringTool;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class XzqjDAO {

	private static Logger log = Logger.getLogger(XzqjDAO.class);
	public List<clsProvinceTO> getChildElements(String likeId ,String id){
		List<clsProvinceTO> resultMap = new ArrayList<clsProvinceTO>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM sc_xzqh WHERE xzqh_id like '"+clsStringTool.convertNull(likeId)+"' AND xzqh_id !='"+clsStringTool.convertNull(id)+"' ");
		DataAccess dateAccessObject = new DataAccess();

		clsProvinceTO pro = null;
		try{
			CachedRowSet crs = dateAccessObject.query(sql.toString());
			while(crs.next()){
				pro = new clsProvinceTO();
				pro.setId(crs.getString("xzqh_id"));
				pro.setProvinceName(crs.getString("xzqh_name"));
				resultMap.add(pro);
			}
			return resultMap;
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
	}
    
	public List<clsProvinceTO> getFatherElements(){
		List<clsProvinceTO> resultMap = new ArrayList<clsProvinceTO>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM sc_xzqh WHERE xzqh_id like '%0000' order by xzqh_id asc ");
		DataAccess dateAccessObject = new DataAccess();
		
		clsProvinceTO pro = null;
		try{
			CachedRowSet crs = dateAccessObject.query(sql.toString());
			while(crs.next()){
				pro = new clsProvinceTO();
				pro.setId(crs.getString("xzqh_id"));
				pro.setProvinceName(crs.getString("xzqh_name"));
				resultMap.add(pro);
			}
			return resultMap;
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
	}

	public clsProvinceTO getProById(String id){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT xzqh_id, xzqh_name FROM sc_xzqh WHERE xzqh_id='"+id+"' ");
		DataAccess dateAccessObject = new DataAccess();
		clsProvinceTO pro = null;
		try{
			CachedRowSet crs = dateAccessObject.query(sql.toString());
			if(crs.next()){
				pro = new clsProvinceTO();
				pro.setId(crs.getString("xzqh_id"));
				pro.setProvinceName(crs.getString("xzqh_name"));
			}
			return pro;
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
	}
}
