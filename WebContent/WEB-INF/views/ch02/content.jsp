<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ch02.content</title>
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
					<h5>GET 방식 매핑</h5>
						<div>
							<a class="btn btn-warning" href="getMethod">getMethod() 요청</a>
							<a class="btn btn-danger" href="postMethod">postMethod() 요청</a> <!-- ch02/ 까지 생략되어 있는 링크 -->
						</div>
					</div>
					<br/>
					<div class="sector">
						<h5>POST 방식 매핑</h5>
						<div>
							<form method="post" action="getMethod" style="display:inline-block;">
								<input class="btn btn-danger" type="submit" value="getMethod() 요청"/>
							</form>
							<form method="post" action="postMethod" style="display:inline-block;">
								<input class="btn btn-warning" type="submit" value="postMethod() 요청"/>
							</form>
						</div>
					</div>
					<br/>
					<div class="sector">
						<h5>폼요청(GET)과 폼처리(POST)를 동일한 요청으로 매핑</h5>
						<div>
							<a class="btn btn-warning" href="javascript:fun()">폼요청(GET)</a>
							<script type="text/javascript">
								function fun() {
									$.ajax({
										url:"join", /* 메소드 */
										method:"GET", /* GET방식으로 폼을 가져오고 폼처리는 post방식으로 진행 */
										success: function(data) {
											$("#fun_result").append(data);
										}
									});
								}
							</script>
							<br/><br/>
							<div id="fun_result"> <!-- 여기에 추가됨 --> </div>
						</div>
					</div>
				</div>
			</div>
		</div> 
	</body>
</html>