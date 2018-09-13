
Constants=function Constants()
{
}

//判断浏览器类型
Constants.isIE = ( /msie/i.test(navigator.userAgent) && !/opera/i.test(navigator.userAgent) );
Constants.isIE5 = ( Constants.isIE && /msie 5\.0/i.test(navigator.userAgent) );
Constants.isOpera= /opera/i.test(navigator.userAgent);
Constants.isKHtml = /Konqueror|Safari|KHTML/i.test(navigator.userAgent);
Constants.isFirefox= /Firefox/i.test(navigator.userAgent);
Constants.isNS= /Netscape/i.test(navigator.userAgent);


Constants.contextRoot="";//当前WEB的contextRoot，如果是默认应用，值为"",不要写成"/"

Constants.repListBgColor1="#EDF3FF";//列表式报表奇数行背景色
Constants.repListBgColor2="#DEEBF7";//列表式报表偶数行背景色

Constants.constReady="就绪";
Constants.defaultCharset="UTF-8";

Constants.opIntervalLimit=1000;//操作间隔限制