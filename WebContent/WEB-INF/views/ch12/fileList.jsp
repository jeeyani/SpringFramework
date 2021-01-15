<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

[
<c:forEach var="fileName" items="${fileNames}" varStatus="status">
	"${fileName}"
	<c:if test="${!status.last}"> ,</c:if>
</c:forEach>
]