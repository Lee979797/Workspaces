//******************************************************************************
//*                                                                            *
//* 第一步 、基本信息录入  *
//*                                                                            *
//******************************************************************************
//--------------------变更申请单基本信息著录-------------------------------------------

var grid_pzjg_ulim = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_pzjg,
	ds : ds_pzjg,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入登记批准机构名称：',text_search_pzjg,btn_search_pzjg],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_pzjg,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_pzjgQuery_ulim.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			orgnewInfoModifyForm.getForm().findField('select_pzjgmc_ulim').setValue(selections[0].get('pzjgmc'));
			orgnewInfoModifyForm.getForm().findField('select_pzjgdm_ulim').setValue(selections[0].get('pzjgdm'));
		}
	}
});


var window_pzjgQuery_ulim = new Ext.Window({
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
	items : [grid_pzjg_ulim]
});


var grid_jjlx_ulim = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_jjlx,
	ds : ds_jjlx,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'note',
	viewConfig : {forceFit : true},
	tbar : ['请输入企业登记注册类型名称：',text_search_jjlx,btn_search_jjlx],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_jjlx,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			window_jjlxQuery_ulim.hide();
			var selections=grid.getSelectionModel().getSelections(); 
			orgnewInfoModifyForm.getForm().findField('select_jjlxmc_ulim').setValue(selections[0].get('jjlxmc'));
			orgnewInfoModifyForm.getForm().findField('select_jjlxdm_ulim').setValue(selections[0].get('jjlxdm'));
		}
	}
});


var window_jjlxQuery_ulim = new Ext.Window({
	title : '企业登记注册类型查询',
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
	items : [grid_jjlx_ulim]
});

var orgnewInfoModifyForm = new Ext.FormPanel({
	loadMask : {
		msg : '数据加载中...'
	},
	url : 'updateOrgnew.action',
	labelAlign : 'right',
	labelWidth : 170,
	bodyStyle : 'padding:5px',
	border : false,
	//fileUpload : true,
	//autoHeight : true,
	autoScroll : true, 
	baseCls : 'x-plain',
	waitMsgTarget: true,
	items : [{//第一行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .67,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '99%'},
			items : [{fieldLabel : '机构名称',name : 'jgmc',allowBlank : false,maxLength : 100,defaults : {anchor:'99%'}}]
		},{
			columnWidth : .33,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [{fieldLabel : '机构代码',name : 'jgdm',allowBlank : false,readOnly:true,maxLength : 9,defaults : {anchor:'98%'}}]
		}]
	},{	//第二行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			layout : 'column',
			border : false,
			baseCls : 'x-plain',
			items : [{
				columnWidth : .33,
				layout : 'form',
				baseCls : 'x-plain',
				border : false,
				defaultType : 'textfield',
				defaults : {anchor : '98%'},
				items : [{fieldLabel : '法定代表人(负责人)名称',	name : 'fddbr',allowBlank : false,maxLength : 20,defaults : {anchor:'98%'}}]
			},{
				columnWidth : .34,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'textfield',
				defaults : {anchor : '98%'},
				items :[{
					xtype : 'combo',
					fieldLabel : '法定代表人(负责人)证件类型',
					id : 'zjlx_ulim',
					name:'zjlx',
					hiddenName : 'zjlx',
					valueField : 'categoryName',
					displayField : 'categoryName',
					mode : 'remote',
					store : ds_zjlx_select,
					selectOnFocus : true,
					editable : false,
					readOnly:true,
					allowBlank : false,
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
				columnWidth : .33,
				layout : 'form',
				border : false,
				baseCls : 'x-plain',
				defaultType : 'textfield',
				defaults : {anchor : '98%'},
				items :[{fieldLabel : '法定代表人(负责人)证件号码',name : 'zjhm',allowBlank : false,maxLength : 18,defaults : {anchor:'95%'}}]
			}]
		}]
	},{//第三行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
				layout : 'column',
				border : false,
				baseCls : 'x-plain',
				items : [{
					columnWidth : 1,
					layout : 'form',
					baseCls : 'x-plain',
					border : false,
					defaultType : 'textarea',
					defaults : {anchor : '99%',height:'50'},
					items : [{fieldLabel : '经营或业务范围',name : 'jyfw',allowBlank : false,maxLength : 240,defaults : {anchor:'100%'}}]
				}]
		}]
	},{//第四行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[
		        new Ext.form.DateField({  
                id:'zcrq_ulim',
                name: 'zcrq',
                format:'Y-m-d',
                maxValue:myDate,  
                maxText:'所选日期应在{0}之前',  
                minValue:'01/01/1949',
                minText:'所选日期应在{0}之后',
                width:150,
                allowBlank : false,
                fieldLabel:'成立日期',
                renderer:dateFormat,
                altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd'
		        }) 
		    ]
		},{
			columnWidth : .45,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [{fieldLabel : '职工人数',name : 'zgrs',xtype : 'numberfield',maxLength:2000000000}]
		},{
			columnWidth : .05,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'label',
			items : [{id:'ttt3',text:'(人)'}]
		}]
	},{//第五行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .5,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [
			    new Ext.form.DateField({  
                id:'zsbfrq_ulim',
                name: 'zsbfrq',
                format:'Y-m-d',
                //maxValue:myDate,  
                //maxText:'所选日期应在{0}之前',  
                minValue:'01/01/1949',
                minText:'所选日期应在{0}之后',
                width:150, 
                allowBlank : false,
                fieldLabel:'证照有效开始日期',
                renderer:dateFormat,
                altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd'
		        }) 
			]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [
				new Ext.form.DateField({  
			    id:'zszfrq_ulim',
			    name: 'zszfrq',
			    format:'Y-m-d',
			    //maxValue:myDate,  
			    //maxText:'所选日期应在{0}之前',  
			    minValue:'01/01/1949',
			    minText:'所选日期应在{0}之后',
			    width:150,  
			    fieldLabel:'证照有效终止日期',
			    renderer:dateFormat,
			    altFormats :'m/d/Y|m-d-y|m-d-Y|m/d|m-d|d|Ymd'
			    })   
			]
		}]
	},{//第五行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [new Ext.form.TriggerField({
				id:"select_jjlxmc_ulim",
				name:"jjlx",
				fieldLabel:"企业登记注册类型",
			 	valueField : "jjlx",
			    displayField : "jjlx",
			    //readOnly:'true',
			    maxLength : 50,
			    allowBlank : false,
			    haveShow : false,
			    editable : false,
			    onTriggerClick : function() {
			    	window_jjlxQuery_ulim.show();
			    }
		    })]
		},{
			columnWidth : .5,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [{xtype : 'combo',
				fieldLabel : '外商投资国别或地区',
				id : 'wftzgb_ulim',
				//name:'hbzldm', //接收值的名称
				
				displayField : 'categoryName',//显示值的名称
				hiddenName : 'wftzgb',//真正提交时此combo的name
				valueField : 'categoryCode',//真正提交时此combo的value
				mode : 'remote',
				store : ds_wftzgb_select,
				maxLength : 50,
				selectOnFocus : true,
				editable : false,
				triggerAction : 'all',
				loadingText : '加载中...',
				listeners : {
					'select' : function(combo, record, index) {
						//alert("名称："+Ext.get("wftzgb_ulim").dom.value);   
						//alert("代码："+this.getValue());
						orgnewInfoModifyForm.getForm().findField('_wftzgb').setValue(Ext.get("wftzgb_ulim").dom.value);
						orgnewInfoModifyForm.getForm().findField('_wftzgbdm').setValue(this.getValue());
					}
				}
			}]
		}]
	},{//第六行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .45,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [{fieldLabel : '注册(开办)资金',xtype : 'numberfield',name : 'zczj',maxValue : 2000000000}]
		},{
			columnWidth : .05,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'label',
			items : [{id:'sss3',text:'(万元)'}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[{xtype : 'combo',
				fieldLabel : '货币种类',
				id : 'hbzl_ulim',
				//name:'hbzldm', //接收值的名称
				
				displayField : 'categoryName',//显示值的名称
				hiddenName : 'hbzl',//真正提交时此combo的name
				valueField : 'categoryCode',//真正提交时此combo的value
				mode : 'remote',
				store : ds_hbzl_select,
				maxLength : 50,
				selectOnFocus : true,
				editable : false,
				triggerAction : 'all',
				loadingText : '加载中...',
				listeners : {
					'select' : function(combo, record, index) {
						//alert("名称："+Ext.get("hbzl_ulim").dom.value);   
						//alert("代码："+this.getValue());
						orgnewInfoModifyForm.getForm().findField('_hbzl').setValue(Ext.get("hbzl_ulim").dom.value);
						orgnewInfoModifyForm.getForm().findField('_hbzldm').setValue(this.getValue());
					}
				}
			}]
		}]
	},{//第六行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[{fieldLabel : '主管部门名称',name : 'zgmc',maxLength : 80}]
		},{
			columnWidth : .5,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [{fieldLabel : '主管部门代码',name : 'zgdm',vtype:'alphanum',vtypeText:'不是有效的机构代码格式',maxLength : 9,minLength : 9}]
		}]
	},{//第六行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[new Ext.form.TriggerField({
				id:"select_pzjgmc_ulim",
				name:"pzjgmc",
				fieldLabel:"登记批准机构名称",
			 	valueField : "pzjgmc",
			    displayField : "pzjgmc",
			    //readOnly:'true',
			    maxLength : 80,
			    haveShow : false,
			    editable : false,
			    allowBlank : false,
			    onTriggerClick : function() {
			    	window_pzjgQuery_ulim.show();
			    }
		    })]
		},{
			columnWidth : .5,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [{id:"select_pzjgdm_ulim",fieldLabel : '登记批准机构代码',vtype:'alphanum',vtypeText:'不是有效的机构代码格式',allowBlank : false,name : 'pzjgdm',maxLength : 9,minLength : 9}]
		}]
	},{//第六行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[{fieldLabel : '批准文号(注册号)',name : 'zch',allowBlank : false,maxLength : 31}]
		},{
			columnWidth : .5,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [{fieldLabel : '邮政编码',name : 'yzbm',maxLength : 6}]
		}]
	},{	//第六行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[{fieldLabel : '机构地址',name : 'jgdz',allowBlank : false,maxLength : 100,defaults : {anchor:'98%'}}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[{	
				xtype : 'combo',
				fieldLabel : '行政区划',
				id : 'xzqh_ulim',
				name : 'xzqhName',  //接收值的名称
				displayField : 'xzqhName', //显示值的名称
				hiddenName : 'xzqhName', //真正提交时此combo的name
				valueField : 'xzqhCode',  //真正提交时此combo的value
				maxLength : 50,
				allowBlank : false,
				mode : 'remote',
				store : new Ext.data.Store({
					//autoLoad : true,
					proxy : new Ext.data.HttpProxy({
						url : 'findAllXzqh.action'
					}),
					reader : new Ext.data.JsonReader({
						root : 'root'
					}, [{name : 'xzqhCode',type : 'string'},
						{name : 'xzqhName',type : 'string'},
						{name : 'xzqhNote',type : 'string'}
					])
				}),
				selectOnFocus : true,
				editable : false,
				triggerAction : 'all',
				loadingText : '加载中...',
				listeners : {
					'select' : function(combo, record, index) {
						//alert("名称："+Ext.get("xzqh_ulim").dom.value);   
						///alert("代码："+this.getValue());
						orgnewInfoModifyForm.getForm().findField('_xzqhName').setValue(Ext.get("xzqh_ulim").dom.value);
						orgnewInfoModifyForm.getForm().findField('_xzqhCode').setValue(this.getValue());
					}
				}
			}]
		}]
	},{	//第六行修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[{fieldLabel : '固定电话号码',name : 'dhhm',maxLength : 21}]
		},{
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items :[{fieldLabel : '移动电话',name : 'mobile',maxLength : 25}]
		}]
	},{ //表单修改
		layout : 'column',
		border : false,
		baseCls : 'x-plain',
		items : [{
			columnWidth : .5,
			layout : 'form',
			baseCls : 'x-plain',
			border : false,
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [
				{fieldLabel : '机构网址',name : 'weburl',maxLength : 50},
				 {fieldLabel : '经办人名称',name : 'tbrxm',allowBlank : false,maxLength : 25},
				{	xtype : 'combo',
					fieldLabel : '经办人证件类型',
					id : 'memo_ulim',
					name:'memo',
					hiddenName : 'memo',
					valueField : 'categoryName',
					displayField : 'categoryName',
					mode : 'remote',
					maxLength : 25,
					store : ds_zjlx_select,
					selectOnFocus : true,
					editable : false,
					allowBlank : false,
					triggerAction : 'all',
					loadingText : '加载中...',
					listeners : {
						'select' : function(combo, record, index) {
							//this.ownerCt.ownerCt.ownerCt.form.findField('book.categoryName').setValue(record.data.categoryName);
						}
					}},
				{xtype : 'hidden',	name : 'orgid',id:'orgid'},
				{xtype : 'hidden',	name : 'orderid',id:'orderid'},
				{xtype : 'hidden',name : 'xzqhName'}, 
				{xtype : 'hidden',name : 'imageUrl'}
			]
		}, {//表单修改
			columnWidth : .5,
			layout : 'form',
			border : false,
			baseCls : 'x-plain',
			defaultType : 'textfield',
			defaults : {anchor : '98%'},
			items : [
			    {fieldLabel : '电子邮箱',name : 'email',vtype:'email',vtypeText:'不是有效的邮箱地址',maxLength : 40},
			    {fieldLabel : '经办人电话',name : 'tbrlxfs',allowBlank : false,maxLength : 25},
			    {fieldLabel : '经办人证件号码',name : 'tbrsfzh',allowBlank : false,maxLength : 18},
			    {id:"select_jjlxdm_ulim",xtype : 'hidden',name : 'jjlxdm'},
			    {xtype : 'hidden',name : '_xzqhName',maxLength : 25},
			    {xtype : 'hidden',name : '_xzqhCode',maxLength : 25},
			    {xtype : 'hidden',name : '_wftzgb',maxLength : 25},
			    {xtype : 'hidden',name : '_wftzgbdm',maxLength : 25},
			    {xtype : 'hidden',name : '_hbzl',maxLength : 25},
			    {xtype : 'hidden',name : '_hbzldm',maxLength : 25},
				{xtype : 'hidden',name : 'lastdate',value :myDate.format('Y-m-d')}, 
				{xtype : 'hidden',name : 'xgr',value:currentUser},
				{xtype : 'hidden',name : 'state'},
				{xtype : 'hidden',name : 'newYwlx',value:'变更'},
				{xtype : 'hidden',name : 'newState',value:20}
			]
		}]
	}],
	buttonAlign : 'center',
	minButtonWidth : 60,
	buttons : [{
		text : '保存',
		id:'infoModify_bc',
		name:'infoModify_bc',
		disabled:false,
		hidden:false,
		handler : function(btn){
			if (orgnewInfoModifyForm.getForm().isValid()) {
				btn.disable();
				orgnewInfoModifyForm.getForm().submit({
					waitTitle : '请稍候',
					waitMsg : '正在保存信息,请稍候...',
					success : function(form,action) {
						Ext.Msg.show({
							title : '提示',
							msg : '【' + form.findField('jgmc').getValue() + '】“变更申请单”保存成功！<br><br>&nbsp;下一步,进入“打印申请单”！',
							buttons : Ext.Msg.OK,
							fn : function(){
								btn.enable();
								var tab3=Ext.getCmp("centerPanel3");
								tab3.setActiveTab("InfoModifyPtTab");
								
								var tab31=Ext.getCmp("InfoModifyTab");
								tab31.setTitle("第一步、变更信息录入(已保存)");	
								
								
								
							},
							icon : Ext.Msg.INFO
						});
					},
					failure : function(form, action) {
						Ext.Msg.show({
							title : '提示',
							msg : '数据保存失败',
							buttons : Ext.Msg.OK,
							fn : function() {btn.enable();},
							icon : Ext.Msg.ERROR
						});
					}
				});
			}
		}
	},{
		text : '重置',
		id:'infoModify_cz',
		name:'infoModify_cz',
		disabled:false,
		hidden:false,
		handler :function() {
			orgnewInfoModifyForm.getForm().reader = Orgnews;
			orgnewInfoModifyForm.getForm().load({
			    url: 'findUsernameOrgnew.action?username='+currentUsername+'&stateConditions=100,20,23', //请求控制器获取数据
			    //url: 'findUsernameOrgnew2.json',
			    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
			    waitTitle: '提示',
			    waitMsg: '数据正在加载中，请稍后',
			    success:function(form,action){
			    	var resultObject821 = Ext.util.JSON.decode(action.responseText);
   					//alert("pageTypeStr="+resultObject82.root[0].pageTypeStr);
			    	//var dt = new Date().add(Date.DAY,new Number(record.data.loanDays));
		    		//loanLogForm.getForm().findField('_preReturnTime').setValue(dt.format('Y-m-d'));
		    		//loanLogForm.getForm().findField('loanLog.preReturnTime').setValue(dt.);
		    		//alert(resultObject821.root[0].zcrq);
		    		//alert(action.responseText);
			    	//orgnewInfoModifyForm.getForm().findField('zcrq').setValue(resultObject821.root[0].zcrq.format('Y-m-d'));
			    }
			});
			

		}
	}]
});


var InfoModifyForm = {
		title: '请录入机构变更信息',
	    layout: 'fit',
	    frame: true,
	    id: 'InfoModify21',
	    bodyStyle: 'padding:10px;',
	    border:false,
	    items: [orgnewInfoModifyForm]
};


//******************************************************************************
//                                                                             *
// 第二步 、附件扫描上传                                                                                                                                                       *
//                                                                             *
//******************************************************************************
function GetXmlHttp()
{
	var xmlhttp=false;
	try
	{
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
	}
	catch (e)
	{
		try
		{
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		catch(E)
		{
			xmlhttp = false;
		}
	}
	
	if (!xmlhttp && typeof XMLHttpRequest!='undefined')
	{
		try
		{
			xmlhttp = new XMLHttpRequest();
		}
		catch (e)
		{
			xmlhttp=false;
		}
	}
	
	if (!xmlhttp && window.createRequest)
	{
		try
		{
			xmlhttp = window.createRequest();
		}
		catch (e)
		{
			xmlhttp=false;
		}
	}
	return xmlhttp;
}


//--------------------隐含图片信息-------------------------------------------
var imgForm = new Ext.FormPanel({
		layout : 'form',
		border : false,
		defaultType : 'hidden',
		items : [{xtype : 'hidden',name : 'imageData',id:'sImageData'},{xtype : 'hidden',name : 'orgid',id:'orgid678'},{xtype : 'hidden',name : 'pageTypeStr',id:'sPageTypeStr'}]
});

var InfoModifyScOrgnewForm = new Ext.Panel({
	//url : 'shangchuanOrgnew.action',
	//bodyStyle : 'padding:5px',
	border : false,
	items: [imgForm],
	html: '<OBJECT classid="clsid:B5306E2E-8F98-46CA-9F31-AB326B2613F1"  width=100%  height=100% align=center hspace=0 vspace=0 id="scanner82"  name="scanner82" >'
	       +'<param name="ShowCount" value="4">'
	       +'<param name="sModel" value="1">'
	       +'</OBJECT>'
});

var InfoModifyScForm = {	    
		title: '请扫描并上传申请表、审批表等资料',
	    layout: 'fit',
	    frame: true,
	    id: 'InfoModify3',
	    margins: '0 0 0 0',
	    border:false,
	    items: [InfoModifyScOrgnewForm],
		buttons: [{
		   id:'btn_lim_up',
		   name:'up_button',
		   text: '上传',   
		       handler: function(btn) {   
						var base64file;
						var packLength;
						var packCount;
						var imageCount;
						var pageTypeStr;
						var lastPack;
						var xmlhttp;
						var i;
						var pack;
						var strOrgid;
						
						
						btn.disable();
						strOrgid = currentOrgid;  //通过用户zuser session 带来的参数orgid
						
						//alert(strOrgid);
						packLength = 40960;	//定义每个包的大小40960
						//scanner82.ImageData=document.getElementById("ImageData").value;
						base64file = scanner82.ImageData;  //获取控件扫描的图片数据
						var baseSize = base64file.length;  //获取控件图片数据的64位编码的长度
						imageCount = scanner82.GetPageCount;	//获取扫描图片的页数
						pageTypeStr = scanner82.PageType;    //获取标识字符串,需要写数据库
						if(pageTypeStr!=""){
							pageTypeStr=pageTypeStr.replace(/\%/g, "|"); 
		       			}
						packCount = Math.ceil(base64file.length / packLength);	//判断需要发送数据包的个数
						if(imageCount==0 || base64file=="")   //判断如果没有扫描数据，结束处理
						{
							alert("请扫描或导入图片后，再上传！");
							btn.enable();
							return false;
						}
						
						if(scanner82.CheckOrder()!="")   //判断如果标识数据的类别是否完整
						{
							alert(scanner82.CheckOrder());
							btn.enable();
							return false;
						}
						
						scanner82.OpenProgress(packCount);  //设置上传的进度条的总进度数
						xmlhttp = GetXmlHttp(); //通过AJAX格式上传
						for(i=0; i < packCount; i++)  //分包上传
						{
								pack = base64file.substring(i * packLength, (i + 1) * packLength);  //每个数据包的文件大小
							   //pack="11111111111111111111111";
							try
							{
								//xmlhttp.open("post", "saveImageOrgnew.action?orgid="+strOrgid, false);
								xmlhttp.open("post", "saveImageOrgnew.action?orgid="+strOrgid+"&packindex="+i+"&pageTypeStr="+pageTypeStr+"&lastpack=false", false);
								xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");   //这句必须要，而且一定要放在send以前
								xmlhttp.send("imageData=" + encodeURIComponent(pack)); 
								//xmlhttp.send("imgPackData=" + pack); 
								//alert("上传返回的值"+xmlhttp.responseText);
                                 
								var objs = eval("["+xmlhttp.responseText+"]");
								//alert(objs.length); // 2
			                    //alert(objs[0].success);  // 1
			                    
								if(objs[0].success)
								{
									//scanner82.SetSendProgress(Math.ceil(i / packCount * 100));
									scanner82.Progress('上传中',i+1);
								}
								else
								{
									alert("上传失败，请重试0001。");
									//scanner82.ShowSendMsg(false);
									btn.enable();
									return false;
								}
							}
							catch(e)
							{
								alert("上传失败，请重试0002。");
								btn.enable();
								return false;
							}
						}
						scanner82.CloseProgress();
						alert("上传成功！");
						
						btn.enable();
						var tab3=Ext.getCmp("centerPanel3");
						tab3.setActiveTab("InfoModifyTjTab");
						
						return true;
		       }   
		   }]
};


//******************************************************************************
//                                                                             *
// 第三步 、变更信息提交                                                                                                                                                      *
//                                                                             *
//******************************************************************************

//------------变更信息中，查询返回结果的数据集----------
var sm32 = new Ext.grid.CheckboxSelectionModel();

var ds_orgnewInfoModify = new Ext.data.Store({
	url : 'findAllOrgnew.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'orgid',type : 'int'}, 
	    {name : 'orderid',type : 'string'},
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
		{name : 'zsbfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zszfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'jjlx',type : 'string'},
		
		{name : 'jjhymc',type : 'string'},
		{name : 'jjhydm',type : 'string'},
		{name : 'gk',type : 'string'},
		{name : 'ywlx',type : 'string'},
		
		{name : 'name',type : 'string'},
		{name : 'username',type : 'string'},
		{name : 'adudit_name',type : 'string'},
		{name : 'adudit_date',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'adudit_note',type : 'string'},
		{name : 'imageUrl',type : 'string'},
		{name : 'state',type : 'string'}
	])
});

//----------------------点击列表信息，显示图书的扩展属性----------------------
var expander_im = new Ext.grid.RowExpander({
	tpl : new Ext.Template('<table width="100%"  border="0" cellspacing="6" cellpadding="0"  bgcolor="#DDEEF9" style="margin-top:1px;" >'
			+ '<tr>'
			+ '<td width="" colspan="4">'
			+ '<table width="98%" bgcolor="#ffffff" border="1" cellpadding="0" cellspacing="0" align="center"  bordercolordark="#FFFFFF" bordercolorlight="#6EBBE1" style="margin-top:0px;>'
			+ '<tr height="22" valign="middle">'
			+ '  <td width="20%" height="22" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构名称：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgmc}<img src="images/temp.gif"></td>'
			+ '  <td width="20%" height="22" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构代码：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle" >'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构类型：</td><td nowrap="nowrap" style="padding-top:5px">{jglx}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">法定代表人：</td><td  nowrap="nowrap" style="padding-top:5px">{fddbr}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证件类型：</td><td nowrap="nowrap"  style="padding-top:5px">{zjlx}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证件号码：</td><td nowrap="nowrap"  style="padding-top:5px">{zjhm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">主要经营或业务范围：</td><td  colspan=3 style="padding-top:5px">{jyfw}<img src="images/temp.gif"></td>'
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
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">企业登记注册类型：</td><td nowrap="nowrap" style="padding-top:5px">{jjlx} {jjlxdm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">外商投资国或地区：</td><td nowrap="nowrap" style="padding-top:5px">{wftzgb} {wftzgbdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册(开办)资金：</td><td nowrap="nowrap" style="padding-top:5px">{zczj}(万)<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">货币种类：</td><td nowrap="nowrap" style="padding-top:5px">{hbzl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">主管部门及代码：</td><td nowrap="nowrap" style="padding-top:5px">{zgmc} {zgdm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">批准机构及代码：</td><td nowrap="nowrap" style="padding-top:5px">{pzjgmc} {pzjgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册文号或注册号：</td><td nowrap="nowrap" style="padding-top:5px">{zch}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">邮政编码：</td><td nowrap="nowrap" style="padding-top:5px">{yzbm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构地址：</td><td nowrap="nowrap" style="padding-top:5px">{jgdz}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">行政区划：</td><td nowrap="nowrap" style="padding-top:5px">{xzqhName} {xzqhCode}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">电话号码：</td><td nowrap="nowrap" style="padding-top:5px">{dhhm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">网址：</td><td nowrap="nowrap" style="padding-top:5px">{weburl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">手机：</td><td nowrap="nowrap" style="padding-top:5px">{mobile}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">电子信箱：</td><td nowrap="nowrap" style="padding-top:5px">{email}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人名称：</td><td nowrap="nowrap" style="padding-top:5px">{tbrxm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件类型：</td><td nowrap="nowrap" style="padding-top:5px">{memo}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件号码：</td><td nowrap="nowrap" style="padding-top:5px">{tbrsfzh}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人电话：</td><td nowrap="nowrap" style="padding-top:5px">{tbrlxfs}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经济行业：</td><td nowrap="nowrap" style="padding-top:5px">{jjhymc} {jjhydm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">是否公开：</td><td nowrap="nowrap" style="padding-top:5px">{gk}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">业务类型：</td><td nowrap="nowrap" colspan="3" style="padding-top:5px">{ywlx}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核人：</td><td nowrap="nowrap" style="padding-top:5px">{adudit_name}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核时间：</td><td nowrap="nowrap" style="padding-top:5px">{adudit_date}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核意见：</td><td  colspan=3 style="padding-top:5px">{adudit_note}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '</table>'
			+ '</td></tr></table>')
});




var btn_return_orgnewInfoModify = new Ext.Button({
	text : '提交变更',
	iconCls : 'icon-save',
	disabled:true,
	handler : function(btn){
		var record = grid_LicenseInfoModify.getSelectionModel().getSelected();
		if(record){
			var orgid = record.data.orgid;
			Ext.Ajax.request({
				url: 'returnOrgnew.action',
   				success: function(){
   					Ext.Msg.show({
						title : '提示',
						msg : '变更提交成功,等待审核!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.INFO,
						fn : function(){
							record.set('state','21');
							btn.disable();
							//record.set('currentReader',''),
							//grid_LicenseInfoModify.fireEvent('rowclick',grid_LicenseInfoModify,grid_LicenseInfoModify.getStore().indexOf(record));
							//grid_LicenseInfoModify.getStore().remove(record);
						}
	   					
					});
   					var tab3=Ext.getCmp("centerPanel3");
   					tab3.remove("InfoModifyTab");   //移除标签
					tab3.remove("InfoModifyScTab");   //移除标签
					tab3.remove("InfoModifyPtTab");   //移除标签
					//tab3.remove("InfoModifyPtTab");   //移除标签
   				},
   				failure: function(){
   					Ext.Msg.show({
						title : '提示',
						msg : '变更提交失败!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
   				},
   				params: { orgid: orgid}
			});
		}
	}
});



var btn_search_orgnewInfoModify = new Ext.Button({
	text : '查询',
	hidden:true,
	iconCls : 'icon-search',
	handler : function() {
		searchOrgnewInfoModify();
		//btn_add_orgnewInfoModify.setDisabled(false);
		//btn_edit_orgnewInfoModify.setDisabled(true);
		//btn_return_orgnewInfoModify.setDisabled(true);
	}
});

var btn_refresh_orgnewInfoModify = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchOrgnewInfoModify.value='';
		searchOrgnewInfoModify();
		btn_return_orgnewInfoModify.setDisabled(true);
//		sm32.selectRow(1);
//		var record = grid_LicenseInfoModify.getSelectionModel().getSelected();
//		if(record){
//			sm32.selectRow(1);
//			if(record.data.state=="23"){
//				var tab21=Ext.getCmp("centerPanel3");
//				tab21.add("InfoModifyPtTab");   //移除标签
//				tab21.add("InfoModifyScTab");   //移除标签
//				tab21.add("InfoModifyTab");   //移除标签
//				tab21.add("InfoModifyStateTab");   //移除标签
//			}
//		}
	}
});
    
var text_search_orgnewInfoModify = new Ext.form.TextField({
	id : 'textSearchOrgnewInfoModify',
	hidden:true,
	name : 'textSearchOrgnewInfoModify',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchOrgnewInfoModify();
			}
		}
	}
});

//--------------------- 默认查询 limit为显示的条数 ---------------------- 
var searchOrgnewInfoModify = function() {
	ds_orgnewInfoModify.baseParams.conditions = text_search_orgnewInfoModify.getValue();
	ds_orgnewInfoModify.baseParams.username=currentUsername;
	ds_orgnewInfoModify.baseParams.stateConditions='20,21,22,23,24';
	ds_orgnewInfoModify.load({params : {start : 0,limit : 10} });
};


//---------------------- 列表显示主要数据信息 -------------------------
//列表显示机构的主要信息 yangqi

var cm_orgnew = new Ext.grid.ColumnModel([expander_im,
	sm32,
	{header : '原文',width : 20,dataIndex : 'imageUrl', renderer:icon,sortable : false},
	{header : '流水号',width : 55,dataIndex : 'orderid',sortable : true}, 
	{header : '机构名称',width : 115,sortable : true,dataIndex : 'jgmc'},
	{header : '申请状态',width : 195,dataIndex : 'state',renderer : goState,menuDisabled : true}
]);


//---------------------- 加载右栏主页面   （数据列表、工具栏按钮）---------------------- 
var grid_LicenseInfoModify = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	//autoHeight : true,
	cm : cm_orgnew,
	ds : ds_orgnewInfoModify,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'state',
	viewConfig : {forceFit : true},
	plugins : expander_im,
	tbar : [btn_refresh_orgnewInfoModify,'-',btn_return_orgnewInfoModify,'->',text_search_orgnewInfoModify,
	        btn_search_orgnewInfoModify],
	bbar : new Ext.PagingToolbar({
		pageSize : 10,
		store : ds_orgnewInfoModify,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){
			if(grid.getStore().getAt(rowIndex).data.state == 22){
				//btn_edit_orgnewInfoModify.setDisabled(true);
				btn_return_orgnewInfoModify.setDisabled(true);
			}else{
				if(grid.getStore().getAt(rowIndex).data.state == 21){
					//btn_edit_orgnewInfoModify.setDisabled(true);
					btn_return_orgnewInfoModify.setDisabled(true);
				}else{
					//btn_edit_orgnewInfoModify.setDisabled(false);
					btn_return_orgnewInfoModify.setDisabled(false);
				}
			}
		}
	}
});

//******************************************************************************
//*                                                                            *
//* 第四步 、申请表打印                                                                                                                                                          *
//*                                                                            *
//******************************************************************************

//--------申请表打印中，查询返回结果的数据集---------
var ds_orgnewInfoModify2 = new Ext.data.Store({
	url : 'findAllOrgnew.action',
	reader : new Ext.data.JsonReader(
		{totalProperty : 'totalProperty',root : 'root'}, 
	   [{name : 'orgid',type : 'int'},
	    {name : 'orderid',type : 'string'},
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
		
		{name : 'jjhymc',type : 'string'},
		{name : 'jjhydm',type : 'string'},
		{name : 'gk',type : 'string'},
		
		{name : 'khyh',type : 'string'},
		{name : 'khzh',type : 'string'},
		{name : 'zsbfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zszfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'jjlx',type : 'string'},
		{name : 'ywlx',type : 'string'},
		{name : 'name',type : 'string'},
		{name : 'username',type : 'string'},
		{name : 'adudit_name',type : 'string'},
		{name : 'adudit_date',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'adudit_note',type : 'string'},
		{name : 'imageUrl',type : 'string'},
		{name : 'state',type : 'string'}
	])
});

//--------“申请表打印”中，列表显示机构的扩展属性------------
var expander_im2 = new Ext.grid.RowExpander({
	tpl : new Ext.Template('<table width="100%"  border="0" cellspacing="6" cellpadding="0"  bgcolor="#DDEEF9" style="margin-top:1px;" >'
			+ '<tr>'
			+ '<td width="" colspan="4">'
			+ '<table width="98%" bgcolor="#ffffff" border="1" cellpadding="0" cellspacing="0" align="center"  bordercolordark="#FFFFFF" bordercolorlight="#6EBBE1" style="margin-top:0px;>'
			+ '<tr height="22" valign="middle">'
			+ '  <td width="20%" height="22" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构名称：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgmc}<img src="images/temp.gif"></td>'
			+ '  <td width="20%" height="22" align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构代码：</td><td width="30%"  valign="middle" style="padding-top:5px">{jgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle" >'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构类型：</td><td nowrap="nowrap" style="padding-top:5px">{jglx}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">法定代表人：</td><td  nowrap="nowrap" style="padding-top:5px">{fddbr}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证件类型：</td><td nowrap="nowrap"  style="padding-top:5px">{zjlx}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">证件号码：</td><td nowrap="nowrap"  style="padding-top:5px">{zjhm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">主要经营或业务范围：</td><td  colspan=3 style="padding-top:5px">{jyfw}<img src="images/temp.gif"></td>'
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
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">企业登记注册类型：</td><td nowrap="nowrap" style="padding-top:5px">{jjlx} {jjlxdm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">外商投资国或地区：</td><td nowrap="nowrap" style="padding-top:5px">{wftzgb} {wftzgbdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册(开办)资金：</td><td nowrap="nowrap" style="padding-top:5px">{zczj}(万)<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">货币种类：</td><td nowrap="nowrap" style="padding-top:5px">{hbzl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">主管部门及代码：</td><td nowrap="nowrap" style="padding-top:5px">{zgmc} {zgdm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">批准机构及代码：</td><td nowrap="nowrap" style="padding-top:5px">{pzjgmc} {pzjgdm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">注册文号或注册号：</td><td nowrap="nowrap" style="padding-top:5px">{zch}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">邮政编码：</td><td nowrap="nowrap" style="padding-top:5px">{yzbm}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">机构地址：</td><td nowrap="nowrap" style="padding-top:5px">{jgdz}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">行政区划：</td><td nowrap="nowrap" style="padding-top:5px">{xzqhName} {xzqhCode}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">电话号码：</td><td nowrap="nowrap" style="padding-top:5px">{dhhm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">网址：</td><td nowrap="nowrap" style="padding-top:5px">{weburl}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">手机：</td><td nowrap="nowrap" style="padding-top:5px">{mobile}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">电子信箱：</td><td nowrap="nowrap" style="padding-top:5px">{email}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人名称：</td><td nowrap="nowrap" style="padding-top:5px">{tbrxm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件类型：</td><td nowrap="nowrap" style="padding-top:5px">{memo}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人证件号码：</td><td nowrap="nowrap" style="padding-top:5px">{tbrsfzh}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经办人电话：</td><td nowrap="nowrap" style="padding-top:5px">{tbrlxfs}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">经济行业：</td><td nowrap="nowrap" style="padding-top:5px">{jjhymc} {jjhydm}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">是否公开：</td><td nowrap="nowrap" style="padding-top:5px">{gk}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">业务类型：</td><td nowrap="nowrap" colspan="3" style="padding-top:5px">{ywlx}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核人：</td><td nowrap="nowrap" style="padding-top:5px">{adudit_name}<img src="images/temp.gif"></td>'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核时间：</td><td nowrap="nowrap" style="padding-top:5px">{adudit_date}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '<tr height="22" valign="middle">'
			+ '  <td align="right" nowrap="nowrap" bgcolor="#efefef" style="padding-top:5px">审核意见：</td><td  colspan=3 style="padding-top:5px">{adudit_note}<img src="images/temp.gif"></td>'
			+ '</tr>'
			+ '</table>'
			+ '</td></tr></table>')
});


//---------------------- 打印申请登记表 ---------------------------
function msgShow_ulim()
{
	Ext.Msg.confirm('操作提示','“变更申请表”打印完毕吗?',function(btn300){
		if('yes' == btn300){
			var tab3=Ext.getCmp("centerPanel3");
			tab3.setActiveTab("InfoModifyScTab");
		}
		btn_print_orgnewInfoModify2.setDisabled(false);	
	});	
}

var btn_print_orgnewInfoModify2 = new Ext.Button({
	text : '打印申请表',
	iconCls : 'icon-print',
	disabled:false,
	handler : function(btn){
		//Ext.MessageBox.alert("提示","test"); 
		var record2 = grid_LicenseInfoModify2.getSelectionModel().getSelected();
	    //Ext.MessageBox.alert("提示","您选择的出版号是："+record2.data.jgmc); 
		if(record2){
			var titleHTML = printStr(record2); 
			var newwin = window.open('printer.jsp', 'printWindow', 'menubar=yes,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=no,titlebar=yes,z-look=yes,menubar=yes');     
			newwin.document.write(titleHTML);     
			//newwin.document.location.reload();     
			//newwin.print(); 
			//btn.disable();
		}else{
			alert("请选择需打印的机构");
		}
	}
})


var btn_search_orgnewInfoModify2 = new Ext.Button({
	text : '查询',
	hidden:true,
	iconCls : 'icon-search',
	handler : function() {
		searchOrgnewInfoModify2();
	}
});

var btn_refresh_orgnewInfoModify2 = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		textSearchOrgnewInfoModify2.value='';
		searchOrgnewInfoModify2();
	}
});

var text_search_orgnewInfoModify2 = new Ext.form.TextField({
	id : 'textSearchOrgnewInfoModify2',
	hidden:true,
	name : 'textSearchOrgnewInfoModify2',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchOrgnewInfoModify2();
			}
		}
	}
});


//默认查询 limit为显示的条数
var searchOrgnewInfoModify2 = function() {
	ds_orgnewInfoModify2.baseParams.conditions = text_search_orgnewInfoModify2.getValue();
	ds_orgnewInfoModify2.baseParams.username=currentUsername;
	ds_orgnewInfoModify2.baseParams.stateConditions='20,21,22,23,24';
	ds_orgnewInfoModify2.load({params : {start : 0,limit : 10} });
};


//---------------------- 列表显示主要数据信息 ----------------------------------
//列表显示机构的主要信息 yangqi
var sm31 = new Ext.grid.CheckboxSelectionModel();
var cm_orgnew31 = new Ext.grid.ColumnModel([expander_im2,
	sm31,
	{header : '原文',width : 20,dataIndex : 'imageUrl', renderer:icon,sortable : false},
	{header : '流水号',width : 55,dataIndex : 'orderid',sortable : true}, 
	{header : '机构名称',width : 115,sortable : true,dataIndex : 'jgmc'},
	{header : '申请状态',width : 195,dataIndex : 'state',renderer : goState,menuDisabled : true}
]);


//加载右栏主页面   （数据列表、工具栏按钮）
var grid_LicenseInfoModify2 = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	id:'grid_LicenseInfoModify2',
	//autoHeight : true,
	cm : cm_orgnew31,
	ds : ds_orgnewInfoModify2,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	autoExpandColumn : 'address2',
	
	viewConfig : {forceFit : true},
	plugins : expander_im2,
	tbar : [btn_refresh_orgnewInfoModify2,btn_print_orgnewInfoModify2,'->',text_search_orgnewInfoModify2,
	        btn_search_orgnewInfoModify2],
	bbar : new Ext.PagingToolbar({
		pageSize : 10,
		store : ds_orgnewInfoModify2,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowclick':function(grid,rowIndex){		
			//if(grid.getStore().getAt(rowIndex).data.state == 22){
			   // btn_print_orgnewInfoModify2.setDisabled(false);	
			//}
		}
	}
});


//******************************************************************************
//*
//*   主界面                                                                                                                                                      *
//*
//******************************************************************************

var InfoModifyTjForm = {
		title: '请检查信息并提交审核',
	    layout: 'fit',
	    frame: true,
	    id: 'InfoModify4',
	    border:false,
	    items: [grid_LicenseInfoModify]   
};

var InfoModifyPtForm = {
		title: '请打印登记表',
	    layout: 'fit',
	    frame: true,
	    id: 'InfoModify5',
	    border:false,
	    items: [grid_LicenseInfoModify2]   
};



var p_useLicenseInfoModify = {
	id: 'useLicenseInfoModify-panel',
	iconCls : 'icon-plugin',
	layout : 'border',
	title: '变更申请',
	activeTab: 0,
	items:[{ 
		xtype: 'tabpanel',
		plain: true,
		region: 'center',
		margins: '5 5 5 5',
		activeTab: 0,
		layoutOnTabChange:true,
		autoDestroy: true,
		id: 'centerPanel3',
		name:'centerPanel3',
		items: [{
			title: '变更状态',
			layout: 'fit',
			id:'InfoModifyStateTab',
			layoutOnTabChange:true,
			bodyStyle: 'padding:10px;',
			html: '1、请录入机构基本信息、上传证书新办申请资料，并提交'
				+'<br>2、当前证书办理状态为'
				+'<table><tr align="center">'
				+'<td><img id=imgFlag1 src="images/jc_off.gif" /><br>录入中</td>'
				+'<td><img id=imgFlag2  src="images/jc_off.gif" /><br>已提交<td>'
				+'<td><img id=imgFlag3  src="images/jc_off.gif" /><br>待办理<td>'
				+'<td><img id=imgFlag4  src="images/jc_off.gif" /><br>完成<td>'
				+'</table>'
		},{
			title: '第一步、变更信息录入',
			layout: 'fit',
			id:'InfoModifyTab',
			layoutOnTabChange:true,
			bodyStyle: 'padding:5px;',
	        items : [InfoModifyForm],
	        listeners : {
				'activate' : function() { //标签激活后自动加载数据
					orgnewInfoModifyForm.getForm().reader = Orgnews;
					orgnewInfoModifyForm.getForm().load({
						waitMsg : '正在加载数据请稍后',          //提示信息   
			            waitTitle : '提示',                         //标题  
					    url: 'findUsernameOrgnew.action?username='+currentUsername+'&stateConditions=100,20,23', //请求控制器获取数据
					    //url: 'findUsernameOrgnew2.json',
					    method: 'POST', //为"POST",则上面的url不会显示在浏览器的地址栏中
					    waitTitle: '提示',
					    waitMsg: '数据正在加载中，请稍后',
					    success:function(form,action) {//获取返回值
					    	//alert(action.result.data.jgmc);
		   					if(action.result.data.state=='100'){
		   						var tab31=Ext.getCmp("InfoModifyTab");
		   						tab31.setTitle("第一步、变更信息录入(未保存)");
		   					}
						}
					});
					
				}
			}
		
		},{
			id:'InfoModifyPtTab',
			title: '第二步、打印变更申请表',
			layout: 'fit',
		    bodyStyle: 'padding:5px;',
			layoutOnTabChange:true,
			items : [InfoModifyPtForm],
			listeners : {
				'activate' : function() {  //标签激活后自动加载数据
					text_search_orgnewInfoModify2.value='';
					searchOrgnewInfoModify2();
				}
			}
		},{
			id:'InfoModifyScTab',
			title: '第三步、扫描上传',
			layout: 'fit',
			layoutOnTabChange:true,
			bodyStyle: 'padding:5px;',
			items : [InfoModifyScForm],
			listeners : {
				'activate' : function() {  //标签激活后自动加载数据
					
					//上传文件格式限制串
					var strPageTypeNeed="";
					var resultObject821 = null;
					Ext.Ajax.request({  
						 url: 'findByCategoryid.action?categoryId=29',  
						 method:'POST',  
						 success:function(result,request){
							  //alert(result.responseText);
							  resultObject821 = eval('('+result.responseText+')');  
				    		  //Ext.Msg.alert('提示框',resultObject821.remark); 
							  strPageTypeNeed=resultObject821.root[0].remark;
							  Ext.Ajax.request({  
									 url: 'findOrgidOrgnew.action',
									 params : {orgid : currentOrgid,stateConditions:'100,10,13'},
									 method:'POST',  
									 success:function(result,request){
										var resultObject8311 = Ext.util.JSON.decode(result.responseText);
					   					if(resultObject8311.root.length!=0){
					   						var strTbrsfzh=resultObject8311.root[0].tbrsfzh;
					   						var strZjhm=resultObject8311.root[0].zjhm;
					   						//alert(strTbrsfzh+"|"+strZjhm);
					   						if(strTbrsfzh==strZjhm){
					   							var strPageTypeNeed2=strPageTypeNeed.replace(/\经办人身份证件%/g, "%"); 
					   							scanner82.PageNeed=strPageTypeNeed2;
					   							//alert("===="+strPageTypeNeed2)
					   						}else{
					   							scanner82.PageNeed=strPageTypeNeed;
					   							//alert("<><><>"+strPageTypeNeed)
					   						}
					   					}
									 },
										failure : function() {
											alert("数据读取错误");
										}
							  });
							  //alert(strPageTypeNeed);
				    		  return;  
			    		 },  
						 failure:function(){  
							  Ext.Msg.alert('提示框','操作失败!');  
							  return;  
						 } 
					});
					
					//scanner82.PageNeed="登记信息表%批准证书%法人身份证%经办人身份证件%迁址证明%";
					scanner82.ImageData="";
					strOrgid=currentOrgid;  //当前ORGID同步
					//alert("检查标签条件，"+scanner82.PageNeed);
	        		var resultObject82 = null;
	        		Ext.Ajax.request({
						url : 'orgnewViewImg.action',
						params : {orgid : strOrgid,stateConditions:'100,20,23'},
						success : function(result,request) {//获取返回值
		   					var resultObject82 = Ext.util.JSON.decode(result.responseText);
		   					if(resultObject82.root.length!=0){
		   						if(resultObject82.root[0].state!='100'){
		   							//alert(resultObject82.root[0].imageData);
				   					if(resultObject82.root[0].imageData!=null && resultObject82.root[0].imageData!=""){
				   						scanner82.OpenProgress(3);  //设置上传的进度条的总进度数
				   						scanner82.Progress('原文加载中',1);
				   						scanner82.Progress('原文加载中',2);
				   						scanner82.ImageData=resultObject82.root[0].imageData;
				   						if(resultObject82.root[0].PageType!=""){
				   							//alert(resultObject82.root[0].pageTypeStr);
				   							scanner82.PageType=resultObject82.root[0].pageTypeStr;
				   						}
				   						scanner82.Progress('原文加载完毕',3);
				   						scanner82.CloseProgress();
				   					}
								}
		   					}
						},
						failure : function() {
							alert("图像加载错误");
						}
					});	
	        						
				}
			}
		
		},{
			id:'InfoModifyTjTab',
			title: '第四步、提交变更',
			layout: 'fit',
		    bodyStyle: 'padding:5px;',
			layoutOnTabChange:true,
			items : [InfoModifyTjForm],
			listeners : {
				'activate' : function() {  //标签激活后自动加载数据
					text_search_orgnewInfoModify.value='';
					searchOrgnewInfoModify();
					btn_return_orgnew.setDisabled(true);
				}
			}
		}],
		listeners : {
			'tabchange' : function() {
			   //alert('成功'+userstate+'吗！')
				switch (userstate) {  //设置变更状态 ?????此处应该采用机构的条目吧？
			 	case '7' :
			 		document.getElementById("imgFlag1").src = "images/jc_off.gif";
					document.getElementById("imgFlag2").src = "images/jc_off.gif";
					document.getElementById("imgFlag3").src = "images/jc_off.gif";
					document.getElementById("imgFlag4").src = "images/jc_off.gif";
			 	case '20' :
			 		document.getElementById("imgFlag1").src = "images/jc_on.gif";
					document.getElementById("imgFlag2").src = "images/jc_off.gif";
					document.getElementById("imgFlag3").src = "images/jc_off.gif";
					document.getElementById("imgFlag4").src = "images/jc_off.gif";
			 	case '21' :
			 		document.getElementById("imgFlag1").src = "images/jc_off.gif";
					document.getElementById("imgFlag2").src = "images/jc_on.gif";
					document.getElementById("imgFlag3").src = "images/jc_off.gif";
					document.getElementById("imgFlag4").src = "images/jc_off.gif";
			 	case '22' :
			 		document.getElementById("imgFlag1").src = "images/jc_off.gif";
					document.getElementById("imgFlag2").src = "images/jc_on.gif";
					document.getElementById("imgFlag3").src = "images/jc_off.gif";
					document.getElementById("imgFlag4").src = "images/jc_off.gif";
			 	case '23' :
			 		document.getElementById("imgFlag1").src = "images/jc_off.gif";
					document.getElementById("imgFlag2").src = "images/jc_on.gif";
					document.getElementById("imgFlag3").src = "images/jc_off.gif";
					document.getElementById("imgFlag4").src = "images/jc_off.gif";
			 	case '24' :
			 		document.getElementById("imgFlag1").src = "images/jc_off.gif";
					document.getElementById("imgFlag2").src = "images/jc_off.gif";
					document.getElementById("imgFlag3").src = "images/jc_off.gif";
					document.getElementById("imgFlag4").src = "images/jc_on.gif";
			 	default :
			 		document.getElementById("imgFlag1").src = "images/jc_off.gif";
					document.getElementById("imgFlag2").src = "images/jc_off.gif";
					document.getElementById("imgFlag3").src = "images/jc_off.gif";
					document.getElementById("imgFlag4").src = "images/jc_off.gif";
			 }
			
				var tab21=Ext.getCmp("centerPanel3");
				if(userstate=="22"||userstate=="25"){
					tab21.remove("InfoModifyTab");   //移除标签
					tab21.remove("InfoModifyScTab");   //移除标签
					tab21.remove("InfoModifyPtTab");   //移除标签
					//tab3.remove("InfoModifyPtTab");   //移除标签
					//tab2.remove("auditForm");  //移除标签
					
				}
			}
		}
	}]
}