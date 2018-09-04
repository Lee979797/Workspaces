package com.ninemax.jdbc.dao.system;

import com.ninemax.jdbc.dao.DataAccess;
import com.ninemax.jpa.system.model.Bzjgdm;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class clsBzjgdmDAO {

	private static Logger log = Logger.getLogger(clsBzjgdmDAO.class);
	public Bzjgdm FindBzjgdmById(String id){

		DataAccess dataAccessObject  = new DataAccess();
		Bzjgdm bzjgdm = null;
		String sql = "select * from SC_bzjgdm where dm='"+id+"' ";
		try{
			CachedRowSet crs = dataAccessObject.query(sql);
			if(crs.next()){
				bzjgdm = SetBzjgdm(crs);
			}
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);

		}
		return bzjgdm;
	}


	public Bzjgdm FindBzjgdmByName(String name){

		DataAccess dataAccessObject  = new DataAccess();
		Bzjgdm bzjgdm = null;
		String sql = "select * from SC_bzjgdm where trim(mc)='"+name.trim()+"' ";
		try{
			CachedRowSet crs = dataAccessObject.query(sql);
			if(crs.next()){
				bzjgdm = SetBzjgdm(crs);
			}
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return bzjgdm;
	}

	public List<Bzjgdm> FindBzjgdmByXzqhID(String xzqh_id){

		DataAccess dataAccessObject  = new DataAccess();
		List<Bzjgdm> bzjgdms = new ArrayList();
		String sql = "select * from SC_bzjgdm where xzqh_id='"+xzqh_id+"' ";
		try{
			CachedRowSet crs = dataAccessObject.query(sql);
			while(crs.next()){
				Bzjgdm bzjgdm = SetBzjgdm(crs);
				bzjgdms.add(bzjgdm);
			}
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return bzjgdms;
	}

	/**
	 * 列出省份列表信息
	 * @return
	 */
	public ArrayList ListAll(){

		DataAccess dataAccessObject  = new DataAccess();
		ArrayList bzjgdms = new ArrayList();
		String sql = "select * from SC_bzjgdm order by dm asc ";
		//String sql = "select * from SC_bzjgdm  order by xzqh_id asc ";
		try{
			CachedRowSet crs = dataAccessObject.query(sql);
			while(crs.next()){
				Bzjgdm bzjgdm = SetBzjgdm(crs);
				bzjgdms.add(bzjgdm);
			}
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return bzjgdms;
	}

	/**
	 * 列出一级省市列表信息
	 * @return
	 */
	public List<Bzjgdm> ListFirstAll(){

		DataAccess dataAccessObject  = new DataAccess();
		ArrayList bzjgdms = new ArrayList();
		String sql = "select * from SC_bzjgdm where substring(dm,3,4)='0000' order by dm asc ";
		try{
			CachedRowSet crs = dataAccessObject.query(sql);
			while(crs.next()){
				Bzjgdm bzjgdm = SetBzjgdm(crs);
				bzjgdms.add(bzjgdm);
			}
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return bzjgdms;
	}



	private static Bzjgdm SetBzjgdm(CachedRowSet crs) throws SQLException{
		Bzjgdm bzjgdm = new Bzjgdm();

		bzjgdm.setDm(crs.getString("dm"));
/*		bzjgdm.setFlag(crs.getString("flag"));
		bzjgdm.setJgmc(crs.getString("jgmc"));*/
		bzjgdm.setMc(crs.getString("mc"));
/*		bzjgdm.setSuperdm(crs.getString("superdm"));
		bzjgdm.setXzqhId(crs.getString("xzqh_Id"));
		bzjgdm.setZrxzqhId(crs.getString("zrxzqh_Id"));*/
		return bzjgdm;

	}


    public ArrayList listScCenterAll() {
        DataAccess dataAccessObject  = new DataAccess();
		ArrayList bzjgdms = new ArrayList();
		String sql = "SELECT * FROM sc_center order by dm";
        Bzjgdm bzjgdm = null;
		try{
			CachedRowSet crs = dataAccessObject.query(sql);
			while(crs.next()){
                bzjgdm = new Bzjgdm();
                bzjgdm.setDm(crs.getString("dm"));
                bzjgdm.setMc(crs.getString("mc"));
				bzjgdms.add(bzjgdm);
			}
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return bzjgdms;
    }
}
