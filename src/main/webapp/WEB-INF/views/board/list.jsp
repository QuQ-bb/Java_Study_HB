<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<title>Bank</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-6">
			<h3>${board} LIST PAGE</h3>
			<div class="row mb-3">
				<form action="./list.ms" class="row row-cols-lg-auto g-3 align-items-center">
				  <div class="col-12">
				    <label class="visually-hidden" for="kind">Preference</label>
				    <select class="form-select" name="kind" id="kind">
				      <option selected>Choose...</option>
				      <option value="contents">CONTENTS</option>
				      <option value="title">TITLE</option>
				      <option value="writer">WRITER</option>
				    </select>
				  </div>
				  
				   <div class="col-12">
				    <label class="visually-hidden" for="search">검색어</label>
				    <div class="input-group">
				      <input type="text" name="search" class="form-control" id="search" placeholder="SEARCH">
				    </div>
				  </div>
				
				  <div class="col-12">
				    <button type="submit" class="btn btn-primary">Submit</button>
				  </div>
				</form>
			</div>
			
			<table class="table table-sm" border="1">
				<tr>
					<th>NUM</th>
					<th>TITLE</th>
					<th>WRITER</th>
					<th>REGDATE</th>
					<th>HIT</th>
				</tr>
				<c:forEach items="${list}" var="list">
					<tr>
						<td>${list.num}</td>
						<td>
						<!-- for(int i=0; i<=end;  i++) -->
						<c:catch>
						<c:forEach begin="1" end="${list.depth}">--</c:forEach>
						</c:catch>
						<a href="detail.ms?num=${list.num}">
						${list.title}
						</a>
						</td>
						<td>${list.writer}</td>
						<td>${list.regdate}</td>
						<td>${list.hit}</td>
					</tr>
				</c:forEach>
			</table>
			
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			  <c:if test="${pager.pre}">
			    <li class="page-item">
			      <a class="page-link" href="./list.ms?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    </c:if>
			    
			    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i" >
			    <li class="page-item"><a class="page-link" href="./list.ms?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
			    </c:forEach>
			    
			    <%-- <c:choose>
			    	<c:when test="${pager.next}">
			    		 <li class="page-item">
			    	</c:when>
			    	<c:otherwise>
			    		<li class="page-item disabled">
			    	</c:otherwise>
			    </c:choose> --%>
			    <li class="page-item ${pager.next?'':'disabled'}">
			      <a class="page-link" href="./list.ms?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
		<a href="/">Back</a>
		<a href="./add.ms">ADD</a>
	</section>

	
<c:import url="../template/footer.jsp"></c:import>		
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>		
</body>
</html>