var Hylx = Ext.data.Record.create([{
	name : 'hylxid',
	mapping : 'hylxid',
	type : 'int'
},{
	name : 'hylxmc',
	mapping : 'hylxmc',
	type : 'string'
},{
	name : 'hylxdm',
	mapping : 'hylxdm',
	type : 'string'
},{
	name : 'hylxmc1',
	mapping : 'hylxmc1',
	type : 'string'
},{
	name : 'hylxdm1',
	mapping : 'hylxdm1',
	type : 'string'
},{
	name : 'hylxmc2',
	mapping : 'hylxmc2',
	type : 'string'
},{
	name : 'hylxdm2',
	mapping : 'hylxdm2',
	type : 'string'
},{
	name : 'hylxmc3',
	mapping : 'hylxmc3',
	type : 'string'
},{
	name : 'hylxdm3',
	mapping : 'hylxdm3',
	type : 'string'
},{
	name : 'note',
	mapping : 'note',
	type : 'string'
}]);

var cm_hylx = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
	header : '经济行业名称',
	width : 180,
	dataIndex : 'hylxmc',
	sortable : true,
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 50
	})
}, {
	header : '经济行业代码',
	width : 80,
	dataIndex : 'hylxdm',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 6
	})
}, {
	header : '所属大类名称',
	width : 100,
	dataIndex : 'hylxmc1',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 50
	})
}, {
	header : '所属大类代码',
	width : 80,
	dataIndex : 'hylxdm1',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 6
	})
},{
	header : '所属中类名称',
	width : 100,
	dataIndex : 'hylxmc2',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 50
	})
},{
	header : '所属中类代码',
	width : 80,
	dataIndex : 'hylxdm2',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 6
	})
},{
	header : '所属小类名称',
	width : 100,
	dataIndex : 'hylxmc3',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 50
	})
},{
	header : '所属小类代码',
	width : 80,
	dataIndex : 'hylxdm3',
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

cm_hylx.defaultSortable = false;
var window_add_hylx = new Ext.Window({
	title : '添加经济行业',
	width : 390,
	height : 440,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function() {
			this.setTitle('添加经济行业');
			this.findById('hylx.hylxmc').ownerCt.form.reset();
		}
	},
	items : [new Ext.FormPanel({
		labelWidth : 110,
		labelAlign : 'right',
		url : 'saveHylx.action',
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
			fieldLabel : '经济行业名称',
			id : 'hylx.hylxmc',
			name : 'hylx.hylxmc',
			allowBlank : false,
			maxLength : 50
		},{
			fieldLabel : '经济行业代码',
			name : 'hylx.hylxdm',
			maxLength : 6
		},{
			fieldLabel : '所属大类名称',
			name : 'hylx.hylxmc1',
			maxLength : 50
		},{
			fieldLabel : '所属大类代码',
			name : 'hylx.hylxdm1',
			maxLength : 6
		},{
			fieldLabel : '所属中类名称',
			name : 'hylx.hylxmc2',
			maxLength : 50
		},{
			fieldLabel : '所属中类代码',
			name : 'hylx.hylxdm2',
			maxLength : 6
		},{
			fieldLabel : '所属小类名称',
			name : 'hylx.hylxmc3',
			maxLength : 50
		}, {
			fieldLabel : '所属小类代码',
			name : 'hylx.hylxdm3',
			maxLength : 6
		},{
			fieldLabel : '备注',
			name : 'hylx.note',
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
					var dnfield = frm.findField('hylx.hylxmc');
					frm.submit({
						waitTitle : '请稍候',
						waitMsg : '正在提交表单数据,请稍候...',
						success : function(form, action) {
							var store = grid_hylx.getStore();
							if (store.data.length <= 20) {
								var hylx = new Hylx({
									hylxid : action.result.hylxid,
									hylxmc : dnfield.getValue(),
									hylxdm : form.findField('hylx.hylxdm').getValue(),
									hylxmc1 : form.findField('hylx.hylxmc1').getValue(),
									hylxdm1 : form.findField('hylx.hylxdm1').getValue(),
									hylxmc2 : form.findField('hylx.hylxmc2').getValue(),
									hylxdm2 : form.findField('hylx.hylxdm2').getValue(),
									hylxmc3 : form.findField('hylx.hylxmc3').getValue(),
									hylxdm3 : form.findField('hylx.hylxdm3').getValue(),
									note : form.findField('hylx.note').getValue()
								});
								store.insert(0, [hylx]);
								if (store.data.length > 20) {
									store.remove(store.getAt(store.data.length - 1));
								}
							}
							window_add_hylx.setTitle('[ ' + dnfield.getValue() + ' ]   添加成功!!');
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

var btn_add_hylx = new Ext.Button({
	text : '添加',
	iconCls : 'icon-add',
	handler : function() {
		window_add_hylx.show();
	}
});

var btn_del_hylx = new Ext.Button({
	text : '删除',
	iconCls : 'icon-del',
	handler : function() {
		var record = grid_hylx.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
				if (btn == 'yes') {
					Ext.Ajax.request({
						url : 'deleteHylx.action',
						params : {
							hylxid : record.data.hylxid
						},
						success : function() {
							grid_hylx.getStore().remove(record);
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

var searchHylx = function() {
	ds_hylx.baseParams.conditions = text_search_hylx.getValue();
	ds_hylx.load({
		params : {
			start : 0,
			limit : useFullPageSize
		}
	});
}

var btn_search_hylx = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : searchHylx
});



var text_search_hylx = new Ext.form.TextField({
	name : 'textSearchHylx',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchHylx();
			}
		}
	}
});

var ds_hylx = new Ext.data.Store({
	proxy : new Ext.data.HttpProxy({
		url : 'findAllByConditionHylx.action'
	}),
	reader : new Ext.data.JsonReader({
		totalProperty : 'totalProperty',
		root : 'root'
	},[{
		name : 'hylxid',
		type : 'int'
	},{
		name : 'hylxmc',
		type : 'string'
	},{
		name : 'hylxdm',
		type : 'string'
	},{
		name : 'hylxmc1',
		type : 'string'
	},{
		name : 'hylxdm1',
		type : 'string'
	},{
		name : 'hylxmc2',
		type : 'string'
	},{
		name : 'hylxdm2',
		type : 'string'
	},{
		name : 'hylxmc3',
		type : 'string'
	},{
		name : 'hylxdm3',
		type : 'string'
	},{
		name : 'note',
		type : 'string'
	}])
});

var companyId; // 存储机构修改时省份下拉的省份id

var grid_hylx = new Ext.grid.EditorGridPanel({
	title : '经济行业管理',
	iconCls : 'icon-plugin',
	region : 'center',
	loadMask : {
		msg : '数据加载中...'
	},
	cm : cm_hylx,
	ds : ds_hylx,
	sm : new Ext.grid.RowSelectionModel({
		singleSelect : true
	}),
	enableColumnMove : false,
	trackMouseOver : false,
	frame : true,
	autoExpandColumn : 'note',
	clicksToEdit : 1,
	tbar : [btn_add_hylx, '-', btn_del_hylx, '-', text_search_hylx, btn_search_hylx],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_hylx,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条  共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'afteredit' : function(e) {
			Ext.Ajax.request({
				url : 'updateHylx.action',
				params : {
					fieldName : e.field,
					fieldValue : e.value,
					hylxid : e.record.data.hylxid
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

var p_zzHylxManage = {
	id : 'zzHylxManage-panel',
	border : false,
	layout : 'border',
	items : [grid_hylx]
}
