/*-------------- 函数检索 --------------
 trim函数：                         trim() lTrim() rTrim()
 校验字符串是否为空：                 isEmpty(str)
 校验字符串是否为整型：               checkIsInteger(str)
 校验整型最小值：                    checkIntegerMinValue(str,val)
 校验整型最大值：                    checkIntegerMaxValue(str,val)
 校验整型是否为非负数：               isNotNegativeInteger(str)
 校验字符串是否为浮点型：             checkIsDouble(str)
 校验浮点型最小值：                  checkDoubleMinValue(str,val)
 校验浮点型最大值：                  checkDoubleMaxValue(str,val)
 校验浮点型是否为非负数：             isNotNegativeDouble(str)
 获取系统当前时间                    getSystemDate() yyyy-mm-dd
 校验字符串是否为日期型：             checkIsValidDate(str)
 校验两个日期的先后：                checkDateEarlier(strStart,strEnd)
 校验字符串是否为email型：           checkEmail(str)
 校验邮政编码是否正确               isPostCode(s)
 校验字符串是否为中文：               checkIsChinese(str)
 计算字符串的长度，一个汉字两个字符：   realLength()
 校验字符串是否符合自定义正则表达式：   checkMask(str,pat)
 得到文件的后缀名：                   getFilePostfix(oFile)
 按键屏蔽：                                   KeyDown()
 是否包含特殊字符                    CheckSpecialChar(varstr,Special_chars)
 是否为数字                          isNumber();
 全选复选框                          check_all(menu_all,MENU_ID);
 匹配IP地址的正则表达式              isIP(strIP)
 -------------- 函数检索 --------------
 */
/**
 * 常用变量
 **/
var username_special_chars = "~!@#$%^&*+`={}|\">?<,'[]\\";
//var password_Special_chars="~!@#$%^&*()_+`-={}|\":?<,'[]\\";
var password_Special_chars = "'";
var search_Special_char = "~!@#$%^&*()+`-={}|\">?<,'[]\\";
var article_Special_char = "~@#^&*`{}|\">?<'[]\\";
 special_char = {
    username: username_special_chars,
    searchs: search_Special_char,
    passwd: password_Special_chars,
    article: article_Special_char
};
String.prototype.replaceAll = function (s1, s2) {
    return this.replace(new RegExp(s1, "gm"), s2);
}
String.prototype.trim = function () {
    return this.replace(/(^\s+)|\s+$/g, "");
}
function getChineseDate() {

    var today = new Date();

    function initArray() {

        this.length = initArray.arguments.length;
        for (var i = 0; i < this.length; i++)this[i + 1] = initArray.arguments[i];
    }

    var d = new initArray(
        "星期日",
        "星期一",
        "星期二",
        "星期三",
        "星期四",
        "星期五",
        "星期六");

    return today.getYear() + "-" + (today.getMonth() + 1) + "-" + today.getDate();
}
/**
 * 考虑移到tools.js
 */
function addOption(id, value, text) {

    var data = [
        { value: value, text: text }
    ];
    DWRUtil.addOptions(id, data, "value", "text");
}
/*
 * 是否选中夫选矿
 **/

function isChecked(elementName) {

    var checkBox = document.getElementsByName(elementName);
    var checked = false;
    if (checkBox) {
        //alert(checkBox.item(0).checked);
        for (var index = 0; index < checkBox.length; index++) {
            if (checkBox.item(index).checked) {
                checked = true;

                break;
            }
        }
    }
    return checked;
}
/*
 * 是否选中全部
 **/

function isCheckedAll(elementName) {

    var checkBox = document.getElementsByName(elementName);
    var checked = true;
    if (checkBox) {

        for (var index = 0; index < checkBox.length; index++) {
            if (!checkBox.item(index).checked) {

                return false;
            }
        }
    }
    return checked;
}
/**
 *全选复选框
 **/
function check_all(menu_all, MENU_ID) {

    for (i = 0; i < document.all(MENU_ID).length; i++) {
        if (menu_all.checked)
            document.all(MENU_ID).item(i).checked = true;
        else
            document.all(MENU_ID).item(i).checked = false;
    }

    if (i == 0) {
        if (menu_all.checked)
            document.all(MENU_ID).checked = true;
        else
            document.all(MENU_ID).checked = false;
    }
}

/**
 *
 * 去除多余空格函数
 * trim:去除两边空格 lTrim:去除左空格 rTrim: 去除右空格
 * 用法：
 *     var str = "  hello ";
 *     str = str.trim();
 */
String.prototype.Trim = function () {
    return this.replace(/(^\s*)|(\s*$)/g, "");
}
String.prototype.lTrim = function () {
    return this.replace(/(^[\\s]*)/g, "");
}
String.prototype.rTrim = function () {
    return this.replace(/([\\s]*$)/g, "");
}
/********************************** Empty **************************************/
/**
 *校验字符串是否为空
 *返回值：
 *如果不为空，定义校验通过，返回true
 *如果为空，校验不通过，返回false               参考提示信息：输入域不能为空！
 */
function isEmpty(str) {
    if (str == null || (str.Trim() == null) || (str.Trim().length == 0)) return true;
    else return(false);
}//~~~
/*--------------------------------- Empty --------------------------------------*/
/********************************** Integer *************************************/
/**
 *校验字符串是否为整型
 *返回值：
 *如果为空，定义校验通过，      返回true
 *如果字串全部为数字，校验通过，返回true
 *如果校验不通过，              返回false     参考提示信息：输入域必须为数字！
 */
function checkIsInteger(str) {
    //如果为空，则通过校验
    if (str == "")
        return true;
    if (/^(\\-?)(\\d+)$/.test(str))
        return true;
    else
        return false;
}//~~~
/**
 *校验整型最小值
 *str：要校验的串。  val：比较的值
 *
 *返回值：
 *如果为空，定义校验通过，                返回true
 *如果满足条件，大于等于给定值，校验通过，返回true
 *如果小于给定值，                        返回false              参考提示信息：输入域不能小于给定值！
 */
function checkIntegerMinValue(str, val) {
    //如果为空，则通过校验
    if (str == "")
        return true;
    if (typeof(val) != "string")
        val = val + "";
    if (checkIsInteger(str) == true) {
        if (parseInt(str, 10) >= parseInt(val, 10))
            return true;
        else
            return false;
    }
    else
        return false;
}//~~~
/**
 *校验整型最大值
 *str：要校验的串。  val：比较的值
 *
 *返回值：
 *如果为空，定义校验通过，                返回true
 *如果满足条件，小于等于给定值，校验通过，返回true
 *如果大于给定值，                        返回false       参考提示信息：输入值不能大于给定值！
 */
function checkIntegerMaxValue(str, val) {
    //如果为空，则通过校验
    if (str == "")
        return true;
    if (typeof(val) != "string")
        val = val + "";
    if (checkIsInteger(str) == true) {
        if (parseInt(str, 10) <= parseInt(val, 10))
            return true;
        else
            return false;
    }
    else
        return false;
}//~~~
/**
 *校验整型是否为非负数
 *str：要校验的串。
 *
 *返回值：
 *如果为空，定义校验通过，返回true
 *如果非负数，            返回true
 *如果是负数，            返回false               参考提示信息：输入值不能是负数！
 */
function isNotNegativeInteger(str) {
    //如果为空，则通过校验
    if (str == "")
        return true;
    if (checkIsInteger(str) == true) {
        if (parseInt(str, 10) < 0)
            return false;
        else
            return true;
    }
    else
        return false;
}//~~~
/*--------------------------------- Integer --------------------------------------*/
/********************************** Double ****************************************/
/**
 *校验字符串是否为浮点型
 *返回值：
 *如果为空，定义校验通过，      返回true
 *如果字串为浮点型，校验通过，  返回true
 *如果校验不通过，              返回false     参考提示信息：输入域不是合法的浮点数！
 */
function checkIsDouble(str) {
    //如果为空，则通过校验
    if (str == "")
        return true;
    //如果是整数，则校验整数的有效性
    if (str.indexOf(".") == -1) {
        if (checkIsInteger(str) == true)
            return true;
        else
            return false;
    }
    else {
        if (/^(\\-?)(\\d+)(.{1})(\\d+)$/g.test(str))
            return true;
        else
            return false;
    }
}//~~~
/**
 *校验浮点型最小值
 *str：要校验的串。  val：比较的值
 *
 *返回值：
 *如果为空，定义校验通过，                返回true
 *如果满足条件，大于等于给定值，校验通过，返回true
 *如果小于给定值，                        返回false              参考提示信息：输入域不能小于给定值！
 */
function checkDoubleMinValue(str, val) {
    //如果为空，则通过校验
    if (str == "")
        return true;
    if (typeof(val) != "string")
        val = val + "";
    if (checkIsDouble(str) == true) {
        if (parseFloat(str) >= parseFloat(val))
            return true;
        else
            return false;
    }
    else
        return false;
}//~~~
/**
 *校验浮点型最大值
 *str：要校验的串。  val：比较的值
 *
 *返回值：
 *如果为空，定义校验通过，                返回true
 *如果满足条件，小于等于给定值，校验通过，返回true
 *如果大于给定值，                        返回false       参考提示信息：输入值不能大于给定值！
 */
function checkDoubleMaxValue(str, val) {
    //如果为空，则通过校验
    if (str == "")
        return true;
    if (typeof(val) != "string")
        val = val + "";
    if (checkIsDouble(str) == true) {
        if (parseFloat(str) <= parseFloat(val))
            return true;
        else
            return false;
    }
    else
        return false;
}//~~~
/**
 *校验浮点型是否为非负数
 *str：要校验的串。
 *
 *返回值：
 *如果为空，定义校验通过，返回true
 *如果非负数，            返回true
 *如果是负数，            返回false               参考提示信息：输入值不能是负数！
 */
function isNotNegativeDouble(str) {
    //如果为空，则通过校验
    if (str == "")
        return true;
    if (checkIsDouble(str) == true) {
        if (parseFloat(str) < 0)
            return false;
        else
            return true;
    }
    else
        return false;
}//~~~
/*--------------------------------- Double ---------------------------------------*/
/********************************** date ******************************************/
/**
 *校验字符串是否为日期型
 *返回值：
 *如果为空，定义校验通过，           返回true
 *如果字串为日期型，校验通过，       返回true
 *如果日期不合法，                   返回false    参考提示信息：输入域的时间不合法！（yyyy-MM-dd）
 */
function checkIsValidDate(str) {

    /*var reg = /^(\d{4})(-)(\d{2})$/;
     var r = date.match(reg);
     if(r==null) return false;
     var d= new Date(r[1], r[3]-1,r[4]);
     var newStr=d.getFullYear()+r[2]+(d.getMonth()+1)+r[2]+d.getDate();
     date=r[1]+r[2]+((r[3]-1)+1)+r[2]+((r[4]-1)+1);
     return newStr==date;
     return true;*/


    var reg1 = /^(\d{4})(-)(\d{2})$/;
    var reg2 = /^(\d{4})(-)(\d{2})(-)(\d{2})$/;
    var r1 = str.match(reg1);
    var r2 = str.match(reg2);
    if (r1 == null) {
        r1 = false;
    } else {

        var d = new Date(r1[1], r1[3] - 1);
        var newStr = d.getFullYear() + r1[2] + (d.getMonth() + 1);
        //alert("newStr="+newStr);
        str = r1[1] + r1[2] + ((r1[3] - 1) + 1);
        //alert("str="+str);
        r1 = (newStr == str);
    }
    if (r2 == null) {
        r2 = false;
    } else {

        var d = new Date(r2[1], r2[3] - 1, r2[5]);
        var newStr = d.getFullYear() + r2[2] + (d.getMonth() + 1) + r2[2] + d.getDate();
        str = r2[1] + r2[2] + ((r2[3] - 1) + 1) + r2[2] + ((r2[5] - 1) + 1);
        //alert("newStr="+newStr);
        //alert("str="+str);
        r2 = (newStr == str);
        //r2 =  true;
    }
    return r1 || r2;
}//~~~
/**
 *校验两个日期的先后
 *返回值：
 *如果其中有一个日期为空，校验通过,          返回true
 *如果起始日期早于等于终止日期，校验通过，   返回true
 *如果起始日期晚于终止日期，                 返回false    参考提示信息： 起始日期不能晚于结束日期。
 */
function checkDateEarlier(strStart, strEnd) {
    /* if(checkIsValidDate(strStart) == false || checkIsValidDate(strEnd) == false)
     return false;
     //如果有一个输入为空，则通过检验
     if (( strStart == "" ) || ( strEnd == "" ))
     return true;
     var arr1 = strStart.split("-");
     var arr2 = strEnd.split("-");
     var date1 = new Date(arr1[0],parseInt(arr1[1].replace(/^0/,""),10) - 1,arr1[2]);
     var date2 = new Date(arr2[0],parseInt(arr2[1].replace(/^0/,""),10) - 1,arr2[2]);
     if(arr1[1].length == 1)
     arr1[1] = "0" + arr1[1];
     if(arr1[2].length == 1)
     arr1[2] = "0" + arr1[2];
     if(arr2[1].length == 1)
     arr2[1] = "0" + arr2[1];
     if(arr2[2].length == 1)
     arr2[2]="0" + arr2[2];
     var d1 = arr1[0] + arr1[1] + arr1[2];
     var d2 = arr2[0] + arr2[1] + arr2[2];
     if(parseInt(d1,10) > parseInt(d2,10))
     return false;
     else
     return true;*/

    var s = strStart.split(/\-/)
    if (s.length == 1)
        s = strStart.split(/\//)
    if (s.length == 1)
        s = strStart.split(/\./)
    if (s[1].length < 2)
        s[1] = "0" + s[1];
    if (s[2].length < 2)
        s[2] = "0" + s[2];


    var o = strEnd.split(/\-/)
    if (o.length == 1)
        o = strEnd.split(/\//)
    if (o.length == 1)
        o = strEnd.split(/\./)

    if (o[1].length < 2)
        o[1] = "0" + o[1];
    if (o[2].length < 2)
        o[2] = "0" + o[2];


    return parseInt(s[0] + s[1] + s[2]) - parseInt(o[0] + o[1] + o[2])

}//~~~
/**
 * 获取系统当前时间
 */
function getSystemDate() {
    var date_time = new Date();
    var systemdate = date_time.getYear();
    if (date_time.getMonth() + 1 < 10)
        systemdate += "-0" + (date_time.getMonth() + 1);
    else
        systemdate += "-" + (date_time.getMonth() + 1);

    if (date_time.getDate() < 10)
        systemdate += "-0" + date_time.getDate();
    else
        systemdate += "-" + date_time.getDate();

    return systemdate;
}

/*--------------------------------- date -----------------------------------------*/
/********************************** email *****************************************/
/**
 *校验字符串是否为email型
 *返回值：
 *如果为空，定义校验通过，           返回true
 *如果字串为email型，校验通过，      返回true
 *如果email不合法，                  返回false    参考提示信息：Email的格式不正確！
 */
function checkEmail(str) {
    //如果为空，则通过校验
    /*if(str == "")
     return true;
     if (str.charAt(0) == "." || str.charAt(0) == "@" || str.indexOf('\'@\'', 0) == -1 || str.indexOf('\'.\'', 0) == -1 || str.lastIndexOf("@") == str.length-1 || str.lastIndexOf(".") == str.length-1)

     return false;
     else
     return true;*/

    /*var patrn = /^[\w-_]+(\.[\w-_]+)*@[\w-_]+(\.[\w-_]+)+$/;
     if (!patrn.exec(s)) return false
     return true */

    var Email = str;
    var re = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
    if (!re.test(Email)) {
        return false;
    } else {
        return true;
    }

}//~~~
/*--------------------------------- email ----------------------------------------*/
/********************************** chinese ***************************************/
/**
 *校验字符串是否为中文
 *返回值：
 *如果为空，定义校验通过，           返回true
 *如果字串为中文，校验通过，         返回true
 *如果字串为非中文，             返回false    参考提示信息：必须为中文！
 */
function checkIsChinese(str) {
    //如果值为空，通过校验
    if (str == "")
        return true;
    var pattern = /^([\\u4E00-\\u9FA5]|[\\uFE30-\\uFFA0])*$/gi;
    if (pattern.test(str))
        return true;
    else
        return false;
}//~~~
/**
 * 计算字符串的长度，一个汉字两个字符
 */
String.prototype.realLength = function () {
    if (this.length > 0)
        return this.replace(/[^\\x00-\\xff]/g, "**").length;
    return 0;
};
/*--------------------------------- chinese --------------------------------------*/
/********************************** mask ***************************************/
/**
 *校验字符串是否符合自定义正则表达式
 *str 要校验的字串  pat 自定义的正则表达式
 *返回值：
 *如果为空，定义校验通过，           返回true
 *如果字串符合，校验通过，           返回true
 *如果字串不符合，                   返回false    参考提示信息：必须满足***模式
 */
function checkMask(str, pat) {
    //如果值为空，通过校验
    if (str == "")
        return true;
    var pattern = new RegExp(pat, "gi")
    if (pattern.test(str))
        return true;
    else
        return false;
}//~~~
/*--------------------------------- mask --------------------------------------*/
/********************************** file ***************************************/
/**
 *
 * 得到文件的后缀名
 * oFile为file控件对象
 */
function getFilePostfix(oFile) {
    if (oFile == null)
        return null;
    var pattern = /(.*)\\.(.*)$/gi;
    if (typeof(oFile) == "object") {
        if (oFile.value == null || oFile.value == "")
            return null;
        var arr = pattern.exec(oFile.value);
        return RegExp.$2;
    }
    else if (typeof(oFile) == "string") {
        var arr = pattern.exec(oFile);
        return RegExp.$2;
    }
    else
        return null;
}//~~~

/**
 *  是否包含特殊字符
 **/
function CheckSpecialChar(varstr, Special_chars) {


    for (i = 0; i < varstr.length; i++) {
        if (Special_chars.indexOf(varstr.charAt(i)) != -1) {
            return varstr.charAt(i);
        }
    }
    return false;
}

//校验是数字
function isNumber(s) {
    var patrn = /^\d+$/;
    if (!patrn.exec(s)) return false
    return true
}
//检验中国邮政编码
function isPostCode(s) {
    var patrn = /^[0-9]{6}$/;
    if (!patrn.exec(s)) return false
    return true
}

function LoadWindow(URL, Width, Height) {

    loc_x = document.body.scrollLeft + event.clientX - event.offsetX - 100;
    loc_y = document.body.scrollTop + event.clientY - event.offsetY + 140;
    window.showModalDialog(URL, self, "edge:raised;scroll:0;status:0;help:0;resizable:1;dialogWidth:" + Width + "px;dialogHeight:" + Height + "px;dialogTop:" + loc_y + "px;dialogLeft:" + loc_x + "px");


}

/*--------------------------------- file --------------------------------------*/

function KeyDown() {
//屏蔽鼠标右键、Ctrl+n、shift+F10、F5刷新、退格键 
//alert("ASCII代码是："+event.keyCode); 
    if ((window.event.altKey) &&
        ((window.event.keyCode == 37) || //屏蔽 Alt+ 方向键 ←
            (window.event.keyCode == 39))) { //屏蔽 Alt+ 方向键 →
        alert("不准您使用ALT+方向键前进或后退网页！");
        event.returnValue = false;
    }
    if ((event.keyCode == 8) || //屏蔽退格删除键
        (event.keyCode == 116) || //屏蔽 F5 刷新键
        (event.keyCode == 112) || //屏蔽 F1 刷新键
        (event.ctrlKey && event.keyCode == 82)) { //Ctrl + R
        event.keyCode = 0;
        event.returnValue = false;
    }
    if ((event.ctrlKey) && (event.keyCode == 78)) //屏蔽 Ctrl+n
        event.returnValue = false;
    if ((event.shiftKey) && (event.keyCode == 121)) //屏蔽 shift+F10
        event.returnValue = false;
    if (window.event.srcElement.tagName == "A" && window.event.shiftKey)
        window.event.returnValue = false; //屏蔽 shift 加鼠标左键新开一网页
    if ((window.event.altKey) && (window.event.keyCode == 115)) { //屏蔽Alt+F4
        window.showModelessDialog("about:blank", "", "dialogWidth:1px;dialogheight:1px");
        return false;
    }
}


//弹出窗口
function openwin(pageURL, ht, wd) {
    window.open(pageURL, "newwindow", "height=" + ht + ", width=" + wd + ", toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");
}

function getGUID() {
    var d = new Date();
    var ret = d.getYear() + "_" + d.getUTCMonth() + "_" + d.getUTCDay() + "_" + d.getUTCHours() + "_" + d.getUTCMinutes() + "_" + d.getUTCSeconds() + "_" + d.getUTCMilliseconds();
    return ret;
}
function findPosX(obj) {
    var left = 0;
    if (obj.offsetParent) {
        while (obj.offsetParent) {
            left += obj.offsetLeft;
            obj = obj.offsetParent;
        }
    } else if (obj.x) left += obj.x;
    return left;
}
function findPosY(obj) {
    var top = 0;
    if (obj.offsetParent) {
        while (obj.offsetParent) {
            top += obj.offsetTop;
            obj = obj.offsetParent;
        }
    } else if (obj.y) top += obj.y;
    return top;
}

//get one element
function _getElement(elemid) //param：element id
{
    return document.getElementById ? document.getElementById(elemid) : null
}

//get node list
function _getElementList(expr)//param match expression string
{
    return document.getElementsByTagName ? document.getElementsByTagName(expr) : new Array()
}

//
function _trim(str) //param string
{
    return str.replace(/^\s*|\s*$/g, "")
}

function _esc(str) //param string
{
    return window.encodeURIComponent ? encodeURIComponent(str) : escape(str)
}

function _unesc(str) //param string
{
    return window.decodeURIComponent ? decodeURIComponent(str) : unescape(str)
}

function _hesc(str) //param string replace> <
{
    return str.replace(/</g, "&lt;").replace(/>/g, "&gt;")
}

function _min(a, b) //param int int
{
    return a < b ? a : b
}

function _max(a, b) //param int int
{
    return a > b ? a : b
}

function _isSafari() {
    var a = navigator.userAgent.indexOf("Safari") >= 0;
    return a >= 0 ? true : false;
}

function getXmlHttp()  //get XMLHttpRequest object
{
    var a = null;
    if (window.ActiveXObject) {
        a = new ActiveXObject("Msxml2.XMLHTTP");
        if (!a) {
            a = new ActiveXObject("Microsoft.XMLHTTP")
        }
    } else if (window.XMLHttpRequest) {
        a = new XMLHttpRequest()
    }
    return a
}

//send request
function _send_request_asyc(url, func) //param string,function
{
    var xmlhttp = getXmlHttp();
    if (func) {
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4) {
                func(xmlhttp.status, xmlhttp.responseText)
            }
        }
    }
    xmlhttp.open("POST", url, true);
    xmlhttp.send(null)
}

function _send_request(url, func) //param string,function
{
    var xmlhttp = getXmlHttp();
    xmlhttp.open("POST", url, false);
    xmlhttp.send(null)
    if (func) {
        if (xmlhttp.readyState == 4) {
            func(xmlhttp.status, xmlhttp.responseText)
        }
    }
}

//get response text
function send_request(url) {
    var xmlhttp = getXmlHttp();
    if (xmlhttp) {
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4) {
                if (xmlhttp.status == 200) {
                    return xmlhttp.responseText;
                }
            }
        }
        xmlhttp.open("GET", url, false);
        xmlhttp.send(null);
        return null;
    }
    return false;
}

//change element's style value which class=cls
function _set_cls(cls, syl, val) {
    var nodelist = _getElementList("*");
    for (var index = 0; index < nodelist.length; index++) {
        if (nodelist[index].className == cls) {
            nodelist[index].style[syl] = val
        }
    }
}

function removedlg() {
    var div = _getElement("dlg_modal");
    div.innerHTML = "";
    div.style.display = "none";
}

function showdlg(div, x, y) {
    div.style.display = "block";
    div.style.position = "absolute";
    div.style.left = x + "px";
    div.style.top = y + "px";
}

function _store_func(status, _html) {
    if (status != 200) {
        alert("服务器返回错误,HTTP状态代码：" + status);
    } else if (_html == "OK") {
        alert("定制成功，恭喜您!");
    } else {
        alert(_html);
    }
}
function store(urlid) {
    //var url = "/woyong/Ajaxlet?type=24&urlid="+urlid;
    //_send_request(url,_store_func);
    var url = "/woyong/internal_collect.do?urlid=" + urlid;
    frmSearch.action = url;
    frmSearch.method = "post";
    frmSearch.target = "_blank";
    frmSearch.submit();
}

function subscribeTheme(userid, themeid, clsid) {
    var url = "/woyong/AjMan?type=13&userid=" + userid + "&themeid=" + themeid + "&classid=" + clsid;
    _send_request(url, _store_func);
}
function tologinuser() {
    //window.event.returnValue = false;
    if (event.keyCode == 13) {
        if (frmLogin.username.value.length > 1 && frmLogin.userpass.value.length > 1)
            frmLogin.submit();
    }
}

function isIP(strIP) {

    var re = /^(\d+)\.(\d+)\.(\d+)\.(\d+)$/g
    if (re.test(strIP)) {
        if (RegExp.$1 < 256 && RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256) return true;
    }
    return false;
}


function isDecimal(s) {
    var patrn = /^(-?\d+)(\.\d+)?$/
    if (!patrn.exec(s)) return false
    return true

}

///////////////////////////////////////////////////////////////////////////////////////////