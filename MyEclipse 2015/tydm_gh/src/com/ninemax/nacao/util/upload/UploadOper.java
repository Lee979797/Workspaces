package com.ninemax.nacao.util.upload;

import javax.servlet.http.HttpServletRequest;
public class UploadOper {


	/**
	 * �ļ��ϴ�����.
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
	        if (fileCount==0) throw new Exception("��ѡ���ϴ����ļ�");
	        
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
