<%@ page contentType="text/html; charset=UTF-8"%>

<form method="post" action="join"> <!-- GET방식으로 폼을 가져오고 폼처리는 post방식으로 진행  -->
	<div class="input-group">
	  <div class="input-group-prepend">
	    <span class="input-group-text">Email</span>
	  </div>
	  <input type="email" class="form-control" placeholder="Enter email">
	</div>
	<input class="btn btn-warning" type="submit" value="폼처리(POST)"/>
</form>