
//-----------------------点击列表信息，显示图书的扩展属性-----------------------
var expander87 = new Ext.grid.RowExpander({
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
			+ '<tr height="" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">企业简介：</td><td  colspan=3 style="padding-top:5px">{qyjj}<img src="images/temp.gif"></td>'
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
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注 册 号：</td><td nowrap="nowrap" style="padding-top:5px">{zch}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">联系电话：</td><td nowrap="nowrap" style="padding-top:5px">{dhhm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构注册地址：</td><td  colspan=3 style="padding-top:5px">{jgdz}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">行政区划：</td><td nowrap="nowrap" style="padding-top:5px">{xzqhName} {xzqhCode}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">邮政编码：</td><td nowrap="nowrap" style="padding-top:5px">{yzbm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构实际地址：</td><td  colspan=3 style="padding-top:5px">{jydz}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">行政区划：</td><td nowrap="nowrap" style="padding-top:5px">{xzqhName2} {xzqhCode2}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">邮政编码：</td><td nowrap="nowrap" style="padding-top:5px">{jyyb}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">电子信箱：</td><td nowrap="nowrap" style="padding-top:5px">{email}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">网&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</td><td nowrap="nowrap" style="padding-top:5px">{weburl}<img src="images/temp.gif"></td>'
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
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经 办 人：</td><td nowrap="nowrap" style="padding-top:5px">{tbrxm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件类型：</td><td nowrap="nowrap" style="padding-top:5px">{tbrzjlx}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件号码：</td><td nowrap="nowrap" style="padding-top:5px">{tbrsfzh}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人电话：</td><td nowrap="nowrap" style="padding-top:5px">{tbrlxfs}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">办 理 人：</td><td nowrap="nowrap" style="padding-top:5px">{handleName}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">办理时间：</td><td nowrap="nowrap" style="padding-top:5px">{handleDate}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审 核 人：</td><td nowrap="nowrap" style="padding-top:5px">{auditName}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核时间：</td><td nowrap="nowrap" style="padding-top:5px">{auditDate}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核意见：</td><td  colspan=3 style="padding-top:5px">{auditNote}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '</table>'
			+ '</td></tr></table>')
});


//--------------------图片浏览窗口-------------------------------------------
var imageView_window_licenseArchive = new Ext.Window({   
    id: 'image-window_7007',   
    title : '原文预览',   
    width : 900,   
    height : 600,   
    resizable : true, 
    maximizable:true,
    closeAction :'hide',
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"   width=100%  height=100% align=center hspace=0 vspace=0 id="scanner7007"  name="scanner7007" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>',
    buttons: [{   
	       text: '重载',   
		       handler: function() { 
		       	   scanner7007.ImageData="";
		    	   var record = grid_LicenseArchive.getSelectionModel().getSelected();
				   var resultObject = null;
				   var useState=record.data.state;
				   var	imgUrl='';
					imgUrl='tjgdmViewImg.action';

		    		Ext.Ajax.request({
						url : imgUrl,
						params : {orgid : record.data.orgid},
						success : function(result,request) {//获取返回值
							var resultObject = Ext.util.JSON.decode(result.responseText);
							if(resultObject!=null){
								scanner7007.OpenProgress(3);  //设置上传的进度条的总进度数
								scanner7007.Progress('原文加载中',1);
								scanner7007.Progress('原文加载中',2);
							    //resultObject = eval('('+result.responseText+')');  
			   					scanner7007.ImageData=resultObject.imageData;
		   						if(scanner7007.ImageData!=""){
		   							scanner7007.PageType=resultObject.pageTypeStr;
		   							scanner7007.Progress('原文加载完毕',3);
		   							alert("档案加载完毕！");
		   						}else{
		   							scanner7007.Progress('原文加载失败',3);
			   						alert("原文错误，加载失败，请重新扫描或导入！");
		   						}
		   						scanner7007.CloseProgress();
							}
						},
						failure : function() {
							alert("图像加载错误");
						}
					});
		       }
	   },{   
	        text: '取消',   
	        handler: function() {   
	            imageView_window_licenseArchive.hide();   
	        }
	   }],
	   listeners : {
			'activate' : function() {  //标签激活后自动加载数据
				scanner7007.ImageData="";
				var record = grid_LicenseArchive.getSelectionModel().getSelected();
				var resultObject = null;
				var useState=record.data.state;
				var	imgUrl='';

				imgUrl='tjgdmViewImg.action';
	    		Ext.Ajax.request({
					url : imgUrl,
					params : {orgid : record.data.orgid},
					success : function(result,request) {//获取返回值
						var resultObject = Ext.util.JSON.decode(result.responseText);
						if(resultObject!=null){
							scanner7007.OpenProgress(3);  //设置上传的进度条的总进度数
							scanner7007.Progress('原文加载中',1);
							scanner7007.Progress('原文加载中',2);
						    //resultObject = eval('('+result.responseText+')');  
		   					scanner7007.ImageData=resultObject.imageData;
	   						if(scanner7007.ImageData!=""){
	   							scanner7007.PageType=resultObject.pageTypeStr;
	   							scanner7007.Progress('原文加载完毕',3);
		   						scanner7007.CloseProgress();
		   						alert("档案加载完毕！");
	   						}else{
	   							scanner7007.Progress('原文加载失败',3);
		   						scanner7007.CloseProgress();
		   						alert("原文错误，加载失败，请重新扫描或导入！");
	   						}
						}
					},
					failure : function() {
						alert("图像加载错误");
					}
				});
			}
		}
    
});   

//---------------------- 弹出浏览原文的窗口 ------------------------------------
function viewPic_licenseArchive()
{
	imageView_window_licenseArchive.show(); 
	imageView_window_licenseArchive.setTitle('原文预览');
}
//---------------------- 列表显示原文的标识 ------------------------------------
function icon_licenseArchive(value,p,record){
	
	if(typeof record=='object'){
		var fileUrl;
		fileUrl=record.data["imageData"];
		//alert(fileUrl);
		if(fileUrl!=''){
			return String.format('<a style="display:table;width:100%;" onclick="viewPic_licenseArchive()"><img src="images/file_ico.gif"></a>',record.data["orgid"]);
		}
	}  
}

//代码状态
function goState_archive(value,p,record)
{
   var stateValue;
   stateValue=record.data["state"]; 
   if(typeof stateValue!=''){
		   return String.format('已归档案');
   }
}

//---------------------- 列表显示主要数据信息 ----------------------------------
// 列表显示机构的主要信息 yangqi
var sm2 = new Ext.grid.CheckboxSelectionModel();
var cm_orgnew = new Ext.grid.ColumnModel([expander87,
	sm2,
	{header : '原文',width : 20,dataIndex : 'imageUrl', renderer:icon_licenseArchive,sortable : false},
	//{header : '流水号',width : 60,dataIndex : 'orderid',sortable : true},
	{header : '机构代码',width : 60,sortable : true,dataIndex : 'jgdm'},
	{header : '机构名称',width : 180,sortable : true,dataIndex : 'jgmc'},
	{header : '法定代表人/负责人',width : 80,dataIndex : 'fddbr',sortable : true}, 
	{header : '经办人姓名',width : 40,dataIndex : 'tbrxm',sortable : true},
	{header : '审核人',	width : 50,dataIndex : 'handleName',sortable : true},
	{header : '业务类型',width : 40,dataIndex : 'ywlx',sortable : true},
	{header : '申请状态',width : 150,dataIndex : 'state',renderer : goState_archive,menuDisabled : true}
]);


var ds_user_select = new Ext.data.Store({
	url : 'findUserByExample.action',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'userId',type : 'int'}, 
		{name : 'emplName',type : 'string'}
	])
})



//默认查询 limit为显示的条数
var searchOrgnewArchive = function() {
	ds_orgnewArchive.baseParams.conditions = text_search_orgnewArchive.getValue();
	ds_orgnewArchive.baseParams.username='';
	ds_orgnewArchive.baseParams.userBzjgdm=currentZzUserBzjgdm;
	ds_orgnewArchive.baseParams.stateConditions='';
	ds_orgnewArchive.load({params : {start : 0,limit : useFullPageSize} });

}

//查询返回结果的数据列
var ds_orgnewArchive = new Ext.data.Store({
	url : 'findAllTjgdm.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'orgid',type : 'int'}, 
	    {name : 'orderid',type : 'string'}, 
	    {name : 'centerid',type : 'string'},
		{name : 'jgmc',type : 'string'},
		{name : 'jgdm',type : 'string'},
		{name : 'jglx',type : 'string'}, 
		{name : 'jglxdm',type : 'string'}, 
		{name : 'jglxOld',type : 'string'}, 
		{name : 'jglxdmOld',type : 'string'}, 
		{name : 'fddbr',type : 'string'}, 
		{name : 'zjlx',type : 'string'},
		{name : 'zjlxdm',type : 'string'},
		{name : 'zjhm',type : 'string'}, 
		{name : 'qyjj',type : 'string'},
		{name : 'jyfw',type : 'string'},
		{name : 'zcrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zgdm',type : 'string'},
		{name : 'zgmc',type : 'string'},
		{name : 'jjhymc',type : 'string'},
		{name : 'jjhydm',type : 'string'},
		{name : 'jjlx',type : 'string'},
		{name : 'jjlxdm',type : 'string'},
		{name : 'gk',type : 'string'},
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
		{name : 'tbrsfzh',type : 'string'},
		{name : 'tbrlxfs',type : 'string'},
		{name : 'jydz',type : 'string'},
		{name : 'jyyb',type : 'string'},
		{name : 'jydh',type : 'string'},
		{name : 'jfly',type : 'string'},
		{name : 'khyh',type : 'string'},
		{name : 'khzh',type : 'string'},
		{name : 'zsbfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zszfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zslsh',type : 'string'},
		{name : 'bzrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'tbrzjlx',type : 'string'},
		{name : 'memo2',type : 'string'},
		{name : 'memo',type : 'string'},
		{name : 'name',type : 'string'},
		{name : 'dybz',type : 'string'},
		
		{name : 'njrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'njqx',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'isxw',type : 'string'},
		{name : 'fkbz',type : 'string'},
		{name : 'fksl',type : 'int'},
		
		{name : 'username',type : 'string'},
		{name : 'handleName',type : 'string'},
		{name : 'handleDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'handleNote',type : 'string'},
		{name : 'auditName',type : 'string'},
		{name : 'auditDate',type : 'date',convert:function(v){if(v) return v.substring(0,16);}},
		{name : 'auditNote',type : 'string'},
		{name : 'fbsl',type : 'int'},
		{name : 'moveoutAddrss',type : 'string'},
		{name : 'moveoutReason',type : 'string'},
		{name : 'offPzjgmc',type : 'string'},
		{name : 'offPzwh',type : 'string'},
		{name : 'offReason',type : 'string'},
		{name : 'offNote',type : 'string'},
		{name : 'imageUrl',type : 'string'},
		{name : 'ywlx',type : 'string'},
		{name : 'state',type : 'string'}
	])
});

var btn_search_orgnewArchive = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchOrgnewArchive();
		//btn_add_orgnewArchive.setDisabled(false);
		//btn_edit_orgnewArchive.setDisabled(true);
		//btn_return_orgnewArchive.setDisabled(false);
	}
});

var btn_refresh_orgnewArchive = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchOrgnewArchiveid.value='';
		searchOrgnewArchive();
		//btn_add_orgnewArchive.setDisabled(false);
		//btn_edit_orgnewArchive.setDisabled(true);
		//btn_return_orgnewArchive.setDisabled(true);
	}
});

function formatToGk(str){
	if(str!=null  && str!=""){
		if(str=='是'){
			return '否';
		}
		return '是';
	}else{
		return '否';
	}
}

function returnNjqx(str){
	if(str){
		var d1 = new Date(Date.parse(str.replace(/-/g,"/")));
		var d2 = new Date();
		if(d1<d2){
			return '是';
		}else{
			return '否';
		}
	}else{
		return '';
	}
}

var btn_prt_orgnewArchive = new Ext.Button({
	text : '打印信息查询表',
	iconCls : 'icon-print',
	handler : function(){
		var record20 = grid_LicenseArchive.getSelectionModel().getSelected();
		//alert(record20.data.jgdm);
		if(record20){
			
			var tableStr = '<html><head><title>中华人民共和国组织机构代码证---信息查询表打印</title><style type="text/css"> ';
			tableStr = tableStr + '.xiahua2 { border-bottom:1px #000000 solid; padding:2px; font-size:13px; }';
			tableStr = tableStr + '.STYLE4 {font-size: 30px;font-weight: bold;} .STYLE5 {font-size: 12px}';
			tableStr = tableStr + '.STYLE12 {font-size: 16px;font-weight: bold;} .STYLE16 {border-bottom: 1px #000000 solid; padding: 2px; font-size: 12px; }';
			tableStr = tableStr + '.STYLE17 {font-size: 24px} .STYLE20 {font-size: 20px; font-weight: bold; } .STYLE21 {font-size: 13px}';
			tableStr = tableStr + '.STYLE22 {border-bottom: 1px #000000 solid; padding: 2px; font-size: 13px; }</style><style type="text/css">@media print{INPUT {display:none}}	.fangge {font-size: 16pt;color: #FF0000;line-height:1em;} body {margin-left: 0px;margin-top: 0px;margin-right: 0px;margin-bottom: 0px;}</style></head>';
			tableStr = tableStr + '<body><table width="679" height="961" border="0" align="center">';
			tableStr = tableStr + '<tr><td height="94" colspan="4">&nbsp;</td></tr>';
			tableStr = tableStr + '<tr><td width="51" height="35"><input type="button" name="print" value="打印" onClick="reportPrint()" /></td>';
			tableStr = tableStr + '<td width="563" align="center"><span class="STYLE17">中华人民共和国组织机构代码证</span></td>';
			tableStr = tableStr + '<td width="53" align="center">&nbsp;</td><td width="0" align="center"></td></tr>';
			tableStr = tableStr + '<tr><td height="46" colspan="4" valign="bottom"><table width="679" border="0"><tr>';
			tableStr = tableStr + '<td width="54" height="23" valign="bottom"><span class="STYLE5">流水号：</span></td>';
			tableStr = tableStr + '<td width="109" valign="bottom"><span class="STYLE5">'+record20.data.orgid+'</span></td>';
			tableStr = tableStr + '<td width="319" align="center" valign="bottom"><span class="STYLE4">信息查询表</span></td>';
			tableStr = tableStr + '<td width="179"></td></tr></table><hr noshade="noshade" /></td></tr><tr>';
			tableStr = tableStr + '<td height="29" colspan="4" valign="bottom"><span class="STYLE20">基本信息(不可改)</span></td>';
			tableStr = tableStr + '</tr><tr><td height="218" colspan="4" valign="top">';         
			tableStr = tableStr + '<div style="border:solid; border-width:thin; height:179; padding-top:8px; padding-left:4px; padding-right: 2px; padding-bottom: 4px;"><table width="670" height="210" border="0">';
			tableStr = tableStr + '<tr><td width="72" height="26" style="padding-left:5px;"><span class="STYLE21">机构代码：</span></td>';
			tableStr = tableStr + '<td colspan="5"><span class="STYLE21">'+record20.data.jgdm+'</span></td></tr>';
			tableStr = tableStr + '<tr><td height="26" style="padding-left:5px;"><span class="STYLE21">机构名称：</span></td>';
			tableStr = tableStr + '<td colspan="5"><span class="STYLE21">'+record20.data.jgmc+'</span></td></tr>';
			tableStr = tableStr + '<tr><td height="26" style="padding-left:5px;"><span class="STYLE21">行政区划：</span></td>';
			tableStr = tableStr + '<td><span class="STYLE21">'+record20.data.xzqhCode+'</span></td>';
			tableStr = tableStr + '<td align="right"><span class="STYLE21">机构类型：</span></td><td width="41"><span class="STYLE21">K8310</span></td><td colspan="2"><span class="STYLE21">'+record20.data.jglx+'</span></td></tr>';
			tableStr = tableStr + '<tr><td height="26" style="padding-left:5px;"><span class="STYLE21">机构地址：</span></td>';
			tableStr = tableStr + '<td colspan="5"><span class="STYLE21">'+record20.data.jgdz+'</span></td></tr>';
			tableStr = tableStr + '<tr><td height="26" style="padding-left:5px;"><span class="STYLE21">颁证日期：</span></td>';
			tableStr = tableStr + '<td width="158"><span class="STYLE21">'+dateFormatToYMD(record20.data.bzrq)+'</span></td>';
			tableStr = tableStr + '<td width="132" align="right"><span class="STYLE21">副本数量：</span></td><td><span class="STYLE21">'+record20.data.fbsl+'</span></td>';
			tableStr = tableStr + '<td width="87" align="right"><span class="STYLE21">电子副本数：</span></td>';
			tableStr = tableStr + '<td width="154"><span class="STYLE21">'+record20.data.fksl+'</span></td></tr><tr><td colspan="2"><table width="231" border="0"><tr>';
			tableStr = tableStr + '<td width="88" height="26" class="STYLE21">法定代表人：</td><td width="133" class="STYLE21">'+record20.data.fddbr+'</td></tr></table></td>';
			tableStr = tableStr + '<td align="right"><span class="STYLE21">法定代表人证件号码：</span></td><td colspan="3"><span class="STYLE21">'+record20.data.zjhm+'</span></td></tr>';
			tableStr = tableStr + '<tr><td height="26" colspan="4"><span class="STYLE21"></span></td>';
			tableStr = tableStr + '<td align="right"><span class="STYLE21">领证人：</span></td><td><span class="STYLE21">'+record20.data.tbrxm+'</span></td></tr></table>';
			tableStr = tableStr + '</div></td></tr><tr><td height="29" colspan="4" valign="bottom"><span class="STYLE20">其他信息(可改)</span></td>';
			tableStr = tableStr + '</tr><tr><td height="327" colspan="4">';           
			tableStr = tableStr + '<div style="border:solid; border-width:thin; border-color:#000000; height:179; padding-top:8px; padding-left:4px; padding-right: 2px; padding-bottom: 4px;"><table width="670" height="284" border="0"><tr>';            
			tableStr = tableStr + '<td width="71" height="27" valign="bottom" style="padding-left:5px;"><span class="STYLE21">电话号码：</span></td>';  
			tableStr = tableStr + '<td width="176" height="24" valign="bottom" class="xiahua2">'+record20.data.dhhm+'</td>';            
			tableStr = tableStr + '<td width="87" align="center" valign="bottom"><span class="STYLE21">传真号码：</span></td><td width="114" valign="bottom" class="STYLE16">&nbsp;</td>';
			tableStr = tableStr + '<td width="94" align="center" valign="bottom"><span class="STYLE21">邮政编码：</span></td><td width="102" valign="bottom" class="xiahua2">'+record20.data.yzbm+'&nbsp;</td></tr>';  
			tableStr = tableStr + '<tr><td width="71" height="27" valign="bottom" style="padding-left:5px;"><span class="STYLE21">通信地址：</span></td>';            
			tableStr = tableStr + '<td colspan="5" valign="bottom" class="xiahua2">'+record20.data.jgdz+' </td></tr>';            
			tableStr = tableStr + '<tr><td valign="middle" style="padding-left:5px;"><span class="STYLE21">经营范围：</span></td>';  
			tableStr = tableStr + '<td colspan="5" valign="bottom"><p class="xiahua2">'+record20.data.jyfw+'</p> </td></tr><tr>';            
			tableStr = tableStr + '<td height="27" valign="bottom" style="padding-left:5px;"><span class="STYLE21">经济行业：</span></td>';
			tableStr = tableStr + '<td colspan="2" valign="bottom" class="xiahua2">'+record20.data.jjhymc+'&nbsp;</td>';
			tableStr = tableStr + '<td align="right" valign="bottom"><span class="STYLE21">企业类型：</span></td><td colspan="2" valign="bottom" class="STYLE16">'+record20.data.jjlx+'&nbsp;</td></tr><tr>';          
			tableStr = tableStr + '<td height="27" valign="bottom" style="padding-left:5px;"><span class="STYLE21">注册资金：</span></td>';           
			tableStr = tableStr + '<td colspan="2" valign="bottom" class="xiahua2">'+record20.data.zczj+'万，币种'+record20.data.hbzl+'&nbsp;</td>';  
			tableStr = tableStr + '<td align="right" valign="bottom"><span class="STYLE21">经营期限：</span></td><td colspan="2" valign="bottom" class="STYLE16">'+dateFormatToYMD(record20.data.zszfrq)+'&nbsp;</td></tr>';            
			tableStr = tableStr + '<tr><td height="27" valign="bottom" style="padding-left:5px;"><span class="STYLE21">登记机关：</span></td>';
			
			if(record20.data.zslsh!=null&&record20.data.zslsh!=''){
				tableStr = tableStr + '<td colspan="3" valign="bottom" class="xiahua2">组代管'+currentZzUserCenterid+'-'+returnZslsh(record20.data.zslsh)+'&nbsp;</td>';
			}else{
				tableStr = tableStr + '<td colspan="3" valign="bottom" class="xiahua2">&nbsp;</td>';
			}
			tableStr = tableStr + '<td align="center" valign="bottom"><span class="STYLE21">投资国别：</span></td><td valign="bottom" class="xiahua2">'+record20.data.wftzgb+'&nbsp;</td></tr>';          
			tableStr = tableStr + '<tr><td height="27" valign="bottom" style="padding-left:5px;"><span class="STYLE21">注册号：</span></td>';            
			tableStr = tableStr + '<td colspan="3" valign="bottom" class="xiahua2">'+record20.data.zch+'</td>';            
			tableStr = tableStr + '<td align="center" valign="bottom"><span class="STYLE21">职工人数：</span></td><td valign="bottom" class="xiahua2">'+record20.data.zgrs+'&nbsp;</td></tr>';  
			tableStr = tableStr + '<tr><td colspan="3"><table width="338" border="0"><tr>';            
			tableStr = tableStr + '<td width="98" height="27" valign="bottom" class="STYLE21">主管单位代码：</td><td width="230" valign="bottom" class="STYLE22">'+record20.data.zgdm+'&nbsp;</td></tr></table></td>';
			tableStr = tableStr + '<td align="right" valign="bottom"><span class="STYLE21">主管单位名称：</span></td><td colspan="2" valign="bottom" class="STYLE16">'+record20.data.zgmc+'&nbsp;</td></tr>';
			tableStr = tableStr + '<tr><td height="27" valign="bottom" style="padding-left:5px;"><span class="STYLE21">是否年检：</span></td>';
			tableStr = tableStr + '<td colspan="2" valign="bottom" class="xiahua2">'+returnNjqx(record20.data.njqx)+'&nbsp;</td>';
			tableStr = tableStr + '<td align="right" valign="bottom"><span class="STYLE21">年检日期：</span></td><td colspan="2" valign="bottom" class="STYLE16">'+dateFormatToYMD(record20.data.njrq)+'&nbsp;</td></tr>';
			tableStr = tableStr + '<tr><td height="24" colspan="6" valign="bottom"><table width="134" border="0">';
			tableStr = tableStr + '<tr><td width="99" height="27" valign="bottom" class="STYLE21"> 是否涉密单位：</td><td width="25" align="center" valign="bottom" class="STYLE22">'+formatToGk(record20.data.gk)+'&nbsp;</td></tr></table></td>';
			tableStr = tableStr + '</tr></table></div></td></tr><tr><td height="29" colspan="4" valign="bottom"><span class="STYLE20">备查信息</span></td></tr>';          
			tableStr = tableStr + '<tr><td height="94" colspan="4"><div style="border:solid; border-width:thin; border-color:#000000; height:94; padding-top:8px; padding-left:4px; padding-right: 2px; padding-bottom: 4px;"><table width="670" height="93" border="0">';           
			tableStr = tableStr + '<tr><td width="69" height="24" style="padding-left:5px;"><span class="STYLE21">机构名称：</span></td>';  
			tableStr = tableStr + '<td width="591"><span class="STYLE21">'+record20.data.jgmc+'</span></td></tr>';            
			tableStr = tableStr + '<tr><td height="24" style="padding-left:5px;"><span class="STYLE21">查询单位：</span></td><td>&nbsp;</td></tr>';
			tableStr = tableStr + '<tr><td height="41" colspan="2" align="center"><span class="STYLE12">查询单位：（盖公章）</span></td></tr></table>';
			tableStr = tableStr + '</div></td></tr></table><script language="JavaScript">function reportPrint(){window.location.reload();window.print();}</script></body></html>';          
 
			var titleHTML = tableStr;
			var newwin = window.open('printer.jsp', 'printWindow', 'menubar=yes,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no,titlebar=yes,z-look=yes,menubar=yes');     
			newwin.document.write(titleHTML);   
		}
	}
});
    
var text_search_orgnewArchive = new Ext.form.TextField({
	id : 'textSearchOrgnewArchiveid',
	name : 'textSearchOrgnewArchive',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchOrgnewArchive();
			}
		}
	}
});

//加载右栏主页面   （数据列表、工具栏按钮）
var grid_LicenseArchive = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	//autoHeight : true,
	cm : cm_orgnew,
	ds : ds_orgnewArchive,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'address',
	viewConfig : {forceFit : true},
	plugins : expander87,
	tbar : [btn_refresh_orgnewArchive,btn_prt_orgnewArchive,'->',text_search_orgnewArchive,
	        btn_search_orgnewArchive],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_orgnewArchive,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowdblclick':function(grid, rowIndex){
			ds_filelog.baseParams.orgid = grid.getStore().getAt(rowIndex).data.orgid;
			ds_filelog.load({params : {start : 0,limit : useFullPageSize}});
		}
	}
});

var ds_filelog =  new Ext.data.Store({
	url : 'findAllLoanLog.action',
	sortInfo : {field: 'loanTime', direction: 'DESC'},
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'logId',type : 'int'}, 
		{name : 'orgid',type : 'int'}, 
		{name : 'orgnewName',type : 'string'}, 
		{name : 'loanTime'},
		{name : 'loanDays',type : 'int'}, 
		{name : 'preReturnTime'},
		{name : 'returnTime'},
		{name : 'readerId',type : 'int'},
		{name : 'reader',type : 'string'},
		{name : 'loannerId',type : 'int'},
		{name : 'filetypename',type : 'string'},
		{name : 'loanner',type : 'string'}]
	)
});



LoanLogPanel = Ext.extend(Ext.grid.GridPanel,{
	constructor:function(){
		LoanLogPanel.superclass.constructor.call(this,{
		loadMask : {msg : '数据加载中...'},
			cm : new Ext.grid.ColumnModel([ 
			   {header : '文件分类',width : 100,	dataIndex : 'filetypename',sortable : true}, 
				{header : '文件名称',	width : 120,dataIndex : 'orgnewName',id : 'orgnewName',renderer:linker,sortable : true}, 
				{header : '文件大小(K)',	width : 90,	dataIndex : 'reader',sortable : true},
				{header : '上传时间',width : 100,	dataIndex : 'loanTime',renderer: dateFormatShzt,sortable : true}, 
				{header : '浏览次数',width : 100,	dataIndex : 'loanDays',sortable : true}, 
				{header : '审核时间',	width : 100,dataIndex : 'preReturnTime',renderer: dateFormatShzt,sortable : true}, 
				{header : '通过时间',	width : 100,dataIndex : 'returnTime',renderer:dateFormatShzt,sortable : true}, 
				{header : '受理人',	width : 100,dataIndex : 'loanner',menuDisabled : true}]
			),
			autoExpandColumn : 'jgmc',
			ds : ds_filelog,
			sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
			bbar : new Ext.PagingToolbar({
					pageSize : useFullPageSize,
					store : ds_filelog,
					displayInfo : true,
					displayMsg : '第 {0} - {1} 条 共 {2} 条',
					emptyMsg : "没有档案记录"}
			)
		});
	}
});


var zzLicenseArchive_panel = new Ext.Panel({
	title : '机构信息查询',
	iconCls : 'icon-plugin',
	region : 'center',
	border : 'layout',
	frame : true,
	layout:'border',
	defaults: {
	    collapsible: true,
	    split: true
	},
	items: [{
	    region:'center',
	    layout : 'border',
	    items : [grid_LicenseArchive]
	}]
});

var p_zzLicenseArchive = {
	id : 'zzLicenseArchive-panel',
	border : false,
	layout : 'border',
	items : [zzLicenseArchive_panel]
}
