var smqx1 = new Ext.grid.CheckboxSelectionModel();
var smqx2 = new Ext.grid.CheckboxSelectionModel();
var qxYwlx = [
	['1','新办',''],['2','年检',''],['3','变更',''],
	['4','换证',''],['5','补证',''],['6','迁入',''],
	['7','迁出',''],['8','预赋码',''],['9','注销',''],['10','批量注销','']
]; 
var qxYwlxStore = new Ext.data.SimpleStore({fields:['ywlxCode','ywlx','shbz'],data:qxYwlx});
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
	onMouseDown : function(e, t){
        if(t.className && t.className.indexOf('x-grid3-cc-'+this.id) != -1){
            e.stopEvent();
            var index = this.grid.getView().findRowIndex(t);
            var record = this.grid.store.getAt(index);
            //console.log(record.data[this.dataIndex]);
            record.set(this.dataIndex, !record.data[this.dataIndex]);
            //console.log(record.data[this.dataIndex]);
        }
    },
	renderer : function(v, p, record) {
		p.css += ' x-grid3-check-col-td';
		return '<div class="x-grid3-check-col' + (v ? '-on' : '') + ' x-grid3-cc-' + this.id + '">&#160;</div>';
	}
};
var checkJglxColumn = new Ext.grid.CheckColumn({
	header : "是否审核机构类型",
	dataIndex : 'shbz',
	width : 150
});
var qxYwPanel = new Ext.grid.GridPanel({
    columns : [smqx1,
		{header : '业务代码',width : 100,	dataIndex : 'ywlxCode',sortable : true},
		{header : '业务类型',width : 100,	dataIndex : 'ywlx',id:'ywlx',sortable : true},
		checkJglxColumn
	],
	store : qxYwlxStore,
	selModel : smqx1,//new Ext.grid.CheckboxSelectionModel(),
	plugins : checkJglxColumn,
	autoExpandColumn : 'ywlx'
});

//默认查询 limit为显示的条数,测试时候不用打印标志为限制
var searchQxBzjg = function() {
	ds_qxBzjg.baseParams.conditions = text_search_qxBzjg.getValue();
	ds_qxBzjg.load({params : {start : 0,limit : useFullPageSize} });
	
	var unYwSelects = qxYwPanel.getSelectionModel();
	if(unYwSelects){
		unYwSelects.clearSelections();
	}
}

var btn_search_qxBzjg = new Ext.Button({
	text : '查询',
	iconCls : 'icon-search',
	handler : function() {
		searchQxBzjg();
	}
});
var text_search_qxBzjg = new Ext.form.TextField({
	id:'textSearchQxBzjg',
	name : 'textSearchQxBzjg',
	width : 200,
	listeners : {
		'specialkey' : function(field, e) {
			if (e.getKey() == Ext.EventObject.ENTER) {
				searchQxBzjg();
			}
		}
	}
});
var btn_save_qxBzjgYw = new Ext.Button({
	text : '保存设置',
	iconCls : 'blist',
	handler : function() {
		var bzjgRecords = grid_qxBzjg.getSelectionModel().getSelections();
		var ywlxRecords = qxYwPanel.getSelectionModel().getSelections();
		if(bzjgRecords.length>0&&ywlxRecords.length>0){
			//有选项
			var bzjgs=[];var ywlxs=[];
			for(var i=0;i<bzjgRecords.length;i++){
				bzjgs.push(bzjgRecords[i].data.bzjgCode);
			}
			
			for(var i=0;i<ywlxRecords.length;i++){
				var shbz = ywlxRecords[i].data.shbz==true? 1:0;
				ywlxs.push(ywlxRecords[i].data.ywlxCode+"/"+shbz+"/"+ywlxRecords[i].data.ywlx);
			}
			ajaxLoadMask.show();
			Ext.Ajax.request({
				url: 'saveBzjgYwSet.action',
				params: {bsStr:Ext.util.JSON.encode(bzjgs),ywStr:Ext.util.JSON.encode(ywlxs)},
				success: function(form,action){
					ajaxLoadMask.hide();
					Ext.Msg.show({
						title : '提示',
						msg : '审核范围设置成功！',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.INFO
					});
				},
				failure : function() {
					ajaxLoadMask.hide();
					Ext.Msg.show({
						title : '错误',
						msg : '审核范围设置办理失败!',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
				}
			});
		}else{
			alert("请选择办证机构及业务类型后再进行保存设置操作！");
		}
	}
});
var btn_del_qxBzjgYw = new Ext.Button({
	text : '清除设置',
	iconCls : 'icon-del',
	handler : function() {
		var bzRecords = grid_qxBzjg.getSelectionModel().getSelections();
		if(bzRecords.length>0){
			var bs=[];
			for(var i=0;i<bzRecords.length;i++){
				bs.push(bzRecords[i].data.bzjgCode);
			}
			Ext.Msg.show({
				title : '信息提示',
				msg : '确定要对选定的办证机构所对应的的设置进行删除？',
				icon : Ext.Msg.INFO,
				buttons : Ext.Msg.OKCANCEL,
				fn: function(btn){
					if(btn=="ok"){
						Ext.Ajax.request({
							url: 'delBzjgYwSet.action',
							params: {bsStr:Ext.util.JSON.encode(bs)},
							success: function(form,action){
								Ext.Msg.show({
									title : '提示',
									msg : '对应办证机构的审核设置已清除！',
									buttons : Ext.Msg.OK,
									icon : Ext.Msg.ERROR
								});
							},
							failure : function() {
								ajaxLoadMask.hide();
								Ext.Msg.show({
									title : '错误',
									msg : '审核设置清除发生错误!',
									buttons : Ext.Msg.OK,
									icon : Ext.Msg.ERROR
								});
							}
						});
					}
				}
			});
		}else{
			Ext.Msg.show({
				title : '提示',
				msg : '请先选择要清除设置的办证机构！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.ERROR
			});
		}
	}
});
var ds_qxBzjg = new Ext.data.Store({
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
function searchAllBzjg(){
	ds_qxBzjg.load({params : {start : 0,limit : useFullPageSize} });
}
var cm_qxBzjg = new Ext.grid.ColumnModel([
	smqx2,
	{header : '办证机构代码',width : 20,dataIndex : 'bzjgCode',sortable : true},
	{header : '办证机构名称',width : 60,dataIndex : 'bzjgName',sortable : false}
]);
//加载右栏主页面   （数据列表、工具栏按钮）
var grid_qxBzjg = new Ext.grid.GridPanel({
	region : 'center',
	loadMask : {msg : '数据加载中...'},
	enableColumnMove : false,
	cm : cm_qxBzjg,
	ds : ds_qxBzjg,
	sm : smqx2,//new Ext.grid.CheckboxSelectionModel(),
	autoExpandColumn : 'bzjgName',
	viewConfig : {forceFit : true},
	tbar : [btn_save_qxBzjgYw,btn_del_qxBzjgYw,'->',text_search_qxBzjg,btn_search_qxBzjg],
	bbar : new Ext.PagingToolbar({
		pageSize : useFullPageSize,
		store : ds_qxBzjg,
		displayInfo : true,
		displayMsg : '第 {0} - {1} 条 共 {2} 条',
		emptyMsg : "没有工单记录"
	}),
	listeners : {
		'rowdblclick':function(grid, rowIndex){
			//qxYwPanel.getSelectionModel()
			var bzjgCode = grid.getStore().getAt(rowIndex).data.bzjgCode;
			Ext.Ajax.request({
				url: 'findByBzjgCode.action',
				params: {bzjgCode:bzjgCode},
				success: function(result,request){
					eval("var data="+result.responseText);
					var yw = [];
					for(var a=0;a<ywlxStr.length;a++){
						var record = qxYwPanel.getStore().getAt(a);
						record.set("shbz", "");
					}
					for(var i=0;i<data.length;i++){
						var r = data[i];// ywlxCode shbz
						for(var j=0;j<ywlxStr.length;j++){
							var record = qxYwPanel.getStore().getAt(j);
							if(r.ywlxCode == record.data.ywlxCode){
								yw.push(j);
								if(r.shbz==1){
						            record.set("shbz", r.shbz);
								}
								break;
							}
						}
					}
					qxYwPanel.getSelectionModel().selectRows(yw);
				}
			});
		}
	}
});

var zzQXSetPanel = new Ext.Panel({
	title : '现场业务--审核设置',
	iconCls : 'icon-plugin',
	region : 'center',
	border : 'layout',
	frame : true,
	layout:'border',
	defaults: {
	    collapsible: true,
	    split: true
	},
	items: [{
	    region:'center',
	    layout : 'border',
	    items : [grid_qxBzjg]
	},{
	    region: 'south',
	    layout :'fit',
		title : '业务选择',
	    height: 250,
	    minSize: 150,
	    maxSize: 450,
	    margins     : '0 0 0 0',
    	cmargins    : '5 0 0 0',
	    items : [qxYwPanel]
	}]
});
var p_zzQXSet = {
	id : 'zzQXSet-panel',
	border : false,
	layout : 'border',
	items : [zzQXSetPanel]
}