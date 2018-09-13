var Zuser = Ext.data.Record.create([
	{name : 'userid',mapping : 'userid',type : 'int'}, 
	{name : 'xzqhName',mapping : 'xzqhName',type : 'string'}, 
	{name : 'xzqhCode',mapping : 'xzqhCode',type : 'string'},
	{name : 'orgZch',mapping : 'orgZch',type : 'string'},
	{name : 'orgName',mapping : 'orgName',type : 'string'}, 
	{name : 'orgCode',mapping : 'orgCode',type : 'string'}, 
	{name : 'orgType',mapping : 'orgType',type : 'string'}, 
	{name : 'userName',mapping : 'userName',type : 'string'}, 
	{name : 'userPwd',mapping : 'userPwd',type : 'string'}, 
	{name : 'name',	mapping : 'name',type : 'string'}, 
	{name : 'mPhone',mapping : 'mPhone',type : 'string'}, 
	{name : 'tel',	mapping : 'tel',type : 'string'}, 
	{name : 'email',mapping : 'email',type : 'string'}, 
	{name : 'sex',mapping : 'sex',type : 'string'}, 
	{name : 'sfzHao',mapping : 'sfzHao',type : 'string'}, 
	{name : 'msgType',mapping : 'msgType',type : 'int'}, 
	{name : 'state',mapping : 'state',type : 'string'}, 
	{name : 'note',	mapping : 'note',type : 'string'}
]);


//点击列表信息，显示用户的扩展属性-->
var expander3 = new Ext.grid.RowExpander({
	tpl : new Ext.Template('<p><table width="800" style="padding-left:20px" border="0" cellspacing="0" cellpadding="0">'
			+ '<tr>'
			+ '<td width="650" colspan="4">'
			+ '<table width="100%" align="left" border="0" cellspacing="0" cellpadding="0">'
			+ '<tr height="20">'
			+ '  <td width="15%" align="right" valign="middle" nowrap="nowrap">用户名：</td><td width="38%" nowrap="nowrap">{userName}</td>'
			+ '  <td width="19%" align="right" nowrap="nowrap">姓名：</td><td width="28%" nowrap="nowrap">{name}</td>'
			+ '</tr>'
			+ '<tr height="20">'
			+ '  <td align="right" nowrap="nowrap">注册号：</td><td nowrap="nowrap">{orgZch}</td>'
			+ '  <td align="right" nowrap="nowrap">机构类别：</td><td nowrap="nowrap">{orgType}</td>'
			+ '</tr>'
			+ '<tr height="20">'
			+ '  <td align="right" nowrap="nowrap">所属机构：</td><td nowrap="nowrap">{orgName}</td>'
			+ '  <td align="right" nowrap="nowrap">所属机构代码：</td><td nowrap="nowrap">{orgCode}</td>'
			+ '</tr>'
			+ '<tr height="20">'
			+ '  <td align="right" nowrap="nowrap">联系电话：</td><td nowrap="nowrap">{tel}</td>'
			+ '  <td align="right" nowrap="nowrap">手机号码：</td><td nowrap="nowrap">{mPhone}</td>'
			+ '</tr>'
			+ '<tr height="20">'
			+ '  <td align="right" nowrap="nowrap">电子信箱：</td><td nowrap="nowrap">{email}</td>'
			+ '  <td align="right" nowrap="nowrap">行政区代码：</td><td nowrap="nowrap">{xzqhName}</td>'
			+ '</tr>'
			+ '<tr height="20">'
			+ '   <td align="right" nowrap="nowrap">邮政编码：</td><td nowrap="nowrap">{postalcode}</td>'
			+ '   <td align="right" nowrap="nowrap">性别：</td><td nowrap="nowrap">{sex}</td>'
			+ '</tr>'
			+ '<tr height="20">'
			+ '  <td align="right" nowrap="nowrap">身份证号：</td><td nowrap="nowrap">{sfzHao}</td>'
			+ '  <td align="right" nowrap="nowrap">提示方式：</td><td nowrap="nowrap">{pack}</td>'
			+ '</tr>'
			+ '<tr height="20">'
			+ '  <td align="right" nowrap="nowrap">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</td><td nowrap="nowrap" colspan="3">{description}</td>'
			+ '</tr>'
			+ '</table>'
			+ '</td></tr></table></p>')
});

   
//列表显示用户主要信息//
var sm2 = new Ext.grid.CheckboxSelectionModel();
var cm_zuser = new Ext.grid.ColumnModel([expander3,
	sm2,
    {header : '用户名',width : 70,dataIndex : 'userName',sortable : true},
	{header : '姓名',width : 70,dataIndex : 'name',	sortable : true}, 
	{header : '所属机构',width : 170,dataIndex : 'orgName',sortable : true}, 
	{header : '性别',width : 40,	dataIndex : 'sex',sortable : true}, 
	{header : '身份证号',width : 90,	dataIndex : 'sfzHao',sortable : true}, 
	{header : '联系电话',width :70,dataIndex : 'tel',menuDisabled : true}, 
	{header : '当前状态',width : 60,dataIndex : 'state',renderer : function(v) {return v == '0' ? '未审核' : '已审核'},	menuDisabled : true}, 
	{header : '备注',	width : 50,dataIndex : 'description',id : 'description',sortable : true}
]);



var btn_return_zuser = new Ext.Button({
	text : '审核通过',
	iconCls : 'icon-ok',
	handler : function(){
		var record = grid_registerAudit.getSelectionModel().getSelected();
		if(record){
			ajaxLoadMask.show();
			var userName = record.data.userName;
			Ext.Ajax.request({
				url: 'returnZuserOk.action',
   				success: function(){
   					ajaxLoadMask.hide();
   					Ext.Msg.show({
						title : '提示',
						msg : '用户操作成功!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.INFO,
						fn : function(){
							record.set('state',1);
							grid_registerAudit.fireEvent('rowclick',grid_registerAudit,grid_registerAudit.getStore().indexOf(record));
						}
					});
   				},
   				failure: function(){
   					ajaxLoadMask.hide();
   					Ext.Msg.show({
						title : '提示',
						msg : '用户操作失败!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
   				},
   				params: {userName: userName}
			});
		}
	}
});



var btn_edit_registerAudit = new Ext.Button({
	text : '修改',
	iconCls : 'icon-edit',
	handler : function(){
		var record = grid_registerAudit.getSelectionModel().getSelected();
		if(record){
			window_read_zuser.show();
			zuserReadForm.getForm().loadRecord(record);
		}
	}
})

var btn_refresh_registerAudit = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		text_search_registerAudit.value='';
		SearchRegistUser();
		btn_add_registerAudit.setDisabled(true);
		btn_edit_registerAudit.setDisabled(true);
		btn_return_registerAudit_no.setDisabled(true);
		btn_return_registerAudit_ok.setDisabled(true);
	}
});

var btn_del_registerAudit = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	handler : function() {
		var record = grid_registerAudit.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该件工单?', function(btn) {
				if (btn == 'yes') {
					ajaxLoadMask.show();
					Ext.Ajax.request({
						url : 'deleteZuser.action',
						params : {userName : record.data.userName},
						success : function() {ajaxLoadMask.hide();grid_registerAudit.getStore().remove(record);},
						failure : function() {
							ajaxLoadMask.hide();
							Ext.Msg.show({
								title : '错误提示',
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


//默认查询 limit为显示的条数//
var SearchRegistUser = function() {
	ds_registerAudit.baseParams.conditions = text_search_registerAudit.getValue();
	ds_registerAudit.load({params : {start : 0,limit : 10}
	});
}

var ds_registerAudit = new Ext.data.Store({
	url : 'findAllZuser.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [
		{name : 'userid',type : 'int'}, 
		{name : 'userName',type : 'string'}, 
		{name : 'name',type : 'string'}, 
		{name : 'orgName',type : 'string'}, 
		{name : 'sex',type : 'string'}, 
		{name : 'sfzHao',type : 'string'},
		{name : 'mPhone',type : 'string'}, 
		{name : 'tel',type : 'string'}, 
		{name : 'state',type : 'string'}, 
		{name : 'note',type : 'string'}
	])
});

var btn_search_registerAudit = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : SearchRegistUser
});



  
var text_search_registerAudit = new Ext.form.TextField({
	name : 'textSearchRegistUser',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				SearchRegistUser();
			}
		}
	}
});

//加载工具栏和按钮//
var grid_registerAudit = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_zuser,
	ds : ds_registerAudit,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'address',
	viewConfig : {forceFit : true},
	plugins : expander3,
	tbar : [btn_edit_registerAudit, '-', btn_del_registerAudit, '-',btn_refresh_registerAudit,'-', btn_return_zuser,'->',
	        text_search_registerAudit,btn_search_registerAudit],
	bbar : new Ext.PagingToolbar({
		pageSize : 10,
		store : ds_registerAudit,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowdblclick':function(grid, rowIndex){
			ds_loanlog.baseParams.userName = grid.getStore().getAt(rowIndex).data.userName;
			ds_loanlog.load({params : {start : 0,limit : 10}});
		},
		'rowclick':function(grid,rowIndex){
			btn_loan_zuser.setDisabled(grid.getStore().getAt(rowIndex).data.state == '0' ? true:false);
			btn_return_zuser.setDisabled(grid.getStore().getAt(rowIndex).data.state == '1' ? true:false);
		}
	}
});




var zzRegisterAudit_panel = new Ext.Panel({
	title : '注册用户管理',
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
	    items : [grid_registerAudit]
	}]
});
var p_zzRegisterAudit = {
	id : 'zzregisterAudit-panel',
	border : false,
	layout : 'border',
	items : [zzRegisterAudit_panel]
}
