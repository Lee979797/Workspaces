
var ds_ywlx_select25 = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=4',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});


var ds_bzjg_select25 = new Ext.data.Store({
	url:'findBzjgByCenter.action',
	reader:new Ext.data.JsonReader({root:'root'}, 
	[{name:'bzjgId'},{name:'bzjgName'},{name:'bzjgCode'}])
});

var cm_ywxcSet = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),{
	header : '业务类型',
	width :200,
	sortable : true,
	dataIndex : 'ywlx',
	editor : new Ext.form.ComboBox({
		store : ds_ywlx_select25,
		displayField : 'categoryName',
		valueField : 'categoryName',
		mode : 'remote',
		allowBlank : false,
		editable : false,
		triggerAction : 'all',
		listWidth : 200, // 因为列宽度默认比较小,所以设定下拉列表宽度
		listeners : {
			'select' : function(combo, record, index) {
				ywlxdm = record.data.categoryCode; // 保存到全局
			}
		}
		
	})
},{
	header : '办证机构名称',
	width : 200,
	sortable : true,
	dataIndex : 'bzjgmc',
	editor : new Ext.form.ComboBox({
		store : ds_bzjg_select25,
		displayField : 'bzjgName',
		valueField : 'bzjgName',
		mode : 'remote',
		allowBlank : false,
		editable : false,
		triggerAction : 'all',
		listWidth : 200, // 因为列宽度默认比较小,所以设定下拉列表宽度
		listeners : {
			'select' : function(combo, record, index) {
				bzjgdm = record.data.bzjgCode; // 保存到全局
			}
		}
	})
},{
	header : '备注',
	id : 'note',
	dataIndex : 'note',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 250
	})
}]);

cm_ywxcSet.defaultSortable = false;

var window_add_ywxcSet = new Ext.Window({
	title : '添加业务设置',
	width : 370,
	height : 440,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function() {
			this.setTitle('添加新业务设置');
			this.findById('ywlx_zyxs').ownerCt.form.reset();
		}
	},
	items : [new Ext.FormPanel({
		labelWidth : 100,
		labelAlign : 'right',
		url : 'saveYwset.action',
		border : false,
		baseCls : 'x-plain',
		bodyStyle : 'padding:5px 5px 0px 0px 30px',
		anchor : '100%',
		defaults : {
			width : 233,
			msgTarget : 'side'
		},
		defaultType : 'textfield',
		items : [{
			xtype : 'combo',
			fieldLabel : '业务类型',
			id : 'ywlx_zyxs',
			hiddenName : 'ywset.ywlx',
			valueField : 'categoryName',
			displayField : 'categoryName',
			mode : 'remote',
			store : ds_ywlx_select25,
			selectOnFocus : true,
			editable : false,
			allowBlank : false,
			triggerAction : 'all',
			loadingText : '加载中...',
			emptyText : '业务类型名称',
			listeners : { // 获得下拉文本内容,解决id,value都要的情况
				'select' : function(combo, record, index) {
					this.ownerCt.form.findField('ywset.ywlxdm').setValue(record.data.categoryCode);
				}
			}
		},{
			fieldLabel : '业务类型代码',
			//id : 'ywset.ywlxdm',
			name : 'ywset.ywlxdm',
			readOnly:true,
			allowBlank : false,
			maxLength : 50
		},{
			xtype : 'combo',
			fieldLabel : '办证机构名称',
			id : 'bzjgmc_zyxs',
			hiddenName : 'ywset.bzjgmc',
			valueField : 'bzjgName',
			displayField : 'bzjgName',
			mode : 'remote',
			store : ds_bzjg_select25,
			selectOnFocus : true,
			editable : false,
			allowBlank : false,
			triggerAction : 'all',
			loadingText : '加载中...',
			emptyText : '办证机构名称',
			listeners : { // 获得下拉文本内容,解决id,value都要的情况
				'select' : function(combo, record, index) {
					this.ownerCt.form.findField('ywset.bzjgdm').setValue(record.data.bzjgCode);
				}
			}
		},{
			fieldLabel : '办证机构代码',
			//id : 'ywset.bzjgdm',
			name : 'ywset.bzjgdm',
			readOnly:true,
			allowBlank : false,
			maxLength : 50
		},{
			fieldLabel : '备注',
			name : 'ywset.note',
			xtype : 'textarea',
			maxLength : 200
		}, {xtype : 'hidden',name : 'ywset.flag',value:'1'}],
		buttonAlign : 'right',
		minButtonWidth : 60,
		buttons : [{
			text : '保存',
			handler : function(btn) {
				var frm = this.ownerCt.form;
				if (frm.isValid()) {
					btn.disable();
					var dnfield = frm.findField('ywset.ywlx');
					frm.submit({
						waitTitle : '请稍候',
						waitMsg : '正在提交表单数据,请稍候...',
						success : function(form, action) {
							var store = grid_ywxcSet.getStore();
							if (store.data.length <= 20) {
								var ywset = new Ywset({
									ywsetId : action.result.ywsetId,
									ywlx : dnfield.getValue(),
									ywlxdm : form.findField('ywset.ywlxdm').getValue(),
									bzjgdm : form.findField('ywset.bzjgdm').getValue(),
									bzjgmc : form.findField('ywset.bzjgmc').getValue(),
									note : form.findField('ywset.note').getValue()
								});
								store.insert(0, [ywset]);
								if (store.data.length > 20) {
									store.remove(store.getAt(store.data.length - 1));
								}
							}
							window_add_ywxcSet.setTitle('[ ' + dnfield.getValue() + ' ]   添加设置成功!!');
							dnfield.reset();
							frm.findField('ywset.ywlxdm').reset();
							frm.findField('ywset.bzjgmc').reset();
							frm.findField('ywset.bzjgdm').reset();
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

var btn_add_ywxcSet = new Ext.Button({
	text : '添加业务设置',
	iconCls : 'icon-add',
	handler : function() {
		window_add_ywxcSet.show();
	}
});

var btn_del_ywxcSet = new Ext.Button({
	text : '删除业务设置',
	iconCls : 'icon-del',
	handler : function() {
		var record = grid_ywxcSet.getSelectionModel().getSelected();
		if (record) {
			Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
				if (btn == 'yes') {
					Ext.Ajax.request({
						url : 'deleteYwset.action',
						params : {
							ywsetId : record.data.ywsetId
						},
						success : function() {
							grid_ywxcSet.getStore().remove(record);
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

var searchYwxcNet = function() {
	ds_ywxcSet.baseParams.conditions = text_search_ywxcSet.getValue();
	ds_ywxcSet.load({
		params : {
			start : 0,
			limit : 20
		}
	});
}

var btn_search_ywxcSet = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : searchYwxcNet
});



var text_search_ywxcSet = new Ext.form.TextField({
	name : 'textSearchYwset',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchYwxcNet();
			}
		}
	}
});

var ds_ywxcSet = new Ext.data.Store({
	proxy : new Ext.data.HttpProxy({
		url : 'findAllYwset.action?flag=1'
	}),
	reader : new Ext.data.JsonReader({
		totalProperty : 'totalProperty',
		root : 'root'
	},[{
		name : 'ywsetId',
		type : 'int'
	},{
		name : 'ywlx',
		type : 'string'
	},{
		name : 'bzjgmc',
		type : 'string'
	},{
		name : 'bzjgdm',
		type : 'string'
	},{
		name : 'flag',
		type : 'string'
	},{
		name : 'note',
		type : 'string'
	}])
});

var bzjgdm;
var ywlxdm;


var grid_ywxcSet = new Ext.grid.EditorGridPanel({
	title : '现场业务--审核设置',
	iconCls : 'icon-plugin',
	region : 'center',
	loadMask : {
		msg : '数据加载中...'
	},
	cm : cm_ywxcSet,
	ds : ds_ywxcSet,
	sm : new Ext.grid.RowSelectionModel({
		singleSelect : true
	}),
	enableColumnMove : false,
	trackMouseOver : false,
	frame : true,
	autoExpandColumn : 'note',
	clicksToEdit : 1,
	tbar : [btn_add_ywxcSet, '-', btn_del_ywxcSet, '-', text_search_ywxcSet, btn_search_ywxcSet],
	bbar : new Ext.PagingToolbar({
		pageSize : 20,
		store : ds_ywxcSet,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条  共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'afteredit' : function(e) {
			Ext.Ajax.request({
				url : 'updateYwset.action',
				params : {
					fieldName : e.field,
					fieldValue : e.value,
					bzjgdm : e.field == 'bzjgmc' ? bzjgdm : null,
					ywlxdm : e.field == 'ywlx' ? ywlxdm : null,
					ywsetId : e.record.data.ywsetId
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

var p_zzYwxcSet = {
	id : 'zzYwxcSet-panel',
	border : false,
	layout : 'border',
	items : [grid_ywxcSet]
}
