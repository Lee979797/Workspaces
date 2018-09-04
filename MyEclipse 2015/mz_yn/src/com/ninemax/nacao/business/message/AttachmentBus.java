package com.ninemax.nacao.business.message;

import java.io.File;
import java.util.List;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.util.CommonPropertiesUtil;
import com.ninemax.jpa.util.FileHelp;
import com.ninemax.nacao.dao.message.AttachmentDAO;
import com.ninemax.nacao.to.message.AttachmentTO;
import com.ninemax.nacao.util.clsStringTool;
import org.apache.log4j.Logger;

public class AttachmentBus {
    private static Logger log = Logger.getLogger(AttachmentBus.class);
	AttachmentDAO attachmentDAO = new AttachmentDAO();
	  String uploadPath =CommonPropertiesUtil.getValue("common.properties", "filepath");;//系统指定文件存储路径
	
	/**
	 * 保存附件
	 * @param at
	 * @return
	 */
	public int saveAttachmentInfo(AttachmentTO at){
		int result = 0;
		result = attachmentDAO.saveAttachmentInfo(at);
		return result;
	}
	/**
	 * 对应id 
	 * @param uuid
	 * @return 附件列表
	 */
	public List<AttachmentTO> getAttachmentInfoToJson(String uuid){
		List<AttachmentTO> list = attachmentDAO.getAttachmentInfoList(uuid);
		return list;
	}
	/**
	 * 获取附件信息
	 * @param fileId
	 * @return 附件信息
	 */
	public AttachmentTO getAttachmentInfo(String fileId){
		AttachmentTO at = attachmentDAO.getAttachmentInfo(fileId);
    return at;
	}
	/**
	 * 删除单个文件
	 * @param fileId
	 * @return
	 */
	public String deleteAttachmen(int fileId){
		int i = 0;
		AttachmentTO at = attachmentDAO.getAttachmentInfo(String.valueOf(fileId));
		// 删除文件
		if(at.getInfo3().equals(false)){
			uploadPath = uploadPath + "uploadsTempFolder//";
		}
		try {
			FileHelp.removeFile(uploadPath+at.getSaveName());
		} catch (Exception e) {
			i = 1;
			log.error(e);
		}
		// 删除文件信息
		i = attachmentDAO.deleteAttachmenInfo(String.valueOf(fileId));
		return String.valueOf(i);
	}
	/**
	 * 附件提交到对应公告里头
	 * @param file
	 * @return
	 */
	public int submitAttachmen(String file[],String fileName[],String uuid,String ids){
		String fileIds = arrayToStr(file);
		String fileNames = arrayToStr(fileName);
		int i = 0;
		// 第一步先提交确认上传的附件
		i = attachmentDAO.submitAttachmen(fileIds, fileNames, uuid, ids);
		// 第二步 把上传的附件 复制到正式文件夹
		i = attachmentDAO.copyFiles(fileName);
		// 第三步删除 表 无用数据
		i = attachmentDAO.deleteAttachmenInfoList(fileIds, uuid, ids);
		// 第四步 删除 临时文件夹
        String savePath = CommonPropertiesUtil.getValue("common.properties", "filepath") + "/uploadsTempFolder/";
        FileHelp.delFolder(savePath);
		return i;
	}
	/**
	 * 附件提交到对应公告里头
	 * @param file
	 * @return
	 */
	public int submitModAddAttachmen(String file[],String fileName[],String uuid,String ids){
		String fileIds = arrayToStr(file);
		String fileNames = arrayToStr(fileName);
		int i = 0;
		// 一、临时附件操作。
		// 第1步先提交确认上传的附件
		i = attachmentDAO.submitAttachmen(fileIds, fileNames, uuid, ids);
		// 第2步 把上传的附件 复制到正式文件夹
		i = attachmentDAO.copyFiles(fileName);
		// 第3步删除 表 无用数据
		i = attachmentDAO.deleteAttachmenInfoList(fileIds, uuid, ids);
		// 第4步 删除 临时文件夹
        String savePath = InitSysParams.system.getImagePath() + "/uploadsTempFolder/";
        FileHelp.delFolder(savePath);
        // 二、正式附件操作。有删除操作时
        // 第1步 删除附件数据项，查询集合
        List<AttachmentTO> atList = attachmentDAO.getDeleteAttachmentList(ids, fileIds);
		String fileidsTo = arrayListToStr(atList);
        // 第2步 删除此数据项以及文件（物理文件）
		if(!clsStringTool.isEmpty(fileidsTo)){
			i = attachmentDAO.modDeleteAttachmenInfo(fileidsTo);
			i = attachmentDAO.modDeleteAttachmenFiles(atList);
		}
		return i;
	}
	
	/**
	 * 数组传字符串
	 * @param arry
	 * @return a,b,c,d
	 */
	public String arrayToStr(String arry[]){
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<arry.length; i++) {
			sb.append(arry[i].trim());
			if(i+1 < arry.length){
				sb.append(",");
			}
		}
		return sb.toString();
	}
	/**
	 * 集合传字符串
	 * @param list
	 * @return a,b,c,d
	 */
	public String arrayListToStr(List<AttachmentTO> list){
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<list.size(); i++) {
			sb.append(list.get(i).getFileId());
			if(i+1 < list.size()){
				sb.append(",");
			}
		}
		return sb.toString();
	}
	/**
	 * 判断附件大小 是否超过指定大小范围
	 * @param filePath 文件所在路径+文件名
	 * @param limitSize 指定文件大小限制
	 * @return 返回 是否超过指定文件大小
	 */
	public boolean isAttachmentSize(String filePath,int limitSize){
		boolean isFlag = true;
		File file = new File(filePath);
		if((file.length())>(limitSize*1024*1024)){
			isFlag = false;
		}
		return isFlag;
	}	
}
