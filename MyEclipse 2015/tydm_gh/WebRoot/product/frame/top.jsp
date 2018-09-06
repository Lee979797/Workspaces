<%@ page contentType="text/html; charset=gb2312"%>
<%@ page import="com.ninemax.jdbc.business.system.clsUserRightKeyBus"%>
<%@ page import="com.ninemax.jpa.system.model.User"%>
<%@ page import="com.ninemax.jpa.system.bo.UserBo"%>
<%@ page import="com.ninemax.jpa.global.InitSysParams"%>
<%@ page import="com.ninemax.jpa.system.model.Rightkey"%>
<%@ page import="com.ninemax.jdbc.business.system.clsRightKeyBus"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ninemax.jpa.util.CommonPropertiesUtil"%>
<%
	User ses_user = (User) session.getAttribute("sysUser");
    int user_id = ses_user.getUserId();
    UserBo userBo = new UserBo();
    User user = userBo.findById(user_id);
    
    String userName = user.getUserName();
    clsRightKeyBus rightKeyBus = new clsRightKeyBus();
    List<Rightkey> rightKeys = rightKeyBus.ListFirstRight("0");
    clsUserRightKeyBus userRightKeyBus = new clsUserRightKeyBus();
    //权限
    /**
     *权限说明
     *
     *  01010101 发证  01050101 换证 02010101 变更
     **/

    boolean canFz = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "01010101");
    boolean canHz = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "01050101");
    boolean canBg = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "02010101");
    boolean canNj = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "02010201");
    boolean canVz = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "02010301");
    boolean canDy = userRightKeyBus.HasRight(String.valueOf(user.getUserId()), "01060101");
    String xtmc=CommonPropertiesUtil.getValue("common.properties", "xtmc");
    if(xtmc.length()>17){
    	
        xtmc= xtmc.substring(0,15);
        }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>全国组织机构代码管理系统</title>
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src="/js/tools.js"></script>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript">
        <!--
        function MM_swapImgRestore() { //v3.0
            var i, x, a = document.MM_sr;
            for (i = 0; a && i < a.length && (x = a[i]) && x.oSrc; i++) x.src = x.oSrc;
        }
        function MM_preloadImages() { //v3.0
            var d = document;
            if (d.images) {
                if (!d.MM_p) d.MM_p = [];
                var i, j = d.MM_p.length, a = MM_preloadImages.arguments;
                for (i = 0; i < a.length; i++)
                    if (a[i].indexOf("#") != 0) {
                        d.MM_p[j] = new Image;
                        d.MM_p[j++].src = a[i];
                    }
            }
        }

        function MM_findObj(n, d) { //v4.01
            var p, i, x;
            if (!d) d = document;
            if ((p = n.indexOf("?")) > 0 && parent.frames.length) {
                d = parent.frames[n.substring(p + 1)].document;
                n = n.substring(0, p);
            }
            if (!(x = d[n]) && d.all) x = d.all[n];
            for (i = 0; !x && i < d.forms.length; i++) x = d.forms[i][n];
            for (i = 0; !x && d.layers && i < d.layers.length; i++) x = MM_findObj(n, d.layers[i].document);
            if (!x && d.getElementById) x = d.getElementById(n);
            return x;
        }

        function MM_swapImage() { //v3.0
            var i, j = 0, x, a = MM_swapImage.arguments;
            document.MM_sr = [];
            for (i = 0; i < (a.length - 2); i += 3)
                if ((x = MM_findObj(a[i])) != null) {
                    document.MM_sr[j++] = x;
                    if (!x.oSrc) x.oSrc = x.src;
                    x.src = a[i + 2];
                }
        }
        //-->
    </script>
<script type="text/javascript">

        var topSize = null;
        function changeStyle(topnum) {

            for (var i = 0; i < topSize; i++) {
                if (i == topnum) {
                    document.getElementById("top_" + i).className = "hei";
                } else {
                    document.getElementById("top_" + i).className = "";
                }
            }
        }

        function setTab(name,cursel,userID,rightkeyID){
        	$(".active").attr('class','');
        	$("#one_id"+cursel).addClass('active');

         	if(name != null && name != "" && name != "null"){
      		  window.open("/product/frame/left.jsp?name=" + name + "&cursel=" + cursel+ "&userID=" + userID+ "&rightkeyID=" + rightkeyID+"&num=" + <%=rightKeys.size()%>,"left","");
      		  //window.open("/product/welcome_ht.jsp","kunFrame","");
      		}else{
      			$(".active").attr('class','');
         	  $("#a1").addClass('active');
      		 window.open("/product/frame/left.html","left","");
      		 window.open("/product/welcome_ht.jsp","kunFrame","");
      		}
    		

            }
        
        function openthisWindow(num, id, title, rightUrl) {

            if (id != null && id != "" && id != "null") {
                window.open("left.jsp?parentId=" + id + "&parentName=" + title, "leftFrame", "");
                window.open("right.jsp?parentName=" + title, "kunFrame", "");
            } else {
                window.open("left.html", "leftFrame", "");
                window.open("right.jsp", "kunFrame", "");
            }

        }
        function changePwd(){
        	 window.parent.location.href = '../jsp/user/modPassword.jsp'
        }
        

        function logOut() {
            if (confirm("确认注销本系统？")) {
                //UtilBus.logout();
                window.parent.location.href = '/action/UserAction?method=exit';
                //先关闭框架页面， 再打开新的页面。
        		window.parent.location.href = 'http://'+window.location.host+"/product/real.jsp";
            }
        }
        function home() {
            window.parent.location.href = '/product/index.html';
        }
        function logOutToPortal() {
            if (confirm("确认退出本系统？")) {
                //UtilBus.logout();
                window.parent.location.href = '/action/UserAction?method=exit';
                //先关闭框架页面， 再打开新的页面。
                window.parent.location.href = 'http://' + window.location.host + "/";
            }
        }

        function test(){
        	//var ff=window.parent.window.document.getElementsByid("_left");
        	//var ff=document.getElementById('_left');
        	parent.left.a();
            }

    </script>

</head>

<body>
	<!-- 头部 -->
	<div id="head-top" style="width: auto">
		<div class="top_left">

			<h1>
				<a href="javascript:void(0);"><%=xtmc%></a>
			</h1>


		</div>

		<div class="top_right">
			<!-- 右侧退出 -->
			<div class="top_quit">
				<ul>
					<li><a href="#" onclick="changePwd();"><img
							src="../images/zhuxiao.png" /><br />密码修改</a></li>
					<li><a href="#" onclick="logOut();"><img
							src="../images/zhuxiao.png" alt="退出" /><br />退出</a></li>
				</ul>
			</div>
			<div class="top_menu">
				<ul>
					<%--<!-- <li><a href="../jsp/frame/right.jsp" target="kunFrame"><img src="../images/zsds_r5_c38.png" width="30" height="31" alt="首页" /><br />首页</a></li> -->
                <%if(canCj){%>
                <li><a href="../jsp/enterpriseinfomation/addinfomationcollection.jsp" target="kunFrame"><img src="../images/fazheng.png" alt="发证" /> 发证</a></li>
                <%}%>
                <%if(canGl){%>
                <li><a href="../jsp/enterpriseinfomation/enterprisemanagelist.jsp" target="kunFrame"><img src="../images/guanli.png" alt="管理" /> 管理</a></li>
                <%}%>
                <%if(canTj){%>
                <li><a href="../jsp/statistics/data.jsp" target="kunFrame"><img src="../images/zsds_r4_c57.png" alt="统计" /> 统计</a></li>
                <%}%>
                <%if(canFl){%>
                <li><a href="../jsp/products/productsList.jsp" target="kunFrame"><img src="../images/zsds_r4_c59.png" alt="分类" /> 分类</a></li>
                <%}%>
                <%if(canYh){%>
                <li><a href="../jsp/user/userList.jsp" target="kunFrame"><img src="../images/yonghu.png" alt="用户" /> 用户</a></li>
                <%}%>--%>

					<!-- <li><a href="../jsp/frame/right.jsp" target="kunFrame"><img src="../images/zsds_r5_c38.png" width="30" height="31" alt="首页" /><br />首页</a></li> -->

					<%
						if (canFz) {
					%>
					<li><a
						href="/product/jsp/certificate/addinfomationEnter.jsp?formType=0<%=InitSysParams.system.getIsGs() ? "&isGs=1" : ""%>"
						target="kunFrame"> <img src="../images/report_add.png"
							alt="新办" /><br />新办
					</a></li>
					<%
						}
					%>
					<%
						if (canDy) {
					%>
					<li style="width:55px;"><a
						href="/bsweb/certificatePrint_apply_info" target="kunFrame"><img
							src="../images/printer.png" alt="申请" /><br />申报表打印</a></li>
					<%
						}
					%>
					<%
						if (canHz) {
					%>
					<li><a href="/bsweb/certificate_certOperList"
						target="kunFrame"><img src="../images/report_edit.png"
							alt="换证" /><br />换证</a></li>
					<%
						}
					%>

					<%
						if (canBg) {
					%>
					<li><a href="/bsweb/business_list?source=update_no"
						target="kunFrame"><img src="../images/application_edit.png"
							alt="变更" /><br />变更</a></li>
					<%
						}
					%>

					<%
						if (canNj) {
					%>
					<li><a href="/bsweb/business_list?source=check"
						target="kunFrame"><img src="../images/report_magnify.png"
							alt="年检" /><br />年检</a></li>
					<%
						}
					%>
					<%
						if (canVz) {
					%>
					<li><a href="/bsweb/business_list?source=validate"
						target="kunFrame"><img src="../images/trash.png" alt="注销" /><br />注销</a></li>
					<%
						}
					%>



					<%
						if (canDy) {
					%>
					<li><a href="/bsweb/certificatePrint_list_no_print"
						target="kunFrame"><img src="../images/printer.png" alt="打印" /><br />打印</a></li>
					<%
						}
					%>

				</ul>
			</div>
			<!-- 菜单 -->
		</div>

		<!--用户信息-->
		<div class="top_user">

			<ul>
				<li><p>用户名：${sysUser.userName }</p></li>
				<li><p>赋码行政区划:${sysUser.zrxzqu }</p></li>
			</ul>
			<ul>
				<li><p>用户姓名：${sysUser.userChinesename }</p></li>
				<li><p>发证机关：${sysUser.printName }</p></li>
			</ul>
		</div>
		<!--用户信息 over-->


	</div>


	<div class="head_menu">
		<ul>
			<li><a
				href="javascript:setTab('','1','<%=String.valueOf(user.getUserId())%>','0');"
				id="a1" class="active">首页</a></li>
			<%
				if (rightKeys != null && rightKeys.size() > 0) {
					int topNum = 1;
					for (Rightkey rightKeyTO : rightKeys) {
						String rightKeyId = rightKeyTO.getRightkeyId();
						String level = rightKeyTO.getRightkeyDepth();
						String title = rightKeyTO.getRightkeyName();
						/*
						if (!isYwlc) {
						    if ("12".equals(rightKeyId)) {
						        continue;
						    }
						}
						 */
						int fKeyId = 0;
						if ("1".equals(level)) {
							if (userRightKeyBus.HasRight(
									String.valueOf(user.getUserId()), rightKeyId)) { //如果有权限才显示
								fKeyId = Integer.parseInt(rightKeyId);
								if (fKeyId < 20 || fKeyId == 30) {
			%>
			<li id="one<%=topNum%>" style="cursor:pointer"
				onclick="setTab('one',<%=topNum%>,'<%=String.valueOf(user.getUserId())%>','0');">
				<a id="one_id<%=topNum%>"
				<%if (title.length() > 2) {
									out.print("class='tabs_linheight'");
								}%>
				<%if (topNum == 1) {
									out.print("class=''");
								}%>
				href="#"> <%=title%>
			</a>
			</li>

			<%
				topNum++;
								}

							}

						}

					}
			%>

			<%
				}
			%>
		</ul>

	</div>
	<!-- 头部结束 -->

</body>
</html>
