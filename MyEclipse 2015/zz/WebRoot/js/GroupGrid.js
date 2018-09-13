Ext.namespace("Ext.tet");
Ext.tet.GroupGrid=Ext.extend(Ext.grid.GridPanel , {   
             //=====================================�Զ������Խ���============================
             ajaxUrl:"/ExtProject/pagination/pagination.ashx",
             chartUrl:"/ExtProject/pagination/statisChart.ashx",
             excelUrl:"/ExtProject/pagination/toExcel.aspx",
             pageSize:20,
             //DataSourceParams:{tableName:null,key:null,query:null,search:null,where:null,groupBy:null,orderBy:null,direction:"Desc"},
             excelTitle:"���ݵ���",
             excelButton:true,
             chartButton:true,
             queryButton:true,
             loadStore:true,
             singleSelect:true,
             //=====================================����Ĭ��ȱʡ����==========================
             loadMask:true,
             loadMask:{msg:"�������ڼ�����...."},       
          autoScroll:true,
          border:false,
          columnLines:true,
          //height:function(){var de = document.documentElement, bd = document.body; return ((de && de.offsetHeight) || bd.offsetHeight);}(),
          //width:function(){var de = document.documentElement, bd = document.body; return ((de && de.offsetWidth) || bd.offsetWidth);}(), 
             viewConfig: new Ext.grid.GroupingView({  
                forceFit:false,
                sortAscText :'��������',
                sortDescText :'��������',
                columnsText:'����ʾ/����',
                groupByText:'���ݱ��з���',
                showGroupsText:'�Ƿ������ʾ',
                groupTextTpl: '{text} (<b><font color=red>{[values.rs.length]}</font> </b>{[values.rs.length > 0 ? "����Ϣ" : "������Ϣ"]})',
             enableRowBody:true,
             hideGroupedColumn:true,
             getRowClass:function(record,rowIndex,p,ds){                            
                               //if(rowIndex==0) return "x-grid3-row-selected"; //Ĭ��ѡ�ֵ�һ�� 
                               if(rowIndex%2==0)
                                     return "AlternatingRowStyle";
                               else  return "RowStyle"; 
             } 
             }), 
             //====================================�Զ����庯��================================
             setHeight:function(){
                   if(!this.height) this.height=window.screen.availHeight-110;
             },          
             getColumnField:function(){                  
                  var columns =this.cm.getColumnsBy(function(c){ 
                                                      if(c.dataIndex=="") return false;   //ȥ����ѡ��
                                                      return true;
                                                   });                                
                  var field=[];      
                  var excelSql=[]       
                  Ext.each(columns,function(){                      
                      field.push(this.dataIndex);
                      excelSql.push(this.dataIndex+" as "+this.header);
                  });       
                  this.excelSql=excelSql.join(",");           
                  return field;
             },
             getStoreField:function(){
                  if(this.storeField) return this.storeField;
                  var columns =this.cm.getColumnsBy(function(c){ 
                                                       if(c.dataIndex=="") return false;   //ȥ����ѡ��
                                                       return true;
                                                   });  
                  var field=[];
                  var object;
                  Ext.each(columns,function(){                      
                      object={name:this.dataIndex,type:"string",header:this.header};
                      if(this.attribute&&this.attribute.type)
                             object["type"]=this.attribute.type;
                      if(this.attribute&&this.attribute.dateFormat)
                             object["dateFormat"]=this.attribute.dateFormat;
                      field.push(object);
                      object=null;
                  });    
                  this.storeField=field;             
                  return this.storeField;
             },
             getSearchColumns:function(){
                  return this.cm.getColumnsBy(function(c){ 
                                                      if(!c.searchable) return false;  //ȥ������Ҫ��ѯ����
                                                      else if(!c.searchable) return false;                                                      
                                                      return true;
                                              });
             },
             createRowSelectionModel:function(){
                 if(!this.sm) this.sm = new Ext.grid.RowSelectionModel({singleSelect:this.singleSelect});    
             },          
             createStore:function(){
                 if(this.store) return ;
                 var __pageSize=this.pageSize||10000;
                 var __fields=this.getStoreField();                                  
                 var __url= this.ajaxUrl;
                 var __key= this.DataSourceParams["key"];
                 var __groupBy=this.DataSourceParams["groupBy"];
                 var __orderBy=this.DataSourceParams["orderBy"];
                 var __direction=this.DataSourceParams["direction"].toUpperCase();
                 var __baseParams=Ext.apply({start:0,limit:__pageSize,columns:this.getColumnField().join(",")},this.DataSourceParams);
                    this.store =new Ext.data.GroupingStore({
                           proxy:new Ext.data.HttpProxy(
                           {
                                url:this.ajaxUrl,
                                method:"POST"
                           }),
                           reader:new Ext.data.JsonReader(
                           {
                                fields:__fields,
                                root:"data",
                                idProperty:__key,
                                totalProperty:"totalCount"                       
                           }),
                           listeners:{
                                        //scope:this,
                                        //"datachanged":function(){
                                        //             this.getSelectionModel().selectFirstRow(); 
                                        //},
                                        "beforeload":function(ds,option){
                                                            if(ds.baseParams["query"]!=null||ds.baseParams["query"]==""){
                                                                ds.baseParams["where"]=ds.baseParams["search"]+" like '%" + ds.baseParams["query"] + "%'"; 
                                                                ds.baseParams["query"]=null;
                                                            }
                                                     }
                           },       
                           baseParams:__baseParams,                          
                           remoteSort:true,                                    //��̨����
                           sortInfo: {field:__orderBy,direction:__direction},
                           groupOnSort:false,                                  //ǰ̨����
                           groupField:__groupBy                                //ǰ̨����[�������__groupBy=""����]
                    });
                    if(this.loadStore) this.store.load();
             },
             selectFirstRow:function(){
                   this.getSelectionModel().selectFirstRow(); 
             },
             createBbar:function(){
                    if(this.bbar||!this.pageSize) return ;
                    this.pagesize_combo = new Ext.form.ComboBox({    
                         store:new Ext.data.SimpleStore({
                          fields:["text","value"],
                          data:[["10","10"],["15","15"],["20","20"],["30","30"],["50","50"]]
                         }),    
                         width:50,    
                         readOnly:true,    
                         emptyText: '20',    
                         mode:"local",     
                         triggerAction: 'all',    
                         valueField: 'value',    
                         displayField: 'text',
                         valueNotFoundText:this.pageSize   
                    }); 
                    this.pagesize_combo.setValue(this.pageSize);
                    this.bbar=new Ext.PagingToolbar({
                           store:this.store,
                           pageSize:this.pageSize,
                           displayInfo:true,
                           displayMsg:'��ǰ��¼ {0} -- {1} �� �� {2} ����¼',
                              emptyMsg:"û������",
                              prevText:"��һҳ",
                           nextText:"��һҳ",
                           refreshText:"ˢ��",
                           lastText:"���ҳ",
                           firstText:"��һҳ",
                           beforePageText:"��ǰҳ",
                           afterPageText:"��{0}ҳ",
                           items:[
                                 "","-",
                                 '&nbsp;&nbsp;ÿҳ��¼����',
                                 this.pagesize_combo,"-",
                                 {text:"����",iconCls:"excelicon",hidden:!this.excelButton,listeners:{
                                                                               scope:this,
                                                                               "click":function(){                                               
                                                                                    var oiframe=Ext.getDom("gridview_Excelfram");
                                                                                    if(!oiframe){
                                                                                        var oiframe=document.createElement("IFRAME");
                                                                                        oiframe.id="gridview_Excelfram";
                                                                                        oiframe.style.display="none";                                                                                        
                                                                                        window.document.body.appendChild(oiframe);                         
                                                                                    }
                                                                                    oiframe.src=this.excelUrl+"?excelSql="+encodeURIComponent(this.excelSql)+"&excelTitle="+encodeURIComponent(this.excelTitle)+"&tableName="+encodeURIComponent(this.store.baseParams["tableName"])+"&where="+encodeURIComponent(this.store.baseParams["where"])+"&sort="+this.store.sortInfo.field+"&dir="+this.store.sortInfo.direction;
                                                                               }
                                 }},"-",
                                 {text:"ͳ��",iconCls:"charticon",hidden:!this.chartButton,
                                                  listeners:{
                                                  scope:this,
                                                  "click":function(){
                                                           this.chartWindow.show();
                                                  }
                                 }},"-"                                 
                           ]  
                    });
                    this.pagesize_combo.on("select",function(comboBox){ 
                            this.getBottomToolbar().pageSize= parseInt(comboBox.getValue());
                            this.store.baseParams["limit"]=this.getBottomToolbar().pageSize;
                            this.store.reload({params:{start:0}}); 
                    },this);   
             },
createChartWindow:function(){
                  var date=new Date().format("Y-m-d H:i:s");                              
                  
                  this.typeCheckboxGroup=new Ext.form.RadioGroup({                                                        
                                                        allowBlank:false,                                                           
                                                        hideLabel:true,
                                                        height:20,
                                                        columns: 3,
                                                        items: [
                                                            {boxLabel: '����ͼ', name:date+ 'cb-col'},
                                                            {boxLabel: '��״ͼ', name:date+ 'cb-col'},
                                                            {boxLabel: '����ͼ', name:date+ 'cb-col'}
                                                        ],
                                                        listeners:{
                                                             scope:this,
                                                             "change":function(rg,rd){                                                                 
                                                                  this.chartType=rd.boxLabel;
                                                             }
                                                        } 
                                               });
                   
                   var kindItems=[];   
                   var statisItems=[];                            
                    
                   Ext.each(this.storeField,function(){
                           if(this.type=="string"||this.type=="date")
                                    kindItems[kindItems.length]={boxLabel:this.header,name:date+'kindItems',chartKind:this.name}                   
                           else     statisItems[statisItems.length]={boxLabel:this.header,name:date+"statisItems",chartStatis:this.name}   
                   });
                   
                   this.kindRadioGroup=new Ext.form.RadioGroup({
                                                        allowBlank:false,                                                        
                                                        hideLabel:true,
                                                        columns: 4,
                                                        items:kindItems,
                                                        listeners:{
                                                             scope:this,
                                                             "change":function(rg,rd){                                                                 
                                                                 this.chartKind=rd.chartKind;
                                                                 this.chartKindName=rd.boxLabel; 
                                                             }
                                                        } 
                                               });  
                   
                   this.statisRadioGroup=new  Ext.form.RadioGroup({
                                                        allowBlank:false,                                                            
                                                        hideLabel:true,
                                                        columns: 4,
                                                        items:statisItems,
                                                        listeners:{
                                                             scope:this,
                                                             "change":function(rg,rd){                                                                 
                                                                 this.chartStatis=rd.chartStatis;
                                                                 this.chartStatisName=rd.boxLabel; 
                                                             }
                                                        } 
                                               });  
                                              
                   
                   var chartFromPanelButtons=[new Ext.Button({text:"ȷ ��"}),
                                              new Ext.Button({text:"�� ��"}),
                                              new Ext.Button({text:"ȡ ��"})]
                                                                       
                   this.chartFromPanel=new Ext.form.FormPanel({                                                                       
                                                           frame:true,
                                                           buttonAlign:"center",
                                                           items:[                                                                             
                                                                  {     xtype: 'fieldset',
                                                                        title: 'ͼ������',
                                                                        autoHeight: true,
                                                                        layout: 'form',
                                                                        items:[this.typeCheckboxGroup]
                                                                  },{     xtype: 'fieldset',
                                                                        title: '����',
                                                                        autoHeight: true,
                                                                        layout: 'form',
                                                                        items:[this.kindRadioGroup]
                                                                  },{   xtype: 'fieldset',
                                                                        title: 'ͳ������',
                                                                        autoHeight: true,
                                                                        layout: 'form',
                                                                        items:[this.statisRadioGroup]
                                                                  },{
                                                                        xtype: 'fieldset',
                                                                        title: 'ע������',
                                                                        autoHeight: true,
                                                                        layout: 'form',
                                                                        items:[new Ext.form.Label({                                                                                 
                                                                                 text:"ͳ��ͼ���ݲ�ѯ�����������ɡ����û�в�ѯ���ݣ�����ȫ����������ͳ��ͼ��"
                                                                        })]
                                                                  }        
                                                           ],
                                                           buttons:chartFromPanelButtons
                                                }); 
                    
                    chartFromPanelButtons[0].on("click",function(but){
                                    if(this.chartFromPanel.getForm().isValid()){
                                           new Ext.tet.ChartWindow({                                                        
                                                         chartUrl:this.chartUrl,
                                                         DataSourceParams:{tableName:this.store.baseParams["tableName"],where:this.store.baseParams["where"],chartType:this.chartType,chartKind:this.chartKind,chartStatis:this.chartStatis,chartKindName:this.chartKindName,chartStatisName:this.chartStatisName}
                                           }).show();
                                    }
                                    else  Ext.Msg.alert('��ʾ','ÿ���������ѡ��һ��');   
                     },this);                                    
                                                
                    chartFromPanelButtons[1].on("click",function(but){
                                                   this.chartFromPanel.getForm().reset();
                    },this);  
                    
                    chartFromPanelButtons[2].on("click",function(but){
                                                   this.chartWindow.hide();
                    },this); 
                    
                    this.chartWindow = new Ext.Window({
                                                        title:"ͼ�η���",
                                                     width:450,
                                         resizable:false,
                                                        closeAction : 'hide',
                                                        closable:true,
                                                        plain : true,
                                               modal: 'true',
                                               border:false,
                                               iconCls:"charticon",
                                                        items: [this.chartFromPanel]
                                           });
                    
             },
             createQueryMenu:function(){                    
                    if(!this.tbar) this.tbar=[];
                    this.tbar.push({text:"ˢ��",tooltip:"ˢ��ҳ��",iconCls:"refreshicon",ref:"../refBut",handler:function(){window.location.reload();}});                      
                    var items=[];
                    var hightQueryFormPanelItem=[];                 //����߼���ѯ�ؼ�
                    var searchColumns=this.getSearchColumns();      //�õ���ѯ��                  
                    if(searchColumns.length==0){ 
                          this.tbar.unshift([new Ext.Toolbar.Fill()]); 
                          return ;                
                    }
                    Ext.each(searchColumns,function(item,index){    //��̬���ɸ߼���ѯ��һ���ѯ                  
                           if(index==0){ 
                                items[index]={text:this.header,name:this.dataIndex,checked:true};
                           }
                           else items[index]={text:this.header,name:this.dataIndex};
                           if(!this.attribute||!this.attribute.type||this.attribute.type=="string")
                                        if(this.attribute&&this.attribute.xtype=="combobox")
                                        hightQueryFormPanelItem.push(new Ext.tet.ComboBox(Ext.apply({
                                                   type:"string",
                                                   name:this.dataIndex,
                                                   fieldLabel:this.header,
                                                   anchor:"96%",
                                                   emptyText:"��ѡ���ѯ����"
                                        },this.attribute.options)));
                                        else
                                        hightQueryFormPanelItem.push(new Ext.form.TextField({
                                                   type:"string",
                                                   name:this.dataIndex,
                                                   fieldLabel:this.header,
                                                   anchor:"96%",
                                                   emptyText:"�������ѯ����"
                                        }));
                           else if(this.attribute.type=="date")
                                        hightQueryFormPanelItem.push( new Ext.tet.DateField({
                                                   type:"date",
                                                   name:this.dataIndex,
                                                   beginTimeConfig:{fieldLabel:this.header}
                                        }));
                           else if(this.attribute.type=="int")
                                        hightQueryFormPanelItem.push(new Ext.tet.NumberField({
                                                   type:"int",
                                                   name:this.dataIndex,
                                                   numberConfig:{allowDecimals:false,emptyText:"����������"},
                                                   beginNumberConfig:{fieldLabel:this.header}
                                        }));
                           else if(this.attribute.type=="float")
                                        hightQueryFormPanelItem.push(new Ext.tet.NumberField({
                                                   type:"float",
                                                   name:this.dataIndex,
                                                   numberConfig:{decimalPrecision:this.attribute.decimalPrecision||2},
                                                   beginNumberConfig:{fieldLabel:this.header}
                                        }));
                    });  


this.hightQueryFormPanelItem=hightQueryFormPanelItem; //�߼���ѯ�ؼ�
                                      
                    this.store.baseParams["search"]=items[0]["name"];     //Ĭ�ϰ���һ����ѯ�ֶβ�ѯ
                    
                    this.searchTextBox= new Ext.ux.form.SearchField({                                            
                        store: this.store,
                        width:140,
                        height:18,
                        emptyText:"",
                        selectOnFocus:true
                    });                   
                    
                    this.searchTextBut=new Ext.CycleButton({     
                         showText: true,
                         minWidth:60,
                         items:items                        
                    });               
                         
                    this.searchTextBut.on("change",function(btn, item){
                                 this.store.baseParams["search"]=item.name;
                    },this);                   
            
                    
                    var QueryFromPanelButtons=[new Ext.Button({text:"ȷ ��",ref:"../../okBut"}),
                                               new Ext.Button({text:"�� ��",ref:"../../reBut"}),
                                               new Ext.Button({text:"ȡ ��",ref:"../../noBut"})];
                      
                    this.higthQueryFromPanel=new Ext.form.FormPanel({                                                                       
                                                                       frame:true,
                                                                       labelWidth:60,   
                                                                       buttonAlign:"center",
                                                                       items:this.hightQueryFormPanelItem,
                                                                       buttons:QueryFromPanelButtons
                                                 }); 
                    
                    QueryFromPanelButtons[0].on("click",function(but){
                                                    if(this.higthQueryFromPanel.getForm().isValid()){
                                                        Ext.MessageBox.show({
                                                                msg: '���ڲ�ѯ�����Ե�...',
                                           progressText: 'load...',
                                           width:300,
                                           wait:true,
                                           waitConfig: {interval:200},
                                           icon:'download',
                                           animEl: 'loading'
                                                        });
                                                        var where=[];
                                                        Ext.each(this.hightQueryFormPanelItem,function(){
                                                                 if(this.type=="string")
                                                                       where[where.length]=new whereRelation(this.name,this.getValue(),"string",null,null,true)
                                                                 else if(this.type=="date")
                                                                       where[where.length]=new whereRelation(this.name,this.getBeginDateValue(),"string",this.getEndDateValue(),null,null);
                                                                 else if(this.type=="int"||this.type=="float")
                                                                       where[where.length]=new whereRelation(this.name,this.getBeginNumberValue(),"float",this.getEndNumberValue(),null,null);
                                                        });
                                                        var grid=this;
                                                        this.store.baseParams["query"]=null;
                                                        this.store.baseParams["where"]=new FormatWhere(where).getWhereSql();
                                                        this.store.reload({ params:{start:0},
                                                                            callback: function(r, options, success){   
                                                                                            Ext.MessageBox.hide();
                                                                                            if(success){   
                                                                                               grid.hightQueryWindow.hide();
                                                                                               grid.focus();
                                                                                            }else{   
                                                                                               Ext.Msg.alert('����','ʧ�ܣ�');   
                                                                                            }   
                                                                            }
                                                        }); 
                                                                                             
                                                    }   
                    },this);
                    
                    QueryFromPanelButtons[1].on("click",function(but){
                                                   this.higthQueryFromPanel.getForm().reset();
                    },this);  
                    
                    QueryFromPanelButtons[2].on("click",function(but){
                                                   this.hightQueryWindow.hide();
                                                   this.focus();
                    },this);           
                     
                      
                    this.hightQueryWindow = new Ext.Window({
                                                title:"�߼���ѯ",
                                             width:420,
                                       resizable:false,
                                                closeAction : 'hide',
                                                closable:true,
                                                plain : true,
                                             modal: 'true',
                                             border:false,
                                                items: [this.higthQueryFromPanel]
                    });    
                       
                    this.hightQueryBut=new Ext.Button({text:"�߼���ѯ",ref:"../findBut",pressed:true });
                                      
                    this.hightQueryBut.on("click",function(but){
                                      this.hightQueryWindow.show();
                    },this);                                      
                    
                    this.tbar.unshift([this.searchTextBut,this.searchTextBox,"","-","",this.hightQueryBut,new Ext.Toolbar.Fill()]);                                     
             },
             createDataSource:function(){
                    this.DataSourceParams=Ext.apply({tableName:null,key:null,query:null,search:null,where:null,groupBy:null,orderBy:null,direction:"Desc"},this.DataSourceParams);                     
             },
             createListeners:function(){
                    this.listeners=Ext.apply({
                                             'contextmenu':function(e){
                                                    //e.stopEvent();
                                             },
                                             'rowcontextmenu':function(grid,rowIndex,e){
                                                    e.preventDefault();
                                                    if(!grid.getTopToolbar()) return ;
                                                    grid.getSelectionModel().selectRow(rowIndex);
                                                    if(!grid.rowContextMenu){
                                                          var menus=[],but;
                                                          var buttons=grid.getTopToolbar().findByType("button"); 
                                                          for(var i=0;i<buttons.length;i++){
                                                                 but=buttons[i];
                                                                 if(but!=grid.searchTextBut&&but!=grid.hightQueryBut){
                                                                         menus.push({
                                                                                      text:but.text,
                                                                                      iconCls:but.iconCls,
                                                                                      listeners:{
                                                                                          scope:but,
                                                                                         'click':function(item){
                                                                                                 if(this.handler) this.handler();
                                                                                                 else alert("�¼�δ����");    
                                                                                          }
                                                                                      }
                                                                                 });
                                                                 }
                                                                 but=null;     
                                                          }
                                                          grid.rowContextMenu=new Ext.menu.Menu(menus);
                                                    }
                                                    grid.rowContextMenu.showAt(e.getPoint());
                                             },
                                             'rowclick':function(grid,rowIndex,e){
                                                    var rows=this.getSelectionModel().getSelections();
                                                    if(this.selectRowIndex&&this.selectRowIndex==rowIndex) return ; 
                                                    this.selectRowIndex=rowIndex;
                                                    this.selectRow=rows[0];
                                                    this.fireEvent("afterrowclick",this,rowIndex,e,rows);  
                                             },
                                             'afterrowclick':function(grid,rowIndex,e,selectRows){       //�Զ����¼����е���󴥷�  
                                                    return true;
                                             }
                               },this.listeners)  
             },
             initComponent: function(){
                    Ext.tet.GroupGrid.superclass.initComponent.call(this);
             },  
             render:function(gp){                    
                    if(this.chartButton) this.createChartWindow();
                    Ext.tet.GroupGrid.superclass.render.apply(this, arguments);
             },
             constructor:function(options){
                    Ext.apply(this,options);                             
                    this.createDataSource();
                    this.createListeners();
                    this.setHeight();
                    this.createRowSelectionModel();
                    this.createStore();
                    this.createBbar();
                    if(this.queryButton) this.createQueryMenu();                    
                    Ext.tet.GroupGrid.superclass.constructor.call(this);
             }
});
