/**
�������ƣ�isChinese
�������ܣ��ж������Ƿ�������Ļ�����������
�����������Ҫ���Ե��ַ���
���ز������������ĺ��������ţ�true ���������ĺ��������ţ� false
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
�������ƣ�fucCheckLength
�������ܣ��ж������ַ����ĳ��ȣ��������ģ�
�����������Ҫ���Ե��ַ���
���ز�����sum:�ַ�������
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
�������ƣ�Trim
�������ܣ�ȥ�������ַ����������ߵĿո�
����������ַ���
���ز������ַ���
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
�������ƣ�isIpAddress
�������ܣ��ж������ַ����ǲ��Ƿ��Ϲ淶��IP��ַ
�����������Ҫ���Ե��ַ���
���ز�������IP��ַ��true ����IP��ַ��false
*/
function isIpAddress(s)
{
	 var pattern=/(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])/;
   if(!pattern.exec(s))
   {
     alert("IP��ַ����ȷ");
     return false;
   }
  	return true;
}
/**
�������ƣ�isip
�������ܣ��ж������ַ����ǲ��Ƿ��Ϲ淶��IP��ַ
�����������Ҫ���Ե��ַ���
���ز�������IP��ַ��true ����IP��ַ��false
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
�������ƣ�isCoordinate 
�������ܣ��ж������ַ����ǲ��Ƿ��Ϲ淶������
�����������Ҫ���Ե��ַ���
���ز����������꣺true �������꣺false
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
�Ƿ����������롺�й���
*/
function isAreaCode(s)
{
  var patrn=/^[0]{1}[1-9]{1}[0-9]{1,2}$/;
  var str = Trim(s);
  if (patrn.exec(str)) return true;
  return false;
}

/**
�������ƣ�isPhoneNumber
�������ܣ��ж������ַ����ǲ��Ƿ��Ϲ淶�Ĺ̶��绰����
�жϹ淶��1-20λ�����ֻ�"-"��
�����������Ҫ���Ե��ַ���
���ز������ǵ绰���룺true ���ǵ绰���룺false
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
�������ƣ�samePassword
�������ܣ��ж����������ַ����ǲ�����ͬ
�����������Ҫ���Ե������ַ���
���ز�������ͬ��true ��ͬ��false
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
�������ƣ�ismobile
�������ܣ��ж������ַ����ǲ��Ƿ��Ϲ淶���ֻ����루������С��ͨ��
�жϹ淶����13��ͷ
�����������Ҫ���Ե��ַ���
���ز��������ֻ����룺true �����ֻ����룺false
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
�������ƣ�isEmail
�������ܣ��ж������ַ����ǲ��Ƿ��Ϲ淶�������ַ
�����������Ҫ���Ե��ַ���
���ز������������ַ��true ���������ַ��false
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
�������ƣ�isDigit
�������ܣ��ж������ַ����ǲ���1��32λ������
�����������Ҫ���Ե��ַ���
���ز������ǣ�true ���ǣ�false
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
�������ƣ�fnIsIntNum
�������ܣ��ж������ַ����ǲ����������ַ���
�����������Ҫ���Ե��ַ���
���ز������ǣ�true ���ǣ�false
*/
function fnIsIntNum(strNum)
{
 var strCheckNum = strNum + "";
 if(strCheckNum.length < 1)         //���ַ���
  return false;
 else if(isNaN(strCheckNum))         //������ֵ
  return false;
 else if(parseInt(strCheckNum,10) < 0)       //��������
  return false;
 else if(parseFloat(strCheckNum) > parseInt(strCheckNum,10)) //��������
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
�������ƣ�isProportions
�������ܣ��ж������ַ����ǲ���0-100��С��
�����������Ҫ���Ե��ַ���
���ز������ǣ�true ���ǣ�false
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
�Ƿ����������롺�й���
*/
function isPostCode(s)
{
  var patrn=/^[1-9]{1}[0-9]{5}$/;
  var str = Trim(s);
  if (patrn.exec(str)) return true;
  return false;
}
/**
�Ƿ�����֤��
*/
function isValidCode(s)
{
  var patrn=/^[0-9]|[a-z]|[A-Z]{6}$/;
  var str = Trim(s);
  if (patrn.exec(str)) return true;
  return false;
}
/**
�Ƿ��ǵ��ε���
*/
function isThisTimePoints(s)
{
  var patrn=/^[0-9]{1,4}$/;
  var str = Trim(s);
  if (patrn.exec(str)) return true;
  return false;
}
/**
����
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
�������ƣ�IsTimeValid
�������ܣ��ж������ַ����ǲ���ʱ�䣬���磺12:33,12:33-14:23
�����������Ҫ���Ե��ַ���
���ز������ǣ�true ���ǣ�false
*/
function IsTimeValid(str)
{
    if(str == "")
    return true;
    var patrn =/^([0-9]|[-]|[,]|[:]){1,150}$/;
    if(!patrn.exec(str))
    {alert("ʱ��θ�ʽ����ȷ");return false;}
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
     {alert("ʱ��������ʽ����ȷ");return false;}
     else
     {checktime(temp[0]);checktime(temp[1]);}}
    }
    return true;
}

/**
�������ƣ�IsDateValid
�������ܣ��ж������ַ����ǲ�������,���磺1,12-23,23-
�����������Ҫ���Ե��ַ���
���ز������ǣ�true ���ǣ�false
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
*�������ƣ�CheckDate
*�������ܣ��жϽ��������Ƿ������ʼ����
*�����������ʼ����dates�ͽ�������datee
*����ֵ���� true �� false
*/
 function CheckDate(datee,dates)
 {
     arrDates = dates.split("-");
     arrDatee = datee.split("-");
     if(arrDates.length != 3 ||arrDatee.length != 3)
     {
      	return false;
     }
     if(fnIsIntNum(arrDates[0]) && fnIsIntNum(arrDates[1]) && fnIsIntNum(arrDates[2]) &&fnIsIntNum(arrDatee[0]) && fnIsIntNum(arrDatee[1]) && fnIsIntNum(arrDatee[2]))   //������
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
*�������ƣ�timecompare
*�������ܣ��жϽ���ʱ���Ƿ������ʼʱ��
*���������ʱ���
*����ֵ���� true �� false
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
//���ܣ����ڼ�麯����
//  ��ȷ�����ڸ�ʽΪ��2001-2-13�����ڷ�ΧΪ 0001-1-1 �� 9999-12-31
//  ͬʱ���Ե�ǰ�굱ǰ�µ�����Ҳ�����жϣ��磺2001-2-29 2001-4-31 ���ǷǷ�������
//������strDate ---- ��Ҫ�жϵ������ַ���
//����ֵ��true ---- ���ںϷ� false ---- ���ڲ��Ϸ�
function fnCheckDate(strDate)
{
 var strCheckDate = strDate + "";     //��һ��ȷ�������жϵĿ϶���һ���ַ���

 if(strCheckDate == "")        //���ַ���,���ǺϷ��������ַ���������false
 {
  return true;
 }

 //�жϴ����������������ָ�ʽд������
 var arrDate;          //�ֱ�洢������
 var pattern = /^(\d{4})-(\d{1,2})-(\d{1,2})$/g;
 if(!pattern.test(strCheckDate))
     {//alert("������ȷ��ʽΪ��yyyy-MM-dd");
      return false;}

 arrDate = strCheckDate.split("-");    //2001-3-7 ��
 //�ж����Ƿ�Ϸ�
 if(parseInt(arrDate[1],10) < 1 || parseInt(arrDate[1],10) > 12)
    {
     //alert("�·ݱ�����1��12�䣡");
     return false;
    }

 //�ж����Ƿ�Ϸ�
 var intDayCount = fnComputerDay(parseInt(arrDate[0],10),parseInt(arrDate[1],10));
    if(intDayCount < parseInt(arrDate[2],10) || parseInt(arrDate[2],10) < 1)
    {
     //alert("��������ȷ������");
     return false;
    }
 return true;
}


//**********************************************************************************************************
//���ܣ��ж�intYear��intMonth�µ�����
//����ֵ��intYear��intMonth�µ�����
function fnComputerDay(intYear,intMonth)
{
    var dtmDate = new Date(intYear,intMonth,-1);
    var intDay = dtmDate.getDate() + 1;

    return intDay;
}
/**
�������ƣ�issection
�������ܣ��ж������ַ����ǲ��Ƿ��Ϲ淶�ĺŶ�
�жϹ淶����13��ͷ,��Ϊ��
�����������Ҫ���Ե��ַ���
���ز������ǺŶΣ�true ���ǺŶΣ�false
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
�������ƣ�winopenSel
�������ܣ����������ѡ���
�����������
���ز�������
*/
function winopenSel()
{
  var gwIdStr = document.forms[0].gwIdStr.value;

  var url = 'preselgwlist.do?gwIdStr='+gwIdStr;
  window.open(url,'',"height=350, width=600, top=200, left=200, toolbar=no,menubar=no, scrollbars=no, resizable=no,location=no, status=no");
}
/**
�������ƣ�winopenDef
�������ܣ���������
���������url
���ز�������
*/
function winopenDef(url)
{
  window.open(url,'',"height=320, width=720, top=200, left=200, toolbar=no,menubar=no, scrollbars=yes, resizable=yes,location=no, status=no");
}
/**
*�������ƣ�CheckmonthDate
*�������ܣ��жϽ��������Ƿ������ʼ����,���ܿ���
*�����������ʼ����dates�ͽ�������datee
*����ֵ���� true �� false
*/
 function CheckmonthDate(dates,datee)
 {
     arrDates = dates.split("-");
     arrDatee = datee.split("-");
     if(fnIsIntNum(arrDates[0]) && fnIsIntNum(arrDates[1]) && fnIsIntNum(arrDates[2]) &&fnIsIntNum(arrDatee[0]) && fnIsIntNum(arrDatee[1]) && fnIsIntNum(arrDatee[2]))   //������
     {
        var yy = parseInt(arrDates[0],10);
        var mm = parseInt(arrDates[1],10);
        var dd = parseInt(arrDates[2],10);
      	if(parseInt(arrDatee[0],10) != yy || parseInt(arrDatee[1],10) != mm)
      	{
          alert("��ѯ���ڲ��ܿ���");
          return false;
      	}
      	else if(parseInt(arrDatee[2],10) >= dd)
        {
          return true;
        }
       alert("�������ڲ������ڿ�ʼ����");
       return false;
    }
 }
/**
*�������ƣ�Issinglegw
*�������ܣ��ж��Ƿ�ֻ����һ�������
*��������������
*����ֵ���� true �� false
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
  alert("���Ŷβ�ѯʱֻ��ѡ��һ�������");
  return false;
}
/**
*�������ƣ�Isspid
*�������ܣ��ж��Ƿ�����һ����ҵ����
*�����������ҵ����
*����ֵ���� true �� false
*/
function Isspid(spId)
{
  var patrn=/^(9)[A-Z a-z 0-9]{2}[0-9]{3}$/;
  if (!patrn.exec(spId))
    {
        alert("��ҵ�������벻��ȷ");
        return false;
    }
  return true;
}

/**
*�������ƣ�Istime
*�������ܣ��ж��Ƿ�����һ��ʱ��hh:mm:ss
*���������shijian
*����ֵ���� true �� false
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
*�������ƣ�Checktime
*�������ܣ��жϽ���ʱ���Ƿ������ʼʱ��
*�����������ʼʱ��dates�ͽ���ʱ��datee  hh:mm:ss
*����ֵ���� true �� false
*/
 function Checktime(dates,datee)
 {
     arrDates = dates.split(":");
     arrDatee = datee.split(":");
     if(arrDates.length != 3 ||arrDatee.length != 3)
     {
       return false;
     }
     if(fnIsIntNum(arrDates[0]) && fnIsIntNum(arrDates[1]) && fnIsIntNum(arrDates[2]) &&fnIsIntNum(arrDatee[0]) && fnIsIntNum(arrDatee[1]) && fnIsIntNum(arrDatee[2]))   //������
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
*�������ƣ�Istimecomp
*�������ܣ��ж�����ʱ������
*�������������ʱ��
*����ֵ���� true �� false
*/
function IStimecomp(sn,sd)
{
    arr1 = sn.split(" ");
    arr2 = sd.split(" ");
  if(!CheckDate(arr1[0],arr2[0]))
  {alert("�������ڱ������ڿ�ʼ����");
   return false;}

  if(arr1[0] == arr2[0])
  {
  if(!Checktime(arr1[1],arr2[1]))
  {alert("����ʱ��������ڿ�ʼʱ��");
   return false;}
  }
return true;

}
/**
*�������ƣ�checkyearandmonth
*�������ܣ��ж�����ʱ���Ƿ�����ȷ�����
*���������ʱ��
*����ֵ���� true �� false
*/
function checkyearandmonth(date)
{
    date = Trim(date);
    var patrn=/^[0-9]{6}$/;
    if (!patrn.exec(date))
    {
        alert("��������λ������");
        return false;
    }
    Month = ""+date.substring(4);
    month = parseInt(Month,10);
    if(month<1||month>12)
    {
    	alert("��������ȷ������");
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
*�������ƣ�checktime �磺12:20
*�������ܣ��ж�����ʱ���Ƿ���hh��mm
*���������һ��
*����ֵ���� true �� false
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
         alert("ÿ���ʱ������벻�Ϸ�");
         return false;
       }

   return false;
}

/**
*�������ƣ�isMobilsNum
*�������ܣ��ж������Ƿ���7λ�ĺŶ�
*���������s �û�����ĺŶ�
*����ֵ���� true �� false
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
*�������ƣ�isRightNum
*�������ܣ��ж����뿪ʼ�Ŷ��Ƿ�С�ڽ����Ŷ�
*���������s �û��������ʼ�ŶΣ� t �û���������Ŷ�
*����ֵ���� true �� false
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
*�������ƣ�isRightModulus
*�������ܣ��ж����������Ƿ�Ϊ3λ��Ч���֣���λС����
*���������s �û���������
*����ֵ���� true �� false
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
*�������ƣ�isRightModulus2
*�������ܣ��ж����������Ƿ�Ϊ9λ��Ч���֣���λС����
*���������s �û���������
*����ֵ���� true �� false
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
*�������ƣ�addOption
*�������ܣ������б��е�ѡ��
*���������
*����ֵ����
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
*�������ƣ�changeAreaCodeVisiable
*�������ܣ���ʾ������areainfo
*���������subProductSize
*����ֵ����
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
* �������ƣ�checkNoMoreThen31Day
* �������ܣ�����������ڼ���Ƿ񳬹�31��
* ���������dates��ʾ��ʼ����,datee��ʾ��������
* ���ز�������������true;������false
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

//���ݵ���EXCEL
//o��Ҫ�����ҳ�������DIV ID
//n��Ҫ�����XLS�ļ���ǰ׺�������ɵ�XLS�ļ���ȱʡΪ��n���ļ���ǰ׺��+_2004-06-07����ǰ���ڣ�.xls
function data2Excel(o, n)
{
	var fso = null, fldr = null, tmpStr = "", tmpObj = "";

	alert("���ϵͳ��ʾ���Ƿ�Ӧ��ActiveX������ѡ���ǡ���");
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
			alert('���ݵ������,���ݵĸ�ʽ�뵽Excel�����е���!');
		}
		catch (e)
		{
			alert('����ȡ���򵼳�����ʧ��\n[��ȷ���Ѱ�װExcel2000(����߰汾),����û��ͬ��xls�ļ�]');
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
