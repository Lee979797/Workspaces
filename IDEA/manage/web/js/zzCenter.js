var Center = Ext.data.Record.create([{
	name : 'centerId',
	mapping : 'centerId',
	type : 'int'
}, {
	name : 'centerName',
	mapping : 'centerName',
	type : 'string'
},  {
	name : 'centerCode',
	mapping : 'centerCode',
	type : 'string'
},{
	name : 'address',
	mapping : 'address',
	type : 'string'
}, {
	name : 'tellPhone',
	mapping : 'tellPhone',
	type : 'string'
}, {
	name : 'leader',
	mapping : 'leader',
	type : 'string'
}, {
	name : 'mobilePhone',
	mapping : 'mobilePhone',
	type : 'string'
}, {
	name : 'remark',
	mapping : 'remark',
	type : 'string'
}]);

var cm_center = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
	header : '分中心名称',
	width : 90,
	sortable : true,
	dataIndex : 'centerName',
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 50
	})
},{
	header : '分中心机构代码',
	width : 90,
	sortable : true,
	dataIndex : 'centerCode',
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 50
	})
},{
	header : '分中心地址',
	width : 200,
	dataIndex : 'address',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 70
	})
}, {
	header : '分中心电话',
	width : 85,
	dataIndex : 'tellPhone',
	menuDisabled : true,
	resizable : false,
	editor : new Ext.form.TextField({
		maxLength : 20
	})
}, {
	header : '负责人',
	width : 60,
	dataIndex : 'leader',
	resizable : false,
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 20
	})
}, {
	header : '联系电话',
	width : 85,
	dataIndex : 'mobilePhone',
	resizable : false,
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 20
	})
}, {
	header : '备注',
	id : 'remark',
	dataIndex : 'remark',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 200
	})
}]);

cm_center.defaultSortable = false;

var window_add_center = new Ext.Window({
	title : '添加分中心',
	width : 370,
	height : 500,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function() {
			this.setTitle('添加分中心');
			this.findById('center.centerName').ownerCt.form.reset();
		}
	},
	items : [new Ext.FormPanel({
		labelWidth : 100,
		labelAlign : 'right',
		url : 'saveCenter.action',
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
			fieldLabel : '分中心名称',
			id : 'center.centerName',
			name : 'center.centerName',
			allowBlank : false,
			maxLength : 50
		},{
			fieldLabel : '分中心机构代码',
			id : 'center.centerCode',
			name : 'center.centerCode',
			allowBlank : false,
			maxLength : 50
		},{
			fieldLabel : '分中心地址',
			name : 'center.address',
			maxLength : 70
		}, {
			fieldLabel : '分中心电话',
			name : 'center.tellPhone',
			maxLength : 20
		}, {
			fieldLabel : '负责人',
			name : 'center.leader',
			allowBlank : false,
			maxLength : 20
		}, {
			fieldLabel : '联系电话',
			name : 'center.mobilePhone',
			maxLength : 20
		}, {
			fieldLabel : '备注',
			name : 'center.remark',
			xtype : 'textarea',
			maxLength : 200
		}],
		buttonAlign : 'right',
		minButtonWidth : 60,
		buttons : [{
			text : '添加',
			handler : function(btn) {
				var frm = this.ownerCt.form;
				if (frm.isValid()) {
					btn.disable();
					var cnfield = frm.findField('center.centerName'); // 获得分中心名称输入框
					frm.submit({
						waitTitle : '请稍候',
						waitMsg : '正在提交表单数据,请稍候...',
						success : function(form, action) {
							var store = grid_center.getStore();
							if (store.data.length <= 20) {
								var center = new Center({
									centerId : action.result.centerId,
									centerName : cnfield.getValue(),
									centerCode :  form.findField('center.centerCode').getValue(),
									address : form.findField('center.address').getValue(),
									tellPhone : form.findField('center.tellPhone').getValue(),
									leader : form.findField('center.leader').getValue(),
									mobilePhone : form.findField('center.mobilePhone').getValue(),
									remark : form.findField('center.remark').getValue()
								});
								store.insert(0, [center]);
								if (store.data.length > 20) {
									store.remove(store.getAt(store.data.length - 1));
								}
							}
							window_add_center.setTitle('[ ' + cnfield.getValue() + ' ]   添加成功!!');
							cnfield.reset();
							btn.enable();
						},
						failure : function() {
							Ext.Msg.show({
								title : '错误提示',
								msg : '"' + cnfield.getValue() + '" ' + '名称可能已经存在!',
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

var btn_add_center = new Ext.Button({
	text : '添加分中心',
	iconCls : 'icon-add',
	handler : function() {
		window_add_center.show();
	}
});

var btn_del_center = new Ext.Button({
	text : '删除分中心',
	iconCls : 'icon-del',
	handler : function() {
		var record = grid_center.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
				if (btn == 'yes') {
					Ext.Ajax.request({
						url : 'deleteCenter.action',
						params : {
							centerId : record.data.centerId
						},
						success : function() {
							grid_center.getStore().remove(record);
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

var text_search_center = new Ext.form.TextField({
	name : 'textSearchCenter',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchCenter();
			}
		}
	}
});

// grid的查找方法
var searchCenter = function() {
	// 传参数一定要用这种方式,否则翻页的时候不会根据这些参数查询
	ds_center.baseParams.conditions = text_search_center.getValue();
	ds_center.load({
		params : {
			start : 0,
			limit : 20
		}
	});
}

var btn_search_center = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : searchCenter
});

var ds_center = new Ext.data.Store({
	proxy : new Ext.data.HttpProxy({
		url : 'findAllCenter.action'
	}),
	reader : new Ext.data.JsonReader({
		totalProperty : 'totalProperty',
		root : 'root'
	}, [{
		name : 'centerId',
		type : 'int'
	}, {
		name : 'centerName',
		type : 'string'
	}, {
		name : 'centerCode',
		type : 'string'
	}, {
		name : 'address',
		type : 'string'
	}, {
		name : 'tellPhone',
		type : 'string'
	}, {
		name : 'leader',
		type : 'string'
	}, {
		name : 'mobilePhone',
		type : 'string'
	}, {
		name : 'remark',
		type : 'string'
	}])
});

var grid_center = new Ext.grid.EditorGridPanel({
	title : '分中心管理',
	iconCls : 'icon-grid',
	loadMask : {msg : '数据加载中...'},
	region : 'center',
	cm : cm_center,
	ds : ds_center,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	enableColumnMove : false,
	trackMouseOver : false,
	frame : true,
	autoExpandColumn : 'remark',
	clicksToEdit : 1,
	tbar : [btn_add_center, '-', btn_del_center, '-', text_search_center, btn_search_center],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_center,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条  共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'afteredit' : function(e) {
			Ext.Ajax.request({
				url : 'updateCenter.action',
				params : {
					fieldName : e.field,
					fieldValue : e.value,
					centerId : e.record.data.centerId
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

var p_zzCenter = {
	id : 'zzCenter-panel',
	border : false,
	layout : 'border',
	items : [grid_center]
};