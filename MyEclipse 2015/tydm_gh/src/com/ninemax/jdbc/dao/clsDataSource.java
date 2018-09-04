package com.ninemax.jdbc.dao;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;
public class clsDataSource {
   private static ComboPooledDataSource  cpds = null;
	public static DataSource getDataSource() throws Exception {

		if(cpds==null)
		{
			InputStream  insteam=  clsDataSource.class.getResourceAsStream("/config.properties");
			Properties prop =  new Properties();
			prop.load(insteam);
			cpds= new ComboPooledDataSource();
			cpds.setDriverClass(prop.getProperty("driverClass"));
			cpds.setJdbcUrl(prop.getProperty("jdbcUrl"));
			cpds.setUser(prop.getProperty("user"));
			cpds.setPassword(prop.getProperty("password"));
			cpds.setMaxPoolSize(Integer.valueOf(prop.getProperty("MaxPoolSize")));
			cpds.setMinPoolSize(Integer.valueOf(prop.getProperty("MinPoolSize")));
			cpds.setInitialPoolSize(Integer.valueOf(prop.getProperty("InitialPoolSize")));
			cpds.setAcquireIncrement(Integer.valueOf(prop.getProperty("AcquireIncrement")));
			//定义在从数据库获取新连接失败后重复尝试的次数。Default: 30
			cpds.setAcquireRetryAttempts(Integer.valueOf(prop.getProperty("AcquireRetryAttempts")));
			//两次连接中间隔时间，单位毫秒。Default: 1000
			cpds.setAcquireRetryDelay(Integer.valueOf(prop.getProperty("AcquireRetryDelay")));
			//当连接池用完时客户端调用getConnection()后等待获取新连接的时间，超时后将抛出SQLException,如设为0则无限期等待。单位毫秒。Default: 0
			cpds.setCheckoutTimeout(Integer.valueOf(prop.getProperty("CheckoutTimeout")));		
			//一下为解决mysql 8小时问题
			cpds.setAutomaticTestTable("c3p0tabletest");
			cpds.setTestConnectionOnCheckin(true);
			cpds.setIdleConnectionTestPeriod(18000);
			//<!--最大空闲时间,60秒内未使用则连接被丢弃。若为0则永不丢弃。Default: 0 -->
			cpds.setMaxIdleTime(25000);
			cpds.setTestConnectionOnCheckout(true);

		}
        return cpds;
	}
	
	
}
