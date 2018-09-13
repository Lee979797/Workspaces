/**
 * 重载EXTJS-HTML编辑器
 * 
 * @class HTMLEditor
 * @extends Ext.form.HtmlEditor
 * @author wuliangbo
 */
HTMLEditor = Ext.extend(Ext.form.HtmlEditor, {
	addImage : function() {
		var editor = this;
		var imgform = new Ext.FormPanel({
			url : 'UploadImg.action?t=' + new Date(),
			region : 'center',
			labelWidth : 55,
			frame : true,
			bodyStyle : 'padding:20px 5px 0 0',
			border : false,
			fileUpload : true,
			items : [{
						xtype : 'textfield',
						fieldLabel : '文件源',
						name : 'imgfile',
						inputType : 'file',
						allowBlank : false,
						blankText : '文件不能为空',
						height : 25,
						anchor : '100%'
					}],
			buttons : [{
				text : '上传',
				handler : function() {
					if (!imgform.getForm().isValid()) {return;}
					
					imgform.getForm().submit({
						waitMsg : '正在上传......',
						method : 'POST',
						success : function(form, action) {
							var element = document.createElement("img");
							element.src = action.result.fileURL;
							if (Ext.isIE) {
								editor.insertAtCursor(element.outerHTML);
							} else {
								var selection = editor.win.getSelection();
								if (!selection.isCollapsed) {
									selection.deleteFromDocument();
								}
								selection.getRangeAt(0).insertNode(element);
							}
							win.hide();
						},
						failure : function(form, action) {
							form.reset();
							if (action.failureType == Ext.form.Action.SERVER_INVALID){
								Ext.MessageBox.alert('警告',action.result.errors.msg);
							}
						}
					});
				}
			}, {
				text : '关闭',
				handler : function() {
					win.close(this);
				}
			}]
		})

		var win = new Ext.Window({
					title : "上传图片",
					width : 320,
					height : 130,
					modal : true,
					border : false,
					iconCls : "icon-img",
					layout : "fit",
					items : imgform

				});
		win.show();
	},
	createToolbar : function(editor) {
		HTMLEditor.superclass.createToolbar.call(this, editor);
		this.tb.insertButton(16, {
					cls : "x-btn-icon",
					icon : "images/picture.png",
					handler : this.addImage,
					scope : this
				});
	}
});
Ext.reg('StarHtmleditor', HTMLEditor);
