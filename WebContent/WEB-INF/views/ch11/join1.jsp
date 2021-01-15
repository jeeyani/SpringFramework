<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h6 style="margin-top: 5px; ">[HTML로 작성]</h6>
<form action="join1" method="post">
	아이디: <input type="text" id="mid" name="mid" value="${ch11Member.mid}"/>
	이름: <input type="text" id="mname" name="mname" value="${ch11Member.mname}"/>
	비밀번호: <input type="password" id="mpassword" name="mpassword" value="${ch11Member.mpassword}"/>
	국가: <input type="text" id="mnation" name="mnation" value="${ch11Member.mnation}"/>
	<br/>
	<input class="btn btn-info" type="submit" value="입력"/> 
</form>

<h6 style="margin-top: 5px; ">[Spring 태그로 작성 ]</h6>
<form:form modelAttribute="ch11Member">
	아이디: <form:input type="text" path="mid"/> 
	이름: <form:input type="text" path="mname"/> 
	비밀번호: <form:password path="mpassword"/> 
	국가: <form:input type="text" path="mnation"/> 
	<br/>
	<input class="btn btn-warning" type="submit" value="입력"/> 
</form:form>