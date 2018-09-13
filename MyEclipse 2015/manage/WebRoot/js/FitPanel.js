/**
 * 只容纳一个组件的面板
 * 
 * @class gdda.ux.FitPanel
 * @extends Ext.Panel
 */

FitPanel = Ext.extend(Ext.Panel, {
	id : 'fitpanel_main',
	region : 'center',
	layout : 'card',
	margins : '2 5 5 0',
	activeItem : 0,
	border : false,
	autoDestroy:false,
	currentWidget : new Ext.Panel({}),
	items : this.currentWidget,
	setWidget : function(widget, info) {
		if(!this.getComponent(info)){
			alert("add");
			this.add(widget);
		}
		this.getLayout().setActiveItem(info);
	}
});