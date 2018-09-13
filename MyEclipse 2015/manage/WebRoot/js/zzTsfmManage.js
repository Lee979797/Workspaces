var Tsfm = Ext.data.Record.create([
	{name : 'id',mapping : 'id',type : 'int'}, 
	{name : 'qsdm',mapping : 'qsdm',type : 'string'}, 
	{name : 'jzdm',mapping : 'jzdm',type : 'string'},
	{name : 'dmsl',mapping : 'dmsl',type : 'int'},  
	{name : 'fmtype',mapping : 'fmtype',type : 'string'}, 
	{name : 'fmjgdm',mapping : 'fmjgdm',type : 'string'}, 
	{name : 'fmjgmc',mapping : 'fmjgmc',type : 'string'}, 
	{name : 'fpbzjg',mapping : 'fpbzjg',type : 'string'}, 
	{name : 'flag',mapping : 'flag',type : 'string'}, 
	{name : 'lrsj',mapping : 'lrsj',type : 'date',dateFormat:'Y-M-D'},
	{name : 'userid',mapping : 'userid',type : 'string'}, 
	{name : 'username',mapping : 'username',type : 'string'}, 
	{name : 'name',mapping : 'name',type : 'string'}, 
	{name : 'note',mapping : 'note',type : 'string'}
]);

var btn_search_pzjg_tsfm = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchPzjg_tsfm();
		//btn_search_pzjg_tsfm.setDisabled(true);
	}
});


var text_search_pzjg_tsfm = new Ext.form.TextField({
	id : 'textSearchPzjg_tsfm',
	name : 'textSearchPzjg_tsfm',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchPzjg_tsfm();
			}
		},
		'change' : function(field, e) {
			btn_search_pzjg_tsfm.setDisabled(false);
		}
	}
});


var cm_pzjg_tsfm = new Ext.grid.ColumnModel([
	{header : '批准机构名称',width : 50,dataIndex : 'pzjgmc',sortable : true}, 
	{header : '批准机构代码',width : 20,dataIndex : 'pzjgdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_pzjg_tsfm = new Ext.data.Store({
	url : 'findAllByConditionPzjg.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'pzjgid',type : 'int'}, 
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchPzjg_tsfm = function() {
	ds_pzjg_tsfm.baseParams.conditions = text_search_pzjg_tsfm.getValue();
	ds_pzjg_tsfm.baseParams.username='';
	ds_pzjg_tsfm.baseParams.stateConditions='';
	ds_pzjg_tsfm.load({params : {start : 0,limit : 20} });
}

var grid_pzjg_tsfm = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_pzjg_tsfm,
	ds : ds_pzjg_tsfm,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入赋码机构名称：',text_search_pzjg_tsfm,btn_search_pzjg_tsfm],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_pzjg_tsfm,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_pzjgQuery_tsfm.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			tsfmDoForm.getForm().findField('select_pzjgmc_tsfm').setValue(selections[0].get('pzjgmc'));
			tsfmDoForm.getForm().findField('select_pzjgdm_tsfm').setValue(selections[0].get('pzjgdm'));
		}
	}
});


var window_pzjgQuery_tsfm = new Ext.Window({
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
	items : [grid_pzjg_tsfm]
});

//-----------------------点击列表信息，显示图书的扩展属性-----------------------
var expander_tsfm = new Ext.grid.RowExpander({
	tpl : new Ext.Template('<table width="100%"  border="0" cellspacing="6" cellpadding="0"  bgcolor="#DDEEF9" style="margin-top:1px;" >'
			+ '<tr>'
			+ '<td width="" colspan="4">'
			+ '<table width="98%" bgcolor="#ffffff" border="1" cellpadding="0" cellspacing="0" align="center"  bordercolordark="#FFFFFF" bordercolorlight="#6EBBE1" style="margin-top:0px;>'
			+ '<tr height="22" valign="middle">'
			+ '  <td width="20%" height="22" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">起始代码：</td><td width="30%"  valign="middle" style="padding-top:5px">{qsdm}<img src="images/temp.gif"></td>'
			+ '  <td width="20%" height="22" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">截至代码：</td><td width="30%"  valign="middle" style="padding-top:5px">{jzdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle" >'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">批准机构名称：</td><td nowrap="nowrap" style="padding-top:5px">{fmjgmc}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">批准机构代码：</td><td  nowrap="nowrap" style="padding-top:5px">{fmjgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle" >'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">赋码类型：</td><td nowrap="nowrap" style="padding-top:5px">{fmtype}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">代码数量：</td><td  nowrap="nowrap" style="padding-top:5px">{dmsl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">分配办证机构：</td><td nowrap="nowrap"  style="padding-top:5px">{fpbzjg}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">录入人ID：</td><td nowrap="nowrap"  style="padding-top:5px">{username}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">录入人姓名：</td><td nowrap="nowrap"  style="padding-top:5px">{name}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">录入时间：</td><td nowrap="nowrap"  style="padding-top:5px">{lrsj}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">备注：</td><td  colspan=3 style="padding-top:5px">{note}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '</table>'
			+ '</td></tr></table>')
});
        
        
//---------------------- 列表显示主要数据信息 ----------------------------------
// 列表显示机构的主要信息 yangqi
var sm27234641251 = new Ext.grid.CheckboxSelectionModel();
var cm_tsfmManage = new Ext.grid.ColumnModel([expander_tsfm,
	sm27234641251,
	{header : '码段批次',width : 40,dataIndex : 'id',sortable : false},
	{header : '起始代码',width : 60,dataIndex : 'qsdm',sortable : true}, 
	{header : '截至代码',width : 60,dataIndex : 'jzdm',sortable : true},
	{header : '赋码类型',width : 50,dataIndex : 'fmtype',renderer : function(v) {return v == 0 ? '其它部门' : '省间迁入'},sortable : true},
	{header : '批准机构名称',width : 120,dataIndex : 'fmjgmc',id:'fmjgmc_tsfm',sortable : true},
	{header : '批准机构代码',width : 60,dataIndex : 'fmjgdm',sortable : true},
	{header : '代码数量',width : 50,dataIndex : 'dmsl',sortable : true},
	{header : '录入人',width : 60,dataIndex : 'name',sortable : true},
	{header : '录入时间',width : 60,dataIndex : 'lrsj',sortable : true}, 
	{header : '状态',width : 50,dataIndex : 'flag',renderer : function(b) {return b == 1 ? '正常' : '不正常'},menuDisabled : true}
]);



//默认查询 limit为显示的条数
var searchTsfmManage = function() {
	ds_tsfmManage.baseParams.conditions = text_search_tsfmManage.getValue();
	ds_tsfmManage.baseParams.username=currentZzUsername;
	ds_tsfmManage.baseParams.stateConditions='4,14';
	ds_tsfmManage.load({params : {start : 0,limit : useUpPageSize} });
}

//查询返回结果的数据列
var ds_tsfmManage = new Ext.data.Store({
	url : 'findAllTsfm.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'id',type : 'int'}, 
	    {name : 'qsdm',type : 'string'}, 
	    {name : 'jzdm',type : 'string'},
		{name : 'dmsl',type : 'int'},
		{name : 'fmtype',type : 'string'},
		{name : 'fmjgmc',type : 'string'},
		{name : 'fmjgdm',type : 'string'},
		{name : 'fpbzjg',type : 'string'}, 
		{name : 'name',type : 'string'}, 
		{name : 'userid',type : 'string'}, 
		{name : 'username',type : 'string'}, 
		{name : 'flag',type : 'string'}, 
		{name : 'lrsj',type : 'date',convert:function(v){if(v) return v.substring(0,10);}}
	])
});

var btn_search_tsfmManage = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchTsfmManage();
	}
});

var btn_refresh_tsfmManage = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchTsfmManageid.value='';
		searchTsfmManage();
	}
});

    
var text_search_tsfmManage = new Ext.form.TextField({
	id:'textSearchTsfmManageid',
	name : 'textSearchTsfmManage',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchTsfmManage();
			}
		}
	}
});


var btn_tsfm_do = new Ext.Button({
	text : '特殊码段分发',
	iconCls : 'icon-edit',
	handler : function(){
		window_tsfm_do.show();
	}
});


var tsfmDoForm = new Ext.FormPanel({
	url : 'saveTsfm.action',
	labelAlign : 'right',
	labelWidth : 90,
	bodyStyle : 'padding:10px',
	border : false,
	autoHeight : true,
	autoScroll : true, 
	baseCls : 'x-plain',
	waitMsgTarget: true,
	items : [{  
			xtype : 'combo',
				fieldLabel : '码段类型',
				name:'fmtype',
				displayField : 'fmtypeName',
				valueField : 'fmtypeCode',
				hiddenName : 'fmtype',
				store : fmtypeStore,
				triggerAction : 'all',
				lazyRender:true,
				value:'',
				anchor:'100%',
				mode : 'local',
				selectOnFocus : true,
				allowBlank:false,
				editable : false,
				listeners : {
					'select' : function(val, field) {
						//if(val.getValue()=='0'){
							tsfmDoForm.getForm().findField('qsdm_tsfm').maxLength=8;
							tsfmDoForm.getForm().findField('qsdm_tsfm').minLength=8;
							tsfmDoForm.getForm().findField('jzdm_tsfm').maxLength=8;
							tsfmDoForm.getForm().findField('jzdm_tsfm').minLength=8;
						/*}else{
							tsfmDoForm.getForm().findField('qsdm_tsfm').maxLength=9;
							tsfmDoForm.getForm().findField('qsdm_tsfm').minLength=9;
							tsfmDoForm.getForm().findField('jzdm_tsfm').maxLength=9;
							tsfmDoForm.getForm().findField('jzdm_tsfm').minLength=9;
						}*/
					}
				}
			},{xtype:'textfield',fieldLabel:'起始码段',name:'qsdm',id:'qsdm_tsfm',allowBlank : false,maxLength:'8',minLength:'8',anchor:'100%'},
			{xtype:'textfield',fieldLabel:'截至码段',name:'jzdm',id:'jzdm_tsfm',allowBlank : false,maxLength:'8',minLength:'8',anchor:'100%'},
			new Ext.form.TriggerField({
				id:"select_pzjgdm_tsfm",
				name:"fmjgdm",
				fieldLabel:"批准机构代码",
			 	valueField : "fmjgdm",
			    displayField : "fmjgdm",
			    maxLength : 9,
			    minLength : 9,
			    anchor:'100%',
			    //labelSeparator:'',
			    haveShow : false,
			    editable : false,
			    readOnly:true,
			    allowBlank : false,
			    onTriggerClick : function() {
			    	window_pzjgQuery_tsfm.show();
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
		    }),
		    {xtype:'textfield',fieldLabel : '批准机构名称',name:'fmjgmc',id:"select_pzjgmc_tsfm",allowBlank : false,readOnly:true,anchor:'99.9%'},
            {xtype : 'hidden',name : 'fpbzjg',value:currentZzUserBzjgdm},
            {xtype:'textfield',fieldLabel : '备注',name:'note',maxLength:'100',anchor:'99.9%'}
		],
	buttonAlign : 'center',
	minButtonWidth : 60,
	buttons : [{
		text:'确定',
		handler : function(btn){
			if(this.ownerCt.getForm().isValid()){
				if(this.ownerCt.getForm().findField('qsdm').getValue()<=this.ownerCt.getForm().findField('jzdm').getValue()){
					btn.disable();
					tsfmDoForm.getForm().submit({
						waitTitle : '请稍候',
						waitMsg : '正在分发证书码段,请稍候...',
						success : function(form,action) {
							Ext.Msg.show({
								title : '提示',
								msg : '码段分发成功!',
								buttons : Ext.Msg.OK,
								fn : function(){btn.enable();form.findField('qsdm').reset();form.findField('jzdm').reset();textSearchTsfmManageid.value='';searchTsfmManage();},
								icon : Ext.Msg.INFO
							});
						},
						failure : function(form, action) {
							Ext.Msg.show({
								title : '提示',
								msg : '码段分发失败！'+action.result.errMsg,
								buttons : Ext.Msg.OK,
								fn : function() {btn.enable();},
								icon : Ext.Msg.ERROR
							});
						}
					});
				}else{
					Ext.Msg.show({
						title : '提示',
						msg : '“起始码段”输入错误，“截至码段”不能小于“起始码段”！',
						buttons : Ext.Msg.OK,
						fn : function() {btn.enable();},
						icon : Ext.Msg.ERROR
					});
				}
			}
		}
	},{
		text : '取消',
		handler:function(){
			this.ownerCt.ownerCt.hide();
		}
	}]
});

var window_tsfm_do = new Ext.Window({
	title : '特殊码段分发',
	width : 330,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	items : [tsfmDoForm]
});


//加载上栏主页面   （数据列表、工具栏按钮）
var grid_TsfmManage = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	//autoHeight : true,
	cm : cm_tsfmManage,
	ds : ds_tsfmManage,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'fmjgmc_tsfm',
	viewConfig : {forceFit : true},
	plugins : expander_tsfm,
	tbar : [btn_refresh_tsfmManage,btn_tsfm_do,'->', text_search_tsfmManage,btn_search_tsfmManage],
	bbar : new Ext.PagingToolbar({
		pageSize : useUpPageSize,
		store : ds_tsfmManage,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有码段记录"
	}),
	listeners : {
		'rowdblclick':function(grid, rowIndex){
			ds_tjgdm.baseParams.qsdm = String(parseInt(grid.getStore().getAt(rowIndex).data.qsdm)-1)+"Z";
			ds_tjgdm.baseParams.jzdm = String(parseInt(grid.getStore().getAt(rowIndex).data.jzdm)+1)+"0";
			ds_tjgdm.load({params : {start : 0,limit : useDownPageSize}});
		}
	}
});


var ds_tjgdm =  new Ext.data.Store({
	url : 'findTjgdmByDmmd.action',
	sortInfo : {field: 'lastdate', direction: 'DESC'},
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'jgdm',type : 'string'},
	   	{name : 'jgmc',type : 'string'}, 
		{name : 'jglx',type : 'string'},
		{name : 'ywlx',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		{name : 'pzjgmc',type : 'string'},
		{name : 'handleName',type : 'string'},
		{name : 'handleDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'lastdate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}}]
	)
});


var dateFormatZszt = function(v){
	if(v){
		return '已办证'
	}
	return '未办证';
}

TjgdmListPanel = Ext.extend(Ext.grid.GridPanel,{
	constructor:function(){
		TjgdmListPanel.superclass.constructor.call(this,{
		loadMask : {msg : '数据加载中...'},
			cm : new Ext.grid.ColumnModel([ 
			    {header : '机构代码',width : 90,dataIndex : 'jgdm',sortable : true}, 
			    {header : '机构名称',width : 150,	dataIndex : 'jgmc',id : 'jgmc_tsfm',sortable : true},
				{header : '机构类型',width : 90,dataIndex : 'jglx',sortable : true},
				{header : '业务类型',width : 90,dataIndex : 'ywlx',sortable : true}, 
				{header : '批准机构代码',width : 90,dataIndex : 'pzjgdm',sortable : true}, 
			    {header : '批准机构名称',width : 150,	dataIndex : 'pzjgmc',sortable : true},
				{header : '办理人',width : 90,dataIndex : 'handleName',menuDisabled : true},
				{header : '办理时间',width : 90,dataIndex : 'handleDate',renderer: goDateFormat,sortable : true},
				{header : '状态',width : 90,dataIndex : 'lastdate',renderer: dateFormatZszt,sortable : true}
			]),
			autoExpandColumn : 'jgmc_tsfm',
			ds : ds_tjgdm,
			sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
			bbar : new Ext.PagingToolbar({
					pageSize : useDownPageSize,
					store : ds_tjgdm,
					displayInfo : true,
					displayMsg : '第 {0} - {1} 条 共 {2} 条',
					emptyMsg : "没有新办申请记录"}
			)
		});
	}
});

var zzTsfmManage_panel = new Ext.Panel({
	title : '特殊赋码',
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
	    items : [grid_TsfmManage]
	},{
	    region: 'south',
	    layout :'fit',
		title : '代码使用情况',
	    height: 300,
	    minSize: 150,
	    maxSize: 450,
	    margins     : '0 0 0 0',
    	cmargins    : '5 0 0 0',
	    items : [new TjgdmListPanel()]
	}]
});

var p_zzTsfmManage = {
	id : 'zzTsfmManage-panel',
	border : false,
	layout : 'border',
	items : [zzTsfmManage_panel]
}
