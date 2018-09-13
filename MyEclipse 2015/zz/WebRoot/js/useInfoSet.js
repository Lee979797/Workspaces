
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
//
var Zusers = Ext.data.JsonReader({root:'root'},[
	{name : 'userid',type : 'int'}, //
	//{name : 'xzqhName',type : 'string'}, 
	//{name : 'xzqhCode',type : 'string'},
	{name : 'pzjgmc',type : 'string'},// pzjgmc
	{name : 'pzjgdm',type : 'string'},// pzjgdm
	{name : 'orgZch',type : 'string'},//
	{name : 'orgName',type : 'string'},//   
	{name : 'orgCode',type : 'string'},// 
	//{name : 'orgType',type : 'string'}, 
	{name : 'userName',type : 'string'}, //
	//{name : 'userPwd',type : 'string'}, 
	{name : 'zjlx',type : 'string'}, //zjlx
	{name : 'name',type : 'string'}, //
	{name : 'mPhone',type : 'string'}, //
	{name : 'tel',type : 'string'}, //
	{name : 'email',type : 'string'}, //
	//{name : 'sex',type : 'string'}, 
	{name : 'address',type : 'string'},//address 
	{name : 'postalcode',type : 'string'}, //postalcode
	{name : 'sfzHao',type : 'string'}, //  
	//{name : 'msgType',type : 'int'}, 
	//{name : 'state',type : 'string'}, 
	{name : 'note',type : 'string'}//
]);

var btn_search_pzjg_zrm = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchPzjg_zrm();
		//btn_search_pzjg.setDisabled(true);
	}
});


var text_search_pzjg_zrm = new Ext.form.TextField({
	id : 'textSearchPzjg_zrm',
	name : 'textSearchPzjg_zrm',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchPzjg_zrm();
			}
		},
		'change' : function(field, e) {
			btn_search_pzjg_zrm.setDisabled(false);
		}
	}
});


var cm_pzjg_zrm = new Ext.grid.ColumnModel([
	{header : '批准机构名称',width : 50,dataIndex : 'pzjgmc',sortable : true}, 
	{header : '批准机构代码',width : 20,dataIndex : 'pzjgdm',sortable : true},
	{header : '备注',width : 30,dataIndex : 'note',sortable : true}
]);


//查询返回结果的数据列
var ds_pzjg_zrm = new Ext.data.Store({
	url : 'findAllByConditionPzjg.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'pzjgid',type : 'int'}, 
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		{name : 'note',type : 'string'}
	])
});

var searchPzjg_zrm = function() {
	ds_pzjg_zrm.baseParams.conditions = text_search_pzjg_zrm.getValue();
	ds_pzjg_zrm.baseParams.username=currentUsername;
	ds_pzjg_zrm.baseParams.stateConditions='';
	ds_pzjg_zrm.load({params : {start : 0,limit : 20} });
}

var grid_pzjg_zrm = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_pzjg_zrm,
	ds : ds_pzjg_zrm,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入登记批准机构名称：',text_search_pzjg_zrm,btn_search_pzjg_zrm],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_pzjg_zrm,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_pzjgQuery_zrm.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			zuserEditForm.getForm().findField('select_pzjgmc_zrm').setValue(selections[0].get('pzjgmc'));
			zuserEditForm.getForm().findField('select_pzjgdm_zrm').setValue(selections[0].get('pzjgdm'));
		}
	}
});

var window_pzjgQuery_zrm = new Ext.Window({
	title : '登记批准机构查询',
	iconCls : 'icon-plugin',
	width :500,
	height:400,
	//plain    : true,
	layout   : 'border',
	resizable : false,
	modal : true,
	resizable : true, 
	maximizable:true,
	closeAction : 'hide',
	items : [grid_pzjg_zrm]
});
//--------------------修改用户信息-------------------------------------------
var zuserEditForm = new Ext.FormPanel({
	loadMask : {
		msg : '数据加载中...'
	},
	url : 'updateZuser.action',
	labelAlign : 'right',
	labelWidth : 90,
	bodyStyle : 'padding:5px',
	plain: true,
	border : false,
	baseCls : 'x-plain',
	waitMsgTarget: true,autoScroll : true,layout: 'fit',
	items : [{//第1行修改
		layout:'column',
        border:false,
        autoScroll : true,
        baseCls : 'x-plain',
        bodyStyle:'padding:10px',
		items : [{
			columnWidth : 1,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '48%'},
			items : [{xtype : 'hidden',name : 'userid'},
			         {fieldLabel : '用户名',	name : 'userName',readOnly:true}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '96%'},
			items :[{fieldLabel : '机构名称',id:'orgName',name:'orgName',allowBlank : false,maxLength : 100}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '96%'},
			items :[{fieldLabel : '机构代码',name:'orgCode',vtype:'alphanum',vtypeText:'不是有效的机构代码格式',maxLength : 9,minLength : 9}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '96%'},
			items :[new Ext.form.TriggerField({
				id:"select_pzjgmc_zrm",
				name:"pzjgmc",
				fieldLabel:"批准机构名称",
			 	valueField : "pzjgmc",
			    displayField : "pzjgmc",
			    //readOnly:'true',
			    maxLength : 80,
			    haveShow : false,
			    editable : false,
			    allowBlank : false,
			    onTriggerClick : function() {
			    	window_pzjgQuery_zrm.show();
			    }
		    })]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '96%'},
			items :[{id:"select_pzjgdm_zrm",fieldLabel : '批准机构代码',name:'pzjgdm',allowBlank : false}]
		},{
			columnWidth : 1,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '97.9%'},
			items :[{fieldLabel : '批准注册号',name:'orgZch',allowBlank : false,maxLength : 50}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '96%'},
			items :[{fieldLabel : '法人姓名',name:'name',maxLength : 25}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '96%'},
			items :[{
				xtype : 'combo',
				fieldLabel : '法人证件类型',
				id : 'zjlx_zrm',
				name:'zjlx',
				hiddenName : 'zjlx',
				valueField : 'categoryName',
				displayField : 'categoryName',
				mode : 'remote',
				store : ds_zjlx_select,
				selectOnFocus : true,
				editable : false,
				readOnly:true,
				maxLength : 25,
				//onTriggerClick : Ext.emptyFn,
				triggerAction : 'all',
				loadingText : '加载中...',
				listeners : {
					'select' : function(combo, record, index) {
						//orgnewAuditForm.findField('zjlx').setValue(record.data.categoryName);
					}
				}
			}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '96%'},
			items :[{fieldLabel : '证件号码',name:'sfzHao',maxLength : 18}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '96%'},
			items :[{fieldLabel : '联系地址',name:'address',allowBlank : true,maxLength : 100}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '96%'},
			items :[{fieldLabel : '邮政编码',name : 'postalcode',allowBlank : true,maxLength : 6}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '96%'},
			items :[{fieldLabel : '联系电话',name:'tel',allowBlank : true,maxLength : 25}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '96%'},
			items :[{fieldLabel : '手机号码',name:'mPhone',allowBlank : true,maxLength : 12}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '96%'},
			items :[{fieldLabel : '电子邮件',name:'email',allowBlank : true,vtype:'email',vtypeText:'不是有效的邮箱地址',maxLength : 40}]
		},{//表单修改
			columnWidth : 1,
			baseCls : 'x-plain',
			border : false,
			layout : 'form',
			defaultType : 'textarea',
			defaults : {anchor:'97.6%'},
			items : [{fieldLabel : '备注',name : 'note',maxLength : 500}]
		}]
	}]
});

var searchUserInfo = function(){
	/*zuserEditForm.getForm().reader = Zusers;
	zuserEditForm.getForm().load({
	    url : 'findUserInfo.action',
		params : {username:currentUsername},
	    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
	    waitTitle: '提示',
	    waitMsg: '数据正在加载中，请稍后',
	    success:function(result,request) {//获取返回值form,action
			alert("进了");
			var tab21=Ext.getCmp("uInfo");
			tab21.setTitle("基本信息已录入");	
			
		},
		failure : function() {
			Ext.Msg.show({
				title : '提示',
				msg : '加载用户信息错误',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR
			});
		}
	});
	*/
	Ext.Ajax.request({
		url : 'findUserInfo.action',
		params : {username:currentUsername},
		method:'post', 
		waitTitle: '提示',
	    waitMsg: '数据正在重新加载中，请稍后',
		success : function(result,request) {//获取返回值
		    eval("var data = "+ result.responseText);
		    zuserEditForm.getForm().findField("userid").setValue(data.root[0].userid);
		    zuserEditForm.getForm().findField("userName").setValue(data.root[0].userName);
		    zuserEditForm.getForm().findField("orgName").setValue(data.root[0].orgName);
		    zuserEditForm.getForm().findField("orgCode").setValue(data.root[0].orgCode);
		    zuserEditForm.getForm().findField("pzjgmc").setValue(data.root[0].pzjgmc);
		    zuserEditForm.getForm().findField("pzjgdm").setValue(data.root[0].pzjgdm);
		    zuserEditForm.getForm().findField("orgZch").setValue(data.root[0].orgZch);
		    zuserEditForm.getForm().findField("name").setValue(data.root[0].name);
		    zuserEditForm.getForm().findField("zjlx").setValue(data.root[0].zjlx);
		    zuserEditForm.getForm().findField("sfzHao").setValue(data.root[0].sfzHao);
		    zuserEditForm.getForm().findField("address").setValue(data.root[0].address);
		    zuserEditForm.getForm().findField("postalcode").setValue(data.root[0].postalcode);
		    zuserEditForm.getForm().findField("tel").setValue(data.root[0].tel);
		    zuserEditForm.getForm().findField("mPhone").setValue(data.root[0].MPhone);
		    zuserEditForm.getForm().findField("email").setValue(data.root[0].email);
		    zuserEditForm.getForm().findField("note").setValue(data.root[0].note);
		    
		},
		failure : function() {
			Ext.Msg.show({
				title : '提示',
				msg : '加载用户信息错误',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR
			});
		}
	});
	
}


        
var btn_save_infoSet = new Ext.Button({
	text : '保存',
	iconCls : 'icon-yes',
	handler : btn_saveInfo
});

var btn_reset_pwdSet = new Ext.Button({
	text : '取消',
	iconCls : 'icon-refresh',
	handler:function(){
			zuserEditForm.getForm().reset();
	}
});

function btn_saveInfo(btn){
	if (zuserEditForm.getForm().isValid()) {
		zuserEditForm.getForm().submit({
			waitTitle : '请稍候',
			waitMsg : '正在修改数据,请稍候...',
			success : function(form) {
					Ext.Msg.show({
						title : '提示',
						msg : '['+Ext.get("orgName").dom.value+'] 信息保存成功',
						buttons : Ext.Msg.OK,
						fn : function() {btn.enable();},
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
			msg : '用户信息填写不完整！<br><br>显示为红色的输入框为错误输入项',
			buttons : Ext.Msg.OK,
			fn : function() {btn.enable();},
			icon : Ext.Msg.ERROR
		});
	}
}
var  uInfoViewForm= new Ext.Panel({
    title       : '基本信息',
    id          : 'uInfo',
    region      : 'center',
    margins     : '3 0 0 0',
    cmargins    : '5 5 0 0',
	autoScroll : true,
	layout: 'fit',
	bodyStyle: 'padding:0px',
    items : [zuserEditForm]
});


var p_useInfoSet = {
	id : 'useInfoSet-panel',
	border : false,
	layout : 'border',
	bodyStyle: 'padding:0px',
	items : [{
		id:'border-panel',
	    layout:'border',
	    bodyBorder: true,
	    title: '用户信息',
	    iconCls : 'icon-plugin',
		region: 'center',
		plain: true,
		baseCls : 'x-plain',
		tbar : [btn_save_infoSet,btn_reset_pwdSet],
		items: [uInfoViewForm]
	}]
}