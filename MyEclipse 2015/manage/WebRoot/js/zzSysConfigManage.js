var SysConfig = Ext.data.Record.create([{
	name : 'configId',
	mapping : 'configId',
	type : 'int'
}, {
	name : 'configName',
	mapping : 'configName',
	type : 'string'
}, {
	name : 'configCode',
	mapping : 'configCode',
	type : 'string'
}, {
	name : 'configValue',
	mapping : 'configValue',
	type : 'string'
}, {
	name : 'note',
	mapping : 'note',
	type : 'string'
}]);

var cm_sysConfig = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
	header : '参数名称',
	width : 180,
	dataIndex : 'configName',
	sortable : true,
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 50
	})
}, {
	header : '参数代码',
	width : 200,
	dataIndex : 'configCode',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		readOnly:true,
		allowBlank : false,
		maxLength : 50
	})
}, {
	header : '参数值',
	width : 200,
	dataIndex : 'configValue',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 50
	})
}, {
	header : '备注',
	id : 'note',
	dataIndex : 'note',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 100
	})
}]);

cm_sysConfig.defaultSortable = false;

var window_add_sysConfig = new Ext.Window({
	title : '添加新参数',
	width : 390,
	height : 440,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function() {
			this.setTitle('添加新参数');
			this.findById('sysConfig.configCode').ownerCt.form.reset();
			this.findById('sysConfig.configName').ownerCt.form.reset();
			this.findById('sysConfig.configValue').ownerCt.form.reset();
			this.findById('sysConfig.note').ownerCt.form.reset();
		}
	},
	items : [new Ext.FormPanel({
		labelWidth : 110,
		labelAlign : 'right',
		url : 'saveSysConfig.action',
		border : false,
		baseCls : 'x-plain',
		bodyStyle : 'padding:5px 5px 0',
		anchor : '100%',
		defaults : {
			width : 233,
			msgTarget : 'side'
		},
		defaultType : 'textfield',
		items : [{
			fieldLabel : '参数名称',
			id : 'sysConfig.configName',
			name : 'sysConfig.configName',
			allowBlank : false,
			maxLength : 100
		}, {
			fieldLabel : '参数代码',
			id : 'sysConfig.configCode',
			name : 'sysConfig.configCode',
			maxLength : 50
		}, {
			fieldLabel : '参数值',
			id : 'sysConfig.configValue',
			name : 'sysConfig.configValue',
			maxLength : 50
		}, {
			fieldLabel : '备注',
			id : 'sysConfig.note',
			name : 'sysConfig.note',
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
					var dnfield = frm.findField('sysConfig.configName');
					var dnfield2 = frm.findField('sysConfig.configCode')
					var dnfield3 = frm.findField('sysConfig.configValue');
					var dnfield4 = frm.findField('sysConfig.note');
					frm.submit({
						waitTitle : '请稍候',
						waitMsg : '正在提交表单数据,请稍候...',
						success : function(form, action) {
							var store = grid_sysConfig.getStore();
							if (store.data.length <= 20) {
								var sysConfig = new SysConfig({
									configId : action.result.configId,
									configName : dnfield.getValue(),
									configCode : dnfield2.getValue(),
									configValue : dnfield3.getValue(),
									note : dnfield4.getValue()
								});
								store.insert(0, [sysConfig]);
								if (store.data.length > 20) {
									store.remove(store.getAt(store.data.length - 1));
								}
							}
							window_add_sysConfig.setTitle('[ ' + dnfield.getValue() + ' ]   添加成功!!');
							dnfield.reset();
							dnfield2.reset();
							dnfield3.reset();
							dnfield4.reset();
							btn.enable();
						},
						failure : function() {
							Ext.Msg.show({
								title : '错误提示',
								msg : '参数"' + dnfield.getValue() + '" ' + '的代码'+fdnfield2.getValue()+'可能已经存在!',
								buttons : Ext.Msg.OK,
								fn : function() {
									dnfield2.focus(true);
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

var btn_add_sysConfig = new Ext.Button({
	text : '添加',
	disabled:true,
	iconCls : 'icon-add',
	handler : function() {
		window_add_sysConfig.show();
	}
});

var btn_del_sysConfig = new Ext.Button({
	text : '删除',
	disabled:true,
	iconCls : 'icon-del',
	handler : function() {
		var record = grid_sysConfig.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
				if (btn == 'yes') {
					Ext.Ajax.request({
						url : 'deleteSysConfig.action',
						params : {
							configId : record.data.configId
						},
						success : function() {
							grid_sysConfig.getStore().remove(record);
						},
						failure : function() {
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

var searchSysConfig = function() {
	ds_sysConfig.baseParams.conditions = text_search_sysConfig.getValue();
	ds_sysConfig.load({
		params : {
			start : 0,
			limit : useFullPageSize
		}
	});
}

var btn_search_sysConfig = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : searchSysConfig
});



var text_search_sysConfig = new Ext.form.TextField({
	name : 'textSearchSysConfig',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchSysConfig();
			}
		}
	}
});

var ds_sysConfig = new Ext.data.Store({
	proxy : new Ext.data.HttpProxy({
		url : 'findAllByConditionSysConfig.action'
	}),
	reader : new Ext.data.JsonReader({
		totalProperty : 'totalProperty',
		root : 'root'
	}, [{
		name : 'configId',
		type : 'int'
	}, {
		name : 'configName',
		type : 'string'
	}, {
		name : 'configCode',
		type : 'string'
	}, {
		name : 'configValue',
		type : 'string'
	}, {
		name : 'note',
		type : 'string'
	}])
});


var grid_sysConfig = new Ext.grid.EditorGridPanel({
	title : '系统参数设置（系统参数改变后，用户需重新登录）',
	iconCls : 'icon-plugin',
	region : 'center',
	loadMask : {
		msg : '数据加载中...'
	},
	cm : cm_sysConfig,
	ds : ds_sysConfig,
	sm : new Ext.grid.RowSelectionModel({
		singleSelect : true
	}),
	enableColumnMove : false,
	trackMouseOver : false,
	frame : true,
	autoExpandColumn : 'note',
	clicksToEdit : 1,
	tbar : [btn_add_sysConfig, '-', btn_del_sysConfig, '-', text_search_sysConfig, btn_search_sysConfig],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_sysConfig,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条  共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'afteredit' : function(e) {
			Ext.Ajax.request({
				url : 'updateSysConfig.action',
				params : {
					fieldName : e.field,
					fieldValue : e.value,
					configId : e.record.data.configId
				},
				success : function() {
					// alert("数据修改成功！");
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

var p_zzSysConfigManage = {
	id : 'zzSysConfigManage-panel',
	border : false,
	layout : 'border',
	items : [grid_sysConfig]
}
