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
     * ���ʡ��
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
     * �޸�ʡ��
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
     * ����IDɾ��ʡ������
     * @param id
     * @return
     */
    public boolean DeleteProvince(String id){
    	return provinceDAO.DeleteProvince(id);
    }
    
    /**
     * ʡ���б�
     * @return
     */
    public ArrayList ListAll(){
    	return provinceDAO.ListAll();
    }
    
    /**
	 * �г�һ�����������б���Ϣ
	 * @return
	 */
    public ArrayList ListFirstAll(){
    	return provinceDAO.ListFirstAll();
    }
    /**
	 * �г��������������б���Ϣ
	 * @return
	 */
    public ArrayList ListTwoAll(String first_id){
    	return provinceDAO.ListTwoAll(first_id);
    }
    /**
     * �����������
     * @param first_id
     * @return
     */
    public ArrayList listQxAll(String first_id){
    	return provinceDAO.listQxAll(first_id);
    }
    /**
     * ���������
     * @param first_id
     * @return
     */
    public ArrayList listSAll(String first_id){
    	return provinceDAO.listSAll(first_id);
    }
    /**
	 * �г��������������б���Ϣ
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
     * ����ID�õ�ʡ�ݶ���
     * @param id
     * @return
     */
    public clsProvinceTO GetProvinceById(String id){
    	return provinceDAO.FindProvinceById(id);
    }
    /*
     * zhoupengpeng ��id���� ʡ������
     */
    /**
     * ����ID�õ�ʡ������
     * @param id
     * @return
     */
    public String GetProById(String id){
    	return provinceDAO.FindProvinceById(id).getProvinceName();
    }
    
    /**
     * �������Ƶõ�ʡ�ݶ���
     * @param name
     * @return
     */
    public clsProvinceTO GetProvinceByName(String name){
    	return provinceDAO.FindProvinceByName(name);
    }
    
    /**
     * ʡ��ID�Ƿ����
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
     * �ж���û�ж�����������
     * @param id
     * @return
     */
    public boolean IsExistTwo(String id){
    	return provinceDAO.IsExistTwo(id);
    }
    /**
     * ʡ�������Ƿ����
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
