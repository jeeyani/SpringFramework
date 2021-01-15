<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:forEach var="fileName" items="${fileNames}">
	<a href="download?fileName=${fileName}"> 
			<img width="80px" height="80px" class="rounded-circle" alt="Cinque Terre" src="download?fileName=${fileName}" style="margin: 2px"/></a>
</c:forEach>

