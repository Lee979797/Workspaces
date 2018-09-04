function GetMidType(option,cpfl){
	
	var cpflObj = document.getElementById(cpfl);
	
	var dmId = option.value;
	cpflObj.options.length = 0;
	DWREngine.setAsync(false);
	CpflBo.getMidType(dmId,{callback:function(cpfls){
		
				if(cpfls != null && cpfls.length != 0){
					for(var i=0;i<cpfls.length;i++){
						var text = cpfls[i].skcb;
						var value = cpfls[i].cpdm;
						cpflObj.options.add(new Option(text,value));	
					}	
				}else{
						var text = "Ñ¡Ôñ";
						var value = "";
						cpflObj.options.add(new Option(text,value));
					}
		
		}});
	DWREngine.setAsync(true);
		
}

function GetSmlType(option,cpfl){
	
	var cpflObj = document.getElementById(cpfl);
	
	var dmId = option.value;
	cpflObj.options.length = 0;
	DWREngine.setAsync(false);
	CpflBo.getSmlType(dmId,{callback:function(cpfls){
		
				if(cpfls != null && cpfls.length != 0){
					for(var i=0;i<cpfls.length;i++){
						var text = cpfls[i].skcb;
						var value = cpfls[i].cpdm;
						cpflObj.options.add(new Option(text,value));	
					}	
				}else{
						var text = "Ñ¡Ôñ";
						var value = "";
						cpflObj.options.add(new Option(text,value));
					}
		
		}});
	DWREngine.setAsync(true);
		
}