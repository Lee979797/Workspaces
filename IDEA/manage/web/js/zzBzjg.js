var Bzjg = Ext.data.Record.create([{
	name : 'bzjgId',
	mapping : 'bzjgId',
	type : 'int'
}, {
	name : 'bzjgName',
	mapping : 'bzjgName',
	type : 'string'
}, {
	name : 'bzjgCode',
	mapping : 'bzjgCode',
	type : 'string'
}, {
	name : 'bzjgJcName',
	mapping : 'bzjgJcName',
	type : 'string'
}, {
	name : 'centerId',
	mapping : 'centerId',
	type : 'int'
}, {
	name : 'centerName',
	mapping : 'centerName',
	type : 'string'
}, {
	name : 'centerCode',
	mapping : 'centerCode',
	type : 'string'
}, {
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

var ds_center_select2 = new Ext.data.Store({
	url : 'findAllCenterName.action',
	reader : new Ext.data.JsonReader({
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
	}])
});

var cm_bzjg = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
	header : '办证机构名称',
	width : 180,
	dataIndex : 'bzjgName',
	sortable : true,
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 50
	})
}, {
	header : '办证机构代码',
	width : 100,
	dataIndex : 'bzjgCode',
	sortable : true,
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 50
	})
}, {
	header : '办证机构简称',
	width : 100,
	dataIndex : 'bzjgJcName',
	sortable : true,
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 50
	})
},{
	header : '所属分中心',
	width : 90,
	sortable : true,
	dataIndex : 'centerName',
	editor : new Ext.form.ComboBox({
		store : ds_center_select2,
		displayField : 'centerName',
		valueField : 'centerName',
		mode : 'remote',
		allowBlank : false,
		editable : false,
		triggerAction : 'all',
		listWidth : 130, // 因为列宽度默认比较小,所以设定下拉列表宽度
		listeners : {
			'select' : function(combo, record, index) {
				centerId = record.data.centerId; // 获得分中心id,保存到全局
				centerCode = record.data.centerCode; // 获得分中心id,保存到全局
			}
		}
	})
}, {
	header : '办证机构地址',
	width : 200,
	dataIndex : 'address',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 70
	})
}, {
	header : '办证机构电话',
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
	menuDisabled : true,
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 20
	})
}, {
	header : '联系电话',
	width : 85,
	dataIndex : 'mobilePhone',
	menuDisabled : true,
	resizable : false,
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

cm_bzjg.defaultSortable = false;

var window_add_bzjg = new Ext.Window({
	title : '添加办证机构',
	width : 370,
	height : 440,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function() {
			this.setTitle('添加办证机构');
			this.findById('bzjg.bzjgName').ownerCt.form.reset();
		}
	},
	items : [new Ext.FormPanel({
		labelWidth : 100,
		labelAlign : 'right',
		url : 'saveBzjg.action',
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
			id : 'bzjg.bzjgName',
			name : 'bzjg.bzjgName',
			allowBlank : false,
			maxLength : 50
		}, {
			fieldLabel : '办证机构代码',
			id : 'bzjg.bzjgCode',
			name : 'bzjg.bzjgCode',
			allowBlank : false,
			maxLength : 50
		},{
			fieldLabel : '办证机构简称',
			id : 'bzjg.bzjgJcName',
			name : 'bzjg.bzjgJcName',
			allowBlank : false,
			maxLength : 50
		},{
			xtype : 'combo',
			fieldLabel : '所属分中心',
			id : 'center',
			hiddenName : 'bzjg.centerId',
			valueField : 'centerId',
			displayField : 'centerName',
			mode : 'remote',
			store : ds_center_select2,
			selectOnFocus : true,
			editable : false,
			allowBlank : false,
			triggerAction : 'all',
			loadingText : '加载中...',
			emptyText : '分中心名称',
			listeners : { // 获得下拉文本内容,解决id,value都要的情况
				'select' : function(combo, record, index) {
					this.ownerCt.form.findField('bzjg.centerName').setValue(record.data.centerName);
					this.ownerCt.form.findField('bzjg.centerCode').setValue(record.data.centerCode);
				}
			}
		}, {
			xtype : 'hidden',
			name : 'bzjg.centerName'
		}, {
			fieldLabel : '分中心代码',
			name : 'bzjg.centerCode',
			allowBlank : false,
			readOnly:true,
			maxLength : 70
		}, {
			fieldLabel : '办证机构地址',
			name : 'bzjg.address',
			maxLength : 70
		}, {
			fieldLabel : '办证机构电话',
			name : 'bzjg.tellPhone',
			maxLength : 20
		}, {
			fieldLabel : '负责人',
			name : 'bzjg.leader',
			maxLength : 20
		}, {
			fieldLabel : '联系电话',
			name : 'bzjg.mobilePhone',
			maxLength : 20
		}, {
			fieldLabel : '备注',
			name : 'bzjg.remark',
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
					var dnfield = frm.findField('bzjg.bzjgName');
					frm.submit({
						waitTitle : '请稍候',
						waitMsg : '正在提交表单数据,请稍候...',
						success : function(form, action) {
							var store = grid_bzjg.getStore();
							if (store.data.length <= 20) {
								var bzjg = new Bzjg({
									bzjgId : action.result.bzjgId,
									bzjgName : dnfield.getValue(),
									bzjgCode : form.findField('bzjg.bzjgCode').getValue(),
									bzjgJcName : form.findField('bzjg.bzjgJcName').getValue(),
									centerId : form.findField('bzjg.centerId').getValue(),
									centerName : Ext.get('center').dom.value,
									address : form.findField('bzjg.address').getValue(),
									tellPhone : form.findField('bzjg.tellPhone').getValue(),
									leader : form.findField('bzjg.leader').getValue(),
									mobilePhone : form.findField('bzjg.mobilePhone').getValue(),
									remark : form.findField('bzjg.remark').getValue()
								});
								store.insert(0, [bzjg]);
								if (store.data.length > 20) {
									store.remove(store.getAt(store.data.length - 1));
								}
							}
							window_add_bzjg.setTitle('[ ' + dnfield.getValue() + ' ]   添加成功!!');
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

var btn_add_bzjg = new Ext.Button({
	text : '添加办证机构',
	iconCls : 'icon-add',
	handler : function() {
		window_add_bzjg.show();
	}
});

var btn_del_bzjg = new Ext.Button({
	text : '删除办证机构',
	iconCls : 'icon-del',
	handler : function() {
		var record = grid_bzjg.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
				if (btn == 'yes') {
					Ext.Ajax.request({
						url : 'deleteBzjg.action',
						params : {
							bzjgId : record.data.bzjgId
						},
						success : function() {
							grid_bzjg.getStore().remove(record);
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

var searchBzjg = function() {
	ds_bzjg.baseParams.conditions = text_search_bzjg.getValue();// + ',' +
																// cbb_center_for_bzjg.getValue();
	ds_bzjg.load({
		params : {
			start : 0,
			limit : useFullPageSize
		}
	});
}

var btn_search_bzjg = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : searchBzjg
});

var cbb_center_for_bzjg = new Ext.form.ComboBox({
	name : 'centerName',
	width : 120,
	displayField : 'centerName',
	mode : 'remote',
	store : ds_center_select2,
	selectOnFocus : true,
	triggerAction : 'all',
	loadingText : '加载中...',
	emptyText : '分中心名称'
});

var text_search_bzjg = new Ext.form.TextField({
	name : 'textSearchBzjg',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchBzjg();
			}
		}
	}
});

var ds_bzjg = new Ext.data.Store({
	proxy : new Ext.data.HttpProxy({
		url : 'findAllBzjg.action'
	}),
	reader : new Ext.data.JsonReader({
		totalProperty : 'totalProperty',
		root : 'root'
	}, [{
		name : 'bzjgId',
		type : 'int'
	}, {
		name : 'bzjgName',
		type : 'string'
	}, {
		name : 'bzjgCode',
		type : 'string'
	}, {
		name : 'bzjgJcName',
		type : 'string'
	}, {
		name : 'centerId',
		type : 'int'
	}, {
		name : 'centerName',
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

var centerId; // 存储机构修改时分中心下拉的分中心id
var centerCode; 

var grid_bzjg = new Ext.grid.EditorGridPanel({
	title : '办证机构管理',
	iconCls : 'icon-plugin',
	region : 'center',
	loadMask : {
		msg : '数据加载中...'
	},
	cm : cm_bzjg,
	ds : ds_bzjg,
	sm : new Ext.grid.RowSelectionModel({
		singleSelect : true
	}),
	enableColumnMove : false,
	trackMouseOver : false,
	frame : true,
	autoExpandColumn : 'remark',
	clicksToEdit : 1,
	tbar : [btn_add_bzjg, '-', btn_del_bzjg, '-', // cbb_center_for_bzjg,
													// '-', '&nbsp;&nbsp;',
			text_search_bzjg, btn_search_bzjg],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_bzjg,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条  共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'afteredit' : function(e) {
			Ext.Ajax.request({
				url : 'updateBzjg.action',
				params : {
					fieldName : e.field,
					fieldValue : e.value,
					centerId : e.field == 'centerName' ? centerId : null,
					bzjgId : e.record.data.bzjgId
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

var p_zzBzjg = {
	id : 'zzBzjg-panel',
	border : false,
	layout : 'border',
	items : [grid_bzjg]
}
