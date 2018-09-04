<%@ page contentType="text/html; charset=GBK" %>
<%
    String currentPage = request.getRequestURI();
    if (request.getQueryString() != null) {
        currentPage = currentPage + "?" + request.getQueryString();
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
<title>home</title>
<link href="../../css/css.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
<link rel="stylesheet" id='skin' type="text/css" href="../frame/js/alert/skin/dmm-green/ymPrompt.css"/>
<link href="../css/Blue_css.css" rel="stylesheet" type="text/css"/>
<script type='text/javascript' src='/dwr/interface/UserGroupBo.js'></script>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript' src="/js/tools.js"></script>
<script type='text/javascript' src='<%=request.getContextPath() %>/product/js/judge.js'></script>
<%--<script type='text/javascript' src='js/advance.js'></script>--%>
<script language="javascript">
var midText;
var midValues;
var bigQhArr;
var midQhDepthArr;
var firstSelect = 0;
var jjhyMidText;
var jjhySmlText;
var jjhySmlText1;
var jjhyMidValues;
var jjhySmlValues;
var jjhySmlValues1;
var firstSelJjhy = 0;
var frlxCodeArr, frlxNameArr, jjlxCodeArr, jjlxNameArr, gjlxCodeArr, gjlxNameArr;
var firstSelCon = 0;


function MM_openBrWindow(theURL, winName, features) {
    window.open(theURL, winName, features);
}

function setcode() {

    document.form1.select0.options.length = 0;
    var strCondi = ":!=:like:&gt;:&gt;=:=:&lt;=:";
    var conditions = strCondi.split(":");
    var index = 0;

    switch (document.form1.select1.value) {
        case '000000':
            document.form1.tit.disabled = true;
            document.form1.select2.disabled = true;
            break;
        case 'jgdm' :
            for (var i = 0; i < conditions.length - 1; i++) {
                if (conditions[i] == "=") {
                    document.form1.select0.options.add(new Option("=(等于)", "="));//此方法支持 w3c，firefox上无恙
                    /*document.form1.select0.add(document.createElement("OPTION"));
                     document.form1.select0.options[index].text="=(等于)";
                     document.form1.select0.options[index].value="=";*/
                    index++;
                }
                if (conditions[i] == "!=") {
                    document.form1.select0.options.add(new Option("!=(不等于)", "!="));//此方法支持 w3c，firefox上无恙
                    /*document.form1.select0.add(document.createElement("OPTION"));
                     document.form1.select0.options[index].text="!=(不等于)";
                     document.form1.select0.options[index].value="!=";*/
                    index++;
                }
            }

            document.form1.tit.disabled = false;
            document.form1.select2.disabled = true;

            break;
        case 'jgmc':
        case 'cpmc':
        case 'cpmcgjz':
        case 'zxbzbh':
        case 'zxbzmc':
        case 'cpcym':
        case 'cpywmc':
        case 'cpxh':
        case 'cpgg':
        case 'cpxkzh':
        case '3crzh':
        case 'qsrzh':
            for (var i = 0; i < conditions.length - 1; i++) {
                //alert(conditions);
                if (conditions[i] == "=") {
                    document.form1.select0.options.add(new Option("=(等于)", "="));//此方法支持 w3c，firefox上无恙
                    /*document.form1.select0.add(document.createElement("OPTION"));
                     document.form1.select0.options[index].text="=(等于)";
                     document.form1.select0.options[index].value="=";*/
                    index++;
                }
                if (conditions[i] == "!=") {
                    document.form1.select0.options.add(new Option("!=(不等于)", "!="));//此方法支持 w3c，firefox上无恙
                    /*document.form1.select0.add(document.createElement("OPTION"));
                     document.form1.select0.options[index].text="!=(不等于)";
                     document.form1.select0.options[index].value="!=";*/
                    index++;
                }
                if (conditions[i] == "like") {
                    document.form1.select0.options.add(new Option("like(包含)", "like"));//此方法支持 w3c，firefox上无恙
                    /*
                     document.form1.select0.add(document.createElement("OPTION"));
                     document.form1.select0.options[index].text="like(包含)";
                     document.form1.select0.options[index].value="like";*/
                    index++;
                }
//              if(conditions[i]=="not like"){
//				   document.form1.select0.options.add(new Option("!like(不包含)", "!like"));//此方法支持 w3c，firefox上无恙
//                /*
//                document.form1.select0.add(document.createElement("OPTION"));
//                document.form1.select0.options[index].text="!like(不包含)";
//                document.form1.select0.options[index].value="!like";*/
//                index++;
//              }

            }
            document.form1.tit.disabled = false;
            document.form1.select2.disabled = true;
            break;


    }

    document.form1.select0.selectedIndex = 0;
}

function addCondition() {
    var strselect1 = document.form1.select1.value;
    var strselect0 = document.form1.select0.value;
    var strtit = document.form1.tit.value;
    var strSelect2 = document.form1.select2.value;

    if (strselect1 == "000000" || strselect1.length == 0) {
        ymPrompt.alert({message:'请选择查询条件！', width:330, height:220, title:'提示信息'});
        return;
    }

    if (document.form1.tit.disabled == false) {
        if (strtit.length == 0) {
            //alert("请输入查询词！");
            ymPrompt.alert({message:'请输入查询词！', width:330, height:220, title:'提示信息'});
            return;
        }
        if (strtit.toUpperCase() == 'NULL') {
            ymPrompt.alert({message:'请输入正确的查询值！', width:330, height:220, title:'提示信息'});
            return;
        }
        if (Trim(strtit) == '') {
            ymPrompt.alert({message:'请输入非空的查询值！', width:330, height:220, title:'提示信息'});
            return;
        }
    } else {
        if (strSelect2.length == 0) {
            //alert("请选择查询值！");
            ymPrompt.alert({message:'请选择查询值！', width:330, height:220, title:'提示信息'});
            return;
        }
        strtit = strSelect2;
    }

    var strtitDisplay = strtit;


    var strdisplay = document.form1.display.value;

    var strhidevalue = "";
    var strtp0 = "";
    var strtp1 = "";

    switch (strselect1) {
        case 'jgdm' :
            var Special_chars = "~!@#$%^&*()_+`-={}|\":>?<,./;'[]\\";
            for (i = 0; i < strtit.length; i++) {
                if (Special_chars.indexOf(strtit.charAt(i)) != -1) {
                    //alert("请去除非法字符! ("+ strtit.charAt(i)+" )");
                    ymPrompt.alert({message:'请去除非法字符! ', width:330, height:220, title:'提示信息'});
                    document.form1.tit.focus();
                    return false;
                }
            }
            strtp0 = "机构代码";
            break;

        case 'jgmc':
            var Special_chars = "~!@#$%^&+`=|\":>?<'\\";
            for (i = 0; i < strtit.length; i++) {
                if (Special_chars.indexOf(strtit.charAt(i)) != -1) {
                    //alert("请去除非法字符! ("+ strtit.charAt(i)+" )");
                    ymPrompt.alert({message:'请去除非法字符! ', width:330, height:220, title:'提示信息'});
                    document.form1.tit.focus();
                    return false;
                }
            }
            strtp0 = "机构名称";
            break;
        case 'cpmc':
            var Special_chars = "~!@#$%^&+`=|\":>?<'\\";
            for (i = 0; i < strtit.length; i++) {
                if (Special_chars.indexOf(strtit.charAt(i)) != -1) {
                    //alert("请去除非法字符! ("+ strtit.charAt(i)+" )");
                    ymPrompt.alert({message:'请去除非法字符! ', width:330, height:220, title:'提示信息'});
                    document.form1.tit.focus();
                    return false;
                }
            }
            strtp0 = "产品名称";
            break;
        case 'cpmcgjz':
            var Special_chars = "~!@#$%^&+`=|\":>?<'\\";
            for (i = 0; i < strtit.length; i++) {
                if (Special_chars.indexOf(strtit.charAt(i)) != -1) {
                    //alert("请去除非法字符! ("+ strtit.charAt(i)+" )");
                    ymPrompt.alert({message:'请去除非法字符! ', width:330, height:220, title:'提示信息'});
                    document.form1.tit.focus();
                    return false;
                }
            }
            strtp0 = "产品关键字";
            break;
        case 'zxbzbh':
            var Special_chars = "~!@#$%^&+`=|\":>?<'\\";
            for (i = 0; i < strtit.length; i++) {
                if (Special_chars.indexOf(strtit.charAt(i)) != -1) {
                    //alert("请去除非法字符! ("+ strtit.charAt(i)+" )");
                    ymPrompt.alert({message:'请去除非法字符! ', width:330, height:220, title:'提示信息'});
                    document.form1.tit.focus();
                    return false;
                }
            }
            strtp0 = "执行标准编号";
            break;
        case 'zxbzmc':
            var Special_chars = "~!@#$%^&+`=|\":>?<'\\";
            for (i = 0; i < strtit.length; i++) {
                if (Special_chars.indexOf(strtit.charAt(i)) != -1) {
                    //alert("请去除非法字符! ("+ strtit.charAt(i)+" )");
                    ymPrompt.alert({message:'请去除非法字符! ', width:330, height:220, title:'提示信息'});
                    document.form1.tit.focus();
                    return false;
                }
            }
            strtp0 = "执行标准名称";
            break;
        case 'cpcym':
            var Special_chars = "~!@#$%^&+`=|\":>?<'\\";
            for (i = 0; i < strtit.length; i++) {
                if (Special_chars.indexOf(strtit.charAt(i)) != -1) {
                    //alert("请去除非法字符! ("+ strtit.charAt(i)+" )");
                    ymPrompt.alert({message:'请去除非法字符! ', width:330, height:220, title:'提示信息'});
                    document.form1.tit.focus();
                    return false;
                }
            }
            strtp0 = "产品常用名";
            break;
        case 'cpywmc':
            var Special_chars = "~!@#$%^&+`=|\":>?<'\\";
            for (i = 0; i < strtit.length; i++) {
                if (Special_chars.indexOf(strtit.charAt(i)) != -1) {
                    //alert("请去除非法字符! ("+ strtit.charAt(i)+" )");
                    ymPrompt.alert({message:'请去除非法字符! ', width:330, height:220, title:'提示信息'});
                    document.form1.tit.focus();
                    return false;
                }
            }
            strtp0 = "产品英文名";
            break;
        case 'cpxh':
            var Special_chars = "~!@#$%^&+`=|\":>?<'\\";
            for (i = 0; i < strtit.length; i++) {
                if (Special_chars.indexOf(strtit.charAt(i)) != -1) {
                    //alert("请去除非法字符! ("+ strtit.charAt(i)+" )");
                    ymPrompt.alert({message:'请去除非法字符! ', width:330, height:220, title:'提示信息'});
                    document.form1.tit.focus();
                    return false;
                }
            }
            strtp0 = "产品型号";
            break;
        case 'cpgg':
            var Special_chars = "~!@#$%^&+`=|\":>?<'\\";
            for (i = 0; i < strtit.length; i++) {
                if (Special_chars.indexOf(strtit.charAt(i)) != -1) {
                    //alert("请去除非法字符! ("+ strtit.charAt(i)+" )");
                    ymPrompt.alert({message:'请去除非法字符! ', width:330, height:220, title:'提示信息'});
                    document.form1.tit.focus();
                    return false;
                }
            }
            strtp0 = "产品规格";
            break;
        case 'cpxkzh':
            var Special_chars = "~!@#$%^&+`=|\":>?<'\\";
            for (i = 0; i < strtit.length; i++) {
                if (Special_chars.indexOf(strtit.charAt(i)) != -1) {
                    //alert("请去除非法字符! ("+ strtit.charAt(i)+" )");
                    ymPrompt.alert({message:'请去除非法字符! ', width:330, height:220, title:'提示信息'});
                    document.form1.tit.focus();
                    return false;
                }
            }
            strtp0 = "生产许可证号";
            break;
        case 'thcrzh':
            var Special_chars = "~!@#$%^&+`=|\":>?<'\\";
            for (i = 0; i < strtit.length; i++) {
                if (Special_chars.indexOf(strtit.charAt(i)) != -1) {
                    //alert("请去除非法字符! ("+ strtit.charAt(i)+" )");
                    ymPrompt.alert({message:'请去除非法字符! ', width:330, height:220, title:'提示信息'});
                    document.form1.tit.focus();
                    return false;
                }
            }
            strtp0 = "3C认证号";
            break;
        case 'qsrzh':
            var Special_chars = "~!@#$%^&+`=|\":>?<'\\";
            for (i = 0; i < strtit.length; i++) {
                if (Special_chars.indexOf(strtit.charAt(i)) != -1) {
                    //alert("请去除非法字符! ("+ strtit.charAt(i)+" )");
                    ymPrompt.alert({message:'请去除非法字符! ', width:330, height:220, title:'提示信息'});
                    document.form1.tit.focus();
                    return false;
                }
            }
            strtp0 = "QS认证号";
            break;


    }


    if (strdisplay.length > 0) {
        if (strselect0 == "=") {
            //if((strselect1=="pwrq")||(strselect1=="njrq")||(strselect1=="bzrq")||(strselect1=="zfrq")||(strselect1=="zcrq")||(strselect1=="njqx")||(strselect1=="zczj")||(strselect1=="zgrs")){
            if (false) {
                strhidevalue = strhidevalue + strselect1 + "=" + "" + strtit + "";
                strdisplay = strdisplay + strtp0 + "=" + "" + strtitDisplay + "";
            } else {
                strhidevalue = strhidevalue + strselect1 + "=" + "'" + strtit + "'";
                strdisplay = strdisplay + strtp0 + " 等于 " + "'" + strtitDisplay + "'";
            }
        } else if (strselect0 == "!=") {
            //if((strselect1=="pwrq")||(strselect1=="njrq")||(strselect1=="bzrq")||(strselect1=="zfrq")||(strselect1=="zcrq")||(strselect1=="njqx")||(strselect1=="zczj")||(strselect1=="zgrs")){
            if (false) {
                strhidevalue = strhidevalue + " not " + strselect1 + "=" + strtit + "";
                strdisplay = strdisplay + strtp0 + "!=" + strtitDisplay + "";
            } else {
                strhidevalue = strhidevalue + " " + strselect1 + "<>'" + strtit + "'";
                strdisplay = strdisplay + strtp0 + " 不等于 '" + strtitDisplay + "'";
            }
        } else if (strselect0 == ">") {
            strhidevalue = strhidevalue + strselect1 + ">" + strtit + "";
            strdisplay = strdisplay + strtp0 + ">" + strtitDisplay + "";
        } else if (strselect0 == "<") {
            strhidevalue = strhidevalue + strselect1 + "<" + "" + strtit + "";
            strdisplay = strdisplay + strtp0 + "<" + strtitDisplay + "";
        } else if (strselect0 == ">=") {
            strhidevalue = strhidevalue + strselect1 + ">=" + strtit + "";
            strdisplay = strdisplay + strtp0 + ">=" + strtitDisplay + "";
        } else if (strselect0 == "<=") {
            strhidevalue = strhidevalue + strselect1 + "<=" + strtit + "";
            strdisplay = strdisplay + strtp0 + "<=" + strtitDisplay + "";
        } else if (strselect0 == "like") {
            strhidevalue = strhidevalue + strselect1 + " like '#" + strtit + "#'";
            strdisplay = strdisplay + strtp0 + " 包含 " + "*" + strtitDisplay + "*";
        } else if (strselect0 == "!like") {
            strhidevalue = strhidevalue + " not " + strselect1 + "=" + strtit + "";
            strdisplay = strdisplay + strtp0 + " 不包含 *" + strtitDisplay + "*";
        } else if (strselect0 == "fr") {
            strhidevalue = strhidevalue + strselect1 + "= fr " + strtit + "";
            strdisplay = strdisplay + strtp0 + ">" + strtitDisplay + "";
        } else if (strselect0 == "to") {
            strhidevalue = strhidevalue + strselect1 + "= to " + strtit + "";
            strdisplay = strdisplay + strtp0 + "<" + strtitDisplay + "";
        } else {
            strhidevalue = strhidevalue + strselect1 + strselect0 + "" + strtit + "";
            strdisplay = strdisplay + strtp0 + strselect0 + "" + strtitDisplay + "";
        }
    }
    else  //第一次添加
    {
        if (strselect0 == "=") {
            //if((strselect1=="pwrq")||(strselect1=="njrq")||(strselect1=="bzrq")||(strselect1=="zfrq")||(strselect1=="zcrq")||(strselect1=="njqx")||(strselect1=="zczj")||(strselect1=="zgrs")){
            if (false) {
                strhidevalue = " " + strselect1 + "=" + strtit + "";
                strdisplay = strtp0 + "=" + strtitDisplay + "";
            } else {
                strhidevalue = " " + strselect1 + "='" + strtit + "'";
                strdisplay = strtp0 + "='" + strtitDisplay + "'";
            }
        } else if (strselect0 == "!=") {
            //if((strselect1=="pwrq")||(strselect1=="njrq")||(strselect1=="bzrq")||(strselect1=="zfrq")||(strselect1=="zcrq")||(strselect1=="njqx")||(strselect1=="zczj")||(strselect1=="zgrs")){
            if (false) {
                strhidevalue = " not " + strselect1 + "=" + strtit + "";
                strdisplay = strtp0 + "!=" + strtitDisplay + "";
            } else {
                strhidevalue = " not " + strselect1 + "='" + strtit + "'";
                strdisplay = strtp0 + "!='" + strtitDisplay + "'";
            }
        } else if (strselect0 == "like") {
            strhidevalue = " " + strselect1 + " like '#" + strtit + "#'";
            strdisplay = strtp0 + " 包含 " + "*" + strtitDisplay + "*";
        } else if (strselect0 == "!like") {
            strhidevalue = " not " + strselect1 + "=" + strtit + "";
            strdisplay = strtp0 + " 不包含 " + "*" + strtitDisplay + "*";
        } else if (strselect0 == "fr") {
            strhidevalue = " " + strselect1 + "= fr " + "" + strtit + "";
            strdisplay = strtp0 + ">" + strtitDisplay + "";
        } else if (strselect0 == "to") {
            strhidevalue = " " + strselect1 + "= to " + "" + strtit + "";
            strdisplay = strtp0 + "<" + strtitDisplay + "";
        } else {
            strhidevalue = " " + strselect1 + strselect0 + "" + strtit + "";
            strdisplay = strtp0 + strselect0 + "" + strtitDisplay + "";
        }

    }
    //alert(strhidevalue);

    document.form1.display.value = strdisplay;
    document.form1.strstr.value = document.form1.strstr.value + strhidevalue;
    hideArray.push(strhidevalue);
//      alert(document.form1.strstr.value);
    document.form1.tit.value = "";
}
var oldStr = "";
var newStr = "";
var hideArray = new Array();
function getOld() {
    oldStr = document.form1.display.value;
    if (oldStr == "") {
        oldStrTemp = oldStr;
    } else {
        oldStrTemp = newStr + "##";
    }
}

function getNew() {
    var display = document.form1.display.value;
    newStr = oldStrTemp + display.substring(oldStr.length);
}
var flag = 0;
function getOld1() {
    var strtit = document.form1.tit.value;
    var strselect1 = document.form1.select1.value;
    var Special_chars = "~!@#$%^&*()_+`-={}|\":>?<,./;'[]\\";
    if (strselect1 == "jgdm") {
        Special_chars = "~!@#$%^&*()_+`-={}|\":>?<,./;'[]\\";
    } else {
        Special_chars = "~!@#$%^&+`=|\":>?</'\\";
    }
    var allowable = 0;
    for (var i = 0; i < strtit.length; i++) {
        if (Special_chars.indexOf(strtit.charAt(i)) != -1) {
            allowable = 1;
        }
    }
    if (document.form1.tit.disabled == true || (document.form1.tit.disabled == false && document.form1.tit.value.length > 0 && allowable == 0)) {
        flag = 1;
        oldStr = document.form1.display.value;
        if (oldStr == "") {
            oldStrTemp = oldStr;
        } else {
            oldStrTemp = newStr + "##";
        }
    }
}
function getNew1() {//这个和一下的都是给增加专用的，因为空的时候这个就不用执行了
    if (flag == 1) {
        var display = document.form1.display.value;
        newStr = oldStrTemp + display.substring(oldStr.length);
    }
}

function backCondition() {

    var str = newStr.substring(0, newStr.lastIndexOf("##"));
    newStr = str;
    //alert(newStr);
    str = str.replaceall("##", "");
    document.form1.display.value = str;
    var hideStr = document.form1.strstr.value;
    document.form1.strstr.value = hideStr.substring(0, hideStr.lastIndexOf(hideArray.pop()));
}
String.prototype.replaceall = function (s1, s2) {
    var demo = this;
    while (demo.indexOf(s1) != -1)
        demo = demo.replace(s1, s2);
    return demo;
}


function backCondition2() {
    var str = document.form1.display.value;
    var andIndex = str.length;
    var orIndex = str.length;

    if (str != "") {
        if (str.indexOf("and") > -1) {
            andIndex = str.indexOf("and");
        }
        if (str.indexOf("or") > -1) {
            orIndex = str.indexOf("or");
        }
        var index = (parseInt(andIndex) > parseInt(orIndex)) ? andIndex : orIndex;
        document.form1.display.value = str.substring(0, index);
    }

}

function backCondition1() {

    if (document.form1.display.value != "") {
        document.form1.display.value = "";
        return true;
    }
    if (document.form1.select1.options[0].selected == false) {
        document.form1.select1.options[0].selected = true;
        document.form1.select0.options.length = 0;
        document.form1.select0.add(document.createElement("OPTION"));
        document.form1.select0.options[0].text = "        ";
        document.form1.select2.options.length = 0;
        document.form1.select2.add(document.createElement("OPTION"));
        document.form1.select2.options[0].text = "        ";
        document.form1.select2.disabled = true;
        document.form1.tit.value = "";
        document.form1.tit.disabled = "disabled";
        return true;
    }
    if (document.form1.selectJjBig) {
        if (document.form1.selectJjBig.options[0].selected == false) {
            document.form1.selectJjBig.options[0].selected = true;
            document.form1.selectJjMid.options.length = 0;
            document.form1.selectJjMid.add(document.createElement("OPTION"));
            document.form1.selectJjMid.options[0].text = "请选择中类               ";
            document.form1.selectJjMid.disabled = true;
            return true;
        }
    }

    if (document.form1.selectArea) {
        if (document.form1.selectArea.options[0].selected == false) {
            document.form1.selectArea.options[0].selected = true;
            document.form1.selectArea1.options.length = 0;
            document.form1.selectArea1.add(document.createElement("OPTION"));
            document.form1.selectArea1.options[0].text = "请选择                                ";
            document.form1.selectArea1.disabled = true;
            return true;
        }
    }

}

function addleft() {
    var left = "(";
    document.form1.display.value = document.form1.display.value + left;
    document.form1.strstr.value = document.form1.strstr.value + left;
    hideArray.push(left);
}
function addright() {
    var right = ")";
    document.form1.display.value = document.form1.display.value + right;
    document.form1.strstr.value = document.form1.strstr.value + right;
    hideArray.push(right);
}
function addand() {
    var addand = " and ";
    document.form1.display.value = document.form1.display.value + addand;
    document.form1.strstr.value = document.form1.strstr.value + addand;
    hideArray.push(addand);
}
function addor() {
    var addor = " or ";
    document.form1.display.value = document.form1.display.value + addor;
    document.form1.strstr.value = document.form1.strstr.value + addor;
    hideArray.push(addor);
}
function js(area, jjhy) {
    var strdispaly = document.form1.display.value;
    //alert(strdispaly);
    var strprov = "";
    var strprov1;
    var strtp = "";

    if (area == 0) {
        strprov = document.form1.selectArea.value;
        strprov1 = document.form1.selectArea1.value;
        if (strprov1.length > 0) {
            if ((strprov1.substring(0, 2) == "11") || (strprov1.substring(0, 2) == "12") || (strprov1.substring(0, 2) == "31")) {
                strtp = "xzqh='" + strprov1 + "'";
            } else if (strprov.length > 6) {
                strtp = "xzqh='" + strprov1 + "'";
            } else {
                strtp = "xzqh=" + strprov1.substring(0, 4) + "!!";
            }
        } else if (strprov.length > 6) {
            strtp = "xzqh=" + strprov.substring(0, 4) + "!!";
        } else {
            if (strprov.length > 0) {
                strtp = "xzqh=" + strprov.substring(0, 2) + "!!!!";
                for (var i = 0; i < bigQhArr.length; i++) {
                    if ((bigQhArr[i].substring(0, 2) == strprov.substring(0, 2)) && (bigQhArr[i].substring(0, 6) != strprov.substring(0, 6))) {
                        strtp = strtp + " and not xzqh=" + bigQhArr[i].substring(0, 4) + "!!";
                    }
                }
            }
        }
    }

    var xxqh = strtp;
    var strBig = "";
    var strMid;
    var strSml;
    if (jjhy == 0) {
        strBig = document.form1.selectJjBig.value;
        strMid = document.form1.selectJjMid.value;
        strSml = document.form1.selectJjSml.value;
        if (strSml.length != 0) {
            strBig = "jjhy=" + strSml.substring(0, 5) + "#";
        } else {
            if (strMid.length != 0) {
                strBig = "jjhy=" + strMid.substring(0, 4) + "#";
            } else {
                if (strBig.length > 0) {
                    strBig = "jjhy=" + strBig.substring(0, 3) + "#";
                }
            }
        }
    }


    //组合产品类型语句
    var andOrNot = "";
    if (strtp.length > 0) {
        andOrNot = " and "
    } else {
        andOrNot = "";
    }
    if (document.form1.selectCpSml.disabled == false) {//小类开
        if (document.form1.selectCpSml.value != "") {//小类有
            strtp = strtp + andOrNot + "cpfl=" + document.form1.selectCpSml.value;
        } else {
            if (document.form1.selectCpMid.value != "") {
                strtp = strtp + andOrNot + "cpfl=" + document.form1.selectCpMid.value + "#";
            } else {
                if (document.form1.selectCpBig.value != "") {
                    strtp = strtp + andOrNot + "cpfl=" + document.form1.selectCpBig.value + "#";
                }
            }
        }
    } else {//小类关
        if (document.form1.selectCpBig.value != "") {
            strtp = strtp + andOrNot + "cpfl=" + document.form1.selectCpBig.value + "#";
        }
    }


    var xxcx = document.form1.display.value
    if (strBig.length > 0) {
        if (strtp.length > 0) {
            strtp = strtp + " and " + strBig;
        } else {
            strtp = strBig;
        }
    }


    var strLength = document.form1.strstr.value.length;
    if (strtp.length > 0) {
        strtp = strtp + " and (" + document.form1.strstr.value + ")";
        //alert(strtp);
    } else {
        strtp = document.form1.strstr.value.substring(0, strLength);
        //alert(strtp);
    }
    if (strBig.length > 0 && xxcx.length == 0) {
        strtp = strBig;
        //alert(strtp);
    }
    if (strprov.length > 0 && xxcx.length == 0) {
        strtp = xxqh;
        //alert(strtp);
    }
    if (strprov.length > 0 && xxcx.length == 0 && strBig.length > 0) {
        strtp = xxqh + " and " + strBig;
    }
    //alert(strtp);
    if (strtp.length == 0) {
        //alert("查询条件不能为空！");
        return false;
    }
    //alert("strtp="+strtp);
    //alert("xxcx="+xxcx);
    strtp = strtp.replace("(", "");
    strtp = strtp.replace(")", "");

    if (strtp.indexOf("and") > -1 && strtp.length - strtp.lastIndexOf("and") <= 4) {

        strtp = strtp.substring(0, strtp.lastIndexOf("and"));
    }
    document.form1.strfind.value = strtp;
    document.form1.submit();
}

function selectBig(midLength, qh_code_big, qh_depth_middle) {
    if (firstSelect == 0) {
        midText = new Array(parseInt(midLength));
        midValues = new Array(parseInt(midLength));
        bigQhArr = qh_code_big.split(":");
        midQhDepthArr = qh_depth_middle.split(":");
        for (var i = 1; i < document.form1.selectArea1.length; i++) {
            midText[i - 1] = document.form1.selectArea1[i].text;
            midValues[i - 1] = document.form1.selectArea1[i].value;
        }
        firstSelect = 1;
    }
    document.form1.selectArea1.disabled = false;
    document.form1.selectArea1.options.length = 0;

    var selBigArea = document.form1.selectArea.value;
    var index = 0;
    if (document.form1.selectArea.value.length > 0) {
        document.form1.selectArea1.options.add(new Option("请选择", ""));//此方法支持 w3c，firefox上无恙
        /*document.form1.selectArea1.add(document.createElement("OPTION"));
         document.form1.selectArea1.options[index].text="请选择";
         document.form1.selectArea1.options[index].value="";
         */
        index++;
    }

    for (var j = 0; j < parseInt(midLength); j++) {
        if ((selBigArea.substring(0, 2) == midValues[j].substring(0, 2)) && (selBigArea.substring(2, 6) == "0000") && (midQhDepthArr[j + 1] == "2")) {
            document.form1.selectArea1.options.add(new Option(midText[j], midValues[j]));//此方法支持 w3c，firefox上无恙
            /*
             document.form1.selectArea1.add(document.createElement("OPTION"));
             document.form1.selectArea1.options[index].text=midText[j];
             document.form1.selectArea1.options[index].value=midValues[j];
             */
            index++;
        } else if ((selBigArea.substring(0, 4) == midValues[j].substring(0, 4)) && (selBigArea.substring(2, 6) != "0000")) {
            document.form1.selectArea1.options.add(new Option(midText[j], midValues[j]));//此方法支持 w3c，firefox上无恙
            /*
             document.form1.selectArea1.add(document.createElement("OPTION"));
             document.form1.selectArea1.options[index].text=midText[j];
             document.form1.selectArea1.options[index].value=midValues[j];
             */
            index++;
        }
    }
}

function selJjBig(jjhyMidSize) {
    var jjhySmlSize = document.form1.jjhySmlSize.value;
    if (firstSelJjhy == 0) {
        jjhyMidText = new Array(parseInt(jjhyMidSize));
        jjhyMidValues = new Array(parseInt(jjhyMidSize));
        for (var i = 0; i < document.form1.selectJjMid.length; i++) {
            jjhyMidText[i] = document.form1.selectJjMid[i].text;
            jjhyMidValues[i] = document.form1.selectJjMid[i].value;
        }


        jjhySmlText = new Array(parseInt(jjhySmlSize));
        jjhySmlValues = new Array(parseInt(jjhySmlSize));

        for (var i = 0; i < parseInt(jjhySmlSize); i++) {
            jjhySmlText[i] = document.form1.selectJjSml[parseInt(i) + 1].text;
            jjhySmlValues[i] = document.form1.selectJjSml[parseInt(i) + 1].value;
        }

        firstSelJjhy = 1;
    }

    document.form1.selectJjMid.disabled = false;
    document.form1.selectJjMid.options.length = 0;

    var selBigJjhy = document.form1.selectJjBig.value.substring(0, 3);
    var index = 0;
    if (document.form1.selectJjBig.value.length > 0) {
        document.form1.selectJjMid.options.add(new Option("请选择中类", ""));//此方法支持 w3c，firefox上无恙
        /*
         document.form1.selectJjMid.add(document.createElement("OPTION"));
         document.form1.selectJjMid.options[index].text="请选择中类";
         document.form1.selectJjMid.options[index].value="";
         */
        index++;
    }

    for (var j = 0; j < parseInt(jjhyMidSize); j++) {
        if (selBigJjhy == jjhyMidValues[j].substring(0, 3)) {
            document.form1.selectJjMid.options.add(new Option(jjhyMidText[j], jjhyMidValues[j]));//此方法支持 w3c，firefox上无恙
            /*
             document.form1.selectJjMid.add(document.createElement("OPTION"));
             document.form1.selectJjMid.options[index].text=jjhyMidText[j];
             document.form1.selectJjMid.options[index].value=jjhyMidValues[j];
             */
            index++;
        }
    }

    if (document.form1.selectJjMid.length > 1) {
        document.form1.selectJjSml.options.length = 0;
        document.form1.selectJjSml.options.add(new Option("请选择小类", ""));//此方法支持 w3c，firefox上无恙
        /*document.form1.selectJjSml.add(document.createElement("OPTION"));
         document.form1.selectJjSml.options[0].text="请选择小类";
         document.form1.selectJjSml.options[0].value="";*/
        document.form1.selectJjSml.disabled = true;
    }

    if (document.form1.selectJjMid.length == 1) {

        // alert(jjhySmlValues1.length);
        document.form1.selectJjSml.disabled = false;
        document.form1.selectJjSml.options.length = 0;
        var selBigJjhy2 = document.form1.selectJjBig.value.substring(0, 3);

        var index2 = 0;

        document.form1.selectJjSml.options.add(new Option("请选择小类", ""));//此方法支持 w3c，firefox上无恙
        /*document.form1.selectJjSml.add(document.createElement("OPTION"));
         document.form1.selectJjSml.options[index2].text="请选择小类";
         document.form1.selectJjSml.options[index2].value="";
         */
        index2++;
        for (var j = 0; j < parseInt(jjhySmlSize); j++) {

            if (selBigJjhy2 == jjhySmlValues[j].substring(0, 3)) {
                document.form1.selectJjSml.options.add(new Option(jjhySmlText[j], jjhySmlValues[j]));//此方法支持 w3c，firefox上无恙
                /*document.form1.selectJjSml.add(document.createElement("OPTION"));
                 document.form1.selectJjSml.options[index2].text=jjhySmlText[j];
                 document.form1.selectJjSml.options[index2].value=jjhySmlValues[j];
                 */
                index2++;
            }

        }

    }
}
function selJjMid(jjhySmlSize) {

    document.form1.selectJjSml.disabled = false;
    document.form1.selectJjSml.options.length = 0;

    var selMidJjhy = document.form1.selectJjMid.value.substring(0, 4);
    var index = 0;

    if (document.form1.selectJjMid.value.length > 0) {
        document.form1.selectJjSml.options.add(new Option("请选择小类", ""));//此方法支持 w3c，firefox上无恙
        /*document.form1.selectJjSml.add(document.createElement("OPTION"));
         document.form1.selectJjSml.options[index].text="请选择小类";
         document.form1.selectJjSml.options[index].value="";
         */
        index++;
    }

    for (var j = 0; j < parseInt(jjhySmlSize); j++) {
        if (selMidJjhy == jjhySmlValues[j].substring(0, 4)) {
            document.form1.selectJjSml.options.add(new Option(jjhySmlText[j], jjhySmlValues[j]));//此方法支持 w3c，firefox上无恙
            /*document.form1.selectJjSml.add(document.createElement("OPTION"));
             document.form1.selectJjSml.options[index].text=jjhySmlText[j];
             document.form1.selectJjSml.options[index].value=jjhySmlValues[j];
             */
            index++;
        }
    }
}
function selCpBig(obj) {
    document.form1.selectCpMid.disabled = false;
    document.form1.selectCpMid.options.length = 1;
    document.form1.selectCpSml.options.length = 1;
    document.form1.selectCpSml.disabled = true;
    if (obj.value != "") {
        DWREngine.setAsync(false);
        AutoSuggest.getCpflByLevelAndParent(4, obj.value, function (backobj) {
            for (var i = 0; i < backobj.length; i++) {
                document.form1.selectCpMid.options.add(new Option(backobj[i].skcb, backobj[i].cpdm));//此方法支持 w3c，firefox上无恙
                /*document.form1.selectCpMid.add(document.createElement("OPTION"));
                 document.form1.selectCpMid.options[(i+1)].value=backobj[i].cpdm;
                 document.form1.selectCpMid.options[(i+1)].text=backobj[i].skcb;
                 */
            }
        });
        DWREngine.setAsync(true);
    }
}
function selCpMid(obj) {
    document.form1.selectCpSml.disabled = false;
    document.form1.selectCpSml.options.length = 1;
    if (obj.value != "") {
        DWREngine.setAsync(false);
        AutoSuggest.getCpflByLevelAndParent(6, obj.value, function (backobj) {
            for (var i = 0; i < backobj.length; i++) {
                document.form1.selectCpSml.options.add(new Option(backobj[i].skcb, backobj[i].cpdm));//此方法支持 w3c，firefox上无恙
                /* document.form1.selectCpSml.add(document.createElement("OPTION"));
                 document.form1.selectCpSml.options[(i+1)].value=backobj[i].cpdm;
                 document.form1.selectCpSml.options[(i+1)].text=backobj[i].skcb;
                 */

            }
        });
        DWREngine.setAsync(true);
    }
}

function checkForm() {
    var disvalue = document.form1.strstr.value;
    if (isEmpty(disvalue)) {
        ymPrompt.alert({message:'请生成查询条件再进行提交!', width:330, height:220, title:'提示信息'});
        return false;
    } else {
        disvalue = disvalue.trim();
        if (disvalue.startWith("and") || disvalue.startWith("or") || disvalue.startWith(")")) {
            ymPrompt.alert({message:'请按正确方法连接条件表达式!', width:330, height:220, title:'提示信息'});
            return false;
        } else {
            document.form1.submit();
        }
    }
}
String.prototype.startWith = function (str) {
    if (str == null || str == "" || this.length == 0 || str.length > this.length)
        return false;
    if (this.substr(0, str.length) == str)
        return true;
    else
        return false;
    return true;
}
function document.onkeydown() {

    if (event.keyCode == 13 && document.activeElement.id == "tit") {
        return false;
        // document.form1.submit
    }
}
</script>
</head>
<body>
<div class="page_top">采集 &gt;&gt; 高级查询</div>

<form method="post" action="advancedlist.jsp" name="form1">
    <input type="hidden" name="actions" value="search"/>
    <input type="hidden" name="currentPage" value="<%=currentPage%>"/>

    <div id="list_main">
        <div class="list_box">
            <div class="list_box_top">
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td class="talbe1_top_img"><img src="../images/icon_addgxlm.gif" width="16" height="16"/></td>
                        <td align="left">高级查询</td>
                        <td class="right"><input name="saveButton" type="button" class="btn_more" value="提交"
                                                 onClick="checkForm()" id="saveButton"/>
                            <input name="button" type="button" class="btn_more" id="button" value="重 填"
                                   onclick="form1.reset();"/></td>
                    </tr>
                </table>
            </div>
            <div class="div_bian5">
                <table width="100%" border="0" cellpadding="0" cellspacing="1" class="table_bj1">
                    <tr class="table1_tr1">
                        <td class="table1_td1" width="18%">条件选择：</td>
                        <td>
                            <select name="select1" id="select1" onChange="setcode();">
                                <%--<option value="">选择字段</option>--%>
                                <%--<%List<Fields> enterpriseinfos = InitSysParams.enterpriseinfos;--%>
                                <%--for(Fields fields : enterpriseinfos){if(!(fields.getFieldCode().equals("zlfzr")||fields.getFieldCode().equals("zlfzrlxfs")||fields.getFieldCode().equals("brand_img")||fields.getFieldCode().equals("health_id")||fields.getFieldCode().equals("health_timeout"))){ %>--%>
                                <%--<option value="<%="t1."+fields.getFieldCode() %>"><%=fields.getFieldName() %></option>--%>
                                <%--<%}}%>--%>
                                <option value="000000">请选择</option>
                                <option value="jgdm">机构代码</option>
                                <option value="jgmc">机构名称</option>
                                <option value="cpmc">产品名称</option>
                                <%--<option value="cpmcgjz">产品名称关键字</option>--%>
                                <option value="zxbzbh">执行标准编号</option>
                                <option value="zxbzmc">执行标准名称</option>
                                <option value="cpcym">产品常用名</option>
                                <option value="cpywmc">产品英文名</option>
                                <option value="cpxh">产品型号</option>
                                <option value="cpgg">产品规格</option>
                                <option value="cpxkzh">生产许可证号</option>
                                <option value="qsrzh">QS认证号</option>
                            </select>
                            <span id="enterDiv"></span>

                            <br/></td>
                    </tr>
                    <%--<tr  class="table1_tr1" style="display:none;">--%>
                    <%--<td class="table1_td1" width="18%">产品信息：</td>--%>
                    <%--<td> --%>
                    <%--<select name="selectproduct" id="selectproduct" onChange="checkProduct();">--%>
                    <%--<option value="">选择字段</option>--%>
                    <%--<%List<Fields> db_productinfos = InitSysParams.productinfos;--%>
                    <%--for(Fields fields : db_productinfos){if(!(fields.getFieldCode().equals("appscope")||fields.getFieldCode().equals("appfeature")||fields.getFieldCode().equals("NameKey")||fields.getFieldCode().equals("fact_timeout")||fields.getFieldCode().equals("threec_timeout")||fields.getFieldCode().equals("qs_timeout"))){ %>--%>
                    <%--<option value="<%="t4."+fields.getFieldCode() %>"><%=fields.getFieldName() %></option>--%>
                    <%--<%}}%>--%>
                    <%--</select>--%>
                    <%--<span id="productDiv"></span>--%>
                    <%----%>
                    <%--</td></tr>--%>
                    <tr class="table1_tr1">
                        <td class="table1_td1" width="18%">关系运算符：</td>
                        <td>
                            <select name="select0">
                                <option>&nbsp;</option>
                            </select>
                            <span id="groupDiv"></span>

                        </td>
                    </tr>
                    <tr class="table1_tr1">
                        <td class="table1_td1" width="18%">查询值：</td>
                        <td><input type="text" name="tit" id="tit" maxlength="50" isnull="false" size="22"
                                   class="page_input2"/><span id="titDiv"></span>
                            <select name="select2" disabled="disabled" style="display:none">
                                <option>&nbsp;</option>
                            </select>
                        </td>
                    </tr>
                    <tr class="table1_tr1">
                        <td class="table1_td1" width="18%">条件内部关系符：</td>
                        <td>
                            <input type="button" name="add_and" value="and(和)" onClick="getOld();addand();getNew()"
                                   class="btn_more"/>&nbsp;<input type="button" name="add_or" value="or (或)"
                                                                  onClick="getOld();addor();getNew()" class="btn_more"/>&nbsp;<input
                                type="button" name="add_left" value="(" onClick="getOld();addleft();getNew()"
                                class="btn_more"/>&nbsp;<input type="button" name="add_right" value=")"
                                                               onClick="getOld();addright();getNew()" class="btn_more"/>&nbsp;<input
                                type="button" name="add_condition" value="添 加"
                                onClick="getOld1();addCondition();getNew1();" class="btn_more"/>&nbsp;<input
                                type="button" name="back_Condition" value="回 退" onClick="backCondition();"
                                class="btn_more"/>
                        </td>
                    </tr>
                    <tr class="table1_tr1">
                        <td class="table1_td1">查询条件：</td>
                        <td><textarea name="display" cols="80" rows="5" readonly="readonly"> </textarea>
                            <textarea name="strstr" cols="80" rows="5" readonly="readonly"
                                      style="display:none"></textarea></td>
                    </tr>

                </table>

            </div>
        </div>
    </div>
</form>
<div style="background:url(../../images/ty.png) repeat-x; height:5px; width:100%; overflow:hidden; clear:both;"></div>

</body>

</html>
