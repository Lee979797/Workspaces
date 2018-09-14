<%@ page language="java" 
 contentType = "text/html;charset=UTF-8" 
 pageEncoding="UTF-8"
%>
<%@ page import="java.sql.*,java.lang.*,java.util.*,com.lhq.prj.bms.core.MyUtils" %>
<%@ page import="com.lhq.prj.bms.po.Func" %>

<%
List funcList=(List)session.getAttribute("funcList");
if(funcList!=null){
	if(funcList.size()==0){
%>
		[{text:'没有权限',id:'zzNoDuty-manage',expanded:false}]
<%
	}else{
		String strAllTree="";
		String strOldeParentName="";
		Boolean isFinalNote=false;
		for (int k = 0; k < funcList.size(); k++) {
			Func func=new Func();
			func=(Func)funcList.get(k);
			String strParentName=func.getParentName();
			String strParentCode=func.getParentCode();
			boolean strParentFlag=func.getParentFlag();
			String strFuncName=func.getFuncName();
			String strFuncCode=func.getFuncCode();

			if(!strOldeParentName.equals(strParentName)){
				if(strFuncCode.equals("zzCard")){
					if(k==0){
						//strAllTree=strAllTree+"{text:'IC卡管理',id:'"+strParentCode+"Parent-manage',expanded: false,children:[{text:'卡日常业务',id:'zzCardManage-manage',expanded: true, children:[{text:'年检',id:'zzCardAudit-manage',leaf:true}]},{text:'卡操作',id:'zzCardDo-manage',expanded: true,children:[{text:'读卡',id:'zzCardRead-manage',leaf:true},{text:'写卡',id:'zzCardWrite-manage',leaf:true},{text:'打卡(写卡&打卡)',id:'zzDCardPrint-manage',leaf:true},{text:'打卡表面',id:'zzCardPrint-manage',leaf:true},{text:'IC卡查询',id:'zzCardPrintLog-manage',leaf:true}]},{text:'卡参数设置',id:'zzCardSet-manage',children:[{text:'打卡机参数设置',id:'zzCardPrintSet-manage',leaf:true}]}";
						strAllTree=strAllTree+"{text:'IC卡管理',id:'"+strParentCode+"Parent-manage',expanded: false,children:[{text:'卡日常业务',id:'zzCardManage-manage',expanded: true, children:[{text:'年检',id:'zzCardAudit-manage',leaf:true}]},{text:'卡操作',id:'zzCardDo-manage',expanded: true,children:[{text:'读卡',id:'zzCardRead-manage',leaf:true},{text:'写卡',id:'zzCardWrite-manage',leaf:true},{text:'打卡表面',id:'zzCardPrint-manage',leaf:true},{text:'IC卡查询',id:'zzCardPrintLog-manage',leaf:true}]},{text:'卡参数设置',id:'zzCardSet-manage',children:[{text:'打卡机参数设置',id:'zzCardPrintSet-manage',leaf:true}]}";
					}else{
						//strAllTree=strAllTree+"]},{text:'IC卡管理',id:'"+strParentCode+"Parent-manage',expanded: false,children:[{text:'卡日常业务',id:'zzCardManage-manage',expanded: true, children:[{text:'年检',id:'zzCardAudit-manage',leaf:true}]},{text:'卡操作',id:'zzCardDo-manage',expanded: true,children:[{text:'读卡',id:'zzCardRead-manage',leaf:true},{text:'写卡',id:'zzCardWrite-manage',leaf:true},{text:'打卡(写卡&打卡)',id:'zzDCardPrint-manage',leaf:true},{text:'打卡表面',id:'zzCardPrint-manage',leaf:true},{text:'IC卡查询',id:'zzCardPrintLog-manage',leaf:true}]},{text:'卡参数设置',id:'zzCardSet-manage',children:[{text:'打卡机参数设置',id:'zzCardPrintSet-manage',leaf:true}]}";
						strAllTree=strAllTree+"]},{text:'IC卡管理',id:'"+strParentCode+"Parent-manage',expanded: false,children:[{text:'卡日常业务',id:'zzCardManage-manage',expanded: true, children:[{text:'年检',id:'zzCardAudit-manage',leaf:true}]},{text:'卡操作',id:'zzCardDo-manage',expanded: true,children:[{text:'读卡',id:'zzCardRead-manage',leaf:true},{text:'写卡',id:'zzCardWrite-manage',leaf:true},{text:'打卡表面',id:'zzCardPrint-manage',leaf:true},{text:'IC卡查询',id:'zzCardPrintLog-manage',leaf:true}]},{text:'卡参数设置',id:'zzCardSet-manage',children:[{text:'打卡机参数设置',id:'zzCardPrintSet-manage',leaf:true}]}";
					}
				}else{
					if(k==0){
						strAllTree=strAllTree+"{text:'"+strParentName+"',id:'"+strParentCode+"Parent-manage',expanded: "+strParentFlag+", children:[{text:'"+strFuncName+"',id:'"+strFuncCode+"-manage',leaf:true}";
					}else{
						strAllTree=strAllTree+"]},{text:'"+strParentName+"',id:'"+strParentCode+"Parent-manage',expanded: "+strParentFlag+", children:[{text:'"+strFuncName+"',id:'"+strFuncCode+"-manage',leaf:true}";
					}
				}
				if(k==funcList.size()-1){
					strAllTree=strAllTree+"]}";
				}	
						
			}else{  
				if( strFuncCode.equals("zzYwset") || strFuncCode.equals("zzDict") || strFuncCode.equals("zzCenterManage")){
					if(strFuncCode.equals("zzYwset")){
						strAllTree=strAllTree+",{text:'业务审核设置',id:'zzYwset-manage',children:[{text:'网上业务',id:'zzYwnetSet-manage',leaf:true},{text:'现场业务',id:'zzQXSet-manage',leaf:true}]}";
					}
					if(strFuncCode.equals("zzDict")){
						strAllTree=strAllTree+",{text:'数据字典管理',id:'zzDict-manage',children:[{text:'字典管理',id:'zzDictIndex-manage',leaf:true},{text:'字典类别管理',id:'zzDictDetail-manage',leaf:true}]}";
					}
					if(strFuncCode.equals("zzCenterManage")){
						strAllTree=strAllTree+",{text:'办证组织机构管理',id:'zzCenterManage-manage',children:[{text:'分中心管理',id:'zzCenter-manage',leaf:true},{text:'办证机构管理',id:'zzBzjg-manage',leaf:true},{text:'全国办证机构管理',id:'zzBzjgallManage-manage',leaf:true}]}";
					}
				}else{
					if(k==funcList.size()-1){
						strAllTree=strAllTree+",{text:'"+strFuncName+"',id:'"+strFuncCode+"-manage',leaf:true}]}";
					}else{
						strAllTree=strAllTree+",{text:'"+strFuncName+"',id:'"+strFuncCode+"-manage',leaf:true}";
					}
				}
			}
			strOldeParentName=strParentName;
		}
		out.print("["+strAllTree+"]");
	}
}else{
%>
	[{text:'系统登录时间到期',id:'zzNoLogin-manage',expanded:false}]
<%
}
%>