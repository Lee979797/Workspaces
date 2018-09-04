package com.ninemax.jpa.util;    
   
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;    
import java.io.FileInputStream;    
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;    
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
  
/**   
 * 读取TXE数据     
 */  
public class  TxtUtil {
    private static Logger log = Logger.getLogger(TxtUtil.class);
	private static TxtUtil tu = new TxtUtil();
	/**
	 *  取文件(opera.txt) - 某一值
	 * @param getName 键名
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static  String getFileName(String getName){
		String getValue = tu.getName(getName,"sqlStr.txt", "txt/");
		return getValue;
	}
	/**
	 * 重新设置 文件(opera.txt) - 某一值 
	 * @param setName  键名
	 * @param setValue 键值
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void setFileName(String setName,String setValue){
		 tu.setName(setName, setValue, "sqlStr.txt", "txt/");
	}

	/**
	 *  每次只能固定保存一个单一值
	 * @param setName    键名
	 * @param setValue   键值 
	 * @param FileName   文件名
	 * @param path1      路径名：格式（ /abcd.txt/）
	 */	 
	public  void setName(String setName,String setValue,String FileName,String path1){
		 String classPath = getClass().getResource("").toString();
		 classPath = classPath.replaceAll("WEB-INF", ",");
		 classPath = classPath.replaceAll("file:/", "");
		 String[] path = classPath.split("[,]");
	      String FilePath = path[0]+path1+FileName;
	     Properties pt=new Properties();
		 try {
			pt.load(new FileInputStream(FilePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.error(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
		 pt.setProperty(setName,setValue);
		 try {
			pt.store(new FileOutputStream(FilePath),"PROGREAM RUN TIMES");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.error(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e);
		} 
	}
	/**
	 *  取出文件 - 某一值
	 * @param getName   键名
	 * @param FileName  文件名
	 * @param path1           路径 
	 * @return    取得文件某一值
	 */
	public  String getName(String getName,String FileName,String path1){
		String classPath = getClass().getResource("").toString();
		classPath = classPath.replaceAll("WEB-INF", ",");
		classPath = classPath.replaceAll("file:/", "");
		String[] path = classPath.split("[,]");
	     String FilePath = path[0]+path1+FileName;
	     Properties pt=new Properties();
		 try {
			pt.load(new FileInputStream(FilePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.error(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
		 String getValue= pt.getProperty(getName);
		return getValue;
	}
	/**
	 * 
	 * @param clumFileName 要读取的文件名
	 * @return 返回 字段数据列
	 */
	 public static List<String> getClumList(String clumFileName){
    	List<String> clumList = new ArrayList<String>();
    	// 文件所在路径为本工程所在路径的当前路径
        String path = System.getProperty("user.dir");
        String FilePath = path+"/"+clumFileName;
        try {    
            String encoding = "GBK"; // 字符编码(可解决中文乱码问题 )    
            File file = new File(FilePath);    
           if (file.isFile() && file.exists()) {    
                InputStreamReader read = new InputStreamReader(    
                        new FileInputStream(file), encoding);    
                BufferedReader bufferedReader = new BufferedReader(read);    
               String lineTXT = null;    
                while ((lineTXT = bufferedReader.readLine()) != null) {
                	clumList.add(lineTXT.toString().trim());  
                }    
                read.close();    
            }else{
               log.info("找不到指定的文件！"+FilePath);
               }
       } catch (Exception e) {
            log.error("读取文件内容操作出错",e);
           }
       return clumList;
    }
	 // 设置文件属性 - 可写
    public void setWrite(){
		 String classPath = getClass().getResource("").toString();
		 classPath = classPath.replaceAll("WEB-INF", ",");
		 classPath = classPath.replaceAll("file:/", "");
		 String[] path = classPath.split("[,]");
	     String FilePath = path[0]+"txt/"+"sqlStr.txt";
	     try {
			Runtime.getRuntime().exec("attrib " + FilePath + " -R");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
    }
}