package com.ninemax.jpa.util;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class FilePathStr {

	
	public static void createFilePath(HttpServletRequest request,String filepath){
		
		filepath = filepath.toUpperCase();
		String path=request.getSession().getServletContext().getRealPath(filepath);	//将要建立的目录路径
		File d=new File(path);//建立代表   目录的File对象，并得到它的一个引用
		if(!d.exists()){//检查 目录是否存在
			d.mkdirs();
		
		}		
	}

    public static  void createFilePath(String filepath)
    {
        File d=new File(filepath);//建立代表   目录的File对象，并得到它的一个引用
		if(!d.exists()){//检查 目录是否存在
			d.mkdirs();
			
		}
    }

}
