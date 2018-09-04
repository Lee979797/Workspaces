package com.ninemax.jdbc.business.system;

import com.ninemax.jdbc.dao.system.clsRightKeyDAO;
import com.ninemax.jdbc.dao.system.clsUserRightKeyDAO;
import com.ninemax.jpa.system.model.Rightkey;

import java.util.ArrayList;

/**
 * 权限类
 */

public class clsRightKeyBus {

	/*#com.ninemax.nacao.business.system.clsRoleRightKeyBus Dependency20*/
	/*#com.ninemax.nacao.business.system.clsUserRightKeyBus Dependency201*/
    private clsRightKeyDAO rightKeyDAO = null;
	public clsRightKeyBus() {
		
		rightKeyDAO = new clsRightKeyDAO();
	}
	
	/**
	 * 根据ID得到权限对象
	 * @param keyId
	 * @return
	 */
	public Rightkey GetRightKey(String keyId) {
			
		return rightKeyDAO.FindById(keyId);
	}
	
	/**
	 * 根据ID删除权限数据
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
			return -2;//操作失败
		}
	}
	
	/**
	 * 判断权限ID是否被用户使用
	 * @param keyId
	 * @return
	 */
	public boolean isUsedByUser(String keyId){
		
		return new clsUserRightKeyDAO().FindByKeyId(keyId);
	}
	
	/**
	 * 根据权限ID得到子权限
	 * @param keyId
	 * @return
	 */
	public  ArrayList ListChildNode(String keyId) {
		return rightKeyDAO.ListChildNode(keyId);
	}
	
	/**
	 * 列出所有的栏目
	 * 递归按顺序列出
	 ***/
	private  String listAll_parentId = "0";//这个变量专门用于这个递归方法
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
	 * 列出一级栏目
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
	 *是否有子栏目 
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
	 * 列出某一层的栏目
	 * parentId为0列出第一级栏目
	 **/
	public  ArrayList GetChildren(String keyId){
		
		return rightKeyDAO.ListChildNode(keyId);
	}
	
	/**
	 * 栏目是否拥有增加查改权限 
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
