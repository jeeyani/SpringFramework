<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8">
	<title>예외처리</title>
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
						<h5>예외처리</h5>
						<div>
							<a class="btn btn-warning" href="wrongurl">클라이언트 요청 오류(404)</a>
							<a class="btn btn-warning" href="runtimeException">서버 실행 오류(500)</a>
							<a class="btn btn-warning" href="customException">커스텀 예외</a>	
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>