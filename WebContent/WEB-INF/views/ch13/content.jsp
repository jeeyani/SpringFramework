<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8">
	<title>fileDownload</title>
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
						<h5>XML 객체 생성 및 주입</h5>
						<div>
							spring/root/ch13_di.xml 참조
						</div>
					</div>
					<div class="sector">
						<h5>@Annotation을 이용한 객체 생성 및 주입</h5>
						<div>
							<ul>
								<li><a href="useAutowired">@Autowired 이용</a></li>
								<li><a href="useResource">@Resource 이용</a></li>
								<li><a href="useInject">@Inject 이용</a></li>
							</ul>
						</div>
					</div>
					<div class="sector">
						<h5>Properties의 값 주입</h5>
						<div>
							<a class="btn btn-sm btn-warning" href="usePropertiesXml">Properties 값 주입- XML방식</a>
							<a class="btn btn-sm btn-warning" href="usePropertiesAnno">Properties 값 주입- Annotation방식</a>
						</div>
					</div>
					<div class="sector">
						<h5>Interface 타입 주입</h5>
						<div>
							<a class="btn btn-sm btn-warning" href="useInterface">Interface 타입 주입</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>