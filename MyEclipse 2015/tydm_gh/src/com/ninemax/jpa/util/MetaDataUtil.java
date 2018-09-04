package com.ninemax.jpa.util;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**                                                                                                                        n
 *
 */
public class MetaDataUtil {
    private static Map<String, Map<String, Integer>> mapMap = new HashMap<String, Map<String, Integer>>();

    public static Map<String, Integer> getFieldLength(EntityManager em, final String table_name) throws Exception {
        if (mapMap.get(table_name) == null) {
            final Map<String, Integer> map = new HashMap<String, Integer>();
            Session session = ((Session) em.getDelegate());
            session.doWork(new Work() {
                public void execute(Connection connection) throws SQLException {
                    PreparedStatement stmt = connection.prepareStatement("select * from " + table_name + " where 1=2");
                    ResultSetMetaData metaData = stmt.executeQuery().getMetaData();
                    for (int i = 1; i < metaData.getColumnCount(); i++) {
                        map.put(metaData.getColumnName(i).toLowerCase().trim(), metaData.getColumnDisplaySize(i));
                    }
                    stmt.close();
                }
            });
            mapMap.put(table_name, map);
        }

        return mapMap.get(table_name);
    }
}