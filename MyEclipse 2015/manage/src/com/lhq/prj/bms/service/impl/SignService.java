package com.lhq.prj.bms.service.impl;

import jit.parameters.JIT_CRLPARAM;
import jit.parameters.Params;
import jit.toolkits.JIT_Base64;
import jit.toolkits.JIT_Bin;
import jit.toolkits.JIT_Certificate;
import jit.toolkits.JIT_Engine;

import com.lhq.prj.bms.service.ISignService;

public class SignService implements ISignService {

	private static final String Global_ZJ_ROOT_PFX_NAME="whbzy.pfx";
	private static final String Global_ZJ_ROOT_PFX_PASSWORD="11111111";
	private String errorMessage = "";
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	private String charRemoveEnter(String str)
	{
		String content="";
        for(int k=0;k<str.length();k++)
        {
            if(str.charAt(k)!='\n' && str.charAt(k)!='\r')
                content+=str.charAt(k);
            else
            	content+= "";
        }
        return content;
	}
	public String charChangeEnter(String str)
	{
		String content="";
        for(int k=0;k<str.length();k++)
        {
        	
            if(str.charAt(k)=='\n'||str.charAt(k)=='\r')
            {
            	if(str.charAt(k)=='\n')
            	 content+="@n@";
            	if(str.charAt(k)=='\r')
               	 content+="@r@";
            }
            else
            {
            	 content+=str.charAt(k);
            }
        }
        return content;
	}
	
	public String getSign(String jgdm,String bzjgdm,String bzrq){
		
		String str = jgdm+bzjgdm+bzrq;
		String sWorkPath ;
		byte[] bWorkPath ;
		String sServerCertPath ;
	    
		JIT_Engine Engine = null;
	
		JIT_Bin Bin = null;
		JIT_Base64 Base64 = null;
	
		JIT_Certificate ServerEncCert = null;
		JIT_Certificate ServerSignCert = null;
	
		String ServerEncCertPath;
		String ServerSignCertPath;
		String CertPassword = Global_ZJ_ROOT_PFX_PASSWORD;
		
		if(CertPassword==null)
		{
			this.errorMessage = "为获取到证书密码！";
			return "";
		}
	
		byte[] bServerSignCertPath;
		byte[] bCertPassword ;
	

		byte [] CRLPath ;
	

		int iRet = 0;
		
		sWorkPath = "c:\\path";
		sServerCertPath = "c:\\path";
		ServerSignCertPath = "FILE://"+sServerCertPath+"/"+Global_ZJ_ROOT_PFX_NAME;
		
		
		CRLPath = (sWorkPath+"/crl.crl").getBytes();
	    try
	    {
	    
			bWorkPath = sWorkPath.getBytes();
			
			bServerSignCertPath = ServerSignCertPath.getBytes();
			bCertPassword = CertPassword.getBytes();
//////////////////////////////////////////////////////////////////////////
		//初始化


			System.out.println("Engine = new JIT_Engine(bWorkPath); begin");
			try{
				Engine = new JIT_Engine(bWorkPath);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			System.out.println("Engine = new JIT_Engine(bWorkPath); end");

			iRet = Engine.getErrcode();
			if(0 > iRet){
				this.errorMessage = "JIT初始化失败!" + iRet;
				return "";
			}
		
			Base64 = new JIT_Base64();
			iRet = Base64.getErrCode();
			if(0 > iRet)
			{
				this.errorMessage = "JITBase64failed!" + iRet;
				return "";
			}
		    
			Bin = new JIT_Bin();
			iRet = Bin.getErrCode();
			if (0 > iRet) {
				this.errorMessage = "Bin init failed:" + iRet;
			  return "";
			}

	System.out.println(" JIT_Certificate( begin");
		//////////////////////////////////////////////////////////////////////////
		//证书操作
		
			ServerSignCert = new JIT_Certificate(bServerSignCertPath, bCertPassword, bWorkPath);
			iRet = ServerSignCert.getErrCode();
			if (0 > iRet) {
				this.errorMessage = "ServerSignCert operation failed with err_code:" + iRet;
			  return "";
			}    

System.out.println(" JIT_Certificate( end");
			//////////////////////////////////////////////////////////////////////////
			//初始化crl配置
			JIT_CRLPARAM ParamCRL= new JIT_CRLPARAM();
			ParamCRL.szCRLFile = CRLPath;
			ParamCRL.nMode=Params.VERIFY_MODE_OFFLINE;//1

			//vfyDecEvp引发不可预料的错误（gpf），加上非空判定
			//2007.04.06 wangningbo
			if(ServerSignCert==null)
			{
				this.errorMessage = "初始化服务器证书失败！";
				return "";
			}

System.out.println(" 初始化服务器证书 成功");

			byte[] bInData = str.getBytes();
			byte[] a = Bin.signData(ServerSignCert,6, bInData ); //签名

			String re = new String(a);
			re = this.charChangeEnter(re);
			System.out.println(re);
			return re;
			
	    }
	    catch(Exception ex)
	    {
	    	this.errorMessage = "签名时发生异常："+this.charRemoveEnter(ex.getMessage());
	    	return "";
	    }
	
	}
}
