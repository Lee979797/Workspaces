
/**
 * XHttp对象,在调用send后，通过设定XHttp.callback(xmlHttp)来执行显示操作.
 * @param _url 发送的URL。
 * @param _async 是否同步。
 * @param _method POST或GET.
 */
function XHttp(url,async,method)
{ 
  this.xmlHttp = PubUtil.createXMLHttp(); 
  this.url=url;
  
  this.async=true; 
  if(async)
    this.async=async;

  //采用post时，要用UTF-8编码，采用get方法，设置编码无效。
  this.charset="UTF-8";  

  this.contentType="";

  this.method="POST";
  if(method!=null)
    this.method=method;

  this.reqData=null;   
};

XHttp.prototype.callback=function(xmlHttp){};

XHttp.prototype.send=function()
{ 
  var method=null;
  if(this.method.toLowerCase()=="get")
    method="GET";//IE5,TOMCAT中，如果用小写，则会报错，提示找不到get
  else
    method="POST";
  this.xmlHttp.open(method, this.url, this.async); 
  var _contentType="";
  if(this.contentType==null || this.contentType=="")
  {
    if(method=="POST")
      contentType="application/x-www-form-urlencoded";
    else
      contentType="text/xml";
  }
  else
    contentType=this.content;
  if(this.charset!=null && this.charset!="")
    contentType+=";charset="+this.charset;
  this.xmlHttp.setRequestHeader("Content-type", contentType); 
  var xmlHttp=this.xmlHttp;
  var me=this;
  if (this.async) 
    this.xmlHttp.onreadystatechange=function()
    { 
      if (xmlHttp.readyState == 4)
      { 
        me.callback(xmlHttp);
        xmlHttp=null;
        me=null;
      } 
    };
  else 
    this.xmlHttp.onreadystatechange=function(){}
  this.xmlHttp.send(this.reqData); 
  if (!this.async)
    this.callback(this.xmlHttp);
};





