package com.ninemax.jpa.system.dao;

import com.ninemax.jdbc.dao.DataAccess;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

import java.sql.SQLException;
import java.util.HashMap;

public class ForbidLoad {
	private static Logger log = Logger.getLogger(ForbidLoad.class);
	 public static ForbidLoad instance;

		private HashMap forbidwordsHm = new HashMap();

		public synchronized static ForbidLoad getInstance() {
			if (instance == null) {
				try {
					instance = new ForbidLoad();
				} catch (SQLException e) {
					log.error("error", e);
					throw new RuntimeException(e.getMessage(),e);
				}
			}
			return instance;
		}

		public ForbidLoad() throws SQLException {
			load();
		}

		public void load() throws SQLException {
			CachedRowSet rs = null;

			String sql = "select forbid_word from db_forbidword";
			DataAccess dataAccessObject = new DataAccess();
			try {
				rs = dataAccessObject.query(sql);
			} catch (SQLException e1) {
				log.error("error", e1);
				throw new RuntimeException(e1.getMessage(),e1);
			}

			while (rs.next()) {
				try {
					forbidwordsHm.put(rs.getString("forbid_word").trim(), rs
							.getString("forbid_word").trim());
				} catch (SQLException e) {
					log.error("error", e);
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
