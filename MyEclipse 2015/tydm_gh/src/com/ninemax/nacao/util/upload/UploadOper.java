package com.ninemax.nacao.util.upload;

import javax.servlet.http.HttpServletRequest;
public class UploadOper {


	/**
	 * 文件上传方法.
	 * @param su
	 * @param request
	 * @return
	 * @throws Exception
	 */
    @SuppressWarnings(value="unchecked")
	public static String fileUpload(String configPath,String uploadPath,String fileName,SmartUpload su, HttpServletRequest request) throws Exception {
    	File suFile = null;
	    int fileCount = 0;
	    try {
	        for (int i=0; i<su.getFiles().getCount();i++) {
	            suFile = su.getFiles().getFile(i);
	            if (suFile.isMissing())
	                continue;
	            fileCount++;
	        }
	        if (fileCount==0) throw new Exception("请选择上传的文件");
	        
            //String realPath = request.getRealPath("");
            String filePath=configPath+uploadPath;
            //java.io.File file = new java.io.File(filePath);
	        if (!new java.io.File(filePath).isDirectory())
				new java.io.File(filePath).mkdirs();
	        suFile.saveAs(filePath+fileName+"."+suFile.getFileExt(),SmartUpload.SAVE_PHYSICAL);
	        String name = fileName+"."+suFile.getFileExt();
	        return name;
	    } finally {

	    }
	}


}
