Ext.namespace("Ext.tet"); 

　　Ext.tet.ComboBox=new Ext.extend(Ext.form.ComboBox,{ 
　　DataSource:{tableName:null,cols:[],relationValue:n ull,query:null,search:null,where:null,orderBy:null, direction:null}, 
　　ajaxUrl:"/ExtProject/pagination/comBoxPagination.ashx", 
　　typeAhead:true, 

　　forceSelection: true, 

　　triggerAction: 'all', //all 音軟喘 autocomplete孔嬬�� query 軟喘autocomplete孔嬬 

　　emptyText:'萩僉夲佚連', 

　　selectOnFocus:true, 

　　anchor:"97%", 

　　blankText:'萩僉夲匯倖', 

　　readOnly:true, 

　　minChars:1, 

　　lazyRender:true, 

　　selectFirstRow:false, //潮範音僉嶽及匯�� 

　　lazyInit:true, 

　　initComboBox:function(){ 

　　if(this.DataSource){ 

　　if(Ext.type(this.DataSource)=="object"){ //捲暦匂 

　　this.mode="remote"; 

　　if(this.pageSize){ //蛍匈,指渠方象 

　　triggerAction="query"; 

　　} 

　　} 

　　else if(Ext.type(this.DataSource)=="array"){ //云仇方象 

　　this.mode="local"; 

　　} 

　　} 

　　else Ext.Msg.alert("戻幣","DataSource葎腎"); 

　　}, 

　　createStore:function(){ 

　　if(this.DataSource){ //[valueField音嬬嗤嶷鹸峙] 

　　if(!this.displayField) this.displayField=this.valueField; 

　　if(!this.valueField) this.valueField=this.displayField; 

　　if(this.mode=="local"){ 

　　this.store=new Ext.data.SimpleStore({ 

　　fields:[this.displayField,this.valueField], 

　　data:this.DataSource 

　　}); 

　　} 

　　else{ 

　　this.store=new Ext.data.Store({ 

　　proxy:new Ext.data.HttpProxy( 

　　{ 

　　url:this.ajaxUrl, 

　　method:"POST" 

　　}), 

　　reader:new Ext.data.JsonReader( 

　　{ 

　　fields:this.DataSource["cols"], 

　　root:"data", 

　　totalProperty:"totalCount" 

　　}), 

　　remoteSort:true, 

　　sortInfo: {field:this.DataSource["orderBy"]||this.displayFie ld,direction:this.DataSource["direction"]||"Desc"}, 

　　listeners:{ 

　　"beforeload":function(ds,option){ 

　　if(ds.baseParams["relationValue"]==null){ //雫選臥儂 

　　if(ds.baseParams["query"]!=null||ds.baseParams["qu ery"]==""){ 

　　ds.baseParams["where"]=ds.baseParams["search"]+" like '%" + ds.baseParams["query"] + "%'"; 

　　ds.baseParams["query"]=null; 

　　} 

　　} 

　　else{ 

　　ds.baseParams["where"]=ds.baseParams["search"]+" like '%" + ds.baseParams["relationValue"] + "%'"; 

　　} 

　　} 

　　}, 

　　baseParams:{start:0,limit:this.pageSize||1000,sear ch:this.DataSource["search"]||this.displayField,rel ationValue:this.DataSource["relationValue"]||null,t ableName:this.DataSource["tableName"],key:this.valu eField,columns:this.DataSource["cols"].join(","),wh ere:this.DataSource["where"]} 

　　}); 

　　this.store.load(); 

　　} 

　　} 

　　}, 

　　render:function(comb){ 

　　Ext.tet.ComboBox.superclass.render.apply(this, arguments); 

　　if(this.selectFirstRow){ 

　　this.setValue(this.getStore().getAt(0).data[this.v alueField]); 

　　this.fireEvent("select",this,this.getStore().getAt (0),0); 

　　} 

　　}, 

　　constructor:function(options){ 

　　Ext.apply(this,options); 

　　this.initComboBox(); 

　　this.createStore(); 

　　Ext.tet.ComboBox.superclass.constructor.call(this) ; 

　　} 

　　}); 

　　Ext.reg('combobox',Ext.tet.ComboBox); 距喘圭隈