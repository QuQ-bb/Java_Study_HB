<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>
	<h1>상품 등록</h1>
	<hr>
	<form action="./add.ms" method="post">
		상품명<br>
		<input type="text" name="bookName"><br>
		이자율<br>
		<input type="text" name="bookRate"><br>
		<br>
		<input type="submit">
	</form>

</body>
</html>