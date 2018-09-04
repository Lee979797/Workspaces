package com.ninemax.jpa.util;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 11-2-18
 * Time: ÏÂÎç3:54
 */

import com.ninemax.jdbc.dao.DataAccess;
import sun.jdbc.rowset.CachedRowSet;

import java.sql.SQLException;
import java.util.HashMap;


public class ForbidLoad {
	 public static ForbidLoad instance;

		private HashMap forbidwordsHm = new HashMap();

		public synchronized static ForbidLoad getInstance() {
			//if (instance == null) {
				try {
					instance = new ForbidLoad();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//}
			return instance;
		}

		public ForbidLoad() throws SQLException {
			load();
		}

		public void load() throws SQLException {
			CachedRowSet rs = null;

			String sql = "SELECT FORBID_WORD FROM DB_FORBIDWORD fb";
			DataAccess dataAccessObject = new DataAccess();
			try {
				rs = dataAccessObject.query(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			while (rs.next()) {
				try {
					forbidwordsHm.put(rs.getString("forbid_word").trim(), rs
							.getString("forbid_word").trim());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		public HashMap getForbidwordsHm() {
			return forbidwordsHm;
		}

		public void setForbidwordsHm(HashMap forbidwordsHm) {
			this.forbidwordsHm = forbidwordsHm;
		}
}
