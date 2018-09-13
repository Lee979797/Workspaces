
/**
 * TreeFolder的JS对象。
 */
function TreeFolder(treeID,id,openIconSrc,closeIconSrc,navObj,iconImg,nodeImg,isLastNode,
         childLeftSide,value,isOpen,isShownChildren) 
{
  this.treeID=treeID;
  this.id=id;
  var resPath=Constants.contextRoot+"/charisma/treeres/";
  if(WebTree.resPath!="")
    resPath=WebTree.resPath;
  if(openIconSrc!=null && openIconSrc.length>0)
    this.openIconSrc=openIconSrc;
  else
    this.openIconSrc=resPath+"iOpenFolder.gif";
  if(closeIconSrc!=null && closeIconSrc.length>0)
    this.closeIconSrc=closeIconSrc;
  else
    this.closeIconSrc=resPath+"iGenericFolder.gif";
  this.mLastNodeSrc=resPath+"ftv2mlastnode.gif";
  this.pLastNodeSrc=resPath+"ftv2plastnode.gif";
  this.mNodeSrc=resPath+"ftv2mnode.gif";
  this.pNodeSrc=resPath+"ftv2pnode.gif";
  this.navObj=null;
  if(typeof navObj =="string")
    this.navObj=document.getElementById(navObj);  
  else
    this.navObj=navObj;
  this.iconImg=null;
  if(typeof iconImg =="string")
    this.iconImg=document.getElementById(iconImg);
  else
    this.iconImg=iconImg;
  this.nodeImg=null;
  if(typeof nodeImg =="string")
    this.nodeImg=document.getElementById(nodeImg);
  else
    this.nodeImg=nodeImg;
  this.isLastNode=isLastNode;
  this.childLeftSide=childLeftSide;
  this.value=value;
  
  //dynamic data 
  this.isOpen=isOpen;
  this.isShownChildren=isShownChildren;
};



/**
 * 设置folder状态。
 */
TreeFolder.prototype.setState = function(isOpen) 
{ 
  if (isOpen == this.isOpen) 
    return;
  this.isOpen = isOpen;
  TreeFolder.propagateInState(this); 
};

/**
 * 隐藏folder对象。
 */ 
TreeFolder.prototype.hide = function() 
{ 
  if (this.navObj.style.display!=null)
  { 
    if (this.navObj.style.display == "none") 
      return;
    this.navObj.style.display = "none";
  }
  else
  { 
    if (this.navObj.visibility == "hiden") 
      return;
    this.navObj.visibility = "hiden";
  }    
  this.setState(0);
};

/**
 * 显示folder对。
 */
TreeFolder.prototype.display = function() 
{ 
  if(Constants.isIE || Constants.isIE5)
  {
	//处理空行
	var isAllBlk=true;
    for(var i=0;i<this.navObj.childNodes.length;i++)
	{
	  if(this.navObj.childNodes[i].innerHTML.length>0)
	  {
		isAllBlk=false;
		break;
	  }		 
	}
	if(isAllBlk) return;
  }
  if(this.navObj.style.display!=null) 
    this.navObj.style.display = "block"; 
  else 
    this.navObj.visibility = "show"; 
};

 
/**
 * 切换folder状态。
 */
TreeFolder.propagateInState=function(folder) 
{
  var i=0;
  if (folder.isOpen) 
  { 
    if (folder.nodeImg)
    {
      if (folder.isLastNode) 
        folder.nodeImg.src = folder.mLastNodeSrc; 
      else 
	      folder.nodeImg.src = folder.mNodeSrc;
    }
    folder.iconImg.src = folder.openIconSrc;
    folder.display();    
  } 
  else 
  { 
    if (folder.nodeImg)
    {
      if (folder.isLastNode) 
        folder.nodeImg.src = folder.pLastNodeSrc;
      else 
	      folder.nodeImg.src = folder.pNodeSrc;
    }        
    folder.iconImg.src = folder.closeIconSrc;
    folder.hide();
  }  
};

/**
 * WebTree的JS对象。
 */
function WebTree(id,maxID)
{
  this.id=id;
  this.maxID=maxID;//Folder与Item当前最在ID值
  this.subTreeURL=null;//可能含参数。
  this.lastLinkObj=null;//上一次点击的链接。
  this.isOpenRefresh=false;//打开Folder时刷新子树
  //this.resPath="";

  this.linkProvider="";//连接提供类名。  
  this.otherParams="";//子树用其它参数.
  this.indexOfEntries=new Array();//子对象，目前只有folder
};

WebTree.prototype.init=function(openFID)
{
  // open the root folder 
  clickOnNode(this.id,0);
  if(openFID!=null && openFID!=-1)
    clickOnNode(this.id,openFID);
};

WebTree.resPath="";

WebTree.showAll=function(treeID)//显示所有节点
{
  if(treeID==null)
  {
	for(var i=0;i<webTrees.length;i++)
	{
	  if(webTrees[i]!=null)//显示第一个
	  {
		treeID=i;
		break;
	  }
	}
  }
  var tree=webTrees[treeID];
  if(tree==null)
    return;
  for(var i=0;i<tree.indexOfEntries.length;i++)
  {
    if(tree.indexOfEntries[i]!=null && tree.indexOfEntries[i].isShownChildren)//没打开子树的folder不展开。
       tree.indexOfEntries[i].setState(true);
  }
};


WebTree.collapseAll=function(treeID)//隐藏所有节点
{
  if(treeID==null)
  {
	for(var i=0;i<webTrees.length;i++)
	{
	  if(webTrees[i]!=null)//显示第一个
	  {
		treeID=i;
		break;
	  }
	}
  }
  var tree=webTrees[treeID];
  if(tree==null)
    return;
  for(var i=1;i<tree.indexOfEntries.length;i++)//根节点不能隐藏
  {
    if(tree.indexOfEntries[i]!=null)
       tree.indexOfEntries[i].setState(false);
  }
};


// Events 
// ********************************************************* 
 
/**
 * 点击folder对象。
 */
function clickOnFolder(treeID,folderID) 
{ 
  var tree=webTrees[treeID];
  if(tree==null)
    return;
  var clicked = tree.indexOfEntries[folderID]; 
  if (!clicked.isOpen) 
    clickOnNode(treeID,folderID);
} 
 
/**
 * 点击folder对应的节点。
 */
function clickOnNode(treeID,folderID) 
{ 
  var tree=webTrees[treeID];
  if(tree==null)
    return;
  clickedFolder = tree.indexOfEntries[folderID];
  if(clickedFolder==null)
  {
    return;
  }
  if(!clickedFolder.isShownChildren && !clickedFolder.isOpen)
  {
    //clickedFolder.navObj.innerHTML="loadding...";
    var url=tree.subTreeURL;
    var reqData="";
    var pos=url.indexOf("?");
    if(pos!=-1)
    {
      url=url.substring(0,pos);
      reqData=url.substring(pos+1)+"&";
    }
    reqData+="treeID="+tree.id+"&folderID="+clickedFolder.id+"&childLeftSide="+encodeURIComponent(clickedFolder.childLeftSide)+
      "&nodeValue="+encodeURIComponent(clickedFolder.value)+"&maxID="+tree.maxID;//"&clearCache="+Math.random();
    if(webTrees[treeID].otherParams!=null && webTrees[treeID].otherParams!="")
      reqData+="&otherParams="+encodeURIComponent(webTrees[treeID].otherParams);
    if(webTrees[treeID].linkProvider!=null && webTrees[treeID].linkProvider!="")
      reqData+="&linkProvider="+webTrees[treeID].linkProvider;
    if(WebTree.resPath!="")
      reqData+="&resPath="+encodeURIComponent(WebTree.resPath);

    //注意，这里不能用escape,否则会有中文乱码问题
    var xHttp=new XHttp(url);
    xHttp.method="POST";//不能用get,否则超过2048，在ie中会报未知错误。
    xHttp.reqData=reqData;
	  xHttp.async=false; 
    xHttp.callback=function(xmlHttp)
    {
      var data=xmlHttp.responseText;
      var index=data.indexOf("<treetags>");
      if(index==-1)		  
        alert("展开子树时出错，请查看系统日志!");
	  else
	  {				
        var index2=data.indexOf("</treetags>");
        var treeTags=data.substring(index+10,index2);
        index=data.indexOf("<jstags>");
        index2=data.indexOf("</jstags>");
        var jsTags=data.substring(index+8,index2);
	    if(!tree.isOpenRefresh)
          clickedFolder.isShownChildren=true;
        var subTreeLayer=document.getElementById(clickedFolder.navObj.id+"_subTree");
        if(subTreeLayer==null)
          subTreeLayer=clickedFolder.navObj;
        if(treeTags.length>0 && treeTags!="&nbsp;" || subTreeLayer.innerHTML.length>0)
        {
          subTreeLayer.innerHTML=treeTags; 
        }
        if(jsTags.length>0)
          eval(jsTags); 
	  }
    };
    xHttp.send();
    xHttp=null;
  }
  var state = clickedFolder.isOpen;
  clickedFolder.setState(!state); //open<->close 
}

/**
 * 点击链接。
 * @param treeID 树标识。
 * @param linkObj 链接对象，或ID。
 */
function clickOnTreeLink(treeID,linkObj)
{ 
  var tree=webTrees[treeID];
  if(tree==null)
    return;
  if(tree.lastLinkObj!=null)
    tree.lastLinkObj.style.background="transparent";
  if(typeof linkObj =="string")
    linkObj=document.getElementById(linkObj);
  if(linkObj==null)
    return;
  linkObj.style.background="#cccccc";
  tree.lastLinkObj=linkObj;
}

// Global variables 
// **************** 
var webTrees=new Array();

