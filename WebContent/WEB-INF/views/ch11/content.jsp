<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>View - Spring tag</title>
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
						<h5>form 요청</h5>
						<div>
							<a class="btn btn-warning" href="javascript:fun1()">폼 요청</a>
							<script>
								function fun1() {
									$.ajax({
										url:"join1",
										success: function (data) {
											$("#fun1_result").html(data);
										}
									});
								}
							</script>
							<div id="fun1_result"></div>
						</div>
					</div>
					<div class="sector">
						<h5>form 요청</h5>
						<div>
							<a class="btn btn-warning" href="javascript:fun2()">폼 요청</a>
							<script>
								function fun2() {
									$.ajax({
										url:"join2",
										success: function (data) {
											$("#fun2_result").html(data);
										}
									});
								}
							</script>
							<div id="fun2_result"></div>
						</div>
					</div>
					<div class="sector">
						<h5>form 요청</h5>
						<div>
							<a class="btn btn-warning" href="javascript:fun3()">폼 요청</a>
							<script>
								function fun3() {
									$.ajax({
										url:"join3",
										success: function (data) {
											$("#fun3_result").html(data);
										}
									});
								}
							</script>
							<div id="fun3_result"></div>
						</div>
					</div>
						<div class="sector">
						<h5>form 요청</h5>
						<div>
							<a class="btn btn-warning" href="javascript:fun4()">폼 요청</a>
							<script>
								function fun4() {
									$.ajax({
										url:"join4",
										success: function (data) {
											$("#fun4_result").html(data);
										}
									});
								}
							</script>
							<div id="fun4_result"></div>
						</div>
					</div>
					<div class="sector">
						<h5>form 요청 -국제화</h5>
						<div>
							<a class="btn btn-warning" href="javascript:fun5()">폼 요청</a>
							<script>
								function fun5() {
									$.ajax({
										url:"join5",
										success: function (data) {
											$("#fun5_result").html(data);
										}
									});
								}
							</script>
							<div id="fun5_result"></div>
						</div>
					</div>
				</div>
				
			</div>
		</div> 
	</body>
</html>