/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-8-30
 * Time: 下午4:18
 * To change this template use File | Settings | File Templates.
 */
function view(display,count){
    if(count > 3000){
         ymPrompt.alert({message:"最多导出3000行，请从数据库直接导出!",showMask: false});
        return false;
    }else{
	    ymPrompt.win({message:'selectedFields.jsp?display='+display,handler:callBack,width:600,height:450,title:'导出企业信息',iframe:true});
    }
}
function view1(display,count){
    if(count > 3000){
         ymPrompt.alert({message:"最多导出3000行，请从数据库直接导出!",showMask: false});
        return false;
    }else{
	    ymPrompt.win({message:'selectedFields1.jsp?display='+display,handler:callBack,width:600,height:450,title:'导出产品信息',iframe:true});
    }
}
function callBack(tp)
{
 	//window.location.reload();
}