package com.ninemax.jpa.system.bo;

import com.ninemax.jpa.system.dao.RightkeyDAO;
import com.ninemax.jpa.system.model.Rightkey;

import java.util.ArrayList;
import java.util.List;

public class RightkeyBo {
	private RightkeyDAO rightkeyDAO = new RightkeyDAO();
	
	public List<Rightkey> findAll() {
		return rightkeyDAO.findAll();
	}
	
	public boolean save(Rightkey rightkey){
		
		return rightkeyDAO.save(rightkey);
			
	}
	public boolean update(Rightkey rightkey){
		return rightkeyDAO.update(rightkey);
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
		
		if( rightkeyDAO.delete(keyId)){
			return 1;
		}else{
			return -2;//����ʧ��
		}
	}
	
	/**
	 * ����ID�õ�Ȩ�޶���
	 * @param keyId
	 * @return
	 */
	
	public Rightkey GetRightKey(String id){
		return rightkeyDAO.findById(id);
	}
	
	public List<Rightkey> findByRightkeyName(String RightkeyName
	) {
		return rightkeyDAO.findByRightkeyName(RightkeyName);
	}
	
	/**
	 * �ж�Ȩ��ID�Ƿ��û�ʹ��
	 * @param keyId
	 * @return
	 */
	public boolean isUsedByUser(String keyId){
		Rightkey rightkey = rightkeyDAO.findById(keyId);
		boolean reuslt = false;
		if(rightkey!=null){
			reuslt = true;
		}else{
			reuslt = false;
		}
		return reuslt;
	}
	
	/**
	 * ����Ȩ��ID�õ���Ȩ��
	 * @param keyId
	 * @return
	 */
	public List<Rightkey> ListChildNode(String keyId) {
		return rightkeyDAO.ListChildNode(keyId);
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
		
		List<Rightkey> array = new ArrayList();
		array = GetChildren(listAll_parentId);
		
		if(array!=null&&array.size()>0){
			
			for(int aIndex=0;aIndex<array.size();aIndex++){
				Rightkey rightkey = (Rightkey)array.get(aIndex);
				String keyId = String.valueOf(rightkey.getRightkeyId());
				String type = rightkey.getType();
				
				if("1".equals(type)){
				
					listAll_array.add(rightkey);
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
		List<Rightkey> array = GetChildren(parentId);
		ArrayList _array = new ArrayList();
		if(array!=null&&array.size()>0){
			
			for(int aIndex=0;aIndex<array.size();aIndex++){
				Rightkey rightkey = (Rightkey)array.get(aIndex);
				String keyId = String.valueOf(rightkey.getRightkeyId());
				String type = rightkey.getType();
				
				if("1".equals(type)){
				
					_array.add(rightkey);
				}
			}
		}
		return _array;
	}
	/**
	 *�Ƿ�������Ŀ 
	 ***/
	
	public  boolean HasSunChannel(String keyid){
		
		List<Rightkey> array = rightkeyDAO.ListChildNode(keyid);
		
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
	public  List<Rightkey> GetChildren(String keyId){
		
		return rightkeyDAO.ListChildNode(keyId);
	}
	
	/**
	 * ��Ŀ�Ƿ�ӵ�����Ӳ��Ȩ�� 
	 ***/
	public boolean HasAddRight(String keyId){
		if(HasSunChannel(keyId)){
			List<Rightkey> childNodes = ListChildNode(keyId);
			Rightkey rightkey = (Rightkey)childNodes.get(0);
			String type = rightkey.getType();
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
