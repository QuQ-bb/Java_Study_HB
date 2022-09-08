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
			<div >
				<table class="table table-hover" id="commentList">

				</table>
			</div>
			<button class="btn btn-danger disabled" id="more">더보기</button>
		</div>

		<!----------------------------Modal----------------------------->
		<div>
				<!--Modal Button-->
			<button type="button" style="display: none;" class="btn btn-primary" id="up" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@getbootstrap">댓글수정이란말이야</button>
					<!--Modal-->
				<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">UPDATE</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form>
							<input type="hidden" id="num">
						<div class="mb-3">
							<label for="recipient-name" class="col-form-label">Writer:</label>
							<input type="text" class="form-control" id="updateWriter">
						</div>
						<div class="mb-3">
							<label for="message-text" class="col-form-label">Contents:</label>
							<textarea class="form-control" id="updateContents"></textarea>
						</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary" id="send" data-bs-dismiss="modal">Send message</button>
					</div>
					</div>
				</div>
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