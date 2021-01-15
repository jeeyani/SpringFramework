<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html >
<html>
<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>		
		<link rel="stylesheet" href="<%=application.getContextPath()%>/resources/css/myCss.css">

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm alert" style="background-color: #FDD692; padding-top: 5px; color:#754F44;">
				<jsp:include page="/WEB-INF/views/include/header.jsp"/>
			</div>
		</div>

		<div id="backdiv" class="row">
			<div class="col-sm-4">
				<jsp:include page="/WEB-INF/views/include/menu.jsp"/>
			</div>
			<div id="main" class="col-sm-8">
			<br/>
				<div class="sector">
					<h5>jowarningrm Validate</h5>
					<div>
						<form method="post" action="join">
							<div class="input-group">
								<div class="input-group-prepend"><span class="input-group-text">mid</span></div>
								<input type="text" name="mid" class="form-control" value="${jowarningrm.mid}">
								<form:errors cssClass="error" path="jowarningrm.mid"/>
							</div>
							<div class="input-group">
								<div class="input-group-prepend"><span class="input-group-text">mpassword</span></div>
								<input type="password" name="mpassword" class="form-control" value="${jowarningrm.mpassword}">
								<form:errors cssClass="error" path="jowarningrm.mpassword"/>
							</div>
							<div class="input-group">
								<div class="input-group-prepend"><span class="input-group-text">memail</span></div>
								<input type="text" name="memail" class="form-control" value="${jowarningrm.memail}">
								<form:errors cssClass="error" path="jowarningrm.memail"/>
							</div>
							<div class="input-group">
								<div class="input-group-prepend"><span class="input-group-text">mtel</span></div>
								<input type="text" name="mtel" class="form-control" value="${jowarningrm.mtel}">
								<form:errors cssClass="error" path="jowarningrm.mtel"/>
							</div>
							<input class="btn btn-warning" type="submit" value="가입"/>
						</form>
					</div>
				</div>
				
				<div class="sector">
					<h5>logwarningrm Validate</h5>
					<div>
						<form method="post" action="login">
							<div class="input-group">
								<div class="input-group-prepend"><span class="input-group-text">mid</span></div>
								<input type="text" name="mid" class="form-control" value="${logwarningrm.mid}">
								<form:errors cssClass="error" path="logwarningrm.mid"/>
							</div>
							<div class="input-group">
								<div class="input-group-prepend"><span class="input-group-text">mpassword</span></div>
								<input type="password" name="mpassword" class="form-control" value="${logwarningrm.mpassword}">
								<form:errors cssClass="error" path="logwarningrm.mpassword"/>
							</div>
							<input class="btn btn-warning" type="submit" value="로그인"/>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>