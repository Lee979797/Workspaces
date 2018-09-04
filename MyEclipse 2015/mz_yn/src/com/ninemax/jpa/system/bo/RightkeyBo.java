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
		
		if( rightkeyDAO.delete(keyId)){
			return 1;
		}else{
			return -2;//操作失败
		}
	}
	
	/**
	 * 根据ID得到权限对象
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
	 * 判断权限ID是否被用户使用
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
	 * 根据权限ID得到子权限
	 * @param keyId
	 * @return
	 */
	public List<Rightkey> ListChildNode(String keyId) {
		return rightkeyDAO.ListChildNode(keyId);
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
	 * 列出一级栏目
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
	 *是否有子栏目 
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
	 * 列出某一层的栏目
	 * parentId为0列出第一级栏目
	 **/
	public  List<Rightkey> GetChildren(String keyId){
		
		return rightkeyDAO.ListChildNode(keyId);
	}
	
	/**
	 * 栏目是否拥有增加查改权限 
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
