
var btn_search_pzjgJgBerth = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchPzjgJgBerth();
		//btn_search_pzjg.setDisabled(true);
	}
});


var text_search_pzjgJgBerth = new Ext.form.TextField({
	id : 'textSearchPzjgJgBerth',
	name : 'textSearchPzjgJgBerth',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchPzjgJgBerth();
			}
		},
		'change' : function(field, e) {
			btn_search_pzjgJgBerth.setDisabled(false);
		}
	}
});


var cm_pzjgJgBerth = new Ext.grid.ColumnModel([
	{header : '批准机构名称',width : 50,dataIndex : 'pzjgmc',sortable : true}, 
	{header : '批准机构代码',width : 20,dataIndex : 'pzjgdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_pzjgJgBerth = new Ext.data.Store({
	url : 'findAllByConditionPzjg.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'pzjgid',type : 'int'}, 
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchPzjgJgBerth = function() {
	ds_pzjgJgBerth.baseParams.conditions = text_search_pzjgJgBerth.getValue();
	ds_pzjgJgBerth.baseParams.username=currentUsername;
	ds_pzjgJgBerth.baseParams.stateConditions='';
	ds_pzjgJgBerth.load({params : {start : 0,limit : 20} });
}

var grid_pzjgJgBerth = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_pzjgJgBerth,
	ds : ds_pzjgJgBerth,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入登记批准机构名称：',text_search_pzjgJgBerth,btn_search_pzjgJgBerth],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_pzjgJgBerth,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_pzjgJgBerth.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			jgBerthView.getForm().findField('pzjgmc').setValue(selections[0].get('pzjgmc'));
			jgBerthView.getForm().findField('pzjgdm').setValue(selections[0].get('pzjgdm'));
		}
	}
});

var window_pzjgJgBerth = new Ext.Window({
	title : '登记批准机构查询',
	iconCls : 'icon-plugin',
	width :500,
	height:400,
	//plain    : true,
	layout   : 'border',
	resizable : false,
	modal : true,
	resizable : true, 
	maximizable:true,
	closeAction : 'hide',
	items : [grid_pzjgJgBerth]
});

var jgBerthView = new Ext.FormPanel({
	loadMask : {
		msg : '数据加载中...'
	},
	url : 'saveJgBerth.action',
	labelAlign : 'right',
    bodyStyle:'padding-top:20px',
	labelWidth : 90,
	border : false,
	layout: 'fit',
	baseCls : 'x-plain',
	waitMsgTarget: true,
	autoScroll : true,
	items : [{
		layout:'column',
        border:false,
        baseCls : 'x-plain',
        bodyStyle:'padding:10px',
		items : [{
			columnWidth : 1,
			layout : 'form',
			border : false,baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '99.7%'},
			items : [
				{fieldLabel : '机构代码',name : 'jgdm'},
				{fieldLabel : '机构名称',name : 'jgmc',allowBlank : false},
				{fieldLabel : '机构地址',name : 'jgdz',allowBlank : false},
				{fieldLabel : '注 册 号',name : 'zch',allowBlank : false},
				new Ext.form.TriggerField({
					name:"pzjgmc",
					fieldLabel:"批准机构名称",
				 	valueField : "pzjgmc",
				    displayField : "pzjgmc",
				    allowBlank : false,
			
					selectOnFocus : true,
				    readOnly:'true',
				    
				    haveShow : false,
				    editable : true,
				    onTriggerClick : function() {
				    	window_pzjgJgBerth.show();
				    }
			    }),
				{fieldLabel : '批准机构代码',name : 'pzjgdm',allowBlank : false},
				{fieldLabel : '电子信箱',name : 'email',vtype:'email',vtypeText:'不是有效的邮箱地址'},
				{fieldLabel : '联系电话',name : 'dhhm',allowBlank : false,vtype:'phone'},
				{xtype:'hidden',name : 'userid',value:currentUserid},
				{xtype:'hidden',name : 'state',value:'0'},
				{xtype:'hidden',name : 'jgid'}
			]
		}]
	}],
	buttons : [{
		text : '保存',
		id:'jgberth_bc',
		name:'jgberth_bc',
		handler : function(btn){
			if (jgBerthView.getForm().isValid()) {
				jgBerthView.getForm().submit({
					waitTitle : '请稍候',
					waitMsg : '正在保存数据,请稍候...',
					success : function(form, action) {
						
						jgBerthView.getForm().reset();
						searchJgBerth();
						Ext.Msg.show({
							title : '提示',
							msg : '数据保存成功！',
							buttons : Ext.Msg.OK,
							fn : function(){window_JgBerthView.hide();},
							icon : Ext.Msg.INFO
						});
					},
					failure : function(form, action) {
						Ext.Msg.show({
							title : '提示',
							msg : '数据保存失败！',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.ERROR
						});
					}
				})
			}
		}
	},{
		text : '重置',
		id:'jgberth_cz',
		name:'jgberth_cz',
		handler :function() {
			jgBerthView.getForm().reset();
		}
	},{
		text : '取消',
		id:'jgberth_qx',
		name:'jgberth_qx',
		handler :function() {
			window_JgBerthView.hide();
			searchJgBerth();
		}
	}]
});

var window_JgBerthView = new Ext.Window({
	title : '',
	iconCls : 'icon-plugin',
	width :500,
	height:350,
	layout : 'fit',
	modal : true,
	plain: false,
	closeAction : 'hide',
	items : [jgBerthView]
});









var JgBerths = new Ext.data.JsonReader(
	{totalProperty : 'totalProperty',root : 'root'}, 
   [{name : 'jgid',type : 'int'}, 
    {name : 'jgmc',type : 'string'},
	{name : 'jgdm',type : 'string'},
	{name : 'jgdz',type : 'string'}, 
	{name : 'pzjgmc',type : 'string'}, 
	{name : 'pzjgdm',type : 'string'},
	{name : 'zch',type : 'string'},
	{name : 'email',type : 'string'},
	{name : 'dhhm',type : 'string'},
	{name : 'state',type : 'string'},
	{name : 'userid',type : 'int'}
]);





var sm = new Ext.grid.CheckboxSelectionModel();
var cm_jgberth = new Ext.grid.ColumnModel([
	sm,
	{header : '机构名称',width : 90,dataIndex : 'jgmc',sortable : false},
	{header : '机构代码',width : 50,dataIndex : 'jgdm',sortable : true}, 
	{header : '批准机构',width : 120,dataIndex : 'pzjgmc',sortable : true},
	{header : '注册号',width : 60,dataIndex : 'zch',sortable : true}/*,
	{header : '状态',width : 50,dataIndex : 'state',renderer : goJgBerthState,menuDisabled : true}*/
]);


//---------------------- 定义工具栏按钮事件 ------------------------------------------------------
//默认查询 limit为显示的条数
var searchJgBerth = function() {
	ds_jgberth.baseParams.conditions = text_search_jgBerth.getValue();
	ds_jgberth.baseParams.userid=currentUserid;
	ds_jgberth.load({params : {start : 0,limit : 50} });
}

//查询返回结果的数据列
var ds_jgberth = new Ext.data.Store({
	url : 'findAllJgBerth.action',
	reader : JgBerths
});

var btn_add_jgBerth = new Ext.Button({
	text : '新增',
	iconCls : 'icon-add',
	handler : function() {
		var btn = Ext.getCmp('jgberth_bc');
		btn.setText("保存");window_JgBerthView.setTitle('添加挂靠机构信息');
		window_JgBerthView.show();
	}
});
var btn_upd_jgBerth = new Ext.Button({
	text : '更新',
	iconCls : 'icon-refresh',
	handler : function() {
		var record = jgBerthGridForm.getSelectionModel().getSelected();
		if(record){
			var btn = Ext.getCmp('jgberth_bc');
			btn.setText("更新");window_JgBerthView.setTitle('更新挂靠机构信息');
			window_JgBerthView.show();
			jgBerthView.getForm().loadRecord(record);
		}else{
			Ext.Msg.show({
				title : '提示',
				msg : '请选择需要更新的机构！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.INFO
			});
		}
	}
});
var btn_del_jgBerth = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	handler : function() {
		var record = jgBerthGridForm.getSelectionModel().getSelected();
		if(record){
			Ext.Msg.show({
				title : '提示',
				msg : '确定要去除此挂靠机构信息？',
				buttons : Ext.Msg.OKCANCEL,
				icon : Ext.Msg.INFO,
				fn : function(btn){
					if(btn == 'ok'){
						Ext.Ajax.request({  
							url: 'delJgBerth.action',
							method: 'POST',
							params: {jgid:record.data.jgid},
							success:function(result,request){
								Ext.Msg.show({
									title : '提示',
									msg : '成功去除机构信息！',
									buttons : Ext.Msg.OK,
									fn : function(){searchJgBerth();},
									icon : Ext.Msg.INFO
								});
							}
						});
					}
				}
			});
		}else{
			Ext.Msg.show({
				title : '提示',
				msg : '请选择需要去除的机构！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.INFO
			});
		}
	}
});
var text_search_jgBerth = new Ext.form.TextField({
	id:'textsearchjgBerth',
	name : 'textsearchjgBerth',
	width : 200,
	emptyText : '查询条件机构名称、代码、注册号',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJgBerth();
			}
		}
	}
});
var btn_search_jgBerth = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJgBerth();
	}
});
//加载右栏主页面   （数据列表、工具栏按钮）
var jgBerthGridForm = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jgberth,
	ds : ds_jgberth,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	viewConfig : {forceFit : true},
	tbar : [btn_add_jgBerth,btn_upd_jgBerth,btn_del_jgBerth,'->',text_search_jgBerth,btn_search_jgBerth],
	bbar : new Ext.PagingToolbar({
		pageSize : 50,
		store : ds_jgberth,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	})
});

var p_jgBerthSet = {
	id : 'useJgBerthSet-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:0px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    bodyBorder: true,
	    title: '挂靠机构信息',
	    iconCls : 'icon-plugin',
		region: 'center',
		plain: true,
		baseCls : 'x-plain',
		items: [jgBerthGridForm]
	}]
}