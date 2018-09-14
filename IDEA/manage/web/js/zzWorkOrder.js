

var btn_search_jglxSelcet = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJglxSelcet();
	}
});

var text_search_jglxSelcet = new Ext.form.TextField({
	id : 'textSearchJglxSelcet',
	name : 'textSearchJglxSelcet',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJglxSelcet();
			}
		},
		'change' : function(field, e) {
			btn_search_jglxSelcet.setDisabled(false);
		}
	}
});


var cm_jglxSelcet = new Ext.grid.ColumnModel([
    {header : '一级类型',width : 30,dataIndex : 'pjglxmc',sortable : true}, 
	{header : '二级类型',width : 100,dataIndex : 'jglxmc',sortable : true}, 
	{header : '代码',width : 30,dataIndex : 'jglxdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_jglxSelcet = new Ext.data.Store({
	url : 'findAllByConditionJglx.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'jglxid',type : 'int'}, 
	    {name : 'pjglxmc',type : 'string'},
		{name : 'jglxmc',type : 'string'},
		{name : 'jglxdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchJglxSelcet = function() {
	ds_jglxSelcet.baseParams.conditions = text_search_jglxSelcet.getValue();
	ds_jglxSelcet.baseParams.username="";
	ds_jglxSelcet.baseParams.stateConditions='';
	ds_jglxSelcet.load({params : {start : 0,limit : 20} });
}

var grid_jglx_zwo = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jglxSelcet,
	ds : ds_jglxSelcet,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入机构类型名称：',text_search_jglxSelcet,btn_search_jglxSelcet],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jglxSelcet,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jglxQuery_zwo.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			workOrderViewForm.getForm().findField('select_jglxmc_zwo').setValue(selections[0].get('jglxmc'));
			workOrderViewForm.getForm().findField('select_jglxdm_zwo').setValue(selections[0].get('jglxdm'));
		}
	}
});


var window_jglxQuery_zwo = new Ext.Window({
	title : '机构类型查询',
	iconCls : 'icon-plugin',
	width :500,
	height:400,
	x:'250',
	y:'170',
	//plain    : true,
	layout   : 'border',
	resizable : false,
	modal : true,
	resizable : true, 
	maximizable:true,
	closeAction : 'hide',
	items : [grid_jglx_zwo]
});



var btn_search_hylxSelcet = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchHylxSelcet();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_hylxSelcet = new Ext.form.TextField({
	id : 'textSearchHylxSelcet',
	name : 'textSearchHylxSelcet',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchHylxSelcet();
			}
		},
		'change' : function(field, e) {
			btn_search_hylxSelcet.setDisabled(false);
		}
	}
});


var cm_hylxSelcet = new Ext.grid.ColumnModel([
	{header : '大类',width : 30,dataIndex : 'hylxmc1',sortable : true}, 
	{header : '中类',width : 100,dataIndex : 'hylxmc2',sortable : true}, 
	{header : '小类',width : 30,dataIndex : 'hylxmc3',sortable : true}, 
    {header : '经济行业名称',width : 30,dataIndex : 'hylxmc',sortable : true},
	{header : '经济行业代码',width : 30,dataIndex : 'hylxdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_hylxSelcet = new Ext.data.Store({
	url : 'findAllByConditionHylx.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'hylxid',type : 'int'}, 
	    {name : 'hylxmc',type : 'string'},
	    {name : 'hylxdm',type : 'string'},
	    {name : 'hylxmcOld',type : 'string'},
	    {name : 'hylxdmOld',type : 'string'},
		{name : 'hylxmc1',type : 'string'},
		{name : 'hylxmc2',type : 'string'},
		{name : 'hylxmc3',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchHylxSelcet = function() {
	ds_hylxSelcet.baseParams.conditions = text_search_hylxSelcet.getValue();
	ds_hylxSelcet.baseParams.username="";
	ds_hylxSelcet.baseParams.stateConditions='';
	ds_hylxSelcet.load({params : {start : 0,limit : 20} });
}

var grid_hylx_zwo = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_hylxSelcet,
	ds : ds_hylxSelcet,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入经济行业代码名称：',text_search_hylxSelcet,btn_search_hylxSelcet],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_hylxSelcet,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_hylxQuery_zwo.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			workOrderViewForm.getForm().findField('select_jjhymc_zwo').setValue(selections[0].get('hylxmc'));
			workOrderViewForm.getForm().findField('select_jjhydm_zwo').setValue(selections[0].get('hylxdm'));
		}
	}
});


var window_hylxQuery_zwo = new Ext.Window({
	title : '经济行业查询',
	iconCls : 'icon-plugin',
	width :500,
	height:400,
	x:'250',
	y:'170',
	//plain    : true,
	layout   : 'border',
	resizable : false,
	modal : true,
	resizable : true, 
	maximizable:true,
	closeAction : 'hide',
	items : [grid_hylx_zwo]
});



var btn_search_pzjg2 = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchPzjg_select();
		
		//btn_search_pzjg.setDisabled(true);
	}
});


var text_search_pzjg2 = new Ext.form.TextField({
	id : 'textSearchPzjg',
	name : 'textSearchPzjg',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchPzjg_select();
			}
		},
		'change' : function(field, e) {
			btn_search_pzjg2.setDisabled(false);
		}
	}
});


var cm_pzjg2 = new Ext.grid.ColumnModel([
	{header : '批准机构名称',width : 50,dataIndex : 'pzjgmc',sortable : true}, 
	{header : '批准机构代码',width : 20,dataIndex : 'pzjgdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_pzjg2 = new Ext.data.Store({
	url : 'findAllByConditionPzjg.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'pzjgid',type : 'int'}, 
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchPzjg_select = function() {
	ds_pzjg2.baseParams.conditions = text_search_pzjg2.getValue();
	ds_pzjg2.baseParams.username='';
	ds_pzjg2.baseParams.stateConditions='';
	ds_pzjg2.load({params : {start : 0,limit : 20} });
}

//-----------------------点击列表信息，显示图书的扩展属性-----------------------
var expander_zwo = new Ext.grid.RowExpander({
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
var imageView_window_workOrder = new Ext.Window({   
    id: 'image-window_7000',   
    title : '原文预览',   
    width : 900,   
    height : 600,   
    resizable : true, 
    maximizable:true,
    closeAction :'hide',
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"   width=100%  height=100% align=center hspace=0 vspace=0 id="scanner7000"  name="scanner7000" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT><OBJECT id="WebBrowser1" height="0" width="0" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" VIEWASTEXT></OBJECT>',
    buttons: [{ 
		   id:'up_button2',
		   name:'up_button2',
		   text: '上传',   
	       handler: function(btn) {   
					var base64file;
					var packLength;
					var packCount;
					var imageCount;
					var pageTypeStr;
					var lastPack;
					var xmlhttp;
					var i;
					var pack;
					var strOrgid;
					var strBzjgdm;
					
					var record = grid_WorkOrder.getSelectionModel().getSelected();
				    //Ext.MessageBox.alert("提示","您选择的出版号是："+record2.data.fddbr); 
					btn.disable();
					strOrgid = record.data.orgid;  //参数orgid
					strDocid = record.data.docid;
					strBzjgdm = record.data.bzjgdm;
					
					//alert(record.data.imageData);
					packLength = 40960;	//定义每个包的大小40960
					//scanner7000.ImageData=record.data.imageData;
					base64file = scanner7000.ImageData;  //获取控件扫描的图片数据
					var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
					imageCount = scanner7000.GetPageCount;	//获取扫描图片的页数
					pageTypeStr = scanner7000.PageType;    //获取标识字符串,需要写数据库
					if(pageTypeStr!=""){
						pageTypeStr=pageTypeStr.replace(/\%/g, "|"); 
	       			}
					alert(pageTypeStr);
					packCount = Math.ceil(base64file.length / packLength);	//判断需要发送数据包的个数
					//alert(packCount);
					if(imageCount==0 || base64file=="")   //判断如果没有扫描数据，结束处理
					{
						alert("请扫描或导入图片后，再上传！");
						btn.enable();
						return false;
					}
					if (pageTypeStr.indexOf('未标识')!=-1){ //判断如果没有标识，则不允许上传
						alert("请进行电子原文标识后，再保存！");
						btn.enable();
						return false;
					}
					scanner7000.OpenProgress(packCount);  //设置上传的进度条的总进度数
					xmlhttp = GetXmlHttp(); //通过AJAX格式上传
					for(i=0; i < packCount; i++)  //分包上传
					{
						if(i==packCount-1){
							lastpack="true";
						}else{
							lastpack="false";
						}
						
						pack = base64file.substring(i * packLength, (i + 1) * packLength);  //每个数据包的文件大小
							//alert(pack);
						try
						{
							xmlhttp.open("post", "saveImageOrgnew.action?orgid="+strOrgid+"&docid="+strDocid+"&packindex="+i+"&pageTypeStr="+pageTypeStr+"&&bzjgdm="+strBzjgdm+"lastpack="+lastpack, false);
							xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   //这句必须要，而且一定要放在send以前
							xmlhttp.send("imageData=" + encodeURIComponent(pack)); 
                            //alert(xmlhttp.responseText);
							var objs = eval("["+xmlhttp.responseText+"]");
							if(objs[0].success)
							{
								scanner7000.Progress('上传中',i+1);
							}
							else
							{
								alert("上传失败，请重试0001。");
								btn.enable();
								return false;
							}
						}
						catch(e)
						{
							alert("上传失败，请重试0002。");
							btn.enable();
							return false;
						}
					}
					alert("上传成功！");
					btn.enable();
					return true;
	       }   
	   },{   
	       text: '重载',   
		       handler: function() { 
		    	   var record = grid_WorkOrder.getSelectionModel().getSelected();
					var resultObject = null;
					var useState=record.data.state;
					var	imgUrl='';
					imgUrl='orgnewViewImg.action';

		    		Ext.Ajax.request({
						url : imgUrl,
						params : {orgid : record.data.orgid},
						success : function(result,request) {//获取返回值
							var resultObject = Ext.util.JSON.decode(result.responseText);
							if(resultObject!=null){
								scanner7000.OpenProgress(3);  //设置上传的进度条的总进度数
								scanner7000.Progress('原文加载中',1);
								scanner7000.Progress('原文加载中',2);
							    //resultObject = eval('('+result.responseText+')');  
			   					scanner7000.ImageData=resultObject.imageData;
		   						if(scanner7000.ImageData!=""){
		   							scanner7000.PageType=resultObject.pageTypeStr;
		   							scanner7000.Progress('原文加载完毕',3);
		   						}else{
		   							scanner7000.Progress('原文加载失败',3);
			   						alert("原文错误，加载失败，请重新扫描或导入！");
		   						}
		   						scanner7000.CloseProgress();
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
	            imageView_window_workOrder.hide();   
	        }
	   }],
	   listeners : {
			'activate' : function() {  //标签激活后自动加载数据
				var record = grid_WorkOrder.getSelectionModel().getSelected();
				var resultObject = null;
				var useState=record.data.state;
				var	imgUrl='';

				imgUrl='orgnewViewImg.action';
	    		Ext.Ajax.request({
					url : imgUrl,
					params : {orgid : record.data.orgid},
					success : function(result,request) {//获取返回值
						var resultObject = Ext.util.JSON.decode(result.responseText);
						if(resultObject!=null){
							scanner7000.OpenProgress(3);  //设置上传的进度条的总进度数
							scanner7000.Progress('原文加载中',1);
							scanner7000.Progress('原文加载中',2);
						    //resultObject = eval('('+result.responseText+')');  
		   					scanner7000.ImageData=resultObject.imageData;
	   						if(scanner7000.ImageData!=""){
	   							scanner7000.PageType=resultObject.pageTypeStr;
	   							scanner7000.Progress('原文加载完毕',3);
		   						scanner7000.CloseProgress();
	   						}else{
	   							scanner7000.Progress('原文加载失败',3);
		   						scanner7000.CloseProgress();
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
function viewPic_workOrder()
{
	imageView_window_workOrder.show(); 
	imageView_window_workOrder.setTitle('原文预览');
}
//---------------------- 列表显示原文的标识 ------------------------------------
function icon_workOrder(value,p,record){
	if(typeof record=='object'){
		var fileUrl;
		fileUrl=record.data["imageData"];
		//alert(fileUrl);
		if(fileUrl!=''){
			return String.format('<a style="display:table;width:100%;" onclick="viewPic_workOrder()"><img src="images/file_ico.gif"></a>',record.data["orgid"]);
		}
	}  
}


//---------------------- 列表显示主要数据信息 ----------------------------------
// 列表显示机构的主要信息 yangqi
var sm2 = new Ext.grid.CheckboxSelectionModel();
var cm_workorder = new Ext.grid.ColumnModel([expander_zwo,
	sm2,
	{header : '原文',width : 20,dataIndex : 'imageUrl', renderer:icon_workOrder,sortable : false},
	{header : '流水号',width : 60,dataIndex : 'orderid',sortable : true}, 
	{header : '机构名称',width : 180,sortable : true,dataIndex : 'jgmc'},
	{header : '法定代表人/负责人',width : 60,dataIndex : 'fddbr',sortable : true}, 
	{header : '经办人姓名',width : 40,dataIndex : 'tbrxm',id : 'tbrxm',sortable : true},
	{header : '业务类型',width : 60,dataIndex : 'ywlx',sortable : true},
	{header : '业务状态',width : 150,dataIndex : 'state',renderer : goState,menuDisabled : true}
]);

//--------------------机构基本信息-------------------------------------------
var workOrderViewForm = new Ext.FormPanel({
	url : 'updateOrgnew.action',
	labelAlign : 'right',
	labelWidth : 95,
	bodyStyle : 'padding:0px',
	border : false,
	autoHeight : true,
	autoScroll : true, 
	baseCls : 'x-plain',
	waitMsgTarget: true,
	items : [{
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		bodyStyle : 'padding:10px',
		items : [{//第一行基本
			columnWidth : 1,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			 bodyStyle: 'padding:0px',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items : [{xtype : 'hidden',name : 'orgid'},{fieldLabel : '机构名称',	name : 'jgmc',allowBlank : false,readOnly:true,maxLength : 100}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			 bodyStyle: 'padding:0px',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '机构代码',name : 'jgdm',allowBlank : true,readOnly:true,maxLength : 9}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			 bodyStyle: 'padding:0px',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '法定代表人',name : 'fddbr',maxLength : 30,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			 bodyStyle: 'padding:0px',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '证件类型',name : 'zjlx',maxLength : 25,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			 bodyStyle: 'padding:0px',
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '证件号码',name : 'zjhm',maxLength : 18,readOnly:true}]
		},{
			columnWidth : 1,
			xtype : 'panel',
			baseCls : 'x-plain',
			bodyBorder : false,
			 bodyStyle: 'padding:0px',
			layout : 'form',
			defaultType : 'textarea',
			defaults : {anchor:'99%',height:40},
			items : [{fieldLabel : '经营范围',name : 'jyfw',maxLength : 240,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			 bodyStyle: 'padding:0px',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '成立日期',name : 'zcrq',maxLength : 10,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			 bodyStyle: 'padding:0px',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '职工人数',name : 'zgrs',xtype : 'numberfield',maxLength : 2000000000,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			 bodyStyle: 'padding:0px',
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '证照开始日期',name : 'zsbfrq',maxLength : 10,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			 bodyStyle: 'padding:0px',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '证照终止日期',name : 'zszfrq',maxLength : 10,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			 bodyStyle: 'padding:0px',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '企业注册类型',name : 'jjlx',maxLength : 50,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			 bodyStyle: 'padding:0px',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '外商投资国别',name : 'wftzgb',maxLength : 50,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			 bodyStyle: 'padding:0px',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '注册(开办)资金',name : 'zczj',xtype : 'numberfield',maxValue : 2000000000,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			 bodyStyle: 'padding:0px',
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '货币种类',name : 'hbzl',maxLength : 50,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			 bodyStyle: 'padding:0px',
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '主管部门',name : 'zgmc',maxLength : 80,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			 bodyStyle: 'padding:0px',
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '批准机构',name : 'pzjgmc',maxLength : 80,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			 bodyStyle: 'padding:0px',
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '注册文号',name : 'zch',maxLength : 31,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			 bodyStyle: 'padding:0px',
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '邮政编码',name : 'yzbm',maxLength : 6,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			 bodyStyle: 'padding:0px',
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '机构地址',name : 'jgdz',maxLength : 100,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			 bodyStyle: 'padding:0px',
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '行政区划',name : 'xzqhName',readOnly:true,maxLength : 100}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			 bodyStyle: 'padding:0px',
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '固定电话',name : 'dhhm',maxLength : 21,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			 bodyStyle: 'padding:0px',
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '移动电话',name : 'mobile',maxLength : 25,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			 bodyStyle: 'padding:0px',
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '网址',name : 'weburl',maxLength : 50,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			 bodyStyle: 'padding:0px',
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '电子信箱',name : 'email',maxLength : 40,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			 bodyStyle: 'padding:0px',
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '经办人',name : 'tbrxm',maxLength : 25,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			bodyStyle: 'padding:0px',
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '经办人证件类型',name : 'memo',maxLength : 25,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			 bodyStyle: 'padding:0px',
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '经办人证件号码',name : 'tbrsfzh',maxLength : 18,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			 bodyStyle: 'padding:0px',
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[{fieldLabel : '经办人电话',name : 'tbrlxfs',maxLength : 25,readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			 bodyStyle: 'padding:0px',
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items :[new Ext.form.TriggerField({
				id:"select_jjhymc_zwo",
				name:"jjhymc",
				fieldLabel:"经济行业",
			 	valueField : "jjhymc",
			    displayField : "jjhymc",
			    //readOnly:'true',
			    maxLength : 50,
			    allowBlank : false,
			    haveShow : false,
			    editable : false,
			    emptyText:'请选择经济行业！',
			    onTriggerClick : function() {
			    	window_hylxQuery_zwo.show();
			    },
			    width:135
			})]

		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			bodyStyle: 'padding:0px',
			baseCls : 'x-plain',
			defaults : {anchor : '99%'},
			items :[new Ext.form.TriggerField({
				id:"select_jglxmc_zwo",
				name:"jglx",
				fieldLabel:"机构类型",
			 	valueField : "jglx",
			    displayField : "jglx",
			    //readOnly:'true',
			    maxLength : 50,
			    allowBlank : false,
			    haveShow : false,
			    editable : false,
			    emptyText:'请选择机构类型！',
			    onTriggerClick : function() {
			    	window_jglxQuery_zwo.show();
			    },
			    width:135
			},{id:"select_jglxdm_zwo",xtype : 'hidden',name : 'jglxdm'},{id:"select_pageTypeStr_zwo",xtype : 'hidden',name : 'pageTypeStr'},{id:"select_jjhydm_zwo",xtype : 'hidden',name : 'jjhydm'})]
		}]
	},{
		columnWidth : 1,
		xtype : 'panel',
		baseCls : 'x-plain',
		bodyBorder : false,
		bodyStyle: 'padding:0px',
		layout : 'form',
		defaults : {anchor:'99%',height:40},
		items : [{
			xtype : 'combo',
			fieldLabel : '是否公开',
			id : 'gk_zwo',
			name : 'gk',
			displayField : 'gk',
			valueField : 'gk',
			hiddenName : 'gk',
			store : gkStore,
			triggerAction : 'all',
			lazyRender:true,
			emptyText:'请选择是否公开！',
			mode : 'local',
			anchor:'90%',
			selectOnFocus : true,
			allowBlank:false,
			editable : false
		}]
	},{
		columnWidth : 1,
		xtype : 'panel',
		baseCls : 'x-plain',
		bodyBorder : false,
		bodyStyle: 'padding:0px',
		defaults : {anchor : '99%'},
		layout : 'form',
		defaultType : 'textarea',
		items : [{fieldLabel : '审核意见',name : 'auditNote',height:40,maxLength : 250,anchor:'90%'}]
	}]
});

//图像浏览
var workOrderViewImg = new Ext.Panel({
	title   : '原文信息',
    region    : 'center',
    margins   : '3 3 3 0', 
    activeTab : 0,
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"   width=100%  height=100% align=center hspace=0 vspace=0 id="scanner77179"  name="scanner77179" >'
	       +'<param name="ShowCount" value="1">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>'
});

//--------------------修改新办申请机构信息-------------------------------------------
var workOrderEditForm = new Ext.FormPanel({
	loadMask : {
		msg : '数据加载中...'
	},
	url : 'updateOrgnew.action',
	labelAlign : 'right',
	labelWidth : 75,
	bodyStyle : 'padding:3px',
	border : false,
	autoHeight : true,
	autoScroll : true, 
	baseCls : 'x-plain',
	waitMsgTarget: true,
	items : [{
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{//第0行基本
			columnWidth : 1,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items : [{fieldLabel : '流水号',	name : 'orderid',allowBlank : false,readOnly:true,maxLength : 50}]
		}]
	},{//第一行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .67,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '96.5%'},
			items : [{fieldLabel : '机构名称',name : 'jgmc',allowBlank : false,maxLength : 100,defaults : {anchor:'95%'}}]
		},{
			columnWidth : .33,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '96.5%'},
			items : [{fieldLabel : '机构类型',name : 'jglx',allowBlank : false,maxLength : 50,defaults : {anchor:'100%'}}]
		}]
	},{	layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{//第二行修改
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : .33,
					layout : 'form',
					baseCls : 'x-plain',
					border : false,
					defaultType : 'textfield',
					defaults : {anchor : '96.5%'},
					items : [{fieldLabel : '法定代表人',	name : 'fddbr',allowBlank : false,maxLength : 30,defaults : {anchor:'95%'}}]
				},{
					columnWidth : .34,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '93%'},
					items :[{fieldLabel : '证件类型',	name : 'zjlx',allowBlank : false,maxLength : 10,defaults : {anchor:'95%'}}]
				},{
					columnWidth : .33,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '93%'},
					items :[{fieldLabel : '证件号码',name : 'zjhm',allowBlank : false,maxLength : 25,defaults : {anchor:'95%'}}]
				}]
		}]
	},{
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{//第三行修改
			columnWidth : 1,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '97.5%'},
			items : [{fieldLabel : '经营范围',name : 'jyfw',allowBlank : false,maxLength : 50,defaults : {anchor:'96.5%'}}]
		}]

	},{	
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{//第四行修改
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : .67,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '96.5%'},
					items :[{fieldLabel : '机构地址',	name : 'jgdz',allowBlank : false,maxLength : 100,defaults : {anchor:'95%'}}]
				},{
					columnWidth : .33,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '93%'},
					items :[{
						xtype : 'combo',
						fieldLabel : '行政区划',
						id : 'xzqh_edit',
						name: 'xzqhName',
						hiddenName : 'xzqhCode',
						valueField : 'xzqhCode',
						displayField : 'xzqhName',
						mode : 'remote',
						store : new Ext.data.Store({
							//autoLoad : true,
							proxy : new Ext.data.HttpProxy({
								url : 'findAllXzqh.action'
							}),
							reader : new Ext.data.JsonReader({
								root : 'root'
							}, [{name : 'xzqhCode',type : 'string'},
								{name : 'xzqhName',type : 'string'}
							])
						}),
						selectOnFocus : true,
						editable : false,
						triggerAction : 'all',
						loadingText : '加载中...',
						listeners : {
							'select' : function(combo, record, index) {
								this.ownerCt.ownerCt.ownerCt.ownerCt.form.findField('xzqhName').setValue(record.data.xzqhName);
							}
						}
					}]
			}]
		}]
	},{ //表单修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .33,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '95%'},
			items : [
			    {xtype : 'hidden',	name : 'orgid'},
			    {fieldLabel : '邮政编码',	name : 'yzbm',allowBlank : false,maxLength : 50},
				{fieldLabel : '机构网址',	name : 'weburl',maxLength : 50}, 
				{fieldLabel : '主要产品一',	name : 'zycp1',maxLength : 50}, 
				{xtype : 'hidden',name : 'xzqhName'}, 
				{xtype : 'hidden',name : 'imageUrl'},
				{fieldLabel : '职工人数',name : 'zgrs',maxLength : 50}, 
				{fieldLabel : '批准机构',name : 'pzjgmc',maxLength : 50}, 
				{fieldLabel : '经营地址',name : 'jydz',maxLength : 100}, 
				{fieldLabel : '经费来源',name : 'jfly',maxLength : 25}, 
				{fieldLabel : '经办人',name : 'tbrxm',maxLength : 25}, 
				{fieldLabel : '可否公开',name : 'gk',maxLength : 25}
			]
		}, {//表单修改
			columnWidth : .34,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '95%'},
			items : [
				{fieldLabel : '电话号码',name : 'dhhm',maxLength : 50}, 
				{fieldLabel : '注册资金',xtype : 'numberfield',name : 'zczj',maxValue : 1000}, 
				{fieldLabel : '主要产品二',name : 'zycp2',maxLength : 25}, 
				{fieldLabel : '主管机构名',name : 'zgmc',maxLength : 25}, 
				{fieldLabel : '批准文号',name : 'pzwh',maxLength : 25},
				{fieldLabel : '经营邮编',name : 'jyyb',maxLength : 25}, 
				{fieldLabel : '开户银行',name : 'khyh',maxLength : 25}, 
				{fieldLabel : '身份证号码',name : 'tbrsfzh',maxLength : 25}, 
				{fieldLabel : '是否邮寄',name : 'yjflag',maxLength : 25}, 
				{xtype : 'hidden',name : 'lastdate',value :myDate.format('Y-m-d'),maxLength : 8 }, 
				{xtype : 'hidden',name : 'xgr',valuemaxLength : 50}
				]
		}, {//表单修改
			columnWidth : .33,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '93%'},
			items : [
				{fieldLabel : '电子邮箱',name : 'email',maxLength : 50}, 
				{fieldLabel : '投资国别',name : 'wftzgb',maxValue : 1000}, 
				{fieldLabel : '主要产品三',name : 'zycp3',maxLength : 25}, 
				{fieldLabel : '注册号',name : 'zch',maxLength : 25}, 
				{fieldLabel : '批准日期',name : 'pwrq',maxLength : 25}, 
				{fieldLabel : '经营电话',name : 'jydh',maxLength : 25}, 
				{fieldLabel : '开户帐号',name : 'khzh',maxLength : 25}, 
				{fieldLabel : '经办人电话',name : 'tbrlxfs',maxLength : 25},{
					id:'zrcq_edit2',
			        name:'zcrq',
				    fieldLabel:"注册日期",
					xtype:"datefield",  
				    format:"Y-m-d",
				    readOnly:true,
				    maxValue:myDate.format('Y-m-d'),  
			        maxText:'所选日期应在{0}之前',  
			        minValue:'01/01/2008',
			        minText:'所选日期应在{0}之后',
			        disabledDates:["2008年03月12日"],     
				    value:"1984-12-03"  
			}]
		}]
        	
	},{//表单修改
		xtype : 'panel',
		baseCls : 'x-plain',
		bodyBorder : false,
		layout : 'form',
		defaultType : 'textarea',
		defaults : {anchor:'97.6%'},
		items : [{fieldLabel : '审核意见',name : 'auditNote',maxLength : 500,disabled : true }]
	}],
	buttonAlign : 'center',
	minButtonWidth : 60,
	buttons : [{
		text : '修改',
		handler : function(btn){
			if (workOrderEditForm.getForm().isValid()) {
				btn.disable();
				workOrderEditForm.getForm().submit({
					waitTitle : '请稍候',
					waitMsg : '正在修改数据,请稍候...',
					success : function(form,action) {
						Ext.Msg.show({
							title : '成功提示',
							msg : '数据修改成功!',
							buttons : Ext.Msg.OK,
							fn : function(){btn.enable();},
							icon : Ext.Msg.INFO
						});
						var store = grid_WorkOrder.getStore();
						var orgnew = new Orgnew({
							orgid : form.findField('orgid').getValue(),
							// 数据修改自动更新表格列表本地信息
							
							fddbr : form.findField('fddbr').getValue(),
							zjlx : form.findField('zjlx').getValue(),
							zjhm : form.findField('zjhm').getValue(),
							jyfw : form.findField('jyfw').getValue(),
							jgdz : form.findField('jgdz').getValue(),
							yzbm : form.findField('yzbm').getValue(),
							dhhm : form.findField('dhhm').getValue(),
							email : form.findField('email').getValue(),
							weburl : form.findField('weburl').getValue(),
							zczj : form.findField('zczj').getValue(),
							wftzgb : form.findField('wftzgb').getValue(),
							zgrs : form.findField('zgrs').getValue(),
							zgmc : form.findField('zgmc').getValue(),
							zycp1 : form.findField('zycp1').getValue(),
							zycp2 : form.findField('zycp2').getValue(),
							zycp3 : form.findField('zycp3').getValue(),
							zch : form.findField('zch').getValue(),
							pzjgmc : form.findField('pzjgmc').getValue(),
							pzwh : form.findField('pzwh').getValue(),
							pwrq : form.findField('pwrq').getValue(),
							jydz : form.findField('jydz').getValue(),
							jyyb : form.findField('jyyb').getValue(),
							jydh : form.findField('jydh').getValue(),
							jfly : form.findField('jfly').getValue(),
							khyh : form.findField('khyh').getValue(),
							khzh : form.findField('khzh').getValue(),
							tbrxm : form.findField('tbrxm').getValue(),
							tbrsfzh : form.findField('tbrsfzh').getValue(),
							tbrlxfs : form.findField('tbrlxfs').getValue(),
							gk : form.findField('gk').getValue(),
							yjflag : form.findField('yjflag').getValue(),
							zcrq : Ext.get('zrcq_edit2').dom.value,
							
							
							/*下拉选择问题，报JS错误？？？？yangqi
							xzqhName : Ext.get('xzqh_edit').dom.value,
							xzqhCode : form.findField('xzqhCode').getValue(),
							xzqhName : Ext.get('xzqh_edit').dom.value,
							zcrq : form.findField('zcrq').getValue(),
							imageUrl : action.result.imageUrl,
							*/
							jgmc : form.findField('jgmc').getValue()
						});
						var index = store.indexOf(grid_WorkOrder.getSelectionModel().getSelected());
						store.remove(grid_WorkOrder.getSelectionModel().getSelected());
						store.insert(index,orgnew);
						grid_WorkOrder.getSelectionModel().selectRow(index);
					},
					failure : function(form, action) {
						Ext.Msg.show({
							title : '错误提示',
							msg : action.result.contentTypeIsValid ? '操作失败' : '操作失败,文件类型不正确!',
							buttons : Ext.Msg.OK,
							fn : function() {btn.enable();},
							icon : Ext.Msg.ERROR
						});
					}
				});
			}
		}
	},{
		text : '重置',
		handler : function() {
			var record = grid_WorkOrder.getSelectionModel().getSelected();
			if(record){
				workOrderEditForm.getForm().loadRecord(record);
				workOrderEditForm.getForm().findField('_companyName').setValue('');
				workOrderEditForm.getForm().findField('_deptNo').setValue('');
				workOrderEditForm.getForm().findField('upload').setValue('');
			}
		}
	}, {
		text : '取消',
		handler : function() {this.ownerCt.ownerCt.hide();}
	}]
});



//信息浏览
var  workOrderView= new Ext.Panel({
    title       : '基本信息',
    region      : 'west',
    split       : true,
    width       : 480,
    collapsible : true,
    margins     : '3 0 3 3',
    cmargins    : '3 3 3 3',
    autoScroll : true,
    items : [workOrderViewForm]
}); 

var window_do_WorkOrder = new Ext.Window({
	title : '业务审批',
	iconCls : 'icon-plugin',
	width : 1000,
	height : 600,
	resizable : true,
	modal : true,
	plain    : true,
	layout   : 'border',
	closeAction : 'hide',
	maximizable:true,
	items : [workOrderView,workOrderViewImg],
	buttons : [{
		text : '审核通过',
		handler : function(btn){
			if (workOrderViewForm.getForm().isValid()) {
				btn.disable();
				var orgid = workOrderViewForm.getForm().findField('orgid').getValue();
				ajaxLoadMask.show();
				Ext.Ajax.request({
					url: 'returnOrgnewOk.action',
	   				success: function(){
	   					ajaxLoadMask.hide();
	   					btn.enable();
						//window_do_WorkOrder.hide();
	   					workOrderViewForm.getForm().reset();
	   					scanner77179.ImageData="";
	   					scanner77179.PageType="";
						var record = grid_WorkOrder.getSelectionModel().getSelected();
		         		if(record){
							grid_WorkOrder.getStore().remove(record);
		         		}
		         		workOrderViewForm.getForm().reset();
	   				},
	   				failure: function(){
	   					ajaxLoadMask.hide();
	   					Ext.Msg.show({
							title : '提示',
							msg : '网络审核失败!',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.ERROR
						});
	   				},
	   				params: { orgid: orgid ,bzjgdm: currentZzUserBzjgdm}
				});
			}
		}
	},{
		text : '审核驳回',
		handler : function(btn){
			var record = grid_WorkOrder.getSelectionModel().getSelected();
			if(record){
				ajaxLoadMask.show();
				var orgid = record.data.orgid;
				Ext.Ajax.request({
					url: 'returnOrgnewNo.action',
	   				success: function(){
	   					ajaxLoadMask.hide();
	   					btn.enable();
						//window_do_WorkOrder.hide();
	   					workOrderViewForm.getForm().reset();
	   					scanner77179.ImageData="";
	   					scanner77179.PageType="";
						var record = grid_WorkOrder.getSelectionModel().getSelected();
		         		if(record){
							grid_WorkOrder.getStore().remove(record);
		         		}
	   				},
	   				failure: function(){
	   					ajaxLoadMask.hide();
	   					Ext.Msg.show({
							title : '提示',
							msg : '驳回失败!',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.ERROR
						});
	   				},
	   				params: { orgid: orgid}
				});
			}
		}
	},{   
        text: '前一条',   
        handler: function() {
        	 var grid_ = grid_WorkOrder;
             var selModel = grid_.getSelectionModel();
             if(selModel.hasPrevious()){
                selModel.selectPrevious();
         		var record = grid_WorkOrder.getSelectionModel().getSelected();
         		if(record){
         			workOrderViewForm.getForm().loadRecord(record);
         			window_do_WorkOrder.setTitle('业务审批--【'+record.data.jgmc+'】');
         			
         			var resultObject = null;
         			var useState=record.data.state;
						var	imgUrl='';
						imgUrl='orgnewViewImg.action';

            		Ext.Ajax.request({
    					url : imgUrl,
    					params : {orgid : record.data.orgid},
    					success : function(result,request) {//获取返回值
    					    //resultObject = eval('('+result.responseText+')');  
    	   					var resultObject = Ext.util.JSON.decode(result.responseText);  
    	   					if(resultObject!=null){
	    						scanner77179.OpenProgress(3);  //设置上传的进度条的总进度数
	    						scanner77179.Progress('原文加载中',1);
	    						scanner77179.Progress('原文加载中',2);
    		   					scanner77179.ImageData=resultObject.imageData;
    		   					if(resultObject.pageTypeStr!=""){
	   								scanner77179.PageType=resultObject.pageTypeStr;
	   							}
    		   					scanner77179.Progress('原文加载完毕',3);
    	   						scanner77179.CloseProgress();
    						}
    					},
    					failure : function() {
    						alert("图像加载错误");
    					}
    				});
         		}
             }else{
                 alert("已经到第一条,请翻页");
             }
        }   
    },{   
        text: '下一条',   
        handler: function() {
        	 var grid_ = grid_WorkOrder;
             var selModel = grid_.getSelectionModel();
             if(selModel.hasNext()){
                selModel.selectNext();
                //grid_WorkOrder.getSelectionModel().selectNext();
         		var record = grid_WorkOrder.getSelectionModel().getSelected();
         		if(record){
         			//store.remove(grid_WorkOrder.getSelectionModel().getSelected());
                 	//var next = grid_WorkOrder.selectNext(); 
                 	//if(next){grid_WorkOrder.getSelectionModel().selectRecords([next]);}
         			//window_edit_dfileManage.show();
         			workOrderViewForm.getForm().loadRecord(record);
         			window_do_WorkOrder.setTitle('业务审批--【'+record.data.jgmc+'】');
         			
         			var resultObject = null;
         			var useState=record.data.state;
						var	imgUrl='';
						imgUrl='orgnewViewImg.action';
            		Ext.Ajax.request({
    					url : imgUrl,
    					params : {orgid : record.data.orgid},
    					success : function(result,request) {//获取返回值
    					    //resultObject = eval('('+result.responseText+')');  
    	   					var resultObject = Ext.util.JSON.decode(result.responseText);  
    	   					if(resultObject!=null){
	    						scanner77179.OpenProgress(3);  //设置上传的进度条的总进度数
	    						scanner77179.Progress('原文加载中',1);
	    						scanner77179.Progress('原文加载中',2);
    		   					scanner77179.ImageData=resultObject.imageData;
    		   					if(resultObject.pageTypeStr!=""){
	   								scanner77179.PageType=resultObject.pageTypeStr;
	   							}
    		   					scanner77179.Progress('原文加载完毕',3);
    	   						scanner77179.CloseProgress();
    						}
    					},
    					failure : function() {
    						alert("图像加载错误");
    					}
    				});
         		}
             }else{
                 alert("已经到最后一条,请翻页");
             }
        }   
    },{   
        text: '重载原文',   
        handler: function() {
        	var record = grid_WorkOrder.getSelectionModel().getSelected();
        	if(record){
        		var resultObject = null;
        		var useState=record.data.state;
				var	imgUrl='';
				imgUrl='orgnewViewImg.action';

        		Ext.Ajax.request({
					url : imgUrl,
					params : {orgid : record.data.orgid},
					success : function(result,request) {//获取返回值
					    //resultObject = eval('('+result.responseText+')');  
	   					var resultObject = Ext.util.JSON.decode(result.responseText);  
	   					if(resultObject!=null){
							scanner77179.OpenProgress(3);  //设置上传的进度条的总进度数
							scanner77179.Progress('原文加载中',1);
							scanner77179.Progress('原文加载中',2);
		   					scanner77179.ImageData=resultObject.imageData;
		   					if(resultObject.pageTypeStr!=""){
   								scanner77179.PageType=resultObject.pageTypeStr;
   							}
		   					scanner77179.Progress('原文加载完毕',3);
	   						scanner77179.CloseProgress();
						}
					},
					failure : function() {
						alert("图像加载错误");
					}
				});
	        	
			}else{
                alert("请选择条目！");
            }
        }   
    },{   
        text: '退出',   
        handler: function() {   
        	window_do_WorkOrder.hide(); 
        }   
    }],
    listeners : {
    	'activate' : function() {
	    	var record = grid_WorkOrder.getSelectionModel().getSelected();
	    	if(record){
	    		var resultObject = null;
	    		var useState=record.data.state;
				var	imgUrl='';
				imgUrl='orgnewViewImg.action';

	    		Ext.Ajax.request({
					url : imgUrl,
					params : {orgid : record.data.orgid},
					success : function(result,request) {//获取返回值
						scanner77179.ImageData="";
						var resultObject = Ext.util.JSON.decode(result.responseText);
						if(resultObject!=null){
							scanner77179.OpenProgress(3);  //设置上传的进度条的总进度数
							scanner77179.Progress('原文加载中',1);
							scanner77179.Progress('原文加载中',2);
		   					scanner77179.ImageData=resultObject.imageData;
	   						if(scanner77179.ImageData!=""){
	   							if(resultObject.pageTypeStr!=""){
	   								scanner77179.PageType=resultObject.pageTypeStr;
	   							}
	   							scanner77179.Progress('原文加载完毕',3);
		   						scanner77179.CloseProgress();
	   						}else{
	   							scanner77179.Progress('原文加载失败',3);
		   						scanner77179.CloseProgress();
		   						alert("原文错误，加载失败，请重新扫描或导入！");
	   						}
						}
					},
					failure : function() {
						alert("图像加载错误");
					}
				});
	        	
			}else{
	            alert("请重新选择条目！");
	        }
    	}
    }   
});


var ds_user_select = new Ext.data.Store({
	url : 'findUserByExample.action',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'userId',type : 'int'}, 
		{name : 'emplName',type : 'string'}
	])
})


//---------------------- 定义工具栏按钮事件 ------------------------------------------------------
var window_edit_workorder = new Ext.Window({
	title : '业务审批--信息修改',
	width : 800,
	resizable : true,
	autoHeight : true,
	autoScroll : true, 
	modal : true,
	closeAction : 'hide',
	items : [workOrderEditForm]
	
});

var btn_loan_workorder = new Ext.Button({
	text : '预约日期',
	iconCls : 'icon-datetime',
	disabled:true,
	handler : function(){
		var record = grid_WorkOrder.getSelectionModel().getSelected();
		if(record){
			window_loan_workorder.show();
			loanLogForm.getForm().findField('loanLog.orgid').setValue(record.data.orgid);
			loanLogForm.getForm().findField('loanLog.orgnewName').setValue(record.data.orgnewName);
			loanLogForm.getForm().findField('_jgmc').setValue(record.data.orgnewName);
		}
	}
});


var btn_return_workorder_ok = new Ext.Button({
	text : '网审通过',
	iconCls : 'icon-save',
	disabled:true,
	handler : function(){
		var record = grid_WorkOrder.getSelectionModel().getSelected();
		if(record){
			ajaxLoadMask.show();
			var orgid = record.data.orgid;
			Ext.Ajax.request({
				url: 'returnOrgnewOk.action',
   				success: function(){
   					ajaxLoadMask.hide();
   					Ext.Msg.show({
						title : '提示',
						msg : '审查通过!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.INFO,
						fn : function(){
							record.set('state',1);
							//record.set('currentReader',''),
							//grid_WorkOrder.fireEvent('rowclick',grid_WorkOrder,grid_WorkOrder.getStore().indexOf(record));
							grid_WorkOrder.getStore().remove(record);
						}
					});
   				},
   				failure: function(){
   					ajaxLoadMask.hide();
   					Ext.Msg.show({
						title : '提示',
						msg : '审查操作失败!!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
   				},
   				params: { orgid: orgid}
			});
		}
	}
});

var btn_return_workorder_no = new Ext.Button({
	text : '网审驳回',
	iconCls : 'icon-put',
	disabled:true,
	handler : function(){
		var record = grid_WorkOrder.getSelectionModel().getSelected();
		if(record){
			ajaxLoadMask.show();
			var orgid = record.data.orgid;
			Ext.Ajax.request({
				url: 'returnOrgnewNo.action',
   				success: function(){
   					ajaxLoadMask.hide();
   					Ext.Msg.show({
						title : '提示',
						msg : '驳回成功!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.INFO,
						fn : function(){
							//更新修改行的值
							//record.set('state',1);
							//grid_WorkOrder.fireEvent('rowclick',grid_WorkOrder,grid_WorkOrder.getStore().indexOf(record));
							grid_WorkOrder.getStore().remove(record);
							
						}
					});
   				},
   				failure: function(){
   					ajaxLoadMask.hide();
   					Ext.Msg.show({
						title : '提示',
						msg : '驳回失败!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
   				},
   				params: { orgid: orgid}
			});
		}
	}
});


var btn_return_workorder_do = new Ext.Button({
	text : '办理网审',
	iconCls : 'icon-put',
	handler : function(){
		var record = grid_WorkOrder.getSelectionModel().getSelected();
		if(record){
			window_do_WorkOrder.show();
			workOrderViewForm.getForm().loadRecord(record);
			window_do_WorkOrder.setTitle('业务审批--【'+record.data.jgmc+'】--'+record.data.ywlx);
    		
		}else{
			Ext.Msg.show({
				title : '提示',
				msg : '请选择数据!',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.INFO
			});
		}
	}
});

var btn_scanImage = new Ext.Button({
	text : '扫描',
	iconCls : 'icon-scan',
	handler : function() {
		window.open("NKOScanProj.jsp")
	}
});


var btn_edit_workorder = new Ext.Button({
	text : '编辑',
	iconCls : 'icon-edit',
	disabled:true,
	handler : function(){
		var record = grid_WorkOrder.getSelectionModel().getSelected();
		if(record){
			window_edit_workorder.show();
			workOrderEditForm.getForm().loadRecord(record);
		}
	}
})

var btn_del_workorder = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	disabled:true,
	handler : function() {
		var record = grid_WorkOrder.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该件工单?', function(btn) {
				if (btn == 'yes') {
					ajaxLoadMask.show();
					Ext.Ajax.request({
						url : 'deleteOrgnew.action',
						params : {orgid : record.data.orgid},
						success : function() {ajaxLoadMask.hide();grid_WorkOrder.getStore().remove(record);},
						failure : function() {
							ajaxLoadMask.hide();
							Ext.Msg.show({
								title : '错误提示',
								msg : '删除时发生错误!',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR
							});
						}
					});
				}
			});
		}
	}
});


//默认查询 limit为显示的条数
var searchWorkOrder = function() {
	ds_workorder.baseParams.conditions = text_search_workorder.getValue();
	ds_workorder.baseParams.userName=currentZzUsername;
	//控制需要显示那些状态的数据
	if(currentZzUserBzjgdm==currentZzUserCenterid){//中心用户：
		ds_workorder.baseParams.bzjgdm=currentZzUserCenterid;
		ds_workorder.baseParams.stateConditions='2,3';
	}else{
		ds_workorder.baseParams.bzjgdm=currentZzUserBzjgdm;
		ds_workorder.baseParams.stateConditions='2';
	}
	ds_workorder.baseParams.ywlxConditions='';
	ds_workorder.load({params : {start : 0,limit : useFullPageSize} });

}



//查询返回结果的数据列
var ds_workorder = new Ext.data.Store({
	url : 'findShenheNetAllOrgnew.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'orgid',type : 'int'}, 
	    {name : 'orderid',type : 'string'}, 
	    {name : 'centerid',type : 'string'},
	    {name : 'docid',type : 'string'},
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
		{name : 'zslsh',type : 'string'},
		{name : 'bzrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'njqx',type: 'date', convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'njrq',type: 'date', convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zch',type : 'string'},
		{name : 'pzwh',type : 'string'},
		{name : 'pwrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
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
		{name : 'isxw',type : 'string'},
		{name : 'fkbz',type : 'string'},
		{name : 'fksl',type : 'int'},
		{name : 'zsbfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zszfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'memo2',type : 'string'},
		{name : 'tbrzjlx',type : 'string'},
		{name : 'memo',type : 'string'},
		{name : 'name',type : 'string'},
		{name : 'username',type : 'string'},
		{name : 'handleName',type : 'string'},
		{name : 'handleDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'handleNote',type : 'string'},
		{name : 'auditName',type : 'string'},
		{name : 'auditDate',type : 'date',convert:function(v){if(v) return v.substring(0,16);}},
		{name : 'auditNote',type : 'string'},
		
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

var btn_search_workorder = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchWorkOrder();
		//btn_add_workorder.setDisabled(false);
		btn_edit_workorder.setDisabled(true);
		//btn_return_workorder.setDisabled(true);
	}
});

var btn_refresh_workorder = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchWorkOrderid.value='';
		searchWorkOrder();
		//btn_add_workorder.setDisabled(true);
		btn_edit_workorder.setDisabled(true);
		btn_return_workorder_no.setDisabled(true);
		btn_return_workorder_ok.setDisabled(true);
	}
});


var text_search_workorder = new Ext.form.TextField({
	id:'textSearchWorkOrderid',
	name : 'textSearchWorkOrder',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchWorkOrder();
			}
		}
	}
});

//加载右栏主页面   （数据列表、工具栏按钮）
var grid_WorkOrder = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	//autoHeight : true,
	cm : cm_workorder,
	ds : ds_workorder,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'state',
	viewConfig : {forceFit : true},
	plugins : expander_zwo,
	tbar :[btn_edit_workorder,btn_del_workorder,btn_refresh_workorder,'-',btn_return_workorder_do,'->', 
		  	text_search_workorder,btn_search_workorder],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_workorder,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			btn_edit_workorder.setDisabled(false);
			btn_del_workorder.setDisabled(false);
		},
		'rowdblclick':function(grid, rowIndex){
			var record = grid_WorkOrder.getSelectionModel().getSelected();
			if(record){
				window_do_WorkOrder.show();
				workOrderViewForm.getForm().loadRecord(record);
				window_do_WorkOrder.setTitle('业务审批--【'+record.data.jgmc+'】--'+record.data.ywlx);

			}
		}
	}
});

var dateFormatShzt = function(v){
	if(v){
		return v.substring(0,10)
	}
	return '未审批';
}

var dateFormat = function(v){
	if(v){
		return v.substring(0,10)
	}
	return '未审批';
}


function linker(value,p,record)
{
   var fileUrl;
   fileUrl=record.data["bookId"] +'/'+ record.data["logId"]+'.jpg';
   if(typeof val!=''){
	   return String.format('<a style="display:table;width:100%;" onclick=viewPic("'+record.data["bookName"]+'","file/2012/'+fileUrl+'")>'+ record.data["bookName"]+'</a>',record.data.ID);
   		//return String.format('<a style="display:table;width:100%;" target="_blank" href="file/2012/' + record.data["bookId"] +'/'+ record.data["logId"]+'.jpg" >'+ record.data["bookName"]+'</a>',record.data.ID)
	}
	return val;
};



var zzWorkOrder_panel = new Ext.Panel({
	title : '网上业务审批',
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
	    items : [grid_WorkOrder]
	}]
});

var p_zzWorkOrder = {
	id : 'zzWorkOrder-panel',
	border : false,
	layout : 'border',
	items : [zzWorkOrder_panel]
};