package com.ninemax.jdbc.dao.system;

import com.ninemax.jdbc.dao.DataAccess;
import com.ninemax.jpa.system.model.Rightkey;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

import java.sql.SQLException;
import java.util.ArrayList;


public class clsRightKeyDAO {
	private static Logger log = Logger.getLogger(clsRightKeyDAO.class);
	public clsRightKeyDAO(){

	}


	
	public static ArrayList ListParentNode() {
		
		DataAccess dataAccessObject  = new DataAccess();
		CachedRowSet crs = null;
		ArrayList arrParentNode = new ArrayList();
		
		String sql = "select * from sm_rightkey where rightkey_depth='1' order by orderby asc";
		try{
			
			crs = dataAccessObject.query(sql);
			while(crs.next()){
				
				Rightkey rightKeyTO = SetRightKeyTO(crs);
				
				arrParentNode.add(rightKeyTO);
			}
			crs.close();
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return arrParentNode;
	}

	public  ArrayList ListChildNode(String parentId) {
		
		DataAccess dataAccessObject  = new DataAccess();
		CachedRowSet crs = null;
		ArrayList arrParentNode = new ArrayList();
		
		String sql = "select * from sm_rightkey where parentId = '"+parentId+"' order by orderby asc";
		
		try{
			
			crs = dataAccessObject.query(sql);
			while(crs.next()){
				
				Rightkey rightKeyTO = SetRightKeyTO(crs);
				
				arrParentNode.add(rightKeyTO);
			}
			crs.close();
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return arrParentNode;
	}

	public Rightkey FindById(String keyId) {
		
		DataAccess dataAccessObject  = new DataAccess();
		CachedRowSet crs = null;
		Rightkey rightKeyTO = null;
		
		String sql = "select * from sm_rightkey where rightkey_id = '"+keyId+"'";
		try{
	
			crs = dataAccessObject.query(sql);
			if(crs.next()){
				
				rightKeyTO = SetRightKeyTO(crs);
				
				
			}
			crs.close();
		}catch(Exception e){
			
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return rightKeyTO;
	}
	

	public Rightkey FindByName(String rightkey_name) {
		
		DataAccess dataAccessObject  = new DataAccess();
		CachedRowSet crs = null;
		Rightkey rightKeyTO = null;
		
		String sql = "select * from sm_rightkey where rightkey_name = '%"+rightkey_name+"'";
		try{
			
			crs = dataAccessObject.query(sql);
			if(crs.next()){
				
				rightKeyTO = SetRightKeyTO(crs);
				
				
			}
			crs.close();
		}catch(Exception e){
			
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return rightKeyTO;
	}



	
	public  boolean DeleteKey(String keyId){
    	
    	boolean reuslt = false;
    	DataAccess dataAccessObject  = new DataAccess();
		String sql = "delete from  sm_rightkey  where rightKey_id='"+keyId+"'";
		try{
			if(dataAccessObject.execute(sql)==1){
				reuslt = true;
			}else{
				reuslt = false;
			}
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);

		}
		return reuslt ;
    }
	
	private static Rightkey SetRightKeyTO(CachedRowSet crs) throws SQLException{
		
		Rightkey rightKeyTO = new Rightkey();
		rightKeyTO.setId(crs.getInt("id"));
		rightKeyTO.setRightkeyDepth(crs.getString("rightKey_depth").trim());
		rightKeyTO.setRightkeyId(crs.getString("rightKey_id"));
		rightKeyTO.setRightkeyName(crs.getString("rightKey_name").trim());
		rightKeyTO.setRightkeyKind(crs.getString("rightKey_kind").trim());
		rightKeyTO.setRightkeyFunc(crs.getString("rightKey_func"));
		rightKeyTO.setRightkeyFullname(crs.getString("rightKey_fullname"));
		rightKeyTO.setLinkpage(crs.getString("linkPage"));
		rightKeyTO.setOrderby(crs.getString("orderBy"));
		rightKeyTO.setParentid(crs.getString("parentId").trim());
		rightKeyTO.setPictrue(crs.getString("pictrue"));
		rightKeyTO.setType(crs.getString("type").trim());
		return rightKeyTO;
		
	}

}
