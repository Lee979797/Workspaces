var Pzjg = Ext.data.Record.create([{
	name : 'pzjgid',
	mapping : 'pzjgid',
	type : 'int'
}, {
	name : 'pzjgmc',
	mapping : 'pzjgmc',
	type : 'string'
}, {
	name : 'pzjgdm',
	mapping : 'pzjgdm',
	type : 'string'
}, {
	name : 'bzjgdm',
	mapping : 'bzjgdm',
	type : 'string'
}, {
	name : 'note',
	mapping : 'note',
	type : 'string'
}]);

var cm_pzjg = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
	header : '批准机构名称',
	width : 180,
	dataIndex : 'pzjgmc',
	sortable : true,
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 50
	})
}, {
	header : '批准机构代码',
	width : 200,
	dataIndex : 'pzjgdm',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 9
	})
}, {
	header : '所属办证机构代码',
	width : 200,
	dataIndex : 'bzjgdm',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 9
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

cm_pzjg.defaultSortable = false;
var window_add_pzjg = new Ext.Window({
	title : '添加批准机构',
	width : 390,
	height : 440,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function() {
			this.setTitle('添加批准机构');
			this.findById('pzjg.pzjgmc').ownerCt.form.reset();
			this.findById('pzjg.pzjgdm').ownerCt.form.reset();
			this.findById('pzjg.note').ownerCt.form.reset();
		}
	},
	items : [new Ext.FormPanel({
		labelWidth : 110,
		labelAlign : 'right',
		url : 'savePzjg.action',
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
			fieldLabel : '批准机构名称',
			id : 'pzjg.pzjgmc',
			name : 'pzjg.pzjgmc',
			allowBlank : false,
			maxLength : 100
		}, {
			fieldLabel : '批准机构代码',
			id : 'pzjg.pzjgdm',
			name : 'pzjg.pzjgdm',
			maxLength : 9
		}, {
			fieldLabel : '所属办证机构编码',
			name : 'pzjg.bzjgdm',
			maxLength : 6
		}, {
			fieldLabel : '备注',
			id : 'pzjg.note',
			name : 'pzjg.note',
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
					var dnfield = frm.findField('pzjg.pzjgmc');
					frm.submit({
						waitTitle : '请稍候',
						waitMsg : '正在提交表单数据,请稍候...',
						success : function(form, action) {
							var store = grid_pzjg.getStore();
							if (store.data.length <= 20) {
								var pzjg = new Pzjg({
									pzjgid : action.result.pzjgid,
									pzjgmc : dnfield.getValue(),
									pzjgdm : form.findField('pzjg.pzjgdm').getValue(),
									bzjgdm : form.findField('pzjg.bzjgdm').getValue(),
									note : form.findField('pzjg.note').getValue()
								});
								store.insert(0, [pzjg]);
								if (store.data.length > 20) {
									store.remove(store.getAt(store.data.length - 1));
								}
							}
							window_add_pzjg.setTitle('[ ' + dnfield.getValue() + ' ]   添加成功!!');
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

var btn_add_pzjg = new Ext.Button({
	text : '添加',
	iconCls : 'icon-add',
	handler : function() {
		window_add_pzjg.show();
	}
});

var btn_del_pzjg = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	handler : function() {
		var record = grid_pzjg.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
				if (btn == 'yes') {
					Ext.Ajax.request({
						url : 'deletePzjg.action',
						params : {
							pzjgid : record.data.pzjgid
						},
						success : function() {
							grid_pzjg.getStore().remove(record);
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

var searchPzjg = function() {
	ds_pzjg.baseParams.conditions = text_search_pzjg.getValue();
	ds_pzjg.load({
		params : {
			start : 0,
			limit : useFullPageSize
		}
	});
}

var btn_search_pzjg = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : searchPzjg
});



var text_search_pzjg = new Ext.form.TextField({
	name : 'textSearchPzjg',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchPzjg();
			}
		}
	}
});

var ds_pzjg = new Ext.data.Store({
	proxy : new Ext.data.HttpProxy({
		url : 'findAllByConditionPzjg.action'
	}),
	reader : new Ext.data.JsonReader({
		totalProperty : 'totalProperty',
		root : 'root'
	}, [{
		name : 'pzjgid',
		type : 'int'
	}, {
		name : 'pzjgmc',
		type : 'string'
	}, {
		name : 'pzjgdm',
		type : 'string'
	}, {
		name : 'bzjgdm',
		type : 'string'
	}, {
		name : 'note',
		type : 'string'
	}])
});

var grid_pzjg = new Ext.grid.EditorGridPanel({
	title : '批准机构管理',
	iconCls : 'icon-plugin',
	region : 'center',
	loadMask : {
		msg : '数据加载中...'
	},
	cm : cm_pzjg,
	ds : ds_pzjg,
	sm : new Ext.grid.RowSelectionModel({
		singleSelect : true
	}),
	enableColumnMove : false,
	trackMouseOver : false,
	frame : true,
	autoExpandColumn : 'note',
	clicksToEdit : 1,
	tbar : [btn_add_pzjg, '-', btn_del_pzjg, '-', text_search_pzjg, btn_search_pzjg],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_pzjg,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条  共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'afteredit' : function(e) {
			Ext.Ajax.request({
				url : 'updatePzjg.action',
				params : {
					fieldName : e.field,
					fieldValue : e.value,
					pzjgid : e.record.data.pzjgid
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

var p_zzPzjgManage = {
	id : 'zzPzjgManage-panel',
	border : false,
	layout : 'border',
	items : [grid_pzjg]
}
