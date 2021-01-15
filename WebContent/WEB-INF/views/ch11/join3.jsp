<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h6 style="margin-top: 5px; ">[HTML로 작성]</h6>
<form action="join3" method="post">
	언어:
	<c:forEach var="lang" items="${languageList}">
		<c:set var="check" value="false"/>
		<c:forEach var="temp" items="${ch11Member.mlanguage}" >
			<c:if test="${lang == temp}">
				<c:set var="check" value="true"/>
			</c:if>
		</c:forEach>
		<c:if test="${check}">
			<input type="checkbox" name="mlanguage" value="${lang}" checked> ${lang}
		</c:if>
		<c:if test="${!check}">
			<input type="checkbox" name="mlanguage" value="${lang}" > ${lang}
		</c:if>
	</c:forEach>
	<br/>
	스킬:
	<c:forEach var="skill" items="${skillList}">
		<c:set var="check" value="false"/>
		<c:forEach var="temp" items="${ch11Member.mskill}" >
			<c:if test="${skill.value == temp}">
				<c:set var="check" value="true"/>
			</c:if>
		</c:forEach>
		<c:if test="${check}">
			<input type="checkbox" name="mskill" value="${skill.value}" checked> ${skill.label}
		</c:if>
		<c:if test="${!check}">
			<input type="checkbox" name="mskill" value="${skill.value}" > ${skill.label}
		</c:if>
	</c:forEach>
	
	<br/>
	<input class="btn btn-warning" type="submit" value="입력"/> 
</form>

<h6 style="margin-top: 5px; ">[Spring 태그로 작성 ]</h6>
<form:form modelAttribute="ch11Member">
	언어:<form:checkboxes items="${languageList}" path="mlanguage"/> <br/>
	스킬:<form:checkboxes items="${skillList}" path="mskill" itemLabel="label" itemValue="value"/>
	<br/>
	<input class="btn btn-warning" type="submit" value="입력"/> 
</form:form>