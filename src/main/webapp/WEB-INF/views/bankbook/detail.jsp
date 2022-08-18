<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BankBook Detail</title>
</head>
<body>
	<h1>BankBook Detail</h1>
	<hr>
	<a href="#">상품수정</a>
	<a href="#">상품가입</a>
	<table border="1">
		<thead>
			<tr>
				<th>Num</th><th>Name</th><th>Rate</th><th>Sale</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>${requestScope.bankBook.bookNum}</th>
				<th>${requestScope.bankBook.bookName}</th>
				<th>${requestScope.bankBook.bookRate}</th>
				<th>
				<c:if test="${bankBook.bookSale eq 1}">판매 중</c:if>
				<c:if test="${bankBook.bookSale ne 1}">판매 금지</c:if>
				</th>
			</tr>
		</tbody>
	</table>

</body>
</html>