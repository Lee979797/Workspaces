package com.ninemax.producttest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;
import com.ninemax.jdbc.dao.DataAccess;
import com.ninemax.jdbc.dao.system.clsUserDAO;

public class CertificateNumberStatisticsDao {
	private List list = new ArrayList();
	private static Logger log = Logger.getLogger(clsUserDAO.class);

	/**
	 * 证书编号统计
	 * 
	 * @return
	 */
	public List TypeStatistics() {
		DataAccess dataAccessObject = new DataAccess();
		CachedRowSet crs = null;
		String strUser_id = "";
		// String sql = "select user_id from sm_usermanage where user_name='" +
		// user_name + "' and user_status='0'";
		StringBuffer sBuffer = new StringBuffer();
		sBuffer
				.append("select t.ssbzjg,t.fpsj,t.zslx,COUNT(t.flag =1),count(t.zblx) from t_zsbhb t where t.ssbzjg is not NULL GROUP BY t.ssbzjg,to_date(t.fpsj,'yyyy-mm-dd hh:mm:ss'),t.zslx");

		try {
			crs = dataAccessObject.query(sBuffer.toString());
			if (crs.next()) {
				strUser_id = crs.getString("user_id");
			}
		} catch (SQLException e) {
			log.error("error", e);
			throw new RuntimeException(e.getMessage(), e);
		}
		return list;

	}
}
