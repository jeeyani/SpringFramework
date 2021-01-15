<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
	<div>
		<div>
			<span><img class="rounded-circle" width="50px" height="50px" src="photodownload?fileName=${board.mphoto}"/></span> <br/>
			<span>번호:</span> 
			<span>${board.bno}</span> <br/>
			
			<span>제목:</span> 
			<span>${board.btitle}</span> <br/>
			
			<span>글쓴이:</span> 
			<span>${board.mid}</span> <br/>
			
			<span class="title">날짜:</span> 
			<span><fmt:formatDate value="${board.bdate}" pattern="yyyy-MM-dd HH.mm.ss"/></span> <br/>
		</div>
		
		<div>
			<span class="title">내용:</span> <br/>
			<textarea style="width:100%" readonly>${board.bcontent}</textarea>
		</div>
		
		<c:if test="${sessionMid == board.mid}">
			
			<a class="btn btn-warning" href="javascript:boardDelete(${board.bno})">삭제</a>
			<script type="text/javascript">
				function boardDelete(bno) {
					$.ajax({
						url:"boardDelete",
						data:{bno:bno},
						method:"post",
						success:function(data) {
							if(data.result == "success") {
								boardList();
							}
							console.log(data);
						}
					});
				}
			</script>	
			
			<a class="btn btn-warning" href="javascript:boardUpdate(${board.bno})">수정</a>
			<script type="text/javascript">
				function boardUpdate(bno) {
					$.ajax({
						url:"boardUpdate",
						data:{bno:bno},
						method:"get",
						success:function(data) {
							$("#board_result").html(data);
						}
					});
				}
			</script>	
		</c:if>
	</div>
</div>