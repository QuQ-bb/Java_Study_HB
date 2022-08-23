<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<title>Bank</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-3">
			<h3>LIST PAGE</h3>
			<table border="1">
				<tr>
					<th>NUM</th>
					<th>TITLE</th>
					<th>WRITER</th>
					<th>REGDATE</th>
					<th>HIT</th>
				</tr>
				<c:forEach items="${list}" var="list">
					<tr>
						<td>${list.num}</td>
						<td>
						<a href="detail.ms?num=${list.num}">
						${list.title}
						</a>
						</td>
						<td>${list.writer}</td>
						<td>${list.regdate}</td>
						<td>${list.hit}</td>
					</tr>
				</c:forEach>
			</table>
		<a href="/">Back</a>
		<a href="./add.ms">ADD</a>
	</section>

	
<c:import url="../template/footer.jsp"></c:import>		
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>		
</body>
</html>