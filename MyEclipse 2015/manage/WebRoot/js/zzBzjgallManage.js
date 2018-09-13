var Bzjgall = Ext.data.Record.create([{
	name : 'bzjgid',
	mapping : 'bzjgid',
	type : 'int'
}, {
	name : 'bzjgmc',
	mapping : 'bzjgmc',
	type : 'string'
}, {
	name : 'bzjgdm',
	mapping : 'bzjgdm',
	type : 'string'
}, {
	name : 'superdm',
	mapping : 'superdm',
	type : 'string'
}, {
	name : 'note',
	mapping : 'note',
	type : 'string'
}]);

var cm_bzjgall = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
	header : '办证机构名称',
	width : 180,
	dataIndex : 'bzjgmc',
	sortable : true,
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 50
	})
}, {
	header : '办证机构代码',
	width : 200,
	dataIndex : 'bzjgdm',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 6
	})
}, {
	header : '上级办证机构代码',
	width : 200,
	dataIndex : 'superdm',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 6
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

cm_bzjgall.defaultSortable = false;
var window_add_bzjgall = new Ext.Window({
	title : '添加办证机构',
	width : 390,
	height : 440,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function() {
			this.setTitle('添加办证机构');
			this.findById('bzjgall.bzjgmc').ownerCt.form.reset();
		}
	},
	items : [new Ext.FormPanel({
		labelWidth : 110,
		labelAlign : 'right',
		url : 'saveBzjgall.action',
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
			fieldLabel : '办证机构名称',
			id : 'bzjgall.bzjgmc',
			name : 'bzjgall.bzjgmc',
			allowBlank : false,
			maxLength : 100
		}, {
			fieldLabel : '办证机构代码',
			name : 'bzjgall.bzjgdm',
			maxLength : 6
		}, {
			fieldLabel : '上级办证机构代码',
			name : 'bzjgall.superdm',
			maxLength : 6
		}, {
			fieldLabel : '备注',
			name : 'bzjgall.note',
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
					var dnfield = frm.findField('bzjgall.bzjgmc');
					frm.submit({
						waitTitle : '请稍候',
						waitMsg : '正在提交表单数据,请稍候...',
						success : function(form, action) {
							var store = grid_bzjgall.getStore();
							if (store.data.length <= 20) {
								var bzjgall = new Bzjgall({
									bzjgid : action.result.bzjgid,
									bzjgmc : dnfield.getValue(),
									bzjgdm : form.findField('bzjgall.bzjgdm').getValue(),
									superdm : form.findField('bzjgall.superdm').getValue(),
									note : form.findField('bzjgall.note').getValue()
								});
								store.insert(0, [bzjgall]);
								if (store.data.length > 20) {
									store.remove(store.getAt(store.data.length - 1));
								}
							}
							window_add_bzjgall.setTitle('[ ' + dnfield.getValue() + ' ]   添加成功!!');
							dnfield.reset();
							btn.enable();
						},
						failure : function() {
							Ext.Msg.show({
								title : '错误提示',
								msg : '"' + dnfield.getValue() + '" ' + '名称可能已经存在!',
								buttons : Ext.Msg.OK,
								fn : function() {
									dnfield.focus(true);
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

var btn_add_bzjgall = new Ext.Button({
	text : '添加',
	iconCls : 'icon-add',
	handler : function() {
		window_add_bzjgall.show();
	}
});

var btn_del_bzjgall = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	handler : function() {
		var record = grid_bzjgall.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
				if (btn == 'yes') {
					Ext.Ajax.request({
						url : 'deleteBzjgall.action',
						params : {
							bzjgid : record.data.bzjgid
						},
						success : function() {
							grid_bzjgall.getStore().remove(record);
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

var searchBzjgall = function() {
	ds_bzjgall.baseParams.conditions = text_search_bzjgall.getValue();
	ds_bzjgall.load({
		params : {
			start : 0,
			limit : useFullPageSize
		}
	});
}

var btn_search_bzjgall = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : searchBzjgall
});



var text_search_bzjgall = new Ext.form.TextField({
	name : 'textSearchBzjgall',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchBzjgall();
			}
		}
	}
});

var ds_bzjgall = new Ext.data.Store({
	proxy : new Ext.data.HttpProxy({
		url : 'findAllByConditionBzjgall.action'
	}),
	reader : new Ext.data.JsonReader({
		totalProperty : 'totalProperty',
		root : 'root'
	}, [{
		name : 'bzjgid',
		type : 'int'
	}, {
		name : 'bzjgmc',
		type : 'string'
	}, {
		name : 'bzjgdm',
		type : 'string'
	}, {
		name : 'superdm',
		type : 'string'
	}, {
		name : 'note',
		type : 'string'
	}])
});

var companyId; // 存储机构修改时省份下拉的省份id

var grid_bzjgall = new Ext.grid.EditorGridPanel({
	title : '办证机构管理',
	iconCls : 'icon-plugin',
	region : 'center',
	loadMask : {
		msg : '数据加载中...'
	},
	cm : cm_bzjgall,
	ds : ds_bzjgall,
	sm : new Ext.grid.RowSelectionModel({
		singleSelect : true
	}),
	enableColumnMove : false,
	trackMouseOver : false,
	frame : true,
	autoExpandColumn : 'note',
	clicksToEdit : 1,
	tbar : [btn_add_bzjgall, '-', btn_del_bzjgall, '-', text_search_bzjgall, btn_search_bzjgall],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_bzjgall,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条  共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'afteredit' : function(e) {
			Ext.Ajax.request({
				url : 'updateBzjgall.action',
				params : {
					fieldName : e.field,
					fieldValue : e.value,
					bzjgid : e.record.data.bzjgid
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

var p_zzBzjgallManage = {
	id : 'zzBzjgallManage-panel',
	border : false,
	layout : 'border',
	items : [grid_bzjgall]
}
