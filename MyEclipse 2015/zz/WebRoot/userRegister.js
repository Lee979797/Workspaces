Ext.onReady(function(){
    var window_pzjgQuery_ur;
    var button = Ext.get('show-btn');
     
    var btn_search_pzjg2 = new Ext.Button({
		text : '查询',
		iconCls : 'icon-search',
		handler : function() {
			if(text_search_pzjg2.getValue().trim()!=''){
				searchPzjg_select();
			}else{
				alert("请输入查询条件");
			}
			
			//btn_search_pzjg.setDisabled(true);
		}
	});

	var text_search_pzjg2 = new Ext.form.TextField({
		id : 'textSearchPzjg',
		name : 'textSearchPzjg',
		width : 200,
		emptyText : '多条件可用逗号或者空格隔开!',
		listeners : {
			'specialkey' : function(field, e) {
				if (e.getKey() == Ext.EventObject.ENTER) {
					searchPzjg_select();
				}
			},
			'change' : function(field, e) {
				btn_search_pzjg2.setDisabled(false);
			}
		}
	});

	var cm_pzjg2 = new Ext.grid.ColumnModel([
		{header : '批准机构名称',width : 50,dataIndex : 'pzjgmc',sortable : true}, 
		{header : '批准机构代码',width : 20,dataIndex : 'pzjgdm',sortable : true},
		{header : '备注',width : 30,dataIndex : 'note',sortable : true}
	]);


	//查询返回结果的数据列
	var ds_pzjg2 = new Ext.data.Store({
		url : 'findAllByConditionPzjg.action',
		reader : new Ext.data.JsonReader(
			{totalProperty : 'totalProperty',root : 'root'}, 
		   [{name : 'pzjgid',type : 'int'}, 
			{name : 'pzjgmc',type : 'string'},
			{name : 'pzjgdm',type : 'string'},
			{name : 'bzjgdm',type : 'string'},
			{name : 'note',type : 'string'}
		])
	});
	
	var searchPzjg_select = function() {
		ds_pzjg2.baseParams.conditions = text_search_pzjg2.getValue();
		ds_pzjg2.baseParams.username='';
		ds_pzjg2.baseParams.stateConditions='';
		ds_pzjg2.load({params : {start : 0,limit : 20} });
	}


	var grid_pzjg_ur = new Ext.grid.GridPanel({
		region : 'center',
		loadMask : {msg : '数据加载中...'},
		enableColumnMove : false,
		cm : cm_pzjg2,
		ds : ds_pzjg2,
		sm : new Ext.grid.RowSelectionModel({singleSelect : true}),
		autoExpandColumn : 'note',
		viewConfig : {forceFit : true},
		tbar : ['请输入登记批准机构名称',text_search_pzjg2,btn_search_pzjg2],
		bbar : new Ext.PagingToolbar({
			pageSize : 20,
			store : ds_pzjg2,
			displayInfo : true,
			displayMsg : '第 {0} - {1} 条 共 {2} 条',
			emptyMsg : "没有记录"
		}),
		listeners : {
			'rowclick':function(grid,rowIndex){
				window_pzjgQuery_ur.hide();
				var selections=grid.getSelectionModel().getSelections(); 
				document.getElementById("pzjgmc").value=selections[0].get('pzjgmc');
				document.getElementById("pzjgdm").value=selections[0].get('pzjgdm');
				document.getElementById("bzjgdm").value=selections[0].get('bzjgdm');
				//alert(selections[0].get('bzjgdm'));
				//userRegisterForm.getForm().findField('pzjgmc').setValue(selections[0].get('pzjgmc'));
				//userRegisterForm.getForm().findField('pzjgdm').setValue(selections[0].get('pzjgdm'));
			}
		}
	});

    button.on('click', function(){
        // create the window on the first click and reuse on subsequent clicks
        if(!window_pzjgQuery_ur){
            window_pzjgQuery_ur = new Ext.Window({
               title : '登记批准机构查询',
					iconCls : 'icon-plugin',
					width :500,
					height:400,
					//plain    : true,
					layout   : 'border',
					resizable : false,
					modal : true,
					resizable : true, 
					maximizable:true,
					closeAction : 'hide',
					items : [grid_pzjg_ur]
            });
        }
        window_pzjgQuery_ur.show(button);
    });
    
});