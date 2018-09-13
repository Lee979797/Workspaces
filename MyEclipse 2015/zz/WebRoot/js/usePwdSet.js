
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
 

var pwdSetForm = new Ext.FormPanel({
	url : 'updatePwd.action',
	labelAlign : 'right',
	labelWidth : 80,
	bodyStyle : 'padding:5px',
	border : false,
	baseCls : 'x-plain',
	defaults : {anchor:'30%'},
	items : [
	   {xtype : 'hidden',name : 'userid',value:currentUserid},//
	   {xtype : 'textfield',fieldLabel : '旧密码',allowBlank:false,name : 'userPwdOld'},
	   {xtype : 'textfield',fieldLabel : '新密码',id:'new',allowBlank:false,name : 'userPwdNew',inputType : "password" },
	   {xtype : 'textfield',fieldLabel : '重复新密码',allowBlank:false,name : 'userPwd',vtype:'pwd', confirmTo: 'new',inputType : "password" }
	]
});

       
var btn_save_pwdSet = new Ext.Button({
	text : '保存',
	iconCls : 'icon-yes',
	handler : btn_savePwdInfo
});


var btn_reset_pwdSet = new Ext.Button({
	text : '取消',
	iconCls : 'icon-refresh',
	handler:function(){
			pwdSetForm.getForm().reset();
	}
});


function btn_savePwdInfo(btn){
	if (pwdSetForm.getForm().isValid()) {
		pwdSetForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在修改数据,请稍候...',
			success : function(form) {
				
				Ext.Msg.show({
					title : '提示',
					msg : '[新密码] 信息保存成功',
					buttons : Ext.Msg.OK,
					fn : function() {
						btn.enable();
						pwdSetForm.getForm().reset();
					},
					icon : Ext.Msg.INFO
				});
			},
			failure : function(form) {
				Ext.Msg.show({
					title : '提示',
					msg : '密码更新失败，请确认旧密码正确性！',
					buttons : Ext.Msg.OK,
					fn : function() {btn.enable();},
					icon :Ext.Msg.ERROR
				});
			}
		});
	}else{
		Ext.Msg.show({
			title : '提示',
			msg : '信息填写不完整！<br><br>显示为红色的输入框为错误输入项',
			buttons : Ext.Msg.OK,
			fn : function() {btn.enable();},
			icon : Ext.Msg.ERROR
		});
	}
}

var  pInfoViewForm= new Ext.Panel({
    //title       : '密码信息',
    id          : 'pInfo',
    region      : 'center',
    margins     : '3 0 0 0',
    cmargins    : '5 5 0 0',
	autoScroll : true,
	layout: 'fit',
	bodyStyle: 'padding:0px',
    items : [pwdSetForm]
});

var p_usePwdSet = {
	id : 'usePwdSet-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:5px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    //bodyBorder: false,
	    title: '密码修改',
	    iconCls : 'icon-plugin',
 		//plain: true,
		region: 'center',
		tbar : [btn_save_pwdSet,btn_reset_pwdSet],
		items: [pInfoViewForm]
	}]
}