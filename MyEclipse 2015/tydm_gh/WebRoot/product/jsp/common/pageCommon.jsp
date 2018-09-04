<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/js/page.js"></script>
<input type="hidden" name="page.totalPage" value="${page.totalPage }" id="totalPages"/>
<input type="hidden" name="page.currentPage" value="${page.currentPage }" id="currentPage"/>
<input type="hidden" name="page.orderByField" value="${page.orderByField }" id="orderByField"/>
<input type="hidden" name="page.orderByType" value="${page.orderByType }" id="orderByType"/>

<div class="list_ym">
    <div class="left pageLeft">��${page.totalRecord}����¼ ��${page.totalRecord eq 0?0:page.currentPage}ҳ
        ��${page.totalRecord eq 0?0:page.totalPage}ҳ
    </div>
    <div class="right">
        <c:if test="${ page.hasPre}">
            <input name="button" onclick="Page.goto(1);" type="button" class="list_ym_btn" id="button"
                   value="��ҳ"
                   style="cursor:pointer"/>
            <input name="button2" class="list_ym_btn" type="button" id="button2" value="��һҳ"
                   onClick="Page.goto('${page.currentPage-1}');" style="cursor:pointer"/>
        </c:if>
        <c:if test="${ !page.hasPre}">
            <input name="button" disabled="disabled" type="button" class="list_ym_btn" id="button"
                   value="��ҳ"
                   style="cursor:pointer"/>
            <input name="button2" disabled="disabled" class="list_ym_btn" type="button" id="button2" value="��һҳ"
                   style="cursor:pointer"/>
        </c:if>
        <c:if test="${page.hasNext}">
            <input name="button3" class="list_ym_btn" type="button" id="button3" value="��һҳ"
                   onClick="Page.goto('${page.currentPage+1}');" style="cursor:pointer "/>
            <input name="button4" class="list_ym_btn" type="button" id="button4" value="βҳ"
                   onClick="Page.goto('${page.totalPage}');"
                   style="cursor:pointer"/>
        </c:if>
        <c:if test="${!page.hasNext}">
            <input name="button3" disabled="disabled" class="list_ym_btn" type="button" id="button3" value="��һҳ"
                   style="cursor:pointer "/>
            <input name="button4" disabled="disabled" class="list_ym_btn" type="button" id="button4" value="βҳ"

                   style="cursor:pointer"/>
        </c:if>
        ת��
        <input value="${page.currentPage }" name="pageNo" type="text" class="input_ym"/>
        ҳ
        <input name="button5" type="button" class="list_ym_btngo" value="GO"
               onclick="Page.goto(pageNo.value)"
               style="cursor:pointer"/>


        <select name="page.pageSize" id="pageSize" style="height: 20px;"
                onchange="Page.reload(this.value)">
            <option value="15" ${page.pageSize==15?"selected":""} >15</option>
            <option value="20" ${page.pageSize==20?"selected":""} >20</option>
            <option value="50" ${page.pageSize==50?"selected":""} >50</option>
        </select>��
    </div>
</div>
<script type="text/javascript">
    (function () {
        Page.config('${page.totalPage}');
    })();
</script>