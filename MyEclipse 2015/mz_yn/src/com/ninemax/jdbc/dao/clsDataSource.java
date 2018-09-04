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
			//�����ڴ����ݿ��ȡ������ʧ�ܺ��ظ����ԵĴ�����Default: 30
			cpds.setAcquireRetryAttempts(Integer.valueOf(prop.getProperty("AcquireRetryAttempts")));
			//���������м��ʱ�䣬��λ���롣Default: 1000
			cpds.setAcquireRetryDelay(Integer.valueOf(prop.getProperty("AcquireRetryDelay")));
			//�����ӳ�����ʱ�ͻ��˵���getConnection()��ȴ���ȡ�����ӵ�ʱ�䣬��ʱ���׳�SQLException,����Ϊ0�������ڵȴ�����λ���롣Default: 0
			cpds.setCheckoutTimeout(Integer.valueOf(prop.getProperty("CheckoutTimeout")));		
			//һ��Ϊ���mysql 8Сʱ����
			cpds.setAutomaticTestTable("c3p0tabletest");
			cpds.setTestConnectionOnCheckin(true);
			cpds.setIdleConnectionTestPeriod(18000);
			//<!--������ʱ��,60����δʹ�������ӱ���������Ϊ0������������Default: 0 -->
			cpds.setMaxIdleTime(25000);
			cpds.setTestConnectionOnCheckout(true);

		}
        return cpds;
	}
	
	
}
