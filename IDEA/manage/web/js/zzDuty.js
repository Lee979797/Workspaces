// 角色管理
var Duty = Ext.data.Record.create([{
	name : 'dutyId',
	mapping : 'dutyId',
	type : 'int'
}, {
	name : 'dutyName',
	mapping : 'dutyName',
	type : 'string'
}, {
	name : 'remark',
	mapping : 'remark',
	type : 'string'
}]);

var funcCode="";

var ds_func_select = new Ext.data.Store({
	autoLoad : true, 
	url : 'findAllFunc.action',
	reader : new Ext.data.JsonReader({root:'root'},[{name:'funcCode'}, {name:'funcName'}])
});

var cm_duty = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
	header : '角色ID',
	sortable : true,
	menuDisabled : true,
	width : 60,
	dataIndex : 'dutyId'
},{
	header : '角色名称',
	sortable : true,
	menuDisabled : true,
	width : 120,
	dataIndex : 'dutyName'
},{
	header : '功能权限',
	width : 500,
	dataIndex : 'funcName',
	menuDisabled : true,
	readOnly:true,
	sortable : false
},{
	header : '备注',
	id : 'remark',
	dataIndex : 'remark',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 100
	})
}]);

cm_duty.defaultSortable = false;

var window_add_duty = new Ext.Window({
	title : '添加',
	width : 350,
	height : 440,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function() {
			this.setTitle('添加');
			this.findById('duty.dutyName').ownerCt.form.reset();
		}
	},
	items : [new Ext.FormPanel({
		labelWidth : 70,
		labelAlign : 'right',
		url : 'saveDuty.action',
		border : false,
		baseCls : 'x-plain',
		bodyStyle : 'padding:5px 5px 0',
		anchor : '100%',
		defaults : {
			width : 233,
			msgTarget : 'side' // 验证信息显示右边
		},
		defaultType : 'textfield',
		items : [{
			fieldLabel : '角色名称',
			id : 'duty.dutyName',
			name : 'duty.dutyName',
			allowBlank : false,
			maxLength : 20
		}, new Ext.ux.form.LovCombo({
			  id:"duty_add",
			  name:"funcCode",
			  fieldLabel:"功能权限",
			  store:ds_func_select,
			  mode:'local',
			  triggerAction:'all',
			  hideTrigger:false,
			  width:180,
			  allowBlank : false,
			  editable : false,
			  labelSeparator:'',
			  displayField:'funcName',
			  hiddenName : 'duty.funcCode',
			  valueField : 'funcCode',
			  loadingText : '加载中...',
			  emptyText:'请选择功能',
			  editable:false,
			  listeners : {
					'select' : function(combo, record, index) {
						this.ownerCt.form.findField('duty.funcName').setValue(Ext.get('duty_add').dom.value.replace(/\s+/g,""));
					}
			 }
		}), {xtype : 'hidden',name : 'duty.funcName'},{
			fieldLabel : '备注',
			name : 'duty.remark',
			xtype : 'textarea',
			maxLength : 100
		}],
		buttonAlign : 'right',
		minButtonWidth : 60,
		buttons : [{
			text : '添加',
			handler : function(btn) {
				var frm = this.ownerCt.form;
				if (frm.isValid()) {
					btn.disable();
					var cnfield = frm.findField('duty.dutyName');
					frm.submit({
						waitTitle : '请稍候',
						waitMsg : '正在提交表单数据,请稍候...',
						success : function(form, action) {
							var store = grid_zzDuty.getStore();
							var duty = new Duty({
								dutyId : action.result.dutyId,
								dutyName : cnfield.getValue(),
								funcCode : form.findField('duty.funcCode').getValue(),
								funcName : form.findField('duty.funcName').getValue(),
								remark : form.findField('duty.remark').getValue()
							});
							store.insert(0, [duty]);
							window_add_duty.setTitle('【'+cnfield.getValue()+'】，添加成功！');
							cnfield.reset();
							btn.enable();
						},
						failure : function() {
							Ext.Msg.show({
								title : '错误提示',
								msg : '【'+cnfield.getValue()+'】，可能已经存在！',
								buttons : Ext.Msg.OK,
								fn : function() {
									cnfield.focus(true);
									btn.enable();
								},
								icon : Ext.Msg.ERROR
							});
						}
					});
				}
			}
		}, {
			text : '重置',
			handler : function() {
				this.ownerCt.form.reset();
			}
		}, {
			text : '取消',
			handler : function() {
				this.ownerCt.ownerCt.hide();
			}
		}]
	})]
});

var btn_add_duty = new Ext.Button({
	text : '添加',
	iconCls : 'icon-add',
	handler : function() {
		window_add_duty.show();
	}
});

var qxDutyEditForm = new Ext.FormPanel({
		url : 'qxDuty.action',
		labelWidth : 70,
		labelAlign : 'right',
		border : false,
		baseCls : 'x-plain',
		bodyStyle : 'padding:5px 5px 0',
		anchor : '100%',
		defaults : {
			width : 233,
			msgTarget : 'side' // 验证信息显示右边
		},
		defaultType : 'textfield',
		items : [{
				xtype : 'hidden',
				name : 'dutyId'
		},{
			fieldLabel : '角色名称',
			id:'dutyName',
			name : 'dutyName',
			allowBlank : false,
			readOnly:true,
			maxLength : 20
		}, new Ext.ux.form.LovCombo({
			  id:'duty_qxEdit',
			  name:"funcCode",
			  fieldLabel:"功能权限",
			  store:ds_func_select,
			  mode:'local',
			  triggerAction:'all',
			  hideTrigger:false,
			  width:180,
			  allowBlank : false,
			  editable : false,
			  labelSeparator:'',
			  displayField:'funcName',
			  hiddenName : 'funcCode',
			  valueField : 'funcCode',
			  loadingText : '加载中...',
			  emptyText:'请选择功能',
			  editable:false,
			  listeners : {
					'select' : function(combo, record, index) {
						this.ownerCt.form.findField('funcName').setValue(Ext.get('duty_qxEdit').dom.value.replace(/\s+/g,""));
					}
			 }
		}), {xtype : 'hidden',name : 'funcName'},{
			fieldLabel : '备注',
			name : 'remark',
			xtype : 'textarea',
			maxLength : 100
		}],
		buttonAlign : 'right',
		minButtonWidth : 60,
		buttons : [{
			text : '保存',
			handler : function(btn) {
				var frm = this.ownerCt.form;
				if (frm.isValid()) {
					btn.disable();
					var dutyName = frm.findField('dutyName').getValue();
					frm.submit({
						waitTitle : '请稍候',
						waitMsg : '正在提交表单数据,请稍候...',
						success : function(form, action) {
							var store = grid_zzDuty.getStore();
							var duty = new Duty({
								dutyId : form.findField('dutyId').getValue(),
								dutyName : dutyName,
								funcCode : form.findField('funcCode').getValue(),
								funcName : form.findField('funcName').getValue(),
								remark : form.findField('remark').getValue()
							});
							var index = store.indexOf(grid_zzDuty.getSelectionModel().getSelected());
							store.remove(grid_zzDuty.getSelectionModel().getSelected());
							store.insert(index, duty);
							grid_zzDuty.getSelectionModel().selectRow(index);
							//cnfield.reset();
							window_qx_duty.hide();
							Ext.Msg.show({
								title : '成功提示',
								msg : '角色【 '+dutyName+'】，修改成功！',
								buttons : Ext.Msg.OK,
								fn : function(){btn.enable();},
								icon : Ext.Msg.INFO
							});
						},
						failure : function() {
							Ext.Msg.show({
								title : '错误提示',
								msg : '角色【'+dutyName+'】，修改失败！',
								buttons : Ext.Msg.OK,
								fn : function() {
									btn.enable();
								},
								icon : Ext.Msg.ERROR
							});
						}
					});
				}
			}
		}, {
			text : '重置',
			handler : function() {
				this.ownerCt.form.reset();
			}
		}, {
			text : '取消',
			handler : function() {
				this.ownerCt.ownerCt.hide();
			}
		}]
	});
		
var window_qx_duty = new Ext.Window({
	title : '修改',
	width : 350,
	height : 440,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function() {
			this.setTitle('修改');
			this.findById('dutyName').ownerCt.form.reset();
		}
	},
	items : [qxDutyEditForm]
});

var btn_qx_duty = new Ext.Button({
	text : '修改',
	iconCls : 'icon-edit',
	handler : function() {
		var record = grid_zzDuty.getSelectionModel().getSelected();
		if(record){
			window_qx_duty.show();
			qxDutyEditForm.getForm().loadRecord(record);
		}
	}
});


var btn_del_duty = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	handler : function() {
		var record = grid_zzDuty.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
				if (btn == 'yes') {
					ajaxLoadMask.show();
					Ext.Ajax.request({
						url : 'deleteDuty.action',
						params : {
							dutyId : record.data.dutyId
						},
						success : function() {
							ajaxLoadMask.hide();
							grid_zzDuty.getStore().remove(record);
						},
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

var btn_search_duty = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-refresh',
	handler : function() {
		ds_duty.load();
	}
});

var ds_duty = new Ext.data.Store({
	proxy : new Ext.data.HttpProxy({
		url : 'findAllDuty.action'
	}),
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{
		name : 'dutyId',
		type : 'int'
	}, {
		name : 'dutyName',
		type : 'string'
	}, {
		name : 'funcCode',
		type : 'string'
	}, {
		name : 'funcName',
		type : 'string'
	}, {
		name : 'remark',
		type : 'string'
	}])
});

var grid_zzDuty = new Ext.grid.EditorGridPanel({
	title : '用户角色管理',
	iconCls : 'icon-grid',
	loadMask : {
		msg : '数据加载中...'
	},
	region : 'center',
	cm : cm_duty,
	ds : ds_duty,
	sm : new Ext.grid.RowSelectionModel({
		singleSelect : true
	}),
	enableColumnMove : false,
	trackMouseOver : false,
	frame : true,
	autoExpandColumn : 'remark',
	clicksToEdit : 1,
	tbar : [btn_add_duty,btn_del_duty,btn_qx_duty,'-', btn_search_duty],
	listeners : {
		'afteredit' : function(e) {
			Ext.Ajax.request({
				url : 'updateDuty.action',
				params : {
					fieldName : e.field,
					fieldValue : e.value,
					funcCode:funcCode,
					dutyId : e.record.data.dutyId
				},
				success : function() {
					funcCode="";
				},
				failure : function() {
					Ext.Msg.show({
						title : '错误提示',
						msg : '修改数据发生错误,操作将被回滚!',
						fn : function() {
							e.record.set(e.field, e.originalValue);
						},
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
				}
			});
		}
	}
});

var p_zzDuty = {
	id : 'zzDuty-panel',
	border : false,
	layout : 'border',
	items : [grid_zzDuty]
};