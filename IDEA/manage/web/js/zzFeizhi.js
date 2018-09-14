var btn_search_pzjg_fz = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchPzjg_fz();
		//btn_search_pzjg_fz.setDisabled(true);
	}
});


var text_search_pzjg_fz = new Ext.form.TextField({
	id : 'textSearchPzjg_fz',
	name : 'textSearchPzjg_fz',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchPzjg_fz();
			}
		},
		'change' : function(field, e) {
			btn_search_pzjg_fz.setDisabled(false);
		}
	}
});


var cm_pzjg_zfz = new Ext.grid.ColumnModel([
	{header : '批准机构名称',width : 50,dataIndex : 'pzjgmc',sortable : true}, 
	{header : '批准机构代码',width : 20,dataIndex : 'pzjgdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_pzjg_fz = new Ext.data.Store({
	url : 'findAllByConditionPzjg.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'pzjgid',type : 'int'}, 
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchPzjg_fz = function() {
	ds_pzjg_fz.baseParams.conditions = text_search_pzjg_fz.getValue();
	ds_pzjg_fz.baseParams.username='';
	ds_pzjg_fz.baseParams.stateConditions='';
	ds_pzjg_fz.load({params : {start : 0,limit : 20} });
}

var grid_pzjg_fz = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_pzjg_zfz,
	ds : ds_pzjg_fz,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入登记批准机构名称：',text_search_pzjg_fz,btn_search_pzjg_fz],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_pzjg_fz,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_pzjgQuery_fz.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			feizhiViewForm.getForm().findField('select_pzjgmc_feizhi').setValue(selections[0].get('pzjgmc'));
			feizhiViewForm.getForm().findField('select_pzjgdm_feizhi').setValue(selections[0].get('pzjgdm'));
		}
	}
});


var window_pzjgQuery_fz = new Ext.Window({
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
	items : [grid_pzjg_fz]
});


var btn_search_jglxSelcet_zfz = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJglxSelcet_fz();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_jglxSelcet_zfz = new Ext.form.TextField({
	id : 'textsearchJglxSelcet_fz',
	name : 'textsearchJglxSelcet_fz',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJglxSelcet_fz();
			}
		},
		'change' : function(field, e) {
			btn_search_jglxSelcet_zfz.setDisabled(false);
		}
	}
});


var cm_jglxSelcet_zfz = new Ext.grid.ColumnModel([
    {header : '一级类型',width : 60,dataIndex : 'pjglxmc',sortable : true}, 
	{header : '二级类型',width : 100,dataIndex : 'jglxmc',sortable : true}, 
	{header : '代码',width : 30,dataIndex : 'jglxdm',sortable : true},
	{header : '备注',width : 50,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_jglxSelcet_fz = new Ext.data.Store({
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

var ds_hbzl_select = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=1',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});

var searchJglxSelcet_fz = function() {
	ds_jglxSelcet_fz.baseParams.conditions = text_search_jglxSelcet_zfz.getValue();
	ds_jglxSelcet_fz.baseParams.username="";
	ds_jglxSelcet_fz.baseParams.stateConditions='';
	ds_jglxSelcet_fz.load({params : {start : 0,limit : 20} });
}

var grid_jglx_feizhi = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jglxSelcet_zfz,
	ds : ds_jglxSelcet_fz,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入机构类型名称：',text_search_jglxSelcet_zfz,btn_search_jglxSelcet_zfz],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jglxSelcet_fz,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jglxQuery_feizhi.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			feizhiViewForm.getForm().findField('select_jglxmc_feizhi').setValue(selections[0].get('jglxmc'));
			feizhiViewForm.getForm().findField('select_jglxdm_feizhi').setValue(selections[0].get('jglxdm'));
		}
	}
});

var window_jglxQuery_feizhi = new Ext.Window({
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
	items : [grid_jglx_feizhi]
});

var btn_search_hylxSelcet_fz = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchHylxSelcet_fz();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_hylxSelcet_fz = new Ext.form.TextField({
	id : 'textSearchHylxSelcet_fz',
	name : 'textSearchHylxSelcet_fz',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchHylxSelcet_fz();
			}
		},
		'change' : function(field, e) {
			btn_search_hylxSelcet_fz.setDisabled(false);
		}
	}
});


var cm_hylxSelcet_fz = new Ext.grid.ColumnModel([
	{header : '大类',width : 100,dataIndex : 'hylxmc1',sortable : true}, 
	{header : '中类',width : 100,dataIndex : 'hylxmc2',sortable : true}, 
	{header : '小类',width : 100,dataIndex : 'hylxmc3',sortable : true}, 
   {header : '经济行业名称',width : 100,dataIndex : 'hylxmc',sortable : true},
	{header : '经济行业代码',width : 30,dataIndex : 'hylxdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_hylxSelcet_fz = new Ext.data.Store({
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

var searchHylxSelcet_fz = function() {
	ds_hylxSelcet_fz.baseParams.conditions = text_search_hylxSelcet_fz.getValue();
	ds_hylxSelcet_fz.baseParams.username="";
	ds_hylxSelcet_fz.baseParams.stateConditions='';
	ds_hylxSelcet_fz.load({params : {start : 0,limit : 20} });
}

var grid_hylx_feizhi = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_hylxSelcet_fz,
	ds : ds_hylxSelcet_fz,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入经济行业代码名称：',text_search_hylxSelcet_fz,btn_search_hylxSelcet_fz],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_hylxSelcet_fz,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_hylxQuery_feizhi.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			feizhiViewForm.getForm().findField('select_jjhymc_feizhi').setValue(selections[0].get('hylxmc'));
			feizhiViewForm.getForm().findField('select_jjhydm_feizhi').setValue(selections[0].get('hylxdm'));
			feizhiViewForm.getForm().findField('select_jjhymcOld_feizhi').setValue(selections[0].get('hylxmcOld'));
			feizhiViewForm.getForm().findField('select_jjhydmOld_feizhi').setValue(selections[0].get('hylxdmOld'));
		}
	}
});


var window_hylxQuery_feizhi = new Ext.Window({
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
	items : [grid_hylx_feizhi]
});

//--------------------机构基本信息-------------------------------------------

var feizhiViewForm = new Ext.FormPanel({	
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
            	columnWidth:1,
            	layout: 'form',
            	bodyStyle: 'padding:0px',
            	border:false,
            	items: [{ xtype:'textfield',fieldLabel : '注销依据',name : 'offPzwh',labelSeparator:'',allowBlank:false,maxLength : 250,anchor:'100%'}]
			},{
            	columnWidth:1,
            	layout: 'form',
            	bodyStyle: 'padding:0px',
            	border:false,
            	items: [{ xtype:'textfield',fieldLabel : '注销原因',name : 'offReason',labelSeparator:'',allowBlank:false,maxLength : 250,anchor:'100%'}]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '注销备注',name : 'offNote',labelSeparator:'',maxLength : 100,anchor:'100%'}]
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
						id : 'zjlx2_feizhi',
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
								var flag = isIdCardNo(feizhiViewForm.getForm().findField('tbrsfzh').getValue());
								if(flag != true){
									feizhiViewForm.getForm().findField('tbrsfzh').focus();
								}
							}else{
								feizhiViewForm.getForm().findField('tbrsfzh').focus();
							}
						}
					}
					}]
			},{
                columnWidth:.27,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '证件号码',name : 'tbrsfzh',labelSeparator:'',hideLabel:true,confirmTo:'zjlx2_feizhi',vtype:'sfzhao',allowBlank : false,maxLength : 50,anchor:'95%',
                	enableKeyEvents: true,
					listeners : {
						keyup: function(f, e){//计数
				    		feizhiViewForm.findById('ts_feizhi').setText("("+f.getValue().length+")");
				    	}
					}	
				}]
			},{
				columnWidth : '.03',
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'label',
				items : [{id:'ts_feizhi',name:'ts_feizhi',text:'(0)'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '经办人电话',name : 'tbrlxfs',labelSeparator:'',vtype:'dhhmphone',maxLength : 50,anchor:'100%'}]
			},{
                columnWidth:.3,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.TriggerField({
						id:"select_jglxdm_feizhi",
						name:"jglxdm",
						fieldLabel:"机构类型",
						anchor:'97%',
					 	valueField : "jglxdm",
					    displayField : "jglxdm",
					    labelSeparator:'',
					    haveShow : false,
					    editable : false,
					    allowBlank : false,
					    onTriggerClick : function() {
					    	window_jglxQuery_feizhi.show();
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
                items: [{ xtype:'textfield',fieldLabel : '机构类型名称',id:"select_jglxmc_feizhi",name : 'jglx',labelSeparator:'',allowBlank : false,hideLabel:true,readOnly:'true',anchor:'100%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{xtype : 'combo',
						fieldLabel : '小微企业',
						id : 'isxw_feizhi',
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
						readOnly:'true',
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
						id : 'gk_feizhi',
						name : 'gk',
						displayField : 'gk',
						valueField : 'gk',
						hiddenName : 'gk',
						readOnly:'true',
						store : gkStore,
						triggerAction : 'all',
						lazyRender:true,
						//emptyText:'请选择是否信息公开！',
						//width:135,
						value:'是',
						anchor:'100%',
						mode : 'local',
						selectOnFocus : true,
						labelSeparator:'',
						editable : false
					}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '正本数量',name : 'zbsl',labelSeparator:'',xtype : 'numberfield',anchor:'100%',readOnly:true}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '副本数量',name : 'fbsl',labelSeparator:'',xtype : 'numberfield',anchor:'100%',readOnly:true}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype : 'combo',
						fieldLabel : '是否发卡',
						id : 'fkbz_feizhi',
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
						readOnly:'true',
						selectOnFocus : true,
						editable : false
					}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '发卡数量',name : 'fksl',labelSeparator:'',xtype : 'numberfield',readOnly:true,value:0,anchor:'100%'}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构代码',name : 'jgdm',labelSeparator:'',allowBlank : false,maxLength : 9,readOnly:true,minLength:9,anchor:'100%'}]
			},{
                columnWidth:.75,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构名称',name : 'jgmc',labelSeparator:'',allowBlank : false,readOnly:true,maxLength : 100,anchor:'99.9%'}]
			},{
                columnWidth:.3,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '法定代表人',name : 'fddbr',labelSeparator:'',readOnly:true,maxLength : 30,anchor:'97%'}]
			},{
                columnWidth:.15,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '证件类型',name : 'zjlx',labelSeparator:'',readOnly:true,anchor:'97%'}]
			},{
                columnWidth:.3,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ 
                	xtype:'textfield',fieldLabel : '证件号码',name : 'zjhm',labelSeparator:'',hideLabel:true,readOnly:'true',anchor:'99.9%'	}]
			},{
                columnWidth:.25,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype:'textfield',fieldLabel : '移动电话',name : 'mobile',labelSeparator:'',readOnly:'true',anchor:'100%'}]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                defaultType : 'textarea',
                items: [{fieldLabel : '经营范围',name : 'jyfw',labelSeparator:'',maxLength:1000,height:55,readOnly:'true',anchor:'99.5%'}]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                defaultType : 'textarea',
                items: [{fieldLabel : '企业简介',name : 'qyjj',labelSeparator:'',maxLength:1000,height:55,readOnly:'true',anchor:'99.5%'}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '成立日期',name : 'zcrq',readOnly:true,labelSeparator:'',anchor:'100%'},
				     {xtype:'textfield',fieldLabel : '证照有效期',name : 'zsbfrq',readOnly:true,labelSeparator:'',anchor:'99.9%'},
				     {xtype:'textfield',fieldLabel : '企业注册类型',name : 'jjlxdm',readOnly:true,labelSeparator:'',anchor:'97%'},
				    {xtype:'textfield',fieldLabel : '经济行业',name : 'jjhydm',readOnly:true,labelSeparator:'',anchor:'97%'}]
				},{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '职工人数(人)',name : 'zgrs',labelSeparator:'',readOnly:true,anchor:'99.9%'},
	                	{xtype:'textfield',fieldLabel : '至',name : 'zszfrq',readOnly:true,labelSeparator:'',anchor:'99.9%'},
	                	{xtype:'textfield',fieldLabel : '经济类型名称',name : 'jjlx',readOnly:true,labelSeparator:'',hideLabel:true,anchor:'99.9%'},
	                	{xtype:'textfield',fieldLabel : '经济行业名称',name : 'jjhymc',readOnly:true,labelSeparator:'',hideLabel:true,anchor:'99.9%'}
	                ]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [{xtype:'textfield',fieldLabel : '注册资金(万)',name : 'zczj',readOnly:true,labelSeparator:'',anchor:'97%'}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [{xtype:'textfield',fieldLabel : '货币种类',name : 'hbzl',readOnly:true,labelSeparator:'',anchor:'99.9%'}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [{xtype:'textfield',fieldLabel : '外方国别',name : 'wftzgb',readOnly:true,labelSeparator:'',anchor:'97%'}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [{xtype:'textfield',fieldLabel : '外方国别代码',id : 'wftzgbdm_feizhi',name : 'wftzgbdm',readOnly:true,labelSeparator:'',hideLabel:true,anchor:'99.9%'}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [{xtype:'textfield',fieldLabel : '主管部门',name :'zgdm',labelSeparator:'',readOnly:true,anchor:'97%'},
					    {xtype:'textfield',fieldLabel : '批准机构',name :'pzjgdm',labelSeparator:'',readOnly:true,anchor:'97%'}]
	            },{
	                columnWidth:.75,
	                layout: 'form',
	                border:false,
	                items: [
	                	{xtype:'textfield',fieldLabel : '主管部门名称',name :'zgmc',labelSeparator:'',hideLabel:true,readOnly:true,anchor:'99.9%'},
	                	{xtype:'textfield',fieldLabel : '批准机构名称',name:'pzjgmc',labelSeparator:'',hideLabel:true,readOnly:true,anchor:'99.9%'}
	                ]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '注册号',name : 'zch',labelSeparator:'',readOnly:true,anchor:'100%'}]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '联系电话',name : 'dhhm',labelSeparator:'',readOnly:true,anchor:'100%'}]
	            },{
	                columnWidth:1,
	                layout: 'form',
	                border:false,
	                items: [
	                	{ xtype:'textfield',fieldLabel : '机构注册地址',name : 'jgdz',labelSeparator:'',readOnly:true,anchor:'99.9%'}
	                ]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [
	                { xtype:'textfield',fieldLabel : '行政区划',name : 'xzqhCode',labelSeparator:'',readOnly:true,anchor:'97%'}]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '行政区划名称',name : 'xzqhName',labelSeparator:'',hideLabel:true,readOnly:true,anchor:'99.9%'}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '邮政编码',name : 'yzbm',labelSeparator:'',minLength : 6,readOnly:true,anchor:'100%'}]
	            },{
	                columnWidth:1,
	                layout: 'form',
	                border:false,
	                items: [
	                	{ xtype:'textfield',fieldLabel : '机构实际地址',name : 'jydz',labelSeparator:'',readOnly:true,anchor:'99.9%'}
	                ]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [
	                { xtype:'textfield',fieldLabel : '行政区划',name : 'xzqhCode2',labelSeparator:'',readOnly:true,anchor:'97%'}]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '行政区划名称',name : 'xzqhName2',labelSeparator:'',hideLabel:true,readOnly:true,anchor:'99.9%'}]
	            },{
	                columnWidth:.25,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '邮政编码',name : 'jyyb',labelSeparator:'',minLength : 6,readOnly:true,anchor:'100%'}]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '网址',name : 'weburl',labelSeparator:'',readOnly:true,anchor:'100%'}]
	            },{
	                columnWidth:.5,
	                layout: 'form',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '电子邮箱',name : 'email',labelSeparator:'',readOnly:true,anchor:'100%'}]
	            },{
	                columnWidth:.33,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '办证日期',name : 'bzrq',labelSeparator:'',readOnly:true,maxLength : 50, renderer:dateFormat,anchor:'100%'}]
				},{
	                columnWidth:.34,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '作废日期',name : 'zfrq',labelSeparator:'',readOnly:true,maxLength : 50, renderer:dateFormat,anchor:'100%'}]
				},{
	                columnWidth:.33,
	                layout: 'form',
	                bodyStyle: 'padding:0px',
	                border:false,
	                items: [{ xtype:'textfield',fieldLabel : '年检期限',name : 'njqx',labelSeparator:'',readOnly:true,maxLength : 50, renderer:dateFormat,anchor:'100%'}]
				},{
                	columnWidth:1,
                	layout: 'form',
                	bodyStyle: 'padding:0px',
                	border:false,
                	items: [
                		{ xtype:'textfield',fieldLabel : '备注',name : 'memo',maxLength : 50,readOnly:true,anchor:'100%'},
	                	{xtype:'hidden',fieldLabel : '业务类型',name : 'ywlx',value:'注销'},
						{xtype : 'hidden',	name : 'orgid',value:''},
						{xtype : 'hidden',	name : 'orderid',id:'orderid'},
						{xtype : 'hidden',name : 'docid'},
						{xtype : 'hidden',name : 'imageUrl'},
					    {xtype : 'hidden',id:'hbzldm_feizhi',name : 'hbzldm'},
					    {xtype : 'hidden',id:'select_jjhymcOld_feizhi',name : 'jjhymcOld'},
					    {xtype : 'hidden',id:'select_jjhydmOld_feizhi',name : 'jjhydmOld'},
					    {xtype : 'hidden',name : 'bzjgdm',value:currentZzUserBzjgdm},
						{xtype : 'hidden',name : 'lastdate',value :myDate.format('Y-m-d')}, 
						{xtype : 'hidden',name : 'xgr',value:currentZzUsername},
						{xtype : 'hidden',name : 'lry'},
						{xtype : 'hidden',name : 'state',value:'12'}]
				}]
		}]
});




var  feizhiViewForm2= new Ext.Panel({
    title       : '基本信息',
    region      : 'center',
    id          : 'jbInfo29',
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
    items : [feizhiViewForm]
});


var fileFtpForm_feizhi = new Ext.Panel({
	title:'原文扫描',
	split:true,
	width:620,
	collapsible:true,
	collapsed: false,
    region:'east',
    margins:'3 0 0 5',
    cmargins:'3 0 0 5',
    //activeTab: 0,
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"  width=100%  height=100% align=center hspace=0 vspace=0 id="scanner24630"  name="scanner24630" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>'
    
});


//默认查询 档案
var searchfeizhi = function() {

	feizhiViewForm.getForm().reader = Orgnews;
	feizhiViewForm.getForm().load({
		waitMsg : '正在进行数据查询，请稍等',          //提示信息   
        waitTitle : '提示',                      //标题  
	    url: 'findAllYwqxOrgnew.action', //请求控制器获取数据
	    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
	    params: { conditions:  text_search_feizhi.getValue(),username:currentZzUsername,ywlxConditions:null,stateConditions:'10,11,12,13,14,15,16',start:1,limit:1},	
	    success:function(form,action) {//获取返回值
	    	if(action.result.data.ywlx=='注销' && (action.result.data.state=='12' || action.result.data.state=='14')){//判断业务是否办理中
	    		btn_del_feizhi.setDisabled(false);
	    		var tab3452=Ext.getCmp("jbInfo29");
	    		tab3452.setTitle("基本信息  ("+stateToInfo(feizhiViewForm.getForm().findField('state').value)+")");
	    		feizhiViewForm.getForm().findField('lastdate').setValue(myDate.format('Y-m-d'));
				feizhiViewForm.getForm().findField('xgr').setValue(currentZzUsername);
	    		feizhiViewForm.getForm().findField('bzjgdm').setValue(currentZzUserBzjgdm);
	    		var resultObject = null;
	    		Ext.Ajax.request({
					url : 'orgnewViewImg.action',
					params : {orgid : action.result.data.orgid},

					success : function(result,request) {//获取返回值
						scanner24630.ImageData="";
	   					var resultObject = Ext.util.JSON.decode(result.responseText); 
	   					if(resultObject!=null){
		   					scanner24630.OpenProgress(3);  //设置上传的进度条的总进度数
		   					scanner24630.Progress('原文加载中',1);
							scanner24630.Progress('原文加载中',2);
		   					scanner24630.ImageData=resultObject.imageData;
		   					scanner24630.pageType=resultObject.pageTypeStr;
		   					if(scanner24630.ImageData!=""){
		   						scanner24630.Progress('原文加载完毕',3);
								scanner24630.CloseProgress();
							}else{
								scanner24630.Progress('原文加载失败',3);
				   				scanner24630.CloseProgress();
				   				alert("原文错误，加载失败！");
							}
	   					}
					},
					failure : function() {
						scanner24630.ImageData="";
			   			scanner24630.CloseProgress();
						alert("图像加载错误，或者无原文");
					}
				});	
	
			}else{
				btn_del_feizhi.setDisabled(true);
			    //btn_save_qianchu_menu.setDisabled(true);
			    
				Ext.Msg.show({
					title : '提示',
					msg : '机构正在进行“'+action.result.data.ywlx+'”业务办理中!',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.INFO,
					fn : function() {feizhiViewForm.getForm().reset();scanner24630.ImageData="";}
				});
            }
		},
		failure : function() {//正式库检索
				feizhiViewForm.getForm().reader = Orgnews;
				feizhiViewForm.getForm().load({
					waitMsg : '正在进行数据查询，请稍等',          //提示信息   
			        waitTitle : '提示',                      //标题  
				    url: 'findAllTjgdmByJgdm.action', //请求控制器获取数据
				    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
				    params: { jgdm:  text_search_feizhi.getValue(),userBzjgdm:null},	
				    success:function(form,action) {//获取返回值
				    		if(currentZzUsername!='admin' && sysBzjgLimitMode=='1' && action.result.data.bzjgdm!=currentZzUserBzjgdm && currentZzUserYwqx!='2' && currentZzUserBzjgdm!=currentZzUserCenterid){
				    				Ext.Msg.show({
										title : '提示',
										msg : '【'+action.result.data.jgmc+'】，<br><br>办证机构代码为“'+action.result.data.bzjgdm+'”,不属于本办证机构办理！',
										buttons : Ext.Msg.OK,
										fn:  function() {
											btn_del_feizhi.setDisabled(true);
							    			btn_save_feizhi_menu.setDisabled(false);
							    			
											feizhiViewForm.getForm().reset();
											scanner24630.ImageData="";
											var tab3452559=Ext.getCmp("jbInfo29");
							    			tab3452559.setTitle("基本信息");
										},
										icon : Ext.Msg.ERROR
									});
				    		}else{
						    	if(action.result.data.state=='100' || action.result.data.state==''){//判断此机构状态是否正常
						    		btn_del_feizhi.setDisabled(true);
						    		scanner24630.ImageData="";
						    		var tab3452=Ext.getCmp("jbInfo29");
						    		tab3452.setTitle("基本信息  (新录入)");
						    		feizhiViewForm.getForm().findField('ywlx').setValue('注销');
						    		feizhiViewForm.getForm().findField('state').setValue('12');
						    		feizhiViewForm.getForm().findField('orgid').setValue('');
						    		feizhiViewForm.getForm().findField('lastdate').setValue(myDate.format('Y-m-d'));
									feizhiViewForm.getForm().findField('xgr').setValue(currentZzUsername);
									feizhiViewForm.getForm().findField('fkbz').setValue('否');
							    	feizhiViewForm.getForm().findField('fksl').setValue('0');
							    	feizhiViewForm.getForm().findField('bzjgdm').setValue(currentZzUserBzjgdm);
								}else{
									Ext.Msg.show({
										title : '提示',
										msg : '机构“'+action.result.data.jgmc+'”状态为“'+tjgdmStateToInfo(action.result.data.state)+'”,<br><br>不能再次办理业务！',
										buttons : Ext.Msg.OK,
										fn:  function() {
											btn_del_feizhi.setDisabled(true);
							    			btn_save_feizhi_menu.setDisabled(false);
							    			
											feizhiViewForm.getForm().reset();
											scanner24630.ImageData="";
											var tab3452559=Ext.getCmp("jbInfo29");
							    			tab3452559.setTitle("基本信息");
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
									//btn_del_feizhi.setDisabled(true);
								    //btn_shibie_feizhi.setDisabled(false);
									feizhiViewForm.getForm().reset();
									scanner24630.ImageData="";
								}
							});
						}	
				});
			}
	});
}

var btn_search_feizhi = new Ext.Button({
	text : '代码查询',
	iconCls : 'icon-search',
	handler : function() {
		searchfeizhi();
	}
});

var text_search_feizhi = new Ext.form.TextField({
	id : 'textSearchfeizhi',
	name : 'textSearchfeizhi',
	width : 200,
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchfeizhi();
			}
		}
	}
});


var btn_refresh_feizhi = new Ext.Button({
	text : '重置',
	iconCls : 'icon-refresh',
	handler : function() {
    	//btn_save_feizhi_menu.setDisabled(true);
    	//btn_shibie_feizhi.setDisabled(false);
		btn_del_feizhi.setDisabled(true);
		feizhiViewForm.getForm().reset();
		var tab3452=Ext.getCmp("jbInfo29");
	    tab3452.setTitle("基本信息");
		scanner24630.ImageData="";
		//this.ownerCt.form.reset();;
	}
});


var btn_del_feizhi = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	disabled:true,
	handler : function() {
		var orgid = feizhiViewForm.getForm().findField('orgid').value;
		if(orgid!=null && orgid!=""){
			Ext.Msg.confirm('确认删除', '你确定删除吗?', function(btn) {
				if (btn == 'yes') {
					ajaxLoadMask.show();
					Ext.Ajax.request({
						url : 'deleteOrgnew.action',
						params : {orgid : orgid},
						success : function() {
							ajaxLoadMask.hide();
							btn_del_feizhi.setDisabled(true);
					    	//btn_shibie_feizhi.setDisabled(false);
							feizhiViewForm.getForm().reset();
							var tab3452=Ext.getCmp("jbInfo29");
	    					tab3452.setTitle("基本信息");
							scanner24630.ImageData="";
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

var btn_duru_feizhi = new Ext.Button({
	text : '测试键入',
	iconCls : 'icon-add',
	//disabled:true,调用参数
	//scanner.GetOCRValue 返回 识别结果
	handler : function(){
		//var ocrStr=scanner24630.GetOCRValue;
		//,{id:'jyfw',value:'许可经营项目'},{id:'zcrq',value:'2011-07-27'},{id:'zczj',value:'10'},{id:'zch',value:'110106014104570'},{id:'jgdz',value:'北京市丰台区永外海户屯166号院5号楼101室'},{id:'jglx',value:'有限责任公司'},{id:'tbrxm',value:'高跃辉'},{id:'tbrsfzh',value:'410325198204126593'},{id:'tbrzjlx',value:'居民身份证'}
		//  var ocrStr="[{id:'jgmc',value:'11'},{id:'fddbr',value:'11'}]";
		//var ocrStr="[{id:'jgmc',value:'zhangsan'},{id:'fddbr',value:'15'}]";
		//var ocrStr="[{id:'jgmc',value:'北京顺光庆华商贸有限公司'},{id:'fddbr',value:'杨志英'},{id:'jyfw',value:'许可经营项目'},{id:'zcrq',value:'2011年07月27日'},{id:'zczj',value:'10'},{id:'zch',value:'110106014104570'},{id:'jgdz',value:'北京市丰台区永外海户屯166号院5号楼101室'},{id:'jglx',value:'有限责任公司'},{id:'tbrxm',value:'高跃辉'},{id:'tbrsfzh',value:'410325198204126593'},{id:'tbrzjlx',value:'居民身份证'}]";
 		var ocrStr="[{id:'orgid',value:''},{id:'jgmc',value:'北京东方世纪科技有限公司'},{id:'jgdm',value:'109101235'},	{id:'fddbr',value:'张治中'},	{id:'zjlx',value:'居民身份证'},{id:'zjhm',value:'107101192312015714'},{id:'jyfw',value:'在法律范围内，许可经营项目'},{id:'zcrq',value:'19711209'},{id:'zczj',value:'10000'},	{id:'zch',value:'110101218105012'},{id:'jglx',value:'有限责任公司'},{id:'jgdz',value:'北京市海淀区中航工业大厦1805室'},{id:'pzjgmc',value:'北京市工商局'},{id:'pzjgdm',value:'110000021'},{id:'jjlx',value:'有限责任公司'},{id:'zsbfrq',value:'1972-01-01'},{id:'zszfrq',value:'1992-01-01'},{id:'wftzgb',value:'中国'},{id:'hbzl',value:'人民币'},{id:'jydz',value:'北京市海淀区中关村科技广场鼎好大厦12楼'},{id:'zgmc',value:'海淀国资委'},{id:'zgdm',value:'100001231'},{id:'dhhm',value:'010-62528899'},{id:'mobile',value:'13810101225'},{id:'jjhymc',value:'计算机软件'},{id:'jjhydm',value:'0709'},{id:'zgrs',value:'500'},{id:'xzqhCode',value:'100000220'},{id:'xzqhName',value:'北京市海淀区'},{id:'yzbm',value:'100098'},{id:'weburl',value:'www.163.com'},{id:'email',value:'hr@163.com'},{id:'tbrxm',value:'申通'},{id:'tbrsfzh',value:'110109198509014216'},{id:'tbrzjlx',value:'居民身份证'},{id:'tbrlxfs',value:'13366114568'},{id:'gk',value:'是'}]";
		if(ocrStr!="" && ocrStr!=null){
			var respText = Ext.util.JSON.decode(ocrStr); 
			feizhiViewForm.getForm().setValues(respText); 
			//btn_del_feizhi.setDisabled(true);
			//btn_save_feizhi_menu.setDisabled(false);
			//var respText = Ext.util.JSON.decode(ocrStr); 
			//feizhiViewForm.getForm().setValues(respText); 
			//alert(respText.jgmc);
			
			//feizhiViewForm.getForm().reader = Orgnews;
			//feizhiViewForm.getForm().load({waitMsg:'正在加载数据请稍后',url:'ocr.json'});
		}else{
			alert("请扫描或导入需识别的图片！");
		}
	}
});




var btn_save_feizhi_menu = new Ext.Toolbar.MenuButton({
    text: '保存',
    handler: btn_feizhi_saveAll,
    tooltip: {title:'保存数据和原文',text:'保存'},
    iconCls: 'blist',
    //disabled:true,
    menu : {items: [
                {text: '全部保存', handler: btn_feizhi_saveAll}, '-',
                {text: '仅保存数据', handler: btn_feizhi_saveInfo},
                {text: '仅上传原文', handler: btn_feizhi_ftpFile}
        ]}
});

var upFuncFZ = function(docid,orgid,strJgdm,strState,strYwlx,jgmc){
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
				strBzjgdm=feizhiViewForm.getForm().findField('bzjgdm').value; 
				
				packLength = 40960;	//定义每个包的大小40960
				//scanner24630.ImageData=document.getElementById("ImageData").value;
				base64file = scanner24630.ImageData;  //获取控件扫描的图片数据
				var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
				imageCount = scanner24630.ImageCount;	//获取扫描图片的页数
				pageTypeStr = scanner24630.PageType;    //获取标识字符串,需要写数据库
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
				scanner24630.OpenProgress(packCount);  //设置上传的进度条的总进度数
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
							scanner24630.Progress('上传中',i+1);
						}
						else
						{
							alert("上传失败，请重试0001。");
							//scanner24630.ShowSendMsg(false);
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
					msg : '['+feizhiViewForm.getForm().findField('jgmc').value+']，<br><br>信息保存成功！',
					buttons : Ext.Msg.OK,
					fn : function() {
						scanner24630.CloseProgress();
						subFZAction(orgid,strJgdm,strState,strYwlx,jgmc);
					},
					icon : Ext.Msg.INFO
				});

				
}

function btn_feizhi_saveAll(btn){
	if (feizhiViewForm.getForm().isValid()) {
		feizhiViewForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在保存数据,请稍候...',
			success : function(form,action) {
				
				feizhiViewForm.getForm().findField('orgid').setValue(action.result.orgid);
				feizhiViewForm.getForm().findField('docid').setValue(action.result.docid);
				var orgid = feizhiViewForm.getForm().findField('orgid').getValue();
				var docid = action.result.docid;
		var strJgdm = feizhiViewForm.getForm().findField('jgdm').getValue();
		var strState = feizhiViewForm.getForm().findField('state').getValue();
		var jgmc = feizhiViewForm.getForm().findField('jgmc').getValue();
		var strYwlx = feizhiViewForm.getForm().findField('ywlx').getValue();
				if(scanner24630.ImageCount>0){
					if(orgid!=null && orgid!=""){
			Ext.Ajax.request({
				url: 'checkArchive.action',
				params: {orgid: orgid,jgdm:strJgdm},
				success: function(result,request){//result,request
					var data = Ext.util.JSON.decode(result.responseText);
					var str = scanner24630.CheckArchives("注销",data.jglxdmOld,data.zchInfo,data.frInfo);
					if(str==''){
						//alert("更新imageFlag为1（表示档案完整）");
						refreshImageFlag(orgid,'1');
						upFuncFZ(docid,orgid,strJgdm,strState,strYwlx,jgmc);
					}else{
						//alert(str+"::更新imageFlag为0（表示档案不完整）");
						Ext.Msg.show({
							title : '提示',
							msg : str + '继续提交则选是,取消提交则选否！',
							buttons : Ext.Msg.OKCANCEL,
							fn : function(btn){
								if(btn == 'ok'){
									refreshImageFlag(orgid,'0');
									upFuncFZ(docid,orgid,strJgdm,strState,strYwlx,jgmc);
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
				msg : '请保存信息后，再进行“注销确认”处理！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.INFO
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
									subFZAction(orgid,strJgdm,strState,strYwlx,jgmc);
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

function btn_feizhi_saveInfo(btn){
	if (feizhiViewForm.getForm().isValid()) {
		feizhiViewForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在保存数据,请稍候...',
			success : function(form,action) {
				//alert(action.result.orgid);
				feizhiViewForm.getForm().findField('orgid').setValue(action.result.orgid);
				feizhiViewForm.getForm().findField('docid').setValue(action.result.docid);
				Ext.Msg.show({
					title : '提示',
					msg : '['+feizhiViewForm.getForm().findField('jgmc').value+']，申办信息保存成功',
					buttons : Ext.Msg.OK,
					//fn : function() {btn.enable();btn_ok_feizhi.setDisabled(false);},
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

function btn_feizhi_ftpFile(btn){
	
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
	strOrgid =feizhiViewForm.getForm().findField('orgid').value;  //参数orgid
	strDocid =feizhiViewForm.getForm().findField('docid').value;  //参数docid
	strBzjgdm=feizhiViewForm.getForm().findField('bzjgdm').value;  //办证机构代码
	//alert("strOrgid="+strOrgid);
	
	if(strOrgid!=""){
			packLength = 40960;	//定义每个包的大小40960
			//scanner24630.ImageData=document.getElementById("ImageData").value;
			base64file = scanner24630.ImageData;  //获取控件扫描的图片数据
			var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
			imageCount = scanner24630.GetPageCount;	//获取扫描图片的页数
			pageTypeStr = scanner24630.PageType;    //获取标识字符串,需要写数据库
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
			scanner24630.OpenProgress(packCount);  //设置上传的进度条的总进度数
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
						scanner24630.Progress('上传中',i+1);
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
			scanner24630.CloseProgress();
			
			Ext.Msg.show({
				title : '提示',
				msg : '['+feizhiViewForm.getForm().findField('jgmc').value+']，<br><br>原文上传成功！',
				buttons : Ext.Msg.OK,
				fn : function() {btn.enable();},
				icon : Ext.Msg.INFO
			});
			
			scanner24630.CloseProgress();
			return true;
	}else{
		alert("请录入数据后，再上传原文！");
	}
}

//提交确认方法
var subFZAction =function (orgid,strJgdm,strState,strYwlx,jgmc){
	ajaxLoadMask.hide();
	Ext.Ajax.request({
		url: 'returnOrgnewDo.action',
		params: {orgid: orgid,jgdm:strJgdm,state:strState,ywlx:strYwlx},
		success: function(){
			ajaxLoadMask .hide();
			Ext.Msg.show({
				title : '提示',
				msg : '[' + jgmc + ']申请单办理完毕！',
				buttons : Ext.Msg.OK,
				fn:  function() {
   					feizhiViewForm.getForm().findField('orgid').setValue('');
   					
   					var tab345=Ext.getCmp("jbInfo29");
		    		tab345.setTitle("基本信息");	
					feizhiViewForm.getForm().reset();
					scanner24630.PageType="";
					scanner24630.ImageData="";
					text_search_feizhi.setValue("");
				},
				icon : Ext.Msg.INFO
			});
		},
		failure: function(){
			ajaxLoadMask .hide();
			Ext.Msg.show({
				title : '提示',
				msg : '[' + jgmc + ']申请单办理失败！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR
			});
		}
	});
}

var btn_saveInfo_feizhi = new Ext.Button({
	text : '保存数据',
	iconCls : 'blist',
	handler : btn_feizhi_saveInfo
});

var btn_print_feizhi = new Ext.Button({
	text : '打印注销单',
	iconCls : 'icon-print',
	handler : function(){
		
		var orgid = feizhiViewForm.getForm().findField('orgid').getValue();
		if(orgid!=null && orgid!=""){
			ajaxLoadMask .show();
			Ext.Ajax.request({
				url: 'findOrgnewByOrgid.action',
   				params: {orgid: orgid},
   				success: function(result,request){//获取返回值
   					ajaxLoadMask .hide();
   					var resultObject = Ext.util.JSON.decode(result.responseText);
   					if(resultObject.root.length!=0){
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
			tableStr = tableStr + '            <td colspan="5"  align="center">'+resultObject.root[0].jgdm+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '           <td width="140" height="40" align="center" class="STYLE8">机构名称</td>';
			tableStr = tableStr + '            <td colspan="5"  align="center">'+resultObject.root[0].jgmc+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40" align="center" class="STYLE8"> 注销核准机关</td>';
			tableStr = tableStr + '            <td colspan="5" align="center"></td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40"  align="center" class="STYLE8">注销核准文号</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+resultObject.root[0].offPzwh+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40"  align="center" class="STYLE8">注销原因</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+resultObject.root[0].offReason+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '         <tr>';
			tableStr = tableStr + '            <td height="40" align="center" class="STYLE8">证书回收情况</span></td>';
			tableStr = tableStr + '            <td colspan="5" align="center">□ 正本&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;□ 纸质副本&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;个&nbsp;&nbsp;&nbsp;&nbsp;□ 电子副本&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="63" class="STYLE8"  align="center">经办人</td>';
			tableStr = tableStr + '            <td width="125" align="center">'+resultObject.root[0].tbrxm+'</td>';
			tableStr = tableStr + '            <td width="60" height="63" align="center" class="STYLE8">身份证件号码</td>';
			tableStr = tableStr + '            <td width="177" height="63" class="STYLE8" align="center">'+resultObject.root[0].tbrsfzh+'</td>';
			tableStr = tableStr + '            <td width="46" height="63" align="center" class="STYLE9">联系<br>';
			tableStr = tableStr + '            电话</td>';
			tableStr = tableStr + '            <td width="127" height="63" class="STYLE9" align="center">'+resultObject.root[0].tbrlxfs+'</td>';
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
			tableStr = tableStr + '            <td height="54" colspan="5" align="center" class="STYLE18 STYLE19">组织机构代码注销证明</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '        </table>';
			tableStr = tableStr + '      <table id="table4" style="width:689;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "1" bordercolor= "#3366FF">';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td width="140" height="40"  align="center" class="STYLE8"> 机构代码</td>';
			tableStr = tableStr + '            <td colspan="5"  align="center">'+resultObject.root[0].jgdm+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '           <td width="140" height="40" align="center" class="STYLE8">机构名称</td>';
			tableStr = tableStr + '            <td colspan="5"  align="center">'+resultObject.root[0].jgmc+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40" align="center" class="STYLE8"> 注销核准机关</td>';
			tableStr = tableStr + '            <td colspan="5" align="center"></td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40"  align="center" class="STYLE8">注销核准文号</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+resultObject.root[0].offPzwh+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="40"  align="center" class="STYLE8">注销原因</td>';
			tableStr = tableStr + '            <td colspan="5" align="center">'+resultObject.root[0].offReason+'</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '         <tr>';
			tableStr = tableStr + '            <td height="40" align="center" class="STYLE8">证书回收情况</span></td>';
			tableStr = tableStr + '            <td colspan="5" align="center">□ 正本&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;□ 纸质副本&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;个&nbsp;&nbsp;&nbsp;&nbsp;□ 电子副本&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>';
			tableStr = tableStr + '          </tr>';
			tableStr = tableStr + '          <tr>';
			tableStr = tableStr + '            <td height="63" class="STYLE8"  align="center">经办人</td>';
			tableStr = tableStr + '            <td width="125" align="center">'+resultObject.root[0].tbrxm+'</td>';
			tableStr = tableStr + '            <td width="60" height="63" align="center" class="STYLE8">身份证件号码</td>';
			tableStr = tableStr + '            <td width="177" height="63" class="STYLE8" align="center">'+resultObject.root[0].tbrsfzh+'</td>';
			tableStr = tableStr + '            <td width="46" height="63" align="center" class="STYLE9">联系<br>';
			tableStr = tableStr + '            电话</td>';
			tableStr = tableStr + '            <td width="127" height="63" class="STYLE9" align="center">'+resultObject.root[0].tbrlxfs+'</td>';
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
			if(resultObject.root[0].dybz != 'N'){
				Ext.Ajax.request({
					url : "updateDybzByOrgid.action",
					params : {orgid : resultObject.root[0].orgid},
					success : function(result,request) {
						
					}
				});
			}
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

var btn_ok_feizhi = new Ext.Button({
	text : '确认提交',
	iconCls : 'icon-store',
	handler : btn_feizhi_saveAll
});


var p_zzFeizhi = {
	id : 'zzFeizhi-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:0px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    bodyBorder: false,
	    title: '注销',
	    iconCls : 'icon-plugin',
 		plain: true,
		region: 'center',
		tbar : [btn_refresh_feizhi,btn_del_feizhi,/*btn_save_feizhi_menu*/btn_saveInfo_feizhi,btn_print_feizhi,btn_ok_feizhi,'->',text_search_feizhi,btn_search_feizhi],
		items: [feizhiViewForm2,fileFtpForm_feizhi]
	}]
}