/**
函数名称：isChinese
函数功能：判断输入是否包括中文或者其他符号
输入参数：需要测试的字符串
返回参数：包括中文和其他符号：true 不包括中文和其他符号： false
*/
function isChinese(strTemp)
{

    var i;
    for(i=0;i<strTemp.length;i++)
    {
        if((strTemp.charCodeAt(i)<0)||(strTemp.charCodeAt(i))>255)
        {
            return false;
        }
    }
    return true;
}

/**
函数名称：fucCheckLength
函数功能：判断输入字符串的长度（包括中文）
输入参数：需要测试的字符串
返回参数：sum:字符串长度
*/
function fucCheckLength(strTemp)
{
 var i,sum;
 sum=0;
 for(i=0;i<strTemp.length;i++)
 {
  if ((strTemp.charCodeAt(i)>=0) && (strTemp.charCodeAt(i)<=255))
   sum=sum+1;
  else
   sum=sum+2;
 }
 return sum;
}

/**
函数名称：Trim
函数功能：去掉输入字符串左右两边的空格
输入参数：字符串
返回参数：字符串
*/
function Trim(sInputString)
{
    var sTmpStr = " ";
    var i = -1;
    while (sTmpStr == " ")
    {
      ++i;
      sTmpStr = sInputString.substr(i,1);
    }
    sInputString = sInputString.substring(i);

    sTmpStr = " ";
    i = sInputString.length;
    while (sTmpStr == " ")
    {
      --i;
      sTmpStr = sInputString.substr(i,1);
    }
    sInputString = sInputString.substring(0,i+1);
    return sInputString;
}

/**
函数名称：isIpAddress
函数功能：判断输入字符串是不是符合规范的IP地址
输入参数：需要测试的字符串
返回参数：是IP地址：true 不是IP地址：false
*/
function isIpAddress(s)
{
	 var pattern=/(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])/;
   if(!pattern.exec(s))
   {
     alert("IP地址不正确");
     return false;
   }
  	return true;
}
/**
函数名称：isip
函数功能：判断输入字符串是不是符合规范的IP地址
输入参数：需要测试的字符串
返回参数：是IP地址：true 不是IP地址：false
*/
function isip(s)
{
    var patrn=/^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
    //var patrn=/^[0-9.]{1,20}$/;
    if(!patrn.exec(s))
    {return false}
    return true
}
/**
函数名称：isCoordinate 
函数功能：判断输入字符串是不是符合规范的坐标
输入参数：需要测试的字符串
返回参数：是坐标：true 不是坐标：false
*/
function isCoordinate (s)
{
   var pattern=/([1-9]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\,([1-9]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])/;
   if(!pattern.exec(s))
   {     
     return false;
   }
  	return true;
}

/**
是否是邮政编码『中国』
*/
function isAreaCode(s)
{
  var patrn=/^[0]{1}[1-9]{1}[0-9]{1,2}$/;
  var str = Trim(s);
  if (patrn.exec(str)) return true;
  return false;
}

/**
函数名称：isPhoneNumber
函数功能：判断输入字符串是不是符合规范的固定电话号码
判断规范：1-20位的数字或"-"线
输入参数：需要测试的字符串
返回参数：是电话号码：true 不是电话号码：false
*/
function isPhoneNumber(s)
{
    var patrn=/^([0-9]|[-]|[,]){1,40}$/;
    if (!patrn.exec(s))
    {
        return false;
    }
    return true;
}

/**
函数名称：samePassword
函数功能：判断输入两个字符串是不是相同
输入参数：需要测试的两个字符串
返回参数：相同：true 不同：false
*/
function samePassword(t,s)
{
    if(t != s)
    {
        return false;
    }
    return true;
}

/**
函数名称：ismobile
函数功能：判断输入字符串是不是符合规范的手机号码（不包括小灵通）
判断规范：以13开头
输入参数：需要测试的字符串
返回参数：是手机号码：true 不是手机号码：false
*/
function ismobile(s)
{
    var patrn=/^(13)[0-9]{9}$/;
    //var patrn1=/^(159)[0-9]{8}$/;
    var patrn1=/^(15)[0-9]{9}$/;
    var patrn2=/^(18)[0-9]{9}$/;
    if (!patrn.exec(s) && !patrn1.exec(s) && !patrn2.exec(s))
    {
       return false;
    }
    return true;
}

/**
函数名称：isEmail
函数功能：判断输入字符串是不是符合规范的邮箱地址
输入参数：需要测试的字符串
返回参数：是邮箱地址：true 不是邮箱地址：false
*/
function isEmail(a)
{
 var i=a.length;
 var temp = a.indexOf('@');
 var tempd = a.indexOf('.');
 if (temp > 1) {
  if ((i-temp) > 3) {
   if (tempd!=-1) {
    return true;
   }
  }
}
 return false;
}

/**
函数名称：isDigit
函数功能：判断输入字符串是不是1－32位的数字
输入参数：需要测试的字符串
返回参数：是：true 不是：false
*/
function isDigit(s)
{
  var patrn=/^[0-9]{1,32}$/;
  var str = Trim(s);
  if (!patrn.exec(str)) return false;
  return true;
}

function isImbalanceCoef(s)
{
  var patrn=/^[0-9]{1,2}$/;
  var str = Trim(s);
  if (!patrn.exec(str)) return false;
  return true;
}

function isPrior(s){
  var patrn=/^[1-9]{1}$/;
  var str = Trim(s);
  if (!patrn.exec(str)) return false;
  return true;	
}

/**
函数名称：fnIsIntNum
函数功能：判断输入字符串是不是正整数字符串
输入参数：需要测试的字符串
返回参数：是：true 不是：false
*/
function fnIsIntNum(strNum)
{
 var strCheckNum = strNum + "";
 if(strCheckNum.length < 1)         //空字符串
  return false;
 else if(isNaN(strCheckNum))         //不是数值
  return false;
 else if(parseInt(strCheckNum,10) < 0)       //不是正数
  return false;
 else if(parseFloat(strCheckNum) > parseInt(strCheckNum,10)) //不是整数
  return false;

 return true;
}

function isLitteNumber(s)
{
  var patrn=/^[0]{1}[.]{1}[0-9]{1,4}$/;
  var str = Trim(s);
  if (patrn.exec(str)) return true;
  return false;
}

/**
函数名称：isProportions
函数功能：判断输入字符串是不是0-100的小数
输入参数：需要测试的字符串
返回参数：是：true 不是：false
*/
function isProportions(s)
{
  var patrn=/^[0-9]{1,2}$/;
  var patrn1=/^[0-9]{1,2}[.]{1}[0-9]{1,2}$/;
  var patrn2=/^[1]{1}[0]{1,2}$/;
  var patrn3=/^[1-9]{1}[0-9]{1}$/;
  var patrn4=/^[100]$/;
  var patrn5=/^\d{1,2}$/;
  var str = Trim(s);
  if (patrn5.exec(str)||patrn2.exec(str)) return true;
  return false;
}
/**
是否是邮政编码『中国』
*/
function isPostCode(s)
{
  var patrn=/^[1-9]{1}[0-9]{5}$/;
  var str = Trim(s);
  if (patrn.exec(str)) return true;
  return false;
}
/**
是否是验证码
*/
function isValidCode(s)
{
  var patrn=/^[0-9]|[a-z]|[A-Z]{6}$/;
  var str = Trim(s);
  if (patrn.exec(str)) return true;
  return false;
}
/**
是否是当次点数
*/
function isThisTimePoints(s)
{
  var patrn=/^[0-9]{1,4}$/;
  var str = Trim(s);
  if (patrn.exec(str)) return true;
  return false;
}
/**
费用
*/
function isFee(s)
{
	var patrn=/^[0-9]{1,6}$/;
  var patrn1=/^[0-9]{1,6}[.]{1}$/;
  var patrn2=/^[.]{1}[0-9]{1,2}$/;
  var patrn3=/^[0-9]{1,6}[.]{1}[0-9]{1,2}$/;
  var str = Trim(s);
  if (patrn.exec(str) || patrn1.exec(str) || patrn2.exec(str) ||patrn3.exec(str)) return true;
  return false;
}
/**
函数名称：IsTimeValid
函数功能：判断输入字符串是不是时间，例如：12:33,12:33-14:23
输入参数：需要测试的字符串
返回参数：是：true 不是：false
*/
function IsTimeValid(str)
{
    if(str == "")
    return true;
    var patrn =/^([0-9]|[-]|[,]|[:]){1,150}$/;
    if(!patrn.exec(str))
    {alert("时间段格式不正确");return false;}
    var tempTimeSeg = str.split(",");
    for(var i=0;i<tempTimeSeg.length;i++)
    {
     var d = /\-/;
     var j = -1;
     j = tempTimeSeg[i].search(d);
     if(j==-1)
     {checktime(tempTimeSeg[i]);}
     else
     {
     var temp = tempTimeSeg[i].split("-");
     if(temp.length !=2 )
     {alert("时间段输入格式不正确");return false;}
     else
     {checktime(temp[0]);checktime(temp[1]);}}
    }
    return true;
}

/**
函数名称：IsDateValid
函数功能：判断输入字符串是不是日期,例如：1,12-23,23-
输入参数：需要测试的字符串
返回参数：是：true 不是：false
*/
function IsDateValid(str)
{
    if (str == "")
    return true;
    var tempDateSeg = str.split(",");
    for(var i=0;i<tempDateSeg.length;i++)
    {
        var dateSplit = tempDateSeg[i].split("-");
        if(dateSplit.length == 2)
        {
          var temp1 = Trim(dateSplit[0]);
          var temp2 = Trim(dateSplit[1]);
          if(fnIsIntNum(temp1))
          {
            if(parseInt(temp1,10)<=0 || parseInt(temp1,10)>31)
              return false;
          }
          else
             return false;
          if(temp2 != "")
          {
            if(fnIsIntNum(temp2))
            {
              if(parseInt(temp2,10)<=0 || parseInt(temp2,10)>31)
                return false;
            }
            else
              return false;
          }
        }
        else if(dateSplit.length == 1)
        {
          var temp3 = Trim(dateSplit[0]);
          if(fnIsIntNum(temp3))
          {
             if(parseInt(temp3,10)<=0 || parseInt(temp3,10)>31)
                return false;
          }
          else
            return false;
        }
        else
          return false;
    }
    return true;
}


/**
*函数名称：CheckDate
*函数功能：判断结束日期是否大于起始日期
*输入参数：起始日期dates和结束日期datee
*返回值：是 true 否 false
*/
 function CheckDate(datee,dates)
 {
     arrDates = dates.split("-");
     arrDatee = datee.split("-");
     if(arrDates.length != 3 ||arrDatee.length != 3)
     {
      	return false;
     }
     if(fnIsIntNum(arrDates[0]) && fnIsIntNum(arrDates[1]) && fnIsIntNum(arrDates[2]) &&fnIsIntNum(arrDatee[0]) && fnIsIntNum(arrDatee[1]) && fnIsIntNum(arrDatee[2]))   //是整数
     {
     		
        var yy = parseInt(arrDates[0],10);
        var mm = parseInt(arrDates[1],10);
        var dd = parseInt(arrDates[2],10);
      	if(parseInt(arrDatee[0],10) > yy)
      	{
          return true;
      	}
      	else if(parseInt(arrDatee[0],10) == yy)
        {
           if(parseInt(arrDatee[1],10) > mm)
           {
               return true;
           }
           else if(parseInt(arrDatee[1],10) == mm)
           {
               if(parseInt(arrDatee[2],10) > dd)
               {
               	   return true;
               }
               
           }
        }
        return false;
     }
     return false;
 }
 /**
*函数名称：timecompare
*函数功能：判断结束时间是否大于起始时间
*输入参数：时间段
*返回值：是 true 否 false
*/
 function timecompare(time)
{
     arrtime = time.split("-");
     arrtime0 = arrtime[0].split(":");
     arrtime1 = arrtime[1].split(":");

     var yy = parseInt(arrtime0[0],10);
     var mm = parseInt(arrtime0[1],10);

      	if(parseInt(arrtime1[0],10) > yy)
      	{
          return true;
      	}
      	else if(parseInt(arrtime1[0],10) == yy)
       {
           if(parseInt(arrtime1[1],10) > mm)
           {
               return true;
           }

           return false;
       }
}
//功能：日期检查函数。
//  正确的日期格式为：2001-2-13，日期范围为 0001-1-1 到 9999-12-31
//  同时，对当前年当前月的天数也做了判断，如：2001-2-29 2001-4-31 都是非法的日期
//参数：strDate ---- 需要判断的日期字符串
//返回值：true ---- 日期合法 false ---- 日期不合法
function fnCheckDate(strDate)
{
 var strCheckDate = strDate + "";     //进一步确认哪来判断的肯定是一串字符串

 if(strCheckDate == "")        //空字符串,不是合法的日期字符串，返回false
 {
  return true;
 }

 //判断传进来的数据是那种格式写成日期
 var arrDate;          //分别存储年月日
 var pattern = /^(\d{4})-(\d{1,2})-(\d{1,2})$/g;
 if(!pattern.test(strCheckDate))
     {//alert("日期正确格式为：yyyy-MM-dd");
      return false;}

 arrDate = strCheckDate.split("-");    //2001-3-7 型
 //判断月是否合法
 if(parseInt(arrDate[1],10) < 1 || parseInt(arrDate[1],10) > 12)
    {
     //alert("月份必须在1到12间！");
     return false;
    }

 //判断日是否合法
 var intDayCount = fnComputerDay(parseInt(arrDate[0],10),parseInt(arrDate[1],10));
    if(intDayCount < parseInt(arrDate[2],10) || parseInt(arrDate[2],10) < 1)
    {
     //alert("请输入正确天数！");
     return false;
    }
 return true;
}


//**********************************************************************************************************
//功能：判断intYear年intMonth月的天数
//返回值：intYear年intMonth月的天数
function fnComputerDay(intYear,intMonth)
{
    var dtmDate = new Date(intYear,intMonth,-1);
    var intDay = dtmDate.getDate() + 1;

    return intDay;
}
/**
函数名称：issection
函数功能：判断输入字符串是不是符合规范的号段
判断规范：以13开头,或为空
输入参数：需要测试的字符串
返回参数：是号段：true 不是号段：false
*/
function issection(s)
{
    var patrn=/^(13)[0-9]{9}$/;
    if (!patrn.exec(s))
    {
       return false;
    }
    return true;
}
/**
函数名称：winopenSel
函数功能：弹出接入点选择框
输入参数：无
返回参数：无
*/
function winopenSel()
{
  var gwIdStr = document.forms[0].gwIdStr.value;

  var url = 'preselgwlist.do?gwIdStr='+gwIdStr;
  window.open(url,'',"height=350, width=600, top=200, left=200, toolbar=no,menubar=no, scrollbars=no, resizable=no,location=no, status=no");
}
/**
函数名称：winopenDef
函数功能：弹出窗口
输入参数：url
返回参数：无
*/
function winopenDef(url)
{
  window.open(url,'',"height=320, width=720, top=200, left=200, toolbar=no,menubar=no, scrollbars=yes, resizable=yes,location=no, status=no");
}
/**
*函数名称：CheckmonthDate
*函数功能：判断结束日期是否大于起始日期,不能跨月
*输入参数：起始日期dates和结束日期datee
*返回值：是 true 否 false
*/
 function CheckmonthDate(dates,datee)
 {
     arrDates = dates.split("-");
     arrDatee = datee.split("-");
     if(fnIsIntNum(arrDates[0]) && fnIsIntNum(arrDates[1]) && fnIsIntNum(arrDates[2]) &&fnIsIntNum(arrDatee[0]) && fnIsIntNum(arrDatee[1]) && fnIsIntNum(arrDatee[2]))   //是整数
     {
        var yy = parseInt(arrDates[0],10);
        var mm = parseInt(arrDates[1],10);
        var dd = parseInt(arrDates[2],10);
      	if(parseInt(arrDatee[0],10) != yy || parseInt(arrDatee[1],10) != mm)
      	{
          alert("查询日期不能跨月");
          return false;
      	}
      	else if(parseInt(arrDatee[2],10) >= dd)
        {
          return true;
        }
       alert("结束日期不得早于开始日期");
       return false;
    }
 }
/**
*函数名称：Issinglegw
*函数功能：判断是否只输入一个接入点
*输入参数：接入点
*返回值：是 true 否 false
*/
function Issinglegw(gw)
{
  var intIndex = -1;
  var regExpInfo = /,/;
  intIndex = gw.search(regExpInfo);

  if(intIndex == -1)
  {
  	return true;
  }
  alert("按号段查询时只能选择一个接入点");
  return false;
}
/**
*函数名称：Isspid
*函数功能：判断是否输入一个企业代码
*输入参数：企业代码
*返回值：是 true 否 false
*/
function Isspid(spId)
{
  var patrn=/^(9)[A-Z a-z 0-9]{2}[0-9]{3}$/;
  if (!patrn.exec(spId))
    {
        alert("企业代码输入不正确");
        return false;
    }
  return true;
}

/**
*函数名称：Istime
*函数功能：判断是否输入一个时间hh:mm:ss
*输入参数：shijian
*返回值：是 true 否 false
*/
function Istime(time)
{

  arrHHs = time.split(":");

  var hh = parseInt( arrHHs[0],10);
  var mm = parseInt( arrHHs[1], 10);
  var ss = parseInt( arrHHs[2],10);
  if(hh>23 ||hh<0||mm<0||mm>59||ss<0||ss>59)
  {return false;}
return true;
}
/**
*函数名称：Checktime
*函数功能：判断结束时间是否大于起始时间
*输入参数：起始时间dates和结束时间datee  hh:mm:ss
*返回值：是 true 否 false
*/
 function Checktime(dates,datee)
 {
     arrDates = dates.split(":");
     arrDatee = datee.split(":");
     if(arrDates.length != 3 ||arrDatee.length != 3)
     {
       return false;
     }
     if(fnIsIntNum(arrDates[0]) && fnIsIntNum(arrDates[1]) && fnIsIntNum(arrDates[2]) &&fnIsIntNum(arrDatee[0]) && fnIsIntNum(arrDatee[1]) && fnIsIntNum(arrDatee[2]))   //是整数
     {
        var yy = parseInt(arrDates[0],10);
        var mm = parseInt(arrDates[1],10);
        var dd = parseInt(arrDates[2],10);
       if(parseInt(arrDatee[0],10) > yy)
       {
          return true;
       }
       else if(parseInt(arrDatee[0],10) == yy)
       {
           if(parseInt(arrDatee[1],10) > mm)
           {
               return true;
           }
           else if(parseInt(arrDatee[1],10) == mm)
           {
               if(parseInt(arrDatee[2],10) > dd)
               {
                   return true;
               }
           }
       }
       return false;
       }
 }
/**
*函数名称：Istimecomp
*函数功能：判断输入时间早晚
*输入参数：两个时间
*返回值：是 true 否 false
*/
function IStimecomp(sn,sd)
{
    arr1 = sn.split(" ");
    arr2 = sd.split(" ");
  if(!CheckDate(arr1[0],arr2[0]))
  {alert("结束日期必须晚于开始日期");
   return false;}

  if(arr1[0] == arr2[0])
  {
  if(!Checktime(arr1[1],arr2[1]))
  {alert("结束时间必须晚于开始时间");
   return false;}
  }
return true;

}
/**
*函数名称：checkyearandmonth
*函数功能：判断输入时间是否是正确年和月
*输入参数：时间
*返回值：是 true 否 false
*/
function checkyearandmonth(date)
{
    date = Trim(date);
    var patrn=/^[0-9]{6}$/;
    if (!patrn.exec(date))
    {
        alert("输入日期位数错误");
        return false;
    }
    Month = ""+date.substring(4);
    month = parseInt(Month,10);
    if(month<1||month>12)
    {
    	alert("请输入正确的年月");
        return false;
    }
    return true;
}
function isNineDigit(s)
{
  var patrn=/^[0-9]{1,9}$/;
  var str = Trim(s);
  if (!patrn.exec(str)) return false;
  return true;
}
/**
*函数名称：checktime 如：12:20
*函数功能：判断输入时间是否是hh：mm
*输入参数：一个
*返回值：是 true 否 false
*/
function checktime(str)
{

    date = Trim(str);
    var timpSplit = date.split(":");
    if(timpSplit.length!=2)
    {return false;}
    if(fnIsIntNum(timpSplit[0]) && fnIsIntNum(timpSplit[1]))
       {
       	  if(parseInt(Trim(timpSplit[0]),10)<0 || parseInt(Trim(timpSplit[0]),10)>=24)
          {
             return false;
          }
         if(parseInt(Trim(timpSplit[1]),10)<0 || parseInt(Trim(timpSplit[1]),10)>=60)
         {
             return false;
         }
         return true;
       }

       else
       {
         alert("每天的时间段输入不合法");
         return false;
       }

   return false;
}

/**
*函数名称：isMobilsNum
*函数功能：判断输入是否是7位的号段
*输入参数：s 用户输入的号段
*返回值：是 true 否 false
*/
function isMobilsNum(s)
{
   var patrn=/^[0-9]{7}$/;
    if (!patrn.exec(s))
    {
       return false;
    }
    return true;
}

/**
*函数名称：isRightNum
*函数功能：判断输入开始号段是否小于结束号段
*输入参数：s 用户输入的起始号段； t 用户输入结束号段
*返回值：是 true 否 false
*/
function isRightNum(s,t)
{
    var beginNum = parseInt(s,10);
    var endNum = parseInt(t,10);
    if(beginNum>endNum)
    {
        return false;
    }
    return true;
}

/**
*函数名称：isRightModulus
*函数功能：判断输入数字是否为3位有效数字（两位小数）
*输入参数：s 用户输入数字
*返回值：是 true 否 false
*/
function isRightModulus(s)
{
    var patrn=/^[0-9]{1}$/;
    var patrn1=/^[0-9]{1}[.]{1}[0-9]{1,2}$/;
    var str = Trim(s);
    if (patrn.exec(str)||patrn1.exec(str))
    {
       return true;
    }
    return false;
}

/**
*函数名称：isRightModulus2
*函数功能：判断输入数字是否为9位有效数字（两位小数）
*输入参数：s 用户输入数字
*返回值：是 true 否 false
*/
function isRightModulus2(s)
{
    var patrn=/^[0-9]{1,10}$/;
    var patrn1=/^[0-9]{1,10}[.]{1}[0-9]{1,4}$/;
    var str = Trim(s);
    if (patrn.exec(str)||patrn1.exec(str))
    {
       return true;
    }
    return false;
}
/**
*函数名称：addOption
*函数功能：增加列表中的选项
*输入参数：
*返回值：无
*/
function addOption(value,text,sel)
{
	var opt=document.createElement("OPTION");
        opt.text=text;
        opt.value=value;
        opt.selected=true;
        sel.options.add(opt);
}
/**
*函数名称：changeAreaCodeVisiable
*函数功能：显示或隐藏areainfo
*输入参数：subProductSize
*返回值：无
*/
function changeAreaCodeVisiable(subProductSize)
{
  if(subProductSize == 1){
    document.getElementById("areaCodeList").style.display="";
    document.getElementById("areaCodeList2").style.display="";
    document.getElementById("areaCodeListStruts").style.display="none";
  }else{
    document.getElementById("areaCodeList").style.display="none";
    document.getElementById("areaCodeList2").style.display="none";
    document.getElementById("areaCodeListStruts").style.display="";
  }
}


function winopenAreaSel()
{
  var gwIdStr = document.forms[0].gwIdStr.value;
  var areaIdStr = document.forms[0].areaIdStr.value;

  var url = 'preselarealist.do?gwIdStr='+gwIdStr+'&areaIdStr='+areaIdStr;
  window.open(url,'',"height=350, width=600, top=200, left=200, toolbar=no,menubar=no, scrollbars=no, resizable=no,location=no, status=no");
}
/**
* 函数名称：checkNoMoreThen31Day
* 函数功能：检查输入日期间隔是否超过31天
* 输入参数：dates表示起始日期,datee表示结束日期
* 返回参数：不超过：true;超过：false
*/
function checkNoMoreThen31Day(dates,datee)
{
  arrDates = dates.split("-");
  arrDatee = datee.split("-");
  if(fnIsIntNum(arrDates[0])&&fnIsIntNum(arrDates[1])&&fnIsIntNum(arrDates[2])&&fnIsIntNum(arrDatee[0])&&fnIsIntNum(arrDatee[1])&&fnIsIntNum(arrDatee[2]))
  {
    var yys = parseInt(arrDates[0],10);
    var mms = parseInt(arrDates[1],10)-1;
    var dds = parseInt(arrDates[2],10);
    var ds = new Date(yys,mms,dds);
    var yye = parseInt(arrDatee[0],10);
    var mme = parseInt(arrDatee[1],10)-1;
    var dde = parseInt(arrDatee[2],10);
    var de = new Date(yye,mme,dde);
    if((de.getTime()-ds.getTime())>31*24*3600*1000)
    {
    	return false;
    }
    else
    	return true;
  }
}

//数据导出EXCEL
//o：要输出的页面区域的DIV ID
//n：要输出的XLS文件名前缀，将生成的XLS文件名缺省为：n（文件名前缀）+_2004-06-07（当前日期）.xls
function data2Excel(o, n)
{
	var fso = null, fldr = null, tmpStr = "", tmpObj = "";

	alert("如果系统提示“是否应用ActiveX”，请选择“是”！");
	var dataTabHTML = "<TABLE id=\"_eDataFrame\" style=\"display:none\">";

	for (var  i = 0; i < o.children.length ; i ++)
		if (o.children(i).tagName == "TABLE")
			dataTabHTML += o.children(i).innerHTML;

	dataTabHTML += "</TABLE>";

	document.body.insertAdjacentHTML("afterBegin", dataTabHTML);
	document.body.insertAdjacentHTML("afterBegin", "<OBJECT id=\"_EXPORT_OBJECT\" classid=\"clsid:0002E510-0000-0000-C000-000000000046\" style=\"display:none\"></Object>");

	for (var i = 0; i < _eDataFrame.rows.length; i ++)
	{
		for (var j = 0; j < _eDataFrame.rows[i].cells.length; j ++)
		{
			for (var k = 0; k < _eDataFrame.rows[i].cells[j].children.length; k ++)
			{
				if (_eDataFrame.rows[i].cells[j].children(k).tagName == "INPUT")
				{
					tmpStr = _eDataFrame.rows[i].cells[j].children(k).value;
					tmpObj = document.createElement("SPAN");
					tmpObj.innerText = tmpStr;
					_eDataFrame.rows[i].cells[j].children(k).replaceNode(tmpObj);
				}
				else if (_eDataFrame.rows[i].cells[j].children(k).face == "webdings" || _eDataFrame.rows[i].cells[j].children(k).style.fontFamily == "webdings")
				{
					_eDataFrame.rows[i].cells[j].children(k).removeNode(true);
				}
			}
		}
	}

	try
	{
		fso = new ActiveXObject("Scripting.FileSystemObject");
		fldr = fso.CreateFolder("C:\\sinochem");
	}
	catch(e){}

	with(_EXPORT_OBJECT)
	{
		DataType = "HTMLData";
		HTMLData = _eDataFrame.outerHTML;

		try
		{
			ActiveSheet.Export("C:\\sinochem\\" + n + "_" + Get_Cur_DateStr() + ".xls", 0);
			alert('数据导出完毕,数据的格式请到Excel中自行调整!');
		}
		catch (e)
		{
			alert('任务取消或导出数据失败\n[请确认已安装Excel2000(或更高版本),并且没打开同名xls文件]');
		}
	}

	document.body.removeChild(_eDataFrame);
	document.body.removeChild(_EXPORT_OBJECT);
}

function Get_Cur_DateStr(sschar)
{
	var Today = new Date();

	var year_Str;
	var mon_Str;
	var day_Str;

	var year = Today.getYear();
	var mon = Today.getMonth() + 1;
	var day = Today.getDate();

	year_Str = year.toString();
	mon_Str = mon.toString();
	day_Str = day.toString();
	if ( mon <10 )
	{
		mon_Str = '0' + mon_Str;
	}
	if ( day <10 )
	{
		day_Str = '0' + day_Str;
	}

	var str_date = year_Str + "-" + mon_Str + "-" + day_Str;
	return str_date;
}
