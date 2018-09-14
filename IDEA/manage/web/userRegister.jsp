<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!--http://wsdj.baic.gov.cn/user/register.jsp-->
<html>
<head>
<title>全国组织机构代码中心网上办证服务系统 —— 用户注册</title>
<style type="text/css">
<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
		background-color: #FFFFFF;
	}
	.input1 {
		width: 150px;
	}
-->
</style>
<link href="css/main.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/JavaScript">
function changeStyle(elementID,toStyle) {
  document.getElementById(elementID).className=toStyle;
}

//检查移动电话格式
function checkMobileAction(obj,strmsg) {
	if(obj==null)return true;
	var mobile = obj.value;
	if (mobile=="") {
		alert("["+strmsg+"]不能为空！");
		return false;
	}
	if (isNaN(mobile)||mobile.length!=11){
		window.alert("["+strmsg+"]输入的格式不正确!");
		return false;
	}else{
	}
	return true;
}
//END

function mySubmit(){

	if (document.getElementById('fPassword').value!=document.getElementById('rPassword').value) {
		alert("两次密码输入不一致！");
		return;
	}
	//checkCard();
	form1.submit();
}

function checkCountry(){
	obj = document.getElementById("account.nation");
	obj2 = document.getElementById("account.idcardtype");
	if (obj.value!="156"){	//非中国
		obj2.options[2].selected = true;
		
	}
	else{
		obj2.options[1].selected = true;
	}

}

function checkIsChina(){
	//obj = document.getElementById("account.nation");
	//obj2 = document.getElementById("account.idcardtype");
	//if (obj.value=="156" && obj2.options[2].selected == true){	//中国
	//	obj2.options[1].selected = true;
	//	alert("国籍为中国，不能选择护照为证件类型！");
	//}else if(obj.value!="156") {
	//	alert("国籍不为中国，请选择护照为证件类型！");
	//	obj2.options[2].selected = true;
	//}
}

function checkCard(){
	obj2 = document.getElementById("account.idcardtype");
	obj3 = document.getElementById("account.idcardnum");
	//alert(obj2.value);
	if (obj2.value=="1"){	//身份证
		return isIdCard(obj3.value,"身份证号码");
	}
	return true;
}
function checkMobile(s){
	var patrn=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; 
	if (!patrn.exec(s)) {
		alert("邮件地址输入错误！");
	} 

}

function isUserName() {
	var s = document.getElementById("account.logonname").value;
	if(!isRegisterUserName(s)) {
	  alert("请输入6-16位由字母开头，字母和数字组成的的用户名");
	  return;
	}
}

 function isRegisterUserName(s)   
 {   
     var patrn=/^[a-zA-Z]{1}[a-zA-Z0-9]{5,15}$/;   
     if (!patrn.exec(s)) {
		alert("请输入6-16位由字母开头，字母和数字组成的的用户名");
		return false;
		}  
    return true;
 } 
 
 	function checkU(oCtl){
			var userName=oCtl.value;
			JUserChecker.check(userName,haolejiaowo);
	}
	
	function haolejiaowo(isExist){
			if(isExist==1){
			alert("hao");
			}
			else if(isExist==0){
			alert("error");
			}
		} 
		  
//核对用户名是否存在
function checkPeople(){
    var logonname=document.getElementById("account.logonname").value;
    
    if(logonname!=null && logonname.length>0&&isRegisterUserName(logonname))
    		DWRActionUtil.execute({namespace:'/account', action:'checkPeople', executeResult:'false'}, 'form1', checkPeopleCallBack);
  }
  
function checkPeopleCallBack(Action){
  	if(Action.msg!=null)
  	{
  		if(Action.msg_flag=="f") {
  	    changeStyle('s1','msg4');
  	    document.getElementById("s1").innerHTML = Action.msg;
  	    return;
  	    }else {
  	    		changeStyle('s1','msg3');
  	    		 document.getElementById("s1").innerHTML = Action.msg;
  	    return;
  	    }
  	}    	
 }
 function changeImage() {
	//window.location.reload(true);
	document.getElementById("imageId").src="regImages.jsp?t=" + (new Date());
}
</script>

<link href="css/flow.css" rel="stylesheet" type="text/css">
</head>

<body>
<center>
<div style="width:1000px; border-left:1px solid #cccccc; text-align:center;border-right:1px solid #cccccc">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="JavaScript" type="text/JavaScript" src="js/page.js"></script>
<link href="http://wsdj.baic.gov.cn:80/common/css/outweball.css" rel="stylesheet" type="text/css" />
<table width="1000" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="images/userRegister.jpg" alt="" width="1000" height="145" border="0" ></td>
  </tr>
  <tr>
    <td height="25" background="images/head_banner_bg.jpg">
    	<table width="100%" border="0" cellpadding="2" cellspacing="0">
	      <tr>
	        <td width="170" align="center"><script language="JavaScript">PageDate();</script></td>
	        <td align="right">| 
		        <a href="index.jsp">首页</a>  | 
		        <a href="javascript:window.showModalDialog('qa.htm',window,'dialogWidth:700px;dialogHeight:600px;center:yes;status:no;resizable:yes;help:no');">常见问题</a> |
		        下载中心 | 
	        <td width="10">&nbsp;</td>
	      </tr>
   	 </table>
    </td>
  </tr>
</table>
 
<h2>用户注册</h2>

<form name="form1" method="post" action="regUser.action"> 
<table width="700" cellpadding="3" cellspacing="1" align=center>
<tr>
	<td colspan="3" ><font color="red">请注意：以下均为必填项</font></td>
</tr></table>

<table width="700" align="center" cellpadding="3" cellspacing="1" align=center class="add_table">
<tr>
	<td colspan="3"  class="add_tr">登录信息：</td>
</tr>
  <tr>
    <td width="120" class="add_tdl" align="right">登录名</td>
    <td width="170" class="add_tdr"><input maxlength="16" id="userName" name="userName" value="" type="text" size="20" 
		onfocus="changeStyle('s1','msg2');"
		onblur="checkU(this);" class="input1"></td>
    <td class="add_tdr"><div id="s1" class="msg1" style="float:left">请使用英文字母和数字填写用户名，最多16个字符，如smith。</div></td>
  </tr>
     
  
  <tr>
    <td class="add_tdl" align="right">登录密码</td>
    <td class="add_tdr"><input id="fPassword" name="account.logonpassword" value="" type="password" size="20" class="input1"
		onFocus="changeStyle('s2','msg2');"
		onBlur="changeStyle('s2','msg1');checkPwStrong(value,$$('account.logonname'),1)">
      </td>
    <td class="add_tdr"><div id="s2" class="msg1" style="float:left">密码长度应为6-10位，更安全的方法是用0～9、a～z大小写字母和符号的混合使用。</div></td>
  </tr>
  
   
  <tr>
    <td class="add_tdl" align="right">确认密码</td>
    <td class="add_tdr"><input id="rPassword" name="rePassword" class="input1" type="password" size="20" maxlength="10"></td>
    <td class="add_tdr"><div id="s3" class="msg1" style="float:left"></div></td>
  </tr>

<!--
  <tr>
    <td class="add_tdl" align="right">彩色认证码</td>
    <td class="add_tdr">
    	<img id = "imageId" src="regImages.jsp" align="absmiddle" onclick="changeImage()" style="cursor:pointer;"  title="看不清楚，换一个"/>
    	<input name="validateStr" type="text" size="8" 
		onfocus="changeStyle('s10','msg2');"
		onblur="changeStyle('s10','msg1');" ></td>
    <td class="add_tdr"><div id="s10" class="msg1" style="float:left">请输入彩色认证码！</div></td>
  </tr>  
  
  
  <tr>
    <td colspan="3" class="add_tr">用户基本信息</td> 
    </tr>
  <tr>
    <td class="add_tdl" align="right">姓　　名</td>
    <td class="add_tdr"><input name="account.username" class="input1" value="" type="text" size="20"
		onfocus="changeStyle('s6','msg2');"
		onblur="changeStyle('s6','msg1');" ></td>
    <td class="add_tdr"><div id="s6" class="msg1" style="float:left">请注意：姓名与今后的登记申请相关，此人即为今后的登记申请人，必须填写真实姓名，否则无法完成申报手续。</div></td>
  </tr>

 

  <tr>
    <td class="add_tdl" align="right">性　　别</td>
    <td class="add_tdr"><select id="account.gender" name="account.gender" class="input1" ><option value=''>请选择</option ><option id="0" value="1" >男</option ><option id="1" value="2" >女</option ></select>
    </td>
    <td class="add_tdr">&nbsp;</td>
  </tr>

 

  <tr>
    <td class="add_tdl" align="right">Email</td>
    <td class="add_tdr"><input id="account.email" class="input1" name="account.email" value="" type="text" size="20"
		onfocus="changeStyle('s20','msg2');"
		onblur="changeStyle('s20','msg1');" ></td>
    <td class="add_tdr"><div id="s20" class="msg1" style="float:left">请输入真实有效的邮箱地址，您可能需要此邮箱找回您的密码。</div></td>
  </tr>
  <tr>
    <td class="add_tdl" align="right">联系地址</td>
    <td class="add_tdr" colspan="2"><input name="account.address" value="" type="text" size="50"></td>
    
  </tr>
<tr>
    <td class="add_tdl" align="right">联系电话</td>
    <td class="add_tdr"><input name="account.tel" class="input1" value="" type="text" size="20"
		onfocus="changeStyle('s40','msg2');"
		onblur="changeStyle('s40','msg1');" ></td>
    <td class="add_tdr"><div id="s40" class="msg1" style="float:left">您必须提供至少一个电话号码。电话号码仅允许输入数字，范例：01066692008 或 139******** </div></td>
    
  </tr>
  <tr>
    <td class="add_tdl" align="right">移动电话</td>
    <td class="add_tdr" colspan="2">
    <input name="account.mobile" type="text" value="" maxlength="11"/>
    
    </td>
  </tr>
  
  <tr>
    <td class="add_tdl" align="right">邮政编码</td>
    <td class="add_tdr"><input name="account.postalcode" value="" type="text" maxlength="6" size="20"></td>
    <td class="add_tdr">&nbsp;</td>
  </tr>

  <tr>
    <td class="add_tdl" align="right">国别（地区）</td>
    <td class="add_tdr" style="width:220px"><select id="account.nation" name="account.nation" onchange="checkCountry();" ><option value=''>请选择</option ><option id="0" value="8" >阿尔巴尼亚</option ><option id="1" value="12" >阿尔及利亚</option ><option id="2" value="4" >阿富汗</option ><option id="3" value="32" >阿根廷</option ><option id="4" value="784" >阿联酋</option ><option id="5" value="533" >阿鲁巴</option ><option id="6" value="512" >阿曼</option ><option id="7" value="31" >阿塞拜疆</option ><option id="8" value="818" >埃及</option ><option id="9" value="231" >埃塞俄比亚</option ><option id="10" value="372" >爱尔兰</option ><option id="11" value="233" >爱沙尼亚</option ><option id="12" value="20" >安道尔</option ><option id="13" value="24" >安哥拉</option ><option id="14" value="660" >安圭拉</option ><option id="15" value="28" >安提瓜和巴布达</option ><option id="16" value="40" >奥地利</option ><option id="17" value="36" >澳大利亚</option ><option id="18" value="52" >巴巴多斯</option ><option id="19" value="598" >巴布亚新几内亚</option ><option id="20" value="44" >巴哈马</option ><option id="21" value="586" >巴基斯坦</option ><option id="22" value="600" >巴拉圭</option ><option id="23" value="374" >巴勒斯坦</option ><option id="24" value="48" >巴林</option ><option id="25" value="591" >巴拿马</option ><option id="26" value="76" >巴西</option ><option id="27" value="112" >白俄罗斯</option ><option id="28" value="60" >百慕大</option ><option id="29" value="100" >保加利亚</option ><option id="30" value="580" >北马里亚纳</option ><option id="31" value="994" >北美洲其它国家</option ><option id="32" value="585" >贝劳</option ><option id="33" value="204" >贝宁</option ><option id="34" value="56" >比利时</option ><option id="35" value="352" >冰岛</option ><option id="36" value="68" >玻利维亚</option ><option id="37" value="630" >波多黎各</option ><option id="38" value="616" >波兰</option ><option id="39" value="70" >波斯尼亚和黑塞哥维那</option ><option id="40" value="72" >博茨瓦纳</option ><option id="41" value="908" >博内尔</option ><option id="42" value="84" >伯利兹</option ><option id="43" value="64" >不丹</option ><option id="44" value="854" >布基纳法索</option ><option id="45" value="108" >布隆迪</option ><option id="46" value="74" >布维岛</option ><option id="47" value="408" >朝鲜</option ><option id="48" value="226" >赤道几内亚</option ><option id="49" value="996" >大洋洲其它国家</option ><option id="50" value="208" >丹麦</option ><option id="51" value="276" >德国</option ><option id="52" value="626" >东帝汶</option ><option id="53" value="768" >多哥</option ><option id="54" value="214" >多米尼加共和国</option ><option id="55" value="212" >多米尼克</option ><option id="56" value="643" >俄罗斯</option ><option id="57" value="218" >厄瓜多尔</option ><option id="58" value="232" >厄立特里亚</option ><option id="59" value="250" >法国</option ><option id="60" value="234" >法罗群岛</option ><option id="61" value="258" >法属波利尼西亚</option ><option id="62" value="254" >法属圭亚那</option ><option id="63" value="260" >法属南部领土</option ><option id="64" value="608" >菲律宾</option ><option id="65" value="993" >非洲其它国家</option ><option id="66" value="246" >芬兰</option ><option id="67" value="132" >佛得角</option ><option id="68" value="912" >盖比群岛</option ><option id="69" value="270" >冈比亚</option ><option id="70" value="178" >刚果</option ><option id="71" value="906" >刚果民主共和国</option ><option id="72" value="170" >哥伦比亚</option ><option id="73" value="188" >哥斯达黎加</option ><option id="74" value="308" >格林纳达</option ><option id="75" value="304" >格陵兰</option ><option id="76" value="268" >格鲁吉亚</option ><option id="77" value="192" >古巴</option ><option id="78" value="312" >瓜德罗普</option ><option id="79" value="316" >关岛</option ><option id="80" value="328" >圭亚那</option ><option id="81" value="398" >哈萨克斯坦</option ><option id="82" value="332" >海地</option ><option id="83" value="410" >韩国</option ><option id="84" value="528" >荷兰</option ><option id="85" value="530" >荷属安的列斯</option ><option id="86" value="334" >赫德岛和麦克唐纳岛</option ><option id="87" value="340" >洪都拉斯</option ><option id="88" value="296" >基里巴斯</option ><option id="89" value="262" >吉布提</option ><option id="90" value="417" >吉尔吉斯斯坦</option ><option id="91" value="324" >几内亚</option ><option id="92" value="624" >几内亚比绍</option ><option id="93" value="124" >加拿大</option ><option id="94" value="288" >加纳</option ><option id="95" value="266" >加蓬</option ><option id="96" value="116" >柬埔寨</option ><option id="97" value="203" >捷克</option ><option id="98" value="716" >津巴布韦</option ><option id="99" value="120" >喀麦隆</option ><option id="100" value="634" >卡塔尔</option ><option id="101" value="136" >开曼群岛</option ><option id="102" value="166" >科科斯（基林）群岛</option ><option id="103" value="174" >科摩罗</option ><option id="104" value="384" >科特迪瓦</option ><option id="105" value="414" >科威特</option ><option id="106" value="191" >克罗地亚</option ><option id="107" value="404" >肯尼亚</option ><option id="108" value="184" >库克群岛</option ><option id="109" value="909" >库腊索岛</option ><option id="110" value="428" >拉脱维亚</option ><option id="111" value="426" >莱索托</option ><option id="112" value="418" >老挝</option ><option id="113" value="422" >黎巴嫩</option ><option id="114" value="430" >利比里亚</option ><option id="115" value="434" >利比亚</option ><option id="116" value="440" >立陶宛</option ><option id="117" value="438" >列支敦士登</option ><option id="118" value="638" >留尼汪</option ><option id="119" value="442" >卢森堡</option ><option id="120" value="646" >卢旺达</option ><option id="121" value="642" >罗马尼亚</option ><option id="122" value="450" >马达加斯加</option ><option id="123" value="470" >马耳他</option ><option id="124" value="462" >马尔代夫</option ><option id="125" value="238" >马尔维纳斯群岛（福克兰群岛）</option ><option id="126" value="913" >马克萨斯群岛</option ><option id="127" value="454" >马拉维</option ><option id="128" value="458" >马来西亚</option ><option id="129" value="466" >马里</option ><option id="130" value="807" >马其顿</option ><option id="131" value="584" >马绍尔群岛</option ><option id="132" value="474" >马提尼克</option ><option id="133" value="175" >马约特</option ><option id="134" value="480" >毛里求斯</option ><option id="135" value="478" >毛里塔尼亚</option ><option id="136" value="907" >梅利利亚</option ><option id="137" value="840" >美国</option ><option id="138" value="16" >美属萨摩亚</option ><option id="139" value="581" >美属太平洋各群岛</option ><option id="140" value="850" >美属维尔京群岛</option ><option id="141" value="496" >蒙古</option ><option id="142" value="500" >蒙特塞拉特</option ><option id="143" value="50" >孟加拉国</option ><option id="144" value="604" >秘鲁</option ><option id="145" value="583" >密克罗尼西亚</option ><option id="146" value="104" >缅甸</option ><option id="147" value="498" >摩尔多瓦</option ><option id="148" value="504" >摩洛哥</option ><option id="149" value="492" >摩纳哥</option ><option id="150" value="508" >莫桑比克</option ><option id="151" value="484" >墨西哥</option ><option id="152" value="516" >纳米比亚</option ><option id="153" value="710" >南非</option ><option id="154" value="10" >南极洲</option ><option id="155" value="995" >南美洲其它国家</option ><option id="156" value="239" >南乔治亚岛和南桑德韦奇岛</option ><option id="157" value="891" >南斯拉夫</option ><option id="158" value="524" >尼泊尔</option ><option id="159" value="558" >尼加拉瓜</option ><option id="160" value="562" >尼日尔</option ><option id="161" value="566" >尼日利亚</option ><option id="162" value="570" >纽埃</option ><option id="163" value="578" >挪威</option ><option id="164" value="574" >诺福克岛</option ><option id="165" value="992" >欧洲其它国家</option ><option id="166" value="612" >皮特凯恩群岛</option ><option id="167" value="620" >葡萄牙</option ><option id="168" value="392" >日本</option ><option id="169" value="752" >瑞典</option ><option id="170" value="756" >瑞士</option ><option id="171" value="910" >萨巴</option ><option id="172" value="222" >萨尔瓦多</option ><option id="173" value="882" >萨摩亚</option ><option id="174" value="905" >塞卜太（休达）</option ><option id="175" value="892" >塞尔维亚与黑山共和国</option ><option id="176" value="694" >塞拉利昂</option ><option id="177" value="686" >塞内加尔</option ><option id="178" value="196" >塞浦路斯</option ><option id="179" value="690" >塞舌尔</option ><option id="180" value="682" >沙特阿拉伯</option ><option id="181" value="914" >社会群岛</option ><option id="182" value="162" >圣诞岛</option ><option id="183" value="678" >圣多美和普林西比</option ><option id="184" value="654" >圣赫勒拿</option ><option id="185" value="659" >圣基茨和尼维斯</option ><option id="186" value="662" >圣卢西亚</option ><option id="187" value="911" >圣马丁岛</option ><option id="188" value="674" >圣马力诺</option ><option id="189" value="666" >圣皮埃尔和密克隆</option ><option id="190" value="670" >圣文森特和格林纳丁斯</option ><option id="191" value="144" >斯里兰卡</option ><option id="192" value="703" >斯洛伐克</option ><option id="193" value="705" >斯洛文尼亚</option ><option id="194" value="744" >斯瓦尔巴群岛</option ><option id="195" value="748" >斯威士兰</option ><option id="196" value="736" >苏丹</option ><option id="197" value="740" >苏里南</option ><option id="198" value="706" >索马里</option ><option id="199" value="90" >所罗门群岛</option ><option id="200" value="762" >塔吉克斯坦</option ><option id="201" value="764" >泰国</option ><option id="202" value="834" >坦桑尼亚</option ><option id="203" value="776" >汤加</option ><option id="204" value="796" >特克斯和凯科斯群岛</option ><option id="205" value="780" >特立尼达和多巴哥</option ><option id="206" value="788" >突尼斯</option ><option id="207" value="798" >图瓦卢</option ><option id="208" value="915" >土阿莫土群岛</option ><option id="209" value="916" >土布艾群岛</option ><option id="210" value="792" >土耳其</option ><option id="211" value="795" >土库曼斯坦</option ><option id="212" value="772" >托克劳</option ><option id="213" value="876" >瓦利斯和富图纳群岛</option ><option id="214" value="548" >瓦努阿图</option ><option id="215" value="320" >危地马拉</option ><option id="216" value="862" >委内瑞拉</option ><option id="217" value="96" >文莱</option ><option id="218" value="800" >乌干达</option ><option id="219" value="804" >乌克兰</option ><option id="220" value="858" >乌拉圭</option ><option id="221" value="860" >乌兹别克斯坦</option ><option id="222" value="724" >西班牙</option ><option id="223" value="732" >西撤哈拉</option ><option id="224" value="904" >西纳加</option ><option id="225" value="300" >希腊</option ><option id="226" value="997" >象牙海岸</option ><option id="227" value="702" >新加坡</option ><option id="228" value="540" >新喀里多尼亚</option ><option id="229" value="554" >新西兰</option ><option id="230" value="348" >匈牙利</option ><option id="231" value="760" >叙利亚</option ><option id="232" value="388" >牙买加</option ><option id="233" value="51" >亚美尼亚</option ><option id="234" value="991" >亚洲其它国家</option ><option id="235" value="887" >也门</option ><option id="236" value="368" >伊拉克</option ><option id="237" value="364" >伊朗</option ><option id="238" value="376" >以色列</option ><option id="239" value="380" >意大利</option ><option id="240" value="356" >印度</option ><option id="241" value="360" >印度尼西亚</option ><option id="242" value="826" >英国</option ><option id="243" value="92" >英属维尔京群岛</option ><option id="244" value="86" >英属印度洋领土</option ><option id="245" value="400" >约旦</option ><option id="246" value="704" >越南</option ><option id="247" value="894" >赞比亚</option ><option id="248" value="180" >扎伊尔</option ><option id="249" value="148" >乍得</option ><option id="250" value="292" >直布罗陀</option ><option id="251" value="152" >智利</option ><option id="252" value="140" >中非</option ><option id="253" value="156" >中国</option ><option id="254" value="446" >中国（澳门）</option ><option id="255" value="158" >中国（台湾）</option ><option id="256" value="344" >中国（香港）</option ><option id="257" value="520" >瑙鲁</option ><option id="258" value="336" >梵蒂冈</option ><option id="259" value="242" >斐济</option ></select>
</td>
    <td class="add_tdr">&nbsp;</td>
  </tr>
  <tr>
    <td class="add_tdl" align="right">证件类型</td>
    <td class="add_tdr"><select id="account.idcardtype" name="account.idcardtype" onchange="javascript:checkIsChina();" class="input1" ><option value=''>请选择</option ><option id="0" value="1" >居民身份证</option ><option id="1" value="2" >军官证</option ><option id="2" value="3" >中华人民共和国警官证</option ><option id="3" value="4" >护照</option ><option id="4" value="5" >军人离(退)休证</option ><option id="5" value="9" >其他</option ></select>
</td>
    <td class="add_tdr">&nbsp;</td>
  </tr>

 

  <tr>
    <td class="add_tdl" align="right">证件号码</td>
    <td class="add_tdr"><input id="account.idcardnum" class="input1" name="account.idcardnum" value="" type="text" size="20"		
    	onfocus="changeStyle('s30','msg2');"
		onblur="changeStyle('s30','msg1');checkCard();" ></td>
    <td class="add_tdr"><div id="s30" class="msg1" style="float:left">身份证号码应为15或18位，军官证需输入文字和数字部分，例如：空字第1234567。</div></td>
  </tr>

 
<input type="hidden" name="account.ca" value="0">
<input type="hidden" name="account.usertype" value="0">
 -->   
</table>

<table height="35"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <!--上一步 -->

    <td align="center"><input name="Submit22" onClick="mySubmit();" type="button"  class="ButtonCss" value="确 定">

      &nbsp; </td>
    <td align="center">&nbsp;
        <input name="Submit22" type="reset"  class="ButtonCss" value="重 置">
      &nbsp; </td>
  </tr>
  
</table>
</form>

<style type="text/css">
<!--
.STYLE3 {color: #999999}
-->
</style>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td  align="center" background="images/index_11.jpg">
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr>
		    <td align="center">
			    <span style="color: #FFFFFF;">建议使用IE6.0及以上版本, 分辨率1024x768.</span>
		    </td>
	  </tr>
	  <tr>
	        <td align="center"><span style="color: #FFFFFF;">紫光软件&nbsp;&nbsp;&nbsp;&nbsp;版权所有
	         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	       </span></td>
	  </tr>
	 </table>
	</td>
  </tr>
</table>
</div>
</center>
<script>
	//var jsnation = 156;//中国
	//setSelect($("account.nation"),jsnation);
	//checkCountry();
</script>
	
</body>
</html>
