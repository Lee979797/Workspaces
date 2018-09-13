var Jjlx = Ext.data.Record.create([{
	name : 'jjlxid',
	mapping : 'jjlxid',
	type : 'int'
}, {
	name : 'jjlxmc',
	mapping : 'jjlxmc',
	type : 'string'
}, {
	name : 'jjlxdm',
	mapping : 'jjlxdm',
	type : 'string'
}, {
	name : 'pjjlxmc',
	mapping : 'pjjlxmc',
	type : 'string'
}, {
	name : 'pjjlxdm',
	mapping : 'pjjlxdm',
	type : 'string'
},{
	name : 'ojjlxmc',
	mapping : 'ojjlxmc',
	type : 'string'
}, {
	name : 'ojjlxdm',
	mapping : 'ojjlxdm',
	type : 'string'
}, {
	name : 'note',
	mapping : 'note',
	type : 'string'
}]);

var cm_jjlx = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
	header : '经济类型名称',
	width : 250,
	dataIndex : 'jjlxmc',
	sortable : true,
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 50
	})
}, {
	header : '经济类型代码',
	width : 80,
	dataIndex : 'jjlxdm',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 6
	})
}, {
	header : '所属经济类型科目名称',
	width : 150,
	dataIndex : 'pjjlxmc',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 50
	})
}, {
	header : '所属经济类型科目代码',
	width : 100,
	dataIndex : 'pjjlxdm',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 6
	})
}, {
	header : '旧版经济类型科目名称',
	width : 150,
	dataIndex : 'ojjlxmc',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 50
	})
}, {
	header : '旧版所属经济类型科目代码',
	width : 100,
	dataIndex : 'ojjlxdm',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 6
	})
},{
	header : '备注',
	id : 'note',
	dataIndex : 'note',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 100
	})
}]);

cm_jjlx.defaultSortable = false;
var window_add_jjlx = new Ext.Window({
	title : '添加经济类型',
	width : 390,
	height : 440,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function() {
			this.setTitle('添加经济类型');
			this.findById('jjlx.jjlxmc').ownerCt.form.reset();
		}
	},
	items : [new Ext.FormPanel({
		labelWidth : 110,
		labelAlign : 'right',
		url : 'saveJjlx.action',
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
			fieldLabel : '经济类型名称',
			id : 'jjlx.jjlxmc',
			name : 'jjlx.jjlxmc',
			allowBlank : false,
			maxLength : 50
		}, {
			fieldLabel : '经济类型代码',
			name : 'jjlx.jjlxdm',
			maxLength : 6
		}, {
			fieldLabel : '所属经济类型名称',
			name : 'jjlx.pjjlxmc',
			maxLength : 50
		}, {
			fieldLabel : '所属经济类型代码',
			name : 'jjlx.pjjlxdm',
			maxLength : 6
		}, {
			fieldLabel : '旧版经济类型名称',
			name : 'jjlx.ojjlxmc',
			maxLength : 50
		}, {
			fieldLabel : '旧版经济类型代码',
			name : 'jjlx.ojjlxdm',
			maxLength : 6
		},{
			fieldLabel : '备注',
			name : 'jjlx.note',
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
					var dnfield = frm.findField('jjlx.jjlxmc');
					frm.submit({
						waitTitle : '请稍候',
						waitMsg : '正在提交表单数据,请稍候...',
						success : function(form, action) {
							var store = grid_jjlx.getStore();
							if (store.data.length <= 20) {
								var jjlx = new Jjlx({
									jjlxid : action.result.jjlxid,
									jjlxmc : dnfield.getValue(),
									jjlxdm : form.findField('jjlx.jjlxdm').getValue(),
									pjjlxmc : form.findField('jjlx.pjjlxmc').getValue(),
									pjjlxdm : form.findField('jjlx.pjjlxdm').getValue(),
									ojjlxmc : form.findField('jjlx.ojjlxmc').getValue(),
									ojjlxdm : form.findField('jjlx.ojjlxdm').getValue(),
									note : form.findField('jjlx.note').getValue()
								});
								store.insert(0, [jjlx]);
								if (store.data.length > 20) {
									store.remove(store.getAt(store.data.length - 1));
								}
							}
							window_add_jjlx.setTitle('[ ' + dnfield.getValue() + ' ]   添加成功!!');
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

var btn_add_jjlx = new Ext.Button({
	text : '添加',
	iconCls : 'icon-add',
	handler : function() {
		window_add_jjlx.show();
	}
});

var btn_del_jjlx = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	handler : function() {
		var record = grid_jjlx.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
				if (btn == 'yes') {
					Ext.Ajax.request({
						url : 'deleteJjlx.action',
						params : {
							jjlxid : record.data.jjlxid
						},
						success : function() {
							grid_jjlx.getStore().remove(record);
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

var searchJjlx = function() {
	//alert(useFullPageSize);
	ds_jjlx.baseParams.conditions = text_search_jjlx.getValue();
	ds_jjlx.load({
		params : {
			start : 0,
			limit : useFullPageSize
		}
	});
}

var btn_search_jjlx = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : searchJjlx
});



var text_search_jjlx = new Ext.form.TextField({
	name : 'textSearchJjlx',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJjlx();
			}
		}
	}
});

var ds_jjlx = new Ext.data.Store({
	proxy : new Ext.data.HttpProxy({
		url : 'findAllByConditionJjlx.action'
	}),
	reader : new Ext.data.JsonReader({
		totalProperty : 'totalProperty',
		root : 'root'
	},[{
		name : 'jjlxid',
		type : 'int'
	},{
		name : 'jjlxmc',
		type : 'string'
	},{
		name : 'jjlxdm',
		type : 'string'
	},{
		name : 'pjjlxmc',
		type : 'string'
	},{
		name : 'pjjlxdm',
		type : 'string'
	},{
		name : 'ojjlxmc',
		type : 'string'
	},{
		name : 'ojjlxdm',
		type : 'string'
	},{
		name : 'note',
		type : 'string'
	}])
});

var companyId; // 存储机构修改时省份下拉的省份id

var grid_jjlx = new Ext.grid.EditorGridPanel({
	title : '经济类型管理',
	iconCls : 'icon-plugin',
	region : 'center',
	loadMask : {
		msg : '数据加载中...'
	},
	cm : cm_jjlx,
	ds : ds_jjlx,
	sm : new Ext.grid.RowSelectionModel({
		singleSelect : true
	}),
	enableColumnMove : false,
	trackMouseOver : false,
	frame : true,
	autoExpandColumn : 'note',
	clicksToEdit : 1,
	tbar : [btn_add_jjlx, '-', btn_del_jjlx, '-', text_search_jjlx, btn_search_jjlx],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_jjlx,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条  共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'afteredit' : function(e) {
			Ext.Ajax.request({
				url : 'updateJjlx.action',
				params : {
					fieldName : e.field,
					fieldValue : e.value,
					jjlxid : e.record.data.jjlxid
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

var p_zzJjlxManage = {
	id : 'zzJjlxManage-panel',
	border : false,
	layout : 'border',
	items : [grid_jjlx]
}
