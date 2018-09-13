

var searchXzqh_archiveScan2 = function() {
	ds_xzqh_archiveScan2.baseParams.conditions = text_search_xzqh_archiveScan2.getValue();
	ds_xzqh_archiveScan2.baseParams.username='';
	ds_xzqh_archiveScan2.baseParams.stateConditions='';
	ds_xzqh_archiveScan2.load({params : {start : 0,limit : 20} });
}

var btn_search_xzqh_archiveScan2 = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchXzqh_archiveScan2();
	}
});

var text_search_xzqh_archiveScan2 = new Ext.form.TextField({
	id : 'textSearchXzqh_archiveScan2',
	name : 'textSearchXzqh_archiveScan2',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchXzqh_archiveScan2();
			}
		},
		'change' : function(field, e) {
			searchXzqh_archiveScan2();
			//btn_search_xzqh_archiveScan.setDisabled(false);
		}
	}
});

var cm_xzqh_archiveScan2 = new Ext.grid.ColumnModel([
	{header : '行政区划名称',width : 50,dataIndex : 'xzqhName',sortable : true},
	{header : '行政区划代码',width : 20,dataIndex : 'xzqhCode',sortable : true}
]);

var ds_xzqh_archiveScan2 = new Ext.data.Store({
	url : 'findAllByConditionXzqh.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'xzqhCode',type : 'string'},
			{name : 'xzqhName',type : 'string'},
			{name : 'xzqhNote',type : 'string'}
		])
});
var grid_xzqh_archiveScan2 = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_xzqh_archiveScan2,
	ds : ds_xzqh_archiveScan2,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入行政区划名称：',text_search_xzqh_archiveScan2,btn_search_xzqh_archiveScan2],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_xzqh_archiveScan2,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_xzqhQuery_archiveScan2.hide();
			var selections=grid.getSelectionModel().getSelections();
			archiveScanViewForm.getForm().findField('xzqhName_archiveScan2').setValue(selections[0].get('xzqhName'));
			archiveScanViewForm.getForm().findField('xzqhCode_archiveScan2').setValue(selections[0].get('xzqhCode'));
		}
	}
});

var window_xzqhQuery_archiveScan2 = new Ext.Window({
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
	items : [grid_xzqh_archiveScan2]
});
//行政区划的到此结束

var searchXzqh_archiveScan = function() {
	ds_xzqh_archiveScan.baseParams.conditions = text_search_xzqh_archiveScan.getValue();
	ds_xzqh_archiveScan.baseParams.username='';
	ds_xzqh_archiveScan.baseParams.stateConditions='';
	ds_xzqh_archiveScan.load({params : {start : 0,limit : 20} });
}

var btn_search_xzqh_archiveScan = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchXzqh_archiveScan();
	}
});

var text_search_xzqh_archiveScan = new Ext.form.TextField({
	id : 'textSearchXzqh_archiveScan',
	name : 'textSearchXzqh_archiveScan',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchXzqh_archiveScan();
			}
		},
		'change' : function(field, e) {
			searchXzqh_archiveScan();
			//btn_search_xzqh_archiveScan.setDisabled(false);
		}
	}
});

var cm_xzqh_archiveScan = new Ext.grid.ColumnModel([
	{header : '行政区划名称',width : 50,dataIndex : 'xzqhName',sortable : true},
	{header : '行政区划代码',width : 20,dataIndex : 'xzqhCode',sortable : true}
]);

var ds_xzqh_archiveScan = new Ext.data.Store({
	url : 'findAllByConditionXzqh.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'xzqhCode',type : 'string'},
			{name : 'xzqhName',type : 'string'},
			{name : 'xzqhNote',type : 'string'}
		])
});
var grid_xzqh_archiveScan = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_xzqh_archiveScan,
	ds : ds_xzqh_archiveScan,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入行政区划名称：',text_search_xzqh_archiveScan,btn_search_xzqh_archiveScan],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_xzqh_archiveScan,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_xzqhQuery_archiveScan.hide();
			var selections=grid.getSelectionModel().getSelections();
			archiveScanViewForm.getForm().findField('xzqhName_archiveScan').setValue(selections[0].get('xzqhName'));
			archiveScanViewForm.getForm().findField('xzqhCode_archiveScan').setValue(selections[0].get('xzqhCode'));
		}
	}
});

var window_xzqhQuery_archiveScan = new Ext.Window({
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
	items : [grid_xzqh_archiveScan]
});
//行政区划的到此结束

var btn_search_pzjg_as = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchPzjg_as();
		//btn_search_pzjg_as.setDisabled(true);
	}
});


var text_search_pzjg_as = new Ext.form.TextField({
	id : 'textSearchPzjg_as',
	name : 'textSearchPzjg_as',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchPzjg_as();
			}
		},
		'change' : function(field, e) {
			btn_search_pzjg_as.setDisabled(false);
		}
	}
});


var cm_pzjg_as = new Ext.grid.ColumnModel([
	{header : '批准机构名称',width : 50,dataIndex : 'pzjgmc',sortable : true}, 
	{header : '批准机构代码',width : 20,dataIndex : 'pzjgdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_pzjg_as = new Ext.data.Store({
	url : 'findAllByConditionPzjg.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'pzjgid',type : 'int'}, 
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchPzjg_as = function() {
	ds_pzjg_as.baseParams.conditions = text_search_pzjg_as.getValue();
	ds_pzjg_as.baseParams.username='';
	ds_pzjg_as.baseParams.stateConditions='';
	ds_pzjg_as.load({params : {start : 0,limit : 20} });
}

var grid_pzjg_as = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_pzjg_as,
	ds : ds_pzjg_as,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入登记批准机构名称：',text_search_pzjg_as,btn_search_pzjg_as],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_pzjg_as,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_pzjgQuery_as.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			archiveScanViewForm.getForm().findField('select_pzjgmc_archiveScan').setValue(selections[0].get('pzjgmc'));
			archiveScanViewForm.getForm().findField('select_pzjgdm_archiveScan').setValue(selections[0].get('pzjgdm'));
		}
	}
});


var window_pzjgQuery_as = new Ext.Window({
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
	items : [grid_pzjg_as]
});


var btn_search_jglxSelcet_as = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJglxSelcet_as();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_jglxSelcet_as = new Ext.form.TextField({
	id : 'textsearchJglxSelcet_as',
	name : 'textsearchJglxSelcet_as',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJglxSelcet_as();
			}
		},
		'change' : function(field, e) {
			btn_search_jglxSelcet_as.setDisabled(false);
		}
	}
});


var cm_jglxSelcet_as = new Ext.grid.ColumnModel([
    {header : '一级类型',width : 60,dataIndex : 'pjglxmc',sortable : true}, 
	{header : '二级类型',width : 100,dataIndex : 'jglxmc',sortable : true}, 
	{header : '代码',width : 30,dataIndex : 'jglxdm',sortable : true},
	{header : '备注',width : 50,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_jglxSelcet_as = new Ext.data.Store({
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

var ds_hbzl_select_as = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=1',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});

var searchJglxSelcet_as = function() {
	ds_jglxSelcet_as.baseParams.conditions = text_search_jglxSelcet_as.getValue();
	ds_jglxSelcet_as.baseParams.username="";
	ds_jglxSelcet_as.baseParams.stateConditions='';
	ds_jglxSelcet_as.load({params : {start : 0,limit : 20} });
}

var grid_jglx_archiveScan = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jglxSelcet_as,
	ds : ds_jglxSelcet_as,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入机构类型名称：',text_search_jglxSelcet_as,btn_search_jglxSelcet_as],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jglxSelcet_as,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jglxQuery_archiveScan.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			archiveScanViewForm.getForm().findField('select_jglxmc_archiveScan').setValue(selections[0].get('jglxmc'));
			archiveScanViewForm.getForm().findField('select_jglxdm_archiveScan').setValue(selections[0].get('jglxdm'));
		}
	}
});


var window_jglxQuery_archiveScan = new Ext.Window({
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
	items : [grid_jglx_archiveScan]
});

var btn_search_hylxSelcet_as = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchHylxSelcet_archiveScan();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_hylxSelcet_as = new Ext.form.TextField({
	id : 'textSearchHylxSelcet_as',
	name : 'textSearchHylxSelcet_as',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchHylxSelcet_archiveScan();
			}
		},
		'change' : function(field, e) {
			btn_search_hylxSelcet_as.setDisabled(false);
		}
	}
});

var ds_wftzgb_select_as = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=3',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});

var cm_hylxSelcet_as = new Ext.grid.ColumnModel([
	{header : '大类',width : 60,dataIndex : 'hylxmc1',sortable : true}, 
	{header : '中类',width : 60,dataIndex : 'hylxmc2',sortable : true}, 
	{header : '小类',width : 60,dataIndex : 'hylxmc3',sortable : true}, 
    {header : '经济行业名称',width : 60,dataIndex : 'hylxmc',sortable : true},
	{header : '经济行业代码',width : 30,dataIndex : 'hylxdm',sortable : true},
	{header : '备注',width : 60,dataIndex : 'note',menuDisabled : true}
]);


//查询返回结果的数据列
var ds_hylxSelcet_archiveScan = new Ext.data.Store({
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

var searchHylxSelcet_archiveScan = function() {
	ds_hylxSelcet_archiveScan.baseParams.conditions = text_search_hylxSelcet_as.getValue();
	ds_hylxSelcet_archiveScan.baseParams.username="";
	ds_hylxSelcet_archiveScan.baseParams.stateConditions='';
	ds_hylxSelcet_archiveScan.load({params : {start : 0,limit : 20} });
}

var grid_hylx_archiveScan = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_hylxSelcet_as,
	ds : ds_hylxSelcet_archiveScan,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入经济行业代码名称：',text_search_hylxSelcet_as,btn_search_hylxSelcet_as],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_hylxSelcet_archiveScan,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_hylxQuery_archiveScan.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			archiveScanViewForm.getForm().findField('select_jjhymc_archiveScan').setValue(selections[0].get('hylxmc'));
			archiveScanViewForm.getForm().findField('select_jjhydm_archiveScan').setValue(selections[0].get('hylxdm'));
			archiveScanViewForm.getForm().findField('select_jjhymcOld_archiveScan').setValue(selections[0].get('hylxmcOld'));
			archiveScanViewForm.getForm().findField('select_jjhydmOld_archiveScan').setValue(selections[0].get('hylxdmOld'));
		}
	}
});


var window_hylxQuery_archiveScan = new Ext.Window({
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
	items : [grid_hylx_archiveScan]
});


var btn_search_jjlx_archiveScan = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJjlx_archiveScan();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_jjlx_archiveScan = new Ext.form.TextField({
	id : 'textSearchJjlx_archiveScan',
	name : 'textSearchJjlx_archiveScan',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJjlx_archiveScan();
			}
		},
		'change' : function(field, e) {
			btn_search_jjlx_archiveScan.setDisabled(false);
		}
	}
});


var cm_jjlx_archiveScan = new Ext.grid.ColumnModel([
    {header : '大类',width : 30,dataIndex : 'pjjlxmc',sortable : true}, 
    {header : '中类',width : 30,dataIndex : 'pjjlxmc2',sortable : true}, 
    {header : '小类',width : 30,dataIndex : 'pjjlxmc3',sortable : true}, 
	{header : '经济类型名称',width : 100,dataIndex : 'jjlxmc',sortable : true}, 
	{header : '经济类型代码',width : 30,dataIndex : 'jjlxdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_jjlx_archiveScan = new Ext.data.Store({
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


var searchJjlx_archiveScan = function() {
	ds_jjlx_archiveScan.baseParams.conditions = text_search_jjlx_archiveScan.getValue();
	ds_jjlx_archiveScan.baseParams.username='';
	ds_jjlx_archiveScan.baseParams.stateConditions='';
	ds_jjlx_archiveScan.load({params : {start : 0,limit : 20} });
}

var grid_jjlx_archiveScan = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jjlx_archiveScan,
	ds : ds_jjlx_archiveScan,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入企业登记注册类型名称：',text_search_jjlx_archiveScan,btn_search_jjlx_archiveScan],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jjlx_archiveScan,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jjlxQuery_archiveScan.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			archiveScanViewForm.getForm().findField('select_jjlxmc_archiveScan').setValue(selections[0].get('jjlxmc'));
			archiveScanViewForm.getForm().findField('select_jjlxdm_archiveScan').setValue(selections[0].get('jjlxdm'));
			archiveScanViewForm.getForm().findField('select_jjlxmcOld_archiveScan').setValue(selections[0].get('ojjlxmc00'));
			archiveScanViewForm.getForm().findField('select_jjlxdmOld_archiveScan').setValue(selections[0].get('ojjlxdm00'));
			
			if(selections[0].get('jjlxdm')>5000 && selections[0].get('jjlxdm')<8000){
				archiveScanViewForm.getForm().findField('wftzgb_archiveScan').allowBlank=false;
				archiveScanViewForm.getForm().findField('wftzgbdm_archiveScan').allowBlank=false;
				if(selections[0].get('jjlxdm')>6000 && selections[0].get('jjlxdm')<7000){
					archiveScanViewForm.getForm().findField('wftzgb_archiveScan').setValue('港澳台');
					archiveScanViewForm.getForm().findField('wftzgbdm_archiveScan').setValue('344');
				}
			}else{
				archiveScanViewForm.getForm().findField('wftzgb_archiveScan').setValue('');
				archiveScanViewForm.getForm().findField('wftzgbdm_archiveScan').setValue('');
				archiveScanViewForm.getForm().findField('wftzgb_archiveScan').allowBlank=true;
				archiveScanViewForm.getForm().findField('wftzgbdm_archiveScan').allowBlank=true;
			}	
		}
	}
});


var window_jjlxQuery_archiveScan = new Ext.Window({
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
	items : [grid_jjlx_archiveScan]
});

//主管部门
var searchZgmc_as = function() {
	ds_zgmc_as.baseParams.conditions = text_search_zgmc_as.getValue();
	ds_zgmc_as.baseParams.username='';
	ds_zgmc_as.baseParams.stateConditions='';
	ds_zgmc_as.load({params : {start : 0,limit : 20} });
}

var btn_search_zgmc_as = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchZgmc_as();
		//btn_search_pzjg.setDisabled(true);
	}
});

var text_search_zgmc_as = new Ext.form.TextField({
	id : 'textSearchZgmc_as',
	name : 'textSearchZgmc_as',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchZgmc_as();
			}
		},
		'change' : function(field, e) {
			btn_search_zgmc_as.setDisabled(false);
		}
	}
});

var cm_zgmc_as = new Ext.grid.ColumnModel([
	{header : '主管部门名称',width : 50,dataIndex : 'jgmc',sortable : true}, 
	{header : '主管部门代码',width : 20,dataIndex : 'jgdm',sortable : true}
]);

var ds_zgmc_as = new Ext.data.Store({
	url : 'findAllTjgdm.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'jgdm',type : 'string'},
			{name : 'jgmc',type : 'string'}
		])
});

var grid_zgmc_as = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_zgmc_as,
	ds : ds_zgmc_as,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入主管部门名称：',text_search_zgmc_as,btn_search_zgmc_as],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_zgmc_as,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_zgmcQuery_archiveScan.hide();
			var selections=grid.getSelectionModel().getSelections();
			archiveScanViewForm.getForm().findField('select_zgmc_archiveScan').setValue(selections[0].get('jgmc'));
			archiveScanViewForm.getForm().findField('select_zgdm_archiveScan').setValue(selections[0].get('jgdm'));
		}
	}
});

var window_zgmcQuery_archiveScan = new Ext.Window({
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
	items : [grid_zgmc_as]
});

//--------------------机构基本信息-------------------------------------------
var archiveScanViewForm = new Ext.FormPanel({	
	url : 'saveOrgnew.action',
	labelAlign : 'right',
    bodyStyle:'padding:0px',
	labelWidth : 80,
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
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{xtype : 'combo',
						fieldLabel : '业务类型',
						id : 'ywlx_archiveScan',
						name : 'ywlx',
						displayField : 'ywlx',
						valueField : 'ywlx',
						hiddenName : 'ywlx',
						store : ywlxStore,
						triggerAction : 'all',
						lazyRender:true,
						value:'',
						anchor:'100%',
						mode : 'local',
						selectOnFocus : true,
						allowBlank:false,
						labelSeparator:'',
						editable : false,
						listeners : {	
							'select' : function(field, e) {
								if(archiveScanViewForm.getForm().findField('jgdm').getValue()!='' && field.getValue()=='预赋码'){
									archiveScanViewForm.getForm().findField('ywlx_archiveScan').setValue('');
									alert("机构已赋码，不能再次办理“预赋码”业务！");
								}
							}
						}
					}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype : 'combo',
						fieldLabel : '是否公开',
						id : 'gk_archiveScan',
						name : 'gk',
						displayField : 'gk',
						valueField : 'gk',
						hiddenName : 'gk',
						store : gkStore,
						triggerAction : 'all',
						lazyRender:true,
						value:'是',
						anchor:'100%',
						mode : 'local',
						selectOnFocus : true,
						allowBlank:false,
						labelSeparator:'',
						editable : false
					}]
			},{
                columnWidth:.3,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jglxdm_archiveScan",
						name:"jglxdm",
						fieldLabel:"机构类型",
						anchor:'97%',
					 	valueField : "jglxdm",
					    displayField : "jglxdm",
					    labelSeparator:'',
					    allowBlank : false,
					    haveShow : false,
					    editable : false,
					    onTriggerClick : function() {
					    	window_jglxQuery_archiveScan.show();
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
                items: [{ xtype:'textfield',id:"select_jglxmc_archiveScan",name : 'jglx',labelSeparator:'',hideLabel:true,allowBlank:false,readOnly:'true',maxLength : 50,anchor:'100%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构代码',name : 'jgdm',labelSeparator:'',allowBlank : true,vtype:'verifyCode',readOnly:'true',maxLength : 9,minLength:9,anchor:'100%'}]
			},{
                columnWidth:.75,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构名称',id:'jgmc_archiveScan',name : 'jgmc',labelSeparator:'',allowBlank : false,maxLength : 100,anchor:'99.9%'}]
			},{
                columnWidth:.3,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '法定代表人',name : 'fddbr',labelSeparator:'',allowBlank : true,maxLength : 30,anchor:'97%'}]
			},{
                columnWidth:.15,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{	xtype : 'combo',
						fieldLabel : '证件类型',
						id : 'zjlx_archiveScan',
						name:'zjlx',
						hiddenName : 'zjlx',
						valueField : 'categoryName',
						displayField : 'categoryName',
						mode : 'remote',
						store : ds_zjlx_select,
						selectOnFocus : true,
						editable : false,
						allowBlank : true,
						labelSeparator:'',
						//readOnly:true,
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
									var flag = isIdCardNo(archiveScanViewForm.getForm().findField('zjhm').getValue());
									if(flag != true){
										archiveScanViewForm.getForm().findField('zjhm').focus();
									}
								}else{
									archiveScanViewForm.getForm().findField('zjhm').focus();
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
                	xtype:'textfield',fieldLabel : '证件号码',name : 'zjhm',labelSeparator:'',hideLabel:true,allowBlank : true,confirmTo:'zjlx_archiveScan',maxLength : 25,anchor:'99.9%',
                	enableKeyEvents: true,
					listeners : {
						keyup: function(f, e){//计数
				    		archiveScanViewForm.findById('ws_as').setText("("+f.getValue().length+")");
				    	}
					}
				}]
			},{
				columnWidth : '.03',
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'ws_as',name:'ws_as',text:'(0)'}]
			},{
                columnWidth:.2,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{
                	xtype:'textfield',fieldLabel : '移动电话',id : 'mobile_as',name : 'mobile',
                	labelSeparator:'',vtype:'mobilephone',maxLength:11,minLength:11,anchor:'100%',
                	enableKeyEvents:true,
            		listeners: {
            			keyup: function(f,e){
            				archiveScanViewForm.findById('mobile_arcscan').setText("("+f.getValue().length+")");
            			}
            		}
                }]
			},{
				columnWidth : .05,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'mobile_arcscan',name:'mobile_arcscan',text:'(0)'}]
		    },{
                columnWidth:.95,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                defaultType : 'textarea',
                items: [{
                	fieldLabel : '经营范围',name : 'jyfw',allowBlank : true,labelSeparator:'',maxLength:1000,height:55,anchor:'99.5%',
                	enableKeyEvents: true,
			    	listeners:{
			    		keyup: function(f, e){//计数
				    		var length = 1000-f.getValue().length
				    		archiveScanViewForm.findById('fw_as').setText("("+length+")");
				    	}
			    	}
                }]
			},{
				columnWidth : .05,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'fw_as',name:'fw_as',text:'(1000)'}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
		                id:'zcrq_archiveScan',
		                name: 'zcrq',
		                format:'Y-m-d',
		                maxValue:myDate,  
		                maxText:'所选日期应在{0}之前',  
		                anchor:'100%',
		                allowBlank : true,
		                labelSeparator:'',
		                fieldLabel:'成立日期',
		                renderer:dateFormat,
					    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd',
					    listeners : {
							'blur' : function(f) {
								if(f.getValue()>archiveScanViewForm.getForm().findField('zsbfrq_archiveScan').getValue()){
									archiveScanViewForm.getForm().findField('zsbfrq_archiveScan').setValue('');
								}
								archiveScanViewForm.getForm().findField('zsbfrq_archiveScan').minValue=f.getValue();
							}
						}
				    })]
			},{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '职工人数(人)',name : 'zgrs',labelSeparator:'',allowBlank : true,xtype : 'numberfield',maxValue : 2000000000,anchor:'99.9%'}]
	        },{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
		                id:'zsbfrq_archiveScan',
		                name: 'zsbfrq',
		                format:'Y-m-d',
		                maxValue:myDate,  
		                maxText:'所选日期应在{0}之前',  
		                //minValue:myDate,
		                minText:'所选日期应在{0}之后',
		                //width:150,
		                anchor:'100%',
		                allowBlank : true,
		                fieldLabel:'证照有效期',
		                renderer:dateFormat,
		                labelSeparator:'',
					    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd'
						//dateRange:{begin:'zsbfrq_archiveScan',end:'zszfrq_archiveScan'},//用于vtype类型dateRange   
                		//vtype:'dateRange'
				        })]
			},{
                columnWidth:.5,
                layout: 'form',
                border:false,
                items: [new Ext.form.DateField({  
					    id:'zszfrq_archiveScan',
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
					    dateRange:{begin:'zsbfrq_archiveScan',end:'zszfrq_archiveScan'},//用于vtype类型dateRange   
            			vtype:'dateRange'
					})]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jjlxdm_archiveScan",
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
					    	window_jjlxQuery_archiveScan.show();
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
	                border:false,
	                items: [{xtype:'textfield',fieldLabel : '企业注册类型名称',id:"select_jjlxmc_archiveScan",name : 'jjlx',readOnly:true,labelSeparator:'',hideLabel:true,anchor:'99.9%'},
	                	{xtype:'hidden',id:"select_jjlxmcOld_archiveScan",name : 'jjlxOld'},
	                	{xtype:'hidden',id:"select_jjlxdmOld_archiveScan",name : 'jjlxdmOld'}]
	        },{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jjhydm_archiveScan",
						name:"jjhydm",
						fieldLabel:"经济行业",
					 	valueField : "jjhydm",
					    displayField : "jjhydm",
					    maxLength : 50,
					    allowBlank : true,
					    haveShow : false,
					    labelSeparator:'',
					    anchor:'97%',
					    editable : false,
					    onTriggerClick : function() {
					    	window_hylxQuery_archiveScan.show();
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
	                border:false,
	                items: [{xtype:'textfield',fieldLabel : '经济行业名称',id:"select_jjhymc_archiveScan",name : 'jjhymc',allowBlank : true,readOnly:true,labelSeparator:'',hideLabel:true,anchor:'99.9%'}]
	        },{
	                columnWidth:.3,
	                layout: 'form',
	                border:false,
	                items: [{xtype:'textfield',fieldLabel : '注册资金(万)',name : 'zczj',labelSeparator:'',allowBlank : true,xtype : 'numberfield',decimalPrecision :6,value:'0',maxValue : 2000000000,anchor:'97%'}]
	        },{
	                columnWidth:.2,
	                layout: 'form',
	                border:false,
	                items: [{xtype : 'combo',
						fieldLabel : '货币种类',
						id : 'hbzl_archiveScan',
						displayField : 'categoryName',//显示值的名称
						hiddenName : 'hbzl',//真正提交时此combo的name
						valueField : 'categoryName',//真正提交时此combo的value
						mode : 'remote',
						store : ds_hbzl_select_as,
						selectOnFocus : true,
						maxLength : 50,
						hideLabel:true,
						anchor:'100%',
						editable : false,
						labelSeparator:'',
						triggerAction : 'all',
						value:'人民币元',
						loadingText : '加载中...',
						listeners : {
							'select' : function(combo, record, index) {
								archiveScanViewForm.getForm().findField('hbzldm_archiveScan').setValue(record.data.categoryCode);
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
						id : 'wftzgb_archiveScan',
						displayField : 'categoryName',//显示值的名称
						hiddenName : 'wftzgb',//真正提交时此combo的name
						valueField : 'categoryName',//真正提交时此combo的value
						mode : 'remote',
						store : ds_wftzgb_select_as,
						selectOnFocus : true,
						anchor:'100%',
						maxLength : 50,
						editable : true,
						allowBlank : true,
						labelSeparator:'',
						value:'',
						triggerAction : 'all',
						loadingText : '加载中...',
						listeners : {
							'select' : function(combo, record, index) {
								archiveScanViewForm.getForm().findField('wftzgbdm_archiveScan').setValue(record.data.categoryCode);
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
	                items: [{xtype:'textfield',fieldLabel : '外方国别代码',id : 'wftzgbdm_archiveScan',name : 'wftzgbdm',labelSeparator:'',hideLabel:true,allowBlank : true,anchor:'99.9%'}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [new Ext.form.TriggerField({
							id:"select_zgdm_archiveScan",
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
						    	window_zgmcQuery_archiveScan.show();
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
	                items: [{xtype:'textfield',fieldLabel : '主管部门名称',name :'zgmc',labelSeparator:'',id:"select_zgmc_archiveScan",hideLabel:true,anchor:'99.9%'}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [new Ext.form.TriggerField({
							id:"select_pzjgdm_archiveScan",
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
						    	window_pzjgQuery_as.show();
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
	                items: [{xtype:'textfield',fieldLabel : '批准机构名称',name:'pzjgmc',labelSeparator:'',id:"select_pzjgmc_archiveScan",allowBlank : true,hideLabel:true,anchor:'99.9%'}]
	            },{
	                columnWidth:.45,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '注册号',name : 'zch',id : 'zch_archivescan',labelSeparator:'',allowBlank : false,maxLength : 50,anchor:'100%',
						enableKeyEvents:true,
				                		listeners: {
				                			keyup: function(f,e){
				                				archiveScanViewForm.findById('zch_arcscan').setText("("+f.getValue().length+")");
				                			}
				                		}
					}]
	            },{
					columnWidth : .05,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'label',
					items : [{id:'zch_arcscan',name:'zch_arcscan',text:'(0)'}]
			    },{
	                columnWidth:.45,
	                layout: 'form',
	                border:false,
	                items: [{ 
	                	xtype:'textfield',fieldLabel : '联系电话',name : 'dhhm',labelSeparator:'',
	                	vtype:'phone',maxLength : 50,anchor:'100%'
	                	,enableKeyEvents:true,
	            		listeners: {
	            			keyup: function(f,e){
	            				archiveScanViewForm.findById('dhhm_arcscan').setText("("+f.getValue().length+")");
	            			}
	            		}
	                }]
	            },{
					columnWidth : .05,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'label',
					items : [{id:'dhhm_arcscan',name:'dhhm_arcscan',text:'(0)'}]
			    },{
	                columnWidth:1,
	                layout: 'form',
	                border:false,
	                items: [
	                	{ xtype:'textfield',fieldLabel : '机构注册地址',name : 'jgdz',labelSeparator:'',allowBlank : true,maxLength : 100,anchor:'99.9%'}
	                ]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [
	                	new Ext.form.TriggerField({
							fieldLabel : '行政区划',
							id : 'xzqhCode_archiveScan',
					    	name : 'xzqhCode',  //接收值的名称
							displayField : 'xzqhCode', //显示值的名称
							valueField : 'xzqhCode',  //真正提交时此combo的value
							maxLength : 50,
							allowBlank : true,
							labelSeparator:'',
						    haveShow : false,
						    anchor : '98%',
						    editable : false,
						    onTriggerClick : function() {
						    	window_xzqhQuery_archiveScan.show();
						    },
						    listeners : {
								'specialkey' : function(field, e) {
									if (e.getKey() == Ext.EventObject.ENTER) {
										findXzqhNameByXzqhCode(field,'xzqhName_archiveScan');
									}
								},
								'blur': function(field){
									findXzqhNameByXzqhCode(field,'xzqhName_archiveScan');
								}
							}
					    })
					]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '行政区划名称',id:'xzqhName_archiveScan',name : 'xzqhName',labelSeparator:'',allowBlank : true,hideLabel:true,readOnly:true,maxLength : 50,anchor:'99.9%'}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '邮政编码',name : 'yzbm',labelSeparator:'',allowBlank : true,minLength : 6,maxLength : 6,anchor:'100%'}]
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
							id : 'xzqhCode_archiveScan2',
					    	name : 'xzqhCode2',  //接收值的名称
							displayField : 'xzqhCode2', //显示值的名称
							valueField : 'xzqhCode2',  //真正提交时此combo的value
							maxLength : 50,
							labelSeparator:'',
						    haveShow : false,
						    anchor : '98%',
						    editable : false,
						    onTriggerClick : function() {
						    	window_xzqhQuery_archiveScan2.show();
						    },
						    listeners : {
								'specialkey' : function(field, e) {
									if (e.getKey() == Ext.EventObject.ENTER) {
										findXzqhNameByXzqhCode(field,'xzqhName_archiveScan2');
									}
								},
								'blur': function(field){
									findXzqhNameByXzqhCode(field,'xzqhName_archiveScan2');
								}
							}
					    })
					]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '行政区划名称',id:'xzqhName_archiveScan2',name : 'xzqhName2',labelSeparator:'',hideLabel:true,readOnly:true,maxLength : 50,anchor:'99.9%'}]
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
	                items: [{ xtype:'textfield',fieldLabel : '经办人',name : 'tbrxm',labelSeparator:'',allowBlank : true,maxLength : 30,anchor:'97%'}]
				},
				{
	                columnWidth:.15,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{
	                		xtype : 'combo',
							fieldLabel : '证件类型',
							id : 'zjlx2_archiveScan',
							name:'tbrzjlx',
							hiddenName : 'tbrzjlx',
							valueField : 'categoryName',
							displayField : 'categoryName',
							mode : 'remote',
							store : ds_zjlx_select,
							selectOnFocus : true,
							editable : false,
							allowBlank : true,
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
									var flag = isIdCardNo(archiveScanViewForm.getForm().findField('tbrsfzh').getValue());
									if(flag != true){
										archiveScanViewForm.getForm().findField('tbrsfzh').focus();
									}
								}else{
									archiveScanViewForm.getForm().findField('tbrsfzh').focus();
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
	                	xtype:'textfield',fieldLabel : '证件号码',name : 'tbrsfzh',labelSeparator:'',hideLabel:true,confirmTo:'zjlx2_archiveScan',vtype:'sfzhao',allowBlank : true,maxLength : 50,anchor:'95%',
	                	enableKeyEvents: true,
						listeners : {
							keyup: function(f, e){//计数
					    		archiveScanViewForm.findById('ts_as').setText("("+f.getValue().length+")");
					    	}
						}	
					}]
				},{
					columnWidth : '.03',
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'label',
					items : [{id:'ts_as',name:'ts_as',text:'(0)'}]
				},{
	                columnWidth:.2,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{ 
	                	xtype:'textfield',fieldLabel : '经办人电话',name : 'tbrlxfs',
	                	labelSeparator:'',allowBlank : true,maxLength : 50,anchor:'100%'
	                	,enableKeyEvents:true,
	            		listeners: {
	            			keyup: function(f,e){
	            				archiveScanViewForm.findById('tbrlxfs_arcscan').setText("("+f.getValue().length+")");
	            			}
	            		}
	                }]
				},{
					columnWidth : .05,
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'label',
					items : [{id:'tbrlxfs_arcscan',name:'tbrlxfs_arcscan',text:'(0)'}]
			    },{
	                columnWidth:.33,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [new Ext.form.DateField({  
						    id:'bzrq_archiveScan',
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
						    allowBlank : true,
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
						    id:'zfrq_archiveScan',
						    name: 'zfrq',
						    format:'Y-m-d',
						    maxValue:newZfrqYes,  
						    maxText:'所选日期应在{0}之前',  
						    minValue:myDate,
						    minText:'所选日期应在{0}之后',
						    anchor:'100%',
						    value:newZfrqYes,
						    fieldLabel:'作废日期',
						    allowBlank : true,
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
						    id:'njqx_archiveScan',
						    name: 'njqx',
						    format:'Y-m-d',
						    maxValue:newNjqx,  
						    maxText:'所选日期应在{0}之前',  
						    minValue:'01/01/1949',
						    minText:'所选日期应在{0}之后',
						    anchor:'100%',
						    labelSeparator:'',
						    fieldLabel:'年检期限',
						    allowBlank : true,
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
                	items: [{xtype:'textfield',fieldLabel : '备注',name : 'memo',labelSeparator:'',maxLength : 250,anchor:'99.9%'},
						{xtype : 'hidden',name : 'orgid',value:''},
					    {xtype : 'hidden',name : 'orderid',id:'orderid'},
					    {xtype : 'hidden',name : 'docid'},
						{xtype : 'hidden',name : 'zbsl',value:'1'},
						{xtype : 'hidden',name : 'fbsl',value:'1'},
						{xtype : 'hidden',name : 'isxw'},
						{xtype : 'hidden',name : 'fkbz'},
						{xtype : 'hidden',name : 'fksl'},
						{xtype : 'hidden',name : 'imageUrl'},
					    {xtype : 'hidden',id:'hbzldm_archiveScan',name : 'hbzldm',value:'156'},
					    {xtype : 'hidden',id:'select_jjhymcOld_archiveScan',name : 'jjhymcOld'},
					    {xtype : 'hidden',id:'select_jjhydmOld_archiveScan',name : 'jjhydmOld'},
					    {xtype : 'hidden',name : 'bzjgdm',value:currentZzUserBzjgdm},
						{xtype : 'hidden',name : 'lastdate',value :myDate.format('Y-m-d')}, 
						{xtype : 'hidden',name : 'njrq',value :myDate.format('Y-m-d')}, 
						{xtype : 'hidden',name : 'scbzrq',value :myDate.format('Y-m-d')}, 
						{xtype : 'hidden',name : 'lry',value:currentZzUsername},
						{xtype : 'hidden',name : 'xgr',value:currentZzUsername},
						{xtype : 'hidden',name : 'state',value:'10'}]
				}]
		}]
});


var  archiveScanViewForm2= new Ext.Panel({
    title       : '基本信息',
    id          : 'jbInfo390',
    region      : 'center',
    margins     : '3 0 0 0',
    cmargins    : '5 5 0 0',
	autoScroll : true,
	layout: 'fit',
	bodyStyle: 'padding:0px',
    items : [archiveScanViewForm]
});


var fileFtpForm_archiveScan = new Ext.Panel({
	title:'原文扫描',
	split: true,
	width:620,
	collapsible:true,
	collapsed: false,//是否默认打开
    region:'east',
    margins:'3 0 0 0',
    cmargins:'3 0 0 5',
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"  width=100%  height=100% align=center hspace=0 vspace=0 id="scanner74622"  name="scanner74622" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'<param name="OCRFlag" value="1">'
	       +'</OBJECT>'
    
});


//默认查询 档案
var searchArchiveScan = function() {
	archiveScanViewForm.getForm().reader = Orgnews;
	archiveScanViewForm.getForm().load({
		waitMsg : '正在进行数据查询，请稍等',          //提示信息   
        waitTitle : '提示',                         //标题  
	    url: 'findAllOrgnew.action', //请求控制器获取数据
	    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
	    params: { conditions:  text_search_archiveScan.getValue(),username:currentZzUsername,ywlxConditions:null,stateConditions:'10,11',start:1,limit:1},	
	    success:function(form,action) {//获取返回值
		    	if(action.result.data.state=='10' || action.result.data.state=='11'){//判断业务是否正在办理中
		    		btn_del_archiveScan.setDisabled(false);
		    		btn_shibie_archiveScan.setDisabled(true);
		    		var tab3452=Ext.getCmp("jbInfo390");
		    		tab3452.setTitle("基本信息  ("+stateToInfo(xinbanViewForm.getForm().findField('state').value)+")");
		    		archiveScanViewForm.getForm().findField('lastdate').setValue(myDate.format('Y-m-d'));
					archiveScanViewForm.getForm().findField('xgr').setValue(currentZzUsername);
					archiveScanViewForm.getForm().findField('select_jjlxmc_archiveScan').allowBlank=true;
					archiveScanViewForm.getForm().findField('select_jjlxdm_archiveScan').allowBlank=true;
					archiveScanViewForm.getForm().findField('wftzgb_archiveScan').allowBlank=true;
					archiveScanViewForm.getForm().findField('wftzgbdm_archiveScan').allowBlank=true;
		    		var resultObject = null;
		            //alert(action.result.data.orgid);
		    		Ext.Ajax.request({
						url : 'orgnewViewImg.action',
						params : {orgid : action.result.data.orgid},
						//waitTitle: '提示',
					    //waitMsg: '数据正在重新加载中，请稍后',
						success : function(result,request) {//获取返回值
							scanner74622.ImageData="";
		   					var resultObject = Ext.util.JSON.decode(result.responseText); 
		   					if(resultObject!=null){
			   					scanner74622.OpenProgress(3);  //设置上传的进度条的总进度数
			   					scanner74622.Progress('原文加载中',1);
								scanner74622.Progress('原文加载中',2);
			   					scanner74622.ImageData=resultObject.imageData;
			   					scanner74622.pageType=resultObject.pageTypeStr;
			   					if(scanner74622.ImageData!=""){
			   						scanner74622.Progress('原文加载完毕',3);
									scanner74622.CloseProgress();
								}else{
									scanner74622.Progress('原文加载失败',3);
					   				scanner74622.CloseProgress();
					   				alert("原文错误，加载失败！");
								}
		   					}
						},
						failure : function() {
							scanner74622.ImageData="";
				   			scanner74622.CloseProgress();
							alert("图像加载错误，或者无原文");
						}
					});	
		
				}else{
					btn_del_archiveScan.setDisabled(true);
				    btn_ok_archiveScan.setDisabled(true);
					Ext.Msg.show({
						title : '提示',
						msg : '机构正在进行“'+action.result.data.ywlx+'('+stateToInfo(action.result.data.state)+')”业务办理中!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.INFO,
						fn : function() {archiveScanViewForm.getForm().reset();scanner74622.ImageData="";}
					});
	            }

		},
		failure : function() {//正式库检索
			archiveScanViewForm.getForm().reader = Orgnews;
			archiveScanViewForm.getForm().load({
				waitMsg : '正在进行数据查询，请稍等',          //提示信息   
		        waitTitle : '提示',                      //标题  
			    url: 'findAllTjgdm.action', //请求控制器获取数据
			    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
			    params: { conditions:  text_search_archiveScan.getValue(),stateConditions:'',ywlxConditions:null,userBzjgdm:null,start:1,limit:1},	
			    success:function(form,action) {//获取返回值
				    	if(currentZzUsername!='admin' && sysBzjgLimitMode=='1' && action.result.data.bzjgdm!=currentZzUserBzjgdm){
			    				Ext.Msg.show({
									title : '提示',
									msg : '【'+action.result.data.jgmc+'】，<br><br>办证机构代码为“'+action.result.data.bzjgdm+'”,不属于本办证机构办理！',
									buttons : Ext.Msg.OK,
									fn:  function() {
											btn_del_archiveScan.setDisabled(true);
										    btn_shibie_archiveScan.setDisabled(false);
										    btn_print_archiveScan.setDisabled(true);
										    btn_save_archiveScan_menu.setDisabled(false);
											archiveScanViewForm.getForm().reset();
											scanner74622.ImageData="";
											var tab34528=Ext.getCmp("jbInfo390");
							    			tab34528.setTitle("基本信息");
									},
									icon : Ext.Msg.ERROR
								});
				    	}else{	
				    			if(action.result.data.state=='100' || action.result.data.state==''){ //判断此机构状态是否正常
							    	if(action.result.data.orgid!=''){//自动加载原文
					    					btn_save_archiveScan_menu.setDisabled(false);
								    		btn_del_archiveScan.setDisabled(true);
								    		btn_shibie_archiveScan.setDisabled(true);
								    		btn_print_archiveScan.setDisabled(true);
								    		btn_ok_archiveScan.setDisabled(true);
								    		var tab34527=Ext.getCmp("jbInfo390");
								    		tab34527.setTitle("基本信息  (新录入)");
								    		archiveScanViewForm.getForm().findField('ywlx').setValue('');
								    		archiveScanViewForm.getForm().findField('state').setValue('10');
								    		archiveScanViewForm.getForm().findField('orgid').setValue('');
					    					archiveScanViewForm.getForm().findField('lry').setValue(currentZzUsername);
									}else{
										Ext.Msg.show({
											title : '提示',
											msg : '机构没有办理代码业务!',
											buttons : Ext.Msg.OK,
											icon : Ext.Msg.ERROR
										});
						            }
						      }else{
									Ext.Msg.show({
										title : '提示',
										msg : '机构“'+action.result.data.jgmc+'”状态为“'+tjgdmStateToInfo(action.result.data.state)+'”,<br><br>不能再次办理业务！',
										buttons : Ext.Msg.OK,
										fn:  function() {
											btn_del_archiveScan.setDisabled(true);
										    btn_shibie_archiveScan.setDisabled(false);
										    btn_print_archiveScan.setDisabled(true);
										    btn_save_archiveScan_menu.setDisabled(false);
											archiveScanViewForm.getForm().reset();
											scanner74622.ImageData="";
											var tab34528=Ext.getCmp("jbInfo390");
							    			tab34528.setTitle("基本信息");
										},
										icon : Ext.Msg.ERROR
									});
					            }
				    	}
					},
					failure : function() {
						Ext.Msg.show({
							title : '提示',
							msg : '机构信息未查到!',
							width:250,
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.ERROR,
							fn:  function() {
								btn_del_archiveScan.setDisabled(true);
							    btn_shibie_archiveScan.setDisabled(false);
							    btn_print_archiveScan.setDisabled(true);
							    btn_save_archiveScan_menu.setDisabled(false);
								archiveScanViewForm.getForm().reset();
								scanner74622.ImageData="";
								var tab34528=Ext.getCmp("jbInfo390");
				    			tab34528.setTitle("基本信息");
							}
						});
					}	
			});
		}
	});
}




var btn_search_archiveScan = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchArchiveScan();
	}
});

var text_search_archiveScan = new Ext.form.TextField({
	id : 'textSearchArchiveScan',
	name : 'textSearchArchiveScan',
	width : 200,
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchArchiveScan();
			}
		}
	}
});


var btn_print_archiveScan = new Ext.Button({
	text : '打印申请表',
	iconCls : 'icon-print',
	disabled:true,
	handler : function(field){			
		var orgid = archiveScanViewForm.getForm().findField('orgid').value;
		if(orgid!=null && orgid!=""){
			ajaxLoadMask.show();
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
			alert("请保存信息后，再进行打印");
		}
	}
});

var btn_refresh_archiveScan = new Ext.Button({
	text : '重置',
	iconCls : 'icon-refresh',
	handler : function() {
		btn_del_archiveScan.setDisabled(true);
		btn_print_archiveScan.setDisabled(true);
    	btn_shibie_archiveScan.setDisabled(false);
		archiveScanViewForm.getForm().reset();
		var tab3452=Ext.getCmp("jbInfo390");
	    tab3452.setTitle("基本信息");
		scanner74622.ImageData="";
		archiveScanViewForm.getForm().findField('orgid').setValue('');
		archiveScanViewForm.getForm().findField('select_jjlxmc_archiveScan').allowBlank=true;
		archiveScanViewForm.getForm().findField('select_jjlxdm_archiveScan').allowBlank=true;
		archiveScanViewForm.getForm().findField('wftzgb_archiveScan').allowBlank=true;
		archiveScanViewForm.getForm().findField('wftzgbdm_archiveScan').allowBlank=true;
	}
});

var btn_del_archiveScan = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	disabled:true,
	handler : function() {
		var orgid = archiveScanViewForm.getForm().findField('orgid').value;
		if(orgid!=null && orgid!=""){
			Ext.Msg.confirm('确认删除', '你确定删除吗?', function(btn) {
				if (btn == 'yes') {
					ajaxLoadMask .show();
					Ext.Ajax.request({
						url : 'deleteOrgnew.action',
						params : {orgid : orgid},
						success : function() {
							ajaxLoadMask .hide();
							btn_del_archiveScan.setDisabled(true);
					    	btn_shibie_archiveScan.setDisabled(false);
							archiveScanViewForm.getForm().reset();
							var tab3452=Ext.getCmp("jbInfo390");
	    					tab3452.setTitle("基本信息");
							scanner74622.ImageData="";
						},
						failure : function() {
							ajaxLoadMask .hide();
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

        
var btn_shibie_archiveScan = new Ext.Button({
	text : '识别',
	iconCls : 'icon-add',
	//disabled:true,调用参数
	//scanner.GetOCRValue 返回 识别结果
	handler : function(){
		var ocrStr=scanner74622.GetOCRValue;
		//var ocrStr="[{id:'jgmc',value:'武汉顺利昌隆食品包装机械有限公司'},{id:'fddbr',value:'省贮口们u腭u绚医今亏'},{id:'jgdm',value:''},{id:'zjhm',value:''},{id:'zjlx',value:''},{id:'jyfw',value:'-食品机械、饮料机械、水处理设备、包装机械、不锈钢制品、五金电器、包装材料、水处理材料的批发零售（国家有专项规足旧7员日82甲1Ⅲ眉1侃死而1双野列、此万叫82鹤2。**薄'},{id:'zcrq',value:'2011年03月03日'},{id:'jjlx',value:''},{id:'zsbfrq',value:''},{id:'zczj',value:'壹拾万元整'},{id:'pzjgmc',value:''},{id:'zch',value:' 46420104000101842'},{id:'jgdz',value:'武汉市硕口区解放大道329号（三金香港映象）T11幢18层矗号'},{id:'jglx',value:'有限责任公司'},{id:'tbrxm',value:''},{id:'tbrsfzh',value:''},{id:'memo',value:'''}]";
		//alert(ocrStr);
		//,{id:'jyfw',value:'许可经营项目'},{id:'zcrq',value:'2011-07-27'},{id:'zczj',value:'10'},{id:'zch',value:'110106014104570'},{id:'jgdz',value:'北京市丰台区永外海户屯166号院5号楼101室'},{id:'jglx',value:'有限责任公司'},{id:'tbrxm',value:'高跃辉'},{id:'tbrsfzh',value:'410325198204126593'},{id:'tbrzjlx',value:'居民身份证'}
		//  var ocrStr="[{id:'jgmc',value:'11'},{id:'fddbr',value:'11'}]";
		//var ocrStr="[{id:'jgmc',value:'zhangsan'},{id:'fddbr',value:'15'}]";
		//var ocrStr="[{id:'jgmc',value:'北京顺光庆华商贸有限公司'},{id:'fddbr',value:'杨志英'},{id:'jyfw',value:'许可经营项目'},{id:'zcrq',value:'2011年07月27日'},{id:'zczj',value:'10'},{id:'zch',value:'110106014104570'},{id:'jgdz',value:'北京市丰台区永外海户屯166号院5号楼101室'},{id:'jglx',value:'有限责任公司'},{id:'tbrxm',value:'高跃辉'},{id:'tbrsfzh',value:'410325198204126593'},{id:'tbrzjlx',value:'居民身份证'}]";
 		//var ocrStr="[{id:'orgid',value:''},{id:'jgmc',value:'<font color=red>北京顺光庆华</font><font color=blue>商贸有限公司</font>'},{id:'jgdm',value:'123456789'},	{id:'fddbr',value:'杨志英'},	{id:'zjlx',value:'居民身份证'},{id:'zjhm',value:'342625197510120996'},{id:'jyfw',value:'在法律范围内，许可经营项目'},{id:'zcrq',value:'20110727'},{id:'zczj',value:'10'},	{id:'zch',value:'110106014104570'},{id:'jglx',value:'企业分支机构'},{id:'jglxdm',value:'15'},{id:'jgdz',value:'北京市丰台区永外海户屯166号院5号楼101室'},{id:'pzjgmc',value:'北京市工商局海淀分居'},{id:'pzjgdm',value:'110000021'},{id:'jjlx',value:'有限责任公司'},{id:'jjlxdm',value:'1100'},{id:'zsbfrq',value:'2012-11-07'},{id:'zszfrq',value:'2032-11-06'},{id:'wftzgb',value:'中国'},{id:'hbzl',value:'人民币'},{id:'jydz',value:'北京市丰台区永外海户屯166号院5号楼101室'},{id:'zgmc',value:'海淀国资委'},{id:'zgdm',value:'100001231'},{id:'dhhm',value:'010-62528899'},{id:'mobile',value:'13810101225'},{id:'jjhymc',value:'报纸出版'},{id:'jjhydm',value:'0102'},{id:'zgrs',value:'100'},{id:'xzqhCode',value:'100000220'},{id:'xzqhName',value:'北京市海淀区'},{id:'yzbm',value:'100098'},{id:'weburl',value:'www.sina.com'},{id:'email',value:'nenuo@sina.com'},{id:'tbrxm',value:'高跃辉'},{id:'tbrsfzh',value:'410325198204126593'},{id:'tbrzjlx',value:'居民身份证'},{id:'tbrlxfs',value:'13651031561'},{id:'gk',value:'是'}]";
		//var str="<font color='red'>www.5dblog.com/vip/</font><font color='blue'>allinhands</font>";
       //oA=document.createElement('A');
       //oA.innerHTML=str;
       //oA.href="http://www.5dblog.com/vip/allinhands33333/"
      // document.all('oTX').appendChild(oA)
		if(ocrStr!="" && ocrStr!=null){
			var respText = Ext.util.JSON.decode(ocrStr); 
			archiveScanViewForm.getForm().setValues(respText); 
			btn_del_archiveScan.setDisabled(true);
			archiveScanViewForm.getForm().findField('orgid').setValue('');
		}else{
			alert("请扫描或导入需识别的图片！");
		}
	}
});


var btn_save_archiveScan_menu = new Ext.Toolbar.MenuButton({
    text: '保存',
    handler: btn_archiveScan_saveAll,
    tooltip: {title:'保存数据和原文',text:'保存'},
    iconCls: 'blist',
    //disabled:true,
    menu : {items: [
                {text: '全部保存', handler: btn_archiveScan_saveAll}, '-',
                {text: '仅保存数据', handler: btn_archiveScan_saveInfo},
                {text: '仅上传原文', handler: btn_archiveScan_ftpFile}
        ]}
});

function btn_archiveScan_saveAll(btn){
	if (archiveScanViewForm.getForm().isValid()) {
		archiveScanViewForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在保存数据,请稍候...',
			success : function(form,action) {
				btn_ok_archiveScan.setDisabled(false);
   			btn_print_archiveScan.setDisabled(false);
				archiveScanViewForm.getForm().findField('orgid').setValue(action.result.orgid);
				archiveScanViewForm.getForm().findField('docid').setValue(action.result.docid);

				
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
				var strCheckArchives;
				var strYwlx;
				var strBzjgdm;
				
				strYwlx =archiveScanViewForm.getForm().findField('ywlx').value;  //参数ywlx
				strJglxdm =archiveScanViewForm.getForm().findField('jglxdm').value;  //参数ywlx
				strBzjgdm=archiveScanViewForm.getForm().findField('bzjgdm').value; 
				
				btn.disable();
				strOrgid = action.result.orgid;  //参数orgid
				strDocid = action.result.docid;
				
				packLength = 40960;	//定义每个包的大小40960
				base64file = scanner74622.ImageData;  //获取控件扫描的图片数据
				var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
				imageCount = scanner74622.GetPageCount;	//获取扫描图片的页数
				pageTypeStr = scanner74622.PageType;    //获取标识字符串,需要写数据库
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
				
				strCheckArchives=scanner74622.CheckArchives(strYwlx,jglxNewToOld(strJglxdm),"FALSE","FALSE")
				if (strCheckArchives!=""){
					imageFlag=strCheckArchives
					alert(strCheckArchives);
					if(scanCheckMode=="0"){//强制校验后，再保存
						btn.enable();
						return false;
					}
				}
			
				scanner74622.OpenProgress(packCount);  //设置上传的进度条的总进度数
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
						xmlhttp.open("post", "saveImageOrgnew.action?orgid="+strOrgid+"&docid="+strDocid+"&packindex="+i+"&pageTypeStr="+pageTypeStr+"&bzjgdm="+strBzjgdm+"&lastpack="+lastpack, false);
						xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   //这句必须要，而且一定要放在send以前
						xmlhttp.send("imageData=" + encodeURIComponent(pack)); 
						var objs = eval("["+xmlhttp.responseText+"]");
						if(objs[0].success)
						{
							scanner74622.Progress('上传中',i+1);
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
					msg : '['+archiveScanViewForm.getForm().findField('jgmc_archiveScan').getValue()+']，<br><br>申办信息保存成功！',
					buttons : Ext.Msg.OK,
					fn : function() {btn.enable();btn_print_archiveScan.setDisabled(false);btn_ok_archiveScan.setDisabled(false);},
					icon : Ext.Msg.INFO
				});

				scanner74622.CloseProgress();
				return true;
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


function btn_archiveScan_saveInfo(btn){
	if (archiveScanViewForm.getForm().isValid()) {
		archiveScanViewForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在保存数据,请稍候...',
			success : function(form,action) {
				//alert(archiveScanViewForm.getForm().findField('ywlx').getValue());
				archiveScanViewForm.getForm().findField('orgid').setValue(action.result.orgid);
				archiveScanViewForm.getForm().findField('docid').setValue(action.result.docid);
				Ext.Msg.show({
					title : '提示',
					msg : '['+archiveScanViewForm.getForm().findField('jgmc_archiveScan').getValue()+']，<br><br>申办信息保存成功！',
					buttons : Ext.Msg.OK,
					fn : function() {btn.enable();btn_print_archiveScan.setDisabled(false);btn_ok_archiveScan.setDisabled(false);},
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

function btn_archiveScan_ftpFile(btn){
	
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
	var imageFlag;
	var strCheckArchives;
	var strYwlx;
	var strBzjgdm;
	
	btn.disable();
	strOrgid =archiveScanViewForm.getForm().findField('orgid').value;  //参数orgid
	strDocid =archiveScanViewForm.getForm().findField('docid').value;  //参数docid
	strYwlx =archiveScanViewForm.getForm().findField('ywlx').value;  //参数ywlx
	strJglxdm =archiveScanViewForm.getForm().findField('jglxdm').value;  //参数ywlx
	strBzjgdm=archiveScanViewForm.getForm().findField('bzjgdm').value;  //办证机构代码
	//alert("strOrgid="+strOrgid);
	
	if(strOrgid!=""){
			packLength = 40960;	//定义每个包的大小40960
			//scanner74622.ImageData=document.getElementById("ImageData").value;
			base64file = scanner74622.ImageData;  //获取控件扫描的图片数据
			var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
			imageCount = scanner74622.GetPageCount;	//获取扫描图片的页数
			pageTypeStr = scanner74622.PageType;    //获取标识字符串,需要写数据库
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
			
			strCheckArchives=scanner74622.CheckArchives(strYwlx,jglxNewToOld(strJglxdm),"FALSE","FALSE")
			if (strCheckArchives!=""){
				imageFlag=strCheckArchives
				alert(strCheckArchives);
				if(scanCheckMode=="0"){//强制校验后，再保存
					btn.enable();
					return false;
				}
			}
			
			
			scanner74622.OpenProgress(packCount);  //设置上传的进度条的总进度数
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
					xmlhttp.open("post", "saveImageOrgnew.action?orgid="+strOrgid+"&docid="+strDocid+"&packindex="+i+"&pageTypeStr="+pageTypeStr+"&imageFlag="+imageFlag+"&bzjgdm="+strBzjgdm+"&lastpack="+lastpack, false);
					xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   //这句必须要，而且一定要放在send以前
					xmlhttp.send("imageData=" + encodeURIComponent(pack)); 
					//alert("上传返回的值"+xmlhttp.responseText);
		         
					var objs = eval("["+xmlhttp.responseText+"]");
					if(objs[0].success){
						scanner74622.Progress('上传中',i+1);
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
			
			scanner74622.CloseProgress();
			
			Ext.Msg.show({
				title : '提示',
				msg : '['+archiveScanViewForm.getForm().findField('jgmc_archiveScan').getValue()+']，<br><br>原文上传成功！',
				buttons : Ext.Msg.OK,
				fn : function() {btn.enable();btn_print_archiveScan.setDisabled(false);btn_ok_archiveScan.setDisabled(false);},
				icon : Ext.Msg.INFO
			});
			
			scanner74622.CloseProgress();
			return true;
	}else{
		alert("请录入数据后，再上传原文！");
	}
}


var btn_ok_archiveScan = new Ext.Button({
	text : '提交办理',
	iconCls : 'icon-store',
	handler : function(){
		var orgid = archiveScanViewForm.getForm().findField('orgid').value;
		var strState = archiveScanViewForm.getForm().findField('state').value;
		var strJgmc = archiveScanViewForm.getForm().findField('jgmc_archiveScan').getValue();
		var strYwlx = archiveScanViewForm.getForm().findField('ywlx').value;
		var strJglxdm = archiveScanViewForm.getForm().findField('jgdm').value;
		var strCheckArchives;
		var imageFlag;
		var strIsOK="0";
		if(orgid!=null && orgid!=""){
			
			strCheckArchives=scanner74622.CheckArchives(strYwlx,jglxNewToOld(strJglxdm),"FALSE","FALSE")
			imageFlag=strCheckArchives
			if (strCheckArchives!=""){
				
				if(scanCheckMode!="0"){//强制校验后，再保存
					strIsOK="1";
				}else{
					strIsOK="0";
					Ext.Msg.show({
						title : '提示',
						msg : strCheckArchives+'<br><br>请扫描全部办证资料后，再提交办理！',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.INFO
					});
				}
			}else{
				strIsOK="1";
			}
			
			if(strIsOK=="1"){//可以提交
				ajaxLoadMask.show();
				Ext.Ajax.request({
					url: 'returnOrgnewDo.action',
	   				params: {orgid: orgid,state:strState,ywlx:strYwlx},
	   				success: function(){
	   					ajaxLoadMask .hide();
	   					Ext.Msg.show({
							title : '提示',
							msg : '[' + strJgmc + ']申请单提交完毕！',
							buttons : Ext.Msg.OK,
							fn:  function() {
			   					archiveScanViewForm.getForm().findField('orgid').setValue('');
			   					btn_ok_archiveScan.setDisabled(true);
			   					btn_print_archiveScan.setDisabled(true);
			   					var tab345293=Ext.getCmp("jbInfo390");
					    		tab345293.setTitle("基本信息");
								scanner74622.PageType="";
								scanner74622.ImageData="";
								archiveScanViewForm.getForm().reset();
								text_search_archiveScan.setValue("");
							},
							icon : Ext.Msg.INFO
						});
	   				},
	   				failure: function(){
	   					ajaxLoadMask .hide();
	   					Ext.Msg.show({
							title : '提示',
							msg : '[' + strJgmc + ']申请单提交失败！',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.ERROR
						});
	   				}
				});	
			}
		}else{
			Ext.Msg.show({
				title : '提示',
				msg : '请保存信息后，再提交办理！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.INFO
			});
		}
	}
});


var p_zzArchiveScan = {
	id : 'zzArchiveScan-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:0px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    bodyBorder: false,
	    title: '扫描录入',
	    iconCls : 'icon-plugin',
 		plain: true,
		region: 'center',
		tbar : [btn_shibie_archiveScan,btn_refresh_archiveScan,btn_del_archiveScan,btn_save_archiveScan_menu,btn_print_archiveScan,btn_ok_archiveScan,'->',text_search_archiveScan,btn_search_archiveScan],
		items: [archiveScanViewForm2,fileFtpForm_archiveScan]
	}]
}