<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<table  class="table table-striped table-hover">
	<c:forEach items="${commentList}" var="list">
		<tr>
		<td>${list.contents}</td>
		<td>${list.writer}</td>
		<td>${list.regdate}</td>
		</tr>
	</c:forEach>

</table>