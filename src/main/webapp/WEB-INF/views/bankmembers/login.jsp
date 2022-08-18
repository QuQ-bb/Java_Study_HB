<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>LOGIN PAGE</h3>
	<form action="login.ms" method="post">
		<table border="1">
			<tr>
				<th>USERNAME</th>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<th>PASSWORD</th>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
		<input type="submit" value="LOGIN">
		<a href="/">BACK</a>
	</form>
	

</body>
</html>