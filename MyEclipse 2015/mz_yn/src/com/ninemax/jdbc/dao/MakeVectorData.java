/**
 * 
 */
package com.ninemax.jdbc.dao;

import com.ninemax.jpa.util.clsStringTool;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Hashtable;
import java.util.Vector;

/**
 * @author Liuzy
 * 
 */
public class MakeVectorData {

	public synchronized static Vector dbQuery(String sql) {
		DataAccess objData = new DataAccess();
		int colNum = 0;
		ResultSet ret = null;
		Vector vec = new Vector();
		ResultSetMetaData rsm = null;
		Hashtable<Object, Object> ht = new Hashtable<Object,Object>();
		try {

			ret = objData.query(sql);

			rsm = ret.getMetaData();
			colNum = rsm.getColumnCount();
			while (ret.next()) {
				for (int i = 0; i < colNum; i++) {
					Object objValue = clsStringTool.convertNull(""+ret.getObject(i + 1));
					Object objName = rsm.getColumnName(i + 1);
					ht.put(objName, objValue);
				}
				vec.add(ht);
			}
			
			ret.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return vec;
	}

}
