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

	<section class="container">
		<div class="row">
		<h3>MY PAGE</h3>
	
		<table border="1">
			<tr>
				<th>USERNAME</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>PHONE</th>
			</tr>
			<tr>
				<td>${dto.userName}</td>		
				<td>${dto.name}</td>		
				<td>${dto.email}</td>		
				<td>${dto.phone}</td>		
			</tr>
		</table>
		
		</div>
		
		<div class="row">
	
		<h3>MY ACCOUNT LIST</h3>
		<table border="1">
			<tr>
				<th>ACCOUNTNUM</th>
				<th>BOOKNAME</th>
				<th>ACCOUNTDATE</th>
			</tr>
				<c:forEach items="${dto.bankAccountDTOs}" var="my">
					<tr>
					<td>${my.accountNum}</td>
					<td>${my.bankBookDTO.bookName}</td>
					<td>${my.accountDate}</td>
					</tr>
				</c:forEach> 
			<hr>
		</table>
		
				<c:forEach items="${member.roleDTOs}" var ="role">
					${role.roleNum},${role.roleName}<br>
				</c:forEach>
				
				<h1>당신은 ${member.roleDTOs.get(0).roleName}</h1>
				<h1>당신은 ${member.roleDTOs["0"].roleName}</h1>
		
		</div>
		
		<div class="row">
			<img alt="" src="../resources/upload/member/${dto.bankMembersFileDTO.fileName}">
		</div>
	</section>

	
	
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>