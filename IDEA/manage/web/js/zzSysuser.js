
// 用户管理
var User = Ext.data.Record.create([
	{name : 'userId',mapping : 'userId',type : 'int'}, 
	{name : 'emplName',mapping : 'emplName',type : 'string'}, 
	{name : 'emplNo',mapping : 'emplNo',type : 'string'}, 
	{name : 'mobilePhone',mapping : 'mobilePhone',type : 'string'}, 
	{name : 'email',mapping : 'email',type : 'string'}, 
	{name : 'sex',mapping : 'sex',type : 'string'}, 
	{name : 'age',mapping : 'age',type : 'int'}, 
	{name : 'userName',mapping : 'userName',type : 'string'}, 
	{name : 'password',mapping : 'password',type : 'string'}, 
	{name : 'userId',mapping : 'userId',type : 'int'}, 
	{name : 'userName',mapping : 'userName',type : 'string'}, 
	{name : 'bzjgId',mapping : 'bzjgId',type : 'int'}, 
	{name : 'bzjgName',mapping : 'bzjgName',type : 'string'},
	{name : 'bzjgCode',mapping : 'bzjgCode',type : 'string'}, 
	{name : 'dutyId',mapping : 'dutyId',type : 'string'}, 
	{name : 'dutyName',mapping : 'dutyName',type : 'string'}, 
	{name : 'manager',mapping : 'manager',type : 'bool'}, 
	{name : 'remark',mapping : 'remark',type : 'string'},
	{name : 'useUpPageSize',mapping : 'useUpPageSize',type : 'string'}, 
	{name : 'useDownPageSize',mapping : 'useDownPageSize',type : 'bool'}, 
	{name : 'useFullPageSize',mapping : 'useFullPageSize',type : 'string'}
]);

//	var dutyStore = new Ext.data.Store({
//	proxy : new Ext.data.HttpProxy({url : 'findAllDuty.action'}),
//	reader : new Ext.data.JsonReader({root : 'root'}, [{name : 'dutyName',type : 'string'}])
//});
//dutyStore.load();

var ds_duty_select = new Ext.data.Store({
	url : 'findAllDuty.action',
	reader : new Ext.data.JsonReader({root : 'root'},[{name : 'dutyId'}, {name : 'dutyName'}])
});

var ds_bzjg_select = new Ext.data.Store({
	url:'findBzjgByCenter.action',
	reader:new Ext.data.JsonReader({root:'root'}, 
	[{name:'bzjgId'},{name:'bzjgName'},{name:'bzjgCode'}])
});

var ds_center_select = new Ext.data.Store({
	proxy : new Ext.data.HttpProxy({
		url : 'findAllCenterName.action'
	}),
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

var centerId, centerCode,dutyId, bzjgId,bzjgCode,managerId;

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

var checkColumn2 = new Ext.grid.CheckColumn({
	id : 'manager',
	header : "是否管理员",
	dataIndex : 'manager',
	width : 70
});

var qxFormat = function(v){
	//alert(v);
	switch(v){
		case '1': return '省管理员';break;
		case '2': return '市管理员';break;
		case '3': return '县管理员';break;
		//default : return '请选择权限';
	}
}
//
var smps = new Ext.data.SimpleStore({
	data : [['1','省管理员'],['2','市管理员'],['3','县管理员']],
	fields : ['qxCode', 'qxName']
});

var ywqxFormat = function(v){
	switch(v){
		case '1': return '中心业务人员';break;
		case '2': return '跨区业务人员';break;
		case '3': return '区县业务人员';break;
	}
}
var ywqxstore = new Ext.data.SimpleStore({
	data : [['1','中心业务人员'],['2','跨区业务人员'],['3','区县业务人员']],
	fields : ['ywqx', 'ywqxName']
});

var cm_user = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
	header : '用户名',
	width : 40,
	dataIndex : 'userName'
}/*, {
	header : '密码',
	width : 50,
	dataIndex : 'password',
	sortable : false,
	menuDisabled : true,
	renderer : function(value) {return "******";},
	editor : new Ext.form.TextField({
		allowBlank : false,
		minLength : 1,
		maxLength : 25,
		inputType: 'password'
	})
}*/, {
	header : '用户姓名',
	sortable : false,
	menuDisabled : true,
	width : 70,
	dataIndex : 'emplName',
	editor : new Ext.form.TextField({
		allowBlank : false,
		maxLength : 20
	})
}/*, {
	header : '用户编码',
	width : 70,
	dataIndex : 'emplNo',
	hidden : true,
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 20
	})
}*/, {
	header : '电子邮件',
	width : 85,
	dataIndex : 'email',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 99,
		allowBlank : sysAutoMail,
		vtype:'email',
		vtypeText:'不是有效的邮箱地址'
	})
}, {
	header : '手机号码',
	width : 85,
	dataIndex : 'mobilePhone',
	menuDisabled : true,
	editor : new Ext.form.TextField({
		maxLength : 20
	})
}/*, {
	header : '性别',
	width : 50,
	dataIndex : 'sex',
	hidden : true,
	sortable : false,
	menuDisabled : true,
	editor : new Ext.form.ComboBox({
		mode : 'local',
		editable : false,
		store : new Ext.data.SimpleStore({
			data : [['男', '男'], ['女', '女']],
			fields : ['text', 'value']
		}),
		displayField : 'text',
		valueField : 'value',
		mode : 'local',
		triggerAction : 'all'
	})
}, {
	header : '年龄',
	width : 40,
	dataIndex : 'age',
	sortable : false,
	hidden : true,
	menuDisabled : true,
	editor : new Ext.form.NumberField({
		decimalPrecision : 1,
		fieldLabel : '年龄',
		maxLength : 3,
		maxLengthText : '年龄不符合实际',
		maxValue : 120,
		maxText : '最大允许年龄为120岁'
	})
}*/, {
	header : '所属分中心',
	width : 85,
	sortable : false,
	dataIndex : 'centerName',
	menuDisabled : true,
	editor : new Ext.form.ComboBox({
		store : ds_center_select,
		displayField : 'centerName',
		valueField : 'centerName',
		mode : 'remote',
		allowBlank : false,
		editable : false,
		triggerAction : 'all',
		listWidth : 85,
		listeners : {
			'select' : function(combo, record) {
				centerId = record.data.centerId;
				centerCode = record.data.centerCode;
				ds_bzjg_select.baseParams.centerId = centerId;
				ds_bzjg_select.reload();
			}
		}
	})
}, {
	header : '所属办证机构',
	width : 100,
	dataIndex : 'bzjgName',
	sortable : false,
	menuDisabled : true,
	editor : new Ext.form.ComboBox({
		valueField : 'bzjgName',
		displayField : 'bzjgName',
		mode : 'remote',
		store : ds_bzjg_select,
		editable : false,
		allowBlank : false,
		triggerAction : 'all',
		listWidth : 100,
		listeners : {
			'select' : function(combo, record) {// 当选择部门后,获得部门的id保存到全局
				bzjgId = record.data.bzjgId;
				bzjgCode = record.data.bzjgCode;
			},
			'beforequery' : function(queryEvent) {// 在执行下拉查询时,先判断是否参数centerId(单击行时被附值,更换分公司也被赋值)是否存在
				if (!centerId) {
					queryEvent.cancel = true;
				}
			},
			'focus' : function() {
				// 当获得焦点时,设置查询参数,重新加载数据,注意:如果不是每次参数都有可能不一样,不推荐使用这个监听器
				// 因为它每次都要重新加载数据
				ds_bzjg_select.baseParams.centerId = centerId;
				ds_bzjg_select.reload();
			}
		}
	})
}, {
	header : '所属角色',
	width : 300,
	dataIndex : 'dutyName',
	menuDisabled : true,
	sortable : false,
	editor : new Ext.ux.form.LovCombo({
			  fieldLabel:"角色",
			  store:ds_duty_select,
			  mode:'remote',
			  triggerAction:'all',
			  hideTrigger:false,
			  anchor : '100%',
			  width:100,
			  allowBlank : false,
			  editable : false,
			  labelSeparator:'',
			  displayField:'dutyName',
			  valueField:'dutyName',
			  hiddenName : 'dutyId',
			  emptyText:'请选择角色',
			  editable:false,
			  listeners : {
			  	
			  	'select' : function(combo, record, index) {
//			  		alert(combo.getValue());
//			  		alert(index+"|"+dutyId);
			  		if(dutyId=="" || typeof(dutyId)=="undefined"){
			  			dutyId=record.data.dutyId;
			  		}else{
			  			dutyId = dutyId+","+record.data.dutyId;
			  		}
					
				}
			}
		})
}, {
	header : '管理权限',
	width : 85,
	sortable : false,
	dataIndex : 'qxCode',
	menuDisabled : true,
	renderer : qxFormat,
	editor : new Ext.form.ComboBox({
		store : smps,
		displayField : 'qxName',
		valueField : 'qxCode',
		//hiddenName : 'qxCode',
		emptyText:'请选择权限',
		mode : 'local',
		allowBlank : false,
		editable : false,
		triggerAction : 'all',
		listWidth : 85,
		listeners : {
			'select' : function(combo, record) {
				//centerId = record.data.centerId;
				//centerCode = record.data.centerCode;
				//ds_bzjg_select.baseParams.centerId = centerId;
				//ds_bzjg_select.reload();
			}
		}
	})
}, {
	header : '业务权限',
	width : 85,
	sortable : false,
	dataIndex : 'ywqx',
	menuDisabled : true,
	renderer : ywqxFormat,
	editor : new Ext.form.ComboBox({
		store : ywqxstore,
		displayField : 'ywqxName',
		valueField : 'ywqx',
		//hiddenName : 'qxCode',
		emptyText:'请选择权限',
		mode : 'local',
		allowBlank : false,
		editable : false,
		triggerAction : 'all',
		listWidth : 85
	})
}, 
/*checkColumn2,*/ {
	header : '备注',
	id : 'remark',
	dataIndex : 'remark',
	menuDisabled : true,
	sortable : false,
	editor : new Ext.form.TextField({
		maxLength : 200
	})
}]);

cm_user.defaultSortable = true;

var btn_add_user = new Ext.Button({
	text : '添加用户',
	iconCls : 'icon-add',
	handler : function() {
		window_add_user.show();
	}
});

var btn_del_user = new Ext.Button({
	text : '删除用户',
	iconCls : 'icon-del',
	handler : function() {
		var record = grid_user.getSelectionModel().getSelected();
		if (record) {
			if(record.data.userId!=1){
				Ext.Msg.confirm('确认删除', '你确定删除该条记录?', function(btn) {
					if (btn == 'yes') {
						ajaxLoadMask.show();
						Ext.Ajax.request({
							url : 'deleteUser.action',
							params : {userId : record.data.userId},
							success : function() {ajaxLoadMask.hide();grid_user.getStore().remove(record);},
							failure : function() {
								ajaxLoadMask.hide();
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
			}else{
				Ext.Msg.show({
					title : '错误提示',
					msg : 'admin用户不能删除!',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.ERROR
				});
			}
		}
	}
});

var text_search_user = new Ext.form.TextField({
	name : 'textSearchUser',
	width : 200,
	emptyText : '多条件可用逗号或者空格隔开!',
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchUser();
			}
		}
	}
});

var searchUser = function() {
	ds_user.baseParams.conditions = text_search_user.getValue(); 
	ds_user.load({params : {start : 0,limit : useFullPageSize}});
}

var btn_search_user = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : searchUser
});

var ds_user = new Ext.data.Store({
	url : 'findAllUser.action',
	reader : new Ext.data.JsonReader({totalProperty : 'totalProperty',root : 'root'}, 
	[{name : 'userId',type : 'int'}, 
	{name : 'userName',type : 'string'}, 
	{name : 'password',type : 'string'}, 
	{name : 'mobilePhone',type : 'string'}, 
	{name : 'email',type : 'string'}, 
	{name : 'emplName',type : 'string'}, 
	{name : 'emplNo',type : 'string'}, 
	{name : 'sex',type : 'string'}, 
	{name : 'age',type : 'int'},
	{name : 'centerId',type : 'int'},
	{name : 'centerName',type : 'string'},
	{name : 'centerCode',type : 'string'},
	{name : 'bzjgId',type : 'int'},
	{name : 'bzjgName',type : 'string'},
	{name : 'bzjgCode',type : 'string'},
	{name : 'dutyId',type : 'int'},
	{name : 'dutyName',type : 'string'},
	{name : 'manager',type : 'bool'},
	{name : 'qxCode',type : 'string'},
	{name : 'ywqx',type : 'string'},
	{name : 'remark',type : 'string'}])
});



var grid_user = new Ext.grid.EditorGridPanel({
	title : '系统用户管理',
	iconCls : 'icon-grid',
	loadMask : {msg : '数据加载中...'},
	region : 'center',
	cm : cm_user,
	ds : ds_user,
	plugins : checkColumn2,
	sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
	enableColumnMove : false,
	trackMouseOver : false,
	frame : true,
	autoExpandColumn : 'remark',
	clicksToEdit : 1,
	tbar : [btn_add_user, '-', btn_del_user, '-',text_search_user, btn_search_user],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_user,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条  共 {2} 条',
		emptyMsg : "没有记录"
	}),
	listeners : {
		'afteredit' : function(e) {
			Ext.Ajax.request({
				url : 'updateUser.action',
				params : {
					fieldName : e.field,
					fieldValue : e.value,
					centerId : e.field == 'centerName' ? centerId : null,
					bzjgId : e.field == 'bzjgName' ? bzjgId : null,
					dutyId : e.field == 'dutyName' ? dutyId : null,
					managerId:e.record.data.manager,
					userId : e.record.data.userId,
					centerCode : centerCode,
					bzjgCode : bzjgCode//,
					//qxCode : qxCode
				},
				success : function() {
					if (e.field == 'centerName') {// 如果公司修改成功则同步当前显示修改记录的中心id
						e.record.set('centerId', centerId);
					}
				},
				failure : function() {
					Ext.Msg.show({
						title : '错误提示',
						msg : '修改数据发生错误,操作将被回滚!',
						fn : function() {e.record.set(e.field, e.originalValue);},
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
				}
			});
		},
		'cellclick' : function(grid, rowIndex) { // 为了部门下拉能够提取到分公司id的参数
			centerId = grid.getStore().getAt(rowIndex).data.centerId;
		}
	}
});

var window_add_user = new Ext.Window({
	title : '添加系统用户',
	width : 350,
	resizable : false,
	autoHeight : true,
	modal : true,
	closeAction : 'hide',
	listeners : {
		'hide' : function() {
			this.setTitle('添加系统用户');
			this.findById('user.userName').ownerCt.form.reset();
		}
	},
	items : [new Ext.FormPanel({
		border : false,
		baseCls : 'x-plain',
		bodyStyle : 'padding:5px 5px 0',
		labelAlign : 'right',
		labelWidth : 90,
		url : 'saveUser.action',
		defaults : {anchor : '93%',msgTarget : 'side'},
		defaultType : 'textfield',
		items : [{
			fieldLabel : '用户名',
			id : 'user.userName',
			name : 'user.userName',
			allowBlank : false,
			maxLength : 30
		}, {
			fieldLabel : '密码',
			id : 'password1',
			name : 'user.password',
			allowBlank : false,
			minLength : 1,
			maxLength : 25
		}, {
			xtype : 'combo',
			fieldLabel : '所属分中心',
			id : 'center2',
			hiddenName : 'user.centerId',
			valueField : 'centerId',
			displayField : 'centerName',
			mode : 'remote',
			store : ds_center_select,
			selectOnFocus : true,
			editable : false,
			allowBlank : false,
			triggerAction : 'all',
			loadingText : '加载中...',
			emptyText : '请选择分中心名称',
			listeners : {
				'select' : function(combo, record, index) {
					this.ownerCt.findById('bzjg').reset(); // 可以通过findById来获得同一个表单中的ComboBox
					ds_bzjg_select.baseParams.centerId = this.ownerCt.form.findField('user.centerId').getValue();
					ds_bzjg_select.reload();
					this.ownerCt.form.findField('user.centerName').setValue(record.data.centerName);
					this.ownerCt.form.findField('user.centerCode').setValue(record.data.centerCode);
				}
			}
		}, {
			xtype : 'hidden',
			name : 'user.centerName'
		}, {
			xtype : 'hidden',
			name : 'user.centerCode'
		}, {
			xtype : 'combo',
			fieldLabel : '所属办证机构',
			id : 'bzjg',
			hiddenName : 'user.bzjgId',
			valueField : 'bzjgId',
			displayField : 'bzjgName',
			mode : 'remote',
			store : ds_bzjg_select,
			selectOnFocus : true,
			editable : false,
			allowBlank : false,
			triggerAction : 'all',
			loadingText : '加载中...',
			emptyText : '办证机构名称',
			listeners : {
				'select' : function(combo, record, index) {
					this.ownerCt.form.findField('user.bzjgName').setValue(record.data.bzjgName);
					this.ownerCt.form.findField('user.bzjgCode').setValue(record.data.bzjgCode);
				},
				'beforequery' : function(queryEvent) {
					if (!this.ownerCt.form.findField('user.centerId').getValue()) {
						queryEvent.cancel = true;
					}
				}
			}
		}, {xtype : 'hidden',name : 'user.bzjgName'}, {xtype : 'hidden',name : 'user.bzjgCode'}, 
		   new Ext.ux.form.LovCombo({
			  name:"inzlststus",
			  id : 'duty',
			  fieldLabel:"所属角色",
			  store:ds_duty_select,
			  mode:'remote',
			  triggerAction:'all',
			  hideTrigger:false,
			  anchor : '100%',
			  width:180,
			  allowBlank : false,
			  editable : false,
			  labelSeparator:'',
			  displayField:'dutyName',
			  hiddenName : 'user.dutyId',
			  valueField : 'dutyId',
			  loadingText : '加载中...',
			  emptyText:'请选择角色',
			  editable:false,
			  listeners : {
					'select' : function(combo, record, index) {
						var strDutyName=this.ownerCt.form.findField('user.dutyName').getValue();
						//alert(strDutyName);
						if(strDutyName=="" || strDutyName==null){
							this.ownerCt.form.findField('user.dutyName').setValue(record.data.dutyName);
						}else{
							this.ownerCt.form.findField('user.dutyName').setValue(strDutyName+","+record.data.dutyName);
						}
					}
			 }
		})	
		, {xtype : 'hidden',name : 'user.dutyName'}, 
		{xtype : 'combo',
			fieldLabel : '管理权限',name : 'user.qxCode',
			allowBlank : false,
			mode : 'local',
			store : smps,
			displayField : 'qxName',
			valueField : 'qxCode',
			hiddenName : 'user.qxCode',
			emptyText:'请选择权限',
			editable : false,
			triggerAction : 'all'
		},
		{xtype : 'combo',
			fieldLabel : '业务权限',name : 'user.ywqx',
			allowBlank : false,
			mode : 'local',
			store : ywqxstore,
			displayField : 'ywqxName',
			valueField : 'ywqx',
			hiddenName : 'user.ywqx',
			emptyText:'请选择权限',
			editable : false,
			triggerAction : 'all'
		},
		{fieldLabel : '用户姓名',name : 'user.emplName',allowBlank : false,maxLength : 20},
		   {fieldLabel : '用户编码',name : 'user.emplNo',maxLength : 20}, 
		   {xtype : 'combo',
			fieldLabel : '性别',
			mode : 'local',
			name : 'user.sex',
			editable : false,
			store : new Ext.data.SimpleStore({
				data : [['男', '男'], ['女', '女']],
				fields : ['text', 'value']
			}),
			displayField : 'text',
			valueField : 'value',
			mode : 'local',
			triggerAction : 'all'
		}, {
			xtype : 'numberfield',
			decimalPrecision : 1,
			fieldLabel : '年龄',
			maxLength : 3,
			maxLengthText : '年龄不符合实际',
			maxValue : 120,
			maxText : '最大允许年龄为120岁',
			name : 'user.age'
		}, {fieldLabel : '联系电话',name : 'user.mobilePhone',maxLength : 20}, 
		   {fieldLabel : '电子邮件',name : 'user.email',maxLength : 100,allowBlank : sysAutoMail,vtype:'email',vtypeText:'不是有效的邮箱地址'}, 
		   {fieldLabel : '备注',name : 'user.remark',xtype : 'textarea',maxLength : 100}
		],
		buttonAlign : 'right',
		minButtonWidth : 60,
		buttons : [{
			text : '添加',
			handler : function(btn) {
				var frm = this.ownerCt.form;
				if (frm.isValid()) {
					btn.disable();
					var unfield = frm.findField('user.userName');
					frm.submit({
						waitTitle : '请稍候',
						waitMsg : '正在提交表单数据,请稍候...',
						success : function(form, action) {
							var store = grid_user.getStore();
							if (store.data.length <= 20) {
								var user = new User({
									userId : action.result.userId,
									userName : unfield.getValue(),
									centerId : form.findField('user.centerId').getValue(),
									centerName : Ext.get('center2').dom.value,
									bzjgId : form.findField('user.bzjgId').getValue(),
									bzjgName : Ext.get('bzjg').dom.value,
									dutyId : form.findField('user.dutyId').getValue(),
									dutyName : Ext.get('duty').dom.value,
									emplName : form.findField('user.emplName').getValue(),
									qxCode : form.findField('user.qxCode').getValue(),
									ywqx : form.findField('user.ywqx').getValue(),
									emplNo : form.findField('user.emplNo').getValue(),
									sex : form.findField('user.sex').getValue(),
									age : form.findField('user.age').getValue(),
									password : form.findField('user.password').getValue(),
									mobilePhone : form.findField('user.mobilePhone').getValue(),
									email : form.findField('user.email').getValue(),
									remark : form.findField('user.remark').getValue()
								});
								store.insert(0, [user]);
								if (store.data.length > 20) {
									store.remove(store.getAt(store.data.length - 1));
								}
							}
							window_add_user.setTitle('[ ' + unfield.getValue() + ' ]   添加成功!!');
							unfield.reset();
							form.findField('user.emplName').reset();
							form.findField('user.password').reset();
							form.findField('user.mobilePhone').reset();
							form.findField('user.qxCode').reset();
							form.findField('user.ywqx').reset();
							form.findField('user.email').reset()
							btn.enable();
						},
						failure : function() {
							Ext.Msg.show({
								title : '错误提示',
								msg : '"' + unfield.getValue() + '" ' + '名称可能已经存在!',
								buttons : Ext.Msg.OK,
								fn : function() {
									unfield.focus(true);
									btn.enable();
								},
								icon : Ext.Msg.ERROR
							});
						}
					});
				}
			}
		}, {text : '重置',handler : function() {this.ownerCt.form.reset();}
		}, {text : '取消',handler : function() {this.ownerCt.ownerCt.hide();}
		}]
	})]
});

var p_zzSysuser = {
	id : 'zzSysuser-panel',
	border : false,
	layout : 'border',
	items : [grid_user]
};