// =============================================================================
//函数: Trim
//功能  : 
//参数  : string strInputString  Your Input String  
//        string strType		 Your Trim Method Type   
//        sInputString  
//其中  : 0 - Delete Both Space; 1 - Delete Front Space; 2 - Delete Back Space 
// =============================================================================

/**
 * @return {string}
 */
function Trim(strInputString, strType) {
    var strTmp = ' '; //temp string
    var i = -1;
    if (strInputString == undefined || strInputString == "undefined") {
        return "";
    }

    if (strType == 0 || strType == 1) {
        while (strTmp == ' ') {
            ++i;
            strTmp = strInputString.substr(i, 1);
        }
        strInputString = strInputString.substring(i);
    }

    if (strType == 0 || strType == 2) {
        strTmp = ' ';
        i = strInputString.length;
        while (strTmp == ' ') {
            --i;
            strTmp = strInputString.substr(i, 1);
        }
        strInputString = strInputString.substring(0, i + 1);
    }
    return strInputString;
}
//判断是否是正实数，包含小数点
function fCheckFloat(myint) {
    var checkStr = myint;
    var isNumber = true;
    var ch;
    var chStand;
    var j = 0;
    var standardString = "1234567890.";
    for (i = 0; i < checkStr.length; i++) {
        ch = checkStr.charAt(i);
        for (j = 0; j < standardString.length; j++) {
            chStand = standardString.charAt(j);
            if (ch == chStand)
                break;
        }
        if (j == 10) {
            isNumber = false;
            break;
        }
    }
    return isNumber;
}

//判断是否是正整数
function fCheckInt(myint) {
    var checkStr = myint;
    var isNumber = true;
    var ch;
    var j = 0;
    for (i = 0; i < checkStr.length; i++) {
        ch = checkStr.charAt(i);
        for (j = 0; j < 10; j++) {
            if (ch == j) break;
        }
        if (j == 10) {
            isNumber = false;
            break;
        }
    }
    return isNumber;
}
//作废点
function check_int(myint) {
    var checkStr = myint;
    var isNumber = true;
    var ch;
    var j = 0;
    for (i = 0; i < checkStr.length; i++) {
        ch = checkStr.charAt(i);
        for (j = 0; j < 10; j++) {
            if (ch == j)
                break;
        }
        if (j == 10) {
            isNumber = false;
            break;
        }
    }
    return isNumber;
}
//判断是否包含了非法的字符
function fIsVaildChar(str) {
    var checkStr = str;
    var bVaild = true;
    //判断是否包含了空格，',\
    var notVaildChar = "\"'\\";
    var ch;
    var j = 0;
    for (i = 0; i < checkStr.length; i++) {
        ch = checkStr.charAt(i);
        for (j = 0; j < notVaildChar.length; j++) {
            ch2 = notVaildChar.charAt(j);
            if (ch2 == ch) {
                bVaild = false;
                break;
            }
        }
    }
    return bVaild;
}

//是否全部为数字
function IsAllNumbers(str) {
    var flag = true;
    var ch;
    for (var i = 0; i < str.length; i++) {
        ch = str.charAt(i);
        if (!(ch >= 0 && ch <= 9)) {
            flag = false;
            break;
        }
    }
    return flag;
}

//是否是数字或字母
function IsNumberOrChar(str) {
    var flag = true;
    var ch;
    for (var i = 0; i < str.length; i++) {
        ch = str.charAt(i);
        if (!((ch >= 0 && ch <= 9) || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))) {
            flag = false;
            break;
        }
    }
    return flag;
}

//是否是数字或大写字母
function IsNumberOrBigChar(str) {
    var checkStr = str;
    var isNumber = true;
    var ch;
    var j = 0;
    for (i = 0; i < checkStr.length; i++) {
        ch = checkStr.charAt(i);
        if (!((ch >= 0 && ch <= 9) || (ch >= 'A' && ch <= 'Z'))) {
            isNumber = false
            break;
        }
    }
    return isNumber;
}

//判断是否含有某字符
function check_ch(str, sch) {
    var allRight = false;
    for (i = 0; i < str.length; i++) {
        ch = str.charAt(i);
        if (ch == sch) {
            allRight = true;
            break;
        }
        else {
        }
    }
    return allRight;
}


//判断字符串是否包含',"
function checkstring(str) {
    var allRight = false;

    for (i = 0; i < str.length; i++) {
        ch = str.charAt(i);
        if (ch == "'" || ch == "\"") {
            allRight = true;
            break;
        } else {
        }
    }
    return allRight;
}


//判断时间段
//按照输入的时，分，秒 Input
function CheckTime(oHour, oMinute, oSecond) {
    var strH;					   //string year
    var strM;                      //string month
    var strS;					   //string date
    strH = oHour.value;
    strM = oMinute.value;
    strS = oSecond.value;
    if (strH.length != 2) {
        alert("小时的位数为2位!")
        oHour.focus();
        return false;
    }
    if (strM.length != 2) {
        alert("分钟的位数为2位!")
        oMinute.focus();
        return false;
    }
    if (strS.length != 2) {
        alert("秒的位数为2位!")
        oSecond.focus();
        return false;
    }

    if (strH < 0 || strH >= 24) {
        alert("您输入的小时无效，应为24时制")
        oHour.focus();
        return false;
    }

    if (strM < 0 || strM >= 60) {
        alert("您输入的分钟无效")
        oMinute.focus();
        return false;
    }

    if (strS < 0 || strS >= 60) {
        alert("您输入的秒无效")
        oSecond.focus();
        return false;
    }
    return true;
}

//判断二个日期是否相差固定的长度，
//aflag:"Y" 年份相差小于等于 anum
//aflag:"M" 月份相差小于等于 anum
//aflag:"Y" 日期相差小于等于 anum

function fCheckRelativeDate(oFirst, oLast, aFlag, aNum) {
    var strStart;
    var strEnd;
    strStart = oFirst.value;
    strEnd = oLast.value;
    switch (aFlag) {
        case "Y":
        {
            strFirstItem = strStart.substring(0, 4);
            strLastItem = strEnd.substring(0, 4);
            if (parseInt(strFirstItem) + aNum != parseInt(strLastItem)) {
                alert("年份应该相差" + aNum);
                oLast.focus();
                return false;
            }
            break;
        }
        case "M":
        {
            strFirstItem = strStart.substring(5, 7);
            strLastItem = strEnd.substring(5, 7);
            if (parseInt(strFirstItem) + aNum != parseInt(strLastItem)) {
                alert("月份应该相差" + aNum);
                oLast.focus();
                return false;
            }
            break;
        }
        case "D":
        {
            strFirstItem = strStart.substring(8, 10);
            strLastItem = strEnd.substring(8, 10);
            if (parseInt(strFirstItem) + aNum != parseInt(strLastItem)) {
                alert("日期应该相差" + aNum);
                oLast.focus();
                return false;
            }
            break;

        }
    }
    return true;
}

//判断二个日期是否相差固定的长度，
//aflag:"Y" 年份相差小于等于 anum
//aflag:"M" 月份相差小于等于 anum
//aflag:"Y" 日期相差小于等于 anum

function fCheckDateSpecialYear(oFirst, oLast, aNum) {
    var strStart;
    var strEnd;
    var iTemp;
    var strStartTemp;
    strStart = oFirst.value;
    strEnd = oLast.value;
    var strFirstItem = strStart.substring(0, 4);
    iTemp = parseInt(strFirstItem) + aNum;
    strStartTemp = iTemp.toString() + "-" + strStart.substring(5, 10);
    if ((strStart > strEnd) || (strStartTemp < strEnd)) {
        return false;
    }
    return true;
}
//判断日期
//按照
function CheckDate(oDate) {
    var strY;					   //string year
    var strM;                      //string month
    var strD;					   //string date
    var blnFlag;                   //mark leap year
    var strBetweenYM              //string between year and month
    var strBetweenMD              //string between month and date
    var i                         //loop
    var strTemp                   //temp string

    strDate = oDate.value;

    if (strDate.length != 10) {
        ymPrompt.alert({message: "格式为:yyyy-mm-dd", width: 330, height: 220, title: '提示信息'});
        oDate.focus();
        return false;
    }
    strY = strDate.substring(0, 4);
    strM = strDate.substring(5, 7);
    strD = strDate.substring(8, 10);
    strFlag = strDate.substring(4, 5);
    if (strFlag != "-") {
        ymPrompt.alert({message: '格式为:yyyy-mm-dd', width: 330, height: 220, title: '提示信息'});
        oDate.focus();
        return false;
    }
    strFlag = strDate.substring(7, 8);
    if (strFlag != "-") {
        ymPrompt.alert({message: '格式为:yyyy-mm-dd', width: 330, height: 220, title: '提示信息'});
        oDate.focus();
        return false;
    }

    if (strDate < "1900-01-01") {
        ymPrompt.alert({message: '日期应该大于1900-01-01', width: 330, height: 220, title: '提示信息'});
        oDate.focus();
        return false;

    }
    if (strDate > "2100-12-31") {
        ymPrompt.alert({message: '日期应该小于2100-12-31', width: 330, height: 220, title: '提示信息'});
        oDate.focus();
        return false;

    }

    if (strY.length != 4) {
        ymPrompt.alert({message: '年份为4位!', width: 330, height: 220, title: '提示信息'});
        oDate.focus();
        return false;

    }
    if (strM.length != 2) {
        ymPrompt.alert({message: '月份为2位!', width: 330, height: 220, title: '提示信息'});
        oDate.focus();
        return false;
    }
    if (strD.length != 2) {
        ymPrompt.alert({message: '日期为2位!', width: 330, height: 220, title: '提示信息'});
        oDate.focus();
        return false;
    }

    if (strY % 4 == 0) {
        if (strY % 100 == 0) {
            if (strY % 400 == 0) {
                blnFlag = true;
            }
            else {
                blnFlag = false;
            }
        }
        else {
            blnFlag = true;
        }
    }
    else {
        blnFlag = false;
    }


    switch (strM) {
        case "01":
        {
            if (strD >= 1 && strD <= 31) {
                return true;
            }
            else {
                ymPrompt.alert({message: '日期有误!', width: 330, height: 220, title: '提示信息'});
                oDate.focus();
                return false;
            }
            break;
        }
        case "02":
        {
            if (blnFlag) {
                if (strD >= 1 && strD <= 29) {
                    return true;
                }
                else {
                    ymPrompt.alert({message: '日期有误!', width: 330, height: 220, title: '提示信息'});
                    oDate.focus();
                    return false;
                }
            }
            else {
                if (strD >= 1 && strD <= 28) {
                    return true;
                }
                else {
                    ymPrompt.alert({message: '日期有误!', width: 330, height: 220, title: '提示信息'});
                    oDate.focus();
                    return false;
                }
            }
            break;
        }
        case "03":
        {
            if (strD >= 1 && strD <= 31) {
                return true;
            }
            else {
                ymPrompt.alert({message: '日期有误!', width: 330, height: 220, title: '提示信息'});
                oDate.focus();
                return false;
            }
            break;
        }
        case "04":
        {
            if (strD >= 1 && strD <= 30) {
                return true;
            }
            else {
                ymPrompt.alert({message: '日期有误!', width: 330, height: 220, title: '提示信息'});
                oDate.focus();
                return false;
            }
            break;
        }
        case "05":
        {
            if (strD >= 1 && strD <= 31) {
                return true;
            }
            else {
                ymPrompt.alert({message: '日期有误!', width: 330, height: 220, title: '提示信息'});
                oDate.focus();
                return false;
            }
            break;
        }
        case "06":
        {
            if (strD >= 1 && strD <= 30) {
                return true;
            }
            else {
                ymPrompt.alert({message: '日期有误!', width: 330, height: 220, title: '提示信息'});
                oDate.focus();
                return false;
            }
            break;
        }
        case "07":
        {
            if (strD >= 1 && strD <= 31) {
                return true;
            }
            else {
                ymPrompt.alert({message: '日期有误!', width: 330, height: 220, title: '提示信息'});
                oDate.focus();
                return false;
            }
            break;
        }
        case "08":
        {
            if (strD >= 1 && strD <= 31) {
                return true;
            }
            else {
                ymPrompt.alert({message: '日期有误!', width: 330, height: 220, title: '提示信息'});
                oDate.focus();
                return false;
            }
            break;
        }
        case "09":
        {
            if (strD >= 1 && strD <= 30) {
                return true;
            }
            else {
                ymPrompt.alert({message: '日期有误!', width: 330, height: 220, title: '提示信息'});
                oDate.focus();
                return false;
            }
            break;
        }
        case "10":
        {
            if (strD >= 1 && strD <= 31) {
                return true;
            }
            else {
                ymPrompt.alert({message: '日期有误!', width: 330, height: 220, title: '提示信息'});
                oDate.focus();
                return false;
            }
            break;
        }
        case "11":
        {
            if (strD >= 1 && strD <= 30) {
                return true;
            }
            else {
                ymPrompt.alert({message: '日期有误!', width: 330, height: 220, title: '提示信息'});
                oDate.focus();
                return false;
            }
            break;
        }
        case "12":
        {
            if (strD >= 1 && strD <= 31) {
                return true;
            }
            else {
                ymPrompt.alert({message: '日期有误!', width: 330, height: 220, title: '提示信息'});
                oDate.focus();
                return false;
            }
            break;
        }
        default:
        {
            ymPrompt.alert({message: '月份有误!', width: 330, height: 220, title: '提示信息'});
            oDate.focus();
            return false;
        }
    }

}
function IsCorrDate(strDate) {
    var strY;					   //string year
    var strM;                      //string month
    var strD;					   //string date
    var blnFlag;                   //mark leap year

    if (strDate.length != 10) {
        alert("日期格式长度10位!格式为:yyyy-mm-dd")
        oDate.focus();
        return false;
    }
    strY = strDate.substring(0, 4);
    strM = strDate.substring(5, 7);
    strD = strDate.substring(8, 10);
    strFlag = strDate.substring(4, 5);
    if (strFlag != "-") {
        //alert("格式为:yyyy-mm-dd")
        return false;
    }
    strFlag = strDate.substring(7, 8);
    if (strFlag != "-") {
        //alert("格式为:yyyy-mm-dd")
        return false;
    }

    if (strDate < "1900-01-01") {
        //alert("日期应该大于1900-01-01")
        return false;

    }
    if (strDate > "2100-12-31") {
        //alert("日期应该小于2100-12-31")
        return false;

    }

    if (strY.length != 4) {
        //alert("年份为4位!")
        return false;

    }
    if (strM.length != 2) {
        //alert("月份为2位!")
        return false;
    }
    if (strD.length != 2) {
        //alert("日期为2位!")
        return false;
    }

    if (strY % 4 == 0) {
        if (strY % 100 == 0) {
            if (strY % 400 == 0) {
                blnFlag = true;
            }
            else {
                blnFlag = false;
            }
        }
        else {
            blnFlag = true;
        }
    }
    else {
        blnFlag = false;
    }


    switch (strM) {
        case "01":
        {
            if (strD >= 1 && strD <= 31) {
                return true;
            }
            else {
                //alert("日期有误!")
                return false;
            }
            break;
        }
        case "02":
        {
            if (blnFlag) {
                if (strD >= 1 && strD <= 29) {
                    return true;
                }
                else {
                    //alert("日期有误!")
                    return false;
                }
            }
            else {
                if (strD >= 1 && strD <= 28) {
                    return true;
                }
                else {
                    //alert("日期有误!")
                    return false;
                }
            }
            break;
        }
        case "03":
        {
            if (strD >= 1 && strD <= 31) {
                return true;
            }
            else {
                //alert("日期有误!")
                return false;
            }
            break;
        }
        case "04":
        {
            if (strD >= 1 && strD <= 30) {
                return true;
            }
            else {
                //alert("日期有误!")
                return false;
            }
            break;
        }
        case "05":
        {
            if (strD >= 1 && strD <= 31) {
                return true;
            }
            else {
                //alert("日期有误!")
                return false;
            }
            break;
        }
        case "06":
        {
            if (strD >= 1 && strD <= 30) {
                return true;
            }
            else {
                //alert("日期有误!")
                return false;
            }
            break;
        }
        case "07":
        {
            if (strD >= 1 && strD <= 31) {
                return true;
            }
            else {
                //alert("日期有误!")
                return false;
            }
            break;
        }
        case "08":
        {
            if (strD >= 1 && strD <= 31) {
                return true;
            }
            else {
                //alert("日期有误!")
                return false;
            }
            break;
        }
        case "09":
        {
            if (strD >= 1 && strD <= 30) {
                return true;
            }
            else {
                //alert("日期有误!")
                return false;
            }
            break;
        }
        case "10":
        {
            if (strD >= 1 && strD <= 31) {
                return true;
            }
            else {
                //alert("日期有误!")
                return false;
            }
            break;
        }
        case "11":
        {
            if (strD >= 1 && strD <= 30) {
                return true;
            }
            else {
                //alert("日期有误!")
                return false;
            }
            break;
        }
        case "12":
        {
            if (strD >= 1 && strD <= 31) {
                return true;
            }
            else {
                //alert("日期有误!")
                return false;
            }
            break;
        }
        default:
        {
            //alert("月份有误!")
            return false;
        }
    }

}
// =============================================================================
//函数: AddChar
//功能  : add many characters to the string
//参数  : string  strSrc		 source string 
//		  integer intNumber		 the number of char you want to add
//        string  strChar		 the char you want to add
//		  integer intType		 0: add char before the string
//								 1: add char behand the string  
//返回: String   the string added the char 
//补充  : 
// =============================================================================
function AddChar(strSrc, intNumber, strChar, intType) {
    var i;			// loop variable
    var intLength;	// source string length
    var strDest;	// destination

    if (strSrc == null) {
        intLength = 0;
    }
    else {
        intLength = strSrc.length;
    }

    strDest = "";
    for (i = 0; i < (intNumber - intLength); i++) {
        strDest = strDest + strChar;
    }

    if (intType == 1) {
        // add char behand the string
        strDest = strSrc + strDest;
    }
    else {
        // add char before the string
        strDest = strDest + strSrc;
    }
    return(strDest);
}


// =============================================================================
//函数: CheckMoney
//功能  : This fuction validate the strMoney.
//输入  : string strMoney		Money string 
//返回: Boolean			true: The strmoney is valid.
//							false:The strMoney is invalid. 
//补充  : 
// =============================================================================
function CheckMoney(strMoney) {
    var strNumber;    // string that having delete comma

    var i;            // temp variable

    strNumber = DeleteComma(strMoney);
    if (strNumber.charAt(0) == "-") {
        for (i = 1; i < strNumber.length; i++) {
            if (strNumber.charAt(i) < "0" || strNumber.charAt(i) > "9") {
                return false;
            }
        }
    }
    else {
        for (i = 0; i < strNumber.length; i++) {
            if (strNumber.charAt(i) < "0" || strNumber.charAt(i) > "9") {
                return false;
            }
        }
    }


    return true;
}

// =============================================================================
//函数: CheckAscii
//功能  : This fuction validate the strMoney.
//输入  : string strInput		input string 
//输出: Boolean			true: The strInput is valid.
//							false:The strInput is invalid. 
//补充  : 
// =============================================================================
function CheckAscii(strInput) {
    var i;		// loop variable

    for (i = 0; i < strInput.length; i++) {
        if ((strInput.charCodeAt(i) >= 32) && (strInput.charCodeAt(i) <= 126)) {
        }
        else {
            return false;
        }

    }

    return true;
}

//判断输入是否合法
function isOK(form, q) {

    if (form.currpage.value == "") {
        alert("请输入跳转页码");
        form.currpage.focus();
        return false;
    }

    if (check_space(form.currpage.value)) {
        alert("跳转页码输入不允许出现空格");
        form.currpage.focus();
        return false;
    }

    if (!check_int(form.currpage.value)) {
        alert("输入的跳转页码不包含字母或汉字");
        form.currpage.focus();
        return false;
    }

    if (form.currpage.value < 1 || form.currpage.value > q) {
        alert("跳转页码范围不正确,正确范围: 1 to " + q);
        form.currpage.focus();
        return false;
    }

    //return true;
    return true;
}
function fHasSpecialString(thisString, strCheckString) {
    var allValid = false;
    for (i = 0; i < thisString.length; i++) {
        ch = thisString.charAt(i);
        for (j = 0; j < strCheckString.length; j++) {
            if (ch == strCheckString.charAt(j))
                break;
        }
        if (j < strCheckString.length) {
            allValid = true;
            break;
        }
    }
    return allValid;
}
function fCheckSpecialString(thisString, strCheckString) {
    var reg = new RegExp("[" + strCheckString + "]");
    var allValid = true;
    for (i = 0; i < thisString.length; i++) {
        ch = thisString.charAt(i);
        for (j = 0; j < strCheckString.length; j++) {
            if (ch == strCheckString.charAt(j))
                break;
        }
        if (j == strCheckString.length) {
            allValid = false;
            break;
        }
    }
    return allValid;
}


//判断是否含有空格
function check_space(str) {
    var allValid = false;
    for (i = 0; i < str.length; i++) {
        ch = str.charAt(i);
        if (ch == " ") {
            ymPrompt.alert({message: "输入了空格!", width: 330, height: 220, title: '提示信息'});
            allValid = true;
            break;
        }
        else {
        }
    }
    return allValid;

}
//身份证是否满足检验要求
//aflag 18检验18位的身份证,检验其检验码
//aflag 15检验15位的身份证中6位日期的有效性
function fIsIDCheckCode(aStrCode, aFlag) {
    var strOrigin = "";
    //判断前17位


    var wi = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1);
    var i = 0;
    var sum = 0;
    var ai = new Array("1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2");
    var strCheck = "";
    if (aFlag == 18) {
        strOrigin = aStrCode.substring(0, 17);
        //按照检验算法进行运算
        for (i = 0; i < 17; i++) {
            strCheck = strOrigin.substring(i, i + 1);
            //alert(strCheck);
            sum = sum + wi[i] * parseInt(strCheck);
            //alert(sum);
        }
        sum = sum % 11;
        strOrigin = strOrigin + ai[sum];
        if (strOrigin == aStrCode) {
            return true;
        } else {
            return false;
        }

    } else {
        strOrigin = aStrCode.substring(6, 12);
        strCheck = "19" + strOrigin.substring(0, 2) + "-" + strOrigin.substring(2, 4) + "-" + strOrigin.substring(4, 6);
        /*strCheck=strOrigin.substring(0,2);
         if (!(strCheck>="00" && strCheck<="99")){
         return false;
         }
         strCheck=strOrigin.substring(2,4);
         if (!(strCheck>="01" && strCheck<="12")){
         return false;
         }
         strCheck=strOrigin.substring(4,6);
         if (!(strCheck>="01" && strCheck<="31")){
         return false;
         }*/
        return IsCorrDate(strCheck);
    }
}

//检验身份证输入有效性
function fCheckIdentify(thisObject) {
    var title = '身份证号';
    if (thisObject.id != 'zjhm') {
        title = '经办人证件号码';
    }
    var allValid = true;
    var strVar = thisObject.value;
    if (!(/*strVar.length == 15 ||*/ strVar.length == 18)) {
        /*ymPrompt.alert('输入的身份证号长度不正确!', 330, 220, '提示信息', function (data) {
         if (data == "ok") {
         thisObject.focus();
         }
         });
         allValid = false;
         return allValid;*/
        if (thisObject.id == 'zjhm') {
            document.getElementById("zjhmInfo").innerHTML = '身份证号码长度不正确!';
            return false;
        } else {
            document.getElementById("jbrzjhmInfo").innerHTML = '经办人证件号码长度不正确!';
            return false;
        }
        /*if (!confirm("输入的"+title+"长度不正确，您确认要保存吗？")) {
         thisObject.focus();
         return false;
         }*/
    }
    /*if (strVar.length == 15) {
     if (!fCheckSpecialString(strVar, "0123456789")) {
     */
    /*ymPrompt.alert('输入的身份证号中有非法字符!', 330, 220, '提示信息', function (data) {
     if (data == "ok") {
     thisObject.focus();
     }
     });
     allValid = false;
     return allValid;*/
    /*

     */
    /*if (!confirm("输入的"+title+"中有非法字符，您确认要保存吗？")) {
     thisObject.focus();
     return false;
     }*/
    
    /*
     if (thisObject.id == 'zjhm') {
    	 document.getElementById("zjhmInfo").innerHTML = '身份证号码中有非法字符!';
    	 return false;
     } else {
    	 document.getElementById("jbrzjhmInfo").innerHTML = '经办人证件号码中有非法字符!';
    	 return false;
     }
     */

     

//     if (!fIsIDCheckCode(strVar, 15)) {
    
    /*ymPrompt.alert('输入的身份证号无效!', 330, 220, '提示信息', function (data) {
     if (data == "ok") {
     thisObject.focus();
     }
     });
     allValid = false;
     return allValid;*/
    /*
     */
    /*if (!confirm("输入的"+title+"无效，您确认要保存吗？")) {
     thisObject.focus();
     return false;
     }*/
    /*

     if (thisObject.id == 'zjhm') {
     document.getElementById("zjhmInfo").innerHTML = '身份证号码无效!';
     return false;
     } else {
     document.getElementById("jbrzjhmInfo").innerHTML = '经办人证件号码无效!';
     return false;
     }

     }

     }*/
    if (strVar.length == 18) {
        if (!fIsIDCheckCode(strVar, 18)) {
            /*ymPrompt.alert('输入的身份证号无效!', 330, 220, '提示信息', function (data) {
             if (data == "ok") {
             thisObject.focus();
             }
             });
             allValid = false;
             return allValid;*/

            /*if (!confirm("输入的"+title+"无效，您确认要保存吗？")) {
             thisObject.focus();
             return false;
             }*/
            if (thisObject.id == 'zjhm') {
                document.getElementById("zjhmInfo").innerHTML = '身份证号码不符合国家编码规则，请确认是否输入正确!';
                return false;
            } else {
                document.getElementById("jbrzjhmInfo").innerHTML = '经办人证件号码不符合国家编码规则，请确认是否输入正确!';
                return false;
            }
        }
    }
    return allValid;
}

//检验邮政编码输入有效性
function fCheckPostCode(thisObject, title) {
    var allValid = true;
    var strVar = thisObject.value;
    if (strVar.length != 6) {
        ymPrompt.alert('输入的' + title + '长度不正确!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;
    }
    if (!fCheckSpecialString(strVar, "0123456789")) {
        ymPrompt.alert('输入的' + title + '中有非法字符!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;

    }
    if (strVar.substring(0, 2) == "00") {
        ymPrompt.alert('输入的' + title + '不正确!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;
    }
    return allValid;
}

//检验电话号码输入有效性
function fCheckTelecom(thisObject, title) {
    var allValid = true;
    var strVar = thisObject.value;
    var reg = /^((1[358]\d{9})|((0\d{2,3}-?)?\d{7,8}(-?\d{1,6})?))$/;
    if (!reg.test(thisObject.value)) {
        ymPrompt.alert('输入的' + title + '格式不正确!正确格式,例如:03123456789-123或13123456789!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;
    }
    return allValid;
}

//判断经办人手机
function fCheckJbrTel(thisObject, title) {
    var flag = true;
    var strVar = thisObject.value;
    var strFirst = strVar.substring(0, 1);
    if (strFirst == '1') {
        if (!isPhone(strVar)) {
            ymPrompt.alert('输入的经办人手机号格式不正确!正确格式,例如:13581888888', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    thisObject.focus();
                }
            });
            flag = false;
            return flag;
        }
    } else {
        if (!fCheckTelecom(thisObject, "经办人手机")) {
            flag = false;
            return flag;
        }
    }
    return flag;

}

//检验移动电话输入有效性
function fCheckMobile(thisObject) {
    var allValid = true;
    var strVar = thisObject.value;
    var strFirst = strVar.substring(0, 1);

    if (strVar.length < 7) {
        ymPrompt.alert('输入的法人手机长度不正确!正确格式,例如:13581888888', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;
    }
    if (!fCheckSpecialString(strVar, "0123456789")) {
        ymPrompt.alert('输入的法人手机中有非法字符!正确格式,例如:13581888888', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;

    }
    if (strFirst == "1") {
        if (strVar.length != 11) {
            ymPrompt.alert('输入的法人手机长度不正确!正确格式,例如:13581888888', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    thisObject.focus();
                }
            });
            allValid = false;
        } else {
            if (!fCheckSpecialString(strVar.substring(1, 2), "3458")) {
                ymPrompt.alert('输入的法人手机不正确!正确格式,例如:13581888888', 330, 220, '提示信息', function (data) {
                    if (data == "ok") {
                        thisObject.focus();
                    }
                });
                allValid = false;
            }
        }
        return allValid;
    }
    return allValid;
}

//检验注册资金输入有效性
function fCheckZczj(thisObject) {
    var allValid = true;
    if (checkZCZJ(document.getElementById("zczj"), "注册资金")) {
        return false;
    }
    var strVar = thisObject.value;
    if (strVar.length > 14) {
        ymPrompt.alert('输入的注册资金长度不正确!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;
    }
    if (!fCheckSpecialString(strVar, "0123456789.")) {
        ymPrompt.alert('输入的注册资金中有非法字符!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;

    }
    return allValid;
}

//检验发卡数量输入有效性
function fCheckFksl(thisObject) {
    var allValid = true;
    var strVar = thisObject.value;

    if (strVar.length >= 3) {
        ymPrompt.alert('输入的发卡数量长度不正确!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;
    }
    if (!fCheckSpecialString(strVar, "0123456789")) {
        ymPrompt.alert('输入的发卡数量中有非法字符!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;

    }
    return allValid;
}

//判断数字
function fCheckInteger(thisObject, strTitle) {
    var allValid = true;
    var strVar = thisObject.value;
    if (!fCheckSpecialString(strVar, "0123456789")) {
        ymPrompt.alert('输入的' + strTitle + '中有非法字符!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;

    }
    return allValid;
}
//判断机构代码
function fCheckJgdm(thisObject, strTitle) {
    var allValid = true;
    var strVar = thisObject.value;
    if (strVar.length != 9) {
        ymPrompt.alert('输入的' + strTitle + '长度不正确!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;
    }
    if (!fCheckSpecialString(strVar, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ")) {
        ymPrompt.alert('输入的' + strTitle + '中有非法字符!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;

    }
    return allValid;
}
//判断注册号
function fCheckZch(thisObject) {
    var allValid = true;
    var strVar = thisObject.value;
    //如果不全是数字，则检查长度不小于6
    if (strVar.length < 6) {
        ymPrompt.alert('输入的注册号长度至少为6!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
    }
    /*if (strVar.replace(/[^\x00-\xff]/g, "**").length > 35) {
     ymPrompt.alert('输入的注册号字节大于35,请修改后保存!', 330, 220, '提示信息', function (data) {
     if (data == "ok") {
     thisObject.focus();
     }
     });
     allValid = false;
     }*/
    return allValid;
}

//判断机构类型是否为空
function checkJglxItem(thisObject, strTitle) {
    var valid = false;
    if (thisObject.value == 0) {
        ymPrompt.alert(strTitle + "不允许为空!", 330, 220, "提示信息", function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        valid = true;
        return valid;
    }
    return valid;
}


function checkItem(obj,title) {
    if (!(obj && obj.value && obj.value.trim() != "")) {
        ymPrompt.alert(title + "不允许为空!", 330, 220, "提示信息", function (data) {
            if (data == "ok") {
                obj.focus();
            }
        });
        return true;
    }
    return false;
}
function checkZCZJ(object, title) {
    var reg = /^(([0-9]\d{0,8})|(\d{1,9}\.\d{1,4}))$/g;
    if (reg.test(object.value)) {
        return false;
    } else {
        ymPrompt.alert(title + "应小于等于14位并包含4位小数，请重新输入!例如：123456789.1234", 330, 220, "提示信息", function (data) {
            if (data == "ok") {
                object.focus();
            }
        });
        return true;
    }

}
//判断整个Form中是否包含了非法的字符
function fItemCheckVaild(thisForm) {
    var jglxVal = "";
    if (document.getElementById("jglx") != undefined) {
        jglxVal = document.getElementById("jglx").value;
    }
    var bVaild = true;
    var aInputs = thisForm.getElementsByTagName("INPUT");
    var i = 0;
    if (aInputs != null) {
        for (i = 0; i < aInputs.length; i++) {
            if (aInputs[i].type == "text" && !(aInputs[i].readOnly)) {
                if (jglxVal == '4' || jglxVal == '7' || jglxVal == '8' || jglxVal == '9') {
                    if (aInputs[i].id != "memo" && aInputs[i].id != "memo2" && aInputs[i].id != "memo3" && aInputs[i].id != "memo4" && aInputs[i].id != "bak1" && aInputs[i].id != "bak2" && aInputs[i].id != "bak3" && aInputs[i].id != "bak4" && aInputs[i].id != "bak5" && aInputs[i].id != "pzjgdm") {
                        if (!fIsVaildChar(aInputs[i].value)) {
                            var obj = aInputs[i];
                            ymPrompt.alert("输入了('、\")等非法字符！", 330, 220, '提示信息', function (data) {
                                if (data == "ok") {
                                    obj.focus();
                                }
                            });
                            bVaild = false
                            break;
                        }
                    }
                } else {
                    if (aInputs[i].id != "memo" && aInputs[i].id != "memo2" && aInputs[i].id != "memo3" && aInputs[i].id != "memo4" && aInputs[i].id != "bak1" && aInputs[i].id != "bak2" && aInputs[i].id != "bak3" && aInputs[i].id != "bak4" && aInputs[i].id != "bak5") {
                        if (!fIsVaildChar(aInputs[i].value)) {
                            var obj = aInputs[i];
                            ymPrompt.alert("输入了('、\")等非法字符！", 330, 220, '提示信息', function (data) {
                                if (data == "ok") {
                                    obj.focus();
                                }
                            });
                            bVaild = false
                            break;
                        }
                    }
                }
            }
        }
    }
    aInputs = thisForm.getElementsByTagName("TEXTAREA");
    i = 0;
    if (aInputs == null)
        return true;
    for (i = 0; i < aInputs.length; i++) {
        if (aInputs[i].type == "TEXTAREA" && !aInputs[i].readOnly) {
            if (!fIsVaildChar(aInputs[i].value)) {
                var obj = aInputs[i];
                ymPrompt.alert('输入了(\'、\")等非法字符！', 330, 220, '提示信息', function (data) {
                    if (data == "ok") {
                        obj.focus();
                    }
                });
                bVaild = false;
                break;
            }
        }
    }
    return bVaild;
}
//若不为空,判断各个项目的内容
function fCheckEssItem(frmThis) {
    var allValid = true;
    var strName;

    var strZcrq = document.getElementById("zcrq").value;
    var strBzrq = document.getElementById("bzrq").value;
    var strClrq = document.getElementById("zcrq").value;
    var strYxqx = document.getElementById("yxqxs").value;
    var strZfrq = document.getElementById("zfrq").value;
    var strZjlx = document.getElementById("zjlx").value;
    var strZjhm = document.getElementById("zjhm").value;
    var yzbm = document.getElementById("yzbm");
    var jyyb = document.getElementById("jyyb");
    var rzsj = $("input[name^='fzr.memo1']");
    var strZczj = document.getElementById("zczj").value;
  /*  var strNjqx = document.getElementById("njqx").value;
    var strGsfzrq = document.getElementById("gsfzrq").value;
    var strFksl = document.getElementById("fksl").value;*/
    //var strZgrs = document.getElementById("zgrs").value;
    var strNow = new Date();
    //判断是否有非法字符
    if (!fItemCheckVaild(frmThis)) {
        return false;
    }
    //判断一些特殊的项目
    if (strZjlx == "0") {
        /*//是身份证,15,18位，与法定代表人的关联判断 
         if (strZjhm != "") {
         if (!fCheckIdentify(document.getElementById("zjhm"))) {
         return false;
         }
         }*/
        /*if (fHasSpecialString(document.getElementById("fddbr").value, "\" '\\1234567890ABCEFGJOKLLMNOPQRSTUVWXYZ")) {
         ymPrompt.alert('输入的法人代表中含有非法字符!', 330, 220, '提示信息', function (data) {
         if (data == "ok") {
         document.getElementById("fddbr").focus();
         }
         });
         return false;
         }*/
    } else {
        if (document.getElementById("fddbr").value.replace(/[^\x00-\xff]/g, "**").length > 100) {
            ymPrompt.alert('输入的法人代表字节大于100,请修改后保存!', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    document.getElementById("fddbr").focus();
                }
            });
            return false;
        }
    }

    if (strZcrq != "") {
        if (!CheckDate(document.getElementById("zcrq"))) {
            return false;
        }
    }
    if (strBzrq != "") {
        if (!CheckDate(document.getElementById("bzrq"))) {
            return false;
        }
    }
    if (strZfrq != "") {
        if (!CheckDate(document.getElementById("zfrq"))) {
            return false;
        }
    }
   /* if (strNjqx != "") {
        if (!CheckDate(document.getElementById("njqx"))) {
            return false;
        }
    }
    if (strGsfzrq != "") {
        if (!CheckDate(document.getElementById("gsfzrq"))) {
            return false;
        }
    }*/
    //判断作废日期，年检日期，办证日期
/*    if (strNjqx != "" && strBzrq != "" && strZfrq != "") {
        if (!dateCompare(strNjqx,strBzrq )) {
            ymPrompt.alert('年检期限应该大于办证日期!', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    document.getElementById("njqx").focus();
                }
            });
            return false;
        }
        var scnj = document.getElementById("scnj");
        if (scnj && !scnj.value) {
            if (!fCheckDateSpecialYear(scnj, document.getElementById("njqx"), 1)) {
                ymPrompt.alert('年检期限不能超过上次年检日期1年，请重新输入!', 330, 220, '提示信息', function (data) {
                    if (data == "ok") {
                        document.getElementById("njqx").focus();
                    }
                });
                return false;
            }
        }
        else {
         if (!fCheckDateSpecialYear(document.getElementById("bzrq"), document.getElementById("njqx"), 1)) {
         ymPrompt.alert('年检期限不能超过办证日期1年，请重新输入!', 330, 220, '提示信息', function (data) {
         if (data == "ok") {
         document.getElementById("njqx").focus();
         }
         });
         return false;
         }
         }


        if (!dateCompare(strZfrq,strBzrq)) {
            ymPrompt.alert('作废日期应该大于办证日期!', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    document.getElementById("zfrq").focus();
                }
            });
            return false;
        }

        if (!fCheckDateSpecialYear(document.getElementById("bzrq"), document.getElementById("zfrq"), 4)) {
            ymPrompt.alert('作废日期不能超过办证日期4年，请重新输入!', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    document.getElementById("zfrq").focus();
                }
            });
            return false;
        }

        if (dateCompare( strNjqx,strZfrq)) {
            ymPrompt.alert('作废日期应该大于等于年检期限!', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    document.getElementById("njqx").value = strZfrq;
                    document.getElementById("njqx").focus();
                }
            });
            return false;
        }
    }*/
   

    //判断年检期限和作废日期，add by zjy at 07-12-19
    /**
    if (strZfrq != "" && strGsfzrq != "") {
        if (dateCompare(strZfrq, strGsfzrq)) {
            //document.getElementById("txtzfrq").value=strGsfzrq;
            ymPrompt.alert('作废日期不能大于经营期限!', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    document.getElementById("zfrq").focus();
                }
            });
            return false;
        }
    }
    */
    //判断成立日期
    if (dateCompare(strZcrq, strBzrq)) {
        ymPrompt.alert('成立日期应该小于办证日期!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                document.getElementById("zcrq").focus();
            }
        });
        return false;
    }
    if (dateCompareSingle(strBzrq)) {
        ymPrompt.alert('发证日期不应大于当前日期!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                document.getElementById("bzrq").focus();
            }
        });
        return false;
    }
for(var i=0;i<rzsj.length-1;i++){
    	
        if(dateCompareSingle($.trim(rzsj[i].value))){
        	ymPrompt.alert('任职时间不能大于当前日期!', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    rzsj[i].focus();
                }
            });
        	 return false;
        };
    }
    if (dateCompareSingle(strClrq)) {
        ymPrompt.alert('成立日期不应大于当前日期!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                document.getElementById("zcrq").focus();
            }
        });
        return false;
    }
    if (dateCompareSingle(strYxqx)) {
        ymPrompt.alert('有效期限自不应大于当前日期!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                document.getElementById("yxqxs").focus();
            }
        });
        return false;
    }

    if (strZczj != "") {
        if (!fCheckZczj(document.getElementById("zczj"))) {
            return false;
        }
        /*if (document.getElementById("zczj").value <= 0 && document.getElementById("jglx").value == "1") {
            ymPrompt.alert('企业法人必须输入具体的注册资金!', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    document.getElementById("zczj").focus();
                }
            });
            return false;
        }*/
    }
    if (yzbm.value != "") {
        /*if (!fCheckPostCode(yzbm, '邮政编码')) {
         return false;
         }*/
        if (!checkPostPage(yzbm, 'post')) {
            return false;
        }
    }
    var zgdm = document.getElementById("zgdm");
   /* if (zgdm.value != "") {
        if (!fCheckJgdm(zgdm, "主管部门代码")) {
            return false;
        }
    }*/
   // var pzjgdm = document.getElementById("pzjgdm");
/*    var jglxVal = document.getElementById("jglx").value;
    if (jglxVal != '4' && jglxVal != '7' && jglxVal != '8' && jglxVal != '9') {
        if (pzjgdm.value != "") {
            if (!fCheckJgdm(pzjgdm, "批准机构")) {
                return false;
            }
        }
    }*/
   /* if (strZgrs != "") {
        if (!fCheckInteger(document.getElementById("zgrs"), "职工人数")) {
            return false;
        }
        if (parseInt(strZgrs) == 0) {
            ymPrompt.alert('职工人数不能为零!', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    document.getElementById("zgrs").focus();
                }
            });
            return false;
        }
        if (strZgrs >= 1000) {
         if (!confirm("输入的职工人数已经超过1000人，您确认要保存吗？")) {
         document.getElementById("zgrs").focus();
         return false;
         }
         }
    }*/

    var dhhm = document.getElementById("dhhm");
    
    if (dhhm.value != "") {
        if (!fCheckTelecom(document.getElementById("dhhm"), "单位联系电话")) {
            return false;
        }
    }
    var djrldh=document.getElementById("djlxrdhhm");
    if (djrldh.value != "") {
        if (!fCheckTelecom(document.getElementById("djlxrdhhm"), "党建联系人电话")) {
            return false;
        }
    }
 /*   var strMobile = document.getElementById("mobile").value;
    if (strMobile != "") {
        if (!fCheckMobile(document.getElementById("mobile"))) {
            return false;
        }
    }*/

/*    if (strFksl != "") {
        if (!fCheckInteger(document.getElementById("fksl"), "发卡数量")) {
            return false;
        }
    }*/
    /*var strZch = document.getElementById("zch").value;
    if (strZch != "") {
        if (!fCheckZch(document.getElementById("zch"))) {
            return false;
        }
    }*/
    var strTbrxm = document.getElementById("tbrxm").value;
    if (strTbrxm != "") {
        if (strTbrxm.replace(/[^\x00-\xff]/g, "**").length > 60) {
            ymPrompt.alert('输入的经办人姓名字节大于60,请修改后保存!', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    document.getElementById("tbrxm").focus();
                }
            });
            return false;
        }
    }

  /*  var strTbrLxfs = document.getElementById("tbrlxfs").value;
    if (strTbrLxfs != "") {
        if (!fCheckJbrTel(document.getElementById("tbrlxfs"), "经办人手机")) {
            return false;
        }
    }*/
   /* if (jyyb.value != "") {
        if (!fCheckPostCode(jyyb, '经营邮编')) {
         return false;
         }
        if (!checkPostPage(jyyb, 'jyPost')) {
            return false;
        }
    }*/
   /* var jydh = document.getElementById("jydh").value;
    if (jydh != "") {
        if (!fCheckTelecom(document.getElementById("jydh"), "经营电话")) {
            return false;
        }
    }*/
    //若经济类型为非7,8,外方国别为""
   /* var strJglx = document.getElementById("jglx").value;
    var strJjlx = document.getElementById("jjlx").value;
    var strJjlxFirst = strJjlx.substring(0, 1);
    if (strJglx == "B" && !fCheckSpecialString(strJjlxFirst, "4")) {
        ymPrompt.alert('机构类型和经济类型不匹配，经济类型应该为个体经济!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                document.getElementById("jjlx").focus();
            }
        });
        return false;
    }*/
    //if ((strJjlx=="31"||strJjlx=="32")&&(strJglx!="2"||strJglx!="9")){
    /*if ((strJjlx == "31") && (!fCheckSpecialString(strJglx, "29"))) {
        ymPrompt.alert('机构类型和经济类型不匹配，机构类型应该为企业非法人或者其他机构!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                document.getElementById("jjlx").focus();
            }
        });
        return false;
    }*/
/*    if (!fCheckSpecialString(strJjlxFirst, "78")) {
        document.getElementById("wftzgb").value = "";
    } else if (strJjlxFirst == "7") {
        //外商暂时不包含香港，无香港代码
        //中国156,"",台湾158,澳门446
        if (document.getElementById("wftzgb").value == "" || document.getElementById("wftzgb").value == "156" || document.getElementById("wftzgb").value == "158" || document.getElementById("wftzgb").value == "446" || document.getElementById("wftzgb").value == "344") {
            ymPrompt.alert('外方国别输入有误(可能和经济类型不匹配)!', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    document.getElementById("wftzgb").focus();
                }
            });
            return false;
        }
    } else if (strJjlxFirst == "8") {
        //港澳台
        if (document.getElementById("wftzgb").value != "158" && document.getElementById("wftzgb").value != "446" && document.getElementById("wftzgb").value != "344") {
            ymPrompt.alert('外方国别输入有误(港澳台要和经济类型中的港澳台投资对应)!', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    document.getElementById("wftzgb").focus();
                }
            });
            return false;
        }
    }*/
    if (document.getElementById("jyfw").value.replace(/[^\x00-\xff]/g, "**").length > 2000) {
        ymPrompt.alert('经营范围只能输入2000个字符,或者1000个汉字!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                document.getElementById("jyfw").focus();
            }
        });
        return false;
    }
    if (document.getElementById("nnjjhy1").innerHTML == "未找到名称") {
        ymPrompt.alert('请输入有效的经济行业!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                document.getElementById("nnjjhy").focus();
            }
        });
        return false;
    }
    /*//经济行业转化为大写
     var strJjhy = document.getElementById("jjhy").value;
     strJjhy = strJjhy.toUpperCase();
     document.getElementById("jjhy").value = strJjhy;
     //判断是是否输入一些无效的名称
     if (document.getElementById("jjhy1").innerHTML == "未找到名称") {
     ymPrompt.alert('请输入有效的经济行业!', 330, 220, '提示信息', function (data) {
     if (data == "ok") {
     document.getElementById("jjhy").focus();
     }
     });
     return false;
     }
     if (document.getElementById("jjhy").value.length < 4) {
     ymPrompt.alert('请输入小类的经济行业!', 330, 220, '提示信息', function (data) {
     if (data == "ok") {
     document.getElementById("jjhy").focus();
     }
     });
     return false;
     }   */
   /* var strNjjhy = document.getElementById("njjhy").value;
    strNjjhy = strNjjhy.toUpperCase();
    document.getElementById("njjhy").value = strNjjhy;
    if (document.getElementById("nnjjhy1").innerHTML == "未找到名称") {
        ymPrompt.alert('请输入有效的经济行业(2011版)!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                document.getElementById("nnjjhy").focus();
            }
        });
        return false;
    }*/
   /* if (document.getElementById("njjhy1").innerHTML == "未找到名称") {
        ymPrompt.alert('请输入有效的经济行业(2000版)!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                document.getElementById("njjhy").focus();
            }
        });
        return false;
    }*/
    
   /* if (document.getElementById("jjhy1").innerHTML == "未找到名称") {
        ymPrompt.alert('请输入有效的经济行业(94版)!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                document.getElementById("jjhy").focus();
            }
        });
        return false;
    }
*/
  /*  if (document.getElementById("jjlx1").innerHTML == "未找到名称") {
        ymPrompt.alert('请输入有效的经济类型!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                document.getElementById("jjlx").focus();
            }
        });
        return false;
    }*/
   /* if (document.getElementById("njjlx1").innerHTML == "未找到名称") {
        ymPrompt.alert('请输入有效的新经济类型!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                document.getElementById("njjlx").focus();
            }
        });
        return false;
    }*/
    if (document.getElementById("xzqh1").innerHTML == "未找到名称") {
        ymPrompt.alert('请输入有效的行政区划!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                document.getElementById("xzqh").focus();
            }
        });
        return false;
    }
    /*var pzjgmc = document.getElementById("pzjgmc");
     if ((pzjgmc && pzjgmc.innerHTML && pzjgmc.innerHTML == "未找到名称")) {
     ymPrompt.alert('请输入有效的批准机构名称!', 330, 220, '提示信息', function (data) {
     if (data == "ok") {
     document.getElementById("pzjgdm").focus();
     }
     });
     return false;
     }*/
    if (document.getElementById("zgmc").value == "未找到名称") {
        ymPrompt.alert('请输入有效的主管机构名称!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                document.getElementById("zgmc").focus();
            }
        });
        return false;
    }
    /*if (document.getElementById("wftzgb").innerHTML == "未找到名称") {
        ymPrompt.alert('请输入有效的外方国别!', 330, 220, '提示信息', function (data) {
            if (data == "ok") {
                document.getElementById("wftzgb").focus();
            }
        });
        return false;
    }*/
    /*if (document.getElementById("zycp11").innerHTML == "未找到名称") {
     ymPrompt.alert('请输入有效的主要产品1!', 330, 220, '提示信息', function (data) {
     if (data == "ok") {
     document.getElementById("zycp1").focus();
     }
     });
     return false;
     }
     if (document.getElementById("zycp21").innerHTML == "未找到名称") {
     ymPrompt.alert('请输入有效的主要产品2!', 330, 220, '提示信息', function (data) {
     if (data == "ok") {
     document.getElementById("zycp2").focus();
     }
     });
     return false;
     }
     if (document.getElementById("zycp31").innerHTML == "未找到名称") {
     ymPrompt.alert('请输入有效的主要产品3!', 330, 220, '提示信息', function (data) {
     if (data == "ok") {
     document.getElementById("zycp3").focus();
     }
     });
     return false;
     }*/
//   if (fCheckSpecialString(strJglx,"3456789")||(fCheckSpecialString(strJglx,"12")&&document.getElementById("jjlx").value=="11")){
    var bsx;
    /* dwr.engine.setAsync(false);
    jglxBsxBus.getJglxBsx(function (data) {
        bsx = data;
    });*/
    dwr.engine.setAsync(true);
    if (bsx != null && bsx != '') {
        if (fCheckSpecialString(strJglx, bsx)) {
            if (document.getElementById("zgmc").value == "") {
                ymPrompt.alert('必须输入主管机构名称!', 330, 220, '提示信息', function (data) {
                    if (data == "ok") {
                        document.getElementById("zgmc").focus();
                    }
                });
                return false;
            }
        }
    }

    /*if (fCheckSpecialString(strJglx, "12B")) {
     if ((pzjgmc && pzjgmc.innerHTML && pzjgmc.innerHTML.indexOf("工商行政管理局") == -1)) {
     ymPrompt.alert('请选择包含工商行政管理局的批准机构!', 330, 220, '提示信息', function (data) {
     if (data == "ok") {
     document.getElementById("pzjgdm").focus();
     }
     });
     return false;
     }
     }
     if (fCheckSpecialString(strJglx, "3")) {
     if ((pzjgmc && pzjgmc.innerHTML && pzjgmc.innerHTML.indexOf("事业单位登记管理局") == -1)) {
     ymPrompt.alert('请选择包含事业单位登记管理局的批准机构!', 330, 220, '提示信息', function (data) {
     if (data == "ok") {
     document.getElementById("pzjgdm").focus();
     }
     });
     return false;
     }
     }
     if (fCheckSpecialString(strJglx, "56A")) {
     if ((pzjgmc && pzjgmc.innerHTML && pzjgmc.innerHTML.indexOf("民政") == -1)) {
     ymPrompt.alert('请选择包含民政局或民政厅的批准机构!', 330, 220, '提示信息', function (data) {
     if (data == "ok") {
     document.getElementById("pzjgdm").focus();
     }
     });
     return false;
     }
     }
     if (fCheckSpecialString(strJglx, "C")) {
     if ((pzjgmc && pzjgmc.innerHTML && pzjgmc.innerHTML.indexOf("总工会") == -1)) {
     ymPrompt.alert('请选择包含总工会的批准机构!', 330, 220, '提示信息', function (data) {
     if (data == "ok") {
     document.getElementById("pzjgdm").focus();
     }
     });
     return false;
     }
     }*/

    /*var bankAccount = document.getElementById("khzh").value;
    if (bankAccount != null && bankAccount.length > 0) {
        if (!fCheckSpecialString(bankAccount, "0123456789")) {
            ymPrompt.alert('输入的开户账号中有非法字符!', 330, 220, '提示信息', function (data) {
                if (data == "ok") {
                    document.getElementById("khzh").focus();
                }
            });
            return false;
        }
    }*/
    return true;
}

function goNext(textField, len, nextinput) {
    if (textField.value.length == len) {
        nextinput.focus();
        nextinput.select();
    }
    return true;
}

function fChangeRadioForFlag(varFlag) {
    var fksl = document.getElementById("fksl");
    var fkslmc = document.getElementById("fkslmc");
    if (varFlag == 1) {
        fksl.value = "1";
        fksl.style.display = 'inline';
        fkslmc.style.display = 'inline';
    } else {
        fksl.value = "0";
        fksl.style.display = 'none';
        fkslmc.style.display = 'none';
    }
    return true;
}
function dateCompare(str1, str2) {
    var r1 = str1.replace("-", "/");
    var r2 = str2.replace("-", "/");
    var d1 = new Date(r1);
    var d2 = new Date(r2);
    return d1 > d2;
}

function dateCompareSingle(str1) {
    var d2 = new Date();
    var d1 = new Date(str1.replace("-", "/"));
    return d1 > d2;
}
function maxLength(obj, max, prop) {

    if (max && obj.value.length > max) {
        obj.value = obj.value.substring(0, max);
        if (prop) {
            prop.innerHTML = "系统限制最大长度" + max + "字符,或者" + (max / 2) + "个汉字！";
        } else {
            ymPrompt.alert({message: "系统限制最大长度" + max + "字符,或者" + (max / 2) + "个汉字！", width: 330, height: 220, title: '提示信息'});
        }
        obj.focus();
        return false;
    }
    else {
        if (prop) {
            prop.innerHTML = "";
        }
        return true;
    }
}
function onlyDecimal(obj) {
    if (filterKeyUp()) {
        return;
    }
    if (/^[1-9]\d*$/.test(obj.value)) {
        return;
    }
    obj.value = obj.value.replace(/^0(.*)$/, '$1');
    obj.value = obj.value.replace(/\D/g, '');
}


function onlyDecimalZero(obj) {
    if (filterKeyUp()) {
        return true;
    }
    if (/^\d*$/.test(obj.value)) {
        return true;
    }
    obj.value = obj.value.replace(/\D/g, '');
    return false;
}

function onlyDecimalTel(obj) {
    if (filterKeyUp()) {
        return;
    }
    if (/^[-0-9]*$/.test(obj.value)) {
        return;
    }
    obj.value = obj.value.replace(/[^-0-9]/g, '');
}

function onlyNumber(obj) {
    if (filterKeyUp()) {
        return;
    }
    if (/^[1-9]\d*$/.test(obj.value)) {
        return;
    }
    obj.value = obj.value.replace(/^(.*)$/, '$1');
    obj.value = obj.value.replace(/\D/g, '');
}
function onlySfzh(obj){
	if (filterKeyUp()) {
        return;
    }
	  if (/^[-0-9]*$/.test(obj.value)) {
	        return;
	    }
	obj.value=obj.value.replace(/[\W]/g,'');
}
/*function onlyMc(obj){
	if (filterKeyUp()) {
        return;
    }
	  if (/^[\a-\z\A-\Z0-9\u4E00-\u9FA5]*$/.test(obj.value)) {
	        return;
	    }
	  //alert(33);
	//obj.value=obj.value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g,'');
}*/
function onlyMc(th){ if(/["'<>%;)(&+]/.test(th.value)){           $(th).val(th.value.replace(/["'<>%;)(&+]/,""));     } }
/*function onlyMc(s) {
	
    var pattern = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）&mdash;—|{}【】‘；：”“'。，、？]");
        var rs = "";
    for (var i = 0; i < s.value.length; i++) {
       s.value = rs + s.value.substr(i, 1).replace(pattern, '');  
    }
    //return rs;
}*/
function zczjNumber(obj) {
    if (filterKeyUp()) {
        return;
    }
    if (obj.value.length <= 0)
        return;

    if (/^[1-9]\d*\.?\d*$/.test(obj.value)) {
        return;
    }
    if (/^0\.\d*[1-9]\d*$/.test(obj.value)) {
        return;
    }
    obj.value = obj.value.replace(/[^0-9\.]/g, '');
    obj.value = obj.value.replace(/^0*([1-9]|\d(\.?))/, '$1');
    if (!/\d+\.?\d*/.test(obj.value)) {
        obj.value = obj.substr(0, obj.value.length - 1);
    }
}


//判断必输项
function fCheckItem(thisObject, strTitle) {
    var allValid = false;
    var strName = Trim(thisObject.value, 0);
    if (strName == "") {
        ymPrompt.alert(strTitle + "不允许为空!", 330, 220, "提示信息", function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = true;
        return allValid;
    }
    return allValid;
}

function rightValues(obj) {
    if (event.keyCode == "35" || event.keyCode == "36" || event.keyCode == "37" || event.keyCode == "38" || event.keyCode == "39" || event.keyCode == "40") {
        return;
    }
    if (obj.value && obj.value.length > 0) {
        obj.value = obj.value.trim().toUpperCase();
        if (!(/^[A-Z0-9]{1,9}$/.test(obj.value))) {
            obj.value = obj.value.substr(0, obj.value.length - 1);
            rightValues(obj);
        }
    }
}


