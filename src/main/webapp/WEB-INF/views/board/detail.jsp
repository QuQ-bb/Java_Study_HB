<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
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
			<h3>${board} DATAIL PAGE</h3>
				<table border="1">
					<tr>
						<th>NUM</th>
						<td>${detail.num}</td>
					</tr>
					<tr>
						<th>HIT</th>
						<td>${detail.hit}</td>
					</tr>
					<tr>
					<tr>
						<th>WRITER</th>
						<td>${detail.writer}</td>
					</tr>
					<tr>
						<th>REGDATE</th>
						<td>${detail.regdate}</td>
					</tr>
						<th>TITLE</th>
						<td>${detail.title}</td>
					</tr>
					<tr>
						<th>CONTENTS</th>
						<td>${detail.contents}</td>
					</tr>
				</table>
				<div class="row">
					<a href="./reply.ms?num=${detail.num}">REPLY</a>
				</div>
				
				<a href="./list.ms">Back List</a>
				<a href="update.ms?num=${detail.num}">UPDATE</a>
				<a href="./delete.ms?num=${detail.num}">Delete</a>
		</div>
	</section>
	
	
	
<c:import url="../template/footer.jsp"></c:import>	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>		
</body>
</html>