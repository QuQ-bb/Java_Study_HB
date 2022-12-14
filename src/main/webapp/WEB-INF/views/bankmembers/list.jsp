<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bank</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<section class="container-fluid col-sm-3">
		<div class="row">
		<h3>SEARCH ID LIST PAGE</h3>
		<h4>선생님 좀 나와주세요...</h4>
		<table class="table table-sm" border="1">
			<tr>
				<th>USERNAME</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>PHONE</th>
			</tr>
				<c:forEach items="${search}" var="search">
			<tr>
					<td>${search.userName}</td>
					<td>${search.name}</td>
					<td>${search.email}</td>
					<td>${search.phone}</td>
			</tr>
				</c:forEach>
	</table>
	<a href="/searchID.ms">Back Search</a>
		
		</div>
	
	
	</section>


	
	
<c:import url="../template/footer.jsp"></c:import>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>