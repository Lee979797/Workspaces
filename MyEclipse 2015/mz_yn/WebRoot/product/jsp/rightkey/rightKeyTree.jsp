<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.jpa.system.bo.RightkeyBo" %>
<%@ page import="com.ninemax.jdbc.business.system.clsRightKeyBus" %>
<%@ page import="com.ninemax.jpa.system.model.Rightkey" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<SCRIPT type="text/javascript">var tWorkPath="/product/js/";</script>
<script type="text/javascript" language="JavaScript1.2" src="/product/js/dtree.js"></script>
<script type="text/javascript" language="JavaScript1.2" src="/product/js/loadTree.js"></script>
<title>部门树</title>
</head>

<body bgcolor="#7AA1E6">
<%
clsRightKeyBus rightKeyBus = new clsRightKeyBus();
//RightkeyBo rightKeyBus = new RightkeyBo();
ArrayList rightKeys = rightKeyBus.ListAllToMune();

%>
<script language="javascript">
var tmenuItems =
[
  
];
alert("loading");
<%
if(rightKeys!=null && rightKeys.size()>0){
    for(int index=0;index<rightKeys.size();index++){
	    
		Rightkey rightKeyTO = (Rightkey)rightKeys.get(index);
		
		String rightKeyId = rightKeyTO.getRightkeyId();
		String level = rightKeyTO.getRightkeyDepth().trim();
		
		String pictrue = "folder_mac.gif";
		String linkPage = "viewRightKey.jsp?rightKeyId="+rightKeyId;//固定的
		String rightKeyName = rightKeyTO.getRightkeyName();
	    String levelSy = "";
		//String target = "rightFrame";
		String pageTarget = "deptRight";
		
		if("1".equals(level)){
		 
		
			 
		 }
		 if("2".equals(level)){
			 levelSy = "|";
		 }
		 if("3".equals(level)){
			levelSy = "||";
		 }
		 
		
		String chName = levelSy+rightKeyName;
%>

 
	tmenuItems[<%=index%>]=["<%=chName%>", "<%=linkPage%>", "<%=pictrue%>","","", "","<%=pageTarget%>","",""];
	
			 
	<%	}
		
	}%>


if(tmenuItems.length>0)dtree_init();
</script>
</body>
</html>
