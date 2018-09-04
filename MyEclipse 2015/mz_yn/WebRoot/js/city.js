function GetCity(option,city){
	
	var cityObj = document.getElementById(city);
	
	var dmId = option.value;
	cityObj.options.length = 0;
	DWREngine.setAsync(false);
	UserBus.getChildProvince(dmId,{callback:function(citys){
		
				if(citys != null && citys.length != 0){
					for(var i=0;i<citys.length;i++){
						var text = citys[i].mc;
						var value = citys[i].dm;
						cityObj.options.add(new Option(text,value));	
					}	
				}else{
						var text = "Ñ¡Ôñ";
						var value = "";
						cityObj.options.add(new Option(text,value));
					}
		
		}});
	DWREngine.setAsync(true);
		
}