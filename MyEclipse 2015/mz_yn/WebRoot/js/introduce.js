/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-4-7
 * Time: 下午2:31
 * To change this template use File | Settings | File Templates.
 */
var RecommendFlag=true;//全局变量,用于判断是否允许清除文本框内容
//用于清除输入框中提示信息的方法
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
            oTxt.value="企业规模，售后服务体系，员工团队，管理体系，品牌战略，企业的发展历程。";
        }
        else
        {
             RecommendFlag=false;
        }
}
var CultureFlag=true;//全局变量,用于判断是否允许清除文本框内容
//用于清除输入框中提示信息的方法
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
            oTxt.value="对本企业生产的产品质量向社会做出公开承诺，此处填写承诺内容。";
        }else
        {
            CultureFlag=false;
        }
}
//        var ServiceinfoFlag=true;//全局变量,用于判断是否允许清除文本框内容
//        //用于清除输入框中提示信息的方法
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
//                    oTxt.value="企业的文化、理念、所获得的荣誉等，可以上传图片以资说明。";
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
            oTxt.value="企业主要产品类别、系列，产品特点，产品发展历程，名优产品介绍等。";
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
        ymPrompt.alert({message:"请去除企业简介自述中的不文明用语或敏感词:", width:330, height:220, title:'提示信息'});
        return false;
    }
    ForbidUtil.getBadWords(document.form1.productDesc.value, {callback:function(dwrreturn) {
        flag = dwrreturn;
    }
    });
    if (flag != "" && flag != null) {
        ymPrompt.alert({message:"请去除产品自述中的不文明用语或敏感词:", width:330, height:220, title:'提示信息'});
        return false;
    }
    ForbidUtil.getBadWords(document.form1.Culture.value, {callback:function(dwrreturn) {
        flag = dwrreturn;
    }
    });
    if (flag != "" && flag != null) {
        ymPrompt.alert({message:"请去除诚信承诺中的不文明用语或敏感词:", width:330, height:220, title:'提示信息'});
        return false;
    }
    ForbidUtil.getBadWords(document.form1.Oneself.value, {callback:function(dwrreturn) {
        flag = dwrreturn;
    }
    });
    if (flag != "" && flag != null) {
        ymPrompt.alert({message:"请去除备注中的不文明用语或敏感词:", width:330, height:220, title:'提示信息'});
        return false;
    }
    if(document.form1.Recommend.value.length>2000){
        ymPrompt.alert({message:"企业简介自述长度不能多于2000个汉字!", width:330, height:220, title:'提示信息'});
        return false;
    }
    if(document.form1.productDesc.value.length>2000){
        ymPrompt.alert({message:"产品自述长度不能多于2000个汉字!", width:330, height:220, title:'提示信息'});
        return false;
    }
    if(document.form1.Culture.value.length>2000){
        ymPrompt.alert({message:"诚信承诺长度不能多于2000个汉字!", width:330, height:220, title:'提示信息'});
        return false;
    }
    if(document.form1.Oneself.value.length>1000){
        ymPrompt.alert({message:"企业备注长度不能多于1000个汉字!", width:330, height:220, title:'提示信息'});
        return false;
    }
    document.form1.submit();
    document.form1.btn.disabled = true;
}

function checkEmpty(gotopage) {
    var flag = false;//判断用户是否填写了信息
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

function uploadEnterpriseImg() {
    var _codeid = document.getElementById("codeid").value;
    ymPrompt.win('uploadEnterpriseImg.jsp?codeid=' + _codeid, 750, 450, '上传企业图片', null, null, null, {id:'certalert'});
}

function setEnterpriseImg(codeid,imageFlag) {
    var isIE=!!window.ActiveXObject;  //判断是否为IE浏览器
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
 * 针对使用iframe高度不能自适应
 * @param codeid
 * @param imageFlag
 */
function setEnterpriseImgForFrame (codeid,imageFlag) {
    var isIE=!!window.ActiveXObject;  //判断是否为IE浏览器
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
        ymPrompt.alert({message:'请先选中图片再进行预览！', width:330, height:220, title:'提示信息'});
    }
}

function deleteImage() {
    var _eid = document.getElementById("enterpriseimageid").value;
    var _imageFlag = document.getElementById("imgFlag").value;
    if (_eid != "") {
        ymPrompt.confirmInfo('您确认删除该图片信息吗?', 350, 185, '提示信息', function (data) {
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
        ymPrompt.alert({message:'请选择要删除的图片！', width:330, height:220, title:'提示信息'});
    }
    document.getElementById("enterpriseimageid").value = "";
}

function showExample(oper){
    if(oper==1){
       ymPrompt.win('<p style="text-indent:24px;">北京九瑞网络科技有限公司（简称九瑞或NineMax），成立于1996年，是北京市软件企业，北京市高新技术企业，专注于海量非结构化信息处理领域为核心的软件研发、销售和技术服务，享有自主知识产权的软件著作二十几项，并拥有国家系统集成二级资质，国家保密局涉及国家秘密计算机信息系统集成资质。目前，九瑞拥有超过百人的研发团队，拥有雄厚的研发实力和强大的项目实施及售后服务能力，赢得了客户的一致赞誉。<p><p style="text-indent:24px;">北京九瑞网络科技有限公司自成立以来一直坚持自主研发，自主创新，其中以海量数据仓储、全文检索、文本挖掘、行业词表、本体知识库，大型门户群内容管理与互联网资源采集等技术核心形成了资源共享、内容管理、知识服务、互联网资源采集应用四大体系软件产品。</p><p style="text-indent:24px;">九瑞资源共享平台是国内资源共享领域第一品牌，项目实施经验丰富，承担了多项国家级的资源共享平台项目的建设，提供非结构化资源加工，整合，共享，服务等整个资源共享周期所有功能与软件，形成了新一代数字图书馆、数字档案馆，行业数字资源整合共享等覆盖学校、企业、行业、政府的解决方案。九瑞知识服务平台是国内知识管理与服务领域最先进前沿的软件产品，基于本体知识库构建技术能够将信息服务提升为更加高效知识服务，提供问答和客服机器人、企业知识服务、医疗知识服务和辅助诊断等解决方案。九瑞内容管理平台是大型网站群门户首选产品，具备成熟内容管理产品与大型门户实施经验，特别在大型政府企业网站群建设，大型行业电子商务网站门户建设具有成熟解决方案。九瑞互联网资源采集与应用以国内最专业互联网采集软件为基础，能够采集各类资源类、情报类、视频类难采的互联网非结构化数据，为客户提供的解决方案有互联网专题采集与发布、舆情监控、站内搜索与行业搜索引擎等。</p><p style="text-indent:24px;">北京九瑞网络科技有限公司，历经十五年的发展，典型客户有国家科技文献中心，全国组织机构代码管理中心，国家图书馆，国家档案局，文化部等。九瑞以成功实现客户应用价值为发展目标，将会以专业之道，惟精惟一的精神，成为客户值得信赖的长期合作伙伴！</p>',580,460,'企业简介自诉');
    }
    if(oper==2){
       ymPrompt.win('<p style="text-indent:24px;">九瑞互联网信息采集发布平台经过十年不断开发与改进，已经成为研究机构，情报机构以及各个行业用户中的信息采集应用的高级龙头软件产品。特别在互联网知识应用，互联网情报采集分析，舆情监控等高级应用中处于全国领先地位。</p><p style="text-indent:24px;">九瑞互联网信息采集与发布平台提供从互联网信息采集、信息加工与整合、信息挖掘分析、全文检索数据库、信息审核发布、难采网站针对性采集、以及各类高级应用：互联网知识服务与协助、情报分析平台、舆情监控平台定题服务等一整套解决方案。无论是行业垂直搜索引擎还是大型企业情报分析平台舆情监控平台互联网知识服务平台均有成熟案例与应用。</p><p style="text-indent:24px;">现状分析</p><p style="text-indent:24px;">十年互联网采集应用项目成功实施经验，使得我们能够准确理解不同客户的不同需求。能够使得互联网采集应用项目成为真正有用的软件系统。同时我们也总结出了当前互联网信息采集应用中的难点与现状问题，我们九瑞的解决方案能够有效解决下面的问题。</p><p style="text-indent:24px;">（1）新兴互联网信息源采集，例如微博，视频网站等。大部分市面采集器无法采集微薄，视频网站。</p><p style="text-indent:24px;">（2）很多专业的行业网站特别是军事类 情报类网站具备很强的屏蔽机制。市面上绝大多数采集器无法采集这些网站。</p><p style="text-indent:24px;">（3）如何简便制作网站模板是客户最头疼问题，当需要采集的网站进行改版或者有新站需要采集时往往使得采集器无法正常采集，我们具备上万网站模板库并且有专人进行维护，通过有效服务可以完美解决该问题。</p><p style="text-indent:24px;">（4）国外无法访问的网站的采集问题，我们通过采集器自带的搜索代理系统能够解决该问题。</p><p style="text-indent:24px;">（5）网站内部的文档难以采集，例如PPT、PDF、WORD、EXCEL等，但往往该类文档是重要文件。</p><p style="text-indent:24px;">（6）绝大部分市面采集产品采集后信息无法对信息进行有效清洗，抽取，格式化标准化，也无法对其进行挖掘分析，例如信息追踪、自动分类、自动聚类、自动摘要、相似信息计算、信息正负面分析、统计分析等一系列知识挖掘分析工作。无法提高互联网采集下来的信息质量。</p><p style="text-indent:24px;">（7）发布与入库问题无法有效解决，特别是采集器采集的信息如何无缝发布到已有系统中。</p><p style="text-indent:24px;">（8）大部分采集系统无法快速建立一套采集发布网站平台供客户使用，并且没有一些高级采集应用，例如：互联网信息定题服务、情报采集加工分析服务、舆情预警服务。九瑞不仅具备快速建立分类体系的采集发布平台门户，并能提供检索服务功能，而且还具备以上三种不同类型的高级采集应用服务功能。</p>',600,580,'产品自述');
    }
    if(oper==3){
       ymPrompt.win('<p style="text-indent:24px;">九瑞公司将在开发实施之前根据用户方的需求与建议并结合相似的开发经验，向用户提供尽可能完善的解决方案。</p><p style="text-indent:24px;">为了保障项目各功能按照计划正常、有序的进行开发工作，九瑞公司将成立了项目总体组，总体组人员将根据项目的实际情况分配相应的资源，来保证本项目的正常运转。</p><p style="text-indent:24px;">九瑞公司项目总体组在开发阶段每周一召开开发组工作情况例行会议，对上周开发工作进行总结并提交本周开发进度安排，并根据用户代表的意见以及结合本项目实际情况，对开发工作进行最优化的调整。同时，项目总体组人员会随时向用户报告项目进展，并提请用户代表进行监督，使用户可以更大可能地对项目进行控制。</p><p style="text-indent:24px;">九瑞公司总体组将与用户共同制定一套试运行、调试和验收进度计划，并将每项工作的时间安排落实到小时和人员。在计划执行过程中，严格执行计划中所列进度，以保证按时完成安装、调试工作。</p><p style="text-indent:24px;">在试运行期间，九瑞公司总开发人员将全职在用户现场负责维护和技术指导，并解决所发现的问题。九瑞公司承诺将按照合同规定进行验收，对于未达用户要求的功能改进至用户满意为止。在本项目验收结束后，九瑞公司承诺为用户提供应用开发咨询，保证用户的软件平台可以持续发展。</p><p style="text-indent:24px;">现场支持服务：服务顾问赶赴用户的应用现场，为用户解决本软件平台应用问题，并向用户提供预防措施和应用建议。热线咨询服务：服务顾问通过服务热线帮助用户诊断并解决日常应用过程的常见问题，并向用户提供应用建议。（服务热线电话：58246699）远程支持服务：服务技术人员远程连接用户的软件应用平台快捷地锁定应用故障并进行排除。同时为用户提供应用指导。整个服务过程如同服务专家亲临现场。系统优化服务：系统运行半年后，九瑞公司提供系统运行后的性能分析，并提出相应建议以维护系统的高性能运作。</p>',600,400,'诚信曾诺');
    }
}

function scanImage()
{
    var _codeid = document.getElementById('codeid').value;
    var winFeaturesz = "dialogWidth:760px; dialogHeight:600px; status:no;scroll:yes;dialogTop:150px;dialogLeft:350px;";
    window.showModalDialog('ScanEnterpriseImage.nacao.jsp?codeid='+_codeid+'&imgFlag=4','',winFeaturesz);
    setEnterpriseImg(_codeid,'4')

}

