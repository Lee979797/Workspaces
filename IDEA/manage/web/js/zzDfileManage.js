var Dfile = Ext.data.Record.create([
	{name : 'orgid',mapping : 'orgid',type : 'int'}, 
	{name : 'centerid',mapping : 'centerid',type : 'string'},
	{name : 'orderid',mapping : 'orderid',type : 'string'}, 
	{name : 'jgdm',	mapping : 'jgdm',type : 'string'}, 
	{name : 'jgmc',mapping : 'jgmc',type : 'string'}, 
	{name : 'jglx',mapping : 'jglx',type : 'string'},
	{name : 'fddbr',mapping : 'fddbr',type : 'string'}, 
	{name : 'zjlx',mapping : 'zjlx',type : 'string'}, 
	{name : 'zjhm',mapping : 'zjhm',type : 'string'}, 
	{name : 'jyfw',mapping : 'jyfw',type : 'string'}, 
	{name : 'zcrq',mapping : 'zcrq',type : 'date',dateFormat:'Y-M-D'}, 
	{name : 'xzqhCode',mapping : 'xzqhCode',type : 'string'},
	{name : 'xzqhName',mapping : 'xzqhName',type : 'string'},
	{name : 'jgdz',mapping : 'jgdz',type : 'string'}, 
	{name : 'yzbm',mapping : 'yzbm',type : 'string'}, 
	{name : 'dhhm',mapping : 'dhhm',type : 'string'}, 
	{name : 'zycp1',mapping : 'zycp1',type : 'string'}, 
	{name : 'zycp2',mapping : 'zycp2',type : 'string'}, 
	{name : 'zycp3',mapping : 'zycp3',type : 'string'}, 
	{name : 'zczj',mapping : 'zczj',type : 'string'}, 
	{name : 'wftzgb',mapping : 'wftzgb',type : 'string'}, 
	{name : 'zgrs',mapping : 'zgrs',type : 'string'}, 
	{name : 'zch',mapping : 'zch',type : 'string'}, 
	{name : 'pzwh',mapping : 'pzwh',type : 'string'},
	{name : 'pzrq',mapping : 'pzrq',type : 'date',dateFormat:'Y-M-D'},
	{name : 'pzjgmc',mapping : 'pzjgmc',type : 'string'},
	{name : 'pzjgdm',mapping : 'pzjgdm',type : 'string'},
	{name : 'kfgk',mapping : 'kfgk',type : 'string'},
	{name : 'email',mapping : 'email',type : 'string'},
	{name : 'weburl',mapping : 'weburl',type : 'string'},
	{name : 'mobile',mapping : 'mobile',type : 'string'},
	{name : 'tbrxm',mapping : 'tbrxm',type : 'string'},
	{name : 'tbrsfzh',mapping : 'tbrsfzh',type : 'string'},
	{name : 'tbrlxfs',mapping : 'tbrlxfs',type : 'string'},
	{name : 'jydz',mapping : 'jydz',type : 'string'},
	{name : 'jyyb',mapping : 'jyyb',type : 'string'},
	{name : 'jydh',mapping : 'jydh',type : 'string'},
	{name : 'jfly',mapping : 'jfly',type : 'string'},
	{name : 'zsbfrq',mapping : 'zsbfrq',type : 'date', convert:function(v){if(v) return v.substring(0,10);}},
	{name : 'zszfrq',mapping : 'zszfrq',type : 'date', convert:function(v){if(v) return v.substring(0,10);}},
	{name : 'jjlx',mapping : 'jjlx',type : 'string'},
	{name : 'jjlxdm',mapping : 'jjlxdm',type : 'string'},
	{name : 'tbrzjlx',mapping : 'tbrzjlx',type : 'string'},
	{name : 'memo',mapping : 'memo',type : 'string'},
	{name : 'memo2',mapping : 'memo2',type : 'string'},
	
	{name : 'hbzl',mapping : 'hbzl',type : 'string'},
	{name : 'hbzldm',mapping : 'hbzldm',type : 'string'},
	
	{name : 'khyh',mapping : 'khyh',type : 'string'},
	{name : 'khzh',mapping : 'khzh',type : 'string'},
	{name : 'userid',mapping : 'userid',type : 'string'},
	{name : 'username',mapping : 'username',type : 'string'},
	{name : 'handleUsername', mapping: 'handleUsername',type : 'string'},
	{name : 'handleName', mapping: 'handleName',type : 'string'},
	{name : 'handleDate', mapping: 'handleDate',type : 'string'},
	{name : 'handleNote', mapping: 'handleNote',type : 'string'},	
	{name : 'imageUrl', mapping: 'imageUrl',type : 'string'},
	
	{name : 'offPzjgmc', mapping: 'offPzjgmc',type : 'string'},
	{name : 'offPzwh', mapping: 'offPzwh',type : 'string'},
	{name : 'offReason', mapping: 'offReason',type : 'string'},	
	{name : 'offNote', mapping: 'offNote',type : 'string'},
	
	{name : 'errorFlag', mapping: 'errorFlag',type : 'string'},
	{name : 'd_flag',mapping : 'd_flag',type : 'int'}, 
	{name : 'up_Dflag',mapping : 'up_Dflag',type : 'int'}, 
	{name : 'up_Aflag',mapping : 'up_Aflag',type : 'int'},
	{name : 'pigeTime',mapping : 'pigeTime',type : 'date', convert:function(v){if(v) return v.substring(0,10);}},
	
	{name : 'state',mapping : 'state',type : 'string'}
]);

var arctypeStr4 = [['1','新办'],['2','年检'],['3','迁出'],['4','迁入'],['5','变更'],['6','换证'],['7','补证'],['8','注销'],['9','其他'],['10','预赋码']]; 
var arctypeStore4 = new Ext.data.SimpleStore({fields:['arctypeCode','arctypeValue'],data:arctypeStr4});

var searchXzqh_dfileManage = function() {
	ds_xzqh_dfileManage.baseParams.conditions = text_search_xzqh_dfileManage.getValue();
	ds_xzqh_dfileManage.baseParams.username='';
	ds_xzqh_dfileManage.baseParams.stateConditions='';
	ds_xzqh_dfileManage.load({params : {start : 0,limit : 20} });
}

var btn_search_xzqh_dfileManage = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchXzqh_dfileManage();
	}
});

var text_search_xzqh_dfileManage = new Ext.form.TextField({
	id : 'textSearchXzqh_dfileManage',
	name : 'textSearchXzqh_dfileManage',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchXzqh_dfileManage();
			}
		},
		'change' : function(field, e) {
			searchXzqh_dfileManage();
			//btn_search_xzqh_dfileManage.setDisabled(false);
		}
	}
});

var cm_xzqh_dfileManage = new Ext.grid.ColumnModel([
	{header : '行政区划名称',width : 50,dataIndex : 'xzqhName',sortable : true},
	{header : '行政区划代码',width : 20,dataIndex : 'xzqhCode',sortable : true}
]);

var ds_xzqh_dfileManage = new Ext.data.Store({
	url : 'findAllByConditionXzqh.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'xzqhCode',type : 'string'},
			{name : 'xzqhName',type : 'string'},
			{name : 'xzqhNote',type : 'string'}
		])
});
var grid_xzqh_dfileManage = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_xzqh_dfileManage,
	ds : ds_xzqh_dfileManage,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入行政区划名称：',text_search_xzqh_dfileManage,btn_search_xzqh_dfileManage],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_xzqh_dfileManage,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_xzqhQuery_dfileManage.hide();
			var selections=grid.getSelectionModel().getSelections();
			dfileManageEditForm.getForm().findField('xzqhName_dfileManage').setValue(selections[0].get('xzqhName'));
			dfileManageEditForm.getForm().findField('xzqhCode_dfileManage').setValue(selections[0].get('xzqhCode'));
		}
	}
});

var window_xzqhQuery_dfileManage = new Ext.Window({
	title : '行政区划名称查询',
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
	items : [grid_xzqh_dfileManage]
});
//行政区划的到此结束
var searchXzqh_dfileManage2 = function() {
	ds_xzqh_dfileManage2.baseParams.conditions = text_search_xzqh_dfileManage2.getValue();
	ds_xzqh_dfileManage2.baseParams.username='';
	ds_xzqh_dfileManage2.baseParams.stateConditions='';
	ds_xzqh_dfileManage2.load({params : {start : 0,limit : 20} });
}

var btn_search_xzqh_dfileManage2 = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchXzqh_dfileManage2();
	}
});

var text_search_xzqh_dfileManage2 = new Ext.form.TextField({
	id : 'textSearchXzqh_dfileManage2',
	name : 'textSearchXzqh_dfileManage2',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchXzqh_dfileManage2();
			}
		},
		'change' : function(field, e) {
			searchXzqh_dfileManage2();
			//btn_search_xzqh_dfileManage.setDisabled(false);
		}
	}
});

var cm_xzqh_dfileManage2 = new Ext.grid.ColumnModel([
	{header : '行政区划名称',width : 50,dataIndex : 'xzqhName',sortable : true},
	{header : '行政区划代码',width : 20,dataIndex : 'xzqhCode',sortable : true}
]);

var ds_xzqh_dfileManage2 = new Ext.data.Store({
	url : 'findAllByConditionXzqh.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'xzqhCode',type : 'string'},
			{name : 'xzqhName',type : 'string'},
			{name : 'xzqhNote',type : 'string'}
		])
});
var grid_xzqh_dfileManage2 = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_xzqh_dfileManage2,
	ds : ds_xzqh_dfileManage2,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入行政区划名称：',text_search_xzqh_dfileManage2,btn_search_xzqh_dfileManage2],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_xzqh_dfileManage2,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_xzqhQuery_dfileManage2.hide();
			var selections=grid.getSelectionModel().getSelections();
			dfileManageEditForm.getForm().findField('xzqhName_dfileManage2').setValue(selections[0].get('xzqhName'));
			dfileManageEditForm.getForm().findField('xzqhCode_dfileManage2').setValue(selections[0].get('xzqhCode'));
		}
	}
});

var window_xzqhQuery_dfileManage2 = new Ext.Window({
	title : '行政区划名称查询',
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
	items : [grid_xzqh_dfileManage2]
});
//行政区划的到此结束

var btn_search_pzjg_dfileManage = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchPzjg_dfileManage();
		//btn_search_pzjg_dfileManage.setDisabled(true);
	}
});


var text_search_pzjg_dfileManage = new Ext.form.TextField({
	id : 'textSearchPzjg_dfileManage',
	name : 'textSearchPzjg_dfileManage',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchPzjg_dfileManage();
			}
		},
		'change' : function(field, e) {
			btn_search_pzjg_dfileManage.setDisabled(false);
		}
	}
});


var cm_pzjg_dfileManage = new Ext.grid.ColumnModel([
	{header : '批准机构名称',width : 50,dataIndex : 'pzjgmc',sortable : true}, 
	{header : '批准机构代码',width : 20,dataIndex : 'pzjgdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_pzjg_dfileManage = new Ext.data.Store({
	url : 'findAllByConditionPzjg.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'pzjgid',type : 'int'}, 
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchPzjg_dfileManage = function() {
	ds_pzjg_dfileManage.baseParams.conditions = text_search_pzjg_dfileManage.getValue();
	ds_pzjg_dfileManage.baseParams.username='';
	ds_pzjg_dfileManage.baseParams.stateConditions='';
	ds_pzjg_dfileManage.load({params : {start : 0,limit : 20} });
}

var grid_pzjg_dfileManage = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_pzjg_dfileManage,
	ds : ds_pzjg_dfileManage,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入登记批准机构名称：',text_search_pzjg_dfileManage,btn_search_pzjg_dfileManage],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_pzjg_dfileManage,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_pzjgQuery_dfileManage.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			dfileManageEditForm.getForm().findField('select_pzjgmc_dfileManage').setValue(selections[0].get('pzjgmc'));
			dfileManageEditForm.getForm().findField('select_pzjgdm_dfileManage').setValue(selections[0].get('pzjgdm'));
		}
	}
});


var window_pzjgQuery_dfileManage = new Ext.Window({
	title : '登记批准机构查询',
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
	items : [grid_pzjg_dfileManage]
});


var btn_search_jglxSelcet_dfileManage = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJglxSelcet_dfileManage();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_jglxSelcet_dfileManage = new Ext.form.TextField({
	id : 'textsearchJglxSelcet_dfileManage',
	name : 'textsearchJglxSelcet_dfileManage',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJglxSelcet_dfileManage();
			}
		},
		'change' : function(field, e) {
			btn_search_jglxSelcet_dfileManage.setDisabled(false);
		}
	}
});


var cm_jglxSelcet_dfileManage = new Ext.grid.ColumnModel([
    {header : '一级类型',width : 60,dataIndex : 'pjglxmc',sortable : true}, 
	{header : '二级类型',width : 100,dataIndex : 'jglxmc',sortable : true}, 
	{header : '代码',width : 30,dataIndex : 'jglxdm',sortable : true},
	{header : '备注',width : 50,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_jglxSelcet_dfileManage = new Ext.data.Store({
	url : 'findAllByConditionJglx.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'jglxid',type : 'int'}, 
	    {name : 'pjglxmc',type : 'string'},
	    {name : 'pjglxdm',type : 'string'},
		{name : 'jglxmc',type : 'string'},
		{name : 'jglxdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var ds_hbzl_select_dfileManage = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=1',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});

var searchJglxSelcet_dfileManage = function() {
	ds_jglxSelcet_dfileManage.baseParams.conditions = text_search_jglxSelcet_dfileManage.getValue();
	ds_jglxSelcet_dfileManage.baseParams.username="";
	ds_jglxSelcet_dfileManage.baseParams.stateConditions='';
	ds_jglxSelcet_dfileManage.load({params : {start : 0,limit : 20} });
}

var grid_jglx_dfileManage = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jglxSelcet_dfileManage,
	ds : ds_jglxSelcet_dfileManage,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入机构类型名称：',text_search_jglxSelcet_dfileManage,btn_search_jglxSelcet_dfileManage],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jglxSelcet_dfileManage,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jglxQuery_dfileManage.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			dfileManageEditForm.getForm().findField('select_jglxmc_dfileManage').setValue(selections[0].get('jglxmc'));
			dfileManageEditForm.getForm().findField('select_jglxdm_dfileManage').setValue(selections[0].get('jglxdm'));
			
			if(selections[0].get('pjglxdm')==1){
				dfileManageEditForm.getForm().findField('select_jjlxmc_dfileManage').allowBlank=false;
				dfileManageEditForm.getForm().findField('select_jjlxdm_dfileManage').allowBlank=false;
			}else{
				dfileManageEditForm.getForm().findField('select_jjlxmc_dfileManage').allowBlank=true;
				dfileManageEditForm.getForm().findField('select_jjlxdm_dfileManage').allowBlank=true;
			}
		}
	}
});


var window_jglxQuery_dfileManage = new Ext.Window({
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
	items : [grid_jglx_dfileManage]
});


var btn_search_hylxSelcet_dfileManage = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchHylxSelcet_dfileManage();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_hylxSelcet_dfileManage = new Ext.form.TextField({
	id : 'textSearchHylxSelcet_dfileManage',
	name : 'textSearchHylxSelcet_dfileManage',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchHylxSelcet_dfileManage();
			}
		},
		'change' : function(field, e) {
			btn_search_hylxSelcet_dfileManage.setDisabled(false);
		}
	}
});

var ds_wftzgb_select_dfileManage = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=3',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});

var cm_hylxSelcet_dfileManage = new Ext.grid.ColumnModel([
	{header : '大类',width : 100,dataIndex : 'hylxmc1',sortable : true}, 
	{header : '中类',width : 100,dataIndex : 'hylxmc2',sortable : true}, 
	{header : '小类',width : 100,dataIndex : 'hylxmc3',sortable : true}, 
    {header : '经济行业名称',width : 100,dataIndex : 'hylxmc',sortable : true},
	{header : '经济行业代码',width : 30,dataIndex : 'hylxdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_hylxSelcet_dfileManage = new Ext.data.Store({
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
		{ name : 'note',type : 'string'}
	])
});

var searchHylxSelcet_dfileManage = function() {
	ds_hylxSelcet_dfileManage.baseParams.conditions = text_search_hylxSelcet_dfileManage.getValue();
	ds_hylxSelcet_dfileManage.baseParams.username="";
	ds_hylxSelcet_dfileManage.baseParams.stateConditions='';
	ds_hylxSelcet_dfileManage.load({params : {start : 0,limit : 20} });
}

var grid_hylx_dfileManage = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_hylxSelcet_dfileManage,
	ds : ds_hylxSelcet_dfileManage,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入经济行业代码名称：',text_search_hylxSelcet_dfileManage,btn_search_hylxSelcet_dfileManage],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_hylxSelcet_dfileManage,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_hylxQuery_dfileManage.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			dfileManageEditForm.getForm().findField('select_jjhymc_dfileManage').setValue(selections[0].get('hylxmc'));
			dfileManageEditForm.getForm().findField('select_jjhydm_dfileManage').setValue(selections[0].get('hylxdm'));
			dfileManageEditForm.getForm().findField('select_jjhymcOld_dfileManage').setValue(selections[0].get('hylxmcOld'));
			dfileManageEditForm.getForm().findField('select_jjhydmOld_dfileManage').setValue(selections[0].get('hylxdmOld'));
		}
	}
});


var window_hylxQuery_dfileManage = new Ext.Window({
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
	items : [grid_hylx_dfileManage]
});


var btn_search_jjlx_dfileManage = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJjlx_dfileManage();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_jjlx_dfileManage = new Ext.form.TextField({
	id : 'textSearchJjlx_dfileManage',
	name : 'textSearchJjlx_dfileManage',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJjlx_dfileManage();
			}
		},
		'change' : function(field, e) {
			btn_search_jjlx_dfileManage.setDisabled(false);
		}
	}
});


var cm_jjlx_dfileManage = new Ext.grid.ColumnModel([
    {header : '大类',width : 30,dataIndex : 'pjjlxmc',sortable : true}, 
    {header : '中类',width : 30,dataIndex : 'pjjlxmc2',sortable : true}, 
    {header : '小类',width : 30,dataIndex : 'pjjlxmc3',sortable : true}, 
	{header : '经济类型名称',width : 100,dataIndex : 'jjlxmc',sortable : true}, 
	{header : '经济类型代码',width : 30,dataIndex : 'jjlxdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_jjlx_dfileManage = new Ext.data.Store({
	url : 'findAllByConditionJjlx.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'jjlxid',type : 'int'}, 
	    {name : 'pjjlxmc',type : 'string'},
	    {name : 'pjjlxmc2',type : 'string'},
	    {name : 'pjjlxmc3',type : 'string'},
		{name : 'jjlxmc',type : 'string'},
		{name : 'jjlxdm',type : 'string'},
		{name : 'ojjlxmc00',type : 'string'},
		{name : 'ojjlxdm00',type : 'string'},
		{name : 'note',type : 'string'}
	])
});


var jjlxStore_dfileManage = new Ext.data.Store({
	url : 'findAllByConditionJjlx.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'jjlxmc',type : 'string'},
		{name : 'jjlxdm',type : 'string'}
	])
});


var searchJjlx_dfileManage = function() {
	ds_jjlx_dfileManage.baseParams.conditions = text_search_jjlx_dfileManage.getValue();
	ds_jjlx_dfileManage.baseParams.username='';
	ds_jjlx_dfileManage.baseParams.stateConditions='';
	ds_jjlx_dfileManage.load({params : {start : 0,limit : 20} });
}

var grid_jjlx_dfileManage = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jjlx_dfileManage,
	ds : ds_jjlx_dfileManage,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入企业登记注册类型名称：',text_search_jjlx_dfileManage,btn_search_jjlx_dfileManage],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jjlx_dfileManage,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jjlxQuery_dfileManage.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			dfileManageEditForm.getForm().findField('select_jjlxmc_dfileManage').setValue(selections[0].get('jjlxmc'));
			dfileManageEditForm.getForm().findField('select_jjlxdm_dfileManage').setValue(selections[0].get('jjlxdm'));
			dfileManageEditForm.getForm().findField('select_jjlxmcOld_dfileManage').setValue(selections[0].get('ojjlxmc00'));
			dfileManageEditForm.getForm().findField('select_jjlxdmOld_dfileManage').setValue(selections[0].get('ojjlxdm00'));
			
			if(selections[0].get('jjlxdm')>5000 && selections[0].get('jjlxdm')<8000){
				dfileManageEditForm.getForm().findField('wftzgb_dfileManage').allowBlank=false;
				dfileManageEditForm.getForm().findField('wftzgbdm_dfileManage').allowBlank=false;
				if(selections[0].get('jjlxdm')>6000 && selections[0].get('jjlxdm')<7000){
					dfileManageEditForm.getForm().findField('wftzgb_dfileManage').setValue('港澳台');
					dfileManageEditForm.getForm().findField('wftzgbdm_dfileManage').setValue('344');
				}
			}else{
				dfileManageEditForm.getForm().findField('wftzgb_dfileManage').setValue('');
				dfileManageEditForm.getForm().findField('wftzgbdm_dfileManage').setValue('');
				dfileManageEditForm.getForm().findField('wftzgb_dfileManage').allowBlank=true;
				dfileManageEditForm.getForm().findField('wftzgbdm_dfileManage').allowBlank=true;
			}
		}
	}
});


var window_jjlxQuery_dfileManage = new Ext.Window({
	title : '企业登记注册类型查询',
	iconCls : 'icon-plugin',
	width :500,
	height:400,
	//expandOnShow:'true',
	x:'250',
	y:'170',
	//plain    : true,
	layout   : 'border',
	resizable : false,
	modal : true,
	resizable : true, 
	maximizable:true,
	closeAction : 'hide',
	items : [grid_jjlx_dfileManage]
});

//主管部门
var searchZgmc_dfileManage = function() {
	ds_zgmc_dfileManage.baseParams.conditions = text_search_zgmc_dfileManage.getValue();
	ds_zgmc_dfileManage.baseParams.username='';
	ds_zgmc_dfileManage.baseParams.stateConditions='';
	ds_zgmc_dfileManage.load({params : {start : 0,limit : 20} });
}

var btn_search_zgmc_dfileManage = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchZgmc_dfileManage();
		//btn_search_pzjg.setDisabled(true);
	}
});

var text_search_zgmc_dfileManage = new Ext.form.TextField({
	id : 'textSearchZgmc_dfileManage',
	name : 'textSearchZgmc_dfileManage',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchZgmc_dfileManage();
			}
		},
		'change' : function(field, e) {
			btn_search_zgmc_dfileManage.setDisabled(false);
		}
	}
});

var cm_zgmc_dfileManage = new Ext.grid.ColumnModel([
	{header : '主管部门名称',width : 50,dataIndex : 'jgmc',sortable : true}, 
	{header : '主管部门代码',width : 20,dataIndex : 'jgdm',sortable : true}
]);

var ds_zgmc_dfileManage = new Ext.data.Store({
	url : 'findAllTjgdm.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'jgdm',type : 'string'},
			{name : 'jgmc',type : 'string'}
		])
});

var grid_zgmc_dfileManage = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_zgmc_dfileManage,
	ds : ds_zgmc_dfileManage,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入主管部门名称：',text_search_zgmc_dfileManage,btn_search_zgmc_dfileManage],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_zgmc_dfileManage,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_zgmcQuery_dfileManage.hide();
			var selections=grid.getSelectionModel().getSelections();
			dfileManageEditForm.getForm().findField('select_zgmc_dfileManage').setValue(selections[0].get('jgmc'));
			dfileManageEditForm.getForm().findField('select_zgdm_dfileManage').setValue(selections[0].get('jgdm'));
		}
	}
});

var window_zgmcQuery_dfileManage = new Ext.Window({
	title : '主管部门名称查询',
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
	items : [grid_zgmc_dfileManage]
});

 
//点击列表信息，显示图书的扩展属性//
var expander_dfileManage = new Ext.grid.RowExpander({
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




//--------------------修改临时库机构档案信息-------------------------------------------
var dfileManageEditForm = new Ext.FormPanel({
	url : 'updateDfile.action',
	loadMask : {
		msg : '数据加载中...'
	},
	labelAlign : 'right',
	labelWidth : 95,
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
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
	                	{xtype:'textfield',fieldLabel : '流水号',name : 'orderid',id : 'orderid_dfileManage',readOnly:true,maxLength : 50,anchor:'100%'},
	                	{xtype : 'hidden',name : 'isbc',id : 'isbc_dfileManage',value:'0'}]
			},{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
	                	{xtype:'textfield',fieldLabel : '业务类型',name : 'ywlx',allowBlank : false,maxLength : 50,readOnly:true,anchor:'100%'}
					]
			},{
                columnWidth:.3,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jglxdm_dfileManage",
						name:"jglxdm",
						fieldLabel:"机构类型",
						//width:135,
						anchor:'97%',
					 	valueField : "jglxdm",
					    displayField : "jglxdm",
					    store : jjlxStore_dfileManage,
					    labelSeparator:'',
					    allowBlank : false,
					    haveShow : true,
					    editable : false,
					    onTriggerClick : function() {
					    	window_jglxQuery_dfileManage.show();
					    	document.getElementById("isbc_dfileManage").value='1';
					    },listeners : {
							'specialkey' : function(field, e) {
								if (e.getKey() == Ext.EventObject.ENTER) {
									findJglxNameByCode(field);
								}
							},
							'change' : function(field,newValue,oldValue){
								document.getElementById("isbc_dfileManage").value='1';}
							,
							'blur': function(field){
								findJglxNameByCode(field);
							}
						}
					})]
			},{
                columnWidth:.2,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',id:"select_jglxmc_dfileManage",name : 'jglx',labelSeparator:'',hideLabel:true,allowBlank : false,readOnly:'true',maxLength : 50,anchor:'100%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{xtype : 'combo',
						fieldLabel : '小微企业',
						id : 'isxw_dfileManage',
						name : 'isxw',
						displayField : 'isxw',
						valueField : 'isxw',
						hiddenName : 'isxw',
						store : isxwStore,
						triggerAction : 'all',
						lazyRender:true,
						//emptyText:'请选择是否小微企业！',
						//width:135,
						value:'否',
						anchor:'100%',
						mode : 'local',
						selectOnFocus : true,
						allowBlank:false,
						labelSeparator:'',
						editable : false,
						listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}
					}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype : 'combo',
						fieldLabel : '是否公开',
						id : 'gk_dfileManage',
						name : 'gk',
						displayField : 'gk',
						valueField : 'gk',
						hiddenName : 'gk',
						store : gkStore,
						triggerAction : 'all',
						lazyRender:true,
						//emptyText:'请选择是否信息公开！',
						//width:135,
						value:'是',
						anchor:'100%',
						mode : 'local',
						selectOnFocus : true,
						allowBlank:false,
						labelSeparator:'',
						editable : false,
						listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}
					}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '正本数量',name : 'zbsl',labelSeparator:'',allowBlank : false,xtype : 'numberfield',value:1,readOnly:'true',maxValue : 2000000000,anchor:'100%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '副本数量',name : 'fbsl',labelSeparator:'',allowBlank : false,xtype : 'numberfield',value:1,readOnly:'true',maxValue : 2000000000,anchor:'100%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype : 'combo',
						fieldLabel : '是否发卡',
						id : 'fkbz_dfileManage',
						name : 'fkbz',
						displayField : 'fkbz',
						valueField : 'fkbz',
						hiddenName : 'fkbz',
						store : fkbzStore,
						triggerAction : 'all',
						labelSeparator:'',
						lazyRender:true,
						//emptyText:'请选择是否发卡！',
						anchor:'100%',
						value:'否',
						readOnly:'true',
						
						mode : 'local',
						selectOnFocus : true,
						allowBlank:false,
						editable : false,
						listeners : {
							'select' : function(val, field) {
								if(val.getValue()=='是'){
									dfileManageEditForm.getForm().findField('fksl').setValue('1');
								}else{
									dfileManageEditForm.getForm().findField('fksl').setValue('0');
								}
							},
							'change' : function(field,newValue,oldValue){
								document.getElementById("isbc_dfileManage").value='1';
							}
						}
					}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '发卡数量',name : 'fksl',labelSeparator:'',allowBlank : false,xtype : 'numberfield',readOnly:'true',value:0,maxValue : 2000000000,anchor:'100%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构代码',name : 'jgdm',labelSeparator:'',allowBlank : false,vtype:'verifyCode',readOnly:'true',maxLength : 9,minLength:9,anchor:'100%'}]
			},{
                columnWidth:.75,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构名称',id:'jgmc_dfileManage',name : 'jgmc',labelSeparator:'',allowBlank : false,maxLength : 100,anchor:'99.9%',listeners:{change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}
                ]
			},{
                columnWidth:.3,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '法定代表人',name : 'fddbr',labelSeparator:'',allowBlank : false,maxLength : 30,anchor:'97%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}]
			},{
                columnWidth:.15,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{	xtype : 'combo',
						fieldLabel : '证件类型',
						id : 'zjlx_dfileManage',
						name:'zjlx',
						hiddenName : 'zjlx',
						valueField : 'categoryName',
						displayField : 'categoryName',
						mode : 'remote',
						store : ds_zjlx_select,
						selectOnFocus : true,
						editable : false,
						allowBlank : false,
						labelSeparator:'',
						maxLength : 25,
						anchor:'100%',
						hideLabel:true,
						value:'居民身份证',
						//onTriggerClick : Ext.emptyFn,
						triggerAction : 'all',
						loadingText : '加载中...',
						listeners : {
							'select' : function(combo, record, index) {
								if(record.data.categoryName=='居民身份证'){
									var flag = isIdCardNo(dfileManageEditForm.getForm().findField('zjhm').getValue());
									if(flag != true){
										dfileManageEditForm.getForm().findField('zjhm').focus();
									}
								}else{
									dfileManageEditForm.getForm().findField('zjhm').focus();
								}
							},
							'change' : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}
						}
					}]
			},{
                columnWidth:.27,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ 
                	xtype:'textfield',fieldLabel : '证件号码',name : 'zjhm',labelSeparator:'',hideLabel:true,allowBlank : false,confirmTo:'zjlx_dfileManage',vtype:'sfzhao',maxLength : 25,anchor:'99.9%',
                	enableKeyEvents: true,
					listeners : {
						keyup: function(f, e){//计数
				    		dfileManageEditForm.findById('ws_dfileManage').setText("("+f.getValue().length+")");
				    	},
				    	'change' : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}
					}
				}]
			},{
				columnWidth : '.03',
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'ws_dfileManage',name:'ws_dfileManage',text:'(0)'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '移动电话',id : 'mobile_dfileManage',name : 'mobile',labelSeparator:'',vtype:'mobilephone',maxLength:11,minLength:11,anchor:'100%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}]
			},{
                columnWidth:.95,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                defaultType : 'textarea',
                items: [{
                	fieldLabel : '经营范围',name : 'jyfw',allowBlank : false,labelSeparator:'',maxLength:1000,height:55,anchor:'99.5%',
                	enableKeyEvents: true,
			    	listeners:{
			    		keyup: function(f, e){//计数
				    		var length = 1000-f.getValue().length
				    		dfileManageEditForm.findById('fw_dfileManage').setText("("+length+")");
				    	},'change' : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}
			    	}
                }]
			},{
				columnWidth : .05,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'fw_dfileManage',name:'fw_dfileManage',text:'(1000)'}]
			},{
                columnWidth:.95,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                defaultType : 'textarea',
                items: [{
                	fieldLabel : '企业简介',name : 'qyjj',labelSeparator:'',maxLength:1000,height:55,anchor:'99.5%',
                	enableKeyEvents: true,
			    	listeners:{
			    		keyup: function(f, e){//计数
				    		var length = 1000-f.getValue().length
				    		dfileManageEditForm.findById('jj_dfileManage').setText("("+length+")");
				    	},'change' : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}
			    	}
                }]
			},{
				columnWidth : .05,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'jj_dfileManage',name:'jj_dfileManage',text:'(1000)'}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
		                id:'zcrq_dfileManage',
		                name: 'zcrq',
		                format:'Y-m-d',
		                maxValue:myDate,  
		                maxText:'所选日期应在{0}之前',  
		                anchor:'100%',
		                allowBlank : false,
		                labelSeparator:'',
		                fieldLabel:'成立日期',
		                renderer:dateFormat,
					    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd',
					    listeners : {
							'blur' : function(f) {
								if(f.getValue()>dfileManageEditForm.getForm().findField('zsbfrq_dfileManage').getValue()){
									dfileManageEditForm.getForm().findField('zsbfrq_dfileManage').setValue('');
								}
								dfileManageEditForm.getForm().findField('zsbfrq_dfileManage').minValue=f.getValue();
							},'change' : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}
						}
				    })]
			},{
                columnWidth:.5,
                layout: 'form',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '职工人数(人)',name : 'zgrs',labelSeparator:'',allowBlank : false,xtype : 'numberfield',maxValue : 2000000000,anchor:'99.9%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
		                id:'zsbfrq_dfileManage',
		                name: 'zsbfrq',
		                format:'Y-m-d',
		                maxValue:myDate,  
		                maxText:'所选日期应在{0}之前',
		                minText:'所选日期应在{0}之后',
		                anchor:'100%',
		                //allowBlank : false,
		                fieldLabel:'证照有效期',
		                renderer:dateFormat,
		                labelSeparator:'',
					    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd'
						,listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}
				        })]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
					    id:'zszfrq_dfileManage',
					    name: 'zszfrq',
					    format:'Y-m-d',
					    //labelStyle: "text-align: left;",
					    //maxValue:myDate,  
					    //maxText:'所选日期应在{0}之前',  
					    minValue:'01/01/1949',
					    minText:'所选日期应在{0}之后',
					    anchor:'99.9%',
					    fieldLabel:'至',
					    labelSeparator:'',
					    //labelAlign : 'left',
					    //validator:vailda,//自定义校验
					    renderer:dateFormat,
					    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd',
					    dateRange:{begin:'zsbfrq_dfileManage',end:'zszfrq_dfileManage'},//用于vtype类型dateRange   
            			vtype:'dateRange',
            			listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}
					})]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jjlxdm_dfileManage",
						name:"jjlxdm",
						fieldLabel:"企业注册类型",
					 	valueField : "jjlxdm",
					    displayField : "jjlxdm",
					    //readOnly:'true',
					    //allowBlank : false,
					    haveShow : false,
					    editable : false,
					    labelSeparator:'',
					    labelSeparator:'',
					    //emptyText:'请选择企业注册类型！',
					    //labelStyle:'text-size:9pt',
					    anchor:'97%',
					    onTriggerClick : function() {
					    	window_jjlxQuery_dfileManage.show();
					    	document.getElementById("isbc_dfileManage").value='1';
					    },
					    listeners : {
							'specialkey' : function(field, e) {
								if (e.getKey() == Ext.EventObject.ENTER) {
									findMcByDm(field);
								}
							},
							'blur': function(field){
								findMcByDm(field);
							},
							'change' : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}
						}
				    })]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '企业注册类型名称',id:"select_jjlxmc_dfileManage",name : 'jjlx',readOnly:'true',labelSeparator:'',hideLabel:true,anchor:'99.9%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}},
	                	{xtype:'hidden',id:"select_jjlxmcOld_dfileManage",name : 'jjlxOld'},
	                	{xtype:'hidden',id:"select_jjlxdmOld_dfileManage",name : 'jjlxdmOld'}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jjhydm_dfileManage",
						name:"jjhydm",
						fieldLabel:"经济行业",
					 	valueField : "jjhydm",
					    displayField : "jjhydm",
					    maxLength : 50,
					    allowBlank : false,
					    haveShow : false,
					    labelSeparator:'',
					    anchor:'97%',
					    editable : false,
					    onTriggerClick : function() {
					    	window_hylxQuery_dfileManage.show();
					    	document.getElementById("isbc_dfileManage").value='1';
					    },listeners : {
							'specialkey' : function(field, e) {
								if (e.getKey() == Ext.EventObject.ENTER) {
									findHylxNameByCode(field);
								}
							},
							'blur': function(field){
								findHylxNameByCode(field);
							},
							'change' : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}
						}
					})]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '经济行业名称',id:"select_jjhymc_dfileManage",name : 'jjhymc',allowBlank : false,readOnly:'true',labelSeparator:'',hideLabel:true,anchor:'99.9%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '注册资金(万)',name : 'zczj',labelSeparator:'',allowBlank : false,xtype : 'numberfield',decimalPrecision :6,maxValue : 2000000000,anchor:'97%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [{xtype : 'combo',
					fieldLabel : '货币种类',
					id : 'hbzl_dfileManage',
					displayField : 'categoryName',//显示值的名称
					hiddenName : 'hbzl',//真正提交时此combo的name
					valueField : 'categoryName',//真正提交时此combo的value
					mode : 'remote',
					store : ds_hbzl_select_dfileManage,
					selectOnFocus : true,
					maxLength : 50,
					hideLabel:true,
					anchor:'99.9%',
					editable : false,
					labelSeparator:'',
					triggerAction : 'all',
					value:'人民币元',
					loadingText : '加载中...',
					listeners : {
						'select' : function(combo, record, index) {
							dfileManageEditForm.getForm().findField('hbzldm_dfileManage').setValue(record.data.categoryCode);
						},
						'change' : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}
					}
				}]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [{	
                	xtype : 'combo',
					fieldLabel : '外方国别',
					name:'wftzgb',
					name:'wftzgb',
					id : 'wftzgb_dfileManage',
					displayField : 'categoryName',//显示值的名称
					hiddenName : 'wftzgb',//真正提交时此combo的name
					valueField : 'categoryName',//真正提交时此combo的value
					mode : 'remote',
					store : ds_wftzgb_select_dfileManage,
					selectOnFocus : true,
					anchor:'97%',
					maxLength : 50,
					editable : true,
					allowBlank : true,
					labelSeparator:'',
					triggerAction : 'all',
					loadingText : '加载中...',
					listeners : {
							'select' : function(combo, record, index) {
								dfileManageEditForm.getForm().findField('wftzgbdm_dfileManage').setValue(record.data.categoryCode);
							},
							'specialkey' : function(field, e) {
								if (e.getKey() == Ext.EventObject.ENTER) {
									findWftzgbDmByMC(field);
								}
							},
							'blur': function(field){
								findWftzgbDmByMC(field);
							},
							'change' : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}
						}
					}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [{xtype:'textfield',fieldLabel : '外方国别代码',id : 'wftzgbdm_dfileManage',name : 'wftzgbdm',labelSeparator:'',hideLabel:true,allowBlank : true,anchor:'99.9%'}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [new Ext.form.TriggerField({
							id:"select_zgdm_dfileManage",
							name:"zgdm",
							fieldLabel:"主管部门",
						 	valueField : "zgdm",
						    displayField : "zgdm",
						    maxLength : 9,
						    minLength : 9,
						    anchor:'97%',
							selectOnFocus : true,
						    haveShow : false,
						    labelSeparator:'',
						    editable : false,
						    onTriggerClick : function() {
						    	window_zgmcQuery_dfileManage.show();
						    	document.getElementById("isbc_dfileManage").value='1';
						    },listeners : {
								'specialkey' : function(field, e) {
									if (e.getKey() == Ext.EventObject.ENTER) {
										findTjgdmByCode(field);
									}
								},
								'blur': function(field){
									findTjgdmByCode(field);
								},
								'change' : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}
							}
					    })]
				},{
	                columnWidth:.75,
	                layout: 'form',
	                border:false,
	                items: [{xtype:'textfield',fieldLabel : '主管部门名称',name :'zgmc',labelSeparator:'',id:"select_zgmc_dfileManage",hideLabel:true,anchor:'99.9%'}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [new Ext.form.TriggerField({
							id:"select_pzjgdm_dfileManage",
							name:"pzjgdm",
							fieldLabel:"批准机构",
						 	valueField : "pzjgdm",
						    displayField : "pzjgdm",
						    maxLength : 9,
						    minLength : 9,
						    anchor:'97%',
						    labelSeparator:'',
						    allowBlank : false,
						    haveShow : false,
						    editable : false,
						    onTriggerClick : function() {
						    	window_pzjgQuery_dfileManage.show();
						    	document.getElementById("isbc_dfileManage").value='1';
						    },listeners : {
								'specialkey' : function(field, e) {
									if (e.getKey() == Ext.EventObject.ENTER) {
										findPzjgNameByCode(field);
									}
								},
								'blur': function(field){
									findPzjgNameByCode(field);
								},
								'change' : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}
							}
					    })
					]
	            },{
	                columnWidth:.75,
	                layout: 'form',
	                border:false,
	                items: [{xtype:'textfield',fieldLabel : '批准机构名称',name:'pzjgmc',labelSeparator:'',id:"select_pzjgmc_dfileManage",hideLabel:true,allowBlank : false,anchor:'99.9%'}]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '注册号',name : 'zch',labelSeparator:'',allowBlank : false,maxLength : 50,anchor:'100%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '联系电话',name : 'dhhm',labelSeparator:'',vtype:'phone',maxLength : 50,anchor:'100%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}]
	            },{
	                columnWidth:1,
	                layout: 'form',
	                border:false,
	                items: [
	                	{ xtype:'textfield',fieldLabel : '机构注册地址',name : 'jgdz',labelSeparator:'',readOnly:'true',allowBlank : false,maxLength : 100,anchor:'99.9%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}
	                ]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [
	                	new Ext.form.TriggerField({
							fieldLabel : '行政区划',
							id : 'xzqhCode_dfileManage',
							name : 'xzqhCode',  //接收值的名称
							displayField : 'xzqhCode', //显示值的名称
							valueField : 'xzqhCode',  //真正提交时此combo的value
							maxLength : 50,
							allowBlank : false,
							selectOnFocus : true,
						    haveShow : false,
						    labelSeparator:'',
						    anchor : '98%',
						    editable : false,
						    onTriggerClick : function() {
						    	window_xzqhQuery_dfileManage.show();
						    	document.getElementById("isbc_dfileManage").value='1';
						    },
						    listeners : {
								'specialkey' : function(field, e) {
									if (e.getKey() == Ext.EventObject.ENTER) {
										findXzqhNameByXzqhCode(field,'xzqhName_dfileManage');
									}
								},
								'blur': function(field){
									findXzqhNameByXzqhCode(field,'xzqhName_dfileManage');
								},
								'change' : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}
							}
					    })
					]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '行政区划名称',id:'xzqhName_dfileManage',name : 'xzqhName',labelSeparator:'',allowBlank : false,readOnly:true,hideLabel:true,maxLength : 50,anchor:'99.9%'}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '邮政编码',name : 'yzbm',labelSeparator:'',allowBlank : false,minLength : 6,maxLength : 6,anchor:'100%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}]
	            },{
	                columnWidth:1,
	                layout: 'form',
	                border:false,
	                items: [
	                	{ xtype:'textfield',fieldLabel : '机构实际地址',name : 'jydz',labelSeparator:'',maxLength : 100,anchor:'99.9%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}
	                ]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [
	                	new Ext.form.TriggerField({
							fieldLabel : '行政区划',
							id : 'xzqhCode_dfileManage2',
							name : 'xzqhCode2',  //接收值的名称
							displayField : 'xzqhCode2', //显示值的名称
							valueField : 'xzqhCode2',  //真正提交时此combo的value
							maxLength : 50,
							selectOnFocus : true,
						    haveShow : false,
						    labelSeparator:'',
						    anchor : '98%',
						    editable : false,
						    onTriggerClick : function() {
						    	window_xzqhQuery_dfileManage2.show();
						    	document.getElementById("isbc_dfileManage").value='1';
						    },
						    listeners : {
								'specialkey' : function(field, e) {
									if (e.getKey() == Ext.EventObject.ENTER) {
										findXzqhNameByXzqhCode(field,'xzqhName_dfileManage2');
									}
								},
								'blur': function(field){
									findXzqhNameByXzqhCode(field,'xzqhName_dfileManage2');
								},
								'change' : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}
							}
					    })
					]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '行政区划名称',id:'xzqhName_dfileManage2',name : 'xzqhName2',labelSeparator:'',readOnly:true,hideLabel:true,maxLength : 50,anchor:'99.9%'}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '邮政编码',name : 'jyyb',labelSeparator:'',minLength : 6,maxLength : 6,anchor:'100%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '网址',name : 'weburl',labelSeparator:'',maxLength : 50,anchor:'100%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '电子邮箱',name : 'email',labelSeparator:'',vtype:'email',vtypeText:'不是有效的邮箱地址',maxLength : 40,maxLength : 50,anchor:'100%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}]
	            },{
	                columnWidth:.3,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '经办人',name : 'tbrxm',labelSeparator:'',allowBlank : false,maxLength : 30,anchor:'97%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}]
				},{
	                columnWidth:.15,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{	xtype : 'combo',
							fieldLabel : '经办人证件类型',
							id : 'zjlx2_dfileManage',
							name:'tbrzjlx',
							hiddenName : 'tbrzjlx',
							valueField : 'categoryName',
							displayField : 'categoryName',
							mode : 'remote',
							store : ds_zjlx_select,
							selectOnFocus : true,
							editable : false,
							allowBlank : false,
							labelSeparator:'',
							//readOnly:true,
							maxLength : 25,
							anchor:'100%',
							hideLabel:true,
							//onTriggerClick : Ext.emptyFn,
							triggerAction : 'all',
							loadingText : '加载中...',
							value:'居民身份证',
							listeners : {
							'select' : function(combo, record, index) {
								if(record.data.categoryName=='居民身份证'){
									var flag = isIdCardNo(dfileManageEditForm.getForm().findField('tbrsfzh').getValue());
									if(flag != true){
										//Ext.getCmp('tbrsfzh_dfileManage').focus(false, 50);
										//dfileManageEditForm.getForm().findField('tbrsfzh').focus(false, 50);
										dfileManageEditForm.getForm().findField('tbrsfzh').focus();
										//dfileManageEditForm.findById('ts_dfileManage').setText("(0)");
									}
								}else{
									dfileManageEditForm.getForm().findField('tbrsfzh').focus();
								}
							},
							'change' : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}
						}
						}]
				},{
	                columnWidth:.27,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{
	                	xtype:'textfield',fieldLabel : '证件号码',name : 'tbrsfzh',id:'tbrsfzh_dfileManage',labelSeparator:'',hideLabel:true,confirmTo:'zjlx2_dfileManage',vtype:'sfzhao',allowBlank : false,maxLength : 50,anchor:'95%',
	                	enableKeyEvents: true,
						listeners : {
							keyup: function(f, e){//计数
					    		dfileManageEditForm.findById('ts_dfileManage').setText("("+f.getValue().length+")");
					    	},
					    	'change' : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}
						}	
					}]
				},{
					columnWidth : '.03',
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'label',
					items : [{id:'ts_dfileManage',name:'ts_dfileManage',text:'(0)'}]
				},{
	                columnWidth:.25,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '经办人电话',allowBlank : false,name : 'tbrlxfs',labelSeparator:'',vtype:'dhhmphone',maxLength : 50,anchor:'100%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}]
				},{
	                columnWidth:.33,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '办证日期',name : 'bzrq',id:'bzrq_dfileManage',labelSeparator:'',allowBlank : false,readOnly:'true',maxLength : 10,anchor:'100%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}]
				},{
	                columnWidth:.34,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '作废日期',name : 'zfrq',id:'zfrq_dfileManage',labelSeparator:'',allowBlank : false,readOnly:'true',maxLength : 10,anchor:'100%',listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}}]
				},{
	                columnWidth:.33,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [new Ext.form.DateField({  
						    id:'njqx_dfileManage',
						    name: 'njqx',
						    format:'Y-m-d',
						    maxValue:newNjqx,  
						    maxText:'所选日期应在{0}之前',  
						    minValue:'01/01/1949',
						    minText:'所选日期应在{0}之后',
						    anchor:'100%',
						    labelSeparator:'',
						    fieldLabel:'年检期限',
						    allowBlank : false,
						    renderer:dateFormat,
						    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd',
						    value:newNjqx,
						    listeners : {change : function(field,newValue,oldValue){document.getElementById("isbc_dfileManage").value='1';}}
						})
					]
				},{
                	columnWidth:1,
                	layout: 'form',
                	bodyStyle: 'padding:0px',
                	border:false,
                	items: [
//                		{xtype:'textfield',fieldLabel : '迁入地址',id:'moveoutAddrss_dfile',name : 'moveoutAddrss',maxLength : 100,readOnly:true,anchor:'100%'},
//						{xtype:'textfield',fieldLabel : '迁址原因',id:'moveoutReason_dfile',name : 'moveoutReason',maxLength : 250,readOnly:true,anchor:'100%'},
//						{xtype:'textfield',fieldLabel : '批注注销机构',id:'offPzjgmc_dfile',name : 'offPzjgmc',maxLength : 100,readOnly:true,anchor:'100%'},
//						{xtype:'textfield',fieldLabel : '批准注销文号',id:'offPzwh_dfile',name : 'offPzwh',maxLength : 50,readOnly:true,anchor:'100%'},
//						{xtype:'textfield',fieldLabel : '注销原因',id:'offReason_dfile',name : 'offReason',maxLength:250,readOnly:true,anchor:'100%'},
//						{xtype:'textfield',fieldLabel : '证书回收情况',id:'offNote_dfile',name : 'offNote',height:80,maxLength:250,anchor:'100%'}*/
                		{xtype:'textfield',fieldLabel : '备注',name : 'memo',labelSeparator:'',maxLength : 250,anchor:'99.9%'},
	                	//{xtype:'hidden',fieldLabel : '业务类型',name : 'ywlx'},
						{xtype : 'hidden',name : 'centerid'},
						{xtype : 'hidden',name : 'orgid',value:''},
						{xtype : 'hidden',name : 'docid'},
						{xtype : 'hidden',name : 'imageUrl'},
					    {xtype : 'hidden',id:'hbzldm_dfileManage',name : 'hbzldm',value:'156'},
					    {xtype : 'hidden',id:'select_jjhymcOld_dfileManage',name : 'jjhymcOld'},
					    {xtype : 'hidden',id:'select_jjhydmOld_dfileManage',name : 'jjhydmOld'},
					    {xtype : 'hidden',name : 'bzjgdm',value:currentZzUserBzjgdm},
						{xtype : 'hidden',name : 'lastdate',value :''}, 
						{xtype : 'hidden',name : 'njrq',value :''}, 
						{xtype : 'hidden',name : 'njr',value:''},
						{xtype : 'hidden',name : 'lry'},
						{xtype : 'hidden',name : 'xgr',value:''},
						{xtype : 'hidden',name : 'state'}]
				},{
	                columnWidth:1,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '问题类型',name : 'errorFlag',readOnly:true,disabled : true,anchor:'100%',height:'40'}]
				}]
		}]
});


var sm234 = new Ext.grid.CheckboxSelectionModel();
//列表显示图书主要信息//
var cm_dfileManage = new Ext.grid.ColumnModel([expander_dfileManage,
    sm234,
    {header : '原文',width : 20,dataIndex : 'imageUrl', renderer:icon_dam,sortable : false},
    {header : '流水号',width : 20,dataIndex : 'orderid',sortable : true}, 
	{header : '机构代码',width : 40,dataIndex : 'jgdm',	sortable : true}, 
	{header : '机构名称',width : 120,dataIndex : 'jgmc',sortable : true}, 
	{header : '办证机构代码',width : 40,dataIndex : 'bzjgdm',sortable : true},
	{header : '建档日期',width : 40,	dataIndex : 'handleDate',renderer: goDateFormat,sortable : true}, 
	{header : '录档日期',width : 40,dataIndex : 'pigeTime',renderer: goDateFormat,sortable : true}, 
	{header : '档案类型',width : 40,dataIndex : 'ywlx',sortable : true}, 
	{header : '问题类型',width : 120,dataIndex : 'errorFlag',id : 'errorFlag',renderer : goErrorflag,menuDisabled : true},
	{header : '备注',width : 40,dataIndex : 'memo',sortable : true}
	]
);


var dfileManageImg = new Ext.Panel({
	id:'dfileManageImgId',
	title   : '原文浏览',
    split: true,
	width:600,
	collapsible:true,
	collapsed: false,//是否默认打开
    region:'east',
    margins   : '3 3 3 0', 
    cmargins  : '3 3 3 3',
    activeTab : 0,
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"  width=100%  height=100% align=center hspace=0 vspace=0 id="scanner994"  name="scanner994" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>'
    
});

//Panel for the west
var  dfileManageView= new Ext.Panel({
	title       : '基本信息',
    region:'center',
    margins     : '3 0 3 3',
    cmargins    : '3 0 3 3',
    autoScroll : true,
    bodyStyle: 'padding:0px',
    layout: 'fit',
    items : [dfileManageEditForm]
}); 

function  saveImgFunc(btn){
	//数据保存成功后，再自动保存原文
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
	
	btn.disable();
	var record = grid_dfileManage.getSelectionModel().getSelected();
	strOrgid = record.data.orgid;  //参数orgid
	strDocid =record.data.docid;  //参数docid
	strBzjgdm = record.data.bzjgdm;

	packLength = 40960;	//定义每个包的大小40960
	base64file = scanner994.ImageData;  //获取控件扫描的图片数据
	var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
	imageCount = scanner994.GetPageCount;	//获取扫描图片的页数
	pageTypeStr = scanner994.PageType;    //获取标识字符串,需要写数据库
	if(pageTypeStr!=""){
		pageTypeStr=pageTypeStr.replace(/\%/g, "|"); 
	}
	packCount = Math.ceil(baseSize / packLength);	//判断需要发送数据包的个数
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
	scanner994.OpenProgress(packCount);  //设置上传的进度条的总进度数
	xmlhttp = GetXmlHttp(); //通过AJAX格式上传
	for(var i=0; i < packCount; i++)  //分包上传
	{
		if(i==packCount-1){
			lastpack="true";
		}else{
			lastpack="false";
		}				
		pack = base64file.substring(i * packLength, (i + 1) * packLength);  //每个数据包的文件大小
		try
		{
			xmlhttp.open("post", "saveImageDfile.action?orgid="+strOrgid+"&docid="+strDocid+"&packindex="+i+"&pageTypeStr="+pageTypeStr+"&bzjgdm="+strBzjgdm+"&lastpack="+lastpack, false);
			xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   //这句必须要，而且一定要放在send以前
			xmlhttp.send("imageData=" + encodeURIComponent(pack)); 
			var objs = eval("["+xmlhttp.responseText+"]");
			if(objs[0].success)
			{
				scanner994.Progress('上传中',i+1);
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
	Ext.Msg.show({
		title : '提示',
		msg : '['+dfileManageEditForm.getForm().findField('jgmc').value+']，<br><br>申办信息保存成功！',
			buttons : Ext.Msg.OK,
			fn : function() {
				btn.enable();
				dfileManageEditForm.getForm().reset();
				scanner994.PageType="";
				scanner994.ImageData="";
				var record = grid_dfileManage.getSelectionModel().getSelected();
				if(record){
					grid_dfileManage.getStore().remove(record);
				}
			},
			icon : Ext.Msg.INFO
	});	
	scanner994.CloseProgress();
	return true;
}

var window_edit_dfileManage = new Ext.Window({
	title : '数据修改',
	iconCls : 'icon-plugin',
	width : 1000,
	height : 600,
	resizable : true,
	modal : true,
	plain    : true,
	layout   : 'border',
	closeAction : 'hide',
	maximized :true,  //默认最大化
	items : [dfileManageView,dfileManageImg],
	buttons : [{
		text : '保存',
		handler : function(btn){
			if (dfileManageEditForm.getForm().isValid()) {
				btn.disable();
				dfileManageEditForm.getForm().submit({
					waitTitle : '请稍候',
					waitMsg : '正在修改数据,请稍候...',
					success : function(form,action) {
						document.getElementById("isbc_dfileManage").value='0'; 
						saveImgFunc(btn);
						
					},
					failure : function(form) {
						Ext.Msg.show({
							title : '提示',
							msg : '保存失败',
							buttons : Ext.Msg.OK,
							fn : function() {btn.enable();},
							icon : Ext.Msg.ERROR
						});
					}
				});
			}
		}
	},{   
        text: '前一条',   
        handler: function(btn) {
        	var isbc_dfileManage=document.getElementById("isbc_dfileManage").value
        		if(isbc_dfileManage=='1'){
        			Ext.Msg.confirm('提示','“数据已修改”需要保存吗?',function(btn2){
	        			if('yes' == btn2){
		        				//执行保存
		        				if (dfileManageEditForm.getForm().isValid()) {
		        					dfileManageEditForm.getForm().submit({
		        						waitTitle : '请稍候',
		        						waitMsg : '正在修改数据,请稍候...',
		        						success : function(form) {
		        							//数据保存成功后，再自动上传原文
											document.getElementById("isbc_dfileManage").value='0'; 
											saveImgFunc(btn); 
		        						},
		        						failure : function(form) {
		        							alert("nnnn");
		        							Ext.Msg.show({
		        								title : '错误提示',
		        								msg : '操作失败',
		        								buttons : Ext.Msg.OK,
		        								icon : Ext.Msg.ERROR
		        							});
		        						}
		        					});
		        				}	
	    				}else{
	    					//前一条
	    					var grid_ = grid_dfileManage;
	    		            var selModel = grid_.getSelectionModel();
	    		            if(selModel.hasPrevious()){
	    		                selModel.selectPrevious();
	    		         		var record = grid_dfileManage.getSelectionModel().getSelected();
	    		         		if(record){
	    		         			//加载数据
	    		         			dfileManageEditForm.getForm().loadRecord(record);
	    		         			dfileManageEditForm.getForm().findField('errorFlag').setValue(goErrorflag2(record.data.errorFlag));
	    		         			//记载原文
	    		         			scanner994.ImageData="";
	    		        			scanner994.pageType="";
	    		        			var tab345273334=Ext.getCmp("dfileManageImgId");
									tab345273334.setTitle("原文浏览 ");
	    		         		}
	    		             }else{
	    		                 alert("已经到第一条,请翻页");
	    		             }	
	    				}
        				
        			});	
        		}else{
        			//前一条
					var grid_ = grid_dfileManage;
		            var selModel = grid_.getSelectionModel();
		            if(selModel.hasPrevious()){
		                selModel.selectPrevious();
		         		var record = grid_dfileManage.getSelectionModel().getSelected();
		         		if(record){
		         			//加载数据
		         			dfileManageEditForm.getForm().loadRecord(record);
		         			dfileManageEditForm.getForm().findField('errorFlag').setValue(goErrorflag2(record.data.errorFlag));
		         			
		         			//加载原文
		         			scanner994.ImageData="";
		        			scanner994.pageType="";
		        			var tab345273335=Ext.getCmp("dfileManageImgId");
							tab345273335.setTitle("原文浏览 ");
		         		}
		             }else{
		                 alert("已经到第一条,请翻页");
		             }	
        		}	
        	}  
    },{   
        text: '下一条',   
        handler: function(btn) {
        	var isbc_dfileManage=document.getElementById("isbc_dfileManage").value
        		if(isbc_dfileManage=='1'){
        			Ext.Msg.confirm('提示','“数据已修改”需要保存吗?',function(btn2){
	        			if('yes' == btn2){
		        				//执行保存
		        				if (dfileManageEditForm.getForm().isValid()) {
		        					dfileManageEditForm.getForm().submit({
		        						waitTitle : '请稍候',
		        						waitMsg : '正在修改数据,请稍候...',
		        						success : function(form) {
		        							//数据保存成功后，再自动上传原文
											document.getElementById("isbc_dfileManage").value='0'; 
											saveImgFunc(btn); 
		        						},
		        						failure : function(form) {
		        							Ext.Msg.show({
		        								title : '错误提示',
		        								msg : '操作失败',
		        								buttons : Ext.Msg.OK,
		        								icon : Ext.Msg.ERROR
		        							});
		        						}
		        					});
		        				}
	    				}else{
					        	 var grid_ = grid_dfileManage;
					             var selModel = grid_.getSelectionModel();
					             if(selModel.hasNext()){
					                selModel.selectNext();
					                //grid_dfileManage.getSelectionModel().selectNext();
					         		var record = grid_dfileManage.getSelectionModel().getSelected();
					         		if(record){
					         			//加载数据
					         			dfileManageEditForm.getForm().loadRecord(record);
					         			dfileManageEditForm.getForm().findField('errorFlag').setValue(goErrorflag2(record.data.errorFlag));
					         			document.getElementById("isbc_dfileManage").value='0'; 
					         			//记载原文
					         			scanner994.ImageData="";
					        			scanner994.pageType="";
					        			var tab345273336=Ext.getCmp("dfileManageImgId");
										tab345273336.setTitle("原文浏览 ");
					         		}
					             }else{
					                 alert("已经到最后一条,请翻页");
					             }
	    					}
        				
        				}); 
        		}else{
        			var grid_ = grid_dfileManage;
		            var selModel = grid_.getSelectionModel();
		            if(selModel.hasNext()){
		                selModel.selectNext();
		                //grid_dfileManage.getSelectionModel().selectNext();
		         		var record = grid_dfileManage.getSelectionModel().getSelected();
		         		if(record){
		         			//加载数据
		         			dfileManageEditForm.getForm().loadRecord(record);
		         			dfileManageEditForm.getForm().findField('errorFlag').setValue(goErrorflag2(record.data.errorFlag));
		         			document.getElementById("isbc_dfileManage").value='0'; 
		         			//记载原文
		         			scanner994.ImageData="";
		        			scanner994.pageType="";
		        			var tab345273337=Ext.getCmp("dfileManageImgId");
							tab345273337.setTitle("原文浏览 ");
		         		}
		             }else{
		                 alert("已经到最后一条,请翻页");
		             }
				}            	             
        }   
    },{
    	text: '查看原文',   
        handler: function() {  
        	var record = grid_dfileManage.getSelectionModel().getSelected();
        	if(record){
        		scanner994.ImageData="";
    			scanner994.pageType="";
    			var veiwFileTitle= record.data.jgmc+"("+record.data.jgdm+")";
    			
    			var tab34527333=Ext.getCmp("dfileManageImgId");
				tab34527333.setTitle("原文浏览-- "+veiwFileTitle);
    			Ext.Ajax.request({
					url : 'dfileViewImg.action',
					params : {orgid : record.data.orgid,d_flag:record.data.d_flag},
					success : function(result,request) {//获取返回值
						var resultObject90 = Ext.util.JSON.decode(result.responseText);
						if(resultObject90.imageData!=null && resultObject90.imageData!=""){
							scanner994.OpenProgress(3);  //设置上传的进度条的总进度数
							scanner994.Progress('原文加载中',1);
							scanner994.Progress('原文加载中',2);
		   					scanner994.ImageData=resultObject90.imageData;
							if(scanner994.ImageData!=""){
								scanner994.PageType=resultObject90.pageTypeStr;
								scanner994.Progress('原文加载完毕',3);
							}else{
								scanner994.Progress('原文加载失败',3);
		   						alert("原文错误，加载失败，请重新扫描或导入！");
							}
							scanner994.CloseProgress();
						}
					},
					failure : function() {
						alert("图像加载错误");
					}
				});
        	}
        }   	
    },{   
        text: '重置',   
        handler: function(btn) {   
     		//重新加载
            //grid_dfileManage.getSelectionModel().selectNext();
     		var record = grid_dfileManage.getSelectionModel().getSelected();
     		if(record){
     			//加载数据
     			document.getElementById("isbc_dfileManage").value='0'; 
     			dfileManageEditForm.getForm().loadRecord(record);
     			dfileManageEditForm.getForm().findField('errorFlag').setValue(goErrorflag2(record.data.errorFlag));
     			
     			//记载原文
     			scanner994.ImageData="";
    			scanner994.pageType="";
    			var tab345273338=Ext.getCmp("dfileManageImgId");
				tab345273338.setTitle("原文浏览 ");
	    		btn.enable();
     		}
        }   
    },{   
        text: '退出',   
        handler: function() {   
        	window_edit_dfileManage.hide(); 
        }   
    }]
});

function ShowInfoMsg(aMsg,winWidth){
	var InfoMsgWin=Ext.getCmp('InfoMsgWin');
	if(InfoMsgWin){
		InfoMsgWin.close();
	};
	var okBtn=new Ext.Button({
		id:'okButton',
		text:'确定',
		enableToggle:false,
		iconCls:'okbutton-icon-cls',
		minWidth:80,
		tooltip:'确定',
		handler:function(){
			var aWin=Ext.getCmp('InfoMsgWin');
			if(aWin){aWin.close();
		};
		delete aWin;
		}
	});
	InfoMsgWin=new Ext.Window({
		id:'InfoMsgWin',
		title:"提示信息",
		border:true,
		resizable:false,
		closable:true,
		closeAction:'close',
		modal:true,
		width:winWidth,
		iconCls:'msgwindow-icon-cls',
		html:aMsg,
		buttonAlign:'center',
		buttons:[okBtn]
	});
	InfoMsgWin.show();
	delete okBtn;
	delete InfoMsgWin;
};

var btn_refresh_dfileManage = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchDfileManageid.value='';
		searchDfileManage();
		//btn_edit_dfileManage.setDisabled(true);
	}
});


var btn_edit_dfileManage = new Ext.Button({
	text : '修改',
	iconCls : 'icon-edit',
	handler : function(){
		var record = grid_dfileManage.getSelectionModel().getSelected();
		if(record){
			window_edit_dfileManage.show();
			dfileManageEditForm.getForm().loadRecord(record);
			dfileManageEditForm.getForm().findField('errorFlag').setValue(goErrorflag2(record.data.errorFlag));
		}else{
			alert("请选择数据");
		}
	}
})


var searchDfileManage = function() {
	ds_dfileManage.baseParams.conditions = text_search_dfileManage.getValue();
	ds_dfileManage.baseParams.username='';
	ds_dfileManage.baseParams.stateConditions='';
	ds_dfileManage.baseParams.dflagConditions='2';   //查询问题数据
	ds_dfileManage.load({params : {start : 0,limit : useFullPageSize}
	});
}

var ds_dfileManage = new Ext.data.Store({
	url : 'findQxDfile.action',
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
		{name : 'jjhymc',type : 'string'},
		{name : 'jjhydm',type : 'string'},
		{name : 'jjhymcOld',type : 'string'},
		{name : 'jjhydmOld',type : 'string'},
		{name : 'isca',type : 'string'},
		{name : 'fkbz',type : 'string'},
		{name : 'zbsl',type : 'string'},
		{name : 'fbsl',type : 'string'},
		{name : 'fksl',type : 'int'},
		{name : 'isxw',type : 'string'},
		{name : 'gk',type : 'string'},
		
		{name : 'fddbr',type : 'string'}, 
		{name : 'zjlx',type : 'string'},
		{name : 'zjhm',type : 'string'}, 
		{name : 'jyfw',type : 'string'},
		{name : 'qyjj',type : 'string'},
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
		
		{name : 'njrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'bzrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		
		{name : 'zsbfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zszfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zslsh',type : 'string'},
		{name : 'bzrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'njqx',type: 'date', convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'njrq',type: 'date', convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'jjlx',type : 'string'},
		{name : 'jjlxdm',type : 'string'},
		{name : 'tbrzjlx',type : 'string'},
		{name : 'memo',type : 'string'},
		{name : 'memo2',type : 'string'},
		
		{name : 'moveoutCenter',type : 'string'},
		{name : 'moveoutBzjgdm',type : 'string'},
		{name : 'moveoutAddrss',type : 'string'},
		{name : 'moveoutReason',type : 'string'},
		{name : 'offPzjgmc',type : 'string'},
		{name : 'offPzwh',type : 'string'},
		{name : 'offReason',type : 'string'},
		{name : 'offNote',type : 'string'},
		
		{name : 'jydz',type : 'string'},
		{name : 'jyyb',type : 'string'},
		{name : 'jydh',type : 'string'},
		{name : 'jfly',type : 'string'},
		{name : 'khyh',type : 'string'},
		{name : 'khzh',type : 'string'},
		{name : 'name',type : 'string'},
		{name : 'userid',type : 'string'},
		{name : 'username',type : 'string'},
		{name : 'handleUsername',type : 'string'},
		{name : 'handleName',type : 'string'},
		{name : 'handleDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'handleNote',type : 'string'},
		{name : 'auditUsername',type : 'string'},
		{name : 'auditName',type : 'string'},
		{name : 'auditDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'auditNote',type : 'string'},
		
		{name : 'offPzjgmc',type : 'string'},
		{name : 'offPzwh',type : 'string'},
		{name : 'offReason',type : 'string'},	
		{name : 'offNote',type : 'string'},
		{name : 'imageUrl',type : 'string'},
		{name : 'pageTypeStr',type : 'string'},
		
		{name : 'd_flag',type : 'int'}, 
		{name : 'up_Dflag',type : 'int'}, 
		{name : 'up_Aflag',type : 'int'}, 
		{name : 'errorFlag',type : 'string'},
		{name : 'pigeTime',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'ywlx',type : 'string'},
		{name : 'state',type : 'string'}]
	)
});


var btn_search_dfileManage = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : searchDfileManage
});

var text_search_dfileManage = new Ext.form.TextField({
	id : 'textSearchDfileManageid',
	name : 'textSearchDfileManage',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchDfileManage();
			}
		}
	}
});

/*
//# 每页显示行数   
// Page size combo box   
var pagingCombo = new Ext.form.ComboBox({   
    store : new Ext.data.SimpleStore({   
        fields : ['num'],   
        data : [[5], [10], [20], [50], [100]]   
    }),   
    displayField : 'num',   
    typeAhead : false,   
    mode : 'local',   
    triggerAction : 'all',   
    emptyText : '行数',   
    selectOnFocus : false,   
    allowBlank : false,   
    width : 65,   
    listWidth : 65,   
    resizable : false  
});   

pagingCombo.on('select', function(combo, record, index) {   
    setGridLimit(record.data.num);   
});   
function setGridLimit(record) {   
    dsLimit = record;   
    paging.pageSize = record;   
    refreshGrid();   
}   

function refreshGrid() {   
    var create_time = Ext.get('startdate').dom.value;   
    var end_time = Ext.get('enddate').dom.value;   
    ds.load({   
        params : {   
            start : 0,   
            limit : dsLimit
        }   
    });   
} 
  
//把一下语句计入tbar中，既可以实现翻页，，参数需要修改
  ,{id : 'btnSearch', text : '每页显示', tooltip : '每页显示' }, pagingCombo,'--'
*/

var grid_dfileManage = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_dfileManage,
	ds : ds_dfileManage,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'errorFlag',
	viewConfig : {forceFit : true},
	plugins : expander_dfileManage,
	tbar : [btn_edit_dfileManage,btn_refresh_dfileManage,'->',text_search_dfileManage,btn_search_dfileManage],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_dfileManage,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'rowdblclick':function(grid, rowIndex){
			var record = grid_dfileManage.getSelectionModel().getSelected();
			if(record){
				window_edit_dfileManage.show();
				dfileManageEditForm.getForm().loadRecord(record);
				dfileManageEditForm.getForm().findField('errorFlag').setValue(goErrorflag2(record.data.errorFlag));
				if(record.data.ywlx=='注销'||record.data.ywlx=='批量注销'||record.data.ywlx=='预赋码'||record.data.ywlx=='迁出'){
					dfileManageEditForm.getForm().findField('zbsl').allowBlank=true;
					dfileManageEditForm.getForm().findField('fbsl').allowBlank=true;
					dfileManageEditForm.getForm().findField('fddbr').allowBlank=true;
					dfileManageEditForm.getForm().findField('zjlx').allowBlank=true;
					dfileManageEditForm.getForm().findField('zjhm').allowBlank=true;
					dfileManageEditForm.getForm().findField('jyfw').allowBlank=true;
					dfileManageEditForm.getForm().findField('zcrq').allowBlank=true;
					dfileManageEditForm.getForm().findField('zgrs').allowBlank=true;
					dfileManageEditForm.getForm().findField('jjhymc').allowBlank=true;
					dfileManageEditForm.getForm().findField('jjhydm').allowBlank=true;
					dfileManageEditForm.getForm().findField('pzjgmc').allowBlank=true;
					dfileManageEditForm.getForm().findField('pzjgdm').allowBlank=true;
					dfileManageEditForm.getForm().findField('zczj').allowBlank=true;
					dfileManageEditForm.getForm().findField('jgdz').allowBlank=true;
					dfileManageEditForm.getForm().findField('zch').allowBlank=true;
					dfileManageEditForm.getForm().findField('bzrq').allowBlank=true;
					dfileManageEditForm.getForm().findField('zfrq').allowBlank=true;
					dfileManageEditForm.getForm().findField('njqx').allowBlank=true;
					dfileManageEditForm.getForm().findField('tbrlxfs').allowBlank=true;
					dfileManageEditForm.getForm().findField('xzqhCode').allowBlank=true;
					dfileManageEditForm.getForm().findField('xzqhName').allowBlank=true;
					dfileManageEditForm.getForm().findField('jglxdm').allowBlank=true;
					dfileManageEditForm.getForm().findField('jglx').allowBlank=true;
					dfileManageEditForm.getForm().findField('yzbm').allowBlank=true;
				}else{
					dfileManageEditForm.getForm().findField('zbsl').allowBlank=false;
					dfileManageEditForm.getForm().findField('fbsl').allowBlank=false;
					dfileManageEditForm.getForm().findField('fddbr').allowBlank=false;
					dfileManageEditForm.getForm().findField('zjlx').allowBlank=false;
					dfileManageEditForm.getForm().findField('zjhm').allowBlank=false;
					dfileManageEditForm.getForm().findField('jyfw').allowBlank=false;
					dfileManageEditForm.getForm().findField('zcrq').allowBlank=false;
					dfileManageEditForm.getForm().findField('zgrs').allowBlank=false;
					dfileManageEditForm.getForm().findField('jjhymc').allowBlank=false;
					dfileManageEditForm.getForm().findField('jjhydm').allowBlank=false;
					dfileManageEditForm.getForm().findField('pzjgmc').allowBlank=false;
					dfileManageEditForm.getForm().findField('pzjgdm').allowBlank=false;
					dfileManageEditForm.getForm().findField('zczj').allowBlank=false;
					dfileManageEditForm.getForm().findField('jgdz').allowBlank=false;
					dfileManageEditForm.getForm().findField('zch').allowBlank=false;
					dfileManageEditForm.getForm().findField('bzrq').allowBlank=false;
					dfileManageEditForm.getForm().findField('zfrq').allowBlank=false;
					dfileManageEditForm.getForm().findField('njqx').allowBlank=false;
					dfileManageEditForm.getForm().findField('tbrlxfs').allowBlank=false;
					dfileManageEditForm.getForm().findField('xzqhCode').allowBlank=false;
					dfileManageEditForm.getForm().findField('xzqhName').allowBlank=false;
					dfileManageEditForm.getForm().findField('jglxdm').allowBlank=false;
					dfileManageEditForm.getForm().findField('jglx').allowBlank=false;
					dfileManageEditForm.getForm().findField('yzbm').allowBlank=false;
				}
			}
		}
	}
});

var zzDfileManage_panel = new Ext.Panel({
	title : '问题库管理',
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
	    items : [grid_dfileManage]
	}]
});

var p_zzDfileManage = {
	id : 'zzDfileManage-panel',
	border : false,
	layout : 'border',
	items : [zzDfileManage_panel]
}
