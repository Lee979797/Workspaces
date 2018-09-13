/**
 * 此Javascript提供了基本检验操作。
 */
Validate=function Validate(){};

/**
 * 判断输入值是否为空(null or "").
 * @param obj Object,标签对象.
 * @param isSpaceFilter boolean,是否先去除字符串右端的空格.
 * @return boolean,输入值是否为空.
*/
Validate.isBlank=function(obj,isSpaceFilter)
{
  if(obj.value==null)
    return true;
  if(isSpaceFilter)
  {
    if(!(obj.type!=null && obj.type.toLowerCase()=="file"))//否则firefox中会报错
      obj.value = StrUtil.rTrim(obj.value);
  }
  return obj.value==""
};

/**
 * 判断输入值是否为空(null or ""),去除字符串右端的空格.
 * @param obj Object,标签对象.
 * @return boolean,输入值是否为空.
 */
Validate.isBlankEx=function(obj)
{
  return Validate.isBlank(obj,true);
};

/**
 * 判断输入值是否为数值.
 * @param obj Object,标签对象.
 * @return boolean,输入值是否为数值.
 */
Validate.isNumber=function(obj)
{
  if(!(obj.type!=null && obj.type.toLowerCase()=="file"))
    obj.value = StrUtil.rTrim(obj.value);
  return !isNaN(obj.value)
};

/**
 * 判断输入值是否为整数.
 * @param obj Object,标签对象.
 * @return boolean,输入值是否为整数.
 */
Validate.isInteger=function(obj)
{
  if(!Validate.isNumber(obj))
    return false;
  if(StrUtil.rTrim(obj.value)=="")
    return true;
  if(parseInt(obj.value,10)==parseFloat(obj.value))
    return true;
  else
    return false;
};

/**
 * 判断输入值是否在一区间内.
 * @param obj Object,标签对象.
 * @param nMin float,左边界取值.
 * @param isContainMin boolean,是否左边界为闭区间.
 * @param nMax float,右边界取值.
 * @param isContainMax boolean,是否右边界为闭区间.
 * @return boolean,输入值是否在一区间内.
 */
Validate.isBetween=function(obj,nMin,isContainMin,nMax,isContainMax)
{
  if(!Validate.isNumber(obj))
    return false;
  var result = parseFloat(obj.value);
  var condition1 = (result>nMin && !isContainMin) || (result>=nMin && isContainMin);
  var condition2 = (result<nMax && !isContainMax) || (result<=nMax && isContainMax);
  if(condition1 && condition2)
    return true;
  else
    return false;
};

/**
 * 判断输入值是否在一区间内（左边界为闭区间，右边界为闭区间）.
 * @param obj Object,标签对象.
 * @param nMin float,左边界取值.
 * @param nMax float,右边界取值.
 * @return 输入值是否在一区间内.
 */
Validate.isBetweenEx=function(obj,nMin,nMax)
{
  return Validate.isBetween(obj,nMin,true,nMax,true);
};

/**判断输入值是否小于某一数值.
 * @param obj Object,标签对象.
 * @param nMax float,右边界取值.
 * @param isContainMax boolean,是否右边界为闭区间.
 * @return boolean,输入值是否小于某一数值.
 */
Validate.isBelow=function(obj,nMax,isContainMax)
{
  if(!Validate.isNumber(obj))
    return false;
  var result = parseFloat(obj.value);
  if(result<nMax && !isContainMax || result<=nMax && isContainMax)
    return true;
  else
    return false;
};

/**
 * 判断输入值是否小于某一数值（右边界为闭区间）.
 * @param obj Object,标签对象.
 * @param nMax float,右边界取值.
 * @param isContainMax boolean,是否右边界为闭区间.
 * @return boolean,输入值是否小于某一数值.
 */
Validate.isBelowEx=function(obj,nMax)
{
  return Validate.isBelow(obj,nMax,true);
};

/**
 * 判断输入值是否大于某一数值.
 * @param obj Object,标签对象.
 * @param nMin float,左边界取值.
 * @param isContainMin boolean,是否左边界为闭区间.
 * @return boolean,输入值是否小于某一数值.
 */
Validate.isAbove=function(obj,nMin,isContainMin)
{
  if(!Validate.isNumber(obj))
    return false;
  var result = parseFloat(obj.value);
  if(result>nMin && !isContainMin || result>=nMin && isContainMin)
    return true;
  else
    return false;
};

/**
 * 判断输入值是否大于某一数值（左边界为闭区间）.
 * @param obj Object,标签对象.
 * @parma nMin float,左边界取值.
 * @param isContainMin boolean,是否左边界为闭区间.
 * @return boolean,输入值是否小于某一数值.
 */
Validate.isAboveEx=function(obj,nMin)
{
  return Validate.isAbove(obj,nMin,true);
};

/**
 * 判断输入值是否为正数.
 * @param obj Object,标签对象.
 * @param isContainZero boolean,是否允许零为合法.
 * @return boolean,输入值是否为正数.
 */
Validate.isPositiveNumber=function(obj,isContainZero)
{
  return Validate.isAbove(obj,0,isContainZero);
};

/**
 * 判断输入值是否为正数（允许零为合法）.
 * @param obj Object,标签对象.
 * @return boolean,输入值是否为正数.
*/
Validate.isPositiveNumberEx=function(obj)
{
  return Validate.isPositiveNumber(obj,true);
};

/**
 * 判断输入值是否为指定的合法字符串.
 * @param obj Object,标签对象.
 * @param species String,合法字符集.
 * @param isSpaceFilter boolean,是否先去除字符串两端的空格.
 * @return boolean,输入值是否为指定的合法字符串.
 */
Validate.VS_LETTER = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
Validate.VS_NUMBER = "0123456789";
Validate.VS_BASIC = Validate.VS_LETTER + Validate.VS_NUMBER;
Validate.VS_COMMON = "@$()/.- _" + Validate.VS_BASIC;
Validate.isValidString=function(obj,species,isSpaceFilter)
{
  if(isSpaceFilter)
  {
    if(!(obj.type!=null && obj.type.toLowerCase()=="file"))
      obj.value = StrUtil.rTrim(obj.value);
  }
  for(i=0;i<obj.value.length;i++)
    if(species.indexOf(obj.value.charAt(i))<0)
      return false;
  return true;
};

/**
 * 判断输入值是否为指定的合法字符串（以Validate.VS_COMMON为合法字符集，先去除字符串两端的空格）.
 * @param obj Object,标签对象.
 * @return boolean,输入值是否为指定的合法字符串.
 */
Validate.isValidStringEx=function(obj)
{
  return Validate.isValidString(obj,Validate.VS_BASIC,true);
};

/**
 * 判断输入值是否为指定的合法的中文字符串.
 * @param obj Object,标签对象.
 * @param species String,其它合法字符集.
 * @param isSpaceFilter boolean,是否先去除字符串两端的空格.
 * @return boolean,输入值是否为指定的合法中文字符串.
 */
Validate.isValidChineseString=function(obj,species,isSpaceFilter)
{
  if(isSpaceFilter )
  {
    if(!(obj.type!=null && obj.type.toLowerCase()=="file"))
      obj.value = StrUtil.rTrim(obj.value);
  }
  for(i=0;i<obj.value.length;i++)
    if(species.indexOf(obj.value.charAt(i))<0 && obj.value.charCodeAt(i)<19968)
       return false;
  return true;
};

/**
 * 判断输入值是否为指定的合法的中文字符串（以Validate.VS_COMMON为其它合法字符集，先去除字符串两端的空格）.
 * @param obj Object,标签对象.
 * @return boolean,输入值是否为指定的合法中文字符串.
 */
Validate.isValidChineseStringEx=function(obj)
{
  return Validate.isValidChineseString(obj,Validate.VS_BASIC,true);
};

/**
 * 判断输入值是否为指定的合法的扩展（含中文）字符串.
 * @param obj Object,标签对象.
 * @param species,其它合法字符集.
 * @param isSpaceFilter boolean,是否先去除字符串两端的空格.
 * @return boolean,输入值是否为指定的合法扩展（含中文）字符串.
 */
Validate.isValidExtendedString=function(obj,species,isSpaceFilter)
{
  if(isSpaceFilter)
  {
    if(!(obj.type!=null && obj.type.toLowerCase()=="file"))
      obj.value = StrUtil.rTrim(obj.value);
  }
  for(i=0;i<obj.value.length;i++)
    if(species.indexOf(obj.value.charAt(i))<0 && obj.value.charCodeAt(i)<128)
      return false;
  return true;
};

/**
 * 判断输入值是否为指定的合法的扩展（含中文）字符串（以Validate.VS_COMMON为其它合法字符集，先去除字符串两端的空格）.
 * @param obj Object,标签对象.
 * @return boolean,输入值是否为指定的合法扩展（含中文）字符串.
 */
Validate.isValidExtendedStringEx=function(obj)
{
  return Validate.isValidExtendedString(obj,Validate.VS_COMMON,true);
};

/**
 * 判断输入值是否为合法的日期类型（格式为yyyy[?mm?dd]其中年份必须为[1000,9999]）.
 * @param obj Object,标签对象.
 * @param conjunction String,为年月日的连接符.
 * @return boolean,输入值是否为合法的日期类型.
 */
Validate.isStandardDate=function(obj,conjunction)
{
  if(!(obj.type!=null && obj.type.toLowerCase()=="file"))
    obj.value = StrUtil.rTrim(obj.value);
  if(obj.value=="")
    return true;
  var isCheckConj=conjunction && conjunction!=""?true:false; 
  var len=obj.value.length;
  var year = "";
  var month="";
  var day="";  
  var index=0;
  for(;index<obj.value.length;index++)
  {
    var charVal=obj.value.charAt(index);
    if(!isNaN(charVal) && charVal!=' ')
    {
      year+=charVal;
      if(!isCheckConj && year.length==4)
      {
        index++;
        break;
      }
    }
    else
    {
      if(isCheckConj && charVal!=conjunction)
        return false;
      break;
    }
  }
  var isStart=false;
  for(;index<obj.value.length;index++)
  {
    var charVal=obj.value.charAt(index);
    if(!isNaN(charVal) && charVal!=' ')
    {
      month+=charVal;
      isStart=true;
      if(!isCheckConj && month.length==2)
      {
        index++;
        break;
      }
    }
    else if(isStart)
    {
      if(isCheckConj && charVal!=conjunction)
        return false;
      break;
    }
  }
  isStart=false;
  for(;index<obj.value.length;index++)
  {
    var charVal=obj.value.charAt(index);
    if(!isNaN(charVal) && charVal!=' ' )
    {
      day+=charVal;
      isStart=true;
      if(!isCheckConj && day.length==2)
      {
        index++;
        break;
      }
    }
    else if(isStart)
      break;
  }
  if(month.length==0)
	  month="01";
  if(day.length==0)
	  day="01";
  var condition1 = isNaN(year) || isNaN(month) || isNaN(day);
  var condition2 = parseInt(year,10)!=parseFloat(year) || parseInt(month,10)!=parseFloat(month) || parseInt(day,10)!=parseFloat(day)
  if(condition1 || condition2)
    return false;
  var d = new Date(year,month-1,day);
  var year2 = d.getFullYear();
  var month2 = d.getMonth()+1;
  var day2 = d.getDate();
  if(year==year2 && month==month2 && day==day2)
    return true;
  else
    return false;
};

/**
 * 判断输入值是否为合法的日期类型（格式为yyyy?mm?dd其中年份必须为[1000,9999]，年月日连接符为“-”）.
 * @param obj Object,标签对象.
 * @return boolean,输入值是否为合法的日期类型.
 */
Validate.isStandardDateEx=function(obj)
{
  return Validate.isStandardDate(obj,"-");
};

/**
 * 判断输入值长度是否在一闭区间内.
 * @param obj Object,标签对象.
 * @param nMin int,长度左边界.
 * @param nMax int,长度右边界.
 * @return boolean,输入值长度是否在一闭区间内.
 */
Validate.isLengthBetween=function(obj,nMin,nMax)
{
  if(!(obj.type!=null && obj.type.toLowerCase()=="file"))
    obj.value = StrUtil.rTrim(obj.value);
  if(obj.value.length>=nMin && obj.value.length<=nMax)
    return true;
  else
    return false;
};

/**
 * 判断输入值长度是否小于某一值.
 * @param obj Object,标签对象.
 * @param nMax int,长度右边界.
 * @return boolean,输入值长度是否小于某一值.
 */
Validate.isLengthBelow=function(obj,nMax)
{
  return Validate.isLengthBetween(obj,0,nMax);
};

/**
 * 判断输入值长度是否为某一值.
 * @param obj Object,标签对象.
 * @param n int,字符串必须长度.
 * @return boolean,输入值长度是否为某一值.
 */
Validate.isLengthEqual=function(obj,n)
{
  return Validate.isLengthBetween(obj,n,n);
};

/**
 * 判断输入值是否不含有某些字符.
 * @param obj Object,标签对象.
 * @parma species String,不合法字符集.
 * @param isSpaceFilter boolean,是否先去除字符串两端的空格.
 * @return boolean,输入值是否不含有某些字符.
 */
Validate.NC_BASIC = "<>";
Validate.NC_COMMON = Validate.NC_BASIC+"\"\'";
Validate.isNotContain=function(obj,species,isSpaceFilter)
{
  if(isSpaceFilter)
  {
    if(!(obj.type!=null && obj.type.toLowerCase()=="file"))
      obj.value = StrUtil.rTrim(obj.value);
  }
  for(i=0;i<species.length;i++)
    if(obj.value.indexOf(species.charAt(i))>=0)
      return false;
  return true;
};

/**
 * 判断输入值是否不含有某些字符（以Validate.NC_COMMON为不合法字符集，先去除字符串两端的空格）.
 * @param obj Object,标签对象.
 * @return boolean,输入值是否不含有某些字符.
 */
Validate.isNotcontainEx=function(obj)
{
  return Validate.isNotContain(obj,Validate.NC_COMMON,true);
};

/**
 * 判断输入值是否含有某些字符（不去除字符串两端的空格）.
 * @param obj Object,标签对象.
 * @param species String,必须含有的字符集
 * @return boolean,输入值是否含有某些字符.
 */
Validate.isContain=function(obj,species)
{
  for(i=0;i<species.length;i++)
    if(obj.value.indexOf(species.charAt(i))<0)
      return false;
  return true;
};


/**
 * 检验form表单中的输入项是否已输入完整.
 * @param form Form表单对象.
 * @return boolean 非空项是否均输入内容.
 */
Validate.checkInputFull=function(form)
{
 var isValid=true;
 var errMessage="";
 var first=null;
 var itemArray=form.elements;
 for(var e=0;e<itemArray.length;e++)
 {
   var itemObj=itemArray[e];
   var nullable=itemObj.getAttribute("nullable");
   if(nullable==null || nullable=="" || nullable=="1")
     continue;
   var isBlankItem=false;
   isBlankItem=Validate.isBlank(itemObj,true);
   if(isBlankItem && first==null)
     first=itemObj;
   if(isBlankItem)
   {
     var itemDesc=itemObj.getAttribute("itemdesc");
     if(itemDesc==null || itemDesc=="")
       itemDesc=itemObj.name;
     if(errMessage.indexOf(itemDesc+",")==-1)
       errMessage+=itemDesc+",";
     isValid=false;
   }
 }
 if(isValid==false)
 {
   TabUtil.showParentPage(first);   
   alert("信息不完整，以下项必须全部输入：\r\n"+errMessage.substring(0,errMessage.length-1));
   if(first.nodeName=="input" ||first.style.display=="none")
	   first=first.nextSibling;
   first.focus();
 }
 return isValid;
};

/**
 * 激发检查值。
 * @param event 事件对象。
 */
Validate.fireCheckValue=function(event)
{
  var curObj=EventUtil.eventCurrentTarget(event);
  var isPass=Validate.checkValue(curObj);
  if(!isPass && Constants.isIE)
  {
    var targetObj=PubUtil.getActiveElement();
    //if(event.target)
      //targetObj=event.target;
    //else
      //targetObj=PubUtil.getActiveElement();
    if(targetObj!=null && Validate.checkValue(targetObj))//不验证会死循环。
      curObj.focus();
  }
}

/**
 * 检验表单的某元素值是否正确.
 * @param obj 元素对象.
 * @return boolean 是否正确.
 */
Validate.checkValue=function(obj)
{
  if(Validate.isBlank(obj,true))
    return true;
  var itemDesc=obj.getAttribute("itemdesc");
  if(itemDesc==null || itemDesc=="")
    itemDesc=obj.name;
  var maxLen=obj.getAttribute("maxlen");
  if(maxLen==null && obj.tagName.toLowerCase()=="input")
    maxLen=obj.getAttribute("maxlength");
  if(maxLen!=null && maxLen!="" && StrUtil.byteLen(obj.value)>parseInt(maxLen))
  {
    alert(itemDesc+"值的长度不能超过"+maxLen+"个字符，中文占两字符!");
    return false;
  }
  var minLen=obj.getAttribute("minlen");
  if(minLen!=null && StrUtil.byteLen(obj.value)<parseInt(minLen))
  {
    alert(itemDesc+"值的长度必须不少于"+minLen+"个字符，中文占两字符!");
    return false;
  }	
  var isValid=true;
  var dataType=obj.getAttribute("datatype");
  if(dataType==null)
    return true;
  dataType=dataType.toLowerCase();
  var errMessage="";
  switch(dataType)
  {
    case "int":
      isValid=Validate.isInteger(obj);
      if(!isValid)
        errMessage="的值:"+obj.value+"不是合法的整数类型！";
      break;
    case "num":
      isValid=Validate.isNumber(obj);
      if(!isValid)
        errMessage="的值:"+obj.value+"不是合法的数字类型！";
      break;
    case "str":
      break;
    case "date":
      isValid=Validate.isStandardDate(obj);
      if(!isValid)
        errMessage="的值:"+obj.value+"不是合法的日期类型！";
      break;
  }
  if(dataType=="int" || dataType=="num")
  {
    var minValue=obj.getAttribute("minvalue");
    if(isValid && minValue!=null && !Validate.isAboveEx(obj,parseFloat(minValue)))
      errMessage="的值必须大于等于"+minValue+"！";
    var maxValue=obj.getAttribute("maxvalue");
    if(isValid && maxValue!=null && !Validate.isBelowEx(obj,parseFloat(maxValue)))
    {
      isValid=false;
      errMessage="的值必须小于等于"+maxValue+"！";
    }
    var digits=obj.getAttribute("digits");
    if(digits!=null)
    {
      var pos=obj.value.indexOf(".");
      if(pos>-1)
      {
        if(obj.value.length-pos-1>parseInt(digits))
        {
          isValid=false;
          errMessage="的值小数位不能超过"+digits+"！";
        }
      }
    }
    var precision=obj.getAttribute("precision");
    if(precision!=null)
    {
      var value=obj.value;
      var length=value.indexOf(".");
      if(length==-1)
        length=value.length;
      if(value.substring(0,1)=="-" || value.substring(0,1)=="+")
        length--;
      var size=parseInt(precision);
      if(digits!=null)
        size-=parseInt(digits);
      if(length>size)
      {
        isValid=false;
        errMessage="的值整数位不能超过"+size+"位";
      }
    }
  }
  if(!isValid)
    alert("值错误："+itemDesc+errMessage);
  var checkFunc=obj.getAttribute("checkfunc");
  if(isValid && checkFunc!=null && checkFunc.length>0)
    isValid=eval(checkFunc+"('"+encodeURIComponent(obj.value)+"','"+encodeURIComponent(itemDesc)+"')");
  return isValid;
};

/**
 * 检验form表单中的元素值是否合法.
 * @param form form表单对象.
 * @return 是否合法,是返回true,否则false.
 */
Validate.checkFormItemValue=function(form)
{
  if(!form)
	return true;
  var isValid=true;
  var itemArray=form.elements;
  for(var e=0;e<itemArray.length;e++)
  {
    isValid=Validate.checkValue(itemArray[e]);
    if(!isValid)
      break;
  }
  return isValid;
};

/**
 * 验证给定值是否是标识，即由字典、数字及下划线组成。
 * @param value 给定值。
 * @param 元素描述。
 */
Validate.checkID=function(value,desc)
{
  if(value==null || value.length==0)
  {
    alert(desc+"不能为空!");
    return false;
  }
  for(var i=0;i<value.length;i++)
  {
    var curChar=value.charAt(i);
    if(curChar>='a' && curChar<='z' || curChar>='A' && curChar<='Z' || curChar=='_' || 
       curChar>='0' && curChar<='9')
      continue;
    alert(desc+"只能由字母、数字及下划线组成!");
    return false;
  }
  return true;
};


/**
 * 验证给定值是否是标识，即由字典、数字及下划线及中文(不包括特殊符号，如引号、括号)组成。
 * @param value 给定值。
 * @param 元素描述。
 */
Validate.checkIDExt=function(value,desc)
{
  if(value==null || value.length==0)
  {
    alert(desc+"不能为空!");
    return false;
  }
  var charArr=new Array('，','。','；','　','！','（','）','’','”','＋','－','＊','、');
  for(var i=0;i<value.length;i++)
  {
    var curChar=value.charAt(i);
    if(curChar>='a' && curChar<='z' || curChar>='A' && curChar<='Z' || curChar=='_' || 
       curChar>='0' && curChar<='9')
      continue;
    if(value.charCodeAt(i)>19968)
    {
      var isValid=true;
      for(var j=0;j<charArr.length;j++)
      {
        if(charArr[j]==curChar)
      {
          isValid=false;
        break;
        }
      }
      if(isValid)
      continue;
    }
    alert(desc+"只能由字母、数字及下划线及中文组成!");
    return false;
  }
  return true;
};



/**
 * 验证元素值是否合法的Email。
 * @param value 元素值。
 * @param desc 元素描述。
 */
Validate.checkEmail=function(value,desc)
{
  var flagNum=0;
  for(var i=0;i<value.length;i++)
  {
    if(value.charAt(i)=='@')
      flagNum++;
    }
    if(flagNum!=1)
    {
      alert(desc+"的值错误，在Email中必须包含一个@符号！");
      return false;
    }
    var index=value.indexOf("@");
    if(index==0)
    {
      alert(desc+"的值错误，在Email中@前必须有字符！");
      return false;
    }
    if(value.substring(index+1).indexOf(".")==-1)
    {
      alert(desc+"的值错误，非法的Email！");
      return false;
  }
  return true;
};


