//首页图片框变化
function ShowDiv1(divName) {
    document.getElementById('show_line').style.display = "none";
    document.getElementById('show_hotel').style.display = "none";
    document.getElementById('show_linepic').src = "images/zxff-xl.gif";
    document.getElementById('show_hotelpic').src = "images/zxff-jd.gif";
    document.getElementById(divName).style.display = "";
}
function ShowDiv2(divName) {
    document.getElementById('show_line').style.display = "none";
    document.getElementById('show_hotel').style.display = "none";
    document.getElementById('show_linepic').src = "images/zxff-xl1.gif";
    document.getElementById('show_hotelpic').src = "images/zxff-jd1.gif";
    document.getElementById(divName).style.display = "";
}
function ShowDiv(divName)
{

    if (divName == 'hc')
    {
        ShowDivhc();
    }
    if (divName == 'gx')
    {
        ShowDivgx();
    }
    if (divName == 'xj')
    {
        ShowDivxj();
    }
    if (divName == 'jj')
    {
        ShowDivjj();
    }
    if (divName == 'lj')
    {
        ShowDivlj();
    }
    if (divName == 'sm')
    {
        ShowDivsm();
    }
    if (divName == 'sqgj')
    {
        ShowDivsqgj();
    }
    if (divName == 'jqggc')
    {
        ShowDivjqggc();
    }
    if (divName == 'qczl')
    {
        ShowDivqczl();
    }
    if (divName == 'qczl')
    {
        ShowDivqczl();
    }
    if (divName == 'rlslc')
    {
        ShowDivrlslc();
    }

    if (divName == 'sdhg')
    {
        ShowDivsdhg();
    }
    if (divName == 'dgggc')
    {
        ShowDivdgggc();
    }
    if (divName == 'szsem')
    {
        ShowDivszsem();
    }
    if (divName == 'jdtj')
    {
        ShowDivjdtj();
    }
    if (divName == 'sjem')
    {
        ShowDivsjem();
    }
    if (divName == 'xjjd1')
    {
        ShowDivxjjd1();
    }
    if (divName == 'jjjd1')
    {
        ShowDivjjjd1();
    }
    if (divName == 'ljjd1')
    {
        ShowDivljjd1();
    }
    if (divName == 'smjd1')
    {
        ShowDivsmjd1();
    }
    if (divName == 'emxy')
    {
        ShowDivemxy();
    }
    if (divName == 'lyjnp')
    {
        ShowDivlyjnp();
    }
    if (divName == 'zyc')
    {
        ShowDivzyc();
    }
    if (divName == 'ttc')
    {
        ShowDivttc();
    }
    if (divName == 'fjkgjnp')
    {
        ShowDivfjkgjnp();
    }
    if (divName == 'nxy')
    {
        ShowDivnxy();
    }
    if (divName == 'wq')
    {

        ShowDivwq();
    }
    if (divName == 'hx')
    {
        ShowDivhx();
    }
    if (divName == 'ylc')
    {
        ShowDivylc();
    }
}
//景区服务－－服务导航 --好吃排行图片框变化
function ShowDivhc() {
    document.getElementById('hcph').style.display = "none";
    document.getElementById('gxph').style.display = "none";

    document.getElementById('hcphpic').src = "images/tb4.gif";
    document.getElementById('gxphpic').src = "images/tb5.gif";
    document.getElementById('hcph').style.display = "";
}
function ShowDivgx() {
    document.getElementById('hcph').style.display = "none";
    document.getElementById('gxph').style.display = "none";

    document.getElementById('hcphpic').src = "images/tb4-1.gif";
    document.getElementById('gxphpic').src = "images/tb5-1.gif";
    document.getElementById('gxph').style.display = "";
}
//景区服务－－服务导航 --酒店图片框变化
function ShowDivxj() {
    document.getElementById('jj').style.display = "none";
    document.getElementById('lj').style.display = "none";
    document.getElementById('sm').style.display = "none";

    document.getElementById('xjjdpic').src = "images/tb7.gif";
    document.getElementById('jjjdpic').src = "images/jjjd.gif";
    document.getElementById('ljjdpic').src = "images/tb9.gif";
    document.getElementById('smjdpic').src = "images/tb10.gif";
    document.getElementById('xj').style.display = "";
}
function ShowDivjj() {
    document.getElementById('xj').style.display = "none";
    document.getElementById('lj').style.display = "none";
    document.getElementById('sm').style.display = "none";

    document.getElementById('xjjdpic').src = "images/tb7-1.gif";
    document.getElementById('jjjdpic').src = "images/tb8-1.gif";
    document.getElementById('ljjdpic').src = "images/tb9.gif";
    document.getElementById('smjdpic').src = "images/tb10.gif";
    document.getElementById('jj').style.display = "";
}
function ShowDivlj() {
    document.getElementById('xj').style.display = "none";
    document.getElementById('jj').style.display = "none";
    document.getElementById('sm').style.display = "none";

    document.getElementById('xjjdpic').src = "images/tb7-1.gif";
    document.getElementById('jjjdpic').src = "images/jjjd.gif";
    document.getElementById('ljjdpic').src = "images/tb9-1.gif";
    document.getElementById('smjdpic').src = "images/tb10.gif";
    document.getElementById('lj').style.display = "";
}
function ShowDivsm() {
    document.getElementById('xj').style.display = "none";
    document.getElementById('lj').style.display = "none";
    document.getElementById('jj').style.display = "none";

    document.getElementById('xjjdpic').src = "images/tb7-1.gif";
    document.getElementById('jjjdpic').src = "images/jjjd.gif";
    document.getElementById('ljjdpic').src = "images/tb9.gif";
    document.getElementById('smjdpic').src = "images/tb10-1.gif";
    document.getElementById('sm').style.display = "";
}
//景区服务－－服务导航 --行在峨嵋图片框变化
function ShowDivsqgj() {
    document.getElementById('jqggc').style.display = "none";
    document.getElementById('qczl').style.display = "none";
    document.getElementById('rlslc').style.display = "none";
    document.getElementById('sdhg').style.display = "none";
    document.getElementById('dgggc').style.display = "none";

    document.getElementById('sqgjpic').src = "images/tb12.gif";
    document.getElementById('jqggcpic').src = "images/tb13.gif";
    document.getElementById('qczlpic').src = "images/tb14.gif";
    document.getElementById('rlslcpic').src = "images/tb15.gif";
    document.getElementById('sdhgpic').src = "images/tb16.gif";
    document.getElementById('dgggcpic').src = "images/tb17.gif";
    document.getElementById('sqgj').style.display = "";
}

function ShowDivjqggc() {
    document.getElementById('sqgj').style.display = "none";
    document.getElementById('qczl').style.display = "none";
    document.getElementById('rlslc').style.display = "none";
    document.getElementById('sdhg').style.display = "none";
    document.getElementById('dgggc').style.display = "none";
    document.getElementById('sqgjpic').src = "images/tb12-1.gif";
    document.getElementById('jqggcpic').src = "images/tb13-1.gif";
    document.getElementById('qczlpic').src = "images/tb14.gif";
    document.getElementById('rlslcpic').src = "images/tb15.gif";
    document.getElementById('sdhgpic').src = "images/tb16.gif";
    document.getElementById('dgggcpic').src = "images/tb17.gif";
    document.getElementById('jqggc').style.display = "";
}

function ShowDivqczl() {
    document.getElementById('sqgj').style.display = "none";
    document.getElementById('jqggc').style.display = "none";
    document.getElementById('rlslc').style.display = "none";
    document.getElementById('sdhg').style.display = "none";
    document.getElementById('dgggc').style.display = "none";
    document.getElementById('sqgjpic').src = "images/tb12-1.gif";
    document.getElementById('jqggcpic').src = "images/tb13.gif";
    document.getElementById('qczlpic').src = "images/tb14-1.gif";
    document.getElementById('rlslcpic').src = "images/tb15.gif";
    document.getElementById('sdhgpic').src = "images/tb16.gif";
    document.getElementById('dgggcpic').src = "images/tb17.gif";
    document.getElementById('qczl').style.display = "";
}
function ShowDivrlslc() {
    document.getElementById('sqgj').style.display = "none";
    document.getElementById('jqggc').style.display = "none";
    document.getElementById('qczl').style.display = "none";
    document.getElementById('sdhg').style.display = "none";
    document.getElementById('dgggc').style.display = "none";
    document.getElementById('sqgjpic').src = "images/tb12-1.gif";
    document.getElementById('jqggcpic').src = "images/tb13.gif";
    document.getElementById('qczlpic').src = "images/tb14.gif";
    document.getElementById('rlslcpic').src = "images/tb15-1.gif";
    document.getElementById('sdhgpic').src = "images/tb16.gif";
    document.getElementById('dgggcpic').src = "images/tb17.gif";
    document.getElementById('rlslc').style.display = "";
}
function ShowDivsdhg() {
    document.getElementById('sqgj').style.display = "none";
    document.getElementById('jqggc').style.display = "none";
    document.getElementById('rlslc').style.display = "none";
    document.getElementById('qczl').style.display = "none";
    document.getElementById('dgggc').style.display = "none";
    document.getElementById('sqgjpic').src = "images/tb12-1.gif";
    document.getElementById('jqggcpic').src = "images/tb13.gif";
    document.getElementById('qczlpic').src = "images/tb14.gif";
    document.getElementById('rlslcpic').src = "images/tb15.gif";
    document.getElementById('sdhgpic').src = "images/tb16-1.gif";
    document.getElementById('dgggcpic').src = "images/tb17.gif";
    document.getElementById('sdhg').style.display = "";
}
function ShowDivdgggc() {
    document.getElementById('sqgj').style.display = "none";
    document.getElementById('jqggc').style.display = "none";
    document.getElementById('rlslc').style.display = "none";
    document.getElementById('sdhg').style.display = "none";
    document.getElementById('qczl').style.display = "none";
    document.getElementById('sqgjpic').src = "images/tb12-1.gif";
    document.getElementById('jqggcpic').src = "images/tb13.gif";
    document.getElementById('qczlpic').src = "images/tb14.gif";
    document.getElementById('rlslcpic').src = "images/tb15.gif";
    document.getElementById('sdhgpic').src = "images/tb16.gif";
    document.getElementById('dgggcpic').src = "images/tb17-1.gif";
    document.getElementById('dgggc').style.display = "";
}
//游在峨嵋
function ShowDivszsem() {
    document.getElementById('jdtj').style.display = "none";
    document.getElementById('sjem').style.display = "none";

    document.getElementById('szsempic').src = "images/pic2.gif";
    document.getElementById('jdtjpic').src = "images/pic3.gif";
    document.getElementById('sjempic').src = "images/pic4.gif";
    document.getElementById('szsem').style.display = "";
}
function ShowDivjdtj() {
    document.getElementById('szsem').style.display = "none";
    document.getElementById('sjem').style.display = "none";

    document.getElementById('szsempic').src = "images/pic2-1.gif";
    document.getElementById('jdtjpic').src = "images/pic3-1.gif";
    document.getElementById('sjempic').src = "images/pic4.gif";
    document.getElementById('jdtj').style.display = "";
}
function ShowDivsjem() {
    document.getElementById('jdtj').style.display = "none";
    document.getElementById('szsem').style.display = "none";

    document.getElementById('szsempic').src = "images/pic2-1.gif";
    document.getElementById('jdtjpic').src = "images/pic3.gif";
    document.getElementById('sjempic').src = "images/pic4-1.gif";
    document.getElementById('sjem').style.display = "";
}
//住在峨嵋，酒店图片框变化
function ShowDivxjjd1() {
    document.getElementById('jjjd').style.display = "none";
    document.getElementById('ljjd').style.display = "none";
    document.getElementById('smjd').style.display = "none";

    document.getElementById('xjjdpic').src = "images/xjbg.gif";
    document.getElementById('jjjdpic').src = "images/t6.gif";
    document.getElementById('ljjdpic').src = "images/t7.gif";
    document.getElementById('smjdpic').src = "images/t8.gif";
    document.getElementById('xjjd').style.display = "";
}
function ShowDivjjjd1() {
    document.getElementById('xjjd').style.display = "none";
    document.getElementById('ljjd').style.display = "none";
    document.getElementById('smjd').style.display = "none";

    document.getElementById('xjjdpic').src = "images/xjbg-1.gif";
    document.getElementById('jjjdpic').src = "images/t6-1.gif";
    document.getElementById('ljjdpic').src = "images/t7.gif";
    document.getElementById('smjdpic').src = "images/t8.gif";
    document.getElementById('jjjd').style.display = "";
}
function ShowDivljjd1() {
    document.getElementById('jjjd').style.display = "none";
    document.getElementById('xjjd').style.display = "none";
    document.getElementById('smjd').style.display = "none";

    document.getElementById('xjjdpic').src = "images/xjbg-1.gif";
    document.getElementById('jjjdpic').src = "images/t6.gif";
    document.getElementById('ljjdpic').src = "images/t7-1.gif";
    document.getElementById('smjdpic').src = "images/t8.gif";
    document.getElementById('ljjd').style.display = "";
}
function ShowDivsmjd1() {
    document.getElementById('jjjd').style.display = "none";
    document.getElementById('ljjd').style.display = "none";
    document.getElementById('xjjd').style.display = "none";

    document.getElementById('xjjdpic').src = "images/xjbg-1.gif";
    document.getElementById('jjjdpic').src = "images/t6.gif";
    document.getElementById('ljjdpic').src = "images/t7.gif";
    document.getElementById('smjdpic').src = "images/t8-1.gif";
    document.getElementById('smjd').style.display = "";
}
//购在峨嵋图片切换
function ShowDivemxy()
{
    document.getElementById('lyjnp').style.display = "none";
    document.getElementById('zyc').style.display = "none";
    document.getElementById('ttc').style.display = "none";
    document.getElementById('fjkgjnp').style.display = "none";

    document.getElementById('emxypic').src = "images/pic7.gif";
    document.getElementById('lyjnppic').src = "images/pic8.gif";
    document.getElementById('zycpic').src = "images/pic9.gif";
    document.getElementById('ttcpic').src = "images/pic10.gif";
    document.getElementById('fjkgjnppic').src = "images/pic11.gif";
    document.getElementById('emxy').style.display = "";
}
function ShowDivlyjnp() {
    document.getElementById('emxy').style.display = "none";
    document.getElementById('zyc').style.display = "none";
    document.getElementById('ttc').style.display = "none";
    document.getElementById('fjkgjnp').style.display = "none";

    document.getElementById('emxypic').src = "images/pic7-1.gif";
    document.getElementById('lyjnppic').src = "images/pic8-1.gif";
    document.getElementById('zycpic').src = "images/pic9.gif";
    document.getElementById('ttcpic').src = "images/pic10.gif";
    document.getElementById('fjkgjnppic').src = "images/pic11.gif";
    document.getElementById('lyjnp').style.display = "";
}
function ShowDivzyc() {
    document.getElementById('emxy').style.display = "none";
    document.getElementById('lyjnp').style.display = "none";
    document.getElementById('ttc').style.display = "none";
    document.getElementById('fjkgjnp').style.display = "none";

    document.getElementById('emxypic').src = "images/pic7-1.gif";
    document.getElementById('lyjnppic').src = "images/pic8.gif";
    document.getElementById('zycpic').src = "images/pic9-1.gif";
    document.getElementById('ttcpic').src = "images/pic10.gif";
    document.getElementById('fjkgjnppic').src = "images/pic11.gif";
    document.getElementById('zyc').style.display = "";
}
function ShowDivttc() {
    document.getElementById('emxy').style.display = "none";
    document.getElementById('zyc').style.display = "none";
    document.getElementById('lyjnp').style.display = "none";
    document.getElementById('fjkgjnp').style.display = "none";

    document.getElementById('emxypic').src = "images/pic7-1.gif";
    document.getElementById('lyjnppic').src = "images/pic8.gif";
    document.getElementById('zycpic').src = "images/pic9.gif";
    document.getElementById('ttcpic').src = "images/pic10-1.gif";
    document.getElementById('fjkgjnppic').src = "images/pic11.gif";
    document.getElementById('ttc').style.display = "";
}
function ShowDivfjkgjnp() {
    document.getElementById('emxy').style.display = "none";
    document.getElementById('zyc').style.display = "none";
    document.getElementById('ttc').style.display = "none";
    document.getElementById('lyjnp').style.display = "none";

    document.getElementById('emxypic').src = "images/pic7-1.gif";
    document.getElementById('lyjnppic').src = "images/pic8.gif";
    document.getElementById('zycpic').src = "images/pic9.gif";
    document.getElementById('ttcpic').src = "images/pic10.gif";
    document.getElementById('fjkgjnppic').src = "images/pic11-1.gif";
    document.getElementById('fjkgjnp').style.display = "";
}
//娱在峨嵋图片切换
function ShowDivnxy()
{
    document.getElementById('wq').style.display = "none";
    document.getElementById('hx').style.display = "none";
    document.getElementById('ylc').style.display = "none";

    document.getElementById('nxypic').src = "images/lxw.gif";
    document.getElementById('wqpic').src = "images/wq.gif";
    document.getElementById('hxpic').src = "images/hx.gif";
    document.getElementById('ylcpic').src = "images/ylc.gif";
    document.getElementById('nxy').style.display = "";
}
function ShowDivwq()
{

    document.getElementById('nxy').style.display = "none";
    document.getElementById('hx').style.display = "none";
    document.getElementById('ylc').style.display = "none";

    document.getElementById('nxypic').src = "images/lxw-1.gif";
    document.getElementById('wqpic').src = "images/wq-1.gif";
    document.getElementById('hxpic').src = "images/hx.gif";
    document.getElementById('ylcpic').src = "images/ylc.gif";
    document.getElementById('wq').style.display = "";
}
function ShowDivhx()
{
    document.getElementById('wq').style.display = "none";
    document.getElementById('nxy').style.display = "none";
    document.getElementById('ylc').style.display = "none";

    document.getElementById('nxypic').src = "images/lxw-1.gif";
    document.getElementById('wqpic').src = "images/wq.gif";
    document.getElementById('hxpic').src = "images/hx-1.gif";
    document.getElementById('ylcpic').src = "images/ylc.gif";
    document.getElementById('hx').style.display = "";
}
function ShowDivylc()
{
    document.getElementById('wq').style.display = "none";
    document.getElementById('hx').style.display = "none";
    document.getElementById('nxy').style.display = "none";

    document.getElementById('nxypic').src = "images/lxw-1.gif";
    document.getElementById('wqpic').src = "images/wq.gif";
    document.getElementById('hxpic').src = "images/hx.gif";
    document.getElementById('ylcpic').src = "images/ylc-1.gif";
    document.getElementById('ylc').style.display = "";
}
function chkform() {
    if (document.all("username").value == "") {
        alert("请输入“用户登陆名！”");
        return false;
    } else if (document.all("password").value == "") {
        alert("请输入“用户登陆密码”");
        return false;
    } else {
        return true;
    }
}
function tj(key) {
    if (key == "1") {
        document.MemberSForm.service.value = document.MemberSForm.service1.value;
        document.MemberSForm.action.value = document.MemberSForm.action1.value;
    } else if (key == "2") {
        document.MemberSForm.service.value = document.MemberSForm.service2.value;
        document.MemberSForm.action.value = document.MemberSForm.action2.value;
    } else if (key == "3") {
        document.MemberSForm.service.value = document.MemberSForm.service3.value;
        document.MemberSForm.action.value = document.MemberSForm.action3.value;
    }
    document.all("MemberSForm").submit();
}

function GoMeeting() {
    msgLine();
    return false;
}
function SubmitSerch1()
{
    Serch1Form.submit();
}
function Submithotel()
{
    serchhotel.submit();
}
//景区动态图片切换
var nn;
nn = 1;
function setFocus1(i)
{
    selectLayer1(i);
}
function selectLayer1(i)
{
    switch (i)
            {
        case 1:
            document.getElementById("focusPic1").style.display = "block";
            document.getElementById("focusPic2").style.display = "none";
            document.getElementById("focusPic3").style.display = "none";
            document.getElementById("focusPic4").style.display = "none";
        //     document.getElementById("focusPic1nav").style.display = "block";
        //       document.getElementById("focusPic2nav").style.display = "none";
        //       document.getElementById("focusPic3nav").style.display = "none";
        //       document.getElementById("focusPic4nav").style.display = "none";
            break;
        case 2:
            document.getElementById("focusPic1").style.display = "none";
            document.getElementById("focusPic2").style.display = "block";
            document.getElementById("focusPic3").style.display = "none";
            document.getElementById("focusPic4").style.display = "none";
        //     document.getElementById("focusPic1nav").style.display = "none";
        //      document.getElementById("focusPic2nav").style.display = "block";
        //    document.getElementById("focusPic3nav").style.display = "none";
        //   document.getElementById("focusPic4nav").style.display = "none";
            break;
        case 3:
            document.getElementById("focusPic1").style.display = "none";
            document.getElementById("focusPic2").style.display = "none";
            document.getElementById("focusPic3").style.display = "block";
            document.getElementById("focusPic4").style.display = "none";
        //   document.getElementById("focusPic1nav").style.display = "none";
        //   document.getElementById("focusPic2nav").style.display = "none";
        //   document.getElementById("focusPic3nav").style.display = "block";
        // document.getElementById("focusPic4nav").style.display = "none";
            break;
        case 4:
            document.getElementById("focusPic1").style.display = "none";
            document.getElementById("focusPic2").style.display = "none";
            document.getElementById("focusPic3").style.display = "none";
            document.getElementById("focusPic4").style.display = "block";
        // document.getElementById("focusPic1nav").style.display = "none";
        //  document.getElementById("focusPic2nav").style.display = "none";
        //  document.getElementById("focusPic3nav").style.display = "none";
        //   document.getElementById("focusPic4nav").style.display = "block";
            break;
    }
}
function overDiv(key) {

}
function outDiv(key) {
    try {
        var url = document.all(key + "").src + "";
        if (url.indexOf("top3") == -1)
            document.all(key + "").src = "/emeip/images/top1/" + key + ".gif";
    } catch(err) {
        alert(err)
    }

    document.all("hot" + key).style.visibility = 'hidden';

    if (document.all("1").src.indexOf("top3") > -1)
        document.all("hot1").style.visibility = 'visible';

    else if (document.all("2").src.indexOf("top3") > -1)
        document.all("hot2").style.visibility = 'visible';

    else if (document.all("3").src.indexOf("top3") > -1)
        document.all("hot3").style.visibility = 'visible';

    else if (document.all("4").src.indexOf("top3") > -1)
        document.all("hot4").style.visibility = 'visible';

    else if (document.all("5").src.indexOf("top3") > -1)
        document.all("hot5").style.visibility = 'visible';

    else if (document.all("6").src.indexOf("top3") > -1)
        document.all("hot6").style.visibility = 'visible';

    else if (document.all("7").src.indexOf("top3") > -1)
        document.all("hot7").style.visibility = 'visible';

    else if (document.all("8").src.indexOf("top3") > -1)
        document.all("hot8").style.visibility = 'visible';

    else if (document.all("9").src.indexOf("top3") > -1)
        document.all("hot9").style.visibility = 'visible';

    else if (document.all("10").src.indexOf("top3") > -1)
        document.all("hot10").style.visibility = 'visible';
}
function HiddenImg() {
    for (var k = 100; k < 139; k++) {
        try {
            document.all(k + "").style.color = "ffffff";
        } catch(err) {
        }
        try {
            if (document.all("xiaobiao" + k).src.indexOf("xiaobiao2") > -1)
                document.all("xiaobiao" + k).src = "/emeip/images/xiaobiao.gif";
        } catch(err) {
        }
    }       
    event.cancelBubble=true;
    return false;
}

function imgChange(key) {
    for (var k = 100; k < 139; k++) {
        try {
            document.all(k + "").style.color = "ffffff";
        } catch(err) {
        }
        try {
            if (document.all("xiaobiao" + k).src.indexOf("xiaobiao2") > -1)
                document.all("xiaobiao" + k).src = "/emeip/images/xiaobiao.gif";
        } catch(err) {
        }
    }
    document.all(key).style.color = "606060";
    document.all("xiaobiao" + key).src = "/emeip/images/xiaobiao2.gif";
}
function setDivBg() {
    for (var k = 100; k < 139; k++) {
        try {
            document.all(k + "").style.color = "ffffff";
        } catch(err) {
        }
    }
}
function HiddenDiv() {
      if (document.all("1").src.indexOf("top2") > -1 && document.all("1").src.indexOf("top3") == -1)
        document.all("1").src = "/emeip/images/top1/1.gif";
    else if(document.all("1").src.indexOf("top5") > -1)
        document.all("1").src = "/emeip/images/top4/1.gif";

    if (document.all("2").src.indexOf("top2") > -1 && document.all("2").src.indexOf("top3") == -1)
        document.all("2").src = "/emeip/images/top1/2.gif";
    else if(document.all("2").src.indexOf("top5") > -1)
        document.all("2").src = "/emeip/images/top4/2.gif";

    if (document.all("3").src.indexOf("top2") > -1 && document.all("3").src.indexOf("top3") == -1)
        document.all("3").src = "/emeip/images/top1/3.gif";
    else if(document.all("3").src.indexOf("top5") > -1)
        document.all("3").src = "/emeip/images/top4/3.gif";

    if (document.all("4").src.indexOf("top2") > -1 && document.all("4").src.indexOf("top3") == -1)
        document.all("4").src = "/emeip/images/top1/4.gif";
    else if(document.all("4").src.indexOf("top5") > -1)
        document.all("4").src = "/emeip/images/top4/4.gif";

    if (document.all("5").src.indexOf("top2") > -1 && document.all("5").src.indexOf("top3") == -1)
        document.all("5").src = "/emeip/images/top1/5.gif";
    else if(document.all("5").src.indexOf("top5") > -1)
        document.all("5").src = "/emeip/images/top4/5.gif";

    if (document.all("6").src.indexOf("top2") > -1 && document.all("6").src.indexOf("top3") == -1)
        document.all("6").src = "/emeip/images/top1/6.gif";
    else if(document.all("6").src.indexOf("top5") > -1)
        document.all("6").src = "/emeip/images/top4/6.gif";

    if (document.all("7").src.indexOf("top2") > -1 && document.all("7").src.indexOf("top3") == -1)
        document.all("7").src = "/emeip/images/top1/7.gif";
    else if(document.all("7").src.indexOf("top5") > -1)
        document.all("7").src = "/emeip/images/top4/7.gif";

    if (document.all("8").src.indexOf("top2") > -1 && document.all("8").src.indexOf("top3") == -1)
        document.all("8").src = "/emeip/images/top1/8.gif";
    else if(document.all("8").src.indexOf("top5") > -1)
        document.all("8").src = "/emeip/images/top4/8.gif";

    if (document.all("9").src.indexOf("top2") > -1 && document.all("9").src.indexOf("top3") == -1)
        document.all("9").src = "/emeip/images/top1/9.gif";
    else if(document.all("9").src.indexOf("top5") > -1)
        document.all("9").src = "/emeip/images/top4/9.gif";

    if (document.all("10").src.indexOf("top2") > -1 && document.all("10").src.indexOf("top3") == -1)
        document.all("10").src = "/emeip/images/top1/10.gif";
    else if(document.all("10").src.indexOf("top5") > -1)
        document.all("10").src = "/emeip/images/top4/10.gif";
}
function Show(divid, key) {
      if (document.all("1").src.indexOf("top2") > -1 && document.all("1").src.indexOf("top3") == -1)
        document.all("1").src = "/emeip/images/top1/1.gif";
    else if(document.all("1").src.indexOf("top5") > -1)
        document.all("1").src = "/emeip/images/top4/1.gif";

    if (document.all("2").src.indexOf("top2") > -1 && document.all("2").src.indexOf("top3") == -1)
        document.all("2").src = "/emeip/images/top1/2.gif";
    else if(document.all("2").src.indexOf("top5") > -1)
        document.all("2").src = "/emeip/images/top4/2.gif";

    if (document.all("3").src.indexOf("top2") > -1 && document.all("3").src.indexOf("top3") == -1)
        document.all("3").src = "/emeip/images/top1/3.gif";
    else if(document.all("3").src.indexOf("top5") > -1)
        document.all("3").src = "/emeip/images/top4/3.gif";

    if (document.all("4").src.indexOf("top2") > -1 && document.all("4").src.indexOf("top3") == -1)
        document.all("4").src = "/emeip/images/top1/4.gif";
    else if(document.all("4").src.indexOf("top5") > -1)
        document.all("4").src = "/emeip/images/top4/4.gif";

    if (document.all("5").src.indexOf("top2") > -1 && document.all("5").src.indexOf("top3") == -1)
        document.all("5").src = "/emeip/images/top1/5.gif";
    else if(document.all("5").src.indexOf("top5") > -1)
        document.all("5").src = "/emeip/images/top4/5.gif";

    if (document.all("6").src.indexOf("top2") > -1 && document.all("6").src.indexOf("top3") == -1)
        document.all("6").src = "/emeip/images/top1/6.gif";
    else if(document.all("6").src.indexOf("top5") > -1)
        document.all("6").src = "/emeip/images/top4/6.gif";

    if (document.all("7").src.indexOf("top2") > -1 && document.all("7").src.indexOf("top3") == -1)
        document.all("7").src = "/emeip/images/top1/7.gif";
    else if(document.all("7").src.indexOf("top5") > -1)
        document.all("7").src = "/emeip/images/top4/7.gif";

    if (document.all("8").src.indexOf("top2") > -1 && document.all("8").src.indexOf("top3") == -1)
        document.all("8").src = "/emeip/images/top1/8.gif";
    else if(document.all("8").src.indexOf("top5") > -1)
        document.all("8").src = "/emeip/images/top4/8.gif";

    if (document.all("9").src.indexOf("top2") > -1 && document.all("9").src.indexOf("top3") == -1)
        document.all("9").src = "/emeip/images/top1/9.gif";
    else if(document.all("9").src.indexOf("top5") > -1)
        document.all("9").src = "/emeip/images/top4/9.gif";

    if (document.all("10").src.indexOf("top2") > -1 && document.all("10").src.indexOf("top3") == -1)
        document.all("10").src = "/emeip/images/top1/10.gif";
    else if(document.all("10").src.indexOf("top5") > -1)
        document.all("10").src = "/emeip/images/top4/10.gif";

    // divid.filters.revealTrans.apply();
    //divid.style.visibility = "visible";
    hot1.style.visibility = 'hidden';
    hot2.style.visibility = 'hidden';
    hot3.style.visibility = 'hidden';
    hot4.style.visibility = 'hidden';
    hot5.style.visibility = 'hidden';
    hot6.style.visibility = 'hidden';
    hot7.style.visibility = 'hidden';
    hot8.style.visibility = 'hidden';
    hot9.style.visibility = 'hidden';
    hot10.style.visibility = 'hidden';
    divid.style.visibility = 'visible';
    // divid.filters.revealTrans.play();

    try {
        var url = document.all(key).src + "";
        if (url.indexOf("top3") == -1){
           if(url.indexOf("top2") > -1 || url.indexOf("top1") > -1)
              document.all(key).src = "/emeip/images/top2/" + key + ".gif";
           else
              document.all(key).src = "/emeip/images/top5/" + key + ".gif";
        }
    } catch(err) {
        alert(err)
    }
}


function chooLang() {
    if (document.all("selectLang").value == "en") {
        window.open("http://61.139.77.29:88/eng/index.html");
    } else if (document.all("selectLang").value == "kr") {
        window.open("http://61.139.77.29:88/lang/kr/index.asp");
    } else if (document.all("selectLang").value == "ma") {
        window.open("http://61.139.77.29:88/lang/ml/index.asp");
    } else if (document.all("selectLang").value == "jp") {
        window.open("http://61.139.77.29:81/japan/home/index.htm");
    } else if (document.all("selectLang").value == "th") {
        window.open("http://www.emei.co.th");
    } else if (document.all("selectLang").value == "chinese") {

    } else {
        alert("网站维护升级中..请稍后访问！谢谢。");
    }
    document.all("selectLang").options[0].selected = true;
}