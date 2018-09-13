
Ext.form.TextField.override({
    initComponent: Ext.form.TextField.prototype.initComponent.createInterceptor(function(){  
        if (this.allowBlank === false && this.fieldLabel) {  
            this.fieldLabel ='<font color=red>*</font>' + this.fieldLabel;  
        }  
    })  
}); 

Ext.apply(Ext.form.VTypes, {
	dhhmphone:function(val,field)  
	{  
		try{  
			//var a=/^(0[0-9]{2,4}-)?([1-9][0-9]{3,10})+(-[0-9]{1,6})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])d{8}$)/;
			//var a=/^(0[0-9]{2,4}-)?([1-9][0-9]{3,10})+(-[0-9]{1,6})?$|(^(13[0-9]|15[0-9]|18[0-9])d{8}$)/;
			var a=/^(0[0-9]{2,4}(-)?)?([1-9][0-9]{3,10})+(-[0-9]{1,6})?$|(^(13[0-9]|15[0-9]|18[0-9])d{8}$)/;//15[0|3|6|7|8|9]|18[8|9]
			var b = /(^0?[1][35][0-9]{9}$)/;
			if(a.test(val)||b.test(val))
				return true;  
			return false;  
	    }catch(e){  
			return false;  
		}  
	},dhhmphoneText:'请输入正确的电话/手机号码,如:0920-29392929或13122212123',
	
	phone:function(val,field)  
	{
		try{  
			var a=/^(0[0-9]{2,4}-)?([1-9][0-9]{3,10})+(-[0-9]{1,6})?$/;
			if(a.test(val))
				return true;  
			return false;  
	    }catch(e){  
			return false;  
		}
	},phoneText:'请输入正确的电话号码,如:010-62802929-8001',
	
	mobilephone:function(val,field)  
	{  
		try{  
			if(/^0?1(3|5|8)\d{9}$/.test(val))  
				return true;  
			return false;  
		}catch(e){  
			return false;  
		}  
	},mobilephoneText:'请输入正确的手机号码',
	
	sfzhao : function(val, field) {// val指这里的文本框值，field指这个文本框组件，大家要明白这个意思
		if (field.confirmTo) {// confirmTo是我们自定义的配置参数，一般用来保存另外的组件的id值
			var zjlx = Ext.get(field.confirmTo);// 取得confirmTo的那个id的值
			if(zjlx.getValue()=='居民身份证'){
				var flag = isIdCardNo(val);
				return (flag);
			}
		}
		return true;
	},sfzhaoText:'请输入正确的证件号码',
	
	//大于比较日期，小于当前日期
	checkDate : function(val, field) {// val指这里的文本框值，field指这个文本框组件
		if (field.confirmTo) {// confirmTo是我们自定义的配置参数，一般用来保存另外的组件的id值
			var startDate = Ext.get(field.confirmTo);// 取得confirmTo的那个id的值
			if(val<startDate.getValue()){
				return false;
			}else{
				if(val>now()){
					return false;
				}
			}
		}
		return true;
	},checkDateText:'请选择正确的有效日期',
	//大于比较日期，大于当前日期
	checkDateNow : function(val, field) {// val指这里的文本框值，field指这个文本框组件
		if (field.confirmTo) {// confirmTo是我们自定义的配置参数，一般用来保存另外的组件的id值
			var startDate = Ext.get(field.confirmTo);// 取得confirmTo的那个id的值
			if(val<startDate.getValue()){
				return false;
			}else{
				if(val<=now()){
					return false;
				}
			}
		}
		return true;
	},checkDateNowText:'请选择正确的有效日期',
	
	dateRange : function(val, field) {  
		if(field.dateRange){  
			var beginId = field.dateRange.begin;  
            this.beginField = Ext.getCmp(beginId);  

            var endId = field.dateRange.end;  
            this.endField = Ext.getCmp(endId);
  
            var beginDate = this.beginField.getValue();  
            var endDate = this.endField.getValue();  
		}  
                  
        if(beginDate <= endDate){ 
            return true;  
        }else{  
            return false;  
        }  
    }, //验证提示信息   
    dateRangeText : '开始日期不能大于结束日期',
    
    verifyCode:function(val, field){//d1231232 1
		AOrgCode = val.toUpperCase();
		var C = ['0','1','2','3','4','5','6','7','8','9',
	             'A','B','C','D','E','F','G','H','I',
	             'J','K','L','M','N','O','P','Q','R',
	             'S','T','U','V','W','X','Y','Z'],
	        V = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,
	            19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35],
	        W = [3,7,9,10,5,8,4,2],
	        A = ['1','2','3','4','5','6','7','8','9','X','0'];
		
		var Clength= C.length;
		var len = AOrgCode.length;
		var result;
		if(len != 9){
			return false;
		}
		function getIndex(Achar){
			for(var tmp= 0;tmp< Clength;tmp++){
				if(C[tmp] == Achar){
					result = tmp;
					return result;
				}
			}
		}
		var s=0 ,j=0;
		for(var i= 0;i < 8;i++){
			getIndex(AOrgCode.charAt(i));
			j= V[result]*W[i];//alert("V*W: "+V[result]+"*"+W[i]);
			s+=j;
		}
		s = 10-(s%11);
		//alert("A[s] "+A[s]);//此为最后一位数值
		//return A[s];
		if(A[s]==AOrgCode.charAt(8)){
			return true;
		}else{
			return false;
		}
	},verifyCodeText: '组织机构代码格式错误！',
	
	pwd : function(val, field) {// val指这里的文本框值，field指这个文本框组件，大家要明白这个意思
		if (field.confirmTo) {// confirmTo是我们自定义的配置参数，一般用来保存另外的组件的id值
			var pnew1 = Ext.get(field.confirmTo);// 取得confirmTo的那个id的值
			
			if(pnew1.getValue()==val){
				return true;
			}
		}
		return false;
	},pwdText:'请输入相同的密码'

});


if (Ext.grid.CheckboxSelectionModel) {
	var interceptOnMouseDown = Ext.grid.CheckboxSelectionModel.prototype.onMouseDown.createInterceptor(function(e, t){
		this.on('rowdeselect', this.handleDeselect, this);
		this.on('rowselect', this.handleSelect, this);   
	});
 
	 Ext.override(Ext.grid.CheckboxSelectionModel, {
		hd : null,    
	    onMouseDown : interceptOnMouseDown,     
	    handleSelect:function(){
	      	if(this.grid.store.getCount()!=this.selections.length)
	    	return;
	    	var hd = Ext.fly(this.grid.getView().innerHd).child('div.x-grid3-hd-checker');
	  		if(!hd.hasClass('x-grid3-hd-checker-on'))  
	  		hd.addClass('x-grid3-hd-checker-on');
		},   
		handleDeselect:function(){
	  		if( this.grid.store.getCount() != this.selections.length +1)
			return;
	  		var hd = Ext.fly(this.grid.getView().innerHd).child('div.x-grid3-hd-checker'); 
	  		if(hd.hasClass('x-grid3-hd-checker-on'))
	   		hd.removeClass('x-grid3-hd-checker-on');
	    }
	});
}


// 自定义扩展：将Grid表头中的全选复选框取消复选
Ext.grid.GridPanel.prototype.unSelectAll = function(){
	var view = this.getView();
	var sm = this.getSelectionModel();
	if(sm){
		sm.clearSelections();
		var hd = Ext.fly(view.innerHd);
		var c = hd.query('.x-grid3-hd-checker-on');
		if(c && c.length>0){
			Ext.fly(c[0]).removeClass('x-grid3-hd-checker-on')
		}
	}
}

//Ext.override(Ext.form.CheckboxGroup,{
//    //在inputValue中找到定义的内容后，设置到items里的各个checkbox中
//    setValue : function(value){
//        this.items.each(function(f){
//            if(value.indexOf(f.inputValue) != -1){
//                f.setValue(true);
//            }else{
//                f.setValue(false);
//            }
//        });
//    },
//    //以value1,value2的形式拼接group内的值
//    getValue : function(){
//        var re = "";
//        this.items.each(function(f){
//            if(f.getValue() == true){
//                re += f.inputValue + ",";
//            }
//        });
//        return re.substr(0,re.length - 1);
//    },   
//    //在Field类中定义的getName方法不符合CheckBoxGroup中默认的定义，因此需要重写该方法使其可以被BasicForm找到
//    getName : function(){
//        return this.name;
//    }
//});

Ext.override(Ext.form.CheckboxGroup, {
	getValue: function() {
		var v = [];
		this.items.each(function(item) {
			if (item.getValue()) {
				v.push(item.getRawValue());
			} else {
				v.push('');
			}
		});
		return v;
	},

	setValue: function(vals) {
		var a = [];
		if (Ext.isArray(vals)) {
			a = vals;
		} else {
			a = [vals];
		}
		this.items.each(function(item) {
			item.setValue(false); // reset value            
			for ( var i = 0 ; i < a.length ; i ++ ) {
				var val = a[i];
				if ( val == item.getRawValue() ) {
					item.setValue(true);            
				}
			};
		});
	}
});


LianXiangComboBox = Ext.extend(Ext.form.ComboBox, {
	id:'',
	name : '',// 显示的文本框的name
	hiddenName : '',// 隐藏域name,存放服务器返回的编号
	/* store查询用 */
	hideTrigger : true,
	loadingText : '加载中..',
	typeAhead : false,//延时查询，并将第一个值放到text框中
	typeAheadDelay:250,//默认250  
	minChars : 1,
	width:250,
//	pageSize:10,//extjs会主动向后退传递start和limit
	totalProperty:'',
	mode : 'remote', 
	sort : '',// 用于远程排序
	dir : 'DESC',// 用于远程排序
	confirmTo:"",//加载KEY值到字段
	//必填
	valueField : '',
	displayField : '',
	url:'',
	root:'',//返回值json
	
	initComponent : function() {
		Ext.form.ComboBox.superclass.initComponent.call(this);
		// 创建默认数据集
		this.store = new Ext.data.Store({
			parent : this,
			url : this.url,
			reader : new Ext.data.JsonReader({
				root : this.root,
				totalProperty: this.totalProperty,
				fields : [this.displayField,this.valueField]
			}),
			baseParams:{
				dir : this.dir,
				sort: this.sort
			},
			autoLoad:true
		});
	},
	listeners:{
		keyup:function(field,e){
			Ext.apply(this.store.baseParams,{
				conditions:this.getRawValue()
			});
			if(e.getKey()==8&&field.getRawValue().length>0){
				this.store.load();
			}else if(e.getKey()==8&&field.getRawValue().length==0){
				this.collapse();
			};
//			if(e.getKey()==13){
//				if(!this.isExpanded()){
//					this.store.load();
//					this.expand();
//				}
//			};
		}
	},
	
	// 数据加载完成后会调用
	onLoad : function() {
		if (this.store.getCount() > 0) {
			this.restrictHeight();//list高度
		}
		// 如果只有一条记录就隐藏选择列表,并直接设置值
		if (this.store.getCount() == 0) {
				this.setValue();
		} else if (this.store.getCount() == 1) {
			this.list.hide();//隐藏下拉框
//			this.collapse();//同上
			this.setValue(this.store.getAt(0).get(this.displayField));
			Ext.getCmp(this.confirmTo).setValue(this.store.getAt(0).get(this.valueField));

		}
	},
	//修正ext3.0keyup监听bug
	initEvents : function() {
		Ext.form.ComboBox.superclass.initEvents.call(this);
		this.keyNav = new Ext.KeyNav(this.el, {
			"up" : function(e) {
				this.inKeyMode = true;
				this.selectPrev();
			},
			"down" : function(e) {
				if (!this.isExpanded()&&this.getRawValue().length>0) {
					this.onTriggerClick();
				} else {
					this.inKeyMode = true;
					this.selectNext();
				}
			},
			"enter" : function(e) {
				this.onViewClick();
				this.delayedCheck = true;
				this.unsetDelayCheck.defer(10, this);
				alert(this.store.getAt(0).get(this.valueField));
				
			},
			"esc" : function(e) {
				this.collapse();
			},
			"tab" : function(e) {
				this.onViewClick(false);
				return true;
			},
			scope : this,
			doRelay : function(foo, bar, hname) {
				if (hname == 'down' || this.scope.isExpanded()) {
					return Ext.KeyNav.prototype.doRelay.apply(
							this, arguments);
				}
				return true;
			},
			forceKeyDown : true
		});
		this.queryDelay = Math.max(this.queryDelay || 10,
				this.mode == 'local' ? 10 : 250);
		this.dqTask = new Ext.util.DelayedTask(this.initQuery, this);
		if (this.typeAhead) {
			this.taTask = new Ext.util.DelayedTask(this.onTypeAhead,this);
		}
		if ((this.editable !== false) && !this.enableKeyEvents) {
			this.el.on("keyup", this.onKeyUp, this);
		}
		if (this.forceSelection) {
			this.on('blur', this.doForce, this);
		}
	},
	onKeyUp : function(e) {
		if (this.editable !== false && !e.isSpecialKey()) {
			this.lastKey = e.getKey();
			this.dqTask.delay(this.queryDelay);
		}
		Ext.form.ComboBox.superclass.onKeyUp.call(this, e);
	}
})
Ext.reg('lianxiangbox', LianXiangComboBox);

var ajaxLoadMask = new Ext.LoadMask(document.body, {msg : '正在向服务器发送请求...'});

var Orgnew = Ext.data.Record.create([
	{name : 'orgid',mapping : 'orgid',type : 'int'}, 
	{name : 'centerid',mapping : 'centerid',type : 'string'},
	{name : 'orderid',mapping : 'orderid',type : 'string'}, 
	{name : 'jgdm',	mapping : 'jgdm',type : 'string'}, 
	{name : 'jgmc',mapping : 'jgmc',type : 'string'}, 
	{name : 'jglx',mapping : 'jglx',type : 'string'},
	{name : 'fddbr',mapping : 'fddbr',type : 'string'}, 
	{name : 'zjlx',mapping : 'zjlx',type : 'string'}, 
	{name : 'zjhm',mapping : 'zjhm',type : 'string'}, 
	{name : 'jyfw',mapping : 'jyfw',type : 'string'}, 
	{name : 'zcrq',mapping : 'zcrq',type : 'date',dateFormat:'Y-M-D'}, 
	{name : 'jglxOld',mapping : 'jglxOld',type : 'string'},
	{name : 'jglxdmOld',mapping : 'jglxdmOld',type : 'string'},
	{name : 'isca',type : 'string'},
	{name : 'fkbz',type : 'string'},
	{name : 'zbsl',type : 'string'},
	{name : 'fbsl',type : 'string'},
	{name : 'xzqhCode',mapping : 'xzqhCode',type : 'string'},
	{name : 'xzqhName',mapping : 'xzqhName',type : 'string'},
	{name : 'jgdz',mapping : 'jgdz',type : 'string'}, 
	{name : 'yzbm',mapping : 'yzbm',type : 'string'}, 
	{name : 'dhhm',mapping : 'dhhm',type : 'string'}, 
	{name : 'zycp1',mapping : 'zycp1',type : 'string'}, 
	{name : 'zycp2',mapping : 'zycp2',type : 'string'}, 
	{name : 'zycp3',mapping : 'zycp3',type : 'string'}, 
	{name : 'zczj',mapping : 'zczj',type : 'string'}, 
	{name : 'wftzgb',mapping : 'wftzgb',type : 'string'}, 
	{name : 'zgrs',mapping : 'zgrs',type : 'string'}, 
	{name : 'zch',mapping : 'zch',type : 'string'}, 
	{name : 'pzwh',mapping : 'pzwh',type : 'string'},
	{name : 'pzrq',mapping : 'pzrq',type : 'date',dateFormat:'Y-M-D'},
	{name : 'pzjgmc',mapping : 'pzjgmc',type : 'string'},
	{name : 'pzjgdm',mapping : 'pzjgdm',type : 'string'},
	{name : 'kfgk',mapping : 'kfgk',type : 'string'},
	{name : 'email',mapping : 'email',type : 'string'},
	{name : 'weburl',mapping : 'weburl',type : 'string'},
	{name : 'mobile',mapping : 'mobile',type : 'string'},
	{name : 'tbrxm',mapping : 'tbrxm',type : 'string'},
	{name : 'tbrsfzh',mapping : 'tbrsfzh',type : 'string'},
	{name : 'tbrlxfs',mapping : 'tbrlxfs',type : 'string'},
	{name : 'jydz',mapping : 'jydz',type : 'string'},
	{name : 'jyyb',mapping : 'jyyb',type : 'string'},
	{name : 'jydh',mapping : 'jydh',type : 'string'},
	{name : 'jfly',mapping : 'jfly',type : 'string'},
	{name : 'zsbfrq',mapping : 'zsbfrq',type : 'date', convert:function(v){if(v) return v.substring(0,10);}},
	{name : 'zszfrq',mapping : 'zszfrq',type : 'date', convert:function(v){if(v) return v.substring(0,10);}},
	{name : 'bzrq',mapping : 'bzrq',type : 'date', convert:function(v){if(v) return v.substring(0,10);}},
	{name : 'zfrq',mapping : 'zfrq',type : 'date', convert:function(v){if(v) return v.substring(0,10);}},
	{name : 'jjlx',mapping : 'jjlx',type : 'string'},
	{name : 'jjlxdm',mapping : 'jjlxdm',type : 'string'},
	{name : 'tbrzjlx',mapping : 'tbrzjlx',type : 'string'},
	{name : 'memo',mapping : 'memo',type : 'string'},
	{name : 'memo2',mapping : 'memo2',type : 'string'},
	{name : 'hbzl',mapping : 'hbzl',type : 'string'},
	{name : 'hbzldm',mapping : 'hbzldm',type : 'string'},
	{name : 'khyh',mapping : 'khyh',type : 'string'},
	{name : 'khzh',mapping : 'khzh',type : 'string'},
	{name : 'userid',mapping : 'userid',type : 'string'},
	{name : 'username',mapping : 'username',type : 'string'},
	{name : 'handleUsername', mapping: 'handleUsername',type : 'string'},
	{name : 'handleName', mapping: 'handleName',type : 'string'},
	{name : 'handleDate', mapping: 'handleDate',type : 'string'},
	{name : 'handleNote', mapping: 'handleNote',type : 'string'},	
	{name : 'auditUsername', mapping: 'auditUsername',type : 'string'},
	{name : 'auditName', mapping: 'auditName',type : 'string'},
	{name : 'auditDate', mapping: 'auditDate',type : 'string'},
	{name : 'auditNote', mapping: 'auditNote',type : 'string'},	
	{name : 'imageUrl', mapping: 'imageUrl',type : 'string'},
	{name : 'offPzjgmc', mapping: 'offPzjgmc',type : 'string'},
	{name : 'offPzwh', mapping: 'offPzwh',type : 'string'},
	{name : 'offReason', mapping: 'offReason',type : 'string'},	
	{name : 'offNote', mapping: 'offNote',type : 'string'},
	{name : 'state',mapping : 'state',type : 'string'}
]);


//--------------------------------------------------------------
var Orgnews = new Ext.data.JsonReader({root:'root'},[
        {name : 'orgid',type : 'int'},
        {name : 'orderid',type : 'string'}, 
        {name : 'centerid',type : 'string'},
        {name : 'docid',type : 'string'},
		{name : 'jgmc',type : 'string'},
		{name : 'jgdm',type : 'string'},
		{name : 'jglx',type : 'string'},
		{name : 'jglxdm',type : 'string'},
		{name : 'jglxOld',type : 'string'},
		{name : 'jglxdmOld',type : 'string'},
		
		{name : 'jjhymc',type : 'string'},
		{name : 'jjhydm',type : 'string'},
		{name : 'jjhymcOld',type : 'string'},
		{name : 'jjhydmOld',type : 'string'},
		{name : 'isca',type : 'string'},
		{name : 'fkbz',type : 'string'},
		{name : 'zbsl',type : 'string'},
		{name : 'fbsl',type : 'string'},
	
		{name : 'fksl',type : 'int'},
		{name : 'isxw',type : 'string'},
		{name : 'gk',type : 'string'},
		{name : 'fddbr',type : 'string'}, 
		{name : 'zjlx',type : 'string'},
		{name : 'zjhm',type : 'string'},
		{name : 'qyjj',type : 'string'},
		{name : 'jyfw',type : 'string'},
		{name : 'zcrq',type: 'date', convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zgdm',type : 'string'},
		{name : 'zgmc',type : 'string'},
		{name : 'pzjgmc',type : 'string'},
		{name : 'pzjgdm',type : 'string'},
		{name : 'xzqhCode',type : 'string'},
		{name : 'xzqhName',type : 'string'},
		{name : 'xzqhCode2',type : 'string'},
		{name : 'xzqhName2',type : 'string'},
		{name : 'jgdz',type : 'string'},
		{name : 'yzbm',type : 'string'},
		{name : 'dhhm',type : 'string'},
		{name : 'bzjgdm',type : 'string'},
		{name : 'zycp1',type : 'string'},
		{name : 'zycp2',type : 'string'},
		{name : 'zycp3',type : 'string'},
		{name : 'zczj',type : 'string'},
		{name : 'hbzl',type : 'string'},
		{name : 'hbzldm',type : 'string'},
		{name : 'wftzgb',type : 'string'},
		{name : 'wftzgbdm',type : 'string'},
		{name : 'zgrs',type : 'string'},
		{name : 'zch',type : 'string'},
		{name : 'pzwh',type : 'string'},
		{name : 'pwrq',type: 'date', convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'email',type : 'string'},
		{name : 'weburl',type : 'string'},
		{name : 'mobile',type : 'string'},
		{name : 'yjflag',type : 'string'},
		{name : 'tbrxm',type : 'string'},
		{name : 'tbrsfzh',type : 'string'},
		{name : 'tbrlxfs',type : 'string'},
		{name : 'zsbfrq',type: 'date', convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zszfrq',type: 'date', convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zslsh',type : 'string'},
		{name : 'bzrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'zfrq',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'njqx',type: 'date', convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'njrq',type: 'date', convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'jjlx',type : 'string'},
		{name : 'jjlxdm',type : 'string'},
		{name : 'tbrzjlx',type : 'string'},
		{name : 'memo',type : 'string'},
		{name : 'memo2',type : 'string'},
		{name : 'moveoutCenter',type : 'string'},
		{name : 'moveoutBzjgdm',type : 'string'},
		{name : 'moveoutAddrss',type : 'string'},
		{name : 'moveoutReason',type : 'string'},
		{name : 'offPzjgmc',type : 'string'},
		{name : 'offPzwh',type : 'string'},
		{name : 'offReason',type : 'string'},
		{name : 'offNote',type : 'string'},
		
		{name : 'jydz',type : 'string'},
		{name : 'jyyb',type : 'string'},
		{name : 'jydh',type : 'string'},
		{name : 'jfly',type : 'string'},
		{name : 'khyh',type : 'string'},
		{name : 'khzh',type : 'string'},
		{name : 'name',type : 'string'},
		{name : 'username',type : 'string'},
		{name : 'handleUsername',type : 'string'},
		{name : 'handleName',type : 'string'},
		{name : 'handleDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'handleNote',type : 'string'},
		
		{name : 'auditUsername',type : 'string'},
		{name : 'auditName',type : 'string'},
		{name : 'auditDate',type : 'date',convert:function(v){if(v) return v.substring(0,10);}},
		{name : 'auditNote',type : 'string'},
		
		{name : 'pageTypeStr',type : 'string'},
		{name : 'imageUrl',type : 'string'},
		{name : 'ywlx',type : 'string'},
		{name : 'state',type : 'string'},
		{name : 'imageData',type : 'string'}]
);


//---------------------- 列表显示申请单状态 ------------------------------------
function goState(value,p,record)
{
   var stateValue;
   var dybzValue;
   stateValue=record.data["state"];
   dybzValue=record.data["dybz"];
   if(typeof stateValue!=''){
	   switch (stateValue) {
	   case '0' :
		   return String.format('<font color="DarkBlue"><b>网上办证，申请暂存</b></font>');
	   case '1' :
		   return String.format('<font color="DarkBlue"><b>网上办证，申请暂存</b></font>');
	   case '2' :
		   return String.format('<font color="blue"><b>网上办证，等待审批</b></font>');
	   case '3' :
		   return String.format('<font color="blue"><b>网上办证，等待审批</b></font>');
	   case '4' :
		   return String.format('<font color="red"><b>网上办证，审批驳回</b></font>');
	   case '5' :
		   return String.format('<font color="green"><b>网上办证，审批通过</b></font>');
	   case '6' :
		   if(dybzValue=='Y'){
			   return String.format('<font color="green"><b>正在办理，需打印</b></font>');
		   }else{
			   return String.format('<font color="green"><b>办理完毕，请归档</b></font>');
		   } 
	   case '10' :
		   return String.format('<font color="DarkBlue"><b>档案扫描</b></font>');   
	   case '11' :
		   return String.format('<font color="blue"><b>档案扫描出错</b></font>');
	   case '12' :
		   return String.format('<font color="red"><b>办理暂存</b></font>');
	   case '13' :
		   return String.format('<font color="red"><b>等待审批</b></font>');
	   case '14' :
		   return String.format('<font color="red"><b>审批驳回</b></font>');
	   case '15' :
		   return String.format('<font color="red"><b>可以赋码</b></font>');
	   case '16' :
		   if(dybzValue=='Y'){
			   return String.format('<font color="green"><b>需打印</b></font>');
		   }else{
			   return String.format('<font color="green"><b>待归档</b></font>');
		   }   
	   
	   case '22' :
	   	   if(dybzValue=='Y'){
			   return String.format('<font color="green"><b>数据清整，需打印</b></font>');
		   }else{
			   return String.format('<font color="green"><b>办理完毕，请确认</b></font>');
		   }
	   case '100' :
		   if(dybzValue=='Y'){
			   return String.format('<font color="blue"><b>需打印</b></font>');
		   }else{
			   return String.format('<font color="green"><b>已归档</b></font>');
		   }
	   case '200' :
		   return String.format('<font color="blue"><b>已注销</b></font>');
	   default :
		   return String.format('<font color="green"><b>后台赋值数据错误。。。</b></font>');
	   } 
	}
	//return stateValue
}

function goTjgdmState(value,p,record)
{
   	var stateValue;
   	stateValue=record.data["state"];
	switch (stateValue) {
	   case '-100' :
		   return String.format('<font color="red"><b>已搁置</b></font>');
	   case '0' :
		   return String.format('<font color="blue"><b>机构搁置申请中</b></font>');
	   case '1' :
		   return String.format('<font color="blue"><b>注销恢复申请中</b></font>');
	   case '100' :
			return String.format('<font color="green"><b>正常</b></font>');
	   case '200' :
		   return String.format('<font color="red"><b>已注销</b></font>');
	   case '300' :
		   return String.format('<font color="red"><b>已迁址</b></font>');
	   case '400' :
		   return String.format('<font color="red"><b>已过期</b></font>');
	   default :
		   return String.format('<font color="green"><b>正常</b></font>');
	   } 
}

function goCzshbz(value)
{
   switch (value) {
   case 0 :
	   return String.format('<font color="green"><b>正常打证</b></font>');
   case 1 :
	   return String.format('<font color="blue"><b>当日打证</b></font>');
   default :
	   return String.format('<font color="green"><b>正常打证</b></font>');
   } 
}

function tjgdmStateToInfo(stateValue)
{
   if(typeof stateValue!=''){
	   switch (stateValue) {
	   case '-100' :
		   return String.format('<font color="red"><b>已搁置</b></font>');
	   case '0' :
		   return String.format('<font color="blue"><b>机构搁置申请中</b></font>');
	   case '1' :
		   return String.format('<font color="blue"><b>注销恢复申请中</b></font>');
	   case '100' :
			return String.format('<font color="green"><b>正常</b></font>');
	   case '200' :
		   return String.format('<font color="red"><b>已注销</b></font>');
	   case '300' :
		   return String.format('<font color="red"><b>已迁址</b></font>');
	   case '400' :
		   return String.format('<font color="red"><b>已过期</b></font>');
	   default :
		   return String.format('<font color="green"><b>正常</b></font>');
	   } 
	}
}

//---------------------- 卡片TITLE显示申请单状态 ------------------------------------
function stateToInfo(stateValue,jgdmValue)
{
   if(typeof stateValue!=''){
	   switch (stateValue) {
	   case '0' :
		   return String.format('<font color="DarkBlue">申请暂存</font>');
	   case '1' :
		   return String.format('<font color="DarkBlue">等待网审</font>');
	   case '2' :
		   return String.format('<font color="blue">网审通过</font>');
	   case '3' :
		   return String.format('<font color="red">网审驳回</font>');
	   case '4' :
		   return String.format('<font color="green">办理完毕，需归档</font>');
	   case '5' :
	   	    if(jgdmValue!=''){
		   		return String.format('<font color="DarkBlue">赋码完毕，请提交</font>');
	   	    }else{
	   	    	return String.format('<font color="DarkBlue">审批通过，请赋码</font>');
	   	    }
	   case '6' :
			return String.format('<font color="blue">正在办理</font>');
	   case '10' :
		   return String.format('<font color="DarkBlue">扫描暂存，待提交</font>');
	   case '11' :
		   return String.format('<font color="red">提交后，被驳回，</font>');
	   case '12' :
		   return String.format('<font color="blue">等待办理</font>');
	   case '13' :
		   return String.format('<font color="DarkBlue">等待审批</font>');
	   case '14' :
		   return String.format('<font color="red">审批驳回</font>');
	   case '15' :
	   	    if(jgdmValue!=''){
		   		return String.format('<font color="DarkBlue">赋码完毕，请提交</font>');
	   	    }else{
	   	    	return String.format('<font color="DarkBlue">审批通过，请赋码</font>');
	   	    }
	   case '16' :
			return String.format('<font color="blue">正在办理</font>');
	   case '100' :
		   if(dybzValue=='Y'){
			   return String.format('<font color="blue">证书--需打印</font>');
		   }else{
			   return String.format('<font color="green">证书--已归档</font>');
		   }
	   default :
		   return String.format('<font color="red">后台赋值数据错误。。。</font>');
	   } 
	}
}

function jglxNewToOld(jglxValue)
{
	var strJglxdmOld="";
	if(typeof jglxValue!=''){
		switch(jglxValue) {
			case 11: 
				strJglxdmOld="1";
				break; 
			case 13: 
				strJglxdmOld="1";
				break; 
			case 15: 
				strJglxdmOld="2";
				break; 
			case 17: 
				strJglxdmOld="2";
				break;
			case 19: 
				strJglxdmOld="2";
				break;
			case 31: 
				strJglxdmOld="7";
				break;
			case 32: 
				strJglxdmOld="7";
				break;
			case 33: 
				strJglxdmOld="7";
				break;
			case 34: 
				strJglxdmOld="7";
				break;
			case 35: 
				strJglxdmOld="7";
				break;
			case 36: 
				strJglxdmOld="7";
				break;
			case 37: 
				strJglxdmOld="7";
				break;
			case 39: 
				strJglxdmOld="8";
				break;
			case 51: 
				strJglxdmOld="3";
				break;
			case 53: 
				strJglxdmOld="4";
				break;
			case 59: 
				strJglxdmOld="D";
				break;
			case 71: 
				strJglxdmOld="5";
				break;
			case 73: 
				strJglxdmOld="6";
				break;
			case 91: 
				strJglxdmOld="A";
				break;
			case 93: 
				strJglxdmOld="9";
				break;
			case 94: 
				strJglxdmOld="9";
				break;
			case 95: 
				strJglxdmOld="9";
				break;
			case 96: 
				strJglxdmOld="9";
				break;
			case 97: 
				strJglxdmOld="9";
				break;
			case 99: 
				strJglxdmOld="9";
				break;
			}
		return String.format(strJglxdmOld);
			
	}
}
function StringToDate(DateStr)  
{   
    var converted = Date.parse(DateStr);  
    var myDate2 = new Date(converted);  
    if (isNaN(myDate2))  
    {   
        var arys= DateStr.split('-');  
        myDate2 = new Date(arys[0],--arys[1],arys[2]);  
    }  
    return myDate2;  
}   


//---------------------- 列表取码段状态 ------------------------------------
function goStateFlag(value,p,record)
{
   var stateFlagValue;
   stateFlagValue=record.data["flag"];
   if(typeof stateFlagValue!=''){
	   switch (stateFlagValue) {
	   /*
	   case '1' :
		   return String.format('<font color="DarkBlue">取码成功</font>');
	   case '2' :
		   return String.format('<font color="DarkBlue">机构已赋码</font>');
	   case '3' :
		   return String.format('<font color="blue">赋码无确认</font>');
	   case '4' :
		   return String.format('<font color="red">疑似已赋码</font>');
	   case '5' :
		   return String.format('<font color="green">系统拒绝赋码</font>');
	   case '6' :
		   return String.format('<font color="green">无代码资源</font>');
	   default :
		   return String.format('<font color="green">无代码！</font>');
	    */
	   
	   case '0' :
		   return String.format('<font color="DarkBlue">取码成功</font>');
	   case '1' :
		   return String.format('<font color="DarkBlue">疑似已赋码</font>');
	   case '2' :
		   return String.format('<font color="blue">机构已赋码</font>');
	   case '3' :
	   	   var info=record.data["info"];
		   return String.format('<font color="blue">取码失败('+info+')</font>');
		   
		   
	   }
	   
	}
}

//------------------------当前日期-----------------------
var myDate = new Date();
var newYear = myDate.getYear() + 4; 
var newMonth = myDate.getMonth() + 1; 
var newZfrq = StringToDate(newYear+'-'+newMonth+'-'+myDate.getDate());

var newZfrqYes = StringToDate(newYear+'-'+newMonth+'-'+(myDate.getDate()-1));
//newZfrqYes.setDate(newZfrq.getDate()-1);

var newYear2 = myDate.getYear() + 1; 
var newNjqx=StringToDate(newYear2+'-'+sysNjqxDate);


function dateFormatToYMD(strDate)
{
	if(strDate!=null && strDate!=""){
		//var date= new Date(Date.parse(strDate.replace(/-/g,"/"))); //转换成Data();
		//var strYear=date.getFullYear();    //获取完整的年份(4位,1970)
		//var strMonth=date.getMonth()+1;       //获取当前月份(0-11,0代表1月)
		//var strDate=date.getDate();        //获取当前日(1-31
		//return String.format(strYear.toString()+"年"+strMonth.toString()+"月"+strDate.toString()+"日");
		var arr = strDate.substring(0,10).split('-');
		strDate = arr[0]+"年"+arr[1]+"月"+arr[2]+"日";
		return strDate;
	}else{
		return String.format(" ");
	}
}

function returnZslsh(strZslsh){//420100//2013-01-01
	var str = currentZzUserBzjgdm.substring(4,6);
	strZslsh = str + strZslsh;
	return strZslsh;
}

//检测网上办证流程参数，是否设置正确
function checkNetSysConfigSet(strNetWorkMode,sysStrYwnetSet)
{
	if(strNetWorkMode=='1' && sysStrYwnetSet==""){
		Ext.Msg.show({
			title : '提示',
			msg : '系统参数设置错误002，<br><br>重新登录或联系系统管理员!',
			buttons : Ext.Msg.OK,
			icon : Ext.Msg.INFO,
			fn : function() {window.location = '/manage/index.jsp';}
		});
	}
}


//根据机构代码，业务类型、状态和现场流程参数，来决定赋码状态(新办)
function isFumaBtnActive(strJgdm,strState,strYwlx,strXcWorkMode,sysStrYwxcSet)
{
	if(strJgdm==''){
		if(strXcWorkMode=='0' && strState=='12'){
			return false;
		}else{
			if(strXcWorkMode=='1' && sysStrYwxcSet.indexOf('|'+strYwlx+'|')!=-1){
				if(strState=='15'){
					return false;
				}else{
					return true;
				}
			}else{
				return false;
			}
		}
	}else{
		return true;
	}
}


var HKEY_Root,HKEY_Path,HKEY_Key;
HKEY_Root="HKEY_CURRENT_USER";
HKEY_Path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";

function pagesetup_null(){
	try{
		var RegWsh = new ActiveXObject("WScript.Shell")
		HKEY_Key="header" 
		RegWsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"")
		HKEY_Key="footer"
		RegWsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"")
		HKEY_Key="margin_bottom";   
		RegWsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"0.16929");  //设置下页边距（10为  0.39370，，4.3为0.16929） 
   		HKEY_Key="margin_left";   
  	 	RegWsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"0.16929");  //设置左页边距（10）   
  	 	HKEY_Key="margin_right";   
   		RegWsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"0.16929");  //设置右页边距（10）   
   		HKEY_Key="margin_top";   
   		RegWsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"0.16929");  //设置上页边距（108）   
		//window.print()
	}catch(e){}
}




function goNjqx(zfrqStr)  
{   
    var converted = Date.parse(zfrqStr);  
    var zfrqDate = new Date(converted); 
    if (isNaN(zfrqDate))  
    {   
        if(zfrqDate>=newNjqx){
        	
        }else{
        	newNjqx=zfrqDate;
        }
    }  
    return newNjqx;  
}  

function formatToNormal(str){
	if(str!=null  && str!=""){
		return str;
	}else{
		return "";
	}
}

function printSqdStr(resultObject,pntFlag){//申请单模版
	if(resultObject!=null){
		var tableStr = '<html><head><title>组织机构代码网上办证系统--申请单打印</title></head>';
		tableStr = tableStr + '<body onunload="window.opener.msgShow();"><center>';
		tableStr = tableStr + '	<table border= "0" width=770 cellpadding= "0" cellspacing= "0"  bgcolor="#FFFFFF">';
		tableStr = tableStr + '		<style type="text/css">@media print{INPUT {display:none}} .head1{font-size: 18pt;font-family: "黑体";} .txt1 {font-size: 11.5pt} .txt2 {font-size: 14pt}  .title1 {font-size: 11.5pt;font-family: "黑体"; } .title2 {font-size: 11.5pt;font-family: "宋体"; }	.fangge {font-size: 16pt;color: #FF0000;line-height:1em;} body {margin-left: 0px;margin-top: 0px;margin-right: 0px;margin-bottom: 0px;background-color: #CCCCCC;}</style>';
		tableStr = tableStr + '		<tr><td align="center" valign="middle"><br>';
		tableStr = tableStr + '	<center>';				
		tableStr = tableStr + '	<table  id="table5" style="width:720;border-collapse:collapse; " cellpadding= "0" cellspacing= "0"  border="0" >';
		tableStr = tableStr + '		<tr><td width="200"><table width="200" style="width:200;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "0"><tr><td width="200"><input type="button" name="btnPrint" value="打　　印"  onclick="reportPrint()"/></td></tr></table></td>';			
		tableStr = tableStr + '			<td width="">&nbsp;</td><td width="194" align="right">';
		tableStr = tableStr + '				<table id="table3" style="width:184;border-collapse:collapse;" align="right" cellpadding= "0" cellspacing= "0" border= "1" bordercolor= "#3366FF">';
		tableStr = tableStr + '							<tr>';	
		if(resultObject.jgdm!="" && resultObject.jgdm!=null){
			var codeStr=resultObject.jgdm;
			codeArray = new Array;
			codeArray = codeStr.split("");
		    for(k=0;k<codeArray.length;k++){
		    	if(k!=8){
		    		tableStr = tableStr + '<td width="23"  align="center" class="txt2">'+codeArray[k]+'</td>';	
		    	}else{
		    		tableStr = tableStr + '</tr></table></td>';
					tableStr = tableStr + '<td width="15" align="center">-</td><td width="23"><table width="23"  id="table4" style="width:23;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "1" bordercolor= "#3366FF"><tr><td width="21"  class="txt2" align="center">'+codeArray[k]+'</td></tr></table></td></tr>';
		    	}
		    }
		 }else{
			 	tableStr = tableStr + '			<td width="23">&nbsp;</td><td width="23">&nbsp;</td><td width="23">&nbsp;</td><td width="23">&nbsp;</td><td width="23">&nbsp;</td><td width="23">&nbsp;</td><td width="23">&nbsp;</td><td width="23">&nbsp;</td>';
			 	tableStr = tableStr + '		</tr></table></td>';
			 	tableStr = tableStr + 		'<td width="15" align="center">-</td><td width="23"><table width="23"  id="table4" style="width:23;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "1" bordercolor= "#3366FF"><tr><td width="21">&nbsp;</td></tr></table></td></tr>';
		 }
				 						
		tableStr = tableStr + '	<tr><td height="54" colspan="5"><div align="center" class="head1">组织机构代码证基本信息登记表</div></td></tr></table>';
		
		tableStr = tableStr + '		<table id="table1" style="width:720;border-collapse:collapse; " cellpadding= "3" cellspacing= "0" border= "1" bordercolor= "#3366FF">';
		tableStr = tableStr + '			<tr><td width="140" height="45" class="title1"><div align="center" class="title1"><div align="center">机构名称<br>(盖  章)</div></div></td>';
		tableStr = tableStr + '				<td colspan="7" align="left"  class="txt1">&nbsp;'+resultObject.jgmc+'</td></tr>';
		tableStr = tableStr + '			<tr><td width="140" height="30" class="title1" align="center" >法定代表人(负责人)</td><td width="250"  align="left" colspan=3 class="txt1">&nbsp;'+resultObject.fddbr+'</td>';
		tableStr = tableStr + '				<td height="30" width=80 class="title1" align="center">法人证件</td><td width=250 colspan=3  class="txt1">'+resultObject.zjlx+''+resultObject.zjhm+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="100" class="title1"  align="center">经营范围<br />(职能、宗旨)</td><td colspan="7" align="left"  class="txt1">&nbsp;'+resultObject.jyfw +'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1"  align="center">成立日期</td><td colspan="3" align="left"  class="txt1">&nbsp;'+dateFormatToYMD(resultObject.zcrq)+'</td>';
		tableStr = tableStr + '				<td width=80 class="title1" align="center">职工人数</td><td colspan="3" align="left"  class="txt1">&nbsp;'+resultObject.zgrs+'&nbsp;(人)</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">证照有效期</td><td colspan="7" align="center" class="txt1">&nbsp;'+dateFormatToYMD(resultObject.zsbfrq)+'&nbsp;&nbsp;至&nbsp;&nbsp;'+dateFormatToYMD(resultObject.zszfrq)+'</tr>';
		tableStr = tableStr + '			<tr><td height="30" width="140"  class="title1" align="center">企业登记注册类型</td><td width="230" colspan="2" align="left" class="txt1">&nbsp;'+resultObject.jjlx+resultObject.jjlxdm+'</td>';
		tableStr = tableStr + '				<td colspan="2"  class="title1" align="center">外商投资国别或地区</td><td colspan="3" align="left" width="250" class="txt1">&nbsp;'+resultObject.wftzgb +'&nbsp;&nbsp;'+resultObject.wftzgbdm+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1"  align="center">注册(开办)资金</td><td colspan="3" align="left"  class="txt1">&nbsp;'+resultObject.zczj +'&nbsp;(万元)</td>';
		tableStr = tableStr + '				<td  class="title1" align="center">货币种类</td><td colspan="3"  align="left" class="txt1">&nbsp;'+resultObject.hbzl+'&nbsp;&nbsp;'+resultObject.hbzldm +'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">主管部门</td><td colspan="7" align="left"  class="txt1">&nbsp;'+resultObject.zgmc +' '+resultObject.zgdm+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">登记批准机构</td><td colspan="7" align="left" class="txt1">&nbsp;'+resultObject.pzjgmc+'&nbsp;&nbsp;'+resultObject.pzjgdm+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">批准文号或注册号</td><td colspan="7" align="left" class="txt1">&nbsp;'+resultObject.zch+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">机构注册地址</td><td colspan="7" class="txt1" align="left">&nbsp;'+resultObject.jgdz+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">行政区划</td><td colspan="3" class="txt1" align="left">&nbsp;'+resultObject.xzqhName+'&nbsp;&nbsp;'+resultObject.xzqhCode+'</td>';
		tableStr = tableStr + '				<td class="title1" align="center">邮政编码</td><td  colspan="3" align="left" class="txt1">&nbsp;'+resultObject.yzbm+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">机构实际地址</td><td colspan="7" class="txt1" align="left">&nbsp;'+resultObject.jydz+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">行政区划</td><td colspan="3" class="txt1" align="left">&nbsp;'+formatToNormal(resultObject.xzqhName2)+'&nbsp;&nbsp;'+formatToNormal(resultObject.xzqhCode2)+'</td>';
		tableStr = tableStr + '				<td class="title1" align="center">邮政编码</td><td  colspan="3" align="left" class="txt1">&nbsp;'+formatToNormal(resultObject.jyyb)+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">电子信箱</td><td colspan="3" class="txt1" align="left">&nbsp;'+resultObject.email+'</td>';
		tableStr = tableStr + '				<td class="title1" align="center">网&nbsp;&nbsp;&nbsp;&nbsp;址</td><td colspan="3" align="left" class="txt1">&nbsp;'+resultObject.weburl+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">联系电话</td><td colspan="3" class="txt1" align="left">&nbsp;'+resultObject.dhhm+'</td>';
		//tableStr = tableStr + '				<td class="title1" align="center">自愿申请</td><td colspan="3 align="left" class="txt1" >&nbsp;'+resultObject.fkbz+'</td></tr>';
		tableStr = tableStr + '				<td class="title1" align="center">自愿申请</td><td colspan="3 align="left" class="txt1" >&nbsp;副本&nbsp;';
		//if(resultObject.fbsl==null||resultObject.fbsl==''){
			tableStr = tableStr + '□';
		//}else{
		//	tableStr = tableStr + '■';
		//}
		tableStr = tableStr + '&nbsp;&nbsp;IC卡&nbsp;';
		//if(resultObject.fkbz=='是'){
		//	tableStr = tableStr + '■';
		//}else{
			tableStr = tableStr + '□';
		//}
		
		tableStr = tableStr + '&nbsp;&nbsp;盖章:</td></tr>';
		
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">经  办   人</td><td width="240" colspan=3 align="left" class="txt1">&nbsp;'+resultObject.tbrxm+'</td>';
		tableStr = tableStr + '				<td height="30" class="title1" align="center">经办人证件</td><td colspan=3 align="left"  class="txt1">&nbsp;'+resultObject.tbrsfzh+'</td></tr>';
		tableStr = tableStr + '			<tr><td height="30" class="title1" align="center">经办人电话</td><td colspan="3" align="left"  class="txt1">&nbsp;'+resultObject.tbrlxfs+'</td>';
		tableStr = tableStr + '				<td colspan="1" class="title1" align="center">填表日期</td><td colspan="3" align="left"  class="txt1">&nbsp;'+dateFormatToYMD(myDate.format('Y-m-d'))+'</div></td></tr>';
		tableStr = tableStr + '		</table>';
		tableStr = tableStr + '		<table style="width:720;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "0"><tr><td height="5" ></td></tr></table>';
		tableStr = tableStr + '		<table   id="table2" style="width:718;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "1" bordercolor= "#3366FF">';
		tableStr = tableStr + '			<tr><td height="114" width="80" class="STYLE7">';
		tableStr = tableStr + '				<table width="718" border="0">';
		tableStr = tableStr + '					<tr><td height="22" align="left" class="title1">备注栏：</td></tr><tr><td height="40" align="left" class="title1">&nbsp;</td></tr>';
		tableStr = tableStr + '					<tr><td align="right" height="30" class="title1">校对人签字：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>';
		tableStr = tableStr + '					<tr><td align="right" height="22" class="title1">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;</td></tr>';
		tableStr = tableStr + '				</table></td>';
		tableStr = tableStr + '			</tr>';
		tableStr = tableStr + '		</table>';
		tableStr = tableStr + '		<table style="width:720;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "0"><tr><td height="5" ></td></tr></table>';
		tableStr = tableStr + '		<table id="table3" style="width:720;border-collapse:collapse; " cellpadding= "0" cellspacing= "0" border= "1" bordercolor= "#FF0000">';
		tableStr = tableStr + '			<tr>';
		tableStr = tableStr + '				<td width="115" height="30" class="title1"><div align="center">业务类型</div></td>';
		tableStr = tableStr + '				<td width="605" colspan="3" align="center">';
		tableStr = tableStr + '					<table width="" style="width:560;border-collapse:collapse; " border="0" cellpadding="0" cellspacing="0">';
		tableStr = tableStr + '						<tr><td width="60"><span class="fangge">';	
		var ywlxState='no'; 
		var ywlxStr=resultObject.ywlx
		//alert(ywlxStr);
			if(ywlxStr=="新办"&&pntFlag==1)
			 {
				 tableStr = tableStr + '■';
				 ywlxState='yes'; 
		     } else {
		    	  tableStr = tableStr + '□';
		     }
		 tableStr = tableStr + '</span><span class="title2">新办</span></td><td><span class="fangge"> ';
			 if(ywlxStr=="换证"&&pntFlag==1)
			 {
				 tableStr = tableStr + '■';
				 ywlxState='yes'; 
		     } else {
		    	  tableStr = tableStr + '□';
		     }
		 tableStr = tableStr + '</span><span class="title2">换证</span></td> <td><span class="fangge">'; 
			 if(ywlxStr=="变更"&&pntFlag==1)
			 {
				 tableStr = tableStr + '■';
				 ywlxState='yes'; 
		     } else {
		    	  tableStr = tableStr + '□';
		     }
		 tableStr = tableStr + '</span><span class="title2">变更</span></td><td><span class="fangge"> ';
			 if(ywlxStr=="迁出"&&pntFlag==1)
			 {
				 tableStr = tableStr + '■';
				 ywlxState='yes'; 
		     } else {
		    	 tableStr = tableStr + '□';
		     }
		 tableStr = tableStr + '</span><span class="title2">迁出</span></td><td><span class="fangge">';
			 if(ywlxStr=="迁入"&&pntFlag==1)
			 {
				tableStr = tableStr + '■';
				ywlxState='yes'; 
		     } else {
		    	 tableStr = tableStr + '□';
		     }
		 tableStr = tableStr + '</span><span class="title2">迁入</span></td><td><span class="fangge">'; 
			 if(ywlxStr=="年检"&&pntFlag==1)
			 {
				 tableStr = tableStr + '■';
				 ywlxState='yes'; 
		     } else {
		    	  tableStr = tableStr + '□';
		     }
		 tableStr = tableStr + '</span><span class="title2">年检</span></td><td><span class="fangge">'; 
			 if(ywlxStr=="补证"&&pntFlag==1)
			 {
				tableStr = tableStr + '■';
				ywlxState='yes';
		     } else {
		    	  tableStr = tableStr + '□';
		     }
		 tableStr = tableStr + '</span><span class="title2">补证</span></td><td><span class="fangge">';
			 if(ywlxStr=="其它"&&pntFlag==1)
			 {
				  tableStr = tableStr + '■';
		     } else {
		    	  tableStr = tableStr + '□';
		     }
		tableStr = tableStr + '</span><span class="title2">其它</span></td></tr></table> ';
		tableStr = tableStr + '				</td> ';
		tableStr = tableStr + '			</tr> ';
		if(pntFlag==1){
			tableStr = tableStr + '			<tr><td width="115" height="30" class="title1"><div align="center">代码有效期</div></td><td colspan="3" class="txt1"><div align="center">&nbsp;'+dateFormatToYMD(resultObject.bzrq)+'  至  '+dateFormatToYMD(resultObject.zfrq)+'&nbsp;&nbsp;</div></td></tr> ';
		}else{
			tableStr = tableStr + '			<tr><td width="115" height="30" class="title1"><div align="center">代码有效期</div></td><td colspan="3" class="txt1"><div align="center">  至 &nbsp;&nbsp;</div></td></tr> ';
		}
		tableStr = tableStr + '			<tr><td width="115" height="30" class="title1"><div align="center">经济行业(11版)</div></td><td width="245" class="txt1">&nbsp;'+resultObject.jjhymc+' '+resultObject.jjhydm+'</td> ';
		tableStr = tableStr + '				<td width="115" class="title1" align="center">机构类型(06版)</td><td width="245" class="txt1">&nbsp;'+resultObject.jglx+' '+resultObject.jglxdm+'</td></tr> ';
		tableStr = tableStr + '			<tr><td height="30" class="title1"><div align="center">受&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;理</div></td><td align="right" class="title2">年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</td> ';
		tableStr = tableStr + '				<td class="title1"><div align="center">审&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;核</div></td><td align="right"class="title2">年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</td></tr> ';
		tableStr = tableStr + '			<tr><td height="30" class="title1"><div align="center">录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;入</div></td><td align="right"class="title2">年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</td> ';
		tableStr = tableStr + '				<td class="title1"><div align="center">扫&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;描</div></td><td align="right"class="title2">年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</td></tr> ';
		tableStr = tableStr + '			<tr><td height="30" class="title1"><div align="center">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</div></td><td align="left" colspan=3>&nbsp;</td></tr>';
		tableStr = tableStr + '		</table><br> ';
		tableStr = tableStr + '		</td> ';
		tableStr = tableStr + '		</tr></table></center><script language="JavaScript">function reportPrint(){window.location.reload();window.print();}</script></body></html>';
	}  
	return String.format(tableStr);
}


//------------------------录入后下拉列表显示行政区划----------------------------
var xzqhCode;
var ds_xzqh_select = new Ext.data.Store({
	url : 'findAllXzqh.action',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'xzqhCode',type : 'string'},
		{name : 'xzqhName',type : 'string'}
	])
});


var ds_zjlx_select = new Ext.data.Store({
	url : 'findAllBySubjectid.action?subjectId=2',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'categoryId',type : 'int'},
		{name : 'categoryName',type : 'string'},
		{name : 'categoryCode',type : 'string'}
	])
});

var ds_bzjgdm_all = new Ext.data.Store({
	url : 'findBzjgByCenter.action?centerid=1',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'bzjgId',type : 'int'},
		{name : 'bzjgName',type : 'string'},
		{name : 'bzjgCode',type : 'string'}
	])
});

var ds_user_select = new Ext.data.Store({
	url : 'findUserByExample.action',
	reader : new Ext.data.JsonReader({
		root : 'root'
	}, [{name : 'userId',type : 'int'}, 
		{name : 'emplName',type : 'string'}
	])
})

var gkStr = [['1','是'],['2','否']]; 
var gkStore = new Ext.data.SimpleStore({fields:['gkCode','gk'],data:gkStr});
var fkbzStr = [['1','是'],['2','否']]; 
var fkbzStore = new Ext.data.SimpleStore({fields:['fkbzCode','fkbz'],data:fkbzStr});
var ywlxStr = [['1','新办'],['2','年检'],['3','变更'],['4','换证'],['5','补证'],['6','迁入'],['7','迁出'],['8','预赋码'],['9','注销'],['10','批量注销']]; 
var ywlxStore = new Ext.data.SimpleStore({fields:['ywlxCode','ywlx'],data:ywlxStr});
var isxwStr = [['1','是'],['2','否']]; 
var isxwStore = new Ext.data.SimpleStore({fields:['isxwCode','isxw'],data:isxwStr});

//国家中心
//var dmlxStr = [['0','个体'],['3','非个体'],['9','军队']]; 
//地方中心无军队
var dmlxStr = [['0','个体'],['3','非个体']]; 
var dmlxStore = new Ext.data.SimpleStore({fields:['dmlxCode','dmlx']});
var dmlxStrYfm = [['1','预赋码']];
var dmlxStoreYfm = new Ext.data.SimpleStore({fields:['dmlxCode','dmlx']});
var getDmlxStore = function(str){
	if(str=='yfm'){
		dmlxStoreYfm.loadData(dmlxStrYfm);
		return dmlxStoreYfm;
	}else{
		dmlxStore.loadData(dmlxStr);
		return dmlxStore;
	}
}

var codelxStr =  [['0','个体'],['3','非个体'],['9','军队']]; 
var codeTypeStore = new Ext.data.SimpleStore({fields:['fmtypeCode','fmtypeName'],data:codelxStr});

var zslxStr = [['0','正本'],['1','副本']]; 
var zstypeStore = new Ext.data.SimpleStore({fields:['zstypeCode','zstypeName'],data:zslxStr});

var fmlxStr = [['0','其它部门'],['1','省间迁入']]; 
var fmtypeStore = new Ext.data.SimpleStore({fields:['fmtypeCode','fmtypeName'],data:fmlxStr});



var sexStr = [['0','男'],['1','女']]; 
var sexTypeStore = new Ext.data.SimpleStore({fields:['sexCode','sex'],data:sexStr});



//依据经济类型代码 查询 名称 函数
var findMcByDm = function(field){
	var code = field.getValue();
	if(code!=""){
		Ext.Ajax.request({
			url : 'findJjlxNameByCode.action',
			params : {jjlxdm : code},
			success : function(response) {
				eval("var data = "+response.responseText);
				if(data!=null){
					field.ownerCt.ownerCt.ownerCt.form.findField('jjlx').setValue(data.jjlxmc);
					field.ownerCt.ownerCt.ownerCt.form.findField('jjlxdmOld').setValue(data.ojjlxdm00);
					field.ownerCt.ownerCt.ownerCt.form.findField('jjlxOld').setValue(data.ojjlxmc00);
					if(code>5000 && code<8000){
						field.ownerCt.ownerCt.ownerCt.form.findField('wftzgb').allowBlank=false;
						field.ownerCt.ownerCt.ownerCt.form.findField('wftzgbdm').allowBlank=false;
						if(code>6000 && code<7000){
							field.ownerCt.ownerCt.ownerCt.form.findField('wftzgb').setValue('港澳台');
							field.ownerCt.ownerCt.ownerCt.form.findField('wftzgbdm').setValue('344');
						}
					}else{
						field.ownerCt.ownerCt.ownerCt.form.findField('wftzgb').allowBlank=true;
						field.ownerCt.ownerCt.ownerCt.form.findField('wftzgbdm').allowBlank=true;
					}			
				}
			},
			failure : function() {
				field.ownerCt.ownerCt.ownerCt.form.findField('jjlx').setValue('');
				field.ownerCt.ownerCt.ownerCt.form.findField('jjlxdmOld').setValue('');
				field.ownerCt.ownerCt.ownerCt.form.findField('jjlxOld').setValue('');
			}
		});
	}else{
		field.ownerCt.ownerCt.ownerCt.form.findField('jjlx').setValue('');
		field.ownerCt.ownerCt.ownerCt.form.findField('jjlxdmOld').setValue('');
		field.ownerCt.ownerCt.ownerCt.form.findField('jjlxOld').setValue('');
	}
}

//依据数据字典名称 查询代码 函数
var findWftzgbDmByMC = function(field){
	var strWftzgb = field.getRawValue();
	if(strWftzgb!=""){
		Ext.Ajax.request({
			url : 'findDictCodeByName.action',
			params : {categoryName : strWftzgb,subjectId:'3'},
			success : function(response) {
				eval("var data = "+response.responseText);
				if(data!=null){
					field.ownerCt.ownerCt.ownerCt.form.findField('wftzgb').setValue(data.categoryName);
					field.ownerCt.ownerCt.ownerCt.form.findField('wftzgbdm').setValue(data.categoryCode);
					//qianruViewForm.getForm().findField('jjlx').setValue(data.jjlxmc);
				}else{
					field.ownerCt.ownerCt.ownerCt.form.findField('wftzgb').setValue('');
					field.ownerCt.ownerCt.ownerCt.form.findField('wftzgbdm').setValue('');
				}
			},
			failure : function() {
				
				field.ownerCt.ownerCt.ownerCt.form.findField('wftzgb').setValue('');
				field.ownerCt.ownerCt.ownerCt.form.findField('wftzgbdm').setValue('');
			}
		});
	}else{
		field.ownerCt.ownerCt.ownerCt.form.findField('wftzgb').setValue('');
		field.ownerCt.ownerCt.ownerCt.form.findField('wftzgbdm').setValue('');
	}
}



//依据代码 查询 名称 函数
var findXzqhNameByXzqhCode = function(field,id){
	var strXzqhCode = field.getValue();
	if(strXzqhCode!=""){
		Ext.Ajax.request({
			url : 'findXzqhNameByXzqhCode.action',
			params : {xzqhCode : strXzqhCode},
			success : function(response) {
				eval("var data = "+response.responseText);
				if(data!=null){
					//this.ownerCt.ownerCt.ownerCt.ownerCt.ownerCt.form.findField('jjlx').setValue(data.jjlxmc);
					field.ownerCt.ownerCt.ownerCt.form.findField(id).setValue(data.xzqhName);
					//qianruViewForm.getForm().findField('jjlx').setValue(data.jjlxmc);
				}
			},
			failure : function() {
				
				field.ownerCt.ownerCt.ownerCt.form.findField(id).setValue('');
			}
		});
	}else{
		field.ownerCt.ownerCt.ownerCt.form.findField(id).setValue('');
	}
}

//依据行业代码 查询 名称 函数
var findHylxNameByCode = function(field){
	var strHylxdm = field.getValue();
	if(strHylxdm!=""){
		Ext.Ajax.request({
			url : 'findHylxNameByCode.action',
			params : {hylxdm : strHylxdm},
			success : function(response) {
				eval("var data = "+response.responseText);
				if(data!=null){
					//this.ownerCt.ownerCt.ownerCt.ownerCt.ownerCt.form.findField('jjlx').setValue(data.jjlxmc);
					field.ownerCt.ownerCt.ownerCt.form.findField('jjhymc').setValue(data.hylxmc);
					field.ownerCt.ownerCt.ownerCt.form.findField('jjhymcOld').setValue(data.hylxmcOld);
					field.ownerCt.ownerCt.ownerCt.form.findField('jjhydmOld').setValue(data.hylxdmOld);
					//qianruViewForm.getForm().findField('jjlx').setValue(data.jjlxmc);
				}
			},
			failure : function() {
				
				field.ownerCt.ownerCt.ownerCt.form.findField('jjhymc').setValue('');
				field.ownerCt.ownerCt.ownerCt.form.findField('jjhymcOld').setValue('');
				field.ownerCt.ownerCt.ownerCt.form.findField('jjhydmOld').setValue('');
			}
		});
	}else{
		field.ownerCt.ownerCt.ownerCt.form.findField('jjhymc').setValue('');
		field.ownerCt.ownerCt.ownerCt.form.findField('jjhymcOld').setValue('');
		field.ownerCt.ownerCt.ownerCt.form.findField('jjhydmOld').setValue('');
	}
}

//依据行业代码 查询 名称 函数
var findTjgdmByCode = function(field){
	var strJgdm = field.getValue();
	if(strJgdm!=""){
		Ext.Ajax.request({
			url : 'findTjgdmByCode.action',
			params : {jgdm : strJgdm},
			success : function(response) {
				eval("var data = "+response.responseText);
				if(data!=null){
					//this.ownerCt.ownerCt.ownerCt.ownerCt.ownerCt.form.findField('jjlx').setValue(data.jjlxmc);
					field.ownerCt.ownerCt.ownerCt.form.findField('zgmc').setValue(data.jgmc);
					//qianruViewForm.getForm().findField('jjlx').setValue(data.jjlxmc);
				}
			},
			failure : function() {
				
				field.ownerCt.ownerCt.ownerCt.form.findField('zgmc').setValue('');
			}
		});
	}else{
		field.ownerCt.ownerCt.ownerCt.form.findField('zgmc').setValue('');
	}
}

//依据机构类型代码 查询 名称 函数
var findJglxNameByCode = function(field){
	var strJglxdm = field.getValue();
	if(strJglxdm!=""){
		Ext.Ajax.request({
			url : 'findJglxNameByCode.action',
			params : {jglxdm : strJglxdm},
			success : function(response) {
				eval("var data = "+response.responseText);
				if(data!=null){
					field.ownerCt.ownerCt.ownerCt.form.findField('jglx').setValue(data.jglxmc);
					if(data.pjglxdm==1){
						field.ownerCt.ownerCt.ownerCt.form.findField('jjlx').allowBlank=false;
						field.ownerCt.ownerCt.ownerCt.form.findField('jjlxdm').allowBlank=false;
						feizhiViewForm.getForm().findField('jjlx').allowBlank=true;
						feizhiViewForm.getForm().findField('jjlxdm').allowBlank=true;
					}else{
						field.ownerCt.ownerCt.ownerCt.form.findField('jjlx').allowBlank=true;
						field.ownerCt.ownerCt.ownerCt.form.findField('jjlxdm').allowBlank=true;
					}
				}else{
					field.ownerCt.ownerCt.ownerCt.form.findField('jglx').setValue('');
					field.ownerCt.ownerCt.ownerCt.form.findField('jglxOld').setValue('');
					field.ownerCt.ownerCt.ownerCt.form.findField('jglxdmOld').setValue('');
					if(field.ownerCt.ownerCt.ownerCt.form.findField('jjlxdm').getValue()!=null){
						field.ownerCt.ownerCt.ownerCt.form.findField('jjlxdm').allowBlank=true;
						field.ownerCt.ownerCt.ownerCt.form.findField('jjlx').allowBlank=true;
					}
				}
			},
			failure : function() {
				field.ownerCt.ownerCt.ownerCt.form.findField('jglx').setValue('');
				field.ownerCt.ownerCt.ownerCt.form.findField('jjlx').allowBlank=true;
				field.ownerCt.ownerCt.ownerCt.form.findField('jjlxdm').allowBlank=true;
				if(field.ownerCt.ownerCt.ownerCt.form.findField('jjlxdm').getValue()!=null){
					field.ownerCt.ownerCt.ownerCt.form.findField('jjlxdm').allowBlank=true;
					field.ownerCt.ownerCt.ownerCt.form.findField('jjlx').allowBlank=true;
				}
			}
		});
	}else{
		field.ownerCt.ownerCt.ownerCt.form.findField('jglx').setValue('');
		field.ownerCt.ownerCt.ownerCt.form.findField('jjlx').allowBlank=true;
		field.ownerCt.ownerCt.ownerCt.form.findField('jjlxdm').allowBlank=true;
		if(field.ownerCt.ownerCt.ownerCt.form.findField('jjlxdm').getValue()!=null){
			field.ownerCt.ownerCt.ownerCt.form.findField('jjlxdm').allowBlank=true;
			field.ownerCt.ownerCt.ownerCt.form.findField('jjlx').allowBlank=true;
		}
	}
}

//依据主管机构代码 查询 名称 函数
var findZgjgNameByCode = function(field){
	var strJgdm = field.getValue();
	if(strJgdm!=""){
		Ext.Ajax.request({
			url : 'findZgjgNameByCode.action',
			params : {jgdm : strJgdm},
			success : function(response) {
				eval("var data = "+response.responseText);
				if(data!=null){
					//this.ownerCt.ownerCt.ownerCt.ownerCt.ownerCt.form.findField('jjlx').setValue(data.jjlxmc);
					field.ownerCt.ownerCt.ownerCt.form.findField('zgmc').setValue(data.zgjgmc);
					//qianruViewForm.getForm().findField('jjlx').setValue(data.jjlxmc);
				}
			},
			failure : function() {
				
				field.ownerCt.ownerCt.ownerCt.form.findField('zgmc').setValue('');
			}
		});
	}else{
		field.ownerCt.ownerCt.ownerCt.form.findField('zgmc').setValue('');
	}
}

//依据批准结构代码 查询 名称 函数
var findPzjgNameByCode = function(field){
	var strPzjgdm = field.getValue();
	if(strPzjgdm!=""){
		Ext.Ajax.request({
			url : 'findPzjgNameByCode.action',
			params : {pzjgdm : strPzjgdm},
			success : function(response) {
				eval("var data = "+response.responseText);
				if(data!=null){
					field.ownerCt.ownerCt.ownerCt.form.findField('pzjgmc').setValue(data.pzjgmc);
					field.ownerCt.ownerCt.ownerCt.form.findField('pzjgdm').setValue(data.pzjgdm);
				}
			},
			failure : function() {
				
				field.ownerCt.ownerCt.ownerCt.form.findField('pzjgmc').setValue('');
				field.ownerCt.ownerCt.ownerCt.form.findField('pzjgdm').setValue('');
			}
		});
	}else{
		field.ownerCt.ownerCt.ownerCt.form.findField('pzjgmc').setValue('');
		field.ownerCt.ownerCt.ownerCt.form.findField('pzjgdm').setValue('');
	}
}

function GetXmlHttp()
{
	var xmlhttp=false;
	try
	{xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");}
	catch (e)
	{
		try
		{xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");}
		catch(E)
		{xmlhttp = false;}
	}
	
	if (!xmlhttp && typeof XMLHttpRequest!='undefined')
	{
		try
		{xmlhttp = new XMLHttpRequest();}
		catch (e)
		{xmlhttp=false;}
	}
	
	if (!xmlhttp && window.createRequest)
	{
		try
		{xmlhttp = window.createRequest();}
		catch (e)
		{xmlhttp=false;}
	}
	return xmlhttp;
}



function goZslyFlag(value,p,record)
{
   var flagValue;
   flagValue=record.data["flag"];
   if(typeof flagValue!=''){
	   switch (flagValue) {
	   case '0' :
		   return String.format('<font color="DarkBlue"><b>未使用</b></font>');
	   case '1' :
		   return String.format('<font color="DarkBlue"><b>已使用</b></font>');
	   case '2' :
		   return String.format('<font color="blue"><b>已损耗</b></font>');
	   default :
		   return String.format('<font color="green"><b>后台赋值数据错误。。。</b></font>');
	   } 
	}
	//return stateValue
}

var dateFormatShzt = function(v){
	if(v){
		return v.substring(0,10)
	}
	return '未审批';
}

var dateFormat = function(v){
	if(v){
		return v.substring(0,10)
	}
	return '未审批';
}

var goDateFormat = function(v){
	if(v){
		return v.substring(0,10)
	}
}

function goErrorflag(value,p,record)
{
   var ErrorflagValue;
   ErrorflagValue=record.data["errorFlag"];
   if(ErrorflagValue.toString()!=""){
	   var Errorflags = ErrorflagValue.split(",");
	   var strEsFlag='';
	   for (var i = 0; i < Errorflags.length-1; i++) {
		   var esFlag=Errorflags[i];
		   if(esFlag!=""){
			   switch (esFlag) {
			   case '1' :
				   strEsFlag=strEsFlag+'<font color=red>1</font>图像不清晰 ';
				   break;
			   case '2' :
				   strEsFlag=strEsFlag+'<font color=red>2</font>图像黑边、倾斜 ';
				   break;
			   case '3' :
				   strEsFlag=strEsFlag+'<font color=red>3</font>图像混扫 ';
				   break;
			   case '4' :
				   strEsFlag=strEsFlag+'<font color=red>4</font>图像残缺 ';
				   break;
			   case '5' :
				   strEsFlag=strEsFlag+'<font color=red>5</font>建档日期错误 ';
				   break;
			   case '6' :
				   strEsFlag=strEsFlag+'<font color=red>6</font>档案分类错误 ';
				   break;
			   case '7' :
				   strEsFlag=strEsFlag+'<font color=red>7</font>申请表标识问题 ';
				   break;
			   case '8' :
				   strEsFlag=strEsFlag+'<font color=red>8</font>批准证书标识问题 ';
				   break;
			   case '9' :
				   strEsFlag=strEsFlag+'<font color=red>9</font>身份证明文件标识问题 ';
				   break;
			   case '10' :
				   strEsFlag=strEsFlag+'<font color=red>10</font>其他文件标示问题 ';
				   break;
			   case '11' :
				   strEsFlag=strEsFlag+'<font color=red>11</font>其他问题 ';
				   break;
			   case '12' :
				   strEsFlag=strEsFlag+'<font color=red>12</font>批准文件不合格 ';
				   break;
			   case '13' :
				   strEsFlag=strEsFlag+'<font color=red>13</font>缺页问题 ';
				   break;
			   case '20' :
				   strEsFlag=strEsFlag+'<font color=red>20</font>批量问题 ';
				   break;
			   case '21' :
				   strEsFlag=strEsFlag+'<font color=red>21</font>多个问题 ';
				   break;
			   case '22' :
				   strEsFlag=strEsFlag+'<font color=red>22</font>年检执照问 ';
				   break;
			   default :
				   strEsFlag=strEsFlag+'';
			       break;
			   } 
	   		}else{
	   			strEsFlag='';
			}
	   }
   }else{
	   strEsFlag="";
   }
    return String.format(strEsFlag);
}

function goDflag(value,p,record)
{
   	var DflagValue;
   	DflagValue=record.data["d_flag"];
	var strDFlag='';
	switch (DflagValue) {
		case 3 :
			strDFlag='<font color=blacke>正式库</font>';
			break;
		case 1 :
		   	strDFlag='<font color=blue>临时库</font>';
		   	break;
	   	case 2 :
		   	strDFlag='<font color=red>问题库</font>';
		   	break;
	   	default :
		   	strDFlag='';
	       	break;
   } 
    return String.format(strDFlag);
}

function linker(value,p,record)
{
   var fileUrl;
   fileUrl=record.data["bookId"] +'/'+ record.data["logId"]+'.jpg';
   if(typeof val!=''){
	   return String.format('<a style="display:table;width:100%;" onclick=viewPic("'+record.data["bookName"]+'","file/2012/'+fileUrl+'")>'+ record.data["bookName"]+'</a>',record.data.ID);
   		//return String.format('<a style="display:table;width:100%;" target="_blank" href="file/2012/' + record.data["bookId"] +'/'+ record.data["logId"]+'.jpg" >'+ record.data["bookName"]+'</a>',record.data.ID)
	}
	return val;
};

//跟新imageFlag的方法
var refreshImageFlag = function(orgid,imageFlag){
	Ext.Ajax.request({
		url: 'saveOrgnew.action',
		params: {orgid: orgid,imageFlag: imageFlag},
		success: function(){}
	});
}

function icon_dam(value,p,record){
	if(typeof record=='object'){
		var fileUrl;
		fileUrl=record.data["imageData"];
		//alert(fileUrl);
		if(fileUrl!=''){
			return String.format('<a style="display:table;width:100%;"><img src="images/file_ico.gif"></a>',record.data["orgid"]);
		}
	}  
}

function validateJgmc(jgmc,docid){
	var flag = false;
	var xmlhttp = GetXmlHttp(); 
	xmlhttp.open("post", "validateJgmc.action?", false);
	xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");//这句必须要，而且一定要放在send以前
	xmlhttp.send("jgmc=" + jgmc +"&docid=" + docid); 
 	var objs = eval("["+xmlhttp.responseText+"]");
	if(!objs[0].success){//objs[0].success=true 说明无重复数据可保存
		alert("机构名称为["+jgmc+"]的数据已赋码，不可修改数据！");
	}
	return objs[0].success;
}
