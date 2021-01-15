<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h6 style="margin-top: 5px; ">[HTML로 작성]</h6>
<form action="join2" method="post">
	회원타입:
	<select id="mtype" name="mtype">
		<c:forEach var="type" items="${typeList}">
			<c:if test="${type == ch11Member.mtype}">
				<option value="${type}" selected> ${type}</option>
			</c:if>
			
			<c:if test="${type != ch11Member.mtype}">
				<option value="${type}"> ${type}</option>
			</c:if>
		</c:forEach>
	</select>
	회원직업:
	<select id="mjob" name="mjob">
		<c:forEach var="job" items="${jobList}">
			<c:if test="${job == ch11Member.mjob}">
				<option value="${job}" selected> ${job}</option>
			</c:if>
			
			<c:if test="${job != ch11Member.mjob}">
				<option value="${job}"> ${job}</option>
			</c:if>
		</c:forEach>
	</select>
	회원도시:
	<select id="mcity" name="mcity">
		<c:forEach var="city" items="${cityList}">
			<c:if test="${city.value == ch11Member.mcity}">
				<option value="${city.value}" selected> ${city.label}</option>
			</c:if>
			
			<c:if test="${city.value != ch11Member.mcity}">
				<option value="${city.value}"> ${city.label}</option>
			</c:if>
		</c:forEach>
	</select>
	<br/>
	<input class="btn btn-warning" type="submit" value="입력"/> 
</form>

<h6 style="margin-top: 5px; ">[Spring 태그로 작성 ]</h6>
<form:form modelAttribute="ch11Member">
	회원타입:
	<form:select path="mtype" items="${typeList}"></form:select>
	회원직업:
	<form:select path="mjob" items="${jobList}"></form:select>
	회원도시:
	<form:select path="mcity" items="${cityList}" itemLabel="label" itemValue="value"></form:select>
	<br/>
	<input class="btn btn-warning" type="submit" value="입력"/> 
</form:form>