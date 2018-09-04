/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-8-30
 * Time: 下午3:10
 * To change this template use File | Settings | File Templates.
 */
function buildSelectValues()
{
        var l_tTreeObject = document.forms[0].selectedrole;
        var l_tOptions = l_tTreeObject.options;
        var l_tOption;
        for(var i=0;i<l_tOptions.length;i++)
        {
                l_tOption = l_tOptions[i];
                l_tOption.selected = true;
        }
}
function add(){

        var allRoles = document.forms[0].alllist;
		var selectedRoles = document.forms[0].selectedrole;
		//alert(allRoles.options.length);
        if (allRoles.selectedIndex<0){

				ymPrompt.alert('授权的角色不能为空',300,200,'提示信息');
                return;
        }

		if(allRoles){
		    if(allRoles.length>0){
			    var selectedOptions = [];
				for(var allRoleIndex=0;allRoleIndex<allRoles.length;allRoleIndex++){

					if(allRoles.options[allRoleIndex].selected){

                        var select = document.createElement("OPTION");
						select.value=allRoles[allRoleIndex].value;
		                select.text=allRoles[allRoleIndex].innerText;

                        selectedRoles.options.add(select);

                        selectedOptions.push(allRoleIndex);
					}
				}

				if(selectedOptions.length>0){
				    var index = 0;
				    for(var selectedOptionIndex=0;selectedOptionIndex<selectedOptions.length;selectedOptionIndex++){
						//alert(allRoles.length);
						//alert(allRoles.options[selectedOptions[selectedOptionIndex]].value);
						//allRoles.options[selectedOptions[selectedOptionIndex]]=null;
						allRoles.options.remove(selectedOptions[selectedOptionIndex]-index);
						index++;
					}
				}
			}
		}


}

function addAll(){

        var allRoles = document.forms[0].alllist;
		var selectedRoles = document.forms[0].selectedrole;
		if(allRoles){
		    if(allRoles.length>0){
			    var selectedOptions = [];
				for(var allRoleIndex=0;allRoleIndex<allRoles.length;allRoleIndex++){

					var select = document.createElement("OPTION");
					select.value=allRoles[allRoleIndex].value;
					select.text=allRoles[allRoleIndex].innerText;

					selectedRoles.options.add(select);

					selectedOptions.push(allRoleIndex);

				}

				if(selectedOptions.length>0){
				    var index = 0;
				    for(var selectedOptionIndex=0;selectedOptionIndex<selectedOptions.length;selectedOptionIndex++){

						allRoles.options.remove(selectedOptions[selectedOptionIndex]-index);
						index++;
					}
				}
			}
		}


}

function del(){

        var allRoles = document.forms[0].alllist;
		var selectedRoles = document.forms[0].selectedrole;
        if (selectedRoles.selectedIndex<0){

				ymPrompt.alert('请选择您所要删除的角色',300,185,'提示信息');
                return;
        }

		if(selectedRoles){

		    if(selectedRoles.length>0){
			    var selectedOptions = [];
				for(var selectedRoleIndex=0;selectedRoleIndex<selectedRoles.length;selectedRoleIndex++){

					if(selectedRoles.options[selectedRoleIndex].selected){

                        var select = document.createElement("OPTION");
						select.value=selectedRoles[selectedRoleIndex].value;
		                select.text=selectedRoles[selectedRoleIndex].innerText;

                        allRoles.options.add(select);

                        selectedOptions.push(selectedRoleIndex);
					}
				}

				if(selectedOptions.length>0){

				    var index = 0;
				    for(var selectedOptionIndex=0;selectedOptionIndex<selectedOptions.length;selectedOptionIndex++){


						selectedRoles.options.remove(selectedOptions[selectedOptionIndex]-index);
						index++;
					}
				}
			}
		}

}

function delAll(){

        var allRoles = document.forms[0].alllist;
		var selectedRoles = document.forms[0].selectedrole;


		if(selectedRoles){

		    if(selectedRoles.length>0){
			    var selectedOptions = [];
				for(var selectedRoleIndex=0;selectedRoleIndex<selectedRoles.length;selectedRoleIndex++){

					var select = document.createElement("OPTION");
					select.value=selectedRoles[selectedRoleIndex].value;
					select.text=selectedRoles[selectedRoleIndex].innerText;

					allRoles.options.add(select);

					selectedOptions.push(selectedRoleIndex);

				}

				if(selectedOptions.length>0){

				    var index = 0;
				    for(var selectedOptionIndex=0;selectedOptionIndex<selectedOptions.length;selectedOptionIndex++){


						selectedRoles.options.remove(selectedOptions[selectedOptionIndex]-index);
						index++;
					}
				}
			}
		}

}
function CheckValid(){
     if (document.forms[0].selectedrole.length<1){

				ymPrompt.alert({message:'授权的角色不能为空', width:330, height:220, title:'提示信息'});
        return false;
     }
     buildSelectValues();
     document.forms[0].submit();
}