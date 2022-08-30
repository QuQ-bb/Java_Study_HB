<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bank</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>	
	<c:import url="../template/header.jsp"></c:import>
	<section class=" container-fluid mt-5 col-lg-6 text-center">
	<div class="row">
	  <form action="login.ms" method="post" id="form">
	  <div class="form-group ms-3  mb-3 row">
	  <h3>LOGIN PAGE</h3>
	    <label for="staticEmail" class="col-sm-3 col-form-label">USERNAME</label>
		 <div class="col-lg-6">
		      <input type="text" class="form-control" id="userName" name="userName">
			  <div id="id_check"></div>
		</div>
	  </div>
	  
	  
		<div class="form-group ms-3 row">
			  <label for="inputPassword" class="col-sm-3 col-form-label">PASSWORD</label>
			<div class="col-lg-6">
			      <input type="password" class="form-control" id="password" name="password">
				  <div id="pw_check"></div>
		    </div>
		    
		    <div class="mt-3 col-lg-12 text-center">
				<button type="button" class="btn-btn-primary" id="btn">Submit</button>
	 	 	<!-- <input type="submit" value="LOGIN"> <br> -->
	 	 	</div>
 	 </div>
 	 	<a href="/">BACK</a>
		</form>
	</div>
 	 	
		
		
	</section>

	<c:import url="../template/footer.jsp"></c:import>
	<script src="/resources/js/member.js"></script>
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>