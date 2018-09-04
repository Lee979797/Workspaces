
function IsNumeric(str,dec,beginPos)
{
   if(dec==null) dec = 0;
   if(beginPos==null) beginPos = dec
   var rg = /^\d+$/;
   if(dec > 0 ) rg = eval("/^\\d+\\.?\\d{"+beginPos+","+dec+"}$/");
   return rg.test(str);
}

// 功能：判断是否为整数

function IsInter(str)
{
   var rg = /^\d+$/;
   return rg.test(str);
}

// 功能：字符串是否为空

function IsEmpty(str)
{
    var rg = /^(\s|　)*$/;
    return rg.test(str);
}

// 功能：判断是否为汉字

function IsChinese(str)
{
   var rg = /^[\u4e00-\u9fa5]+$/;
   return rg.test(str);
}

// 功能：判断是否为合法的字段名
// 参数：IsChinese 是否包含中文 true 包含 false 不包含
// 提示：XXX中不能包含下列任何字符之一"\/:*?"'<>|&"
function IsValidFieldName(str,isChinese)
{

  if(isChinese==null) isChinese = false;
  var rg;
  if(IsChinese)
	{
	rg =  /^[a-z|A-Z|\u4e00-\u9fa5]+[_|a-z|A-Z|0-9|\u4e00-\u9fa5]*$/;
 	}
  else
 	{
	rg =  /^[a-z|A-Z]+[_|a-z|A-Z|0-9]*$/;
	}
  return rg.test(str);
}

function IsHasInvalidString(str)
{
  var rg = /[\/:*?\"\'<>|&]/;
  return rg.test(str);
}

// 判断是否为日期

function IsDate(oDate)
{

 var rgExp = /^\s*(\d{4})-(\d{1,2})-(\d{1,2})$/;
 var arr = rgExp.exec(oDate); if(arr==null) return false; 
 if(arr[0].replace(/\s/gi,"")!=oDate.replace(/\s/gi,"")) return false;
 arr[1] = parseInt(arr[1],10);
 arr[2] = parseInt(arr[2],10);
 arr[3] = parseInt(arr[3],10); 
 if(arr[1]>2099||arr[1]<1900) return false;
 if(arr[2]>12||arr[2]<1) return false;
 if(arr[2]==2)
   { if(arr[1]%4!=0) 
        { if(arr[3]>28||arr[3]<1) return false;}
    else{if(arr[3]>29||arr[3]<1) return false;}
   }
 else{ if(arr[2]==4||arr[2]==6||arr[2]==9||arr[2]==11)
      { if(arr[3]>30||arr[3]<1) return false; } 
      else {if(arr[3]>31||arr[3]<1) return false;}}
  return true;
}

function IsMail(mail) 
{ 
	return(new RegExp(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/).test(mail)); 
} 

function IsTime(str)
{
	var reg=/^\d{1,2}:\d{1,2}$/g;
	if(!reg.test(str)) return false;
	var intHours=str.replace(/^(\d{1,2}):(\d{1,2})$/,"$1");
	var intMinute=str.replace(/^(\d{1,2}):(\d{1,2})$/,"$2");
	if(parseInt(intHours,10)>=24) return false;
	if(parseInt(intMinute,10)>=60) return false;
	return true;
}