package com.ninemax.nacao.to.message;

import java.io.Serializable;
/**
 *   ������
 * @author jinxy
 *
 */
public class AttachmentTO implements Serializable{
	private String fileId;           // ������id
	private String fileName;         // ����ԭ�ļ���
	private String saveName;         // ��������ڱ������
	private String filePath;         // ����·��     -- ��ʱû���ϣ�ÿ��������ָ���ļ����·������ InitSysParams.system.getImagePath()
	private String fileType;         // �ļ�����
	private String message_ids;      // ����id - ���
    private String info;             
    private String info1;
    private String info2;
    private String info3;
    
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getMessage_ids() {
		return message_ids;
	}
	public void setMessage_ids(String messageIds) {
		message_ids = messageIds;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getInfo1() {
		return info1;
	}
	public void setInfo1(String info1) {
		this.info1 = info1;
	}
	public String getInfo2() {
		return info2;
	}
	public void setInfo2(String info2) {
		this.info2 = info2;
	}
	public String getInfo3() {
		return info3;
	}
	public void setInfo3(String info3) {
		this.info3 = info3;
	}
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	
}
