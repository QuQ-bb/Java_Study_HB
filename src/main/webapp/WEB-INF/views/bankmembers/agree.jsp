<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<section class="container-fluid col-lg-3">
		<div class="row">
		<h3>AGREE PAGE</h3>

			<div class="form-check">
					<input  type="checkbox" id="all">
					<label class="form-check-label" for="all">
					  전체동의
					</label>
				  </div>
				  <div class="form-check">
					<input class="req agrees" type="checkbox"  name="agree">
					<label class="form-check-label" for="flexCheckChecked">
					  동의(필수)
					</label>
				  </div>
				  <div class="form-check">
					<input class="req agrees" type="checkbox" name="agree">
					<label class="form-check-label" for="flexCheckChecked">
					  동의(필수)
					</label>
				  </div>
				  <div class="form-check">
					<input class="agrees" type="checkbox"  name="agree">
					<label class="form-check-label" for="flexCheckChecked">
					  동의(선택)
					</label>
				  </div>
				  <!-- <button type="button" onClick="location.href='/bankmembers/join.ms'">JOIN</button> -->
				  <form action="join.ms" id="frm" method="get">
					<button type="button" id="btn">JOIN</button>
				  </form>
				<script src="/resources/js/agree.js"></script>  
		</div>
	</section>

	

<c:import url="../template/footer.jsp"></c:import>	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>