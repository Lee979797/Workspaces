

//-----------------------点击列表信息，显示图书的扩展属性-----------------------
var expander_feizhiHuifuManage = new Ext.grid.RowExpander({
	tpl : new Ext.Template('<table width="100%"  border="0" cellspacing="6" cellpadding="0"  bgcolor="#DDEEF9" style="margin-top:1px;" >'
			+ '<tr>'
			+ '<td width="" colspan="4">'
			+ '<table width="98%" bgcolor="#ffffff" border="1" cellpadding="0" cellspacing="0" align="center"  bordercolordark="#FFFFFF" bordercolorlight="#6EBBE1" style="margin-top:0px;>'
			+ '<tr height="" valign="middle">'
			+ '  <td width="20%" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构名称：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgmc}<img src="images/temp.gif"></td>'
			+ '  <td width="20%" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构代码：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">小微企业：</td><td nowrap="nowrap" style="padding-top:5px">{isxw}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">年检日期：</td><td nowrap="nowrap" style="padding-top:5px">{njrq}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">法定代表人：</td><td nowrap="nowrap" style="padding-top:5px">{fddbr}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">是否公开：</td><td nowrap="nowrap" style="padding-top:5px">{gk}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证件类型：</td><td nowrap="nowrap"  style="padding-top:5px">{zjlx}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证件号码：</td><td nowrap="nowrap"  style="padding-top:5px">{zjhm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle" >'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构类型：</td><td  nowrap="nowrap" style="padding-top:5px">{jglx}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经济行业：</td><td nowrap="nowrap" style="padding-top:5px">{jjhymc} {jjhydm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经营范围：</td><td  colspan=3 style="padding-top:5px">{jyfw}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">成立日期：</td><td nowrap="nowrap" style="padding-top:5px">{zcrq}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">职工人数：</td><td nowrap="nowrap" style="padding-top:5px">{zgrs}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证照有效开始日期：</td><td nowrap="nowrap" style="padding-top:5px">{zsbfrq}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证照有效终止日期：</td><td nowrap="nowrap" style="padding-top:5px">{zszfrq}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">企业注册类型：</td><td nowrap="nowrap" style="padding-top:5px">{jjlx} {jjlxdm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">外方国别：</td><td nowrap="nowrap" style="padding-top:5px">{wftzgb} {wftzgbdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册资金：</td><td nowrap="nowrap" style="padding-top:5px">{zczj}(万)<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">货币种类：</td><td nowrap="nowrap" style="padding-top:5px">{hbzl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">主管部门：</td><td nowrap="nowrap" style="padding-top:5px">{zgmc} {zgdm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">批准机构：</td><td nowrap="nowrap" style="padding-top:5px">{pzjgmc} {pzjgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注 册 号：</td><td nowrap="nowrap" style="padding-top:5px">{zch}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">联系电话：</td><td nowrap="nowrap" style="padding-top:5px">{dhhm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构注册地址：</td><td  colspan=3 style="padding-top:5px">{jgdz}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">行政区划：</td><td nowrap="nowrap" style="padding-top:5px">{xzqhName} {xzqhCode}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">邮政编码：</td><td nowrap="nowrap" style="padding-top:5px">{yzbm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构实际地址：</td><td  colspan=3 style="padding-top:5px">{jydz}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">行政区划：</td><td nowrap="nowrap" style="padding-top:5px">{xzqhName2} {xzqhCode2}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">邮政编码：</td><td nowrap="nowrap" style="padding-top:5px">{jyyb}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">电子信箱：</td><td nowrap="nowrap" style="padding-top:5px">{email}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">网&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</td><td nowrap="nowrap" style="padding-top:5px">{weburl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">是否发卡：</td><td nowrap="nowrap" style="padding-top:5px">{fkbz}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">发卡数量：</td><td nowrap="nowrap" style="padding-top:5px">{fksl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">办证日期：</td><td nowrap="nowrap" style="padding-top:5px">{bzrq}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">作废日期：</td><td nowrap="nowrap" style="padding-top:5px">{zfrq}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经 办 人：</td><td nowrap="nowrap" style="padding-top:5px">{tbrxm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件类型：</td><td nowrap="nowrap" style="padding-top:5px">{tbrzjlx}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件号码：</td><td nowrap="nowrap" style="padding-top:5px">{tbrsfzh}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人电话：</td><td nowrap="nowrap" style="padding-top:5px">{tbrlxfs}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">办 理 人：</td><td nowrap="nowrap" style="padding-top:5px">{handleName}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">办理时间：</td><td nowrap="nowrap" style="padding-top:5px">{handleDate}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审 核 人：</td><td nowrap="nowrap" style="padding-top:5px">{auditName}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核时间：</td><td nowrap="nowrap" style="padding-top:5px">{auditDate}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核意见：</td><td  colspan=3 style="padding-top:5px">{auditNote}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '</table>'
			+ '</td></tr></table>')
});



//---------------------- 列表显示主要数据信息 ----------------------------------
// 列表显示机构的主要信息 yangqi
var sm26785544 = new Ext.grid.CheckboxSelectionModel();
 
var cm_feizhiHuifuManage = new Ext.grid.ColumnModel([expander_feizhiHuifuManage,
	sm26785544,
	{header : '原文',width : 20,dataIndex : 'imageUrl', renderer:icon_feizhiHuifuManage,sortable : false},
	{header : '流水号',width : 60,dataIndex : 'orderid',sortable : true}, 
	{header : '机构名称',width : 180,sortable : true,dataIndex : 'jgmc'},
	{header : '机构代码',width : 60,sortable : true,dataIndex : 'jgdm'},
	{header : '机构类型',width : 60,sortable : true,dataIndex : 'jglx'},
	{header : '法定代表人/负责人',width : 80,dataIndex : 'fddbr',sortable : true}, 
	{header : '办理人',width : 40,dataIndex : 'handleName',id : 'handleName',sortable : true},
	{header : '业务类型',	width : 50,dataIndex : 'ywlx',id : 'ywlx',sortable : true},
	{header : '状态',width : 150,dataIndex : 'state',renderer : goTjgdmState,menuDisabled : true}
]);

var feizhiHuifuManageForm = new Ext.FormPanel({
	labelAlign : 'right',
	labelWidth : 90,
	bodyStyle : 'padding:5px',
	border : false,
	baseCls : 'x-plain',
	defaultType : 'combo',
	defaults : {anchor:'98%'},
	items : [
		{xtype : 'textfield',fieldLabel : '机构代码',name : 'jgdm',allowBlank:false,readOnly:true},
		{xtype : 'textfield',fieldLabel : '机构名称',name : 'jgmc',allowBlank:false,readOnly:true},
		{xtype : 'textarea',fieldLabel : '搁置原因',name : 'handleNote',height:100,allowBlank:false,readOnly:true},
		{xtype : 'textarea',fieldLabel : '搁置批复',name : 'auditNote',id:'auditNote_feizhiHuifuManage',height:100,allowBlank:false}
	],
	buttonAlign : 'center',
	minButtonWidth : 60,
	buttons : [{
		text : '恢复申请驳回',
		handler : function(btn){
			var record=grid_FeizhiHuifuManage.getSelectionModel().getSelected();
			if (record) {
				var strAuditNote=feizhiHuifuManageForm.getForm().findField('auditNote_feizhiHuifuManage').getValue();
				var strJgdm=record.data.jgdm;
				if (feizhiHuifuManageForm.getForm().isValid()) {
					ajaxLoadMask.show();
					Ext.Ajax.request({
						url: 'returnTjgdmFeizhiHuifu.action',
		   				params: { jgdm: strJgdm,auditNote:strAuditNote},
		   				success: function(response){
		   					window_gezhi_feizhiHuifuManage.hide();
		   					ajaxLoadMask.hide();
		   					Ext.Msg.show({
								title : '提示',
								msg : '“搁置确认”操作成功!',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.INFO,
								fn : function(){
									btn.enable();
									record.set('state','200');
								}
							});
		   				},
		   				failure: function(){
		   					ajaxLoadMask.hide();
		   					Ext.Msg.show({
								title : '提示',
								msg : '“搁置确认”操作失败!',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR
							});
		   				}
					});
				}
			}else{
				Ext.Msg.show({
					title : '提示',
					msg : '请选择需搁置机构！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.ERROR
				});
			}
		}
	},{
		text : '取消',
		handler:function(){
			feizhiHuifuManageForm.getForm().reset();
			this.ownerCt.ownerCt.hide();
		}
	}]
});


var window_gezhi_feizhiHuifuManage = new Ext.Window({
	title : '恢复申请驳回',
	width : 500,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function(){
			feizhiHuifuManageForm.getForm().reset();			
		}
	},
	items : [feizhiHuifuManageForm]
});


var btn_return_feizhiHuifuManage = new Ext.Button({
	text : '恢复申请驳回',
	iconCls : 'icon-put',
	disabled:true,
	handler : function(btn){
		var record=grid_FeizhiHuifuManage.getSelectionModel().getSelected();
		if (record) {
			window_gezhi_feizhiHuifuManage.show();
			feizhiHuifuManageForm.getForm().findField('jgdm').setValue(record.data.jgdm);
			feizhiHuifuManageForm.getForm().findField('jgmc').setValue(record.data.jgmc);
			feizhiHuifuManageForm.getForm().findField('handleNote').setValue(record.data.handleNote);
			btn.disable();
		}else{
			alert('请选择需恢复机构！');
		}
	}
});


var btn_return_feizhiHuifuManage_cancl = new Ext.Button({
	text : '恢复申请通过',
	iconCls : 'icon-ok',
	disabled:true,
	handler : function(btn){
		var record=grid_FeizhiHuifuManage.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('操作提示','确认“机构恢复”?',function(btn){
				if('yes' == btn){
					ajaxLoadMask.show();
					var strJgdm=record.data.jgdm;
					Ext.Ajax.request({
						url: 'returnTjgdmFeizhiHuifu.action',
		   				params: { jgdm: strJgdm},
		   				success: function(response){
		   					ajaxLoadMask.hide();
		   					Ext.Msg.show({
								title : '提示',
								msg : '机构“恢复申请通过”操作成功!',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.INFO,
								fn : function(){
									record.set('state','100');
									btn.disable();
								}
							});
		   				},
		   				failure: function(){
		   					ajaxLoadMask.hide();
		   					Ext.Msg.show({
								title : '提示',
								msg : '机构“恢复申请通过”操作失败!',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR
							});
		   				}
					});
				}
			});
		}else{
			alert('请选择需取消搁置的机构！');
		}
	}
});



//默认查询 limit为显示的条数
var searchFeizhiHuifuManage = function() {
	ds_feizhiHuifuManage.baseParams.conditions = text_search_feizhiHuifuManage.getValue();
	ds_feizhiHuifuManage.baseParams.username=currentZzUsername;
	ds_feizhiHuifuManage.baseParams.stateConditions='1';
	ds_feizhiHuifuManage.load({params : {start : 0,limit : useFullPageSize} });

}

//查询返回结果的数据列
var ds_feizhiHuifuManage = new Ext.data.Store({
	url : 'findAllTjgdm.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'orgid',type : 'int'}, 
	    {name : 'orderid',type : 'string'}, 
	    {name : 'centerid',type : 'string'},
	    {name : 'docid',type : 'string'},
		{name : 'jgmc',type : 'string'},
		{name : 'jgdm',type : 'string'},
		{name : 'jglx',type : 'string'}, 
		{name : 'fddbr',type : 'string'}, 
		{name : 'zjlx',type : 'string'},
		{name : 'zjhm',type : 'string'}, 
		{name : 'jyfw',type : 'string'},
		{name : 'zcrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zgdm',type : 'string'},
		{name : 'zgmc',type : 'string'},
		{name : 'pzjgmc',type : 'string'},
		{name : 'xzqhCode',type : 'string'},
		{name : 'xzqhName',type : 'string'},
		{name : 'xzqhCode2',type : 'string'},
		{name : 'xzqhName2',type : 'string'},
		{name : 'jgdz',type : 'string'},
		{name : 'yzbm',type : 'string'},
		{name : 'dhhm',type : 'string'},
		{name : 'bzjgdm',type : 'string'},
		{name : 'zycp1',type : 'string'},
		{name : 'zycp2',type : 'string'},
		{name : 'zycp3',type : 'string'},
		{name : 'zczj',type : 'string'},
		{name : 'hbzl',type : 'string'},
		{name : 'wftzgb',type : 'string'},
		{name : 'zgrs',type : 'string'},
		{name : 'zch',type : 'string'},
		{name : 'pzwh',type : 'string'},
		{name : 'pwrq',type : 'string'},
		{name : 'email',type : 'string'},
		{name : 'weburl',type : 'string'},
		{name : 'mobile',type : 'string'},
		{name : 'yjflag',type : 'string'},
		{name : 'tbrxm',type : 'string'},
		{name : 'tbrsfzh',type : 'string'},
		{name : 'tbrlxfs',type : 'string'},
		{name : 'jydz',type : 'string'},
		{name : 'jyyb',type : 'string'},
		{name : 'jydh',type : 'string'},
		{name : 'jfly',type : 'string'},
		{name : 'khyh',type : 'string'},
		{name : 'khzh',type : 'string'},
		{name : 'jjhymc',type : 'string'},
		{name : 'jjhydm',type : 'string'},
		{name : 'gk',type : 'string'},
		
		{name : 'njrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'bzrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'isxw',type : 'string'},
		{name : 'fkbz',type : 'string'},
		{name : 'fksl',type : 'int'},
		
		{name : 'zsbfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zszfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'jjlx',type : 'string'},
		{name : 'jjlxdm',type : 'string'},
		{name : 'tbrzjlx',type : 'string'},
		{name : 'memo',type : 'string'},
		{name : 'memo2',type : 'string'},
		{name : 'wftzgbdm',type : 'string'},
		{name : 'hbzldm',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		
		{name : 'ywlx',type : 'string'},
		{name : 'name',type : 'string'},
		{name : 'userid',type : 'string'},
		{name : 'username',type : 'string'},
		{name : 'handleName',type : 'string'},
		{name : 'handleDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'handleNote',type : 'string'},
		{name : 'auditName',type : 'string'},
		{name : 'auditDate',type : 'date',convert:function(v){if(v) return v.substring(0,16);}},
		{name : 'auditNote',type : 'string'},
		{name : 'imageUrl',type : 'string'},
		
		{name : 'offPzjgmc',type : 'string'},
		{name : 'offPzwh',type : 'string'},
		{name : 'offReason',type : 'string'},	
		{name : 'offNote',type : 'string'},
		{name : 'state',type : 'string'}
	])
});

var btn_search_feizhiHuifuManage = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchFeizhiHuifuManage();
		btn_return_feizhiHuifuManage.setDisabled(true);
		btn_return_feizhiHuifuManage_cancl.setDisabled(true);
	}
});

var btn_refresh_feizhiHuifuManage = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchFeizhiHuifuManageid.value='';
		searchFeizhiHuifuManage();
		btn_return_feizhiHuifuManage.setDisabled(true);
		btn_return_feizhiHuifuManage_cancl.setDisabled(true);
	}
});

var text_search_feizhiHuifuManage = new Ext.form.TextField({
	id:'textSearchFeizhiHuifuManageid',
	name : 'textSearchFeizhiHuifuManage',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchFeizhiHuifuManage();
			}
		}
	}
});


//--------------------图片浏览窗口-------------------------------------------
var imageView_window_feizhiHuifuManage = new Ext.Window({   
    id: 'image-window_7483262',   
    title : '原文预览',   
    width : 900,   
    height : 600,   
    resizable : true, 
    maximizable:true,
    closeAction :'hide',
    html: '<OBJECT classid="clsid:B4E2D33E-D8B2-4956-9F91-1C6BDC87A6D1"   width=100%  height=100% align=center hspace=0 vspace=0 id="scanner74832"  name="scanner74832" >'
	       +'<param name="ShowCount" value="8">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>',
    buttons: [{   
	       text: '重载',   
		       handler: function() { 
		    	   var record = grid_FeizhiHuifuManage.getSelectionModel().getSelected();
				   var resultObject = null;
				   var useState=record.data.state;
				   var	imgUrl='';
					imgUrl='orgnewViewImg.action';

		    		Ext.Ajax.request({
						url : imgUrl,
						params : {orgid : record.data.orgid},
						success : function(result,request) {//获取返回值
							var resultObject = Ext.util.JSON.decode(result.responseText);
							if(resultObject!=null){
								scanner74832.OpenProgress(3);  //设置上传的进度条的总进度数
								scanner74832.Progress('原文加载中',1);
								scanner74832.Progress('原文加载中',2);
							    //resultObject = eval('('+result.responseText+')');  
			   					scanner74832.ImageData=resultObject.imageData;
		   						if(scanner74832.ImageData!=""){
		   							scanner74832.PageType=resultObject.pageTypeStr;
		   							scanner74832.Progress('原文加载完毕',3);
		   						}else{
		   							scanner74832.Progress('原文加载失败',3);
			   						alert("原文错误，加载失败，请重新扫描或导入！");
		   						}
		   						scanner74832.CloseProgress();
							}
						},
						failure : function() {
							alert("图像加载错误");
						}
					});
		       }
	   },{   
	        text: '取消',   
	        handler: function() {   
	            imageView_window_feizhiHuifuManage.hide();   
	        }
	   }],
	   listeners : {
			'activate' : function() {  //标签激活后自动加载数据
				var record = grid_FeizhiHuifuManage.getSelectionModel().getSelected();
				var resultObject = null;
				var useState=record.data.state;
				var	imgUrl='';
				scanner74832.ImageData="";
				scanner74832.PageType="";
				imgUrl='orgnewViewImg.action';
	    		Ext.Ajax.request({
					url : imgUrl,
					params : {orgid : record.data.orgid},
					success : function(result,request) {//获取返回值
						var resultObject = Ext.util.JSON.decode(result.responseText);
						if(resultObject!=null){
							scanner74832.OpenProgress(3);  //设置上传的进度条的总进度数
							scanner74832.Progress('原文加载中',1);
							scanner74832.Progress('原文加载中',2);
						    //resultObject = eval('('+result.responseText+')');  
		   					scanner74832.ImageData=resultObject.imageData;
	   						if(scanner74832.ImageData!=""){
	   							scanner74832.PageType=resultObject.pageTypeStr;
	   							scanner74832.Progress('原文加载完毕',3);
		   						scanner74832.CloseProgress();
	   						}else{
	   							scanner74832.Progress('原文加载失败',3);
		   						scanner74832.CloseProgress();
		   						alert("原文错误，加载失败，请重新扫描或导入！");
	   						}
						}
					},
					failure : function() {
						alert("图像加载错误");
					}
				});
			}
		}
    
});   

//---------------------- 弹出浏览原文的窗口 ------------------------------------
function viewPic_feizhiHuifuManage()
{
	imageView_window_feizhiHuifuManage.show(); 
	imageView_window_feizhiHuifuManage.setTitle('原文预览');
}
//---------------------- 列表显示原文的标识 ------------------------------------
function icon_feizhiHuifuManage(value,p,record){
	if(typeof record=='object'){
		var fileUrl;
		fileUrl=record.data["imageData"];
		//alert(fileUrl);
		if(fileUrl!=''){
			return String.format('<a style="display:table;width:100%;" onclick="viewPic_feizhiHuifuManage()"><img src="images/file_ico.gif"></a>',record.data["orgid"]);
		}
	}  
}

//加载右栏主页面   （数据列表、工具栏按钮）
var grid_FeizhiHuifuManage = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_feizhiHuifuManage,
	ds : ds_feizhiHuifuManage,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'jgmc',
	viewConfig : {forceFit : true},
	plugins : expander_feizhiHuifuManage,
	tbar : [btn_refresh_feizhiHuifuManage,btn_return_feizhiHuifuManage,btn_return_feizhiHuifuManage_cancl,'->', 
		  	text_search_feizhiHuifuManage,btn_search_feizhiHuifuManage],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_feizhiHuifuManage,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			if(grid.getStore().getAt(rowIndex).data.state == '1')
			{
				btn_return_feizhiHuifuManage.setDisabled(false);
				btn_return_feizhiHuifuManage_cancl.setDisabled(false);
			}else{
				btn_return_feizhiHuifuManage.setDisabled(true);
				btn_return_feizhiHuifuManage_cancl.setDisabled(true);
			}
		}
	}
});


var zzFeizhiHuifuManage_panel = new Ext.Panel({
	title : '注销恢复管理',
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
	    items : [grid_FeizhiHuifuManage]
	}]
});

var p_zzFeizhiHuifuManage = {
	id : 'zzFeizhiHuifuManage-panel',
	border : false,
	layout : 'border',
	items : [zzFeizhiHuifuManage_panel]
}