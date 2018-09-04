/*-------------- �������� --------------
 trim������                         trim() lTrim() rTrim()
 У���ַ����Ƿ�Ϊ�գ�                 isEmpty(str)
 У���ַ����Ƿ�Ϊ���ͣ�               checkIsInteger(str)
 У��������Сֵ��                    checkIntegerMinValue(str,val)
 У���������ֵ��                    checkIntegerMaxValue(str,val)
 У�������Ƿ�Ϊ�Ǹ�����               isNotNegativeInteger(str)
 У���ַ����Ƿ�Ϊ�����ͣ�             checkIsDouble(str)
 У�鸡������Сֵ��                  checkDoubleMinValue(str,val)
 У�鸡�������ֵ��                  checkDoubleMaxValue(str,val)
 У�鸡�����Ƿ�Ϊ�Ǹ�����             isNotNegativeDouble(str)
 ��ȡϵͳ��ǰʱ��                    getSystemDate() yyyy-mm-dd
 У���ַ����Ƿ�Ϊ�����ͣ�             checkIsValidDate(str)
 У���������ڵ��Ⱥ�                checkDateEarlier(strStart,strEnd)
 У���ַ����Ƿ�Ϊemail�ͣ�           checkEmail(str)
 У�����������Ƿ���ȷ               isPostCode(s)
 У���ַ����Ƿ�Ϊ���ģ�               checkIsChinese(str)
 �����ַ����ĳ��ȣ�һ�����������ַ���   realLength()
 У���ַ����Ƿ�����Զ���������ʽ��   checkMask(str,pat)
 �õ��ļ��ĺ�׺����                   getFilePostfix(oFile)
 �������Σ�                                   KeyDown()
 �Ƿ���������ַ�                    CheckSpecialChar(varstr,Special_chars)
 �Ƿ�Ϊ����                          isNumber();
 ȫѡ��ѡ��                          check_all(menu_all,MENU_ID);
 ƥ��IP��ַ��������ʽ              isIP(strIP)
 -------------- �������� --------------
 */
/**
 * ���ñ���
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
        "������",
        "����һ",
        "���ڶ�",
        "������",
        "������",
        "������",
        "������");

    return today.getYear() + "-" + (today.getMonth() + 1) + "-" + today.getDate();
}
/**
 * �����Ƶ�tools.js
 */
function addOption(id, value, text) {

    var data = [
        { value: value, text: text }
    ];
    DWRUtil.addOptions(id, data, "value", "text");
}
/*
 * �Ƿ�ѡ�з�ѡ��
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
 * �Ƿ�ѡ��ȫ��
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
 *ȫѡ��ѡ��
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
 * ȥ������ո���
 * trim:ȥ�����߿ո� lTrim:ȥ����ո� rTrim: ȥ���ҿո�
 * �÷���
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
 *У���ַ����Ƿ�Ϊ��
 *����ֵ��
 *�����Ϊ�գ�����У��ͨ��������true
 *���Ϊ�գ�У�鲻ͨ��������false               �ο���ʾ��Ϣ����������Ϊ�գ�
 */
function isEmpty(str) {
    if (str == null || (str.Trim() == null) || (str.Trim().length == 0)) return true;
    else return(false);
}//~~~
/*--------------------------------- Empty --------------------------------------*/
/********************************** Integer *************************************/
/**
 *У���ַ����Ƿ�Ϊ����
 *����ֵ��
 *���Ϊ�գ�����У��ͨ����      ����true
 *����ִ�ȫ��Ϊ���֣�У��ͨ��������true
 *���У�鲻ͨ����              ����false     �ο���ʾ��Ϣ�����������Ϊ���֣�
 */
function checkIsInteger(str) {
    //���Ϊ�գ���ͨ��У��
    if (str == "")
        return true;
    if (/^(\\-?)(\\d+)$/.test(str))
        return true;
    else
        return false;
}//~~~
/**
 *У��������Сֵ
 *str��ҪУ��Ĵ���  val���Ƚϵ�ֵ
 *
 *����ֵ��
 *���Ϊ�գ�����У��ͨ����                ����true
 *����������������ڵ��ڸ���ֵ��У��ͨ��������true
 *���С�ڸ���ֵ��                        ����false              �ο���ʾ��Ϣ����������С�ڸ���ֵ��
 */
function checkIntegerMinValue(str, val) {
    //���Ϊ�գ���ͨ��У��
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
 *У���������ֵ
 *str��ҪУ��Ĵ���  val���Ƚϵ�ֵ
 *
 *����ֵ��
 *���Ϊ�գ�����У��ͨ����                ����true
 *�������������С�ڵ��ڸ���ֵ��У��ͨ��������true
 *������ڸ���ֵ��                        ����false       �ο���ʾ��Ϣ������ֵ���ܴ��ڸ���ֵ��
 */
function checkIntegerMaxValue(str, val) {
    //���Ϊ�գ���ͨ��У��
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
 *У�������Ƿ�Ϊ�Ǹ���
 *str��ҪУ��Ĵ���
 *
 *����ֵ��
 *���Ϊ�գ�����У��ͨ��������true
 *����Ǹ�����            ����true
 *����Ǹ�����            ����false               �ο���ʾ��Ϣ������ֵ�����Ǹ�����
 */
function isNotNegativeInteger(str) {
    //���Ϊ�գ���ͨ��У��
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
 *У���ַ����Ƿ�Ϊ������
 *����ֵ��
 *���Ϊ�գ�����У��ͨ����      ����true
 *����ִ�Ϊ�����ͣ�У��ͨ����  ����true
 *���У�鲻ͨ����              ����false     �ο���ʾ��Ϣ���������ǺϷ��ĸ�������
 */
function checkIsDouble(str) {
    //���Ϊ�գ���ͨ��У��
    if (str == "")
        return true;
    //�������������У����������Ч��
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
 *У�鸡������Сֵ
 *str��ҪУ��Ĵ���  val���Ƚϵ�ֵ
 *
 *����ֵ��
 *���Ϊ�գ�����У��ͨ����                ����true
 *����������������ڵ��ڸ���ֵ��У��ͨ��������true
 *���С�ڸ���ֵ��                        ����false              �ο���ʾ��Ϣ����������С�ڸ���ֵ��
 */
function checkDoubleMinValue(str, val) {
    //���Ϊ�գ���ͨ��У��
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
 *У�鸡�������ֵ
 *str��ҪУ��Ĵ���  val���Ƚϵ�ֵ
 *
 *����ֵ��
 *���Ϊ�գ�����У��ͨ����                ����true
 *�������������С�ڵ��ڸ���ֵ��У��ͨ��������true
 *������ڸ���ֵ��                        ����false       �ο���ʾ��Ϣ������ֵ���ܴ��ڸ���ֵ��
 */
function checkDoubleMaxValue(str, val) {
    //���Ϊ�գ���ͨ��У��
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
 *У�鸡�����Ƿ�Ϊ�Ǹ���
 *str��ҪУ��Ĵ���
 *
 *����ֵ��
 *���Ϊ�գ�����У��ͨ��������true
 *����Ǹ�����            ����true
 *����Ǹ�����            ����false               �ο���ʾ��Ϣ������ֵ�����Ǹ�����
 */
function isNotNegativeDouble(str) {
    //���Ϊ�գ���ͨ��У��
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
 *У���ַ����Ƿ�Ϊ������
 *����ֵ��
 *���Ϊ�գ�����У��ͨ����           ����true
 *����ִ�Ϊ�����ͣ�У��ͨ����       ����true
 *������ڲ��Ϸ���                   ����false    �ο���ʾ��Ϣ���������ʱ�䲻�Ϸ�����yyyy-MM-dd��
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
 *У���������ڵ��Ⱥ�
 *����ֵ��
 *���������һ������Ϊ�գ�У��ͨ��,          ����true
 *�����ʼ�������ڵ�����ֹ���ڣ�У��ͨ����   ����true
 *�����ʼ����������ֹ���ڣ�                 ����false    �ο���ʾ��Ϣ�� ��ʼ���ڲ������ڽ������ڡ�
 */
function checkDateEarlier(strStart, strEnd) {
    /* if(checkIsValidDate(strStart) == false || checkIsValidDate(strEnd) == false)
     return false;
     //�����һ������Ϊ�գ���ͨ������
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
 * ��ȡϵͳ��ǰʱ��
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
 *У���ַ����Ƿ�Ϊemail��
 *����ֵ��
 *���Ϊ�գ�����У��ͨ����           ����true
 *����ִ�Ϊemail�ͣ�У��ͨ����      ����true
 *���email���Ϸ���                  ����false    �ο���ʾ��Ϣ��Email�ĸ�ʽ�����_��
 */
function checkEmail(str) {
    //���Ϊ�գ���ͨ��У��
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
 *У���ַ����Ƿ�Ϊ����
 *����ֵ��
 *���Ϊ�գ�����У��ͨ����           ����true
 *����ִ�Ϊ���ģ�У��ͨ����         ����true
 *����ִ�Ϊ�����ģ�             ����false    �ο���ʾ��Ϣ������Ϊ���ģ�
 */
function checkIsChinese(str) {
    //���ֵΪ�գ�ͨ��У��
    if (str == "")
        return true;
    var pattern = /^([\\u4E00-\\u9FA5]|[\\uFE30-\\uFFA0])*$/gi;
    if (pattern.test(str))
        return true;
    else
        return false;
}//~~~
/**
 * �����ַ����ĳ��ȣ�һ�����������ַ�
 */
String.prototype.realLength = function () {
    if (this.length > 0)
        return this.replace(/[^\\x00-\\xff]/g, "**").length;
    return 0;
};
/*--------------------------------- chinese --------------------------------------*/
/********************************** mask ***************************************/
/**
 *У���ַ����Ƿ�����Զ���������ʽ
 *str ҪУ����ִ�  pat �Զ����������ʽ
 *����ֵ��
 *���Ϊ�գ�����У��ͨ����           ����true
 *����ִ����ϣ�У��ͨ����           ����true
 *����ִ������ϣ�                   ����false    �ο���ʾ��Ϣ����������***ģʽ
 */
function checkMask(str, pat) {
    //���ֵΪ�գ�ͨ��У��
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
 * �õ��ļ��ĺ�׺��
 * oFileΪfile�ؼ�����
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
 *  �Ƿ���������ַ�
 **/
function CheckSpecialChar(varstr, Special_chars) {


    for (i = 0; i < varstr.length; i++) {
        if (Special_chars.indexOf(varstr.charAt(i)) != -1) {
            return varstr.charAt(i);
        }
    }
    return false;
}

//У��������
function isNumber(s) {
    var patrn = /^\d+$/;
    if (!patrn.exec(s)) return false
    return true
}
//�����й���������
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
//��������Ҽ���Ctrl+n��shift+F10��F5ˢ�¡��˸�� 
//alert("ASCII�����ǣ�"+event.keyCode); 
    if ((window.event.altKey) &&
        ((window.event.keyCode == 37) || //���� Alt+ ����� ��
            (window.event.keyCode == 39))) { //���� Alt+ ����� ��
        alert("��׼��ʹ��ALT+�����ǰ���������ҳ��");
        event.returnValue = false;
    }
    if ((event.keyCode == 8) || //�����˸�ɾ����
        (event.keyCode == 116) || //���� F5 ˢ�¼�
        (event.keyCode == 112) || //���� F1 ˢ�¼�
        (event.ctrlKey && event.keyCode == 82)) { //Ctrl + R
        event.keyCode = 0;
        event.returnValue = false;
    }
    if ((event.ctrlKey) && (event.keyCode == 78)) //���� Ctrl+n
        event.returnValue = false;
    if ((event.shiftKey) && (event.keyCode == 121)) //���� shift+F10
        event.returnValue = false;
    if (window.event.srcElement.tagName == "A" && window.event.shiftKey)
        window.event.returnValue = false; //���� shift ���������¿�һ��ҳ
    if ((window.event.altKey) && (window.event.keyCode == 115)) { //����Alt+F4
        window.showModelessDialog("about:blank", "", "dialogWidth:1px;dialogheight:1px");
        return false;
    }
}


//��������
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
function _getElement(elemid) //param��element id
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
        alert("���������ش���,HTTP״̬���룺" + status);
    } else if (_html == "OK") {
        alert("���Ƴɹ�����ϲ��!");
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