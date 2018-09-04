/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-8-30
 * Time: 上午10:29
 * To change this template use File | Settings | File Templates.
 */
function startAction(url){
	  window.location.href=url;
}
function query(){
	var isTrue = true;
    var specialChar;
    if(typeof(document.searchForm.keyword)!='undefined'){
         if(!isEmpty(document.searchForm.keyword.value)){
          specialChar = CheckSpecialChar(document.searchForm.keyword.value,special_char.searchs);
        }
    }
    if(specialChar){
		 ymPrompt.alert({message:"查询关键字不能包含'", width:330, height:220, title:'提示信息'});
         isTrue = false;
		 return false;
	}

	if(isTrue){
		searchForm.submit();
	}
}
 var tag =0;
function forbidInsert(){
tag =0;
  var forbidWord =frmAction.forbidWord.value;
  if(isEmpty(forbidWord)){
   ymPrompt.alert({message:"请输入词条！", width:330, height:220, title:'提示信息'});
   frmAction.forbidWord.focus();
   return false;
  }else if(forbidWord.length > 10){
	  ymPrompt.alert({message:"最多只能录入10个汉字，请重新输入！", width:330, height:220, title:'提示信息'});
	  return false;
	}
  var Special_chars="~!@#$%^&*()_+`-={}|\":>?<,/.'[]\\";
  for(i=0;i<forbidWord.length;i++) {
    if(Special_chars.indexOf(forbidWord.charAt(i))!=-1) {
      ymPrompt.alert({message:"请去除非法字符! (", width:330, height:220, title:'提示信息'});
      frmAction.forbidWord.focus();
      return false;
    }
  }
  var mycars=new Array();
  forbidWord = forbidWord.replace(/[；]/g,';');

  mycars = forbidWord.split(";");
  dwr.engine.setAsync(false);

  for (i=0;i<mycars.length ;i++ )
    {
           ForbidwordBo.isExistForbidWord(mycars[i],doChackForbidWord);
    }
	  dwr.engine.setAsync(true);
	  if(tag==0){
   //   frmAction.action="";
	  frmAction.submit();
	  }
}

function doChackForbidWord(result){

	if(result){//已经存在

	     document.getElementById("wordDiv").innerHTML = "<font color='red'>词条已经被使用，请重新输入！</font>";
		frmAction.forbidWord.focus();
		tag=1;
		 return false;
	}else{

	}
}

function isEmpty (str) {
if ((str.Trim()==null)||(str.Trim().length==0)) return true;
else return(false);
}

//判断是否为空
String.prototype.Trim = function()
{
    return this.replace(/(^\s*)|(\s*$)/g, "");
}