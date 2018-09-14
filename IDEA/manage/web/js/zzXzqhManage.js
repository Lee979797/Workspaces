var Xzqh = Ext.data.Record.create([{
	name : 'xzqhId',
	mapping : 'xzqhId',
	type : 'int'
}, {
	name : 'xzqhName',
	mapping : 'xzqhName',
	type : 'string'
}, {
	name : 'xzqhCode',
	mapping : 'xzqhCode',
	type : 'string'
}, {
	name : 'xzqhNote',
	mapping : 'xzqhNote',
	type : 'string'
}]);

var cm_xzqh = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
	header : '行政区划名称',
	width : 180,
	dataIndex : 'xzqhName',
	sortable : true,
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 50
	})
}, {
	header : '行政区划代码',
	width : 200,
	dataIndex : 'xzqhCode',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 6
	})
}, {
	header : '备注',
	id : 'xzqhNote',
	dataIndex : 'xzqhNote',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 100
	})
}]);

cm_xzqh.defaultSortable = false;
var window_add_xzqh = new Ext.Window({
	title : '添加行政区划',
	width : 360,
	height : 440,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function() {
			this.setTitle('添加行政区划');
			this.findById('xzqh.xzqhName').ownerCt.form.reset();
		}
	},
	items : [new Ext.FormPanel({
		labelWidth : 90,
		labelAlign : 'right',
		url : 'saveXzqh.action',
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
			fieldLabel : '行政区划名称',
			id : 'xzqh.xzqhName',
			name : 'xzqh.xzqhName',
			allowBlank : false,
			maxLength : 100
		}, {
			fieldLabel : '行政区划代码',
			name : 'xzqh.xzqhCode',
			maxLength : 6
		}, {
			fieldLabel : '备注',
			name : 'xzqh.xzqhNote',
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
					var dnfield = frm.findField('xzqh.xzqhName');
					frm.submit({
						waitTitle : '请稍候',
						waitMsg : '正在提交表单数据,请稍候...',
						success : function(form, action) {
							var store = grid_xzqh.getStore();
							if (store.data.length <= 20) {
								var xzqh = new Xzqh({
									xzqhId : action.result.xzqhId,
									xzqhName : dnfield.getValue(),
									xzqhCode : form.findField('xzqh.xzqhCode').getValue(),
									xzqhNote : form.findField('xzqh.xzqhNote').getValue()
								});
								store.insert(0, [xzqh]);
								if (store.data.length > 20) {
									store.remove(store.getAt(store.data.length - 1));
								}
							}
							window_add_xzqh.setTitle('[ ' + dnfield.getValue() + ' ]   添加成功!!');
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

var btn_add_xzqh = new Ext.Button({
	text : '添加',
	iconCls : 'icon-add',
	handler : function() {
		window_add_xzqh.show();
	}
});

var btn_del_xzqh = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	handler : function() {
		var record = grid_xzqh.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
				if (btn == 'yes') {
					Ext.Ajax.request({
						url : 'deleteXzqh.action',
						params : {
							xzqhId : record.data.xzqhId
						},
						success : function() {
							grid_xzqh.getStore().remove(record);
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

var searchXzqh = function() {
	ds_xzqh.baseParams.conditions = text_search_xzqh.getValue();
	ds_xzqh.load({
		params : {
			start : 0,
			limit : useFullPageSize
		}
	});
}

var btn_search_xzqh = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : searchXzqh
});



var text_search_xzqh = new Ext.form.TextField({
	name : 'textSearchXzqh',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchXzqh();
			}
		}
	}
});

var ds_xzqh = new Ext.data.Store({
	proxy : new Ext.data.HttpProxy({
		url : 'findAllByConditionXzqh.action'
	}),
	reader : new Ext.data.JsonReader({
		totalProperty : 'totalProperty',
		root : 'root'
	}, [{
		name : 'xzqhId',
		type : 'int'
	}, {
		name : 'xzqhName',
		type : 'string'
	}, {
		name : 'xzqhCode',
		type : 'string'
	}, {
		name : 'xzqhNote',
		type : 'string'
	}])
});

var companyId; // 存储机构修改时省份下拉的省份id

var grid_xzqh = new Ext.grid.EditorGridPanel({
	title : '行政区划管理',
	iconCls : 'icon-plugin',
	region : 'center',
	loadMask : {
		msg : '数据加载中...'
	},
	cm : cm_xzqh,
	ds : ds_xzqh,
	sm : new Ext.grid.RowSelectionModel({
		singleSelect : true
	}),
	enableColumnMove : false,
	trackMouseOver : false,
	frame : true,
	autoExpandColumn : 'xzqhNote',
	clicksToEdit : 1,
	tbar : [btn_add_xzqh, '-', btn_del_xzqh, '-', text_search_xzqh, btn_search_xzqh],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_xzqh,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条  共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'afteredit' : function(e) {
			Ext.Ajax.request({
				url : 'updateXzqh.action',
				params : {
					fieldName : e.field,
					fieldValue : e.value,
					xzqhId : e.record.data.xzqhId
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

var p_zzXzqhManage = {
	id : 'zzXzqhManage-panel',
	border : false,
	layout : 'border',
	items : [grid_xzqh]
}
