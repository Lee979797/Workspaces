package com.ninemax.jdbc.business.system;

import com.ninemax.jdbc.dao.system.clsBzjgdmDAO;
import com.ninemax.jpa.system.model.Bzjgdm;

import java.util.ArrayList;
import java.util.List;

public class clsBzjgdmBus {
	
	private clsBzjgdmDAO bzjgdmDAO = null;
    public clsBzjgdmBus(){
    	bzjgdmDAO = new clsBzjgdmDAO();
    }
    
    
    /**
     * 省份列表
     * @return
     */
    public ArrayList ListAll(){
    	return bzjgdmDAO.ListAll();
    }
    
    /**
	 * 列出一级省份列表信息
	 * @return
	 */
    public List<Bzjgdm> ListFirstAll(){
    	return bzjgdmDAO.ListFirstAll();
    }
    
    /**
     * 根据ID得到省份对象
     * @param id
     * @return
     */
    public Bzjgdm GetProvinceById(String id){
    	return bzjgdmDAO.FindBzjgdmById(id);
    }
    /*
     * zhoupengpeng 由id返回 省市名称
     */
    /**
     * 根据ID得到省份名称
     * @param id
     * @return
     */
    public String GetProById(String id){
    	return bzjgdmDAO.FindBzjgdmById(id).getMc();
    }
    
    /**
     * 根据名称得到省份对象
     * @param name
     * @return
     */
    public Bzjgdm GetBzjgdmByName(String name){
    	return bzjgdmDAO.FindBzjgdmByName(name);
    }
    
    /**
     * 省份ID是否存在
     * @param id
     * @return
     */
    public boolean IsExistId(String id){
    	
    	Bzjgdm BzjgdmTO = bzjgdmDAO.FindBzjgdmById(id);
    	if(BzjgdmTO!=null){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    /**
     * 省份名称是否存在
     * @param name
     * @return
     */
    public boolean IsExistName(String name){
    	
    	Bzjgdm bzjgdm = bzjgdmDAO.FindBzjgdmByName(name);
    	if(bzjgdm!=null){
    		return true;
    	}else{
    		return false;
    	}
    }
    //zhoupengpeng test
    public String getString(String a){
    	return a;
    }
    
    /**
     * 根据行政区划ID得到列表
     * @param xzqh_id
     * @return
     */
    public List<Bzjgdm> FindBzjgdmByXzqhID(String xzqh_id){
    	return bzjgdmDAO.FindBzjgdmByXzqhID(xzqh_id);
    }

    /**
     * 列出所有一级办证机构
     * @return
     */
    public ArrayList listScCenterAll() {
       return bzjgdmDAO.listScCenterAll();
    }
}
