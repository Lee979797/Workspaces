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
     * ����תΪ�ַ���
     * @param String[] s ����
     * @param String compart �ָ���
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
	
	//ISO����ת����GBK����
    public static String convertGBK(String str) {
        try {
        	if(isEmpty(str)) return "";
            byte[] bytesStr = str.getBytes("ISO-8859-1");
            return new String(bytesStr, "gb2312");
        } catch (Exception ex) {
            return str;
        }
    }

    //GBK����ת����ISO����
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
     * �ж��ַ����Ƿ�Ϊ��
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
     * �ж��ַ����Ƿ�Ϊ��
     * @return New String ��ֵ������null
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
     * �����ֽڽ�ȡ�ַ�������
     * @param s
     * @param length
     * @return
     * @throws Exception
     */
    public static String bSubstring(String s, int length) throws Exception {

		byte[] bytes = s.getBytes("Unicode");
		int n = 0; // ��ʾ��ǰ���ֽ���
		int i = 2; // Ҫ��ȡ���ֽ������ӵ�3���ֽڿ�ʼ
		for (; i < bytes.length && n < length; i++) {
			// ����λ�ã���3��5��7�ȣ�ΪUCS2�����������ֽڵĵڶ����ֽ�
			if (i % 2 == 1) {
				n++; // ��UCS2�ڶ����ֽ�ʱn��1
			} else {
				// ��UCS2����ĵ�һ���ֽڲ�����0ʱ����UCS2�ַ�Ϊ���֣�һ�������������ֽ�
				if (bytes[i] != 0) {
					n++;
				}
			}
		}
		// ���iΪ����ʱ�������ż��
		if (i % 2 == 1)

		{
			// ��UCS2�ַ��Ǻ���ʱ��ȥ�������һ��ĺ���
			if (bytes[i - 1] != 0)
				i = i - 1;
			// ��UCS2�ַ�����ĸ�����֣��������ַ�
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
		str = str.replaceAll("<head>.*</head>|<script>.*?</script>", "").// ͷ����ű�ȥ��
		replaceAll("<.*?>|&.{2,5};", "");// ��ǩ��ת��ȥ��
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
