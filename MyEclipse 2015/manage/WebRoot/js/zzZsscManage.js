var Zssc = Ext.data.Record.create([
	{name : 'id',mapping : 'id',type : 'int'}, 
	{name : 'qsbh',mapping : 'qsbh',type : 'string'}, 
	{name : 'jzbh',mapping : 'jzbh',type : 'string'},
	{name : 'zssl',mapping : 'zssl',type : 'int'},  
	{name : 'zstype',mapping : 'zstype',type : 'string'}, 
	{name : 'fpbzjg',mapping : 'fpbzjg',type : 'string'}, 
	{name : 'flag',mapping : 'flag',type : 'string'}, 
	{name : 'lrsj',mapping : 'lrsj',type : 'date',dateFormat:'Y-M-D'},
	{name : 'note',mapping : 'note',type : 'string'}
]);


//-----------------------点击列表信息，显示图书的扩展属性-----------------------
var expander_zssc = new Ext.grid.RowExpander({
	tpl : new Ext.Template('<table width="100%"  border="0" cellspacing="6" cellpadding="0"  bgcolor="#DDEEF9" style="margin-top:1px;" >'
			+ '<tr>'
			+ '<td width="" colspan="4">'
			+ '<table width="98%" bgcolor="#ffffff" border="1" cellpadding="0" cellspacing="0" align="center"  bordercolordark="#FFFFFF" bordercolorlight="#6EBBE1" style="margin-top:0px;>'
			+ '<tr height="22" valign="middle">'
			+ '  <td width="20%" height="22" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证书开始编号：</td><td width="30%"  valign="middle" style="padding-top:5px">{qsbh}<img src="images/temp.gif"></td>'
			+ '  <td width="20%" height="22" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证书截至编号：</td><td width="30%"  valign="middle" style="padding-top:5px">{jzbh}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle" >'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证书类型：</td><td nowrap="nowrap" style="padding-top:5px">{zstype}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证书数量：</td><td  nowrap="nowrap" style="padding-top:5px">{zssl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">分配办证机构：</td><td nowrap="nowrap"  style="padding-top:5px">{fpbzjg}<img src="images/temp.gif"></td>'
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
var sm27234641 = new Ext.grid.CheckboxSelectionModel();
var cm_zsscManage = new Ext.grid.ColumnModel([expander_zssc,
	sm27234641,
	{header : '证书批号',width : 40,dataIndex : 'id',sortable : false},
	{header : '证书类型',width : 50,dataIndex : 'zstype',renderer : function(v) {return v == 0 ? '正本' : '副本'},sortable : true},
	{header : '证书开始编号',width : 60,dataIndex : 'qsbh',sortable : true}, 
	{header : '证书截至编号',width : 180,dataIndex : 'jzbh',sortable : true},
	{header : '证书数量',width : 50,dataIndex : 'zssl',sortable : true},
	{header : '录入时间',width : 80,dataIndex : 'lrsj',sortable : true}, 
	{header : '状态',width : 50,dataIndex : 'flag',menuDisabled : true}
]);



//默认查询 limit为显示的条数
var searchZsscManage = function() {
	ds_zsscManage.baseParams.conditions = text_search_zsscManage.getValue();
	ds_zsscManage.baseParams.username=currentZzUsername;
	ds_zsscManage.baseParams.stateConditions='4,14';
	ds_zsscManage.load({params : {start : 0,limit : useUpPageSize} });
}

//查询返回结果的数据列
var ds_zsscManage = new Ext.data.Store({
	url : 'findAllZssc.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'id',type : 'int'}, 
	    {name : 'qsbh',type : 'string'}, 
	    {name : 'jzbh',type : 'string'},
		{name : 'zssl',type : 'int'},
		{name : 'zstype',type : 'string'},
		{name : 'fpbzjg',type : 'string'}, 
		{name : 'flag',type : 'string'}, 
		{name : 'lrsj',type : 'date',convert:function(v){if(v) return v.substring(0,10);}}
	])
});

var btn_search_zsscManage = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchZsscManage();
	}
});

var btn_refresh_zsscManage = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchZsscManageid.value='';
		searchZsscManage();
	}
});

    
var text_search_zsscManage = new Ext.form.TextField({
	id:'textSearchZsscManageid',
	name : 'textSearchZsscManage',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchZsscManage();
			}
		}
	}
});


var ds_bzjgStore = new Ext.data.Store({
	url : 'findAllBzjg.action?conditions=&start=0&limit=1000',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{
		name : 'bzjgName',
		type : 'string'
	}, {
		name : 'bzjgCode',
		type : 'string'
	}])
});

var btn_zzsc_do = new Ext.Button({
	text : '证书分发',
	iconCls : 'icon-edit',
	handler : function(){
		window_zzsc_do.show();
	}
});

var zzscDoForm = new Ext.FormPanel({
	url : 'saveZssc.action',
	labelAlign : 'right',
	labelWidth : 90,
	bodyStyle : 'padding:10px',
	border : false,
	autoHeight : true,
	autoScroll : true, 
	baseCls : 'x-plain',
	waitMsgTarget: true,
	items : [{xtype:'textfield',fieldLabel:'证书起始编号',name:'qsbh',allowBlank : false,maxLength : 11,minLength:11,anchor:'100%'},
			{xtype:'textfield',fieldLabel:'证书截至编号',name:'jzbh',allowBlank : false,maxLength : 11,minLength:11,anchor:'100%'},
			{
				xtype : 'combo',
				fieldLabel : '分配办证机构',
				displayField : 'bzjgName',
				valueField : 'bzjgCode',
				hiddenName : 'fpbzjg',
				mode : 'remote',
				store : ds_bzjgStore,
				selectOnFocus : true,
				editable : false,
				triggerAction : 'all',
				allowBlank : false,
				anchor:'100%',
				emptyText:'',
				allowBlank:false
			},{
				xtype : 'combo',
				fieldLabel : '证书类型',
				name:'zstype',
				displayField : 'zstypeName',
				valueField : 'zstypeCode',
				hiddenName : 'zstype',
				store : zstypeStore,
				triggerAction : 'all',
				lazyRender:true,
				value:'',
				anchor:'100%',
				mode : 'local',
				selectOnFocus : true,
				allowBlank:false,
				editable : false
			},{xtype : 'hidden',name : 'ssds',value:currentZzUserBzjgdm}
		],
	buttonAlign : 'center',
	minButtonWidth : 60,
	buttons : [{
		text:'确定',
		handler : function(btn){
			if(this.ownerCt.getForm().isValid()){
				if(this.ownerCt.getForm().findField('qsbh').getValue()<this.ownerCt.getForm().findField('jzbh').getValue()){
					btn.disable();
					zzscDoForm.getForm().submit({
						waitTitle : '请稍候',
						waitMsg : '正在分发证书资源,请稍候...',
						success : function(form,action) {
							Ext.Msg.show({
								title : '提示',
								msg : '证书资源分发成功!',
								buttons : Ext.Msg.OK,
								fn : function(){btn.enable();form.findField('qsbh').reset();form.findField('jzbh').reset();textSearchZsscManageid.value='';searchZsscManage();},
								icon : Ext.Msg.INFO
							});
						},
						failure : function(form, action) {
							Ext.Msg.show({
								title : '提示',
								msg : '证书资源分发失败',
								buttons : Ext.Msg.OK,
								fn : function() {btn.enable();},
								icon : Ext.Msg.ERROR
							});
						}
					});
				}else{
					Ext.Msg.show({
						title : '提示',
						msg : '“证书截至编号”输入错误，“证书截至编号”必须大于“证书起始编号”！',
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

var window_zzsc_do = new Ext.Window({
	title : '证书资源分发',
	width : 330,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	items : [zzscDoForm]
});


//加载右栏主页面   （数据列表、工具栏按钮）
var grid_ZsscManage = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	//autoHeight : true,
	cm : cm_zsscManage,
	ds : ds_zsscManage,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'flag',
	viewConfig : {forceFit : true},
	plugins : expander_zssc,
	tbar : [btn_refresh_zsscManage,btn_zzsc_do,'->', text_search_zsscManage,btn_search_zsscManage],
	bbar : new Ext.PagingToolbar({
		pageSize : useUpPageSize,
		store : ds_zsscManage,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowdblclick':function(grid, rowIndex){
			ds_zsly.baseParams.qsbh = grid.getStore().getAt(rowIndex).data.qsbh;
			ds_zsly.baseParams.jzbh = grid.getStore().getAt(rowIndex).data.jzbh;
			ds_zsly.baseParams.zstype = grid.getStore().getAt(rowIndex).data.zstype;
			ds_zsly.baseParams.jgdm = null;
			ds_zsly.load({params : {start : 0,limit : useDownPageSize}});
		}
	}
});

var ds_zsly =  new Ext.data.Store({
	url : 'findZslyByZsbh.action',
	sortInfo : {field: 'dysj', direction: 'DESC'},
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'zsbh',type : 'string'}, 
		{name : 'zslx',type : 'string'}, 
		{name : 'ssds',type : 'string'},
		{name : 'jgdm',type : 'string'},
		{name : 'ssbzjg',type : 'string'},
		{name : 'fpsj',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'dysj',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'czy',type : 'string'}, 
		{name : 'djh',type : 'string'},
		{name : 'flag',type : 'string'}]
	)
});

//默认查询 limit为显示的条数
var searchZslyManage = function() {
	ds_zsly.baseParams.jgdm = text_search_zsly.getValue();
	ds_zsly.baseParams.qsbh = null;
	ds_zsly.baseParams.jzbh = null;
	ds_zsly.baseParams.zstype = null;
	ds_zsly.load({params : {start : 0,limit : useUpPageSize} });
}

var dateFormatDyzt = function(v){
	if(v){
		return v.substring(0,10)
	}
	return '未使用';
}

var btn_refresh_zsly = new Ext.Button({
	text : '重置',
	iconCls : 'icon-refresh',
	handler : function() {
		text_search_zsly.setValue('');
		searchZslyManage();
	}
});

var btn_search_zsly = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchZslyManage();
	}
});
   
var text_search_zsly = new Ext.form.TextField({
	id:'textsearchzsly',
	name : 'textsearchzsly',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchZslyManage();
			}
		}
	}
});

ZslyListPanel = Ext.extend(Ext.grid.GridPanel,{
	constructor:function(){
		ZslyListPanel.superclass.constructor.call(this,{
		loadMask : {msg : '数据加载中...'},
			cm : new Ext.grid.ColumnModel([ 
			    {header : '证书编号',width : 100,dataIndex : 'zsbh',sortable : true}, 
			    {header : '机构代码',width : 90,	dataIndex : 'jgdm',sortable : true},
				{header : '登记号',width : 100,dataIndex : 'djh',id : 'djh',sortable : true},
				{header : '证书类型',width : 120,dataIndex : 'zslx',renderer : function(v) {return v == 0 ? '正本' : '副本'},sortable : true}, 
				{header : '打印时间',width : 100,dataIndex : 'dysj',renderer: dateFormatDyzt,sortable : true}, 
				{header : '操作人',width : 100,dataIndex : 'czy',menuDisabled : true},
				{header : '证书状态',width : 100,dataIndex : 'flag',renderer :goZslyFlag,menuDisabled : true}
			]),
			autoExpandColumn : 'djh',
			ds : ds_zsly,
			sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
			tbar : [btn_refresh_zsly,'->', text_search_zsly,btn_search_zsly],
			bbar : new Ext.PagingToolbar({
					pageSize : useDownPageSize,
					store : ds_zsly,
					displayInfo : true,
					displayMsg : '第 {0} - {1} 条 共 {2} 条',
					emptyMsg : "没有新办申请记录"}
			)
		});
	}
});

var zzZsscManage_panel = new Ext.Panel({
	title : '证书资源管理',
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
	    items : [grid_ZsscManage]
	},{
	    region: 'south',
	    layout :'fit',
		title : '证书利用记录',
	    height: 300,
	    minSize: 150,
	    maxSize: 450,
	    margins     : '0 0 0 0',
    	cmargins    : '5 0 0 0',
	    items : [new ZslyListPanel()]
	}]
});

var p_zzZsscManage = {
	id : 'zzZsscManage-panel',
	border : false,
	layout : 'border',
	items : [zzZsscManage_panel]
}