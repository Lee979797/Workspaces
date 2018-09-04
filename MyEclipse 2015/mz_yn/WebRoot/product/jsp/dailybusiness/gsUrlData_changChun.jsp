<%@ page import="com.ninemax.jpa.util.clsStringTool" %>
<%@ page import="com.ninemax.jpa.util.DateUtil" %>
<%@ page import="com.ninemax.jpa.code.model.Qiye" %>
<%@ page import="com.ninemax.jpa.code.model.TJgdm" %>
<%@ page contentType="text/html; charset=gbk" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String zch = clsStringTool.convertNull(request.getParameter("zch"));
    String jgdm = clsStringTool.convertNull(request.getParameter("jgdm"));
    String source = clsStringTool.convertNull(request.getParameter("source"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type='text/javascript' src="/js/tools.js"></script>
     <link type="text/css" href="/css/jquery-ui-1.8.7.custom.css" rel="stylesheet"/>
        <link rel="stylesheet" id='skin' type="text/css" href="/js/alert/skin/dmm-green/ymPrompt.css"/>
    <script type="text/javascript" src="/product/jsp/frame/js/alert/ymPrompt.js"></script>
    <link href="<%=request.getContextPath() %>/product/css/css.css" rel="stylesheet" type="text/css"/>

    <script type="text/javascript">
        var secs = 10; //����ʱ������
        function Load() {
            for (var i = secs; i >= 0; i--) {
                window.setTimeout('doUpdate(' + i + ')', (secs - i) * 1000);
            }
        }
        function doUpdate(num) {
           // document.getElementById('ShowSec').innerHTML = num;
            if (num == 0) {
                if (${card eq "changeCard"}) {
                    window.parent.ymPrompt.doHandler('changeCard', true);
                } else {
                    window.parent.ymPrompt.doHandler('validate', true);
                }
            }
        }

 

		

        /*        if(top.location!=self.location)
         top.location=self.location;*/
        //--------------------------------------------
      
        function fCheckValue() {
        	 if (isEmpty($("#twoCode").val())) {
        		 $("#mes").html("��ɨ���ά��...");
        		 $("#twoCode").focus(); 
                 return false;
             }

        	 $("#mes").html("");
        	 $.ajax({
					url:"<%=request.getContextPath() %>/bsweb/gsUrlAction_daLian",
					dataType:"JSON",
					type:"POST",
					data:'gsUrl='+encodeURIComponent($("#twoCode").val()),
					
					cache:false,
					beforeSend:function(){
					    
					},
					success:function(data)
					{
						data=eval("(" + data + ")");
						$("#jgmc").html(data.jgmc);
						$("#fddbr").html(data.fddbr);
						$("#zczj").html(data.zccj);
						$("#jyfw").html(data.jyfw);
						$("#zch").html(data.zch);
						$("#jgdz").html(data.jgdz);
						$("#zczj").html(data.zczj);
						$("#clrq").html(data.clrq);
						$("#jyqxS").html(data.jyqxS);
						$("#jyqxE").html(data.jyqxE);
						if(data.jgdz!=null){
							//$("#mes").html("���޲�ѯ��Ϣ!");
							window.parent.ymPrompt.resizeWin(750, 500);
							
							$("#t_table").css('display','block');
							
						}else{
						$("#mes").html("���޲�ѯ��Ϣ!");
						$("#twoCode").attr("value","");
						$("#twoCode").focus(); 
							//ymPrompt.alert({message: '���޲�ѯ��Ϣ!', width: 330, height: 220, title: '��ʾ��Ϣ'});
							//window.parent.ymPrompt.doHandler('fsearch',true);
						}
						
					},	
					error:function(){

					},
					complete:function(){
						//window.parent.ymPrompt.resizeWin(750, 500);
						
						//$("#t_table").css('display','block');
					}
				});

				
           
        }

         function setValue(){
             var data1=null;
        	 $.ajax({
					url:"<%=request.getContextPath() %>/GsUrlData",
					dataType:"JSON",
					type:"POST",
					data:'gsUrl='+encodeURIComponent($("#twoCode").val()),
					cache:false,
					beforeSend:function(){
					    
					},
					success:function(data)
					{
						data1=eval("(" + data + ")");
						
						
						
					},	
					error:function(){

					},
					complete:function(){
						//window.parent.ymPrompt.resizeWin(750, 500);
						
						//$("#t_table").css('display','block');

						//var parent=window.dialogArguments;
						//var x=parent.document.getElementByIdx_x("jgmc").value;
						
						//x=x+1��
						//���ø�������age����ֵ
						
						window.parent.document.getElementById("jgmc").value=data1.jgmc;
						window.parent.document.getElementById("jyfw").value=data1.jyfw;
						window.parent.document.getElementById("zczj").value=data1.zczj;
						window.parent.document.getElementById("zch").value=data1.zch;
						window.parent.document.getElementById("jgdz").value=data1.jgdz;
						window.parent.document.getElementById("zcrq").value=data1.clrq;
						window.parent.document.getElementById("fddbr").value=data1.fddbr;

						
						window.parent.ymPrompt.doHandler('fsearch',true);
						//window.parent.document.getElementById("jgmc")="adkjaljfla������������ ";
						//$("#jgmc").parent().attr("value","000000");
					}
				});

				
             
             }
        function fGsVsBs(jgdm, zch) {
            document.thisForm.action = "/bsweb/gsAction_gsVsBsData.action?dzch=" + zch + "&jgdmcode=" + jgdm;
            thisForm.submit();
        }
    </script>
    <title>��ȡ��������</title>
    <style type="text/css">
    .input_500 {
		    background: #fff;
		    width: 500px;
		    border: 1px solid #ccc;
		}
        ul li {
            text-align: left;
        }

        ul li span {
            font-size: 12px;
            font-weight: 100;
        }

        table tr td, table tr th {
            border: 1px solid #dddee6;
        }

        table tr th {
            width: 60px;
            text-align: content;
        }

        table tr td {
            font-weight: 100;
        }

        .fname {
            color: red;
        }
        
    </style>
</head>
<body style="background:#fff;">
<form method="POST" name='thisForm' action="/bsweb/gsAction_gsVsBsData.action">
<input type="hidden" name="source" id="source" value="<%=source%>"/>

<div class="list_box_top" style="text-align: center;">
<%--@elvariable id="qiye" type="com.ninemax.jpa.code.model.Gtgsh"--%>
    <%--@elvariable id="tjgdm" type="com.ninemax.jpa.code.model.TJgdm"--%>
      ��ά���ַ��
    <input name="dzch" type="text" class="input_500" maxlength="" id="twoCode"   value=""/>

    <input name="button2" type="button" class="newBtn1" id="button2" value="ȷ ��" onclick="fCheckValue();"/>
    </br></br><span style="color: red;" id="mes"></span>
    <script type="text/javascript"></script>

    <table cellpadding="0" cellspacing="0" id="t_table" style="display:none;width=80%">
        <caption
                style="text-align: content;border: 1px solid #dddee6;background-color: #dddee6;font-size: 14px;">
            <em>
                ������Ϣ
            </em>
        </caption>
        <tbody>
        <tr class="pname">
            <th width="10%">
                ��Դ
            </th>
            <td width="70%">
                <b>��������</b>
            </td>
            
        </tr>
        <tr class="pname">
            <th>
                ��������
            </th>
            <td  id="jgmc">
                    
            </td>
           
        </tr>
          <tr class="pname">
            <th>
                ע���
            </th>
            <td  id="zch">
                    
            </td>
           
        </tr>
        <tr class="pname">
            <th>
                ����������
            </th>
            <td  id="fddbr">
                    
            </td>
           
        </tr>
        <tr class="pname">
            <th>
                ������ַ
            </th>
            <td id="jgdz">
                    
            </td>
            
        </tr>
        <tr class="pname">
            <th>
                ע���ʽ�
            </th>
            <td id="zczj">
                    
            </td>
           
        </tr>
        <tr class="pname">
            <th>
                ��Ӫ��Χ
            </th>
            <td id="jyfw">
                   
           </td>
        </tr>
        <tr class="pname">
            <th>
                ��������
            </th>
            <td id="clrq">
                    
            </td>
           
        </tr>

        <tr class="pname">
            <th>
                ��Ӫ����
            </th>
            <td id="jyqxS">
                    
            </td>
            
        </tr>
          <tr class="pname">
            <th>
                ��Ӫ����
            </th>
            <td id="jyqxE">
                    
            </td>
            
        </tr>

        <tr>
       
        </tr>
       

   <tr ><th>
   ����
   </th><td>
   
        <input name="button5" type="button" class="newBtn1" id="button5"
               onclick="setValue(); window.close();" value="�� ��"/>
        <input name="button6" type="button" class="newBtn1" id="button6"
               onclick="window.parent.ymPrompt.doHandler('fsearch',true);" value="ȡ ��"/>
   </td>
               </tr>
        </tbody>
    
    </table>

  
    <p>&nbsp;</p>


</div>
</form>
<script >$("#twoCode").focus(); 
$("#twoCode").bind("keypress",function(){
    //����д��input������(text)�����ı�ʱ��ִ�еĴ��룡
	//alert($("#twoCode").val().length);
});

$("#twoCode").change(function(){
		  //alert($("#twoCode").val().length);
		});</script>
</body>


</html>
