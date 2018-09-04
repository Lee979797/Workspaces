package com.ninemax.tygs.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;



public class ContractTimingTask implements ServletContextListener {
	private Timer timer=null;
	private static Logger log = Logger.getLogger(ContractTimingTask.class);
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		timer.cancel();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 3); 
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND,0); 
		Date time=calendar.getTime();
		log.info("Ö´ÐÐÊ±¼ä"+ time);
		timer=new Timer();
		//timer.schedule(new TyGsService(), 0,10*1000*60);
		//timer.schedule(new TyGsService2(), 0,11*1000*60);
		
	}

}
