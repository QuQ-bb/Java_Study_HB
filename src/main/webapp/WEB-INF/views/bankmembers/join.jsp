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

	<section class="container-fluid">
		<div class="row">
		<h3>JOIN PAGE</h3>

	<form action="join.ms" method="post">
		<table class="table table-hover" border="1">
			<tr>
				<th>USERNAME</th>
				<td><input type="text" class="form-control" name="userName" placeholder="username을 적어주세요"></td>
			</tr>
			<tr>
				 <th>PASSWORD</th>
				<td><input type="password"  class="form-control"name="password" placeholder="password를 입력해주세요"></td>
			</tr>
			<tr>
				  <th>NAME</th>
				<td><input type="text" class="form-control" name="name" placeholder="name을 입력해주세요"></td>
			</tr>
			<tr>
				  <th>EMAIL</th>
				<td><input type="email" class="form-control" name="email" placeholder="email을 입력해주세요."></td>
			</tr>
			<tr>
				  <th>PHONE</th>
				<td><input type="text" class="form-control" name="phone" placeholder="phone번호를 입력해주세요"></td>
			</tr>
		</table>
			<a href="/">Back</a>
			<br><input type="submit" value="JOIN">
	</form>
		</div>
	</section>

	

<c:import url="../template/footer.jsp"></c:import>	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>