/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-4-7
 * Time: ����2:31
 * To change this template use File | Settings | File Templates.
 */
var RecommendFlag=true;//ȫ�ֱ���,�����ж��Ƿ���������ı�������
//����������������ʾ��Ϣ�ķ���
function clearRecommend(){
    var oTxt=document.getElementById("Recommend");
     if(RecommendFlag==true){
       oTxt.value="";
    }

}
function showRecommend()
{
    var oTxt=document.getElementById("Recommend");
      if(oTxt.value =="")
        {
            oTxt.value="��ҵ��ģ���ۺ������ϵ��Ա���Ŷӣ�������ϵ��Ʒ��ս�ԣ���ҵ�ķ�չ���̡�";
        }
        else
        {
             RecommendFlag=false;
        }
}
var CultureFlag=true;//ȫ�ֱ���,�����ж��Ƿ���������ı�������
//����������������ʾ��Ϣ�ķ���
function clearCulture(){
        var oTxt=document.getElementById("Culture");
         if(CultureFlag==true){
           oTxt.value="";
        }
}
function showCulture()
{
    var oTxt=document.getElementById("Culture");
        if(oTxt.value =="")
        {
            oTxt.value="�Ա���ҵ�����Ĳ�Ʒ�������������������ŵ���˴���д��ŵ���ݡ�";
        }else
        {
            CultureFlag=false;
        }
}
//        var ServiceinfoFlag=true;//ȫ�ֱ���,�����ж��Ƿ���������ı�������
//        //����������������ʾ��Ϣ�ķ���
//        function clearServiceinfo(){
//                var oTxt=document.getElementById("Serviceinfo");
//                 if(ServiceinfoFlag==true){
//                   oTxt.value="";
//                }
//        }
//        function showServiceinfo()
//        {
//            var oTxt=document.getElementById("Serviceinfo");
//                if(oTxt.value =="")
//                {
//                    oTxt.value="��ҵ���Ļ����������õ������ȣ������ϴ�ͼƬ����˵����";
//                }else
//                {
//                    ServiceinfoFlag=false;
//                }
//        }
var ProductDescFlag=true;
function clearProductDes(){
      var oTxt=document.getElementById("productDesc");
         if(ProductDescFlag==true){
           oTxt.value="";
        }
}
function showProductDes(){
    var oTxt=document.getElementById("productDesc");
        if(oTxt.value =="")
        {
            oTxt.value="��ҵ��Ҫ��Ʒ���ϵ�У���Ʒ�ص㣬��Ʒ��չ���̣����Ų�Ʒ���ܵȡ�";
        }else
        {
            ProductDescFlag=false;
        }
}
function checkform() {
    var flag = null;
    dwr.engine.setAsync(false);
    ForbidUtil.getBadWords(document.form1.Recommend.value, {callback:function(dwrreturn) {
        flag = dwrreturn;
    }
    });
    if (flag != "" && flag != null) {
        ymPrompt.alert({message:"��ȥ����ҵ��������еĲ�������������д�:", width:330, height:220, title:'��ʾ��Ϣ'});
        return false;
    }
    ForbidUtil.getBadWords(document.form1.productDesc.value, {callback:function(dwrreturn) {
        flag = dwrreturn;
    }
    });
    if (flag != "" && flag != null) {
        ymPrompt.alert({message:"��ȥ����Ʒ�����еĲ�������������д�:", width:330, height:220, title:'��ʾ��Ϣ'});
        return false;
    }
    ForbidUtil.getBadWords(document.form1.Culture.value, {callback:function(dwrreturn) {
        flag = dwrreturn;
    }
    });
    if (flag != "" && flag != null) {
        ymPrompt.alert({message:"��ȥ�����ų�ŵ�еĲ�������������д�:", width:330, height:220, title:'��ʾ��Ϣ'});
        return false;
    }
    ForbidUtil.getBadWords(document.form1.Oneself.value, {callback:function(dwrreturn) {
        flag = dwrreturn;
    }
    });
    if (flag != "" && flag != null) {
        ymPrompt.alert({message:"��ȥ����ע�еĲ�������������д�:", width:330, height:220, title:'��ʾ��Ϣ'});
        return false;
    }
    if(document.form1.Recommend.value.length>2000){
        ymPrompt.alert({message:"��ҵ����������Ȳ��ܶ���2000������!", width:330, height:220, title:'��ʾ��Ϣ'});
        return false;
    }
    if(document.form1.productDesc.value.length>2000){
        ymPrompt.alert({message:"��Ʒ�������Ȳ��ܶ���2000������!", width:330, height:220, title:'��ʾ��Ϣ'});
        return false;
    }
    if(document.form1.Culture.value.length>2000){
        ymPrompt.alert({message:"���ų�ŵ���Ȳ��ܶ���2000������!", width:330, height:220, title:'��ʾ��Ϣ'});
        return false;
    }
    if(document.form1.Oneself.value.length>1000){
        ymPrompt.alert({message:"��ҵ��ע���Ȳ��ܶ���1000������!", width:330, height:220, title:'��ʾ��Ϣ'});
        return false;
    }
    document.form1.submit();
    document.form1.btn.disabled = true;
}

function checkEmpty(gotopage) {
    var flag = false;//�ж��û��Ƿ���д����Ϣ
    if (!isEmpty(document.form1.Recommend.value)) {
        flag = true;
    }
    if (!isEmpty(document.form1.Culture.value)) {
        flag = true;
    }
    if (!isEmpty(document.form1.Serviceinfo.value)) {
        flag = true;
    }
    if (!isEmpty(document.form1.Oneself.value)) {
        flag = true;
    }
    if (flag) {
        //ȷ����д��Ϣ�Ƿ񱣴�
        ymPrompt.confirmInfo('������Ҫ��д������Ϣ����ҳ��Ϣ�Ƿ񱣴�?', 300, 185, '��ʾ��Ϣ', function (data) {
            if (data == 'ok') {
                return false;
            } else {
                window.location.href = gotopage;
            }
        }
                );
        return false;
    } else {
        window.location.href = gotopage;
    }
}

function uploadEnterpriseImg() {
    var _codeid = document.getElementById("codeid").value;
    ymPrompt.win('uploadEnterpriseImg.jsp?codeid=' + _codeid, 750, 450, '�ϴ���ҵͼƬ', null, null, null, {id:'certalert'});
}

function setEnterpriseImg(codeid,imageFlag) {
    var isIE=!!window.ActiveXObject;  //�ж��Ƿ�ΪIE�����
    var isIE6=isIE&&!window.XMLHttpRequest;
    var isIE8=isIE&&!!document.documentMode;
    var isIE7=isIE&&!isIE6&&!isIE8;
    enterpriseImage.findEnterprisesbImageByCodeid(codeid,imageFlag,"1", function(data) {
        var _html = "";
        if (data.length > 0) {
            document.getElementById('pictable'+imageFlag).innerHTML = _html;
            for(var i = 0; i< data.length ;i++)
            {
                _html = _html + "<a href=\"javascript:void(0);\" ><img src=\"" + data[i].storage + "\" width=\"35\" height=\"35\"  onclick=\"seteditimage(this," + data[i].eid + ","+imageFlag+");\" /></a>";
            }
        }
        document.getElementById('pictable'+imageFlag).innerHTML = _html;
        parent.document.all.main.height   =   document.body.scrollHeight;
    });
}

/**
 * ���ʹ��iframe�߶Ȳ�������Ӧ
 * @param codeid
 * @param imageFlag
 */
function setEnterpriseImgForFrame (codeid,imageFlag) {
    var isIE=!!window.ActiveXObject;  //�ж��Ƿ�ΪIE�����
    var isIE6=isIE&&!window.XMLHttpRequest;
    var isIE8=isIE&&!!document.documentMode;
    var isIE7=isIE&&!isIE6&&!isIE8;
    enterpriseImage.findEnterprisesbImageByCodeid(codeid,imageFlag,"1", function(data) {
        var _html = "";
        if (data.length > 0) {
            document.getElementById('pictable'+imageFlag).innerHTML = _html;
            for(var i = 0; i< data.length ;i++)
            {
                _html = _html + "<a href=\"javascript:void(0);\" ><img src=\"" + data[i].storage + "\" width=\"35\" height=\"35\"  onclick=\"seteditimage(this," + data[i].eid + ","+imageFlag+");\" /></a>";
            }
        }
        document.getElementById('pictable'+imageFlag).innerHTML = _html;
        if(isIE6){
            parent.document.all.main.height   =   document.body.scrollHeight;
        }else{
            if(data.length>0){
                parent.document.all.main.height   =   document.body.scrollHeight-10;
            }else
                parent.document.all.main.height   =   document.body.scrollHeight-45;
        }

    });
}


var selectedObject="" ;
function seteditimage(obj, imageid,imageFlag) {
    if(selectedObject=="")
    {
        selectedObject=obj;

    }else
    {
        selectedObject.style.width='35px';
        selectedObject.style.height='35px';
        selectedObject=obj;
    }
    obj.style.width='45px';
    obj.style.height='45px';
    document.getElementById('enterpriseimageid').value = imageid;
    document.getElementById('imgFlag').value=imageFlag;
    parent.document.all.main.height   =   document.body.scrollHeight;

}

function privewEnterpriseImage()
{
    var _imageid = document.getElementById('enterpriseimageid').value;
    if(_imageid!="")
    {
        window.open('privewEnterpriseImage.jsp?eid='+_imageid);

    }else
    {
        ymPrompt.alert({message:'����ѡ��ͼƬ�ٽ���Ԥ����', width:330, height:220, title:'��ʾ��Ϣ'});
    }
}

function deleteImage() {
    var _eid = document.getElementById("enterpriseimageid").value;
    var _imageFlag = document.getElementById("imgFlag").value;
    if (_eid != "") {
        ymPrompt.confirmInfo('��ȷ��ɾ����ͼƬ��Ϣ��?', 350, 185, '��ʾ��Ϣ', function (data) {
            if (data == 'ok') {
                enterpriseImage.deleteEnterpriseImageByImageId(_eid, function(data) {
                    if (data == true) {
                        setEnterpriseImgForFrame(document.getElementById('codeid').value,_imageFlag);
                    }
                });
            }
            else {
                return false;
            }
        });
    }else{
        ymPrompt.alert({message:'��ѡ��Ҫɾ����ͼƬ��', width:330, height:220, title:'��ʾ��Ϣ'});
    }
    document.getElementById("enterpriseimageid").value = "";
}

function showExample(oper){
    if(oper==1){
       ymPrompt.win('<p style="text-indent:24px;">������������Ƽ����޹�˾����ƾ����NineMax����������1996�꣬�Ǳ����������ҵ�������и��¼�����ҵ��רע�ں����ǽṹ����Ϣ��������Ϊ���ĵ�����з������ۺͼ���������������֪ʶ��Ȩ�����������ʮ�����ӵ�й���ϵͳ���ɶ������ʣ����ұ��ܾ��漰�������ܼ������Ϣϵͳ�������ʡ�Ŀǰ������ӵ�г������˵��з��Ŷӣ�ӵ���ۺ���з�ʵ����ǿ�����Ŀʵʩ���ۺ����������Ӯ���˿ͻ���һ��������<p><p style="text-indent:24px;">������������Ƽ����޹�˾�Գ�������һֱ��������з����������£������Ժ������ݲִ���ȫ�ļ������ı��ھ���ҵ�ʱ�����֪ʶ�⣬�����Ż�Ⱥ���ݹ����뻥������Դ�ɼ��ȼ��������γ�����Դ�������ݹ���֪ʶ���񡢻�������Դ�ɼ�Ӧ���Ĵ���ϵ�����Ʒ��</p><p style="text-indent:24px;">������Դ����ƽ̨�ǹ�����Դ���������һƷ�ƣ���Ŀʵʩ����ḻ���е��˶�����Ҽ�����Դ����ƽ̨��Ŀ�Ľ��裬�ṩ�ǽṹ����Դ�ӹ������ϣ����������������Դ�����������й�����������γ�����һ������ͼ��ݡ����ֵ����ݣ���ҵ������Դ���Ϲ���ȸ���ѧУ����ҵ����ҵ�������Ľ������������֪ʶ����ƽ̨�ǹ���֪ʶ����������������Ƚ�ǰ�ص������Ʒ�����ڱ���֪ʶ�⹹�������ܹ�����Ϣ��������Ϊ���Ӹ�Ч֪ʶ�����ṩ�ʴ�Ϳͷ������ˡ���ҵ֪ʶ����ҽ��֪ʶ����͸�����ϵȽ���������������ݹ���ƽ̨�Ǵ�����վȺ�Ż���ѡ��Ʒ���߱��������ݹ����Ʒ������Ż�ʵʩ���飬�ر��ڴ���������ҵ��վȺ���裬������ҵ����������վ�Ż�������г���������������������Դ�ɼ���Ӧ���Թ�����רҵ�������ɼ����Ϊ�������ܹ��ɼ�������Դ�ࡢ�鱨�ࡢ��Ƶ���ѲɵĻ������ǽṹ�����ݣ�Ϊ�ͻ��ṩ�Ľ�������л�����ר��ɼ��뷢���������ء�վ����������ҵ��������ȡ�</p><p style="text-indent:24px;">������������Ƽ����޹�˾������ʮ����ķ�չ�����Ϳͻ��й��ҿƼ��������ģ�ȫ����֯��������������ģ�����ͼ��ݣ����ҵ����֣��Ļ����ȡ������Գɹ�ʵ�ֿͻ�Ӧ�ü�ֵΪ��չĿ�꣬������רҵ֮����Ω��Ωһ�ľ��񣬳�Ϊ�ͻ�ֵ�������ĳ��ں�����飡</p>',580,460,'��ҵ�������');
    }
    if(oper==2){
       ymPrompt.win('<p style="text-indent:24px;">����������Ϣ�ɼ�����ƽ̨����ʮ�겻�Ͽ�����Ľ����Ѿ���Ϊ�о��������鱨�����Լ�������ҵ�û��е���Ϣ�ɼ�Ӧ�õĸ߼���ͷ�����Ʒ���ر��ڻ�����֪ʶӦ�ã��������鱨�ɼ������������صȸ߼�Ӧ���д���ȫ�����ȵ�λ��</p><p style="text-indent:24px;">����������Ϣ�ɼ��뷢��ƽ̨�ṩ�ӻ�������Ϣ�ɼ�����Ϣ�ӹ������ϡ���Ϣ�ھ������ȫ�ļ������ݿ⡢��Ϣ��˷������Ѳ���վ����Բɼ����Լ�����߼�Ӧ�ã�������֪ʶ������Э�����鱨����ƽ̨��������ƽ̨��������һ���׽����������������ҵ��ֱ�������滹�Ǵ�����ҵ�鱨����ƽ̨������ƽ̨������֪ʶ����ƽ̨���г��참����Ӧ�á�</p><p style="text-indent:24px;">��״����</p><p style="text-indent:24px;">ʮ�껥�����ɼ�Ӧ����Ŀ�ɹ�ʵʩ���飬ʹ�������ܹ�׼ȷ��ⲻͬ�ͻ��Ĳ�ͬ�����ܹ�ʹ�û������ɼ�Ӧ����Ŀ��Ϊ�������õ����ϵͳ��ͬʱ����Ҳ�ܽ���˵�ǰ��������Ϣ�ɼ�Ӧ���е��ѵ�����״���⣬���Ǿ���Ľ�������ܹ���Ч�����������⡣</p><p style="text-indent:24px;">��1�����˻�������ϢԴ�ɼ�������΢������Ƶ��վ�ȡ��󲿷�����ɼ����޷��ɼ�΢������Ƶ��վ��</p><p style="text-indent:24px;">��2���ܶ�רҵ����ҵ��վ�ر��Ǿ����� �鱨����վ�߱���ǿ�����λ��ơ������Ͼ�������ɼ����޷��ɼ���Щ��վ��</p><p style="text-indent:24px;">��3����μ��������վģ���ǿͻ���ͷ�����⣬����Ҫ�ɼ�����վ���иİ��������վ��Ҫ�ɼ�ʱ����ʹ�òɼ����޷������ɼ������Ǿ߱�������վģ��Ⲣ����ר�˽���ά����ͨ����Ч�������������������⡣</p><p style="text-indent:24px;">��4�������޷����ʵ���վ�Ĳɼ����⣬����ͨ���ɼ����Դ�����������ϵͳ�ܹ���������⡣</p><p style="text-indent:24px;">��5����վ�ڲ����ĵ����Բɼ�������PPT��PDF��WORD��EXCEL�ȣ������������ĵ�����Ҫ�ļ���</p><p style="text-indent:24px;">��6�����󲿷�����ɼ���Ʒ�ɼ�����Ϣ�޷�����Ϣ������Ч��ϴ����ȡ����ʽ����׼����Ҳ�޷���������ھ������������Ϣ׷�١��Զ����ࡢ�Զ����ࡢ�Զ�ժҪ��������Ϣ���㡢��Ϣ�����������ͳ�Ʒ�����һϵ��֪ʶ�ھ�����������޷���߻������ɼ���������Ϣ������</p><p style="text-indent:24px;">��7����������������޷���Ч������ر��ǲɼ����ɼ�����Ϣ����޷췢��������ϵͳ�С�</p><p style="text-indent:24px;">��8���󲿷ֲɼ�ϵͳ�޷����ٽ���һ�ײɼ�������վƽ̨���ͻ�ʹ�ã�����û��һЩ�߼��ɼ�Ӧ�ã����磺��������Ϣ��������鱨�ɼ��ӹ�������������Ԥ�����񡣾��𲻽��߱����ٽ���������ϵ�Ĳɼ�����ƽ̨�Ż��������ṩ���������ܣ����һ��߱��������ֲ�ͬ���͵ĸ߼��ɼ�Ӧ�÷����ܡ�</p>',600,580,'��Ʒ����');
    }
    if(oper==3){
       ymPrompt.win('<p style="text-indent:24px;">����˾���ڿ���ʵʩ֮ǰ�����û����������뽨�鲢������ƵĿ������飬���û��ṩ���������ƵĽ��������</p><p style="text-indent:24px;">Ϊ�˱�����Ŀ�����ܰ��ռƻ�����������Ľ��п�������������˾����������Ŀ�����飬��������Ա��������Ŀ��ʵ�����������Ӧ����Դ������֤����Ŀ��������ת��</p><p style="text-indent:24px;">����˾��Ŀ�������ڿ����׶�ÿ��һ�ٿ������鹤��������л��飬�����ܿ������������ܽᲢ�ύ���ܿ������Ȱ��ţ��������û����������Լ���ϱ���Ŀʵ��������Կ��������������Ż��ĵ�����ͬʱ����Ŀ��������Ա����ʱ���û�������Ŀ��չ���������û�������мල��ʹ�û����Ը�����ܵض���Ŀ���п��ơ�</p><p style="text-indent:24px;">����˾�����齫���û���ͬ�ƶ�һ�������С����Ժ����ս��ȼƻ�������ÿ�����ʱ�䰲����ʵ��Сʱ����Ա���ڼƻ�ִ�й����У��ϸ�ִ�мƻ������н��ȣ��Ա�֤��ʱ��ɰ�װ�����Թ�����</p><p style="text-indent:24px;">���������ڼ䣬����˾�ܿ�����Ա��ȫְ���û��ֳ�����ά���ͼ���ָ��������������ֵ����⡣����˾��ŵ�����պ�ͬ�涨�������գ�����δ���û�Ҫ��Ĺ��ܸĽ����û�����Ϊֹ���ڱ���Ŀ���ս����󣬾���˾��ŵΪ�û��ṩӦ�ÿ�����ѯ����֤�û������ƽ̨���Գ�����չ��</p><p style="text-indent:24px;">�ֳ�֧�ַ��񣺷�����ʸϸ��û���Ӧ���ֳ���Ϊ�û���������ƽ̨Ӧ�����⣬�����û��ṩԤ����ʩ��Ӧ�ý��顣������ѯ���񣺷������ͨ���������߰����û���ϲ�����ճ�Ӧ�ù��̵ĳ������⣬�����û��ṩӦ�ý��顣���������ߵ绰��58246699��Զ��֧�ַ��񣺷�������ԱԶ�������û������Ӧ��ƽ̨��ݵ�����Ӧ�ù��ϲ������ų���ͬʱΪ�û��ṩӦ��ָ�����������������ͬ����ר�������ֳ���ϵͳ�Ż�����ϵͳ���а���󣬾���˾�ṩϵͳ���к�����ܷ������������Ӧ������ά��ϵͳ�ĸ�����������</p>',600,400,'������ŵ');
    }
}

function scanImage()
{
    var _codeid = document.getElementById('codeid').value;
    var winFeaturesz = "dialogWidth:760px; dialogHeight:600px; status:no;scroll:yes;dialogTop:150px;dialogLeft:350px;";
    window.showModalDialog('ScanEnterpriseImage.nacao.jsp?codeid='+_codeid+'&imgFlag=4','',winFeaturesz);
    setEnterpriseImg(_codeid,'4')

}

