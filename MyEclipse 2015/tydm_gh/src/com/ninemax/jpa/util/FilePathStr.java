package com.ninemax.jpa.util;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class FilePathStr {

	
	public static void createFilePath(HttpServletRequest request,String filepath){
		
		filepath = filepath.toUpperCase();
		String path=request.getSession().getServletContext().getRealPath(filepath);	//��Ҫ������Ŀ¼·��
		File d=new File(path);//��������   Ŀ¼��File���󣬲��õ�����һ������
		if(!d.exists()){//��� Ŀ¼�Ƿ����
			d.mkdirs();
		
		}		
	}

    public static  void createFilePath(String filepath)
    {
        File d=new File(filepath);//��������   Ŀ¼��File���󣬲��õ�����һ������
		if(!d.exists()){//��� Ŀ¼�Ƿ����
			d.mkdirs();
			
		}
    }

}
