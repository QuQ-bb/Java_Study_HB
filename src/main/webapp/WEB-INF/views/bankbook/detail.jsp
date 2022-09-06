<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BankBook Detail</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bank</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<section class="container text-center">
		<div class="row">
			<h1>BankBook Detail</h1>
		<hr>
			<a href="./update.ms?bookNum=${bankBook.bookNum }#">상품수정</a>
			<a href="../account/add.ms?bookNum=${bankBook.bookNum }">상품가입</a>
		<table border="1">
			<thead>
				<tr>
					<th>Num</th><th>Name</th><th>Rate</th><th>Sale</th>
				</tr>
			</thead>
			<tbody>
				<tr>
				<td>${requestScope.bankBook.bookNum}</td>
				<td>${requestScope.bankBook.bookName}</td>
				<td>${requestScope.bankBook.bookRate}</td>
				<td>
				<c:if test="${bankBook.bookSale eq 1}">판매 중</c:if>
				<c:if test="${bankBook.bookSale ne 1}">판매 금지</c:if>
				</td>
			</tr>
		</tbody>
	</table>

		<!-- Comment -->
		<div class="row">
			<div class="mb-3">
				<label for="writer" class="form-label">Email address</label>
				<input type="text" class="form-control" id="writer" placeholder="Writer..">
			</div>
			<div class="mb-3">
				<label for="contents" class="form-label">WRITE CONTENTS</label>
				<textarea class="form-control" id="contents" rows="3"></textarea>
			</div>
			<div class="mb-3">
				<button type="button" id="btn" data-book-num="${bankBook.bookNum}">댓글 작성</button>
			</div>

			<!--Comment List-->
			<div id="commentList">
				

			</div>

		</div>
		<!-- Comment -->
	<a href="./delete.ms?bookNum=${bankBook.bookNum }#">상품삭제</a>
		</div>
	</section>

	
	
<c:import url="../template/footer.jsp"></c:import>	
	<script src="/resources/js/bankbookComment.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>