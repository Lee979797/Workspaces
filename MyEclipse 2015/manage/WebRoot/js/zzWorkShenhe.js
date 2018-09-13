
var btn_search_jglxSelcet_zwsh = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJglxSelcet_zwsh();
	}
});

var text_search_jglxSelcet_zwsh = new Ext.form.TextField({
	id : 'btn_search_jglxSelcet_zwsh',
	name : 'btn_search_jglxSelcet_zwsh',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJglxSelcet_zwsh();
			}
		},
		'change' : function(field, e) {
			btn_search_jglxSelcet_zwsh.setDisabled(false);
		}
	}
});


var cm_jglxSelcet_zwsh = new Ext.grid.ColumnModel([
    {header : '一级类型',width : 30,dataIndex : 'pjglxmc',sortable : true}, 
	{header : '二级类型',width : 100,dataIndex : 'jglxmc',sortable : true}, 
	{header : '代码',width : 30,dataIndex : 'jglxdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_jglxSelcet_zwsh = new Ext.data.Store({
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

var searchJglxSelcet_zwsh = function() {
	ds_jglxSelcet_zwsh.baseParams.conditions = text_search_jglxSelcet_zwsh.getValue();
	ds_jglxSelcet_zwsh.baseParams.username="";
	ds_jglxSelcet_zwsh.baseParams.stateConditions='';
	ds_jglxSelcet_zwsh.load({params : {start : 0,limit : 20} });
}

var grid_jglx_zwsh = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jglxSelcet_zwsh,
	ds : ds_jglxSelcet_zwsh,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入机构类型名称：',text_search_jglxSelcet_zwsh,btn_search_jglxSelcet_zwsh],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jglxSelcet_zwsh,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jglxQuery_zwsh.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			workShenheViewForm.getForm().findField('jglxmc_zwsh').setValue(selections[0].get('jglxmc'));
			workShenheViewForm.getForm().findField('select_jglxdm_zwsh').setValue(selections[0].get('jglxdm'));
		}
	}
});


var window_jglxQuery_zwsh = new Ext.Window({
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
	items : [grid_jglx_zwsh]
});



var btn_search_hylxSelcet_zwsh = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchHylxSelcet_zwsh();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_hylxSelcet_zwsh = new Ext.form.TextField({
	id : 'textSearchHylxSelcet_zwsh',
	name : 'textSearchHylxSelcet_zwsh',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchHylxSelcet_zwsh();
			}
		},
		'change' : function(field, e) {
			btn_search_hylxSelcet_zwsh.setDisabled(false);
		}
	}
});


var cm_hylxSelcet_zwsh = new Ext.grid.ColumnModel([
	{header : '大类',width : 30,dataIndex : 'hylxmc1',sortable : true}, 
	{header : '中类',width : 100,dataIndex : 'hylxmc2',sortable : true}, 
	{header : '小类',width : 30,dataIndex : 'hylxmc3',sortable : true}, 
    {header : '经济行业名称',width : 30,dataIndex : 'hylxmc',sortable : true},
	{header : '经济行业代码',width : 30,dataIndex : 'hylxdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_hylxSelcet_zwsh = new Ext.data.Store({
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

var searchHylxSelcet_zwsh = function() {
	ds_hylxSelcet_zwsh.baseParams.conditions = text_search_hylxSelcet_zwsh.getValue();
	ds_hylxSelcet_zwsh.baseParams.username="";
	ds_hylxSelcet_zwsh.baseParams.stateConditions='';
	ds_hylxSelcet_zwsh.load({params : {start : 0,limit : 20} });
}

var grid_hylx_zwsh = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_hylxSelcet_zwsh,
	ds : ds_hylxSelcet_zwsh,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入经济行业代码名称：',text_search_hylxSelcet_zwsh,btn_search_hylxSelcet_zwsh],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_hylxSelcet_zwsh,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_hylxQuery_zwsh.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			workShenheViewForm.getForm().findField('jjhymc_zwsh').setValue(selections[0].get('hylxmc'));
			workShenheViewForm.getForm().findField('select_jjhydm_zwsh').setValue(selections[0].get('hylxdm'));
		}
	}
});


var window_hylxQuery_zwsh = new Ext.Window({
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
	items : [grid_hylx_zwsh]
});



var btn_search_pzjg_zwsh = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchPzjg_select_zwsh();
		
		//btn_search_pzjg.setDisabled(true);
	}
});


var text_search_pzjg_zwsh = new Ext.form.TextField({
	id : 'textSearchPzjg',
	name : 'textSearchPzjg',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchPzjg_select_zwsh();
			}
		},
		'change' : function(field, e) {
			btn_search_pzjg_zwsh.setDisabled(false);
		}
	}
});


var cm_pzjg_zwsh = new Ext.grid.ColumnModel([
	{header : '批准机构名称',width : 50,dataIndex : 'pzjgmc',sortable : true}, 
	{header : '批准机构代码',width : 20,dataIndex : 'pzjgdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_pzjg_zwsh = new Ext.data.Store({
	url : 'findAllByConditionPzjg.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'pzjgid',type : 'int'}, 
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchPzjg_select_zwsh = function() {
	ds_pzjg_zwsh.baseParams.conditions = text_search_pzjg_zwsh.getValue();
	ds_pzjg_zwsh.baseParams.username='';
	ds_pzjg_zwsh.baseParams.stateConditions='';
	ds_pzjg_zwsh.load({params : {start : 0,limit : 20} });
}




//-----------------------点击列表信息，显示图书的扩展属性-----------------------
var expander_zwsh = new Ext.grid.RowExpander({
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
var imageView_window_workShenhe = new Ext.Window({   
    id: 'image-window_7000',   
    title : '原文预览',   
    width : 900,   
    height : 600,   
    resizable : true, 
    maximizable:true,
    closeAction :'hide',
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"   width=100%  height=100% align=center hspace=0 vspace=0 id="scanner77177"  name="scanner77177" >'
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
					
					var record = grid_workShenhe.getSelectionModel().getSelected();
				    //Ext.MessageBox.alert("提示","您选择的出版号是："+record2.data.fddbr); 
					btn.disable();
					strOrgid = record.data.orgid;  //参数orgid
					strDocid = record.data.docid; 
					strBzjgdm = record.data.bzjgdm;
					
					//alert(record.data.imageData);
					packLength = 40960;	//定义每个包的大小40960
					//scanner77177.ImageData=record.data.imageData;
					base64file = scanner77177.ImageData;  //获取控件扫描的图片数据
					var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
					imageCount = scanner77177.GetPageCount;	//获取扫描图片的页数
					pageTypeStr = scanner77177.PageType;    //获取标识字符串,需要写数据库
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
					scanner77177.OpenProgress(packCount);  //设置上传的进度条的总进度数
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
							xmlhttp.open("post", "saveImageOrgnew.action?orgid="+strOrgid+"&docid="+strDocid+"&packindex="+i+"&pageTypeStr="+pageTypeStr+"&bzjgdm="+strBzjgdm+"&lastpack="+lastpack, false);
							xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   //这句必须要，而且一定要放在send以前
							xmlhttp.send("imageData=" + encodeURIComponent(pack)); 
                            //alert(xmlhttp.responseText);
							var objs = eval("["+xmlhttp.responseText+"]");
							if(objs[0].success)
							{
								scanner77177.Progress('上传中',i+1);
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
		    	   var record = grid_workShenhe.getSelectionModel().getSelected();
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
								scanner77177.OpenProgress(3);  //设置上传的进度条的总进度数
								scanner77177.Progress('原文加载中',1);
								scanner77177.Progress('原文加载中',2);
							    //resultObject = eval('('+result.responseText+')');  
			   					scanner77177.ImageData=resultObject.imageData;
		   						if(scanner77177.ImageData!=""){
		   							scanner77177.PageType=resultObject.pageTypeStr;
		   							scanner77177.Progress('原文加载完毕',3);
		   						}else{
		   							scanner77177.Progress('原文加载失败',3);
			   						alert("原文错误，加载失败，请重新扫描或导入！");
		   						}
		   						scanner77177.CloseProgress();
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
	            imageView_window_workShenhe.hide();   
	        }
	   }],
	   listeners : {
			'activate' : function() {  //标签激活后自动加载数据
				var record = grid_workShenhe.getSelectionModel().getSelected();
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
							scanner77177.OpenProgress(3);  //设置上传的进度条的总进度数
							scanner77177.Progress('原文加载中',1);
							scanner77177.Progress('原文加载中',2);
						    //resultObject = eval('('+result.responseText+')');  
		   					scanner77177.ImageData=resultObject.imageData;
	   						if(scanner77177.ImageData!=""){
	   							scanner77177.PageType=resultObject.pageTypeStr;
	   							scanner77177.Progress('原文加载完毕',3);
		   						scanner77177.CloseProgress();
	   						}else{
	   							scanner77177.Progress('原文加载失败',3);
		   						scanner77177.CloseProgress();
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
function viewPic_workShenhe()
{
	imageView_window_workShenhe.show(); 
	imageView_window_workShenhe.setTitle('原文预览');
}
//---------------------- 列表显示原文的标识 ------------------------------------
function icon_workShenhe(value,p,record){
	if(typeof record=='object'){
		var fileUrl;
		fileUrl=record.data["imageData"];
		//alert(fileUrl);
		if(fileUrl!=''){
			return String.format('<a style="display:table;width:100%;" onclick="viewPic_workShenhe()"><img src="images/file_ico.gif"></a>',record.data["orgid"]);
		}
	}  
}


//---------------------- 列表显示主要数据信息 ----------------------------------
// 列表显示机构的主要信息 yangqi
var sm_zwsh = new Ext.grid.CheckboxSelectionModel();
var cm_workShenhe = new Ext.grid.ColumnModel([expander_zwsh,
	sm_zwsh,
	{header : '原文',width : 20,dataIndex : 'imageUrl', renderer:icon_workShenhe,sortable : false},
	{header : '流水号',width : 60,dataIndex : 'orderid',sortable : true}, 
	{header : '机构名称',width : 180,dataIndex : 'jgmc',sortable : true},
	{header : '机构代码',width : 40,dataIndex : 'jgdm',sortable : true},
	{header : '法定代表人/负责人',width : 60,dataIndex : 'fddbr',sortable : true}, 
	{header : '办证机构代码',width : 40,dataIndex : 'bzjgdm',sortable : true},
	{header : '申请人',width : 40,dataIndex : 'handleName',sortable : true},
	{header : '申请日期',width : 90,dataIndex : 'handleDate',sortable : true},
	{header : '业务类型',width : 40,dataIndex : 'ywlx',sortable : true},
	{header : '业务状态',width : 40,dataIndex : 'state',renderer : goState,menuDisabled : true}
]);

var workShenheViewForm = new Ext.FormPanel({	
	url : 'updateOrgnew.action',
	labelAlign : 'right',
	labelWidth : 80,
	border : false,
	baseCls : 'x-plain',
	waitMsgTarget: true,
	layout: 'fit',
	items:[{
            layout:'column',
            border:false,
            autoScroll : true,
            baseCls : 'x-plain',
            bodyStyle:'padding:10px',
            items:[{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '业务类型',name : 'ywlx',id:'ywlx_zwsh',labelSeparator:'',readOnly:true,maxLength : 100,anchor:'99.9%'},
                {xtype:'hidden',name : 'orgid'}
                ]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '小微企业',name : 'isxw',id:'isxw_zwsh',labelSeparator:'',readOnly:true,maxLength : 20,anchor:'99.9%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '机构类型',name : 'jglxdm',labelSeparator:'',readOnly:true,anchor:'99.9%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '机构类型名称',name : 'jglx',hideLabel:true,labelSeparator:'',readOnly:true,anchor:'99.9%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '正本数量',name : 'zbsl',id:'zbsl_zwsh',labelSeparator:'',xtype : 'numberfield',maxValue : 2000000000,readOnly:true,anchor:'99.9%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '副本数量',name : 'fbsl',id:'fbsl_zwsh',labelSeparator:'',xtype : 'numberfield',maxValue : 2000000000,anchor:'99.9%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '是否发卡',	name : 'fkbz',id:'fkbz_zwsh',labelSeparator:'',readOnly:true,maxLength : 20,anchor:'99.9%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '发卡数量',name : 'fksl',id:'fksl_zwsh',labelSeparator:'',xtype : 'numberfield',value:1,maxValue : 2000000000,anchor:'99.9%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构代码',id:'jgdm_zwsh',name : 'jgdm',labelSeparator:'',vtype:'verifyCode',readOnly:'true',maxLength : 9,minLength:9,anchor:'99.9%'}]
			},{
                columnWidth:.75,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构名称',id:'jgmc_zwsh',name : 'jgmc',labelSeparator:'',allowBlank : false,maxLength : 100,anchor:'99.9%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '法定代表人',id:'fddbr_zwsh',name : 'fddbr',labelSeparator:'',maxLength : 30,anchor:'99.9%'}]
			},{
                columnWidth:.25, 
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '证件类型',id:'zjlx_zwsh',name : 'zjlx',labelSeparator:'',maxLength : 25,anchor:'99.9%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '证件号码',name : 'zjhm',id : 'zjhm_zwsh',labelSeparator:'',hideLabel:true,/*confirmTo:'zjlx_xinban',vtype:'sfzhao',*/maxLength : 25,anchor:'99.9%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '移动电话',id : 'mobile_zwsh',name : 'mobile',labelSeparator:'',vtype:'mobilephone',maxLength:11,minLength:11,anchor:'99.9%'}]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                defaultType : 'textarea',
                items: [{fieldLabel : '经营范围',id : 'jyfw_zwsh',name : 'jyfw',labelSeparator:'',maxLength:1000,height:55,anchor:'99.5%'}]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                defaultType : 'textarea',
                items: [{fieldLabel : '企业简介',id : 'qyjj_zwsh',name : 'qyjj',labelSeparator:'',maxLength:1000,height:55,anchor:'99.5%'}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '成立日期',id:'zcrq_zwsh',name : 'zcrq',labelSeparator:'',maxLength : 10,anchor:'99.9%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                 bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '职工人数(人)',id:'zgrs_zwsh',name : 'zgrs',labelSeparator:'',xtype : 'numberfield',maxValue : 2000000000,anchor:'99.9%'}]
	        },{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '证照有效期',id:'zsbfrq_zwsh',name : 'zsbfrq',labelSeparator:'',maxLength : 10,anchor:'99.9%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '至',id:'zszfrq_zwsh',name : 'zszfrq',labelSeparator:'',maxLength : 10,anchor:'99.9%'}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '企业注册类型',id:'jjlxdm_zwsh',name : 'jjlxdm',labelSeparator:'',maxLength : 50,anchor:'99.9%'}]
			},{
	             columnWidth:.5,
	             layout: 'form',
	             bodyStyle: 'padding:0px',
	             border:false,
	             items: [{xtype:'textfield',fieldLabel : '企业注册类型名称',id:"jjlxmc_zwsh",name : 'jjlx',readOnly:true,labelSeparator:'',hideLabel:true,anchor:'99.9%'}]
	        },{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '经济行业',id:'jjhydm_zwsh',name : 'jjhydm',labelSeparator:'',maxLength : 50,anchor:'99.9%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '经济行业名称',id:"jjhymc_zwsh",name : 'jjhymc',readOnly:true,labelSeparator:'',hideLabel:true,anchor:'99.9%'}]
	        },{
                columnWidth:.3,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '注册资金(万)',id:"zczj_zwsh",name : 'zczj',labelSeparator:'',xtype : 'numberfield',decimalPrecision :6,maxValue : 2000000000,anchor:'99.9%'}]
	        },{
                columnWidth:.2,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '货币种类',id:'hbzl_zwsh',name : 'hbzl',labelSeparator:'',maxLength : 50,anchor:'99.9%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '外方国别',id:'wftzgb_zwsh',name : 'wftzgb',labelSeparator:'',maxLength : 50,anchor:'99.9%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '外方国别代码',id:'wftzgbdm_zwsh',name:'wftzgbdm',labelSeparator:'',hideLabel:true,allowBlank : true,anchor:'99.9%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '主管部门代码',id:'zgdm_zwsh',name:'zgdm',labelSeparator:'',maxLength:9,anchor:'99.9%'}]
			},{
                columnWidth:.75,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '主管部门名称',id:'zgmc_zwsh',name :'zgmc',labelSeparator:'',hideLabel:true,anchor:'99.9%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '批准机构',id:'pzjgdm_zwsh',name :'pzjgdm',allowBlank : false,labelSeparator:'',anchor:'99.9%'}]
            },{
                columnWidth:.75,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '批准机构名称',name:'pzjgmc',labelSeparator:'',id:"pzjgmc_zwsh",allowBlank : false,hideLabel:true,anchor:'99.9%'}]
            },{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '注册号',name : 'zch',id:"zch_zwsh",labelSeparator:'',maxLength : 50,anchor:'99.9%'}]
            },{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '固定电话',name : 'dhhm',id:"dhhm_zwsh",labelSeparator:'',vtype:'phone',maxLength : 50,anchor:'99.9%'}]
            },{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构注册地址',name : 'jgdz',id:"jgdz_zwsh",labelSeparator:'',maxLength : 100,anchor:'99.9%'}
                ]
            },{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '行政区划',name : 'xzqhCode',id:"xzqhCode_zwsh",labelSeparator:'',maxLength : 100,anchor:'99.9%'}]
            },{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '行政区划代码',id:'xzqhName_zwsh',name : 'xzqhName',labelSeparator:'',hideLabel:true,readOnly:true,maxLength : 50,anchor:'99.9%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '邮政编码',name : 'yzbm',id:'yzbm_zwsh',labelSeparator:'',minLength : 6,maxLength : 6,anchor:'99.9%'}]
            },{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构实际地址',name : 'jydz',id:"jydz_zwsh",labelSeparator:'',maxLength : 100,anchor:'99.9%'}
                ]
            },{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '行政区划',name : 'xzqhCode2',id:"xzqhCode2_zwsh",labelSeparator:'',maxLength : 100,anchor:'99.9%'}]
            },{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '行政区划代码',id:'xzqhName2_zwsh',name : 'xzqhName2',labelSeparator:'',hideLabel:true,readOnly:true,maxLength : 50,anchor:'99.9%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '邮政编码',name : 'jyyb',id:'jyyb_zwsh',labelSeparator:'',minLength : 6,maxLength : 6,anchor:'99.9%'}]
            },{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '网址',name : 'weburl',id:'weburl_zwsh',labelSeparator:'',maxLength : 50,anchor:'99.9%'}]
            },{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '电子邮箱',name : 'email',id:'email_zwsh',labelSeparator:'',vtype:'email',vtypeText:'不是有效的邮箱地址',maxLength : 50,anchor:'99.9%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '经办人',name : 'tbrxm',id:'tbrxm_zwsh',labelSeparator:'',maxLength : 30,anchor:'99.9%'}]
			},
			{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '证件类型',name : 'tbrzjlx',id:'tbrzjlx_zwsh',labelSeparator:'',maxLength : 30,anchor:'99.9%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '证件号码',name : 'tbrsfzh',id:'tbrsfzh_zwsh',labelSeparator:'',hideLabel:true,maxLength : 50,anchor:'99.9%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '经办人电话',name : 'tbrlxfs',id:'tbrlxfs_zwsh',labelSeparator:'',vtype:'dhhmphone',maxLength : 50,anchor:'99.9%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '办证日期',name : 'bzrq',id:'bzrq_zwsh',labelSeparator:'',maxLength : 10,anchor:'99.9%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '作废日期',name : 'zfrq',id:'zfrq_zwsh',labelSeparator:'',maxLength : 10,anchor:'99.9%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '年检期限',name : 'njqx',id:'njqx_zwsh',labelSeparator:'',maxLength : 10,anchor:'99.9%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '是否公开',name : 'gk',id:'gk_zwsh',labelSeparator:'',readOnly:true,maxLength : 20,anchor:'99.9%'}]
			},{
				columnWidth : 1,
				xtype : 'panel',
				baseCls : 'x-plain',
				bodyBorder : false,
				bodyStyle: 'padding:0px',
				layout : 'form',
				defaultType : 'textarea',
				items : [{fieldLabel : '审核意见',name : 'auditNote',labelSeparator:'',height:40,maxLength : 250,anchor : '99.5%'}]
			}]
		}]
});

//图像浏览
var workShenheViewImg = new Ext.Panel({
	title   : '原文浏览',
    split: true,
	width:600,
	collapsible:true,
	collapsed: false,//是否默认打开
    region:'east',
    margins   : '3 3 3 0', 
    cmargins  : '3 3 3 3',
    activeTab : 0,
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"   width=100%  height=100% align=center hspace=0 vspace=0 id="scanner74179"  name="scanner74179" >'
	       +'<param name="ShowCount" value="1">'
	       +'<param name="sModel" value="0">'
	       +'</OBJECT>'
});

//--------------------修改新办申请机构信息-------------------------------------------
var workShenheEditForm = new Ext.FormPanel({
	loadMask : {
		msg : '数据加载中...'
	},
	url : 'updateOrgnew.action',
	labelAlign : 'right',
	labelWidth : 85,
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
			defaults : {anchor : '97.5%'},
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
			defaults : {anchor : '97.5%'},
			items : [{fieldLabel : '机构名称',name : 'jgmc',allowBlank : false,maxLength : 100}]
		},{
			columnWidth : .33,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '93%'},
			items : [{fieldLabel : '机构类型',name : 'jglx',allowBlank : false,maxLength : 50}]
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
					items : [{fieldLabel : '法定代表人',	name : 'fddbr',allowBlank : false,maxLength : 30}]
				},{
					columnWidth : .34,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '93%'},
					items :[{fieldLabel : '证件类型',	name : 'zjlx',allowBlank : false,maxLength : 25}]
				},{
					columnWidth : .33,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'textfield',
					defaults : {anchor : '93%'},
					items :[{fieldLabel : '证件号码',name : 'zjhm',allowBlank : false,maxLength : 25}]
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
			items : [{fieldLabel : '经营范围',name : 'jyfw',allowBlank : false,maxLength : 1000}]
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
			items : [{fieldLabel : '企业简介',name : 'qyjj',maxLength : 1000}]
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
					defaults : {anchor : '97.5%'},
					items :[{fieldLabel : '机构地址',	name : 'jgdz',allowBlank : false,maxLength : 100}]
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
				{xtype : 'hidden',name : 'xzqhName'}, 
				{xtype : 'hidden',name : 'imageUrl'},
				{fieldLabel : '职工人数',name : 'zgrs',maxLength : 50}, 
				{fieldLabel : '批准机构',name : 'pzjgmc',maxLength : 50}, 
				{fieldLabel : '经营地址',name : 'jydz',maxLength : 100}, 
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
				{fieldLabel : '主管机构名',name : 'zgmc',maxLength : 25}, 
				{fieldLabel : '批准文号',name : 'pzwh',maxLength : 25},
				{fieldLabel : '经营邮编',name : 'jyyb',maxLength : 25},  
				{fieldLabel : '身份证号码',name : 'tbrsfzh',maxLength : 25}, 
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
				{fieldLabel : '注册号',name : 'zch',maxLength : 25}, 
				{fieldLabel : '批准日期',name : 'pwrq',maxLength : 25}, 
				{fieldLabel : '经营电话',name : 'jydh',maxLength : 25},  
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
			if (workShenheEditForm.getForm().isValid()) {
				btn.disable();
				workShenheEditForm.getForm().submit({
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
						var store = grid_workShenhe.getStore();
						var orgnew = new Orgnew({
							orgid : form.findField('orgid').getValue(),
							// 数据修改自动更新表格列表本地信息
							
							fddbr : form.findField('fddbr').getValue(),
							zjlx : form.findField('zjlx').getValue(),
							zjhm : form.findField('zjhm').getValue(),
							jyfw : form.findField('jyfw').getValue(),
							qyjj : form.findField('qyjj').getValue(),
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
						var index = store.indexOf(grid_workShenhe.getSelectionModel().getSelected());
						store.remove(grid_workShenhe.getSelectionModel().getSelected());
						store.insert(index,orgnew);
						grid_workShenhe.getSelectionModel().selectRow(index);
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
			var record = grid_workShenhe.getSelectionModel().getSelected();
			if(record){
				workShenheEditForm.getForm().loadRecord(record);
				workShenheEditForm.getForm().findField('_companyName').setValue('');
				workShenheEditForm.getForm().findField('_deptNo').setValue('');
				workShenheEditForm.getForm().findField('upload').setValue('');
			}
		}
	}, {
		text : '取消',
		handler : function() {this.ownerCt.ownerCt.hide();}
	}]
});



//信息浏览
var  workShenheView= new Ext.Panel({
    title       : '基本信息',
    region:'center',
    margins     : '3 0 3 3',
    cmargins    : '3 0 3 3',
    autoScroll : true,
    bodyStyle: 'padding:0px',
    layout: 'fit',
    items : [workShenheViewForm]
}); 

var window_do_workShenhe = new Ext.Window({
	title : '现场业务审批',
	iconCls : 'icon-plugin',
	width : 1000,
	height : 600,
	resizable : true,
	modal : true,
	plain    : true,
	layout   : 'border',
	closeAction : 'hide',
	maximized :true,  //默认最大化
	//maximizable:true,  //最大化按钮
	items : [workShenheView,workShenheViewImg],
	buttons : [{
		text : '审核提醒',
		handler : function(btn){
				btn.disable();
				var strJgdm = workShenheViewForm.getForm().findField('jgdm').getValue();
				ajaxLoadMask.show();
				Ext.Ajax.request({
					url: 'verifyOrgnew.action',
	   				params: {jgdm: strJgdm},
	   				success : function(result,request) {
	   					ajaxLoadMask.hide();
	   					btn.enable();
	   					var resultObject = Ext.util.JSON.decode(result.responseText);
						if(resultObject!=null){
	   						for(var j = 0; j < resultObject.length; j++){
		   						var fieldName=resultObject[j].fieldName+'_zwsh';
		   						workShenheViewForm.getForm().findField(fieldName).addClass('txtFieldCss');
	   						}
						}
	   				},
	   				failure: function(){
	   					ajaxLoadMask.hide();
	   					btn.enable();
	   					Ext.Msg.show({
							title : '提示',
							msg : '审核信息提醒失败!',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.ERROR
						});
	   				}
				});
		}
	},{
		text : '审核通过',
		handler : function(btn){
			if (workShenheViewForm.getForm().isValid()) {
				btn.disable();
				var orgid = workShenheViewForm.getForm().findField('orgid').getValue();
				var auditNote = workShenheViewForm.getForm().findField('auditNote').getValue();
				ajaxLoadMask.show();
				Ext.Ajax.request({
					url: 'shenheOrgnewOk.action',
	   				success: function(){
	   					ajaxLoadMask.hide();
	   					btn.enable();
	   					workShenheViewForm.getForm().reset();
	   					scanner74179.ImageData="";
	   					scanner74179.PageType="";
						var record1 = grid_workShenhe.getSelectionModel().getSelected();
		         		if(record1){
		         				
		         			var selModel = grid_workShenhe.getSelectionModel();
	   						var num = selModel.lastActive;
	   						grid_workShenhe.getStore().remove(record1);
	   						selModel.selectRow(num);
	   						record = grid_workShenhe.getSelectionModel().getSelected();
	   						
	         				if(record){
			         			workShenheViewForm.getForm().loadRecord(record);
			         			window_do_workShenhe.setTitle('现场业务审批--【'+record.data.jgmc+'】');
			         			
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
				    							scanner74179.OpenProgress(3);  //设置上传的进度条的总进度数
				    							scanner74179.Progress('原文加载中',1);
				    							scanner74179.Progress('原文加载中',2);
			    		   					scanner74179.ImageData=resultObject.imageData;
			    		   					if(resultObject.pageTypeStr!=""){
				   								scanner74179.PageType=resultObject.pageTypeStr;
				   							}
			    		   					scanner74179.Progress('原文加载完毕',3);
			    	   						scanner74179.CloseProgress();
			    						}
			    					},
			    					failure : function() {
			    						alert("图像加载错误");
			    					}
			    				});
			         		}
		         		}
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
	   				params: {orgid: orgid,auditNote:auditNote}
				});
			}
		}
	},{
		text : '审核驳回',
		handler : function(btn){
			var record = grid_workShenhe.getSelectionModel().getSelected();
			if(record){
				var orgid = record.data.orgid;
				var auditNote = workShenheViewForm.getForm().findField('auditNote').getValue();
				ajaxLoadMask.show();
				Ext.Ajax.request({
					url: 'shenheOrgnewNo.action',
	   				success: function(){
	   					ajaxLoadMask.hide();
	   					btn.enable();
	   					workShenheViewForm.getForm().reset();
	   					scanner74179.ImageData="";
	   					scanner74179.PageType="";
	   					var record1 = grid_workShenhe.getSelectionModel().getSelected();
	   					if(record1){
	   						
	   						var selModel = grid_workShenhe.getSelectionModel();
	   						var num = selModel.lastActive;
	   						grid_workShenhe.getStore().remove(record1);
	   						selModel.selectRow(num);
	   						record = grid_workShenhe.getSelectionModel().getSelected();
	   					
	         				if(record){
			         			workShenheViewForm.getForm().loadRecord(record);
			         			window_do_workShenhe.setTitle('现场业务审批--【'+record.data.jgmc+'】');

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
				    							scanner74179.OpenProgress(3);  //设置上传的进度条的总进度数
				    							scanner74179.Progress('原文加载中',1);
				    							scanner74179.Progress('原文加载中',2);
			    		   					scanner74179.ImageData=resultObject.imageData;
			    		   					if(resultObject.pageTypeStr!=""){
				   								scanner74179.PageType=resultObject.pageTypeStr;
				   							}
			    		   					scanner74179.Progress('原文加载完毕',3);
			    	   						scanner74179.CloseProgress();
			    						}
			    					},
			    					failure : function() {
			    						alert("图像加载错误");
			    					}
			    				});
			         		}
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
	   				params: { orgid: orgid,auditNote:auditNote}
				});
			}
		}
	},{   
        text: '前一条',   
        handler: function() {
        	 var grid_ = grid_workShenhe;
             var selModel = grid_.getSelectionModel();
             if(selModel.hasPrevious()){
                selModel.selectPrevious();
         		var record = grid_workShenhe.getSelectionModel().getSelected();
         		if(record){
         			workShenheViewForm.getForm().loadRecord(record);
         			window_do_workShenhe.setTitle('业务审批--【'+record.data.jgmc+'】');
         			if(record.data.ywlx=="预赋码"){
//						workShenheViewForm.getForm().findField('jjhymc_zwsh').allowBlank=true;
//						workShenheViewForm.getForm().findField('jglxmc_zwsh').allowBlank=true;
//						workShenheViewForm.getForm().findField('gk_zwsh').allowBlank=true;
					}else{
//						workShenheViewForm.getForm().findField('jjhymc_zwsh').allowBlank=false;
//						workShenheViewForm.getForm().findField('jglxmc_zwsh').allowBlank=false;
//						workShenheViewForm.getForm().findField('gk_zwsh').allowBlank=false;
					}
					
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
	    							scanner74179.OpenProgress(3);  //设置上传的进度条的总进度数
	    							scanner74179.Progress('原文加载中',1);
	    							scanner74179.Progress('原文加载中',2);
    		   					scanner74179.ImageData=resultObject.imageData;
    		   					if(resultObject.pageTypeStr!=""){
	   								scanner74179.PageType=resultObject.pageTypeStr;
	   							}
    		   					scanner74179.Progress('原文加载完毕',3);
    	   						scanner74179.CloseProgress();
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
        	 var grid_ = grid_workShenhe;
             var selModel = grid_.getSelectionModel();
             if(selModel.hasNext()){
                selModel.selectNext();
         		var record = grid_workShenhe.getSelectionModel().getSelected();
         		if(record){
         			workShenheViewForm.getForm().loadRecord(record);
         			window_do_workShenhe.setTitle('现场业务审批--【'+record.data.jgmc+'】');
         			if(record.data.ywlx=="预赋码"){
//						workShenheViewForm.getForm().findField('jjhymc_zwsh').allowBlank=true;
//						workShenheViewForm.getForm().findField('jglxmc_zwsh').allowBlank=true;
//						workShenheViewForm.getForm().findField('gk_zwsh').allowBlank=true;
					}else{
//						workShenheViewForm.getForm().findField('jjhymc_zwsh').allowBlank=false;
//						workShenheViewForm.getForm().findField('jglxmc_zwsh').allowBlank=false;
//						workShenheViewForm.getForm().findField('gk_zwsh').allowBlank=false;
					}
         			
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
	    							scanner74179.OpenProgress(3);  //设置上传的进度条的总进度数
	    							scanner74179.Progress('原文加载中',1);
	    							scanner74179.Progress('原文加载中',2);
    		   					scanner74179.ImageData=resultObject.imageData;
    		   					if(resultObject.pageTypeStr!=""){
	   								scanner74179.PageType=resultObject.pageTypeStr;
	   							}
    		   					scanner74179.Progress('原文加载完毕',3);
    	   						scanner74179.CloseProgress();
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
        text: '读取原文',   
        handler: function() {
        	var record = grid_workShenhe.getSelectionModel().getSelected();
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
								scanner74179.OpenProgress(3);  //设置上传的进度条的总进度数
								scanner74179.Progress('原文加载中',1);
								scanner74179.Progress('原文加载中',2);
		   					scanner74179.ImageData=resultObject.imageData;
		   					if(resultObject.pageTypeStr!=""){
   								scanner74179.PageType=resultObject.pageTypeStr;
   							}
		   					scanner74179.Progress('原文加载完毕',3);
	   						scanner74179.CloseProgress();
							//workShenheViewImg.toggleCollapse(false);//是否打开
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
        	window_do_workShenhe.hide(); 
        }   
    }],
    listeners : {
//    	'activate' : function() {
//	    	var record = grid_workShenhe.getSelectionModel().getSelected();
//	    	if(record){
//	    		var resultObject = null;
//	    		var useState=record.data.state;
//				var	imgUrl='';
//				imgUrl='orgnewViewImg.action';
//				var ywlx=record.data.ywlx;
//	    		Ext.Ajax.request({
//					url : imgUrl,
//					params : {orgid : record.data.orgid},
//					success : function(result,request) {//获取返回值
//						scanner74179.ImageData="";
//						var resultObject = Ext.util.JSON.decode(result.responseText);
//						if(resultObject!=null){
//							scanner74179.OpenProgress(3);  //设置上传的进度条的总进度数
//							scanner74179.Progress('原文加载中',1);
//							scanner74179.Progress('原文加载中',2);
//		   					scanner74179.ImageData=resultObject.imageData;
//	   						if(scanner74179.ImageData!=""){
//	   							if(resultObject.pageTypeStr!=""){
//	   								scanner74179.PageType=resultObject.pageTypeStr;
//	   							}
//	   							scanner74179.Progress('原文加载完毕',3);
//		   						scanner74179.CloseProgress();
//	   						}else{
//	   							scanner74179.Progress('原文加载失败',3);
//		   						scanner74179.CloseProgress();
//		   						alert("原文错误，加载失败，请重新扫描或导入！");
//	   						}
//						}
//						
//						
//					},
//					failure : function() {
//						alert("图像加载错误");
//					}
//				});
//	        	
//			}else{
//	            alert("请重新选择条目！");
//	        }
//    	}
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
var window_edit_workShenhe = new Ext.Window({
	title : '业务审批--信息修改',
	width : 900,
	resizable : true,
	autoHeight : true,
	autoScroll : true, 
	modal : true,
	resizable : true, 
	maximizable:true,
	closeAction : 'hide',
	items : [workShenheEditForm]
});

var btn_loan_workShenhe = new Ext.Button({
	text : '预约日期',
	iconCls : 'icon-datetime',
	disabled:true,
	handler : function(){
		var record = grid_workShenhe.getSelectionModel().getSelected();
		if(record){
			window_loan_workShenhe.show();
			loanLogForm.getForm().findField('loanLog.orgid').setValue(record.data.orgid);
			loanLogForm.getForm().findField('loanLog.orgnewName').setValue(record.data.orgnewName);
			loanLogForm.getForm().findField('_jgmc').setValue(record.data.orgnewName);
		}
	}
});


var btn_return_workShenhe_ok = new Ext.Button({
	text : '审批通过',
	iconCls : 'icon-save',
	disabled:true,
	handler : function(){
		var record = grid_workShenhe.getSelectionModel().getSelected();
		if(record){
			var orgid = record.data.orgid;
			ajaxLoadMask.show();
			Ext.Ajax.request({
				url: 'shenheOrgnewOk.action',
   				success: function(){
   					ajaxLoadMask.hide();
   					Ext.Msg.show({
						title : '提示',
						msg : '审批通过!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.INFO,
						fn : function(){
							grid_workShenhe.getStore().remove(record);
						}
					});
   				},
   				failure: function(){
   					ajaxLoadMask.hide();
   					Ext.Msg.show({
						title : '提示',
						msg : '审批操作失败!!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
   				},
   				params: { orgid: orgid}
			});
		}
	}
});

var btn_return_workShenhe_no = new Ext.Button({
	text : '审批驳回',
	iconCls : 'icon-put',
	disabled:true,
	handler : function(){
		var record = grid_workShenhe.getSelectionModel().getSelected();
		if(record){
			var orgid = record.data.orgid;
			ajaxLoadMask.show();
			Ext.Ajax.request({
				url: 'shenheOrgnewNo.action',
   				success: function(){
   					ajaxLoadMask.hide();
   					Ext.Msg.show({
						title : '提示',
						msg : '审批驳回成功!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.INFO,
						fn : function(){
							grid_workShenhe.getStore().remove(record);
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


var btn_return_workShenhe_do = new Ext.Button({
	text : '办理审批',
	iconCls : 'icon-put',
	handler : function(){
		var record = grid_workShenhe.getSelectionModel().getSelected();
		if(record){
			window_do_workShenhe.show();
			//window_do_workShenhe.setWidth('1240');
			//workShenheView.setWidth('600');
			workShenheViewForm.getForm().loadRecord(record);
			window_do_workShenhe.setTitle('现场业务审批--【'+record.data.jgmc+'】--'+record.data.ywlx);
    		if(record.data.ywlx=="预赋码"){
				//workShenheViewForm.getForm().findField('jjhymc_zwsh').allowBlank=true;
				//workShenheViewForm.getForm().findField('jglxmc_zwsh').allowBlank=true;
				workShenheViewForm.getForm().findField('gk_zwsh').allowBlank=true;
			}else{
				//workShenheViewForm.getForm().findField('jjhymc_zwsh').allowBlank=false;
				//workShenheViewForm.getForm().findField('jglxmc_zwsh').allowBlank=false;
				//workShenheViewForm.getForm().findField('gk_zwsh').allowBlank=false;
			}
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




var btn_edit_workShenhe = new Ext.Button({
	text : '编辑',
	iconCls : 'icon-edit',
	disabled:true,
	handler : function(){
		var record = grid_workShenhe.getSelectionModel().getSelected();
		if(record){
			window_edit_workShenhe.show();
			workShenheEditForm.getForm().loadRecord(record);
		}
	}
})

var btn_del_workShenhe = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	disabled:true,
	handler : function() {
		var record = grid_workShenhe.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该申请单?', function(btn) {
				if (btn == 'yes') {
					ajaxLoadMask.show();
					Ext.Ajax.request({
						url : 'deleteOrgnew.action',
						params : {orgid : record.data.orgid},
						success : function() {ajaxLoadMask.hide();grid_workShenhe.getStore().remove(record);},
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
var searchWorkShenhe = function() {
	ds_workShenhe.baseParams.conditions = text_search_workShenhe.getValue();
	ds_workShenhe.baseParams.userBzjgdm=currentZzUserBzjgdm;
	ds_workShenhe.baseParams.userName=currentZzUsername;
	//控制需要显示那些状态的数据
	ds_workShenhe.baseParams.stateConditions='13';
	ds_workShenhe.baseParams.ywlxConditions='';
	ds_workShenhe.load({params : {start : 0,limit : useFullPageSize} });

}



//查询返回结果的数据列
var ds_workShenhe = new Ext.data.Store({
	url : 'findShenheXcAllOrgnew.action',
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
		{name : 'qyjj',type : 'string'},
		{name : 'zcrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zgdm',type : 'string'},
		{name : 'zgmc',type : 'string'},
		{name : 'jjhymc',type : 'string'},
		{name : 'jjhydm',type : 'string'},
		{name : 'jjlx',type : 'string'},
		{name : 'jjlxdm',type : 'string'},
		{name : 'gk',type : 'string'},
		{name : 'isxw',type : 'string'},
		{name : 'fkbz',type : 'string'},
		{name : 'fksl',type : 'int'},
		{name : 'fbsl',type : 'int'},
		{name : 'zbsl',type : 'int'},
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
		{name : 'zsbfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zszfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'memo2',type : 'string'},
		{name : 'tbrzjlx',type : 'string'},
		{name : 'memo',type : 'string'},
		{name : 'name',type : 'string'},
		{name : 'username',type : 'string'},
		{name : 'handleName',type : 'string'},
		{name : 'handleDate',type : 'date',convert:function(v){if(v) return v.substring(0,16);}},
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
		//{name : 'imageData',type : 'string'},
		{name : 'state',type : 'string'}
	])
});

var btn_search_workShenhe = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchWorkShenhe();
		//btn_add_workShenhe.setDisabled(false);
		btn_edit_workShenhe.setDisabled(true);
		//btn_return_workShenhe.setDisabled(true);
	}
});

var btn_refresh_workShenhe = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchWorkShenheid.value='';
		searchWorkShenhe();
		//btn_add_workShenhe.setDisabled(true);
		btn_edit_workShenhe.setDisabled(true);
		btn_return_workShenhe_no.setDisabled(true);
		btn_return_workShenhe_ok.setDisabled(true);
	}
});


var text_search_workShenhe = new Ext.form.TextField({
	id:'textSearchWorkShenheid',
	name : 'textSearchWorkShenhe',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchWorkShenhe();
			}
		}
	}
});

//加载右栏主页面   （数据列表、工具栏按钮）
var grid_workShenhe = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	//autoHeight : true,
	cm : cm_workShenhe,
	ds : ds_workShenhe,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'state',
	viewConfig : {forceFit : true},
	plugins : expander_zwsh,
	tbar :[btn_edit_workShenhe,btn_del_workShenhe,btn_refresh_workShenhe,'-',btn_return_workShenhe_do,'->', 
		  	text_search_workShenhe,btn_search_workShenhe],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_workShenhe,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			btn_edit_workShenhe.setDisabled(false);
			btn_del_workShenhe.setDisabled(false);
		},
		'rowdblclick':function(grid, rowIndex){
			var record = grid_workShenhe.getSelectionModel().getSelected();
			if(record){
				window_do_workShenhe.show();
				workShenheViewForm.getForm().loadRecord(record);
				window_do_workShenhe.setTitle('现场业务审批--【'+record.data.jgmc+'】--'+record.data.ywlx);
				if(record.data.ywlx=="预赋码"){
//					workShenheViewForm.getForm().findField('jjhymc_zwsh').allowBlank=true;
//					workShenheViewForm.getForm().findField('jglxmc_zwsh').allowBlank=true;
//					workShenheViewForm.getForm().findField('gk_zwsh').allowBlank=true;
				}else{
//					workShenheViewForm.getForm().findField('jjhymc_zwsh').allowBlank=false;
//					workShenheViewForm.getForm().findField('jglxmc_zwsh').allowBlank=false;
//					workShenheViewForm.getForm().findField('gk_zwsh').allowBlank=false;
				}
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



var zzWorkShenhe_panel = new Ext.Panel({
	title : '现场业务审批',
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
	    items : [grid_workShenhe]
	}]
});

var p_zzWorkShenhe = {
	id : 'zzWorkShenhe-panel',
	border : false,
	layout : 'border',
	items : [zzWorkShenhe_panel]
};