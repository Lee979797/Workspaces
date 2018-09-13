Ext.namespace("Ext.tet");
Ext.tet.TextField=new Ext.extend(Ext.Panel,{                
         frame:false,
         autoHeight:true,
         autoWidth:true,           
         createTextField:function(){
                  this.TextBg=new Ext.form.TextField(Ext.apply({
                                            emptyText:"请输入信息",  
                                            anchor:"97%"
                                    },Ext.apply(this.beginTextConfig,this.textConfig)));
                                      
                  this.TextEd=new Ext.form.TextField(Ext.apply({
                                            emptyText:"请输入信息",
                                            anchor:"97%"
                                    },Ext.apply(this.endTextConfig,this.textConfig)));  
                                      
                  this.items=[{
                                    layout:'column',
                                    items:[{
                                             columnWidth:0.5, 
                                             layout:'form',
                                             labelWidth:60,                        
                                             items:[this.TextBg]
                                    },{
                                             columnWidth:0.5, 
                                             layout:'form',
                                             labelWidth:60,
                                             items:[this.TextEd]
                                    }]                              
                              }];                     
         },
         getBeginTextValue:function(){
              return this.TextBg.getValue();
         },
         getEndTextValue:function(){
              return this.TextEd.getValue();
         },
         getValue:function(){
             var str=["",""];
             str[0]=this.TextBg.getValue();
             str[1]=this.TextEd.getValue();
             return str;
         },
         initComponent: function(){
                Ext.tet.TextField.superclass.initComponent.call(this);
         },
         constructor:function(options){                               
                Ext.apply(this,options);
                this.createTextField();                                             
                Ext.tet.TextField.superclass.constructor.call(this);
         }
});


