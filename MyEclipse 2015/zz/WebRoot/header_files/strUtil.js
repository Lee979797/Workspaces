
StrUtil=function StrUtil(){};

/**
 * Trim both of leading spaces and trailing spaces.
 * @param val orig String.
 */
StrUtil.trim=function( val )
{
  return StrUtil.rTrim( StrUtil.lTrim( val ) );
};

/**
 * Trim leading spaces.
 * @param val orig String.
 */
StrUtil.lTrim=function( val )
{
  while( '' + val.charAt(0)==' ' || val.charCodeAt(0)==160 )
  {
    val = val.substring(1,val.length);
  }
  return val;
};

/**
 * Trim trailing spaces.
 * @param val orig String.
 */
StrUtil.rTrim=function( val )
{
  while( '' + val.charAt(val.length-1)==' ' || val.charCodeAt(val.length-1)==160)
  {
    val = val.substring(0,val.length-1)
  }
  return val;
};

/**
 * 求给定字符串的字节长度。
 * @param val 给定值。
 * @return 值的字节长度。
 */
StrUtil.byteLen=function(val)
{
  if(val==null)
    return 0;
  var l=0;
  for(var i=0;i<val.length;i++)
  {
    if(val.charCodeAt(i)<19968)
      l++;
    else
      l+=2;
  }
  return l;
};

/**
 * 替换字符串中所有的指定串。
 * @param str 字符串。
 * @param search 要查找的字符串。
 * @param replace 替换的字符串。
 * @return 替换后的字符串。
 */
StrUtil.replaceAll=function(str,search,replace)
{
  var tempStr=str;
  var str=str.replace(search,replace); //默认只匹配第一个。
  while(str!=tempStr)
  {
    tempStr=str;
    str=str.replace(search,replace);
  }
  return str;
};


/**
 * 判断str是否以str2开头。
 * @param str 字符串。
 * @param str2 字符串2。
 * @param isIgnCase 替换的字符串。
 * @return 替换后的字符串。
 */
StrUtil.startsWith=function(str,str2,isIgnCase)
{   
   if(str==null || str2==null)
	 return false;
   if(str.length<str2.length)
	 return false;
   if(isIgnCase!=null && isIgnCase)
   {
	 str=str.toLowerCase();
	 str2=str2.toLowerCase();
   }
   return str.substring(0,str2.length)==str2;
};

