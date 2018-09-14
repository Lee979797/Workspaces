var btn_search_pzjg_plfz = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchPzjg_plfz();
		//btn_search_pzjg_plfz.setDisabled(true);
	}
});


var text_search_pzjg_plfz = new Ext.form.TextField({
	id : 'textSearchPzjg_plfz',
	name : 'textSearchPzjg_plfz',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchPzjg_plfz();
			}
		},
		'change' : function(field, e) {
			btn_search_pzjg_plfz.setDisabled(false);
		}
	}
});


var cm_pzjg_plfz = new Ext.grid.ColumnModel([
	{header : '批准机构名称',width : 50,dataIndex : 'pzjgmc',sortable : true}, 
	{header : '批准机构代码',width : 20,dataIndex : 'pzjgdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_pzjg_plfz = new Ext.data.Store({
	url : 'findAllByConditionPzjg.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'pzjgid',type : 'int'}, 
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchPzjg_plfz = function() {
	ds_pzjg_plfz.baseParams.conditions = text_search_pzjg_plfz.getValue();
	ds_pzjg_plfz.baseParams.username='';
	ds_pzjg_plfz.baseParams.stateConditions='';
	ds_pzjg_plfz.load({params : {start : 0,limit : 20} });
}

var grid_pzjg_plfz = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_pzjg_plfz,
	ds : ds_pzjg_plfz,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入登记批准机构名称：',text_search_pzjg_plfz,btn_search_pzjg_plfz],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_pzjg_plfz,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_pzjgQuery_plfz.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			piliangfeizhiViewForm.getForm().findField('select_pzjgmc_piliangfeizhi').setValue(selections[0].get('pzjgmc'));
			piliangfeizhiViewForm.getForm().findField('select_pzjgdm_piliangfeizhi').setValue(selections[0].get('pzjgdm'));
		}
	}
});


var window_pzjgQuery_plfz = new Ext.Window({
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
	items : [grid_pzjg_plfz]
});


var btn_search_jglxSelcet_plfz = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchJglxSelcet_plfz();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_jglxSelcet_plfz = new Ext.form.TextField({
	id : 'textsearchJglxSelcet_plfz',
	name : 'textsearchJglxSelcet_plfz',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJglxSelcet_plfz();
			}
		},
		'change' : function(field, e) {
			btn_search_jglxSelcet_plfz.setDisabled(false);
		}
	}
});


var cm_jglxSelcet_plfz = new Ext.grid.ColumnModel([
    {header : '一级类型',width : 60,dataIndex : 'pjglxmc',sortable : true}, 
	{header : '二级类型',width : 100,dataIndex : 'jglxmc',sortable : true}, 
	{header : '代码',width : 30,dataIndex : 'jglxdm',sortable : true},
	{header : '备注',width : 50,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_jglxSelcet_plfz = new Ext.data.Store({
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

var searchJglxSelcet_plfz = function() {
	ds_jglxSelcet_plfz.baseParams.conditions = text_search_jglxSelcet_plfz.getValue();
	ds_jglxSelcet_plfz.baseParams.username="";
	ds_jglxSelcet_plfz.baseParams.stateConditions='';
	ds_jglxSelcet_plfz.load({params : {start : 0,limit : 20} });
}

var grid_jglx_piliangfeizhi = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jglxSelcet_plfz,
	ds : ds_jglxSelcet_plfz,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入机构类型名称：',text_search_jglxSelcet_plfz,btn_search_jglxSelcet_plfz],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jglxSelcet_plfz,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jglxQuery_piliangfeizhi.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			piliangfeizhiViewForm.getForm().findField('select_jglxmc_piliangfeizhi').setValue(selections[0].get('jglxmc'));
			piliangfeizhiViewForm.getForm().findField('select_jglxdm_piliangfeizhi').setValue(selections[0].get('jglxdm'));
		}
	}
});


var window_jglxQuery_piliangfeizhi = new Ext.Window({
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
	items : [grid_jglx_piliangfeizhi]
});



var btn_search_hylxSelcet_plfz = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchHylxSelcet_plfz();
		//btn_search_jjlx.setDisabled(true);
	}
});


var text_search_hylxSelcet_plfz = new Ext.form.TextField({
	id : 'textSearchHylxSelcet_plfz',
	name : 'textSearchHylxSelcet_plfz',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchHylxSelcet_plfz();
			}
		},
		'change' : function(field, e) {
			btn_search_hylxSelcet_plfz.setDisabled(false);
		}
	}
});

var ds_wftzgb_select_plfz = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=3',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});

var cm_hylxSelcet_plfz = new Ext.grid.ColumnModel([
	{header : '大类',width : 100,dataIndex : 'hylxmc1',sortable : true}, 
	{header : '中类',width : 100,dataIndex : 'hylxmc2',sortable : true}, 
	{header : '小类',width : 100,dataIndex : 'hylxmc3',sortable : true}, 
   {header : '经济行业名称',width : 100,dataIndex : 'hylxmc',sortable : true},
	{header : '经济行业代码',width : 30,dataIndex : 'hylxdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_hylxSelcet_plfz = new Ext.data.Store({
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

var searchHylxSelcet_plfz = function() {
	ds_hylxSelcet_plfz.baseParams.conditions = text_search_hylxSelcet_plfz.getValue();
	ds_hylxSelcet_plfz.baseParams.username="";
	ds_hylxSelcet_plfz.baseParams.stateConditions='';
	ds_hylxSelcet_plfz.load({params : {start : 0,limit : 20} });
}

var grid_hylx_piliangfeizhi = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_hylxSelcet_plfz,
	ds : ds_hylxSelcet_plfz,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入经济行业代码名称：',text_search_hylxSelcet_plfz,btn_search_hylxSelcet_plfz],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_hylxSelcet_plfz,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_hylxQuery_piliangfeizhi.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			piliangfeizhiViewForm.getForm().findField('select_jjhymc_piliangfeizhi').setValue(selections[0].get('hylxmc'));
			piliangfeizhiViewForm.getForm().findField('select_jjhydm_piliangfeizhi').setValue(selections[0].get('hylxdm'));
			piliangfeizhiViewForm.getForm().findField('select_jjhymcOld_piliangfeizhi').setValue(selections[0].get('hylxmcOld'));
			piliangfeizhiViewForm.getForm().findField('select_jjhydmOld__piliangfeizhi').setValue(selections[0].get('hylxdmOld'));
		}
	}
});


var window_hylxQuery_piliangfeizhi = new Ext.Window({
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
	items : [grid_hylx_piliangfeizhi]
});

//--------------------机构基本信息-------------------------------------------
var piliangfeizhiViewForm = new Ext.FormPanel({	
	url : 'saveOrgnew.action',
	labelAlign : 'right',
    bodyStyle:'padding:0px',
	labelWidth : 110,
	border : false,
	baseCls : 'x-plain',
	waitMsgTarget: true,
	autoScroll : true,
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
            	items: [{ xtype:'textfield',fieldLabel : '注销依据',name : 'offPzwh',maxLength : 250,anchor:'100%'}]
            },{
            	columnWidth:.5,
            	layout: 'form',
            	bodyStyle: 'padding:0px',
            	border:false,
            	items: [{ xtype:'textfield',fieldLabel : '注销批准机构名称',name : 'offPzjgmc',allowBlank : false,maxLength : 100,anchor:'100%'}]	
			},{
            	columnWidth:1,
            	layout: 'form',
            	bodyStyle: 'padding:0px',
            	border:false,
            	items: [{ xtype:'textfield',fieldLabel : '注销原因',name : 'offReason',maxLength : 250,anchor:'100%'}]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '注销备注',name : 'offNote',maxLength : 100,anchor:'100%'}]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构名称',name : 'jgmc',allowBlank : false,maxLength : 100,anchor:'100%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '法定代表人',name : 'fddbr',allowBlank : false,maxLength : 30,anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '证件号码',name : 'zjhm',allowBlank : false,maxLength : 50,anchor:'100%'}]
			},{
                columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构代码',name : 'jgdm',allowBlank : false,maxLength : 50,anchor:'100%'},
                	{	xtype : 'combo',
						fieldLabel : '证件类型',
						id : 'zjlx_piliangfeizhi',
						name:'zjlx',
						hiddenName : 'zjlx',
						valueField : 'categoryName',
						displayField : 'categoryName',
						mode : 'remote',
						store : ds_zjlx_select,
						selectOnFocus : true,
						editable : false,
						allowBlank : false,
						readOnly:true,
						maxLength : 25,
						anchor:'100%',
						//onTriggerClick : Ext.emptyFn,
						triggerAction : 'all',
						loadingText : '加载中...',
						listeners : {
							'select' : function(combo, record, index) {
								//this.ownerCt.ownerCt.ownerCt.form.findField('book.categoryName').setValue(record.data.categoryName);
							}
						}
					}]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                defaultType : 'textarea',
                items: [
                	{ fieldLabel : '经营范围',name : 'jyfw',allowBlank : false,maxLength : 1000,anchor:'99.5%',height:'55'}]
			},{
                columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                defaultType : 'textarea',
                items: [
                	{ fieldLabel : '企业简介',name : 'qyjj',maxLength : 1000,anchor:'99.5%',height:'55'}]
			},{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [new Ext.form.DateField({  
		                id:'zcrq_piliangfeizhi',
		                name: 'zcrq',
		                format:'Y-m-d',
		                maxValue:myDate,  
		                maxText:'所选日期应在{0}之前',  
		                minValue:'01/01/1949',
		                minText:'所选日期应在{0}之后',
		                anchor:'100%',
		                allowBlank : false,
		                fieldLabel:'成立日期',
		                renderer:dateFormat,
					    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd'
				    }),
                	{ xtype:'textfield',fieldLabel : '企业注册类型',name : 'jjlx',maxLength : 50,anchor:'100%'},
                	new Ext.form.DateField({  
					    id:'zszfrq_piliangfeizhi',
					    name: 'zszfrq',
					    format:'Y-m-d',
					    //maxValue:myDate,  
					    //maxText:'所选日期应在{0}之前',  
					    minValue:'01/01/1949',
					    minText:'所选日期应在{0}之后',
					    anchor:'100%',
					    fieldLabel:'证照终止日期',
					    renderer:dateFormat,
					    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd' 
					    }),
                	{	xtype : 'combo',
						fieldLabel : '投资国别或地区',
						id : 'wftzgb_piliangfeizhi',
						displayField : 'categoryName',//显示值的名称
						hiddenName : 'wftzgb',//真正提交时此combo的name
						valueField : 'categoryCode',//真正提交时此combo的value
						mode : 'remote',
						store : ds_wftzgb_select_plfz,
						selectOnFocus : true,
						anchor:'100%',
						maxLength : 50,
						editable : false,
						triggerAction : 'all',
						loadingText : '加载中...',
						listeners : {
							'select' : function(combo, record, index) {
								//piliangfeizhiViewForm.getForm().findField('_wftzgb').setValue(Ext.get("wftzgb_piliangfeizhi").dom.value);
								//piliangfeizhiViewForm.getForm().findField('_wftzgbdm').setValue(this.getValue());
							}
						}
					},
                	{ xtype:'textfield',fieldLabel : '主管部门',name : 'zgmc',allowBlank : false,vtypeText:'不是有效的机构代码格式',anchor:'100%'}
                	
                ]
            },{
                columnWidth:.5,
                layout: 'form',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '职工人数',name : 'zgrs',allowBlank : false,xtype : 'numberfield',readOnly:true,maxLength : 2000000000,anchor:'100%'},
                	new Ext.form.DateField({  
		                id:'zsbfrq_piliangfeizhi',
		                name: 'zsbfrq',
		                format:'Y-m-d',
		                //maxValue:myDate,  
		                //maxText:'所选日期应在{0}之前',  
		                minValue:'01/01/1900',
		                minText:'所选日期应在{0}之后',
		                //width:150,
		                anchor:'100%',
		                allowBlank : false,
		                fieldLabel:'证照开始日期',
		                renderer:dateFormat,
		                
					    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd'
				        }),
                	{ xtype:'textfield',fieldLabel : '注册资金',name : 'zczj',allowBlank : false,xtype : 'numberfield',maxValue : 2000000000,anchor:'100%'},
                	{xtype : 'combo',
						fieldLabel : '货币种类',
						id : 'hbzl_piliangfeizhi',
						displayField : 'categoryName',//显示值的名称
						hiddenName : 'hbzl',//真正提交时此combo的name
						valueField : 'categoryCode',//真正提交时此combo的value
						mode : 'remote',
						store : ds_hbzl_select,
						selectOnFocus : true,
						maxLength : 50,
						anchor:'100%',
						editable : false,
						triggerAction : 'all',
						loadingText : '加载中...',
						listeners : {
							'select' : function(combo, record, index) {
								piliangfeizhiViewForm.getForm().findField('_hbzl').setValue(Ext.get("hbzl_piliangfeizhi").dom.value);
								piliangfeizhiViewForm.getForm().findField('_hbzldm').setValue(this.getValue());
							}
						}
					},
                	new Ext.form.TriggerField({
						id:"select_pzjgmc_piliangfeizhi",
						name:"pzjgmc",
						fieldLabel:"批准机构名称",
					 	valueField : "pzjgmc",
					    displayField : "pzjgmc",
					    maxLength : 80,
					    anchor:'100%',
					    allowBlank : false,
					    haveShow : false,
					    editable : false,
					    onTriggerClick : function() {
					    	window_pzjgQuery_plfz.show();
					    }
				    })
                ]
            },{
            	columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '注册文号',name : 'zch',allowBlank : false,maxLength : 50,anchor:'100%'}
                ]
            },{
            	columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{xtype:'textfield',fieldLabel : '批准机构代码',allowBlank : false,id:"select_pzjgdm_piliangfeizhi",vtype:'alphanum',vtypeText:'不是有效的机构代码格式',name:'pzjgdm',maxLength : 9,minLength : 9,anchor:'100%'}
                ]
            },{
            	columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '机构注册地址',name : 'jgdz',allowBlank : false,maxLength : 100,anchor:'100%'}
                ]
            },{
            	columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{xtype : 'combo',
						fieldLabel : '行政区划',
						id : 'xzqh_piliangfeizhi',
						name : 'xzqhName',  //接收值的名称
						displayField : 'xzqhName', //显示值的名称
						hiddenName : 'xzqhName', //真正提交时此combo的name
						valueField : 'xzqhCode',  //真正提交时此combo的value
						maxLength : 50,
						allowBlank : false,
						mode : 'remote',
						store : new Ext.data.Store({
							//autoLoad : true,
							proxy : new Ext.data.HttpProxy({
								url : 'findAllXzqh.action'
							}),
							reader : new Ext.data.JsonReader({
								root : 'root'
							}, [{name : 'xzqhCode',type : 'string'},
								{name : 'xzqhName',type : 'string'},
								{name : 'xzqhNote',type : 'string'}
							])
						}),
						selectOnFocus : true,
						editable : false,
						triggerAction : 'all',
						loadingText : '加载中...',
						anchor:'100%',
						listeners : {
							'select' : function(combo, record, index) {
								//alert("名称："+Ext.get("xzqh_piliangfeizhi").dom.value);   
								///alert("代码："+this.getValue());
								piliangfeizhiViewForm.getForm().findField('_xzqhName').setValue(Ext.get("xzqh_piliangfeizhi").dom.value);
								piliangfeizhiViewForm.getForm().findField('_xzqhCode').setValue(this.getValue());
							}
						}
					}]
            },{
            	columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '邮政编码',name : 'yzbm',allowBlank : false,minLength : 6,maxLength : 6,anchor:'100%'}
                ]
            },{
            	columnWidth:1,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '机构实际地址',name : 'jydz',maxLength : 100,anchor:'100%'}]
            },{
            	columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '行政区划',name : 'xzqhCode2',minLength : 6,maxLength : 6,anchor:'100%'}
                ]
            },{
            	columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [{ xtype:'textfield',fieldLabel : '邮政编码',name : 'jyyb',minLength : 6,maxLength : 6,anchor:'100%'}]
            },{
				columnWidth:.5,
                layout: 'form',
                bodyStyle: 'padding:0px',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '电子信箱',name : 'email',maxLength : 50,anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '联系电话',name : 'dhhm',allowBlank : false,maxLength : 50,anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '移动电话',name : 'mobile',maxLength : 50,anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '经办人',name : 'tbrxm',allowBlank : false,maxLength : 50,anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '经办人证件号码',name : 'tbrsfzh',allowBlank : false,maxLength : 50,anchor:'100%'},
                	
                		new Ext.form.TriggerField({
						id:"select_jjhymc_piliangfeizhi",
						name:"jjhymc",
						fieldLabel:"经济行业",
					 	valueField : "jjhymc",
					    displayField : "jjhymc",
					    //readOnly:'true',
					    maxLength : 50,
					    allowBlank : false,
					    haveShow : false,
					    //width:135,
					    anchor:'100%',
					    editable : false,
					    //emptyText:'请选择经济行业！',
					    onTriggerClick : function() {
					    	window_hylxQuery_piliangfeizhi.show();
					    }
					}),{id:"select_jjhydm_piliangfeizhi",xtype : 'hidden',name : 'jjhydm'}
                ]
            },{
                columnWidth:.5,
                layout: 'form',
                border:false,
                items: [
                	{ xtype:'textfield',fieldLabel : '网址',name : 'weburl',maxLength : 50,anchor:'100%'},
                	{ xtype:'textfield',fieldLabel : '经办人电话',allowBlank : false,name : 'tbrlxfs',vtype:'dhhmphone',maxLength : 50,anchor:'100%'},
		             new Ext.form.TriggerField({
						id:"select_jglxmc_piliangfeizhi",
						name:"jglx",
						fieldLabel:"机构类型",
						//width:135,
						anchor:'100%',
					 	valueField : "jglx",
					    displayField : "jglx",
					    //readOnly:'true',
					    allowBlank : false,
					    haveShow : false,
					    editable : false,
					    onTriggerClick : function() {
					    	window_jglxQuery_piliangfeizhi.show();
					    }
					}),
					{id:"select_jglxdm_piliangfeizhi",xtype : 'hidden',name : 'jglxdm'},
					{xtype : 'combo',
						fieldLabel : '是否公开',
						id : 'gk_piliangfeizhi',
						name : 'gk',
						displayField : 'gk',
						valueField : 'gk',
						hiddenName : 'gk',
						store : gkStore,
						triggerAction : 'all',
						lazyRender:true,
						//emptyText:'请选择是否公开！',
						//width:135,
						anchor:'100%',
						mode : 'local',
						selectOnFocus : true,
						allowBlank:false,
						editable : false
					},
					{ xtype:'textfield',fieldLabel : '业务类型',name : 'ywlx',value:'批量注销'},
					{ xtype:'textfield',fieldLabel : '备注',name : 'memo',maxLength : 250,anchor:'100%'},
					{xtype : 'hidden',	name : 'orgid',value:''},
				    {xtype : 'hidden',	name : 'orderid',id:'orderid'},
				    {xtype : 'hidden',name : 'docid'},
					{xtype : 'hidden',name : 'xzqhName'}, 
					{xtype : 'hidden',name : 'imageUrl'},
					{id:"select_jjlxdm",xtype : 'hidden',name : 'jjlxdm',maxLength : 25},
				    {xtype : 'hidden',name : '_xzqhName',maxLength : 25},
				    {xtype : 'hidden',name : '_xzqhCode',maxLength : 25},
				    {xtype : 'hidden',name : '_wftzgb',maxLength : 25},
				    {xtype : 'hidden',name : '_wftzgbdm',maxLength : 25},
				    {xtype : 'hidden',name : '_hbzl',maxLength : 25},
				    {xtype : 'hidden',name : '_hbzldm',maxLength : 25},
				    {xtype : 'hidden',name : 'fkbz'},
				    {xtype : 'hidden',name : 'fksl'},
				    {xtype : 'hidden',name : 'xzqhName2'},
				    {xtype : 'hidden',id:'select_jjhymcOld_piliangfeizhi',name : 'jjhymcOld'},
					{xtype : 'hidden',id:'select_jjhydmOld_piliangfeizhi',name : 'jjhydmOld'},
					{xtype : 'hidden',name : 'lastdate',value :myDate.format('Y-m-d')}, 
					{xtype : 'hidden',name : 'lry'},
					{xtype : 'hidden',name : 'xgr',value:''},
					{xtype : 'hidden',name : 'state',value:'12'}
                ]
            }]
         }]
});

var  piliangfeizhiViewForm2= new Ext.Panel({
    title       : '基本信息',
    region      : 'center',
    id          : 'jbInfo30',
    collapsible:false,
    border : 'layout',
    bodyStyle: 'padding:0px',
    margins: '3 0 0 0',
    cmargins: '5 5 0 0',
	layout: 'fit',
    items : [piliangfeizhiViewForm]
});


var fileFtpForm_piliangfeizhi = new Ext.Panel({
	title:'原文扫描',
	split:true,
	width:620,
	collapsible:true,
	collapsed: true,
    region:'east',
    margins:'3 0 0 5',
    cmargins:'3 0 0 5',
    //activeTab: 0,
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"  width=100%  height=100% align=center hspace=0 vspace=0 id="scanner24631"  name="scanner24631" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>'
    
});


//默认查询 档案
var searchpiliangfeizhi = function() {

	piliangfeizhiViewForm.getForm().reader = Orgnews;
	piliangfeizhiViewForm.getForm().load({
		waitMsg : '正在进行数据查询，请稍等',          //提示信息   
        waitTitle : '提示',                      //标题  
	    url: 'findAllYwqxOrgnew.action', //请求控制器获取数据
	    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
	    params: { conditions:  text_search_piliangfeizhi.getValue(),username:currentZzUsername,ywlxConditions:null,stateConditions:'10,11,12,13,14,15,16',start:1,limit:1},	
	    success:function(form,action) {//获取返回值
	    	if(action.result.data.ywlx=='批量注销' && (action.result.data.state=='12' || action.result.data.state=='14')){//判断业务是否办理中
	    		btn_del_piliangfeizhi.setDisabled(false);
	    		//btn_save_piliangfeizhi_menu.setDisabled(false);
	    		//btn_shibie_piliangfeizhi.setDisabled(true);
	    		var tab3452=Ext.getCmp("jbInfo30");
	    		tab3452.setTitle("基本信息  ("+stateToInfo(piliangfeizhiViewForm.getForm().findField('state').value)+")");	
	    		piliangfeizhiViewForm.getForm().findField('lastdate').setValue(myDate.format('Y-m-d'));
				piliangfeizhiViewForm.getForm().findField('xgr').setValue(currentZzUsername);
	    		
	    		piliangfeizhiViewForm.getForm().findField('bzjgdm').setValue(currentZzUserBzjgdm);
	    		var resultObject = null;
	            //alert(action.result.data.orgid);
	    		Ext.Ajax.request({
					url : 'orgnewViewImg.action',
					params : {orgid : action.result.data.orgid},
					//waitTitle: '提示',
				    //waitMsg: '数据正在重新加载中，请稍后',
					success : function(result,request) {//获取返回值
						scanner24631.ImageData="";
	   					var resultObject = Ext.util.JSON.decode(result.responseText); 
	   					if(resultObject!=null){
		   					scanner24631.OpenProgress(3);  //设置上传的进度条的总进度数
		   					scanner24631.Progress('原文加载中',1);
							scanner24631.Progress('原文加载中',2);
		   					scanner24631.ImageData=resultObject.imageData;
		   					scanner24631.pageTypeStr=resultObject.pageTypeStr;
		   					if(scanner24631.ImageData!=""){
		   						scanner24631.Progress('原文加载完毕',3);
								scanner24631.CloseProgress();
							}else{
								scanner24631.Progress('原文加载失败',3);
				   				scanner24631.CloseProgress();
				   				alert("原文错误，加载失败！");
							}
	   					}
					},
					failure : function() {
						scanner24631.ImageData="";
			   			scanner24631.CloseProgress();
						alert("图像加载错误，或者无原文");
					}
				});	
	
			}else{
				btn_del_piliangfeizhi.setDisabled(true);
			    //btn_save_qianchu_menu.setDisabled(true);
			    
				Ext.Msg.show({
					title : '提示',
					msg : '机构正在进行“'+action.result.data.ywlx+'”业务办理中!',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.INFO,
					fn : function() {piliangfeizhiViewForm.getForm().reset();scanner24631.ImageData="";}
				});
            }
		},
		failure : function() {//正式库检索
				piliangfeizhiViewForm.getForm().reader = Orgnews;
				piliangfeizhiViewForm.getForm().load({
					waitMsg : '正在进行数据查询，请稍等',          //提示信息   
			        waitTitle : '提示',                      //标题  
				    url: 'findAllTjgdmByJgdm.action', //请求控制器获取数据
				    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
				    params: { jgdm:  text_search_piliangfeizhi.getValue(),userBzjgdm:null},	
				    success:function(form,action) {//获取返回值
						    if(currentZzUsername!='admin' && sysBzjgLimitMode=='1' && action.result.data.bzjgdm!=currentZzUserBzjgdm && currentZzUserYwqx!='2' && currentZzUserBzjgdm!=currentZzUserCenterid){
				    				Ext.Msg.show({
										title : '提示',
										msg : '【'+action.result.data.jgmc+'】，<br><br>办证机构代码为“'+action.result.data.bzjgdm+'”,不属于本办证机构办理！',
										buttons : Ext.Msg.OK,
										fn:  function() {
											btn_del_piliangfeizhi.setDisabled(true);
							    			btn_save_piliangfeizhi_menu.setDisabled(false);
							    			
											piliangfeizhiViewForm.getForm().reset();
											scanner24631.ImageData="";
											var tab3452560=Ext.getCmp("jbInfo30");
							    			tab3452560.setTitle("基本信息");
										},
										icon : Ext.Msg.ERROR
									});
				    		}else{
						    	if(action.result.data.state=='100' || action.result.data.state==''){//判断此机构状态是否正常
						    		btn_del_piliangfeizhi.setDisabled(false);
						    		scanner24631.ImageData="";
						    		var tab3452=Ext.getCmp("jbInfo30");
						    		tab3452.setTitle("基本信息  (新录入)");
						    		piliangfeizhiViewForm.getForm().findField('ywlx').setValue('批量注销');
						    		piliangfeizhiViewForm.getForm().findField('state').setValue('12');
						    		piliangfeizhiViewForm.getForm().findField('orgid').setValue('');
						    		piliangfeizhiViewForm.getForm().findField('lastdate').setValue(myDate.format('Y-m-d'));
						    		piliangfeizhiViewForm.getForm().findField('fkbz').setValue('否');
							    	piliangfeizhiViewForm.getForm().findField('fksl').setValue('0');
									piliangfeizhiViewForm.getForm().findField('bzjgdm').setValue(currentZzUserBzjgdm);
								}else{
									Ext.Msg.show({
										title : '提示',
										msg : '机构“'+action.result.data.jgmc+'”状态为“'+tjgdmStateToInfo(action.result.data.state)+'”,<br><br>不能再次办理业务！',
										buttons : Ext.Msg.OK,
										fn:  function() {
											btn_del_piliangfeizhi.setDisabled(true);
							    			btn_save_piliangfeizhi_menu.setDisabled(false);
							    			
											piliangfeizhiViewForm.getForm().reset();
											scanner24631.ImageData="";
											var tab3452560=Ext.getCmp("jbInfo30");
							    			tab3452560.setTitle("基本信息");
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
									//btn_del_piliangfeizhi.setDisabled(true);
								    //btn_shibie_piliangfeizhi.setDisabled(false);
									piliangfeizhiViewForm.getForm().reset();
									scanner24630.ImageData="";
								}
							});
						}	
				});
		}
	});
}

var btn_search_piliangfeizhi = new Ext.Button({
	text : '代码查询',
	iconCls : 'icon-search',
	handler : function() {
		searchpiliangfeizhi();
	}
});

var text_search_piliangfeizhi = new Ext.form.TextField({
	id : 'textSearchpiliangfeizhi',
	name : 'textSearchpiliangfeizhi',
	width : 200,
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchpiliangfeizhi();
			}
		}
	}
});



var btn_refresh_piliangfeizhi = new Ext.Button({
	text : '重置',
	iconCls : 'icon-refresh',
	handler : function() {
    	//btn_save_piliangfeizhi_menu.setDisabled(true);
    	//btn_shibie_piliangfeizhi.setDisabled(false);
		btn_del_piliangfeizhi.setDisabled(true);
		piliangfeizhiViewForm.getForm().reset();
		var tab3452=Ext.getCmp("jbInfo30");
	    tab3452.setTitle("基本信息");
		scanner24631.ImageData="";
		//this.ownerCt.form.reset();;
	}
});

var btn_del_piliangfeizhi = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	disabled:true,
	handler : function() {
		var orgid = piliangfeizhiViewForm.getForm().findField('orgid').value;
		if(orgid!=null && orgid!=""){
			Ext.Msg.confirm('确认删除', '你确定删除吗?', function(btn) {
				if (btn == 'yes') {
					ajaxLoadMask.show();
					Ext.Ajax.request({
						url : 'deleteOrgnew.action',
						params : {orgid : orgid},
						success : function() {
							ajaxLoadMask.hide();
							btn_del_piliangfeizhi.setDisabled(true);
					    	//btn_shibie_piliangfeizhi.setDisabled(false);
							piliangfeizhiViewForm.getForm().reset();
							var tab3452=Ext.getCmp("jbInfo30");
	    					tab3452.setTitle("基本信息");
							scanner24631.ImageData="";
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


var btn_duru_piliangfeizhi = new Ext.Button({
	text : '测试键入',
	iconCls : 'icon-add',
	//disabled:true,调用参数
	//scanner.GetOCRValue 返回 识别结果
	handler : function(){
		//var ocrStr=scanner24631.GetOCRValue;
		//,{id:'jyfw',value:'许可经营项目'},{id:'zcrq',value:'2011-07-27'},{id:'zczj',value:'10'},{id:'zch',value:'110106014104570'},{id:'jgdz',value:'北京市丰台区永外海户屯166号院5号楼101室'},{id:'jglx',value:'有限责任公司'},{id:'tbrxm',value:'高跃辉'},{id:'tbrsfzh',value:'410325198204126593'},{id:'tbrzjlx',value:'居民身份证'}
		//  var ocrStr="[{id:'jgmc',value:'11'},{id:'fddbr',value:'11'}]";
		//var ocrStr="[{id:'jgmc',value:'zhangsan'},{id:'fddbr',value:'15'}]";
		//var ocrStr="[{id:'jgmc',value:'北京顺光庆华商贸有限公司'},{id:'fddbr',value:'杨志英'},{id:'jyfw',value:'许可经营项目'},{id:'zcrq',value:'2011年07月27日'},{id:'zczj',value:'10'},{id:'zch',value:'110106014104570'},{id:'jgdz',value:'北京市丰台区永外海户屯166号院5号楼101室'},{id:'jglx',value:'有限责任公司'},{id:'tbrxm',value:'高跃辉'},{id:'tbrsfzh',value:'410325198204126593'},{id:'tbrzjlx',value:'居民身份证'}]";
 		var ocrStr="[{id:'orgid',value:''},{id:'jgmc',value:'北京东方世纪科技有限公司'},{id:'jgdm',value:'109101235'},	{id:'fddbr',value:'张治中'},	{id:'zjlx',value:'居民身份证'},{id:'zjhm',value:'107101192312015714'},{id:'jyfw',value:'在法律范围内，许可经营项目'},{id:'zcrq',value:'19711209'},{id:'zczj',value:'10000'},	{id:'zch',value:'110101218105012'},{id:'jglx',value:'有限责任公司'},{id:'jgdz',value:'北京市海淀区中航工业大厦1805室'},{id:'pzjgmc',value:'北京市工商局'},{id:'pzjgdm',value:'110000021'},{id:'jjlx',value:'有限责任公司'},{id:'zsbfrq',value:'1972-01-01'},{id:'zszfrq',value:'1992-01-01'},{id:'wftzgb',value:'中国'},{id:'hbzl',value:'人民币'},{id:'jydz',value:'北京市海淀区中关村科技广场鼎好大厦12楼'},{id:'zgmc',value:'海淀国资委'},{id:'zgdm',value:'100001231'},{id:'dhhm',value:'010-62528899'},{id:'mobile',value:'13810101225'},{id:'jjhymc',value:'计算机软件'},{id:'jjhydm',value:'0709'},{id:'zgrs',value:'500'},{id:'xzqhCode',value:'100000220'},{id:'xzqhName',value:'北京市海淀区'},{id:'yzbm',value:'100098'},{id:'weburl',value:'www.163.com'},{id:'email',value:'hr@163.com'},{id:'tbrxm',value:'申通'},{id:'tbrsfzh',value:'110109198509014216'},{id:'tbrzjlx',value:'居民身份证'},{id:'tbrlxfs',value:'13366114568'},{id:'gk',value:'是'}]";
		if(ocrStr!="" && ocrStr!=null){
			var respText = Ext.util.JSON.decode(ocrStr); 
			piliangfeizhiViewForm.getForm().setValues(respText); 
			//btn_del_piliangfeizhi.setDisabled(true);
			//btn_save_piliangfeizhi_menu.setDisabled(false);
			//var respText = Ext.util.JSON.decode(ocrStr); 
			//piliangfeizhiViewForm.getForm().setValues(respText); 
			//alert(respText.jgmc);
			
			//piliangfeizhiViewForm.getForm().reader = Orgnews;
			//piliangfeizhiViewForm.getForm().load({waitMsg:'正在加载数据请稍后',url:'ocr.json'});
		}else{
			alert("请扫描或导入需识别的图片！");
		}
	}
});


var btn_save_piliangfeizhi_menu = new Ext.Toolbar.MenuButton({
    text: '保存',
    handler: btn_piliangfeizhi_saveAll,
    tooltip: {title:'保存数据和原文',text:'保存'},
    iconCls: 'blist',
    //disabled:true,
    menu : {items: [
                {text: '全部保存', handler: btn_piliangfeizhi_saveAll}, '-',
                {text: '仅保存数据', handler: btn_piliangfeizhi_saveInfo},
                {text: '仅上传原文', handler: btn_piliangfeizhi_ftpFile}
        ]}
});

var upFuncPLFZ = function(docid,orgid,strJgdm,strState,strYwlx,jgmc){
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
				strBzjgdm=piliangfeizhiViewForm.getForm().findField('bzjgdm').getValue(); 
				
				packLength = 40960;	//定义每个包的大小40960
				//scanner24631.ImageData=document.getElementById("ImageData").value;
				base64file = scanner24631.ImageData;  //获取控件扫描的图片数据
				var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
				imageCount = scanner24631.ImageCount;	//获取扫描图片的页数
				pageTypeStr = scanner24631.PageType;    //获取标识字符串,需要写数据库
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
				scanner24631.OpenProgress(packCount);  //设置上传的进度条的总进度数
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
							scanner24631.Progress('上传中',i+1);
						}
						else
						{
							alert("上传失败，请重试0001。");
							//scanner24631.ShowSendMsg(false);
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
					msg : '['+piliangfeizhiViewForm.getForm().findField('jgmc').value+']，<br><br>信息保存成功！',
					buttons : Ext.Msg.OK,
					fn : function() {
						scanner24631.CloseProgress();
						subPLFZAction(orgid,strJgdm,strState,strYwlx,jgmc);
					},
					icon : Ext.Msg.INFO
				});

				
}

function btn_piliangfeizhi_saveAll(btn){
	if (piliangfeizhiViewForm.getForm().isValid()) {
		piliangfeizhiViewForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在保存数据,请稍候...',
			success : function(form,action) {
				
				piliangfeizhiViewForm.getForm().findField('orgid').setValue(action.result.orgid);
				piliangfeizhiViewForm.getForm().findField('docid').setValue(action.result.docid);
				var orgid = piliangfeizhiViewForm.getForm().findField('orgid').getValue();
				var docid = action.result.docid;
		var strJgdm = piliangfeizhiViewForm.getForm().findField('jgdm').getValue();
		var strState = piliangfeizhiViewForm.getForm().findField('state').getValue();
		var jgmc = piliangfeizhiViewForm.getForm().findField('jgmc').getValue();
		var strYwlx = piliangfeizhiViewForm.getForm().findField('ywlx').getValue();
				if(scanner24631.ImageCount>0){
					if(orgid!=null && orgid!=""){
			Ext.Ajax.request({
				url: 'checkArchive.action',
				params: {orgid: orgid,jgdm:strJgdm},
				success: function(result,request){//result,request
					var data = Ext.util.JSON.decode(result.responseText);
					var str = scanner24631.CheckArchives("注销",data.jglxdmOld,data.zchInfo,data.frInfo);
					if(str==''){
						//alert("更新imageFlag为1（表示档案完整）");
						refreshImageFlag(orgid,'1');
						upFuncPLFZ(docid,orgid,strJgdm,strState,strYwlx,jgmc);
					}else{
						//alert(str+"::更新imageFlag为0（表示档案不完整）");
						Ext.Msg.show({
							title : '提示',
							msg : str + '继续提交则选是,取消提交则选否！',
							buttons : Ext.Msg.OKCANCEL,
							fn : function(btn){
								if(btn == 'ok'){
									refreshImageFlag(orgid,'0');
									upFuncPLFZ(docid,orgid,strJgdm,strState,strYwlx,jgmc);
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
				msg : '请保存信息后，再进行“批量注销确认”处理！',
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
									subPLFZAction(orgid,strJgdm,strState,strYwlx,jgmc);
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

function btn_piliangfeizhi_saveInfo(btn){
	if (piliangfeizhiViewForm.getForm().isValid()) {
		piliangfeizhiViewForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在保存数据,请稍候...',
			success : function(form,action) {
				//alert(action.result.orgid);
				piliangfeizhiViewForm.getForm().findField('orgid').setValue(action.result.orgid);
				piliangfeizhiViewForm.getForm().findField('docid').setValue(action.result.docid);
				Ext.Msg.show({
					title : '提示',
					msg : '['+piliangfeizhiViewForm.getForm().findField('jgmc').value+']，申办信息保存成功',
					buttons : Ext.Msg.OK,
					//fn : function() {btn.enable();btn_ok_piliangfeizhi.setDisabled(false);},
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

function btn_piliangfeizhi_ftpFile(btn){
	
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
	strOrgid =piliangfeizhiViewForm.getForm().findField('orgid').value;  //参数orgid
	strDocid =piliangfeizhiViewForm.getForm().findField('docid').value;  //参数docid
	strBzjgdm=piliangfeizhiViewForm.getForm().findField('bzjgdm').value;  //办证机构代码
	//alert("strOrgid="+strOrgid);
	
	if(strOrgid!=""){
			packLength = 40960;	//定义每个包的大小40960
			//scanner24631.ImageData=document.getElementById("ImageData").value;
			base64file = scanner24631.ImageData;  //获取控件扫描的图片数据
			var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
			imageCount = scanner24631.GetPageCount;	//获取扫描图片的页数
			pageTypeStr = scanner24631.PageType;    //获取标识字符串,需要写数据库
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
			scanner24631.OpenProgress(packCount);  //设置上传的进度条的总进度数
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
						scanner24631.Progress('上传中',i+1);
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
			scanner24631.CloseProgress();
			
			Ext.Msg.show({
				title : '提示',
				msg : '['+piliangfeizhiViewForm.getForm().findField('jgmc').value+']，<br><br>原文上传成功！',
				buttons : Ext.Msg.OK,
				fn : function() {btn.enable();},
				icon : Ext.Msg.INFO
			});
			
			scanner24631.CloseProgress();
			return true;
	}else{
		alert("请录入数据后，再上传原文！");
	}
}

//提交确认方法
var subPLFZAction =function (orgid,strJgdm,strState,strYwlx,jgmc){
	ajaxLoadMask.show();
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
   					piliangfeizhiViewForm.getForm().findField('orgid').setValue('');
   					
   					var tab345=Ext.getCmp("jbInfo30");
		    		tab345.setTitle("基本信息");	
					piliangfeizhiViewForm.getForm().reset();
					scanner24631.PageType="";
					scanner24631.ImageData="";
					text_search_piliangfeizhi.setValue("");
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


var btn_saveInfo_piliangfeizhi = new Ext.Button({
	text : '保存数据',
	iconCls : 'blist',
	handler : btn_piliangfeizhi_saveInfo
});

var btn_ok_piliangfeizhi = new Ext.Button({
	text : '确认提交',
	iconCls : 'icon-store',
	handler : btn_piliangfeizhi_saveAll
});


var p_zzPiliangfeizhi = {
	id : 'zzPiliangfeizhi-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:0px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    bodyBorder: false,
	    title: '批量注销',
	    iconCls : 'icon-plugin',
 		plain: true,
		region: 'center',
		tbar : [btn_refresh_piliangfeizhi,btn_del_piliangfeizhi,/*btn_save_piliangfeizhi_menu*/btn_saveInfo_piliangfeizhi,btn_ok_piliangfeizhi,'->',text_search_piliangfeizhi,btn_search_piliangfeizhi],
		items: [piliangfeizhiViewForm2,fileFtpForm_piliangfeizhi]
	}]
}