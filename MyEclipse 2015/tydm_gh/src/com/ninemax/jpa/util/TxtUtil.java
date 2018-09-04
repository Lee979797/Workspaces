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
 * ��ȡTXE����     
 */  
public class  TxtUtil {
    private static Logger log = Logger.getLogger(TxtUtil.class);
	private static TxtUtil tu = new TxtUtil();
	/**
	 *  ȡ�ļ�(opera.txt) - ĳһֵ
	 * @param getName ����
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static  String getFileName(String getName){
		String getValue = tu.getName(getName,"sqlStr.txt", "txt/");
		return getValue;
	}
	/**
	 * �������� �ļ�(opera.txt) - ĳһֵ 
	 * @param setName  ����
	 * @param setValue ��ֵ
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void setFileName(String setName,String setValue){
		 tu.setName(setName, setValue, "sqlStr.txt", "txt/");
	}

	/**
	 *  ÿ��ֻ�̶ܹ�����һ����һֵ
	 * @param setName    ����
	 * @param setValue   ��ֵ 
	 * @param FileName   �ļ���
	 * @param path1      ·��������ʽ�� /abcd.txt/��
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
	 *  ȡ���ļ� - ĳһֵ
	 * @param getName   ����
	 * @param FileName  �ļ���
	 * @param path1           ·�� 
	 * @return    ȡ���ļ�ĳһֵ
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
	 * @param clumFileName Ҫ��ȡ���ļ���
	 * @return ���� �ֶ�������
	 */
	 public static List<String> getClumList(String clumFileName){
    	List<String> clumList = new ArrayList<String>();
    	// �ļ�����·��Ϊ����������·���ĵ�ǰ·��
        String path = System.getProperty("user.dir");
        String FilePath = path+"/"+clumFileName;
        try {    
            String encoding = "GBK"; // �ַ�����(�ɽ�������������� )    
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
               log.info("�Ҳ���ָ�����ļ���"+FilePath);
               }
       } catch (Exception e) {
            log.error("��ȡ�ļ����ݲ�������",e);
           }
       return clumList;
    }
	 // �����ļ����� - ��д
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