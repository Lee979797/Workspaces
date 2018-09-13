
window.defaultStatus = Constants.constReady;

/**
 * 平台应用基本js函数。
 */
AppUtil=function AppUtil(){};

/**
 * 显示状态信息。
 * @param msg 状态信息。
 */
AppUtil.winStatus=function(msg)
{
  window.status = msg;
};


/**
 * 检验表单元素是否有更改,只检验属性chkmodified=1的元素.
 * @param formObj 表单对象.
 * @param modifiedAttr 是否验证modifiedattr属性。
 * @return 是否有更改，true or false.
 */
AppUtil.isFormModified=function(formObj,modifiedAttr)
{
  for(var e=0;e<formObj.length;e++)
  {
    var elem=formObj.elements[e];
    var chkModified=elem.getAttribute("chkmodified");
    if(chkModified==null || chkModified!="1")//表单中可能有元素不必检验
      continue;
    var modified=elem.getAttribute("modified");
	  if(modifiedAttr && modified!=null && modified=="1")
	    return true;    
    switch(elem.type.toLowerCase())
    {
      case "hidden":
        if(elem.defaultValue!=elem.value)//firefox中defaultValue=value
          isModified=true;
        else
        {
          var origValue=elem.getAttribute("origvalue");
          if(origValue!=null && origValue!=elem.value)
            return true;
        }
        break;
      default:
        if(PubUtil.isElemModified(elem))
          return true;
    }
  }
  return false;
};

/**
 * 将Request的get方法转成post方法.
 * @param formObj 用于post的Form对象.
 * @param requestURL 链接的URL,含请求参数.
 * @param target 打开链接target.
 */
AppUtil.doPostSubmit=function(formObj,requestURL,target)
{
  //requestURL=decodeURI(requestURL);//传过来已解码，不需再解码
  var pos=requestURL.indexOf("?");
  var action="";
  var origInnerHTML=formObj.innerHTML;
  if(pos==-1)
    action=requestURL;
  else
    action=requestURL.slice(0,pos);
  formObj.action=action;
  if(target!=null && target!="")
    formObj.target=target;
  else
	  target='_self';
  var newInnerHTML=origInnerHTML;
  if(pos!=-1)
  {
    var splitor="&";
    for(;;)
    {
      if(requestURL.indexOf(splitor)==-1)
      {
        if(splitor.length>1)
          splitor=splitor.slice(1);
        break;
      }
      splitor+="&";//该URL非标准URL,参数间可能以不同个数的&来间隔，表示不同参数层次(页面)，
    }
    var paramArr=requestURL.slice(pos+1).split(splitor);
    var paramNameArr=new Array();
    var paramValueArr=new Array();
    var counter=0;
    for(var i=0;i<paramArr.length;i++)
    {
      pos=paramArr[i].indexOf("=");
      if(pos==-1)
      {
        paramValueArr[paramValueArr.length-1]=paramValueArr[paramValueArr.length-1]+splitor+paramArr[i];
        continue;
      }
      paramNameArr[counter]=StrUtil.trim(paramArr[i].slice(0,pos));
      var paramValue=StrUtil.trim(paramArr[i].slice(pos+1));
      try
      {
        paramValue=decodeURIComponent(paramValue)
      }
      catch (e){}
      paramValueArr[counter]=paramValue;    
      counter++;
    }
    for(var i=0;i<paramNameArr.length;i++)
    {
      newInnerHTML+="<input type=\"hidden\" name=\""+paramNameArr[i]+"\" value=\""+PubUtil.htmlFilter(paramValueArr[i])+"\">";
    }
  }  
  newInnerHTML+="<input type=\"hidden\" name=\"linkFormTarget\" value=\""+target+"\">";
  formObj.innerHTML=newInnerHTML;
  if(target=="_self")
  {
    var loadingMsg=document.getElementById("loadingMsg");
    if(loadingMsg!=null)
      loadingMsg.style.display="block";
  }
  formObj.submit();
  formObj.innerHTML=origInnerHTML;
};


/**
 * 使表单中给定名称的checkbox全选或全取消.
 * @param formObj 表单对象.
 * @param allCheckObj 操作的checkbox对象.
 * @param checkName 要全选或全不选的checkbox名.
 */
AppUtil.switchCheckAll=function(formObj,allCheckObj,checkName)
{
  var itemArr=formObj.elements;
  for(var i=0;i<itemArr.length;i++)
  {
    if(itemArr[i].name==checkName && itemArr[i].type.toLowerCase()=="checkbox" &&
		!itemArr[i].disabled && !itemArr[i].readonly)
    {
      itemArr[i].checked=allCheckObj.checked;
    }
  }
  var another="";
  if(allCheckObj.id.charAt(allCheckObj.id.length-1)=="2")
	  another=allCheckObj.id.substring(0,allCheckObj.id.length-1);
  else
	  another=allCheckObj.id+"2";
  var anotherObj=PubUtil.findObj(another,document);  
  if(anotherObj!=null && anotherObj.type && anotherObj.type.toLowerCase()=="checkbox")
	  anotherObj.checked=allCheckObj.checked;
};


/**
 * 用弹出式菜单处理MVC动作.
 * @param actionURL 用于处理MVC动作的URL.
 * @param isBigWin 是否显示大窗口.
 */
AppUtil.popAction=function(actionURL,isBigWin)
{
  var location=Constants.contextRoot+"/charisma/syspub/popaction/popAction.jsp?actionURL="+encodeURIComponent(actionURL);
  var winSize="";
  if(isBigWin)
    winSize="width=600, height=400";
  else
    winSize="width=400, height=250";
  var popActionWin=window.open(location, "popActionWin", winSize);
  if(popActionWin==null)
  {
    alert("您的浏览器可能禁止弹出窗口，无法正常运行程序!");
    return;
  }  
  popActionWin.focus();
  popActionWin.moveTo(0,0);
};



/**
 * 打开弹出式窗口.
 * @param location document's location.
 * @param winName window's name.
 * @param width window's width.
 * @param height window's height.
 * @param winOpt options using open window.
 */
AppUtil.popWindow=function(location,winName,width,height,winOpt)
{
  if(width==null || width=='')
    width=400;
  if(height==null || height=='')
    height=200;
  if(winOpt==null)
    winOpt="";
  winOpt="width="+width+",height="+height+(winOpt==""?"":",")+winOpt+", status=1";
  var popWindow=window.open(location,winName,winOpt);
  if(popWindow==null)
  {
    alert("您的浏览器可能禁止弹出窗口，无法正常运行程序!");
    return;
  }  
  popWindow.focus();  
  popWindow.moveTo(0,0);
  
};

/**
 * 打开弹出式窗口,带FOOTER.
 * @param location document's location.
 * @param winName window's name.
 * @param width window's width.
 * @param height window's height.
 * @param winOpt options using open window.
 */
AppUtil.popWinWithFoot=function(popURL,winName,width,height,winOpt)
{
  if(width==null || width=="")
    width="400";
  if(height==null || height=="")
    height="500";
  if(winOpt==null)
    winOpt="";
  winOpt="width="+width+",height="+height+(winOpt==""?"":",")+winOpt+" status=1";
  var location=Constants.contextRoot+"/charisma/syspub/popwin/popWindow.jsp?popURL="+encodeURIComponent(popURL);
  var popWindow=window.open(location,winName,winOpt);
  if(popWindow==null)
  {
    alert("您的浏览器可能禁止弹出窗口，无法正常运行程序!");
    return;
  }  
  popWindow.focus();  
  popWindow.moveTo(0,0);
};


/**
 * 弹出窗口设置字典量,采用系统内定的URL处理.
 * @param subSys 子系统标识.
 * @param dicKind 字典类型.
 * @param dicSubKind 字典子类型.
 * @param dicGrpID 字典组标识.
 * @param valDicCol 值对应字典量列.
 * @param imgObj 图片对象，id为:pop_对应输入元素的ID.
 */
AppUtil.popSetDic=function(subSys,dicKind,dicSubKind,dicGrpID,valDicCol,imgObj)
{
  var elemName=imgObj.getAttribute("elemname");
  var elemObj=imgObj.previousSibling;
  while(elemObj && elemObj.name!=elemName)
  {
    elemObj=elemObj.previousSibling;
	if(elemObj==null)
	  elemObj=elemObj.parentNode;
  }
  if(elemObj==null)
	return;
  var elemArr=document.getElementsByName(elemName);
  var index=0;
  for(var i=0;i<elemArr.length;i++)
  {
    if(elemArr[i]==elemObj)
    {
      index=i;
      break;
    }
  }
  var location=Constants.contextRoot+"/charisma/syspub/popdic/popDic.jsp?subSys="+subSys+"&dicKind=";
  location+=dicKind+"&dicSubKind="+dicSubKind+"&dicGrpID="+dicGrpID;
  location+="&valDicCol="+valDicCol+"&elemName="+elemName+"&index="+index; 
  /*var popDicWin=window.open(location,"","width=500,height=450,status=1");
  if(popDicWin==null)
  {
    alert("您的浏览器可能禁止弹出窗口，无法正常运行程序!");
    return;
  }  
  popDicWin.focus(); */
  DivWin.showDivWindow(elemObj,"popDic",location, 500, 450, -1, -1, "选择数据项",0,"") 

};

/**
 * 弹出窗口设置字典量，采用用户指定的URL处理。
 * @param popDicURL 弹出字典URL。
 * @param imgObj 图片对象，id为:pop_对应输入元素的ID.
 */
AppUtil.popSetDic3=function(popDicURL,imgObj)
{
  var elemName=imgObj.getAttribute("elemname");
  var elemObj=imgObj.previousSibling;
  while(elemObj && elemObj.name!=elemName)
  {
    elemObj=elemObj.previousSibling;
  }
  var elemArr=document.getElementsByName(elemObj.name);
  var index=0;
  for(var i=0;i<elemArr.length;i++)
  {
    if(elemArr[i]==elemObj)
    {
      index=i;
      break;
    }
  }
  var location="";
  var paramArr=popDicURL.split("&&");
  if(paramArr.length==1)
  {
    if(paramArr[0].indexOf("appendElems")!=-1)
    {
      alert("设置批量带回的字典URL时，dicURL与appendElems等元素间以&&间隔!");
    }
    var url="";
    if(paramArr[0].substring(0,6)=="dicURL")
      url=paramArr[0].substring(6);
    else 
      url=paramArr[0];
    location+="dicURL="+encodeURIComponent(AppUtil.handleDicURL(url,index));
  }
  else
  {
    for(var i=0;i<paramArr.length;i++)
    {
      var pos=paramArr[i].indexOf("=");
      if(pos==-1)     
        continue;
      var paramName=StrUtil.trim(paramArr[i].substring(0,pos));
      var paramValue=StrUtil.trim(paramArr[i].substring(pos+1));
      if(paramName=="dicURL")
        paramValue=AppUtil.handleDicURL(paramValue,index);
      location+=(location==""?"":"&")+paramName+"="+encodeURIComponent(paramValue);
    }
  }
  var location=Constants.contextRoot+"/charisma/syspub/popdic/popDic2.jsp?"+location+"&elemName="+elemName+"&index="+index; 
  var popDicWin=window.open(location,"","width=500,height=450,status=1");
  if(popDicWin==null)
  {
    alert("您的浏览器可能禁止弹出窗口，无法正常运行程序!");
    return;
  }  
  popDicWin.focus();
};


/**
 * 弹出窗口设置字典量，采用用户指定的URL处理。
 * @param popDicURL 弹出字典URL。
 * @param imgObj 图片对象，id为:pop_对应输入元素的ID.
 */
AppUtil.popSetDic2=function(popDicURL,imgObj)
{
  var elemName=imgObj.getAttribute("elemname");
  var elemObj=imgObj.previousSibling;
  while(elemObj && elemObj.name!=elemName)
  {
    elemObj=elemObj.previousSibling;
  }
  var elemArr=document.getElementsByName(elemObj.name);
  var index=0;
  for(var i=0;i<elemArr.length;i++)
  {
    if(elemArr[i]==elemObj)
    {
      index=i;
      break;
    }
  }
  var location="";
  var paramArr=popDicURL.split("&&");
  if(paramArr.length==1)
  {
    if(paramArr[0].indexOf("appendElems")!=-1)
    {
      alert("设置批量带回的字典URL时，dicURL与appendElems等元素间以&&间隔!");
    }
    var url="";
    if(paramArr[0].substring(0,6)=="dicURL")
      url=paramArr[0].substring(6);
    else 
      url=paramArr[0];
    location+="dicURL="+encodeURIComponent(AppUtil.handleDicURL(url,index));
  }
  else
  {
    for(var i=0;i<paramArr.length;i++)
    {
      var pos=paramArr[i].indexOf("=");
      if(pos==-1)     
        continue;
      var paramName=StrUtil.trim(paramArr[i].substring(0,pos));
      var paramValue=StrUtil.trim(paramArr[i].substring(pos+1));
      if(paramName=="dicURL")
        paramValue=AppUtil.handleDicURL(paramValue,index);
      location+=(location==""?"":"&")+paramName+"="+encodeURIComponent(paramValue);
    }
  }
  var location=Constants.contextRoot+"/charisma/syspub/popdic/popDic2.jsp?"+location+"&elemName="+elemName+"&index="+index; 
  //var popDicWin=window.open(location,"","width=500,height=450,status=1");
  DivWin.showDivWindow(elemObj,"popDic",location, 500, 450, -1, -1, "选择数据项",0,"") 
};

/**
 * 处理弹出字典URL，将其中的[!=elem or jsFunc!]置换掉。
 * @param dicURL 待处理的字典URL。
 * @param index 字典元素对应的input标签在当前表单中的索引。
 * @return 处理后的字典URL。
 */
AppUtil.handleDicURL=function(dicURL,index)
{
  if(dicURL==null || StrUtil.trim(dicURL).length==0)
	  return dicURL;
  var newDicURL="";
  var lastPos=0;
  var curPos=dicURL.indexOf("[!=");
  if(curPos==-1)
    return dicURL;
  var endPos=0;
  while(curPos>=0)
  {
    newDicURL+=dicURL.substring(lastPos,curPos);
    endPos=dicURL.indexOf("!]",curPos);
    if(endPos==-1)
    {
      newDicURL+=dicURL.substring(curPos);
      break;
    }
    var tempPos=dicURL.indexOf("[!=",curPos+1);
    if(tempPos>=0 && tempPos<endPos)//前一个[!=没有配对，可能是字符内的内容。
    {
      newDicURL+=dicURL.substring(curPos,tempPos);
      curPos=tempPos;
    }
    var elemJsFunc=StrUtil.trim(dicURL.substring(curPos+3,endPos));
    var value=AppUtil.getDicCndElemValue(index,elemJsFunc);
    var isFunc=elemJsFunc.indexOf("(")!=-1;
    //函数结果不过滤，因为有时需返回repID=1&...,如需过滤，在函数内过滤。
    newDicURL+=(isFunc?value:encodeURIComponent(value));
    lastPos=endPos+2;
    curPos=dicURL.indexOf("[!=",endPos+2);
    if(curPos==-1)
      newDicURL+=dicURL.substring(lastPos);
  }  
  return AppUtil.postHandleDicURL(newDicURL);
};

/**
 * 取字典条件元素的值。
 * @param index 字典元素对应的input标签在当前表单中的索引。
 * @param elemJsFunc 字典条件值对应的表单元素名称或是js函数(必须速括号)。
 * @return 指定字典条件元素的值。
 */
AppUtil.getDicCndElemValue=function(index,elemJsFunc)
{
  var pos=elemJsFunc.indexOf("(");
  if(pos!=-1)//是函数名
  {
    elemJsFunc=elemJsFunc.substring(0,pos)+"("+index+")";
    return ""+eval(elemJsFunc);
  }
  var objs=document.getElementsByName(elemJsFunc);
  if(objs.length>index)
	  return objs[index].value;
  else if(objs.length!=0)
	  return objs[0].value;//可能是公共元素		  
  else
    return "";
};

/**
 * 对字典URL进行处理，主要是去除没有条件值的报表条件。
 * @param dicURL 字典URL。
 * @return 处理后的报表URL。
 */
AppUtil.postHandleDicURL=function(dicURL)
{
  var index=dicURL.indexOf("?");
  if(index==-1)
	  return dicURL;
  var paramArr=dicURL.substr(index+1).split("&");
  dicURL=dicURL.substring(0,index);
  var delCndIDArr=new Array();
  var delNo=0;
  var paramExp="";
  for(var i=0;i<paramArr.length;i++)
  {
    paramArr[i]=StrUtil.trim(paramArr[i]);
    if(paramArr[i].substr(paramArr[i].length-1)=="=")
    {
      var paramName=StrUtil.trim(paramArr[i].substring(0,paramArr[i].length-1));
      if(paramName.substring(0,4)=="cnd_")
      {
        delCndIDArr[delNo++]=paramName.substr(4);
      }
    }
  }
  for(var i=0;i<paramArr.length;i++)
  {
    paramArr[i]=StrUtil.trim(paramArr[i]);
    index=paramArr[i].indexOf("=");
    if(index==-1)
      continue;
    if(paramArr[i].substring(0,8)=="selCndID")//include selCndIDs
    {
      var cndIDsExp=StrUtil.trim(paramArr[i].substr(index+1));
      var cndIDArr=cndIDsExp.split(",");
      cndIDsExp="";
      for(var j=0;j<cndIDArr.length;j++)
      {
        var isDel=false;
        for(var k=0;k<delCndIDArr.length;k++)
        {
           if(cndIDArr[j]==delCndIDArr[k])
           {
             isDel=true;
             break;
           }
        }
        if(!isDel)
          cndIDsExp=(cndIDsExp==""?"":",")+cndIDArr[j];
      }		
      if(cndIDsExp!="")
        paramExp+=("&"+paramArr[i].substring(0,index)+"="+cndIDsExp);
    }
    else if(delCndIDArr.length>0 && paramArr[i].substring(0,7)=="isQuery")
      continue;
    else if(!(paramArr[i].substring(0,4)=="cnd_" && StrUtil.trim(paramArr[i].substr(index+1))==""))
      paramExp+=("&"+paramArr[i]);
  }
  if(paramExp.length>0)
	  paramExp=paramExp.substr(1);
  return dicURL+(paramExp.length>0?"?":"")+paramExp;
};

/**
 * line img's onerror's script.
 * @param imgObj line img object.
 * @param line img's type.
 */
AppUtil.onErrorLineImg=function(imgObj,lineType)
{
  if(imgObj.src.indexOf("drawLine")!=-1)
  {
    return;	
  }
  var tdObj=imgObj.parentElement;
  var width=tdObj.clientWidth;	//maybe 0,so no show
  var height=tdObj.clientHeight;//maybe 0,so no show
  imgObj.src=Constants.contextRoot+"/drawLine.gif?lineType="+lineType+"&width="+width+"&height="+height;  
};

/**
 * 上传文件到数据库中。
 * @param subSys 子系统标识。
 * @param uploadID 上传标识。
 * @param keyPairs 关键字集，列名1:列值;列名2:列值。
 * @param fileNameCol 存储上传文件名对应的列名。
 */
AppUtil.upload2DB=function(subSys,uploadID,keyPairs,fileNameCol)
{
  var location=Constants.contextRoot+"/charisma/syspub/upload2DB.jsp?subSys="+subSys+"&uploadID="+uploadID+
	  "&keyPairs="+encodeURIComponent(keyPairs);  
  if(fileNameCol!=null)
	  location+="&fileNameCol="+fileNameCol;
  AppUtil.popWinWithFoot(location,"uploadWin",400,300,"status=1");
};


/**
 * 两个对象切换显示。
 * @param selectObj selct对象。
 * @param inputObj inputObj对象.
 */
AppUtil.toggleSelInput=function(selectObj,inputObj)
{
  var style=selectObj.style.display.toLowerCase();
  if(style=="" || style=="block")
  {
    selectObj.style.display="none";
    inputObj.style.width=selectObj.style.width
    inputObj.style.display="block";	
    inputObj.focus();
    if(document.selection)//firefox中不起作用
    {
      var oTR = document.selection.createRange();
        oTR.text=String.fromCharCode(event.keyCode);
      oTR.select();
    }
  }
  else
  {
    selectObj.style.display="block";
    inputObj.style.display="none";
    selectObj.focus();
  }
};

/**
 * 初始化Calendar对象。
 * @param button 触发打开DatePicker的按钮，或图标。
 * @param format 日期格式串，如%Y-%m-%d %H:%M。
 * @param showsTime 是否在datePicker中显示时间。
 */
AppUtil.datePicker=function(button,format,showsTime)
{
   var input=button.previousSibling;
   if(!format || format=="")
	   format="%Y-%m-%d";
   Calendar.setup({
      inputField     :    input,      
      ifFormat       :    format,      
      showsTime      :    showsTime,    
      button         :    button, 
	    onUpdate       :    AppUtil.datePickerOnUpdate,
	    align          :    "Bl",
	    step           :    1,
      singleClick    :    true    
   });
};
 
 /**
  * datePicker更新Inpute值后触发。
  * @param cal datePicker中Calendar对象。
  */
 AppUtil.datePickerOnUpdate=function(cal)
 {
   EventUtil.fireEvent(cal.params.inputField,"onchange");
   cal.params.inputField.focus();
 };

 /**
  * 按回车键处动的动作。
  */
 AppUtil.enterKeyDown=function(event)
 {
   event || (event=window.event);
   //ev.keyCode==13)ev.keyCode=9
   if(event.keyCode!=13)
	  return;
   var elem=EventUtil.eventTarget(event);
   if(!elem)
	   return;
   var tagName=elem.tagName.toLowerCase();
   if(tagName=="input")
   {
     switch(elem.type.toLowerCase())
     {
        case "button":
          //if(elem.getAttribute("enterfireclick")!=null && elem.onclick!="")
           // EventUtil.fireEvent(elem,"onclick");
          break;
        case "image":
        case "reset":
        case "submit":
          break;
        case "text":
        case "password":
        case "checkbox":
        case "radio":
          AppUtil.focusNextInput(event);
          break;
        default:
          break;
      }
   }
   else if(tagName=="select")
   {
	   AppUtil.focusNextInput(event);//elem'type="select-one","select-multiple":
   }
   else if(tagName=="a" || tagName=="img")
   {
     if(elem.getAttribute("enterfireclick")!=null && elem.onclick!="")//在报表中会存在很多链接，所以通过enterfireclick设定
       EventUtil.fireEvent(elem,"onclick");
     else
       AppUtil.focusNextInput(event);
   }
 };

 /**
  * 将焦点移到下一输入框。
  * @param event 事件体。
  */
 AppUtil.focusNextInput=function(event)
 {
   if(Constants.isIE)
   {
     event.keyCode=9;
     return;
   }
   var elem=EventUtil.eventTarget(event);   
   if(!elem.form)
     return;   
   var elemArr=elem.form.elements;
   for(var i=0;i<elemArr.length;i++)
   {     
     if(elemArr[i]==elem && i<elemArr.length-1)
     {
       for(var j=i+1;j<elemArr.length;j++)
       {
         var tagName=elemArr[j].tagName.toLowerCase();
         if(tagName=="input" && (elemArr[j].type=="text" || elemArr[j].type=="password") ||
            tagName=="select" || tagName=="textarea")
         {
           if(event.cancelable)
             event.preventDefault();//不起作用，以后要研究
           elemArr[j].focus();
           return;
         }
       }
     }
   }
 };



/**
 * 缓存动态标签。
 * @param containerID 标签容器ID。
 */
AppUtil.cacheDynaTags=function(containerID)
{
  var cacheTag=document.getElementById("cacheDynaTags");
  if(cacheTag==null)
    return;
  var container=document.getElementById(containerID);    
  if(container==null)
    return;
  //放在document的onunload,在ie中即使赋值成功，也没有缓存,在firefox中生效
  AppUtil.preCacheDynaTags(container);//在firefox中编辑框的值能过innerHTML取不到，所以这里预处理。同时ie中也要处理defaultValue.
  cacheTag.value=container.innerHTML; 
};


/**
 * 复原动态标签。
 * @param containerID 标签容器ID。
 */
AppUtil.restoreDynaTags=function(containerID)
{
  var cacheTag=document.getElementById("cacheDynaTags");
  if(cacheTag==null || cacheTag.value=="")
    return;
  var container=document.getElementById(containerID);    
  if(container==null)
    return;
  container.innerHTML=cacheTag.value;
  cacheTag.value="";
  AppUtil.postRestoreDynaTags(container);
};


/**
 * 缓存动态标签前处理。
 * @param container 标签容器.
 */
AppUtil.preCacheDynaTags=function(container)
{
  var elems=PubUtil.getEditChildElems(container);
  for(var e=0;e<elems.length;e++)
  {
    var elem=elems[e];
    var elemType=elem.type.toLowerCase();
    switch(elemType)
    {
      case "text":
      case "textarea":
      case "password":
      case "hidden":
      case "file":   
        elem.setAttribute("origvalue",elem.defaultValue);
        elem.setAttribute("curvalue",elem.value);
	      break;   
      case "select-one":
      case "select-multiple":
        elem.setAttribute("origvalue",elem.defaultValue);//must
        elem.setAttribute("curvalue",elem.value);//must
        var optionArr=elem.options;
        for(var e2=0;e2<optionArr.length;e2++)
        {
          optionArr[e2].setAttribute("origselected",optionArr[e2].defaultSelected);
          optionArr[e2].setAttribute("curselected",optionArr[e2].selected);
        }
        break;      
      case "checkbox":
      case "radio":
        elem.setAttribute("origchecked",elem.defaultChecked);
        elem.setAttribute("curchecked",elem.checked);
	      break;
    }
  }
};


/**
 * 复原动态标签后处理。
 * @param container 标签容器.
 */
AppUtil.postRestoreDynaTags=function(container)
{
  var elems=PubUtil.getEditChildElems(container);
  for(var e=0;e<elems.length;e++)
  {
    var elem=elems[e];
    var elemType=elem.type.toLowerCase();
    switch(elemType)
    {
      case "text":
      case "textarea":
      case "password":
      case "hidden":
      case "file":   
      case "select-one":
      case "select-multiple":
        var origValue=elem.getAttribute("origvalue");
        if(origValue!=null)
          elem.defaultValue=origValue;
        var curValue=elem.getAttribute("curvalue");
        if(curValue!=null)
          elem.value=curValue;
        if(elemType!="select-one" && elemType!="select-multiple")
	        break;
        var optionArr=elem.options;
        for(var e2=0;e2<optionArr.length;e2++)
        {
          var origSelected=optionArr[e2].getAttribute("origselected");
          if(origSelected!=null)
          {
            if(origSelected=="true")
              optionArr[e2].defaultSelected=true;
            else
              optionArr[e2].defaultSelected=false;
          }
          var curSelected=optionArr[e2].getAttribute("curselected");
          if(curSelected!=null)
          {
            if(optionArr[e2].getAttribute("curselected")=="true")
              optionArr[e2].selected=true;
            else
              optionArr[e2].selected=false;
          }
        }
	      break;
      case "checkbox":
      case "radio":
        var origChecked=elem.getAttribute("origchecked");
        if(origChecked!=null)
          elem.defaultChecked=origChecked;
        var curChecked=elem.setAttribute("curchecked");
        if(curChecked!=null)
          elem.checked=origChecked;
	      break;
    }
  }
};

/**
 * 取当前服务器时间。
 * @return 当前服务器时间，Date对象。
 */
AppUtil.getCurSvrTime=function()
{
  var xmlHttp = PubUtil.createXMLHttp();
  xmlHttp.open("GET","sysmng.curSvrTime.do?a="+Math.random(),false);//a=Math.random()，主要为了防止缓存 
  xmlHttp.send(null);
  var rst=xmlHttp.responseText;
  if(rst.substring(0,9)=="<curtime>")
  {
    return new Date(parseInt(rst.substring(9,rst.length-10)));
  }
  return new Date();//error 返回客户端时间
}

/**
 * 从错误网页内容中取错误信息。
 * @param errPage 错误网页内容。
 * @return 错误信息。
 */
AppUtil.getErrInfo=function(errPage)
{
  var errFlag="<span id=\"errInfo\" class=\"normalFont\">";
  var pos=errPage.indexOf(errFlag);
  if(pos==-1)
    return "";
  var pos2=errPage.indexOf("</span>",pos);
  return errPage.substring(pos+errFlag.length,pos2);
};

/**
 * 取序列值。
 * @param subSys 子系统。
 * @param seqID 序列标识。
 * @param subSeqID 子序列标识。
 * @return 序列值。
 */
AppUtil.getSeqValue=function(subSys,seqID,subSeqID)
{
  var queryParams = "subSys="+subSys+"&seqID="+seqID;
  if(subSeqID!=null)
    queryParams+="&subSeqID="+subSeqID;
  var xmlHttp=PubUtil.createXMLHttp(); 
  xmlHttp.open("POST","sysmng.seqValue.do",false);
  xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
  xmlHttp.send(queryParams);  
  var resultInfo=xmlHttp.responseText;
  var startIndex=resultInfo.indexOf("<seqValue>");
  if(startIndex==-1)
  {
    startIndex=resultInfo.indexOf("<error>");
    if(startIndex==-1)
    {
      alert("取序列时返回的格式串不正确！");
      return;
    }
    var endIndex=resultInfo.indexOf("</error>");
    var error = resultInfo.substring(startIndex+10,endIndex); 
    alert(error);
    return "";
  }
  var endIndex=resultInfo.indexOf("</seqValue>");
  return resultInfo.substring(startIndex+10,endIndex); 
};


/**
 * 取本地GUID。
 */
AppUtil.getLocalGUID=function() 
{
   var guid= "";
   try
    {
        var x = new ActiveXObject("Scriptlet.TypeLib");
        guid=(x.GUID).substring(0,38);
    }
    catch (e)
    {
	   for(var i=1; i<=32; i++)
	   {
		  var n=Math.floor(Math.random()*16.0).toString(16);
		  guid+=n;
		  //if((i==8)||(i==12)||(i == 16)||(i==20))
			//guid   +=   "-";
	   }
    }   
    return guid;
};


/**
 * 取服服务器端GUID。
 * @param subSys 子系统。
 * @param seqID 序列标识。
 * @param subSeqID 子序列标识。
 * @return 序列值。
 */
AppUtil.getSvrGUID=function()
{
  var queryParams = "";
  var xmlHttp=PubUtil.createXMLHttp(); 
  xmlHttp.open("POST","sysmng.guID.do",false);
  xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
  xmlHttp.send(queryParams);  
  var resultInfo=xmlHttp.responseText;
  var startIndex=resultInfo.indexOf("<guid>");
  if(startIndex==-1)
  {
    startIndex=resultInfo.indexOf("<error>");
    if(startIndex==-1)
    {
      alert("取GUID返回的格式串不正确！");
      return;
    }
    var endIndex=resultInfo.indexOf("</error>");
    var error = resultInfo.substring(startIndex+7,endIndex); 
    alert(error);
    return "";
  }
  var endIndex=resultInfo.indexOf("</guid>");
  return resultInfo.substring(startIndex+6,endIndex); 
};


/**
 * 取数据表列的编辑标签。
 * @param subSys 子系统。
 * @param tableName 序列标识。
 * @param colName 列名。
 * @param tagName 标签名。
 * @param initValue 初始值。
 * @param isNullEnable 是否允许为空。
 * @param isBatch 是否批量录入。
 * @return 列的编辑标签。
 */
AppUtil.getColEditTag=function(subSys,tableName,colName,tagName,initValue,isNullEnable,isBatch)
{
  var queryParams = "subSys="+subSys+"&tableName="+tableName+"&colName="+colName+
	  "&tagName="+tagName;
  if(initValue!=null)
    queryParams+="&initValue="+encodeURIComponent(initValue);
  if(isNullEnable!=null)
	queryParams+="&isNullEnable="+(isNullEnable?"1":"0");
  if(isBatch!=null && isBatch)
	queryParams+"&isBatch=1";  
  var xmlHttp=PubUtil.createXMLHttp(); 
  xmlHttp.open("POST","sysmng.colEditTag.do",false);
  xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
  xmlHttp.send(queryParams);  
  var resultInfo=xmlHttp.responseText;
  var startIndex=resultInfo.indexOf("<colTag>");
  if(startIndex==-1)
  {
    startIndex=resultInfo.indexOf("<error>");
    if(startIndex==-1)
    {
      alert("取列的编辑标签格式串不正确！");
      return;
    }
    var endIndex=resultInfo.indexOf("</error>");
    var error = resultInfo.substring(startIndex+7,endIndex); 
    alert(error);
    return "";
  }
  var endIndex=resultInfo.indexOf("</colTag>");
  return resultInfo.substring(startIndex+8,endIndex); 
};


/**
 * 打印报表。
 * @param subSys 子系统标识。
 * @param repID 报表ID。
 * @param params 参数。
 * @param isPreview 是否打印预览。
 */
AppUtil.printRep=function(subSys,repID,params,isPreview)
{
  var iFrameObj=document.getElementById("printRepIFrame");
  if(iFrameObj==null)
  {
	var iFrameObj= document.createElement("iframe");
    iFrameObj.setAttribute("name","printRepIFrame");
    iFrameObj.setAttribute("id","printRepIFrame");
    iFrameObj.setAttribute("width","0");
    iFrameObj.setAttribute("height","0");
    iFrameObj.setAttribute("style","border-style:none");
    document.body.appendChild(iFrameObj);
  }
  var printType=!isPreview?1:2;
  iFrameObj.src=Constants.contextRoot+"/sysmng.report.do?subSys="+subSys+"&repID="+repID+
	  "&isShowCnd=0&userPerRows=-1&printType="+printType+"&"+params;
};

/**
 * 设置表达式联动元素集，当一个编辑框值变动时，要重计算关联的元素值。
 * @param formObj 表单元素。
 */
AppUtil.initExpLinkElems=function(formObj)
{
   var elemArr=formObj.elements;
   for(var i=0;i<elemArr.length;i++)
   {
	 var exp=elemArr[i].getAttribute("exp");
	 if(exp==null || exp=="")
	   continue;
	 var prefix=elemArr[i].getAttribute("expprefix");
	 if(prefix==null)
	   prefix="";
	 var index=0;
	 var arr=document.getElementsByName(elemArr[i].name);	 
	 for(var j=0;j<arr.length;j++)
	 {
	   if(arr[j]==elemArr[i])
	   {
		 index=j;
		 break;
	   }
	 }
	 var pos=exp.indexOf("{");
	 while(pos!=-1)
	 {
	   var pos2=exp.indexOf("}",pos);
	   if(pos2==-1)
		 break;
	   var elemName=prefix+exp.substring(pos+1,pos2);
	   var arr2=document.getElementsByName(elemName);
	   if(arr2.length>0)
	   {
		 var elem=arr2.length>index?arr2[index]:arr2[0];
		 var linkElems=elem.getAttribute("linkelems");
		 if(linkElems==null || linkElems=="")
		   linkElems=elemArr[i].name;
		 else
		   linkElems+=","+elemArr[i].name;
		 elem.setAttribute("linkelems",linkElems);
	   }
	   else
	   {
		 alert("当前表单中不存在元素"+elemName);
	   }
	   pos=exp.indexOf("{",pos+1);
	 }
   }
   for(var i=0;i<elemArr.length;i++)
   {
	 var linkElems=elemArr[i].getAttribute("linkelems");
	 if(linkElems!=null && linkElems!="")
	 {
	    EventUtil.addEvent(elemArr[i],"change",AppUtil.setLinkElemVals);
	 }
   }
}

/**
 * 设置关联元素值。
 */
AppUtil.setLinkElemVals=function(event)
{
  /*
  <body onload="javascript:AppUtil.initExpLinkElems();">
  ...
  <input type="text" name="col_YYE" linkelems="col_YYSR,col_ZLR" onchange="javascript:AppUtil.setLinkElemVals();" />
  <input type="text" name="col_YYLR" expprefix="col_" exp="{YYE}-{YYZC}" />
  */
  var curObj=EventUtil.eventCurrentTarget(event);
  var linkElems=curObj.getAttribute("linkelems");
  if(linkElems==null || linkElems=="")
	return;
  var index=0;
  var arr=document.getElementsByName(curObj.name);
  for(var i=0;i<arr.length;i++)
  {
	if(arr[i]==curObj)
	{
	  index=i;
	  break;
	}
  }
  var isOne=arr.length==0;
  var linkElemNameArr=linkElems.split(",");
  for(var i=0;i<linkElemNameArr.length;i++) 
  {
	var elemArr=document.getElementsByName(linkElemNameArr[i]);
	for(var j=0;j<elemArr.length;j++)
	{
	  if(!isOne && j!=index)//如果值变化的同名元素，只有一个，则设置所有关联元素。
		continue;
	  var prefix=elemArr[j].getAttribute("expprefix");
	  if(prefix==null)
	    prefix="";
	  var exp=elemArr[j].getAttribute("exp");
	  var result="";
      var pos=exp.indexOf("{");
	  var pos2=-1;
	  while(pos!=-1)
	  {
		result+=exp.substring(pos2+1,pos);
	    var pos2=exp.indexOf("}",pos);
	    if(pos2==-1)
		{
		  alert(exp+"中缺}！")
		  return;
		}
	    var elemName=prefix+exp.substring(pos+1,pos2);		
	    var arr2=document.getElementsByName(elemName);
	    if(arr2.length>0)
	    {
		  var elem=arr2.length>j?arr2[j]:arr2[0];
		  result+=(elem.value==""?"0":"("+elem.value+")");
	    }
	    pos=exp.indexOf("{",pos+1);
	  }
	  result+=exp.substring(pos2+1);
	  var val=eval(result);
	  var digits=elemArr[j].getAttribute("digits");
      if(digits!=null)
	  {
		exponent=Math.pow(10,parseInt(digits));
        val=Math.round(parseFloat(val)*exponent)/exponent;
	  }
	  elemArr[j].value=val;
	  EventUtil.fireEvent(elemArr[j],"onchange");  
	}
  }
}