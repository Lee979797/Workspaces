DivSelect = function DivSelect(){};
DivSelect.eventElem=null;
DivSelect.layerObj=null;
DivSelect.innerTHML=null;
DivSelect.layerX=0;
DivSelect.layerY=0;
DivSelect.oldobjval="";
DivSelect.divTable=null;
DivSelect.divRowObjs=null;
DivSelect.isTargetDiv=false;
DivSelect.agt=navigator.userAgent.toLowerCase();
DivSelect.ns  = ((DivSelect.agt.indexOf('mozilla')!=-1) && (DivSelect.agt.indexOf('spoofer')==-1)
            && (DivSelect.agt.indexOf('compatible') == -1) && (DivSelect.agt.indexOf('opera')==-1)
            && (DivSelect.agt.indexOf('webtv')==-1) && (DivSelect.agt.indexOf('hotjava')==-1));
DivSelect.browerName="";
DivSelect.cndClause="";
DivSelect.checkTrue="true";

//div下拉字典显示接口，layerID为divid,obj来源标签，fPopupN 选择事件
DivSelect.openSelect=function(theObj,colseFlag){
	if(theObj!=DivSelect.eventElem)return;
	var layer=DivSelect.layerObj;
	if(layer.style.display=="none")
	{
		//设置div显示位置，定位到源标签下方
		var layerX = PubUtil.getXPos(theObj)+1;
		var layerY = PubUtil.getYPos(theObj)+	theObj.offsetHeight+1;
		 if(layer.offsetWidth + layerX>document.body.clientWidth)
			 layerX = document.body.clientWidth-layer.offsetWidth;
		 if(layer.offsetHeight + layerY>document.body.clientHeight+document.body.scrollTop)
			 layerY = document.body.clientHeight+document.body.scrollTop-layer.offsetHeight;
		 if(layerY<document.body.scrollTop) layerY =document.body.scrollTop;
		 if(layer.offsetWidth<theObj.offsetWidth) layer.style.width=theObj.offsetWidth;
		 //显示下拉框
		 layer.style.left = layerX+ "px";
		 layer.style.top =  layerY + "px"; 
		 layer.style.display="block";
		 DivSelect.layerX=layerX;
		 DivSelect.layerY=layerY;
		 PubUtil.hiddenTags(layer,layerX,layerY);
	}
	else
	{
		if(colseFlag)
			DivSelect.buttonCloseSelect(true);
	}
}
//div得到焦点时触发事件
DivSelect.elemFocus=function(theObj,layerID,type){
	if(!DivSelect.checkTrue)return;
	if(theObj!=DivSelect.eventElem)
	{
		DivSelect.buttonCloseSelect(true);
	}
	DivSelect.layerObj=document.getElementById(layerID);
	DivSelect.eventElem=theObj;
	if(type==2)
	{
		if (!DivSelect.linkageSelect(DivSelect.layerObj,theObj,layerID)) return;
	}
	DivSelect.divTable=DivSelect.getMainTable(DivSelect.layerObj);
	if (DivSelect.divTable)
		DivSelect.divRowObjs=DivSelect.divTable.tBodies[0].rows;
}
DivSelect.linkageSelect=function(layer,theObj,layerID)
{
	var tableDiv=document.getElementById(layerID+"_table");
	var dicParams=document.getElementsByName(layerID+"_dicParams")[0];
	return  DivSelect.linkageSelectAjax(theObj,layer,tableDiv,dicParams);
	
}
DivSelect.linkageSelectAjax=function(theObj,layerObj,tableDiv,dicParams)
{
	var index=0;
	var arr=document.getElementsByName(theObj.name);
	for(var i=0;i<arr.length;i++)
	{
		if(arr[i]==theObj)
		{
			index=i;
			break;
		}
	}
	var subSys=dicParams.getAttribute("subSys");
	var cndClause=dicParams.value;
	var dicSubKind=dicParams.getAttribute("dicSubKind");
	var dicGrpID=dicParams.getAttribute("dicGrpID");
	var refDicBindValues=dicParams.getAttribute("refDicBindValues");
	var dicValue=dicParams.getAttribute("dicValue");
	var valDicCol=dicParams.getAttribute("valDicCol");
	while (cndClause.indexOf("{")>-1)
	{
		var ttTag="";
		var str1="";
		var str2="";
		str1=cndClause.substring(0,cndClause.indexOf("{"));
		ttTag=cndClause.substring(cndClause.indexOf("{")+1,cndClause.indexOf("}"));
		if(cndClause.length>cndClause.indexOf("}")+1)
			str2=cndClause.substring(cndClause.indexOf("}")+1,cndClause.length);
		var tt=document.getElementsByName(ttTag);
		if (tt!=null&&tt[index]!=null)
		{
			ttTag=tt[index].value;
			cndClause=str1+ttTag+str2;
		}
		else
		{
			alert("页面不存在NAME为["+ttTag+"]的标签");
			return false;
		}
	}
	while(cndClause.indexOf("+")>-1){
		cndClause = cndClause.replace("+","!!")
	}
	if(DivSelect.cndClause==cndClause) return true;
	DivSelect.cndClause=cndClause;
	tableDiv.innerHTML="";
	var xmlHttp=PubUtil.createXMLHttp();
	var queryParams = "subSys="+subSys+"&dicSubKind="+dicSubKind+"&dicSubKind="+dicSubKind+"&dicGrpID="+dicGrpID+"&refDicBindValues="+refDicBindValues+"&dicValue="+dicValue+"&cndClause="+cndClause+"&valDicCol="+valDicCol;
	queryParams=encodeURI(queryParams);
	xmlHttp.open("POST","sysmng.divSelectData.do",false);
	xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
	xmlHttp.send(queryParams);  
	var resultInfo=xmlHttp.responseText;
	var error = DivSelect.getError(resultInfo);
	if(error.length>0)
	{
		alert(error);
		return false;
	}
	tableDiv.innerHTML=resultInfo;
	return true;
}

//源标签keydown事件
DivSelect.keyDown= function(theObj,evt){
	var keycode=evt.keyCode;
	DivSelect.oldobjval=theObj.value;
	if(keycode==13||keycode==38||keycode==40){
		if(DivSelect.layerObj==null)return;
		if(DivSelect.divRowObjs==null||DivSelect.divRowObjs.length<1)return;
		var rowIdx=parseInt(DivSelect.divTable.getAttribute("divrow"));
		var rowSize=parseInt(DivSelect.divTable.getAttribute("divsize"));
		if(keycode==13)//Enter键事件,如果未选择行，默认取第一条数据，如果第一条数据为空，则return
		{	
			var rownum= rowIdx;
			if(rownum==-1)
			{
				rownum=0;	
			}
			while(DivSelect.divRowObjs[rownum].style.display=="none")
			{
				rownum=rownum+1;
				if(rowIdx>=rowSize)return;
				if(rowIdx==rownum)break;
			}
			DivSelect.Selected(DivSelect.divRowObjs[rownum]);
			DivSelect.divTable.setAttribute("divrow",rownum);
			if(DivSelect.ns)
				DivSelect.divRowObjs[rownum].onclick();
			else 
				DivSelect.divRowObjs[rownum].click();
		}
		else if(keycode==38){//上键，操作list上移
			var rownum= rowIdx-1;
			if(rownum<0)
				rownum=rowSize-1;
			while(DivSelect.divRowObjs[rownum].style.display=="none")
			{
				rownum=rownum-1;
				if(rownum<0)
				rownum=rowSize-1;
				if(rownum==rowIdx)break;
			}
			if(rownum<0)
				rownum=rowSize-1;
			DivSelect.divTable.setAttribute("divrow",rownum);
			DivSelect.Selected(DivSelect.divRowObjs[rownum]);
			DivSelect.noSelected(DivSelect.divRowObjs[rowIdx]);
		}
		else if(keycode==40){//下键，操作list下移
			var rownum= rowIdx+1;
			if(rownum>=rowSize)
				rownum=0;
			while(DivSelect.divRowObjs[rownum].style.display=="none")
			{
				rownum=rownum+1;
				if(rownum>=rowSize)
				rownum=0;
				if(rownum==rowIdx)break;
			}
			if(rownum>=rowSize)
				rownum=0;
			DivSelect.divTable.setAttribute("divrow",rownum);
			DivSelect.Selected(DivSelect.divRowObjs[rownum]);
			DivSelect.noSelected(DivSelect.divRowObjs[rowIdx]);
		}
	}
}
//默认divlist 选择函数，支持左键，回车键选择  obj源标签，text_name 标签弹回函数参见使用说明，n行号
DivSelect.pubSelData=function(theObj,hideObjName,index,key,value,isMinu,textName)
{

	var eventElem=DivSelect.eventElem;
	var index1=0;
	var elemArr=new Array();
	var elemArr2=new Array();
	//查出源标签，对应的index,第几个
	arr=document.getElementsByName(eventElem.name);
	for(var i=0;i<arr.length;i++)
	{
		if(arr[i]==eventElem)
		{
			index1=i;
			break;
		}
	}
	if(!isMinu)
	{
		//分解标签返回参数，写回返回值
		var cells=theObj.cells;
		var tpobj=document.getElementsByName(eventElem.getAttribute("ftext"));
		if(tpobj!=null&&tpobj[index1]!=null)
			tpobj[index1].value=cells[0].innerHTML;
		elemArr[0]=eventElem;
		eventElem.value=cells[1].innerHTML;;
	}
	else
	{
		//分析设置参数,并将数据返回到对应的页面标签
		var text = textName.split(";;");
		var vals=theObj.childNodes;
		for(var i=0;i<text.length;i++)
		{
			var tpobj=document.getElementsByName(text[i]);
			if(tpobj!=null&&tpobj[index1]!=null){
				
				tpobj[index1].value=vals[i].value;				//document.getElementsByName("div_"+text[i])[index].value;
			}
			elemArr[i]=tpobj;
		}
		var divDisableText = eventElem.divDisableText;
		if(divDisableText!=null){
			var divDisable = eventElem.divDisable;
			var text = divDisableText.split(":");
			if(divDisable!=null&&divDisable){
				for(var i=0;i<text.length;i++){
					var tpobj=document.getElementsByName(text[i]);
					if(tpobj!=null&&tpobj[index1]!=null){
						tpobj[index1].disabled=true;		
					}
				}
			}
		}
	}
	DivSelect.closeSelect(DivSelect.layerObj,DivSelect.layerX,DivSelect.layerY);
	DivSelect.fireOnChange(elemArr,elemArr2);
}
//关闭字典 参数id为divID,
DivSelect.closeSelect=function (theObj,cordX,cordY,checkFlag){ 
	if(theObj==null)return;
	theObj.style.display="none";
	PubUtil.showTags(theObj,cordX,cordY);
	DivSelect.isTargetDiv=false;
	if(DivSelect.eventElem&&!checkFlag)
	{
		var elemArr=new Array();
		elemArr[0]=DivSelect.eventElem;
		DivSelect.fireOnBlur(elemArr);
	}
}
//关闭字典 参数id为divID,
DivSelect.buttonCloseSelect=function (bool){ 
	DivSelect.closeSelect(DivSelect.layerObj,DivSelect.layerX,DivSelect.layerY,bool);
}


/**
 * 下拉框中清除按钮使用。
 * @param elemNames 关联元素名集，多个逗号间隔。
 */
DivSelect.clearValues=function(elemNames){
	var eventElem=DivSelect.eventElem;
	if(eventElem==null) return;
	var index=0;
	var arr=document.getElementsByName(eventElem.name);
	for(var i=0;i<arr.length;i++)
	{
		if(arr[i]==eventElem)
		{
			index=i;
			break;
		}
	}
	var elemArr=new Array();
	var elemArr2=new Array();
	var texts = elemNames.split(",");
	//清楚源标签值及关联标签值
	for(var i=0;i<texts.length;i++){
		var tt=document.getElementsByName(texts[i]);
		if(tt!=null&&tt[index]!=null) tt[index].value="";
		elemArr[i]=eventElem;
	}
	DivSelect.buttonCloseSelect();
	DivSelect.fireOnChange(elemArr,elemArr2);
	DivSelect.fireEvent(eventElem,"onkeyup");
	DivSelect.isTargetDiv=false;
}

/*可输入过滤的下拉框
 *@param obj 源标签, divid, text_name 返回标签参数, type 无用
 */
DivSelect.doFilter=function(theObj){
	if(DivSelect.layerObj==null)return;
	var value=theObj.value;
	if(DivSelect.oldobjval==value) return;
	if(DivSelect.divRowObjs==null||DivSelect.divRowObjs.length<1) return;
	var childs = DivSelect.divRowObjs;
	for(var i=0,n=childs.length;i<n;i++){
		var cell=childs[i].childNodes[1];
		if(cell.innerHTML.indexOf(value)==0)
			cell.style.display=""
		else
			cell.style.display="none";
	}
}
//下拉框onblur
DivSelect.selectOnBlur=function(obj,isCheckExist,isMuli){
	if(obj!=DivSelect.eventElem)
	{
		DivSelect.checkTrue=true;
		return;
	}
	if(DivSelect.layerObj==null)return;
	if(!DivSelect.isTargetDiv) 
		DivSelect.buttonCloseSelect(true);
	else
		return true;
	var index=0;
	var arr=document.getElementsByName(obj.name);
	for(var i=0;i<arr.length;i++)
	{
		if(arr[i]==obj)
		{
			index=i;
			break;
		}
	}
	var ftext=document.getElementsByName(obj.getAttribute("ftext"));
	var value=obj.value;
	if(value=="")
	{
		if(ftext!=null&&ftext[index]!=null) ftext[index].value="";
		return true;
	}
	ftext=ftext[index];
	if(isCheckExist)
	{
		DivSelect.checkTrue=DivSelect.checkValue(obj,value,ftext,isCheckExist,isMuli)
	}
	else
	{
		var objDiv= DivSelect.getMainTable(layer);
		if(objDiv==null&&!DivSelect.checkExist(obj,ftext,objDiv,value,isMuli))
		{
			obj.value=text;
			if(ftext!=null) ftext.value=value;
			DivSelect.closeSelect(DivSelect.layerObj);
			return true;
		}
	}
}
DivSelect.checkValue =function(obj,value,ftext,isCheckExist,isMuli)
{
	var layer=document.getElementById(obj.getAttribute("divid"));
	if(isCheckExist)
	{
		var objDiv= DivSelect.getMainTable(layer);
		if(objDiv!=null)
		{
			DivSelect.divRowObjs=objDiv.tBodies[0].rows;
			if(DivSelect.checkExist(obj,ftext,objDiv,value,isMuli)){
				alert("不存在[ "+value+" ]对应的值!");
				if(ftext!=null&&ftext!=null) ftext.value="";
				obj.focus();
				return false;
			}
		}
		else
		{
			alert("不存在[ "+value+" ]对应的值!");
			if(ftext!=null&&ftext!=null) ftext.value="";
			obj.focus();
			return false;
		}
	}
	return true;
}
DivSelect.checkExist=function(obj,ftext,objDiv,text,muli){
	muli=false;
	var bool=true;
	if(objDiv.childNodes==null||objDiv.childNodes.length<1) return;
	if(muli){
		var dicKeyIndexs=document.getElementsByName(obj.getAttribute("divid")+"dicKeyIndexs");
		var dicKeyIndex=null;
		var m=0;
		if(dicKeyIndexs[0]!=null&&dicKeyIndexs[0].value.length>0)
		{
			dicKeyIndex=dicKeyIndexs[0].value.split(",");
			m=dicKeyIndex.length;
			var childs = objDiv.childNodes[0].tBodies[0].rows
			for(var i=1,n=childs.length;i<n;i++){
				var cells=childs[i].cells;
				for(var j=0;j<m;j++)
				{
					if(cells[j].innerHTML==text)
					{
						if(DivSelect.ns)
							childs[i].onclick();
						else 
							childs[i].click();
						bool=false;
						break;
					}
				}
				if(!bool)break;
			}
		}
		else 
			bool=false;
	}
	else
	{
		var childs = objDiv.tBodies[0].rows;
		for(var i=0,n=childs.length;i<n;i++){
			var cells=childs[i].cells;
			if(cells[0].innerHTML==text||cells[1].innerHTML==text){
				if(DivSelect.ns)
					childs[i].onclick();
				else 
					childs[i].click();
				bool=false;
				break;
			}
		}
	}
	return bool;
}
//取divselect数据表
DivSelect.getMainTable=function(divObj)
{	
	if(divObj==null)return null;
	var MainTable=null;
	var tables = divObj.getElementsByTagName("table");
	if(tables==null||tables.length<1)return null;
	for (var i=0,m=tables.length;i<m;i++)
	{
		if (tables[i].id!=null&&tables[i].id=="selectTable")
		{
			MainTable=tables[i];
			break;
		}
	}
	return MainTable;
}
DivSelect.setIsTargetDiv=function(isTargetDiv)
{	
	DivSelect.isTargetDiv=isTargetDiv;
}
//ajax出错信息提取
DivSelect.getError=function(info)
{
  var index1=info.indexOf("<error>");
  var index2=info.indexOf("</error>");
  if(index1==-1 || index2==-1)
    return "";
  return info.substring(index1+7,index2);
}
/**
 * 触发指定元素集的onchange事件。
 * @param elemArr 指定元素集，
 * @param elemArr2 指定元素集2。
 */
DivSelect.fireOnChange=function(elemArr,elemArr2)
{
  for(var i=0;i<elemArr.length;i++)
  {
    try
    {
      if(elemArr[i] && elemArr[i].onchange)
      {
        DivSelect.fireEvent(elemArr[i],"onchange");
      }
      if(elemArr2[i] && elemArr2[i].onchange)
      {
        DivSelect.fireEvent(elemArr2[i],"onchange");  
      }
    }
    catch(e)
    {
    }
  }
}
/**
 * 触发指定元素集的onblur事件。
 * @param elemArr 指定元素集，
 * @param elemArr2 指定元素集2。
 */
DivSelect.fireOnBlur=function(elemArr)
{
  for(var i=0;i<elemArr.length;i++)
  {
    try
    {
      if(elemArr[i] && elemArr[i].onblur)
      {
        DivSelect.fireEvent(elemArr[i],"onblur");
      }
    }
    catch(e)
    {
    }
  }
}
DivSelect.selectImageOnload=function (obj)
{
	var arrowObj=obj.parentNode;
	var prevObj=arrowObj.previousSibling;
	if(DivSelect.ns)
	{
		arrowObj.className="link_arrow01";
		arrowObj.style.left=-arrowObj.offsetWidth-1;
		arrowObj.style.top=prevObj.offsetTop-1;
		arrowObj.style.height=prevObj.clientHeight+1;
		var PostfixTag=arrowObj.nextSibling;
		PostfixTag.style.left=-arrowObj.offsetWidth;
	}
	else
	{
		arrowObj.style.left=-arrowObj.offsetWidth-1;
		arrowObj.style.top=prevObj.offsetTop-2;
		arrowObj.style.height=prevObj.clientHeight+1;
		var PostfixTag=arrowObj.nextSibling;
		PostfixTag.style.left=-arrowObj.offsetWidth;
	}

}
//原背景色。
DivSelect.preBgColor="";
/**
 * 鼠标移到对象时改变背景色.
 * @param obj 对象,如tr,td.
 */
DivSelect.Selected=function(obj)
{ 
	if(obj==null)return;
	DivSelect.preBgColor=obj.style.backgroundColor;
    obj.style.backgroundColor="#CCCCFF";
}
//未选择时还原原背景色
DivSelect.noSelected=function(obj)
{ 
	if(obj==null)return;
	obj.style.backgroundColor=DivSelect.preBgColor;
}
/**
 * 触发指定的事件。
 * @param elem 对象。
 * @eventName 事件名。
 */
DivSelect.fireEvent=function(elem,eventName)
{
  if(!elem || !eventName)
    return;
  try
  {
    if(elem.fireEvent(eventName))//ie is ok,firefox isn't ok
      return;
  }
  catch(e)
  {
    if(eventName.toLowerCase()=="onchange" && elem.onchange)
    {
      elem.onchange();
      return;
    }
    if(eventName.toLowerCase()=="onclick" && elem.onclick)
    {
      elem.onclick();
      return;
    }
	if(eventName.toLowerCase()=="onblur" && elem.onclick)
    {
      elem.onblur();
      return;
    }
	if(eventName.toLowerCase()=="onkeyup" && elem.onclick)
    {
      elem.onkeyup();
      return;
    }
    var eventBodyObj=elem.getAttribute(eventName);
    if(!eventBodyObj)
      return;
    var eventBody=eventBodyObj.toString();
    if(eventBody=="undefined")
      return;
    var i=eventBody.indexOf("{");
    if(i>-1)
      eventBody=eventBody.substring(i+1);
    i=eventBody.lastIndexOf("}");
    if(i>-1)
      eventBody=eventBody.substring(0,i);
    eventBody=eventBody.replace(/document/ig,"elem.document");
    eval(eventBody); 
  }   
};
/*下拉按钮onclick事件*/
DivSelect.drogDownClick=function(imgElem)
{ 
	var prev=imgElem.previousSibling;
	if(prev==null)return;
	if(DivSelect.ns) 
	{
		prev.focus();
		DivSelect.openSelect(prev,true);
	}
	else 
	{
		prev.onfocus();
		DivSelect.openSelect(prev,true);
	}
}
/*下拉按钮点击改变className*/
DivSelect.changeClassName=function(eventElem,clssName)
{ 
	if(DivSelect.ns) eventElem.className=clssName+"1";
	else eventElem.className=clssName;
}