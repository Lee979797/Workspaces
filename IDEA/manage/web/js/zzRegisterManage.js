

var grid_pzjg_zrm = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_pzjg2,
	ds : ds_pzjg2,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入登记批准机构名称：',text_search_pzjg2,btn_search_pzjg2],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_pzjg2,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有记录"
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

var Zuser = Ext.data.Record.create([
	{name : 'userid',mapping : 'userid',type : 'int'}, 
	{name : 'xzqhName',mapping : 'xzqhName',type : 'string'}, 
	{name : 'xzqhCode',mapping : 'xzqhCode',type : 'string'},
	{name : 'pzjgmc',mapping : 'pzjgmc',type : 'string'},
	{name : 'pzjgdm',mapping : 'pzjgdm',type : 'string'}, 
	{name : 'orgZch',mapping : 'orgZch',type : 'string'},
	{name : 'orgName',mapping : 'orgName',type : 'string'}, 
	{name : 'orgCode',mapping : 'orgCode',type : 'string'}, 
	{name : 'orgid',mapping : 'orgid',type : 'int'}, 
	{name : 'orgType',mapping : 'orgType',type : 'string'}, 
	{name : 'userName',mapping : 'userName',type : 'string'}, 
	{name : 'userPwd',mapping : 'userPwd',type : 'string'}, 
	{name : 'name',	mapping : 'name',type : 'string'}, 
	{name : 'mPhone',mapping : 'mPhone',type : 'string'}, 
	{name : 'tel',	mapping : 'tel',type : 'string'}, 
	{name : 'email',mapping : 'email',type : 'string'},
	{name : 'address',mapping : 'address',type : 'string'},
	{name : 'postalcode',mapping : 'postalcode',type : 'string'}, 
	{name : 'sex',mapping : 'sex',type : 'string'}, 
	{name : 'sfzHao',mapping : 'sfzHao',type : 'string'}, 
	{name : 'msgType',mapping : 'msgType',type : 'int'}, 
	{name : 'state',mapping : 'state',type : 'string'}, 
	{name : 'note',	mapping : 'note',type : 'string'}
]);


//点击列表信息，显示用户的扩展属性-->
var expander30 = new Ext.grid.RowExpander({
	tpl : new Ext.Template('<p><table width="100%"  border="0" cellspacing="6" cellpadding="0" bgcolor="#DDEEF9" style="margin-top:1px;">'
			+ '<tr>'
			+ '<td width="" colspan="4">'
			+ '<table width="98%" bgcolor="#ffffff" border="1" cellpadding="0" cellspacing="0" align="center"  bordercolordark="#FFFFFF" bordercolorlight="#6EBBE1" style="margin-top:0px;>'
			+ '<tr height="22" valign="middle">'
			+ '  <td width="15%" align="right" valign="middle" nowrap="nowrap" style="padding-top:5px">用户名：</td><td width="85%" nowrap="nowrap" style="padding-top:5px" colspan="3">{userName}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" style="padding-top:5px">机构名称：</td><td nowrap="nowrap" style="padding-top:5px">{orgName}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" style="padding-top:5px">机构代码：</td><td nowrap="nowrap" style="padding-top:5px">{orgCode}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td width="15%" align="right" valign="middle" nowrap="nowrap" style="padding-top:5px">批准机构名称：</td><td nowrap="nowrap" width="38%" style="padding-top:5px">{pzjgmc}<img src="images/temp.gif"></td>'
			+ '  <td width="15%" align="right" nowrap="nowrap" style="padding-top:5px">批准机构代码：</td><td width="32%" nowrap="nowrap" style="padding-top:5px">{pzjgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" style="padding-top:5px">批准注册号：</td><td nowrap="nowrap" style="padding-top:5px">{orgZch}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" style="padding-top:5px">法定代表人/负责人姓名：</td><td nowrap="nowrap" style="padding-top:5px">{name}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '   <td align="right" nowrap="nowrap" style="padding-top:5px">法人证件类型：</td><td nowrap="nowrap" style="padding-top:5px">{zjlx}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" style="padding-top:5px">法人证件号码：</td><td nowrap="nowrap" style="padding-top:5px">{sfzHao}<img src="images/temp.gif"></td>'
			+ '</tr>'

			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" style="padding-top:5px">联系地址：</td><td nowrap="nowrap" style="padding-top:5px">{address}<img src="images/temp.gif"></td>'
			+ '   <td align="right" nowrap="nowrap" style="padding-top:5px">邮政编码：</td><td nowrap="nowrap" style="padding-top:5px">{postalcode}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" style="padding-top:5px">联系电话：</td><td nowrap="nowrap" style="padding-top:5px">{tel}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" style="padding-top:5px">手机号码：</td><td nowrap="nowrap" style="padding-top:5px">{mPhone}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" style="padding-top:5px">电子信箱：</td><td nowrap="nowrap" style="padding-top:5px">{email}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" style="padding-top:5px">提示方式：</td><td nowrap="nowrap" style="padding-top:5px">{msgType}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" style="padding-top:5px">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</td><td nowrap="nowrap" colspan="3"  style="padding-top:5px">{note}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '</table>'
			+ '</td></tr></table></p>')
});

function userState(value,p,record)
{
   var stateValue;
   stateValue=record.data["state"];
   if(typeof stateValue!=''){
	   switch (stateValue) {
		   case '0' :
			   return String.format('<font color="red">未审核</font>');
		   case '-1' :
			   return String.format('<font color="blue">已注销</font>');
		   case '-2' :
			   return String.format('<font color="DarkBlue">审核未通过</font>');
		   default :
			   return String.format('<font color="green">审核通过</font>');
	   } 
   }
}
   
//列表显示用户主要信息//
var sm20 = new Ext.grid.CheckboxSelectionModel();
var cm_zuser = new Ext.grid.ColumnModel([expander30,
	sm20,
	{header : '编号',width : 70,dataIndex : 'userid',sortable : true},
    {header : '用户名',width : 70,dataIndex : 'userName',sortable : true},
	{header : '机构名称',width : 170,dataIndex : 'orgName',sortable : true}, 
	{header : '机构代码',width : 170,dataIndex : 'orgCode',sortable : true},
	{header : '联系电话',width :70,dataIndex : 'tel',menuDisabled : true}, 
	{header : '当前状态',width : 60,dataIndex : 'state',renderer : userState,	menuDisabled : true}, 
	{header : '备注',	width : 50,dataIndex : 'note',id : 'note',sortable : true}
]);


//--------------------修改用户信息-------------------------------------------
var zuserEditForm = new Ext.FormPanel({
	loadMask : {
		msg : '数据加载中...'
	},
	url : 'updateZuser.action',
	labelAlign : 'right',
	labelWidth : 90,
	bodyStyle : 'padding:5px',
	border : false,
	autoHeight : true,
	autoScroll : true, 
	baseCls : 'x-plain',
	waitMsgTarget: true,
	items : [{//第1行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : 1,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [{xtype : 'hidden',name : 'userid'},
			         {fieldLabel : '用户名',	name : 'userName',readOnly:true}]
		}]
	},{//第2行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '96%'},
			items :[{fieldLabel : '机构名称',name:'orgName',allowBlank : false,maxLength : 100}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '96%'},
			items :[{fieldLabel : '机构代码',name:'orgCode',vtype:'alphanum',vtypeText:'不是有效的机构代码格式',maxLength : 9,minLength : 9}]
		}]
	},{//第2行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
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
			items :[{id:"select_pzjgdm_zrm",fieldLabel : '批准机构代码',name:'pzjgdm',allowBlank : false,vtype:'alphanum',vtypeText:'不是有效的机构代码格式',maxLength : 9,minLength : 9}]
		}]
	},{//第3行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '96%'},
			items :[{fieldLabel : '批准注册号',name:'orgZch',allowBlank : false,maxLength : 50}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '96%'},
			items :[{fieldLabel : '法人姓名',name:'name',maxLength : 25}]
		}]
	},{//第3行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
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
		}]
	},{//第3行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
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
		}]
	},{//第3行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
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
			items :[{fieldLabel : '手机',name:'mPhone',allowBlank : true,maxLength : 12}]
		}]
	},{	layout : 'column',//第4行修改
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '96%'},
			items :[{fieldLabel : '电子邮件',name:'email',allowBlank : true,vtype:'email',vtypeText:'不是有效的邮箱地址',maxLength : 40}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '96%'},
			items :[{fieldLabel : '提示方式',name:'msgType',allowBlank : true}]
		}]
	},{//表单修改
		xtype : 'panel',
		baseCls : 'x-plain',
		bodyBorder : false,
		layout : 'form',
		defaultType : 'textarea',
		defaults : {anchor:'98%'},
		items : [{fieldLabel : '备注',name : 'note',maxLength : 500}]
	}]
});

var window_editZuser = new Ext.Window({
	title : '用户信息--修改',
	width : 500,
	height : 400,
	resizable : true,
	//autoHeight : true,
	closeAction : 'hide',
	modal : true,
	buttonAlign : 'center',
	minButtonWidth : 60,
	maximizable:true,
	items : [zuserEditForm],
	buttons : [{   
        text: '前一条', 
        id:'btn1',
        handler: function(btn1) {
        	 var grid_ = grid_registerManage;
             var selModel = grid_.getSelectionModel();
             if(selModel.hasPrevious()){
                selModel.selectPrevious();
                //btn2.enable();
                //grid_registerManage.getSelectionModel().selectNext();
         		var record = grid_registerManage.getSelectionModel().getSelected();
         		if(record){
         			//store.remove(grid_registerManage.getSelectionModel().getSelected());
                 	//var next = grid_registerManage.selectNext(); 
                 	//if(next){grid_registerManage.getSelectionModel().selectRecords([next]);}
         			//window_edit_dfileManage.show();
         			zuserEditForm.getForm().loadRecord(record);
         		}
             }else{
            	 Ext.Msg.show({
					title : '提示',
					msg : '已经到第一条,请翻页!',
					buttons : Ext.Msg.OK,
					fn : function(){btn1.enable();},
					icon : Ext.Msg.INFO
				});
             }
        }   
    },{   
        text: '下一条', 
        id:'btn2',
        handler: function(btn2) {
        	 var grid_ = grid_registerManage;
             var selModel = grid_.getSelectionModel();
             if(selModel.hasNext()){
                selModel.selectNext();
                //btn1.enable();
                //grid_registerManage.getSelectionModel().selectNext();
         		var record = grid_registerManage.getSelectionModel().getSelected();
         		if(record){
         			//store.remove(grid_registerManage.getSelectionModel().getSelected());
                 	//var next = grid_registerManage.selectNext(); 
                 	//if(next){grid_registerManage.getSelectionModel().selectRecords([next]);}
         			//window_edit_dfileManage.show();
         			zuserEditForm.getForm().loadRecord(record);
         		}
             }else{
            	 Ext.Msg.show({
 					title : '提示',
 					msg : '已经到最后一条,请翻页!',
 					buttons : Ext.Msg.OK,
 					fn : function(){btn2.enable();},
 					icon : Ext.Msg.INFO
 				});
               
             }
        }   
    },{
		text : '保存',
		handler : function(btn){
			if (zuserEditForm.getForm().isValid()) {
				btn.disable();
				zuserEditForm.getForm().submit({
					waitTitle : '请稍候',
					waitMsg : '正在修改数据,请稍候...',
					//url : 'updateZuser.action', 
			        //method : 'POST',
					success : function(form,action) {
						Ext.Msg.show({
							title : '成功提示',
							msg : '数据修改成功!',
							buttons : Ext.Msg.OK,
							fn : function(){btn.enable();},
							icon : Ext.Msg.INFO
						});
					
						var zuser_store = grid_registerManage.getStore();
						var zuser = new Zuser({
							userid : form.findField('userid').getValue(),
							userName : form.findField('userName').getValue(),
							orgName : form.findField('orgName').getValue(),
							orgCode : form.findField('orgCode').getValue(),
							pzjgmc : form.findField('pzjgmc').getValue(),
							pzjgdm : form.findField('pzjgdm').getValue(),
							orgZch : Ext.get('orgZch').dom.value,
							name : form.findField('name').getValue(),
							zjlx : form.findField('zjlx').getValue(),
							sfzHao : form.findField('sfzHao').getValue(),
							address : form.findField('address').getValue(),
							postalcode : form.findField('postalcode').getValue(),
							mPhone : form.findField('mPhone').getValue(),
							tel : form.findField('tel').getValue(),
							email : form.findField('email').getValue(),
							msgType : form.findField('msgType').getValue(),
							note : form.findField('note').getValue()
						});
						var index = zuser_store.indexOf(grid_registerManage.getSelectionModel().getSelected());
						zuser_store.remove(grid_registerManage.getSelectionModel().getSelected());
						zuser_store.insert(index,zuser);
						grid_registerManage.getSelectionModel().selectRow(index);
					},
					failure : function(form,action) {
						Ext.Msg.show({
							title : '错误提示',
							msg : '数据保存失败!',
							buttons : Ext.Msg.OK,
							fn : function() {btn.enable();},
							icon : Ext.Msg.ERROR
						});
					}
				});
			}
		}
	},{   
        text: '审核通过',   
        handler : function(){
    		var record = grid_registerManage.getSelectionModel().getSelected();
    		if(record){
    			var userid = record.data.userid;
    			var resultObject = null;
    			ajaxLoadMask.show();
    			Ext.Ajax.request({
    				url: 'returnZuserOk.action',
       				success: function(result,request){
       					ajaxLoadMask.hide();
       					var resultObject = Ext.util.JSON.decode(result.responseText);  
       	   			    if(resultObject.success){
	       					Ext.Msg.show({
	    						title : '提示',
	    						msg : '“用户”审核通过!',
	    						buttons : Ext.Msg.OK,
	    						icon : Ext.Msg.INFO,
	    						fn : function(){
	    							record.set('state','1');
	    							grid_registerManage.fireEvent('rowclick',grid_registerManage,grid_registerManage.getStore().indexOf(record));
	    						}
	    					});
       					}else{
       						ajaxLoadMask.hide();
       						Ext.Msg.show({
	    						title : '提示',
	    						msg : '“用户”已审核!',
	    						buttons : Ext.Msg.OK,
	    						icon : Ext.Msg.INFO,
	    						fn : function(){
	    							record.set('state','1');
	    							grid_registerManage.fireEvent('rowclick',grid_registerManage,grid_registerManage.getStore().indexOf(record));
	    						}
	    					});
       						
       					}
       				},
       				failure: function(){
       					Ext.Msg.show({
    						title : '提示',
    						msg : '此用户审核操作失败!',
    						buttons : Ext.Msg.OK,
    						icon : Ext.Msg.ERROR
    					});
       				},
       				params: {userid: userid}
    			});
    		}
    	}   
    },{   
        text: '审核驳回',   
        handler : function(){
    		var record = grid_registerManage.getSelectionModel().getSelected();
    		if(record){
    			ajaxLoadMask.show();
    			var userid = record.data.userid;
    			Ext.Ajax.request({
    				url: 'returnZuserNo.action',
       				success: function(){
       					ajaxLoadMask.hide();
       					Ext.Msg.show({
    						title : '提示',
    						msg : '驳回成功!',
    						buttons : Ext.Msg.OK,
    						icon : Ext.Msg.INFO,
    						fn : function(){
    							grid_registerManage.getStore().remove(record);
    							
    						}
    					});
       				},
       				failure: function(){
       					ajaxLoadMask.hide();
       					Ext.Msg.show({
    						title : '提示',
    						msg : '驳回失败!',
    						buttons : Ext.Msg.OK,
    						icon : Ext.Msg.ERROR
    					});
       				},
       				params: { userid: userid}
    			});
    		}
    	}   
    },{   
        text: '退出',   
        handler: function() {   
        	window_editZuser.hide(); 
        	//this.ownerCt.ownerCt.hide();
        }   
    }]
});

var btn_return_zuser_ok = new Ext.Button({
	text : '审查通过',
	iconCls : 'icon-ok',
	disabled:true,
	hidden:true,
	handler : function(){
		var record = grid_registerManage.getSelectionModel().getSelected();
		if(record){
			ajaxLoadMask.show();
			var userid = record.data.userid;
			Ext.Ajax.request({
				url: 'returnZuserOk.action',
   				success: function(result,request){
   					ajaxLoadMask.hide();
   					var resultObject = Ext.util.JSON.decode(result.responseText);  
   					//alert(resultObject.success);
   					if(resultObject.success){
       					Ext.Msg.show({
    						title : '提示',
    						msg : '“用户”审核通过!',
    						buttons : Ext.Msg.OK,
    						icon : Ext.Msg.INFO,
    						fn : function(){
    							record.set('state','1');
    							grid_registerManage.fireEvent('rowclick',grid_registerManage,grid_registerManage.getStore().indexOf(record));
    						}
    					});
   					}else{
   						Ext.Msg.show({
    						title : '提示',
    						msg : '“用户”已审核!',
    						buttons : Ext.Msg.OK,
    						icon : Ext.Msg.INFO,
    						fn : function(){
    							record.set('state','-2');
    							grid_registerManage.fireEvent('rowclick',grid_registerManage,grid_registerManage.getStore().indexOf(record));
    						}
    					});
   						
   					}
   				},
   				failure: function(){
   					ajaxLoadMask.hide();
   					Ext.Msg.show({
						title : '提示',
						msg : '此用户审核操作失败!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
   				},
   				params: {userid: userid}
			});
		}
	}
});

var btn_return_zuser_no = new Ext.Button({
	text : '审查驳回',
	iconCls : 'icon-put',
	hidden:true,
	disabled:true,
	handler : function(){
		var record = grid_registerManage.getSelectionModel().getSelected();
		if(record){
			ajaxLoadMask.show();
			var userid = record.data.userid;
			Ext.Ajax.request({
				url: 'returnZuserNo.action',
   				success: function(){
   					ajaxLoadMask.hide();
   					Ext.Msg.show({
						title : '提示',
						msg : '驳回成功!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.INFO,
						fn : function(){
							//更新修改行的值
							//record.set('state',1);
							//grid_registerManage.fireEvent('rowclick',grid_registerManage,grid_registerManage.getStore().indexOf(record));
							grid_registerManage.getStore().remove(record);
							
						}
					});
   				},
   				failure: function(){
   					ajaxLoadMask.hide();
   					Ext.Msg.show({
						title : '提示',
						msg : '驳回失败!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
   				},
   				params: { userid: userid}
			});
		}
	}
});



var btn_edit_registerManage = new Ext.Button({
	text : '修改',
	iconCls : 'icon-edit',
	disabled:true,
	handler : function(){
		var record = grid_registerManage.getSelectionModel().getSelected();
		if(record){
			window_editZuser.show();
			zuserEditForm.getForm().loadRecord(record);
		}
	}
})

var btn_refresh_registerManage = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		text_search_registerManage.value='';
		SearchRegistUser();
		btn_del_registerManage.setDisabled(true);
		btn_edit_registerManage.setDisabled(true);
		btn_return_zuser_no.setDisabled(true);
		btn_return_zuser_ok.setDisabled(true);
	}
});

var btn_del_registerManage = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	disabled:true,
	handler : function() {
		var record = grid_registerManage.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该件用户?', function(btn) {
				if (btn == 'yes') {
					ajaxLoadMask.show();
					Ext.Ajax.request({
						url : 'deleteZuser.action',
						params : {userid : record.data.userid},
						success : function() {ajaxLoadMask.hide();grid_registerManage.getStore().remove(record);},
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


//默认查询 limit为显示的条数//
var SearchRegistUser = function() {
	ds_registerManage.baseParams.conditions = text_search_registerManage.getValue();
	//ds_registerManage.baseParams.currentZzUserBzjgdm = currentZzUserBzjgdm;
	ds_registerManage.load({params : {start : 0,limit : useFullPageSize}
	});
}

var ds_registerManage = new Ext.data.Store({
	url : 'findAllZuser.action?userBzjgdm='+currentZzUserBzjgdm+'&userName='+currentZzUsername,
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'userid',type : 'int'}, 
	    {name : 'xzqhCode',type : 'string'}, 
		{name : 'xzqhName',type : 'string'}, 
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'}, 
		{name : 'orgZch',type : 'string'},
		{name : 'orgName',type : 'string'}, 
		{name : 'orgCode',type : 'string'}, 
		{name : 'orgType',type : 'string'},
		{name : 'userName',type : 'string'}, 
		{name : 'userPwd',type : 'string'},
		{name : 'name',type : 'string'},
		{name : 'mPhone',type : 'string'},
		{name : 'tel',type : 'string'}, 
		{name : 'email',type : 'string'},
		{name : 'address',type : 'string'},  
		{name : 'postalcode',type : 'string'}, 
		{name : 'zjlx',type : 'string'}, 
		{name : 'sfzHao',type : 'string'},
		{name : 'msgType',type : 'string'},
		{name : 'state',type : 'string'}, 
		{name : 'note',type : 'string'}
	])
});

var btn_search_registerManage = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		text_search_registerManage.value='';
		SearchRegistUser();
		btn_del_registerManage.setDisabled(true);
		btn_edit_registerManage.setDisabled(true);
		btn_return_zuser_no.setDisabled(true);
		btn_return_zuser_ok.setDisabled(true);
	}
});



  
var text_search_registerManage = new Ext.form.TextField({
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
var grid_registerManage = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_zuser,
	ds : ds_registerManage,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'address',
	viewConfig : {forceFit : true},
	plugins : expander30,
	tbar : [btn_edit_registerManage, btn_del_registerManage,btn_refresh_registerManage,'-', btn_return_zuser_ok,btn_return_zuser_no,'->',
	        text_search_registerManage,btn_search_registerManage],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_registerManage,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowdblclick':function(grid, rowIndex){
			var record = grid_registerManage.getSelectionModel().getSelected();
			if(record){
				window_editZuser.show();
				zuserEditForm.getForm().loadRecord(record);
			}
		},
		'rowclick':function(grid,rowIndex){
			btn_edit_registerManage.setDisabled(grid.getStore().getAt(rowIndex).data.state != 0 ? false:false);
			btn_del_registerManage.setDisabled(grid.getStore().getAt(rowIndex).data.state != 0 ? true:false);
			
			btn_return_zuser_ok.setDisabled((grid.getStore().getAt(rowIndex).data.state == '0'|| grid.getStore().getAt(rowIndex).data.state =="") ? false:true);
			btn_return_zuser_no.setDisabled((grid.getStore().getAt(rowIndex).data.state == '0'|| grid.getStore().getAt(rowIndex).data.state =="") ? false:true);
		}
	}
});




var zzRegisterManage_panel = new Ext.Panel({
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
	    items : [grid_registerManage]
	}]
});
var p_zzRegisterManage = {
	id : 'zzRegisterManage-panel',
	border : false,
	layout : 'border',
	items : [zzRegisterManage_panel]
}
