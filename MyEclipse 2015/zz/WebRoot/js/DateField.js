Ext.namespace("Ext.tet");
Ext.tet.DateField=new Ext.extend(Ext.Panel,{                
         //----------------------------ȱʡ����----------------------
         frame:false,
         autoHeight:true,
         autoWidth:true,           
         createDateField:function(){
                  this.dateTimeBg=new Ext.form.DateField(Ext.apply({
                                            fieldLabel:"��ʼʱ��",  
                                            anchor:"98%",
                                            emptyText:"��ѡ��ʱ��",
                                            format:"Y-m-d"
                                      },Ext.apply(this.beginTimeConfig||{},this.timeConfig)));
                                      
                  this.dateTimeEd=new Ext.form.DateField(Ext.apply({
                                            fieldLabel:"&nbsp;&nbsp;��",
                                            emptyText:"��ѡ��ʱ��",
                                            anchor:"92%",
                                            format:"Y-m-d"
                                      },Ext.apply(this.endTimeConfig||{},this.timeConfig)));  
                                      
                  this.items=[{
                                    layout:'column',
                                    items:[{
                                             columnWidth:0.5, 
                                             layout:'form',
                                             labelWidth:60,                        
                                             items:[this.dateTimeBg]
                                    },{
                                             columnWidth:0.5, 
                                             layout:'form',
                                             labelWidth:25,
                                             items:[this.dateTimeEd]
                                    }]                              
                              }];                     
         },
         //----------------------------�Զ��庯��----------------------
         getBeginDateValue:function(){
              if(this.dateTimeBg.getValue()=="") return "";
              return this.dateTimeBg.getValue().format("Y-m-d");
         },
         getEndDateValue:function(){
              if(this.dateTimeEd.getValue()=="") return "";              
              return this.dateTimeEd.getValue().format("Y-m-d");
         },
         getValue:function(){
             var str=["",""];
             if(this.dateTimeBg.getValue()!="") str[0]=this.dateTimeBg.getValue().format("Y-m-d");
             if(this.dateTimeEd.getValue()!="") str[1]=this.dateTimeEd.getValue().format("Y-m-d");
             return str;
         },
         listeners:{
                 "afterrender":function(comp){                             
                             return true;  //alert(comp.getInnerWidth());     
                  }
         },
         initComponent: function(){
                Ext.tet.DateField.superclass.initComponent.call(this);
         },
         constructor:function(options){                               
                Ext.apply(this,options);
                this.createDateField();                                             
                Ext.tet.DateField.superclass.constructor.call(this);
         }
});


