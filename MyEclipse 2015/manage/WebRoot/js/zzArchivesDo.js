
var searchXzqh_archivesDo2 = function() {
	ds_xzqh_archivesDo2.baseParams.conditions = text_search_xzqh_archivesDo2.getValue();
	ds_xzqh_archivesDo2.baseParams.username='';
	ds_xzqh_archivesDo2.baseParams.stateConditions='';
	ds_xzqh_archivesDo2.load({params : {start : 0,limit : 20} });
}

var btn_search_xzqh_archivesDo2 = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchXzqh_archivesDo2();
	}
});

var text_search_xzqh_archivesDo2 = new Ext.form.TextField({
	id : 'textSearchXzqh_archivesDo2',
	name : 'textSearchXzqh_archivesDo2',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchXzqh_archivesDo2();
			}
		},
		'change' : function(field, e) {
			searchXzqh_archivesDo2();
			//btn_search_xzqh_archivesDo.setDisabled(false);
		}
	}
});

var cm_xzqh_archivesDo2 = new Ext.grid.ColumnModel([
	{header : '行政区划名称',width : 50,dataIndex : 'xzqhName',sortable : true},
	{header : '行政区划代码',width : 20,dataIndex : 'xzqhCode',sortable : true}
]);

var ds_xzqh_archivesDo2 = new Ext.data.Store({
	url : 'findAllByConditionXzqh.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'xzqhCode',type : 'string'},
			{name : 'xzqhName',type : 'string'},
			{name : 'xzqhNote',type : 'string'}
		])
});
var grid_xzqh_archivesDo2 = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_xzqh_archivesDo2,
	ds : ds_xzqh_archivesDo2,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入行政区划名称：',text_search_xzqh_archivesDo2,btn_search_xzqh_archivesDo2],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_xzqh_archivesDo2,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_xzqhQuery_archivesDo2.hide();
			var selections=grid.getSelectionModel().getSelections();
			archivesDoViewForm.getForm().findField('xzqhName_archivesDo2').setValue(selections[0].get('xzqhName'));
			archivesDoViewForm.getForm().findField('xzqhCode_archivesDo2').setValue(selections[0].get('xzqhCode'));
		}
	}
});

var window_xzqhQuery_archivesDo2 = new Ext.Window({
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
	items : [grid_xzqh_archivesDo2]
});
//行政区划的到此结束

var searchXzqh_archivesDo = function() {
	ds_xzqh_archivesDo.baseParams.conditions = text_search_xzqh_archivesDo.getValue();
	ds_xzqh_archivesDo.baseParams.username='';
	ds_xzqh_archivesDo.baseParams.stateConditions='';
	ds_xzqh_archivesDo.load({params : {start : 0,limit : 20} });
}

var btn_search_xzqh_archivesDo = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchXzqh_archivesDo();
	}
});

var text_search_xzqh_archivesDo = new Ext.form.TextField({
	id : 'textSearchXzqh_archivesDo',
	name : 'textSearchXzqh_archivesDo',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchXzqh_archivesDo();
			}
		},
		'change' : function(field, e) {
			searchXzqh_archivesDo();
			//btn_search_xzqh_archivesDo.setDisabled(false);
		}
	}
});

var cm_xzqh_archivesDo = new Ext.grid.ColumnModel([
	{header : '行政区划名称',width : 50,dataIndex : 'xzqhName',sortable : true},
	{header : '行政区划代码',width : 20,dataIndex : 'xzqhCode',sortable : true}
]);

var ds_xzqh_archivesDo = new Ext.data.Store({
	url : 'findAllByConditionXzqh.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'xzqhCode',type : 'string'},
			{name : 'xzqhName',type : 'string'},
			{name : 'xzqhNote',type : 'string'}
		])
});
var grid_xzqh_archivesDo = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_xzqh_archivesDo,
	ds : ds_xzqh_archivesDo,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入行政区划名称：',text_search_xzqh_archivesDo,btn_search_xzqh_archivesDo],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_xzqh_archivesDo,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_xzqhQuery_archivesDo.hide();
			var selections=grid.getSelectionModel().getSelections();
			archivesDoViewForm.getForm().findField('xzqhName_archivesDo').setValue(selections[0].get('xzqhName'));
			archivesDoViewForm.getForm().findField('xzqhCode_archivesDo').setValue(selections[0].get('xzqhCode'));
		}
	}
});

var window_xzqhQuery_archivesDo = new Ext.Window({
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
	items : [grid_xzqh_archivesDo]
});
//行政区划的到此结束

var btn_search_pzjg_archivesDo = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchPzjg_archivesDo();
		//btn_search_pzjg_archivesDo.setDisabled(true);
	}
});


var text_search_pzjg_archivesDo = new Ext.form.TextField({
	id : 'textSearchPzjg_archivesDo',
	name : 'textSearchPzjg_archivesDo',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchPzjg_archivesDo();
			}
		},
		'change' : function(field, e) {
			btn_search_pzjg_archivesDo.setDisabled(false);
		}
	}
});


var cm_pzjg_archivesDo = new Ext.grid.ColumnModel([
	{header : '批准机构名称',width : 50,dataIndex : 'pzjgmc',sortable : true}, 
	{header : '批准机构代码',width : 20,dataIndex : 'pzjgdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_pzjg_archivesDo = new Ext.data.Store({
	url : 'findAllByConditionPzjg.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'pzjgid',type : 'int'}, 
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchPzjg_archivesDo = function() {
	ds_pzjg_archivesDo.baseParams.conditions = text_search_pzjg_archivesDo.getValue();
	ds_pzjg_archivesDo.baseParams.username='';
	ds_pzjg_archivesDo.baseParams.stateConditions='';
	ds_pzjg_archivesDo.load({params : {start : 0,limit : 20} });
}

var grid_pzjg_archivesDo = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_pzjg_archivesDo,
	ds : ds_pzjg_archivesDo,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入登记批准机构名称：',text_search_pzjg_archivesDo,btn_search_pzjg_archivesDo],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_pzjg_archivesDo,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_pzjgQuery_archivesDo.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			archivesDoViewForm.getForm().findField('select_pzjgmc_archivesDo').setValue(selections[0].get('pzjgmc'));
			archivesDoViewForm.getForm().findField('select_pzjgdm_archivesDo').setValue(selections[0].get('pzjgdm'));
		}
	}
});


var window_pzjgQuery_archivesDo = new Ext.Window({
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
	items : [grid_pzjg_archivesDo]
});


var btn_search_jglxSelcet_archivesDo = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJglxSelcet_archivesDo();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_jglxSelcet_archivesDo = new Ext.form.TextField({
	id : 'textsearchJglxSelcet_archivesDo',
	name : 'textsearchJglxSelcet_archivesDo',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJglxSelcet_archivesDo();
			}
		},
		'change' : function(field, e) {
			btn_search_jglxSelcet_archivesDo.setDisabled(false);
		}
	}
});


var cm_jglxSelcet_archivesDo = new Ext.grid.ColumnModel([
    {header : '一级类型',width : 60,dataIndex : 'pjglxmc',sortable : true}, 
	{header : '二级类型',width : 100,dataIndex : 'jglxmc',sortable : true}, 
	{header : '代码',width : 30,dataIndex : 'jglxdm',sortable : true},
	{header : '备注',width : 50,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_jglxSelcet_archivesDo = new Ext.data.Store({
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

var ds_hbzl_select_archivesDo = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=1',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});

var searchJglxSelcet_archivesDo = function() {
	ds_jglxSelcet_archivesDo.baseParams.conditions = text_search_jglxSelcet_archivesDo.getValue();
	ds_jglxSelcet_archivesDo.baseParams.username="";
	ds_jglxSelcet_archivesDo.baseParams.stateConditions='';
	ds_jglxSelcet_archivesDo.load({params : {start : 0,limit : 20} });
}

var grid_jglx_archivesDo = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jglxSelcet_archivesDo,
	ds : ds_jglxSelcet_archivesDo,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入机构类型名称：',text_search_jglxSelcet_archivesDo,btn_search_jglxSelcet_archivesDo],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jglxSelcet_archivesDo,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jglxQuery_archivesDo.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			archivesDoViewForm.getForm().findField('select_jglxmc_archivesDo').setValue(selections[0].get('jglxmc'));
			archivesDoViewForm.getForm().findField('select_jglxdm_archivesDo').setValue(selections[0].get('jglxdm'));
			
			if(selections[0].get('pjglxdm')==1){
				archivesDoViewForm.getForm().findField('select_jjlxmc_archivesDo').allowBlank=false;
				archivesDoViewForm.getForm().findField('select_jjlxdm_archivesDo').allowBlank=false;
			}else{
				archivesDoViewForm.getForm().findField('select_jjlxmc_archivesDo').allowBlank=true;
				archivesDoViewForm.getForm().findField('select_jjlxdm_archivesDo').allowBlank=true;
			}
		}
	}
});


var window_jglxQuery_archivesDo = new Ext.Window({
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
	items : [grid_jglx_archivesDo]
});

var btn_search_hylxSelcet_archivesDo = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchHylxSelcet_archivesDo();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_hylxSelcet_archivesDo = new Ext.form.TextField({
	id : 'textSearchHylxSelcet_archivesDo',
	name : 'textSearchHylxSelcet_archivesDo',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchHylxSelcet_archivesDo();
			}
		},
		'change' : function(field, e) {
			btn_search_hylxSelcet_archivesDo.setDisabled(false);
		}
	}
});

var ds_wftzgb_select_archivesDo = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=3',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});

var cm_hylxSelcet_archivesDo = new Ext.grid.ColumnModel([
	{header : '大类',width : 60,dataIndex : 'hylxmc1',sortable : true}, 
	{header : '中类',width : 60,dataIndex : 'hylxmc2',sortable : true}, 
	{header : '小类',width : 60,dataIndex : 'hylxmc3',sortable : true}, 
    {header : '经济行业名称',width : 60,dataIndex : 'hylxmc',sortable : true},
	{header : '经济行业代码',width : 30,dataIndex : 'hylxdm',sortable : true},
	{header : '备注',width : 60,dataIndex : 'note',menuDisabled : true}
]);


//查询返回结果的数据列
var ds_hylxSelcet_archivesDo = new Ext.data.Store({
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

var searchHylxSelcet_archivesDo = function() {
	ds_hylxSelcet_archivesDo.baseParams.conditions = text_search_hylxSelcet_archivesDo.getValue();
	ds_hylxSelcet_archivesDo.baseParams.username="";
	ds_hylxSelcet_archivesDo.baseParams.stateConditions='';
	ds_hylxSelcet_archivesDo.load({params : {start : 0,limit : 20} });
}

var grid_hylx_archivesDo = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_hylxSelcet_archivesDo,
	ds : ds_hylxSelcet_archivesDo,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入经济行业代码名称：',text_search_hylxSelcet_archivesDo,btn_search_hylxSelcet_archivesDo],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_hylxSelcet_archivesDo,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_hylxQuery_archivesDo.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			archivesDoViewForm.getForm().findField('select_jjhymc_archivesDo').setValue(selections[0].get('hylxmc'));
			archivesDoViewForm.getForm().findField('select_jjhydm_archivesDo').setValue(selections[0].get('hylxdm'));
			archivesDoViewForm.getForm().findField('select_jjhymcOld_archivesDo').setValue(selections[0].get('hylxmcOld'));
			archivesDoViewForm.getForm().findField('select_jjhydmOld_archivesDo').setValue(selections[0].get('hylxdmOld'));
		}
	}
});


var window_hylxQuery_archivesDo = new Ext.Window({
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
	items : [grid_hylx_archivesDo]
});


var btn_search_jjlx_archivesDo = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJjlx_archivesDo();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_jjlx_archivesDo = new Ext.form.TextField({
	id : 'textSearchJjlx_archivesDo',
	name : 'textSearchJjlx_archivesDo',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJjlx_archivesDo();
			}
		},
		'change' : function(field, e) {
			btn_search_jjlx_archivesDo.setDisabled(false);
		}
	}
});


var cm_jjlx_archivesDo = new Ext.grid.ColumnModel([
    {header : '一级类型',width : 30,dataIndex : 'pjjlxmc',sortable : true}, 
	{header : '二级类型',width : 100,dataIndex : 'jjlxmc',sortable : true}, 
	{header : '代码',width : 30,dataIndex : 'jjlxdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_jjlx_archivesDo = new Ext.data.Store({
	url : 'findAllByConditionJjlx.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'jjlxid',type : 'int'}, 
	    {name : 'pjjlxmc',type : 'string'},
		{name : 'jjlxmc',type : 'string'},
		{name : 'jjlxdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});


var jjlxStore_archivesDo = new Ext.data.Store({
	url : 'findAllByConditionJjlx.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'jjlxmc',type : 'string'},
		{name : 'jjlxdm',type : 'string'}
	])
});


var searchJjlx_archivesDo = function() {
	ds_jjlx_archivesDo.baseParams.conditions = text_search_jjlx_archivesDo.getValue();
	ds_jjlx_archivesDo.baseParams.username='';
	ds_jjlx_archivesDo.baseParams.stateConditions='';
	ds_jjlx_archivesDo.load({params : {start : 0,limit : 20} });
}

var grid_jjlx_archivesDo = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jjlx_archivesDo,
	ds : ds_jjlx_archivesDo,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入企业登记注册类型名称：',text_search_jjlx_archivesDo,btn_search_jjlx_archivesDo],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jjlx_archivesDo,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jjlxQuery_archivesDo.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			archivesDoViewForm.getForm().findField('select_jjlxmc_archivesDo').setValue(selections[0].get('jjlxmc'));
			archivesDoViewForm.getForm().findField('select_jjlxdm_archivesDo').setValue(selections[0].get('jjlxdm'));
			
			if(selections[0].get('jjlxdm')>5000 && selections[0].get('jjlxdm')<8000){
				archivesDoViewForm.getForm().findField('wftzgb_archivesDo').allowBlank=false;
				archivesDoViewForm.getForm().findField('wftzgbdm_archivesDo').allowBlank=false;
				if(selections[0].get('jjlxdm')>6000 && selections[0].get('jjlxdm')<7000){
					archivesDoViewForm.getForm().findField('wftzgb_archivesDo').setValue('港澳台');
					archivesDoViewForm.getForm().findField('wftzgbdm_archivesDo').setValue('344');
				}
			}else{
				archivesDoViewForm.getForm().findField('wftzgb_archivesDo').setValue('');
				archivesDoViewForm.getForm().findField('wftzgbdm_archivesDo').setValue('');
				archivesDoViewForm.getForm().findField('wftzgb_archivesDo').allowBlank=true;
				archivesDoViewForm.getForm().findField('wftzgbdm_archivesDo').allowBlank=true;
			}	
		}
	}
});


var window_jjlxQuery_archivesDo = new Ext.Window({
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
	items : [grid_jjlx_archivesDo]
});

//主管部门
var searchZgmc_archivesDo = function() {
	ds_zgmc_archivesDo.baseParams.conditions = text_search_zgmc_archivesDo.getValue();
	ds_zgmc_archivesDo.baseParams.username='';
	ds_zgmc_archivesDo.baseParams.stateConditions='';
	ds_zgmc_archivesDo.load({params : {start : 0,limit : 20} });
}

var btn_search_zgmc_archivesDo = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchZgmc_archivesDo();
		//btn_search_pzjg.setDisabled(true);
	}
});

var text_search_zgmc_archivesDo = new Ext.form.TextField({
	id : 'textSearchZgmc_archivesDo',
	name : 'textSearchZgmc_archivesDo',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchZgmc_archivesDo();
			}
		},
		'change' : function(field, e) {
			btn_search_zgmc_archivesDo.setDisabled(false);
		}
	}
});

var cm_zgmc_archivesDo = new Ext.grid.ColumnModel([
	{header : '主管部门名称',width : 50,dataIndex : 'jgmc',sortable : true}, 
	{header : '主管部门代码',width : 20,dataIndex : 'jgdm',sortable : true}
]);

var ds_zgmc_archivesDo = new Ext.data.Store({
	url : 'findAllTjgdm.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'jgdm',type : 'string'},
			{name : 'jgmc',type : 'string'}
		])
});

var grid_zgmc_archivesDo = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_zgmc_archivesDo,
	ds : ds_zgmc_archivesDo,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入主管部门名称：',text_search_zgmc_archivesDo,btn_search_zgmc_archivesDo],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_zgmc_archivesDo,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_zgmcQuery_archivesDo.hide();
			var selections=grid.getSelectionModel().getSelections();
			archivesDoViewForm.getForm().findField('select_zgmc_archivesDo').setValue(selections[0].get('jgmc'));
			archivesDoViewForm.getForm().findField('select_zgdm_archivesDo').setValue(selections[0].get('jgdm'));
		}
	}
});

var window_zgmcQuery_archivesDo = new Ext.Window({
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
	items : [grid_zgmc_archivesDo]
});

var archivesDoViewForm = new Ext.FormPanel({	
		url : 'updateOrgnew.action',
		labelAlign : 'right',
	    bodyStyle:'padding:0px',
		labelWidth : 85,
		border : false,
		baseCls : 'x-plain',
		waitMsgTarget: true,
		layout: 'fit',
		items:[{
			layout:'column',
            border:false,
            autoScroll : true,
            baseCls : 'x-plain',
            bodyStyle: 'padding:10px',
            items:[{
	                columnWidth:.5,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{xtype:'textfield',fieldLabel : '流水号',name : 'orderid',labelSeparator:'',readOnly:true,maxLength : 50,anchor:'100%'}]
				},{
	                columnWidth:.25,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [
	                	{xtype:'textfield',fieldLabel : '业务类型',name:'ywlx',labelSeparator:'',allowBlank : false,maxLength : 50,readOnly:true,anchor:'100%'}
					]
				},{
	                columnWidth:.25,
	                layout: 'form',
	                bodyStyle: 'padding:0px',  
	                border:false,
	                items: [{xtype:'textfield',fieldLabel : '机构代码',name : 'jgdm',id : 'jgdm_archivesDo',labelSeparator:'',allowBlank : false,readOnly:true,maxLength : 50,anchor:'100%'}]
				},{
                columnWidth:.3,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jglxdm_archivesDo",
						name:"jglxdm",
						fieldLabel:"机构类型",
						anchor:'97%',
					 	valueField : "jglxdm",
					    displayField : "jglxdm",
					    store : jjlxStore_archivesDo,
					    labelSeparator:'',
					    allowBlank : false,
					    haveShow : false,
					    editable : false,
					    onTriggerClick : function() {
					    	window_jglxQuery_archivesDo.show();
					    }
					})]  
			},{
                columnWidth:.2,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',id:"select_jglxmc_archivesDo",name : 'jglx',labelSeparator:'',hideLabel:true,allowBlank : false,readOnly:'true',maxLength : 50,anchor:'100%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{xtype : 'combo',
						fieldLabel : '小微企业',
						id : 'isxw_archivesDo',
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
						id : 'gk_archivesDo',
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
                	{ xtype:'textfield',fieldLabel : '正本数量',name : 'zbsl',id : 'zbsl_archivesDo',labelSeparator:'',allowBlank : false,xtype : 'numberfield',value:1,maxValue : 2000000000,readOnly:true,anchor:'100%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '副本数量',name : 'fbsl',id : 'fbsl_archivesDo',labelSeparator:'',allowBlank : false,xtype : 'numberfield',value:1,maxValue : 2000000000,anchor:'100%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype : 'combo',
						fieldLabel : '是否发卡',
						id : 'fkbz_archivesDo',
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
						editable : false
					}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '发卡数量',name : 'fksl',id : 'fksl_archivesDo',labelSeparator:'',allowBlank : false,xtype : 'numberfield',value:0,maxValue : 2000000000,anchor:'100%'}]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构名称',name : 'jgmc',labelSeparator:'',id:'jgmc_archivesDo',allowBlank : false,maxLength : 100,anchor:'99.9%'}]
			},{
                columnWidth:.3,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '法定代表人',name : 'fddbr',id : 'fddbr_archivesDo',labelSeparator:'',allowBlank : false,maxLength : 30,anchor:'97%'}]
			},{
                columnWidth:.15,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{	xtype : 'combo',
						fieldLabel : '证件类型',
						id : 'zjlx_archivesDo',
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
						//onTriggerClick : Ext.emptyFn,
						value:'居民身份证',
						triggerAction : 'all',
						loadingText : '加载中...',
						listeners : {
							'select' : function(combo, record, index) {
								if(record.data.categoryName=='居民身份证'){
									var flag = isIdCardNo(archivesDoViewForm.getForm().findField('zjhm').getValue());
									if(flag != true){
										archivesDoViewForm.getForm().findField('zjhm').focus();
									}
								}else{
									archivesDoViewForm.getForm().findField('zjhm').focus();
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
                	xtype:'textfield',fieldLabel : '证件号码',name : 'zjhm',id : 'zjhm_archivesDo',labelSeparator:'',hideLabel:true,allowBlank : false,confirmTo:'zjlx_archivesDo',vtype:'sfzhao',maxLength : 25,anchor:'99.9%',
                	enableKeyEvents: true,
					listeners : {
						keyup: function(f, e){//计数
				    		archivesDoViewForm.findById('ws_archivesDo').setText("("+f.getValue().length+")");
				    	}
					}
				}]
			},{
				columnWidth : '.03',
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'ws_archivesDo',name:'ws_archivesDo',text:'(0)'}]
			},{
                columnWidth:.2,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{
                	xtype:'textfield',fieldLabel : '移动电话',name : 'mobile',
                	id : 'mobile_archivesDo',labelSeparator:'',vtype:'mobilephone',
                	maxLength:11,minLength:11,anchor:'100%'
                	,enableKeyEvents:true,
            		listeners: {
            			keyup: function(f,e){
            				archivesDoViewForm.findById('mobile_arcdo').setText("("+f.getValue().length+")");
            			}
            		}
                }]
			},{
				columnWidth : .05,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'mobile_arcdo',name:'mobile_arcdo',text:'(0)'}]
		    },{
                columnWidth:.95,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                defaultType : 'textarea',
                items: [{
                	fieldLabel : '经营范围',name : 'jyfw',id : 'jyfw_archivesDo',allowBlank : false,labelSeparator:'',maxLength:1000,height:35,anchor:'99.5%',
                	enableKeyEvents: true,
			    	listeners:{
			    		keyup: function(f, e){//计数
				    		var length = 1000-f.getValue().length
				    		archivesDoViewForm.findById('fw_archivesDo').setText("("+length+")");
				    	}
			    	}
                }]
			},{
				columnWidth : .05,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'fw_archivesDo',name:'fw_archivesDo',text:'(1000)'}]
			},{
                columnWidth:.95,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                defaultType : 'textarea',
                items: [{
                	fieldLabel : '经营范围',name : 'qyjj',id : 'qyjj_archivesDo',labelSeparator:'',maxLength:1000,height:35,anchor:'99.5%',
                	enableKeyEvents: true,
			    	listeners:{
			    		keyup: function(f, e){//计数
				    		var length = 1000-f.getValue().length
				    		archivesDoViewForm.findById('jj_archivesDo').setText("("+length+")");
				    	}
			    	}
                }]
			},{
				columnWidth : .05,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'jj_archivesDo',name:'jj_archivesDo',text:'(1000)'}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
		                id:'zcrq_archivesDo',
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
								if(f.getValue()>archivesDoViewForm.getForm().findField('zsbfrq_archivesDo').getValue()){
									archivesDoViewForm.getForm().findField('zsbfrq_archivesDo').setValue('');
								}
								archivesDoViewForm.getForm().findField('zsbfrq_archivesDo').minValue=f.getValue();
							}
						}
				    })]
			},{
                columnWidth:.5,
                layout: 'form',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '职工人数(人)',name : 'zgrs',id : 'zgrs_archivesDo',labelSeparator:'',allowBlank : false,xtype : 'numberfield',maxValue : 2000000000,anchor:'99.9%'}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
		                id:'zsbfrq_archivesDo',
		                name: 'zsbfrq',
		                format:'Y-m-d',
		                maxValue:myDate,  
		                maxText:'所选日期应在{0}之前',  
		                //minValue:myDate,
		                minText:'所选日期应在{0}之后',
		                anchor:'100%',
		                //allowBlank : false,
		                fieldLabel:'证照有效期',
		                renderer:dateFormat,
		                labelSeparator:'',
					    	altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd'
							//dateRange:{begin:'zsbfrq_archivesDo',end:'zszfrq_archivesDo'},//用于vtype类型dateRange   
                		//vtype:'dateRange'
				        })]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
					    id:'zszfrq_archivesDo',
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
					    dateRange:{begin:'zsbfrq_archivesDo',end:'zszfrq_archivesDo'},//用于vtype类型dateRange   
            			vtype:'dateRange'
					})]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jjlxdm_archivesDo",
						name:"jjlxdm",
						fieldLabel:"企业注册类型",
					 	valueField : "jjlxdm",
					    displayField : "jjlxdm",
					    haveShow : false,
					    editable : false,
					    labelSeparator:'',
					    labelSeparator:'',
					    anchor:'97%',
					    onTriggerClick : function() {
					    	window_jjlxQuery_archivesDo.show();
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
                items: [{xtype:'textfield',fieldLabel : '经济类型名称',id:"select_jjlxmc_archivesDo",name : 'jjlx',readOnly:true,labelSeparator:'',hideLabel:true,anchor:'99.9%'}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jjhydm_archivesDo",
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
					    	window_hylxQuery_archivesDo.show();
					    }
					})]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '经济行业名称',id:"select_jjhymc_archivesDo",name : 'jjhymc',readOnly:true,labelSeparator:'',hideLabel:true,anchor:'99.9%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '注册资金(万)',name : 'zczj',id : 'zczj_archivesDo',labelSeparator:'',allowBlank : false,xtype : 'numberfield',maxValue : 2000000000,anchor:'97%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [{xtype : 'combo',
					fieldLabel : '货币种类',
					id : 'hbzl_archivesDo',
					displayField : 'categoryName',//显示值的名称
					hiddenName : 'hbzl',//真正提交时此combo的name
					valueField : 'categoryName',//真正提交时此combo的value
					mode : 'remote',
					store : ds_hbzl_select_archivesDo,
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
							archivesDoViewForm.getForm().findField('hbzldm_archivesDo').setValue(record.data.categoryCode);
						}
					}
				}]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [{	xtype : 'combo',
					fieldLabel : '外方国别',
					id : 'wftzgb_archivesDo',
					displayField : 'categoryName',//显示值的名称
					hiddenName : 'wftzgb',//真正提交时此combo的name
					valueField : 'categoryName',//真正提交时此combo的value
					mode : 'remote',
					store : ds_wftzgb_select_archivesDo,
					selectOnFocus : true,
					anchor:'97%',
					maxLength : 50,
					editable : false,
					allowBlank : true,
					labelSeparator:'',
					triggerAction : 'all',
					loadingText : '加载中...',
					listeners : {
						'select' : function(combo, record, index) {
							archivesDoViewForm.getForm().findField('wftzgbdm_archivesDo').setValue(record.data.categoryCode);
						}
					}
				}]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '外方国别代码',id : 'wftzgbdm_archivesDo',name : 'wftzgbdm',labelSeparator:'',hideLabel:true,allowBlank : true,anchor:'99.5%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [
                	new Ext.form.TriggerField({
						id:"select_zgdm_archivesDo",
						name:"zgdm",
						fieldLabel:"主管部门",
					 	valueField : "zgdm",
					    displayField : "zgdm",
					    maxLength : 9,
					    minLength : 9,
					    anchor:'97%',
						selectOnFocus : true,
					    readOnly:'true',
					    //allowBlank : false,
					    haveShow : false,
					    editable : false,
					    labelSeparator:'',
					    onTriggerClick : function() {
					    	window_zgmcQuery_archivesDo.show();
					    }
				    })]
            },{
                columnWidth:.75,
                layout: 'form',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '主管部门名称',name :'zgmc',labelSeparator:'',id:"select_zgmc_archivesDo",hideLabel:true,readOnly:true,anchor:'99.5%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_pzjgdm_archivesDo",
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
					    	window_pzjgQuery_archivesDo.show();
					    }
				    })]
            },{
                columnWidth:.75,
                layout: 'form',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '批准机构名称',name:'pzjgmc',labelSeparator:'',id:"select_pzjgmc_archivesDo",allowBlank : false,hideLabel:true,anchor:'99.9%'}]
            },{
                columnWidth:1,
                layout: 'form',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '批准文号',name : 'pzwh',id : 'pzwh_archivesDo',labelSeparator:'',allowBlank : true,maxLength : 50,anchor:'100%'}]
            },{
                columnWidth:.45,
                layout: 'form',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '注册号',name : 'zch',id : 'zch_archivesDo',labelSeparator:'',allowBlank : false,maxLength : 50,anchor:'100%',
					enableKeyEvents:true,
			                		listeners: {
			                			keyup: function(f,e){
			                				archivesDoViewForm.findById('zch_arcdo').setText("("+f.getValue().length+")");
			                			}
			                		}
				}]
            },{
				columnWidth : .05,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'zch_arcdo',name:'zch_arcdo',text:'(0)'}]
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
            				archivesDoViewForm.findById('dhhm_arcdo').setText("("+f.getValue().length+")");
            			}
            		}
                }]
            },{
				columnWidth : .05,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'dhhm_arcdo',name:'dhhm_arcdo',text:'(0)'}]
		    },{
                columnWidth:1,
                layout: 'form',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构注册地址',name : 'jgdz',id : 'jgdz_archivesDo',labelSeparator:'',allowBlank : false,maxLength : 100,anchor:'99.9%'}
                ]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [
                	new Ext.form.TriggerField({
						fieldLabel : '行政区划',
						id : 'xzqhCode_archivesDo',
						name : 'xzqhCode',  //接收值的名称
						displayField : 'xzqhCode', //显示值的名称
						valueField : 'xzqhCode',  //真正提交时此combo的value
						maxLength : 50,
						allowBlank : false,
						selectOnFocus : true,
					    haveShow : false,
					    anchor : '98%',
					    labelSeparator:'',
					    editable : false,
					    onTriggerClick : function() {
					    	window_xzqhQuery_archivesDo.show();
					    }
				    })
				]
            },{
                columnWidth:.5,
                layout: 'form',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '行政区划代码',id:'xzqhName_archivesDo',name : 'xzqhName',labelSeparator:'',allowBlank : false,hideLabel:true,maxLength : 50,anchor:'99.9%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '邮政编码',name : 'yzbm',id : 'yzbm_archivesDo',labelSeparator:'',allowBlank : false,minLength : 6,maxLength : 6,anchor:'100%'}]
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
						id : 'xzqhCode_archivesDo2',
						name : 'xzqhCode2',  //接收值的名称
						displayField : 'xzqhCode2', //显示值的名称
						valueField : 'xzqhCode2',  //真正提交时此combo的value
						maxLength : 50,
						selectOnFocus : true,
					    haveShow : false,
					    anchor : '98%',
					    labelSeparator:'',
					    editable : false,
					    onTriggerClick : function() {
					    	window_xzqhQuery_archivesDo2.show();
					    }
				    })
				]
            },{
                columnWidth:.5,
                layout: 'form',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '行政区划代码',id:'xzqhName_archivesDo2',name : 'xzqhName2',labelSeparator:'',hideLabel:true,maxLength : 50,anchor:'99.9%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '邮政编码',name : 'jyyb',id : 'yzbm_archivesDo2',labelSeparator:'',minLength : 6,maxLength : 6,anchor:'100%'}]
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
                items: [{ xtype:'textfield',fieldLabel : '经办人',name : 'tbrxm',id : 'tbrxm_archivesDo',labelSeparator:'',allowBlank : false,maxLength : 50,anchor:'97%'}]
			},
			{
                columnWidth:.15,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{
                		xtype : 'combo',
						fieldLabel : '证件类型',
						id : 'zjlx2_archivesDo',
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
						value:'居民身份证',
						//onTriggerClick : Ext.emptyFn,
						triggerAction : 'all',
						loadingText : '加载中...',
						listeners : {
						'select' : function(combo, record, index) {
							if(record.data.categoryName=='居民身份证'){
								var flag = isIdCardNo(archivesDoViewForm.getForm().findField('tbrsfzh').getValue());
								if(flag != true){
									archivesDoViewForm.getForm().findField('tbrsfzh').focus();
								}
							}else{
								archivesDoViewForm.getForm().findField('tbrsfzh').focus();
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
                	xtype:'textfield',fieldLabel : '证件号码',name : 'tbrsfzh',id : 'tbrsfzh_archivesDo',labelSeparator:'',hideLabel:true,confirmTo:'zjlx2_archivesDo',vtype:'sfzhao',allowBlank : false,maxLength : 50,anchor:'95%',
                	enableKeyEvents: true,
					listeners : {
						keyup: function(f, e){//计数
				    		archivesDoViewForm.findById('ts_archivesDo').setText("("+f.getValue().length+")");
				    	}
					}	
				}]
			},{
				columnWidth : '.03',
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'ts_archivesDo',name:'ts_archivesDo',text:'(0)'}]
			},{
                columnWidth:.2,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ 
                	xtype:'textfield',fieldLabel : '经办人电话',name : 'tbrlxfs',
                	id : 'tbrlxfs_archivesDo',labelSeparator:'',allowBlank : false,
                	maxLength : 50,anchor:'100%'
                	,enableKeyEvents:true,
            		listeners: {
            			keyup: function(f,e){
            				archivesDoViewForm.findById('tbrlxfs_arcdo').setText("("+f.getValue().length+")");
            			}
            		}
                	
                }]
			},{
				columnWidth : .05,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'tbrlxfs_arcdo',name:'tbrlxfs_arcdo',text:'(0)'}]
		    },{
                columnWidth:.33,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
					    id:'bzrq_archivesDo',
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
					    renderer:dateFormat,
					    allowBlank : false,
					    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd' 
					    })
				]
			},{
                columnWidth:.34,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
					    id:'zfrq_archivesDo',
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
					    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd' 
					    })
				]
			},{
                columnWidth:.33,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
					    id:'njqx_archivesDo',
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
					    renderer:dateFormat,
					    allowBlank : false,
					    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd',
					    value:newNjqx
					})
				]
			},{
            	columnWidth:1,
            	layout: 'form',
            	bodyStyle: 'padding:0px',
            	border:false,
            	items: [{xtype:'textfield',fieldLabel : '备注',name : 'memo',labelSeparator:'',maxLength : 50,anchor:'99.9%'},
					{xtype : 'hidden',name : 'orgid',value:''},
					{xtype : 'hidden',name : 'centerid'},
				    {xtype : 'hidden',name : 'docid'},
					{xtype : 'hidden',name : 'imageUrl'},
				    {xtype : 'hidden',id:'hbzldm_archivesDo',name : 'hbzldm',value:'156'},
				    {xtype : 'hidden',id:'select_jjhymcOld_archivesDo',name : 'jjhymcOld'},
				    {xtype : 'hidden',id:'select_jjhydmOld_archivesDo',name : 'jjhydmOld'},
				    {xtype : 'hidden',name : 'bzjgdm',value:currentZzUserBzjgdm},
					{xtype : 'hidden',name : 'lastdate',value :myDate.format('Y-m-d')}, 
					{xtype : 'hidden',name : 'scbzrq',value :myDate.format('Y-m-d')}, 
					{xtype : 'hidden',name : 'lry',value:currentZzUsername},
					{xtype : 'hidden',name : 'state'}]
			}/*
					,
					{xtype:'textfield',fieldLabel : '迁入地址',id:'moveoutAddrss_zad',name : 'moveoutAddrss',maxLength : 100,readOnly:true,anchor:'100%'},
					{xtype:'textfield',fieldLabel : '迁址原因',id:'moveoutReason_zad',name : 'moveoutReason',maxLength : 250,readOnly:true,anchor:'100%'},
					{xtype:'textfield',fieldLabel : '批注注销机构',id:'offPzjgmc_zad',name : 'offPzjgmc',maxLength : 100,readOnly:true,anchor:'100%'},
					{xtype:'textfield',fieldLabel : '批准注销文号',id:'offPzwh_zad',name : 'offPzwh',maxLength : 50,readOnly:true,anchor:'100%'},
					{xtype:'textfield',fieldLabel : '注销原因',id:'offReason_zad',name : 'offReason',maxLength:250,readOnly:true,anchor:'100%'},
					{xtype:'textfield',fieldLabel : '证书回收情况',id:'offNote_zad',name : 'offNote',height:80,maxLength:250,anchor:'100%'}*/]
		}]
});


var  archivesDoViewForm2= new Ext.Panel({
    title       : '基本信息',
    id          : 'jbInfo',
    region      : 'center',
    margins     : '3 0 0 0',
    cmargins    : '5 5 0 0',
	autoScroll : true,
	layout: 'fit',
	bodyStyle: 'padding:0px',
    items : [archivesDoViewForm]
});


var fileFtpForm_archivesDo = new Ext.Panel({
	title:'原文扫描',
	split: true,
	width:620,
	collapsible:true,
	collapsed: false,//是否默认打开
    region:'east',
    margins:'3 0 0 0',
    cmargins:'3 0 0 5',
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"   width=100%  height=100% align=center hspace=0 vspace=0 id="scanner246"  name="scanner246" >'
			       +'<param name="ShowCount" value="1">'
			       +'<param name="sModel" value="1">'
			       +'</OBJECT>'
});


//默认查询 档案
var searchArchivesDo = function() {

	archivesDoViewForm.getForm().reader = Orgnews;
	archivesDoViewForm.getForm().load({
		waitMsg : '正在加载数据请稍后',          //提示信息   
        waitTitle : '提示',                         //标题  
	    url: 'findNetAllOrgnew.action', //请求控制器获取数据
	    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
	    params: { conditions:  text_search_archivesDo.getValue(),stateConditions:'5,12',centerid:currentZzUserBzjgdm,start:1,limit:1},	
	    success:function(form,action) {//获取返回值
	    	
		    	if(action.result.data.orgid!=''){//自动加载原文
		    		var tab345=Ext.getCmp("jbInfo");
		    		tab345.setTitle("基本信息  ("+stateToInfo(archivesDoViewForm.getForm().findField('state').value)+")");	
		    		
		    		if(action.result.data.ywlx=="预赋码"){
						archivesDoViewForm.getForm().findField('select_jglxdm_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('select_jglxmc_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('isxw_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('gk_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('zbsl_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('fbsl_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('fkbz_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('fksl_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('fddbr_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('fddbr_archivesDo').fieldLabel="法定代表人";
						archivesDoViewForm.getForm().findField('zjlx_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('zjhm_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('jyfw_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('zcrq_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('select_jjhydm_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('zgrs_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('zczj_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('jgdz_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('xzqhCode_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('xzqhName_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('yzbm_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('bzrq_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('zfrq_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('njqx_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('tbrxm_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('zjlx2_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('tbrsfzh_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('tbrlxfs_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('zch_archivesDo').allowBlank=true;
						archivesDoViewForm.getForm().findField('pzwh_archivesDo').allowBlank=false;
			    	}else{
			    		archivesDoViewForm.getForm().findField('select_jglxdm_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('select_jglxmc_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('isxw_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('gk_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('zbsl_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('fbsl_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('fkbz_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('fksl_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('fddbr_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('zjlx_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('zjhm_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('jyfw_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('zcrq_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('select_jjhydm_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('zgrs_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('zczj_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('jgdz_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('xzqhCode_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('xzqhName_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('yzbm_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('zch_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('bzrq_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('zfrq_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('njqx_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('tbrxm_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('zjlx2_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('tbrsfzh_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('tbrlxfs_archivesDo').allowBlank=false;
						archivesDoViewForm.getForm().findField('pzwh_archivesDo').allowBlank=true;
			    	}
			    if(action.result.data.isxw==""){
		    		archivesDoViewForm.getForm().findField('isxw_archivesDo').setValue('否');
		    	}
		    	if(action.result.data.gk==""){
		    		archivesDoViewForm.getForm().findField('gk_archivesDo').setValue('是');
		    	}
		    	if(action.result.data.fkbz==""){
		    		archivesDoViewForm.getForm().findField('fkbz_archivesDo').setValue('否');
		    	}
		    	if(action.result.data.fksl==""){
		    		archivesDoViewForm.getForm().findField('fksl_archivesDo').setValue('0');
		    	}
		    	if(action.result.data.zbsl==""){
		    		archivesDoViewForm.getForm().findField('zbsl_archivesDo').setValue('1');
		    	}
	    		//激活相应按钮
				var strState=action.result.data.state
				btn_do_orgnew.setDisabled(false);
				btn_save_menu.setDisabled(false);
				if(strState == 5||strState == 12)
				{
					if(action.result.data.ywlx=="预赋码" || action.result.data.ywlx=="新办"){
						if(action.result.data.jgdm=="" || action.result.data.jgdm==null){
							btn_Code_archivesDo.setDisabled(false);
						}else{
							btn_Code_archivesDo.setDisabled(true);
						}
					}else{
							btn_Code_archivesDo.setDisabled(true);
						}
				}
				//btn_del_archivesDo.setDisabled(strState == 2 ? false:true);
				btn_print_archivesDo.setDisabled(false);
				
				
        		var resultObject = null;
        		
        		var useState=strState;
				var	imgUrl='';
				imgUrl='orgnewViewImg.action';
				
        		Ext.Ajax.request({
					url : imgUrl,
					params : {orgid : action.result.data.orgid},
					success : function(result,request) {//获取返回值 
	   					var resultObject = Ext.util.JSON.decode(result.responseText);  
	   					scanner246.ImageData="";
	   					if(resultObject!=null){
	   						scanner246.OpenProgress(3);  //设置上传的进度条的总进度数
	   						scanner246.Progress('原文加载中',1);
	   						scanner246.Progress('原文加载中',2);
	   						scanner246.ImageData=resultObject.imageData;
	   						if(scanner246.ImageData!=""){
	   							scanner246.PageType=resultObject.pageTypeStr;
	   							scanner246.Progress('原文加载完毕',3);
		   						scanner246.CloseProgress();
	   						}else{
	   							
	   							scanner246.Progress('原文加载失败',3);
		   						scanner246.CloseProgress();
		   						alert("原文错误，加载失败，请重新扫描或导入！");
	   						}
	   						
						}
					},
					failure : function() {
						Ext.Msg.show({
							title : '提示',
							msg : '图像加载错误!',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.ERROR
						});
						//alert("图像加载错误");
					}
				});
	        	
			}else{
				Ext.Msg.show({
					title : '提示',
					msg : '条目不存在!',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.ERROR
				});
                //alert("条目不存在！");
            }
	    },
		failure : function() {
			Ext.Msg.show({
				title : '提示',
				msg : '待办申请单不存在!',
				width:250,
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR
			});
		}	
	});
}

var btn_search_archivesDo = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchArchivesDo();
	}
});

var text_search_archivesDo = new Ext.form.TextField({
	id : 'textSearchArchivesDo',
	name : 'textSearchArchivesDo',
	width : 200,
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchArchivesDo();
			}
		}
	}
});


var btn_print_archivesDo = new Ext.Button({
	text : '打印申请单',
	iconCls : 'icon-print',
	disabled:true,
	handler : function(field){			
		var orgid = archivesDoViewForm.getForm().findField('orgid').value;
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

var btn_print2_archivesDo = new Ext.Button({
	text : '打印迁址证明',
	iconCls : 'icon-print',
	disabled:true,
	handler : function(){

	}
})

var btn_print3_archivesDo = new Ext.Button({
	text : '打印注销单',
	iconCls : 'icon-print',
	disabled:true,
	handler : function(){
		if(archivesDoViewForm.getForm().findField('jgdm').value!=""){
			var tableStr = '<html><head><title>组织机构代码网上办证系统--注销证明打印</title>';
			tableStr = tableStr + '<style>';
			tableStr = tableStr + '.STYLE8 {font-family: "宋体"; font-size: 10.5pt; }.STYLE9 {font-size: 10.5pt; }body {margin-left: 0px;margin-top: 0px;margin-right: 0px;margin-bottom: 0px;background-color: #CCCCCC;}';
			tableStr = tableStr + '.STYLE18 {font-size: 14pt;line-height: 1.5em;}';
			tableStr = tableStr + '.STYLE19 {font-family: "黑体";line-height: 2.5em;	font-size: 16pt;}';
			tableStr = tableStr + '.STYLE20 {font-size: 16pt; }';
			tableStr = tableStr + '</style>';
			tableStr = tableStr + '</head><body><center>';
			tableStr = tableStr + '<table border= "0" width=770 cellpadding= "0" cellspacing= "0"  bgcolor="#FFFFFF">';
			tableStr = tableStr + '  <tr>';
			tableStr = tableStr + '    <td align="center" valign="middle"><br>';
			tableStr = tableStr + '        <center>';
			tableStr = tableStr + '        <table  id="table" style="width:689;border-collapse:collapse; " cellpadding= "0" cellspacing= "0"  border="0" >';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="54" colspan="5" align="center" class="STYLE18 STYLE19">组织机构代码注销证明</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '        </table>';
			tableStr = tableStr + '      <table id="table4" style="width:689;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "1" bordercolor= "#3366FF">';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td width="140" height="40"  align="center" class="STYLE8"> 机构代码</td>';
			tableStr = tableStr + '            <td colspan="5"  align="center">'+archivesDoViewForm.getForm().findField('jgdm').value+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '           <td width="140" height="40" align="center" class="STYLE8">机构名称</td>';
			tableStr = tableStr + '            <td colspan="5"  align="center">'+archivesDoViewForm.getForm().findField('jgmc').value+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40" align="center" class="STYLE8"> 注销核准机关</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+archivesDoViewForm.getForm().findField('offPzjgmc').value+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40"  align="center" class="STYLE8">注销核准文号</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+archivesDoViewForm.getForm().findField('offPzwh').value+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40"  align="center" class="STYLE8">注销原因</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+archivesDoViewForm.getForm().findField('offReason').value+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '         <tr>';
			tableStr = tableStr + '            <td height="40" align="center" class="STYLE8">证书回收情况</span></td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+archivesDoViewForm.getForm().findField('offNote').value+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="63" class="STYLE8"  align="center">经办人</td>';
			tableStr = tableStr + '            <td width="125" align="center">'+archivesDoViewForm.getForm().findField('tbrxm').value+'</td>';
			tableStr = tableStr + '            <td width="60" height="63" align="center" class="STYLE8">身份证件号码</td>';
			tableStr = tableStr + '            <td width="177" height="63" class="STYLE8" align="center">'+archivesDoViewForm.getForm().findField('tbrsfzh').value+'</td>';
			tableStr = tableStr + '            <td width="46" height="63" align="center" class="STYLE9">联系<br>';
			tableStr = tableStr + '            电话</td>';
			tableStr = tableStr + '            <td width="127" height="63" class="STYLE9" align="center">'+archivesDoViewForm.getForm().findField('tbrlxfs').value+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40" class="STYLE9" div align="center">受理人</td>';
			tableStr = tableStr + '            <td colspan="2"  align="center">'+currentZzUser+'</td>';
			tableStr = tableStr + '            <td  class="STYLE9" align="center">办理日期</td>';
			tableStr = tableStr + '            <td colspan="2"  align="center">'+myDate.format('Y-m-d')+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="60" class="STYLE9" div align="center">代码管理机构</td>';
			tableStr = tableStr + '            <td colspan="5" align="right">（签章）&nbsp;&nbsp;&nbsp;&nbsp; </td>';
			tableStr = tableStr + '        </table>';
			tableStr = tableStr + '      <p>&nbsp;</p>';
			tableStr = tableStr + '      <p>&nbsp;</p>';
			tableStr = tableStr + '      <p><br>';
			tableStr = tableStr + '      </p></td>';
			tableStr = tableStr + '  </tr>';
			tableStr = tableStr + '</table>';
			tableStr = tableStr + '<br>';
			tableStr = tableStr + '<table border= "0" width=770 cellpadding= "0" cellspacing= "0"  bgcolor="#FFFFFF">';
			tableStr = tableStr + '  <tr>';
			tableStr = tableStr + '    <td align="center" valign="middle"><br>';
			tableStr = tableStr + '        <center>';
			tableStr = tableStr + '        <table  id="table" style="width:689;border-collapse:collapse; " cellpadding= "0" cellspacing= "0"  border="0" >';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="54" colspan="5" align="center" class="STYLE18 STYLE19">迁&nbsp;址&nbsp;证&nbsp;明</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '        </table>';
			tableStr = tableStr + '      <table id="table4" style="width:689;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "1" bordercolor= "#3366FF">';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td width="140" height="40"  align="center" class="STYLE8"> 机构代码</td>';
			tableStr = tableStr + '            <td colspan="5"  align="center">'+archivesDoViewForm.getForm().findField('jgdm').value+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '           <td width="140" height="40" align="center" class="STYLE8">机构名称</td>';
			tableStr = tableStr + '            <td colspan="5"  align="center">'+archivesDoViewForm.getForm().findField('jgmc').value+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40" align="center" class="STYLE8"> 注销核准机关</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+archivesDoViewForm.getForm().findField('offPzjgmc').value+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40"  align="center" class="STYLE8">注销核准文号</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+archivesDoViewForm.getForm().findField('offPzwh').value+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40"  align="center" class="STYLE8">注销原因</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+archivesDoViewForm.getForm().findField('offReason').value+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '         <tr>';
			tableStr = tableStr + '            <td height="40" align="center" class="STYLE8">证书回收情况</span></td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+archivesDoViewForm.getForm().findField('offNote').value+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="63" class="STYLE8"  align="center">经办人</td>';
			tableStr = tableStr + '            <td width="125" align="center">'+archivesDoViewForm.getForm().findField('tbrxm').value+'</td>';
			tableStr = tableStr + '            <td width="60" height="63" align="center" class="STYLE8">身份证件号码</td>';
			tableStr = tableStr + '            <td width="177" height="63" class="STYLE8" align="center">'+archivesDoViewForm.getForm().findField('tbrsfzh').value+'</td>';
			tableStr = tableStr + '            <td width="46" height="63" align="center" class="STYLE9">联系<br>';
			tableStr = tableStr + '            电话</td>';
			tableStr = tableStr + '            <td width="127" height="63" class="STYLE9" align="center">'+archivesDoViewForm.getForm().findField('tbrlxfs').value+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40" class="STYLE9" div align="center">受理人</td>';
			tableStr = tableStr + '            <td colspan="2"  align="center">'+currentZzUser+'</td>';
			tableStr = tableStr + '            <td  class="STYLE9" align="center">办理日期</td>';
			tableStr = tableStr + '            <td colspan="2"  align="center">'+myDate.format('Y-m-d')+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="60" class="STYLE9" div align="center">代码管理机构</td>';
			tableStr = tableStr + '            <td colspan="5" align="right">（签章）&nbsp;&nbsp;&nbsp;&nbsp; </td>';
			tableStr = tableStr + '        </table>';
			tableStr = tableStr + '      <p>&nbsp;</p>';
			tableStr = tableStr + '      <p>&nbsp;</p>';
			tableStr = tableStr + '      <p><br>';
			tableStr = tableStr + '      </p></td>';
			tableStr = tableStr + '  </tr>';
			tableStr = tableStr + '</table>';
			
			tableStr = tableStr + '</center></body></html>';
			 
			var titleHTML = tableStr;// document.getElementById("printGridfff").innerHTML;     
			var newwin = window.open('printer.jsp', 'printWindow', 'menubar=yes,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no,titlebar=yes,z-look=yes,menubar=yes');     
			  
			newwin.document.write(titleHTML);     
			//newwin.document.location.reload();     
			//newwin.print();     
			//newwin.close();     
		}
	}
});

var btn_refresh_archivesDo = new Ext.Button({
	text : '重置',
	iconCls : 'icon-refresh',
	handler : function() {
		btn_del_archivesDo.setDisabled(true);
    	btn_print_archivesDo.setDisabled(true);
    	btn_Code_archivesDo.setDisabled(true);
		archivesDoViewForm.getForm().reset();
		
		var tab3452=Ext.getCmp("jbInfo");
	    tab3452.setTitle("基本信息");
		scanner246.ImageData="";
		scanner246.CloseProgress();
		archivesDoViewForm.getForm().findField('orgid').setValue('');
		//this.ownerCt.form.reset();;
	}
});


var btn_del_archivesDo = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	disabled:true,
	handler : function() {
		var orgid = archivesDoViewForm.getForm().findField('orgid').value;
		if(orgid!=null || orgid!=""){
			Ext.Msg.confirm('确认删除', '你确定删除该件工单?', function(btn) {
				if (btn == 'yes') {
					ajaxLoadMask.show();
					Ext.Ajax.request({
						url : 'deleteOrgnew.action',
						params : {orgid : orgid},
						success : function() {
							ajaxLoadMask.hide();
							Ext.Msg.show({
								title : '提示',
								msg : '删除成功!',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR
							});
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

//---------------------- 开始赋码 ------------------------------------

var archivesDoFumaForm = new Ext.FormPanel({
	url : 'saveOrgnewCode.action',
	labelAlign : 'right',
	labelWidth : 80,
	bodyStyle : 'padding:5px',
	border : false,
	baseCls : 'x-plain',
	defaultType : 'combo',
	defaults : {anchor:'95%'},
	items : [
		{xtype : 'textfield',fieldLabel : '机构代码',name : 'jgdm',allowBlank:false,readOnly:true},
		{xtype : 'hidden',name : 'orgid'},
		{xtype : 'hidden',name : 'centerid'},
		{xtype : 'hidden',name : 'docid'},
		{xtype : 'textfield',fieldLabel : '机构名称',name : 'jgmc',allowBlank:false,readOnly:true},
		{xtype : 'textfield',fieldLabel : '机构地址',name : 'jgdz',allowBlank:false,readOnly:true},
			{xtype : 'textfield',fieldLabel : '注册号',name : 'zch',allowBlank:false,readOnly:true},
		{xtype : 'combo',
			fieldLabel : '是否个体',
			id : 'dmlx_archivesDo',
			name : 'dmlx',
			displayField : 'dmlx',
			valueField : 'dmlxCode',
			hiddenName : 'dmlxCode',
			store : dmlxStore,
			triggerAction : 'all',
			lazyRender:true,
			mode : 'local',
			selectOnFocus : true,
			allowBlank:false,
			editable : false
		}
	],
	buttonAlign : 'right',
	minButtonWidth : 60,
	buttons : [{
		text:'取码',
		id:'btn_qm_archivesDo',
		handler : function(btn){
			
			if(archivesDoFumaForm.getForm().findField('dmlx_archivesDo').getValue()!=""){
				var record = grid_code_creat_archivesDo.getSelectionModel().getSelected(); 
				
				btn.setText('取码');
				ds_code_creat_archivesDo.removeAll();
				//给store为ds_code_select传params参数值，类似与returnOrgnewCode.action?orgid=111&jgmc=sss&zch=123&centerid=100000
				if(archivesDoViewForm.getForm().findField('ywlx').getValue()=="预赋码" && archivesDoViewForm.getForm().findField('pzwh').getValue()!==""){
					ds_code_creat_archivesDo.baseParams.zch = archivesDoViewForm.getForm().findField('pzwh').getValue();
				}else{
					ds_code_creat_archivesDo.baseParams.zch = archivesDoViewForm.getForm().findField('zch').getValue();
				}
				ds_code_creat_archivesDo.baseParams.orgid = archivesDoViewForm.getForm().findField('orgid').getValue();
				ds_code_creat_archivesDo.baseParams.state = archivesDoViewForm.getForm().findField('state').getValue();
				ds_code_creat_archivesDo.baseParams.jgmc = archivesDoViewForm.getForm().findField('jgmc').getValue();
				ds_code_creat_archivesDo.baseParams.jgdz = archivesDoViewForm.getForm().findField('jgdz').getValue();
				ds_code_creat_archivesDo.baseParams.centerid=archivesDoViewForm.getForm().findField('centerid').getValue();
				ds_code_creat_archivesDo.baseParams.dmlx=archivesDoFumaForm.getForm().findField('dmlx_archivesDo').getValue();//0 个体，3非个体
				if(record!=null && record.data.flag=='1'){
					ds_code_creat_archivesDo.baseParams.flag='1';//0需判断，1不需判断
				}else{
					ds_code_creat_archivesDo.baseParams.flag='0';//0需判断，1不需判断
				}
				ds_code_creat_archivesDo.load({
					callback: function(records, options, success){
						if(records!=null){
							if(records[0].data.flag=='1'|| records[0].data.flag=='3'){
								btn.setText('重新取码');
							}else if(records[0].data.flag=='0'){
								xinbanFumaForm.getForm().findField('jgdm').setValue(records[0].data.jgdm);
								btn.disable();
								
								var btnTrueADfuma=Ext.getCmp("btn_true_adofuma");
								btnTrueADfuma.enable();
								var btnFalseADfuma=Ext.getCmp("btn_false_adofuma");
								btnFalseADfuma.disable();
							}else{
								btn.disable();
								var btnTrueADfuma=Ext.getCmp("btn_true_adofuma");
								btnTrueADfuma.disable();
								var btnFalseADfuma=Ext.getCmp("btn_false_adofuma");
								btnFalseADfuma.enable();
							}
						}
					}
				});
			}else{
				alert("请选择“是否个体” ！");
			}
		}
	},{
		text:'保存',
		id : 'btn_true_adofuma',
		handler : function(btn){
			if(archivesDoFumaForm.getForm().isValid()){
				archivesDoFumaForm.getForm().submit({
					waitTitle : '请稍候',
					waitMsg : '正在修改数据,请稍候...',
					success : function(form) {
						archivesDoViewForm.getForm().findField('jgdm').setValue(archivesDoFumaForm.getForm().findField('jgdm').getValue());
						ds_code_creat_archivesDo.removeAll();
						window_fuma_archivesDo.hide();
						var tab34529034=Ext.getCmp("jbInfo");
					    tab34529034.setTitle("基本信息(赋码成功，请提交确认)");
					    btn_Code_archivesDo.setDisabled(true);
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
			}
		}
	},{
		text : '取消',
		id : 'btn_false_adofuma',
		handler:function(){
			archivesDoFumaForm.getForm().reset();
			ds_code_creat_archivesDo.removeAll();
			var btn3452976=Ext.getCmp("btn_qm_archivesDo");
			 btn3452976.setText("取码");
			 btn3452976.enable();
			this.ownerCt.ownerCt.ownerCt.hide();
		}
	}]
});

//信息浏览
var  archivesDoCODE= new Ext.Panel({
    region      : 'center',
    margins   : '3 3 0 3', 
    activeTab : 1,
    items : [archivesDoFumaForm]
}); 


var ds_code_creat_archivesDo=new Ext.data.Store({
	url : 'returnOrgnewCode.action',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [
		{name : 'jgdm',type : 'string'},{name : 'jgmc',type : 'string'},
		{name : 'zch',type : 'string'},{name : 'flag',type : 'string'},
		{name : 'info',type : 'string'}])
})

var cm_code_creat_archivesDo = new Ext.grid.ColumnModel([
   {header : '机构代码',width:80,dataIndex : 'jgdm',sortable : true}, 
   {header : '机构名称',width:160,dataIndex : 'jgmc',id:'jgmc_archivesDo_code',sortable : true}, 
   {header : '注册号',width:160,dataIndex : 'zch',sortable : true},
   {header : '备注',width:140,dataIndex : 'flag',renderer : goStateFlag,sortable : true},
   {header : '信息',width:20,dataIndex : 'info',hidden:true,sortable : true}
]);

archivesDoCodeListPanel = Ext.extend(Ext.grid.GridPanel,{
	constructor:function(){
		archivesDoCodeListPanel.superclass.constructor.call(this,grid_code_creat_archivesDo);
	}
});


var grid_code_creat_archivesDo = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_code_creat_archivesDo,
	ds : ds_code_creat_archivesDo,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'jgmc_archivesDo_code'/*,
	listeners : {
		'rowclick':function(grid,rowIndex){
			var btn3452912=Ext.getCmp("btn_qm_archivesDo");
			if(grid.getStore().getAt(rowIndex).data.flag=='1' || grid.getStore().getAt(rowIndex).data.flag=='3'){
				archivesDoFumaForm.getForm().findField('jgdm').setValue(grid.getStore().getAt(rowIndex).data.jgdm);
			 	btn3452912.disable();
    		}else{
    			if(grid.getStore().getAt(rowIndex).data.flag=='4'){
			 		btn3452912.setText("重新取码");
    			}
    		}
		}
	}*/
});
	
var window_fuma_archivesDo = new Ext.Window({
	title : '机构赋码',
	iconCls : 'icon-plugin',
	width : 550,
	height : 400,
	x:'250',
	y:'120',
	resizable : true,
	modal : true,
	plain    : true,
	layout   : 'border',
	closable : false,
	closeAction : 'close',
	listeners : {
		/*'hide' : function(){
			archivesDoFumaForm.getForm().reset();
			var btn34529678122=Ext.getCmp("btn_qm_archivesDo");
			btn34529678122.setText("取码");
			btn34529678122.disable();
		}*/
		'show' : function(){
			archivesDoFumaForm.getForm().reset();
			var btnADfuma=Ext.getCmp("btn_qm_archivesDo");
			btnADfuma.enable();
			var btnTrueADfuma=Ext.getCmp("btn_true_adofuma");
			btnTrueADfuma.disable();
			var btnFalseADfuma=Ext.getCmp("btn_false_adofuma");
			btnFalseADfuma.enable();
		}
	},
	items:[archivesDoCODE,{
	    region: 'south',
	    layout :'fit',
		title : '编码列表',
	    height: 170,
	    minSize: 100,
	    border : false,
	    maxSize: 250,
	    //北,东，南，西
	    margins     : '0 3 3 3',
    	cmargins    : '5 0 0 0',
	    items : [new archivesDoCodeListPanel()]
	}]
});

var btn_Code_archivesDo = new Ext.Button({
	text : '赋码',
	iconCls : 'icon-add',
	disabled:true,
	handler : function(){
		window_fuma_archivesDo.show();
		archivesDoFumaForm.getForm().findField('orgid').setValue(archivesDoViewForm.getForm().findField('orgid').getValue());
		archivesDoFumaForm.getForm().findField('jgmc').setValue(archivesDoViewForm.getForm().findField('jgmc').getValue());
		archivesDoFumaForm.getForm().findField('jgdz').setValue(archivesDoViewForm.getForm().findField('jgdz').getValue());
		if(archivesDoViewForm.getForm().findField('ywlx').getValue()=="预赋码"){
			archivesDoFumaForm.getForm().findField('zch').setValue(archivesDoViewForm.getForm().findField('pzwh').getValue());
		}else{
			archivesDoFumaForm.getForm().findField('zch').setValue(archivesDoViewForm.getForm().findField('zch').getValue());
		}
		archivesDoFumaForm.getForm().findField('centerid').setValue(archivesDoViewForm.getForm().findField('centerid').getValue());
	}
});
//------------------------------------------------------------------------

var btn_save_menu = new Ext.Toolbar.MenuButton({
    text: '保存',
    handler: btn_saveAll,
    tooltip: {title:'保存数据和原文',text:'保存'},
    iconCls: 'blist',
    disabled:true,
    menu : {items: [
                {text: '全部保存', handler: btn_saveAll}, '-',
                {text: '仅保存数据', handler: btn_saveInfo},
                {text: '仅上传原文', handler: btn_ftpFile}
        ]}
});

function btn_saveAll(btn){
	if (archivesDoViewForm.getForm().isValid()) {
		btn.disable();
		archivesDoViewForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在修改数据,请稍候...',
			success : function(form) {
				
				btn_ok_archivesDo.setDisabled(false);
			
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
				var strDocid;
				var strBzjgdm;
				
				btn.disable();
				strOrgid = archivesDoViewForm.getForm().findField('orgid').value;  //参数orgid
				strDocid=archivesDoViewForm.getForm().findField('docid').value;  //参数docid
				strBzjgdm=archivesDoViewForm.getForm().findField('bzjgdm').value; 
				
				if(strOrgid!=""){	
					packLength = 40960;	//定义每个包的大小40960
					//scanner246.ImageData=document.getElementById("ImageData").value;
					base64file = scanner246.ImageData;  //获取控件扫描的图片数据
					var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
					imageCount = scanner246.GetPageCount;	//获取扫描图片的页数
					pageTypeStr = scanner246.PageType;    //获取标识字符串,需要写数据库
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
					scanner246.OpenProgress(packCount);  //设置上传的进度条的总进度数
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
								scanner246.Progress('上传中',i+1);
							}
							else
							{
								alert("上传失败，请重试0001。");
								//scanner246.ShowSendMsg(false);
								btn.enable();
								return false;
							}
						}
						catch(e)
						{
							//alert(e.description+'|'+e.name+'|'+e.number);
							alert("上传失败，请重试0002。");
							btn.enable();
							return false;
						}
					}
					
					Ext.Msg.show({
						title : '提示',
						msg : '['+archivesDoViewForm.getForm().findField('jgmc').value+'] 保存成功',
						buttons : Ext.Msg.OK,
						fn : function() {
							btn.enable();btn_ok_archivesDo.setDisabled(false);
							if(sysNetWorkMode=='0'){
								btn_Code_archivesDo.setDisabled(false);
							}
						},
						icon : Ext.Msg.INFO
					});

					scanner246.CloseProgress();
					return true;
				}else{
					alert("请录入数据后，再上传原文！");
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

function btn_saveInfo(btn){
	if (archivesDoViewForm.getForm().isValid()) {
		btn.disable();
		archivesDoViewForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在修改数据,请稍候...',
			success : function(form) {
				Ext.Msg.show({
					title : '提示',
					msg : '['+archivesDoViewForm.getForm().findField('jgmc').value+'] 信息保存成功',
					buttons : Ext.Msg.OK,
					fn : function() {
						btn.enable();btn_ok_archivesDo.setDisabled(false);
						if(sysNetWorkMode=='0'){
							btn_Code_archivesDo.setDisabled(false);
						}
					},
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

function btn_ftpFile(btn){
	
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
	var strDocid;
	var strBzjgdm;
	
	
	btn.disable();
	strOrgid = archivesDoViewForm.getForm().findField('orgid').value;  //参数orgid
	strDocid =archivesDoViewForm.getForm().findField('docid').value;  //参数docid
	strBzjgdm=archivesDoViewForm.getForm().findField('bzjgdm').value;  //办证机构代码
	
	//alert("strOrgid="+strOrgid);
	if(strOrgid!=""){
		packLength = 40960;	//定义每个包的大小40960
		//scanner246.ImageData=document.getElementById("ImageData").value;
		base64file = scanner246.ImageData;  //获取控件扫描的图片数据
		var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
		imageCount = scanner246.GetPageCount;	//获取扫描图片的页数
		pageTypeStr = scanner246.PageType;    //获取标识字符串,需要写数据库
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
		scanner246.OpenProgress(packCount);  //设置上传的进度条的总进度数
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
					scanner246.Progress('上传中',i+1);
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
		scanner246.CloseProgress();
		Ext.Msg.show({
			title : '提示',
			msg : '['+archivesDoViewForm.getForm().findField('jgmc').value+'] 原文上传成功',
			buttons : Ext.Msg.OK,
			fn : function() {btn.enable();btn_ok_archivesDo.setDisabled(false);},
			icon : Ext.Msg.INFO
		});

		return true;
	}else{
		alert("请录入数据后，再上传原文！");
	}
}


var btn_ok_archivesDo = new Ext.Button({
	text : '办理确认',
	iconCls : 'icon-store',
	disabled:true,
	handler : function(){
		var orgid = archivesDoViewForm.getForm().findField('orgid').value;
		var strJgdm = archivesDoViewForm.getForm().findField('jgdm').value;
		var strState = archivesDoViewForm.getForm().findField('state').value;
		var jgmc = archivesDoViewForm.getForm().findField('jgmc').value;
		var strYwlx = archivesDoViewForm.getForm().findField('ywlx').value;
		if(orgid!=null || orgid!=""){
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
						icon : Ext.Msg.INFO,
						fn : function(){
							btn_Code_archivesDo.setDisabled(true);
		   					btn_ok_archivesDo.setDisabled(true);
		   					btn_print_archivesDo.setDisabled(true);
		   					btn_print2_archivesDo.setDisabled(true);
		   					btn_print3_archivesDo.setDisabled(true);
		   					var tab345=Ext.getCmp("jbInfo");
				    		tab345.setTitle("基本信息");	
							archivesDoViewForm.getForm().reset();
							scanner246.PageType="";
							scanner246.ImageData="";
							text_search_archivesDo.setValue("");
						}
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
	}
});


var p_zzArchivesDo = {
	id : 'zzArchivesDo-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:0px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    bodyBorder: false,
	    title: '现场办理',
	    iconCls : 'icon-plugin',
 		plain: true,
		region: 'center',
		tbar : [btn_Code_archivesDo,'-',btn_print_archivesDo,btn_print2_archivesDo,btn_print3_archivesDo,'-',btn_refresh_archivesDo,btn_save_menu,btn_ok_archivesDo,'->',text_search_archivesDo,btn_search_archivesDo],
		items: [archivesDoViewForm2,fileFtpForm_archivesDo]
	}]
}