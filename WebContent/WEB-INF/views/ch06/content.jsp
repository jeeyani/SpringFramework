<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html >
<html>
	<head>
		<meta charset="UTF-8">
		<title>forward/redirected</title>
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
						<h5>Forward</h5>
						<div>
							<a class="btn btn-warning" href="javascript:forward()">Forward</a>
							<div>
								param1: ${param1}<br/>
								param2: ${param2}<br/>
								<%-- param3: ${param3}<br/>
								param4: ${param4}<br/> --%>
							</div>
							<script type="text/javascript">
								function forward() {
									$.ajax({
										url:"forward",
										success:function(data) {
											$("#forward_result").html(data);
										}
									});
								}
							</script>
						</div>
						<div id="forward_result" style="margin-top:10px"></div>
					</div>
						
					<div class="sector">
						<h5>Redirect</h5>
						<div>
							<a class="btn btn-warning" href="redirect">Redirect</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>