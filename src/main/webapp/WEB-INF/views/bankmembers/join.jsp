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

	<section class="container-fluid col-lg-3">
		<div class="row">
		<h3>JOIN PAGE</h3>

	<form action="join.ms" method="post" id="joinfrm" enctype="multipart/form-data">
		<table class="table table-hover" border="1">
			<tr>
				<th>USERNAME</th>
				<td>
					<input type="text" class="form-control" name="userName" id="userName" placeholder="username을 적어주세요">
					<div id="user_check"></div>
					<button type="button" id="idCheckBtn">중복검사</button>
				</td>
			</tr>
			<tr>
				 <th>PASSWORD</th>
				<td>
					<input type="password"  class="form-control"name="password" id="pass" placeholder="password를 입력해주세요">
					<div id="pass_check"></div>
				</td>
			</tr>
			<tr>
				<th>RE PASSWORD</th>
			   <td>
				   <input type="password"  class="form-control"name="password2" id="pass2" placeholder="re password를 입력해주세요">
				   <div id="pass2_check"></div>
			   </td>
		   </tr>
			<tr>
				  <th>NAME</th>
				<td>
					<input type="text" class="form-control" name="name" id="name" placeholder="name을 입력해주세요">
					<div id="name_check"></div>
				</td>
			</tr>
			<tr>
				  <th>EMAIL</th>
				<td>
					<input type="email" required class="form-control" name="email" id="email" placeholder="email을 입력해주세요.">
					<div id="email_check"></div>
				</td>
			</tr>
			<tr>
				  <th>PHONE</th>
				<td>
					<input type="text" class="form-control" name="phone" id="phone" placeholder="phone번호를 입력해주세요">
					<div id="phone_check"></div>
				</td>
			</tr>
			<tr>
				  <th>FILE</th>
				<td><input type="file" class="form-control" name="photo"></td>
			</tr>
		</table>
			<a href="/">Back</a>
			<!-- <br><input type="submit" value="JOIN">  -->
			<button type="button" id="btn">JOIN</button>
	</form>
		</div>
	</section>

	

<c:import url="../template/footer.jsp"></c:import>	

<script src="/resources/js/join.js"></script>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>