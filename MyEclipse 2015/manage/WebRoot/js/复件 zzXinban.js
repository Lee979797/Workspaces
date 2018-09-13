

var searchXzqh_xinban = function() {
	ds_xzqh_xinban.baseParams.conditions = text_search_xzqh_xinban.getValue();
	ds_xzqh_xinban.baseParams.username='';
	ds_xzqh_xinban.baseParams.stateConditions='';
	ds_xzqh_xinban.load({params : {start : 0,limit : 20} });
}

var btn_search_xzqh_xinban = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchXzqh_xinban();
	}
});

var text_search_xzqh_xinban = new Ext.form.TextField({
	id : 'textSearchXzqh_xinban',
	name : 'textSearchXzqh_xinban',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchXzqh_xinban();
			}
		},
		'change' : function(field, e) {
			searchXzqh_xinban();
			//btn_search_xzqh_xinban.setDisabled(false);
		}
	}
});

var cm_xzqh_xinban = new Ext.grid.ColumnModel([
	{header : '行政区划名称',width : 50,dataIndex : 'xzqhName',sortable : true},
	{header : '行政区划代码',width : 20,dataIndex : 'xzqhCode',sortable : true}
]);

var ds_xzqh_xinban = new Ext.data.Store({
	url : 'findAllByConditionXzqh.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'xzqhCode',type : 'string'},
			{name : 'xzqhName',type : 'string'},
			{name : 'xzqhNote',type : 'string'}
		])
});
var grid_xzqh_xinban = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_xzqh_xinban,
	ds : ds_xzqh_xinban,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入行政区划名称：',text_search_xzqh_xinban,btn_search_xzqh_xinban],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_xzqh_xinban,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_xzqhQuery_xinban.hide();
			var selections=grid.getSelectionModel().getSelections();
			xinbanViewForm.getForm().findField('xzqhName_xinban').setValue(selections[0].get('xzqhName'));
			xinbanViewForm.getForm().findField('xzqhCode_xinban').setValue(selections[0].get('xzqhCode'));
		}
	}
});

var window_xzqhQuery_xinban = new Ext.Window({
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
	items : [grid_xzqh_xinban]
});
//行政区划的到此结束

var btn_search_pzjg_xb = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchPzjg_xb();
		//btn_search_pzjg_xb.setDisabled(true);
	}
});


var text_search_pzjg_xb = new Ext.form.TextField({
	id : 'textSearchPzjg_xb',
	name : 'textSearchPzjg_xb',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchPzjg_xb();
			}
		},
		'change' : function(field, e) {
			btn_search_pzjg_xb.setDisabled(false);
		}
	}
});


var cm_pzjg_xb = new Ext.grid.ColumnModel([
	{header : '批准机构名称',width : 50,dataIndex : 'pzjgmc',sortable : true}, 
	{header : '批准机构代码',width : 20,dataIndex : 'pzjgdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_pzjg_xb = new Ext.data.Store({
	url : 'findAllByConditionPzjg.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'pzjgid',type : 'int'}, 
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchPzjg_xb = function() {
	ds_pzjg_xb.baseParams.conditions = text_search_pzjg_xb.getValue();
	ds_pzjg_xb.baseParams.username='';
	ds_pzjg_xb.baseParams.stateConditions='';
	ds_pzjg_xb.load({params : {start : 0,limit : 20} });
}

var grid_pzjg_xb = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_pzjg_xb,
	ds : ds_pzjg_xb,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入登记批准机构名称：',text_search_pzjg_xb,btn_search_pzjg_xb],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_pzjg_xb,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_pzjgQuery_xb.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			xinbanViewForm.getForm().findField('select_pzjgmc_xinban').setValue(selections[0].get('pzjgmc'));
			xinbanViewForm.getForm().findField('select_pzjgdm_xinban').setValue(selections[0].get('pzjgdm'));
		}
	}
});


var window_pzjgQuery_xb = new Ext.Window({
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
	items : [grid_pzjg_xb]
});


var btn_search_jglxSelcet_xb = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJglxSelcet_xb();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_jglxSelcet_xb = new Ext.form.TextField({
	id : 'textsearchJglxSelcet_xb',
	name : 'textsearchJglxSelcet_xb',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJglxSelcet_xb();
			}
		},
		'change' : function(field, e) {
			btn_search_jglxSelcet_xb.setDisabled(false);
		}
	}
});


var cm_jglxSelcet_xb = new Ext.grid.ColumnModel([
    {header : '一级类型',width : 60,dataIndex : 'pjglxmc',sortable : true}, 
	{header : '二级类型',width : 100,dataIndex : 'jglxmc',sortable : true}, 
	{header : '代码',width : 30,dataIndex : 'jglxdm',sortable : true},
	{header : '备注',width : 50,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_jglxSelcet_xb = new Ext.data.Store({
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

var ds_hbzl_select_xb = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=1',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});

var searchJglxSelcet_xb = function() {
	ds_jglxSelcet_xb.baseParams.conditions = text_search_jglxSelcet_xb.getValue();
	ds_jglxSelcet_xb.baseParams.username="";
	ds_jglxSelcet_xb.baseParams.stateConditions='';
	ds_jglxSelcet_xb.load({params : {start : 0,limit : 20} });
}

var grid_jglx_xinban = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jglxSelcet_xb,
	ds : ds_jglxSelcet_xb,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入机构类型名称：',text_search_jglxSelcet_xb,btn_search_jglxSelcet_xb],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jglxSelcet_xb,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jglxQuery_xinban.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			xinbanViewForm.getForm().findField('select_jglxmc_xinban').setValue(selections[0].get('jglxmc'));
			xinbanViewForm.getForm().findField('select_jglxdm_xinban').setValue(selections[0].get('jglxdm'));
			
			if(selections[0].get('pjglxdm')==1){
				xinbanViewForm.getForm().findField('select_jjlxmc_xinban').allowBlank=false;
				xinbanViewForm.getForm().findField('select_jjlxdm_xinban').allowBlank=false;
			}else{
				xinbanViewForm.getForm().findField('select_jjlxmc_xinban').allowBlank=true;
				xinbanViewForm.getForm().findField('select_jjlxdm_xinban').allowBlank=true;
			}
		}
	}
});


var window_jglxQuery_xinban = new Ext.Window({
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
	items : [grid_jglx_xinban]
});

var btn_search_hylxSelcet_xb = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchHylxSelcet_xinban();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_hylxSelcet_xb = new Ext.form.TextField({
	id : 'textSearchHylxSelcet_xb',
	name : 'textSearchHylxSelcet_xb',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchHylxSelcet_xinban();
			}
		},
		'change' : function(field, e) {
			btn_search_hylxSelcet_xb.setDisabled(false);
		}
	}
});

var ds_wftzgb_select_xb = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=3',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});

var cm_hylxSelcet_xb = new Ext.grid.ColumnModel([
	{header : '大类',width : 60,dataIndex : 'hylxmc1',sortable : true}, 
	{header : '中类',width : 60,dataIndex : 'hylxmc2',sortable : true}, 
	{header : '小类',width : 60,dataIndex : 'hylxmc3',sortable : true}, 
    {header : '经济行业名称',width : 60,dataIndex : 'hylxmc',sortable : true},
	{header : '经济行业代码',width : 30,dataIndex : 'hylxdm',sortable : true},
	{header : '备注',width : 60,dataIndex : 'note',menuDisabled : true}
]);


//查询返回结果的数据列
var ds_hylxSelcet_xinban = new Ext.data.Store({
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

var searchHylxSelcet_xinban = function() {
	ds_hylxSelcet_xinban.baseParams.conditions = text_search_hylxSelcet_xb.getValue();
	ds_hylxSelcet_xinban.baseParams.username="";
	ds_hylxSelcet_xinban.baseParams.stateConditions='';
	ds_hylxSelcet_xinban.load({params : {start : 0,limit : 20} });
}

var grid_hylx_xinban = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_hylxSelcet_xb,
	ds : ds_hylxSelcet_xinban,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入经济行业代码名称：',text_search_hylxSelcet_xb,btn_search_hylxSelcet_xb],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_hylxSelcet_xinban,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_hylxQuery_xinban.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			xinbanViewForm.getForm().findField('select_jjhymc_xinban').setValue(selections[0].get('hylxmc'));
			xinbanViewForm.getForm().findField('select_jjhydm_xinban').setValue(selections[0].get('hylxdm'));
			xinbanViewForm.getForm().findField('select_jjhymcOld_xinban').setValue(selections[0].get('hylxmcOld'));
			xinbanViewForm.getForm().findField('select_jjhydmOld_xinban').setValue(selections[0].get('hylxdmOld'));
		}
	}
});


var window_hylxQuery_xinban = new Ext.Window({
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
	items : [grid_hylx_xinban]
});


var btn_search_jjlx_xinban = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJjlx_xinban();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_jjlx_xinban = new Ext.form.TextField({
	id : 'textSearchJjlx_xinban',
	name : 'textSearchJjlx_xinban',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJjlx_xinban();
			}
		},
		'change' : function(field, e) {
			btn_search_jjlx_xinban.setDisabled(false);
		}
	}
});


var cm_jjlx_xinban = new Ext.grid.ColumnModel([
    {header : '大类',width : 30,dataIndex : 'pjjlxmc',sortable : true}, 
    {header : '中类',width : 30,dataIndex : 'pjjlxmc2',sortable : true}, 
    {header : '小类',width : 30,dataIndex : 'pjjlxmc3',sortable : true}, 
	{header : '经济类型名称',width : 100,dataIndex : 'jjlxmc',sortable : true}, 
	{header : '经济类型代码',width : 30,dataIndex : 'jjlxdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_jjlx_xinban = new Ext.data.Store({
	url : 'findAllByConditionJjlx.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'jjlxid',type : 'int'}, 
	    {name : 'pjjlxmc',type : 'string'},
	    {name : 'pjjlxmc2',type : 'string'},
	    {name : 'pjjlxmc3',type : 'string'},
		{name : 'jjlxmc',type : 'string'},
		{name : 'jjlxdm',type : 'string'},
		{name : 'ojjlxmc',type : 'string'},
		{name : 'ojjlxdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});


var searchJjlx_xinban = function() {
	ds_jjlx_xinban.baseParams.conditions = text_search_jjlx_xinban.getValue();
	ds_jjlx_xinban.baseParams.username='';
	ds_jjlx_xinban.baseParams.stateConditions='';
	ds_jjlx_xinban.load({params : {start : 0,limit : 20} });
}

var grid_jjlx_xinban = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jjlx_xinban,
	ds : ds_jjlx_xinban,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入企业登记注册类型名称：',text_search_jjlx_xinban,btn_search_jjlx_xinban],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jjlx_xinban,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jjlxQuery_xinban.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			xinbanViewForm.getForm().findField('select_jjlxmc_xinban').setValue(selections[0].get('jjlxmc'));
			xinbanViewForm.getForm().findField('select_jjlxdm_xinban').setValue(selections[0].get('jjlxdm'));
			xinbanViewForm.getForm().findField('select_jjlxmcOld_xinban').setValue(selections[0].get('ojjlxmc'));
			xinbanViewForm.getForm().findField('select_jjlxdmOld_xinban').setValue(selections[0].get('ojjlxdm'));
			
			if(selections[0].get('jjlxdm')>5000 && selections[0].get('jjlxdm')<8000){
				xinbanViewForm.getForm().findField('wftzgb_xinban').allowBlank=false;
				xinbanViewForm.getForm().findField('wftzgbdm_xinban').allowBlank=false;
				if(selections[0].get('jjlxdm')>6000 && selections[0].get('jjlxdm')<7000){
					xinbanViewForm.getForm().findField('wftzgb_xinban').setValue('港澳台');
					xinbanViewForm.getForm().findField('wftzgbdm_xinban').setValue('344');
				}
			}else{
				xinbanViewForm.getForm().findField('wftzgb_xinban').setValue('');
				xinbanViewForm.getForm().findField('wftzgbdm_xinban').setValue('');
				xinbanViewForm.getForm().findField('wftzgb_xinban').allowBlank=true;
				xinbanViewForm.getForm().findField('wftzgbdm_xinban').allowBlank=true;
			}	
		}
	}
});


var window_jjlxQuery_xinban = new Ext.Window({
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
	items : [grid_jjlx_xinban]
});

//主管部门
var searchZgmc_xb = function() {
	ds_zgmc_xb.baseParams.conditions = text_search_zgmc_xb.getValue();
	ds_zgmc_xb.baseParams.username='';
	ds_zgmc_xb.baseParams.stateConditions='';
	ds_zgmc_xb.load({params : {start : 0,limit : 20} });
}

var btn_search_zgmc_xb = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchZgmc_xb();
		//btn_search_pzjg.setDisabled(true);
	}
});

var text_search_zgmc_xb = new Ext.form.TextField({
	id : 'textSearchZgmc_xb',
	name : 'textSearchZgmc_xb',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchZgmc_xb();
			}
		},
		'change' : function(field, e) {
			btn_search_zgmc_xb.setDisabled(false);
		}
	}
});

var cm_zgmc_xb = new Ext.grid.ColumnModel([
	{header : '主管部门名称',width : 50,dataIndex : 'zgjgmc',sortable : true}, 
	{header : '主管部门代码',width : 20,dataIndex : 'jgdm',sortable : true}
]);

var ds_zgmc_xb = new Ext.data.Store({
	url : 'findAllByConditionZgbm.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
		[
			{name : 'jgdm',type : 'string'},
			{name : 'zgjgmc',type : 'string'}
		])
});

var grid_zgmc_xb = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_zgmc_xb,
	ds : ds_zgmc_xb,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入主管部门名称：',text_search_zgmc_xb,btn_search_zgmc_xb],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_zgmc_xb,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_zgmcQuery_xinban.hide();
			var selections=grid.getSelectionModel().getSelections();
			xinbanViewForm.getForm().findField('select_zgmc_xinban').setValue(selections[0].get('zgjgmc'));
			xinbanViewForm.getForm().findField('select_zgdm_xinban').setValue(selections[0].get('jgdm'));
		}
	}
});

var window_zgmcQuery_xinban = new Ext.Window({
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
	items : [grid_zgmc_xb]
});


//--------------------机构基本信息-------------------------------------------
var xinbanViewForm = new Ext.FormPanel({	
	url : 'saveOrgnew.action',
	labelAlign : 'right',
    bodyStyle:'padding:0px',
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
                columnWidth:.3,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jglxdm_xinban",
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
					    	window_jglxQuery_xinban.show();
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
                items: [{ xtype:'textfield',id:"select_jglxmc_xinban",name : 'jglx',labelSeparator:'',hideLabel:true,allowBlank : false,readOnly:'true',maxLength : 50,anchor:'100%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype : 'combo',
						fieldLabel : '小微企业',
						id : 'isxw_xinban',
						name : 'isxw',
						displayField : 'isxw',
						valueField : 'isxw',
						hiddenName : 'isxw',
						store : isxwStore,
						triggerAction : 'all',
						lazyRender:true,
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
						id : 'gk_xinban',
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
						id : 'fkbz_xinban',
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
								if(val.getValue()=='否'){
									xinbanViewForm.getForm().findField('fksl').setValue('0');
								}else{
									xinbanViewForm.getForm().findField('fksl').setValue('1');
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
                	{ xtype:'textfield',fieldLabel : '发卡数量',name : 'fksl',labelSeparator:'',allowBlank : false,xtype : 'numberfield',value:1,maxValue : 2000000000,anchor:'100%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构代码',id:'jgdm_xinban',name : 'jgdm',labelSeparator:'',allowBlank : true,vtype:'verifyCode',readOnly:'true',maxLength : 9,minLength:9,anchor:'100%'}]
			},{
                columnWidth:.75,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构名称',id:'jgmc_xinban',name : 'jgmc',labelSeparator:'',allowBlank : false,maxLength : 100,anchor:'99.9%'}]
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
						id : 'zjlx_xinban',
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
						value:'居民身份证',
						triggerAction : 'all',
						loadingText : '加载中...',
						listeners : {
							'select' : function(combo, record, index) {
								if(record.data.categoryName=='居民身份证'){
									var flag = isIdCardNo(xinbanViewForm.getForm().findField('zjhm').getValue());
									if(flag != true){
										xinbanViewForm.getForm().findField('zjhm').focus();
									}
								}else{
									xinbanViewForm.getForm().findField('zjhm').focus();
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
                	xtype:'textfield',fieldLabel : '证件号码',name : 'zjhm',labelSeparator:'',hideLabel:true,allowBlank : false,confirmTo:'zjlx_xinban',vtype:'sfzhao',maxLength : 25,anchor:'99.9%',
                	enableKeyEvents: true,
					listeners : {
						keyup: function(f, e){//计数
				    		xinbanViewForm.findById('ws_xb').setText("("+f.getValue().length+")");
				    	}
					}
				}]
			},{
				columnWidth : '.03',
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'ws_xb',name:'ws_xb',text:'(0)'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '移动电话',id : 'mobile_xb',name : 'mobile',allowBlank : false,labelSeparator:'',vtype:'mobilephone',maxLength:11,minLength:11,anchor:'100%'}]
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
				    		xinbanViewForm.findById('fw_xb').setText("("+length+")");
				    	}
			    	}
                }]
			},{
				columnWidth : .05,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'fw_xb',name:'fw_xb',text:'(1000)'}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
		                id:'zcrq_xinban',
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
								if(f.getValue()>xinbanViewForm.getForm().findField('zsbfrq_xinban').getValue()){
									xinbanViewForm.getForm().findField('zsbfrq_xinban').setValue('');
								}
								xinbanViewForm.getForm().findField('zsbfrq_xinban').minValue=f.getValue();
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
		                id:'zsbfrq_xinban',
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
						//dateRange:{begin:'zsbfrq_xinban',end:'zszfrq_xinban'},//用于vtype类型dateRange   
                		//vtype:'dateRange'
				        })]
			},{
                columnWidth:.5,
                layout: 'form',
                border:false,
                items: [new Ext.form.DateField({  
					    id:'zszfrq_xinban',
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
					    dateRange:{begin:'zsbfrq_xinban',end:'zszfrq_xinban'},//用于vtype类型dateRange   
            			vtype:'dateRange'
					})]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jjlxdm_xinban",
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
					    	window_jjlxQuery_xinban.show();
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
	                items: [{xtype:'textfield',fieldLabel : '企业注册类型名称',id:"select_jjlxmc_xinban",name : 'jjlx',readOnly:true,labelSeparator:'',hideLabel:true,anchor:'99.9%'},
	                	{xtype:'hidden',id:"select_jjlxmcOld_xinban",name : 'jjlxOld'},
	                	{xtype:'hidden',id:"select_jjlxdmOld_xinban",name : 'jjlxdmOld'}]
	        },{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jjhydm_xinban",
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
					    	window_hylxQuery_xinban.show();
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
	                items: [{xtype:'textfield',fieldLabel : '经济行业名称',id:"select_jjhymc_xinban",name : 'jjhymc',allowBlank : false,readOnly:true,labelSeparator:'',hideLabel:true,anchor:'99.9%'}]
	        },{
	                columnWidth:.3,
	                layout: 'form',
	                border:false,
	                items: [{xtype:'textfield',fieldLabel : '注册资金(万)',name : 'zczj',labelSeparator:'',allowBlank : false,xtype : 'numberfield',decimalPrecision :6,maxValue : 2000000000,anchor:'97%'}]
	        },{
	                columnWidth:.2,
	                layout: 'form',
	                border:false,
	                items: [{xtype : 'combo',
						fieldLabel : '货币种类',
						id : 'hbzl_xinban',
						displayField : 'categoryName',//显示值的名称
						hiddenName : 'hbzl',//真正提交时此combo的name
						valueField : 'categoryName',//真正提交时此combo的value
						mode : 'remote',
						store : ds_hbzl_select_xb,
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
								xinbanViewForm.getForm().findField('hbzldm_xb').setValue(record.data.categoryCode);
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
						id : 'wftzgb_xinban',
						displayField : 'categoryName',//显示值的名称
						hiddenName : 'wftzgb',//真正提交时此combo的name
						valueField : 'categoryName',//真正提交时此combo的value
						mode : 'remote',
						store : ds_wftzgb_select_xb,
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
								xinbanViewForm.getForm().findField('wftzgbdm_xinban').setValue(record.data.categoryCode);
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
	                items: [{xtype:'textfield',fieldLabel : '外方国别代码',id : 'wftzgbdm_xinban',name : 'wftzgbdm',labelSeparator:'',hideLabel:true,allowBlank : true,anchor:'99.9%'}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [new Ext.form.TriggerField({
							id:"select_zgdm_xinban",
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
						    	window_zgmcQuery_xinban.show();
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
	                items: [{xtype:'textfield',fieldLabel : '主管部门名称',name :'zgmc',labelSeparator:'',id:"select_zgmc_xinban",hideLabel:true,anchor:'99.9%'}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [new Ext.form.TriggerField({
							id:"select_pzjgdm_xinban",
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
						    	window_pzjgQuery_xb.show();
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
	                items: [{xtype:'textfield',fieldLabel : '批准机构名称',name:'pzjgmc',labelSeparator:'',id:"select_pzjgmc_xinban",allowBlank : false,hideLabel:true,anchor:'99.9%'}]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '注册号',name : 'zch',labelSeparator:'',allowBlank : false,maxLength : 50,anchor:'100%'}]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '固定电话',name : 'dhhm',labelSeparator:'',vtype:'phone',maxLength : 50,anchor:'100%'}]
	            },{
	                columnWidth:1,
	                layout: 'form',
	                border:false,
	                items: [
	                	{ xtype:'textfield',fieldLabel : '注册地址',name : 'jgdz',labelSeparator:'',allowBlank : false,maxLength : 100,anchor:'99.9%'},
	                	{ xtype:'textfield',fieldLabel : '经营地址',name : 'jydz',labelSeparator:'',maxLength : 100,anchor:'99.9%'}
	                ]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [
	                	new Ext.form.TriggerField({
							fieldLabel : '行政区划',
							id : 'xzqhCode_xinban',
					    	name : 'xzqhCode',  //接收值的名称
							displayField : 'xzqhCode', //显示值的名称
							valueField : 'xzqhCode',  //真正提交时此combo的value
							maxLength : 50,
							allowBlank : false,
							labelSeparator:'',
						    haveShow : false,
						    anchor : '98%',
						    editable : false,
						    onTriggerClick : function() {
						    	window_xzqhQuery_xinban.show();
						    },
						    listeners : {
								'specialkey' : function(field, e) {
									if (e.getKey() == Ext.EventObject.ENTER) {
										findXzqhNameByXzqhCode(field);
									}
								},
								'blur': function(field){
									findXzqhNameByXzqhCode(field);
								}
							}
					    })
					]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '行政区划代码',id:'xzqhName_xinban',name : 'xzqhName',labelSeparator:'',allowBlank : false,hideLabel:true,readOnly:true,maxLength : 50,anchor:'99.9%'}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '邮政编码',name : 'yzbm',labelSeparator:'',allowBlank : false,minLength : 6,maxLength : 6,anchor:'100%'}]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '网址',name : 'weburl',labelSeparator:'',maxLength : 50,anchor:'100%'}]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '电子邮箱',name : 'email',labelSeparator:'',vtype:'email',vtypeText:'不是有效的邮箱地址',maxLength : 50,anchor:'100%'}]
	            },{
	                columnWidth:.3,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '经办人',name : 'tbrxm',labelSeparator:'',allowBlank : false,maxLength : 30,anchor:'97%'}]
				},
				{
	                columnWidth:.15,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{
	                		xtype : 'combo',
							fieldLabel : '证件类型',
							id : 'zjlx2_xinban',
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
									var flag = isIdCardNo(xinbanViewForm.getForm().findField('tbrsfzh').getValue());
									if(flag != true){
										xinbanViewForm.getForm().findField('tbrsfzh').focus();
									}
								}else{
									xinbanViewForm.getForm().findField('tbrsfzh').focus();
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
	                	xtype:'textfield',fieldLabel : '证件号码',name : 'tbrsfzh',labelSeparator:'',hideLabel:true,confirmTo:'zjlx2_xinban',vtype:'sfzhao',allowBlank : false,maxLength : 50,anchor:'95%',
	                	enableKeyEvents: true,
						listeners : {
							keyup: function(f, e){//计数
					    		xinbanViewForm.findById('ts_xb').setText("("+f.getValue().length+")");
					    	}
						}	
					}]
				},{
					columnWidth : '.03',
					layout : 'form',
					border : false,
					baseCls : 'x-plain',
					defaultType : 'label',
					items : [{id:'ts_xb',name:'ts_xb',text:'(0)'}]
				},{
	                columnWidth:.25,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '经办人电话',name : 'tbrlxfs',labelSeparator:'',vtype:'dhhmphone',maxLength : 50,anchor:'100%'}]
				},{
	                columnWidth:.33,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [new Ext.form.DateField({  
						    id:'bzrq_xinban',
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
						    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd' 
						    })
					]
				},{
	                columnWidth:.34,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [new Ext.form.DateField({  
						    id:'zfrq_xinban',
						    name: 'zfrq',
						    format:'Y-m-d',
						    maxValue:newZfrq,  
						    maxText:'所选日期应在{0}之前',  
						    minValue:myDate,
						    minText:'所选日期应在{0}之后',
						    anchor:'100%',
						    value:newZfrq,
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
						    id:'njqx_xinban',
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
                	items: [{xtype:'textfield',fieldLabel : '备注',name : 'memo',labelSeparator:'',maxLength : 250,anchor:'99.9%'},
	                	{xtype:'hidden',fieldLabel : '业务类型',name : 'ywlx',value:'新办'},
						{xtype : 'hidden',name : 'orgid',value:''},
					    {xtype : 'hidden',name : 'orderid',id:'orderid'},
					    {xtype : 'hidden',name : 'docid'},
						{xtype : 'hidden',name : 'imageUrl'},
						{xtype : 'hidden',name : 'centerid',value:currentZzUserCenterid},
					    {xtype : 'hidden',id:'hbzldm_xb',name : 'hbzldm',value:'156'},
					    {xtype : 'hidden',id:'select_jjhymcOld_xinban',name : 'jjhymcOld'},
					    {xtype : 'hidden',id:'select_jjhydmOld_xinban',name : 'jjhydmOld'},
					    {xtype : 'hidden',name : 'bzjgdm',value:currentZzUserBzjgdm},
						{xtype : 'hidden',name : 'lastdate',value :myDate.format('Y-m-d')}, 
						{xtype : 'hidden',name : 'njrq',value :myDate.format('Y-m-d')}, 
						{xtype : 'hidden',name : 'scbzrq',value :myDate.format('Y-m-d')}, 
						{xtype : 'hidden',name : 'lry'},
						{xtype : 'hidden',name : 'xgr',value:currentZzUsername},
						{xtype : 'hidden',name : 'state',value:'12'}]
				}]
		}]
});


var  xinbanViewForm2= new Ext.Panel({
    title       : '基本信息',
    id          : 'jbInfo21',
    region      : 'center',
    margins     : '3 0 0 0',
    cmargins    : '5 5 0 0',
	autoScroll : true,
	layout: 'fit',
	bodyStyle: 'padding:0px',
    items : [xinbanViewForm]
});


var fileFtpForm_xinban = new Ext.Panel({
	title:'原文扫描',
	split: true,
	width:620,
	collapsible:true,
	collapsed: false,//是否默认打开
    region:'east',
    margins:'3 0 0 0',
    cmargins:'3 0 0 5',
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"  width=100%  height=100% align=center hspace=0 vspace=0 id="scanner24622"  name="scanner24622" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'<param name="OCRFlag" value="1">'
	       +'</OBJECT>'
    
});


//默认查询 档案
var searchXinban = function() {
	xinbanViewForm.getForm().reader = Orgnews;
	xinbanViewForm.getForm().load({
		waitMsg : '正在进行数据查询，请稍等',          //提示信息   
        waitTitle : '提示',                         //标题  
	    url: 'findAllOrgnew.action', //请求控制器获取数据
	    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
	    params: { conditions:  text_search_xinban.getValue(),username:currentZzUsername,ywlxConditions:null,stateConditions:'10,12,13,14,15,16',start:1,limit:1},	
	    success:function(form,action) {//获取返回值
	    	   
			    	if(action.result.data.ywlx=='新办' && (action.result.data.state=='12' || action.result.data.state=='14' || action.result.data.state=='15')){   //判断业务是否正在办理中
			    		//alert("|strJgdm="+action.result.data.jgdm+"|strState="+action.result.data.state+"|sysXcWorkMode="+sysXcWorkMode+"|sysStrYwxcSet="+sysStrYwxcSet);
			    		//sysXcWorkMode,sysStrYwxcSet,sysNetWorkMode,sysStrYwnetSet
			    		//根据现场流程参数设置，来判断赋码状态
			    		//isFumaBtnActive(strJgdm,strState,strYwlx,strXcWorkMode,sysStrYwxcSet)
			    		btn_code_xinban.setDisabled(isFumaBtnActive(action.result.data.jgdm,action.result.data.state,'新办',sysXcWorkMode,sysStrYwxcSet)); 
			    		
			    		btn_del_xinban.setDisabled(false);
			    		btn_shibie_xinban.setDisabled(true);
			    		var tab3452=Ext.getCmp("jbInfo21");
			    		tab3452.setTitle("基本信息  ("+stateToInfo(xinbanViewForm.getForm().findField('state').value,action.result.data.jgdm)+")");
			    		xinbanViewForm.getForm().findField('scbzrq').setValue(myDate.format('Y-m-d'));
			    		xinbanViewForm.getForm().findField('bzrq').setValue(myDate.format('Y-m-d'));
			    		xinbanViewForm.getForm().findField('lastdate').setValue(myDate.format('Y-m-d'));
			    		xinbanViewForm.getForm().findField('zfrq').setValue(newZfrq);
			    		xinbanViewForm.getForm().findField('njqx').setValue(newNjqx);
						xinbanViewForm.getForm().findField('njrq').setValue(myDate.format('Y-m-d'));
						xinbanViewForm.getForm().findField('xgr').setValue(currentZzUsername);
						xinbanViewForm.getForm().findField('select_jjlxmc_xinban').allowBlank=true;
						xinbanViewForm.getForm().findField('select_jjlxdm_xinban').allowBlank=true;
						xinbanViewForm.getForm().findField('wftzgb_xinban').allowBlank=true;
						xinbanViewForm.getForm().findField('wftzgbdm_xinban').allowBlank=true;
						if(action.result.data.state=='15'){
							xinbanViewForm.getForm().findField('jgdm_xinban').allowBlank=false;
						}else{
							xinbanViewForm.getForm().findField('jgdm_xinban').allowBlank=true;
						}
			    		var resultObject = null;
			            //alert(action.result.data.orgid);
			    		Ext.Ajax.request({
							url : 'orgnewViewImg.action',
							params : {orgid : action.result.data.orgid},
							//waitTitle: '提示',
						    //waitMsg: '数据正在重新加载中，请稍后',
							success : function(result,request) {//获取返回值
								scanner24622.ImageData="";
			   					var resultObject = Ext.util.JSON.decode(result.responseText); 
			   					if(resultObject!=null){
				   					scanner24622.OpenProgress(3);  //设置上传的进度条的总进度数
				   					scanner24622.Progress('原文加载中',1);
									scanner24622.Progress('原文加载中',2);
				   					scanner24622.ImageData=resultObject.imageData;
				   					scanner24622.pageType=resultObject.pageTypeStr;
				   					if(scanner24622.ImageData!=""){
				   						scanner24622.Progress('原文加载完毕',3);
										scanner24622.CloseProgress();
									}else{
										scanner24622.Progress('原文加载失败',3);
						   				scanner24622.CloseProgress();
						   				alert("原文错误，加载失败！");
									}
			   					}
							},
							failure : function() {
								scanner24622.ImageData="";
					   			scanner24622.CloseProgress();
								alert("图像加载错误，或者无原文");
							}
						});	
			
					}else{
						btn_del_xinban.setDisabled(true);
					    //btn_save_xinban_menu.setDisabled(true);
					    btn_ok_xinban.setDisabled(true);
						Ext.Msg.show({
							title : '提示',
							msg : '机构正在进行“'+action.result.data.ywlx+'('+stateToInfo(action.result.data.state)+')”业务办理中!',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.INFO,
							fn : function() {xinbanViewForm.getForm().reset();scanner24622.ImageData="";}
						});
		            }
		},
		failure : function() {//正式库检索
				xinbanViewForm.getForm().reader = Orgnews;
				xinbanViewForm.getForm().load({
					waitMsg : '正在进行数据查询，请稍等',          //提示信息   
			        waitTitle : '提示',                      //标题  
				    url: 'findAllTjgdm.action', //请求控制器获取数据
				    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
				    params: { conditions:  text_search_xinban.getValue(),stateConditions:'',ywlxConditions:null,userBzjgdm:null,start:1,limit:1},	
				    success:function(form,action) {//获取返回值
					    	if(currentZzUsername!='admin' && sysBzjgLimitMode=='1' && action.result.data.bzjgdm!=currentZzUserBzjgdm){
				    				Ext.Msg.show({
										title : '提示',
										msg : '【'+action.result.data.jgmc+'】，<br><br>办证机构代码为“'+action.result.data.bzjgdm+'”,不属于本办证机构办理！',
										buttons : Ext.Msg.OK,
										fn:  function() {
											btn_del_xinban.setDisabled(true);
										    btn_shibie_xinban.setDisabled(false);
											xinbanViewForm.getForm().reset();
											scanner24622.ImageData="";
											var tab34528=Ext.getCmp("jbInfo21");
							    			tab34528.setTitle("基本信息");
										},
										icon : Ext.Msg.ERROR
									});
				    		}else{
				    			if(action.result.data.state=='100' || action.result.data.state==''){ //判断此机构状态是否正常
								    	if(action.result.data.orgid!='' && action.result.data.orgid=='预赋码'){//自动加载原文
						    					btn_save_xinban_menu.setDisabled(false);
									    		btn_del_xinban.setDisabled(true);
									    		btn_shibie_xinban.setDisabled(true);
									    		btn_ok_xinban.setDisabled(true);
									    		btn_code_xinban.setDisabled(true);
									    		var tab34527=Ext.getCmp("jbInfo21");
									    		tab34527.setTitle("基本信息  (新录入)");
									    		xinbanViewForm.getForm().findField('ywlx').setValue('新办');
									    		xinbanViewForm.getForm().findField('state').setValue('10');
									    		xinbanViewForm.getForm().findField('orgid').setValue('');
									    		xinbanViewForm.getForm().findField('scbzrq').setValue(myDate.format('Y-m-d'));
									    		xinbanViewForm.getForm().findField('bzrq').setValue(myDate.format('Y-m-d'));
									    		xinbanViewForm.getForm().findField('lastdate').setValue(myDate.format('Y-m-d'));
									    		xinbanViewForm.getForm().findField('zfrq').setValue(newZfrq);
									    		xinbanViewForm.getForm().findField('njqx').setValue(newNjqx);
						    					xinbanViewForm.getForm().findField('njrq').setValue(myDate.format('Y-m-d'));
						    					xinbanViewForm.getForm().findField('select_jjlxmc_xinban').allowBlank=true;
												xinbanViewForm.getForm().findField('select_jjlxdm_xinban').allowBlank=true;
												xinbanViewForm.getForm().findField('wftzgb_xinban').allowBlank=true;
												xinbanViewForm.getForm().findField('wftzgbdm_xinban').allowBlank=true;
												xinbanViewForm.getForm().findField('jgdm_xinban').allowBlank=false;
										}else{
												Ext.Msg.show({
													title : '提示',
													msg : '此机构不是“预赋码”用户，不能进行“新办”业务！',
													buttons : Ext.Msg.OK,
													fn:  function() {
														btn_del_xinban.setDisabled(true);
													    btn_shibie_xinban.setDisabled(false);
														xinbanViewForm.getForm().reset();
														scanner24622.ImageData="";
														var tab34528=Ext.getCmp("jbInfo21");
										    			tab34528.setTitle("基本信息");
													},
													icon : Ext.Msg.ERROR
												});
							            }
							       }else{
										Ext.Msg.show({
											title : '提示',
											msg : '机构“'+action.result.data.jgmc+'”状态为“'+tjgdmStateToInfo(action.result.data.state)+'”,<br><br>不能再次办理业务！',
											buttons : Ext.Msg.OK,
											fn:  function() {
												btn_del_xinban.setDisabled(true);
											    btn_shibie_xinban.setDisabled(false);
												xinbanViewForm.getForm().reset();
												scanner24622.ImageData="";
												var tab34528=Ext.getCmp("jbInfo21");
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
								msg : '机构信息未查到！',
								width:250,
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR,
								fn:  function() {
									btn_del_xinban.setDisabled(true);
								    btn_shibie_xinban.setDisabled(false);
									xinbanViewForm.getForm().reset();
									scanner24622.ImageData="";
									var tab34528=Ext.getCmp("jbInfo21");
					    			tab34528.setTitle("基本信息");
								}
							});
						}	
				});
		}
	});
}




var btn_search_xinban = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchXinban();
	}
});

var text_search_xinban = new Ext.form.TextField({
	id : 'textSearchXinban',
	name : 'textSearchXinban',
	width : 200,
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchXinban();
			}
		}
	}
});

var btn_refresh_xinban = new Ext.Button({
	text : '重置',
	iconCls : 'icon-refresh',
	handler : function() {
		btn_del_xinban.setDisabled(true);
		btn_code_xinban.setDisabled(true);
    	btn_shibie_xinban.setDisabled(false);
		xinbanViewForm.getForm().reset();
		var tab3452=Ext.getCmp("jbInfo21");
	    tab3452.setTitle("基本信息");
		scanner24622.ImageData="";
		xinbanViewForm.getForm().findField('orgid').setValue('');
		xinbanViewForm.getForm().findField('select_jjlxmc_xinban').allowBlank=true;
		xinbanViewForm.getForm().findField('select_jjlxdm_xinban').allowBlank=true;
		xinbanViewForm.getForm().findField('wftzgb_xinban').allowBlank=true;
		xinbanViewForm.getForm().findField('wftzgbdm_xinban').allowBlank=true;
		xinbanViewForm.getForm().findField('jgdm_xinban').allowBlank=true;
	}
});

var btn_del_xinban = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	disabled:true,
	handler : function() {
		var orgid = xinbanViewForm.getForm().findField('orgid').value;
		if(orgid!=null && orgid!=""){
			Ext.Msg.confirm('确认删除', '你确定删除吗?', function(btn) {
				if (btn == 'yes') {
					ajaxLoadMask.show();
					Ext.Ajax.request({
						url : 'deleteOrgnew.action',
						params : {orgid : orgid},
						success : function() {
							ajaxLoadMask .hide();
							btn_del_xinban.setDisabled(true);
					    	btn_shibie_xinban.setDisabled(false);
							xinbanViewForm.getForm().reset();
							var tab3452=Ext.getCmp("jbInfo21");
	    					tab3452.setTitle("基本信息");
							scanner24622.ImageData="";
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

        
var btn_shibie_xinban = new Ext.Button({
	text : '识别',
	iconCls : 'icon-add',
	//disabled:true,调用参数
	//scanner.GetOCRValue 返回 识别结果
	handler : function(){
		var ocrStr=scanner24622.GetOCRValue;
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
			xinbanViewForm.getForm().setValues(respText); 
			btn_del_xinban.setDisabled(true);
			xinbanViewForm.getForm().findField('orgid').setValue('');
		}else{
			alert("请扫描或导入需识别的图片！");
		}
	}
});


//---------------------- 开始赋码 ------------------------------------
var xinbanFumaForm = new Ext.FormPanel({
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
		{xtype : 'hidden',name : 'centerid',value:currentZzUserCenterid},
		{xtype : 'hidden',name : 'docid'},
		{xtype : 'textfield',fieldLabel : '机构名称',name : 'jgmc',allowBlank:false,readOnly:true},
		{xtype : 'textfield',fieldLabel : '注册号',name : 'zch',allowBlank:false,readOnly:true},
		{xtype : 'combo',
			fieldLabel : '是否个体',
			id : 'dmlx_xinban',
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
		id:'btn_qm_xb',
		handler : function(btn){
			if(xinbanFumaForm.getForm().findField('dmlx_xinban').getValue()!=""){
				var record = grid_code_creat_xb.getSelectionModel().getSelected(); 
				if(record==null){
					btn.setText('取码');
					ds_code_creat_xb.removeAll();
					ds_code_creat_xb.baseParams.zch = xinbanViewForm.getForm().findField('zch').value;
					ds_code_creat_xb.baseParams.orgid = xinbanViewForm.getForm().findField('orgid').value;
					ds_code_creat_xb.baseParams.state = xinbanViewForm.getForm().findField('state').value;
					ds_code_creat_xb.baseParams.jgmc = xinbanViewForm.getForm().findField('jgmc').value;
					ds_code_creat_xb.baseParams.centerid=xinbanViewForm.getForm().findField('centerid').value;
					ds_code_creat_xb.baseParams.dmlx=xinbanFumaForm.getForm().findField('dmlx_xinban').getValue();//0 个体，3非个体
					ds_code_creat_xb.baseParams.flag='0';//0需判断，1不需判断
					ds_code_creat_xb.load();
				}else{
					if(record.data.flag=='4'){//疑似赋码
						ds_code_creat_xb.removeAll();
						ds_code_creat_xb.baseParams.zch = xinbanViewForm.getForm().findField('zch').value;
						ds_code_creat_xb.baseParams.orgid = xinbanViewForm.getForm().findField('orgid').value;
						ds_code_creat_xb.baseParams.state = xinbanViewForm.getForm().findField('state').value;
						ds_code_creat_xb.baseParams.jgmc = xinbanViewForm.getForm().findField('jgmc').value;
						ds_code_creat_xb.baseParams.centerid=xinbanViewForm.getForm().findField('centerid').value;
						ds_code_creat_xb.baseParams.dmlx=xinbanFumaForm.getForm().findField('dmlx_xinban').getValue();//0 个体，3非个体
						ds_code_creat_xb.baseParams.flag='1';//0需判断，1不需判断
						ds_code_creat_xb.load();
						btn.setText('取码');
						btn.disable();
					}else{
						btn.setText('取码');
						btn.disable();
					}
				}
			}else{
				alert("请选择“是否个体” ！");
			}
		}
	},{
		text:'确定',
		handler : function(btn){
			if(xinbanFumaForm.getForm().isValid()){
				xinbanFumaForm.getForm().submit({
					waitTitle : '请稍候',
					waitMsg : '正在修改数据,请稍候...',
					success : function(form) {
						xinbanViewForm.getForm().findField('jgdm').setValue(xinbanFumaForm.getForm().findField('jgdm').value);
						ds_code_creat_xb.removeAll();
						window_fuma_xb.hide();
						var tab34529=Ext.getCmp("jbInfo21");
					    tab34529.setTitle("基本信息(赋码成功，请提交确认)");
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
		handler:function(){
			xinbanFumaForm.getForm().reset();
			ds_code_creat_xb.removeAll();
			var btn34529=Ext.getCmp("btn_qm_xb");
			 btn34529.setText("取码");
			 btn34529.enable();
			this.ownerCt.ownerCt.ownerCt.hide();
		}
	}]
});

xinbanCodeListPanel = Ext.extend(Ext.grid.GridPanel,{
	constructor:function(){
		PrintLogPanel.superclass.constructor.call(this,{
		loadMask : {msg : '数据加载中...'},
		
		
//信息浏览
var  xinbanCODE_xb= new Ext.Panel({
    region      : 'center',
    margins   : '3 3 0 3', 
    activeTab : 1,
    items : [xinbanFumaForm]
}); 

var xinbanList_xb = new Ext.Panel({
	title   : '编码列表',
	region    : 'south',
    split       : true,
    height       : 200,
    collapsible : true,
    margins     : '0 3 3 3',
    cmargins    : '3 3 3 3',
    autoScroll : true,
    items:[grid_code_creat_xb]
});

var window_fuma_xb = new Ext.Window({
	title : '请选择机构代码',
	iconCls : 'icon-plugin',
	width : 500,
	height : 400,
	x:'250',
	y:'170',
	resizable : true,
	modal : true,
	plain    : true,
	layout   : 'border',
	closable : false,
	closeAction : 'close',
	listeners : {
		'hide' : function(){
			xinbanFumaForm.getForm().reset();			
		}
	},
	//items : [xinbanCODE_xb,xinbanList_xb]
	items:[{
	    region:'center',
	    layout : 'border',
	    items : [xinbanFumaForm]
	},{
	    region: 'south',
	    layout :'fit',
		title : '编码列表',
	    height: 200,
	    minSize: 100,
	    maxSize: 250,
	    margins     : '0 0 0 0',
    	cmargins    : '5 0 0 0',
	    items : [new xinbanCodeListPanel()]
	}]
});

var btn_code_xinban = new Ext.Button({
	text : '赋码',
	iconCls : 'icon-add',
	disabled:true,
	handler : function(){
		window_fuma_xb.show();
		xinbanFumaForm.getForm().findField('orgid').setValue(xinbanViewForm.getForm().findField('orgid').value);
		xinbanFumaForm.getForm().findField('jgmc').setValue(xinbanViewForm.getForm().findField('jgmc').value);
		xinbanFumaForm.getForm().findField('zch').setValue(xinbanViewForm.getForm().findField('zch').value);
	}
});

var btn_save_xinban_menu = new Ext.Toolbar.MenuButton({
    text: '保存',
    handler: btn_xinban_saveAll,
    tooltip: {title:'保存数据和原文',text:'保存'},
    iconCls: 'blist',
    //disabled:true,
    menu : {items: [
                {text: '全部保存', handler: btn_xinban_saveAll}, '-',
                {text: '仅保存数据', handler: btn_xinban_saveInfo},
                {text: '仅上传原文', handler: btn_xinban_ftpFile}
        ]}
});

function btn_xinban_saveAll(btn){
	if (xinbanViewForm.getForm().isValid()) {
		xinbanViewForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在保存数据,请稍候...',
			success : function(form,action) {
				btn_ok_xinban.setDisabled(false);
   				//alert(action);
				xinbanViewForm.getForm().findField('orgid').setValue(action.result.orgid);
				xinbanViewForm.getForm().findField('docid').setValue(action.result.docid);
				
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
				strOrgid = action.result.orgid;  //参数orgid
				strDocid = action.result.docid;
				strBzjgdm=xinbanViewForm.getForm().findField('bzjgdm').value; 
				
				packLength = 40960;	//定义每个包的大小40960
				base64file = scanner24622.ImageData;  //获取控件扫描的图片数据
				var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
				imageCount = scanner24622.GetPageCount;	//获取扫描图片的页数
				pageTypeStr = scanner24622.PageType;    //获取标识字符串,需要写数据库
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
				scanner24622.OpenProgress(packCount);  //设置上传的进度条的总进度数
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
							scanner24622.Progress('上传中',i+1);
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
					msg : '['+xinbanViewForm.getForm().findField('jgmc_xinban').getValue()+']，<br><br>申办信息保存成功！',
					buttons : Ext.Msg.OK,
					fn : function() {btn.enable();btn_ok_xinban.setDisabled(false);btn_code_xinban.setDisabled(false);},
					icon : Ext.Msg.INFO
				});

				scanner24622.CloseProgress();
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


function btn_xinban_saveInfo(btn){
	if (xinbanViewForm.getForm().isValid()) {
		xinbanViewForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在保存数据,请稍候...',
			success : function(form,action) {
				//alert(action.result.msg+"|"+action.result.success+"|"+xinbanViewForm.getForm().findField('jgmc_xinban').getValue());
				xinbanViewForm.getForm().findField('orgid').setValue(action.result.orgid);
				xinbanViewForm.getForm().findField('docid').setValue(action.result.docid);
				Ext.Msg.show({
					title : '提示',
					msg : '['+xinbanViewForm.getForm().findField('jgmc_xinban').getValue()+']，<br><br>申办信息保存成功！',
					buttons : Ext.Msg.OK,
					fn : function() {btn.enable();btn_ok_xinban.setDisabled(false);btn_code_xinban.setDisabled(false);},
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

function btn_xinban_ftpFile(btn){
	
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
	strOrgid =xinbanViewForm.getForm().findField('orgid').value;  //参数orgid
	strDocid =xinbanViewForm.getForm().findField('docid').value;  //参数docid
	strBzjgdm=xinbanViewForm.getForm().findField('bzjgdm').value;  //办证机构代码
	
	//alert("strOrgid="+strOrgid);
	
	if(strOrgid!=""){
			packLength = 40960;	//定义每个包的大小40960
			//scanner24622.ImageData=document.getElementById("ImageData").value;
			base64file = scanner24622.ImageData;  //获取控件扫描的图片数据
			var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
			imageCount = scanner24622.GetPageCount;	//获取扫描图片的页数
			pageTypeStr = scanner24622.PageType;    //获取标识字符串,需要写数据库
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
			scanner24622.OpenProgress(packCount);  //设置上传的进度条的总进度数
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
						scanner24622.Progress('上传中',i+1);
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
			
			scanner24622.CloseProgress();
			
			Ext.Msg.show({
				title : '提示',
				msg : '['+xinbanViewForm.getForm().findField('jgmc_xinban').getValue()+']，<br><br>原文上传成功！',
				buttons : Ext.Msg.OK,
				fn : function() {btn.enable();btn_ok_xinban.setDisabled(false);btn_code_xinban.setDisabled(false);},
				icon : Ext.Msg.INFO
			});
			
			scanner24622.CloseProgress();
			return true;
	}else{
		alert("请录入数据后，再上传原文！");
	}
}


var btn_ok_xinban = new Ext.Button({
	text : '提交确认',
	iconCls : 'icon-store',
	handler : function(){
		var orgid = xinbanViewForm.getForm().findField('orgid').value;
		var strState = xinbanViewForm.getForm().findField('state').value;
		var strJgmc = xinbanViewForm.getForm().findField('jgmc_xinban').getValue();
		var strJgdm = xinbanViewForm.getForm().findField('jgdm_xinban').getValue();
		var strYwlx = xinbanViewForm.getForm().findField('ywlx').value;
		if(orgid!=null && orgid!=""){
			if((strState=="15" && strJgdm=="")){
				Ext.Msg.show({
					title : '提示',
					msg : '请赋码后，再提交！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.INFO
				});
			}else{
				ajaxLoadMask.show();
				Ext.Ajax.request({
					url: 'returnOrgnewDo.action',
	   				params: {orgid: orgid,state:strState,ywlx:strYwlx},
	   				success: function(result,request){
	   					ajaxLoadMask .hide();
	   					Ext.Msg.show({
							title : '提示',
							msg : '[' + strJgmc + ']申请单提交完毕！',
							buttons : Ext.Msg.OK,
							fn:  function() {
								//var resultObject = Ext.util.JSON.decode(result.responseText);
			   					//alert("state="+resultObject.state);
			   					btn_ok_xinban.setDisabled(true);
			   					xinbanViewForm.getForm().findField('orgid').setValue('');
			   					xinbanViewForm.getForm().findField('jgdm_xinban').allowBlank=true;
			   					var tab34529=Ext.getCmp("jbInfo21");
					    		tab34529.setTitle("基本信息");
								scanner24622.PageType="";
								scanner24622.ImageData="";
								xinbanViewForm.getForm().reset();
								text_search_xinban.setValue("");
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
				msg : '请保存信息后，再提交审核！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.INFO
			});
		}
	}
});

var p_zzXinban = {
	id : 'zzXinban-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:0px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    bodyBorder: false,
	    title: '新办',
	    iconCls : 'icon-plugin',
 		plain: true,
		region: 'center',
		tbar : [btn_shibie_xinban,btn_refresh_xinban,btn_code_xinban,btn_del_xinban,btn_save_xinban_menu,btn_ok_xinban,'->',text_search_xinban,btn_search_xinban],
		items: [xinbanViewForm2,fileFtpForm_xinban]
	}]
}