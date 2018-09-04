package com.ninemax.jdbc.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.engine.SessionFactoryImplementor;
import sun.jdbc.rowset.CachedRowSet;

import javax.persistence.Persistence;
import java.sql.*;
import java.util.List;

public class DataAccess {
    private static Logger log = Logger.getLogger(DataAccess.class);
    private static final ConnectionProvider provider;
    private Connection conn = null;

    static {
        provider = ((SessionFactoryImplementor) ((Session) Persistence.createEntityManagerFactory("ninemax").createEntityManager().getDelegate()
        ).getSessionFactory()).getConnectionProvider();
    }

    public void connect() throws SQLException {
        conn = provider.getConnection();
    }


    public CachedRowSet query(String sql) throws SQLException {
        try {
            connect();
        } catch (SQLException e) {
            log.error(DataAccess.class, e);
            throw new RuntimeException("jdbc数据库连接异常", e);
        }
        ResultSet rs = null;
        Statement stmt = null;
        CachedRowSet crs = new CachedRowSet();

        try {
            stmt = conn.createStatement();
            stmt.setQueryTimeout(100);
            rs = stmt.executeQuery(sql);
            crs.populate(rs);
        } catch (Exception e) {
            log.error(DataAccess.class, e);
            throw new RuntimeException(e.getMessage(), e);
        } finally {

            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
        return crs;
    }


    /**
     * @param sql
     * @return CachedRowSet
     * @throws SQLException
     * @author haojy
     */
    public CachedRowSet query(String sql, List list) throws SQLException {
        try {
            connect();
        } catch (SQLException e) {
            log.error(DataAccess.class, e);
            throw new RuntimeException("jdbc数据库连接异常", e);
        }
        ResultSet rs = null;
        PreparedStatement ps = null;
        CachedRowSet crs = new CachedRowSet();

        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; list != null && i < list.size(); i++) {
                ps.setObject(i + 1, list.get(i));
            }
            ps.setQueryTimeout(100);
            rs = ps.executeQuery();
            crs.populate(rs);
        } catch (Exception e) {
            log.error(DataAccess.class, e);
            crs = null;
            throw new RuntimeException(e.getMessage(), e);
        } finally {

            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        return crs;
    }

    public Connection getConn() {
        if (conn == null) {
            try {
                connect();
            } catch (SQLException e) {
                log.error(DataAccess.class, e);
                throw new RuntimeException("jdbc数据库连接异常", e);
            }
        }
        return this.conn;
    }

    /*
     * insert ,delete ,update
     * */
    public int execute(String s) throws SQLException {
        int result = 0;
        try {
            connect();
        } catch (SQLException e) {
            log.error(DataAccess.class, e);
            throw new RuntimeException("jdbc数据库连接异常", e);
        }
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.setQueryTimeout(100);
            result = stmt.executeUpdate(s);

        } catch (Exception e) {
            log.error(DataAccess.class, e);
            throw new RuntimeException(e.getMessage(), e);
        } finally {


            if (stmt != null) stmt.close();
            if (conn != null) conn.close();

        }
        return result;
    }

    /**
     * @param sql
     * @return CachedRowSet
     * @throws SQLException
     * @author haojy
     * SQL select
     */
    public CachedRowSet executeQuery(String sql, List parameterslist) throws SQLException {
        CachedRowSet crs = new CachedRowSet();
        try {
            connect();
        } catch (SQLException e) {
            throw new RuntimeException("jdbc数据库连接异常", e);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; parameterslist != null && i < parameterslist.size(); i++) {
                ps.setObject(i + 1, parameterslist.get(i));
            }
            rs = ps.executeQuery();
            crs.populate(rs);
        } catch (SQLException e) {
            log.error(DataAccess.class, e);
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        return crs;
    }

    /*
     * hf add. To solve the clob Problem ,use prepareStatement method to avoid special symbol like:', etc ...
     */
    public int PreparedExecute(String s, String str[]) throws SQLException {
        int result = 0;
        try {
            connect();
        } catch (SQLException e) {
            throw new RuntimeException("jdbc数据库连接异常", e);
        }
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(s);
            for (int i = 0; i < str.length; i++) {
                stmt.setString(i + 1, str[i]);
            }
            stmt.setQueryTimeout(100);
            result = stmt.executeUpdate();

        } catch (Exception e) {
            log.error(DataAccess.class, e);
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();

        }
        return result;
    }

    public int executeMessage(String s) throws SQLException {
        int result = 0;
        connect();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.setQueryTimeout(100);
            stmt.execute(s);

        } catch (Exception e) {
            result = 1;
            log.error(DataAccess.class, e);
            return result;
        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();

        }
        return result;
    }

    // 获取插入数据的主键值
    public int executeGetId(String sqlStr) throws SQLException {
        int id = 0;
        ResultSet rs;
        connect();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.setQueryTimeout(100);
            stmt.executeUpdate(sqlStr, stmt.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            log.error(DataAccess.class, e);
            return id;
        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
        return id;
    }
}
