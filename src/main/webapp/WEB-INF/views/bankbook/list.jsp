<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BankBook List</title>
</head>
<body>
	<h1>BankBook List</h1>
	<hr>
	<a href="./add.ms">상품등록</a>
	<table border="1">
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
</body>
</html>