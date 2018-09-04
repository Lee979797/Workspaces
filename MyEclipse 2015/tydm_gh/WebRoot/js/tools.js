special_char = {
    username: "~!#$%^&*+`={}|\">?<,'[]\\",
    searchs: "~!#$%^&*()+`-={}|\">?<,'[]\\",
    passwd: "'",     //   "~!@#$%^&*()_+`-={}|\":?<,'[]\\";
    article: "~@#^&*`{}|\">?<'[]\\"
};
function addOption(id, value, text) {

    var data = [
        { value: value, text: text }
    ];
    DWRUtil.addOptions(id, data, "value", "text");
}
/*
 * 是否选中复选框
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


/********************************** Empty **************************************/
/**
 *校验字符串是否为空
 *返回值：
 *如果不为空，定义校验通过，返回true
 *如果为空，校验不通过，返回false               参考提示信息：输入域不能为空！
 */
function isEmpty(str) {
    if (str == null || (str.trim() == null) || (str.trim().length == 0)) return true;
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
    if (/^(\-?)(\d+)$/.test(str))
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
        return checkIsInteger(str) == true;
    }
    else {
        return /^(\\-?)(\\d+)(.{1})(\\d+)$/g.test(str);
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
        return parseFloat(str) >= parseFloat(val);
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

    /*var pattern = /^[\w-_]+(\.[\w-_]+)*@[\w-_]+(\.[\w-_]+)+$/;
     if (!pattern.exec(s)) return false
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
}
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
    var pattern = /^\d+$/;
    return pattern.exec(s);

}

//检验中国邮政编码
function isPostCode(s) {
    return /^\d{6}$/.test(s);

}

function LoadWindow(URL, Width, Height) {

    loc_x = document.body.scrollLeft + event.clientX - event.offsetX - 100;
    loc_y = document.body.scrollTop + event.clientY - event.offsetY + 140;
    window.showModalDialog(URL, self, "edge:raised;scroll:0;status:0;help:0;resizable:1;dialogWidth:" + Width + "px;dialogHeight:" + Height + "px;dialogTop:" + loc_y + "px;dialogLeft:" + loc_x + "px");


}

/*--------------------------------- file --------------------------------------*/

window.onkeydown = function () {
//屏蔽鼠标右键、Ctrl+n、shift+F10、F5刷新、退格键 
//alert("ASCII代码是："+event.keyCode); 
    if ((window.event.altKey) &&
        ((window.event.keyCode == 37) || //屏蔽 Alt+ 方向键 ←
            (window.event.keyCode == 39))) { //屏蔽 Alt+ 方向键 →
        //   alert("不准您使用ALT+方向键前进或后退网页！");
        event.returnValue = false;
    }
    if (//(event.keyCode == 8) || //屏蔽退格删除键
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

//get one element
function _getElement(elemid) //param：element id
{
    return document.getElementById ? document.getElementById(elemid) : null
}

//get node list
function _getElementList(expr) {//param match expression string
    return document.getElementsByTagName ? document.getElementsByTagName(expr) : [];
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
    var xmlHttp = getXmlHttp();
    if (xmlHttp) {
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4) {
                if (xmlHttp.status == 200) {
                    return xmlHttp.responseText;
                }
            }
        };
        xmlHttp.open("GET", url, false);
        xmlHttp.send(null);
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
        alert("服务器返回错误,HTTP状态代码:" + status);
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

function isURL(url) {
    var strRegex = "^((https|http|ftp|rtsp|mms)?://)"
        + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@
        + "(([0-9]{1,3}.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
        + "|" // 允许IP和DOMAIN（域名）
        + "([0-9a-z_!~*'()-]+.)*" // 域名- www.
        + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]." // 二级域名
        + "[a-z]{2,6})" // first level domain- .com or .museum
        + "(:[0-9]{1,4})?" // 端口- :80
        + "((/?)|" // a slash isn't required if there is no file name
        + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
    var re = new RegExp(strRegex);
    return re.test(url)

}

function isIP(strIP) {

    var re = /^(\d+)\.(\d+)\.(\d+)\.(\d+)$/g;
    if (re.test(strIP)) {
        if (RegExp.$1 < 256 && RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256) return true;
    }
    return false;
}


function isDecimal(s) {
    var pattern = /^(-?\d+)(\.\d+)?$/;
    return pattern.exec(s);


}

function isTel(tel) {
	var partten = /\d{3}-\d{8}|\d{4}-\d{7}/;
	//var pattern = /^((\d{3,4})-?)?(\d{7,8})(-(\d{2,5}))?$/;
    return pattern.exec(tel);

}

function isFax(tel) {
    return isTel(tel);
}

function isPhone(tel) {
    var pattern = /^(\\+?\d{3}-?)?\d{11}$/;
    return pattern.exec(tel);
}

function isEmail(email) {
    var re = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
    return re.test(email);

}

function isPost(post) {
    var pattern = /^\d{6,6}$/g;
    return pattern.exec(post);
}

function isChinese(word) {
    var pattern = /^[^\u4e00-\u9fa5]{0,}$/;
    return pattern.exec(word);
}

function trimIntputValue(obj) {
    if (obj && obj.value)
        obj.value = obj.value.trim();
}

//是否是数字或大写字母
/**
 * @return {boolean}
 */
function isNumberOrBigChar(str) {
    var ch;
    for (var i = 0; i < str.length; i++) {
        ch = str.charAt(i);
        if (!((ch >= 0 && ch <= 9) || (ch >= 'A' && ch <= 'Z'))) {
            return false;
            break;
        }
    }
    return true;
}

//判断起始和截止码段中的字母是否相同
function isSameMd(strqsmd, strjzmd) {
    var result = true;
    var ch1, ch2;
    var index = -1;
    for (var i = 0; i < strqsmd.length; i++) {
        ch1 = strqsmd.charAt(i);
        ch2 = strjzmd.charAt(i);
        if ((ch1 >= 'a' && ch1 <= 'z') || (ch1 >= 'A' && ch1 <= 'Z') ||
            (ch2 >= 'a' && ch2 <= 'z') || (ch2 >= 'A' && ch2 <= 'Z')) {
            index = i;
        }
    }
    if (index > -1) {
        strqsmd_qz = strqsmd.substring(0, index + 1);
        strjzmd_qz = strjzmd.substring(0, index + 1);
        if (strqsmd_qz != strjzmd_qz) {
            result = false;
        }
    }
    return true;
}

//判断整个Form中是否包含了非法的字符
function fItemCheckVaild(thisForm) {
    var aInputs = thisForm.getElementsByTagName("INPUT");
    for (var i = 0; i < aInputs.length; i++) {
        if (aInputs[i].type == "text" && !aInputs[i].readOnly) {
            if (!fIsVaildChar(aInputs[i].value)) {
                alert("输入了空格、'、\"等非法字符！");
                aInputs[i].focus();
                return false;
            }
        }
    }
    aInputs = thisForm.getElementsByTagName("textarea");
    for (var i = 0; i < aInputs.length; i++) {
        if (aInputs[i].type == "textarea" && !aInputs[i].readOnly) {
            if (!fIsVaildChar(aInputs[i].value)) {
                alert("输入了空格、'、\"等非法字符！");
                aInputs[i].focus();
                return false;
                break;
            }
        }
    }
    return true;
}

/**
 * @return {number}
 */
function Clength(s) {
    var l = 0;
    var a = s.split("");
    for (var i = 0; i < a.length; i++) {
        if (a[i].charCodeAt(0) < 299) {
            l++;
        } else {
            l += 2;
        }
    }
    return l;
}

(function () {
    /**
     *
     * 去除多余空格函数
     * trim:去除两边空格 lTrim:去除左空格 rTrim: 去除右空格
     * 用法：
     *     var str = "  hello ";
     *     str = str.trim();
     */
    String.prototype.trim = function () {
        return this.replace(/(^\s+)|(\s+$)/g, "");
    };
    String.prototype.startWith = function (s) {
        return this.indexOf(s) == 0
    };
    String.prototype.endWith = function (s) {
        var d = this.length - s.length;
        return (d >= 0 && this.lastIndexOf(s) == d)
    }
    /**
     * @return {string}
     */
    String.prototype.Trim = function () {
        return this.replace(/(^\s+)|(\s+$)/g, "");
    };
    /**
     * 半角转换为全角
     * @return {string}
     */
    String.prototype.toSBC = function () {
        var tmp = "";
        for (var i = 0; i < this.length; i++) {
            /*if (this.charCodeAt(i) == 32) {
             tmp = tmp + String.fromCharCode(12288);
             }*/
            if (this.charCodeAt(i) == 13) {
                return this;
            }
            if (this.charCodeAt(i) < 127 && this.charCodeAt(i) != 32) {
                tmp = tmp + String.fromCharCode(this.charCodeAt(i) + 65248);
            } else {
                tmp = tmp + this.charAt(i);
            }
        }
        return tmp;
    };
    /**
     * 全角转换为半角函数
     * @return {string}
     */
    String.prototype.toDBC = function () {
        var tmp = "";

        for (var i = 0; i < this.length; i++) {
            if (this.charCodeAt(i) > 65248 && this.charCodeAt(i) < 65375) {
                tmp = tmp + String.fromCharCode(this.charCodeAt(i) - 65248);
            } else {
                tmp = tmp + String.fromCharCode(this.charCodeAt(i));
            }
        }
        return tmp
    };
    /**
     * 计算字符串的长度，一个汉字两个字符
     */
    String.prototype.isCHS = function (i) {
        return this.charCodeAt(i) > 255 || this.charCodeAt(i) < 0;
    };
    String.prototype.realLength = function () {
        var length = 0;
        for (var i = 0; i < this.length; i++) {
            if (this.isCHS(i)) {
                length++;
            }
            length++;
        }
        return length;
    };
    String.prototype.zh_substr = function (start, end) {
        if ((start >= end) || (start >= this.realLength()))
            return "";
        for (var i = 0; i < this.length; i++) {
            if (this.isCHS(i)) {
                if (i < start) {
                    start--;
                }
                if (i < end) {
                    end--;
                }
            }
        }
        return this.substr(start, end);
    };


    window.IdentifyCard = {
        card: '0000000000000000000',
        wi: [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 ],
        verifyCode: [ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ],
        isValidate: function () {
            this.card = this.card.replace(/\s/g, "");
            if (this.card.length == 15) {
                return this.isValidityBrithBy15card();
            } else if (this.card.length == 18) {
                return this.isValidityBrithBy18card() && this.isTrueValidateCodeBy18card();
            } else {
                return false;
            }
        }, isTrueValidateCodeBy18card: function () {
            var cards = this.card.split("");
            var sum = 0; // 声明加权求和变量
            if (cards[17].toLowerCase() == 'x') {
                cards[17] = 10;// 将最后位为x的验证码替换为10方便后续操作
            }
            for (var i = 0; i < 17; i++) {
                sum += this.wi[i] * cards[i];// 加权求和
            }
            var position = sum % 11;// 得到验证码所位置
            return cards[17] == this.verifyCode[position];
        },

        /**
         * 验证18位数身份证号码中的生日是否是有效生日
         * @param card 18位书身份证字符串
         * @return
         */
        isValidityBrithBy18card: function () {
            var year = this.card.substring(6, 10);
            var month = this.card.substring(10, 12);
            var day = this.card.substring(12, 14);
            var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));
            // 这里用getFullYear()获取年份，避免千年虫问题
            return !(temp_date.getFullYear() != parseFloat(year)
                || temp_date.getMonth() != parseFloat(month) - 1
                || temp_date.getDate() != parseFloat(day));
        },
        /**
         * 验证15位数身份证号码中的生日是否是有效生日
         * @param card 15位书身份证字符串
         * @return
         */
        isValidityBrithBy15card: function () {
            var year = this.card.substring(6, 8);
            var month = this.card.substring(8, 10);
            var day = this.card.substring(10, 12);
            var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));
            // 对于老身份证中的你年龄则不需考虑千年虫问题而使用getYear()方法
            return !(temp_date.getYear() != parseFloat(year)
                || temp_date.getMonth() != parseFloat(month) - 1
                || temp_date.getDate() != parseFloat(day));
        }
    };
    window.Tools = {
        isURL: function (url) {
            return /^((((h|H)(t|T)(t|T)(p|P)(s|S)?)|((f|F)(t|T)(p|P))):\/\/)?[A-Za-z0-9]+\.[A-Za-z0-9]+[-\/=?%&_~`@[\]':+!]*([^<>\'\"])*$/.test(url);
        },
        isIP: function (strIP) {
            if (/^(\d+)\.(\d+)\.(\d+)\.(\d+)$/g.test(strIP)) {
                if (RegExp.$1 < 256 && RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256) return true;
            }
            return false;
        },
        isDecimal: function (s) {
            return /^(-?\d+)(\.\d+)?$/.test(s);

        },
        isPhone: function (tel) {
            var pattern = /^1[3458]\d{9}$/;
            return pattern.exec(tel);
        },
        isTel: function (tel) {
        	//var partten = /^(\d{3,4}\-)?\d{7,8}$/i;
        	//var pattern = /^(\d{3,4})?-?\d{7,8}$/g;
        	var pattern = /^((\d{3,4})-?)?(\d{7,8})(-(\d{2,5}))?$/;
            return pattern.exec(tel);
        },
        isFax: function (tel) {
            return this.isTel(tel);
        },
        isPost: function (post) {
            var pattern = /^([0-9])+$/g;
            if (post.length != 6) {
                return false;
            } else {
                return pattern.exec(post);

            }
        },
        isChinese: function (word) {
            //不能输入汉字
            var pattern = /^[^\u4e00-\u9fa5]{0,}$/;
            return pattern.exec(word);

        },

        isEmail: function (email) {
            var re = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
            return !re.test(email);

        },
        isIdentify: function (identify) {
            IdentifyCard.card = identify;
            return IdentifyCard.isValidate();
        }
    };

})();
function showLength(a, b, num) {
	
	b.value =  a.value.realLength();
    /*if (!num) {
    } else {
        if (a.value.realLength() > num) {
            a.value = a.value.zh_substr(0, num);
            ymPrompt.alert({message: "系统限制最大长度" + num + "字符,或者" + (num / 2) + "个汉字！", width: 330, height: 220, title: '提示信息', handler: function () {
                a.focus();
            }});
        }
        b.value = num + a.value.realLength();
    }*/
}
function showFzrLength(){
	var zjhm = $("input[name^='fzr.zjhm']") ;
	var zjhmlength=$("input[name^='fzrzjhmlength']");
for(var i=0;i<zjhm.length-1;i++){
	
	zjhmlength[i].value=zjhm[i].value.length;
      
    }
}
function showMobileLength(){
	var mobile = $("input[name^='fzr.lxmobile']") ;
	var zjhmlength=$("input[name^='fzrsjlength']");
for(var i=0;i<mobile.length-1;i++){
	zjhmlength[i].value=mobile[i].value.length;
      
    }
}
function showDhLength(){
	var lxdh = $("input[name^='fzr.lxdh']") ;
	var zjhmlength=$("input[name^='fzrlxdhlength']");
for(var i=0;i<lxdh.length-1;i++){
	zjhmlength[i].value=lxdh[i].value.length;
      
    }
}
function showFzrLength1(){
	var zjhm = $("input[name^='fzr.zjhm']") ;
	var zjhmlength=$("input[name^='fzrzjhmlength']");
for(var i=0;i<zjhm.length;i++){

	zjhmlength[i].value=zjhm[i].value.length;
      
    }
}
function showMobileLength1(){
	var mobile = $("input[name^='fzr.lxmobile']") ;
	var zjhmlength=$("input[name^='fzrsjlength']");
for(var i=0;i<mobile.length;i++){
	zjhmlength[i].value=mobile[i].value.length;
      
    }
}
function showDhLength1(){
	var lxdh = $("input[name^='fzr.lxdh']") ;
	var zjhmlength=$("input[name^='fzrlxdhlength']");
for(var i=0;i<lxdh.length;i++){
	zjhmlength[i].value=lxdh[i].value.length;
      
    }
}
/*function showLengthZch(a, b, num) {
    if (!num) {
        b.value = a.value.realLength();
    } else {
        if (a.value.realLength() > num) {
            a.value = a.value.zh_substr(0, num);
            ymPrompt.alert({message: "系统限制最大长度" + num + "字符,或者" + (num / 2) + "个汉字！", width: 330, height: 220, title: '提示信息', handler: function () {
                a.focus();
            }});
        }
        b.value = a.value.realLength();
    }
}
*/
function filterKeyUp() {
    var event = window.event || arguments.callee.caller.arguments[0];
    return (event.keyCode == "35" || event.keyCode == "36" || event.keyCode == "37" || event.keyCode == "38" || event.keyCode == "39" || event.keyCode == "40");

}
function onlyDecimal(obj) {
    if (filterKeyUp()) {
        return;
    }
    if (/^(0|([1-9]\d+))$/.test(obj.value)) {
        return;
    }
    obj.value = obj.value.replace(/^0+(.*)$/, '$1');
    obj.value = obj.value.replace(/\D/g, '');
}
function onlyNumber(obj) {
    if (filterKeyUp()) {
        return;
    }
    if (/^\d*$/.test(obj.value)) {
        return;
    }
    obj.value = obj.value.replace(/\D/g, '');
}
function to(href) {
    if (top.location == self.location) {
        //window.opener = null;
        window.opener.location.reload();
        window.open('', '_self');
        window.close();
    } else {
        window.location.href = href;
    }
}
function ches(obj, func) {
    switch (event.keyCode) {
        case 13:
            if (func)
                func();
            else
                obj.submit();
            return false;
        default:
            return true;
    }

}