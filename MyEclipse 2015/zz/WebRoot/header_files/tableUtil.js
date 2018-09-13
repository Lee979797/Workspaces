
/**
 * table功能js。
 */
TableUtil=function TableUtil(){};

/**
 * insert a new row to table object.
 * @param tblObj table object.
 * @param rowIndex new Row's index.-1 表示在最后增加
 * @param isSetDefault 是否对里面的元素设定默认值。
 * @param refRow 引用的行对象。
 * @return new row object.
 */
TableUtil.insertRow=function(tblObj,rowIndex,isSetDefault,refRow)
{
  if(!tblObj)
    return null;
  if(rowIndex<0)
    rowIndex=tblObj.rows.length+rowIndex+1;
  if(rowIndex<0 || rowIndex>tblObj.rows.length)
    rowIndex=tblObj.rows.length;
  var newRow=tblObj.insertRow(rowIndex);
  if(tblObj.rows.length>1)
  {
    var refIndex=(rowIndex>=1)?rowIndex-1:tblObj.rows.length-1;
	if(refRow==null)
      refRow=(refIndex>=0)?tblObj.rows[refIndex]:null;
    if(refRow!=null)
    {
      for(var i=0;i<refRow.attributes.length;i++)
      {
        var attrName=refRow.attributes[i].name;
        var attrValue=refRow.getAttribute(attrName);
        if(attrValue!="" && attrValue!=null)
          newRow.setAttribute(attrName,attrValue);
      }
      newRow.className=refRow.className;//属性中没有className
    }
    for(var i=0,size=refRow.cells.length; refRow && i<size; i++)
    {
      var newCell=newRow.insertCell(i);
      newCell.innerHTML=refRow.cells[i].innerHTML;
      for(var j=0;j<refRow.cells[i].attributes.length;j++)
      {
        var attrName=refRow.cells[i].attributes[j].name;
        var attrValue=refRow.cells[i].getAttribute(attrName);
        if(attrValue!="" && attrValue!=null)
          newCell.setAttribute(attrName,attrValue);
      }
      newCell.className=refRow.cells[i].className;
      TableUtil.copyTdChildValues(newCell,refRow.cells[i],isSetDefault);
    }
  }
  return newRow;
};

/**
 * 设置td的默认值.
 * @param curTdObj 当前的td对象。
 * @param refTdObj 供引用的td对象。
 * @param isSetDefault 是否是设置原始值。
 */
TableUtil.copyTdChildValues=function(curTdObj,refTdObj,isSetDefault)
{
  if(isSetDefault==null)
    isSetDefault=true;
  var tmp=curTdObj.childNodes;
  if(tmp==null)
    return;
  var objArr=new Array(tmp.length);
  for(var i=0;i<tmp.length;i++)//直接用tmp.concat()出错。
  {
    objArr[i]=tmp[i];
  }
  tmp=refTdObj.childNodes;
  if(tmp==null)
    return;
  var objArr2=new Array(tmp.length);
  for(var i=0;i<tmp.length;i++)//直接用tmp.concat()出错。
  {
    objArr2[i]=tmp[i];
  }
  for(var i=0;i<objArr.length;i++)
  {
    if(typeof objArr[i]!="object")
      continue;
    var isAddChildNodes=true;
    if(typeof objArr[i].type !="undefined"&&typeof objArr2[i].type !="undefined")
    {
      isAddChildNodes=false;
      switch(objArr[i].type.toLowerCase())
      {
        case "text":
        case "textarea":
        case "password":
        case "hidden":
        case "file":
          if(isSetDefault)
            objArr[i].value=objArr2[i].defaultValue;
          else
            objArr[i].value=objArr2[i].value;
          objArr[i].defaultValue=objArr2[i].defaultValue;//ie中用innerHTML后，defaultValue=引用对象的新值，下同
          break;
        case "select-one":
        case "select-multiple":          
          if(isSetDefault)
            objArr[i].value=objArr2[i].defaultValue;
          else
            objArr[i].value=objArr2[i].value;
          objArr[i].defaultValue=objArr2[i].defaultValue;
          var optionArr=objArr[i].options;
          var optionArr2=objArr2[i].options;
          var selectedIndex=0;
          for(var j=0;j<optionArr.length;j++)
          {
            if(isSetDefault)
              optionArr[j].selected=optionArr2[j].defaultSelected;
            else
              optionArr[j].selected=optionArr2[j].selected;
            optionArr[j].defaultSelected=optionArr2[j].defaultSelected;
            if(optionArr2[j].defaultSelected)
              selectedIndex=j;
          }
          if(isSetDefault)
            objArr[i].selectedIndex=selectedIndex;//多选第一个生效
          else
            objArr[i].selectedIndex=objArr2[i].selectedIndex;
          break;      
        case "checkbox":
        case "radio":
          if(isSetDefault)
            objArr[i].checked=objArr2[i].defaultChecked;
          else
            objArr[i].checked=objArr2[i].checked;
          objArr[i].defaultChecked=objArr2[i].defaultChecked;
          break;
        default:
          isAddChildNodes=true;
          break;
      }
    }
    if(!isAddChildNodes)
      continue;
    if(objArr[i].childNodes!=null&&objArr2[i]!=null&&objArr2[i].childNodes!=null)
    {
      for(var j=0;j<objArr[i].childNodes.length;j++)
      {
        objArr[objArr.length]=objArr[i].childNodes[j];
      }
      for(var j=0;j<objArr2[i].childNodes.length;j++)
      {
			objArr2[objArr2.length]=objArr2[i].childNodes[j];
      }
    }
  }
};

/**
 * 删除Table中的行。
 * @param tblObj table对象。
 * @param eventObj 引发删除事件的对象，如img,a,必需在要删除的tr中.
 * @param isConfirm 是否询问。
 */
TableUtil.deleteRow=function(tblObj,eventObj,isConfirm)
{
  if(!tblObj)
    return;
  if(isConfirm && !confirm("您真的要删除当前行吗？"))
    return;
  var trObj=eventObj;
  if(trObj==null)
  {
    alert("删除行必须通过事件触发！");
    return;
  }
  trObj=getTrByChild(trObj);
  if(trObj==null)
    return;
  for(var i=0;i<tblObj.rows.length;i++)
  {
    if(tblObj.rows[i]==trObj)
      tblObj.deleteRow(i);
  }
};


/**
 * 删除TD。
 * @param tdObj 要删除的TD。
 */
TableUtil.deleteTd=function(tdObj)
{
  if(tdObj==null)
    return;
  var trObj=PubUtil.getParentNode(tdObj,"tr");
  if(trObj==null)
    return;
  var cells=trObj.cells;
  for(var i=0;i<cells.length;i++)
  {
    if(cells[i]==tdObj)
    {
      trObj.deleteCell(i);
      break;
    }
  }
}

/**
 * 取与给定的子节点对应的父table对象。
 * @param childNode 子节点。
 */
TableUtil.getTableByChild=function(childNode)
{
  return PubUtil.getParentNode(childNode,"table");
};


/**
 * 取与给定的子节点对应的父tr对象。
 * @param childNode 子节点。
 */
TableUtil.getTrByChild=function(childNode)
{
  return PubUtil.getParentNode(childNode,"tr");
};


/**
 * 取与给定的子节点对应的父td对象。
 * @param childNode 子节点。
 */
TableUtil.getTdByChild=function(childNode)
{
  return PubUtil.getParentNode(childNode,"td");
};

