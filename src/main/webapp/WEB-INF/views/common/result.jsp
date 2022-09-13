<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	//let result = ${result};
	let message = '${message}';	//문자열은 ''를 붙여줘야 함
	//alert(result);
	alert(message);
	location.href="${url}";
	//javascript를 사용하지않고 jsp를 사용하는 이유는 js는 el을 사용할수 없기때문이다.
</script>
</head>
<body>


</body>
</html>