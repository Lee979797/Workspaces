// 字典管理
var DictIndex = Ext.data.Record.create([{
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

var cm_dictIndex = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
	header : '字典名称',
	sortable : true,
	menuDisabled : true,
	width : 90,
	dataIndex : 'subjectName',
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 20
	})
}, {
	header : '备注',
	id : 'remark',
	dataIndex : 'remark',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 100
	})
}]);

cm_dictIndex.defaultSortable = false;

var window_add_dictIndex = new Ext.Window({
	title : '添加字典',
	width : 350,
	height : 440,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function() {
			this.setTitle('添加字典');
			this.findById('dictIndex.subjectName').ownerCt.form.reset();
		}
	},
	items : [new Ext.FormPanel({
		labelWidth : 70,
		labelAlign : 'right',
		url : 'saveDictIndex.action',
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
			fieldLabel : '字典名称',
			id : 'dictIndex.subjectName',
			name : 'dictIndex.subjectName',
			allowBlank : false,
			maxLength : 20
		}, {
			fieldLabel : '备注',
			name : 'dictIndex.remark',
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
					var cnfield = frm.findField('dictIndex.subjectName');
					frm.submit({
						waitTitle : '请稍候',
						waitMsg : '正在提交表单数据,请稍候...',
						success : function(form, action) {
							var store = grid_dictIndex.getStore();
							var dictIndex = new DictIndex({
								subjectId : action.result.subjectId,
								subjectName : cnfield.getValue(),
								remark : form.findField('dictIndex.remark').getValue()
							});
							store.insert(0, [dictIndex]);
							window_add_dictIndex.setTitle('[ ' + cnfield.getValue() + ' ]   添加成功!!');
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

var btn_add_dictIndex = new Ext.Button({
	text : '添加字典',
	iconCls : 'icon-add',
	handler : function() {
		window_add_dictIndex.show();
	}
});

var btn_del_dictIndex = new Ext.Button({
	text : '删除字典',
	iconCls : 'icon-del',
	handler : function() {
		var record = grid_dictIndex.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
				if (btn == 'yes') {
					Ext.Ajax.request({
						url : 'deleteDictIndex.action',
						params : {
							subjectId : record.data.subjectId
						},
						success : function() {
							grid_dictIndex.getStore().remove(record);
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

var btn_search_dictIndex = new Ext.Button({
	text : '刷新',
	iconCls : 'icon-search',
	handler : function() {
		ds_dictIndex.load();
	}
});

var ds_dictIndex = new Ext.data.Store({
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
	}, {
		name : 'remark',
		type : 'string'
	}])
});

var grid_dictIndex = new Ext.grid.EditorGridPanel({
	title : '字典管理',
	iconCls : 'icon-grid',
	loadMask : {
		msg : '数据加载中...'
	},
	region : 'center',
	cm : cm_dictIndex,
	ds : ds_dictIndex,
	sm : new Ext.grid.RowSelectionModel({
		singleSelect : true
	}),
	enableColumnMove : false,
	trackMouseOver : false,
	frame : true,
	autoExpandColumn : 'remark',
	clicksToEdit : 1,
	tbar : [btn_add_dictIndex, '-', btn_del_dictIndex, '-', btn_search_dictIndex],
	listeners : {
		'afteredit' : function(e) {
			Ext.Ajax.request({
				url : 'updateDictIndex.action',
				params : {
					fieldName : e.field,
					fieldValue : e.value,
					subjectId : e.record.data.subjectId
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

var p_zzDictIndex = {
	id : 'zzDictIndex-panel',
	border : false,
	layout : 'border',
	items : [grid_dictIndex]
};