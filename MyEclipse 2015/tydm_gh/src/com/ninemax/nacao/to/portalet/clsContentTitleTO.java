/**
 * ��dwr����������� JSON
 */
package com.ninemax.nacao.to.portalet;
import java.io.Serializable;
/**
 * @author zhoupengpeng
 *
 */
public class clsContentTitleTO implements Serializable{
	
	/**
	 * Ϊ�˻������ ʵ�����л�
	 */
	private static final long serialVersionUID = -3631803515866350456L;
	private String title;
	private String isNew;
	private String addDate;//������������
	private String id;//pk����
	private String url;//
	private String dspId;//�г��ļ�¼���ڵı��ID
	//�����ܻ�Ҫ��ʾ����ֶ�
	
	public String getDspId() {
		return dspId;
	}
	public void setDspId(String dspId) {
		this.dspId = dspId;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public String getIsNew() {
		return isNew;
	}
	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	

}
