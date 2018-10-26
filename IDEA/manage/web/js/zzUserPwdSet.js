var pwdSetForm = new Ext.FormPanel({
	url : 'updateUserPwd.action',
	labelAlign : 'right',
	labelWidth : 80,
	bodyStyle : 'padding:10px',
	border : false,
	baseCls : 'x-plain',
	defaults : {anchor:'35%'},
	items : [
	   {xtype : 'textfield',fieldLabel : '用户名',name : 'userName',value:currentZzUsername,allowBlank:false,readOnly:true},
	   {xtype : 'textfield',fieldLabel : '旧密码',name : 'userPwdOld',allowBlank:false},
	   {xtype : 'textfield',fieldLabel : '新密码',id:'new',name : 'userPwdNew',allowBlank:false,inputType : "password" },
	   {xtype : 'textfield',fieldLabel : '重复新密码',name : 'password',allowBlank:false,vtype:'pwd', confirmTo: 'new',inputType : "password" }
	]
});

       
var btn_save_pwdSet = new Ext.Button({
	text : '保存',
	iconCls : 'icon-ok',
	handler : btn_saveUserPwd
});


var btn_reset_pwdSet = new Ext.Button({
	text : '取消',
	iconCls : 'icon-refresh',
	handler:function(){
			pwdSetForm.getForm().reset();
	}
});


function btn_saveUserPwd(btn){
	if (pwdSetForm.getForm().isValid()) {
		pwdSetForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在修改数据,请稍候...',
			success : function(form) {
				
				Ext.Msg.show({
					title : '提示',
					msg : '“密码”修改成功！',
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
					msg : '密码更新失败（旧密码不正确）！',
					buttons : Ext.Msg.OK,
					fn : function() {btn.enable();},
					icon :Ext.Msg.ERROR
				});
			}
		});
	}else{
		Ext.Msg.show({
			title : '提示',
			msg : '信息填写不完整！<br><br>红色的输入框为错误项',
			buttons : Ext.Msg.OK,
			fn : function() {btn.enable();},
			icon : Ext.Msg.ERROR
		});
	}
}


	
var  userPwdViewForm= new Ext.Panel({
    //title       : '密码信息',
    id          : 'pInfo',
    region      : 'center',
    margins     : '3 0 0 0',
    cmargins    : '5 5 0 0',
	autoScroll : true,
	layout: 'fit',
	border : false,
	bodyStyle: 'padding:0px',
    items : [pwdSetForm]
});

var p_zzUserPwdSet = {
	id : 'zzUserPwdSet-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:5px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    title: '密码修改',
	    iconCls : 'icon-plugin',
		region: 'center',
		tbar : [btn_save_pwdSet,btn_reset_pwdSet],
		items: [userPwdViewForm]
	}]
};
