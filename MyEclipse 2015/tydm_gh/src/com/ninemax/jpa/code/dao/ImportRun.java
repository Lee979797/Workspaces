package com.ninemax.jpa.code.dao;
import java.util.*;

import com.ninemax.jpa.util.TxtUtil;

/**
 * 
 * @author Administrator
 *
 */
public class ImportRun implements Runnable{
	ImportDataDAO importDataDAO = new ImportDataDAO();
	String taskName;
    public ImportRun(String taskName){
    	this.taskName = taskName;  
    }
    public void run() { 
    	int importFlag = 0; 
    	importFlag = importDataDAO.startImportData(taskName);  
    	TxtUtil.setFileName("importFlag", String.valueOf(importFlag));
    }
}
