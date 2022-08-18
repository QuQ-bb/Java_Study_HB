<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<c:if test="${member.userName eq null }">
<a href="/bankmembers/join.ms">회원가입</a><br>
<a href="/bankmembers/login.ms">로그인</a><br>
</c:if>

<c:if test="${member.userName ne null }">
<a href="/bankbook/list.ms">상품리스트 확인</a><br>
<a href="/bankmembers/logout.ms">로그아웃</a><br>
<a href="/bankmembers/searchID.ms">아이디 찾기</a><br>
</c:if>

</body>
</html>
