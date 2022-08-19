<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BankBook List</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bank</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<section class="container-fluid col-lg-6">
		<div class="row">
			<h1>BankBook List</h1>
				<hr>
				<a href="./add.ms">상품등록</a>
				<table class="table table-sm" border="1">
					<thead>
						<tr>
							<th>Num</th><th>Name</th><th>Rate</th><th>Sale</th><th>수정</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${bankBookList}" var="book">
						<tr>
						<td>${book.bookNum}</td>
						<td><a href="./detail.ms?bookNum=${book.bookNum}">${book.bookName}</a></td>
						<td>${book.bookRate}</td>
						<td>
						<c:if test="${book.bookSale eq 1}">판매중</c:if>
						<c:if test="${book.bookSale ne 1}">판매금지</c:if>
						</td>
						<td>
						<a href="./update.ms?bookNum=${book.bookNum }">수정</a>
					</c:forEach>
					</tbody>
				</table>
		</div>
	
	
	</section>

	
<c:import url="../template/footer.jsp"></c:import>	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>