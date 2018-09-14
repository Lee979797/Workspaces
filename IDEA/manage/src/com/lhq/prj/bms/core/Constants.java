package com.lhq.prj.bms.core;

public interface Constants {
	
	public static final String LoginUserName = "user-name"; 
	
	public static final String LoginPassword = "password"; 
	
	//具体的上传信息包括：机构名称、注册号、机构地址、申请代码类型，外加一个是否重复的标识符
	
	public static final String OrganizationName = "org-name";
	
	public static final String RegisterNumber = "reg-num";
	
	public static final String OrganizationAddress = "org-address";
	
	public static final String CodeType = "code-type"; 
	
	public static final String IsRepeatedFlag = "flag"; 
	
	
	/**
	 * 通过接口上传文件的文件属性名（同form表单中的input域的name）
	 */
	public static final String XmlFile = "xml-file";
	/**
	 * 通过接口上传文件的文件属性名（同form表单中的input域的name）
	 */
	public static final String TiffFile = "tiff-file";
	
	/**
	 * 执行赋码确认时上传的代码属性名
	 */
	public static final String ConfirmCode = "code";
	
	
}
