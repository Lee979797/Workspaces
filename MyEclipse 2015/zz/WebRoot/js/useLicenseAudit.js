
//---------------------- 列表显示原文的标识 ------------------------------------
var image_window_ula = new Ext.Window({   
    id: 'image-window',   
    title : '原文浏览',   
    width : 800,   
    height : 600,   
    resizable : true,
    maximizable:true,
    closeAction :'hide',   
    layout:'border',   
    items:[{   
        xtype: 'panel',   
        region: 'center',   
        layout:'fit',   
        bodyStyle : 'background-color:#E5E3DF;',   
        frame:false,   
        border:false,
        html: '<OBJECT classid="clsid:B5306E2E-8F98-46CA-9F31-AB326B2613F1"   width=100%  height=100% align=center hspace=0 vspace=0 id="scanner2201"  name="scanner2201" >'
 	       +'<param name="ShowCount" value="1">'
 	       +'<param name="sModel" value="1">'
 	       +'</OBJECT>'    
    }],   
    buttons: [{   
	       text: '重载原文',   
	       handler: function() {
	       		var resultObject = null;
    			var record = grid_LicenseAudit.getSelectionModel().getSelected();
    			var strOrgid="";
	    		
				if(record){
		    		strOrgid=record.data.orgid
		        	/*if(strOrgid=="" || strOrgid==null){
		        		strOrgid=currentOrgid; 
		        	}*/
	    	        //alert(strOrgid);
		    		//此处原文加载时候需要优化为以上注销部分form的提交模式
		    		Ext.Ajax.request({
						url : 'orgnewViewImg.action',
						params : {orgid : strOrgid},
						method:'post', 
						success : function(result,request) {//获取返回值
						    //resultObject = eval('('+result.responseText+')');  
		   					var resultObject = Ext.util.JSON.decode(result.responseText);  
		   					scanner2201.ImageData=resultObject.imageData;
		   					scanner2201.pageTypeStr=resultObject.pageTypeStr;
						},
						failure : function() {
							alert("图像加载错误");
						}
					});
				}
	  		}   
   },{   
       text: '取消',   
       handler: function() {   
           image_window_ula.hide();   
       }   
   }],   
    listeners: {   
    	'activate' : function() {
    		var resultObject = null;
			var record = grid_LicenseAudit.getSelectionModel().getSelected();
			var strOrgid="";
    		
			if(record){
	    		strOrgid=record.data.orgid
	        	/*if(strOrgid=="" || strOrgid==null){
	        		strOrgid=currentOrgid; 
	        	}*/
	    		Ext.Ajax.request({
					url : 'orgnewViewImg.action',
					params : {orgid : strOrgid},
					method:'post', 
					success : function(result,request) {//获取返回值
	   					var resultObject = Ext.util.JSON.decode(result.responseText); 
	   					if(resultObject.imageData!=null && resultObject.imageData!=""){
							scanner2201.OpenProgress(3);  //设置上传的进度条的总进度数
							scanner2201.Progress('原文加载中',1);
							scanner2201.Progress('原文加载中',2);
		   					scanner2201.ImageData=resultObject.imageData;
	   						if(scanner2201.ImageData!=""){
	   							scanner2201.PageType=resultObject.pageTypeStr;
	   							scanner2201.Progress('原文加载完毕',3);
	   						}else{
	   							scanner2201.Progress('原文加载失败',3);
		   						alert("原文错误，加载失败，请重新扫描或导入！");
	   						}
	   						scanner2201.CloseProgress();
	   					}
					},
					failure : function() {
						alert("图像加载错误");
					}
				});	
			}
        }   
    }   
});   



function viewPic_ula(orgName,fileUrl)
{
	image_window_ula.show(); 
	image_window_ula.setTitle('原文浏览-[' + orgName + ']');    
	//scanner2201.ImageData=document.getElementById("sImageData2").value;
}

function icon_ula(value,p,record){
	if(typeof record=='object'){
		var fileUrl;
		var orgName;
		fileUrl=record.data["imageUrl"];
		orgName=record.data["jgmc"];
		if(fileUrl!=''){
			//alert(fileUrl);
			return String.format('<a style="display:table;width:100%;" onclick=viewPic_ula("'+orgName+'","'+fileUrl+'")><img src="images/file_ico.gif"></a>',record.data["orgid"]);
		}
	}  
}


//------------年检信息中，查询返回结果的数据集----------
var ds_orgnewAudit = new Ext.data.Store({
	//url : 'findAllOrgnew.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [//{name : 'orgid',type : 'int'}, 
	    {name : 'orderid',type : 'string'},
		{name : 'jgmc',type : 'string'},
		{name : 'jgdm',type : 'string'},
		/*{name : 'jglx',type : 'string'},
		{name : 'jglxdm',type : 'string'},
		{name : 'fddbr',type : 'string'}, 
		{name : 'zjlx',type : 'string'},
		{name : 'zjhm',type : 'string'}, 
		{name : 'jyfw',type : 'string'},
		{name : 'zcrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zgdm',type : 'string'},
		{name : 'zgmc',type : 'string'},
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		{name : 'xzqhCode',type : 'string'},
		{name : 'xzqhName',type : 'string'},
		{name : 'xzqhCode2',type : 'string'},
		{name : 'xzqhName2',type : 'string'},
		{name : 'jgdz',type : 'string'},
		{name : 'yzbm',type : 'string'},
		{name : 'dhhm',type : 'string'},
		{name : 'bzjgdm',type : 'string'},
		{name : 'zycp1',type : 'string'},
		{name : 'zycp2',type : 'string'},
		{name : 'zycp3',type : 'string'},
		{name : 'jjlx',type : 'string'},
		{name : 'jjlxdm',type : 'string'},
		{name : 'zczj',type : 'string'},
		{name : 'hbzl',type : 'string'},
		{name : 'hbzldm',type : 'string'},
		{name : 'wftzgb',type : 'string'},
		{name : 'wftzgbdm',type : 'string'},
		{name : 'zgrs',type : 'string'},
		{name : 'zch',type : 'string'},
		{name : 'pzwh',type : 'string'},
		{name : 'pwrq',type : 'string'},
		{name : 'email',type : 'string'},
		{name : 'weburl',type : 'string'},
		{name : 'mobile',type : 'string'},
		{name : 'yjflag',type : 'string'},
		{name : 'tbrxm',type : 'string'},
		{name : 'tbrzjlx',type : 'string'},
		{name : 'tbrsfzh',type : 'string'},
		{name : 'tbrlxfs',type : 'string'},
		{name : 'jydz',type : 'string'},
		{name : 'jyyb',type : 'string'},
		{name : 'jydh',type : 'string'},
		{name : 'jfly',type : 'string'},
		
		{name : 'jjhymc',type : 'string'},
		{name : 'jjhydm',type : 'string'},
		{name : 'gk',type : 'string'},*/
		{name : 'ywlx',type : 'string'},
		//{name : 'njrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'lrDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		/*{name : 'isxw',type : 'string'},
		{name : 'fkbz',type : 'string'},
		{name : 'fksl',type : 'int'},
		{name : 'bzrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'handleName',type : 'string'},*/
		{name : 'handleDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'auditNote',type : 'string'},
		
		/*{name : 'khyh',type : 'string'},
		{name : 'khzh',type : 'string'},
		{name : 'zsbfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zszfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'memo2',type : 'string'},
		{name : 'memo',type : 'string'},
		{name : 'name',type : 'string'},
		{name : 'username',type : 'string'},
		{name : 'imageUrl',type : 'string'},*/
		{name : 'state',type : 'string'},
		{name : 'lry',type : 'string'},
		{name : 'handleUsername',type : 'string'},
		{name : 'auditUsername',type : 'string'},
		{name : 'auditDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}}
	])
});

//----------------------点击列表信息，显示图书的扩展属性----------------------
var expander2 = new Ext.grid.RowExpander({
	tpl : new Ext.Template('<table width="100%"  border="0" cellspacing="6" cellpadding="0"  bgcolor="#DDEEF9" style="margin-top:1px;" >'
			+ '<tr>'
			+ '<td width="" colspan="4">'
			+ '<table width="98%" bgcolor="#ffffff" border="1" cellpadding="0" cellspacing="0" align="center"  bordercolordark="#FFFFFF" bordercolorlight="#6EBBE1" style="margin-top:0px;>'
			+ '<tr height="" valign="middle">'
			+ '  <td width="20%" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构名称：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgmc}<img src="images/temp.gif"></td>'
			+ '  <td width="20%" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构代码：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">小微企业：</td><td nowrap="nowrap" style="padding-top:5px">{isxw}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">年检日期：</td><td nowrap="nowrap" style="padding-top:5px">{njrq}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">法定代表人：</td><td nowrap="nowrap" style="padding-top:5px">{fddbr}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">是否公开：</td><td nowrap="nowrap" style="padding-top:5px">{gk}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证件类型：</td><td nowrap="nowrap"  style="padding-top:5px">{zjlx}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证件号码：</td><td nowrap="nowrap"  style="padding-top:5px">{zjhm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle" >'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构类型：</td><td  nowrap="nowrap" style="padding-top:5px">{jglx}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经济行业：</td><td nowrap="nowrap" style="padding-top:5px">{jjhymc} {jjhydm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经营范围：</td><td  colspan=3 style="padding-top:5px">{jyfw}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">成立日期：</td><td nowrap="nowrap" style="padding-top:5px">{zcrq}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">职工人数：</td><td nowrap="nowrap" style="padding-top:5px">{zgrs}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证照有效开始日期：</td><td nowrap="nowrap" style="padding-top:5px">{zsbfrq}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证照有效终止日期：</td><td nowrap="nowrap" style="padding-top:5px">{zszfrq}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">企业注册类型：</td><td nowrap="nowrap" style="padding-top:5px">{jjlx} {jjlxdm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">外方国别：</td><td nowrap="nowrap" style="padding-top:5px">{wftzgb} {wftzgbdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册资金：</td><td nowrap="nowrap" style="padding-top:5px">{zczj}(万)<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">货币种类：</td><td nowrap="nowrap" style="padding-top:5px">{hbzl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">主管部门：</td><td nowrap="nowrap" style="padding-top:5px">{zgmc} {zgdm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">批准机构：</td><td nowrap="nowrap" style="padding-top:5px">{pzjgmc} {pzjgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册号：</td><td nowrap="nowrap" style="padding-top:5px">{zch}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">邮政编码：</td><td nowrap="nowrap" style="padding-top:5px">{yzbm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册地址：</td><td nowrap="nowrap" style="padding-top:5px">{jgdz}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">行政区划：</td><td nowrap="nowrap" style="padding-top:5px">{xzqhName} {xzqhCode}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">联系电话：</td><td nowrap="nowrap" style="padding-top:5px">{dhhm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">电子信箱：</td><td nowrap="nowrap" style="padding-top:5px">{email}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">是否发卡：</td><td nowrap="nowrap" style="padding-top:5px">{fkbz}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">发卡数量：</td><td nowrap="nowrap" style="padding-top:5px">{fksl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">办证日期：</td><td nowrap="nowrap" style="padding-top:5px">{bzrq}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">作废日期：</td><td nowrap="nowrap" style="padding-top:5px">{zfrq}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人：</td><td nowrap="nowrap" style="padding-top:5px">{tbrxm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件类型：</td><td nowrap="nowrap" style="padding-top:5px">{tbrzjlx}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件号码：</td><td nowrap="nowrap" style="padding-top:5px">{tbrsfzh}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人电话：</td><td nowrap="nowrap" style="padding-top:5px">{tbrlxfs}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核人：</td><td nowrap="nowrap" style="padding-top:5px">{handleName}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核时间：</td><td nowrap="nowrap" style="padding-top:5px">{handleDate}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核意见：</td><td  colspan=3 style="padding-top:5px">{auditNote}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '</table>'
			+ '</td></tr></table>')
});
function formatJgdm(jgdmValue)
{
   var ss1 = jgdmValue.substr(0, 8); 
   var ss2 =jgdmValue.substr(8, 1);
   var sss=ss1+"-"+ss2
	return(sss);
}
var btn_print_orgnewAudit = new Ext.Button({
	text : '打印受理通知单',
	disabled : true,
	iconCls : 'icon-print',
	handler : function() {
		//alert('打印');
		pagesetup_null();
		var record=grid_LicenseAudit.getSelectionModel().getSelected();
		//alert(record.data.orderid);
		if(record){
			var titleHTML = printNjStr(record); 
			var newwin = window.open('printer.jsp', 'printWindow', 'menubar=yes,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no,titlebar=yes,z-look=yes,menubar=yes');     
			newwin.document.write(titleHTML); 
		}
	}
});

function printNjStr(record){//申请单模版
	var year = record.data.lrDate.substring(0,4);
	var tableStr = '';	
	tableStr = '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">';
	tableStr = tableStr + '<html xmlns="http://www.w3.org/1999/xhtml"><head>';
	tableStr = tableStr + '<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />';
	tableStr = tableStr + '<title>无标题文档</title><style type="text/css">@media print{INPUT {display:none}}';
	tableStr = tableStr + '.STYLE1 {font-family: "方正小标宋简体"; font-size: 30px; font-weight: bold;}';
	tableStr = tableStr + '.STYLE2 {font-family: "楷体_GB2312"; font-size: 22px}';
	tableStr = tableStr + '.STYLE3 {font-family: "宋体"; font-size: 16px}';
	tableStr = tableStr + '.STYLE4 {font-family: "楷体_GB2312"; font-size: 16px; font-weight: bold;}';
	tableStr = tableStr + '</style></head><body><table height="10" align="center"><tr><td>&nbsp;</td></tr></table>';
	tableStr = tableStr + '<table width="699" height="622" border="0" align="center">';
	tableStr = tableStr + '  <tr><td height="111"><table width="600" height="50" border="0" align="center">';
	tableStr = tableStr + '      <tr><td width="600" height="20" align="center"><p class="STYLE1" >武汉市组织机构代码证书网上'+record.data.ywlx+'</p></td></tr>';
	tableStr = tableStr + '      <tr><td height="20" align="center"><span class="STYLE1" >核准通知书</span></td></tr>';
	tableStr = tableStr + '	  <tr><td height="20" align="left"><span id="disnone"><input type="button" name="print" value="打印" onclick="reportPrint();" /></span>';
	tableStr = tableStr + '	  </td></tr></table></td></tr>';
	tableStr = tableStr + '  <tr><td height="370" align="center">';
	tableStr = tableStr + '	<div style="background-image:url(images/nj.jpg); background-position:center; background-repeat:no-repeat; filter:alpha(opacity=30);">';
	tableStr = tableStr + '	<table width="600" height="369" border="0" style="position:relative;">';
	tableStr = tableStr + '      <tr><td width="295">&nbsp;</td><td width="295" align="left"><span class="STYLE2">业务号：'+record.data.orderid+'</span></td></tr>';
	if(record.data.ywlx=='新办'){
		tableStr = tableStr + '      <tr><td>&nbsp;</td><td width="295" align="left"><p class="STYLE2"></p></td></tr>';
	}else{
		tableStr = tableStr + '      <tr><td>&nbsp;</td><td width="295" align="left"><p class="STYLE2">组织机构代码：'+formatJgdm(record.data.jgdm)+'</p></td></tr>';
	}
	tableStr = tableStr + '      <tr><td colspan="2" align="left"><span class="STYLE2">'+record.data.jgmc+'：</span></td></tr>';
	tableStr = tableStr + '      <tr><td colspan="2" align="left">';
	tableStr = tableStr + '		  <p class="STYLE2" >&nbsp;&nbsp;&nbsp;&nbsp;经审核，你单位于'+dateFormatToYMD(record.data.lrDate)+'提交的武汉市组织机构</p>';
	tableStr = tableStr + '		  <p class="STYLE2" >代码中心网上'+record.data.ywlx+'申请材料齐全、内容完整准确。</p>';
	if(record.data.ywlx=='年检'){
		tableStr = tableStr + '      <p class="STYLE2" >&nbsp;&nbsp;&nbsp;&nbsp;现我中心就您单位提供的年检申请材料对你单位做出<span style="font-weight: bold;"></span></p>';
		tableStr = tableStr + '		  <p class="STYLE2" ><span style="font-weight: bold;">'+year+'年组织机构代码年检通过</span>的决定。</p></td></tr>';
	}else if(record.data.ywlx=='新办'){
		tableStr = tableStr + '      <p class="STYLE2" >&nbsp;&nbsp;&nbsp;&nbsp;现我中心就您单位提供的新办申请材料请于三个工作日</p>';
		tableStr = tableStr + '      <p class="STYLE2" >后，持本通知书和网上所提交资料原件到所属发证单位领取新</p>';
		tableStr = tableStr + '		  <p class="STYLE2" >证及缴费。</p></td></tr>';
	}else{
		tableStr = tableStr + '      <p class="STYLE2" >&nbsp;&nbsp;&nbsp;&nbsp;现我中心就您单位提供的'+record.data.ywlx+'申请材料请于三个工作日</p>';
		tableStr = tableStr + '      <p class="STYLE2" >后，持本通知书和代码证书全套(正本、副本、IC卡或数字证</p>';
		tableStr = tableStr + '		  <p class="STYLE2" >书)到原发证单位领取新证及缴费。</p></td></tr>';
	}
	tableStr = tableStr + '		<tr><td height="34">&nbsp;</td><td width="295">&nbsp;</td></tr>';
	tableStr = tableStr + '      <tr><td>&nbsp;</td><td width="295" align="center"><p class="STYLE2" >&nbsp;</p></td></tr>';
	tableStr = tableStr + '      <tr><td>&nbsp;</td><td width="295" align="center"><span class="STYLE2">'+bfdw+'</span></td></tr>';
	tableStr = tableStr + '      <tr><td>&nbsp;</td><td width="295" align="center"><p class="STYLE2">'+dateFormatToYMD(myDate.format('Y-m-d'))+'</p></td>';
	tableStr = tableStr + '      </tr></table></div></td></tr>';
	tableStr = tableStr + '  <tr><td height="133" align="center"><table width="600" height="111" border="0">';
	tableStr = tableStr + '      <tr><td width="590" align="left"><p class="STYLE3" >免责声明:</p></td></tr>';
	tableStr = tableStr + '      <tr><td align="left"><span class="STYLE4" >1.本通知书仅就行政对象提交组织机构代码证书网上'+record.data.ywlx+'申请材料做出决定。</span></td></tr>';
	tableStr = tableStr + '      <tr><td align="left"><span class="STYLE4" >2.本通知书可在武汉市组织机构代码管理中心网站(www.sxdm.org.cn)进行查询确认。</span></td></tr>';
	if(record.data.ywlx=='年检'){
		tableStr = tableStr + '      <tr><td align="left"><span class="STYLE4" >3.本通知书可作为行政对象组织机构代码证书年度检验通过的证明，如需为证书加盖年检戳记，请持本通知书和代码证书全套到原发证单位办理。</span></td>';
	}
	tableStr = tableStr + '      </tr></table></td></tr></table><script language="JavaScript">function reportPrint(){window.location.reload();window.print();}</script></body></html>';
	
	return String.format(tableStr);
}

var btn_refresh_orgnewAudit = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		searchOrgnewAudit();
	}
});
    
var text_search_orgnewAudit = new Ext.form.TextField({
	id : 'textSearchOrgnewAudit',
	name : 'textSearchOrgnewAudit',
	hidden:true,
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchOrgnewAudit();
			}
		}
	}
});

//--------------------- 默认查询 limit为显示的条数 ---------------------- 
var searchOrgnewAudit = function() {
	ds_orgnewAudit.proxy = new Ext.data.HttpProxy({
		url : 'findAllOrgnew.action'
	});
	if(currentJgdm==''){
		ds_orgnewAudit.baseParams.conditions = currentJgmc;
	}else{
		ds_orgnewAudit.baseParams.conditions = currentJgdm;
	}
	ds_orgnewAudit.baseParams.stateConditions='2,3,4,5,6';
	ds_orgnewAudit.load({
		params : {start : 0,limit : 2},
		callback: function(records, options, success){
			//alert(records.length);
			if(records==null||records.length==0){//records[0].data.flag
				ds_orgnewAudit.proxy = new Ext.data.HttpProxy({
					url : 'findOrgwsrzByConditions.action'
				});
				if(currentJgdm==''){
					ds_orgnewAudit.baseParams.conditions = currentJgmc;
				}else{
					ds_orgnewAudit.baseParams.conditions = currentJgdm;
				}
				ds_orgnewAudit.reload({
					params : {start : 0,limit : 2}
				});
			}
		}
	});
	
};


//---------------------- 列表显示主要数据信息 -------------------------
//列表显示机构的主要信息 yangqi
var sm2 = new Ext.grid.CheckboxSelectionModel();
var cm_orgnew = new Ext.grid.ColumnModel([/*expander2,*/
	sm2,
	//{header : '原文',width : 20,dataIndex : 'imageUrl', renderer:icon_ula,sortable : false},
	{header : '机构代码',width : 40,dataIndex : 'jgdm',sortable : true}, 
	{header : '机构名称',width : 100,sortable : true,dataIndex : 'jgmc'},
	//{header : '法定代表人/负责人',width : 60,dataIndex : 'fddbr',sortable : true}, 
	//{header : '经办人姓名',width : 40,dataIndex : 'tbrxm',id : 'tbrxm',sortable : true},
	{header : '业务类型',width : 30,dataIndex : 'ywlx',sortable : true},
	{header : '录入时间',width : 60,dataIndex : 'lrDate',sortable : true},
	{header : '审核意见',width : 60,dataIndex : 'auditNote',sortable : true},
	{header : '申请状态',width : 60,dataIndex : 'state',renderer : goState,menuDisabled : true}
]);


//---------------------- 加载右栏主页面   （数据列表、工具栏按钮）---------------------- 
var grid_LicenseAudit = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	//autoHeight : true,
	border:false,
	cm : cm_orgnew,
	ds : ds_orgnewAudit,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'address',
	viewConfig : {forceFit : true},
	plugins : expander2,
	tbar : [btn_refresh_orgnewAudit,'|',btn_print_orgnewAudit],
	bbar : new Ext.PagingToolbar({
		pageSize : 10,
		store : ds_orgnewAudit,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			if(grid.getStore().getAt(rowIndex).data.state == 5||grid.getStore().getAt(rowIndex).data.state == 6||grid.getStore().getAt(rowIndex).data.state == null||grid.getStore().getAt(rowIndex).data.state == ''){
				btn_print_orgnewAudit.setDisabled(false);
			}
		}
	}
});


//******************************************************************************
//*
//*   主界面                                                                                                                                                      *
//*
//******************************************************************************

var auditTjForm = {
		title: '请检查信息并提交审核',
	    layout: 'fit',
	    frame: true,
	    id: 'CardWizard4',
	    border:false,
	    items: [grid_LicenseAudit]   
};

var p_useLicenseAudit = {
	id: 'useLicenseAudit-panel',
	iconCls : 'icon-plugin',
	layout : 'fit',
	title: '信息查询',
	//border:false,
	items:[grid_LicenseAudit],
	listeners : {
		'activate' : function() {  //标签激活后自动加载数据
				text_search_orgnewAudit.value='';
				searchOrgnewAudit();
				btn_return_orgnew.setDisabled(true);
		},
		'tabchange' : function() {
			   //alert('成功'+userstate+'吗！')
			var tab2=Ext.getCmp("centerPanel2");
			//if(userstate=="12"||userstate=="14"||userstate=="15"){
			if(userstate=="12"||userstate=="15"){
				tab2.remove("auditTab");   //移除标签
				tab2.remove("auditScTab");   //移除标签
				tab2.remove("auditPtTab");   //移除标签
				//tab2.remove("auditForm");  //移除标签
				
			}
		}
	}
}

