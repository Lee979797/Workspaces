//TAB标签公用功能函数

TabUtil=function TabUtil(){};

TabUtil.LAST_PAGE_INDEX_ATTR="lastPageIndex";

/**
 * 点击标签页。
 * @param pageID 标签页对应的Tag标识。
 * @param isVertical 是否垂直排列。
 * @return 是否切换了标签页。
 */
TabUtil.clickTabPage=function(pageID,isVertical)
{
  if(isVertical==null)
    isVertical=false;
  var pos=pageID.indexOf("_");
  if(pos==-1)
    return;
  var prefix=pageID.substring(0,pos);
  var pageIndex=new Number(pageID.substring(pos+1));
  var lastPageIndex=TabUtil.getPreviousPageIndex(prefix);
  if(pageIndex==lastPageIndex)
    return false;
  //复原上次处理的tab。
  if(lastPageIndex!=-1) 
    TabUtil.setPageStatus(prefix,lastPageIndex,false);  
  //设置新的tab.
  TabUtil.setPageStatus(prefix,pageIndex,true);  
  if(!isVertical && lastPageIndex!=-1)//交换行
  {
    var curRow=TabUtil.getPageRowIndex(pageID);
    var lastRow=TabUtil.getPageRowIndex(prefix+"_"+lastPageIndex);
    if(curRow!=lastRow)
    {
      var pageTdObj=document.getElementById(pageID);
      var pageTableObj=TableUtil.getTableByChild(pageTdObj);
      var tabTableObj=TableUtil.getTableByChild(pageTableObj);
      var len=tabTableObj.rows.length;
      var rows=new Array(len);
      var pNode=tabTableObj.rows[0].parentNode;
      for(var i=0;i<len;i++)
      {
        rows[i]=tabTableObj.rows[0];
        pNode.removeChild(rows[i]);
      }
      var tempTrObj=rows[curRow];
      rows[curRow]=rows[lastRow];
      rows[lastRow]=tempTrObj;
      for(var i=0;i<rows.length;i++)
      {
        pNode.appendChild(rows[i]);
      }
    }
  }
  else if(lastPageIndex!=-1)//交换列
  {
    var curCol=TabUtil.getPageColIndex(pageID);
    var lastCol=TabUtil.getPageColIndex(prefix+"_"+lastPageIndex);
    if(curCol!=lastCol)
    {
      var pageTdObj=document.getElementById(pageID);
      var pageTableObj=TableUtil.getTableByChild(pageTdObj);
      var tabTableObj=TableUtil.getTableByChild(pageTableObj);
      var tmpInnerHTML=tabTableObj.rows[0].cells[curCol].innerHTML;
      tabTableObj.rows[0].cells[curCol].innerHTML=tabTableObj.rows[0].cells[lastCol].innerHTML;
      tabTableObj.rows[0].cells[lastCol].innerHTML=tmpInnerHTML;
    }
  }
  //显示/隐藏标签页
  if(lastPageIndex!=-1)
    PubUtil.showHideElement(prefix+"c_"+lastPageIndex,false);
  PubUtil.showHideElement(prefix+"c_"+pageIndex,true);  
  var curPage=document.getElementById(prefix+"_"+pageIndex);
  if(curPage!=null)
    curPage.setAttribute(TabUtil.LAST_PAGE_INDEX_ATTR,lastPageIndex);
  return true;
};

/**
 * 取上次点击的标签页索引。
 * @param tagIDPrefix Tag标识前缀。
 * @return 上次标签页索引。
 */
TabUtil.getPreviousPageIndex=function(tagIDPrefix)
{
  var index=0;
  var obj=document.getElementById(tagIDPrefix+"_"+index);
  while(obj!=null)
  {
    if(obj.getAttribute("isselected")=="1")
      return index;
    index++;
    obj=document.getElementById(tagIDPrefix+"_"+index);
  }
  return -1;
};

/**
 * 设置标签页状态。
 * @param tagIDPrefix 标签标识前缀。
 * @param pageIndex 标签页索引。
 * @param isSelected 是否被选择。
 */
TabUtil.setPageStatus=function(tagIDPrefix,pageIndex,isSelected)
{
  var isFirst=false;
  var imgObj=document.getElementById(tagIDPrefix+"_"+(pageIndex-1)+"_"+pageIndex);
  if(imgObj==null)
  {
    isFirst=true;
    imgObj=document.getElementById(tagIDPrefix+"__"+pageIndex);//第一列
  }
  if(imgObj!=null)
  {
    imgSrc=imgObj.src.toString();    
    var imgPrefix=imgSrc.substring(0,imgSrc.length-4);
    if(isSelected)
    {
      var pos=imgPrefix.lastIndexOf("/");
      if(pos!=-1)
        imgObj.src=imgPrefix.substring(0,pos)+(isFirst?"/firstLeftSel.gif":"/leftSel.gif");  
    }
    else
      imgObj.src=imgPrefix.substring(0,imgPrefix.length-3)+".gif";
  }
  tdObj=PubUtil.findObj(tagIDPrefix+"_"+pageIndex);
  if(tdObj!=null)//firefox不支持tdObj.background
  {
    //imgSrc=tdObj.background.toString();//firefox不支持tdObj.background
    if(isSelected)
    {
      if(tdObj.className.substring(tdObj.className.length-3)!="Sel")
        tdObj.className=tdObj.className+"Sel";
      tdObj.setAttribute("isselected",1);
    }
    else
    {
      if(tdObj.className.substring(tdObj.className.length-3)=="Sel")
        tdObj.className=tdObj.className.substring(0,tdObj.className.length-3);
      tdObj.setAttribute("isselected",0);
    }    
  }
  var isLast=false;
  imgObj=document.getElementById(tagIDPrefix+"_"+pageIndex+"_"+(pageIndex+1));  
  if(imgObj==null)//最后一个标签
  {
    isLast=true;
    imgObj=document.getElementById(tagIDPrefix+"_"+pageIndex+"_");
  }
  if(imgObj!=null)
  {
    imgSrc=imgObj.src.toString();
    var imgPrefix=imgSrc.substring(0,imgSrc.length-4);
    if(isSelected)
    {
      var pos=imgPrefix.lastIndexOf("/");
      if(pos!=-1)
        imgObj.src=imgPrefix.substring(0,pos)+(isLast?"/lastRightSel.gif":"/rightSel.gif");  
    }
    else
      imgObj.src=imgPrefix.substring(0,imgPrefix.length-3)+".gif";
  }
};

/**
 * 取标签页所在行。
 * @param pageID 标签页ID。
 * @return 标签页所在行。
 */
TabUtil.getPageRowIndex=function(pageID)
{
  var pageTdObj=document.getElementById(pageID);
  var pageTableObj=TableUtil.getTableByChild(pageTdObj);
  var tabTableObj=TableUtil.getTableByChild(pageTableObj);
  if(tabTableObj.rows.length==1)
    return 0;
  var tabTrObj=TableUtil.getTrByChild(pageTableObj);
  for(var i=0;i<tabTableObj.rows.length;i++)
  {
    if(tabTableObj.rows[i]==tabTrObj)
      return i;
  }
  return 0;
};


/**
 * 取标签页所在列。
 * @param pageID 标签页ID。
 * @return 标签页所在列。
 */
TabUtil.getPageColIndex=function(pageID)
{
  var pageTdObj=document.getElementById(pageID);
  var pageTableObj=TableUtil.getTableByChild(pageTdObj);
  var tabTableObj=TableUtil.getTableByChild(pageTableObj);
  if(tabTableObj.rows[0].cells.length==1)
    return 0;
  var tabTdObj=TableUtil.getTdByChild(pageTableObj);
  var tabTdObjs=tabTableObj.rows[0].cells;
  for(var i=0;i<tabTdObjs.length;i++)
  {
    if(tabTdObjs[i]==tabTdObj)
      return i;
  }
  return 0;
};

/**
 * 显示容纳子对象的父标签页.
 * @param child 子对象。
 */
TabUtil.showParentPage=function(child)
{
  if(typeof child=="string")
    child=document.getElementById(child);
  if(child==null)
    return;
  var parent=child.parentNode;
  while(parent!=null)
  {
    var parentID=parent.id;
    if(parentID!=null && parentID.length>3 && parentID.substring(0,3)=="tab" && parentID.indexOf("c_")!=-1)
    {
      var pos=parentID.indexOf("c_");
      var tagIDPrefix=parentID.substring(0,pos);
      var pageIndex=new Number(parentID.substring(pos+2));
      var tdObj=document.getElementById(tagIDPrefix+"_"+pageIndex);
      if(tdObj==null)
        return;
      var isSelected=tdObj.getAttribute("isselected");
      if(isSelected!=null && isSelected=="0")
      {
        EventUtil.fireEvent(tdObj,"onclick");
      }
    }
    parent=parent.parentNode;
  }
};