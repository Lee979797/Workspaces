/**
 * 与dwr交付传输对象 JSON
 */
package com.ninemax.nacao.to.portalet;
import java.io.Serializable;
/**
 * @author zhoupengpeng
 *
 */
public class clsContentTitleTO implements Serializable{
	
	/**
	 * 为了缓存对象 实现序列化
	 */
	private static final long serialVersionUID = -3631803515866350456L;
	private String title;
	private String isNew;
	private String addDate;//今后可能有日期
	private String id;//pk主键
	private String url;//
	private String dspId;//列出的记录所在的表的ID
	//今后可能还要显示别的字段
	
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
