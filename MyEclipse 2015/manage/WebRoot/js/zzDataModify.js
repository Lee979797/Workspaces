
var searchXzqh_dataModify2 = function() {
	ds_xzqh_dataModify2.baseParams.conditions = text_search_xzqh_dataModify2.getValue();
	ds_xzqh_dataModify2.baseParams.username='';
	ds_xzqh_dataModify2.baseParams.stateConditions='';
	ds_xzqh_dataModify2.load({params : {start : 0,limit : 20} });
}

var btn_search_xzqh_dataModify2 = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchXzqh_dataModify2();
	}
});

var text_search_xzqh_dataModify2 = new Ext.form.TextField({
	id : 'textSearchXzqh_dataModify2',
	name : 'textSearchXzqh_dataModify2',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchXzqh_dataModify2();
			}
		},
		'change' : function(field, e) {
			searchXzqh_dataModify2();
			//btn_search_xzqh_dataModify.setDisabled(false);
		}
	}
});

var cm_xzqh_dataModify2 = new Ext.grid.ColumnModel([
	{header : '行政区划名称',width : 50,dataIndex : 'xzqhName',sortable : true},
	{header : '行政区划代码',width : 20,dataIndex : 'xzqhCode',sortable : true}
]);

var ds_xzqh_dataModify2 = new Ext.data.Store({
	url : 'findAllByConditionXzqh.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'xzqhCode',type : 'string'},
			{name : 'xzqhName',type : 'string'},
			{name : 'xzqhNote',type : 'string'}
		])
});
var grid_xzqh_dataModify2 = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_xzqh_dataModify2,
	ds : ds_xzqh_dataModify2,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入行政区划名称：',text_search_xzqh_dataModify2,btn_search_xzqh_dataModify2],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_xzqh_dataModify2,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_xzqhQuery_dataModify2.hide();
			var selections=grid.getSelectionModel().getSelections();
			dataModifyViewForm.getForm().findField('xzqhName_dataModify2').setValue(selections[0].get('xzqhName'));
			dataModifyViewForm.getForm().findField('xzqhCode_dataModify2').setValue(selections[0].get('xzqhCode'));
		}
	}
});

var window_xzqhQuery_dataModify2 = new Ext.Window({
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
	items : [grid_xzqh_dataModify2]
});
//行政区划的到此结束

var searchXzqh_dataModify = function() {
	ds_xzqh_dataModify.baseParams.conditions = text_search_xzqh_dataModify.getValue();
	ds_xzqh_dataModify.baseParams.username='';
	ds_xzqh_dataModify.baseParams.stateConditions='';
	ds_xzqh_dataModify.load({params : {start : 0,limit : 20} });
}

var btn_search_xzqh_dataModify = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchXzqh_dataModify();
	}
});

var text_search_xzqh_dataModify = new Ext.form.TextField({
	id : 'textSearchXzqh_dataModify',
	name : 'textSearchXzqh_dataModify',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchXzqh_dataModify();
			}
		},
		'change' : function(field, e) {
			searchXzqh_dataModify();
			//btn_search_xzqh_dataModify.setDisabled(false);
		}
	}
});

var cm_xzqh_dataModify = new Ext.grid.ColumnModel([
	{header : '行政区划名称',width : 50,dataIndex : 'xzqhName',sortable : true},
	{header : '行政区划代码',width : 20,dataIndex : 'xzqhCode',sortable : true}
]);

var ds_xzqh_dataModify = new Ext.data.Store({
	url : 'findAllByConditionXzqh.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'xzqhCode',type : 'string'},
			{name : 'xzqhName',type : 'string'},
			{name : 'xzqhNote',type : 'string'}
		])
});
var grid_xzqh_dataModify = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_xzqh_dataModify,
	ds : ds_xzqh_dataModify,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入行政区划名称：',text_search_xzqh_dataModify,btn_search_xzqh_dataModify],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_xzqh_dataModify,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_xzqhQuery_dataModify.hide();
			var selections=grid.getSelectionModel().getSelections();
			dataModifyViewForm.getForm().findField('xzqhName_dataModify').setValue(selections[0].get('xzqhName'));
			dataModifyViewForm.getForm().findField('xzqhCode_dataModify').setValue(selections[0].get('xzqhCode'));
		}
	}
});

var window_xzqhQuery_dataModify = new Ext.Window({
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
	items : [grid_xzqh_dataModify]
});
//行政区划的到此结束

var btn_search_pzjg_dm = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchPzjg_dm();
		//btn_search_pzjg_dm.setDisabled(true);
	}
});


var text_search_pzjg_dm = new Ext.form.TextField({
	id : 'textSearchPzjg_dm',
	name : 'textSearchPzjg_dm',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchPzjg_dm();
			}
		},
		'change' : function(field, e) {
			btn_search_pzjg_dm.setDisabled(false);
		}
	}
});


var cm_pzjg_dm = new Ext.grid.ColumnModel([
	{header : '批准机构名称',width : 50,dataIndex : 'pzjgmc',sortable : true}, 
	{header : '批准机构代码',width : 20,dataIndex : 'pzjgdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_pzjg_dm = new Ext.data.Store({
	url : 'findAllByConditionPzjg.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'pzjgid',type : 'int'}, 
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchPzjg_dm = function() {
	ds_pzjg_dm.baseParams.conditions = text_search_pzjg_dm.getValue();
	ds_pzjg_dm.baseParams.username='';
	ds_pzjg_dm.baseParams.stateConditions='';
	ds_pzjg_dm.load({params : {start : 0,limit : 20} });
}

var grid_pzjg_dm = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_pzjg_dm,
	ds : ds_pzjg_dm,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入登记批准机构名称：',text_search_pzjg_dm,btn_search_pzjg_dm],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_pzjg_dm,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_pzjgQuery_dm.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			dataModifyViewForm.getForm().findField('select_pzjgmc_dataModify').setValue(selections[0].get('pzjgmc'));
			dataModifyViewForm.getForm().findField('select_pzjgdm_dataModify').setValue(selections[0].get('pzjgdm'));
		}
	}
});


var window_pzjgQuery_dm = new Ext.Window({
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
	items : [grid_pzjg_dm]
});


var btn_search_jglxSelcet_dm = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJglxSelcet_dm();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_jglxSelcet_dm = new Ext.form.TextField({
	id : 'textsearchJglxSelcet_dm',
	name : 'textsearchJglxSelcet_dm',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJglxSelcet_dm();
			}
		},
		'change' : function(field, e) {
			btn_search_jglxSelcet_dm.setDisabled(false);
		}
	}
});


var cm_jglxSelcet2 = new Ext.grid.ColumnModel([
    {header : '一级类型',width : 60,dataIndex : 'pjglxmc',sortable : true}, 
	{header : '二级类型',width : 100,dataIndex : 'jglxmc',sortable : true}, 
	{header : '代码',width : 30,dataIndex : 'jglxdm',sortable : true},
	{header : '备注',width : 50,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_jglxSelcet_dm = new Ext.data.Store({
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

var ds_hbzl_select_dm = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=1',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});

var searchJglxSelcet_dm = function() {
	ds_jglxSelcet_dm.baseParams.conditions = text_search_jglxSelcet_dm.getValue();
	ds_jglxSelcet_dm.baseParams.username="";
	ds_jglxSelcet_dm.baseParams.stateConditions='';
	ds_jglxSelcet_dm.load({params : {start : 0,limit : 20} });
}

var searchJglxSelcet2_dm = function() {
	ds_jglxSelcet_dm.baseParams.conditions = dataModifyViewForm.getForm().findField('select_jglxdm_dataModify').getValue();
	ds_jglxSelcet_dm.baseParams.username="";
	ds_jglxSelcet_dm.baseParams.stateConditions='';
	ds_jglxSelcet_dm.load({params : {start : 0,limit : 20} });
}

var grid_jglx_dataModify = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jglxSelcet2,
	ds : ds_jglxSelcet_dm,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入机构类型名称：',text_search_jglxSelcet_dm,btn_search_jglxSelcet_dm],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jglxSelcet_dm,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jglxQuery_dataModify.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			dataModifyViewForm.getForm().findField('select_jglxmc_dataModify').setValue(selections[0].get('jglxmc'));
			dataModifyViewForm.getForm().findField('select_jglxdm_dataModify').setValue(selections[0].get('jglxdm'));
			
			//alert(selections[0].get('pjglxdm'));
			if(selections[0].get('pjglxdm')==1){
				dataModifyViewForm.getForm().findField('select_jjlxmc_dataModify').allowBlank=false;
				dataModifyViewForm.getForm().findField('select_jjlxdm_dataModify').allowBlank=false;
			}else{
				dataModifyViewForm.getForm().findField('select_jjlxmc_dataModify').allowBlank=true;
				dataModifyViewForm.getForm().findField('select_jjlxdm_dataModify').allowBlank=true;
			}
		}
	}
});


var window_jglxQuery_dataModify = new Ext.Window({
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
	items : [grid_jglx_dataModify]
});

var btn_search_hylxSelcet_dm = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchHylxSelcet_dm();
		//btn_search_jjlx.setDisabled(true);
	}
});

var text_search_hylxSelcet_dm = new Ext.form.TextField({
	id : 'textSearchHylxSelcet_dm',
	name : 'textSearchHylxSelcet_dm',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchHylxSelcet_dm();
			}
		},
		'change' : function(field, e) {
			btn_search_hylxSelcet_dm.setDisabled(false);
		}
	}
});

var ds_wftzgb_select_dm = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=3',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});

var cm_hylxSelcet_dm = new Ext.grid.ColumnModel([
	{header : '大类',width : 100,dataIndex : 'hylxmc1',sortable : true}, 
	{header : '中类',width : 100,dataIndex : 'hylxmc2',sortable : true}, 
	{header : '小类',width : 100,dataIndex : 'hylxmc3',sortable : true}, 
   {header : '经济行业名称',width : 100,dataIndex : 'hylxmc',sortable : true},
	{header : '经济行业代码',width : 30,dataIndex : 'hylxdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_hylxSelcet_dm = new Ext.data.Store({
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

var searchHylxSelcet_dm = function() {
	ds_hylxSelcet_dm.baseParams.conditions = text_search_hylxSelcet_dm.getValue();
	ds_hylxSelcet_dm.baseParams.username="";
	ds_hylxSelcet_dm.baseParams.stateConditions='';
	ds_hylxSelcet_dm.load({params : {start : 0,limit : 20} });
}

var grid_hylx_dataModify = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_hylxSelcet_dm,
	ds : ds_hylxSelcet_dm,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入经济行业代码名称：',text_search_hylxSelcet_dm,btn_search_hylxSelcet_dm],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_hylxSelcet_dm,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_hylxQuery_dataModify.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			dataModifyViewForm.getForm().findField('select_jjhymc_dataModify').setValue(selections[0].get('hylxmc'));
			dataModifyViewForm.getForm().findField('select_jjhydm_dataModify').setValue(selections[0].get('hylxdm'));
			dataModifyViewForm.getForm().findField('select_jjhymcOld_dataModify').setValue(selections[0].get('hylxmcOld'));
			dataModifyViewForm.getForm().findField('select_jjhydmOld_dataModify').setValue(selections[0].get('hylxdmOld'));
		}
	}
});


var window_hylxQuery_dataModify = new Ext.Window({
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
	items : [grid_hylx_dataModify]
});


var btn_search_jjlx_dataModify = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJjlx_dataModify();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_jjlx_dataModify = new Ext.form.TextField({
	id : 'textSearchJjlx_dataModify',
	name : 'textSearchJjlx_dataModify',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJjlx_dataModify();
			}
		},
		'change' : function(field, e) {
			btn_search_jjlx_dataModify.setDisabled(false);
		}
	}
});


var cm_jjlx_dataModify = new Ext.grid.ColumnModel([
    {header : '大类',width : 30,dataIndex : 'pjjlxmc',sortable : true}, 
    {header : '中类',width : 30,dataIndex : 'pjjlxmc2',sortable : true}, 
    {header : '小类',width : 30,dataIndex : 'pjjlxmc3',sortable : true}, 
	{header : '经济类型名称',width : 100,dataIndex : 'jjlxmc',sortable : true}, 
	{header : '经济类型代码',width : 30,dataIndex : 'jjlxdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_jjlx_dataModify = new Ext.data.Store({
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


var jglxStore_dm = new Ext.data.Store({
	url : 'findAllByConditionJjlx.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'jjlxmc',type : 'string'},
		{name : 'jjlxdm',type : 'string'}
	])
});


var searchJjlx_dataModify = function() {
	ds_jjlx_dataModify.baseParams.conditions = text_search_jjlx_dataModify.getValue();
	ds_jjlx_dataModify.baseParams.username='';
	ds_jjlx_dataModify.baseParams.stateConditions='';
	ds_jjlx_dataModify.load({params : {start : 0,limit : 20} });
}

var grid_jjlx_dataModify = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jjlx_dataModify,
	ds : ds_jjlx_dataModify,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入企业登记注册类型名称：',text_search_jjlx_dataModify,btn_search_jjlx_dataModify],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jjlx_dataModify,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jjlxQuery_dataModify.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			dataModifyViewForm.getForm().findField('select_jjlxmc_dataModify').setValue(selections[0].get('jjlxmc'));
			dataModifyViewForm.getForm().findField('select_jjlxdm_dataModify').setValue(selections[0].get('jjlxdm'));
			dataModifyViewForm.getForm().findField('select_jjlxmcOld_dataModify').setValue(selections[0].get('ojjlxmc00'));
			dataModifyViewForm.getForm().findField('select_jjlxdmOld_dataModify').setValue(selections[0].get('ojjlxdm00'));
			if(selections[0].get('jjlxdm')>5000 && selections[0].get('jjlxdm')<8000){
				dataModifyViewForm.getForm().findField('wftzgb_dataModify').allowBlank=false;
				dataModifyViewForm.getForm().findField('wftzgbdm_dataModify').allowBlank=false;
				if(selections[0].get('jjlxdm')>6000 && selections[0].get('jjlxdm')<7000){
					dataModifyViewForm.getForm().findField('wftzgb_dataModify').setValue('港澳台');
					dataModifyViewForm.getForm().findField('wftzgbdm_dataModify').setValue('344');
				}
			}else{
				dataModifyViewForm.getForm().findField('wftzgb_dataModify').setValue('');
				dataModifyViewForm.getForm().findField('wftzgbdm_dataModify').setValue('');
				dataModifyViewForm.getForm().findField('wftzgb_dataModify').allowBlank=true;
				dataModifyViewForm.getForm().findField('wftzgbdm_dataModify').allowBlank=true;
			}				
		}			
	}
});


var window_jjlxQuery_dataModify = new Ext.Window({
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
	items : [grid_jjlx_dataModify]
});


//主管部门
var searchZgmc_dataModify = function() {
	ds_zgmc_dataModify.baseParams.conditions = text_search_zgmc_dataModify.getValue();
	ds_zgmc_dataModify.baseParams.username='';
	ds_zgmc_dataModify.baseParams.stateConditions='';
	ds_zgmc_dataModify.load({params : {start : 0,limit : 20} });
}

var btn_search_zgmc_dataModify = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchZgmc_dataModify();
		//btn_search_pzjg.setDisabled(true);
	}
});

var text_search_zgmc_dataModify = new Ext.form.TextField({
	id : 'textSearchZgmc_dataModify',
	name : 'textSearchZgmc_dataModify',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchZgmc_dataModify();
			}
		},
		'change' : function(field, e) {
			btn_search_zgmc_dataModify.setDisabled(false);
		}
	}
});

var cm_zgmc_dataModify = new Ext.grid.ColumnModel([
	{header : '主管部门名称',width : 50,dataIndex : 'jgmc',sortable : true}, 
	{header : '主管部门代码',width : 20,dataIndex : 'jgdm',sortable : true}
]);

var ds_zgmc_dataModify = new Ext.data.Store({
	url : 'findAllTjgdm.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'jgdm',type : 'string'},
			{name : 'jgmc',type : 'string'}
		])
});
var grid_zgmc_dataModify = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_zgmc_dataModify,
	ds : ds_zgmc_dataModify,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入主管部门名称：',text_search_zgmc_dataModify,btn_search_zgmc_dataModify],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_zgmc_dataModify,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_zgmcQuery_dataModify.hide();
			var selections=grid.getSelectionModel().getSelections();
			dataModifyViewForm.getForm().findField('select_zgmc_dataModify').setValue(selections[0].get('jgmc'));
			dataModifyViewForm.getForm().findField('select_zgdm_dataModify').setValue(selections[0].get('jgdm'));
		}
	}
});
var window_zgmcQuery_dataModify = new Ext.Window({
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
	items : [grid_zgmc_dataModify]
});




//--------------------机构基本信息-------------------------------------------
var dataModifyViewForm = new Ext.FormPanel({	
	url : 'saveOrgnewModify.action',
	labelAlign : 'right',
    bodyStyle:'padding:0px',
	labelWidth : 85,
	border : false,
	baseCls : 'x-plain',
	waitMsgTarget: true,
	autoScroll : true,
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
						id:"select_jglxdm_dataModify",
						name:"jglxdm",
						fieldLabel:"机构类型",
						//width:135,
						anchor:'97%',
					 	valueField : "jglxdm",
					    displayField : "jglxdm",
					    store : jglxStore_dm,
					    labelSeparator:'',
					    allowBlank : false,
					    haveShow : false,
					    editable : false,
					    onTriggerClick : function() {
					    	window_jglxQuery_dataModify.show();
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
                items: [{ xtype:'textfield',id:"select_jglxmc_dataModify",name : 'jglx',labelSeparator:'',hideLabel:true,allowBlank : false,readOnly:'true',maxLength : 50,anchor:'100%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{xtype : 'combo',
						fieldLabel : '小微企业',
						id : 'isxw_dataModify',
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
						id : 'gk_dataModify',
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
						id : 'fkbz_dataModify',
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
						value:'是',
						mode : 'local',
						selectOnFocus : true,
						allowBlank:false,
						editable : false,
						listeners : {
							'select' : function(val, field) {
								if(val.getValue()=='是'){
									dataModifyViewForm.getForm().findField('fksl').setValue('1');
								}else{
									dataModifyViewForm.getForm().findField('fksl').setValue('0');
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
                	{ xtype:'textfield',fieldLabel : '机构代码',name : 'jgdm',labelSeparator:'',allowBlank : false,vtype:'verifyCode',readOnly:true,maxLength : 9,minLength:9,anchor:'100%'}]
			},{
                columnWidth:.75,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构名称',id:'jgmc_dataModify',name : 'jgmc',labelSeparator:'',allowBlank : false,maxLength : 100,anchor:'99.9%'}]
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
						id : 'zjlx_dataModify',
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
									var flag = isIdCardNo(dataModifyViewForm.getForm().findField('zjhm').getValue());
									if(flag != true){
										dataModifyViewForm.getForm().findField('zjhm').focus();
									}
								}else{
									dataModifyViewForm.getForm().findField('zjhm').focus();
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
                	xtype:'textfield',fieldLabel : '证件号码',name : 'zjhm',labelSeparator:'',hideLabel:true,allowBlank : false,confirmTo:'zjlx_dataModify',vtype:'sfzhao',maxLength : 25,anchor:'99.9%',
                	enableKeyEvents: true,
					listeners : {
						keyup: function(f, e){//计数
				    		dataModifyViewForm.findById('ws_dm').setText("("+f.getValue().length+")");
				    	}
					}
				}]
			},{
				columnWidth : '.03',
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'ws_dm',name:'ws_dm',text:'(0)'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '移动电话',id : 'mobile_dm',name : 'mobile',labelSeparator:'',vtype:'mobilephone',maxLength:11,minLength:11,anchor:'100%'}]
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
				    		dataModifyViewForm.findById('fw_dm').setText("("+length+")");
				    	}
			    	}
                }]
			},{
				columnWidth : .05,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'fw_dm',name:'fw_dm',text:'(1000)'}]
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
				    		dataModifyViewForm.findById('jj_dm').setText("("+length+")");
				    	}
			    	}
                }]
			},{
				columnWidth : .05,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'jj_dm',name:'jj_dm',text:'(1000)'}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
		                id:'zcrq_dataModify',
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
								if(f.getValue()>dataModifyViewForm.getForm().findField('zsbfrq_dataModify').getValue()){
									dataModifyViewForm.getForm().findField('zsbfrq_dataModify').setValue('');
								}
								dataModifyViewForm.getForm().findField('zsbfrq_dataModify').minValue=f.getValue();
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
		                id:'zsbfrq_dataModify',
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
						//dateRange:{begin:'zsbfrq_dataModify',end:'zszfrq_dataModify'},//用于vtype类型dateRange   
                		//vtype:'dateRange'
				        })]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
					    id:'zszfrq_dataModify',
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
					    dateRange:{begin:'zsbfrq_dataModify',end:'zszfrq_dataModify'},//用于vtype类型dateRange   
            			vtype:'dateRange'
					})]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jjlxdm_dataModify",
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
					    	window_jjlxQuery_dataModify.show();
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
                items: [{xtype:'textfield',fieldLabel : '经济类型名称',id:"select_jjlxmc_dataModify",name : 'jjlx',readOnly:true,labelSeparator:'',hideLabel:true,anchor:'99.9%'},
                	{xtype:'hidden',id:"select_jjlxmcOld_dataModify",name : 'jjlxOld'},
                	{xtype:'hidden',id:"select_jjlxdmOld_dataModify",name : 'jjlxdmOld'}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jjhydm_dataModify",
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
					    	window_hylxQuery_dataModify.show();
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
                items: [{xtype:'textfield',fieldLabel : '经济行业名称',id:"select_jjhymc_dataModify",name : 'jjhymc',readOnly:true,labelSeparator:'',hideLabel:true,anchor:'99.9%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '注册资金(万)',name : 'zczj',labelSeparator:'',allowBlank : false,xtype : 'numberfield',decimalPrecision :6,maxValue : 2000000000,value:'0',anchor:'97%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [{xtype : 'combo',
					fieldLabel : '货币种类',
					id : 'hbzl_dataModify',
					displayField : 'categoryName',//显示值的名称
					hiddenName : 'hbzl',//真正提交时此combo的name
					valueField : 'categoryName',//真正提交时此combo的value
					mode : 'remote',
					store : ds_hbzl_select_dm,
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
							//dataModifyViewForm.getForm().findField('_hbzl').setValue(Ext.get("hbzl_dataModify").dom.value);
							dataModifyViewForm.getForm().findField('hbzldm_dataModify').setValue(record.data.categoryCode);
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
					id : 'wftzgb_dataModify',
					displayField : 'categoryName',//显示值的名称
					hiddenName : 'wftzgb',//真正提交时此combo的name
					valueField : 'categoryName',//真正提交时此combo的value
					mode : 'remote',
					store : ds_wftzgb_select_dm,
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
							//dataModifyViewForm.getForm().findField('_wftzgb').setValue(Ext.get("wftzgb_dataModify").dom.value);
							dataModifyViewForm.getForm().findField('wftzgbdm_dataModify').setValue(record.data.categoryCode);
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
                items: [{xtype:'textfield',fieldLabel : '外方国别代码',id : 'wftzgbdm_dataModify',name : 'wftzgbdm',labelSeparator:'',hideLabel:true,allowBlank : true,anchor:'99.9%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [
                	new Ext.form.TriggerField({
						id:"select_zgdm_dataModify",
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
					    	window_zgmcQuery_dataModify.show();
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
                items: [{xtype:'textfield',fieldLabel : '主管部门名称',name :'zgmc',labelSeparator:'',id:"select_zgmc_dataModify",hideLabel:true,anchor:'99.9%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_pzjgdm_dataModify",
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
					    onTriggerClick : function() {
					    	window_pzjgQuery_dm.show();
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
				    })
				]
            },{
                columnWidth:.75,
                layout: 'form',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '批准机构名称',name:'pzjgmc',labelSeparator:'',id:"select_pzjgmc_dataModify",allowBlank : false,hideLabel:true,anchor:'99.9%'}]
            },{
                columnWidth:.5,
                layout: 'form',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '注册号',name : 'zch',labelSeparator:'',allowBlank : false,maxLength : 50,anchor:'100%'}]
            },{
                columnWidth:.5,
                layout: 'form',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '联系电话',name : 'dhhm',labelSeparator:'',vtype:'phone',maxLength : 50,anchor:'100%'}]
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
                items: [
                	new Ext.form.TriggerField({
						fieldLabel : '行政区划',
						id : 'xzqhCode_dataModify',
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
					    	window_xzqhQuery_dataModify.show();
					    },
					    listeners : {
							'specialkey' : function(field, e) {
								if (e.getKey() == Ext.EventObject.ENTER) {
									findXzqhNameByXzqhCode(field,'xzqhName_dataModify');
								}
							},
							'blur': function(field){
								findXzqhNameByXzqhCode(field,'xzqhName_dataModify');
							}
						}
				    })
				]
            },{
                columnWidth:.5,
                layout: 'form',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '行政区划代码',id:'xzqhName_dataModify',name : 'xzqhName',readOnly:true,labelSeparator:'',allowBlank : false,hideLabel:true,maxLength : 50,anchor:'99.9%'}]
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
                items: [
                	new Ext.form.TriggerField({
						fieldLabel : '行政区划',
						id : 'xzqhCode_dataModify2',
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
					    	window_xzqhQuery_dataModify2.show();
					    },
					    listeners : {
							'specialkey' : function(field, e) {
								if (e.getKey() == Ext.EventObject.ENTER) {
									findXzqhNameByXzqhCode(field,'xzqhName_dataModify2');
								}
							},
							'blur': function(field){
								findXzqhNameByXzqhCode(field,'xzqhName_dataModify2');
							}
						}
				    })
				]
            },{
                columnWidth:.5,
                layout: 'form',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '行政区划代码',id:'xzqhName_dataModify2',name : 'xzqhName2',readOnly:true,labelSeparator:'',hideLabel:true,maxLength : 50,anchor:'99.9%'}]
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
						id : 'zjlx2_dataModify',
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
						readOnly:true,
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
								var flag = isIdCardNo(dataModifyViewForm.getForm().findField('tbrsfzh').getValue());
								if(flag != true){
									dataModifyViewForm.getForm().findField('tbrsfzh').focus();
								}
							}else{
								dataModifyViewForm.getForm().findField('tbrsfzh').focus();
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
                	xtype:'textfield',fieldLabel : '证件号码',name : 'tbrsfzh',labelSeparator:'',hideLabel:true,confirmTo:'zjlx2_dataModify',vtype:'sfzhao',allowBlank : false,maxLength : 50,anchor:'95%',
                	enableKeyEvents: true,
					listeners : {
						keyup: function(f, e){//计数
				    		dataModifyViewForm.findById('ts_dm').setText("("+f.getValue().length+")");
				    	}
					}	
				}]
			},{
				columnWidth : '.03',
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'ts_dm',name:'ts_dm',text:'(0)'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '经办人电话',name : 'tbrlxfs',allowBlank : false,labelSeparator:'',maxLength : 50,anchor:'100%'}]
			},{
                columnWidth:.33,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
					    id:'bzrq_dataModify',
					    name: 'bzrq',
					    format:'Y-m-d',
					    maxValue:myDate,  
					    maxText:'所选日期应在{0}之前',  
					    //minValue:'01/01/1949',
					    //minText:'所选日期应在{0}之后',
					    labelSeparator:'',
					    anchor:'100%',
					    fieldLabel:'办证日期',
					    renderer:dateFormat,
					    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd' 
					    })
				]
			},{
                columnWidth:.34,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
					    id:'zfrq_dataModify',
					    name: 'zfrq',
					    format:'Y-m-d',
					    maxValue:newZfrqYes,  
					    maxText:'所选日期应在{0}之前',  
					    minValue:myDate,
					    minText:'所选日期应在{0}之后',
					    anchor:'100%',
					    fieldLabel:'作废日期',
					    labelSeparator:'',
					    renderer:dateFormat,
					    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd' 
					    })
				]
			},{
                columnWidth:.33,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
					    id:'njqx_dataModify',
					    name: 'njqx',
					    format:'Y-m-d',
					    maxValue:newNjqx,  
					    maxText:'所选日期应在{0}之前',  
					    minValue:'01/01/1949',
					    minText:'所选日期应在{0}之后',
					    anchor:'100%',
					    labelSeparator:'',
					    fieldLabel:'年检期限',
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
            		{xtype:'hidden',fieldLabel : '备注',name : 'memo',labelSeparator:'',maxLength : 50,anchor:'99.9%'},
                	{xtype:'hidden',fieldLabel : '业务类型',name : 'ywlx',value:'清整'},
					{xtype : 'hidden',	name : 'orgid',value:''},
				    {xtype : 'hidden',	name : 'orderid',id:'orderid'},
				    {xtype : 'hidden',name : 'docid'},
				    {xtype : 'hidden',name : 'zslsh'},
				    {xtype : 'hidden',name : 'dybz'},
					{xtype : 'hidden',name : 'imageUrl'},
				    {xtype : 'hidden',id:'hbzldm_dataModify',name : 'hbzldm',value:'156'},
				    {xtype : 'hidden',id:'select_jjhymcOld_dataModify',name : 'jjhymcOld'},
				    {xtype : 'hidden',id:'select_jjhydmOld_dataModify',name : 'jjhydmOld'},
				    {xtype : 'hidden',name : 'bzjgdm',value:currentZzUserBzjgdm},
					{xtype : 'hidden',name : 'lastdate',value :myDate.format('Y-m-d')}, 
					{xtype : 'hidden',name : 'bgrq',value :myDate.format('Y-m-d')}, 
					{xtype : 'hidden',name : 'xgr',value:currentZzUsername},
					{xtype : 'hidden',name : 'memo',value:'数据清整'},
					{xtype : 'hidden',name : 'state',value:'22'}]
			}]
	}]
});

var  dataModifyViewForm2= new Ext.Panel({
    title       : '基本信息',
    region      : 'center',
    id          : 'jbInfo2332',
    bodyStyle: 'padding:0px',
    margins: '3 0 0 0',
    cmargins: '5 5 0 0',
    defaults  : {
		autoScroll : true
	},
	layout: 'fit',
    items : [dataModifyViewForm]
});
    
var fileFtpForm_dataModify = new Ext.Panel({    
	title:'原文浏览',
	split: true,
	width:620,
	collapsible:true,
	collapsed: true,
    region:'east',
    margins:'3 0 0 0',
    cmargins:'3 0 0 5',
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"  width=100%  height=100% align=center hspace=0 vspace=0 id="scanner246123"  name="scanner246123" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="0">'
	       +'</OBJECT>'
    
});


//默认查询 档案
var searchDataModify = function() {

	dataModifyViewForm.getForm().reader = Orgnews;
	dataModifyViewForm.getForm().load({
		waitMsg : '正在进行数据查询，请稍等',          //提示信息   
        waitTitle : '提示',                      //标题  
	    url: 'findAllYwqxOrgnew.action', //请求控制器获取数据
	    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
	    params: { conditions:  text_search_dataModify.getValue(),username:currentZzUsername,ywlxConditions:null,stateConditions:'6,16,22',start:1,limit:1},	
	    success:function(form,action) {//获取返回值
		    	if(action.result.data.orgid!=''){//自动加载原文
		    		btn_ok_dataModify.setDisabled(true);
		    		btn_save_dataModify.setDisabled(false);
		    		var tab3452=Ext.getCmp("jbInfo2332");
		    		tab3452.setTitle("基本信息  (业务库数据清整)");
		    		var resultObject = null;
		    		dataModifyViewForm.getForm().findField('lastdate').setValue(myDate.format('Y-m-d'));
					dataModifyViewForm.getForm().findField('xgr').setValue(currentZzUsername);
					dataModifyViewForm.getForm().findField('memo').setValue('数据清整');
					//dataModifyViewForm.getForm().findField('bzjgdm').setValue(currentZzUserBzjgdm);
		            //alert(action.result.data.orgid);
		    		Ext.Ajax.request({
						url : 'orgnewViewImg.action',
						params : {orgid : action.result.data.orgid},
						//waitTitle: '提示',
					    //waitMsg: '数据正在重新加载中，请稍后',
						success : function(result,request) {//获取返回值
							scanner246123.ImageData="";
		   					var resultObject = Ext.util.JSON.decode(result.responseText);
		   					if(resultObject!=null){
			   					scanner246123.OpenProgress(3);  //设置上传的进度条的总进度数
			   					scanner246123.Progress('原文加载中',1);
									scanner246123.Progress('原文加载中',2);
			   					scanner246123.ImageData=resultObject.imageData;
			   					scanner246123.pageType=resultObject.pageTypeStr;
			   					if(scanner246123.ImageData!=""){
			   						scanner246123.Progress('原文加载完毕',3);
									scanner246123.CloseProgress();
								}else{
									scanner246123.Progress('原文加载失败',3);
					   				scanner246123.CloseProgress();
					   				alert("原文错误，加载失败！");
								}
		   					}
						},
						failure : function() {
							scanner246123.ImageData="";
				   			scanner246123.CloseProgress();
							alert("图像加载错误，或者无原文");
						}
					});	
		
				}else{
					Ext.Msg.show({
						title : '提示',
						msg : '申请单错误!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
	            }
		},
		failure : function() {//正式库检索
			dataModifyViewForm.getForm().reader = Orgnews;
			dataModifyViewForm.getForm().load({
				waitMsg : '正在进行数据查询，请稍等',          //提示信息   
		        waitTitle : '提示',                      //标题  
			    url: 'findAllTjgdm.action', //请求控制器获取数据
			    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
			    params: { conditions:  text_search_dataModify.getValue(),stateConditions:'',userBzjgdm:null,start:1,limit:1},	
			    success:function(form,action) {//获取返回值
			    		if(currentZzUsername!='admin' && sysBzjgLimitMode=='1' && action.result.data.bzjgdm!=currentZzUserBzjgdm && currentZzUserYwqx!='2' && currentZzUserBzjgdm!=currentZzUserCenterid){
			    				Ext.Msg.show({
									title : '提示',
									msg : '【'+action.result.data.jgmc+'】，<br><br>办证机构代码为“'+action.result.data.bzjgdm+'”,不属于本办证机构办理！',
									buttons : Ext.Msg.OK,
									fn:  function() {
										btn_save_dataModify.setDisabled(true);
										dataModifyViewForm.getForm().reset();
										var tab3452=Ext.getCmp("jbInfo2332");
						    			tab3452.setTitle("基本信息");
									},
									icon : Ext.Msg.ERROR
								});
				    	}else{
						    if(action.result.data.state=='100' || action.result.data.state==''){//判断此机构状态是否正常
							    	if(action.result.data.orgid!=''){//自动加载原文
							    		btn_save_dataModify.setDisabled(false);
							    		//btn_shibie_dataModify.setDisabled(true);
							    		scanner246123.ImageData="";
							    		btn_ok_dataModify.setDisabled(true);
							    		var tab3452=Ext.getCmp("jbInfo2332");
							    		tab3452.setTitle("基本信息  (正式库数据清整)");
							    		dataModifyViewForm.getForm().findField('ywlx').setValue('清整');
							    		dataModifyViewForm.getForm().findField('state').setValue('22');
							    		dataModifyViewForm.getForm().findField('orgid').setValue('');
							    		dataModifyViewForm.getForm().findField('dybz').setValue('Y');
							    		dataModifyViewForm.getForm().findField('lastdate').setValue(myDate.format('Y-m-d'));
										dataModifyViewForm.getForm().findField('xgr').setValue(currentZzUsername);
										if(action.result.data.zbsl==null||action.result.data.zbsl==''){
											dataModifyViewForm.getForm().findField('zbsl').setValue(1);
										}
										if(action.result.data.bzjgdm==null||action.result.data.bzjgdm==''){
											dataModifyViewForm.getForm().findField('bzjgdm').setValue(currentZzUserBzjgdm);
										}
										//010883169 211404195504126839
										dataModifyViewForm.getForm().findField('memo').setValue('数据清整');
									}else{
										Ext.Msg.show({
											title : '提示',
											msg : '申请单错误!',
											buttons : Ext.Msg.OK,
											icon : Ext.Msg.ERROR
										});
						            }
						    	}
				    		}
						},
						failure : function() {
							Ext.Msg.show({
								title : '提示',
								msg : '信息未查到!',
								width:250,
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR,
								fn:  function() {
								    btn_save_dataModify.setDisabled(true);
									dataModifyViewForm.getForm().reset();
									var tab3452=Ext.getCmp("jbInfo2332");
					    			tab3452.setTitle("基本信息");
								}
						});
					}	
				});
		}
	});
}

var btn_search_dataModify = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchDataModify();
	}
});

var text_search_dataModify = new Ext.form.TextField({
	id : 'textSearchdataModify',
	name : 'textSearchdataModify',
	width : 200,
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchDataModify();
			}
		}
	}
});


var btn_refresh_dataModify = new Ext.Button({
	text : '重置',
	iconCls : 'icon-refresh',
	handler : function() {
		btn_ok_dataModify.setDisabled(true);
		dataModifyViewForm.getForm().reset();
		var tab3452=Ext.getCmp("jbInfo2332");
	    tab3452.setTitle("基本信息");
		scanner246123.ImageData="";
		//this.ownerCt.form.reset();;
	}
});


var btn_save_dataModify = new Ext.Button({
	text : '保存',
	iconCls : 'icon-save',
	disabled:true,
    handler: btn_dataModify_saveInfo,
    tooltip: {title:'保存数据信息！'}
});

function btn_dataModify_saveInfo(btn){
	if (dataModifyViewForm.getForm().isValid()) {
		dataModifyViewForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在保存数据,请稍候...',
			success : function(form,action) {
				//alert(action.result.orgid);
				dataModifyViewForm.getForm().findField('orgid').setValue(action.result.orgid);
				dataModifyViewForm.getForm().findField('docid').setValue(action.result.docid);
				Ext.Msg.show({
					title : '提示',
					msg : '['+dataModifyViewForm.getForm().findField('jgmc_dataModify').getValue()+']，<br><br>清整信息保存成功',
					buttons : Ext.Msg.OK,
					fn : function() {btn.enable();btn_ok_dataModify.setDisabled(false);},
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
			msg : '机构信息，填写不完整！<br><br>显示为红色的输入框为错误输入项',
			buttons : Ext.Msg.OK,
			fn : function() {btn.enable();},
			icon : Ext.Msg.ERROR
		});
	}
}


var btn_ok_dataModify = new Ext.Button({
	text : '清整完毕确认',
	iconCls : 'icon-store',
	handler : function(){
		var orgid = dataModifyViewForm.getForm().findField('orgid').value;
		var strJgdm = dataModifyViewForm.getForm().findField('jgdm').value;
		var strState = dataModifyViewForm.getForm().findField('state').value;
		var jgmc = dataModifyViewForm.getForm().findField('jgmc_dataModify').getValue();
		var strYwlx = dataModifyViewForm.getForm().findField('ywlx').value;
		if(orgid!=null || orgid!=""){
			ajaxLoadMask.show();
			Ext.Ajax.request({
				url: 'returnOrgnewModify.action',
   				params: {orgid: orgid,jgdm:strJgdm,state:strState,ywlx:strYwlx},
   				success: function(){
   					ajaxLoadMask.hide();
   					Ext.Msg.show({
						title : '提示',
						msg : '[' + jgmc + ']清整办理完毕！',
						buttons : Ext.Msg.OK,
						fn:  function() {
		   					dataModifyViewForm.getForm().findField('orgid').setValue('');
		   					btn_ok_dataModify.setDisabled(true);
		   					var tab3452=Ext.getCmp("jbInfo2332");
				    		tab3452.setTitle("基本信息");	
							dataModifyViewForm.getForm().reset();
							scanner246123.PageType="";
							scanner246123.ImageData="";
							text_search_dataModify.setValue("");
						},
						icon : Ext.Msg.INFO
					});
   				},
   				failure: function(){
   					ajaxLoadMask .hide();
   					Ext.Msg.show({
						title : '提示',
						msg : '[' + jgmc + ']清整办理失败！',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
   				}
			});
		}else{
			Ext.Msg.show({
				title : '提示',
				msg : '请保存信息后，再进行“清整确认”处理！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR
			});
		}
	}
});

var p_zzDataModify = {
	id : 'zzDataModify-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:0px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    bodyBorder: false,
	    title: '数据清整',
	    iconCls : 'icon-plugin',
 		plain: true,
		region: 'center',
		tbar : [btn_refresh_dataModify,btn_save_dataModify,btn_ok_dataModify,'->',text_search_dataModify,btn_search_dataModify],
		items: [dataModifyViewForm2,fileFtpForm_dataModify]
	}]
}