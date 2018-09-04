function GetCity2(option,city){
	
	var cityObj = document.getElementById(city);
	
	var dmId = option.value;
	cityObj.options.length = 0;
	dwr.engine.setAsync(false);
	UserBus.getBzjgdmByXzqhID(dmId,{callback:function(citys){
		cityObj.options.add(new Option("选择",""));
				if(citys != null && citys.length != 0){
					for(var i=0;i<citys.length;i++){
						var text = citys[i].mc;
						var value = citys[i].dm;
						cityObj.options.add(new Option(text,value));	
					}	
				}else{
						var text = "选择";
						var value = "";
						cityObj.options.add(new Option(text,value));
					}
		
		}});
	dwr.engine.setAsync(true);
		
}

function GetTwoXzqh2(option,twoXzqh){

	var cityObj = document.getElementById(twoXzqh);

	var dmId = option.value;
	cityObj.options.length = 0;
	dwr.engine.setAsync(false);
	XzqhBus.getSecondGradeElement(dmId,{callback:function(citys){
				cityObj.options.add(new Option("-- 选择 --",""));
				if(citys != null && citys.length != 0){
					cityObj.removeAttribute('disabled');
					for(var i=0;i<citys.length;i++){
						var text = citys[i].provinceName;
						var value = citys[i].id;
						cityObj.options.add(new Option(text,value));	
					}	
				}else{
						//var text = "选择";
						//var value = "";
						//cityObj.options.add(new Option(text,value));
						cityObj.setAttribute('disabled','disabled');
					}
		
		}});
	dwr.engine.setAsync(true);
		
}

function GetThreeXzqh2(option,threeXzqh){

	var cityObj = document.getElementById(threeXzqh);

	var dmId = option.value;
	cityObj.options.length = 0;
	dwr.engine.setAsync(false);
	XzqhBus.getThirdGradeElement(dmId,{callback:function(citys){
		cityObj.options.add(new Option("-- 选择 --",""));
				if(citys != null && citys.length != 0){
					cityObj.removeAttribute('disabled');
					for(var i=0;i<citys.length;i++){
						var text = citys[i].provinceName;
						var value = citys[i].id;
						cityObj.options.add(new Option(text,value));	
					}	
				}else{
						//var text = "选择";
						//var value = "";
						//cityObj.options.add(new Option(text,value));
						cityObj.setAttribute('disabled','disabled');
					}
		
		}});
	dwr.engine.setAsync(true);
		
}