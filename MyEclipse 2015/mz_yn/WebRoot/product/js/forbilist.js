/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-8-30
 * Time: ����10:29
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
		 ymPrompt.alert({message:"��ѯ�ؼ��ֲ��ܰ���'", width:330, height:220, title:'��ʾ��Ϣ'});
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
   ymPrompt.alert({message:"�����������", width:330, height:220, title:'��ʾ��Ϣ'});
   frmAction.forbidWord.focus();
   return false;
  }else if(forbidWord.length > 10){
	  ymPrompt.alert({message:"���ֻ��¼��10�����֣����������룡", width:330, height:220, title:'��ʾ��Ϣ'});
	  return false;
	}
  var Special_chars="~!@#$%^&*()_+`-={}|\":>?<,/.'[]\\";
  for(i=0;i<forbidWord.length;i++) {
    if(Special_chars.indexOf(forbidWord.charAt(i))!=-1) {
      ymPrompt.alert({message:"��ȥ���Ƿ��ַ�! (", width:330, height:220, title:'��ʾ��Ϣ'});
      frmAction.forbidWord.focus();
      return false;
    }
  }
  var mycars=new Array();
  forbidWord = forbidWord.replace(/[��]/g,';');

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

	if(result){//�Ѿ�����

	     document.getElementById("wordDiv").innerHTML = "<font color='red'>�����Ѿ���ʹ�ã����������룡</font>";
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

//�ж��Ƿ�Ϊ��
String.prototype.Trim = function()
{
    return this.replace(/(^\s*)|(\s*$)/g, "");
}