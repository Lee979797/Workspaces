var Users = new Ext.data.JsonReader({root:'root'},[
    {name : 'userId',type : 'int'}, 
	{name : 'emplNo',type : 'string'}, 
	{name : 'mobilePhone',type : 'string'}, 
	{name : 'sex',type : 'string'}, 
	{name : 'useUpPageSize',type : 'int'}, 
	{name : 'useDownPageSize',type : 'int'}, 
	{name : 'useFullPageSize',type : 'int'}
]);

var configSetForm = new Ext.FormPanel({
	url : 'midifyUser.action',
	labelAlign : 'right',
	labelWidth : 120,
	bodyStyle : 'padding:5px',
	border : false,
	baseCls : 'x-plain',
	waitMsgTarget: true,
	layout: 'fit',
	defaults : {anchor:'100%'},
	items : [{
                xtype:'fieldset',
	            title: '个人信息设置',
	            collapsible: true,
	            autoHeight:true,
	            defaults: {width: 230},
	            defaultType: 'textfield',
                items: [
						   {xtype : 'textfield',fieldLabel : '用户ID',name : 'userName',value:currentZzUsername,allowBlank:false,readOnly:true},
						   {xtype : 'textfield',fieldLabel : '用户名',name : 'emplName',value:currentZzUser,allowBlank:false,readOnly:true},
						   {xtype : 'combo',
								fieldLabel : '性别',
								name:'fmtype',
								displayField : 'sex',
								valueField : 'sex',
								hiddenName : 'sex',
								store :sexTypeStore,
								triggerAction : 'all',
								lazyRender:true,
								value:'',
								mode : 'local',
								selectOnFocus : true,
								editable : false
							},
						   {xtype : 'textfield',fieldLabel : '联系电话',name : 'mobilePhone'}]
		 	},{
	            xtype:'fieldset',
		 		title: '页面显示设置',
	            collapsible: true,
	            autoHeight:true,
	            defaults: {width: 230},
	            defaultType: 'textfield',
                items: [
					  {xtype : 'textfield',fieldLabel : '上栏每页条目数',name : 'useUpPageSize',xtype : 'numberfield',maxValue : 200},
					   {xtype : 'textfield',fieldLabel : '下栏每页条目数',name : 'useDownPageSize',xtype : 'numberfield',maxValue : 200},
					   {xtype : 'textfield',fieldLabel : '不分栏每页条目数',name : 'useFullPageSize',xtype : 'numberfield',maxValue : 200}]
            }]
});

       
var btn_save_configSet = new Ext.Button({
	text : '保存',
	iconCls : 'icon-ok',
	disabled:true,
	handler : btn_saveUserConfig
});


var btn_reset_configSet = new Ext.Button({
	text : '重置',
	iconCls : 'icon-refresh',
	disabled:true,
	handler:function(){
		searchUserConfigSet();
	}
});


function btn_saveUserConfig(btn){
	if (configSetForm.getForm().isValid()) {
		configSetForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在修改数据,请稍候...',
			success : function(form) {
				Ext.Msg.show({
					title : '提示',
					msg : '个人信息保存成功！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.INFO
				});
			},
			failure : function(form) {
				Ext.Msg.show({
					title : '提示',
					msg : '个人信息保存失败！',
					buttons : Ext.Msg.OK,
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

var searchUserConfigSet = function() {
	configSetForm.getForm().reader = Users;
	configSetForm.getForm().load({
		waitMsg : '正在进行数据查询，请稍等',             
		waitTitle : '提示',   
		url: 'findUserByExample.action', 
		method: 'POST', 
		params: {username:currentZzUsername,start:1,limit:1},	
		success:function(form,action) {//获取返回值
			btn_save_configSet.setDisabled(false);
			btn_reset_configSet.setDisabled(false);	
		},
		failure : function() {//出错
 				Ext.Msg.show({
					title : '提示',
					msg : '用户信息出错！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.ERROR
				});				    		
		}
	});
}

var  userConfigViewForm= new Ext.Panel({
    id          : 'pInfo',
    region      : 'center',
    margins     : '3 0 0 0',
    cmargins    : '5 5 0 0',
	autoScroll : true,
	layout: 'fit',
	border : false,
	bodyStyle: 'padding:0px',
    items : [configSetForm]
});

var p_zzUserConfigSet = {
	id : 'zzUserConfigSet-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:5px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    title: '个人设置',
	    iconCls : 'icon-plugin',
		region: 'center',
		tbar : [btn_save_configSet,btn_reset_configSet],
		items: [userConfigViewForm]
	}]
}