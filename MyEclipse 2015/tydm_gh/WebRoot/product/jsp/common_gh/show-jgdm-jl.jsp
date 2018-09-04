<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ninemax.jpa.global.InitSysParams" %>
<%@ page import="com.ninemax.jpa.system.model.User" %>
<%--@elvariable id="jgdm" type="com.ninemax.jpa.code.model.TJgdm"--%>
<style type="text/css">
    table.tableBorder0 td {
        border: #c4dbe5 1px solid;
    }
</style>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
%>

<TABLE class=tableBorder0 cellSpacing=0 cellPadding=5 align=center border=0 width="100%">
<%-- <tr>
	<td colspan=6 class=td1 align=center>
		个人简历
	</td>
	
</tr>
<tr>
	<td class=td1 align=right>
		任职时间：
	</td>
	<td class=td1>
		${frjl.rzsj1 }
	</td>
	<td class=td1 align=right>
		工作单位：
	</td>
	<td class=td1 >
		${frjl.gzdw1 }
	</td>
	<td class=td1 align=right>
		职务：
	</td>
	<td class=td1 >
		${frjl.zw1 }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		任职时间：
	</td>
	<td class=td1>
		${frjl.rzsj2 }
	</td>
	<td class=td1 align=right>
		工作单位：
	</td>
	<td class=td1 >
		${frjl.gzdw2 }
	</td>
	<td class=td1 align=right>
		职务：
	</td>
	<td class=td1 >
		${frjl.zw2 }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		任职时间：
	</td>
	<td class=td1>
		${frjl.rzsj3 }
	</td>
	<td class=td1 align=right>
		工作单位：
	</td>
	<td class=td1 >
		${frjl.gzdw3 }
	</td>
	<td class=td1 align=right>
		职务：
	</td>
	<td class=td1 >
		${frjl.zw3 }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		任职时间：
	</td>
	<td class=td1>
		${frjl.rzsj4 }
	</td>
	<td class=td1 align=right>
		工作单位：
	</td>
	<td class=td1 >
		${frjl.gzdw4 }
	</td>
	<td class=td1 align=right>
		职务：
	</td>
	<td class=td1 >
		${frjl.zw4 }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		任职时间：
	</td>
	<td class=td1>
		${frjl.rzsj5 }
	</td>
	<td class=td1 align=right>
		工作单位：
	</td>
	<td class=td1 >
		${frjl.gzdw5 }
	</td>
	<td class=td1 align=right>
		职务：
	</td>
	<td class=td1 >
		${frjl.zw5 }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		任职时间：
	</td>
	<td class=td1>
		${frjl.rzsj6 }
	</td>
	<td class=td1 align=right>
		工作单位：
	</td>
	<td class=td1 >
		${frjl.gzdw6 }
	</td>
	<td class=td1 align=right>
		职务：
	</td>
	<td class=td1 >
		${frjl.zw6 }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		任职时间：
	</td>
	<td class=td1>
		${frjl.rzsj7 }
	</td>
	<td class=td1 align=right>
		工作单位：
	</td>
	<td class=td1 >
		${frjl.gzdw7 }
	</td>
	<td class=td1 align=right>
		职务：
	</td>
	<td class=td1 >
		${frjl.zw7 }
	</td>
</tr>
<tr>
	<td class=td1 align=right>
		任职时间：
	</td>
	<td class=td1>
		${frjl.rzsj8 }
	</td>
	<td class=td1 align=right>
		工作单位：
	</td>
	<td class=td1 >
		${frjl.gzdw8 }
	</td>
	<td class=td1 align=right>
		职务：
	</td>
	<td class=td1 >
		${frjl.zw8 }
	</td>
</tr>
<tr>
	<td colspan=1 class=td1 align=right>
		问题：
	</td>
	<td colspan=5 class=td1>
		${frjl.rzsj8 }
	</td>

</tr> --%>

 </TABLE>



