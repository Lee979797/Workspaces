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
	  String uploadPath =CommonPropertiesUtil.getValue("common.properties", "filepath");;//ϵͳָ���ļ��洢·��
	
	/**
	 * ���渽��
	 * @param at
	 * @return
	 */
	public int saveAttachmentInfo(AttachmentTO at){
		int result = 0;
		result = attachmentDAO.saveAttachmentInfo(at);
		return result;
	}
	/**
	 * ��Ӧid 
	 * @param uuid
	 * @return �����б�
	 */
	public List<AttachmentTO> getAttachmentInfoToJson(String uuid){
		List<AttachmentTO> list = attachmentDAO.getAttachmentInfoList(uuid);
		return list;
	}
	/**
	 * ��ȡ������Ϣ
	 * @param fileId
	 * @return ������Ϣ
	 */
	public AttachmentTO getAttachmentInfo(String fileId){
		AttachmentTO at = attachmentDAO.getAttachmentInfo(fileId);
    return at;
	}
	/**
	 * ɾ�������ļ�
	 * @param fileId
	 * @return
	 */
	public String deleteAttachmen(int fileId){
		int i = 0;
		AttachmentTO at = attachmentDAO.getAttachmentInfo(String.valueOf(fileId));
		// ɾ���ļ�
		if(at.getInfo3().equals(false)){
			uploadPath = uploadPath + "uploadsTempFolder//";
		}
		try {
			FileHelp.removeFile(uploadPath+at.getSaveName());
		} catch (Exception e) {
			i = 1;
			log.error(e);
		}
		// ɾ���ļ���Ϣ
		i = attachmentDAO.deleteAttachmenInfo(String.valueOf(fileId));
		return String.valueOf(i);
	}
	/**
	 * �����ύ����Ӧ������ͷ
	 * @param file
	 * @return
	 */
	public int submitAttachmen(String file[],String fileName[],String uuid,String ids){
		String fileIds = arrayToStr(file);
		String fileNames = arrayToStr(fileName);
		int i = 0;
		// ��һ�����ύȷ���ϴ��ĸ���
		i = attachmentDAO.submitAttachmen(fileIds, fileNames, uuid, ids);
		// �ڶ��� ���ϴ��ĸ��� ���Ƶ���ʽ�ļ���
		i = attachmentDAO.copyFiles(fileName);
		// ������ɾ�� �� ��������
		i = attachmentDAO.deleteAttachmenInfoList(fileIds, uuid, ids);
		// ���Ĳ� ɾ�� ��ʱ�ļ���
        String savePath = CommonPropertiesUtil.getValue("common.properties", "filepath") + "/uploadsTempFolder/";
        FileHelp.delFolder(savePath);
		return i;
	}
	/**
	 * �����ύ����Ӧ������ͷ
	 * @param file
	 * @return
	 */
	public int submitModAddAttachmen(String file[],String fileName[],String uuid,String ids){
		String fileIds = arrayToStr(file);
		String fileNames = arrayToStr(fileName);
		int i = 0;
		// һ����ʱ����������
		// ��1�����ύȷ���ϴ��ĸ���
		i = attachmentDAO.submitAttachmen(fileIds, fileNames, uuid, ids);
		// ��2�� ���ϴ��ĸ��� ���Ƶ���ʽ�ļ���
		i = attachmentDAO.copyFiles(fileName);
		// ��3��ɾ�� �� ��������
		i = attachmentDAO.deleteAttachmenInfoList(fileIds, uuid, ids);
		// ��4�� ɾ�� ��ʱ�ļ���
        String savePath = InitSysParams.system.getImagePath() + "/uploadsTempFolder/";
        FileHelp.delFolder(savePath);
        // ������ʽ������������ɾ������ʱ
        // ��1�� ɾ�������������ѯ����
        List<AttachmentTO> atList = attachmentDAO.getDeleteAttachmentList(ids, fileIds);
		String fileidsTo = arrayListToStr(atList);
        // ��2�� ɾ�����������Լ��ļ��������ļ���
		if(!clsStringTool.isEmpty(fileidsTo)){
			i = attachmentDAO.modDeleteAttachmenInfo(fileidsTo);
			i = attachmentDAO.modDeleteAttachmenFiles(atList);
		}
		return i;
	}
	
	/**
	 * ���鴫�ַ���
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
	 * ���ϴ��ַ���
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
	 * �жϸ�����С �Ƿ񳬹�ָ����С��Χ
	 * @param filePath �ļ�����·��+�ļ���
	 * @param limitSize ָ���ļ���С����
	 * @return ���� �Ƿ񳬹�ָ���ļ���С
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
