var searchXzqh_biangen2 = function() {
	ds_xzqh_biangen2.baseParams.conditions = text_search_xzqh_biangen2.getValue();
	ds_xzqh_biangen2.baseParams.username='';
	ds_xzqh_biangen2.baseParams.stateConditions='';
	ds_xzqh_biangen2.load({params : {start : 0,limit : 20} });
}

var btn_search_xzqh_biangen2 = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchXzqh_biangen2();
	}
});

var text_search_xzqh_biangen2 = new Ext.form.TextField({
	id : 'textSearchXzqh_biangen2',
	name : 'textSearchXzqh_biangen2',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchXzqh_biangen2();
			}
		},
		'change' : function(field, e) {
			searchXzqh_biangen2();
			//btn_search_xzqh_biangen.setDisabled(false);
		}
	}
});

var cm_xzqh_biangen2 = new Ext.grid.ColumnModel([
	{header : '行政区划名称',width : 50,dataIndex : 'xzqhName',sortable : true},
	{header : '行政区划代码',width : 20,dataIndex : 'xzqhCode',sortable : true}
]);

var ds_xzqh_biangen2 = new Ext.data.Store({
	url : 'findAllByConditionXzqh.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'xzqhCode',type : 'string'},
			{name : 'xzqhName',type : 'string'},
			{name : 'xzqhNote',type : 'string'}
		])
});
var grid_xzqh_biangen2 = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_xzqh_biangen2,
	ds : ds_xzqh_biangen2,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入行政区划名称：',text_search_xzqh_biangen2,btn_search_xzqh_biangen2],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_xzqh_biangen2,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_xzqhQuery_biangen2.hide();
			var selections=grid.getSelectionModel().getSelections();
			biangenViewForm.getForm().findField('xzqhName_biangen2').setValue(selections[0].get('xzqhName'));
			biangenViewForm.getForm().findField('xzqhCode_biangen2').setValue(selections[0].get('xzqhCode'));
		}
	}
});

var window_xzqhQuery_biangen2 = new Ext.Window({
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
	items : [grid_xzqh_biangen2]
});
//行政区划的到此结束

var searchXzqh_biangen = function() {
	ds_xzqh_biangen.baseParams.conditions = text_search_xzqh_biangen.getValue();
	ds_xzqh_biangen.baseParams.username='';
	ds_xzqh_biangen.baseParams.stateConditions='';
	ds_xzqh_biangen.load({params : {start : 0,limit : 20} });
}

var btn_search_xzqh_biangen = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchXzqh_biangen();
	}
});

var text_search_xzqh_biangen = new Ext.form.TextField({
	id : 'textSearchXzqh_biangen',
	name : 'textSearchXzqh_biangen',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchXzqh_biangen();
			}
		},
		'change' : function(field, e) {
			searchXzqh_biangen();
			//btn_search_xzqh_biangen.setDisabled(false);
		}
	}
});

var cm_xzqh_biangen = new Ext.grid.ColumnModel([
	{header : '行政区划名称',width : 50,dataIndex : 'xzqhName',sortable : true},
	{header : '行政区划代码',width : 20,dataIndex : 'xzqhCode',sortable : true}
]);

var ds_xzqh_biangen = new Ext.data.Store({
	url : 'findAllByConditionXzqh.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'xzqhCode',type : 'string'},
			{name : 'xzqhName',type : 'string'},
			{name : 'xzqhNote',type : 'string'}
		])
});
var grid_xzqh_biangen = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_xzqh_biangen,
	ds : ds_xzqh_biangen,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入行政区划名称：',text_search_xzqh_biangen,btn_search_xzqh_biangen],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_xzqh_biangen,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_xzqhQuery_biangen.hide();
			var selections=grid.getSelectionModel().getSelections();
			biangenViewForm.getForm().findField('xzqhName_biangen').setValue(selections[0].get('xzqhName'));
			biangenViewForm.getForm().findField('xzqhCode_biangen').setValue(selections[0].get('xzqhCode'));
		}
	}
});

var window_xzqhQuery_biangen = new Ext.Window({
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
	items : [grid_xzqh_biangen]
});
//行政区划的到此结束

var btn_search_pzjg_bg = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchPzjg_bg();
		//btn_search_pzjg_bg.setDisabled(true);
	}
});


var text_search_pzjg_bg = new Ext.form.TextField({
	id : 'textSearchPzjg_bg',
	name : 'textSearchPzjg_bg',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchPzjg_bg();
			}
		},
		'change' : function(field, e) {
			btn_search_pzjg_bg.setDisabled(false);
		}
	}
});


var cm_pzjg_bg = new Ext.grid.ColumnModel([
	{header : '批准机构名称',width : 50,dataIndex : 'pzjgmc',sortable : true}, 
	{header : '批准机构代码',width : 20,dataIndex : 'pzjgdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_pzjg_bg = new Ext.data.Store({
	url : 'findAllByConditionPzjg.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'pzjgid',type : 'int'}, 
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchPzjg_bg = function() {
	ds_pzjg_bg.baseParams.conditions = text_search_pzjg_bg.getValue();
	ds_pzjg_bg.baseParams.username='';
	ds_pzjg_bg.baseParams.stateConditions='';
	ds_pzjg_bg.load({params : {start : 0,limit : 20} });
}

var grid_pzjg_bg = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_pzjg_bg,
	ds : ds_pzjg_bg,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入登记批准机构名称：',text_search_pzjg_bg,btn_search_pzjg_bg],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_pzjg_bg,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_pzjgQuery_bg.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			biangenViewForm.getForm().findField('select_pzjgmc_biangen').setValue(selections[0].get('pzjgmc'));
			biangenViewForm.getForm().findField('select_pzjgdm_biangen').setValue(selections[0].get('pzjgdm'));
		}
	}
});


var window_pzjgQuery_bg = new Ext.Window({
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
	items : [grid_pzjg_bg]
});


var btn_search_jglxSelcet_bg = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJglxSelcet_bg();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_jglxSelcet_bg = new Ext.form.TextField({
	id : 'textsearchJglxSelcet_bg',
	name : 'textsearchJglxSelcet_bg',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJglxSelcet_bg();
			}
		},
		'change' : function(field, e) {
			btn_search_jglxSelcet_bg.setDisabled(false);
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
var ds_jglxSelcet_bg = new Ext.data.Store({
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

var ds_hbzl_select_bg = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=1',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});

var searchJglxSelcet_bg = function() {
	ds_jglxSelcet_bg.baseParams.conditions = text_search_jglxSelcet_bg.getValue();
	ds_jglxSelcet_bg.baseParams.username="";
	ds_jglxSelcet_bg.baseParams.stateConditions='';
	ds_jglxSelcet_bg.load({params : {start : 0,limit : 20} });
}

var searchJglxSelcet2_bg = function() {
	ds_jglxSelcet_bg.baseParams.conditions = biangenViewForm.getForm().findField('select_jglxdm_biangen').getValue();
	ds_jglxSelcet_bg.baseParams.username="";
	ds_jglxSelcet_bg.baseParams.stateConditions='';
	ds_jglxSelcet_bg.load({params : {start : 0,limit : 20} });
}

var grid_jglx_biangen = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jglxSelcet2,
	ds : ds_jglxSelcet_bg,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入机构类型名称：',text_search_jglxSelcet_bg,btn_search_jglxSelcet_bg],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jglxSelcet_bg,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jglxQuery_biangen.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			biangenViewForm.getForm().findField('select_jglxmc_biangen').setValue(selections[0].get('jglxmc'));
			biangenViewForm.getForm().findField('select_jglxdm_biangen').setValue(selections[0].get('jglxdm'));
		
			if(selections[0].get('pjglxdm')==1){
				biangenViewForm.getForm().findField('select_jjlxmc_biangen').allowBlank=false;
				biangenViewForm.getForm().findField('select_jjlxdm_biangen').allowBlank=false;
			}else{
				biangenViewForm.getForm().findField('select_jjlxmc_biangen').allowBlank=true;
				biangenViewForm.getForm().findField('select_jjlxdm_biangen').allowBlank=true;
			}
		}
	}
});


var window_jglxQuery_biangen = new Ext.Window({
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
	items : [grid_jglx_biangen]
});


var btn_search_hylxSelcet_bg = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchHylxSelcet_bg();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_hylxSelcet_bg = new Ext.form.TextField({
	id : 'textSearchHylxSelcet_bg',
	name : 'textSearchHylxSelcet_bg',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchHylxSelcet_bg();
			}
		},
		'change' : function(field, e) {
			btn_search_hylxSelcet_bg.setDisabled(false);
		}
	}
});

var ds_wftzgb_select_bg = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=3',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});

var cm_hylxSelcet_bg = new Ext.grid.ColumnModel([
	{header : '大类',width : 100,dataIndex : 'hylxmc1',sortable : true}, 
	{header : '中类',width : 100,dataIndex : 'hylxmc2',sortable : true}, 
	{header : '小类',width : 100,dataIndex : 'hylxmc3',sortable : true}, 
   {header : '经济行业名称',width : 100,dataIndex : 'hylxmc',sortable : true},
	{header : '经济行业代码',width : 30,dataIndex : 'hylxdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_hylxSelcet_bg = new Ext.data.Store({
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

var searchHylxSelcet_bg = function() {
	ds_hylxSelcet_bg.baseParams.conditions = text_search_hylxSelcet_bg.getValue();
	ds_hylxSelcet_bg.baseParams.username="";
	ds_hylxSelcet_bg.baseParams.stateConditions='';
	ds_hylxSelcet_bg.load({params : {start : 0,limit : 20} });
}

var grid_hylx_biangen = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_hylxSelcet_bg,
	ds : ds_hylxSelcet_bg,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入经济行业代码名称：',text_search_hylxSelcet_bg,btn_search_hylxSelcet_bg],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_hylxSelcet_bg,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_hylxQuery_biangen.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			biangenViewForm.getForm().findField('select_jjhymc_biangen').setValue(selections[0].get('hylxmc'));
			biangenViewForm.getForm().findField('select_jjhydm_biangen').setValue(selections[0].get('hylxdm'));
			biangenViewForm.getForm().findField('select_jjhymcOld_biangen').setValue(selections[0].get('hylxmcOld'));
			biangenViewForm.getForm().findField('select_jjhydmOld_biangen').setValue(selections[0].get('hylxdmOld'));
		}
	}
});


var window_hylxQuery_biangen = new Ext.Window({
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
	items : [grid_hylx_biangen]
});


var btn_search_jjlx_biangen = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJjlx_biangen();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_jjlx_biangen = new Ext.form.TextField({
	id : 'textSearchJjlx_biangen',
	name : 'textSearchJjlx_biangen',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJjlx_biangen();
			}
		},
		'change' : function(field, e) {
			btn_search_jjlx_biangen.setDisabled(false);
		}
	}
});


var cm_jjlx_biangen = new Ext.grid.ColumnModel([
    {header : '大类',width : 30,dataIndex : 'pjjlxmc',sortable : true}, 
    {header : '中类',width : 30,dataIndex : 'pjjlxmc2',sortable : true}, 
    {header : '小类',width : 30,dataIndex : 'pjjlxmc3',sortable : true}, 
	{header : '经济类型名称',width : 100,dataIndex : 'jjlxmc',sortable : true}, 
	{header : '经济类型代码',width : 30,dataIndex : 'jjlxdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_jjlx_biangen = new Ext.data.Store({
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


var jglxStore_bg = new Ext.data.Store({
	url : 'findAllByConditionJjlx.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'jjlxmc',type : 'string'},
		{name : 'jjlxdm',type : 'string'}
	])
});


var searchJjlx_biangen = function() {
	ds_jjlx_biangen.baseParams.conditions = text_search_jjlx_biangen.getValue();
	ds_jjlx_biangen.baseParams.username='';
	ds_jjlx_biangen.baseParams.stateConditions='';
	ds_jjlx_biangen.load({params : {start : 0,limit : 20} });
}

var grid_jjlx_biangen = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jjlx_biangen,
	ds : ds_jjlx_biangen,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入企业登记注册类型名称：',text_search_jjlx_biangen,btn_search_jjlx_biangen],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jjlx_biangen,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jjlxQuery_biangen.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			biangenViewForm.getForm().findField('select_jjlxmc_biangen').setValue(selections[0].get('jjlxmc'));
			biangenViewForm.getForm().findField('select_jjlxdm_biangen').setValue(selections[0].get('jjlxdm'));
			biangenViewForm.getForm().findField('select_jjlxmcOld_biangen').setValue(selections[0].get('ojjlxmc00'));
			biangenViewForm.getForm().findField('select_jjlxdmOld_biangen').setValue(selections[0].get('ojjlxdm00'));
			if(selections[0].get('jjlxdm')>5000 && selections[0].get('jjlxdm')<8000){
				biangenViewForm.getForm().findField('wftzgb_biangen').allowBlank=false;
				biangenViewForm.getForm().findField('wftzgbdm_biangen').allowBlank=false;
				if(selections[0].get('jjlxdm')>6000 && selections[0].get('jjlxdm')<7000){
					biangenViewForm.getForm().findField('wftzgb_biangen').setValue('港澳台');
					biangenViewForm.getForm().findField('wftzgbdm_biangen').setValue('3444');
				}
			}else{
				biangenViewForm.getForm().findField('wftzgb_biangen').setValue('');
				biangenViewForm.getForm().findField('wftzgbdm_biangen').setValue('');
				biangenViewForm.getForm().findField('wftzgb_biangen').allowBlank=true;
				biangenViewForm.getForm().findField('wftzgbdm_biangen').allowBlank=true;
			}			
		}			
	}
});


var window_jjlxQuery_biangen = new Ext.Window({
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
	items : [grid_jjlx_biangen]
});


//主管部门
var searchZgmc_biangen = function() {
	ds_zgmc_biangen.baseParams.conditions = text_search_zgmc_biangen.getValue();
	ds_zgmc_biangen.baseParams.username='';
	ds_zgmc_biangen.baseParams.stateConditions='';
	ds_zgmc_biangen.load({params : {start : 0,limit : 20} });
}

var btn_search_zgmc_biangen = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchZgmc_biangen();
		//btn_search_pzjg.setDisabled(true);
	}
});

var text_search_zgmc_biangen = new Ext.form.TextField({
	id : 'textSearchZgmc_biangen',
	name : 'textSearchZgmc_biangen',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchZgmc_biangen();
			}
		},
		'change' : function(field, e) {
			btn_search_zgmc_biangen.setDisabled(false);
		}
	}
});

var cm_zgmc_biangen = new Ext.grid.ColumnModel([
	{header : '主管部门名称',width : 50,dataIndex : 'jgmc',sortable : true}, 
	{header : '主管部门代码',width : 20,dataIndex : 'jgdm',sortable : true}
]);

var ds_zgmc_biangen = new Ext.data.Store({
	url : 'findAllTjgdm.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'jgdm',type : 'string'},
			{name : 'jgmc',type : 'string'}
		])
});
var grid_zgmc_biangen = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_zgmc_biangen,
	ds : ds_zgmc_biangen,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入主管部门名称：',text_search_zgmc_biangen,btn_search_zgmc_biangen],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_zgmc_biangen,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_zgmcQuery_biangen.hide();
			var selections=grid.getSelectionModel().getSelections();
			biangenViewForm.getForm().findField('select_zgmc_biangen').setValue(selections[0].get('jgmc'));
			biangenViewForm.getForm().findField('select_zgdm_biangen').setValue(selections[0].get('jgdm'));
		}
	}
});
var window_zgmcQuery_biangen = new Ext.Window({
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
	items : [grid_zgmc_biangen]
});




//--------------------机构基本信息-------------------------------------------
var biangenViewForm = new Ext.FormPanel({	
	url : 'saveOrgnew.action',
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
						id:"select_jglxdm_biangen",
						name:"jglxdm",
						fieldLabel:"机构类型",
						anchor:'97%',
					 	valueField : "jglxdm",
					    displayField : "jglxdm",
					    store : jglxStore_bg,
					    labelSeparator:'',
					    allowBlank : false,
					    haveShow : false,
					    editable : false,
					    onTriggerClick : function() {
					    	window_jglxQuery_biangen.show();
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
                items: [{ xtype:'textfield',id:"select_jglxmc_biangen",name : 'jglx',labelSeparator:'',hideLabel:true,allowBlank : false,readOnly:'true',maxLength : 50,anchor:'100%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{xtype : 'combo',
						fieldLabel : '小微企业',
						id : 'isxw_biangen',
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
						id : 'gk_biangen',
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
						id : 'fkbz_biangen',
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
									biangenViewForm.getForm().findField('fksl').setValue('1');
								}else{
									biangenViewForm.getForm().findField('fksl').setValue('0');
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
                	{ xtype:'textfield',fieldLabel : '机构代码',name : 'jgdm',labelSeparator:'',allowBlank : false,vtype:'verifyCode',maxLength : 9,minLength:9,anchor:'100%'}]
			},{
                columnWidth:.75,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构名称',id:'jgmc_biangen',name : 'jgmc',labelSeparator:'',allowBlank : false,maxLength : 100,anchor:'99.9%'}]
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
						id : 'zjlx_biangen',
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
									var flag = isIdCardNo(biangenViewForm.getForm().findField('zjhm').getValue());
									if(flag != true){
										biangenViewForm.getForm().findField('zjhm').focus();
									}
								}else{
									biangenViewForm.getForm().findField('zjhm').focus();
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
                	xtype:'textfield',fieldLabel : '证件号码',name : 'zjhm',labelSeparator:'',hideLabel:true,allowBlank : false,confirmTo:'zjlx_biangen',vtype:'sfzhao',maxLength : 25,anchor:'99.9%',
                	enableKeyEvents: true,
					listeners : {
						keyup: function(f, e){//计数
				    		biangenViewForm.findById('ws_bg').setText("("+f.getValue().length+")");
				    	}
					}
				}]
			},{
				columnWidth : '.03',
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'ws_bg',name:'ws_bg',text:'(0)'}]
			},{
                columnWidth:.2,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{
                	xtype:'textfield',fieldLabel : '移动电话',id : 'mobile_bg',
                	name : 'mobile',labelSeparator:'',vtype:'mobilephone',
                	maxLength:11,minLength:11,anchor:'100%'
                	,enableKeyEvents:true,
            		listeners: {
            			keyup: function(f,e){
            				biangenViewForm.findById('mobile_biangen').setText("("+f.getValue().length+")");
            			}
            		}
                }]
			},{
				columnWidth : .05,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'mobile_biangen',name:'mobile_biangen',text:'(0)'}]
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
				    		biangenViewForm.findById('fw_bg').setText("("+length+")");
				    	}
			    	}
                }]
			},{
				columnWidth : .05,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'fw_bg',name:'fw_bg',text:'(1000)'}]
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
				    		biangenViewForm.findById('jj_bg').setText("("+length+")");
				    	}
			    	}
                }]
			},{
				columnWidth : .05,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'jj_bg',name:'jj_bg',text:'(1000)'}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
		                id:'zcrq_biangen',
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
								if(f.getValue()>biangenViewForm.getForm().findField('zsbfrq_biangen').getValue()){
									biangenViewForm.getForm().findField('zsbfrq_biangen').setValue('');
								}
								biangenViewForm.getForm().findField('zsbfrq_biangen').minValue=f.getValue();
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
		                id:'zsbfrq_biangen',
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
						//dateRange:{begin:'zsbfrq_biangen',end:'zszfrq_biangen'},//用于vtype类型dateRange   
                		//vtype:'dateRange'
				        })]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
					    id:'zszfrq_biangen',
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
					    dateRange:{begin:'zsbfrq_biangen',end:'zszfrq_biangen'},//用于vtype类型dateRange   
            			vtype:'dateRange'
					})]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jjlxdm_biangen",
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
					    	window_jjlxQuery_biangen.show();
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
	            items: [{xtype:'textfield',fieldLabel : '经济类型名称',id:"select_jjlxmc_biangen",name : 'jjlx',readOnly:true,labelSeparator:'',hideLabel:true,anchor:'99.9%'},
	                	{xtype:'hidden',id:"select_jjlxmcOld_biangen",name : 'jjlxOld'},
	                	{xtype:'hidden',id:"select_jjlxdmOld_biangen",name : 'jjlxdmOld'}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jjhydm_biangen",
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
					    	window_hylxQuery_biangen.show();
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
                items: [{xtype:'textfield',fieldLabel : '经济行业名称',id:"select_jjhymc_biangen",name : 'jjhymc',readOnly:true,allowBlank : false,labelSeparator:'',hideLabel:true,anchor:'99.9%'}]
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
					id : 'hbzl_biangen',
					displayField : 'categoryName',//显示值的名称
					hiddenName : 'hbzl',//真正提交时此combo的name
					valueField : 'categoryName',//真正提交时此combo的value
					mode : 'remote',
					store : ds_hbzl_select_bg,
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
							//biangenViewForm.getForm().findField('_hbzl').setValue(Ext.get("hbzl_biangen").dom.value);
							biangenViewForm.getForm().findField('hbzldm_biangen').setValue(record.data.categoryCode);
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
					id : 'wftzgb_biangen',
					displayField : 'categoryName',//显示值的名称
					hiddenName : 'wftzgb',//真正提交时此combo的name
					valueField : 'categoryName',//真正提交时此combo的value
					mode : 'remote',
					store : ds_wftzgb_select_bg,
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
							biangenViewForm.getForm().findField('wftzgbdm_biangen').setValue(record.data.categoryCode);
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
                items: [{xtype:'textfield',fieldLabel : '外方国别代码',id : 'wftzgbdm_biangen',name : 'wftzgbdm',labelSeparator:'',hideLabel:true,allowBlank : true,anchor:'99.9%'}]
            },{
                columnWidth:.25,
                layout: 'form',
                border:false,
                items: [
                	new Ext.form.TriggerField({
						id:"select_zgdm_biangen",
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
					    	window_zgmcQuery_biangen.show();
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
	                items: [{xtype:'textfield',fieldLabel : '主管部门名称',name :'zgmc',labelSeparator:'',id:"select_zgmc_biangen",hideLabel:true,anchor:'99.9%'}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [new Ext.form.TriggerField({
							id:"select_pzjgdm_biangen",
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
						    	window_pzjgQuery_bg.show();
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
	                items: [{xtype:'textfield',fieldLabel : '批准机构名称',name:'pzjgmc',labelSeparator:'',id:"select_pzjgmc_biangen",allowBlank : false,hideLabel:true,anchor:'99.9%'}]
	            },{
	                columnWidth:.45,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '注册号',name : 'zch',labelSeparator:'',allowBlank : false,maxLength : 50,anchor:'100%',
						enableKeyEvents:true,
			                		listeners: {
			                			keyup: function(f,e){
			                				biangenViewForm.findById('zch_bg').setText("("+f.getValue().length+")");
			                			}
			                		}
					}]
	            },{
					columnWidth : .05,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'label',
					items : [{id:'zch_bg',name:'zch_bg',text:'(0)'}]
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
	            				biangenViewForm.findById('dhhm_bg').setText("("+f.getValue().length+")");
	            			}
	            		}
	                }]
	            },{
					columnWidth : .05,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'label',
					items : [{id:'dhhm_bg',name:'dhhm_bg',text:'(0)'}]
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
							id : 'xzqhCode_biangen',
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
						    	window_xzqhQuery_biangen.show();
						    },
						    listeners : {
								'specialkey' : function(field, e) {
									if (e.getKey() == Ext.EventObject.ENTER) {
										findXzqhNameByXzqhCode(field,'xzqhName_biangen');
									}
								},
								'blur': function(field){
									findXzqhNameByXzqhCode(field,'xzqhName_biangen');
								}
							}
					    })
					]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '行政区划代码',id:'xzqhName_biangen',name : 'xzqhName',readOnly:true,labelSeparator:'',allowBlank : false,hideLabel:true,maxLength : 50,anchor:'99.9%'}]
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
							id : 'xzqhCode_biangen2',
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
						    	window_xzqhQuery_biangen2.show();
						    },
						    listeners : {
								'specialkey' : function(field, e) {
									if (e.getKey() == Ext.EventObject.ENTER) {
										findXzqhNameByXzqhCode(field,'xzqhName_biangen2');
									}
								},
								'blur': function(field){
									findXzqhNameByXzqhCode(field,'xzqhName_biangen2');
								}
							}
					    })
					]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '行政区划代码',id:'xzqhName_biangen2',name : 'xzqhName2',readOnly:true,labelSeparator:'',hideLabel:true,maxLength : 50,anchor:'99.9%'}]
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
							id : 'zjlx2_biangen',
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
									var flag = isIdCardNo(biangenViewForm.getForm().findField('tbrsfzh').getValue());
									if(flag != true){
										biangenViewForm.getForm().findField('tbrsfzh').focus();
									}
								}else{
									biangenViewForm.getForm().findField('tbrsfzh').focus();
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
	                	xtype:'textfield',fieldLabel : '证件号码',name : 'tbrsfzh',labelSeparator:'',hideLabel:true,confirmTo:'zjlx2_biangen',vtype:'sfzhao',allowBlank : false,maxLength : 50,anchor:'95%',
	                	enableKeyEvents: true,
						listeners : {
							keyup: function(f, e){//计数
					    		biangenViewForm.findById('ts_bg').setText("("+f.getValue().length+")");
					    	}
						}	
					}]
				},{
					columnWidth : '.03',
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'label',
					items : [{id:'ts_bg',name:'ts_bg',text:'(0)'}]
				},{
	                columnWidth:.2,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{ 
	                	xtype:'textfield',fieldLabel : '经办人电话',allowBlank : false,
	                	name : 'tbrlxfs',labelSeparator:'',vtype:'dhhmphone',
	                	maxLength : 50,anchor:'100%'
	                	,enableKeyEvents:true,
	            		listeners: {
	            			keyup: function(f,e){
	            				biangenViewForm.findById('tbrlxfs_bg').setText("("+f.getValue().length+")");
	            			}
	            		}
	                }]
				},{
					columnWidth : .05,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'label',
					items : [{id:'tbrlxfs_bg',name:'tbrlxfs_bg',text:'(0)'}]
			    },{
	                columnWidth:.33,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [new Ext.form.DateField({  
						    id:'bzrq_biangen',
						    name: 'bzrq',
						    format:'Y-m-d',
						    maxValue:myDate,  
						    maxText:'所选日期应在{0}之前',  
						    //minValue:'01/01/1949',
						    //minText:'所选日期应在{0}之后',
						    labelSeparator:'',
						    anchor:'100%',
						    fieldLabel:'办证日期',
						    //value: myDate,
						    allowBlank : false,
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
						    id:'zfrq_biangen',
						    name: 'zfrq',
						    format:'Y-m-d',
						    maxValue:newZfrqYes,  
						    maxText:'所选日期应在{0}之前',  
						    minValue:myDate,
						    minText:'所选日期应在{0}之后',
						    anchor:'100%',
						    //value:newZfrq,
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
						    id:'njqx_biangen',
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
						    value:newNjqx
						})
					]
				},{
                	columnWidth:1,
                	layout: 'form',
                	bodyStyle: 'padding:0px',
                	border:false,
                	items: [
                		{xtype:'textfield',fieldLabel : '备注',name : 'memo',labelSeparator:'',maxLength : 50,anchor:'99.9%'},
	                	{xtype:'hidden',fieldLabel : '业务类型',name : 'ywlx',value:'变更'},
						{xtype : 'hidden',	name : 'orgid',value:''},
					    {xtype : 'hidden',	name : 'orderid',id:'orderid'},
					    {xtype : 'hidden',name : 'docid'},
						{xtype : 'hidden',name : 'imageUrl'},
					    {xtype : 'hidden',id:'hbzldm_biangen',name : 'hbzldm',value:'156'},
					    {xtype : 'hidden',id:'select_jjhymcOld_biangen',name : 'jjhymcOld'},
					    {xtype : 'hidden',id:'select_jjhydmOld_biangen',name : 'jjhydmOld'},
					    {xtype : 'hidden',name : 'bzjgdm'},
						{xtype : 'hidden',name : 'lastdate',value :myDate.format('Y-m-d')}, 
						{xtype : 'hidden',name : 'bgrq',value :myDate.format('Y-m-d')}, 
						{xtype : 'hidden',name : 'lry'},
						{xtype : 'hidden',name : 'xgr',value:currentZzUsername},
						{xtype : 'hidden',name : 'state',value:'12'}]
				}]
		}]
});

var  biangenViewForm2= new Ext.Panel({
    title       : '基本信息',
    region      : 'center',
    id          : 'jbInfo23',
    bodyStyle: 'padding:0px',
    margins: '3 0 0 0',
    cmargins: '5 5 0 0',
    defaults  : {
		autoScroll : true
	},
	layout: 'fit',
    items : [biangenViewForm]
});
    
var fileFtpForm_biangen = new Ext.Panel({    
	title:'原文扫描',
	split: true,
	width:620,
	collapsible:true,
	collapsed: false,
    region:'east',
    margins:'3 0 0 0',
    cmargins:'3 0 0 5',
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"  width=100%  height=100% align=center hspace=0 vspace=0 id="scanner24624"  name="scanner24624" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>'
    
});


//默认查询 档案
var searchbiangen = function() {
	biangenViewForm.getForm().reader = Orgnews;
	biangenViewForm.getForm().load({
		waitMsg : '正在进行数据查询，请稍等',          //提示信息   
        waitTitle : '提示',                      //标题  
	    url: 'findAllYwqxOrgnew.action', //请求控制器获取数据
	    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
	    params: { conditions:  text_search_biangen.getValue(),username:currentZzUsername,ywlxConditions:null,stateConditions:'10,11,12,13,14,15,16',start:1,limit:1},	
	    success:function(form,action) {//获取返回值
		    	if(action.result.data.ywlx=='变更' && (action.result.data.state=='12' || action.result.data.state=='14')){//判断业务是否办理中
		    		/*
		    		if(currentZzUserYwqx=='2'&&currentZzUserBzjgdm!=currentZzUserCenterid&&action.result.data.bzjgdm==currentZzUserCenterid){
		    			alert('本业务属于中心业务，不属于跨区办理范畴');
		    			biangenViewForm.getForm().findField('select_jjlxmc_biangen').allowBlank=true;
						biangenViewForm.getForm().findField('select_jjlxdm_biangen').allowBlank=true;
						biangenViewForm.getForm().findField('wftzgb_biangen').allowBlank=true;
						biangenViewForm.getForm().findField('wftzgbdm_biangen').allowBlank=true;
						btn_del_biangen.setDisabled(true);
						biangenViewForm.getForm().reset();
						var tab3452=Ext.getCmp("jbInfo23");
					    tab3452.setTitle("基本信息");
						scanner24624.ImageData="";
		    			return;
		    		}
		    		*/
		    		biangenViewForm.getForm().findField('select_jjlxmc_biangen').allowBlank=true;
					biangenViewForm.getForm().findField('select_jjlxdm_biangen').allowBlank=true;
					biangenViewForm.getForm().findField('wftzgb_biangen').allowBlank=true;
					biangenViewForm.getForm().findField('wftzgbdm_biangen').allowBlank=true;
		
		    		btn_save_biangen_menu.setDisabled(false);
		    		btn_del_biangen.setDisabled(true);
		    		var tab3452=Ext.getCmp("jbInfo23");
		    		tab3452.setTitle("基本信息  ("+stateToInfo(biangenViewForm.getForm().findField('state').value)+")");	
		    		biangenViewForm.getForm().findField('lastdate').setValue(myDate.format('Y-m-d'));
					biangenViewForm.getForm().findField('xgr').setValue(currentZzUsername);
					biangenViewForm.getForm().findField('bzjgdm').setValue(currentZzUserBzjgdm);
		    		
		    		var resultObject = null;
		            //alert(action.result.data.orgid);
		    		Ext.Ajax.request({
						url : 'orgnewViewImg.action',
						params : {orgid : action.result.data.orgid},
						//waitTitle: '提示',
					    //waitMsg: '数据正在重新加载中，请稍后',
						success : function(result,request) {//获取返回值
							scanner24624.ImageData="";
		   					var resultObject = Ext.util.JSON.decode(result.responseText);
		   					if(resultObject!=null){
			   					scanner24624.OpenProgress(3);  //设置上传的进度条的总进度数
			   					scanner24624.Progress('原文加载中',1);
								scanner24624.Progress('原文加载中',2);
			   					scanner24624.ImageData=resultObject.imageData;
			   					scanner24624.pageType=resultObject.pageTypeStr;
			   					if(scanner24624.ImageData!=""){
			   						scanner24624.Progress('原文加载完毕',3);
									scanner24624.CloseProgress();
								}else{
									scanner24624.Progress('原文加载失败',3);
					   				scanner24624.CloseProgress();
					   				alert("原文错误，加载失败！");
								}
		   					}
						},
						failure : function() {
							scanner24624.ImageData="";
				   			scanner24624.CloseProgress();
							alert("图像加载错误，或者无原文");
						}
					});	
		
				}else{
					btn_del_biangen.setDisabled(true);
					Ext.Msg.show({
						title : '提示',
						msg : '机构正在进行“'+action.result.data.ywlx+'”业务办理中!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.INFO,
						fn : function() {biangenViewForm.getForm().reset();scanner24624.ImageData="";}
					});
	            }
		},
		failure : function() {//正式库检索
			
				biangenViewForm.getForm().reader = Orgnews;
				biangenViewForm.getForm().load({
					waitMsg : '正在进行数据查询，请稍等',          //提示信息   
			        waitTitle : '提示',                      //标题  
				    url: 'findAllTjgdmByJgdm.action', //请求控制器获取数据
				    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
				    params: { jgdm:  text_search_biangen.getValue(),userBzjgdm:null},	
				    success:function(form,action) {//获取返回值
				    		if(currentZzUsername!='admin' && sysBzjgLimitMode=='1' && action.result.data.bzjgdm!=currentZzUserBzjgdm && currentZzUserYwqx!='2' && currentZzUserBzjgdm!=currentZzUserCenterid){
				    				Ext.Msg.show({
										title : '提示',
										msg : '【'+action.result.data.jgmc+'】，<br><br>办证机构代码为“'+action.result.data.bzjgdm+'”,不属于本办证机构办理！',
										buttons : Ext.Msg.OK,
										fn:  function() {
											btn_del_biangen.setDisabled(true);
											biangenViewForm.getForm().reset();
											scanner24624.ImageData="";
											var tab3452554=Ext.getCmp("jbInfo23");
							    			tab3452554.setTitle("基本信息");
										},
										icon : Ext.Msg.ERROR
									});
				    		}else{
						    	if(action.result.data.state=='100' || action.result.data.state==''){//判断此机构状态是否正常
						    		biangenViewForm.getForm().findField('select_jjlxmc_biangen').allowBlank=true;
									biangenViewForm.getForm().findField('select_jjlxdm_biangen').allowBlank=true;
									biangenViewForm.getForm().findField('wftzgb_biangen').allowBlank=true;
									biangenViewForm.getForm().findField('wftzgbdm_biangen').allowBlank=true;
					
						    		btn_del_biangen.setDisabled(true);
						    		var tab3452=Ext.getCmp("jbInfo23");
						    		tab3452.setTitle("基本信息  (新录入)");
						    		biangenViewForm.getForm().findField('ywlx').setValue('变更');
						    		biangenViewForm.getForm().findField('state').setValue('12');
						    		biangenViewForm.getForm().findField('orgid').setValue('');
						    		biangenViewForm.getForm().findField('lastdate').setValue(myDate.format('Y-m-d'));
						    		//biangenViewForm.getForm().findField('bzrq').setValue(myDate);
						    		//biangenViewForm.getForm().findField('zfrq').setValue(newZfrq);
						    		biangenViewForm.getForm().findField('bgrq').setValue(myDate.format('Y-m-d'));
									biangenViewForm.getForm().findField('xgr').setValue(currentZzUsername);
									biangenViewForm.getForm().findField('bzjgdm').setValue(currentZzUserBzjgdm);
									if(action.result.data.zbsl == null || action.result.data.zbsl == ''){
							    		biangenViewForm.getForm().findField('zbsl').setValue(1);
						    		}
									if(action.result.data.zjlx=='军人证' || action.result.data.zjlx=='通行证' || action.result.data.zjlx=='澳门证' || action.result.data.zjlx=='香港证' || action.result.data.zjlx=='台湾证' || action.result.data.zjlx=='回乡证'){
		    							biangenViewForm.getForm().findField('zjlx').setValue('');
		    						}
								}else{
									Ext.Msg.show({
										title : '提示',
										msg : '机构“'+action.result.data.jgmc+'”状态为“'+tjgdmStateToInfo(action.result.data.state)+'”,<br><br>不能再次办理业务！',
										buttons : Ext.Msg.OK,
										fn:  function() {
											btn_del_biangen.setDisabled(true);
											biangenViewForm.getForm().reset();
											scanner24624.ImageData="";
											var tab3452554=Ext.getCmp("jbInfo23");
							    			tab3452554.setTitle("基本信息");
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
									btn_del_biangen.setDisabled(true);
								    //btn_shibie_biangen.setDisabled(false);
									biangenViewForm.getForm().reset();
									//scanner24624.ImageData="";
									var tab3452=Ext.getCmp("jbInfo23");
					    			tab3452.setTitle("基本信息");
								}
						});
				}	
			});
		}
	});
}

var btn_search_biangen = new Ext.Button({
	text : '代码查询',
	iconCls : 'icon-search',
	handler : function() {
		searchbiangen();
	}
});

var text_search_biangen = new Ext.form.TextField({
	id : 'textSearchbiangen',
	name : 'textSearchbiangen',
	width : 200,
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchbiangen();
			}
		}
	}
});


var btn_print_biangen = new Ext.Button({
	text : '打印申请表',
	iconCls : 'icon-print',
	handler : function(field){			
		var orgid = biangenViewForm.getForm().findField('orgid').value;
		if(orgid!=null && orgid!=""){
			ajaxLoadMask .show();
			Ext.Ajax.request({
				url: 'findOrgnewByOrgid.action',
   				params: {orgid: orgid},
   				success: function(result,request){//获取返回值
   					ajaxLoadMask .hide();
   					var resultObject = Ext.util.JSON.decode(result.responseText);
   					if(resultObject.root.length!=0){
						var titleHTML = printSqdStr(resultObject.root[0],1);   
						var newwin = window.open('printer.jsp', 'printWindow', 'menubar=yes,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no,titlebar=yes,z-look=yes,menubar=yes');     
						newwin.document.write(titleHTML); 
   					}
   				},
   				failure: function(){
   					ajaxLoadMask .hide();
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

var btn_refresh_biangen = new Ext.Button({
	text : '重置',
	iconCls : 'icon-refresh',
	handler : function() {
		biangenViewForm.getForm().findField('select_jjlxmc_biangen').allowBlank=true;
		biangenViewForm.getForm().findField('select_jjlxdm_biangen').allowBlank=true;
		biangenViewForm.getForm().findField('wftzgb_biangen').allowBlank=true;
		biangenViewForm.getForm().findField('wftzgbdm_biangen').allowBlank=true;
		
    	//btn_save_biangen_menu.setDisabled(true);
    	//btn_shibie_biangen.setDisabled(false);
		btn_del_biangen.setDisabled(true);
		biangenViewForm.getForm().reset();
		var tab3452=Ext.getCmp("jbInfo23");
	    tab3452.setTitle("基本信息");
		scanner24624.ImageData="";
		//this.ownerCt.form.reset();;
	}
});


var btn_del_biangen = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	disabled:true,
	handler : function() {
		var orgid = biangenViewForm.getForm().findField('orgid').value;
		if(orgid!=null && orgid!=""){
			Ext.Msg.confirm('确认删除', '你确定删除吗?', function(btn) {
				if (btn == 'yes') {
					ajaxLoadMask.show();
					Ext.Ajax.request({
						url : 'deleteOrgnew.action',
						params : {orgid : orgid},
						success : function() {
							ajaxLoadMask.hide();
							btn_del_biangen.setDisabled(true);
					    	//btn_shibie_biangen.setDisabled(false);
							biangenViewForm.getForm().reset();
							var tab3452=Ext.getCmp("jbInfo23");
	    					tab3452.setTitle("基本信息");
							scanner24624.ImageData="";
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

var btn_save_biangen_menu = new Ext.Toolbar.MenuButton({
    text: '保存',
    handler: btn_biangen_saveAll,
    tooltip: {title:'保存数据和原文',text:'保存'},
    iconCls: 'blist',
    //disabled:true,
    menu : {items: [
                {text: '全部保存', handler: btn_biangen_saveAll}, '-',
                {text: '仅保存数据', handler: btn_biangen_saveInfo},
                {text: '仅上传原文', handler: btn_biangen_ftpFile}
        ]}
});

var upFuncBG = function(docid,orgid,strJgdm,strState,strYwlx,jgmc){
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
				strBzjgdm=biangenViewForm.getForm().findField('bzjgdm').value; 
				
				packLength = 40960;	//定义每个包的大小40960
				//scanner24624.ImageData=document.getElementById("ImageData").value;
				base64file = scanner24624.ImageData;  //获取控件扫描的图片数据
				var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
				imageCount = scanner24624.ImageCount;	//获取扫描图片的页数
				pageTypeStr = scanner24624.PageType;    //获取标识字符串,需要写数据库
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
				scanner24624.OpenProgress(packCount);  //设置上传的进度条的总进度数
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
							scanner24624.Progress('上传中',i+1);
						}
						else
						{
							alert("上传失败，请重试0001。");
							//scanner24624.ShowSendMsg(false);
							
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
					msg : '['+biangenViewForm.getForm().findField('jgmc_biangen').getValue()+']，<br><br>信息保存成功！',
					buttons : Ext.Msg.OK,
					fn : function() {
						scanner24624.CloseProgress();
						subBGAction(orgid,strJgdm,strState,strYwlx,jgmc);
					},
					icon : Ext.Msg.INFO
				});

				
}

function btn_biangen_saveAll(btn){
	if (biangenViewForm.getForm().isValid()) {
		biangenViewForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在保存数据,请稍候...',
			success : function(form,action) {
				biangenViewForm.getForm().findField('orgid').setValue(action.result.orgid);
				biangenViewForm.getForm().findField('docid').setValue(action.result.docid);
				var orgid = action.result.orgid;
				var docid = action.result.docid;
				var strJgdm = biangenViewForm.getForm().findField('jgdm').getValue();
				var strState = biangenViewForm.getForm().findField('state').getValue();
				var jgmc = biangenViewForm.getForm().findField('jgmc_biangen').getValue();
				var strYwlx = biangenViewForm.getForm().findField('ywlx').getValue();
				if(scanner24624.ImageCount>0){
					if(orgid!=null || orgid!=""){
			Ext.Ajax.request({
				url: 'checkArchive.action',
				params: {orgid: orgid,jgdm:strJgdm},
				success: function(result,request){//result,request
					var data = Ext.util.JSON.decode(result.responseText);
					var str = scanner24624.CheckArchives("变更",data.jglxdmOld,data.zchInfo,data.frInfo);
					if(str==''){
						//alert("更新imageFlag为1（表示档案完整）");
						refreshImageFlag(orgid,'1');
						upFuncBG(docid,orgid,strJgdm,strState,strYwlx,jgmc);
					}else{
						//alert(str+"::更新imageFlag为0（表示档案不完整）");
						Ext.Msg.show({
							title : '提示',
							msg : str + '继续提交则选是,取消提交则选否！',
							buttons : Ext.Msg.OKCANCEL,
							fn : function(btn){
								if(btn == 'ok'){
									refreshImageFlag(orgid,'0');
									upFuncBG(docid,orgid,strJgdm,strState,strYwlx,jgmc);
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
			Ext.Msg.show({
				title : '提示',
				msg : '请保存信息后，再进行“变更确认”处理！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR
			});
		}
				}else{
					Ext.Msg.show({
						title : '提示',
						msg : '档案尚未扫描请确认是否继续提交！',
						buttons : Ext.Msg.OKCANCEL,
						fn : function(btn){
							if(btn == 'ok'){
								refreshImageFlag(orgid,'0');
								subBGAction(orgid,strJgdm,strState,strYwlx,jgmc);
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

function btn_biangen_saveInfo(btn){
	if (biangenViewForm.getForm().isValid()) {
		//btn_print_biangen.setDisabled(false);
		biangenViewForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在保存数据,请稍候...',
			success : function(form,action) {
				//alert(action.result.orgid);
				biangenViewForm.getForm().findField('orgid').setValue(action.result.orgid);
				biangenViewForm.getForm().findField('docid').setValue(action.result.docid);
				Ext.Msg.show({
					title : '提示',
					msg : '['+biangenViewForm.getForm().findField('jgmc_biangen').getValue()+']，申办信息保存成功',
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
			fn : function() {
				btn.enable();
			},
			icon : Ext.Msg.ERROR
		});
	}
}

function btn_biangen_ftpFile(btn){
	
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
	strOrgid =biangenViewForm.getForm().findField('orgid').value;  //参数orgid
	strDocid =biangenViewForm.getForm().findField('docid').value;  //参数docid
	strBzjgdm=biangenViewForm.getForm().findField('bzjgdm').value;  //办证机构代码
	//alert("strOrgid="+strOrgid);
	
	if(strOrgid!=""){
			packLength = 40960;	//定义每个包的大小40960
			//scanner24624.ImageData=document.getElementById("ImageData").value;
			base64file = scanner24624.ImageData;  //获取控件扫描的图片数据
			var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
			imageCount = scanner24624.GetPageCount;	//获取扫描图片的页数
			pageTypeStr = scanner24624.PageType;    //获取标识字符串,需要写数据库
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
			scanner24624.OpenProgress(packCount);  //设置上传的进度条的总进度数
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
						scanner24624.Progress('上传中',i+1);
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
			scanner24624.CloseProgress();
			
			Ext.Msg.show({
				title : '提示',
				msg : '['+biangenViewForm.getForm().findField('jgmc_biangen').getValue()+']，<br><br>原文上传成功！',
				buttons : Ext.Msg.OK,
				fn : function() {btn.enable();},
				icon : Ext.Msg.INFO
			});
			
			scanner24624.CloseProgress();
			return true;
	}else{
		alert("请录入数据后，再上传原文！");
	}
}

//提交确认方法
var subBGAction =function (orgid,strJgdm,strState,strYwlx,jgmc){
	
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
					biangenViewForm.getForm().findField('orgid').setValue('');
   					var tab345=Ext.getCmp("jbInfo23");
		    		tab345.setTitle("基本信息");	
					biangenViewForm.getForm().reset();
					scanner24624.PageType="";
					scanner24624.ImageData="";
					text_search_biangen.setValue("");
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

var btn_saveInfo_biangen = new Ext.Button({
	text : '保存数据',
	iconCls : 'blist',
	handler : btn_biangen_saveInfo
});

var btn_ok_biangen = new Ext.Button({
	text : '确认提交',
	iconCls : 'icon-store',
	handler : btn_biangen_saveAll
});


var p_zzBiangen = {
	id : 'zzBiangen-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:0px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    bodyBorder: false,
	    title: '变更',
	    iconCls : 'icon-plugin',
 		plain: true,
		region: 'center',
		tbar : [btn_refresh_biangen,btn_del_biangen,/*btn_save_biangen_menu*/btn_saveInfo_biangen,btn_print_biangen,btn_ok_biangen,'->',text_search_biangen,btn_search_biangen],
		items: [biangenViewForm2,fileFtpForm_biangen]
	}]
}