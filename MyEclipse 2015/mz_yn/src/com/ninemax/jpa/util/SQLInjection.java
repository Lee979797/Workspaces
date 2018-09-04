/**
 * 
 */
package com.ninemax.jpa.util;

import org.apache.log4j.Logger;

/**
 * @author haojy 2011-8-31  下午04:54:02
 *
 */
public class SQLInjection {
    private static Logger log = Logger.getLogger(SQLInjection.class);
	public static boolean injection(String str)
	{
	   // String injection_str ="'|and|exec|insert|select|delete|count|chr|mid|master|truncate|char|declare|;|--|+|,|<script|<|>";
		String injection_str ="'|;|\"|>|<|--|";
	    String[] inj_stra=injection_str.split("\\|");
	    for (int i=0 ; i < inj_stra.length ; i++ )
	    {
	        if (str.indexOf(inj_stra[i])>=0)
	        {
                log.info("存在危险的关键字============="+inj_stra[i]);
	             return true;
	        }
	    }
	    return false;
	}


}
