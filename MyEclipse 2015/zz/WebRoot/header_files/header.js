//首页header用js

var lastCatTabNo=1;//上一次显示的模块组标签序号。
var clickedCatID=null;//点击显示的模块组标识
var navTrees=new Array();
var topCats=new Array();

function ModNavTreeFolder(treeID,id,openIconSrc,closeIconSrc,navObjID,iconImgID,
     nodeImgID,isLastNode,childLeftSide,value,isOpen,isShownChildren)
{
  this.treeID=treeID;
  this.id=id;
  this.openIconSrc=openIconSrc;
  this.closeIconSrc=closeIconSrc;
  this.navObjID=navObjID;  
  this.iconImgID=iconImgID;
  this.nodeImgID=nodeImgID;
  this.isLastNode=isLastNode;
  this.id=id;
  this.childLeftSide=childLeftSide;
  this.value=value;
  this.isOpen=isOpen;
  this.isShownChildren=isShownChildren;
};


//缓存Tree对象。
function ModNavTree()
{
  //这些属性来源于webtree.js,如果属性有变化，要相应更改
  var navTreeObj=top.modNav.document.getElementById("navTree");
  if(navTreeObj==null)//可能是出错页面，没有树对象。
    return;
  this.treeTags=navTreeObj.innerHTML;
  var tree=top.modNav.webTrees[0];
  this.id=tree.id;
  this.maxID=tree.maxID;
  this.subTreeUrl=tree.subTreeUrl;
  this.lastLinkObjID=null;
  if(tree.lastLinkObj!=null)
    this.lastLinkObjID=tree.lastLinkObj.id;
  this.treeFolders=new Array();
  var folders=tree.indexOfEntries;
  WebTree.resPath=top.modNav.WebTree.resPath;
  for(var i=0;i<folders.length;i++)
  {
    if(!folders[i])
      continue;
    var folder=folders[i];
    var nodeImgID=folder.nodeImg?folder.nodeImg.id:null;//根节点无nodeImg
    this.treeFolders[folder.id]=new ModNavTreeFolder(folder.treeID,folder.id,folder.openIconSrc,folder.closeIconSrc,
      folder.navObj.id,folder.iconImg.id,nodeImgID,folder.isLastNode,folder.childLeftSide,
      folder.value,folder.isOpen,folder.isShownChildren);
  }

  //用于刷新
  this.startCatID=top.modNav.document.getElementById("startCatID").value;
};

//恢复原树。返回1表示恢复成功，0失败。
ModNavTree.prototype.restore=function()
{
  var navTreeObj=top.modNav.document.getElementById("navTree");
  if(navTreeObj==null)
    return 0;
  navTreeObj.innerHTML=this.treeTags;
  var tree=top.modNav.webTrees[0];
  tree.id=this.id;
  tree.maxID=this.maxID;
  tree.subTreeUrl=this.subTreeUrl;
  if(this.lastLinkObjID!=null)
    tree.lastLinkObj=top.modNav.document.getElementById(this.lastLinkObjID);    
  tree.indexOfEntries=new Array();
  for(var i=0;i<this.treeFolders.length;i++)
  {
    var treeFolder=this.treeFolders[i];
    if(!treeFolder)
      continue;
    var navObj=top.modNav.document.getElementById(treeFolder.navObjID);
    var iconImg=top.modNav.document.getElementById(treeFolder.iconImgID);
    var nodeImg=null;
    if(treeFolder.nodeImgID)
      nodeImg=top.modNav.document.getElementById(treeFolder.nodeImgID);
    tree.indexOfEntries[treeFolder.id]=new TreeFolder(treeFolder.treeID,treeFolder.id,treeFolder.openIconSrc,
         treeFolder.closeIconSrc,navObj,iconImg,nodeImg,treeFolder.isLastNode,
         treeFolder.childLeftSide,treeFolder.value,treeFolder.isOpen,treeFolder.isShownChildren);
  }
  top.modNav.document.getElementById("startCatID").value=this.startCatID;
  return 1;
};

/**
 * 点击模块组标签时处理事件。
 * @param catID 模块组标识。
 * @param tabNo 标签序号。
 */
function clickCatTab(catID,tabNo)
{
  if(tabNo==lastCatTabNo)
    return;
  clickedCatID=catID;
  changeCatTabFocus(tabNo);
  
  //lastCatTabNo=tabNo;
  //top.modNav.location="modNav.jsp?startCatID="+catID+"&isShowNav="+top.splitor.splitor.showFlag;

  navTrees[lastCatTabNo-1]=new ModNavTree();
  lastCatTabNo=tabNo;
  var flag=0;
  if(navTrees[tabNo-1] && navTrees[tabNo-1].treeTags.length>0 && navTrees[tabNo-1].restore)
    flag=navTrees[tabNo-1].restore();
  if(flag==0)
  {
    var uri=top.modNav.location.toString();
    var pos=uri.indexOf("?");
    if(pos!=-1)
      uri=uri.substring(0,pos);
    pos=uri.indexOf("#");
    if(pos!=-1)
      uri=uri.substring(0,pos);
    top.modNav.location=uri+"?startCatID="+catID+"&isShowNav="+top.splitor.splitor.showFlag;
  }  
  for(var i=0;i<topCats.length;i++)
  {
	if(topCats[i].catID==catID)
	{
	  if(topCats[i].catURL!=null && topCats[i].catURL!="")
	  {
		 if(top.workspace.dynaTabArr[0]!=null)
           top.workspace.dynaTabArr[0].addPage(PubUtil.antiHtmlFilter(topCats[i].catURL),"category"+catID,topCats[i].catTitle,
			  topCats[i].catTitle,true,true);
	  }
	  break;
	}
  }
}

/**
 * 显示用户自定义导航。
 * @param tabNo 标签序号。
 * @param navURL 导航URL。
 */
function showMyNavTree(tabNo,navURL)
{
  if(tabNo==lastCatTabNo)
    return;  
  changeCatTabFocus(tabNo);
  lastCatTabNo=tabNo;
  top.modNav.location=navURL;
}


/**
 * 切换模块组标签焦点。
 * @param tabNo 标签序号。
 */
function changeCatTabFocus(tabNo)
{
  if(tabNo==lastCatTabNo)
    return;  
  var prefix="catTab";
  var imgSrc="";
  var imgObj=null;
  var tdObj=null;
  //复原上次处理的tab。
  imgObj=PubUtil.findObj(prefix+"_"+(lastCatTabNo-1)+"_"+lastCatTabNo);
  if(imgObj)
  {
    imgSrc=imgObj.src.toString();
    imgObj.src=imgSrc.substring(0,imgSrc.length-7)+".gif";
  }
  tdObj=PubUtil.findObj(prefix+"_"+lastCatTabNo);
  if(tdObj!=null)//firefox不支持tdObj.background
  {
    //imgSrc=tdObj.background.toString();//firefox不支持tdObj.background
    tdObj.className="modTab";
  }
  imgObj=PubUtil.findObj(prefix+"_"+lastCatTabNo+"_"+(lastCatTabNo+1));
  if(imgObj==null)//最后一个标签
    imgObj=PubUtil.findObj(prefix+"_"+(lastCatTabNo)+"_");
  if(imgObj!=null)
  {
    imgSrc=imgObj.src.toString();
    imgObj.src=imgSrc.substring(0,imgSrc.length-7)+".gif";
  }
  //设置新的tab.
  var imgObj=PubUtil.findObj(prefix+"_"+(tabNo-1)+"_"+tabNo);
  if(imgObj!=null)
  {
    imgSrc=imgObj.src.toString();
    var index=imgSrc.lastIndexOf("/");
    if(index!=-1)
    {
      imgSrc=imgSrc.substring(0,index+1);
      if(tabNo==1)
        imgObj.src=imgSrc+"firstLeftSel.gif";
      else
        imgObj.src=imgSrc+"leftSel.gif";
    }
  }
  tdObj=PubUtil.findObj(prefix+"_"+tabNo);
  if(tdObj)
  {
    tdObj.className="modTabSel";
  }
  var isLast=false;
  var imgObj=PubUtil.findObj(prefix+"_"+(tabNo)+"_"+(tabNo+1));
  if(!imgObj)//最后一个Tab页
  {
    isLast=true;
    imgObj=PubUtil.findObj(prefix+"_"+(tabNo)+"_");
  }
  if(imgObj!=null)
  {
    imgSrc=imgObj.src.toString();
    var index=imgSrc.lastIndexOf("/");
    if(index!=-1)
    {
      imgSrc=imgSrc.substring(0,index+1);
      if(isLast)
        imgObj.src=imgSrc+"lastRightSel.gif";
      else
        imgObj.src=imgSrc+"rightSel.gif";
    }
  }
}

/**
 * 模块组对象。
 * @param catID 模块组标识。
 * @param catTitle 模块组标题。
 * @param catURL 模块组URL。
 */
function Category(catID,catTitle,catURL)
{
  this.catID=catID;
  this.catTitle=catTitle;
  this.catURL=catURL;
};