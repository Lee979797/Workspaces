Ext.namespace("Ext.tet");
Ext.tet.NumberField=new Ext.extend(Ext.Panel,{                
         //----------------------------缺省设置----------------------
         frame:false,
         autoHeight:true,
         autoWidth:true,           
         createNumberField:function(){
                  this.NumberBg=new Ext.form.NumberField(Ext.apply({
                                            fieldLabel:"开始",
                                            emptyText:"请输入数字",  
                                            anchor:"98%"
                                    },Ext.apply(this.beginNumberConfig||{},this.numberConfig)));
                                      
                  this.NumberEd=new Ext.form.NumberField(Ext.apply({
                                            fieldLabel:"&nbsp;&nbsp;至",
                                            emptyText:"请输入数字",
                                            anchor:"92%"
                                    },Ext.apply(this.endNumberConfig||{},this.numberConfig)));  
                                      
                  this.items=[{
                                    layout:'column',
                                    items:[{
                                             columnWidth:0.5, 
                                             layout:'form',
                                             labelWidth:60,                        
                                             items:[this.NumberBg]
                                    },{
                                             columnWidth:0.5, 
                                             layout:'form',
                                             labelWidth:25,
                                             items:[this.NumberEd]
                                    }]                              
                              }];                     
         },
         getBeginNumberValue:function(){
              return this.NumberBg.getValue();
         },
         getEndNumberValue:function(){
              return this.NumberEd.getValue();
         },
         getValue:function(){
             var str=["",""];
             str[0]=this.NumberBg.getValue();
             str[1]=this.NumberEd.getValue();
             return str;
         },
         initComponent: function(){
                Ext.tet.NumberField.superclass.initComponent.call(this);
         },
         constructor:function(options){                               
                Ext.apply(this,options);
                this.createNumberField();                                             
                Ext.tet.NumberField.superclass.constructor.call(this);
         }
});

