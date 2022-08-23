<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bank</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<section class="container-fluid col-lg-3 mb-3">
		<div class="row text-center mb-3">
			<h1> 상품 수정</h1>
			<hr>
			<form action="./update.ms" method="post">
			<table border="1">
					<tr>
						<th>Num</th><th>Name</th><th>Rate</th>
					</tr>
					<tr>
						<th>${requestScope.bankBook.bookNum}</th>
						<th><input type="text" name="bookName" value="${requestScope.bankBook.bookName}"></th>
						<th><input type="text" name="bookRate" value="${requestScope.bankBook.bookRate}"></th>
					</tr>
					</table>
					<input type="hidden" name="bookNum" value="${requestScope.bankBook.bookNum}">
					<input type="hidden" name="bookSale" value="${requestScope.bankBook.bookSale}">
					<input type="submit">
			</form>
			</div>
	</section>
	
		
<c:import url="../template/footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>