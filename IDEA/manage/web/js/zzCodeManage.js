var codeManage = Ext.data.Record.create([
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

//-----------------------点击列表信息，显示图书的扩展属性-----------------------
var expander_code = new Ext.grid.RowExpander({
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
var sm2728851 = new Ext.grid.CheckboxSelectionModel();
var cm_codeManage = new Ext.grid.ColumnModel([expander_code,
	sm2728851,
	{header : '码段批次',width : 40,dataIndex : 'id',sortable : false},
	{header : '起始代码',width : 60,dataIndex : 'qsdm',sortable : true}, 
	{header : '截至代码',width : 60,dataIndex : 'jzdm',sortable : true},
	{header : '代码类型',width : 50,dataIndex : 'fmtype',renderer : function(v) {return v == 0 ? '个体' : '非个体'},sortable : true},
	{header : '批准机构名称',width : 120,dataIndex : 'fmjgmc',id:'fmjgmc_code',sortable : true},
	{header : '批准机构代码',width : 60,dataIndex : 'fmjgdm',sortable : true},
	{header : '代码数量',width : 50,dataIndex : 'dmsl',sortable : true},
	{header : '录入人',width : 60,dataIndex : 'name',sortable : true},
	{header : '录入时间',width : 60,dataIndex : 'lrsj',sortable : true}, 
	{header : '状态',width : 50,dataIndex : 'flag',renderer : function(b) {return b == 1 ? '正常' : '不正常'},menuDisabled : true}
]);



//默认查询 limit为显示的条数
var searchCodeManage = function() {
	ds_codeManage.baseParams.conditions = text_search_codeManage.getValue();
	ds_codeManage.baseParams.username=currentZzUsername;
	ds_codeManage.baseParams.stateConditions='4,14';
	ds_codeManage.load({params : {start : 0,limit : useUpPageSize} });
}

//查询返回结果的数据列
var ds_codeManage = new Ext.data.Store({
	url : 'findAllCodeManage.action',
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

var btn_search_codeManage = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchCodeManage();
	}
});

var btn_refresh_codeManage = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchCodeManageid.value='';
		searchCodeManage();
	}
});

    
var text_search_codeManage = new Ext.form.TextField({
	id:'textSearchCodeManageid',
	name : 'textSearchCodeManage',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchCodeManage();
			}
		}
	}
});


var btn_code_do = new Ext.Button({
	text : '码段分发',
	iconCls : 'icon-edit',
	handler : function(){
		window_code_do.show();
	}
});


var codeDoForm = new Ext.FormPanel({
	url : 'saveCodeManage.action',
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
				store :codeTypeStore,
				triggerAction : 'all',
				lazyRender:true,
				value:'',
				anchor:'100%',
				mode : 'local',
				selectOnFocus : true,
				allowBlank:false,
				editable : false
			},{xtype:'textfield',fieldLabel:'起始码段',name:'qsdm',id:'qsdm_code',allowBlank : false,maxLength:'8',minLength:'8',anchor:'100%'},
			{xtype:'textfield',fieldLabel:'截至码段',name:'jzdm',id:'jzdm_code',allowBlank : false,maxLength:'8',minLength:'8',anchor:'100%'},
			{xtype : 'hidden',name : 'fpbzjg',value:currentZzUserCenterid},
            {xtype : 'hidden',name : 'fmjgmc',value:currentZzUserCenterName},
            {xtype : 'hidden',name : 'fmjgdm',value:currentZzUserBzjgdm},
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
					codeDoForm.getForm().submit({
						waitTitle : '请稍候',
						waitMsg : '正在分发证书码段,请稍候...',
						success : function(form,action) {
							Ext.Msg.show({
								title : '提示',
								msg : '码段分发成功!',
								buttons : Ext.Msg.OK,
								fn : function(){btn.enable();form.findField('qsdm').reset();form.findField('jzdm').reset();textSearchCodeManageid.value='';searchCodeManage();},
								icon : Ext.Msg.INFO
							});
						},
						failure : function(form, action) {
							Ext.Msg.show({
								title : '提示',
								msg : '码段分发失败!',
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

var window_code_do = new Ext.Window({
	title : '码段分发',
	width : 330,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	items : [codeDoForm]
});


//加载上栏主页面   （数据列表、工具栏按钮）
var grid_CodeManage = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	//autoHeight : true,
	cm : cm_codeManage,
	ds : ds_codeManage,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'fmjgmc_code',
	viewConfig : {forceFit : true},
	plugins : expander_code,
	tbar : [btn_refresh_codeManage,btn_code_do,'->', text_search_codeManage,btn_search_codeManage],
	bbar : new Ext.PagingToolbar({
		pageSize : useUpPageSize,
		store : ds_codeManage,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有码段记录"
	}),
	listeners : {
		'rowdblclick':function(grid, rowIndex){
			if(grid.getStore().getAt(rowIndex).data.fmtype=='0'){
				ds_codeDetail.baseParams.qsdm = grid.getStore().getAt(rowIndex).data.qsdm.substring(0,1)+String(parseInt(grid.getStore().getAt(rowIndex).data.qsdm.substring(1))-1)+"Z";
				ds_codeDetail.baseParams.jzdm = grid.getStore().getAt(rowIndex).data.jzdm.substring(0,1)+String(parseInt(grid.getStore().getAt(rowIndex).data.jzdm.substring(1))+1)+"0";
				ds_codeDetail.load({params : {start : 0,limit : useDownPageSize}});
			}else{
				ds_codeDetail.baseParams.qsdm = String(parseInt(grid.getStore().getAt(rowIndex).data.qsdm)-1)+"Z";
				ds_codeDetail.baseParams.jzdm = String(parseInt(grid.getStore().getAt(rowIndex).data.jzdm)+1)+"0";
				ds_codeDetail.load({params : {start : 0,limit : useDownPageSize}});
			}
		}
	}
});


var ds_codeDetail =  new Ext.data.Store({
	url : 'findCodeByDmmd.action',
	sortInfo : {field: 'jgdm', direction: 'ASC'},
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'jgdm',type : 'string'},
	   	{name : 'jgmc',type : 'string'}, 
		{name : 'dmlx',type : 'string'},
		{name : 'zch',type : 'string'},
		{name : 'bzjgdm',type : 'string'},
		{name : 'fumaName',type : 'string'},
		{name : 'fumaDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'flag',type : 'string'}]
	)
});


var dateFormatZszt = function(v){
	if(v){
		return '已办证'
	}
	return '未办证';
}

CodeDetailListPanel = Ext.extend(Ext.grid.GridPanel,{
	constructor:function(){
		CodeDetailListPanel.superclass.constructor.call(this,{
		loadMask : {msg : '数据加载中...'},
			cm : new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),  
			    {header : '机构代码',width : 90,dataIndex : 'jgdm',sortable : true}, 
			    {header : '机构名称',dataIndex : 'jgmc',id : 'jgmc_code',sortable : true},
				{header : '注册号',width : 120,dataIndex : 'zch',sortable : true},
				{header : '代码类型',width : 80,dataIndex : 'dmlx',renderer : function(v) {return v == 0 ? '个体' : '非个体'},sortable : true}, 
				{header : '办证机构代码',width : 80,dataIndex : 'bzjgdm',sortable : true}, 
				{header : '办理人',width : 80,dataIndex : 'fumaName',menuDisabled : true},
				{header : '办理时间',width : 80,dataIndex : 'fumaDate',renderer: goDateFormat,sortable : true},
				{header : '状态',width : 80,dataIndex : 'flag',renderer: dateFormatZszt,sortable : true}
			]),
			autoExpandColumn : 'jgmc_code',
			ds : ds_codeDetail,
			sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
			bbar : new Ext.PagingToolbar({
					pageSize : useDownPageSize,
					store : ds_codeDetail,
					displayInfo : true,
					displayMsg : '第 {0} - {1} 条 共 {2} 条',
					emptyMsg : "没有新办申请记录"}
			)
		});
	}
});

var zzCodeManage_panel = new Ext.Panel({
	title : '赋码资源管理',
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
	    items : [grid_CodeManage]
	},{
	    region: 'south',
	    layout :'fit',
		title : '代码使用情况',
	    height: 300,
	    minSize: 150,
	    maxSize: 450,
	    margins     : '0 0 0 0',
    	cmargins    : '5 0 0 0',
	    items : [new CodeDetailListPanel()]
	}]
});

var p_zzCodeManage = {
	id : 'zzCodeManage-panel',
	border : false,
	layout : 'border',
	items : [zzCodeManage_panel]
}
