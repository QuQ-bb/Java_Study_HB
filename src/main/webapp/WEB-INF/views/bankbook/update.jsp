<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
</head>
<body>
<h1> 상품 수정</h1>
<hr>
<form action="./update.ms" method="post">
<table border="1">
		<thead>
			<tr>
				<th>Num</th><th>Name</th><th>Rate</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>${requestScope.bankBook.bookNum}</th>
				<th><input type="text" value="${requestScope.bankBook.bookName}" name="bookName"></th>
				<th>${requestScope.bankBook.bookRate}</th>
			</tr>
			</tbody>
			</table>
</form>
</body>
</html>