Ext.namespace("Ext.tet");
Ext.tet.TriggerField=Ext.extend(Ext.form.TriggerField ,{                
             createWindowPanel:function(){
                       if(!this.gridPanel) this.createGridPanel();          
                       this.windowPanel = new Ext.Window(Ext.apply({
                                               title:"信息查询",
                                               closeAction:"hide",
                                               width:500,
                                               height:400,
                                               layout:"fit",
                                               resizable:false,
                                               items:[this.gridPanel]
                       },this.windowPanelConfig));
             },
             createGridPanel:function(){                      
                      this.gridPanel = new Ext.tet.GroupGrid(Ext.apply({},this.gridPanelConfig));  
                      this.gridPanel.on('rowdblclick', function(grid, rowIndex, e) {                              
                              this.windowPanel.hide(this.el);
                              var selections=grid.getSelectionModel().getSelections(); 
                              this.setValue(selections[0].get(this.gridPanelConfig.selectDataIndex));
                      },this);
             }, 
             onTriggerClick: function() {
            	 alert('sss');
                if (!this.windowPanel) this.createWindowPanel();
                this.windowPanel.show(this.el);
             },
             initComponent: function(){
                    Ext.tet.TriggerField.superclass.initComponent.call(this);
             },
             constructor:function(options){                    
                    Ext.apply(this,options);                             
                    Ext.tet.TriggerField.superclass.constructor.call(this);
             }
});

Ext.reg('triggerfield',Ext.tet.TriggerField);

