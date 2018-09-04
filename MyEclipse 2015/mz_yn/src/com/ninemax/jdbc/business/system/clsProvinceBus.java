package com.ninemax.jdbc.business.system;

import com.ninemax.jdbc.dao.system.clsProvinceDAO;
import com.ninemax.jdbc.to.system.clsProvinceTO;

import java.util.ArrayList;
import java.util.HashMap;

public class clsProvinceBus {
	
	private clsProvinceDAO provinceDAO = null;
    public clsProvinceBus(){
    	provinceDAO = new clsProvinceDAO();
    }
    
    /**
     * 添加省份
     * @param provinceTO
     * @return
     */
    public int AddProvince(clsProvinceTO provinceTO){
    	
    	
    	if(IsExistId(provinceTO.getId())){
    		return -1;
    	}
    	if(IsExistName(provinceTO.getProvinceName())){
    		return -2;
    	}
    	
    	if(provinceDAO.AddProvince(provinceTO)){
    		return 1;
    	}else{
    		return -3;
    	}
    	
    }
    
    /**
     * 修改省份
     * @param provinceTO
     * @return
     */
    public int ModifyProvince(clsProvinceTO provinceTO){
    	
    	clsProvinceTO newProvinceTO = GetProvinceByName(provinceTO.getProvinceName());
        if(newProvinceTO!=null){
        	String newId = newProvinceTO.getId();
        	if(!provinceTO.getId().equals(newId)){
        		return -1;
        	}
        }
        if(provinceDAO.ModifyProvince(provinceTO)){
        	return 1;
        }else{
        	return -2;
        }
    }
    
    /**
     * 根据ID删除省份数据
     * @param id
     * @return
     */
    public boolean DeleteProvince(String id){
    	return provinceDAO.DeleteProvince(id);
    }
    
    /**
     * 省份列表
     * @return
     */
    public ArrayList ListAll(){
    	return provinceDAO.ListAll();
    }
    
    /**
	 * 列出一级行政区划列表信息
	 * @return
	 */
    public ArrayList ListFirstAll(){
    	return provinceDAO.ListFirstAll();
    }
    /**
	 * 列出二级行政区划列表信息
	 * @return
	 */
    public ArrayList ListTwoAll(String first_id){
    	return provinceDAO.ListTwoAll(first_id);
    }
    /**
     * 获得区县数据
     * @param first_id
     * @return
     */
    public ArrayList listQxAll(String first_id){
    	return provinceDAO.listQxAll(first_id);
    }
    /**
     * 获得市数据
     * @param first_id
     * @return
     */
    public ArrayList listSAll(String first_id){
    	return provinceDAO.listSAll(first_id);
    }
    /**
	 * 列出三级行政区划列表信息
	 * @return
	 */
    public ArrayList ListThreeAll(String two_id){
    	ArrayList listThreeAll = new ArrayList();
    	if(provinceDAO.IsExistTwo(two_id)){
    		listThreeAll =  provinceDAO.ListThreeAll(two_id);
    	}
    	return listThreeAll;
    }
    
    /**
     * 根据ID得到省份对象
     * @param id
     * @return
     */
    public clsProvinceTO GetProvinceById(String id){
    	return provinceDAO.FindProvinceById(id);
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
    	return provinceDAO.FindProvinceById(id).getProvinceName();
    }
    
    /**
     * 根据名称得到省份对象
     * @param name
     * @return
     */
    public clsProvinceTO GetProvinceByName(String name){
    	return provinceDAO.FindProvinceByName(name);
    }
    
    /**
     * 省份ID是否存在
     * @param id
     * @return
     */
    public boolean IsExistId(String id){
    	
    	clsProvinceTO provinceTO = provinceDAO.FindProvinceById(id);
    	if(provinceTO!=null){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    /**
     * 判断有没有二级行政区划
     * @param id
     * @return
     */
    public boolean IsExistTwo(String id){
    	return provinceDAO.IsExistTwo(id);
    }
    /**
     * 省份名称是否存在
     * @param name
     * @return
     */
    public boolean IsExistName(String name){
    	
    	clsProvinceTO provinceTO = provinceDAO.FindProvinceByName(name);
    	if(provinceTO!=null){
    		return true;
    	}else{
    		return false;
    	}
    }
    //zhoupengpeng test
    public String getString(String a){
    	return a;
    }

    public HashMap<String, String> putAll() {
        return provinceDAO.putAll();
    }

    public boolean isSjFlag(String bzjgdm) {
        return provinceDAO.isSjFlag(bzjgdm);
    }

    public String getProvinceName(String bzjgdm) {
        return provinceDAO.getProvinceName(bzjgdm);
    }
}
