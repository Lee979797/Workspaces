function GetCity(option,city){
	
	var cityObj = document.getElementById(city);
	
	var dmId = option.value;
	cityObj.options.length = 0;
	dwr.engine.setAsync(false);
	UserBus.getBzjgdmByXzqhID(dmId,{callback:function(citys){
		cityObj.options.add(new Option("Ñ¡Ôñ",""));
				if(citys != null && citys.length != 0){
					for(var i=0;i<citys.length;i++){
						var text = citys[i].mc;
						var value = citys[i].dm;
						cityObj.options.add(new Option(text,value));	
					}	
				}
		}});
	dwr.engine.setAsync(true);
		
}

function GetTwoXzqh(option,twoXzqh){

	var cityObj = document.getElementById(twoXzqh);

	var dmId = option.value;
	cityObj.options.length = 0;
	dwr.engine.setAsync(false);
	ProvinceBus.ListTwoAll(dmId,{callback:function(citys){
				cityObj.options.add(new Option("Ñ¡Ôñ",""));
				if(citys != null && citys.length != 0){
					for(var i=0;i<citys.length;i++){
						var text = citys[i].provinceName;
						var value = citys[i].id;
						cityObj.options.add(new Option(text,value));	
					}	
				}
		}});
	dwr.engine.setAsync(true);
		
}

function GetThreeXzqh(option,threeXzqh){

	var cityObj = document.getElementById(threeXzqh);

	var dmId = option.value;
	cityObj.options.length = 0;
	dwr.engine.setAsync(false);
	ProvinceBus.ListThreeAll(dmId,{callback:function(citys){
		cityObj.options.add(new Option("Ñ¡Ôñ",""));
				if(citys != null && citys.length != 0){
					for(var i=0;i<citys.length;i++){
						var text = citys[i].provinceName;
						var value = citys[i].id;
						cityObj.options.add(new Option(text,value));	
					}	
				}
		}});
	dwr.engine.setAsync(true);
		
}