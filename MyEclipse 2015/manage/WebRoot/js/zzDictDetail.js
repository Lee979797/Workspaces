// --------------分类相关--------------
var DictDetail = Ext.data.Record.create([{
	name : 'categoryId',
	mapping : 'categoryId',
	type : 'int'
}, {
	name : 'categoryName',
	mapping : 'categoryName',
	type : 'string'
}, {
	name : 'categoryCode',
	mapping : 'categoryCode',
	type : 'string'
}, {
	name : 'subjectId',
	mapping : 'subjectId',
	type : 'int'
}, {
	name : 'subjectName',
	mapping : 'subjectName',
	type : 'string'
}, {
	name : 'remark',
	mapping : 'remark',
	type : 'string'
}]);

var subjectId;

var ds_dictIndex_select = new Ext.data.Store({
	proxy : new Ext.data.HttpProxy({
		url : 'findAllDictIndex.action'
	}),
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{
		name : 'subjectId',
		type : 'int'
	}, {
		name : 'subjectName',
		type : 'string'
	}])
});

var cm_dictDetail = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
	header : '字典分类',
	width : 90,
	dataIndex : 'categoryName',
	sortable : true,
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 50
	})
}, {
	header : '字典分类代码',
	width : 90,
	dataIndex : 'categoryCode',
	sortable : true,
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 50
	})
},{
	header : '所属字典',
	width : 90,
	sortable : true,
	dataIndex : 'subjectName',
	editor : new Ext.form.ComboBox({
		store : ds_dictIndex_select,
		displayField : 'subjectName',
		valueField : 'subjectName',
		mode : 'remote',
		allowBlank : false,
		editable : false,
		triggerAction : 'all',
		listWidth : 130,
		listeners : {
			'select' : function(combo, record, index) {
				subjectId = record.data.subjectId;
			}
		}
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

cm_dictDetail.defaultSortable = false;

var window_add_dictDetail = new Ext.Window({
	title : '添加',
	width : 350,
	height : 440,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function() {
			this.setTitle('添加字典分类');
			this.findById('dictDetail.categoryName').ownerCt.form.reset();
		}
	},
	items : [new Ext.FormPanel({
		labelWidth : 70,
		labelAlign : 'right',
		url : 'saveDictDetail.action',
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
			fieldLabel : '字典分类',
			id : 'dictDetail.categoryName',
			name : 'dictDetail.categoryName',
			allowBlank : false,
			maxLength : 50
		},{
			fieldLabel : '字典分类代码',
			id : 'dictDetail.categoryCode',
			name : 'dictDetail.categorCode',
			allowBlank : false,
			maxLength : 50
		},  {
			xtype : 'combo',
			fieldLabel : '所属字典',
			id : 'dictIndex',
			hiddenName : 'dictDetail.subjectId',
			valueField : 'subjectId',
			displayField : 'subjectName',
			mode : 'remote',
			store : ds_dictIndex_select,
			selectOnFocus : true,
			editable : false,
			allowBlank : false,
			triggerAction : 'all',
			loadingText : '加载中...',
			emptyText : '字典名称',
			listeners : { // 获得下拉文本内容,解决id,value都要的情况
				'select' : function(combo, record, index) {
					this.ownerCt.form.findField('dictDetail.subjectName').setValue(record.data.subjectName);
				}
			}
		}, {
			xtype : 'hidden',
			name : 'dictDetail.subjectName'
		}, {
			fieldLabel : '备注',
			name : 'dictDetail.remark',
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
					var dnfield = frm.findField('dictDetail.categoryName');
					frm.submit({
						waitTitle : '请稍候',
						waitMsg : '正在提交表单数据,请稍候...',
						success : function(form, action) {
							var store = grid_dictDetail.getStore();
							if (store.data.length <= 20) {
								var dictDetail = new DictDetail({
									categoryId : action.result.categoryId,
									categoryName : dnfield.getValue(),
									categoryCode : form.findField('dictDetail.categoryCode').getValue(),
									subjectId : form.findField('dictDetail.subjectId').getValue(),
									subjectName : Ext.get('dictIndex').dom.value,
									remark : form.findField('dictDetail.remark').getValue()
								});
								store.insert(0, [dictDetail]);
								if (store.data.length > 20) {
									store.remove(store.getAt(store.data.length - 1));
								}
							}
							window_add_dictDetail.setTitle('[ ' + dnfield.getValue() + ' ]   添加成功!!');
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

var btn_add_dictDetail = new Ext.Button({
	text : '添加',
	iconCls : 'icon-add',
	handler : function() {
		window_add_dictDetail.show();
	}
});

var btn_del_dictDetail = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	handler : function() {
		var record = grid_dictDetail.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
				if (btn == 'yes') {
					Ext.Ajax.request({
						url : 'deleteDictDetail.action',
						params : {
							categoryId : record.data.categoryId
						},
						success : function() {
							grid_dictDetail.getStore().remove(record);
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

var searchDictDetail = function() {
	ds_dictDetail.baseParams.conditions = text_search_dictDetail.getValue();// + ','
																		// +
																		// cbb_company_for_dept.getValue();
	ds_dictDetail.load({
		params : {
			start : 0,
			limit : useFullPageSize
		}
	});
}

var btn_search_dictDetail = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : searchDictDetail
});

var cbb_dictIndex_for_dictDetail = new Ext.form.ComboBox({
	name : 'subjectName',
	width : 120,
	displayField : 'subjectName',
	mode : 'remote',
	store : ds_dictIndex_select,
	selectOnFocus : true,
	triggerAction : 'all',
	loadingText : '加载中...',
	emptyText : '字典名称'
});

var text_search_dictDetail = new Ext.form.TextField({
	name : 'textSearchDictDetail',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchDictDetail();
			}
		}
	}
});

var ds_dictDetail = new Ext.data.Store({
	proxy : new Ext.data.HttpProxy({
		url : 'findAllDictDetail.action'
	}),
	reader : new Ext.data.JsonReader({
		totalProperty : 'totalProperty',
		root : 'root'
	}, [{
		name : 'categoryId',
		type : 'int'
	}, {
		name : 'categoryName',
		type : 'string'
	}, {
		name : 'categoryCode',
		type : 'string'
	}, {
		name : 'subjectId',
		type : 'int'
	}, {
		name : 'subjectName',
		type : 'string'
	}, {
		name : 'remark',
		type : 'string'
	}])
});

var grid_dictDetail = new Ext.grid.EditorGridPanel({
	title : '字典分类管理',
	iconCls : 'icon-plugin',
	region : 'center',
	loadMask : {
		msg : '数据加载中...'
	},
	cm : cm_dictDetail,
	ds : ds_dictDetail,
	sm : new Ext.grid.RowSelectionModel({
		singleSelect : true
	}),
	enableColumnMove : false,
	trackMouseOver : false,
	frame : true,
	autoExpandColumn : 'remark',
	clicksToEdit : 1,
	tbar : [btn_add_dictDetail, '-', btn_del_dictDetail, '-', // cbb_company_for_dept,
															// '-',
															// '&nbsp;&nbsp;',
			text_search_dictDetail, btn_search_dictDetail],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_dictDetail,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条  共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'afteredit' : function(e) {
			Ext.Ajax.request({
				url : 'updateDictDetail.action',
				params : {
					fieldName : e.field,
					fieldValue : e.value,
					subjectId : e.field == 'subjectName' ? subjectId : null,
					categoryId : e.record.data.categoryId
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

var p_zzDictDetail = {
	id : 'zzDictDetail-panel',
	border : false,
	layout : 'border',
	items : [grid_dictDetail]
}
