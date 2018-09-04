package com.ninemax.jdbc.business.system;

import com.ninemax.jdbc.dao.system.clsRightKeyDAO;
import com.ninemax.jdbc.dao.system.clsUserRightKeyDAO;
import com.ninemax.jpa.system.model.Rightkey;

import java.util.ArrayList;

/**
 * Ȩ����
 */

public class clsRightKeyBus {

	/*#com.ninemax.nacao.business.system.clsRoleRightKeyBus Dependency20*/
	/*#com.ninemax.nacao.business.system.clsUserRightKeyBus Dependency201*/
    private clsRightKeyDAO rightKeyDAO = null;
	public clsRightKeyBus() {
		
		rightKeyDAO = new clsRightKeyDAO();
	}
	
	/**
	 * ����ID�õ�Ȩ�޶���
	 * @param keyId
	 * @return
	 */
	public Rightkey GetRightKey(String keyId) {
			
		return rightKeyDAO.FindById(keyId);
	}
	
	/**
	 * ����IDɾ��Ȩ������
	 * @param keyId
	 * @return
	 */
	public int DeteleRightKey(String keyId) {
			
		if(isUsedByUser(keyId)){
			return -1;
		}
		
		if(ListChildNode(keyId).size()>0){
			return -3;
		}
		
		if( rightKeyDAO.DeleteKey(keyId)){
			return 1;
		}else{
			return -2;//����ʧ��
		}
	}
	
	/**
	 * �ж�Ȩ��ID�Ƿ��û�ʹ��
	 * @param keyId
	 * @return
	 */
	public boolean isUsedByUser(String keyId){
		
		return new clsUserRightKeyDAO().FindByKeyId(keyId);
	}
	
	/**
	 * ����Ȩ��ID�õ���Ȩ��
	 * @param keyId
	 * @return
	 */
	public  ArrayList ListChildNode(String keyId) {
		return rightKeyDAO.ListChildNode(keyId);
	}
	
	/**
	 * �г����е���Ŀ
	 * �ݹ鰴˳���г�
	 ***/
	private  String listAll_parentId = "0";//�������ר����������ݹ鷽��
	public String getListAll_parentId() {
		return listAll_parentId;
	}

	public void setListAll_parentId(String listAll_parentId) {
		this.listAll_parentId = listAll_parentId;
	}
	private  ArrayList listAll_array = new ArrayList();
	public   ArrayList ListAllToMune(){
		ArrayList array = new ArrayList();
		array = GetChildren(listAll_parentId);
		
		if(array!=null&&array.size()>0){
			
			for(int aIndex=0;aIndex<array.size();aIndex++){
				Rightkey rightKeyTO = (Rightkey)array.get(aIndex);
				String keyId = rightKeyTO.getRightkeyId();
				String type = rightKeyTO.getType();
				
				if("1".equals(type)){
				
					listAll_array.add(rightKeyTO);
				}
				
				if(HasSunChannel(keyId)){
					listAll_parentId = keyId;
					ListAllToMune();
				}
			}
		}
		return listAll_array;
	}
	
	/**
	 * �г�һ����Ŀ
	 * @param parentId
	 * @return
	 */
	public ArrayList ListFirstRight(String parentId){
		ArrayList array = GetChildren(parentId);
		ArrayList _array = new ArrayList();
		if(array!=null&&array.size()>0){
			
			for(int aIndex=0;aIndex<array.size();aIndex++){
				Rightkey rightKeyTO = (Rightkey)array.get(aIndex);
				String keyId = rightKeyTO.getRightkeyId();
				String type = rightKeyTO.getType();
				
				if("1".equals(type)){
				
					_array.add(rightKeyTO);
				}
			}
		}
		return _array;
	}
	/**
	 *�Ƿ�������Ŀ 
	 ***/
	
	public  boolean HasSunChannel(String keyid){
		
		ArrayList array = rightKeyDAO.ListChildNode(keyid);
		
		if(array==null || array.size()<1){
			return false;
		}else{
			return true;
		}
		
	}
	
	/**
	 * �г�ĳһ�����Ŀ
	 * parentIdΪ0�г���һ����Ŀ
	 **/
	public  ArrayList GetChildren(String keyId){
		
		return rightKeyDAO.ListChildNode(keyId);
	}
	
	/**
	 * ��Ŀ�Ƿ�ӵ�����Ӳ��Ȩ�� 
	 ***/
	public boolean HasAddRight(String keyId){
		if(HasSunChannel(keyId)){
			ArrayList childNodes = ListChildNode(keyId);
			Rightkey rightKeyTO = (Rightkey)childNodes.get(0);
			String type = rightKeyTO.getType();
			if("1".equals(type)){
				return false;
			}else{
				return true;
			}
		}else{
			return false;
		}
	}

	
}
