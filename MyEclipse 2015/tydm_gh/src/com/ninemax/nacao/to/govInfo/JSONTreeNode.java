package com.ninemax.nacao.to.govInfo;

import java.io.Serializable;

public class JSONTreeNode implements Serializable{ 

    private static final long serialVersionUID = 1L; 
    private String id;            //ID 
    private String text;          //�ڵ���ʾ 
    private String cls;           //ͼ�� 
    private boolean leaf;         //�Ƿ�Ҷ�� 
    private String href;          //���� 
    private String hrefTarget;    //����ָ�� 
    private boolean expandable;   //�Ƿ�չ�� 
    private String description;   //������Ϣ 
	private String type;//�ڵ����� 1 Ϊ�к��ӽڵ�� 2 Ϊ����Ҷ�ӽڵ�
    
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getHrefTarget() {
		return hrefTarget;
	}
	public void setHrefTarget(String hrefTarget) {
		this.hrefTarget = hrefTarget;
	}
	public boolean isExpandable() {
		return expandable;
	}
	public void setExpandable(boolean expandable) {
		this.expandable = expandable;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
    
    

}
