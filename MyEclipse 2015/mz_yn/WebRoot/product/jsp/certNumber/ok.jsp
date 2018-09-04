<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<c:if test="${source eq 'true'}">
    ok
</c:if>
<c:if test="${source eq 'false'}">
     {message:error,}
</c:if>