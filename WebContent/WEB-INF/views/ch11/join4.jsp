<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h6 style="margin-top: 5px; ">[HTML로 작성]</h6>
<form action="join4" method="post">
	회원타입:
		<c:forEach var="type" items="${typeList}">
			<c:if test="${type == ch11Member.mtype}">
				<input type="radio" name="mtype" value="${type}" checked/> ${type}
			</c:if>
			
			<c:if test="${type != ch11Member.mtype}">
				<input type="radio" name="mtype" value="${type}"/> ${type}
			</c:if>
		</c:forEach>
	<br/>
	회원도시:
		<c:forEach var="city" items="${cityList}">
			<c:if test="${city.value == ch11Member.mcity}">
				<input type="radio" name="mcity" value="${city.value}" checked/> ${city.label}
			</c:if>
			
			<c:if test="${city.value != ch11Member.mcity}">
				<input type="radio" name="mcity"  value="${city.value}"/> ${city.label}
			</c:if>
		</c:forEach>
	<br/>
	<input class="btn btn-warning" type="submit" value="입력"/> 
</form>

<h6 style="margin-top: 5px; ">[Spring 태그로 작성 ]</h6>
<form:form modelAttribute="ch11Member">
	회원타입:
	<form:radiobuttons path="mtype" items="${typeList}"/>
	<br/>
	회원도시:
	<form:radiobuttons path="mcity" items="${cityList}" itemLabel="label" itemValue="value"/>
	<br/>
	<input class="btn btn-warning" type="submit" value="입력"/> 
</form:form>