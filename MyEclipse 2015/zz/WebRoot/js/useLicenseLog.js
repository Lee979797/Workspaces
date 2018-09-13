
//-----------------------点击列表信息，显示图书的扩展属性-----------------------
var expander87 = new Ext.grid.RowExpander({
	tpl : new Ext.Template('<table width="100%"  border="0" cellspacing="6" cellpadding="0"  bgcolor="#DDEEF9" style="margin-top:1px;" >'
			+ '<tr>'
			+ '<td width="" colspan="4">'
			+ '<table width="98%" bgcolor="#ffffff" border="1" cellpadding="0" cellspacing="0" align="center"  bordercolordark="#FFFFFF" bordercolorlight="#6EBBE1" style="margin-top:0px;>'
			+ '<tr height="22" valign="middle">'
			+ '  <td width="20%" height="22" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构名称：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgmc}<img src="images/temp.gif"></td>'
			+ '  <td width="20%" height="22" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构代码：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle" >'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">法定代表人：</td><td nowrap="nowrap" style="padding-top:5px">{fddbr}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册日期：</td><td  nowrap="nowrap" style="padding-top:5px">{zcrq}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证件类型：</td><td nowrap="nowrap"  style="padding-top:5px">{zjlx}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证件号码：</td><td nowrap="nowrap"  style="padding-top:5px">{zjhm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">主要经营或业务范围：</td><td  colspan=3 style="padding-top:5px">{jyfw}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">行政区划：</td><td nowrap="nowrap" style="padding-top:5px">{xzqhName} {xzqhCode}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构地址：</td><td nowrap="nowrap" style="padding-top:5px">{jgdz}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">邮政编码：</td><td nowrap="nowrap" style="padding-top:5px">{yzbm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">电话号码：</td><td nowrap="nowrap" style="padding-top:5px">{dhhm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">电子信箱：</td><td nowrap="nowrap" style="padding-top:5px">{email}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">网址：</td><td nowrap="nowrap" style="padding-top:5px">{weburl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '   <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">主要产品一：</td><td nowrap="nowrap" style="padding-top:5px">{zycp1}<img src="images/temp.gif"></td>'
			+ '   <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">主要产品二：</td><td nowrap="nowrap" style="padding-top:5px">{zycp2}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">主要产品三：</td><td nowrap="nowrap" style="padding-top:5px">{zycp3}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册资金：</td><td nowrap="nowrap" style="padding-top:5px">{zczj}万<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">投资国或地区：</td><td nowrap="nowrap" style="padding-top:5px">{wftzgb}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">职工人数：</td><td nowrap="nowrap" style="padding-top:5px">{zgrs}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">可否公开：</td><td nowrap="nowrap" style="padding-top:5px">{gk}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">主管机构：</td><td nowrap="nowrap" style="padding-top:5px">{zgmc}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册号：</td><td nowrap="nowrap" style="padding-top:5px">{zch}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">批准机构：</td><td nowrap="nowrap" style="padding-top:5px">{pzjgmc}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">批准文号：</td><td nowrap="nowrap" style="padding-top:5px">{pzwh}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">批准日期：</td><td nowrap="nowrap" style="padding-top:5px">{pwrq}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">手机：</td><td nowrap="nowrap" style="padding-top:5px">{mobile}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">是否邮寄：</td><td nowrap="nowrap" style="padding-top:5px">{yjflag}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人名：</td><td nowrap="nowrap" style="padding-top:5px">{tbrxm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件号码：</td><td nowrap="nowrap" style="padding-top:5px">{tbrsfzh}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人电话：</td><td nowrap="nowrap" style="padding-top:5px">{tbrlxfs}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册资金：</td><td nowrap="nowrap" style="padding-top:5px">{zczj}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经营地址：</td><td nowrap="nowrap" style="padding-top:5px">{jydz}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经营邮编：</td><td nowrap="nowrap" style="padding-top:5px">{jyyb}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经营电话：</td><td nowrap="nowrap" style="padding-top:5px">{jydh}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经费来源：</td><td nowrap="nowrap" style="padding-top:5px">{jfly}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">开户银行：</td><td nowrap="nowrap" style="padding-top:5px">{khyh}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">开户帐号：</td><td nowrap="nowrap" style="padding-top:5px">{khzh}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核人：</td><td nowrap="nowrap" style="padding-top:5px">{adudit_name}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核时间：</td><td nowrap="nowrap" style="padding-top:5px">{adudit_date}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核意见：</td><td  colspan=3 style="padding-top:5px">{adudit_note}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '</table>'
			+ '</td></tr></table>')
});


//---------------------- 列表显示主要数据信息 ----------------------------------
// 列表显示机构的主要信息 yangqi
var sm2 = new Ext.grid.CheckboxSelectionModel();
var cm_orgnew = new Ext.grid.ColumnModel([expander87,
	sm2,
	{header : '原文',width : 30,dataIndex : 'imageUrl', renderer:icon,sortable : false},
	{header : '流水号',width : 40,dataIndex : 'orgid',sortable : true}, 
	{header : '机构名称',width : 180,sortable : true,dataIndex : 'jgmc'},
	{header : '法定代表人/负责人',width : 80,dataIndex : 'fddbr',sortable : true}, 
	{header : '经办人姓名',width : 40,dataIndex : 'name',id : 'name',sortable : true},
	{header : '审核人',	width : 50,dataIndex : 'adudit_name',id : 'adudit_username',sortable : true},
	{header : '申请状态',width : 150,dataIndex : 'state',renderer : goState,menuDisabled : true}
]);


var ds_user_select = new Ext.data.Store({
	url : 'findUserByExample.action',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'userId',type : 'int'}, 
		{name : 'emplName',type : 'string'}
	])
})




var btn_scanImage = new Ext.Button({
	text : '扫描',
	iconCls : 'icon-scan',
	handler : function() {
		window.open("NKOScanProj.jsp")
	}
});


//默认查询 limit为显示的条数
var searchOrgnewLog = function() {
	ds_orgnewLog.baseParams.conditions = text_search_orgnewLog.getValue();
	ds_orgnewLog.baseParams.username=currentUsername;
	ds_orgnewLog.baseParams.stateConditions='100';
	ds_orgnewLog.load({params : {start : 0,limit : 10} });

}

//查询返回结果的数据列
var ds_orgnewLog = new Ext.data.Store({
	url : 'findAllTjgdm.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'orgid',type : 'int'}, 
		{name : 'jgmc',type : 'string'}, 
		{name : 'fddbr',type : 'string'}, 
		{name : 'zjlx',type : 'string'},
		{name : 'zjhm',type : 'string'}, 
		{name : 'jyfw',type : 'string'},
		{name : 'zcrq',type : 'date'},
		{name : 'zgdm',type : 'string'},
		{name : 'zgmc',type : 'string'},
		{name : 'pzjgmc',type : 'string'},
		{name : 'xzqhCode',type : 'string'},
		{name : 'xzqhName',type : 'string'},
		{name : 'jgdz',type : 'string'},
		{name : 'yzbm',type : 'string'},
		{name : 'dhhm',type : 'string'},
		{name : 'bzjgdm',type : 'string'},
		{name : 'zycp1',type : 'string'},
		{name : 'zycp2',type : 'string'},
		{name : 'zycp3',type : 'string'},
		{name : 'zczj',type : 'string'},
		{name : 'hbzl',type : 'string'},
		{name : 'wftzgb',type : 'string'},
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
		
		{name : 'name',type : 'string'},
		{name : 'username',type : 'string'},
		{name : 'adudit_name',type : 'string'},
		{name : 'adudit_note',type : 'string'},
		{name : 'imageUrl',type : 'string'},
		{name : 'state',type : 'string'}
	])
});

var btn_search_orgnewLog = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchOrgnewLog();
		//btn_add_orgnewLog.setDisabled(false);
		//btn_edit_orgnewLog.setDisabled(true);
		//btn_return_orgnewLog.setDisabled(false);
	}
});

var btn_refresh_orgnewLog = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchOrgnewLog.value='';
		searchOrgnewLog();
		//btn_add_orgnewLog.setDisabled(false);
		//btn_edit_orgnewLog.setDisabled(true);
		//btn_return_orgnewLog.setDisabled(true);
	}
});
    
var text_search_orgnewLog = new Ext.form.TextField({
	id : 'textSearchOrgnewLog',
	name : 'textSearchOrgnewLog',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchOrgnewLog();
			}
		}
	}
});

//加载右栏主页面   （数据列表、工具栏按钮）
var grid_LicenseLog = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	//autoHeight : true,
	cm : cm_orgnew,
	ds : ds_orgnewLog,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'address',
	viewConfig : {forceFit : true},
	plugins : expander87,
	tbar : [btn_refresh_orgnewLog,'->',text_search_orgnewLog,
	        btn_search_orgnewLog],
	bbar : new Ext.PagingToolbar({
		pageSize : 10,
		store : ds_orgnewLog,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowdblclick':function(grid, rowIndex){
			ds_filelog.baseParams.orgid = grid.getStore().getAt(rowIndex).data.orgid;
			ds_filelog.load({params : {start : 0,limit : 10}});
		},
		'rowclick':function(grid,rowIndex){
			//btn_edit_orgnewLog.setDisabled(true);
			//btn_add_orgnewLog.setDisabled(grid.getStore().getAt(rowIndex).data.state == 0 ? true:false);
			//btn_edit_orgnewLog.setDisabled(grid.getStore().getAt(rowIndex).data.state == 11 ? false:true);
			//btn_return_orgnewLog.setDisabled(grid.getStore().getAt(rowIndex).data.state == 11 ? true:false);
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

var dateFormat = function(v){
	if(v){
		return v.substring(0,10)
	}
	return '未审批';
}

LoanLogPanel = Ext.extend(Ext.grid.GridPanel,{
	constructor:function(){
		LoanLogPanel.superclass.constructor.call(this,{
		loadMask : {msg : '数据加载中...'},
			cm : new Ext.grid.ColumnModel([ 
			   {header : '文件分类',width : 100,	dataIndex : 'filetypename',sortable : true}, 
				{header : '文件名称',	width : 120,dataIndex : 'orgnewName',id : 'orgnewName',renderer:linker,sortable : true}, 
				{header : '文件大小(K)',	width : 90,	dataIndex : 'reader',sortable : true},
				{header : '上传时间',width : 100,	dataIndex : 'loanTime',renderer: dateFormat,sortable : true}, 
				{header : '浏览次数',width : 100,	dataIndex : 'loanDays',sortable : true}, 
				{header : '审核时间',	width : 100,dataIndex : 'preReturnTime',renderer: dateFormat,sortable : true}, 
				{header : '通过时间',	width : 100,dataIndex : 'returnTime',renderer:dateFormat,sortable : true}, 
				{header : '受理人',	width : 100,dataIndex : 'loanner',menuDisabled : true}]
			),
			autoExpandColumn : 'jgmc',
			ds : ds_filelog,
			sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
			bbar : new Ext.PagingToolbar({
					pageSize : 10,
					store : ds_filelog,
					displayInfo : true,
					displayMsg : '第 {0} - {1} 条 共 {2} 条',
					emptyMsg : "没有证书历史记录"}
			)
		});
	}
});


var useLicenseLog_panel = new Ext.Panel({
	title : '证书历史记录',
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
	    items : [grid_LicenseLog]
	}]
});

var p_useLicenseLog = {
	id : 'useLicenseLog-panel',
	border : false,
	layout : 'border',
	items : [useLicenseLog_panel]
}

//当前日期
//alert(myDate.format('Y-m-d'));
//当前用户ID
//alert(currentUsername);
//当前用户姓名
//alert(currentUser);
//searchOrgnewLog()