<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>SEARCH ID LIST PAGE</h3>
	<h4>선생님 좀 나와주세요...</h4>
	<table border="1">
		<tr>
			<th>USERNAME</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>PHONE</th>
		</tr>
		<tr>
			<c:forEach items="${search}" var="search">
				<td>${search.userName}</td>
				<td>${search.name}</td>
				<td>${search.email}</td>
				<td>${search.phone}</td>
			</c:forEach>
		
		</tr>
	
	</table>

</body>
</html>