
/**
 * Select用js函数。
 */
SelectUtil=function SelectUtil(){};

SelectUtil.fakeLine="__________";

/**
 * 初始化select object.
 * @param selObj select对象。
 */
SelectUtil.initSelObj=function(selObj)
{
  // Remove predefined option width cuz Netsape can't resize option width
  if( selObj.options[0].text == SelectUtil.fakeLine )
  {
    selObj.options[0] = null;
  }
};

/**
 * move items from on Select object to another.
 * @param fromObj 源select对象。
 * @param toObj 目标select对象。
 * @param isDelOrig 是否删除源select对象中的选定的项。
 */
SelectUtil.moveOpt=function(fromObj,toObj,isDelOrig)
{
  // Don't do if 1) nothing selected 2) no items in list
  if( fromObj.selectedIndex != -1 && fromObj.length > 0)
  {
    // Must loop in reverse order to prevent miscounting length
    //for( h=here.length-1;h>-1; h-- ) {
    for( h=0; h<fromObj.length;h++)
    {
      if( fromObj.options[h].selected )
      {
        SelectUtil.addOpt( toObj, fromObj.options[h].value, fromObj.options[h].text );
      }
    }
	if(isDelOrig==null || isDelOrig==true)
	{
      // This second pass is need to preserve order of transfer, else if removal is in above code, the transfer would be in reverse
      for( h1=fromObj.length-1;h1>-1; h1-- )
      {
        if( fromObj.options[h1].selected )
        {
          fromObj.options[h1] = null;
        }
      }
	}
  }
};

/**
 * remove items from select object.
 * @param selObj select对象。
 */
SelectUtil.delOpt=function(selObj)
{
  for(var i=selObj.length-1;i>-1;i--)
  {
    if(selObj.options[i].selected)
    {
      selObj.options[i]=null; 
    }
  }
};

/**
 * move selected option up。
 * @param selObj select对象。
 */
SelectUtil.moveUp=function(selObj)
{
  // Don't do if 1) already at top 2) no item selected OR 3) not enough items available
  if( selObj.selectedIndex != 0 && selObj.selectedIndex != -1 && selObj.length > 1)
  {
    var selIdx = selObj.selectedIndex;
    var selVal = selObj.options[selIdx].value;
    var selText = selObj.options[selIdx].text;
    var aboveVal = selObj.options[selIdx-1].value;
    var aboveText = selObj.options[selIdx-1].text;
	
	
    // Swap values
    SelectUtil.addOpt( selObj, selVal, selText, selIdx-1, true );
    SelectUtil.addOpt( selObj, aboveVal, aboveText, selIdx );
  }
};

/**
 * move selected option down.
 * @param selObj select对象。
 */
SelectUtil.moveDown=function(selObj)
{
  // Don't do if 1) already at bottom 2) no item selected OR 3) not enough items available
  if( selObj.selectedIndex != selObj.length-1 && selObj.selectedIndex != -1 && selObj.length > 1)
  {
    var selIdx = selObj.selectedIndex;
    var selVal = selObj.options[selIdx].value;
    var selText = selObj.options[selIdx].text;
    var belowVal = selObj.options[selIdx+1].value;
    var belowText = selObj.options[selIdx+1].text;
	
    // Swap values
    SelectUtil.addOpt( selObj, selVal, selText, selIdx+1, true );
    SelectUtil.addOpt( selObj, belowVal, belowText, selIdx );
  }
};

/**
 * add select's option.
 * @param selObj select对象。
 * @param val option's val.
 * @param text option's text.
 * @param idx 插入的位置,不提供或-1,插入最后。　
 * @param selected 是否选中。
 */
SelectUtil.addOpt=function(selObj, val, text, idx, selected)
{
  if( selected == null )
    selected = false;
  if( idx != null && idx!=-1)
  { // Insert at index
    selObj.options[idx] = new Option( text, val, false, selected );
  }
  else
  { // New add
    selObj.options[selObj.length] = new Option( text, val, false, selected );
  }
};

/**
 * remove select's option.
 * @param selObj select对象。
 * @param idx option's index.
 */
SelectUtil.removeOpt=function( selObj, idx )
{
  selObj.options[idx] = null;
};

/**
 * select all options.
 * @param selObj select对象。
 */
SelectUtil.selectAll=function(selObj)
{
  // Need to select all options on both sides before submitting or else 'null' values will result
  for( a=0; a<selObj.length; a++ )
  {
    selObj.options[a].selected = true;
  }
};


/**
 * sort select's options.
 * @param selObj select对象。
 */
SelectUtil.sortSelect=function(selObj)
{
  var valueArr=new Array(selObj.length);
  var textArr=new Array(selObj.length);
  for(var i=0;i<valueArr.length;i++)
  {
    valueArr[i]=selObj.options[i].value;
    textArr[i]=selObj.options[i].text;
  }
  var isAllNum=true;
  for(var i=0;i<valueArr.length;i++)
  {
    if(isNaN(valueArr[i]))
    {
      isAllNum=false;
      break;
    }	
  }
  var valueTemp=null;
  var textTemp=null;
  for(var i=0;i<valueArr.length-1;i++)
  {
    for(j=valueArr.length-1;j>i;j--)
    {
      var value1=(isAllNum?parseInt(valueArr[j]):valueArr[j]);
      var value2=(isAllNum?parseInt(valueArr[j-1]):valueArr[j-1]);
      if(value1<value2)
      {
        valueTemp=valueArr[j];
        valueArr[j]=valueArr[j-1];
        valueArr[j-1]=valueTemp;
        textTemp=textArr[j];
        textArr[j]=textArr[j-1];
        textArr[j-1]=textTemp;
      }
    }
  }
  for(var i=0;i<selObj.length;i++)
  {
    selObj.options[i].value=valueArr[i];
    selObj.options[i].text=textArr[i];
  }
}

/**
 * reset select's options.
 * @param selObj select's instance.
 * @param values select's values,Array.
 * @param descs select's descriptions.
 */
SelectUtil.resetOpts=function(selObj,values,descs)
{
  var origValue=selObj.value;
  for(var i=0;i<values.length;i++)
  {
    var selected=(values[i]==origValue);
    if(selObj.options.length<i+1)
      SelectUtil.addOpt(selObj,values[i],descs[i],-1,selected);
    else
    {
      selObj.options[i].value=values[i];
      selObj.options[i].text=descs[i];
      selObj.options[i].selected=selected;
    }
  }
  for(var i=selObj.options.length-1;i>=values.length;i--)
  {    
    selObj.options[i]=null;   
  }
}
