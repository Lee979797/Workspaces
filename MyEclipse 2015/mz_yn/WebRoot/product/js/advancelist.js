/**
 * Created by IntelliJ IDEA.
 * User: jun
 * Date: 11-8-30
 * Time: ����4:18
 * To change this template use File | Settings | File Templates.
 */
function view(display,count){
    if(count > 3000){
         ymPrompt.alert({message:"��ർ��3000�У�������ݿ�ֱ�ӵ���!",showMask: false});
        return false;
    }else{
	    ymPrompt.win({message:'selectedFields.jsp?display='+display,handler:callBack,width:600,height:450,title:'������ҵ��Ϣ',iframe:true});
    }
}
function view1(display,count){
    if(count > 3000){
         ymPrompt.alert({message:"��ർ��3000�У�������ݿ�ֱ�ӵ���!",showMask: false});
        return false;
    }else{
	    ymPrompt.win({message:'selectedFields1.jsp?display='+display,handler:callBack,width:600,height:450,title:'������Ʒ��Ϣ',iframe:true});
    }
}
function callBack(tp)
{
 	//window.location.reload();
}