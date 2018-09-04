/**
 * 
 */
package com.ninemax.nacao.util;

import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;



/**
 * @author Administrator
 *
 */
public class clsStringTool {


	
    /**
     * 数组转为字符串
     * @param String[] s 数组
     * @param String compart 分隔符
     **/
	public static String ArrayToString(String[] s,String compart){   
		
		int fieldsNumber = s.length;
		String field = "";
    	
    	for(int i = 0;i<fieldsNumber;i++){
    		if((i+1)!=fieldsNumber){
    			field += " "+compart+s[i]+compart+",";
    		}else{
    			field += " "+compart+s[i]+compart;
    		}
    	}
    	return field;
		
	}
	
	//ISO编码转换成GBK编码
    public static String convertGBK(String str) {
        try {
        	if(isEmpty(str)) return "";
            byte[] bytesStr = str.getBytes("ISO-8859-1");
            return new String(bytesStr, "gb2312");
        } catch (Exception ex) {
            return str;
        }
    }

    //GBK编码转换成ISO编码
    public static String convertISO(String str) {
        try {
        	if(isEmpty(str)) return "";
            byte[] bytesStr = str.getBytes("gb2312");
            return new String(bytesStr, "ISO-8859-1");
        } catch (Exception ex) {
            return str;
        }
    }
    
    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {

        boolean flag = false;
        if (str == null || "".equals(str) || "null".equals(str)) {

            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }
    
    /**
     * 判断字符串是否为空
     * @return New String 空值而不是null
     */
    public static String isNewStr(String str) {

        String flag = str;
        if (str == null || str.equals("") || str.equals("null"))
          flag = "";        
        return flag;
    }
    /**
     * YYYY-MM-DD 
     **/
    public static String getNowDate(){
    	
    	Calendar cal  = Calendar.getInstance();
    	int intMonth = cal.get(cal.MONTH)+1;
    	int intDate = cal.get(cal.DATE);
    	String sMonth = String.valueOf(intMonth);
    	String sDate = String.valueOf(intDate);
    	if(intMonth<10){
    		sMonth = "0"+sMonth;
    	}
    	if(intDate<10){
    		sDate = "0"+sDate;
    	}
    	return cal.get(cal.YEAR)+"-"+sMonth+"-"+sDate;
    }
    
    public static String getProperties(String path,String propertiesName){
    	
    	Properties prop=new Properties();
    	String name = "";
        try{
        
        	FileInputStream in=new FileInputStream(path);
            prop.load(in);
            in.close();
            name=prop.getProperty(propertiesName); 
            prop.clear();
            
        }catch(Exception e){   
        	e.printStackTrace();
        }
        return name;
    }
    /**
     * 按照字节截取字符串长度
     * @param s
     * @param length
     * @return
     * @throws Exception
     */
    public static String bSubstring(String s, int length) throws Exception {

		byte[] bytes = s.getBytes("Unicode");
		int n = 0; // 表示当前的字节数
		int i = 2; // 要截取的字节数，从第3个字节开始
		for (; i < bytes.length && n < length; i++) {
			// 奇数位置，如3、5、7等，为UCS2编码中两个字节的第二个字节
			if (i % 2 == 1) {
				n++; // 在UCS2第二个字节时n加1
			} else {
				// 当UCS2编码的第一个字节不等于0时，该UCS2字符为汉字，一个汉字算两个字节
				if (bytes[i] != 0) {
					n++;
				}
			}
		}
		// 如果i为奇数时，处理成偶数
		if (i % 2 == 1)

		{
			// 该UCS2字符是汉字时，去掉这个截一半的汉字
			if (bytes[i - 1] != 0)
				i = i - 1;
			// 该UCS2字符是字母或数字，则保留该字符
			else
				i = i + 1;
		}

		return new String(bytes, 0, i, "Unicode");
	}
    public static String clearHtml(String str) {
        int flag1 = str.indexOf("<");
        int flag2 = str.indexOf(">");
        while (flag1 != -1 || flag2 != -1) {
            str = clearHtmlPrivate(str);
            flag1 = str.indexOf("<");
            flag2 = str.indexOf(">");
        }
        return str;
    }
    
    private static String clearHtmlPrivate(String str) {
        int start = str.indexOf("<");
        int end = str.indexOf(">");
        if (start != -1 || end != -1) {
            str = str.substring(0, start) + str.substring(end + 1);
        }
        return str;
    }
    public static String superClearHtml(String str) {
		str = str.replaceAll("<head>.*</head>|<script>.*?</script>", "").// 头部与脚本去掉
		replaceAll("<.*?>|&.{2,5};", "");// 标签与转义去掉
		return str;
	}
    public static String escape(String src) {
    	   int i;
    	   char j;
    	   StringBuffer tmp = new StringBuffer();
    	   tmp.ensureCapacity(src.length() * 6);
    	   for (i = 0; i < src.length(); i++) {
    	    j = src.charAt(i);
    	    if (Character.isDigit(j) || Character.isLowerCase(j)
    	      || Character.isUpperCase(j))
    	     tmp.append(j);
    	    else if (j < 256) {
    	     tmp.append("%");
    	     if (j < 16)
    	      tmp.append("0");
    	     tmp.append(Integer.toString(j, 16));
    	    } else {
    	     tmp.append("%u");
    	     tmp.append(Integer.toString(j, 16));
    	    }
    	   }
    	   return tmp.toString();
    	}

    	public static String unescape(String src) {
    	   if(src == null)return null;
    	   StringBuffer tmp = new StringBuffer();
    	   tmp.ensureCapacity(src.length());
    	   int lastPos = 0, pos = 0;
    	   char ch;
    	   while (lastPos < src.length()) {
    	    pos = src.indexOf("%", lastPos);
    	    if (pos == lastPos) {
    	     if (src.charAt(pos + 1) == 'u') {
    	      ch = (char) Integer.parseInt(src
    	        .substring(pos + 2, pos + 6), 16);
    	      tmp.append(ch);
    	      lastPos = pos + 6;
    	     } else if (src.charAt(pos + 1) == ' '
    	       || src.charAt(pos + 1) == ';') {
    	      tmp.append(src.substring(pos, pos + 1));
    	      lastPos = pos + 1;
    	     } else {
    	      ch = (char) Integer.parseInt(src
    	        .substring(pos + 1, pos + 3), 16);
    	      tmp.append(ch);
    	      lastPos = pos + 3;
    	     }
    	    } else {
    	     if (pos == -1) {
    	      tmp.append(src.substring(lastPos));
    	      lastPos = src.length();
    	     } else {
    	      tmp.append(src.substring(lastPos, pos));
    	      lastPos = pos;
    	     }
    	    }
    	   }
    	   return tmp.toString();
    	}

    	/**
         * YYYYMMDDHHNNSSMI 
         **/
        public static String getRandomNumber(){
        	
        	Calendar cal  = Calendar.getInstance();
        	int intMonth = cal.get(cal.MONTH)+1;
        	int intDate = cal.get(cal.DATE);
        	int HH = cal.get(Calendar.HOUR);
        	int NN = cal.get(Calendar.MINUTE);
        	int SS = cal.get(Calendar.SECOND);
        	int MI = cal.get(Calendar.MILLISECOND);
        	String sMonth = String.valueOf(intMonth);
        	String sDate = String.valueOf(intDate);
        	if(intMonth<10){
        		sMonth = "0"+sMonth;
        	}
        	if(intDate<10){
        		sDate = "0"+sDate;
        	}
        	return cal.get(cal.YEAR)+sMonth+sDate+HH+NN+SS+MI;
        }
        
        /**
         * 
         * @param currentValue
         * @param defaultValue
         * @param length
         * @return
         */
        public static String getLsh(String currentValue,String defaultValue,int length){
    		
    		int s=currentValue.toString().length();
    		String tmp="";
    		for(int i=0;i<length-s;i++){
    		tmp+=defaultValue;	
    		}
    		
    		System.out.println(tmp+currentValue);
    		
    		return tmp+currentValue;
        }
        
        
}
