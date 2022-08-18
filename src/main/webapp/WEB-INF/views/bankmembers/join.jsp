<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JOIN PAGE</h3>

	<form action="join.ms" method="post">
		<table border="1">
			<tr>
				<th>USERNAME</th>
				<td><input type="text" name="userName" placeholder="username을 적어주세요"></td>
			</tr>
			<tr>
				 <th>PASSWORD</th>
				<td><input type="password" name="password" placeholder="password를 입력해주세요"></td>
			</tr>
			<tr>
				  <th>NAME</th>
				<td><input type="text" name="name" placeholder="name을 입력해주세요"></td>
			</tr>
			<tr>
				  <th>EMAIL</th>
				<td><input type="email" name="email" placeholder="email을 입력해주세요."></td>
			</tr>
			<tr>
				  <th>PHONE</th>
				<td><input type="text" name="phone" placeholder="phone번호를 입력해주세요"></td>
			</tr>
		</table>
			<a href="/">Back</a>
			<br><input type="submit" value="JOIN">
	</form>
	
	
</body>
</html>