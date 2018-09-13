var Jglx = Ext.data.Record.create([{
	name : 'jglxid',
	mapping : 'jglxid',
	type : 'int'
}, {
	name : 'jglxmc',
	mapping : 'jglxmc',
	type : 'string'
}, {
	name : 'jglxdm',
	mapping : 'jglxdm',
	type : 'string'
}, {
	name : 'pjglxmc',
	mapping : 'jglxmc',
	type : 'string'
}, {
	name : 'pjglxdm',
	mapping : 'jglxdm',
	type : 'string'
},{
	name : 'ojglxmc',
	mapping : 'jglxmc',
	type : 'string'
}, {
	name : 'ojglxdm',
	mapping : 'jglxdm',
	type : 'string'
}, {
	name : 'note',
	mapping : 'note',
	type : 'string'
}]);
Ext.grid.CheckColumn = function(config) {
	Ext.apply(this, config);
	if (!this.id) {
		this.id = Ext.id();
	}
	this.renderer = this.renderer.createDelegate(this);
};

Ext.grid.CheckColumn.prototype = {
	init : function(grid) {
		this.grid = grid;
		this.grid.on('render', function() {
			var view = this.grid.getView();
			view.mainBody.on('mousedown', this.onMouseDown, this);
		}, this);
	},

	onMouseDown : function(e, t) {
		if (t.className && t.className.indexOf('x-grid3-cc-' + this.id) != -1) {
			e.stopEvent();
			var index = this.grid.getView().findRowIndex(t);
			var cindex = this.grid.getView().findCellIndex(t);
			var record = this.grid.store.getAt(index);
			var field = this.grid.colModel.getDataIndex(cindex);
			var e = {
				grid : this.grid,
				record : record,
				field : field,
				originalValue : record.data[this.dataIndex],
				value : !record.data[this.dataIndex],
				row : index,
				column : cindex,
				cancel : false
			};
			if (this.grid.fireEvent("validateedit", e) !== false && !e.cancel) {
				delete e.cancel;
				record.set(this.dataIndex, !record.data[this.dataIndex]);
				this.grid.fireEvent("afteredit", e);
			}
		}
	},

	renderer : function(v, p, record) {
		p.css += ' x-grid3-check-col-td';
		return '<div class="x-grid3-check-col' + (v ? '-on' : '') + ' x-grid3-cc-' + this.id + '">&#160;</div>';
	}
};

var checkjglxColumn = new Ext.grid.CheckColumn({
	header : "是否审核",
	dataIndex : 'shbz',
	width : 70
});
var cm_jglx = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
	header : '机构类型名称',
	width : 180,
	dataIndex : 'jglxmc',
	sortable : true,
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 50
	})
}, {
	header : '机构类型代码',
	width : 80,
	dataIndex : 'jglxdm',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 6
	})
}, {
	header : '所属机构类型科目名称',
	width : 200,
	dataIndex : 'pjglxmc',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 50
	})
}, {
	header : '所属机构类型科目代码',
	width : 100,
	dataIndex : 'pjglxdm',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 6
	})
}, {
	header : '旧版机构类型科目名称',
	width : 200,
	dataIndex : 'ojglxmc',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 50
	})
}, {
	header : '旧版所属机构类型科目代码',
	width : 100,
	dataIndex : 'ojglxdm',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 6
	})
},checkjglxColumn,{
	header : '备注',
	id : 'note',
	dataIndex : 'note',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 100
	})
}]);

cm_jglx.defaultSortable = false;
var window_add_jglx = new Ext.Window({
	title : '添加机构类型',
	width : 390,
	height : 440,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function() {
			this.setTitle('添加机构类型');
			this.findById('jglx.jglxmc').ownerCt.form.reset();
		}
	},
	items : [new Ext.FormPanel({
		labelWidth : 110,
		labelAlign : 'right',
		url : 'saveJglx.action',
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
			fieldLabel : '机构类型名称',
			id : 'jglx.jglxmc',
			name : 'jglx.jglxmc',
			allowBlank : false,
			maxLength : 50
		}, {
			fieldLabel : '机构类型代码',
			name : 'jglx.jglxdm',
			maxLength : 6
		}, {
			fieldLabel : '所属机构类型名称',
			name : 'jglx.pjglxmc',
			maxLength : 50
		}, {
			fieldLabel : '所属机构类型代码',
			name : 'jglx.pjglxdm',
			maxLength : 6
		}, {
			fieldLabel : '旧版机构类型名称',
			name : 'jglx.ojglxmc',
			maxLength : 50
		}, {
			fieldLabel : '旧版机构类型代码',
			name : 'jglx.ojglxdm',
			maxLength : 6
		},{
			fieldLabel : '备注',
			name : 'jglx.note',
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
					var dnfield = frm.findField('jglx.jglxmc');
					frm.submit({
						waitTitle : '请稍候',
						waitMsg : '正在提交表单数据,请稍候...',
						success : function(form, action) {
							var store = grid_jglx.getStore();
							if (store.data.length <= 20) {
								var jglx = new Jglx({
									jglxid : action.result.jglxid,
									jglxmc : dnfield.getValue(),
									jglxdm : form.findField('jglx.jglxdm').getValue(),
									pjglxmc : form.findField('jglx.pjglxmc').getValue(),
									pjglxdm : form.findField('jglx.pjglxdm').getValue(),
									ojglxmc : form.findField('jglx.ojglxmc').getValue(),
									ojglxdm : form.findField('jglx.ojglxdm').getValue(),
									note : form.findField('jglx.note').getValue()
								});
								store.insert(0, [jglx]);
								if (store.data.length > 20) {
									store.remove(store.getAt(store.data.length - 1));
								}
							}
							window_add_jglx.setTitle('[ ' + dnfield.getValue() + ' ]   添加成功!!');
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

var btn_add_jglx = new Ext.Button({
	text : '添加',
	iconCls : 'icon-add',
	handler : function() {
		window_add_jglx.show();
	}
});

var btn_del_jglx = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	handler : function() {
		var record = grid_jglx.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
				if (btn == 'yes') {
					Ext.Ajax.request({
						url : 'deleteJglx.action',
						params : {
							jglxid : record.data.jglxid
						},
						success : function() {
							grid_jglx.getStore().remove(record);
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

var searchJglx = function() {
	ds_jglx.baseParams.conditions = text_search_jglx.getValue();
	ds_jglx.load({
		params : {
			start : 0,
			limit : useFullPageSize
		}
	});
}

var btn_search_jglx = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : searchJglx
});



var text_search_jglx = new Ext.form.TextField({
	name : 'textSearchJglx',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchJglx();
			}
		}
	}
});

var ds_jglx = new Ext.data.Store({
	proxy : new Ext.data.HttpProxy({
		url : 'findAllByConditionJglx.action'
	}),
	reader : new Ext.data.JsonReader({
		totalProperty : 'totalProperty',
		root : 'root'
	}, [{
		name : 'jglxid',
		type : 'int'
	}, {
		name : 'jglxmc',
		type : 'string'
	}, {
		name : 'jglxdm',
		type : 'string'
	}, {
		name : 'pjglxmc',
		type : 'string'
	}, {
		name : 'pjglxdm',
		type : 'string'
	}, {
		name : 'ojglxmc',
		type : 'string'
	}, {
		name : 'ojglxdm',
		type : 'string'
	}, {
		name : 'shbz',
		type : 'bool'
	}, {
		name : 'note',
		type : 'string'
	}])
});

var companyId; // 存储机构修改时省份下拉的省份id

var grid_jglx = new Ext.grid.EditorGridPanel({
	title : '机构类型管理',
	iconCls : 'icon-plugin',
	region : 'center',
	loadMask : {
		msg : '数据加载中...'
	},
	cm : cm_jglx,
	ds : ds_jglx,
	enableColumnMove : false,
	trackMouseOver : false,
	frame : true,
	plugins:checkjglxColumn,
	autoExpandColumn : 'note',
	clicksToEdit : 1,
	tbar : [btn_add_jglx, '-', btn_del_jglx, '-', text_search_jglx, btn_search_jglx],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_jglx,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条  共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'afteredit' : function(e) {
			Ext.Ajax.request({
				url : 'updateJglx.action',
				params : {
					fieldName : e.field,
					fieldValue : e.value,
					jglxid : e.record.data.jglxid
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

var p_zzJglxManage = {
	id : 'zzJglxManage-panel',
	border : false,
	layout : 'border',
	items : [grid_jglx]
}
