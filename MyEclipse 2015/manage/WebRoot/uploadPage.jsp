<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head>
		<link rel="Stylesheet" type="text/css" href="ext2.2/data-view.css" />
		<link rel="stylesheet" type="text/css" href="ext2.2/resources/css/ext-all.css" />
		<link rel="stylesheet" href="Ext.ux.UploadDialog/UploadDialog/css/Ext.ux.UploadDialog.css" />
		<script src="ext2.2/ext-base.js"></script>
		<script src="ext2.2/ext-all.js"></script>
		<script src="ext2.2/ext-lang-zh_CN.js"></script>
		<script src="ext2.2/data-view-plugins.js"></script>
		<script type="text/javascript" src="Ext.ux.UploadDialog/Ext.ux.UploadDialog.packed.js"></script>
		<script type="text/javascript">
		// Download by http://www.codefans.net
		   Ext.onReady(function(){
		   Ext.QuickTips.init();
		   var store = new Ext.data.JsonStore({
		       url: '/zz/servlet/DataViewImages',
		       root: 'images',
		       fields: ['name', 'url', {name:'size', type: 'float'}]
		   });
		   store.load();
		
	       var tpl = new Ext.XTemplate(
		    '<tpl for=".">',
	               '<div class="thumb-wrap" id="{name}">',
		        '<div class="thumb"><img src="{url}" title="{name}"></div>',
		        '<span class="">{shortName}</span>',
		        '<span>{sizeString}</span>',
		        '</div>', 
	           '</tpl>',
	           '<div class="x-clear"></div>'
		    );
		    
		       var customEl;
		       var ResizableExample = {
		           init: function(){
		               var custom = new Ext.Resizable('custom', {
		                   wrap:true,
		                   pinned:true,
		                   minWidth:150,
		                   minHeight: 150,
		                   preserveRatio: true,
		                   handles: 'all',
		                   draggable:true,
		                   dynamic:true
		               });
		               customEl = custom.getEl();
		               document.body.insertBefore(customEl.dom, document.body.firstChild);
		               
		               customEl.on('dblclick', function(){
		                   customEl.hide(true);
		               });
		               customEl.hide();
		               
		           }
		       };
		
		       Ext.EventManager.onDocumentReady(ResizableExample.init, ResizableExample, true);
		    
		    var dataview = new Ext.DataView({
		           store: store,
		           id: "dv",
		           tpl: tpl,
		           autoHeight:true,
		           multiSelect: true,
		           overClass:'x-view-over',
		           itemSelector:'div.thumb-wrap',
		           emptyText: 'No images to display',
		
		           plugins: [
		               new Ext.DataView.DragSelector()
		           ],
		
		           prepareData: function(data){
		               data.shortName = Ext.util.Format.ellipsis(data.name, 15);
		               data.sizeString = Ext.util.Format.fileSize(data.size);
		               return data;
		           },
		           
		           listeners: {
		       	    selectionchange: {
		       		    fn: function(dv,nodes){
		       			    var l = nodes.length;
		       			    var s = '';
		       			    panel.setTitle('图片列表 ('+l+' 项'+s+' 被选中)');
		       		    }
		       	    },
		       	    'dblclick': function(){
		       	        var selNode = dataview.getSelectedNodes()[0];
		           
		       	        var i = document.getElementById("custom");
		       	        i.src = "Upload/" + selNode.id;
		       	        
		       	        customEl.center();
		                   customEl.show(true);
		       	    }
		           }
		       });
		
		       var panel = new Ext.Panel({
		           id:'images-view',
		           frame:true,
		           width:535,
		           autoHeight:true,
		           collapsible:true,
		           layout:'fit',
		           title:'图片列表(0 项 被选中)',
		           tbar:[
		               {text: "添加图片", handler: insertImages}, "-",
		               {text: "删除图片", handler: deleteImages}
		           ],
		           butttonAlign: "left",
		           tools: [{
		               id:"refresh",
		               qtip:"刷新图片列表",
		               on:{click:function(){
		   	                panel.body.mask("加载中...", 'x-mask-loading');
		   	                
		   	                setTimeout(function(){
		   	                    store.reload();
		       	                panel.body.unmask();
		   	                }, 1000);
		                }
		               }
		           }],
		           items: dataview
		       });
		       panel.render(Ext.getBody());
		       
		       function insertImages()
		       {
		           dialog = new Ext.ux.UploadDialog.Dialog({
		                 url: '/zz/servlet/Upload',
			          width : 450,
			          height : 300,
			          minWidth : 450,
			          minHeight : 300,
			          draggable : true,
			          resizable : true,
			          modal: true,
		                 reset_on_hide: false,
		                 allow_close_on_upload: false,  
		                 upload_autostart: false 
		               });
		               
		           dialog.show('show-button');
		       }
		       
		       function deleteImages()
		       {
		           var count = dataview.getSelectionCount();
		           var nodes = "";
		           
		           if(count == 0)
		           {
		               Ext.Msg.show({
		                   title:"提示框",
		                   msg:"请选择要删除的图片",
		                   buttons:Ext.MessageBox.OK , 
		                   icon:Ext.MessageBox.INFO
		               });
		               
		               return false;
		           }
		           
		           for(var i = 0; i < count; i++)
		           {
		               nodes += dataview.getSelectedNodes()[i].id;
		               if(i < count -1){
		               	nodes += ",";
		               }
		           }
		           Ext.Msg.confirm("提示框","你确认删除所选图片吗",function(button){ 
		               if (button == "yes")
		               {
		                   Ext.MessageBox.show({
		                       msg:"删除中,请等待...",
		                       progress:true,
		                       progressText: '删除中...',
		                       width:300,
		                       wait:true,
		                       waitConfig:{
		                             interval:100,
		                             duration:1000,
		                             fn:function(){
		                                 Ext.Ajax.request({
		                                     url: "/zz/servlet/DeleteImages",
		                                     params: {
		                                         "Nodes": nodes
		                                     },
		                                     callback: function(options, success, response)
		                                     {
		                                         if(success)
		                                         {
		                                              Ext.Msg.show({
		                                                  title:"提示框",
		                                                  msg:"删除图片成功",
		                                                  buttons:Ext.MessageBox.OK , 
		                                                  icon:Ext.MessageBox.INFO,
		                                                  fn:function(){
		                                                      store.reload();
		                                                  }
		                                              });
		                                         }
		                                         else
		                                         {
		                                              Ext.Msg.show({
		                                                  title:"提示框",
		                                                  msg:"删除图片失败, 请重试",
		                                                  buttons:Ext.MessageBox.OK , 
		                                                  icon:Ext.MessageBox.WARNING
		                                              });   
		                                         }
		                                     }
		                                 });
		                                 
		                                 Ext.MessageBox.hide();
		                       }},
		                       closable:true
		                   });
		               }
		           });
		       }
		   });
		</script>
	</head>
	<body>
		<div id="div1" style="text-align:center; vertical-align:middle">
			<img id="custom" width="200" height="150" style="position:absolute;left:0;top:0;" />
		</div>
	</body>
</html>
