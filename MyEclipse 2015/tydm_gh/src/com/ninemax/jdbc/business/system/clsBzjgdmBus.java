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
     * ʡ���б�
     * @return
     */
    public ArrayList ListAll(){
    	return bzjgdmDAO.ListAll();
    }
    
    /**
	 * �г�һ��ʡ���б���Ϣ
	 * @return
	 */
    public List<Bzjgdm> ListFirstAll(){
    	return bzjgdmDAO.ListFirstAll();
    }
    
    /**
     * ����ID�õ�ʡ�ݶ���
     * @param id
     * @return
     */
    public Bzjgdm GetProvinceById(String id){
    	return bzjgdmDAO.FindBzjgdmById(id);
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
    	return bzjgdmDAO.FindBzjgdmById(id).getMc();
    }
    
    /**
     * �������Ƶõ�ʡ�ݶ���
     * @param name
     * @return
     */
    public Bzjgdm GetBzjgdmByName(String name){
    	return bzjgdmDAO.FindBzjgdmByName(name);
    }
    
    /**
     * ʡ��ID�Ƿ����
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
     * ʡ�������Ƿ����
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
     * ������������ID�õ��б�
     * @param xzqh_id
     * @return
     */
    public List<Bzjgdm> FindBzjgdmByXzqhID(String xzqh_id){
    	return bzjgdmDAO.FindBzjgdmByXzqhID(xzqh_id);
    }

    /**
     * �г�����һ����֤����
     * @return
     */
    public ArrayList listScCenterAll() {
       return bzjgdmDAO.listScCenterAll();
    }
}
