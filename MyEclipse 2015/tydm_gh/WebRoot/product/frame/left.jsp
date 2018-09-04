<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.util.*" %>
<%@ page import="com.ninemax.jdbc.business.system.clsRightKeyBus" %>
<%@ page import="com.ninemax.jdbc.business.system.clsUserRightKeyBus" %>
<%@ page import="com.ninemax.jpa.system.model.Rightkey" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="com.ninemax.jpa.util.LinkEncrypt" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%

String name = request.getParameter("name");
String cursel = request.getParameter("cursel");
String userID = request.getParameter("userID");
String rightkeyID = request.getParameter("rightkeyID");
String num = request.getParameter("num");

    User user = (User)session.getAttribute("sysUser");
    String userName = user.getUserName();
    clsUserRightKeyBus userRightKeyBus = new clsUserRightKeyBus();
    clsRightKeyBus rightKeyBus = new clsRightKeyBus();
    List<Rightkey> rightKeys = rightKeyBus.ListFirstRight("0");
    //boolean isYwlc = InitSysParams.system.getIsYwlc();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>无标题文档</title>
    <link href="../css/css.css" rel="stylesheet" type="text/css" />
    <link href="/product/css/css.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link rel="stylesheet" id='skin' type="text/css"
          href="/product/jsp/frame/js/alert/skin/dmm-green/ymPrompt.css"/>
                  <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/tools.js"></script>
    <script type="text/javascript" src="/js/jgdmSearch.js"></script>
    <script type='text/javascript' src='/dwr/engine.js'></script>
    <script type='text/javascript' src='/dwr/util.js'></script>
    <script type='text/javascript' src='/dwr/interface/UserBus.js'></script>
    <script type="text/javascript" src="/dwr/interface/sysBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/spBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/jgdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/fzdmBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/kqnjBus.js"></script>
    <script type="text/javascript" src="/dwr/interface/codecheck.js"></script>
    <script type="text/javascript" src="/dwr/interface/czjlBus.js"></script>
    <style type='text/css'>
        html{ background:#ddf1fa;}
        .logincss ul li{
            height:25px;
            line-height:25px;
            padding-top:8px;
        }

    </style>
    <script type="text/javascript">

        function checkJgdmCode() {
            var jgdm=document.getElementById("status").value;
            dwr.engine.setAsync(false);
            var b = false;
            if(jgdm && jgdm.length==9 && /^[a-zA-Z0-9]*$/.test(jgdm)){
                codecheck.isCheckCode(jgdm.trim(), function (value) {
                    b = value;
                });
                if (!b) {
                  parent.control.alert("输入的机构代码不正确！");
                    return false;
                }else{
                    jgdmBus.checkJgdmStatus(jgdm.trim(), function (value){
                        parent.control.alert(value+"！");
                    });
                }
            }else{
                parent.control.alert("输入的机构代码不正确！");
            }

            return true;
        }
    </script>

    <script type="text/javascript">
    window.onload = function() {
    	setTab('<%=name%>',<%=cursel%>,<%=userID%>,<%=rightkeyID%>,<%=num%>)
    };
        function setTab(name,cursel,userID,rightkeyID,count){
            var userName = '<%=userName%>';
            var n = 0;
           dwr.engine.setAsync(false);
           // UserBus.getHasRightKeyNum(userID,rightkeyID,{callback:function(num){
 
                
           // }});

           // dwr.engine.setAsync(true);

            n = count;
            if(userName!='admin'){
                n = n-1;
            }

            $(".tabcon").attr("style","display:none");
            $("#"+"con_"+name+"_"+cursel).attr("style","display:block");
            


        }

        function showTabPage(name,currentTab,userID,rightkeyID)
        {
            var n = 0;
            dwr.engine.setAsync(false);
            UserBus.getHasRightKeyNum(userID,rightkeyID,{callback:function(num){
                n = num;
            }});
            dwr.engine.setAsync(true);
            for(i=1;i<=n;i++){
                //alert(n);
                var con=document.getElementById(name+i);
                con.style.display="none";
            }
            document.getElementById(currentTab).style.display="block";


        }

    </script>
</head>
<body style=" overflow-x:hidden; background:#ddf1fa;">

<div class="leftbg_al">
<div id="leftbg">
<div id="leftbg2">
    <div id="left_main">
        <!--用户 -->
        <div class="leftbg_al2">
            <div id="left_guest">

                <!--
                    <p class="guest_bg_hf"><iframe src="/product/frame/weather.jsp" frameborder="0" scrolling="no" width="130" height="80" allowTransparency="true" style="position: absolute; top: 12px; left: 10px"></iframe><br /><%=user.getUserChinesename() %></p>
                    <br />
                     
                    <div class="line"></div>-->
                <!--
                <div class="gust_menu">
                  <ul>
                    <li class="gust_menu_01 "><a href="../jsp/enterpriseinfomation/addinfomationcollection.jsp" title="采集" target="kunFrame"><img src="../images/zsds_r23_c8.gif" align="center" />&nbsp;采集</a></li>
                    <li class="gust_menu_02"><a href="../jsp/frame/list2_yingyongxiaoxi.jsp" title="消息" target="kunFrame"><img src="../images/zsds_r24_c15.gif" align="center" />&nbsp;消息</a></li>
                  <li class="gust_menu_03"><a href="../jsp/frame/list2_fkxxcl.jsp" title="反馈"  target="kunFrame"><img src="../images/zsds_r28_c8.png"/>反馈</a></li>
                  <li class="gust_menu_04"><a href="/action/taskAction?method=nationTaskList" title="任务" target="kunFrame"><img src="../images/zsds_r28_c15.png"/>任务</a></li>
                    <div class="clears"></div>
                    </ul>
                </div>
                 -->
            </div>
        </div>
        <!--功能 -->
        <div id="cs">

            <div class="Contentbox1" >

                <%
                    if(rightKeys!=null && rightKeys.size()>0){
                        int topNum = 1;
                        for (Rightkey _rightKeyTO : rightKeys) {
                           String _rightKeyId = _rightKeyTO.getRightkeyId();
                           /*
                            if (!isYwlc) {
                                if ("12".equals(_rightKeyId)) {
                                    continue;
                                }
                            }
                           */
                            if (userRightKeyBus.HasRight(String.valueOf(user.getUserId()), _rightKeyId)) { //如果有权限才显示
                %>
                <div class="tabcon" id="con_one_<%=topNum %>" <%
                    if ((topNum) != 1) {
                        out.print("style='display:none'");
                    }
                %>>

                    <%
                        List<Rightkey> twoRightKeys = rightKeyBus.ListFirstRight(_rightKeyId);
                        if (twoRightKeys != null && twoRightKeys.size() > 0) {
                            int userNum = 1;
                            for (Rightkey rightKeyTO : twoRightKeys) {
                                String rightKeyId = rightKeyTO.getRightkeyId();
                                String linkPage = rightKeyTO.getLinkpage();
                                String title = rightKeyTO.getRightkeyName();
                                if (clsStringTool.isEmpty(linkPage)) {
                                    linkPage = "";
                                }
                                if (userRightKeyBus.HasRight(String.valueOf(user.getUserId()), rightKeyId)) { //如果有权限才显示
                                    List<Rightkey> child_rightKeys = rightKeyBus.ListFirstRight(rightKeyId);//子类型
                                    if (child_rightKeys != null && child_rightKeys.size() > 0) {
                                        //有子节点
                    %>
                    <div class="titl_bg" id="div<%=_rightKeyId %><%=userNum %>"
                         onclick="showTabPage('divsub<%=_rightKeyId %>','divsub<%=_rightKeyId %><%=userNum %>','<%=String.valueOf(user.getUserId()) %>','<%=_rightKeyId %>')"
                         style="cursor:pointer; ">
                        <span><%=title %></span>
                    </div>
                    <div id="divsub<%=_rightKeyId %><%=userNum %>"
                            <%
                        if ((userNum) != 1) {
                            out.print("style='display:none;'");
                        }
                    %>
                         class="titlbg_al" >
                        <div class="titl">
                            <ul>
                                <%

                                    //循环子节点
                                    for (Rightkey child_rightKeyTO : child_rightKeys) {
                                        String child_rightKeyId = child_rightKeyTO.getRightkeyId();
                                        String child_linkPage = child_rightKeyTO.getLinkpage();
                                        String child_title = child_rightKeyTO.getRightkeyName();
                                        if (clsStringTool.isEmpty(child_linkPage)) {
                                            child_linkPage = "";
                                        }
                                        if (userRightKeyBus.HasRight(String.valueOf(user.getUserId()), child_rightKeyId)) { //如果有权限才显示

                                %>
                                <li><a href="../jsp/comm.jsp?q=<%=LinkEncrypt.encrypt(child_linkPage)%>"
                                       target="kunFrame"><%=child_title%>
                                </a></li>

                                <%
                                        }
                                    }
                                %>

                            </ul>
                        </div>
                    </div>
                    <%
                    } else {
                        //没有子节点

                    %>
                    <div class="titl_bg" id="div<%=_rightKeyId %><%=userNum %>" target="kunFrame"><a
                            href="../jsp/comm.jsp?q=<%=LinkEncrypt.encrypt(linkPage)%>"
                            target="kunFrame"><span><%=title %></span></a></div>
                    <div class="titlbg_al" id="divsub<%=_rightKeyId %><%=userNum %>" <%
                        if ((userNum) != 1) {
                            out.print("style='display:none;'");
                        }
                    %>>
                        <div class="titl">
                            <ul>
                            </ul>
                        </div>
                    </div>

                    <%

                                    }

                                    userNum++;
                                }
                            }

                        }%>


                </div>
                <%
                                topNum++;
                            }
                        }
                    } %>


            </div>
        </div>

    </div>
</div>
</div>
</div>
</body>
</html>
