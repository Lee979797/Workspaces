
var searchXzqh_huanzheng2 = function() {
	ds_xzqh_huanzheng2.baseParams.conditions = text_search_xzqh_huanzheng2.getValue();
	ds_xzqh_huanzheng2.baseParams.username='';
	ds_xzqh_huanzheng2.baseParams.stateConditions='';
	ds_xzqh_huanzheng2.load({params : {start : 0,limit : 20} });
}

var btn_search_xzqh_huanzheng2 = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchXzqh_huanzheng2();
	}
});

var text_search_xzqh_huanzheng2 = new Ext.form.TextField({
	id : 'textSearchXzqh_huanzheng2',
	name : 'textSearchXzqh_huanzheng2',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchXzqh_huanzheng2();
			}
		},
		'change' : function(field, e) {
			searchXzqh_huanzheng2();
			//btn_search_xzqh_huanzheng.setDisabled(false);
		}
	}
});

var cm_xzqh_huanzheng2 = new Ext.grid.ColumnModel([
	{header : '行政区划名称',width : 50,dataIndex : 'xzqhName',sortable : true},
	{header : '行政区划代码',width : 20,dataIndex : 'xzqhCode',sortable : true}
]);

var ds_xzqh_huanzheng2 = new Ext.data.Store({
	url : 'findAllByConditionXzqh.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'xzqhCode',type : 'string'},
			{name : 'xzqhName',type : 'string'},
			{name : 'xzqhNote',type : 'string'}
		])
});
var grid_xzqh_huanzheng2 = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_xzqh_huanzheng2,
	ds : ds_xzqh_huanzheng2,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入行政区划名称：',text_search_xzqh_huanzheng2,btn_search_xzqh_huanzheng2],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_xzqh_huanzheng2,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_xzqhQuery_huanzheng2.hide();
			var selections=grid.getSelectionModel().getSelections();
			huanzhengViewForm.getForm().findField('xzqhName_huanzheng2').setValue(selections[0].get('xzqhName'));
			huanzhengViewForm.getForm().findField('xzqhCode_huanzheng2').setValue(selections[0].get('xzqhCode'));
		}
	}
});

var window_xzqhQuery_huanzheng2 = new Ext.Window({
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
	items : [grid_xzqh_huanzheng2]
});
//行政区划的到此结束

var searchXzqh_huanzheng = function() {
	ds_xzqh_huanzheng.baseParams.conditions = text_search_xzqh_huanzheng.getValue();
	ds_xzqh_huanzheng.baseParams.username='';
	ds_xzqh_huanzheng.baseParams.stateConditions='';
	ds_xzqh_huanzheng.load({params : {start : 0,limit : 20} });
}

var btn_search_xzqh_huanzheng = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchXzqh_huanzheng();
	}
});

var text_search_xzqh_huanzheng = new Ext.form.TextField({
	id : 'textSearchXzqh_huanzheng',
	name : 'textSearchXzqh_huanzheng',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchXzqh_huanzheng();
			}
		},
		'change' : function(field, e) {
			searchXzqh_huanzheng();
			//btn_search_xzqh_huanzheng.setDisabled(false);
		}
	}
});

var cm_xzqh_huanzheng = new Ext.grid.ColumnModel([
	{header : '行政区划名称',width : 50,dataIndex : 'xzqhName',sortable : true},
	{header : '行政区划代码',width : 20,dataIndex : 'xzqhCode',sortable : true}
]);

var ds_xzqh_huanzheng = new Ext.data.Store({
	url : 'findAllByConditionXzqh.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'xzqhCode',type : 'string'},
			{name : 'xzqhName',type : 'string'},
			{name : 'xzqhNote',type : 'string'}
		])
});
var grid_xzqh_huanzheng = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_xzqh_huanzheng,
	ds : ds_xzqh_huanzheng,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入行政区划名称：',text_search_xzqh_huanzheng,btn_search_xzqh_huanzheng],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_xzqh_huanzheng,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_xzqhQuery_huanzheng.hide();
			var selections=grid.getSelectionModel().getSelections();
			huanzhengViewForm.getForm().findField('xzqhName_huanzheng').setValue(selections[0].get('xzqhName'));
			huanzhengViewForm.getForm().findField('xzqhCode_huanzheng').setValue(selections[0].get('xzqhCode'));
		}
	}
});

var window_xzqhQuery_huanzheng = new Ext.Window({
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
	items : [grid_xzqh_huanzheng]
});
//行政区划的到此结束

var btn_search_pzjg_huanzheng = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchPzjg_huanzheng();
		//btn_search_pzjg_huanzheng.setDisabled(true);
	}
});


var text_search_pzjg_huanzheng = new Ext.form.TextField({
	id : 'textSearchPzjg_huanzheng',
	name : 'textSearchPzjg_huanzheng',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchPzjg_huanzheng();
			}
		},
		'change' : function(field, e) {
			btn_search_pzjg_huanzheng.setDisabled(false);
		}
	}
});


var cm_pzjg_huanzheng = new Ext.grid.ColumnModel([
	{header : '批准机构名称',width : 50,dataIndex : 'pzjgmc',sortable : true}, 
	{header : '批准机构代码',width : 20,dataIndex : 'pzjgdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_pzjg_huanzheng = new Ext.data.Store({
	url : 'findAllByConditionPzjg.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'pzjgid',type : 'int'}, 
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchPzjg_huanzheng = function() {
	ds_pzjg_huanzheng.baseParams.conditions = text_search_pzjg_huanzheng.getValue();
	ds_pzjg_huanzheng.baseParams.username='';
	ds_pzjg_huanzheng.baseParams.stateConditions='';
	ds_pzjg_huanzheng.load({params : {start : 0,limit : 20} });
}

var grid_pzjg_huanzheng = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_pzjg_huanzheng,
	ds : ds_pzjg_huanzheng,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入登记批准机构名称：',text_search_pzjg_huanzheng,btn_search_pzjg_huanzheng],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_pzjg_huanzheng,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_pzjgQuery_huanzheng.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			huanzhengViewForm.getForm().findField('select_pzjgmc_huanzheng').setValue(selections[0].get('pzjgmc'));
			huanzhengViewForm.getForm().findField('select_pzjgdm_huanzheng').setValue(selections[0].get('pzjgdm'));
		}
	}
});


var window_pzjgQuery_huanzheng = new Ext.Window({
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
	items : [grid_pzjg_huanzheng]
});


var btn_search_jglxSelcet_huanzheng = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJglxSelcet_huanzheng();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_jglxSelcet_huanzheng = new Ext.form.TextField({
	id : 'textsearchJglxSelcet_huanzheng',
	name : 'textsearchJglxSelcet_huanzheng',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJglxSelcet_huanzheng();
			}
		},
		'change' : function(field, e) {
			btn_search_jglxSelcet_huanzheng.setDisabled(false);
		}
	}
});


var cm_jglxSelcet_huanzheng = new Ext.grid.ColumnModel([
    {header : '一级类型',width : 60,dataIndex : 'pjglxmc',sortable : true}, 
	{header : '二级类型',width : 100,dataIndex : 'jglxmc',sortable : true}, 
	{header : '代码',width : 30,dataIndex : 'jglxdm',sortable : true},
	{header : '备注',width : 50,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_jglxSelcet_huanzheng = new Ext.data.Store({
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

var ds_hbzl_select_huanzheng = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=1',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});

var searchJglxSelcet_huanzheng = function() {
	ds_jglxSelcet_huanzheng.baseParams.conditions = text_search_jglxSelcet_huanzheng.getValue();
	ds_jglxSelcet_huanzheng.baseParams.username="";
	ds_jglxSelcet_huanzheng.baseParams.stateConditions='';
	ds_jglxSelcet_huanzheng.load({params : {start : 0,limit : 20} });
}

var grid_jglx_huanzheng = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jglxSelcet_huanzheng,
	ds : ds_jglxSelcet_huanzheng,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入机构类型名称：',text_search_jglxSelcet_huanzheng,btn_search_jglxSelcet_huanzheng],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jglxSelcet_huanzheng,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jglxQuery_huanzheng.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			huanzhengViewForm.getForm().findField('select_jglxmc_huanzheng').setValue(selections[0].get('jglxmc'));
			huanzhengViewForm.getForm().findField('select_jglxdm_huanzheng').setValue(selections[0].get('jglxdm'));
			
			if(selections[0].get('pjglxdm')==1){
				huanzhengViewForm.getForm().findField('select_jjlxmc_huanzheng').allowBlank=false;
				huanzhengViewForm.getForm().findField('select_jjlxdm_huanzheng').allowBlank=false;
			}else{
				huanzhengViewForm.getForm().findField('select_jjlxmc_huanzheng').allowBlank=true;
				huanzhengViewForm.getForm().findField('select_jjlxdm_huanzheng').allowBlank=true;
			}
		}
	}
});


var window_jglxQuery_huanzheng = new Ext.Window({
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
	items : [grid_jglx_huanzheng]
});

var btn_search_hylxSelcet_huanzheng = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchHylxSelcet_huanzheng();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_hylxSelcet_huanzheng = new Ext.form.TextField({
	id : 'textSearchHylxSelcet_huanzheng',
	name : 'textSearchHylxSelcet_huanzheng',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchHylxSelcet_huanzheng();
			}
		},
		'change' : function(field, e) {
			btn_search_hylxSelcet_huanzheng.setDisabled(false);
		}
	}
});

var ds_wftzgb_select_huanzheng = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=3',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});

var cm_hylxSelcet_huanzheng = new Ext.grid.ColumnModel([
	{header : '大类',width : 100,dataIndex : 'hylxmc1',sortable : true}, 
	{header : '中类',width : 100,dataIndex : 'hylxmc2',sortable : true}, 
	{header : '小类',width : 100,dataIndex : 'hylxmc3',sortable : true}, 
    {header : '经济行业名称',width : 100,dataIndex : 'hylxmc',sortable : true},
	{header : '经济行业代码',width : 30,dataIndex : 'hylxdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_hylxSelcet_huanzheng = new Ext.data.Store({
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

var searchHylxSelcet_huanzheng = function() {
	ds_hylxSelcet_huanzheng.baseParams.conditions = text_search_hylxSelcet_huanzheng.getValue();
	ds_hylxSelcet_huanzheng.baseParams.username="";
	ds_hylxSelcet_huanzheng.baseParams.stateConditions='';
	ds_hylxSelcet_huanzheng.load({params : {start : 0,limit : 20} });
}

var grid_hylx_huanzheng = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_hylxSelcet_huanzheng,
	ds : ds_hylxSelcet_huanzheng,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入经济行业代码名称：',text_search_hylxSelcet_huanzheng,btn_search_hylxSelcet_huanzheng],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_hylxSelcet_huanzheng,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_hylxQuery_huanzheng.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			huanzhengViewForm.getForm().findField('select_jjhymc_huanzheng').setValue(selections[0].get('hylxmc'));
			huanzhengViewForm.getForm().findField('select_jjhydm_huanzheng').setValue(selections[0].get('hylxdm'));
			huanzhengViewForm.getForm().findField('select_jjhymcOld_huanzheng').setValue(selections[0].get('hylxmcOld'));
			huanzhengViewForm.getForm().findField('select_jjhydmOld_huanzheng').setValue(selections[0].get('hylxdmOld'));
		}
	}
});


var window_hylxQuery_huanzheng = new Ext.Window({
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
	items : [grid_hylx_huanzheng]
});


var btn_search_jjlx_huanzheng = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJjlx_huanzheng();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_jjlx_huanzheng = new Ext.form.TextField({
	id : 'textSearchJjlx_huanzheng',
	name : 'textSearchJjlx_huanzheng',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJjlx_huanzheng();
			}
		},
		'change' : function(field, e) {
			btn_search_jjlx_huanzheng.setDisabled(false);
		}
	}
});


var cm_jjlx_huanzheng = new Ext.grid.ColumnModel([
    {header : '大类',width : 30,dataIndex : 'pjjlxmc',sortable : true}, 
    {header : '中类',width : 30,dataIndex : 'pjjlxmc2',sortable : true}, 
    {header : '小类',width : 30,dataIndex : 'pjjlxmc3',sortable : true}, 
	{header : '经济类型名称',width : 100,dataIndex : 'jjlxmc',sortable : true}, 
	{header : '经济类型代码',width : 30,dataIndex : 'jjlxdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_jjlx_huanzheng = new Ext.data.Store({
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


var jglxStore_huanzheng = new Ext.data.Store({
	url : 'findAllByConditionJjlx.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'jjlxmc',type : 'string'},
		{name : 'jjlxdm',type : 'string'}
	])
});


var searchJjlx_huanzheng = function() {
	ds_jjlx_huanzheng.baseParams.conditions = text_search_jjlx_huanzheng.getValue();
	ds_jjlx_huanzheng.baseParams.username='';
	ds_jjlx_huanzheng.baseParams.stateConditions='';
	ds_jjlx_huanzheng.load({params : {start : 0,limit : 20} });
}

var grid_jjlx_huanzheng = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jjlx_huanzheng,
	ds : ds_jjlx_huanzheng,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入企业登记注册类型名称：',text_search_jjlx_huanzheng,btn_search_jjlx_huanzheng],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jjlx_huanzheng,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jjlxQuery_huanzheng.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			huanzhengViewForm.getForm().findField('select_jjlxmc_huanzheng').setValue(selections[0].get('jjlxmc'));
			huanzhengViewForm.getForm().findField('select_jjlxdm_huanzheng').setValue(selections[0].get('jjlxdm'));
			huanzhengViewForm.getForm().findField('select_jjlxmcOld_huanzheng').setValue(selections[0].get('ojjlxmc00'));
			huanzhengViewForm.getForm().findField('select_jjlxdmOld_huanzheng').setValue(selections[0].get('ojjlxdm00'));
			if(selections[0].get('jjlxdm')>5000 && selections[0].get('jjlxdm')<8000){
				huanzhengViewForm.getForm().findField('wftzgb_huanzheng').allowBlank=false;
				huanzhengViewForm.getForm().findField('wftzgbdm_huanzheng').allowBlank=false;
				if(selections[0].get('jjlxdm')>6000 && selections[0].get('jjlxdm')<7000){
					huanzhengViewForm.getForm().findField('wftzgb_huanzheng').setValue('港澳台');
					huanzhengViewForm.getForm().findField('wftzgbdm_huanzheng').setValue('344');
				}
			}else{
				huanzhengViewForm.getForm().findField('wftzgb_huanzheng').setValue('');
				huanzhengViewForm.getForm().findField('wftzgbdm_huanzheng').setValue('');
				huanzhengViewForm.getForm().findField('wftzgb_huanzheng').allowBlank=true;
				huanzhengViewForm.getForm().findField('wftzgbdm_huanzheng').allowBlank=true;
			}
		}
	}
});


var window_jjlxQuery_huanzheng = new Ext.Window({
	title : '企业登记注册类型查询',
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
	items : [grid_jjlx_huanzheng]
});

//主管部门
var searchZgmc_huanzheng = function() {
	ds_zgmc_huanzheng.baseParams.conditions = text_search_zgmc_huanzheng.getValue();
	ds_zgmc_huanzheng.baseParams.username='';
	ds_zgmc_huanzheng.baseParams.stateConditions='';
	ds_zgmc_huanzheng.load({params : {start : 0,limit : 20} });
}

var btn_search_zgmc_huanzheng = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchZgmc_huanzheng();
		//btn_search_pzjg.setDisabled(true);
	}
});

var text_search_zgmc_huanzheng = new Ext.form.TextField({
	id : 'textSearchZgmc_huanzheng',
	name : 'textSearchZgmc_huanzheng',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchZgmc_huanzheng();
			}
		},
		'change' : function(field, e) {
			btn_search_zgmc_huanzheng.setDisabled(false);
		}
	}
});

var cm_zgmc_huanzheng = new Ext.grid.ColumnModel([
	{header : '主管部门名称',width : 50,dataIndex : 'jgmc',sortable : true}, 
	{header : '主管部门代码',width : 20,dataIndex : 'jgdm',sortable : true}
]);

var ds_zgmc_huanzheng = new Ext.data.Store({
	url : 'findAllTjgdm.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'jgdm',type : 'string'},
			{name : 'jgmc',type : 'string'}
		])
});

var grid_zgmc_huanzheng = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_zgmc_huanzheng,
	ds : ds_zgmc_huanzheng,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入主管部门名称：',text_search_zgmc_huanzheng,btn_search_zgmc_huanzheng],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_zgmc_huanzheng,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_zgmcQuery_huanzheng.hide();
			var selections=grid.getSelectionModel().getSelections();
			huanzhengViewForm.getForm().findField('select_zgmc_huanzheng').setValue(selections[0].get('zgjgmc'));
			huanzhengViewForm.getForm().findField('select_zgdm_huanzheng').setValue(selections[0].get('jgdm'));
		}
	}
});

var window_zgmcQuery_huanzheng = new Ext.Window({
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
	items : [grid_zgmc_huanzheng]
});

//--------------------机构基本信息-------------------------------------------
var huanzhengViewForm = new Ext.FormPanel({	
	url : 'saveOrgnew.action',
	labelAlign : 'right',
    bodyStyle:'padding:0px',
	labelWidth : 85,
	border : false,
	baseCls : 'x-plain',
	waitMsgTarget: true,
	//autoScroll : true,
	//autoHeight : true,
	layout: 'fit',
	items:[{
            layout:'column',
            border:false,
            autoScroll : true,
            baseCls : 'x-plain',
            bodyStyle:'padding:10px',
            items:[{
                columnWidth:.3,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jglxdm_huanzheng",
						name:"jglxdm",
						fieldLabel:"机构类型",
						//width:135,
						anchor:'97%',
					 	valueField : "jglxdm",
					    displayField : "jglxdm",
					    store : jglxStore_huanzheng,
					    labelSeparator:'',
					    allowBlank : false,
					    haveShow : false,
					    editable : false,
					    onTriggerClick : function() {
					    	window_jglxQuery_huanzheng.show();
					    },listeners : {
							'specialkey' : function(field, e) {
								if (e.getKey() == Ext.EventObject.ENTER) {
									findJglxNameByCode(field);
								}
							},
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
                items: [{ xtype:'textfield',id:"select_jglxmc_huanzheng",name : 'jglx',labelSeparator:'',hideLabel:true,allowBlank : false,readOnly:'true',maxLength : 50,anchor:'100%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{xtype : 'combo',
						fieldLabel : '小微企业',
						id : 'isxw_huanzheng',
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
						editable : false
					}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype : 'combo',
						fieldLabel : '是否公开',
						id : 'gk_huanzheng',
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
						editable : false
					}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '正本数量',name : 'zbsl',labelSeparator:'',allowBlank : false,xtype : 'numberfield',value:1,maxValue : 2000000000,readOnly:true,anchor:'100%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '副本数量',name : 'fbsl',labelSeparator:'',allowBlank : false,xtype : 'numberfield',value:1,maxValue : 2000000000,anchor:'100%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype : 'combo',
						fieldLabel : '是否发卡',
						id : 'fkbz_huanzheng',
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
						mode : 'local',
						selectOnFocus : true,
						allowBlank:false,
						editable : false,
						listeners : {
							'select' : function(val, field) {
								if(val.getValue()=='是'){
									huanzhengViewForm.getForm().findField('fksl').setValue('1');
								}else{
									huanzhengViewForm.getForm().findField('fksl').setValue('0');
								}
							}
						}
					}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '发卡数量',name : 'fksl',labelSeparator:'',allowBlank : false,xtype : 'numberfield',value:0,maxValue : 2000000000,anchor:'100%'}]
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
                	{ xtype:'textfield',fieldLabel : '机构名称',id:'jgmc_huanzheng',name : 'jgmc',labelSeparator:'',allowBlank : false,maxLength : 100,anchor:'99.9%'}]
			},{
                columnWidth:.3,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '法定代表人',name : 'fddbr',labelSeparator:'',allowBlank : false,maxLength : 30,anchor:'97%'}]
			},{
                columnWidth:.15,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{	xtype : 'combo',
						fieldLabel : '证件类型',
						id : 'zjlx_huanzheng',
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
									var flag = isIdCardNo(huanzhengViewForm.getForm().findField('zjhm').getValue());
									if(flag != true){
										huanzhengViewForm.getForm().findField('zjhm').focus();
									}
								}else{
									huanzhengViewForm.getForm().findField('zjhm').focus();
								}
							}
						}
					}]
			},{
                columnWidth:.27,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ 
                	xtype:'textfield',fieldLabel : '证件号码',name : 'zjhm',labelSeparator:'',hideLabel:true,allowBlank : false,confirmTo:'zjlx_huanzheng',vtype:'sfzhao',maxLength : 25,anchor:'99.9%',
                	enableKeyEvents: true,
					listeners : {
						keyup: function(f, e){//计数
				    		huanzhengViewForm.findById('ws_huanzheng').setText("("+f.getValue().length+")");
				    	}
					}
				}]
			},{
				columnWidth : '.03',
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'ws_huanzheng',name:'ws_huanzheng',text:'(0)'}]
			},{
                columnWidth:.2,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{
                	xtype:'textfield',fieldLabel : '移动电话',id : 'mobile_huanzheng',
                	name : 'mobile',labelSeparator:'',vtype:'mobilephone',maxLength:11,
                	minLength:11,anchor:'100%'
                	,enableKeyEvents:true,
            		listeners: {
            			keyup: function(f,e){
            				huanzhengViewForm.findById('mobile_hz').setText("("+f.getValue().length+")");
            			}
            		}
                }]
			},{
				columnWidth : .05,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'mobile_hz',name:'mobile_hz',text:'(0)'}]
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
				    		huanzhengViewForm.findById('fw_huanzheng').setText("("+length+")");
				    	}
			    	}
                }]
			},{
				columnWidth : .05,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'fw_huanzheng',name:'fw_huanzheng',text:'(1000)'}]
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
				    		huanzhengViewForm.findById('jj_huanzheng').setText("("+length+")");
				    	}
			    	}
                }]
			},{
				columnWidth : .05,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'jj_huanzheng',name:'jj_huanzheng',text:'(1000)'}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
		                id:'zcrq_huanzheng',
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
								if(f.getValue()>huanzhengViewForm.getForm().findField('zsbfrq_huanzheng').getValue()){
									huanzhengViewForm.getForm().findField('zsbfrq_huanzheng').setValue('');
								}
								huanzhengViewForm.getForm().findField('zsbfrq_huanzheng').minValue=f.getValue();
							}
						}
				    })]
			},{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '职工人数(人)',name : 'zgrs',labelSeparator:'',allowBlank : false,xtype : 'numberfield',maxValue : 2000000000,anchor:'99.9%'}]
	        },{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
		                id:'zsbfrq_huanzheng',
		                name: 'zsbfrq',
		                format:'Y-m-d',
		                maxValue:myDate,  
		                maxText:'所选日期应在{0}之前',  
		                //minValue:myDate,
		                minText:'所选日期应在{0}之后',
		                //width:150,
		                anchor:'100%',
		                //allowBlank : false,
		                fieldLabel:'证照有效期',
		                renderer:dateFormat,
		                labelSeparator:'',
					    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd'
						//dateRange:{begin:'zsbfrq_huanzheng',end:'zszfrq_huanzheng'},//用于vtype类型dateRange   
                		//vtype:'dateRange'
				        })]
			},{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [new Ext.form.DateField({  
						    id:'zszfrq_huanzheng',
						    name: 'zszfrq',
						    format:'Y-m-d',
						    minValue:'01/01/1949',
						    minText:'所选日期应在{0}之后',
						    anchor:'99.9%',
						    fieldLabel:'至',
						    labelSeparator:'',
						    //labelAlign : 'left',
						    //validator:vailda,//自定义校验
						    renderer:dateFormat,
						    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd',
						    dateRange:{begin:'zsbfrq_huanzheng',end:'zszfrq_huanzheng'},//用于vtype类型dateRange   
                			vtype:'dateRange'
					})]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jjlxdm_huanzheng",
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
					    	window_jjlxQuery_huanzheng.show();
					    },
					    listeners : {
							'specialkey' : function(field, e) {
								if (e.getKey() == Ext.EventObject.ENTER) {
									findMcByDm(field);
								}
							},
							'blur': function(field){
								findMcByDm(field);
							}
						}
				    })]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '经济类型名称',id:"select_jjlxmc_huanzheng",name : 'jjlx',readOnly:true,labelSeparator:'',hideLabel:true,anchor:'99.9%'},
	                	{xtype:'hidden',id:"select_jjlxmcOld_huanzheng",name : 'jjlxOld'},
	                	{xtype:'hidden',id:"select_jjlxdmOld_huanzheng",name : 'jjlxdmOld'}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jjhydm_huanzheng",
						name:"jjhydm",
						fieldLabel:"经济行业",
					 	valueField : "jjhydm",
					    displayField : "jjhydm",
					    //readOnly:'true',
					    maxLength : 50,
					    allowBlank : false,
					    haveShow : false,
					    labelSeparator:'',
					    //width:135,
					    anchor:'97%',
					    editable : false,
					    //emptyText:'请选择经济行业代码！',
					    onTriggerClick : function() {
					    	window_hylxQuery_huanzheng.show();
					    },listeners : {
							'specialkey' : function(field, e) {
								if (e.getKey() == Ext.EventObject.ENTER) {
									findHylxNameByCode(field);
								}
							},
							'blur': function(field){
								findHylxNameByCode(field);
							}
						}
					})]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '经济行业名称',id:"select_jjhymc_huanzheng",name : 'jjhymc',allowBlank : false,readOnly:true,labelSeparator:'',hideLabel:true,anchor:'99.9%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '注册资金(万)',name : 'zczj',labelSeparator:'',allowBlank : false,xtype : 'numberfield',decimalPrecision :6,maxValue : 2000000000,anchor:'97%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [{xtype : 'combo',
					fieldLabel : '货币种类',
					id : 'hbzl_huanzheng',
					displayField : 'categoryName',//显示值的名称
					hiddenName : 'hbzl',//真正提交时此combo的name
					valueField : 'categoryName',//真正提交时此combo的value
					mode : 'remote',
					store : ds_hbzl_select_huanzheng,
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
							huanzhengViewForm.getForm().findField('hbzldm_huanzheng').setValue(record.data.categoryCode);
						}
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
					id : 'wftzgb_huanzheng',
					displayField : 'categoryName',//显示值的名称
					hiddenName : 'wftzgb',//真正提交时此combo的name
					valueField : 'categoryName',//真正提交时此combo的value
					mode : 'remote',
					store : ds_wftzgb_select_huanzheng,
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
							huanzhengViewForm.getForm().findField('wftzgbdm_huanzheng').setValue(record.data.categoryCode);
						},
						'specialkey' : function(field, e) {
							if (e.getKey() == Ext.EventObject.ENTER) {
								findWftzgbDmByMC(field);
							}
						},
						'blur': function(field){
							findWftzgbDmByMC(field);
						}
					}
				}]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '外方国别代码',id : 'wftzgbdm_huanzheng',name : 'wftzgbdm',labelSeparator:'',hideLabel:true,allowBlank : true,anchor:'99.9%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [new Ext.form.TriggerField({
							id:"select_zgdm_huanzheng",
							name:"zgdm",
							fieldLabel:"主管部门",
						 	valueField : "zgdm",
						    displayField : "zgdm",
						    maxLength : 9,
						    minLength : 9,
						    anchor:'97%',
							selectOnFocus : true,
							labelSeparator:'',
						    haveShow : false,
						    editable : false,
						    onTriggerClick : function() {
						    	window_zgmcQuery_huanzheng.show();
						    },listeners : {
								'specialkey' : function(field, e) {
									if (e.getKey() == Ext.EventObject.ENTER) {
										findTjgdmByCode(field);
									}
								},
								'blur': function(field){
									findTjgdmByCode(field);
								}
							}
					    })]
	            },{
	                columnWidth:.75,
	                layout: 'form',
	                border:false,
	                items: [
	                	{xtype:'textfield',fieldLabel : '主管部门名称',name :'zgmc',labelSeparator:'',id:"select_zgmc_huanzheng",hideLabel:true,anchor:'99.9%'}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [new Ext.form.TriggerField({
							id:"select_pzjgdm_huanzheng",
							name:"pzjgdm",
							fieldLabel:"批准机构",
						 	valueField : "pzjgdm",
						    displayField : "pzjgdm",
						    maxLength : 9,
						    minLength : 9,
						    anchor:'97%',
						    labelSeparator:'',
						    haveShow : false,
						    editable : false,
						    allowBlank : false,
						    onTriggerClick : function() {
						    	window_pzjgQuery_huanzheng.show();
						    },listeners : {
								'specialkey' : function(field, e) {
									if (e.getKey() == Ext.EventObject.ENTER) {
										findPzjgNameByCode(field);
									}
								},
								'blur': function(field){
									findPzjgNameByCode(field);
								}
							}
					    })]
	            },{
	                columnWidth:.75,
	                layout: 'form',
	                border:false,
	                items: [{xtype:'textfield',fieldLabel : '批准机构名称',name:'pzjgmc',labelSeparator:'',id:"select_pzjgmc_huanzheng",allowBlank : false,hideLabel:true,anchor:'99.9%'}
	                ]
	            },{
	                columnWidth:.45,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '注册号',name : 'zch',labelSeparator:'',allowBlank : false,maxLength : 50,anchor:'100%',
						enableKeyEvents:true,
			                		listeners: {
			                			keyup: function(f,e){
			                				huanzhengViewForm.findById('zch_hz').setText("("+f.getValue().length+")");
			                			}
			                		}
					}]
	            },{
					columnWidth : .05,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'label',
					items : [{id:'zch_hz',name:'zch_hz',text:'(0)'}]
			    },{
	                columnWidth:.45,
	                layout: 'form',
	                border:false,
	                items: [{ 
	                	xtype:'textfield',fieldLabel : '联系电话',name : 'dhhm',
	                	labelSeparator:'',vtype:'phone',maxLength : 50,anchor:'100%'
	                	,enableKeyEvents:true,
	            		listeners: {
	            			keyup: function(f,e){
	            				huanzhengViewForm.findById('dhhm_hz').setText("("+f.getValue().length+")");
	            			}
	            		}
	                }]
	            },{
					columnWidth : .05,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'label',
					items : [{id:'dhhm_hz',name:'dhhm_hz',text:'(0)'}]
			    },{
	                columnWidth:1,
	                layout: 'form',
	                border:false,
	                items: [
	                	{ xtype:'textfield',fieldLabel : '机构注册地址',name : 'jgdz',labelSeparator:'',allowBlank : false,maxLength : 100,anchor:'99.9%'}
	                ]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [new Ext.form.TriggerField({
							fieldLabel : '行政区划',
							id : 'xzqhCode_huanzheng',
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
						    	window_xzqhQuery_huanzheng.show();
						    },
						    listeners : {
								'specialkey' : function(field, e) {
									if (e.getKey() == Ext.EventObject.ENTER) {
										findXzqhNameByXzqhCode(field,'xzqhName_huanzheng');
									}
								},
								'blur': function(field){
									findXzqhNameByXzqhCode(field,'xzqhName_huanzheng');
								}
							}
					    })
					]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '行政区划代码名称',id:'xzqhName_huanzheng',name : 'xzqhName',labelSeparator:'',allowBlank : false,readOnly:true,hideLabel:true,maxLength : 50,anchor:'99.9%'}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '邮政编码',name : 'yzbm',labelSeparator:'',allowBlank : false,minLength : 6,maxLength : 6,anchor:'100%'}]
	            },{
	                columnWidth:1,
	                layout: 'form',
	                border:false,
	                items: [
	                	{ xtype:'textfield',fieldLabel : '机构实际地址',name : 'jydz',labelSeparator:'',maxLength : 100,anchor:'99.9%'}
	                ]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [new Ext.form.TriggerField({
							fieldLabel : '行政区划',
							id : 'xzqhCode_huanzheng2',
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
						    	window_xzqhQuery_huanzheng2.show();
						    },
						    listeners : {
								'specialkey' : function(field, e) {
									if (e.getKey() == Ext.EventObject.ENTER) {
										findXzqhNameByXzqhCode(field,'xzqhName_huanzheng2');
									}
								},
								'blur': function(field){
									findXzqhNameByXzqhCode(field,'xzqhName_huanzheng2');
								}
							}
					    })
					]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '行政区划代码名称',id:'xzqhName_huanzheng2',name : 'xzqhName2',labelSeparator:'',readOnly:true,hideLabel:true,maxLength : 50,anchor:'99.9%'}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '邮政编码',name : 'jyyb',labelSeparator:'',minLength : 6,maxLength : 6,anchor:'100%'}]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '网址',name : 'weburl',labelSeparator:'',maxLength : 50,anchor:'100%'}]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '电子邮箱',name : 'email',labelSeparator:'',vtype:'email',vtypeText:'不是有效的邮箱地址',maxLength : 40,maxLength : 50,anchor:'100%'}]
	            },{
	                columnWidth:.3,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '经办人',name : 'tbrxm',labelSeparator:'',allowBlank : false,maxLength : 30,anchor:'97%'}]
				},{
	                columnWidth:.15,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{	xtype : 'combo',
							fieldLabel : '证件类型',
							id : 'zjlx2_huanzheng',
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
									var flag = isIdCardNo(huanzhengViewForm.getForm().findField('tbrsfzh').getValue());
									if(flag != true){
										huanzhengViewForm.getForm().findField('tbrsfzh').focus();
									}
								}else{
									huanzhengViewForm.getForm().findField('tbrsfzh').focus();
								}
							}
						}
						}]
				},{
	                columnWidth:.27,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{
	                	xtype:'textfield',fieldLabel : '证件号码',name : 'tbrsfzh',labelSeparator:'',hideLabel:true,confirmTo:'zjlx2_huanzheng',vtype:'sfzhao',allowBlank : false,maxLength : 50,anchor:'95%',
	                	enableKeyEvents: true,
						listeners : {
							keyup: function(f, e){//计数
					    		huanzhengViewForm.findById('ts_huanzheng').setText("("+f.getValue().length+")");
					    	}
						}	
					}]
				},{
					columnWidth : '.03',
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'label',
					items : [{id:'ts_huanzheng',name:'ts_huanzheng',text:'(0)'}]
				},{
	                columnWidth:.2,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{ 
	                	xtype:'textfield',fieldLabel : '经办人电话',name : 'tbrlxfs',
	                	allowBlank : false,labelSeparator:'',vtype:'dhhmphone',
	                	maxLength : 50,anchor:'100%'
	                	,enableKeyEvents:true,
	            		listeners: {
	            			keyup: function(f,e){
	            				huanzhengViewForm.findById('tbrlxfs_hz').setText("("+f.getValue().length+")");
	            			}
	            		}
	                }]
				},{
					columnWidth : .05,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'label',
					items : [{id:'tbrlxfs_hz',name:'tbrlxfs_hz',text:'(0)'}]
			    },{
	                columnWidth:.33,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [new Ext.form.DateField({  
						    id:'bzrq_huanzheng',
						    name: 'bzrq',
						    format:'Y-m-d',
						    maxValue:myDate,  
						    maxText:'所选日期应在{0}之前',  
						    //minValue:'01/01/1949',
						    //minText:'所选日期应在{0}之后',
						    value:myDate,
						    labelSeparator:'',
						    anchor:'100%',
						    fieldLabel:'办证日期',
						    allowBlank : false,
						    renderer:dateFormat,
						    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd|Y-m-n' 
						    })
					]
				},{
	                columnWidth:.34,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [new Ext.form.DateField({  
						    id:'zfrq_huanzheng',
						    name: 'zfrq',
						    format:'Y-m-d',
						    maxValue:newZfrqYes,  
						    maxText:'所选日期应在{0}之前',  
						    minValue:myDate,
						    minText:'所选日期应在{0}之后',
						    anchor:'100%',
						    value:newZfrqYes,
						    fieldLabel:'作废日期',
						    allowBlank : false,
						    labelSeparator:'',
						    renderer:dateFormat,
						    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd|Y-m-n' 
						    })
					]
				},{
	                columnWidth:.33,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [new Ext.form.DateField({  
						    id:'njqx_huanzheng',
						    name: 'njqx',
						    format:'Y-m-d',
						    maxValue:newNjqx,  
						    maxText:'所选日期应在{0}之前',  
						    minValue:'01/01/1949',
						    minText:'所选日期应在{0}之后',
						    anchor:'100%',
						    value:newNjqx,
						    labelSeparator:'',
						    fieldLabel:'年检期限',
						    allowBlank : false,
						    renderer:dateFormat,
						    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd',
						    value:newNjqx
						})
					]
				},{
                	columnWidth:1,
                	layout: 'form',
                	bodyStyle: 'padding:0px',
                	border:false,
                	items: [
                		{xtype:'textfield',fieldLabel : '备注',name : 'memo',labelSeparator:'',maxLength : 250,anchor:'99.9%'},
	                	{xtype:'hidden',fieldLabel : '业务类型',name : 'ywlx',value:'换证'},
						{xtype : 'hidden',	name : 'orgid',value:''},
					    {xtype : 'hidden',	name : 'orderid',id:'orderid'},
					    {xtype : 'hidden',name : 'docid'},
						{xtype : 'hidden',name : 'imageUrl'},
					    {xtype : 'hidden',id:'hbzldm_huanzheng',name : 'hbzldm',value:'156'},
					    {xtype : 'hidden',id:'select_jjhymcOld_huanzheng',name : 'jjhymcOld'},
					    {xtype : 'hidden',id:'select_jjhydmOld_huanzheng',name : 'jjhydmOld'},
					    {xtype : 'hidden',name : 'njrq',value :myDate.format('Y-m-d')}, 
					    {xtype : 'hidden',name : 'bzjgdm',value:currentZzUserBzjgdm},
					    {xtype : 'hidden',name : 'bzrq',value:currentZzUserBzjgdm},
						{xtype : 'hidden',name : 'lastdate',value :myDate.format('Y-m-d')}, 
						{xtype : 'hidden',name : 'lry'},
						{xtype : 'hidden',name : 'xgr',value:currentZzUsername},
						{xtype : 'hidden',name : 'state',value:'12'}]
				}]
		}]
});


var  huanzhengViewForm2= new Ext.Panel({
    title       : '基本信息',
    region      : 'center',
    id          : 'jbInfo24',
    collapsible:false,
    //split       : false,
    //width       : 550,
    //collapsible : true,
    //collapsible : false,
    //bodyBorder: false,
    border : 'layout',
    bodyStyle: 'padding:0px',
    margins: '3 0 0 0',
    cmargins: '5 5 0 0',
	layout: 'fit',
    items : [huanzhengViewForm]
});


var fileFtpForm_huanzheng = new Ext.Panel({
	title:'原文扫描',
	split: true,
	width:620,
	collapsible:true,
	collapsed: false,
    region:'east',
    margins:'3 0 0 5',
    cmargins:'3 0 0 5',
    //activeTab: 0,
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"  width=100%  height=100% align=center hspace=0 vspace=0 id="scanner24625"  name="scanner24625" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>'
    
});


//默认查询 档案
var searchhuanzheng = function() {

	huanzhengViewForm.getForm().reader = Orgnews;
	huanzhengViewForm.getForm().load({
		waitMsg : '正在进行数据查询，请稍等',          //提示信息   
        waitTitle : '提示',                      //标题  
	    url: 'findAllYwqxOrgnew.action', //请求控制器获取数据
	    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
	    params: { conditions:  text_search_huanzheng.getValue(),username:currentZzUsername,ywlxConditions:null,stateConditions:'10,11,12,13,14,15,16',start:1,limit:1},	
	    success:function(form,action) {//获取返回值
			    	if(action.result.data.ywlx=='换证' && (action.result.data.state=='12' || action.result.data.state=='14')){//判断业务是否办理中
			    		/*
			    		if(currentZzUserYwqx=='2'&&currentZzUserBzjgdm!=currentZzUserCenterid&&action.result.data.bzjgdm==currentZzUserCenterid){
			    			alert('本业务属于中心业务，不属于跨区办理范畴');
			    			huanzhengViewForm.getForm().findField('select_jjlxmc_huanzheng').allowBlank=true;
							huanzhengViewForm.getForm().findField('select_jjlxdm_huanzheng').allowBlank=true;
							huanzhengViewForm.getForm().findField('wftzgb_huanzheng').allowBlank=true;
							huanzhengViewForm.getForm().findField('wftzgbdm_huanzheng').allowBlank=true;
							btn_del_huanzheng.setDisabled(true);
							huanzhengViewForm.getForm().reset();
							var tab3452=Ext.getCmp("jbInfo24");
						    tab3452.setTitle("基本信息");
							scanner24625.ImageData="";
			    			return;
			    		}
			    		*/
			    		huanzhengViewForm.getForm().findField('select_jjlxmc_huanzheng').allowBlank=true;
						huanzhengViewForm.getForm().findField('select_jjlxdm_huanzheng').allowBlank=true;
						huanzhengViewForm.getForm().findField('wftzgb_huanzheng').allowBlank=true;
						huanzhengViewForm.getForm().findField('wftzgbdm_huanzheng').allowBlank=true;
									
			    		btn_del_huanzheng.setDisabled(false);
			    		btn_save_huanzheng_menu.setDisabled(false);
			    		var tab3452=Ext.getCmp("jbInfo24");
			    		tab3452.setTitle("基本信息  ("+stateToInfo(huanzhengViewForm.getForm().findField('state').value)+")");
			    		huanzhengViewForm.getForm().findField('lastdate').setValue(myDate.format('Y-m-d'));
						huanzhengViewForm.getForm().findField('xgr').setValue(currentZzUsername);
			    		var resultObject = null;
			            huanzhengViewForm.getForm().findField('bzjgdm').setValue(currentZzUserBzjgdm);
			    		//alert(action.result.data.orgid);
			    		Ext.Ajax.request({
							url : 'orgnewViewImg.action',
							params : {orgid : action.result.data.orgid},
							//waitTitle: '提示',
						    //waitMsg: '数据正在重新加载中，请稍后',
							success : function(result,request) {//获取返回值
								scanner24625.ImageData="";
			   					var resultObject = Ext.util.JSON.decode(result.responseText); 
			   					if(resultObject!=null){
				   					scanner24625.OpenProgress(3);  //设置上传的进度条的总进度数
				   					scanner24625.Progress('原文加载中',1);
									scanner24625.Progress('原文加载中',2);
				   					scanner24625.ImageData=resultObject.imageData;
				   					scanner24625.pageType=resultObject.pageTypeStr;
				   					if(scanner24625.ImageData!=""){
				   						scanner24625.Progress('原文加载完毕',3);
										scanner24625.CloseProgress();
									}else{
										scanner24625.Progress('原文加载失败',3);
						   				scanner24625.CloseProgress();
						   				alert("原文错误，加载失败！");
									}
			   					}
							},
							failure : function() {
								scanner24625.ImageData="";
					   			scanner24625.CloseProgress();
								alert("图像加载错误，或者无原文");
							}
						});	
			
				}else{
					btn_del_huanzheng.setDisabled(true);
					Ext.Msg.show({
						title : '提示',
						msg : '机构正在进行“'+action.result.data.ywlx+'”业务办理中!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.INFO,
						fn : function() {huanzhengViewForm.getForm().reset();scanner24625.ImageData="";}
					});
	        	}
		},
		failure : function() {//正式库检索
				huanzhengViewForm.getForm().reader = Orgnews;
				huanzhengViewForm.getForm().load({
					waitMsg : '正在进行数据查询，请稍等',          //提示信息   
			        waitTitle : '提示',                      //标题  
				    url: 'findAllTjgdmByJgdm.action', //请求控制器获取数据
				    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
				    params: { jgdm:  text_search_huanzheng.getValue(),userBzjgdm:null},	
				    success:function(form,action) {//获取返回值
				    		if(currentZzUsername!='admin' && sysBzjgLimitMode=='1' && action.result.data.bzjgdm!=currentZzUserBzjgdm && currentZzUserYwqx!='2' && currentZzUserBzjgdm!=currentZzUserCenterid){
				    				Ext.Msg.show({
										title : '提示',
										msg : '【'+action.result.data.jgmc+'】，<br><br>办证机构代码为“'+action.result.data.bzjgdm+'”,不属于本办证机构办理！',
										buttons : Ext.Msg.OK,
										fn:  function() {
											btn_del_huanzheng.setDisabled(true);
											huanzhengViewForm.getForm().reset();
											scanner24625.ImageData="";
											var tab3452555=Ext.getCmp("jbInfo24");
							    			tab3452555.setTitle("基本信息");
										},
										icon : Ext.Msg.ERROR
									});
				    		}else{
						    	if(action.result.data.state=='100' || action.result.data.state==''){//判断此机构状态是否正常
						    		huanzhengViewForm.getForm().findField('select_jjlxmc_huanzheng').allowBlank=true;
									huanzhengViewForm.getForm().findField('select_jjlxdm_huanzheng').allowBlank=true;
									huanzhengViewForm.getForm().findField('wftzgb_huanzheng').allowBlank=true;
									huanzhengViewForm.getForm().findField('wftzgbdm_huanzheng').allowBlank=true;
		
						    		btn_del_huanzheng.setDisabled(true);
						    		var tab3452=Ext.getCmp("jbInfo24");
						    		tab3452.setTitle("基本信息  (新录入)");
						    		huanzhengViewForm.getForm().findField('ywlx').setValue('换证');
						    		huanzhengViewForm.getForm().findField('state').setValue('12');
						    		huanzhengViewForm.getForm().findField('orgid').setValue('');
						    		huanzhengViewForm.getForm().findField('lastdate').setValue(myDate.format('Y-m-d'));
			    					huanzhengViewForm.getForm().findField('bzrq').setValue(myDate);
						    		huanzhengViewForm.getForm().findField('zfrq').setValue(newZfrqYes);
						    		huanzhengViewForm.getForm().findField('bzjgdm').setValue(currentZzUserBzjgdm);
						    		huanzhengViewForm.getForm().findField('njrq').setValue(myDate.format('Y-m-d'));
						    		huanzhengViewForm.getForm().findField('njqx').setValue(newNjqx);
									if(action.result.data.zbsl == null || action.result.data.zbsl == ''){
							    		huanzhengViewForm.getForm().findField('zbsl').setValue(1);
						    		}
									if(action.result.data.zjlx=='军人证' || action.result.data.zjlx=='通行证' || action.result.data.zjlx=='澳门证' || action.result.data.zjlx=='香港证' || action.result.data.zjlx=='台湾证' || action.result.data.zjlx=='回乡证'){
		    							huanzhengViewForm.getForm().findField('zjlx').setValue('');
		    						}
								}else{
									Ext.Msg.show({
										title : '提示',
										msg : '机构“'+action.result.data.jgmc+'”状态为“'+tjgdmStateToInfo(action.result.data.state)+'”,<br><br>不能再次办理业务！',
										buttons : Ext.Msg.OK,
										fn:  function() {
											btn_del_huanzheng.setDisabled(true);
											huanzhengViewForm.getForm().reset();
											scanner24625.ImageData="";
											var tab3452555=Ext.getCmp("jbInfo24");
							    			tab3452555.setTitle("基本信息");
										},
										icon : Ext.Msg.ERROR
									});
					            }
				    		}
						},
						failure : function() {
							Ext.Msg.show({
								title : '提示',
								msg : '机构信息未查到！',
								width:250,
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR,
								fn:  function() {
									btn_del_huanzheng.setDisabled(true);
									huanzhengViewForm.getForm().reset();
									var tab3452=Ext.getCmp("jbInfo24");
					    			tab3452.setTitle("基本信息");
								}
							});
						}	
				});
		}
	});
}

var btn_search_huanzheng = new Ext.Button({
	text : '代码查询',
	iconCls : 'icon-search',
	handler : function() {
		searchhuanzheng();
	}
});

var text_search_huanzheng = new Ext.form.TextField({
	id : 'textSearchhuanzheng',
	name : 'textSearchhuanzheng',
	width : 200,
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchhuanzheng();
			}
		}
	}
});



var btn_print_huanzheng = new Ext.Button({
	text : '打印申请表',
	iconCls : 'icon-print',
	handler : function(field){			
		var orgid = huanzhengViewForm.getForm().findField('orgid').value;
		if(orgid!=null && orgid!=""){
			ajaxLoadMask.show();
			Ext.Ajax.request({
				url: 'findOrgnewByOrgid.action',
   				params: {orgid: orgid},
   				success: function(result,request){//获取返回值
   					ajaxLoadMask.hide();
   					var resultObject = Ext.util.JSON.decode(result.responseText);
   					if(resultObject.root.length!=0){
						var titleHTML = printSqdStr(resultObject.root[0],1);   
						var newwin = window.open('printer.jsp', 'printWindow', 'menubar=yes,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no,titlebar=yes,z-look=yes,menubar=yes');     
						newwin.document.write(titleHTML); 
   					}
   				},
   				failure: function(){
   					ajaxLoadMask.hide();
   					Ext.Msg.show({
						title : '提示',
						msg : '打印失败！',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
   				}
			});
		}else{
			Ext.Msg.show({
				title : '提示',
				msg : '请保存信息后，再进行打印！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR
			});
		}
	}
});


var btn_refresh_huanzheng = new Ext.Button({
	text : '重置',
	iconCls : 'icon-refresh',
	handler : function() {
		huanzhengViewForm.getForm().findField('select_jjlxmc_huanzheng').allowBlank=true;
		huanzhengViewForm.getForm().findField('select_jjlxdm_huanzheng').allowBlank=true;
		huanzhengViewForm.getForm().findField('wftzgb_huanzheng').allowBlank=true;
		huanzhengViewForm.getForm().findField('wftzgbdm_huanzheng').allowBlank=true;
									
		
		btn_del_huanzheng.setDisabled(true);
		huanzhengViewForm.getForm().reset();
		var tab3452=Ext.getCmp("jbInfo24");
	    tab3452.setTitle("基本信息");
		scanner24625.ImageData="";
	}
});


var btn_del_huanzheng = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	disabled:true,
	handler : function() {
		var orgid = huanzhengViewForm.getForm().findField('orgid').value;
		if(orgid!=null && orgid!=""){
			Ext.Msg.confirm('确认删除', '你确定删除吗?', function(btn) {
				if (btn == 'yes') {
					ajaxLoadMask.show();
					Ext.Ajax.request({
						url : 'deleteOrgnew.action',
						params : {orgid : orgid},
						success : function() {
							ajaxLoadMask.hide();
							btn_del_huanzheng.setDisabled(true);
					    	//btn_shibie_huanzheng.setDisabled(false);
							huanzhengViewForm.getForm().reset();
							var tab3452=Ext.getCmp("jbInfo24");
	    					tab3452.setTitle("基本信息");
							scanner24625.ImageData="";
						},
						failure : function() {
							ajaxLoadMask.hide();
							Ext.Msg.show({
								title : '提示',
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

var btn_duru_huanzheng = new Ext.Button({
	text : '测试键入',
	iconCls : 'icon-add',
	//disabled:true,调用参数
	//scanner.GetOCRValue 返回 识别结果
	handler : function(){
		//var ocrStr=scanner24625.GetOCRValue;
		//,{id:'jyfw',value:'许可经营项目'},{id:'zcrq',value:'2011-07-27'},{id:'zczj',value:'10'},{id:'zch',value:'110106014104570'},{id:'jgdz',value:'北京市丰台区永外海户屯166号院5号楼101室'},{id:'jglx',value:'有限责任公司'},{id:'tbrxm',value:'高跃辉'},{id:'tbrsfzh',value:'410325198204126593'},{id:'tbrzjlx',value:'居民身份证'}
		//  var ocrStr="[{id:'jgmc',value:'11'},{id:'fddbr',value:'11'}]";
		//var ocrStr="[{id:'jgmc',value:'zhangsan'},{id:'fddbr',value:'15'}]";
		//var ocrStr="[{id:'jgmc',value:'北京顺光庆华商贸有限公司'},{id:'fddbr',value:'杨志英'},{id:'jyfw',value:'许可经营项目'},{id:'zcrq',value:'2011年07月27日'},{id:'zczj',value:'10'},{id:'zch',value:'110106014104570'},{id:'jgdz',value:'北京市丰台区永外海户屯166号院5号楼101室'},{id:'jglx',value:'有限责任公司'},{id:'tbrxm',value:'高跃辉'},{id:'tbrsfzh',value:'410325198204126593'},{id:'tbrzjlx',value:'居民身份证'}]";
 		var ocrStr="[{id:'orgid',value:''},{id:'jgmc',value:'北京东方世纪科技有限公司'},{id:'jgdm',value:'109101235'},	{id:'fddbr',value:'张治中'},	{id:'zjlx',value:'居民身份证'},{id:'zjhm',value:'107101192312015714'},{id:'jyfw',value:'在法律范围内，许可经营项目'},{id:'zcrq',value:'19711209'},{id:'zczj',value:'10000'},	{id:'zch',value:'110101218105012'},{id:'jglx',value:'有限责任公司'},{id:'jgdz',value:'北京市海淀区中航工业大厦1805室'},{id:'pzjgmc',value:'北京市工商局'},{id:'pzjgdm',value:'110000021'},{id:'jjlx',value:'有限责任公司'},{id:'zsbfrq',value:'1972-01-01'},{id:'zszfrq',value:'1992-01-01'},{id:'wftzgb',value:'中国'},{id:'hbzl',value:'人民币'},{id:'jydz',value:'北京市海淀区中关村科技广场鼎好大厦12楼'},{id:'zgmc',value:'海淀国资委'},{id:'zgdm',value:'100001231'},{id:'dhhm',value:'010-62528899'},{id:'mobile',value:'13810101225'},{id:'jjhymc',value:'计算机软件'},{id:'jjhydm',value:'0709'},{id:'zgrs',value:'500'},{id:'xzqhCode',value:'100000220'},{id:'xzqhName',value:'北京市海淀区'},{id:'yzbm',value:'100098'},{id:'weburl',value:'www.163.com'},{id:'email',value:'hr@163.com'},{id:'tbrxm',value:'申通'},{id:'tbrsfzh',value:'110109198509014216'},{id:'tbrzjlx',value:'居民身份证'},{id:'tbrlxfs',value:'13366114568'},{id:'gk',value:'是'}]";
		if(ocrStr!="" && ocrStr!=null){
			var respText = Ext.util.JSON.decode(ocrStr); 
			huanzhengViewForm.getForm().setValues(respText); 
			//btn_del_huanzheng.setDisabled(true);
			//btn_save_huanzheng_menu.setDisabled(false);
			//var respText = Ext.util.JSON.decode(ocrStr); 
			//huanzhengViewForm.getForm().setValues(respText); 
			//alert(respText.jgmc);
			
			//huanzhengViewForm.getForm().reader = Orgnews;
			//huanzhengViewForm.getForm().load({waitMsg:'正在加载数据请稍后',url:'ocr.json'});
		}else{
			alert("请扫描或导入需识别的图片！");
		}
	}
});


var btn_save_huanzheng_menu = new Ext.Toolbar.MenuButton({
    text: '保存',
    handler: btn_huanzheng_saveAll,
    tooltip: {title:'保存数据和原文',text:'保存'},
    iconCls: 'blist',
    //disabled:true,
    menu : {items: [
                {text: '全部保存', handler: btn_huanzheng_saveAll}, '-',
                {text: '仅保存数据', handler: btn_huanzheng_saveInfo},
                {text: '仅上传原文', handler: btn_huanzheng_ftpFile}
        ]}
});

var upFuncHZ = function(docid,orgid,strJgdm,strState,strYwlx,jgmc){
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
				
				
				strOrgid = orgid;  //参数orgid
				strDocid = docid;
				strBzjgdm=huanzhengViewForm.getForm().findField('bzjgdm').value; 
				packLength = 40960;	//定义每个包的大小40960
				//scanner24625.ImageData=document.getElementById("ImageData").value;
				base64file = scanner24625.ImageData;  //获取控件扫描的图片数据
				var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
				imageCount = scanner24625.ImageCount;	//获取扫描图片的页数
				pageTypeStr = scanner24625.PageType;    //获取标识字符串,需要写数据库
				if(pageTypeStr!=""){
					pageTypeStr=pageTypeStr.replace(/\%/g, "|"); 
       			}
				packCount = Math.ceil(baseSize / packLength);	//判断需要发送数据包的个数
				if(imageCount==0 || base64file=="")   //判断如果没有扫描数据，结束处理
				{
					alert("请扫描或导入图片后，再上传！");
					
					return false;
				}
				if (pageTypeStr.indexOf('未标识')!=-1){ //判断如果没有标识，则不允许上传
					alert("请进行电子原文标识后，再保存！");
					
					return false;
				}
				scanner24625.OpenProgress(packCount);  //设置上传的进度条的总进度数
				xmlhttp = GetXmlHttp(); //通过AJAX格式上传
				for(var i=0; i < packCount; i++)  //分包上传
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
						//xmlhttp.open("post", "saveImageOrgnew.action?orgid="+strOrgid, false);
						xmlhttp.open("post", "saveImageOrgnew.action?orgid="+strOrgid+"&docid="+strDocid+"&packindex="+i+"&pageTypeStr="+pageTypeStr+"&bzjgdm="+strBzjgdm+"&lastpack="+lastpack, false);
						xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   //这句必须要，而且一定要放在send以前
						xmlhttp.send("imageData=" + encodeURIComponent(pack)); 
						//xmlhttp.send("imgPackData=" + pack); 
						//alert("上传返回的值"+xmlhttp.responseText);
		             
						var objs = eval("["+xmlhttp.responseText+"]");
						//alert(objs.length); // 2
		                //alert(objs[0].success);  // 1
		                //alert(objs[0].success);
		                //if(i==2) break;
						if(objs[0].success)
						{
							scanner24625.Progress('上传中',i+1);
						}
						else
						{
							alert("上传失败，请重试0001。");
							//scanner24625.ShowSendMsg(false);
							
							return false;
						}
					}
					catch(e)
					{
						//alert(e.description+'|'+e.name+'|'+e.number);
						alert("上传失败，请重试0002。");
						
						return false;
					}
				}
				
				Ext.Msg.show({
					title : '提示',
					msg : '['+huanzhengViewForm.getForm().findField('jgmc_huanzheng').getValue()+']，<br><br>申办信息保存成功！',
					buttons : Ext.Msg.OK,
					fn : function() {
						
						scanner24625.CloseProgress();
						subHZAction(orgid,strJgdm,strState,strYwlx,jgmc);
					},
					icon : Ext.Msg.INFO
				});

				
}

function btn_huanzheng_saveAll(btn){
	if (huanzhengViewForm.getForm().isValid()) {
		huanzhengViewForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在保存数据,请稍候...',
			success : function(form,action) {
				huanzhengViewForm.getForm().findField('orgid').setValue(action.result.orgid);
				huanzhengViewForm.getForm().findField('docid').setValue(action.result.docid);
				var orgid = huanzhengViewForm.getForm().findField('orgid').getValue();
				var docid = action.result.docid;
				var strJgdm = huanzhengViewForm.getForm().findField('jgdm').getValue();
				var strState = huanzhengViewForm.getForm().findField('state').getValue();
				var jgmc = huanzhengViewForm.getForm().findField('jgmc_huanzheng').getValue();
				var strYwlx = huanzhengViewForm.getForm().findField('ywlx').getValue();
				if(scanner24625.ImageCount>0){
					if(orgid!=null && orgid!=""){
			Ext.Ajax.request({
				url: 'checkArchive.action',
				params: {orgid: orgid,jgdm:strJgdm},
				success: function(result,request){//result,request
					var data = Ext.util.JSON.decode(result.responseText);
					var str = scanner24625.CheckArchives("换证",data.jglxdmOld,data.zchInfo,data.frInfo);
					if(str==''){
						//alert("更新imageFlag为1（表示档案完整）");
						refreshImageFlag(orgid,'1');
						upFuncHZ(docid,orgid,strJgdm,strState,strYwlx,jgmc);
					}else{
						//alert(str+"::更新imageFlag为0（表示档案不完整）");
						Ext.Msg.show({
							title : '提示',
							msg : str + '继续提交则选是,取消提交则选否！',
							buttons : Ext.Msg.OKCANCEL,
							fn : function(btn){
								if(btn == 'ok'){
									refreshImageFlag(orgid,'0');
									upFuncHZ(docid,orgid,strJgdm,strState,strYwlx,jgmc);
								}else{
									refreshImageFlag(orgid,'0');
								}
							},
							icon : Ext.Msg.INFO
						});
					}
				}
			});
		}else{
			alert("请保存信息后，再进行“换证通过”处理");
		}
				}else{
					Ext.Msg.show({
							title : '提示',
							msg : '档案尚未扫描请确认是否继续提交！',
							buttons : Ext.Msg.OKCANCEL,
							fn : function(btn){
								if(btn == 'ok'){
									refreshImageFlag(orgid,'0');
									subHZAction(orgid,strJgdm,strState,strYwlx,jgmc);
								}else{
									refreshImageFlag(orgid,'0');
								}
							},
							icon : Ext.Msg.INFO
						});
				}
			},
			failure : function(form) {
				Ext.Msg.show({
					title : '提示',
					msg : '著录信息保存失败',
					buttons : Ext.Msg.OK,
					fn : function() {btn.enable();},
					icon :Ext.Msg.ERROR
				});
			}
		});
	}else{
		Ext.Msg.show({
			title : '提示',
			msg : '申请表信息，填写不完整！<br><br>显示为红色的输入框为错误输入项',
			buttons : Ext.Msg.OK,
			fn : function() {btn.enable();},
			icon : Ext.Msg.ERROR
		});
	}
}

function btn_huanzheng_saveInfo(btn){
	if (huanzhengViewForm.getForm().isValid()) {
		huanzhengViewForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在保存数据,请稍候...',
			success : function(form,action) {
				//alert(action.result.orgid);
				huanzhengViewForm.getForm().findField('orgid').setValue(action.result.orgid);
				huanzhengViewForm.getForm().findField('docid').setValue(action.result.docid);
				Ext.Msg.show({
					title : '提示',
					msg : '['+huanzhengViewForm.getForm().findField('jgmc_huanzheng').getValue()+']，<br><br>申办信息保存成功',
					buttons : Ext.Msg.OK,
					fn : function() {btn.enable();},
					icon : Ext.Msg.INFO
				});
			},
			failure : function(form) {
				Ext.Msg.show({
					title : '提示',
					msg : '信息保存失败',
					buttons : Ext.Msg.OK,
					fn : function() {btn.enable();},
					icon :Ext.Msg.ERROR
				});
			}
		});
	}else{
		Ext.Msg.show({
			title : '提示',
			msg : '申请表信息，填写不完整！<br><br>显示为红色的输入框为错误输入项',
			buttons : Ext.Msg.OK,
			fn : function() {btn.enable();},
			icon : Ext.Msg.ERROR
		});
	}
}

function btn_huanzheng_ftpFile(btn){
	
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
	strOrgid =huanzhengViewForm.getForm().findField('orgid').value;  //参数orgid
	strDocid =huanzhengViewForm.getForm().findField('docid').value;  //参数docid
	strBzjgdm=huanzhengViewForm.getForm().findField('bzjgdm').value;  //办证机构代码
	//alert("strOrgid="+strOrgid);
	
	if(strOrgid!=""){
			packLength = 40960;	//定义每个包的大小40960
			//scanner24625.ImageData=document.getElementById("ImageData").value;
			base64file = scanner24625.ImageData;  //获取控件扫描的图片数据
			var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
			imageCount = scanner24625.GetPageCount;	//获取扫描图片的页数
			pageTypeStr = scanner24625.PageType;    //获取标识字符串,需要写数据库
			if(pageTypeStr!=""){
				pageTypeStr=pageTypeStr.replace(/\%/g, "|"); 
			}
			
			//alert(baseSize);
			packCount = Math.ceil(baseSize / packLength);	//判断需要发送数据包的个数
			//alert("packCount="+packCount);
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
			scanner24625.OpenProgress(packCount);  //设置上传的进度条的总进度数
			xmlhttp = GetXmlHttp(); //通过AJAX格式上传
			for(var i=0; i < packCount; i++)  //分包上传
			{
				if(i==packCount-1){
					lastpack="true";
				}else{
					lastpack="false";
				}
							
				pack = base64file.substring(i * packLength, (i + 1) * packLength);  //每个数据包的文件大小
				try{
					xmlhttp.open("post", "saveImageOrgnew.action?orgid="+strOrgid+"&docid="+strDocid+"&packindex="+i+"&pageTypeStr="+pageTypeStr+"&bzjgdm="+strBzjgdm+"&lastpack="+lastpack, false);
					xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   //这句必须要，而且一定要放在send以前
					xmlhttp.send("imageData=" + encodeURIComponent(pack)); 
					//alert("上传返回的值"+xmlhttp.responseText);
		         
					var objs = eval("["+xmlhttp.responseText+"]");
					if(objs[0].success){
						scanner24625.Progress('上传中',i+1);
					}else{
						alert("上传失败，请重试0001。");
						btn.enable();
						return false;
					}
				}catch(e){   
					//alert(e.description+'|'+e.name+'|'+e.number);
					alert("上传失败，请重试0002。");
					btn.enable();
					return false;
				}
			}
			scanner24625.CloseProgress();
			
			Ext.Msg.show({
				title : '提示',
				msg : '['+huanzhengViewForm.getForm().findField('jgmc_huanzheng').getValue()+']，<br><br>原文上传成功！',
				buttons : Ext.Msg.OK,
				fn : function() {btn.enable();},
				icon : Ext.Msg.INFO
			});
			
			scanner24625.CloseProgress();
			return true;
	}else{
		alert("请录入数据后，再上传原文！");
	}
}

//提交确认方法
var subHZAction =function (orgid,strJgdm,strState,strYwlx,jgmc){
	ajaxLoadMask.show();
	Ext.Ajax.request({
		url: 'returnOrgnewDo.action',
		params: {orgid: orgid,jgdm:strJgdm,state:strState,ywlx:strYwlx},
		success: function(){
			ajaxLoadMask.hide();
			Ext.Msg.show({
				title : '提示',
				msg : '[' + jgmc + ']申请单办理完毕！',
				buttons : Ext.Msg.OK,
				fn:  function() {
					huanzhengViewForm.getForm().findField('orgid').setValue('');
   					var tab345=Ext.getCmp("jbInfo24");
		    		tab345.setTitle("基本信息");	
					huanzhengViewForm.getForm().reset();
					scanner24625.PageType="";
					scanner24625.ImageData="";
					text_search_huanzheng.setValue("");
				},
				icon : Ext.Msg.INFO
			});
		},
		failure: function(){
			ajaxLoadMask.hide();
			Ext.Msg.show({
				title : '提示',
				msg : '[' + jgmc + ']申请单办理失败！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR
			});
		}
	});
}

var btn_saveInfo_huanzheng = new Ext.Button({
	text : '保存数据',
	iconCls : 'icon-store',
	handler : btn_huanzheng_saveInfo
});

var btn_ok_huanzheng = new Ext.Button({
	text : '确认提交',
	iconCls : 'icon-store',
	handler : btn_huanzheng_saveAll
});


var p_zzHuanzheng = {
	id : 'zzHuanzheng-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:0px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    bodyBorder: false,
	    title: '换证',
	    iconCls : 'icon-plugin',
 		plain: true,
		region: 'center',
//		defaults: {
//			collapsible: true,
//	        split: true,
//			animFloat: false,
//			autoHide: false,
//			useSplitTips: true,
//			bodyStyle: 'padding:0px'
//		},
		tbar : [btn_refresh_huanzheng,btn_del_huanzheng,/*btn_save_huanzheng_menu*/btn_saveInfo_huanzheng,btn_print_huanzheng,btn_ok_huanzheng,'->',text_search_huanzheng,btn_search_huanzheng],
		items: [huanzhengViewForm2,fileFtpForm_huanzheng]
	}]
}