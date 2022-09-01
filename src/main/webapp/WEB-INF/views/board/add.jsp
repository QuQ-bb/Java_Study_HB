<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- jQuery -->
	<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
	<!-- bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

	<!-- include summernote css/js-->
   <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

</head>

<body>
<c:import url="../template/header.jsp"></c:import>
	<section class="container col-lg-3">
		<div class="row">
			<h3>${board} ADD PAGE</h3>
			<form action="add.ms" method="post" enctype="Multipart/form-data">
				<input type="hidden" name="writer" value="${member.userName}">
					<div>
						<input type="text" name="title" placeholder="제목을 입력해주세요.">
					</div>
				
					<div>
					<textarea rows="10" cols="25" id ="contents" name="contents"></textarea>
					</div>
				      <!-- <tr>
						<div>   
							<th>FILE</th>
								<td>
									<input type="file" name="files">
								</td>      
						</div>
					  </tr>
						<tr>
							<div>   
							<th>FILE</th>
							<td>
								<input type="file" name="files">
							</td>      
							</div>
						</tr>

						<tr>
							<div>   
							<th>FILE</th>
							<td>
								<input type="file" name="files">
							</td>      
						</div>
         			   </tr>  -->
						
					   <div id="addFiles">
						   <button type="button" id="fileAdd" class="btn btn-danger">파일추가</button>
					  </div>
						
					</table>

				<input type="submit" value="ADD">
				<a href="/">Back</a>
			</form>
		
		</div>
	</section>
	
	
<c:import url="../template/footer.jsp"></c:import>	
	<!-- bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>		
<script type="text/javascript">
	$("#contents").summernote();
</script>
<script src="/resources/js/add.js"></script>

</body>
</html>