package com.ninemax.jpa.code.service;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import com.ninemax.jpa.util.Arithmetic;
import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolConfiguration;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Environment;
import org.hibernate.connection.ConnectionProvider;

/**
 * <p>A connection provider that uses the Tomcat JDBC connection pool outside Tomcat container</p>
 * <p/>
 * <p>To use this connection provider set:<br>
 * <code>hibernate.connection.provider_class&nbsp;org.hibernate.connection.TomcatJDBCConnectionProvider</code></p>
 * <p/>
 * <pre>Supported Hibernate properties:
 *   hibernate.connection.driver_class
 *   hibernate.connection.url
 *   hibernate.connection.username
 *   hibernate.connection.password
 *   hibernate.connection.isolation
 *   hibernate.connection.autocommit
 *   hibernate.connection.pool_size
 *   hibernate.connection (JDBC driver properties)</pre>
 * <br>
 * <p/>
 * N.B.: All Tomcat JDBC connection pool properties are also supported by using the hibernate.tomcatJdbcPool prefix.
 *
 * @author Guenther Demetz
 */
public class TomcatJDBCConnectionProvider implements ConnectionProvider {
    private static Logger log = Logger.getLogger(TomcatJDBCConnectionProvider.class);

    private static final String PREFIX = "hibernate.tomcat.jdbc.pool.";
    private DataSource ds;
    PoolProperties tomcatJdbcPoolProperties;


    private Object convertIntoTypedValue(Class clazz, String value) {
        if (clazz.isAssignableFrom(boolean.class)) {
            return Boolean.parseBoolean(value);
        } else if (clazz.isAssignableFrom(int.class)) {
            return Integer.parseInt(value);
        } else if (clazz.isAssignableFrom(long.class)) {
            return Long.parseLong(value);
        } else if (clazz.equals(String.class)) {
            return value;
        } else throw new RuntimeException("Unsupported Parameter type " + clazz);

    }

    @Override
    public void configure(Properties properties) throws HibernateException {
        try {
            log.debug("Configure TomcatJDBCConnectionProvider");
            // Tomcat JDBC connection pool properties used to create theDataSource
            tomcatJdbcPoolProperties = new PoolProperties();
            // DriverClass & url
            String jdbcDriverClass = (String) properties.get(Environment.DRIVER);
            String jdbcUrl = (String) properties.get(Environment.URL);
            tomcatJdbcPoolProperties.setDriverClassName(jdbcDriverClass);
            tomcatJdbcPoolProperties.setUrl(jdbcUrl);
            tomcatJdbcPoolProperties.setFairQueue(true);
            tomcatJdbcPoolProperties.setTestOnBorrow(true);
            tomcatJdbcPoolProperties.setRemoveAbandoned(true);
            tomcatJdbcPoolProperties.setRemoveAbandonedTimeout(54);
            tomcatJdbcPoolProperties.setValidationInterval(3600000);
            tomcatJdbcPoolProperties.setTimeBetweenEvictionRunsMillis(3600000);
            tomcatJdbcPoolProperties.setMinEvictableIdleTimeMillis(3600000);
            tomcatJdbcPoolProperties.setValidationQuery("select 1");
            tomcatJdbcPoolProperties.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");

            //tomcatJdbcPoolProperties.setJmxEnabled(true); thats the default

            // Username / password
            String username = (String) properties.get(Environment.USER);
            String password = Arithmetic.des(properties.getProperty(Environment.PASS));
            tomcatJdbcPoolProperties.setUsername(username);
            tomcatJdbcPoolProperties.setPassword(password);

            String isolationLevel = (String) properties.get(Environment.ISOLATION);
            if ((isolationLevel != null) && (isolationLevel.trim().length() > 0)) {
                tomcatJdbcPoolProperties.setDefaultTransactionIsolation(Integer.parseInt(isolationLevel));
            }

//            // Turn off autocommit (unless autocommit property is set)
//          Unfortunately since hibernate3 autocommit defaults to true but usually you don't need if it, when working outside a EJB-container
//            String autocommit = properties.getProperty(Environment.AUTOCOMMIT);
//            if ((autocommit != null) && (autocommit.trim().length() > 0)) {
//                tomcatJdbcPoolProperties.setDefaultAutoCommit(Boolean.parseBoolean(autocommit));
//            } else {
//                tomcatJdbcPoolProperties.setDefaultAutoCommit(false);
//            }

            // Pool size
            String poolSize = (String) properties.get(Environment.POOL_SIZE);
            if ((poolSize != null) && (poolSize.trim().length() > 0)) {
                tomcatJdbcPoolProperties.setMaxActive(Integer.parseInt(poolSize));
            }

            // Copy all "driver" properties into "connectionProperties"
            // ConnectionProviderInitiator.
            if (properties.size() > 0) {
                StringBuffer connectionProperties = new StringBuffer();
                for (Iterator iter = properties.entrySet().iterator(); iter.hasNext(); ) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    String key = (String) entry.getKey();
                    String value = (String) entry.getValue();
                    connectionProperties.append(key).append('=').append(value);
                    if (iter.hasNext()) {
                        connectionProperties.append(';');
                    }
                }
                System.out.println("connectionProperties = " + connectionProperties);
                tomcatJdbcPoolProperties.setConnectionProperties(connectionProperties.toString());
            }


            // Copy all Tomcat JDBCPool properties removing the prefix
            for (Iterator iter = properties.entrySet().iterator(); iter.hasNext(); ) {
                Map.Entry entry = (Map.Entry) iter.next();
                String key = (String) entry.getKey();
                if (key.startsWith(PREFIX)) {
                    String property = key.substring(PREFIX.length());
                    String value = (String) entry.getValue();
                    Method[] methods = PoolConfiguration.class.getMethods();
                    int i;
                    for (i = 0; i < methods.length; i++) {
                        if (methods[i].getName().equalsIgnoreCase("set" + property)) {
                            Method m = methods[i];
                            Object parameter = convertIntoTypedValue(m.getParameterTypes()[0], value);
                            m.invoke(tomcatJdbcPoolProperties, new Object[]{parameter});
                            break;
                        }
                    }
                    if (i >= methods.length) {
                        log.error("Unable to parse property " + key + " with value: " + value);
                        throw new RuntimeException("Unable to parse property " + key + " with value: " + value);
                    }
                }
            }


            // Let the factory create the pool
            ds = new DataSource();
            ds.setPoolProperties(tomcatJdbcPoolProperties);
            ds.createPool();
            if (ds.getPoolProperties().isJmxEnabled()) {
                MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
                ObjectName objectname = null;
                objectname = new ObjectName("ConnectionPool:name=" + tomcatJdbcPoolProperties.getName());
                if (!mBeanServer.isRegistered(objectname)) {
                    mBeanServer.registerMBean(ds.getPool().getJmxPool(), objectname);
                }
            }

            // Log pool statistics before continuing.
            logStatistics();
        } catch (Exception e) {
            log.debug("Configure TomcatJDBCConnectionProvider error");
            log.error(TomcatJDBCConnectionProvider.class, e);
            if (ds != null) {
                ds.close();
                ds = null;
            }
        }
        log.debug("Configure TomcatJDBCConnectionProvider complete");
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Future<Connection> future = ds.getConnectionAsync();
            while (!future.isDone()) {
                System.out.println("Connection is not yet available. Do some background work");
                try {
                    Thread.sleep(100); //simulate work
                } catch (InterruptedException x) {
                    Thread.currentThread().interrupt();
                }
            }
            conn = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            logStatistics();
        }
        return conn;
    }

    public void closeConnection(Connection conn) throws SQLException {
        try {
            conn.close();
        } finally {
            logStatistics();
        }
    }

    public void close() throws HibernateException {
        log.debug("Close TomcatJDBCConnectionProvider");
        logStatistics();
        try {
            if (ds != null) {
                ds.close();
                ds = null;
            } else {
                log.warn("Cannot close TomcatJDBCConnectionProvider, pool (not initialized)");
            }
        } catch (Exception e) {
            throw new HibernateException("Could not close DBCP pool", e);
        }
        log.debug("Close TomcatJDBCConnectionProvider complete");
    }

    protected void logStatistics() {
        if (log.isDebugEnabled()) {
            log.info("active: " + ds.getNumActive() + " (max: " + ds.getMaxActive() + ")   "
                    + "idle: " + ds.getNumIdle() + "(max: " + ds.getMaxIdle() + ")");
        }
    }

    public boolean supportsAggressiveRelease() {
        return false;
    }

}