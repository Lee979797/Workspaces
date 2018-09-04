
<%//用户公共变量定义

String gStrUserCode = "";		//用户代码
String gStrUserName = "";		//用户真实姓名
String gStrUserType = "";	//用户类型()
String gStrOrgaCode = "";	//用户所属机构代码
String gStrOrgaName="";      //用户所属机构名称
String gStrBelongCode = "";		//
String gStrRoleCode = "";		//
String gStrUserLevel="";         //
String strThisPageTmp="";        //上一层所属页面 
String gStrVisitFlag="";
String gStrBzjgLevel="";//办证机构级别
String gStrBzjgQz="";//办证机构前缀(根据级别取前2、4、6位)
//检查权限函数，将某一页所能访问的级别与用户的级别进行比较，如不存在则拒绝用户访问
//在每个功能页面中调用，参数 strLevel 指所能访问页面的用户级别
gStrUserCode = (String)session.getAttribute("UserCode");
gStrUserCode="530000";
//判断访问权限
//按照传入的 strThisPage
//要求：从session中PemitModules
Vector gVecPemitModules=null;
gVecPemitModules=(Vector)session.getAttribute("PemitModules");



gStrUserName = (String)session.getAttribute("UserName");	//用户真实姓名
gStrUserType = (String)session.getAttribute("UserType");	//用户类型
gStrBelongCode = (String)session.getAttribute("UserBelong");	//用户级别0省分中心，1分支机构
gStrBelongCode = "530000";	//用户级别0省分中心，1分支机构
gStrVisitFlag=(String)application.getAttribute("PermitVisit");
//判断是否已经超出了系统开放时间

//将用户级别放入session中,以便servlet调用
session.setAttribute("UserLevel",gStrUserLevel.trim());
%>
