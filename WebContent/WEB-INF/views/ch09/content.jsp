<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8">
	<title>Data Delivery</title>
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
				<h5>게시물 등록</h5>
					<div>
						<form method="post" action="boardUpload" enctype="multipart/form-data">
							<div class="input-group">
								<div class="input-group-prepend"><span class="input-group-text">제목</span></div>
								<input type="text"  name="title" class="form-control">
							</div>	
							<div class="input-group">
								<div class="input-group-prepend"><span class="input-group-text">내용</span></div>
								<input type="text" name="content" class="form-control">
							</div>	
							<div class="input-group">
								<div class="input-group-prepend"><span class="input-group-text">파일</span></div>
								<input type="file"  name="attach" class="form-control">
							</div>
							<input class="btn btn-warning" type="submit" value="글쓰기"/>
						</form>
					</div>
				</div>	
				
				<div class="sector">
				<h5>게시물 등록(AJAX)</h5>
					<div>
						<div>
							<a class="btn btn-warning" href="javascript:boardUploadAjax()">글쓰기</a>
							<div class="input-group">
								<div class="input-group-prepend"><span class="input-group-text">제목</span></div>
								<input type="text" id="title" name="title" class="form-control">
							</div>	
							<div class="input-group">
								<div class="input-group-prepend"><span class="input-group-text">내용</span></div>
								<input type="text" id="content" name="content" class="form-control">
							</div>	
							<div class="input-group">
								<div class="input-group-prepend"><span class="input-group-text">파일</span></div>
								<input type="file" id="attach" name="attach" class="form-control">
							</div>
							
							
							<script>
							
								function boardUploadAjax() {
									
									var title = $("#title").val();
									var content = $("#content").val();
									var file = $("#attach")[0];
									
									var multipart = new FormData();
									
									multipart.append("title", title);
									multipart.append("content", content);
									
									if(file.files.length !=0){
										
										multipart.append("attach", file.files[0]);
									}
									
									$.ajax({
										url:"boardUploadAjax",
										data: multipart,
										method:"post",
										cache: false,
										processData: false,
										contentType: false,
										success: function (data) {
											$("#fileListDiv").html(data);
										}
									});	
								}
							
							</script>
							
						</div>
					</div>
				</div>	
				
				
				<div class="sector">
					<h5>파일 목록</h5>
					<div id="fileListDiv" style="margin-top: 30px"></div>
					<script>
						$(function () {
							getFileList();
						});
						
						function getFileList() {
							$.ajax({
								url:"getFileList" ,
								success: function (data) {
									$("#fileListDiv").html(data);
								}
								
							});
						}
					</script>
				</div>		
				</div>
			</div>
		</div>
	</body>
</html>