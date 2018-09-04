// =============================================================================
//����: Trim
//����  : 
//����  : string strInputString  Your Input String  
//        string strType		 Your Trim Method Type   
//        sInputString  
//����  : 0 - Delete Both Space; 1 - Delete Front Space; 2 - Delete Back Space 
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
//�ж��Ƿ�����ʵ��������С����
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

//�ж��Ƿ���������
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
//���ϵ�
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
//�ж��Ƿ�����˷Ƿ����ַ�
function fIsVaildChar(str) {
    var checkStr = str;
    var bVaild = true;
    //�ж��Ƿ�����˿ո�',\
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

//�Ƿ�ȫ��Ϊ����
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

//�Ƿ������ֻ���ĸ
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

//�Ƿ������ֻ��д��ĸ
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

//�ж��Ƿ���ĳ�ַ�
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


//�ж��ַ����Ƿ����',"
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


//�ж�ʱ���
//���������ʱ���֣��� Input
function CheckTime(oHour, oMinute, oSecond) {
    var strH;					   //string year
    var strM;                      //string month
    var strS;					   //string date
    strH = oHour.value;
    strM = oMinute.value;
    strS = oSecond.value;
    if (strH.length != 2) {
        alert("Сʱ��λ��Ϊ2λ!")
        oHour.focus();
        return false;
    }
    if (strM.length != 2) {
        alert("���ӵ�λ��Ϊ2λ!")
        oMinute.focus();
        return false;
    }
    if (strS.length != 2) {
        alert("���λ��Ϊ2λ!")
        oSecond.focus();
        return false;
    }

    if (strH < 0 || strH >= 24) {
        alert("�������Сʱ��Ч��ӦΪ24ʱ��")
        oHour.focus();
        return false;
    }

    if (strM < 0 || strM >= 60) {
        alert("������ķ�����Ч")
        oMinute.focus();
        return false;
    }

    if (strS < 0 || strS >= 60) {
        alert("�����������Ч")
        oSecond.focus();
        return false;
    }
    return true;
}

//�ж϶��������Ƿ����̶��ĳ��ȣ�
//aflag:"Y" ������С�ڵ��� anum
//aflag:"M" �·����С�ڵ��� anum
//aflag:"Y" �������С�ڵ��� anum

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
                alert("���Ӧ�����" + aNum);
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
                alert("�·�Ӧ�����" + aNum);
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
                alert("����Ӧ�����" + aNum);
                oLast.focus();
                return false;
            }
            break;

        }
    }
    return true;
}

//�ж϶��������Ƿ����̶��ĳ��ȣ�
//aflag:"Y" ������С�ڵ��� anum
//aflag:"M" �·����С�ڵ��� anum
//aflag:"Y" �������С�ڵ��� anum

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
//�ж�����
//����
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
        ymPrompt.alert({message: "��ʽΪ:yyyy-mm-dd", width: 330, height: 220, title: '��ʾ��Ϣ'});
        oDate.focus();
        return false;
    }
    strY = strDate.substring(0, 4);
    strM = strDate.substring(5, 7);
    strD = strDate.substring(8, 10);
    strFlag = strDate.substring(4, 5);
    if (strFlag != "-") {
        ymPrompt.alert({message: '��ʽΪ:yyyy-mm-dd', width: 330, height: 220, title: '��ʾ��Ϣ'});
        oDate.focus();
        return false;
    }
    strFlag = strDate.substring(7, 8);
    if (strFlag != "-") {
        ymPrompt.alert({message: '��ʽΪ:yyyy-mm-dd', width: 330, height: 220, title: '��ʾ��Ϣ'});
        oDate.focus();
        return false;
    }

    if (strDate < "1900-01-01") {
        ymPrompt.alert({message: '����Ӧ�ô���1900-01-01', width: 330, height: 220, title: '��ʾ��Ϣ'});
        oDate.focus();
        return false;

    }
    if (strDate > "2100-12-31") {
        ymPrompt.alert({message: '����Ӧ��С��2100-12-31', width: 330, height: 220, title: '��ʾ��Ϣ'});
        oDate.focus();
        return false;

    }

    if (strY.length != 4) {
        ymPrompt.alert({message: '���Ϊ4λ!', width: 330, height: 220, title: '��ʾ��Ϣ'});
        oDate.focus();
        return false;

    }
    if (strM.length != 2) {
        ymPrompt.alert({message: '�·�Ϊ2λ!', width: 330, height: 220, title: '��ʾ��Ϣ'});
        oDate.focus();
        return false;
    }
    if (strD.length != 2) {
        ymPrompt.alert({message: '����Ϊ2λ!', width: 330, height: 220, title: '��ʾ��Ϣ'});
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
                ymPrompt.alert({message: '��������!', width: 330, height: 220, title: '��ʾ��Ϣ'});
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
                    ymPrompt.alert({message: '��������!', width: 330, height: 220, title: '��ʾ��Ϣ'});
                    oDate.focus();
                    return false;
                }
            }
            else {
                if (strD >= 1 && strD <= 28) {
                    return true;
                }
                else {
                    ymPrompt.alert({message: '��������!', width: 330, height: 220, title: '��ʾ��Ϣ'});
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
                ymPrompt.alert({message: '��������!', width: 330, height: 220, title: '��ʾ��Ϣ'});
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
                ymPrompt.alert({message: '��������!', width: 330, height: 220, title: '��ʾ��Ϣ'});
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
                ymPrompt.alert({message: '��������!', width: 330, height: 220, title: '��ʾ��Ϣ'});
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
                ymPrompt.alert({message: '��������!', width: 330, height: 220, title: '��ʾ��Ϣ'});
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
                ymPrompt.alert({message: '��������!', width: 330, height: 220, title: '��ʾ��Ϣ'});
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
                ymPrompt.alert({message: '��������!', width: 330, height: 220, title: '��ʾ��Ϣ'});
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
                ymPrompt.alert({message: '��������!', width: 330, height: 220, title: '��ʾ��Ϣ'});
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
                ymPrompt.alert({message: '��������!', width: 330, height: 220, title: '��ʾ��Ϣ'});
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
                ymPrompt.alert({message: '��������!', width: 330, height: 220, title: '��ʾ��Ϣ'});
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
                ymPrompt.alert({message: '��������!', width: 330, height: 220, title: '��ʾ��Ϣ'});
                oDate.focus();
                return false;
            }
            break;
        }
        default:
        {
            ymPrompt.alert({message: '�·�����!', width: 330, height: 220, title: '��ʾ��Ϣ'});
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
        alert("���ڸ�ʽ����10λ!��ʽΪ:yyyy-mm-dd")
        oDate.focus();
        return false;
    }
    strY = strDate.substring(0, 4);
    strM = strDate.substring(5, 7);
    strD = strDate.substring(8, 10);
    strFlag = strDate.substring(4, 5);
    if (strFlag != "-") {
        //alert("��ʽΪ:yyyy-mm-dd")
        return false;
    }
    strFlag = strDate.substring(7, 8);
    if (strFlag != "-") {
        //alert("��ʽΪ:yyyy-mm-dd")
        return false;
    }

    if (strDate < "1900-01-01") {
        //alert("����Ӧ�ô���1900-01-01")
        return false;

    }
    if (strDate > "2100-12-31") {
        //alert("����Ӧ��С��2100-12-31")
        return false;

    }

    if (strY.length != 4) {
        //alert("���Ϊ4λ!")
        return false;

    }
    if (strM.length != 2) {
        //alert("�·�Ϊ2λ!")
        return false;
    }
    if (strD.length != 2) {
        //alert("����Ϊ2λ!")
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
                //alert("��������!")
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
                    //alert("��������!")
                    return false;
                }
            }
            else {
                if (strD >= 1 && strD <= 28) {
                    return true;
                }
                else {
                    //alert("��������!")
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
                //alert("��������!")
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
                //alert("��������!")
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
                //alert("��������!")
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
                //alert("��������!")
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
                //alert("��������!")
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
                //alert("��������!")
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
                //alert("��������!")
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
                //alert("��������!")
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
                //alert("��������!")
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
                //alert("��������!")
                return false;
            }
            break;
        }
        default:
        {
            //alert("�·�����!")
            return false;
        }
    }

}
// =============================================================================
//����: AddChar
//����  : add many characters to the string
//����  : string  strSrc		 source string 
//		  integer intNumber		 the number of char you want to add
//        string  strChar		 the char you want to add
//		  integer intType		 0: add char before the string
//								 1: add char behand the string  
//����: String   the string added the char 
//����  : 
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
//����: CheckMoney
//����  : This fuction validate the strMoney.
//����  : string strMoney		Money string 
//����: Boolean			true: The strmoney is valid.
//							false:The strMoney is invalid. 
//����  : 
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
//����: CheckAscii
//����  : This fuction validate the strMoney.
//����  : string strInput		input string 
//���: Boolean			true: The strInput is valid.
//							false:The strInput is invalid. 
//����  : 
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

//�ж������Ƿ�Ϸ�
function isOK(form, q) {

    if (form.currpage.value == "") {
        alert("��������תҳ��");
        form.currpage.focus();
        return false;
    }

    if (check_space(form.currpage.value)) {
        alert("��תҳ�����벻������ֿո�");
        form.currpage.focus();
        return false;
    }

    if (!check_int(form.currpage.value)) {
        alert("�������תҳ�벻������ĸ����");
        form.currpage.focus();
        return false;
    }

    if (form.currpage.value < 1 || form.currpage.value > q) {
        alert("��תҳ�뷶Χ����ȷ,��ȷ��Χ: 1 to " + q);
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


//�ж��Ƿ��пո�
function check_space(str) {
    var allValid = false;
    for (i = 0; i < str.length; i++) {
        ch = str.charAt(i);
        if (ch == " ") {
            ymPrompt.alert({message: "�����˿ո�!", width: 330, height: 220, title: '��ʾ��Ϣ'});
            allValid = true;
            break;
        }
        else {
        }
    }
    return allValid;

}
//���֤�Ƿ��������Ҫ��
//aflag 18����18λ�����֤,�����������
//aflag 15����15λ�����֤��6λ���ڵ���Ч��
function fIsIDCheckCode(aStrCode, aFlag) {
    var strOrigin = "";
    //�ж�ǰ17λ


    var wi = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1);
    var i = 0;
    var sum = 0;
    var ai = new Array("1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2");
    var strCheck = "";
    if (aFlag == 18) {
        strOrigin = aStrCode.substring(0, 17);
        //���ռ����㷨��������
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

//�������֤������Ч��
function fCheckIdentify(thisObject) {
    var title = '���֤��';
    if (thisObject.id != 'zjhm') {
        title = '������֤������';
    }
    var allValid = true;
    var strVar = thisObject.value;
    if (!(/*strVar.length == 15 ||*/ strVar.length == 18)) {
        /*ymPrompt.alert('��������֤�ų��Ȳ���ȷ!', 330, 220, '��ʾ��Ϣ', function (data) {
         if (data == "ok") {
         thisObject.focus();
         }
         });
         allValid = false;
         return allValid;*/
        if (thisObject.id == 'zjhm') {
            document.getElementById("zjhmInfo").innerHTML = '���֤���볤�Ȳ���ȷ!';
            return false;
        } else {
            document.getElementById("jbrzjhmInfo").innerHTML = '������֤�����볤�Ȳ���ȷ!';
            return false;
        }
        /*if (!confirm("�����"+title+"���Ȳ���ȷ����ȷ��Ҫ������")) {
         thisObject.focus();
         return false;
         }*/
    }
    /*if (strVar.length == 15) {
     if (!fCheckSpecialString(strVar, "0123456789")) {
     */
    /*ymPrompt.alert('��������֤�����зǷ��ַ�!', 330, 220, '��ʾ��Ϣ', function (data) {
     if (data == "ok") {
     thisObject.focus();
     }
     });
     allValid = false;
     return allValid;*/
    /*

     */
    /*if (!confirm("�����"+title+"���зǷ��ַ�����ȷ��Ҫ������")) {
     thisObject.focus();
     return false;
     }*/
    
    /*
     if (thisObject.id == 'zjhm') {
    	 document.getElementById("zjhmInfo").innerHTML = '���֤�������зǷ��ַ�!';
    	 return false;
     } else {
    	 document.getElementById("jbrzjhmInfo").innerHTML = '������֤���������зǷ��ַ�!';
    	 return false;
     }
     */

     

//     if (!fIsIDCheckCode(strVar, 15)) {
    
    /*ymPrompt.alert('��������֤����Ч!', 330, 220, '��ʾ��Ϣ', function (data) {
     if (data == "ok") {
     thisObject.focus();
     }
     });
     allValid = false;
     return allValid;*/
    /*
     */
    /*if (!confirm("�����"+title+"��Ч����ȷ��Ҫ������")) {
     thisObject.focus();
     return false;
     }*/
    /*

     if (thisObject.id == 'zjhm') {
     document.getElementById("zjhmInfo").innerHTML = '���֤������Ч!';
     return false;
     } else {
     document.getElementById("jbrzjhmInfo").innerHTML = '������֤��������Ч!';
     return false;
     }

     }

     }*/
    if (strVar.length == 18) {
        if (!fIsIDCheckCode(strVar, 18)) {
            /*ymPrompt.alert('��������֤����Ч!', 330, 220, '��ʾ��Ϣ', function (data) {
             if (data == "ok") {
             thisObject.focus();
             }
             });
             allValid = false;
             return allValid;*/

            /*if (!confirm("�����"+title+"��Ч����ȷ��Ҫ������")) {
             thisObject.focus();
             return false;
             }*/
            if (thisObject.id == 'zjhm') {
                document.getElementById("zjhmInfo").innerHTML = '���֤���벻���Ϲ��ұ��������ȷ���Ƿ�������ȷ!';
                return false;
            } else {
                document.getElementById("jbrzjhmInfo").innerHTML = '������֤�����벻���Ϲ��ұ��������ȷ���Ƿ�������ȷ!';
                return false;
            }
        }
    }
    return allValid;
}

//������������������Ч��
function fCheckPostCode(thisObject, title) {
    var allValid = true;
    var strVar = thisObject.value;
    if (strVar.length != 6) {
        ymPrompt.alert('�����' + title + '���Ȳ���ȷ!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;
    }
    if (!fCheckSpecialString(strVar, "0123456789")) {
        ymPrompt.alert('�����' + title + '���зǷ��ַ�!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;

    }
    if (strVar.substring(0, 2) == "00") {
        ymPrompt.alert('�����' + title + '����ȷ!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;
    }
    return allValid;
}

//����绰����������Ч��
function fCheckTelecom(thisObject, title) {
    var allValid = true;
    var strVar = thisObject.value;
    var reg = /^((1[358]\d{9})|((0\d{2,3}-?)?\d{7,8}(-?\d{1,6})?))$/;
    if (!reg.test(thisObject.value)) {
        ymPrompt.alert('�����' + title + '��ʽ����ȷ!��ȷ��ʽ,����:03123456789-123��13123456789!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;
    }
    return allValid;
}

//�жϾ������ֻ�
function fCheckJbrTel(thisObject, title) {
    var flag = true;
    var strVar = thisObject.value;
    var strFirst = strVar.substring(0, 1);
    if (strFirst == '1') {
        if (!isPhone(strVar)) {
            ymPrompt.alert('����ľ������ֻ��Ÿ�ʽ����ȷ!��ȷ��ʽ,����:13581888888', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    thisObject.focus();
                }
            });
            flag = false;
            return flag;
        }
    } else {
        if (!fCheckTelecom(thisObject, "�������ֻ�")) {
            flag = false;
            return flag;
        }
    }
    return flag;

}

//�����ƶ��绰������Ч��
function fCheckMobile(thisObject) {
    var allValid = true;
    var strVar = thisObject.value;
    var strFirst = strVar.substring(0, 1);

    if (strVar.length < 7) {
        ymPrompt.alert('����ķ����ֻ����Ȳ���ȷ!��ȷ��ʽ,����:13581888888', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;
    }
    if (!fCheckSpecialString(strVar, "0123456789")) {
        ymPrompt.alert('����ķ����ֻ����зǷ��ַ�!��ȷ��ʽ,����:13581888888', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;

    }
    if (strFirst == "1") {
        if (strVar.length != 11) {
            ymPrompt.alert('����ķ����ֻ����Ȳ���ȷ!��ȷ��ʽ,����:13581888888', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    thisObject.focus();
                }
            });
            allValid = false;
        } else {
            if (!fCheckSpecialString(strVar.substring(1, 2), "3458")) {
                ymPrompt.alert('����ķ����ֻ�����ȷ!��ȷ��ʽ,����:13581888888', 330, 220, '��ʾ��Ϣ', function (data) {
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

//����ע���ʽ�������Ч��
function fCheckZczj(thisObject) {
    var allValid = true;
    if (checkZCZJ(document.getElementById("zczj"), "ע���ʽ�")) {
        return false;
    }
    var strVar = thisObject.value;
    if (strVar.length > 14) {
        ymPrompt.alert('�����ע���ʽ𳤶Ȳ���ȷ!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;
    }
    if (!fCheckSpecialString(strVar, "0123456789.")) {
        ymPrompt.alert('�����ע���ʽ����зǷ��ַ�!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;

    }
    return allValid;
}

//���鷢������������Ч��
function fCheckFksl(thisObject) {
    var allValid = true;
    var strVar = thisObject.value;

    if (strVar.length >= 3) {
        ymPrompt.alert('����ķ����������Ȳ���ȷ!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;
    }
    if (!fCheckSpecialString(strVar, "0123456789")) {
        ymPrompt.alert('����ķ����������зǷ��ַ�!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;

    }
    return allValid;
}

//�ж�����
function fCheckInteger(thisObject, strTitle) {
    var allValid = true;
    var strVar = thisObject.value;
    if (!fCheckSpecialString(strVar, "0123456789")) {
        ymPrompt.alert('�����' + strTitle + '���зǷ��ַ�!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;

    }
    return allValid;
}
//�жϻ�������
function fCheckJgdm(thisObject, strTitle) {
    var allValid = true;
    var strVar = thisObject.value;
    if (strVar.length != 9) {
        ymPrompt.alert('�����' + strTitle + '���Ȳ���ȷ!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;
    }
    if (!fCheckSpecialString(strVar, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ")) {
        ymPrompt.alert('�����' + strTitle + '���зǷ��ַ�!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
        return allValid;

    }
    return allValid;
}
//�ж�ע���
function fCheckZch(thisObject) {
    var allValid = true;
    var strVar = thisObject.value;
    //�����ȫ�����֣����鳤�Ȳ�С��6
    if (strVar.length < 6) {
        ymPrompt.alert('�����ע��ų�������Ϊ6!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                thisObject.focus();
            }
        });
        allValid = false;
    }
    /*if (strVar.replace(/[^\x00-\xff]/g, "**").length > 35) {
     ymPrompt.alert('�����ע����ֽڴ���35,���޸ĺ󱣴�!', 330, 220, '��ʾ��Ϣ', function (data) {
     if (data == "ok") {
     thisObject.focus();
     }
     });
     allValid = false;
     }*/
    return allValid;
}

//�жϻ��������Ƿ�Ϊ��
function checkJglxItem(thisObject, strTitle) {
    var valid = false;
    if (thisObject.value == 0) {
        ymPrompt.alert(strTitle + "������Ϊ��!", 330, 220, "��ʾ��Ϣ", function (data) {
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
        ymPrompt.alert(title + "������Ϊ��!", 330, 220, "��ʾ��Ϣ", function (data) {
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
        ymPrompt.alert(title + "ӦС�ڵ���14λ������4λС��������������!���磺123456789.1234", 330, 220, "��ʾ��Ϣ", function (data) {
            if (data == "ok") {
                object.focus();
            }
        });
        return true;
    }

}
//�ж�����Form���Ƿ�����˷Ƿ����ַ�
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
                            ymPrompt.alert("������('��\")�ȷǷ��ַ���", 330, 220, '��ʾ��Ϣ', function (data) {
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
                            ymPrompt.alert("������('��\")�ȷǷ��ַ���", 330, 220, '��ʾ��Ϣ', function (data) {
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
                ymPrompt.alert('������(\'��\")�ȷǷ��ַ���', 330, 220, '��ʾ��Ϣ', function (data) {
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
//����Ϊ��,�жϸ�����Ŀ������
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
    //�ж��Ƿ��зǷ��ַ�
    if (!fItemCheckVaild(frmThis)) {
        return false;
    }
    //�ж�һЩ�������Ŀ
    if (strZjlx == "0") {
        /*//�����֤,15,18λ���뷨�������˵Ĺ����ж� 
         if (strZjhm != "") {
         if (!fCheckIdentify(document.getElementById("zjhm"))) {
         return false;
         }
         }*/
        /*if (fHasSpecialString(document.getElementById("fddbr").value, "\" '\\1234567890ABCEFGJOKLLMNOPQRSTUVWXYZ")) {
         ymPrompt.alert('����ķ��˴����к��зǷ��ַ�!', 330, 220, '��ʾ��Ϣ', function (data) {
         if (data == "ok") {
         document.getElementById("fddbr").focus();
         }
         });
         return false;
         }*/
    } else {
        if (document.getElementById("fddbr").value.replace(/[^\x00-\xff]/g, "**").length > 100) {
            ymPrompt.alert('����ķ��˴����ֽڴ���100,���޸ĺ󱣴�!', 330, 220, '��ʾ��Ϣ', function (data) {
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
    //�ж��������ڣ�������ڣ���֤����
/*    if (strNjqx != "" && strBzrq != "" && strZfrq != "") {
        if (!dateCompare(strNjqx,strBzrq )) {
            ymPrompt.alert('�������Ӧ�ô��ڰ�֤����!', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    document.getElementById("njqx").focus();
                }
            });
            return false;
        }
        var scnj = document.getElementById("scnj");
        if (scnj && !scnj.value) {
            if (!fCheckDateSpecialYear(scnj, document.getElementById("njqx"), 1)) {
                ymPrompt.alert('������޲��ܳ����ϴ��������1�꣬����������!', 330, 220, '��ʾ��Ϣ', function (data) {
                    if (data == "ok") {
                        document.getElementById("njqx").focus();
                    }
                });
                return false;
            }
        }
        else {
         if (!fCheckDateSpecialYear(document.getElementById("bzrq"), document.getElementById("njqx"), 1)) {
         ymPrompt.alert('������޲��ܳ�����֤����1�꣬����������!', 330, 220, '��ʾ��Ϣ', function (data) {
         if (data == "ok") {
         document.getElementById("njqx").focus();
         }
         });
         return false;
         }
         }


        if (!dateCompare(strZfrq,strBzrq)) {
            ymPrompt.alert('��������Ӧ�ô��ڰ�֤����!', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    document.getElementById("zfrq").focus();
                }
            });
            return false;
        }

        if (!fCheckDateSpecialYear(document.getElementById("bzrq"), document.getElementById("zfrq"), 4)) {
            ymPrompt.alert('�������ڲ��ܳ�����֤����4�꣬����������!', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    document.getElementById("zfrq").focus();
                }
            });
            return false;
        }

        if (dateCompare( strNjqx,strZfrq)) {
            ymPrompt.alert('��������Ӧ�ô��ڵ����������!', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    document.getElementById("njqx").value = strZfrq;
                    document.getElementById("njqx").focus();
                }
            });
            return false;
        }
    }*/
   

    //�ж�������޺��������ڣ�add by zjy at 07-12-19
    /**
    if (strZfrq != "" && strGsfzrq != "") {
        if (dateCompare(strZfrq, strGsfzrq)) {
            //document.getElementById("txtzfrq").value=strGsfzrq;
            ymPrompt.alert('�������ڲ��ܴ��ھ�Ӫ����!', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    document.getElementById("zfrq").focus();
                }
            });
            return false;
        }
    }
    */
    //�жϳ�������
    if (dateCompare(strZcrq, strBzrq)) {
        ymPrompt.alert('��������Ӧ��С�ڰ�֤����!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                document.getElementById("zcrq").focus();
            }
        });
        return false;
    }
    if (dateCompareSingle(strBzrq)) {
        ymPrompt.alert('��֤���ڲ�Ӧ���ڵ�ǰ����!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                document.getElementById("bzrq").focus();
            }
        });
        return false;
    }
for(var i=0;i<rzsj.length-1;i++){
    	
        if(dateCompareSingle($.trim(rzsj[i].value))){
        	ymPrompt.alert('��ְʱ�䲻�ܴ��ڵ�ǰ����!', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    rzsj[i].focus();
                }
            });
        	 return false;
        };
    }
    if (dateCompareSingle(strClrq)) {
        ymPrompt.alert('�������ڲ�Ӧ���ڵ�ǰ����!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                document.getElementById("zcrq").focus();
            }
        });
        return false;
    }
    if (dateCompareSingle(strYxqx)) {
        ymPrompt.alert('��Ч�����Բ�Ӧ���ڵ�ǰ����!', 330, 220, '��ʾ��Ϣ', function (data) {
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
            ymPrompt.alert('��ҵ���˱�����������ע���ʽ�!', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    document.getElementById("zczj").focus();
                }
            });
            return false;
        }*/
    }
    if (yzbm.value != "") {
        /*if (!fCheckPostCode(yzbm, '��������')) {
         return false;
         }*/
        if (!checkPostPage(yzbm, 'post')) {
            return false;
        }
    }
    var zgdm = document.getElementById("zgdm");
   /* if (zgdm.value != "") {
        if (!fCheckJgdm(zgdm, "���ܲ��Ŵ���")) {
            return false;
        }
    }*/
   // var pzjgdm = document.getElementById("pzjgdm");
/*    var jglxVal = document.getElementById("jglx").value;
    if (jglxVal != '4' && jglxVal != '7' && jglxVal != '8' && jglxVal != '9') {
        if (pzjgdm.value != "") {
            if (!fCheckJgdm(pzjgdm, "��׼����")) {
                return false;
            }
        }
    }*/
   /* if (strZgrs != "") {
        if (!fCheckInteger(document.getElementById("zgrs"), "ְ������")) {
            return false;
        }
        if (parseInt(strZgrs) == 0) {
            ymPrompt.alert('ְ����������Ϊ��!', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    document.getElementById("zgrs").focus();
                }
            });
            return false;
        }
        if (strZgrs >= 1000) {
         if (!confirm("�����ְ�������Ѿ�����1000�ˣ���ȷ��Ҫ������")) {
         document.getElementById("zgrs").focus();
         return false;
         }
         }
    }*/

    var dhhm = document.getElementById("dhhm");
    
    if (dhhm.value != "") {
        if (!fCheckTelecom(document.getElementById("dhhm"), "��λ��ϵ�绰")) {
            return false;
        }
    }
    var djrldh=document.getElementById("djlxrdhhm");
    if (djrldh.value != "") {
        if (!fCheckTelecom(document.getElementById("djlxrdhhm"), "������ϵ�˵绰")) {
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
        if (!fCheckInteger(document.getElementById("fksl"), "��������")) {
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
            ymPrompt.alert('����ľ����������ֽڴ���60,���޸ĺ󱣴�!', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    document.getElementById("tbrxm").focus();
                }
            });
            return false;
        }
    }

  /*  var strTbrLxfs = document.getElementById("tbrlxfs").value;
    if (strTbrLxfs != "") {
        if (!fCheckJbrTel(document.getElementById("tbrlxfs"), "�������ֻ�")) {
            return false;
        }
    }*/
   /* if (jyyb.value != "") {
        if (!fCheckPostCode(jyyb, '��Ӫ�ʱ�')) {
         return false;
         }
        if (!checkPostPage(jyyb, 'jyPost')) {
            return false;
        }
    }*/
   /* var jydh = document.getElementById("jydh").value;
    if (jydh != "") {
        if (!fCheckTelecom(document.getElementById("jydh"), "��Ӫ�绰")) {
            return false;
        }
    }*/
    //����������Ϊ��7,8,�ⷽ����Ϊ""
   /* var strJglx = document.getElementById("jglx").value;
    var strJjlx = document.getElementById("jjlx").value;
    var strJjlxFirst = strJjlx.substring(0, 1);
    if (strJglx == "B" && !fCheckSpecialString(strJjlxFirst, "4")) {
        ymPrompt.alert('�������ͺ;������Ͳ�ƥ�䣬��������Ӧ��Ϊ���徭��!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                document.getElementById("jjlx").focus();
            }
        });
        return false;
    }*/
    //if ((strJjlx=="31"||strJjlx=="32")&&(strJglx!="2"||strJglx!="9")){
    /*if ((strJjlx == "31") && (!fCheckSpecialString(strJglx, "29"))) {
        ymPrompt.alert('�������ͺ;������Ͳ�ƥ�䣬��������Ӧ��Ϊ��ҵ�Ƿ��˻�����������!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                document.getElementById("jjlx").focus();
            }
        });
        return false;
    }*/
/*    if (!fCheckSpecialString(strJjlxFirst, "78")) {
        document.getElementById("wftzgb").value = "";
    } else if (strJjlxFirst == "7") {
        //������ʱ��������ۣ�����۴���
        //�й�156,"",̨��158,����446
        if (document.getElementById("wftzgb").value == "" || document.getElementById("wftzgb").value == "156" || document.getElementById("wftzgb").value == "158" || document.getElementById("wftzgb").value == "446" || document.getElementById("wftzgb").value == "344") {
            ymPrompt.alert('�ⷽ������������(���ܺ;������Ͳ�ƥ��)!', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    document.getElementById("wftzgb").focus();
                }
            });
            return false;
        }
    } else if (strJjlxFirst == "8") {
        //�۰�̨
        if (document.getElementById("wftzgb").value != "158" && document.getElementById("wftzgb").value != "446" && document.getElementById("wftzgb").value != "344") {
            ymPrompt.alert('�ⷽ������������(�۰�̨Ҫ�;��������еĸ۰�̨Ͷ�ʶ�Ӧ)!', 330, 220, '��ʾ��Ϣ', function (data) {
                if (data == "ok") {
                    document.getElementById("wftzgb").focus();
                }
            });
            return false;
        }
    }*/
    if (document.getElementById("jyfw").value.replace(/[^\x00-\xff]/g, "**").length > 2000) {
        ymPrompt.alert('��Ӫ��Χֻ������2000���ַ�,����1000������!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                document.getElementById("jyfw").focus();
            }
        });
        return false;
    }
    if (document.getElementById("nnjjhy1").innerHTML == "δ�ҵ�����") {
        ymPrompt.alert('��������Ч�ľ�����ҵ!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                document.getElementById("nnjjhy").focus();
            }
        });
        return false;
    }
    /*//������ҵת��Ϊ��д
     var strJjhy = document.getElementById("jjhy").value;
     strJjhy = strJjhy.toUpperCase();
     document.getElementById("jjhy").value = strJjhy;
     //�ж����Ƿ�����һЩ��Ч������
     if (document.getElementById("jjhy1").innerHTML == "δ�ҵ�����") {
     ymPrompt.alert('��������Ч�ľ�����ҵ!', 330, 220, '��ʾ��Ϣ', function (data) {
     if (data == "ok") {
     document.getElementById("jjhy").focus();
     }
     });
     return false;
     }
     if (document.getElementById("jjhy").value.length < 4) {
     ymPrompt.alert('������С��ľ�����ҵ!', 330, 220, '��ʾ��Ϣ', function (data) {
     if (data == "ok") {
     document.getElementById("jjhy").focus();
     }
     });
     return false;
     }   */
   /* var strNjjhy = document.getElementById("njjhy").value;
    strNjjhy = strNjjhy.toUpperCase();
    document.getElementById("njjhy").value = strNjjhy;
    if (document.getElementById("nnjjhy1").innerHTML == "δ�ҵ�����") {
        ymPrompt.alert('��������Ч�ľ�����ҵ(2011��)!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                document.getElementById("nnjjhy").focus();
            }
        });
        return false;
    }*/
   /* if (document.getElementById("njjhy1").innerHTML == "δ�ҵ�����") {
        ymPrompt.alert('��������Ч�ľ�����ҵ(2000��)!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                document.getElementById("njjhy").focus();
            }
        });
        return false;
    }*/
    
   /* if (document.getElementById("jjhy1").innerHTML == "δ�ҵ�����") {
        ymPrompt.alert('��������Ч�ľ�����ҵ(94��)!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                document.getElementById("jjhy").focus();
            }
        });
        return false;
    }
*/
  /*  if (document.getElementById("jjlx1").innerHTML == "δ�ҵ�����") {
        ymPrompt.alert('��������Ч�ľ�������!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                document.getElementById("jjlx").focus();
            }
        });
        return false;
    }*/
   /* if (document.getElementById("njjlx1").innerHTML == "δ�ҵ�����") {
        ymPrompt.alert('��������Ч���¾�������!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                document.getElementById("njjlx").focus();
            }
        });
        return false;
    }*/
    if (document.getElementById("xzqh1").innerHTML == "δ�ҵ�����") {
        ymPrompt.alert('��������Ч����������!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                document.getElementById("xzqh").focus();
            }
        });
        return false;
    }
    /*var pzjgmc = document.getElementById("pzjgmc");
     if ((pzjgmc && pzjgmc.innerHTML && pzjgmc.innerHTML == "δ�ҵ�����")) {
     ymPrompt.alert('��������Ч����׼��������!', 330, 220, '��ʾ��Ϣ', function (data) {
     if (data == "ok") {
     document.getElementById("pzjgdm").focus();
     }
     });
     return false;
     }*/
    if (document.getElementById("zgmc").value == "δ�ҵ�����") {
        ymPrompt.alert('��������Ч�����ܻ�������!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                document.getElementById("zgmc").focus();
            }
        });
        return false;
    }
    /*if (document.getElementById("wftzgb").innerHTML == "δ�ҵ�����") {
        ymPrompt.alert('��������Ч���ⷽ����!', 330, 220, '��ʾ��Ϣ', function (data) {
            if (data == "ok") {
                document.getElementById("wftzgb").focus();
            }
        });
        return false;
    }*/
    /*if (document.getElementById("zycp11").innerHTML == "δ�ҵ�����") {
     ymPrompt.alert('��������Ч����Ҫ��Ʒ1!', 330, 220, '��ʾ��Ϣ', function (data) {
     if (data == "ok") {
     document.getElementById("zycp1").focus();
     }
     });
     return false;
     }
     if (document.getElementById("zycp21").innerHTML == "δ�ҵ�����") {
     ymPrompt.alert('��������Ч����Ҫ��Ʒ2!', 330, 220, '��ʾ��Ϣ', function (data) {
     if (data == "ok") {
     document.getElementById("zycp2").focus();
     }
     });
     return false;
     }
     if (document.getElementById("zycp31").innerHTML == "δ�ҵ�����") {
     ymPrompt.alert('��������Ч����Ҫ��Ʒ3!', 330, 220, '��ʾ��Ϣ', function (data) {
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
                ymPrompt.alert('�����������ܻ�������!', 330, 220, '��ʾ��Ϣ', function (data) {
                    if (data == "ok") {
                        document.getElementById("zgmc").focus();
                    }
                });
                return false;
            }
        }
    }

    /*if (fCheckSpecialString(strJglx, "12B")) {
     if ((pzjgmc && pzjgmc.innerHTML && pzjgmc.innerHTML.indexOf("�������������") == -1)) {
     ymPrompt.alert('��ѡ�����������������ֵ���׼����!', 330, 220, '��ʾ��Ϣ', function (data) {
     if (data == "ok") {
     document.getElementById("pzjgdm").focus();
     }
     });
     return false;
     }
     }
     if (fCheckSpecialString(strJglx, "3")) {
     if ((pzjgmc && pzjgmc.innerHTML && pzjgmc.innerHTML.indexOf("��ҵ��λ�Ǽǹ����") == -1)) {
     ymPrompt.alert('��ѡ�������ҵ��λ�Ǽǹ���ֵ���׼����!', 330, 220, '��ʾ��Ϣ', function (data) {
     if (data == "ok") {
     document.getElementById("pzjgdm").focus();
     }
     });
     return false;
     }
     }
     if (fCheckSpecialString(strJglx, "56A")) {
     if ((pzjgmc && pzjgmc.innerHTML && pzjgmc.innerHTML.indexOf("����") == -1)) {
     ymPrompt.alert('��ѡ����������ֻ�����������׼����!', 330, 220, '��ʾ��Ϣ', function (data) {
     if (data == "ok") {
     document.getElementById("pzjgdm").focus();
     }
     });
     return false;
     }
     }
     if (fCheckSpecialString(strJglx, "C")) {
     if ((pzjgmc && pzjgmc.innerHTML && pzjgmc.innerHTML.indexOf("�ܹ���") == -1)) {
     ymPrompt.alert('��ѡ������ܹ������׼����!', 330, 220, '��ʾ��Ϣ', function (data) {
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
            ymPrompt.alert('����Ŀ����˺����зǷ��ַ�!', 330, 220, '��ʾ��Ϣ', function (data) {
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
            prop.innerHTML = "ϵͳ������󳤶�" + max + "�ַ�,����" + (max / 2) + "�����֣�";
        } else {
            ymPrompt.alert({message: "ϵͳ������󳤶�" + max + "�ַ�,����" + (max / 2) + "�����֣�", width: 330, height: 220, title: '��ʾ��Ϣ'});
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
	
    var pattern = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~��@#������&*����&mdash;��|{}��������������'��������]");
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


//�жϱ�����
function fCheckItem(thisObject, strTitle) {
    var allValid = false;
    var strName = Trim(thisObject.value, 0);
    if (strName == "") {
        ymPrompt.alert(strTitle + "������Ϊ��!", 330, 220, "��ʾ��Ϣ", function (data) {
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


