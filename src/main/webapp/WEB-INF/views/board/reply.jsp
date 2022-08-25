<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<section class="container col-lg-3">
		<div class="row">
			<h3>${board} REPLY PAGE</h3>
			<form action="./reply.ms" method="post">
				<input type="hidden" name="writer" value="${member.userName}">
				<input type="hidden" name="num" value="${reply.num}">
				<table border="1">
				<tr>
				<div>
					<th>TITLE</th>
					<td>	
						<input type="text" name="title" placeholder="제목을 입력해주세요.">
					</td>
				</div>
				</tr>
				<div>	
					<th>CONTENTS</th>
					<td>
						<textarea rows="10" cols="25" name=contents></textarea>
					</td>		
				</div>
				</table>
				<input type="submit" value="REPLY ADD">
				<a href="/">Back</a>
			</form>
		
		</div>
	</section>
	
	
<c:import url="../template/footer.jsp"></c:import>	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>		
</body>
</html>