/**
 * author 苗志强
 * 2010 3 29
 */
package com.ninemax.nacao.to.system;

public class clsSystemConfig {


	private static String indexPath[];
	private static String tempIndexPath;
	private static int mergeFactor;
	private static int maxMergeDocs;
	private static int minMergeDocs;
	private static int maxFieldLength;
	private static int beginIndexNumber;
	private static int endIndexNumber;
	private static int createIndexTimer;
	private static String sourcefileServer;
	private static String tomcatSerialId;
	private static String tomcatSerialIdPath;
	private static String egovDomain;
	private static String bdPicPath;
	
	
	
	//rmi
	private static String rmi;
	private static String rmiServerip;
	private static String pushletServerip;
	
	
	
	//设置代理上网配置，直连互联网不行就转到代理
	private static String usePoxy;//是否使用代理 1使用 ，0不使用
	private static String poxyHost;
	private static String poxyPort;
	
	//业务系统导入的数据，静态发布页面需要用到的本服务的url地址
	private static String enemcww;
	
	
	public static String getEnemcww() {
		return enemcww;
	}
	public static void setEnemcww(String enemcww) {
		clsSystemConfig.enemcww = enemcww;
	}
	public static String getPoxyHost() {
		return poxyHost;
	}
	public static void setPoxyHost(String poxyHost) {
		clsSystemConfig.poxyHost = poxyHost;
	}
	public static String getPoxyPort() {
		return poxyPort;
	}
	public static void setPoxyPort(String poxyPort) {
		clsSystemConfig.poxyPort = poxyPort;
	}
	public static String getUsePoxy() {
		return usePoxy;
	}
	public static void setUsePoxy(String usePoxy) {
		clsSystemConfig.usePoxy = usePoxy;
	}



	//PDF查看路径 --by yxf
	private static String pdfPath;
	
	public static int getBeginIndexNumber() {
		return beginIndexNumber;
	}
	public static void setBeginIndexNumber(int beginIndexNumber) {
		clsSystemConfig.beginIndexNumber = beginIndexNumber;
	}
	public static int getCreateIndexTimer() {
		return createIndexTimer;
	}
	public static void setCreateIndexTimer(int createIndexTimer) {
		clsSystemConfig.createIndexTimer = createIndexTimer;
	}
	public static int getEndIndexNumber() {
		return endIndexNumber;
	}
	public static void setEndIndexNumber(int endIndexNumber) {
		clsSystemConfig.endIndexNumber = endIndexNumber;
	}
	/*public static String getIndexPath() {
		return indexPath;
	}
	public static void setIndexPath(String indexPath) {
		clsSystemConfig.indexPath = indexPath;
	}*/
	public static int getMaxFieldLength() {
		return maxFieldLength;
	}
	public static void setMaxFieldLength(int maxFieldLength) {
		clsSystemConfig.maxFieldLength = maxFieldLength;
	}
	public static int getMaxMergeDocs() {
		return maxMergeDocs;
	}
	public static void setMaxMergeDocs(int maxMergeDocs) {
		clsSystemConfig.maxMergeDocs = maxMergeDocs;
	}
	public static int getMergeFactor() {
		return mergeFactor;
	}
	public static void setMergeFactor(int mergeFactor) {
		clsSystemConfig.mergeFactor = mergeFactor;
	}
	public static int getMinMergeDocs() {
		return minMergeDocs;
	}
	public static void setMinMergeDocs(int minMergeDocs) {
		clsSystemConfig.minMergeDocs = minMergeDocs;
	}
	public static String getTempIndexPath() {
		return tempIndexPath;
	}
	public static void setTempIndexPath(String tempIndexPath) {
		clsSystemConfig.tempIndexPath = tempIndexPath;
	}
	public static void setIndexPath(String[] indexPath) {
		clsSystemConfig.indexPath = indexPath;
	}
	public static String[] getIndexPath() {
		return indexPath;
	}
	public static String getRmi() {
		return rmi;
	}
	public static void setRmi(String rmi) {
		clsSystemConfig.rmi = rmi;
	}
	public static String getRmiServerip() {
		return rmiServerip;
	}
	public static void setRmiServerip(String rmiServerip) {
		clsSystemConfig.rmiServerip = rmiServerip;
	}
	public static String getPushletServerip() {
		return pushletServerip;
	}
	public static void setPushletServerip(String pushletServerip) {
		clsSystemConfig.pushletServerip = pushletServerip;
	}
	public static String getSourcefileServer() {
		return sourcefileServer;
	}
	public static void setSourcefileServer(String sourcefileServer) {
		clsSystemConfig.sourcefileServer = sourcefileServer;
	}
	public static String getTomcatSerialId() {
		return tomcatSerialId;
	}
	public static void setTomcatSerialId(String tomcatSerialId) {
		clsSystemConfig.tomcatSerialId = tomcatSerialId;
	}
	public static String getTomcatSerialIdPath() {
		return tomcatSerialIdPath;
	}
	public static void setTomcatSerialIdPath(String tomcatSerialIdPath) {
		clsSystemConfig.tomcatSerialIdPath = tomcatSerialIdPath;
	}
	public static String getEgovDomain() {
		return egovDomain;
	}
	public static void setEgovDomain(String egovDomain) {
		clsSystemConfig.egovDomain = egovDomain;
	}
	public static String getPdfPath() {
		return pdfPath;
	}
	public static void setPdfPath(String pdfPath) {
		clsSystemConfig.pdfPath = pdfPath;
	}
	public static String getBdPicPath() {
		return bdPicPath;
	}
	public static void setBdPicPath(String bdPicPath) {
		clsSystemConfig.bdPicPath = bdPicPath;
	}

}
