/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-10-31
 * Time: 下午5:54
 * To change this template use File | Settings | File Templates.
 */

function checkformAdd() {
    if (!checkPname()) {
        return false;
    }
    if (!checkWord()) {
        return false;
    }
    if (!checkPclass()) {
        return false;
    }
    if (!checkCodeEn()) {
        return false;
    }
    if(!checkMemo()){
        return false;
    }else {
        var flag = null;
        dwr.engine.setAsync(false);
        for (var i = 0; i < document.getElementsByTagName("input").length; i++) {
            if (document.getElementsByTagName("input")[i].value.length > 0 && document.getElementsByTagName("input")[i].alt == "badword") {
                ForbidUtil.getBadWords(document.getElementsByTagName("input")[i].value, {callback:function(dwrreturn) {
                    flag = dwrreturn;
                }
                });
            }
            if (flag != "" && flag != null) {
                ymPrompt.alert({message:"请去除输入框中的不文明用语或敏感词:", width:330, height:220, title:'提示信息'});
                document.getElementsByTagName("input")[i].focus();
                return false;
            }
        }

        ForbidUtil.getBadWords(document.form1.AppReadme.value, {callback:function(dwrreturn) {
            flag = dwrreturn;
        }
        });
        if (flag != "" && flag != null) {
            ymPrompt.alert({message:"请去除备注中的不文明用语或敏感词:", width:330, height:220, title:'提示信息'});
            return false;
        }
    }
    for(var i=0;i<document.getElementsByTagName("input").length;i++){
        if(!isEmpty(document.getElementsByTagName("input")[i].value)){
            trimIntputValue(document.getElementsByTagName("input")[i]);
        }
    }
    document.form1.submit();
    document.form1.botton1.disabled = true;
}

function checkEmpty(gotopage) {
    var flag = false;//判断用户是否填写了信息
    for (var i = 0; i < document.getElementsByTagName("input").length; i++) {
        if (document.getElementsByTagName("input")[i].alt == "badword") {
            if (!isEmpty(document.getElementsByTagName("input")[i].value)) {
                flag = true;
                break;
            }
        }
    }
    if (!isEmpty(document.getElementById("AppScope").value)) {
        flag = true;
    }
    if (!isEmpty(document.getElementById("AppFeature").value)) {
        flag = true;
    }
    if (!isEmpty(document.getElementById("AppReadme").value)) {
        flag = true;
    }
    if (flag) {
        //确认填写信息是否保存
        ymPrompt.confirmInfo('您现在要填写其他信息，此页信息是否保存?', 300, 185, '提示信息', function (data) {
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

function checkWord() {
    if (isEmpty(document.getElementById('word').value)) {
        ymPrompt.alert({message:'产品名称关键字不能为空！', width:330, height:220, title:'提示信息'});
        return false;
    }
    else {
        return true;
    }
}

function findCpflBycpname() {
    var _cpmc = document.getElementById('word').value;
    if (_cpmc != null && _cpmc != "") {
        ymPrompt.win('selectcpfl.jsp?word=' + encodeURI(encodeURI(_cpmc)), 600, 400, '产品分类选择', null, null, null, {id:'viewupdatelogID'});
    }
}


function checkform() {
    if (!checkPname()) {
        return false;
    }
    if (!checkPclass()) {
        return false;
    }
    if (!checkCodeEn()) {
        return false;
    }
    if(!checkMemo()){
        return false;
    }else {
        var flag = null;
        dwr.engine.setAsync(false);
        for (var i = 0; i < document.getElementsByTagName("input").length; i++) {
            if (document.getElementsByTagName("input")[i].value.length > 0 && document.getElementsByTagName("input")[i].alt == "badword") {
                ForbidUtil.getBadWords(document.getElementsByTagName("input")[i].value, {callback:function(dwrreturn) {
                    flag = dwrreturn;
                }
                });
            }
            if (flag != "" && flag != null) {
                ymPrompt.alert({message:"请去除输入框中的不文明用语或敏感词:", width:330, height:220, title:'提示信息'});
                document.getElementsByTagName("input")[i].focus();
                return false;
            }
        }
        ForbidUtil.getBadWords(document.form1.AppReadme.value, {callback:function(dwrreturn) {
            flag = dwrreturn;
        }
        });
        if (flag != "" && flag != null) {
            ymPrompt.alert({message:"请去除备注中的不文明用语或敏感词:", width:330, height:220, title:'提示信息'});
            return false;
        }
    }
    for(var i=0;i<document.getElementsByTagName("input").length;i++){
        if(!isEmpty(document.getElementsByTagName("input")[i].value)){
            trimIntputValue(document.getElementsByTagName("input")[i]);
        }
    }
    document.form1.submit();
    document.form1.botton1.disabled = true;
}

function checkPname() {
    if (isEmpty(document.getElementById('Product_name').value)) {
        ymPrompt.alert({message:'产品名称不能为空！',width:330,height:220, title:'提示信息'});
        return false;
    }
    else {
        return true;
    }
}


function checkPclass() {
    if (isEmpty(document.getElementById('Product_className').value)) {
        ymPrompt.alert({message:'产品分类不能为空！', width:330, height:220, title:'提示信息'});
        return false;
    }
    else {
        return true;
    }
}

function checkCodeEn() {
    if (!isEmpty(document.getElementById('Product_en').value)) {
        if(!isChinese(document.getElementById('Product_en').value)) {
            ymPrompt.alert({message:'请输入中文！', width:330, height:220, title:'提示信息'});
            return false;
        } else
            return true;
    } else
        return true;
}

function checkMemo(){
    if(document.getElementById('AppReadme').value.length>200)
    {
        ymPrompt.alert({message:'备注太长，字数不得超过200个字！', width:330, height:220, title:'提示信息'});
        return false;
    }else
        return true;
}


function updatepictable(pid,oper) {
    var isIE=!!window.ActiveXObject;  //判断是否为IE浏览器
    var isIE6=isIE&&!window.XMLHttpRequest;
    var isIE8=isIE&&!!document.documentMode;
    var isIE7=isIE&&!isIE6&&!isIE8;
    productImage.findProductImageByPidSl(pid, "1", 0, 9, function(data) {
        var _html = "";
        if (data.length > 0) {
            document.getElementById('pictable').innerHTML = _html;
            for (var i = 0; i < data.length; i++) {
                _html = _html + "<a href=\"javascript:void(0);\" ><img src=\"" + data[i].storage + "\" width=\"35\" height=\"35\"  onclick=\"seteditimage(this," + data[i].imagesid + ");\" /></a>";
            }
        }
        document.getElementById('pictable').innerHTML = _html;
        document.getElementById('imageid').value = '';
        if(isIE){
            parent.document.all.main.height   =   document.body.scrollHeight;
        }
    });

}

var selectedObject="" ;
function seteditimage(obj, imageid) {
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
    document.getElementById('imageid').value = imageid;
    parent.document.all.main.height   =   document.body.scrollHeight;

}


function deleteImage() {
    var _imageid = document.getElementById('imageid').value;

    if (_imageid != "") {
        ymPrompt.confirmInfo('您确认删除该图片信息吗?', 350, 185, '提示信息', function (data) {
            if (data == 'ok') {

                productImage.deleteProductImageByImageId(_imageid, function(data) {
                    if (data == true)
                        updatepictable(document.getElementById('pid').value,'delete');
                });

            }
            else {
                return false;
            }
        });
    }else{
        ymPrompt.alert({message:'请选择要删除的图片！', width:330, height:220, title:'提示信息'});
    }
    document.getElementById('imageid').value = '';
}

//打开多标准窗口
function openmultibiaozhun() {
    var biaozhunId = document.getElementById('Standard_id').value;
    var biaozhunName = document.getElementById('Standard_name').value;
    biaozhunId = encodeURI(encodeURI(biaozhunId));
    biaozhunName = encodeURI(encodeURI(biaozhunName));
    ymPrompt.win('multibiaozhun.jsp?biaozhunId=' + biaozhunId + '&biaozhunName=' + biaozhunName, 600, 400, '多标准窗口', null, null, null, {id:'multibiaozhun'});
}


function privewEnterpriseImage()
{
    var _imageid = document.getElementById('imageid').value;
    if(_imageid!="")
    {
        window.open('privewImage.jsp?imageid='+_imageid);

    }else
    {
        ymPrompt.alert({message:'请先选中图片再进行预览！', width:330, height:220, title:'提示信息'});
    }
}
