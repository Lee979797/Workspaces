<%@ page contentType="text/html; charset=GBK" buffer="512kb" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.ninemax.jdbc.business.system.clsUserRightKeyBus" %>
<%@ page import="com.ninemax.jpa.code.bus.AuditingBus" %>
<%@ page import="com.ninemax.jpa.code.model.TSystem" %>
<%@ page import="com.ninemax.jpa.system.bo.UserBo" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="com.ninemax.nacao.business.message.SystemMessageBus" %>
<%@ page import="com.ninemax.nacao.to.message.SystemMessageTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.jpa.util.*" %>
<%@ page import="com.ninemax.jpa.util.CommonPropertiesUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
    response.setHeader("Cache-Control", "Public");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<%
    List<SystemMessageTO> messageList = null;
    SystemMessageBus sysMessBus = new SystemMessageBus();
    messageList = sysMessBus.getFirstTop();
    request.setAttribute("messageList", messageList);
    clsUserRightKeyBus userRightKeyBus = new clsUserRightKeyBus();
    User ses_user = (User) session.getAttribute("sysUser");
    int user_id = ses_user.getUserId();

    UserBo userBo = new UserBo();
    User user = userBo.findById(user_id);
    AuditingBus auditingBus = new AuditingBus();
   // Boolean isSp = auditingBus.isHasSps(ses_user.getBzjgdm());

    // 下载路径
       String savePath = CommonPropertiesUtil.getValue("common.properties", "filepath");
    //权限
    /**
     *权限说明
     *
     *  01010101 发证  01050101 换证 02010101 变更
     **/

    boolean canFz = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "01010101");
    boolean canHz = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "01050101");
    boolean canBg = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "02010601");
    boolean canNj = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "02010201");
    boolean canVz = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "02010301");
    boolean canDy = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "01060101");
    boolean canSh = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "100103");
    String xtmc=CommonPropertiesUtil.getValue("common.properties", "xtmc");
    if(xtmc.length()>17){
    	
        xtmc= xtmc.substring(0,15);
        }
%>
<head>
    <title><%=xtmc %></title>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
   <style type="text/css">
        .welcome_ht {
            width: 1070px;
            margin: 0px auto;
            padding-top: 30px;
            font-family: "宋体", serif;
            position: relative;
        }

        .gonggao {
            width: 750px;
            height: 20px;
            line-height: 20px;
            position: absolute;
            top: -10px;
            left: 260px;
            font-size: 14px;
            cursor: pointer;
        }

        .imgGg {
            position: absolute;
            top: -10px; left:160px;
        }

        .imgGg img {
            float: left;
            margin-right: 5px;
        }

        .gonggao span {
            color: #0093e7;
            text-decoration: underline;
        }

        .gonggao img {
            position: relative;
            top: 3px;
        }

        .welcome_ht p {
            width: 100%;
            margin: 0px;
            padding: 0px;
        }

        .welcome_ht h3 {
            width: 750px;
            height: 30px;
            line-height: 30px;
            margin: 10px auto;
            padding: 0px;
            font-size: 14px;
        }

        .welcome_ht ul {
            width: 750px;
            margin: 0px auto;
            padding: 0px;
        }

        .welcome_ht ul li {
            float: left;
            font-size: 12px;
            margin: 0px 30px 0px 0px;
            padding: 0px;
            list-style: none;
        }

        .welcome_ht ul li a {
            font-size: 12px;
            color: #008ad2;
            text-decoration: none;
        }

        .welcome_ht ul li a img {
            border: none;
        }

        <!--
        #shangfan {
            line-height: 24px;
            height: 24px;
            width: 400px; /*border:solid 1px #ccc;*/
            overflow: hidden;
        }

        #shangfan ol {
            margin: 0px 10px;
            padding: 0px;
            list-style-type: none;
        }

        #shangfan ol li {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            margin: 0;
            padding: 0px;
        }
		.home_footer_box{ width:375px;}
		.home_footer_box h1{ font:18px/40px Microsoft yahei; margin:0px; padding:0px;}
		.home_footer_box ul{}
		.home_footer_box ul li{ display:block; clear:both; font:12px/20px Simsun;}
        -->
        .welBan{ width:1068px; height:377px; margin:0px auto; background:url(images/welcome_ht.jpg) no-repeat; overflow:hidden;}
		.welBan h6{ font:40px/150px Microsoft yahei; margin:90px 0px 0px; text-align:center; color:#3B88DA; box-sizing:border-box; text-shadow:1px 1px 1px rgba(255,255,255,0.15);}
    </style>
    <%
String agent = request.getHeader("user-agent"); 
StringTokenizer st = new StringTokenizer(agent,";"); 
String str1 = "";
try{str1 = st.nextToken();}catch(Exception e){}
String str2 = "";
try{str2 = st.nextToken();}catch(Exception e){}
String str3 = "";
try{str3 = st.nextToken();}catch(Exception e){}


//得到用户的浏览器名 
String userbrowser = "";

if(!clsStringTool.isEmpty(str2)){
	if(str2.indexOf("Firefox") > -1){
		userbrowser = str2.split(" ")[str2.split(" ").length-1];
		str1 = str1+")";
	}else{
		userbrowser = str2;
	}
	
}else{
	userbrowser = str1.split(" ")[str1.split(" ").length-2];
}
System.out.println(userbrowser);
if(userbrowser.length()>30){
	//userbrowser=userbrowser.substring(0,30)+"...";	
}
//userbrowser=userbrowser.substring(userbrowser.indexOf("Chrome"),userbrowser.length()-1);
//得到用户的操作系统名 
String useros = ""; 

if(str1.indexOf("(") > -1 && str3.equals("")){
	//System.out.println(str1.indexOf("("));
	//System.out.println(str1.indexOf(")"));
	try{
		useros = str1.substring(str1.indexOf("(")+1,str1.indexOf(")"));
	}catch(Exception e){
		useros = str3;
	}
}else{
	useros = str3;
}

%>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type='text/javascript' src='/dwr/interface/AttachmentBus.js'></script>
    <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.8.7.custom.min.js"></script>
    <script type='text/javascript' src="/js/calendar/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
    <link rel="stylesheet" type="text/css" href="/js/highslide-4.1.8/highslide/highslidezx.css"/>
    <script type="text/javascript" src="/js/highslide-4.1.8/highslide/highslide-with-html.js" charset="gbk"></script>
    <script type="text/javascript">
        hs.graphicsDir = '/js/highslide-4.1.8/highslide/graphics/';
        hs.outlineType = 'rounded-white';
        hs.showCredits = false;
        hs.wrapperClassName = 'draggable-header';
    </script>
    <script type="text/javascript">
        function showBoard(sysId, title, content) {
            document.getElementById("show").innerHTML = "<h3>" + title + "</h3>" + content;
            document.getElementById('btn').onclick();
            // 保存完成 的文件信息 反映
            showParentWindow(sysId)
        }
        function showParentWindow(sysId) {
            dwr.engine.setAsync(false);
            AttachmentBus.getAttachmentInfoToJson(sysId, function (data) {
                //开始 拼 附件 信息
                for (var o in data) {
                    addUpload(data[o].fileName, data[o].fileId, data[o].saveName);
                }
            });
            console.log('b');
        }
        //增加元素
        function addUpload(fileName, fileId, saveName) {
      
            var searchForm = document.searchForm.action;
            var path = document.getElementById("path").value;
            var url = searchForm + "?path=" + path;
            // 放附件
            var newDiv = "<div id=divUpload" + fileId + ">"
                    + "<img src='/product/jsp/images/fujian_tubiao.jpg' /><a href='" + url + saveName + "' >" + fileName + "</A>"
                    + "</div>";
            document.getElementById("show").insertAdjacentHTML("beforeEnd", newDiv);
        }
		
		  function aa(){
        	
        	ymPrompt.win('/product/jsp/user/modPassword.jsp',400,300,'密码修改',null,null,null,{id:'a'})
            }
          
    </script>
</head>

<body
        <c:if test="${sessionScope.prompt !=null && sessionScope.prompt != '' }">onload="document.getElementById('btn2').onclick();" </c:if>
        style="background:#fff;">
<form name="searchForm" action="<%=request.getContextPath()%>/servlet/DownServlet" method="get">
     <input type="hidden" id="path" name="path" value="<%=savePath%>"/>
</form>
<span style="margin-left:50%;" id="btn" onclick="return hs.htmlExpand(this, { headingText: '系统公告' })">&nbsp;</span>

<div id="show" class="highslide-maincontent" style="display:none;"></div>

<div class="welcome_ht">
    
        <div class="imgGg"><img src="../images/icon_volume.gif"/> <b
                onclick="javascript:gonggaoPopUpWindow('t_gg','<%=request.getContextPath()%>/product/gonggao_top.jsp')">系统公告：</b>
        </div>
        <div id="shangfan" class="gonggao">
                <%--<span>${message.send_title}</span>
                <img src="../images/icon_news.gif"/>--%>
            <div id="holder">
                <ol>
                    <c:forEach varStatus="i" var="gonggao" items="${messageList}">
                        <li onclick="showBoard('${gonggao.sys_id}','${gonggao.send_title}','${fn:escapeXml(gonggao.send_content)}');">${gonggao.send_title}
                            <c:if test="${i.count  eq 1 }"><img src="../images/icon_news.gif"/></c:if></li>
                    </c:forEach>
                </ol>
            </div>
        </div>
       <!--<p><img src="images/welcome_ht.jpg"/></p>-->
     <div class="welBan">
    	<h6><%=xtmc %></h6>
    </div>
      <table width="750" border="0" cellpadding="0" cellspacing="5" style="margin:0px auto;">
        <tr>
          <td width="50%" style="vertical-align:top;">
              <div class="home_footer_box">
                <h1>用户信息</h1>
                <ul>
                    <li>用户名:${sysUser.userName } [<a href="#" onclick="javascript:aa()" title="点击修改密码">修改密码</a>]</li>
                    <li>用户姓名:${sysUser.userChinesename } </li>
                    <li>办证机构名称:${sysUser.printName }  </li>
                    <li>当前时间:<%=DateProcess.getSysTime()%></li>
                  </ul>
                </div>
            </td>
          <td width="50%" style="vertical-align:top;">
          	<div class="home_footer_box">
            <h1>系统属性</h1>
            <ul>
                <li><%=xtmc %>V1.02</li>
                
                <li>操作系统版本:<%=useros%></li>
                <li>浏览器类型:<%=userbrowser%>   </li>
                <li><a style="text-decoration:underline;color:blue;font-weight:bold;"href="/icocx/install_lodop.exe">打印控件下载</a>  </li>
            </ul>
            </div>
          </td>
        </tr>
      </table>



</div>
    <script type="text/javascript">
        function marquee(height, speed, delay) {
            var scrollT;
            var pause = false;
            var ScrollBox = document.getElementById("shangfan");
            if (document.getElementById("holder").offsetHeight <= height) return;
            var _tmp = ScrollBox.innerHTML.replace('holder', 'holder2')
            ScrollBox.innerHTML += _tmp;
            ScrollBox.onmouseover = function () {
                pause = true
            }
            ScrollBox.onmouseout = function () {
                pause = false
            }
            ScrollBox.scrollTop = 0;
            function start() {
                scrollT = setInterval(scrolling, speed);
                if (!pause) ScrollBox.scrollTop += 2;
            }

            function scrolling() {
                if (ScrollBox.scrollTop % height != 0) {
                    ScrollBox.scrollTop += 2;
                    if (ScrollBox.scrollTop >= ScrollBox.scrollHeight / 2) ScrollBox.scrollTop = 0;
                }
                else {
                    clearInterval(scrollT);
                    setTimeout(start, delay);
                }
            }

            setTimeout(start, delay);
        }
        marquee(24, 30, 3000);
    </script>

</body>
</html>
