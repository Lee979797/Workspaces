package com.lhq.prj.bms.core;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Date;
import java.util.Calendar;  
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.security.NoSuchAlgorithmException;
import sun.net.ftp.FtpClient;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;



/**
 * MyUtils.java Create on 2008-9-17 下午10:45:20
 * 
 * 工具类
 * 
 * @author 
 * @version 1.0
 */
public class MyUtils {

	public static void main(String[] s) {
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split("a,b-c d,e f-g", " ,-"));
		System.out.println(conditions);// output[a, b, c, d, e, f, g]
	}

	/**
	 * 删除文件
	 * 
	 * @param filePathAndName
	 *          String 文件路径及名称 如c:/fqf.txt
	 * @param fileContent
	 *          String
	 * @return boolean
	 */
	public static boolean delFile(String filePathAndName) {
		File myDelFile = new java.io.File(filePathAndName);
		if (!myDelFile.exists()) {
			return true;
		}
		return myDelFile.delete();
	}
	
	/**
	 * 判断字符串是否包含特定字符
	 * 
	 * @param fileName
	 * @param dir
	 * @return
	 */
	public static boolean isContainsAny(String str, String searchChars){
		//if(str.length()!=str.replace(searchChars,"").length()) 
		if(str.indexOf(searchChars)>0)
		{    
			return true;  
		}  
		return false;
	}

	/*替换字符串中的字符*/
	public static String str_replace(String strSource, String strFrom, String strTo) {    
	     if (strSource == null) {   
	       return null;    
	     }  
	     int i = 0;
	     if ((i = strSource.indexOf(strFrom, i)) >= 0) {
	       char[] cSrc = strSource.toCharArray();
	       char[] cTo = strTo.toCharArray();
	       int len = strFrom.length();  
	       StringBuffer buf = new StringBuffer(cSrc.length);  
	       buf.append(cSrc, 0, i).append(cTo);
	       i += len;    
	       int j = i;       
	       while ((i = strSource.indexOf(strFrom, i)) > 0) {  
	         buf.append(cSrc, j, i - j).append(cTo);   
	         i += len;  
	         j = i;        
	       }        
	       buf.append(cSrc, j, cSrc.length - j); 
	       return buf.toString(); 
	     } 
	     return strSource;
	   }
	
	/**
	 * 上传文件
	 * 
	 * @param uploadFileName
	 *          被上传的文件名称
	 * @param savePath
	 *          文件的保存路径
	 * @param uploadFile
	 *          被上传的文件
	 * @return newFileName
	 */
	public static String upload(String uploadFileName, String savePath, File uploadFile) {
		String newFileName = getRandomName(uploadFileName, savePath);
		try {
			FileOutputStream fos = new FileOutputStream(savePath + newFileName);
			FileInputStream fis = new FileInputStream(uploadFile);
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newFileName;
	}

	/**
	 * 根据路径创建一系列的目录
	 * 
	 * @param path
	 */
	public static void mkDirectory(String path) {
		File file;
		try {
			file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			file = null;
		}
	}

	/**
	 * 将对象数组的每一个元素分别添加到指定集合中,调用Apache commons collections 中的方法
	 * 
	 * @param collection
	 *          目标集合对象
	 * @param arr
	 *          对象数组
	 */
	public static void addToCollection(Collection collection, Object[] arr) {
		if (null != collection && null != arr) {
			CollectionUtils.addAll(collection, arr);
		}
	}

	/**
	 * 将字符串已多个分隔符拆分为数组,调用Apache commons lang 中的方法
	 * 
	 * <pre>
	 *    Example:
	 *     String[] arr = StringUtils.split(&quot;a b,c d,e-f&quot;, &quot; ,-&quot;);
	 *     System.out.println(arr.length);//输出6
	 * </pre>
	 * 
	 * @param str
	 *          目标字符串
	 * @param separatorChars
	 *          分隔符字符串
	 * @return 字符串数组
	 */
	public static String[] split(String str, String separatorChars) {
		return StringUtils.split(str, separatorChars);
	}

	/**
	 * 调用指定字段的setter方法
	 * 
	 * <pre>
	 *    Example:
	 *    User user = new User();
	 *    MyUtils.invokeSetMethod(&quot;userName&quot;, user, new Object[] {&quot;张三&quot;});
	 * </pre>
	 * 
	 * @param fieldName
	 *          字段(属性)名称
	 * @param invokeObj
	 *          被调用方法的对象
	 * @param args
	 *          被调用方法的参数数组
	 * @return 成功与否
	 */
	public static boolean invokeSetMethod(String fieldName, Object invokeObj, Object[] args) {
		boolean flag = false;
		Field[] fields = invokeObj.getClass().getDeclaredFields(); // 获得对象实体类中所有定义的字段
		Method[] methods = invokeObj.getClass().getDeclaredMethods(); // 获得对象实体类中所有定义的方法
		for (Field f : fields) {
			String fname = f.getName();
			if (fname.equals(fieldName)) {// 找到要更新的字段名
				String mname = "set" + (fname.substring(0, 1).toUpperCase() + fname.substring(1));// 组建setter方法
				for (Method m : methods) {
					String name = m.getName();
					if (mname.equals(name)) {
						// 处理Integer参数
						if (f.getType().getSimpleName().equalsIgnoreCase("integer") && args.length > 0) {
							args[0] = Integer.valueOf(args[0].toString());
						}
						// 处理Boolean参数
						if (f.getType().getSimpleName().equalsIgnoreCase("boolean") && args.length > 0) {
							args[0] = Boolean.valueOf(args[0].toString());
						}
						try {
							m.invoke(invokeObj, args);
							flag = true;
						} catch (IllegalArgumentException e) {
							flag = false;
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							flag = false;
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							flag = false;
							e.printStackTrace();
						}
					}
				}
			}
		}
		return flag;
	}

	/**
	 * 判断文件是否存在
	 * 
	 * @param fileName
	 * @param dir
	 * @return
	 */
	public static boolean isFileExist(String fileName, String dir) {
		File files = new File(dir + fileName);
		return (files.exists()) ? true : false;
	}

	/**
	 * 获得随机文件名,保证在同一个文件夹下不同名
	 * 
	 * @param fileName
	 * @param dir
	 * @return
	 */
	public static String getRandomName(String fileName, String dir) {
		String[] split = fileName.split("\\.");// 将文件名已.的形式拆分
		String extendFile = "." + split[split.length - 1].toLowerCase(); // 获文件的有效后缀

		Random random = new Random();
		int add = random.nextInt(1000000); // 产生随机数10000以内
		String ret = add + extendFile;
		while (isFileExist(ret, dir)) {
			add = random.nextInt(1000000);
			ret = fileName + add + extendFile;
		}
		return ret;
	}

	/**
	 * 创建缩略图
	 * 
	 * @param file
	 *          上传的文件流
	 * @param height
	 *          最小的尺寸
	 * @throws IOException
	 */
	public static void createMiniPic(File file, float width, float height) throws IOException {
		Image src = javax.imageio.ImageIO.read(file); // 构造Image对象
		int old_w = src.getWidth(null); // 得到源图宽
		int old_h = src.getHeight(null);
		int new_w = 0;
		int new_h = 0; // 得到源图长
		float tempdouble;
		if (old_w >= old_h) {
			tempdouble = old_w / width;
		} else {
			tempdouble = old_h / height;
		}

		if (old_w >= width || old_h >= height) { // 如果文件小于锁略图的尺寸则复制即可
			new_w = Math.round(old_w / tempdouble);
			new_h = Math.round(old_h / tempdouble);// 计算新图长宽
			while (new_w > width && new_h > height) {
				if (new_w > width) {
					tempdouble = new_w / width;
					new_w = Math.round(new_w / tempdouble);
					new_h = Math.round(new_h / tempdouble);
				}
				if (new_h > height) {
					tempdouble = new_h / height;
					new_w = Math.round(new_w / tempdouble);
					new_h = Math.round(new_h / tempdouble);
				}
			}
			BufferedImage tag = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
			tag.getGraphics().drawImage(src, 0, 0, new_w, new_h, null); // 绘制缩小后的图
			FileOutputStream newimage = new FileOutputStream(file); // 输出到文件流
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
			JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(tag);
			param.setQuality((float) (100 / 100.0), true);// 设置图片质量,100最大,默认70
			encoder.encode(tag, param);
			encoder.encode(tag); // 将JPEG编码
			newimage.close();
		}
	}

	/**
	 * 判断文件类型是否是合法的,就是判断allowTypes中是否包含contentType
	 * 
	 * @param contentType
	 *          文件类型
	 * @param allowTypes
	 *          文件类型列表
	 * @return 是否合法
	 */
	public static boolean isValid(String contentType, String[] allowTypes) {
		if (null == contentType || "".equals(contentType)) {
			return false;
		}
		for (String type : allowTypes) {
			if (contentType.equals(type)) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	* 日期转换成字符串
	* @param date 
	* @return str
	*/
	public static String DateToStr(Date date) {
	  
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String str = format.format(date);
	   return str;
	} 

	/**
	* 字符串转换成日期
	* @param str
	* @return date
	*/
	public static Date StrToDate(String str) {
	  
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
	   Date date = null;
	   try {
		   date = format.parse(str.toString());
	   }
	   catch(ParseException e){
	    e.printStackTrace();
	   }
	   return date;
	}

	/**
	   * 将java.util.Date 格式转换为字符串格式'yyyy-MM-dd HH:mm:ss'(24小时制)<br>
	   * 如Sat May 11 17:24:21 CST 2002 to '2002-05-11 17:24:21'<br>
	   * @param time Date 日期<br>
	   * @return String   字符串<br>
	   */
	  

	public static String dateToString(Date time){
	    SimpleDateFormat formatter;
	    formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
	    String ctime = formatter.format(time);

	    return ctime;
	}


	/**
	   * 将java.util.Date 格式转换为字符串格式'yyyy-MM-dd HH:mm:ss a'(12小时制)<br>
	   * 如Sat May 11 17:23:22 CST 2002 to '2002-05-11 05:23:22 下午'<br>
	   * @param time Date 日期<br>
	   * @param x int 任意整数如：1<br>
	   * @return String 字符串<br>
	   */
	public static String dateToString(Date time,int x){
	    SimpleDateFormat formatter;
	    formatter = new SimpleDateFormat ("yyyy-MM-dd KK:mm:ss a");
	    String ctime = formatter.format(time);

	    return ctime;
	}


	/**
	   *取系统当前时间:返回只值为如下形式
	   *2002-10-30 20:24:39
	   * @return String
	   */
	public static String Now(){
	    return dateToString(new Date());
	}

	/**
	   *取系统当前时间:返回只值为如下形式
	   *2002-10-30 08:28:56 下午
	   *@param hour 为任意整数
	   *@return String
	   */
	public static String Now(int hour){
	    return dateToString(new Date(),hour);
	}


	/**
	   *取系统当前时间:返回值为如下形式
	   *2002-10-30
	   *@return String
	   */
	public static String getYYYY_MM_DD(){
	    return dateToString(new Date()).substring(0,10);

	}
	
	public static int daysBetween(Date smdate,Date bdate) throws ParseException     
    {     
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");   
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();        
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();   
        long between_days=(time2-time1)/(1000*3600*24);

       return Integer.parseInt(String.valueOf(between_days));  
    }
	
	 
	/**
	 * 根据属性名获取属性值
	 * */
	public static Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			//log.error(e.getMessage(),e);
			return null;
		}
	}
	     
	/**
	* 获取属性名数组
	* */
	private String[] getFiledName(Object o){
		Field[] fields=o.getClass().getDeclaredFields();
	    String[] fieldNames=new String[fields.length];
	    for(int i=0;i<fields.length;i++){
	        System.out.println(fields[i].getType());
	        fieldNames[i]=fields[i].getName();
	    }
	    return fieldNames;
	}
	     
	/**
	* 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list
	* */
	private List getFiledsInfo(Object o){
	    Field[] fields=o.getClass().getDeclaredFields();
        String[] fieldNames=new String[fields.length];
        List list = new ArrayList();
        Map infoMap=null;
	    for(int i=0;i<fields.length;i++){
	        infoMap = new HashMap();
	        infoMap.put("type", fields[i].getType().toString());
	        infoMap.put("name", fields[i].getName());
	        infoMap.put("value", getFieldValueByName(fields[i].getName(), o));
	        list.add(infoMap);
	    }
	    return list;
	}
	     
	/**
	* 获取对象的所有属性值，返回一个对象数组
	* */
	public Object[] getFiledValues(Object o){
		String[] fieldNames=this.getFiledName(o);
	    Object[] value=new Object[fieldNames.length];
	    for(int i=0;i<fieldNames.length;i++){
	        value[i]=this.getFieldValueByName(fieldNames[i], o);
	    }
	    return value;
	}
	
	//本地锁定的加密，对应java的MD5S.JAVA
	public static String  md5s(String str) throws NoSuchAlgorithmException {
		String strMd5=null;
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		byte[] encodedPassword = md.digest();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < encodedPassword.length; i++) {
			if ((encodedPassword[i] & 0xff) < 0x10) {
				sb.append("0");
			}
			sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
		}
		strMd5=sb.toString();
		return strMd5;
	}


	
	private static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";    
	/** 
    * 获取任意位的随机字符串(0-9 a-z A-Z) 
    * @param size 位数 
    * @return 
    */  
   public static final String getRandomNum(int size){  
	   StringBuffer sb = new StringBuffer();    
	   Random random = new Random();  
	   for (int i = 0; i < size; i++) {    
		   sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));    
	   }  
	   return sb.toString();  
   }  

   /** 
    * md5加密(ITS) 
    * @param str
    * @param charSet 
    * @return 
    */
	public synchronized static final String getMD5Str(String str,String charSet) { //md5加密   
		MessageDigest messageDigest = null;    
	    try {    
	        messageDigest = MessageDigest.getInstance("MD5");    
	        messageDigest.reset();   
	        if(charSet==null){  
	            messageDigest.update(str.getBytes());  
	        }else{  
	            messageDigest.update(str.getBytes(charSet));    
	        }             
	    } catch (NoSuchAlgorithmException e) {    
	        //log.error("md5 error:"+e.getMessage(),e);  
	    } catch (UnsupportedEncodingException e) {    
	        //log.error("md5 error:"+e.getMessage(),e);  
	    }    
	      
	    byte[] byteArray = messageDigest.digest();    
	    StringBuffer md5StrBuff = new StringBuffer();    
	    for (int i = 0; i < byteArray.length; i++) {                
	        if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)    
	            md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));    
	        else    
	            md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));    
	    }    
	    return md5StrBuff.toString();    
	}  

}
